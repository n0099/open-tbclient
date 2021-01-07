package com.baidu.tieba.ala.alasquare.widget;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.b> {
    private int gLD;
    private d gLE;
    private com.baidu.tieba.ala.alasquare.a.b gLI;
    private a gLJ;
    public int mSkinType;
    private int mViewWidth;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gLD = 0;
        initView();
    }

    private void initView() {
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gLD = (this.mViewWidth * 9) / 16;
        this.gLJ = new a(getView());
        getView().setOnClickListener(this);
    }

    public void a(d dVar) {
        this.gLE = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gLJ.gLb, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gLJ.gLd, R.color.CAM_X0105);
            ao.setViewTextColor(this.gLJ.gLF, R.color.CAM_X0111);
            ao.setViewTextColor(this.gLJ.gLG, R.color.CAM_X0111);
            this.gLJ.gLG.setAlpha(0.9f);
            ao.setViewTextColor(this.gLJ.gLK, R.color.live_cp_other_b);
            ao.setViewTextColor(this.gLJ.gLL, R.color.live_cp_other_b);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_active_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.a.b bVar) {
        if (bVar != null && bVar.gAx != null) {
            this.gLI = bVar;
            int i = bVar.gAx.eVx.eOI > 0 ? (this.mViewWidth * bVar.gAx.eVx.eOJ) / bVar.gAx.eVx.eOI : this.gLD;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLJ.gLb.getLayoutParams();
            layoutParams.width = this.mViewWidth;
            layoutParams.height = i;
            this.gLJ.gLb.setLayoutParams(layoutParams);
            this.gLJ.gLd.setText(bVar.gAx.getTitle());
            this.gLJ.gKY.startLoad(bVar.gAx.eVx.eOK, 10, false);
            this.gLJ.gLF.setText(bVar.gAx.eVx.main_title);
            this.gLJ.gLG.setText(bVar.gAx.eVx.sub_title);
            this.gLJ.gLG.setVisibility(8);
            this.gLJ.gLO.setText(bVar.gAx.eVx.sub_title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView() && this.gLI.gAx != null && this.gLI.gAx.eVx != null) {
            if (this.gLE != null) {
                this.gLE.a(view, this.gLI);
            }
            GM(this.gLI.gAx.eVx.subpage_link);
            com.baidu.tieba.ala.alasquare.b.a.bVm().mG(true);
        }
    }

    private void GM(String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.url_is_null);
        } else {
            be.bwv().a(this.mTbPageContext, "", new String[]{str}, false, null, true);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public TbImageView gKY;
        public TextView gLF;
        public TextView gLG;
        public LinearLayout gLH;
        public TextView gLK;
        public TextView gLL;
        public LinearLayout gLM;
        public ImageView gLN;
        public TextView gLO;
        public RelativeLayout gLb;
        public TextView gLd;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gKY = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gLF = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.gLG = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.gLH = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.gLb = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gLd = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gLM = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gLK = (TextView) view.findViewById(R.id.lfActiveTitleLabel);
            this.gLL = (TextView) view.findViewById(R.id.rfActiveTitleLabel);
            this.gLN = (ImageView) view.findViewById(R.id.imgNewUserCover);
            this.gLO = (TextView) view.findViewById(R.id.tvNewCount);
            this.gLN.setImageResource(R.drawable.icon_video_tieba);
            this.gLF.setTypeface(Typeface.defaultFromStyle(1));
            this.gKY.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bVP());
        }
    }
}
