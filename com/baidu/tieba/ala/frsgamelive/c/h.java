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
public class h implements View.OnClickListener {
    private static String eDy;
    private com.baidu.tieba.ala.d eCe;
    private a eDP;
    private String eDx;
    private bj ekm;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener eut = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.ekm != null && h.this.ekm.aCr() != null && !StringUtils.isNull(h.this.ekm.aCr().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(h.this.ekm.aCr().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bbV().bbW();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.ekm.aCr().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.eDP = new a(this.mRootView);
        getView().setOnClickListener(this);
        eDy = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.eCe = dVar;
    }

    public void a(bj bjVar) {
        if (bjVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ekm = bjVar;
        this.eDP.euv.setDrawerType(0);
        this.eDP.euv.setBorderSurroundContent(true);
        this.eDP.euv.setDrawBorder(true);
        this.eDP.euv.startLoad(this.ekm.aCK().cover, 10, false);
        this.eDP.eux.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.ekm.aCK().audience_count)));
        this.eDP.euz.setData(this.ekm);
        this.eDP.euz.setIsRound(true);
        this.eDP.euz.setBorderSurroundContent(true);
        this.eDP.euA.setText(this.ekm.getTitle());
        if (this.ekm.aCr() != null) {
            String name_show = this.ekm.aCr().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eDP.ahY.setText(name_show);
        }
        this.eDP.eDD.setVisibility(0);
        this.eDP.euw.setBackgroundResource(R.drawable.transparent_bg);
        this.eDP.euw.setText(this.ekm.aCK().label_name);
        this.eDP.euw.setVisibility(0);
        if (this.ekm.aCr() == null || this.ekm.aCr().getAlaUserData() == null || aq.isEmpty(this.ekm.aCr().getAlaUserData().great_anchor_icon)) {
            this.eDP.eDA.setVisibility(8);
        } else {
            this.eDP.eDA.setVisibility(0);
            this.eDP.eDA.startLoad(this.ekm.aCr().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.eDP.ahY.setOnClickListener(this.eut);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.ekm != null && this.ekm.aCK() != null) {
            if (this.eCe != null) {
                this.eCe.P(this.ekm);
            }
            com.baidu.tieba.ala.c.bbV().bbW();
            TiebaStatic.log(new an("c12116").s("obj_id", this.ekm.aCK().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eDP.euy, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eDP.euw, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.eDP.eux, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eDP.ahY, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eDP.euA, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eDP.eDE, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.eDx = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView ahY;
        public TbImageView eDA;
        public RelativeLayout eDB;
        public LinearLayout eDC;
        public View eDD;
        public TextView eDE;
        private LinearLayout.LayoutParams eDF;
        private LinearLayout.LayoutParams eDG;
        public TextView euA;
        public TbImageView euv;
        public TextView euw;
        public TextView eux;
        public RelativeLayout euy;
        public ClickableHeaderImageView euz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.euv = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.euw = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eux = (TextView) view.findViewById(R.id.tvLiveCount);
            this.euy = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.euz = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahY = (TextView) view.findViewById(R.id.tvUserName);
            this.eDB = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.euA = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.eDC = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.eDA = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.eDD = view.findViewById(R.id.living_logo);
            this.eDE = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.eDE.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.eDF = (LinearLayout.LayoutParams) this.euA.getLayoutParams();
            this.eDG = (LinearLayout.LayoutParams) this.eDC.getLayoutParams();
            this.eDA.setDefaultErrorResource(0);
            this.eDA.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.euv.setDefaultErrorResource(0);
            this.euv.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.euy.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.eDG.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.eDG.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.eDF.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eDF.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.euA.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.eDB.setVisibility(8);
            this.eDC.setLayoutParams(this.eDG);
            this.euA.setLayoutParams(this.eDF);
            this.euy.setLayoutParams(layoutParams);
        }
    }
}
