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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private com.baidu.tieba.ala.alasquare.a.c gGV;
    private a gGW;
    private int gGX;
    private d gGY;
    public int mSkinType;
    private int mViewWidth;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gGX = 0;
        initView();
    }

    private void initView() {
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gGX = (this.mViewWidth * 9) / 16;
        this.gGW = new a(getView());
        getView().setOnClickListener(this);
    }

    public void a(d dVar) {
        this.gGY = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gGW.gGv, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gGW.gGZ, R.color.CAM_X0111);
            ao.setViewTextColor(this.gGW.gHa, R.color.CAM_X0111);
            this.gGW.gHa.setAlpha(0.9f);
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
            this.gGV = cVar;
            int i = this.gGV.gvT > 0 ? (this.mViewWidth * this.gGV.gvU) / this.gGV.gvT : this.gGX;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGW.gGv.getLayoutParams();
            layoutParams.width = this.mViewWidth;
            layoutParams.height = i;
            this.gGW.gGv.setLayoutParams(layoutParams);
            this.gGW.gGs.startLoad(this.gGV.gvS, 10, false);
            this.gGW.gGZ.setText(this.gGV.gvR);
            this.gGW.gHa.setText(this.gGV.gvV);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView() && this.gGV != null && !StringUtils.isNull(this.gGV.activity_url)) {
            FB(this.gGV.activity_url);
        }
    }

    private void FB(String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.url_is_null);
        } else {
            be.bsB().a(this.mTbPageContext, "", new String[]{str}, false, null, true);
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public TextView gGZ;
        public TbImageView gGs;
        public RelativeLayout gGv;
        public TextView gHa;
        public LinearLayout gHb;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gGs = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gGZ = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.gHa = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.gHb = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.gGv = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gGZ.setTypeface(Typeface.defaultFromStyle(1));
            this.gGs.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bRX());
        }
    }
}
