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
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.b> {
    private int gGX;
    private d gGY;
    private com.baidu.tieba.ala.alasquare.a.b gHc;
    private a gHd;
    public int mSkinType;
    private int mViewWidth;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gGX = 0;
        initView();
    }

    private void initView() {
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gGX = (this.mViewWidth * 9) / 16;
        this.gHd = new a(getView());
        getView().setOnClickListener(this);
    }

    public void a(d dVar) {
        this.gGY = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gHd.gGv, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gHd.gGx, R.color.CAM_X0105);
            ao.setViewTextColor(this.gHd.gGZ, R.color.CAM_X0111);
            ao.setViewTextColor(this.gHd.gHa, R.color.CAM_X0111);
            this.gHd.gHa.setAlpha(0.9f);
            ao.setViewTextColor(this.gHd.gHe, R.color.live_cp_other_b);
            ao.setViewTextColor(this.gHd.gHf, R.color.live_cp_other_b);
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
        if (bVar != null && bVar.gvQ != null) {
            this.gHc = bVar;
            int i = bVar.gvQ.eQM.eJX > 0 ? (this.mViewWidth * bVar.gvQ.eQM.eJY) / bVar.gvQ.eQM.eJX : this.gGX;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gHd.gGv.getLayoutParams();
            layoutParams.width = this.mViewWidth;
            layoutParams.height = i;
            this.gHd.gGv.setLayoutParams(layoutParams);
            this.gHd.gGx.setText(bVar.gvQ.getTitle());
            this.gHd.gGs.startLoad(bVar.gvQ.eQM.eJZ, 10, false);
            this.gHd.gGZ.setText(bVar.gvQ.eQM.main_title);
            this.gHd.gHa.setText(bVar.gvQ.eQM.sub_title);
            this.gHd.gHa.setVisibility(8);
            this.gHd.gHi.setText(bVar.gvQ.eQM.sub_title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView() && this.gHc.gvQ != null && this.gHc.gvQ.eQM != null) {
            if (this.gGY != null) {
                this.gGY.a(view, this.gHc);
            }
            FB(this.gHc.gvQ.eQM.subpage_link);
            com.baidu.tieba.ala.alasquare.b.a.bRu().mC(true);
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
        public TextView gGx;
        public TextView gHa;
        public LinearLayout gHb;
        public TextView gHe;
        public TextView gHf;
        public LinearLayout gHg;
        public ImageView gHh;
        public TextView gHi;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gGs = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gGZ = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.gHa = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.gHb = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.gGv = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gGx = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gHg = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gHe = (TextView) view.findViewById(R.id.lfActiveTitleLabel);
            this.gHf = (TextView) view.findViewById(R.id.rfActiveTitleLabel);
            this.gHh = (ImageView) view.findViewById(R.id.imgNewUserCover);
            this.gHi = (TextView) view.findViewById(R.id.tvNewCount);
            this.gHh.setImageResource(R.drawable.icon_video_tieba);
            this.gGZ.setTypeface(Typeface.defaultFromStyle(1));
            this.gGs.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bRX());
        }
    }
}
