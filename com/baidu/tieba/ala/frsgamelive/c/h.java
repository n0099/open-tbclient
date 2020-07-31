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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h implements View.OnClickListener {
    private static String fMv;
    private com.baidu.tieba.ala.e fLb;
    private a fMM;
    private String fMu;
    private bv frb;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener fBi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.frb != null && h.this.frb.aWl() != null && !StringUtils.isNull(h.this.frb.aWl().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(h.this.frb.aWl().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.buZ().bva();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.frb.aWl().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.fMM = new a(this.mRootView);
        getView().setOnClickListener(this);
        fMv = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.e eVar) {
        this.fLb = eVar;
    }

    public void a(bv bvVar) {
        if (bvVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.frb = bvVar;
        this.fMM.fBk.setDrawerType(0);
        this.fMM.fBk.setBorderSurroundContent(true);
        this.fMM.fBk.setDrawBorder(true);
        this.fMM.fBk.startLoad(this.frb.aWF().cover, 10, false);
        this.fMM.fBm.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, as.numberUniformFormatExtra(this.frb.aWF().audience_count)));
        this.fMM.fBo.setData(this.frb);
        this.fMM.fBo.setIsRound(true);
        this.fMM.fBo.setBorderSurroundContent(true);
        this.fMM.fBp.setText(this.frb.getTitle());
        if (this.frb.aWl() != null) {
            String name_show = this.frb.aWl().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fMM.aJJ.setText(name_show);
        }
        this.fMM.fMA.setVisibility(0);
        this.fMM.fBl.setBackgroundResource(R.drawable.transparent_bg);
        this.fMM.fBl.setText(this.frb.aWF().label_name);
        this.fMM.fBl.setVisibility(0);
        if (this.frb.aWl() == null || this.frb.aWl().getAlaUserData() == null || as.isEmpty(this.frb.aWl().getAlaUserData().great_anchor_icon)) {
            this.fMM.fMx.setVisibility(8);
        } else {
            this.fMM.fMx.setVisibility(0);
            this.fMM.fMx.startLoad(this.frb.aWl().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.fMM.aJJ.setOnClickListener(this.fBi);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.frb != null && this.frb.aWF() != null) {
            if (this.fLb != null) {
                this.fLb.O(this.frb);
            }
            com.baidu.tieba.ala.c.buZ().bva();
            TiebaStatic.log(new ap("c12116").t("obj_id", this.frb.aWF().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.fMM.fBn, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.fMM.fBl, R.color.cp_cont_g);
            ao.setViewTextColor(this.fMM.fBm, R.color.cp_cont_a);
            ao.setViewTextColor(this.fMM.aJJ, R.color.cp_cont_d);
            ao.setViewTextColor(this.fMM.fBp, R.color.cp_cont_b);
            ao.setViewTextColor(this.fMM.fMB, R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.fMu = str;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TextView aJJ;
        public TbImageView fBk;
        public TextView fBl;
        public TextView fBm;
        public RelativeLayout fBn;
        public ClickableHeaderImageView fBo;
        public TextView fBp;
        public View fMA;
        public TextView fMB;
        private LinearLayout.LayoutParams fMC;
        private LinearLayout.LayoutParams fMD;
        public TbImageView fMx;
        public RelativeLayout fMy;
        public LinearLayout fMz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fBk = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fBl = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fBm = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fBn = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fBo = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aJJ = (TextView) view.findViewById(R.id.tvUserName);
            this.fMy = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.fBp = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fMz = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.fMx = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.fMA = view.findViewById(R.id.living_logo);
            this.fMB = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.fMB.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.fMC = (LinearLayout.LayoutParams) this.fBp.getLayoutParams();
            this.fMD = (LinearLayout.LayoutParams) this.fMz.getLayoutParams();
            this.fMx.setDefaultErrorResource(0);
            this.fMx.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fBk.setDefaultErrorResource(0);
            this.fBk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBn.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.fMD.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.fMD.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.fMC.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fMC.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.fBp.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.fMy.setVisibility(8);
            this.fMz.setLayoutParams(this.fMD);
            this.fBp.setLayoutParams(this.fMC);
            this.fBn.setLayoutParams(layoutParams);
        }
    }
}
