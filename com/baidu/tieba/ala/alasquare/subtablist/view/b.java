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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.e> {
    private String gCX;
    private g gGB;
    private a gIY;
    private boolean gIZ;
    View.OnClickListener gJa;
    private cb gyA;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gIZ = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (b.this.gyA != null && b.this.gyA.boj() != null && b.this.gGB != null) {
                        b.this.gGB.a(b.this.tabId, b.this.gCX, b.this.gyA);
                        return;
                    }
                    return;
                }
                l.showLongToast(b.this.mTbPageContext.getPageActivity(), b.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.gJa = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gyA != null && b.this.gyA.bnQ() != null && !StringUtils.isNull(b.this.gyA.bnQ().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(b.this.gyA.bnQ().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(b.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), b.this.gyA.bnQ().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gIY = new a(getView());
        this.gIZ = z;
    }

    public void c(g gVar) {
        this.gGB = gVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gIY.gJf, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gIY.gJe, R.color.CAM_X0101);
            ap.setViewTextColor(this.gIY.aYx, R.color.CAM_X0101);
            ap.setViewTextColor(this.gIY.gJh, R.color.CAM_X0105);
            ap.setViewTextColor(this.gIY.gJi, R.color.CAM_X0109);
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
        if (eVar == null || eVar.gyA == null || eVar.gyA.boj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gyA = eVar.gyA;
        this.tabId = eVar.tabId;
        this.gCX = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        this.gIY.gJc.startLoad(this.gyA.boj().cover, 10, false);
        this.gIY.gJe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gyA.boj().audience_count)));
        this.gIY.gJg.setData(this.gyA, false);
        this.gIY.gJh.setText(this.gyA.getTitle());
        if (this.gyA.bnQ() != null) {
            String name_show = this.gyA.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gIY.aYx.setText(name_show);
        }
        String str = this.gyA.boj().label_name;
        if (this.gIZ && !StringUtils.isNull(str)) {
            this.gIY.gJd.setText(str);
            this.gIY.gJd.setVisibility(0);
        } else {
            this.gIY.gJd.setVisibility(8);
        }
        if (eVar.gyI) {
            this.gIY.gJi.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.gyA.boj().distance / 1000.0d))));
            this.gIY.gJi.setVisibility(0);
        } else {
            this.gIY.gJi.setVisibility(8);
        }
        this.gIY.aYx.setOnClickListener(this.gJa);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes10.dex */
    public class a {
        public TextView aYx;
        public TbImageView gJc;
        public TextView gJd;
        public TextView gJe;
        public RelativeLayout gJf;
        public ClickableHeaderImageView gJg;
        public TextView gJh;
        public TextView gJi;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gJc = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gJd = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gJe = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gJf = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gJg = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aYx = (TextView) view.findViewById(R.id.tvUserName);
            this.gJh = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gJi = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(b.this.mOnClickListener);
            this.gJc.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gJc.setDrawerType(0);
            this.gJg.setIsRound(true);
            this.gJg.setDrawBorder(true);
            this.gJg.setBorderColor(b.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gJg.setBorderWidth(b.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gJg.setIsGod(false);
            this.gJg.setIsBigV(false);
            this.gJg.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJf.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gJf.setLayoutParams(layoutParams);
        }
    }
}
