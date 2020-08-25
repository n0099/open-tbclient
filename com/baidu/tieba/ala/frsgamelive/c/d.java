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
    private static String fYt;
    private bw fCx;
    private com.baidu.tieba.ala.e fWZ;
    private a fYr;
    private String fYs;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener fMA = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.fCx != null && d.this.fCx.beE() != null && !StringUtils.isNull(d.this.fCx.beE().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.fCx.beE().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bDU().bDV();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.fCx.beE().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.fYr = new a(this.mRootView);
        getView().setOnClickListener(this);
        fYt = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.e eVar) {
        this.fWZ = eVar;
    }

    public void a(bw bwVar) {
        if (bwVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fCx = bwVar;
        this.fYr.fMC.setDrawerType(0);
        this.fYr.fMC.setBorderSurroundContent(true);
        this.fYr.fMC.setDrawBorder(true);
        this.fYr.fMC.startLoad(this.fCx.beY().cover, 10, false);
        this.fYr.fME.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.fCx.beY().audience_count)));
        this.fYr.fMG.setData(this.fCx);
        this.fYr.fMG.setIsRound(true);
        this.fYr.fMG.setBorderSurroundContent(true);
        this.fYr.fMH.setText(this.fCx.getTitle());
        if (this.fCx.beE() != null) {
            String name_show = this.fCx.beE().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fYr.aOU.setText(name_show);
        }
        this.fYr.fYy.setVisibility(0);
        this.fYr.fMD.setBackgroundResource(R.drawable.transparent_bg);
        this.fYr.fMD.setText(this.fCx.beY().label_name);
        this.fYr.fMD.setVisibility(0);
        if (this.fCx.beE() == null || this.fCx.beE().getAlaUserData() == null || at.isEmpty(this.fCx.beE().getAlaUserData().great_anchor_icon)) {
            this.fYr.fYv.setVisibility(8);
        } else {
            this.fYr.fYv.setVisibility(0);
            this.fYr.fYv.startLoad(this.fCx.beE().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.fYr.aOU.setOnClickListener(this.fMA);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.fCx != null && this.fCx.beY() != null) {
            if (this.fWZ != null) {
                this.fWZ.O(this.fCx);
            }
            com.baidu.tieba.ala.c.bDU().bDV();
            TiebaStatic.log(new aq("c12116").u("obj_id", this.fCx.beY().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fYr.fMF, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fYr.fMD, (int) R.color.cp_cont_g);
            ap.setViewTextColor(this.fYr.fME, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fYr.aOU, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.fYr.fMH, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fYr.fYz, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.fYs = str;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TextView aOU;
        public TbImageView fMC;
        public TextView fMD;
        public TextView fME;
        public RelativeLayout fMF;
        public ClickableHeaderImageView fMG;
        public TextView fMH;
        private LinearLayout.LayoutParams fYA;
        private LinearLayout.LayoutParams fYB;
        public TbImageView fYv;
        public RelativeLayout fYw;
        public LinearLayout fYx;
        public View fYy;
        public TextView fYz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fMC = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fMD = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fME = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fMF = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fMG = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aOU = (TextView) view.findViewById(R.id.tvUserName);
            this.fYw = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.fMH = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fYx = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.fYv = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.fYy = view.findViewById(R.id.living_logo);
            this.fYz = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.fYz.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.fYA = (LinearLayout.LayoutParams) this.fMH.getLayoutParams();
            this.fYB = (LinearLayout.LayoutParams) this.fYx.getLayoutParams();
            this.fYv.setDefaultErrorResource(0);
            this.fYv.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fMC.setDefaultErrorResource(0);
            this.fMC.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fMF.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.fYB.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fYB.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fYA.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fYA.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.fMH.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fYw.setVisibility(0);
            this.fYx.setLayoutParams(this.fYB);
            this.fMH.setLayoutParams(this.fYA);
            this.fMF.setLayoutParams(layoutParams);
        }
    }
}
