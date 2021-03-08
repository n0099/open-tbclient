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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private com.baidu.tieba.ala.alasquare.a.c gLC;
    private a gLD;
    private int gLE;
    private d gLF;
    public int mSkinType;
    private int mViewWidth;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gLE = 0;
        initView();
    }

    private void initView() {
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gLE = (this.mViewWidth * 9) / 16;
        this.gLD = new a(getView());
        getView().setOnClickListener(this);
    }

    public void a(d dVar) {
        this.gLF = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gLD.gLc, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gLD.gLG, R.color.CAM_X0111);
            ap.setViewTextColor(this.gLD.gLH, R.color.CAM_X0111);
            this.gLD.gLH.setAlpha(0.9f);
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
            this.gLC = cVar;
            int i = this.gLC.gAA > 0 ? (this.mViewWidth * this.gLC.gAB) / this.gLC.gAA : this.gLE;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLD.gLc.getLayoutParams();
            layoutParams.width = this.mViewWidth;
            layoutParams.height = i;
            this.gLD.gLc.setLayoutParams(layoutParams);
            this.gLD.gKZ.startLoad(this.gLC.gAz, 10, false);
            this.gLD.gLG.setText(this.gLC.gAy);
            this.gLD.gLH.setText(this.gLC.gAC);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView() && this.gLC != null && !StringUtils.isNull(this.gLC.activity_url)) {
            Gj(this.gLC.activity_url);
        }
    }

    private void Gj(String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.url_is_null);
        } else {
            bf.bsY().a(this.mTbPageContext, "", new String[]{str}, false, null, true);
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public TbImageView gKZ;
        public TextView gLG;
        public TextView gLH;
        public LinearLayout gLI;
        public RelativeLayout gLc;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gKZ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gLG = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.gLH = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.gLI = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.gLc = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gLG.setTypeface(Typeface.defaultFromStyle(1));
            this.gKZ.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bSN());
        }
    }
}
