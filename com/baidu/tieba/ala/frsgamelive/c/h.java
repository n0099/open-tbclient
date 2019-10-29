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
public class h implements View.OnClickListener {
    private static String dJX;
    private com.baidu.tieba.ala.d dIE;
    private String dJW;
    private a dKo;
    private bh dvi;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener dEd = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.dvi != null && h.this.dvi.aiG() != null && !StringUtils.isNull(h.this.dvi.aiG().getUserId())) {
                long j = com.baidu.adp.lib.g.b.toLong(h.this.dvi.aiG().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.aIK().aIL();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.dvi.aiG().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.dKo = new a(this.mRootView);
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
        this.dKo.dEf.setDrawerType(0);
        this.dKo.dEf.setBorderSurroundContent(true);
        this.dKo.dEf.setDrawBorder(true);
        this.dKo.dEf.startLoad(this.dvi.aiZ().cover, 10, false);
        this.dKo.dEh.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.dvi.aiZ().audience_count)));
        this.dKo.dEj.setData(this.dvi);
        this.dKo.dEj.setIsRound(true);
        this.dKo.dEj.setBorderSurroundContent(true);
        this.dKo.dEk.setText(this.dvi.getTitle());
        if (this.dvi.aiG() != null) {
            String name_show = this.dvi.aiG().getName_show();
            if (aa.getTextLengthWithEmoji(name_show) > 10) {
                name_show = aa.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.dKo.XE.setText(name_show);
        }
        this.dKo.dKc.setVisibility(0);
        this.dKo.dEg.setBackgroundResource(R.drawable.transparent_bg);
        this.dKo.dEg.setText(this.dvi.aiZ().label_name);
        this.dKo.dEg.setVisibility(0);
        if (this.dvi.aiG() == null || this.dvi.aiG().getAlaUserData() == null || aq.isEmpty(this.dvi.aiG().getAlaUserData().great_anchor_icon)) {
            this.dKo.dJZ.setVisibility(8);
        } else {
            this.dKo.dJZ.setVisibility(0);
            this.dKo.dJZ.startLoad(this.dvi.aiG().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.dKo.XE.setOnClickListener(this.dEd);
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
            am.setBackgroundResource(this.dKo.dEi, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.dKo.dEg, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.dKo.dEh, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dKo.XE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dKo.dEk, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dKo.dKd, (int) R.color.cp_cont_a);
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
            this.dKf.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.dKf.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.dKe.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.dKe.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.dEk.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.dKa.setVisibility(8);
            this.dKb.setLayoutParams(this.dKf);
            this.dEk.setLayoutParams(this.dKe);
            this.dEi.setLayoutParams(layoutParams);
        }
    }
}
