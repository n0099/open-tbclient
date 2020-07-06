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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private static String fHa;
    private com.baidu.tieba.ala.d fFG;
    private a fGY;
    private String fGZ;
    private bu flT;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener fwb = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.flT != null && d.this.flT.aSp() != null && !StringUtils.isNull(d.this.flT.aSp().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.flT.aSp().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.brT().brU();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.flT.aSp().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.fGY = new a(this.mRootView);
        getView().setOnClickListener(this);
        fHa = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.fFG = dVar;
    }

    public void a(bu buVar) {
        if (buVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.flT = buVar;
        this.fGY.fwd.setDrawerType(0);
        this.fGY.fwd.setBorderSurroundContent(true);
        this.fGY.fwd.setDrawBorder(true);
        this.fGY.fwd.startLoad(this.flT.aSJ().cover, 10, false);
        this.fGY.fwf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, ar.numberUniformFormatExtra(this.flT.aSJ().audience_count)));
        this.fGY.fwh.setData(this.flT);
        this.fGY.fwh.setIsRound(true);
        this.fGY.fwh.setBorderSurroundContent(true);
        this.fGY.fwi.setText(this.flT.getTitle());
        if (this.flT.aSp() != null) {
            String name_show = this.flT.aSp().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fGY.aIn.setText(name_show);
        }
        this.fGY.fHf.setVisibility(0);
        this.fGY.fwe.setBackgroundResource(R.drawable.transparent_bg);
        this.fGY.fwe.setText(this.flT.aSJ().label_name);
        this.fGY.fwe.setVisibility(0);
        if (this.flT.aSp() == null || this.flT.aSp().getAlaUserData() == null || ar.isEmpty(this.flT.aSp().getAlaUserData().great_anchor_icon)) {
            this.fGY.fHc.setVisibility(8);
        } else {
            this.fGY.fHc.setVisibility(0);
            this.fGY.fHc.startLoad(this.flT.aSp().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.fGY.aIn.setOnClickListener(this.fwb);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.flT != null && this.flT.aSJ() != null) {
            if (this.fFG != null) {
                this.fFG.R(this.flT);
            }
            com.baidu.tieba.ala.c.brT().brU();
            TiebaStatic.log(new ao("c12116").s("obj_id", this.flT.aSJ().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.fGY.fwg, R.drawable.addresslist_item_bg);
            an.setViewTextColor(this.fGY.fwe, (int) R.color.cp_cont_g);
            an.setViewTextColor(this.fGY.fwf, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fGY.aIn, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.fGY.fwi, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.fGY.fHg, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.fGZ = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView aIn;
        public TbImageView fHc;
        public RelativeLayout fHd;
        public LinearLayout fHe;
        public View fHf;
        public TextView fHg;
        private LinearLayout.LayoutParams fHh;
        private LinearLayout.LayoutParams fHi;
        public TbImageView fwd;
        public TextView fwe;
        public TextView fwf;
        public RelativeLayout fwg;
        public ClickableHeaderImageView fwh;
        public TextView fwi;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fwd = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fwe = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fwf = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fwg = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fwh = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aIn = (TextView) view.findViewById(R.id.tvUserName);
            this.fHd = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.fwi = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fHe = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.fHc = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.fHf = view.findViewById(R.id.living_logo);
            this.fHg = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.fHg.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.fHh = (LinearLayout.LayoutParams) this.fwi.getLayoutParams();
            this.fHi = (LinearLayout.LayoutParams) this.fHe.getLayoutParams();
            this.fHc.setDefaultErrorResource(0);
            this.fHc.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fwd.setDefaultErrorResource(0);
            this.fwd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fwg.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.fHi.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fHi.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fHh.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fHh.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.fwi.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fHd.setVisibility(0);
            this.fHe.setLayoutParams(this.fHi);
            this.fwi.setLayoutParams(this.fHh);
            this.fwg.setLayoutParams(layoutParams);
        }
    }
}
