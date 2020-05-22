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
import com.baidu.adp.widget.ListView.aa;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0590a> {
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
    /* renamed from: aH */
    public C0590a b(ViewGroup viewGroup) {
        return new C0590a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0590a c0590a) {
        c0590a.grv.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0590a.grw.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            am.setViewTextColor(c0590a.grx, R.color.live_cp_other_b, 1, this.mSkinType);
            am.setBackgroundResource(c0590a.grx, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0590a.grx.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0590a.grv.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            am.setViewTextColor(c0590a.grx, R.color.cp_link_tip_a, 1, this.mSkinType);
            am.setBackgroundResource(c0590a.grx, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0590a.grx.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0590a.grv.setAlpha(1.0f);
        } else {
            am.setViewTextColor(c0590a.grx, R.color.cp_cont_d, 1, this.mSkinType);
            am.setBackgroundResource(c0590a.grx, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0590a.grx.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0590a.grv.setAlpha(0.7f);
        }
        c0590a.gry.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.ci((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0590a.grz.setVisibility(0);
            c0590a.grA.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0590a.grz.setVisibility(8);
            c0590a.grA.setVisibility(0);
        } else {
            c0590a.grz.setVisibility(8);
            c0590a.grA.setVisibility(8);
        }
        c0590a.grB.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        am.setViewTextColor(c0590a.grC, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            am.setViewTextColor(c0590a.grC, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0590a.grC.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = am.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0590a.grC.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0590a.grC.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0590a.grC.setText(alaEnterEffectData.obtain_way);
            c0590a.grC.setCompoundDrawables(null, null, null, null);
        }
        a(c0590a);
        return c0590a.getView();
    }

    private void a(C0590a c0590a) {
        if (c0590a != null) {
            am.setBackgroundResource(c0590a.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(c0590a.gry, R.color.cp_cont_d, 1, this.mSkinType);
            am.setViewTextColor(c0590a.grw, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0590a.fOe.setVisibility(0);
            } else {
                c0590a.fOe.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0590a extends aa.a {
        public View fOe;
        public ProgressBar grA;
        public View grB;
        public TextView grC;
        public TbImageView grv;
        public TextView grw;
        public TextView grx;
        public TextView gry;
        public ImageView grz;

        public C0590a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.grv = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.grv.setAutoChangeStyle(false);
            this.grw = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.grx = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.gry = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.grz = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.grA = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.fOe = getView().findViewById(R.id.ala_header_cover);
            this.grB = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.grC = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
