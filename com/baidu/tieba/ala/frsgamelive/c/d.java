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
    private static String gDV;
    private com.baidu.tieba.ala.f gCB;
    private a gDT;
    private String gDU;
    private bw ghO;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gsb = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.ghO != null && d.this.ghO.bmA() != null && !StringUtils.isNull(d.this.ghO.bmA().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.ghO.bmA().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bMo().bMp();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.ghO.bmA().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gDT = new a(this.mRootView);
        getView().setOnClickListener(this);
        gDV = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.f fVar) {
        this.gCB = fVar;
    }

    public void a(bw bwVar) {
        if (bwVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ghO = bwVar;
        this.gDT.gsd.setDrawerType(0);
        this.gDT.gsd.setBorderSurroundContent(true);
        this.gDT.gsd.setDrawBorder(true);
        this.gDT.gsd.startLoad(this.ghO.bmU().cover, 10, false);
        this.gDT.gsf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.ghO.bmU().audience_count)));
        this.gDT.gsh.setData(this.ghO);
        this.gDT.gsh.setIsRound(true);
        this.gDT.gsh.setBorderSurroundContent(true);
        this.gDT.gsi.setText(this.ghO.getTitle());
        if (this.ghO.bmA() != null) {
            String name_show = this.ghO.bmA().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gDT.aWW.setText(name_show);
        }
        this.gDT.gEa.setVisibility(0);
        this.gDT.gse.setBackgroundResource(R.drawable.transparent_bg);
        this.gDT.gse.setText(this.ghO.bmU().label_name);
        this.gDT.gse.setVisibility(0);
        if (this.ghO.bmA() == null || this.ghO.bmA().getAlaUserData() == null || at.isEmpty(this.ghO.bmA().getAlaUserData().great_anchor_icon)) {
            this.gDT.gDX.setVisibility(8);
        } else {
            this.gDT.gDX.setVisibility(0);
            this.gDT.gDX.startLoad(this.ghO.bmA().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gDT.aWW.setOnClickListener(this.gsb);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.ghO != null && this.ghO.bmU() != null) {
            if (this.gCB != null) {
                this.gCB.P(this.ghO);
            }
            com.baidu.tieba.ala.c.bMo().bMp();
            TiebaStatic.log(new aq("c12116").w("obj_id", this.ghO.bmU().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gDT.gsg, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gDT.gse, (int) R.color.cp_cont_g);
            ap.setViewTextColor(this.gDT.gsf, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.gDT.aWW, (int) R.color.cp_cont_d);
            ap.setViewTextColor(this.gDT.gsi, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.gDT.gEb, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gDU = str;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TextView aWW;
        public TbImageView gDX;
        public RelativeLayout gDY;
        public LinearLayout gDZ;
        public View gEa;
        public TextView gEb;
        private LinearLayout.LayoutParams gEc;
        private LinearLayout.LayoutParams gEd;
        public TbImageView gsd;
        public TextView gse;
        public TextView gsf;
        public RelativeLayout gsg;
        public ClickableHeaderImageView gsh;
        public TextView gsi;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gsd = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gse = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gsf = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gsg = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gsh = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aWW = (TextView) view.findViewById(R.id.tvUserName);
            this.gDY = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.gsi = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gDZ = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gDX = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gEa = view.findViewById(R.id.living_logo);
            this.gEb = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gEb.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gEc = (LinearLayout.LayoutParams) this.gsi.getLayoutParams();
            this.gEd = (LinearLayout.LayoutParams) this.gDZ.getLayoutParams();
            this.gDX.setDefaultErrorResource(0);
            this.gDX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gsd.setDefaultErrorResource(0);
            this.gsd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gsg.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gEd.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gEd.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gEc.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gEc.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gsi.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gDY.setVisibility(0);
            this.gDZ.setLayoutParams(this.gEd);
            this.gsi.setLayoutParams(this.gEc);
            this.gsg.setLayoutParams(layoutParams);
        }
    }
}
