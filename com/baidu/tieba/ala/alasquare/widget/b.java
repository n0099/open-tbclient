package com.baidu.tieba.ala.alasquare.widget;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private com.baidu.tieba.ala.alasquare.a.c gLB;
    private a gLC;
    private int gLD;
    private d gLE;
    public int mSkinType;
    private int mViewWidth;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gLD = 0;
        initView();
    }

    private void initView() {
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gLD = (this.mViewWidth * 9) / 16;
        this.gLC = new a(getView());
        getView().setOnClickListener(this);
    }

    public void a(d dVar) {
        this.gLE = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gLC.gLb, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gLC.gLF, R.color.CAM_X0111);
            ao.setViewTextColor(this.gLC.gLG, R.color.CAM_X0111);
            this.gLC.gLG.setAlpha(0.9f);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_active_all_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar != null) {
            this.gLB = cVar;
            int i = this.gLB.gAA > 0 ? (this.mViewWidth * this.gLB.gAB) / this.gLB.gAA : this.gLD;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLC.gLb.getLayoutParams();
            layoutParams.width = this.mViewWidth;
            layoutParams.height = i;
            this.gLC.gLb.setLayoutParams(layoutParams);
            this.gLC.gKY.startLoad(this.gLB.gAz, 10, false);
            this.gLC.gLF.setText(this.gLB.gAy);
            this.gLC.gLG.setText(this.gLB.gAC);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView() && this.gLB != null && !StringUtils.isNull(this.gLB.activity_url)) {
            GM(this.gLB.activity_url);
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
        public RelativeLayout gLb;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gKY = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gLF = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.gLG = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.gLH = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.gLb = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gLF.setTypeface(Typeface.defaultFromStyle(1));
            this.gKY.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bVP());
        }
    }
}
