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
    private com.baidu.tieba.ala.alasquare.a.c gJF;
    private a gJG;
    private int gJH;
    private d gJI;
    public int mSkinType;
    private int mViewWidth;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gJH = 0;
        initView();
    }

    private void initView() {
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gJH = (this.mViewWidth * 9) / 16;
        this.gJG = new a(getView());
        getView().setOnClickListener(this);
    }

    public void a(d dVar) {
        this.gJI = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gJG.gJf, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gJG.gJJ, R.color.CAM_X0111);
            ap.setViewTextColor(this.gJG.gJK, R.color.CAM_X0111);
            this.gJG.gJK.setAlpha(0.9f);
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
            this.gJF = cVar;
            int i = this.gJF.gyD > 0 ? (this.mViewWidth * this.gJF.gyE) / this.gJF.gyD : this.gJH;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJG.gJf.getLayoutParams();
            layoutParams.width = this.mViewWidth;
            layoutParams.height = i;
            this.gJG.gJf.setLayoutParams(layoutParams);
            this.gJG.gJc.startLoad(this.gJF.gyC, 10, false);
            this.gJG.gJJ.setText(this.gJF.gyB);
            this.gJG.gJK.setText(this.gJF.gyF);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView() && this.gJF != null && !StringUtils.isNull(this.gJF.activity_url)) {
            FZ(this.gJF.activity_url);
        }
    }

    private void FZ(String str) {
        if (TextUtils.isEmpty(str)) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.url_is_null);
        } else {
            bf.bsV().a(this.mTbPageContext, "", new String[]{str}, false, null, true);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public TextView gJJ;
        public TextView gJK;
        public LinearLayout gJL;
        public TbImageView gJc;
        public RelativeLayout gJf;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gJc = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gJJ = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.gJK = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.gJL = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.gJf = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gJJ.setTypeface(Typeface.defaultFromStyle(1));
            this.gJc.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bSA());
        }
    }
}
