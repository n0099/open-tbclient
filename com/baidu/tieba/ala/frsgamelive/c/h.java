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
    private static String dJg;
    private com.baidu.tieba.ala.d dHN;
    private String dJf;
    private a dJx;
    private bh dur;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener dDm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.dur != null && h.this.dur.aiE() != null && !StringUtils.isNull(h.this.dur.aiE().getUserId())) {
                long j = com.baidu.adp.lib.g.b.toLong(h.this.dur.aiE().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.aII().aIJ();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.dur.aiE().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.dJx = new a(this.mRootView);
        getView().setOnClickListener(this);
        dJg = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.dHN = dVar;
    }

    public void a(bh bhVar) {
        if (bhVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.dur = bhVar;
        this.dJx.dDo.setDrawerType(0);
        this.dJx.dDo.setBorderSurroundContent(true);
        this.dJx.dDo.setDrawBorder(true);
        this.dJx.dDo.startLoad(this.dur.aiX().cover, 10, false);
        this.dJx.dDq.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.dur.aiX().audience_count)));
        this.dJx.dDs.setData(this.dur);
        this.dJx.dDs.setIsRound(true);
        this.dJx.dDs.setBorderSurroundContent(true);
        this.dJx.dDt.setText(this.dur.getTitle());
        if (this.dur.aiE() != null) {
            String name_show = this.dur.aiE().getName_show();
            if (aa.getTextLengthWithEmoji(name_show) > 10) {
                name_show = aa.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.dJx.Xm.setText(name_show);
        }
        this.dJx.dJl.setVisibility(0);
        this.dJx.dDp.setBackgroundResource(R.drawable.transparent_bg);
        this.dJx.dDp.setText(this.dur.aiX().label_name);
        this.dJx.dDp.setVisibility(0);
        if (this.dur.aiE() == null || this.dur.aiE().getAlaUserData() == null || aq.isEmpty(this.dur.aiE().getAlaUserData().great_anchor_icon)) {
            this.dJx.dJi.setVisibility(8);
        } else {
            this.dJx.dJi.setVisibility(0);
            this.dJx.dJi.startLoad(this.dur.aiE().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.dJx.Xm.setOnClickListener(this.dDm);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.dur != null && this.dur.aiX() != null) {
            if (this.dHN != null) {
                this.dHN.I(this.dur);
            }
            com.baidu.tieba.ala.c.aII().aIJ();
            TiebaStatic.log(new an("c12116").p("obj_id", this.dur.aiX().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dJx.dDr, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.dJx.dDp, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.dJx.dDq, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dJx.Xm, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dJx.dDt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dJx.dJm, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.dJf = str;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public TextView Xm;
        public TbImageView dDo;
        public TextView dDp;
        public TextView dDq;
        public RelativeLayout dDr;
        public ClickableHeaderImageView dDs;
        public TextView dDt;
        public TbImageView dJi;
        public RelativeLayout dJj;
        public LinearLayout dJk;
        public View dJl;
        public TextView dJm;
        private LinearLayout.LayoutParams dJn;
        private LinearLayout.LayoutParams dJo;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.dDo = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.dDp = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.dDq = (TextView) view.findViewById(R.id.tvLiveCount);
            this.dDr = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.dDs = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.Xm = (TextView) view.findViewById(R.id.tvUserName);
            this.dJj = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.dDt = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.dJk = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.dJi = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.dJl = view.findViewById(R.id.living_logo);
            this.dJm = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.dJm.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.dJn = (LinearLayout.LayoutParams) this.dDt.getLayoutParams();
            this.dJo = (LinearLayout.LayoutParams) this.dJk.getLayoutParams();
            this.dJi.setDefaultErrorResource(0);
            this.dJi.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.dDo.setDefaultErrorResource(0);
            this.dDo.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dDr.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.dJo.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.dJo.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.dJn.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.dJn.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.dDt.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.dJj.setVisibility(8);
            this.dJk.setLayoutParams(this.dJo);
            this.dDt.setLayoutParams(this.dJn);
            this.dDr.setLayoutParams(layoutParams);
        }
    }
}
