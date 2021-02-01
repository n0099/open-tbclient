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
    private int gJH;
    private d gJI;
    private com.baidu.tieba.ala.alasquare.a.b gJM;
    private a gJN;
    public int mSkinType;
    private int mViewWidth;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gJH = 0;
        initView();
    }

    private void initView() {
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gJH = (this.mViewWidth * 9) / 16;
        this.gJN = new a(getView());
        getView().setOnClickListener(this);
    }

    public void a(d dVar) {
        this.gJI = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gJN.gJf, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gJN.gJh, R.color.CAM_X0105);
            ap.setViewTextColor(this.gJN.gJJ, R.color.CAM_X0111);
            ap.setViewTextColor(this.gJN.gJK, R.color.CAM_X0111);
            this.gJN.gJK.setAlpha(0.9f);
            ap.setViewTextColor(this.gJN.gJO, R.color.live_cp_other_b);
            ap.setViewTextColor(this.gJN.gJP, R.color.live_cp_other_b);
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
        if (bVar != null && bVar.gyA != null) {
            this.gJM = bVar;
            int i = bVar.gyA.eSY.eMj > 0 ? (this.mViewWidth * bVar.gyA.eSY.eMk) / bVar.gyA.eSY.eMj : this.gJH;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJN.gJf.getLayoutParams();
            layoutParams.width = this.mViewWidth;
            layoutParams.height = i;
            this.gJN.gJf.setLayoutParams(layoutParams);
            this.gJN.gJh.setText(bVar.gyA.getTitle());
            this.gJN.gJc.startLoad(bVar.gyA.eSY.eMl, 10, false);
            this.gJN.gJJ.setText(bVar.gyA.eSY.main_title);
            this.gJN.gJK.setText(bVar.gyA.eSY.sub_title);
            this.gJN.gJK.setVisibility(8);
            this.gJN.gJS.setText(bVar.gyA.eSY.sub_title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView() && this.gJM.gyA != null && this.gJM.gyA.eSY != null) {
            if (this.gJI != null) {
                this.gJI.a(view, this.gJM);
            }
            FZ(this.gJM.gyA.eSY.subpage_link);
            com.baidu.tieba.ala.alasquare.b.a.bRX().mG(true);
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
        public TextView gJO;
        public TextView gJP;
        public LinearLayout gJQ;
        public ImageView gJR;
        public TextView gJS;
        public TbImageView gJc;
        public RelativeLayout gJf;
        public TextView gJh;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gJc = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gJJ = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.gJK = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.gJL = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.gJf = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gJh = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gJQ = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gJO = (TextView) view.findViewById(R.id.lfActiveTitleLabel);
            this.gJP = (TextView) view.findViewById(R.id.rfActiveTitleLabel);
            this.gJR = (ImageView) view.findViewById(R.id.imgNewUserCover);
            this.gJS = (TextView) view.findViewById(R.id.tvNewCount);
            this.gJR.setImageResource(R.drawable.icon_video_tieba);
            this.gJJ.setTypeface(Typeface.defaultFromStyle(1));
            this.gJc.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bSA());
        }
    }
}
