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
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private com.baidu.tieba.ala.alasquare.a.c gJT;
    private a gJU;
    private int gJV;
    private d gJW;
    public int mSkinType;
    private int mViewWidth;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gJV = 0;
        initView();
    }

    private void initView() {
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gJV = (this.mViewWidth * 9) / 16;
        this.gJU = new a(getView());
        getView().setOnClickListener(this);
    }

    public void a(d dVar) {
        this.gJW = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gJU.gJt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gJU.gJX, R.color.CAM_X0111);
            ap.setViewTextColor(this.gJU.gJY, R.color.CAM_X0111);
            this.gJU.gJY.setAlpha(0.9f);
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
            this.gJT = cVar;
            int i = this.gJT.gyR > 0 ? (this.mViewWidth * this.gJT.gyS) / this.gJT.gyR : this.gJV;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJU.gJt.getLayoutParams();
            layoutParams.width = this.mViewWidth;
            layoutParams.height = i;
            this.gJU.gJt.setLayoutParams(layoutParams);
            this.gJU.gJq.startLoad(this.gJT.gyQ, 10, false);
            this.gJU.gJX.setText(this.gJT.gyP);
            this.gJU.gJY.setText(this.gJT.gyT);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView() && this.gJT != null && !StringUtils.isNull(this.gJT.activity_url)) {
            Ga(this.gJT.activity_url);
        }
    }

    private void Ga(String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.url_is_null);
        } else {
            bf.bsV().a(this.mTbPageContext, "", new String[]{str}, false, null, true);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public TextView gJX;
        public TextView gJY;
        public LinearLayout gJZ;
        public TbImageView gJq;
        public RelativeLayout gJt;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gJq = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gJX = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.gJY = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.gJZ = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.gJt = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gJX.setTypeface(Typeface.defaultFromStyle(1));
            this.gJq.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bSH());
        }
    }
}
