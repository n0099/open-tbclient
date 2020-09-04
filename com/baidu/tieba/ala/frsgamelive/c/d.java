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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private static String fYx;
    private bw fCB;
    private com.baidu.tieba.ala.e fXd;
    private a fYv;
    private String fYw;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener fME = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.fCB != null && d.this.fCB.beE() != null && !StringUtils.isNull(d.this.fCB.beE().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.fCB.beE().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bDV().bDW();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.fCB.beE().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.fYv = new a(this.mRootView);
        getView().setOnClickListener(this);
        fYx = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.e eVar) {
        this.fXd = eVar;
    }

    public void a(bw bwVar) {
        if (bwVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fCB = bwVar;
        this.fYv.fMG.setDrawerType(0);
        this.fYv.fMG.setBorderSurroundContent(true);
        this.fYv.fMG.setDrawBorder(true);
        this.fYv.fMG.startLoad(this.fCB.beY().cover, 10, false);
        this.fYv.fMI.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.fCB.beY().audience_count)));
        this.fYv.fMK.setData(this.fCB);
        this.fYv.fMK.setIsRound(true);
        this.fYv.fMK.setBorderSurroundContent(true);
        this.fYv.fML.setText(this.fCB.getTitle());
        if (this.fCB.beE() != null) {
            String name_show = this.fCB.beE().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fYv.aOW.setText(name_show);
        }
        this.fYv.fYC.setVisibility(0);
        this.fYv.fMH.setBackgroundResource(R.drawable.transparent_bg);
        this.fYv.fMH.setText(this.fCB.beY().label_name);
        this.fYv.fMH.setVisibility(0);
        if (this.fCB.beE() == null || this.fCB.beE().getAlaUserData() == null || at.isEmpty(this.fCB.beE().getAlaUserData().great_anchor_icon)) {
            this.fYv.fYz.setVisibility(8);
        } else {
            this.fYv.fYz.setVisibility(0);
            this.fYv.fYz.startLoad(this.fCB.beE().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.fYv.aOW.setOnClickListener(this.fME);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.fCB != null && this.fCB.beY() != null) {
            if (this.fXd != null) {
                this.fXd.O(this.fCB);
            }
            com.baidu.tieba.ala.c.bDV().bDW();
            TiebaStatic.log(new aq("c12116").u("obj_id", this.fCB.beY().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fYv.fMJ, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fYv.fMH, (int) R.color.cp_cont_g);
            ap.setViewTextColor(this.fYv.fMI, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fYv.aOW, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.fYv.fML, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fYv.fYD, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.fYw = str;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TextView aOW;
        public TbImageView fMG;
        public TextView fMH;
        public TextView fMI;
        public RelativeLayout fMJ;
        public ClickableHeaderImageView fMK;
        public TextView fML;
        public RelativeLayout fYA;
        public LinearLayout fYB;
        public View fYC;
        public TextView fYD;
        private LinearLayout.LayoutParams fYE;
        private LinearLayout.LayoutParams fYF;
        public TbImageView fYz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fMG = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fMH = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fMI = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fMJ = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fMK = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aOW = (TextView) view.findViewById(R.id.tvUserName);
            this.fYA = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.fML = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fYB = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.fYz = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.fYC = view.findViewById(R.id.living_logo);
            this.fYD = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.fYD.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.fYE = (LinearLayout.LayoutParams) this.fML.getLayoutParams();
            this.fYF = (LinearLayout.LayoutParams) this.fYB.getLayoutParams();
            this.fYz.setDefaultErrorResource(0);
            this.fYz.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fMG.setDefaultErrorResource(0);
            this.fMG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fMJ.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.fYF.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fYF.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fYE.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fYE.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.fML.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fYA.setVisibility(0);
            this.fYB.setLayoutParams(this.fYF);
            this.fML.setLayoutParams(this.fYE);
            this.fMJ.setLayoutParams(layoutParams);
        }
    }
}
