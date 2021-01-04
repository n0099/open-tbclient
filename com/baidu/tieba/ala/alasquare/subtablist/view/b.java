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
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.e> {
    private bz gAx;
    private String gEU;
    private g gIx;
    private a gKU;
    private boolean gKV;
    View.OnClickListener gKW;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gKV = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (b.this.gAx != null && b.this.gAx.brJ() != null && b.this.gIx != null) {
                        b.this.gIx.a(b.this.tabId, b.this.gEU, b.this.gAx);
                        return;
                    }
                    return;
                }
                l.showLongToast(b.this.mTbPageContext.getPageActivity(), b.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.gKW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gAx != null && b.this.gAx.brq() != null && !StringUtils.isNull(b.this.gAx.brq().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(b.this.gAx.brq().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(b.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), b.this.gAx.brq().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gKU = new a(getView());
        this.gKV = z;
    }

    public void c(g gVar) {
        this.gIx = gVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gKU.gLb, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gKU.gLa, R.color.CAM_X0101);
            ao.setViewTextColor(this.gKU.bac, R.color.CAM_X0101);
            ao.setViewTextColor(this.gKU.gLd, R.color.CAM_X0105);
            ao.setViewTextColor(this.gKU.gLe, R.color.CAM_X0109);
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
        if (eVar == null || eVar.gAx == null || eVar.gAx.brJ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAx = eVar.gAx;
        this.tabId = eVar.tabId;
        this.gEU = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        this.gKU.gKY.startLoad(this.gAx.brJ().cover, 10, false);
        this.gKU.gLa.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.gAx.brJ().audience_count)));
        this.gKU.gLc.setData(this.gAx, false);
        this.gKU.gLd.setText(this.gAx.getTitle());
        if (this.gAx.brq() != null) {
            String name_show = this.gAx.brq().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gKU.bac.setText(name_show);
        }
        String str = this.gAx.brJ().label_name;
        if (this.gKV && !StringUtils.isNull(str)) {
            this.gKU.gKZ.setText(str);
            this.gKU.gKZ.setVisibility(0);
        } else {
            this.gKU.gKZ.setVisibility(8);
        }
        if (eVar.gAF) {
            this.gKU.gLe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.gAx.brJ().distance / 1000.0d))));
            this.gKU.gLe.setVisibility(0);
        } else {
            this.gKU.gLe.setVisibility(8);
        }
        this.gKU.bac.setOnClickListener(this.gKW);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes10.dex */
    public class a {
        public TextView bac;
        public TbImageView gKY;
        public TextView gKZ;
        public TextView gLa;
        public RelativeLayout gLb;
        public ClickableHeaderImageView gLc;
        public TextView gLd;
        public TextView gLe;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gKY = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gKZ = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gLa = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gLb = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gLc = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.bac = (TextView) view.findViewById(R.id.tvUserName);
            this.gLd = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gLe = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(b.this.mOnClickListener);
            this.gKY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gKY.setDrawerType(0);
            this.gLc.setIsRound(true);
            this.gLc.setDrawBorder(true);
            this.gLc.setBorderColor(b.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gLc.setBorderWidth(b.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gLc.setIsGod(false);
            this.gLc.setIsBigV(false);
            this.gLc.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLb.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gLb.setLayoutParams(layoutParams);
        }
    }
}
