package com.baidu.tieba.ala.alasquare.subtablist.view;

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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.e> {
    private String gAn;
    private g gDR;
    private a gGo;
    private boolean gGp;
    View.OnClickListener gGq;
    private bz gvQ;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gGp = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (b.this.gvQ != null && b.this.gvQ.bnQ() != null && b.this.gDR != null) {
                        b.this.gDR.a(b.this.tabId, b.this.gAn, b.this.gvQ);
                        return;
                    }
                    return;
                }
                l.showLongToast(b.this.mTbPageContext.getPageActivity(), b.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.gGq = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gvQ != null && b.this.gvQ.bnx() != null && !StringUtils.isNull(b.this.gvQ.bnx().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(b.this.gvQ.bnx().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(b.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), b.this.gvQ.bnx().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gGo = new a(getView());
        this.gGp = z;
    }

    public void c(g gVar) {
        this.gDR = gVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gGo.gGv, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gGo.gGu, R.color.CAM_X0101);
            ao.setViewTextColor(this.gGo.aVp, R.color.CAM_X0101);
            ao.setViewTextColor(this.gGo.gGx, R.color.CAM_X0105);
            ao.setViewTextColor(this.gGo.gGy, R.color.CAM_X0109);
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
    public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gvQ == null || eVar.gvQ.bnQ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gvQ = eVar.gvQ;
        this.tabId = eVar.tabId;
        this.gAn = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        this.gGo.gGs.startLoad(this.gvQ.bnQ().cover, 10, false);
        this.gGo.gGu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.gvQ.bnQ().audience_count)));
        this.gGo.gGw.setData(this.gvQ, false);
        this.gGo.gGx.setText(this.gvQ.getTitle());
        if (this.gvQ.bnx() != null) {
            String name_show = this.gvQ.bnx().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gGo.aVp.setText(name_show);
        }
        String str = this.gvQ.bnQ().label_name;
        if (this.gGp && !StringUtils.isNull(str)) {
            this.gGo.gGt.setText(str);
            this.gGo.gGt.setVisibility(0);
        } else {
            this.gGo.gGt.setVisibility(8);
        }
        if (eVar.gvY) {
            this.gGo.gGy.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.gvQ.bnQ().distance / 1000.0d))));
            this.gGo.gGy.setVisibility(0);
        } else {
            this.gGo.gGy.setVisibility(8);
        }
        this.gGo.aVp.setOnClickListener(this.gGq);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public class a {
        public TextView aVp;
        public TbImageView gGs;
        public TextView gGt;
        public TextView gGu;
        public RelativeLayout gGv;
        public ClickableHeaderImageView gGw;
        public TextView gGx;
        public TextView gGy;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gGs = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gGt = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gGu = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gGv = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gGw = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aVp = (TextView) view.findViewById(R.id.tvUserName);
            this.gGx = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gGy = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(b.this.mOnClickListener);
            this.gGs.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gGs.setDrawerType(0);
            this.gGw.setIsRound(true);
            this.gGw.setDrawBorder(true);
            this.gGw.setBorderColor(b.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gGw.setBorderWidth(b.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gGw.setIsGod(false);
            this.gGw.setIsBigV(false);
            this.gGw.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGv.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gGv.setLayoutParams(layoutParams);
        }
    }
}
