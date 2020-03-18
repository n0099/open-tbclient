package com.baidu.tieba.ala.personcenter.privilege.entereffect.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0483a> {
    private Context mContext;
    private int mSkinType;

    public a(Context context) {
        super(context, AlaEnterEffectData.TYPE_ENTER_EFFECT_DATA);
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public C0483a b(ViewGroup viewGroup) {
        return new C0483a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0483a c0483a) {
        c0483a.fxW.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0483a.fxX.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            am.setViewTextColor(c0483a.fxY, R.color.live_cp_other_b, 1, this.mSkinType);
            am.setBackgroundResource(c0483a.fxY, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0483a.fxY.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0483a.fxW.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            am.setViewTextColor(c0483a.fxY, R.color.cp_link_tip_a, 1, this.mSkinType);
            am.setBackgroundResource(c0483a.fxY, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0483a.fxY.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0483a.fxW.setAlpha(1.0f);
        } else {
            am.setViewTextColor(c0483a.fxY, R.color.cp_cont_d, 1, this.mSkinType);
            am.setBackgroundResource(c0483a.fxY, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0483a.fxY.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0483a.fxW.setAlpha(0.7f);
        }
        c0483a.fxZ.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.bC((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0483a.fya.setVisibility(0);
            c0483a.fyb.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0483a.fya.setVisibility(8);
            c0483a.fyb.setVisibility(0);
        } else {
            c0483a.fya.setVisibility(8);
            c0483a.fyb.setVisibility(8);
        }
        c0483a.fyc.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        am.setViewTextColor(c0483a.fyd, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            am.setViewTextColor(c0483a.fyd, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0483a.fyd.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = am.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0483a.fyd.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0483a.fyd.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0483a.fyd.setText(alaEnterEffectData.obtain_way);
            c0483a.fyd.setCompoundDrawables(null, null, null, null);
        }
        a(c0483a);
        return c0483a.getView();
    }

    private void a(C0483a c0483a) {
        if (c0483a != null) {
            am.setBackgroundResource(c0483a.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(c0483a.fxZ, R.color.cp_cont_d, 1, this.mSkinType);
            am.setViewTextColor(c0483a.fxX, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0483a.eVI.setVisibility(0);
            } else {
                c0483a.eVI.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0483a extends v.a {
        public View eVI;
        public TbImageView fxW;
        public TextView fxX;
        public TextView fxY;
        public TextView fxZ;
        public ImageView fya;
        public ProgressBar fyb;
        public View fyc;
        public TextView fyd;

        public C0483a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.fxW = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.fxW.setAutoChangeStyle(false);
            this.fxX = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.fxY = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.fxZ = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.fya = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.fyb = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.eVI = getView().findViewById(R.id.ala_header_cover);
            this.fyc = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.fyd = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
