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
public class h implements View.OnClickListener {
    private static String gyh;
    private bw gbZ;
    private com.baidu.tieba.ala.f gwN;
    private String gyg;
    private a gyy;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gmo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.gbZ != null && h.this.gbZ.bka() != null && !StringUtils.isNull(h.this.gbZ.bka().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(h.this.gbZ.bka().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bJP().bJQ();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.gbZ.bka().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gyy = new a(this.mRootView);
        getView().setOnClickListener(this);
        gyh = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.f fVar) {
        this.gwN = fVar;
    }

    public void a(bw bwVar) {
        if (bwVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gbZ = bwVar;
        this.gyy.gmq.setDrawerType(0);
        this.gyy.gmq.setBorderSurroundContent(true);
        this.gyy.gmq.setDrawBorder(true);
        this.gyy.gmq.startLoad(this.gbZ.bku().cover, 10, false);
        this.gyy.gms.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.gbZ.bku().audience_count)));
        this.gyy.gmu.setData(this.gbZ);
        this.gyy.gmu.setIsRound(true);
        this.gyy.gmu.setBorderSurroundContent(true);
        this.gyy.gmv.setText(this.gbZ.getTitle());
        if (this.gbZ.bka() != null) {
            String name_show = this.gbZ.bka().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gyy.aVE.setText(name_show);
        }
        this.gyy.gym.setVisibility(0);
        this.gyy.gmr.setBackgroundResource(R.drawable.transparent_bg);
        this.gyy.gmr.setText(this.gbZ.bku().label_name);
        this.gyy.gmr.setVisibility(0);
        if (this.gbZ.bka() == null || this.gbZ.bka().getAlaUserData() == null || at.isEmpty(this.gbZ.bka().getAlaUserData().great_anchor_icon)) {
            this.gyy.gyj.setVisibility(8);
        } else {
            this.gyy.gyj.setVisibility(0);
            this.gyy.gyj.startLoad(this.gbZ.bka().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gyy.aVE.setOnClickListener(this.gmo);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gbZ != null && this.gbZ.bku() != null) {
            if (this.gwN != null) {
                this.gwN.P(this.gbZ);
            }
            com.baidu.tieba.ala.c.bJP().bJQ();
            TiebaStatic.log(new aq("c12116").w("obj_id", this.gbZ.bku().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gyy.gmt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gyy.gmr, R.color.cp_cont_g);
            ap.setViewTextColor(this.gyy.gms, R.color.cp_cont_a);
            ap.setViewTextColor(this.gyy.aVE, R.color.cp_cont_d);
            ap.setViewTextColor(this.gyy.gmv, R.color.cp_cont_b);
            ap.setViewTextColor(this.gyy.gyn, R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gyg = str;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TextView aVE;
        public TbImageView gmq;
        public TextView gmr;
        public TextView gms;
        public RelativeLayout gmt;
        public ClickableHeaderImageView gmu;
        public TextView gmv;
        public TbImageView gyj;
        public RelativeLayout gyk;
        public LinearLayout gyl;
        public View gym;
        public TextView gyn;
        private LinearLayout.LayoutParams gyo;
        private LinearLayout.LayoutParams gyp;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gmq = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gmr = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gms = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gmt = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gmu = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aVE = (TextView) view.findViewById(R.id.tvUserName);
            this.gyk = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.gmv = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gyl = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gyj = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gym = view.findViewById(R.id.living_logo);
            this.gyn = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gyn.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gyo = (LinearLayout.LayoutParams) this.gmv.getLayoutParams();
            this.gyp = (LinearLayout.LayoutParams) this.gyl.getLayoutParams();
            this.gyj.setDefaultErrorResource(0);
            this.gyj.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gmq.setDefaultErrorResource(0);
            this.gmq.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmt.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gyp.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gyp.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gyo.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gyo.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gmv.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.gyk.setVisibility(8);
            this.gyl.setLayoutParams(this.gyp);
            this.gmv.setLayoutParams(this.gyo);
            this.gmt.setLayoutParams(layoutParams);
        }
    }
}
