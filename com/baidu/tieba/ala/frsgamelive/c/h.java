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
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h implements View.OnClickListener {
    private static String gbL;
    private bw fFN;
    private com.baidu.tieba.ala.f gar;
    private String gbK;
    private a gcc;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener fPS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.fFN != null && h.this.fFN.bfy() != null && !StringUtils.isNull(h.this.fFN.bfy().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(h.this.fFN.bfy().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bFl().bFm();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.fFN.bfy().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gcc = new a(this.mRootView);
        getView().setOnClickListener(this);
        gbL = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.f fVar) {
        this.gar = fVar;
    }

    public void a(bw bwVar) {
        if (bwVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fFN = bwVar;
        this.gcc.fPU.setDrawerType(0);
        this.gcc.fPU.setBorderSurroundContent(true);
        this.gcc.fPU.setDrawBorder(true);
        this.gcc.fPU.startLoad(this.fFN.bfS().cover, 10, false);
        this.gcc.fPW.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.fFN.bfS().audience_count)));
        this.gcc.fPY.setData(this.fFN);
        this.gcc.fPY.setIsRound(true);
        this.gcc.fPY.setBorderSurroundContent(true);
        this.gcc.fPZ.setText(this.fFN.getTitle());
        if (this.fFN.bfy() != null) {
            String name_show = this.fFN.bfy().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gcc.aQY.setText(name_show);
        }
        this.gcc.gbQ.setVisibility(0);
        this.gcc.fPV.setBackgroundResource(R.drawable.transparent_bg);
        this.gcc.fPV.setText(this.fFN.bfS().label_name);
        this.gcc.fPV.setVisibility(0);
        if (this.fFN.bfy() == null || this.fFN.bfy().getAlaUserData() == null || at.isEmpty(this.fFN.bfy().getAlaUserData().great_anchor_icon)) {
            this.gcc.gbN.setVisibility(8);
        } else {
            this.gcc.gbN.setVisibility(0);
            this.gcc.gbN.startLoad(this.fFN.bfy().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gcc.aQY.setOnClickListener(this.fPS);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.fFN != null && this.fFN.bfS() != null) {
            if (this.gar != null) {
                this.gar.P(this.fFN);
            }
            com.baidu.tieba.ala.c.bFl().bFm();
            TiebaStatic.log(new aq("c12116").u("obj_id", this.fFN.bfS().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gcc.fPX, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gcc.fPV, R.color.cp_cont_g);
            ap.setViewTextColor(this.gcc.fPW, R.color.cp_cont_a);
            ap.setViewTextColor(this.gcc.aQY, R.color.cp_cont_d);
            ap.setViewTextColor(this.gcc.fPZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.gcc.gbR, R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gbK = str;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TextView aQY;
        public TbImageView fPU;
        public TextView fPV;
        public TextView fPW;
        public RelativeLayout fPX;
        public ClickableHeaderImageView fPY;
        public TextView fPZ;
        public TbImageView gbN;
        public RelativeLayout gbO;
        public LinearLayout gbP;
        public View gbQ;
        public TextView gbR;
        private LinearLayout.LayoutParams gbS;
        private LinearLayout.LayoutParams gbT;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fPU = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fPV = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fPW = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fPX = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fPY = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aQY = (TextView) view.findViewById(R.id.tvUserName);
            this.gbO = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.fPZ = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gbP = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gbN = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gbQ = view.findViewById(R.id.living_logo);
            this.gbR = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gbR.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gbS = (LinearLayout.LayoutParams) this.fPZ.getLayoutParams();
            this.gbT = (LinearLayout.LayoutParams) this.gbP.getLayoutParams();
            this.gbN.setDefaultErrorResource(0);
            this.gbN.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fPU.setDefaultErrorResource(0);
            this.fPU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fPX.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gbT.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gbT.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gbS.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gbS.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.fPZ.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.gbO.setVisibility(8);
            this.gbP.setLayoutParams(this.gbT);
            this.fPZ.setLayoutParams(this.gbS);
            this.fPX.setLayoutParams(layoutParams);
        }
    }
}
