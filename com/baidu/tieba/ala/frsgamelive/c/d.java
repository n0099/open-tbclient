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
public class d implements View.OnClickListener {
    private static String gbL;
    private bw fFN;
    private com.baidu.tieba.ala.f gar;
    private a gbJ;
    private String gbK;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener fPS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.fFN != null && d.this.fFN.bfy() != null && !StringUtils.isNull(d.this.fFN.bfy().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.fFN.bfy().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bFl().bFm();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.fFN.bfy().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gbJ = new a(this.mRootView);
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
        this.gbJ.fPU.setDrawerType(0);
        this.gbJ.fPU.setBorderSurroundContent(true);
        this.gbJ.fPU.setDrawBorder(true);
        this.gbJ.fPU.startLoad(this.fFN.bfS().cover, 10, false);
        this.gbJ.fPW.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.fFN.bfS().audience_count)));
        this.gbJ.fPY.setData(this.fFN);
        this.gbJ.fPY.setIsRound(true);
        this.gbJ.fPY.setBorderSurroundContent(true);
        this.gbJ.fPZ.setText(this.fFN.getTitle());
        if (this.fFN.bfy() != null) {
            String name_show = this.fFN.bfy().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gbJ.aQY.setText(name_show);
        }
        this.gbJ.gbQ.setVisibility(0);
        this.gbJ.fPV.setBackgroundResource(R.drawable.transparent_bg);
        this.gbJ.fPV.setText(this.fFN.bfS().label_name);
        this.gbJ.fPV.setVisibility(0);
        if (this.fFN.bfy() == null || this.fFN.bfy().getAlaUserData() == null || at.isEmpty(this.fFN.bfy().getAlaUserData().great_anchor_icon)) {
            this.gbJ.gbN.setVisibility(8);
        } else {
            this.gbJ.gbN.setVisibility(0);
            this.gbJ.gbN.startLoad(this.fFN.bfy().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gbJ.aQY.setOnClickListener(this.fPS);
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
            ap.setBackgroundResource(this.gbJ.fPX, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gbJ.fPV, R.color.cp_cont_g);
            ap.setViewTextColor(this.gbJ.fPW, R.color.cp_cont_a);
            ap.setViewTextColor(this.gbJ.aQY, R.color.cp_cont_d);
            ap.setViewTextColor(this.gbJ.fPZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.gbJ.gbR, R.color.cp_cont_a);
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
            this.gbT.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gbT.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gbS.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gbS.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.fPZ.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gbO.setVisibility(0);
            this.gbP.setLayoutParams(this.gbT);
            this.fPZ.setLayoutParams(this.gbS);
            this.fPX.setLayoutParams(layoutParams);
        }
    }
}
