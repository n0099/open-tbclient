package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {
    private bw fRW;
    private String fWl;
    private i fZK;
    private a gcM;
    private boolean gcj;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.fRW != null && g.this.fRW.biB() != null && g.this.fZK != null) {
                    g.this.fZK.a(g.this.tabId, g.this.fWl, g.this.fRW);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener gck = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.fRW != null && g.this.fRW.bih() != null && !StringUtils.isNull(g.this.fRW.bih().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.fRW.bih().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.fRW.bih().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gcM = new a(this.mRootView);
        this.gcj = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.fZK = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.fRW == null || cVar.fRW.biB() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fRW = cVar.fRW;
        this.tabId = cVar.tabId;
        this.fWl = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.gcM.gcm.setDrawerType(0);
        this.gcM.gcm.setBorderSurroundContent(true);
        this.gcM.gcm.setDrawBorder(true);
        this.gcM.gcm.startLoad(this.fRW.biB().cover, 10, false);
        this.gcM.gco.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fRW.biB().audience_count)));
        this.gcM.gcq.setData(this.fRW, false);
        this.gcM.gcr.setText(this.fRW.getTitle());
        if (this.fRW.bih() != null) {
            String name_show = this.fRW.bih().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gcM.aUj.setText(name_show);
        }
        String str = this.fRW.biB().label_name;
        if (this.gcj && !StringUtils.isNull(str)) {
            this.gcM.gcn.setText(str);
            this.gcM.gcn.setVisibility(0);
        } else {
            this.gcM.gcn.setVisibility(8);
        }
        if (cVar.fRX) {
            this.gcM.gcs.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.fRW.biB().distance / 1000.0d))));
            this.gcM.gcs.setVisibility(0);
        } else {
            this.gcM.gcs.setVisibility(8);
        }
        this.gcM.aUj.setOnClickListener(this.gck);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gcM.gcp, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gcM.gco, R.color.cp_cont_a);
            ap.setViewTextColor(this.gcM.aUj, R.color.cp_cont_a);
            ap.setViewTextColor(this.gcM.gcr, R.color.cp_cont_b);
            ap.setViewTextColor(this.gcM.gcs, R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aUj;
        public TbImageView gcm;
        public TextView gcn;
        public TextView gco;
        public RelativeLayout gcp;
        public ClickableHeaderImageView gcq;
        public TextView gcr;
        public TextView gcs;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gcm = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gcn = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gco = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gcp = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gcq = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aUj = (TextView) view.findViewById(R.id.tvUserName);
            this.gcr = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gcs = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.gcm.setDefaultErrorResource(0);
            this.gcm.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gcm.setDrawerType(0);
            this.gcq.setIsRound(true);
            this.gcq.setDrawBorder(true);
            this.gcq.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gcq.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gcq.setIsGod(false);
            this.gcq.setIsBigV(false);
            this.gcq.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gcp.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.gcp.setLayoutParams(layoutParams);
        }
    }
}
