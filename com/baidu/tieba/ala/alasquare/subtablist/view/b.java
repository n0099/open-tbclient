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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.e> {
    private cb gAx;
    private String gEU;
    private g gIy;
    private a gKV;
    private boolean gKW;
    View.OnClickListener gKX;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gKW = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (b.this.gAx != null && b.this.gAx.bol() != null && b.this.gIy != null) {
                        b.this.gIy.a(b.this.tabId, b.this.gEU, b.this.gAx);
                        return;
                    }
                    return;
                }
                l.showLongToast(b.this.mTbPageContext.getPageActivity(), b.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.gKX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gAx != null && b.this.gAx.bnS() != null && !StringUtils.isNull(b.this.gAx.bnS().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(b.this.gAx.bnS().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(b.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), b.this.gAx.bnS().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gKV = new a(getView());
        this.gKW = z;
    }

    public void c(g gVar) {
        this.gIy = gVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gKV.gLc, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gKV.gLb, R.color.CAM_X0101);
            ap.setViewTextColor(this.gKV.aZX, R.color.CAM_X0101);
            ap.setViewTextColor(this.gKV.gLe, R.color.CAM_X0105);
            ap.setViewTextColor(this.gKV.gLf, R.color.CAM_X0109);
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
        if (eVar == null || eVar.gAx == null || eVar.gAx.bol() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAx = eVar.gAx;
        this.tabId = eVar.tabId;
        this.gEU = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        this.gKV.gKZ.startLoad(this.gAx.bol().cover, 10, false);
        this.gKV.gLb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gAx.bol().audience_count)));
        this.gKV.gLd.setData(this.gAx, false);
        this.gKV.gLe.setText(this.gAx.getTitle());
        if (this.gAx.bnS() != null) {
            String name_show = this.gAx.bnS().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gKV.aZX.setText(name_show);
        }
        String str = this.gAx.bol().label_name;
        if (this.gKW && !StringUtils.isNull(str)) {
            this.gKV.gLa.setText(str);
            this.gKV.gLa.setVisibility(0);
        } else {
            this.gKV.gLa.setVisibility(8);
        }
        if (eVar.gAF) {
            this.gKV.gLf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.gAx.bol().distance / 1000.0d))));
            this.gKV.gLf.setVisibility(0);
        } else {
            this.gKV.gLf.setVisibility(8);
        }
        this.gKV.aZX.setOnClickListener(this.gKX);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public class a {
        public TextView aZX;
        public TbImageView gKZ;
        public TextView gLa;
        public TextView gLb;
        public RelativeLayout gLc;
        public ClickableHeaderImageView gLd;
        public TextView gLe;
        public TextView gLf;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gKZ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gLa = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gLb = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gLc = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gLd = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aZX = (TextView) view.findViewById(R.id.tvUserName);
            this.gLe = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gLf = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(b.this.mOnClickListener);
            this.gKZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gKZ.setDrawerType(0);
            this.gLd.setIsRound(true);
            this.gLd.setDrawBorder(true);
            this.gLd.setBorderColor(b.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gLd.setBorderWidth(b.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gLd.setIsGod(false);
            this.gLd.setIsBigV(false);
            this.gLd.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLc.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gLc.setLayoutParams(layoutParams);
        }
    }
}
