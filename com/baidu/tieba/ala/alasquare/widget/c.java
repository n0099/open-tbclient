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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.b> {
    private int gJV;
    private d gJW;
    private com.baidu.tieba.ala.alasquare.a.b gKa;
    private a gKb;
    public int mSkinType;
    private int mViewWidth;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gJV = 0;
        initView();
    }

    private void initView() {
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gJV = (this.mViewWidth * 9) / 16;
        this.gKb = new a(getView());
        getView().setOnClickListener(this);
    }

    public void a(d dVar) {
        this.gJW = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gKb.gJt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gKb.gJv, R.color.CAM_X0105);
            ap.setViewTextColor(this.gKb.gJX, R.color.CAM_X0111);
            ap.setViewTextColor(this.gKb.gJY, R.color.CAM_X0111);
            this.gKb.gJY.setAlpha(0.9f);
            ap.setViewTextColor(this.gKb.gKc, R.color.live_cp_other_b);
            ap.setViewTextColor(this.gKb.gKd, R.color.live_cp_other_b);
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
        if (bVar != null && bVar.gyO != null) {
            this.gKa = bVar;
            int i = bVar.gyO.eSY.eMj > 0 ? (this.mViewWidth * bVar.gyO.eSY.eMk) / bVar.gyO.eSY.eMj : this.gJV;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gKb.gJt.getLayoutParams();
            layoutParams.width = this.mViewWidth;
            layoutParams.height = i;
            this.gKb.gJt.setLayoutParams(layoutParams);
            this.gKb.gJv.setText(bVar.gyO.getTitle());
            this.gKb.gJq.startLoad(bVar.gyO.eSY.eMl, 10, false);
            this.gKb.gJX.setText(bVar.gyO.eSY.main_title);
            this.gKb.gJY.setText(bVar.gyO.eSY.sub_title);
            this.gKb.gJY.setVisibility(8);
            this.gKb.gKg.setText(bVar.gyO.eSY.sub_title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView() && this.gKa.gyO != null && this.gKa.gyO.eSY != null) {
            if (this.gJW != null) {
                this.gJW.a(view, this.gKa);
            }
            Ga(this.gKa.gyO.eSY.subpage_link);
            com.baidu.tieba.ala.alasquare.b.a.bSe().mG(true);
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
        public TextView gJv;
        public TextView gKc;
        public TextView gKd;
        public LinearLayout gKe;
        public ImageView gKf;
        public TextView gKg;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gJq = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gJX = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.gJY = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.gJZ = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.gJt = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gJv = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gKe = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gKc = (TextView) view.findViewById(R.id.lfActiveTitleLabel);
            this.gKd = (TextView) view.findViewById(R.id.rfActiveTitleLabel);
            this.gKf = (ImageView) view.findViewById(R.id.imgNewUserCover);
            this.gKg = (TextView) view.findViewById(R.id.tvNewCount);
            this.gKf.setImageResource(R.drawable.icon_video_tieba);
            this.gJX.setTypeface(Typeface.defaultFromStyle(1));
            this.gJq.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bSH());
        }
    }
}
