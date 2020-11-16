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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h implements View.OnClickListener {
    private static String gDC;
    private com.baidu.tieba.ala.f gCi;
    private String gDB;
    private a gDT;
    private bx ghv;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener grI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.ghv != null && h.this.ghv.blC() != null && !StringUtils.isNull(h.this.ghv.blC().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(h.this.ghv.blC().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bLH().bLI();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.ghv.blC().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gDT = new a(this.mRootView);
        getView().setOnClickListener(this);
        gDC = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.f fVar) {
        this.gCi = fVar;
    }

    public void a(bx bxVar) {
        if (bxVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ghv = bxVar;
        this.gDT.grK.setDrawerType(0);
        this.gDT.grK.setBorderSurroundContent(true);
        this.gDT.grK.setDrawBorder(true);
        this.gDT.grK.startLoad(this.ghv.blW().cover, 10, false);
        this.gDT.grM.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, au.numberUniformFormatExtra(this.ghv.blW().audience_count)));
        this.gDT.grO.setData(this.ghv);
        this.gDT.grO.setIsRound(true);
        this.gDT.grO.setBorderSurroundContent(true);
        this.gDT.grP.setText(this.ghv.getTitle());
        if (this.ghv.blC() != null) {
            String name_show = this.ghv.blC().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gDT.aVl.setText(name_show);
        }
        this.gDT.gDH.setVisibility(0);
        this.gDT.grL.setBackgroundResource(R.drawable.transparent_bg);
        this.gDT.grL.setText(this.ghv.blW().label_name);
        this.gDT.grL.setVisibility(0);
        if (this.ghv.blC() == null || this.ghv.blC().getAlaUserData() == null || au.isEmpty(this.ghv.blC().getAlaUserData().great_anchor_icon)) {
            this.gDT.gDE.setVisibility(8);
        } else {
            this.gDT.gDE.setVisibility(0);
            this.gDT.gDE.startLoad(this.ghv.blC().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gDT.aVl.setOnClickListener(this.grI);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.ghv != null && this.ghv.blW() != null) {
            if (this.gCi != null) {
                this.gCi.R(this.ghv);
            }
            com.baidu.tieba.ala.c.bLH().bLI();
            TiebaStatic.log(new ar("c12116").w("obj_id", this.ghv.blW().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gDT.grN, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gDT.grL, R.color.CAM_X0111);
            ap.setViewTextColor(this.gDT.grM, R.color.CAM_X0101);
            ap.setViewTextColor(this.gDT.aVl, R.color.CAM_X0109);
            ap.setViewTextColor(this.gDT.grP, R.color.CAM_X0105);
            ap.setViewTextColor(this.gDT.gDI, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gDB = str;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TextView aVl;
        public TbImageView gDE;
        public RelativeLayout gDF;
        public LinearLayout gDG;
        public View gDH;
        public TextView gDI;
        private LinearLayout.LayoutParams gDJ;
        private LinearLayout.LayoutParams gDK;
        public TbImageView grK;
        public TextView grL;
        public TextView grM;
        public RelativeLayout grN;
        public ClickableHeaderImageView grO;
        public TextView grP;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.grK = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.grL = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.grM = (TextView) view.findViewById(R.id.tvLiveCount);
            this.grN = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.grO = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aVl = (TextView) view.findViewById(R.id.tvUserName);
            this.gDF = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.grP = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gDG = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gDE = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gDH = view.findViewById(R.id.living_logo);
            this.gDI = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gDI.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gDJ = (LinearLayout.LayoutParams) this.grP.getLayoutParams();
            this.gDK = (LinearLayout.LayoutParams) this.gDG.getLayoutParams();
            this.gDE.setDefaultErrorResource(0);
            this.gDE.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.grK.setDefaultErrorResource(0);
            this.grK.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grN.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gDK.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gDK.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gDJ.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gDJ.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.grP.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.gDF.setVisibility(8);
            this.gDG.setLayoutParams(this.gDK);
            this.grP.setLayoutParams(this.gDJ);
            this.grN.setLayoutParams(layoutParams);
        }
    }
}
