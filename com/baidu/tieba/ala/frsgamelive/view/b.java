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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.d;
import com.baidu.tieba.ala.h;
/* loaded from: classes9.dex */
public class b implements View.OnClickListener {
    private static String gYo;
    private cb gAx;
    private h gWU;
    private a gYD;
    private String gYn;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gKX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gAx != null && b.this.gAx.bnS() != null && !StringUtils.isNull(b.this.gAx.bnS().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(b.this.gAx.bnS().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                d.bOR().bOS();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(b.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, b.this.gAx.bnS().isBigV())));
            }
        }
    };

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gYD = new a(this.mRootView);
        getView().setOnClickListener(this);
        gYo = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(h hVar) {
        this.gWU = hVar;
    }

    public void a(cb cbVar) {
        if (cbVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAx = cbVar;
        this.gYD.gKZ.setDrawerType(0);
        this.gYD.gKZ.setBorderSurroundContent(true);
        this.gYD.gKZ.setDrawBorder(true);
        this.gYD.gKZ.startLoad(this.gAx.bol().cover, 10, false);
        this.gYD.gLb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, au.numberUniformFormatExtra(this.gAx.bol().audience_count)));
        this.gYD.gLd.setData(this.gAx);
        this.gYD.gLd.setIsRound(true);
        this.gYD.gLd.setBorderSurroundContent(true);
        this.gYD.gLe.setText(this.gAx.getTitle());
        if (this.gAx.bnS() != null) {
            String name_show = this.gAx.bnS().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gYD.aZX.setText(name_show);
        }
        this.gYD.gYr.setVisibility(0);
        this.gYD.gLa.setBackgroundResource(R.drawable.transparent_bg);
        this.gYD.gLa.setText(this.gAx.bol().label_name);
        this.gYD.gLa.setVisibility(0);
        if (this.gAx.bnS() == null || this.gAx.bnS().getAlaUserData() == null || au.isEmpty(this.gAx.bnS().getAlaUserData().great_anchor_icon)) {
            this.gYD.gYq.setVisibility(8);
        } else {
            this.gYD.gYq.setVisibility(0);
            this.gYD.gYq.startLoad(this.gAx.bnS().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gYD.aZX.setOnClickListener(this.gKX);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gAx != null && this.gAx.bol() != null) {
            if (this.gWU != null) {
                this.gWU.S(this.gAx);
            }
            d.bOR().bOS();
            TiebaStatic.log(new ar("c12116").v("obj_id", this.gAx.bol().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gYD.gLc, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gYD.gLa, R.color.CAM_X0111);
            ap.setViewTextColor(this.gYD.gLb, R.color.CAM_X0101);
            ap.setViewTextColor(this.gYD.aZX, R.color.CAM_X0109);
            ap.setViewTextColor(this.gYD.gLe, R.color.CAM_X0105);
            ap.setViewTextColor(this.gYD.gYs, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gYn = str;
    }

    /* loaded from: classes9.dex */
    public static class a {
        public TextView aZX;
        public TbImageView gKZ;
        public LinearLayout gLN;
        public RelativeLayout gLV;
        public TextView gLa;
        public TextView gLb;
        public RelativeLayout gLc;
        public ClickableHeaderImageView gLd;
        public TextView gLe;
        public TbImageView gYq;
        public View gYr;
        public TextView gYs;
        private LinearLayout.LayoutParams gYt;
        private LinearLayout.LayoutParams gYu;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gKZ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gLa = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gLb = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gLc = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gLd = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aZX = (TextView) view.findViewById(R.id.tvUserName);
            this.gLV = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.gLe = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gLN = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gYq = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gYr = view.findViewById(R.id.living_logo);
            this.gYs = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gYs.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gYt = (LinearLayout.LayoutParams) this.gLe.getLayoutParams();
            this.gYu = (LinearLayout.LayoutParams) this.gLN.getLayoutParams();
            this.gYq.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gKZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLc.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gYu.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gYu.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gYt.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gYt.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gLe.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.gLV.setVisibility(8);
            this.gLN.setLayoutParams(this.gYu);
            this.gLe.setLayoutParams(this.gYt);
            this.gLc.setLayoutParams(layoutParams);
        }
    }
}
