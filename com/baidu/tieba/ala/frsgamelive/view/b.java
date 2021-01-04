package com.baidu.tieba.ala.frsgamelive.view;

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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.d;
import com.baidu.tieba.ala.g;
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private static String gYn;
    private bz gAx;
    private g gWT;
    private a gYC;
    private String gYm;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gKW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gAx != null && b.this.gAx.brq() != null && !StringUtils.isNull(b.this.gAx.brq().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(b.this.gAx.brq().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                d.bRR().bRS();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(b.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, b.this.gAx.brq().isBigV())));
            }
        }
    };

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gYC = new a(this.mRootView);
        getView().setOnClickListener(this);
        gYn = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(g gVar) {
        this.gWT = gVar;
    }

    public void a(bz bzVar) {
        if (bzVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAx = bzVar;
        this.gYC.gKY.setDrawerType(0);
        this.gYC.gKY.setBorderSurroundContent(true);
        this.gYC.gKY.setDrawBorder(true);
        this.gYC.gKY.startLoad(this.gAx.brJ().cover, 10, false);
        this.gYC.gLa.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.gAx.brJ().audience_count)));
        this.gYC.gLc.setData(this.gAx);
        this.gYC.gLc.setIsRound(true);
        this.gYC.gLc.setBorderSurroundContent(true);
        this.gYC.gLd.setText(this.gAx.getTitle());
        if (this.gAx.brq() != null) {
            String name_show = this.gAx.brq().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gYC.bac.setText(name_show);
        }
        this.gYC.gYq.setVisibility(0);
        this.gYC.gKZ.setBackgroundResource(R.drawable.transparent_bg);
        this.gYC.gKZ.setText(this.gAx.brJ().label_name);
        this.gYC.gKZ.setVisibility(0);
        if (this.gAx.brq() == null || this.gAx.brq().getAlaUserData() == null || at.isEmpty(this.gAx.brq().getAlaUserData().great_anchor_icon)) {
            this.gYC.gYp.setVisibility(8);
        } else {
            this.gYC.gYp.setVisibility(0);
            this.gYC.gYp.startLoad(this.gAx.brq().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gYC.bac.setOnClickListener(this.gKW);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gAx != null && this.gAx.brJ() != null) {
            if (this.gWT != null) {
                this.gWT.R(this.gAx);
            }
            d.bRR().bRS();
            TiebaStatic.log(new aq("c12116").w("obj_id", this.gAx.brJ().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gYC.gLb, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gYC.gKZ, R.color.CAM_X0111);
            ao.setViewTextColor(this.gYC.gLa, R.color.CAM_X0101);
            ao.setViewTextColor(this.gYC.bac, R.color.CAM_X0109);
            ao.setViewTextColor(this.gYC.gLd, R.color.CAM_X0105);
            ao.setViewTextColor(this.gYC.gYr, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gYm = str;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public TextView bac;
        public TbImageView gKY;
        public TextView gKZ;
        public LinearLayout gLM;
        public RelativeLayout gLU;
        public TextView gLa;
        public RelativeLayout gLb;
        public ClickableHeaderImageView gLc;
        public TextView gLd;
        public TbImageView gYp;
        public View gYq;
        public TextView gYr;
        private LinearLayout.LayoutParams gYs;
        private LinearLayout.LayoutParams gYt;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gKY = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gKZ = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gLa = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gLb = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gLc = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.bac = (TextView) view.findViewById(R.id.tvUserName);
            this.gLU = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.gLd = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gLM = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gYp = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gYq = view.findViewById(R.id.living_logo);
            this.gYr = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gYr.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gYs = (LinearLayout.LayoutParams) this.gLd.getLayoutParams();
            this.gYt = (LinearLayout.LayoutParams) this.gLM.getLayoutParams();
            this.gYp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gKY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLb.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gYt.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gYt.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gYs.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gYs.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gLd.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.gLU.setVisibility(8);
            this.gLM.setLayoutParams(this.gYt);
            this.gLd.setLayoutParams(this.gYs);
            this.gLb.setLayoutParams(layoutParams);
        }
    }
}
