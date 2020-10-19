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
    private static String goc;
    private bw fRW;
    private com.baidu.tieba.ala.f gmI;
    private String gob;
    private a got;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gck = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.fRW != null && h.this.fRW.bih() != null && !StringUtils.isNull(h.this.fRW.bih().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(h.this.fRW.bih().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bHX().bHY();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.fRW.bih().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.got = new a(this.mRootView);
        getView().setOnClickListener(this);
        goc = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.f fVar) {
        this.gmI = fVar;
    }

    public void a(bw bwVar) {
        if (bwVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fRW = bwVar;
        this.got.gcm.setDrawerType(0);
        this.got.gcm.setBorderSurroundContent(true);
        this.got.gcm.setDrawBorder(true);
        this.got.gcm.startLoad(this.fRW.biB().cover, 10, false);
        this.got.gco.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.fRW.biB().audience_count)));
        this.got.gcq.setData(this.fRW);
        this.got.gcq.setIsRound(true);
        this.got.gcq.setBorderSurroundContent(true);
        this.got.gcr.setText(this.fRW.getTitle());
        if (this.fRW.bih() != null) {
            String name_show = this.fRW.bih().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.got.aUj.setText(name_show);
        }
        this.got.goh.setVisibility(0);
        this.got.gcn.setBackgroundResource(R.drawable.transparent_bg);
        this.got.gcn.setText(this.fRW.biB().label_name);
        this.got.gcn.setVisibility(0);
        if (this.fRW.bih() == null || this.fRW.bih().getAlaUserData() == null || at.isEmpty(this.fRW.bih().getAlaUserData().great_anchor_icon)) {
            this.got.goe.setVisibility(8);
        } else {
            this.got.goe.setVisibility(0);
            this.got.goe.startLoad(this.fRW.bih().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.got.aUj.setOnClickListener(this.gck);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.fRW != null && this.fRW.biB() != null) {
            if (this.gmI != null) {
                this.gmI.P(this.fRW);
            }
            com.baidu.tieba.ala.c.bHX().bHY();
            TiebaStatic.log(new aq("c12116").u("obj_id", this.fRW.biB().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.got.gcp, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.got.gcn, R.color.cp_cont_g);
            ap.setViewTextColor(this.got.gco, R.color.cp_cont_a);
            ap.setViewTextColor(this.got.aUj, R.color.cp_cont_d);
            ap.setViewTextColor(this.got.gcr, R.color.cp_cont_b);
            ap.setViewTextColor(this.got.goi, R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gob = str;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public TextView aUj;
        public TbImageView gcm;
        public TextView gcn;
        public TextView gco;
        public RelativeLayout gcp;
        public ClickableHeaderImageView gcq;
        public TextView gcr;
        public TbImageView goe;
        public RelativeLayout gof;
        public LinearLayout gog;
        public View goh;
        public TextView goi;
        private LinearLayout.LayoutParams goj;
        private LinearLayout.LayoutParams gok;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gcm = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gcn = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gco = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gcp = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gcq = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aUj = (TextView) view.findViewById(R.id.tvUserName);
            this.gof = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.gcr = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gog = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.goe = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.goh = view.findViewById(R.id.living_logo);
            this.goi = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.goi.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.goj = (LinearLayout.LayoutParams) this.gcr.getLayoutParams();
            this.gok = (LinearLayout.LayoutParams) this.gog.getLayoutParams();
            this.goe.setDefaultErrorResource(0);
            this.goe.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gcm.setDefaultErrorResource(0);
            this.gcm.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gcp.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gok.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gok.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.goj.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.goj.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gcr.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.gof.setVisibility(8);
            this.gog.setLayoutParams(this.gok);
            this.gcr.setLayoutParams(this.goj);
            this.gcp.setLayoutParams(layoutParams);
        }
    }
}
