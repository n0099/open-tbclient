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
    private static String fhW;
    private bj eNR;
    private com.baidu.tieba.ala.d fgC;
    private a fhU;
    private String fhV;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener eXT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.eNR != null && d.this.eNR.aKC() != null && !StringUtils.isNull(d.this.eNR.aKC().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.eNR.aKC().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bjW().bjX();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.eNR.aKC().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.fhU = new a(this.mRootView);
        getView().setOnClickListener(this);
        fhW = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.fgC = dVar;
    }

    public void a(bj bjVar) {
        if (bjVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eNR = bjVar;
        this.fhU.eXV.setDrawerType(0);
        this.fhU.eXV.setBorderSurroundContent(true);
        this.fhU.eXV.setDrawBorder(true);
        this.fhU.eXV.startLoad(this.eNR.aKV().cover, 10, false);
        this.fhU.eXX.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.eNR.aKV().audience_count)));
        this.fhU.eXZ.setData(this.eNR);
        this.fhU.eXZ.setIsRound(true);
        this.fhU.eXZ.setBorderSurroundContent(true);
        this.fhU.eYa.setText(this.eNR.getTitle());
        if (this.eNR.aKC() != null) {
            String name_show = this.eNR.aKC().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fhU.aAy.setText(name_show);
        }
        this.fhU.fib.setVisibility(0);
        this.fhU.eXW.setBackgroundResource(R.drawable.transparent_bg);
        this.fhU.eXW.setText(this.eNR.aKV().label_name);
        this.fhU.eXW.setVisibility(0);
        if (this.eNR.aKC() == null || this.eNR.aKC().getAlaUserData() == null || aq.isEmpty(this.eNR.aKC().getAlaUserData().great_anchor_icon)) {
            this.fhU.fhY.setVisibility(8);
        } else {
            this.fhU.fhY.setVisibility(0);
            this.fhU.fhY.startLoad(this.eNR.aKC().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.fhU.aAy.setOnClickListener(this.eXT);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.eNR != null && this.eNR.aKV() != null) {
            if (this.fgC != null) {
                this.fgC.P(this.eNR);
            }
            com.baidu.tieba.ala.c.bjW().bjX();
            TiebaStatic.log(new an("c12116").t("obj_id", this.eNR.aKV().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fhU.eXY, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.fhU.eXW, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.fhU.eXX, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fhU.aAy, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fhU.eYa, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fhU.fic, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.fhV = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView aAy;
        public TbImageView eXV;
        public TextView eXW;
        public TextView eXX;
        public RelativeLayout eXY;
        public ClickableHeaderImageView eXZ;
        public TextView eYa;
        public TbImageView fhY;
        public RelativeLayout fhZ;
        public LinearLayout fia;
        public View fib;
        public TextView fic;
        private LinearLayout.LayoutParams fie;
        private LinearLayout.LayoutParams fif;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.eXV = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eXW = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eXX = (TextView) view.findViewById(R.id.tvLiveCount);
            this.eXY = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eXZ = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aAy = (TextView) view.findViewById(R.id.tvUserName);
            this.fhZ = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.eYa = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fia = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.fhY = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.fib = view.findViewById(R.id.living_logo);
            this.fic = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.fic.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.fie = (LinearLayout.LayoutParams) this.eYa.getLayoutParams();
            this.fif = (LinearLayout.LayoutParams) this.fia.getLayoutParams();
            this.fhY.setDefaultErrorResource(0);
            this.fhY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.eXV.setDefaultErrorResource(0);
            this.eXV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXY.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.fif.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fif.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fie.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fie.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.eYa.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fhZ.setVisibility(0);
            this.fia.setLayoutParams(this.fif);
            this.eYa.setLayoutParams(this.fie);
            this.eXY.setLayoutParams(layoutParams);
        }
    }
}
