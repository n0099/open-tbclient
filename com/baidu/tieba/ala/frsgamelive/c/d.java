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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d implements View.OnClickListener {
    private static String dJX;
    private com.baidu.tieba.ala.d dIE;
    private a dJV;
    private String dJW;
    private bh dvi;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener dEd = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.dvi != null && d.this.dvi.aiG() != null && !StringUtils.isNull(d.this.dvi.aiG().getUserId())) {
                long j = com.baidu.adp.lib.g.b.toLong(d.this.dvi.aiG().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.aIK().aIL();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.dvi.aiG().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.dJV = new a(this.mRootView);
        getView().setOnClickListener(this);
        dJX = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.dIE = dVar;
    }

    public void a(bh bhVar) {
        if (bhVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.dvi = bhVar;
        this.dJV.dEf.setDrawerType(0);
        this.dJV.dEf.setBorderSurroundContent(true);
        this.dJV.dEf.setDrawBorder(true);
        this.dJV.dEf.startLoad(this.dvi.aiZ().cover, 10, false);
        this.dJV.dEh.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.dvi.aiZ().audience_count)));
        this.dJV.dEj.setData(this.dvi);
        this.dJV.dEj.setIsRound(true);
        this.dJV.dEj.setBorderSurroundContent(true);
        this.dJV.dEk.setText(this.dvi.getTitle());
        if (this.dvi.aiG() != null) {
            String name_show = this.dvi.aiG().getName_show();
            if (aa.getTextLengthWithEmoji(name_show) > 10) {
                name_show = aa.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.dJV.XE.setText(name_show);
        }
        this.dJV.dKc.setVisibility(0);
        this.dJV.dEg.setBackgroundResource(R.drawable.transparent_bg);
        this.dJV.dEg.setText(this.dvi.aiZ().label_name);
        this.dJV.dEg.setVisibility(0);
        if (this.dvi.aiG() == null || this.dvi.aiG().getAlaUserData() == null || aq.isEmpty(this.dvi.aiG().getAlaUserData().great_anchor_icon)) {
            this.dJV.dJZ.setVisibility(8);
        } else {
            this.dJV.dJZ.setVisibility(0);
            this.dJV.dJZ.startLoad(this.dvi.aiG().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.dJV.XE.setOnClickListener(this.dEd);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.dvi != null && this.dvi.aiZ() != null) {
            if (this.dIE != null) {
                this.dIE.I(this.dvi);
            }
            com.baidu.tieba.ala.c.aIK().aIL();
            TiebaStatic.log(new an("c12116").p("obj_id", this.dvi.aiZ().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dJV.dEi, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.dJV.dEg, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.dJV.dEh, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dJV.XE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dJV.dEk, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dJV.dKd, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.dJW = str;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public TextView XE;
        public TbImageView dEf;
        public TextView dEg;
        public TextView dEh;
        public RelativeLayout dEi;
        public ClickableHeaderImageView dEj;
        public TextView dEk;
        public TbImageView dJZ;
        public RelativeLayout dKa;
        public LinearLayout dKb;
        public View dKc;
        public TextView dKd;
        private LinearLayout.LayoutParams dKe;
        private LinearLayout.LayoutParams dKf;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.dEf = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.dEg = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.dEh = (TextView) view.findViewById(R.id.tvLiveCount);
            this.dEi = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.dEj = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.XE = (TextView) view.findViewById(R.id.tvUserName);
            this.dKa = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.dEk = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.dKb = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.dJZ = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.dKc = view.findViewById(R.id.living_logo);
            this.dKd = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.dKd.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.dKe = (LinearLayout.LayoutParams) this.dEk.getLayoutParams();
            this.dKf = (LinearLayout.LayoutParams) this.dKb.getLayoutParams();
            this.dJZ.setDefaultErrorResource(0);
            this.dJZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.dEf.setDefaultErrorResource(0);
            this.dEf.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEi.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.dKf.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.dKf.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.dKe.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.dKe.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.dEk.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.dKa.setVisibility(0);
            this.dKb.setLayoutParams(this.dKf);
            this.dEk.setLayoutParams(this.dKe);
            this.dEi.setLayoutParams(layoutParams);
        }
    }
}
