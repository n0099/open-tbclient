package com.baidu.tieba.ala.frsgamelive.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private static String fhR;
    private bj eNM;
    private com.baidu.tieba.ala.d fgx;
    private a fhP;
    private String fhQ;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener eXO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.eNM != null && d.this.eNM.aKE() != null && !StringUtils.isNull(d.this.eNM.aKE().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.eNM.aKE().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bjY().bjZ();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.eNM.aKE().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.fhP = new a(this.mRootView);
        getView().setOnClickListener(this);
        fhR = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.fgx = dVar;
    }

    public void a(bj bjVar) {
        if (bjVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eNM = bjVar;
        this.fhP.eXQ.setDrawerType(0);
        this.fhP.eXQ.setBorderSurroundContent(true);
        this.fhP.eXQ.setDrawBorder(true);
        this.fhP.eXQ.startLoad(this.eNM.aKX().cover, 10, false);
        this.fhP.eXS.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.eNM.aKX().audience_count)));
        this.fhP.eXU.setData(this.eNM);
        this.fhP.eXU.setIsRound(true);
        this.fhP.eXU.setBorderSurroundContent(true);
        this.fhP.eXV.setText(this.eNM.getTitle());
        if (this.eNM.aKE() != null) {
            String name_show = this.eNM.aKE().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fhP.aAs.setText(name_show);
        }
        this.fhP.fhW.setVisibility(0);
        this.fhP.eXR.setBackgroundResource(R.drawable.transparent_bg);
        this.fhP.eXR.setText(this.eNM.aKX().label_name);
        this.fhP.eXR.setVisibility(0);
        if (this.eNM.aKE() == null || this.eNM.aKE().getAlaUserData() == null || aq.isEmpty(this.eNM.aKE().getAlaUserData().great_anchor_icon)) {
            this.fhP.fhT.setVisibility(8);
        } else {
            this.fhP.fhT.setVisibility(0);
            this.fhP.fhT.startLoad(this.eNM.aKE().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.fhP.aAs.setOnClickListener(this.eXO);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.eNM != null && this.eNM.aKX() != null) {
            if (this.fgx != null) {
                this.fgx.P(this.eNM);
            }
            com.baidu.tieba.ala.c.bjY().bjZ();
            TiebaStatic.log(new an("c12116").t("obj_id", this.eNM.aKX().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fhP.eXT, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.fhP.eXR, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.fhP.eXS, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fhP.aAs, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fhP.eXV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fhP.fhX, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.fhQ = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView aAs;
        public TbImageView eXQ;
        public TextView eXR;
        public TextView eXS;
        public RelativeLayout eXT;
        public ClickableHeaderImageView eXU;
        public TextView eXV;
        public TbImageView fhT;
        public RelativeLayout fhU;
        public LinearLayout fhV;
        public View fhW;
        public TextView fhX;
        private LinearLayout.LayoutParams fhY;
        private LinearLayout.LayoutParams fhZ;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.eXQ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eXR = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eXS = (TextView) view.findViewById(R.id.tvLiveCount);
            this.eXT = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eXU = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aAs = (TextView) view.findViewById(R.id.tvUserName);
            this.fhU = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.eXV = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fhV = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.fhT = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.fhW = view.findViewById(R.id.living_logo);
            this.fhX = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.fhX.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.fhY = (LinearLayout.LayoutParams) this.eXV.getLayoutParams();
            this.fhZ = (LinearLayout.LayoutParams) this.fhV.getLayoutParams();
            this.fhT.setDefaultErrorResource(0);
            this.fhT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.eXQ.setDefaultErrorResource(0);
            this.eXQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXT.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.fhZ.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fhZ.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fhY.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fhY.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.eXV.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fhU.setVisibility(0);
            this.fhV.setLayoutParams(this.fhZ);
            this.eXV.setLayoutParams(this.fhY);
            this.eXT.setLayoutParams(layoutParams);
        }
    }
}
