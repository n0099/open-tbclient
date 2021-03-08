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
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.b> {
    private int gLE;
    private d gLF;
    private com.baidu.tieba.ala.alasquare.a.b gLJ;
    private a gLK;
    public int mSkinType;
    private int mViewWidth;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gLE = 0;
        initView();
    }

    private void initView() {
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gLE = (this.mViewWidth * 9) / 16;
        this.gLK = new a(getView());
        getView().setOnClickListener(this);
    }

    public void a(d dVar) {
        this.gLF = dVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gLK.gLc, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gLK.gLe, R.color.CAM_X0105);
            ap.setViewTextColor(this.gLK.gLG, R.color.CAM_X0111);
            ap.setViewTextColor(this.gLK.gLH, R.color.CAM_X0111);
            this.gLK.gLH.setAlpha(0.9f);
            ap.setViewTextColor(this.gLK.gLL, R.color.live_cp_other_b);
            ap.setViewTextColor(this.gLK.gLM, R.color.live_cp_other_b);
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
            this.gLJ = bVar;
            int i = bVar.gAx.eUz.eNK > 0 ? (this.mViewWidth * bVar.gAx.eUz.eNL) / bVar.gAx.eUz.eNK : this.gLE;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLK.gLc.getLayoutParams();
            layoutParams.width = this.mViewWidth;
            layoutParams.height = i;
            this.gLK.gLc.setLayoutParams(layoutParams);
            this.gLK.gLe.setText(bVar.gAx.getTitle());
            this.gLK.gKZ.startLoad(bVar.gAx.eUz.eNM, 10, false);
            this.gLK.gLG.setText(bVar.gAx.eUz.main_title);
            this.gLK.gLH.setText(bVar.gAx.eUz.sub_title);
            this.gLK.gLH.setVisibility(8);
            this.gLK.gLP.setText(bVar.gAx.eUz.sub_title);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView() && this.gLJ.gAx != null && this.gLJ.gAx.eUz != null) {
            if (this.gLF != null) {
                this.gLF.a(view, this.gLJ);
            }
            Gj(this.gLJ.gAx.eUz.subpage_link);
            com.baidu.tieba.ala.alasquare.b.a.bSk().mG(true);
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
        public TextView gLL;
        public TextView gLM;
        public LinearLayout gLN;
        public ImageView gLO;
        public TextView gLP;
        public RelativeLayout gLc;
        public TextView gLe;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gKZ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gLG = (TextView) view.findViewById(R.id.tvActiveTitle);
            this.gLH = (TextView) view.findViewById(R.id.tvActiveSubTitle);
            this.gLI = (LinearLayout) view.findViewById(R.id.llActiveInfoPanel);
            this.gLc = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gLe = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gLN = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gLL = (TextView) view.findViewById(R.id.lfActiveTitleLabel);
            this.gLM = (TextView) view.findViewById(R.id.rfActiveTitleLabel);
            this.gLO = (ImageView) view.findViewById(R.id.imgNewUserCover);
            this.gLP = (TextView) view.findViewById(R.id.tvNewCount);
            this.gLO.setImageResource(R.drawable.icon_video_tieba);
            this.gLG.setTypeface(Typeface.defaultFromStyle(1));
            this.gKZ.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bSN());
        }
    }
}
