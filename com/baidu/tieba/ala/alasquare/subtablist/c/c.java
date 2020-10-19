package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
import android.view.View;
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
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private bw fRW;
    private String fWl;
    private i fZK;
    private a gci;
    private boolean gcj;
    View.OnClickListener gck;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gcj = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.fRW != null && c.this.fRW.biB() != null && c.this.fZK != null) {
                        c.this.fZK.a(c.this.tabId, c.this.fWl, c.this.fRW);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.gck = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fRW != null && c.this.fRW.bih() != null && !StringUtils.isNull(c.this.fRW.bih().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.fRW.bih().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.fRW.bih().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gci = new a(getView());
        this.gcj = z;
    }

    public void c(i iVar) {
        this.fZK = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gci.gcp, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gci.gco, R.color.cp_cont_a);
            ap.setViewTextColor(this.gci.aUj, R.color.cp_cont_a);
            ap.setViewTextColor(this.gci.gcr, R.color.cp_cont_b);
            ap.setViewTextColor(this.gci.gcs, R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.fRW == null || cVar.fRW.biB() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fRW = cVar.fRW;
        this.tabId = cVar.tabId;
        this.fWl = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.gci.gcm.startLoad(this.fRW.biB().cover, 10, false);
        this.gci.gco.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fRW.biB().audience_count)));
        this.gci.gcq.setData(this.fRW, false);
        this.gci.gcr.setText(this.fRW.getTitle());
        if (this.fRW.bih() != null) {
            String name_show = this.fRW.bih().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gci.aUj.setText(name_show);
        }
        String str = this.fRW.biB().label_name;
        if (this.gcj && !StringUtils.isNull(str)) {
            this.gci.gcn.setText(str);
            this.gci.gcn.setVisibility(0);
        } else {
            this.gci.gcn.setVisibility(8);
        }
        if (cVar.fRX) {
            this.gci.gcs.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.fRW.biB().distance / 1000.0d))));
            this.gci.gcs.setVisibility(0);
        } else {
            this.gci.gcs.setVisibility(8);
        }
        this.gci.aUj.setOnClickListener(this.gck);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
            view.setOnClickListener(c.this.mOnClickListener);
            this.gcm.setDefaultErrorResource(0);
            this.gcm.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gcm.setDrawerType(0);
            this.gcq.setIsRound(true);
            this.gcq.setDrawBorder(true);
            this.gcq.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gcq.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gcq.setIsGod(false);
            this.gcq.setIsBigV(false);
            this.gcq.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gcp.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gcp.setLayoutParams(layoutParams);
        }
    }
}
