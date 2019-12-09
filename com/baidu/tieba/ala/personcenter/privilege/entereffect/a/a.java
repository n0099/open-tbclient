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
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0382a> {
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
    /* renamed from: at */
    public C0382a b(ViewGroup viewGroup) {
        return new C0382a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0382a c0382a) {
        c0382a.ezR.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0382a.ezS.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            am.setViewTextColor(c0382a.ezT, R.color.live_cp_other_b, 1, this.mSkinType);
            am.setBackgroundResource(c0382a.ezT, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0382a.ezT.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0382a.ezR.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            am.setViewTextColor(c0382a.ezT, R.color.cp_link_tip_a, 1, this.mSkinType);
            am.setBackgroundResource(c0382a.ezT, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0382a.ezT.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0382a.ezR.setAlpha(1.0f);
        } else {
            am.setViewTextColor(c0382a.ezT, R.color.cp_cont_d, 1, this.mSkinType);
            am.setBackgroundResource(c0382a.ezT, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0382a.ezT.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0382a.ezR.setAlpha(0.7f);
        }
        c0382a.ezU.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.aQ((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0382a.ezV.setVisibility(0);
            c0382a.ezW.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0382a.ezV.setVisibility(8);
            c0382a.ezW.setVisibility(0);
        } else {
            c0382a.ezV.setVisibility(8);
            c0382a.ezW.setVisibility(8);
        }
        c0382a.ezX.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        am.setViewTextColor(c0382a.ezY, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            am.setViewTextColor(c0382a.ezY, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0382a.ezY.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = am.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0382a.ezY.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0382a.ezY.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0382a.ezY.setText(alaEnterEffectData.obtain_way);
            c0382a.ezY.setCompoundDrawables(null, null, null, null);
        }
        a(c0382a);
        return c0382a.getView();
    }

    private void a(C0382a c0382a) {
        if (c0382a != null) {
            am.setBackgroundResource(c0382a.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(c0382a.ezU, R.color.cp_cont_d, 1, this.mSkinType);
            am.setViewTextColor(c0382a.ezS, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0382a.dZJ.setVisibility(0);
            } else {
                c0382a.dZJ.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0382a extends v.a {
        public View dZJ;
        public TbImageView ezR;
        public TextView ezS;
        public TextView ezT;
        public TextView ezU;
        public ImageView ezV;
        public ProgressBar ezW;
        public View ezX;
        public TextView ezY;

        public C0382a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.ezR = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.ezR.setAutoChangeStyle(false);
            this.ezS = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.ezT = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.ezU = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.ezV = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.ezW = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.dZJ = getView().findViewById(R.id.ala_header_cover);
            this.ezX = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.ezY = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
