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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class h implements View.OnClickListener {
    private static String exu;
    private bj eft;
    private com.baidu.tieba.ala.d evZ;
    private a exL;
    private String exs;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener eol = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.eft != null && h.this.eft.azE() != null && !StringUtils.isNull(h.this.eft.azE().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(h.this.eft.azE().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.aZf().aZg();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.eft.azE().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.exL = new a(this.mRootView);
        getView().setOnClickListener(this);
        exu = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.evZ = dVar;
    }

    public void a(bj bjVar) {
        if (bjVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eft = bjVar;
        this.exL.eon.setDrawerType(0);
        this.exL.eon.setBorderSurroundContent(true);
        this.exL.eon.setDrawBorder(true);
        this.exL.eon.startLoad(this.eft.azX().cover, 10, false);
        this.exL.eop.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.eft.azX().audience_count)));
        this.exL.eor.setData(this.eft);
        this.exL.eor.setIsRound(true);
        this.exL.eor.setBorderSurroundContent(true);
        this.exL.eos.setText(this.eft.getTitle());
        if (this.eft.azE() != null) {
            String name_show = this.eft.azE().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.exL.aeX.setText(name_show);
        }
        this.exL.exz.setVisibility(0);
        this.exL.eoo.setBackgroundResource(R.drawable.transparent_bg);
        this.exL.eoo.setText(this.eft.azX().label_name);
        this.exL.eoo.setVisibility(0);
        if (this.eft.azE() == null || this.eft.azE().getAlaUserData() == null || aq.isEmpty(this.eft.azE().getAlaUserData().great_anchor_icon)) {
            this.exL.exw.setVisibility(8);
        } else {
            this.exL.exw.setVisibility(0);
            this.exL.exw.startLoad(this.eft.azE().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.exL.aeX.setOnClickListener(this.eol);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.eft != null && this.eft.azX() != null) {
            if (this.evZ != null) {
                this.evZ.M(this.eft);
            }
            com.baidu.tieba.ala.c.aZf().aZg();
            TiebaStatic.log(new an("c12116").s("obj_id", this.eft.azX().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.exL.eoq, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.exL.eoo, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.exL.eop, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.exL.aeX, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.exL.eos, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.exL.exA, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.exs = str;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public TextView aeX;
        public TbImageView eon;
        public TextView eoo;
        public TextView eop;
        public RelativeLayout eoq;
        public ClickableHeaderImageView eor;
        public TextView eos;
        public TextView exA;
        private LinearLayout.LayoutParams exB;
        private LinearLayout.LayoutParams exC;
        public TbImageView exw;
        public RelativeLayout exx;
        public LinearLayout exy;
        public View exz;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.eon = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eoo = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eop = (TextView) view.findViewById(R.id.tvLiveCount);
            this.eoq = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eor = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aeX = (TextView) view.findViewById(R.id.tvUserName);
            this.exx = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.eos = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.exy = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.exw = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.exz = view.findViewById(R.id.living_logo);
            this.exA = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.exA.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.exB = (LinearLayout.LayoutParams) this.eos.getLayoutParams();
            this.exC = (LinearLayout.LayoutParams) this.exy.getLayoutParams();
            this.exw.setDefaultErrorResource(0);
            this.exw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.eon.setDefaultErrorResource(0);
            this.eon.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eoq.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.exC.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.exC.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.exB.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.exB.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.eos.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.exx.setVisibility(8);
            this.exy.setLayoutParams(this.exC);
            this.eos.setLayoutParams(this.exB);
            this.eoq.setLayoutParams(layoutParams);
        }
    }
}
