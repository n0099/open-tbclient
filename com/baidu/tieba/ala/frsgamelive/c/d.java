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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private static String fvF;
    private bk fay;
    private com.baidu.tieba.ala.d ful;
    private a fvD;
    private String fvE;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener fkD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.fay != null && d.this.fay.aQx() != null && !StringUtils.isNull(d.this.fay.aQx().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.fay.aQx().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bpq().bpr();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.fay.aQx().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.fvD = new a(this.mRootView);
        getView().setOnClickListener(this);
        fvF = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.ful = dVar;
    }

    public void a(bk bkVar) {
        if (bkVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fay = bkVar;
        this.fvD.fkF.setDrawerType(0);
        this.fvD.fkF.setBorderSurroundContent(true);
        this.fvD.fkF.setDrawBorder(true);
        this.fvD.fkF.startLoad(this.fay.aQS().cover, 10, false);
        this.fvD.fkH.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.fay.aQS().audience_count)));
        this.fvD.fkJ.setData(this.fay);
        this.fvD.fkJ.setIsRound(true);
        this.fvD.fkJ.setBorderSurroundContent(true);
        this.fvD.fkK.setText(this.fay.getTitle());
        if (this.fay.aQx() != null) {
            String name_show = this.fay.aQx().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fvD.aFR.setText(name_show);
        }
        this.fvD.fvK.setVisibility(0);
        this.fvD.fkG.setBackgroundResource(R.drawable.transparent_bg);
        this.fvD.fkG.setText(this.fay.aQS().label_name);
        this.fvD.fkG.setVisibility(0);
        if (this.fay.aQx() == null || this.fay.aQx().getAlaUserData() == null || aq.isEmpty(this.fay.aQx().getAlaUserData().great_anchor_icon)) {
            this.fvD.fvH.setVisibility(8);
        } else {
            this.fvD.fvH.setVisibility(0);
            this.fvD.fvH.startLoad(this.fay.aQx().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.fvD.aFR.setOnClickListener(this.fkD);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.fay != null && this.fay.aQS() != null) {
            if (this.ful != null) {
                this.ful.Q(this.fay);
            }
            com.baidu.tieba.ala.c.bpq().bpr();
            TiebaStatic.log(new an("c12116").s("obj_id", this.fay.aQS().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fvD.fkI, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.fvD.fkG, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.fvD.fkH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fvD.aFR, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fvD.fkK, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fvD.fvL, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.fvE = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView aFR;
        public TbImageView fkF;
        public TextView fkG;
        public TextView fkH;
        public RelativeLayout fkI;
        public ClickableHeaderImageView fkJ;
        public TextView fkK;
        public TbImageView fvH;
        public RelativeLayout fvI;
        public LinearLayout fvJ;
        public View fvK;
        public TextView fvL;
        private LinearLayout.LayoutParams fvM;
        private LinearLayout.LayoutParams fvN;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fkF = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fkG = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fkH = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fkI = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fkJ = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aFR = (TextView) view.findViewById(R.id.tvUserName);
            this.fvI = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.fkK = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fvJ = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.fvH = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.fvK = view.findViewById(R.id.living_logo);
            this.fvL = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.fvL.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.fvM = (LinearLayout.LayoutParams) this.fkK.getLayoutParams();
            this.fvN = (LinearLayout.LayoutParams) this.fvJ.getLayoutParams();
            this.fvH.setDefaultErrorResource(0);
            this.fvH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fkF.setDefaultErrorResource(0);
            this.fkF.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkI.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.fvN.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fvN.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fvM.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fvM.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.fkK.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fvI.setVisibility(0);
            this.fvJ.setLayoutParams(this.fvN);
            this.fkK.setLayoutParams(this.fvM);
            this.fkI.setLayoutParams(layoutParams);
        }
    }
}
