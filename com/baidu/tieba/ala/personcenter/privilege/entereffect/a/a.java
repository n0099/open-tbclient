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
import com.baidu.adp.widget.ListView.af;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<AlaEnterEffectData, C0689a> {
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
    /* renamed from: aO */
    public C0689a c(ViewGroup viewGroup) {
        return new C0689a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_item_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, AlaEnterEffectData alaEnterEffectData, C0689a c0689a) {
        c0689a.hBc.startLoad(alaEnterEffectData.thumbnail_url, 10, false);
        c0689a.hBd.setText(alaEnterEffectData.name);
        if (alaEnterEffectData.isUsing()) {
            ap.setViewTextColor(c0689a.hBe, R.color.live_cp_other_b, 1, this.mSkinType);
            ap.setBackgroundResource(c0689a.hBe, R.drawable.ala_enter_effect_use_bg, this.mSkinType);
            c0689a.hBe.setText(this.mContext.getString(R.string.ala_enter_effect_use));
            c0689a.hBc.setAlpha(1.0f);
        } else if (alaEnterEffectData.isOwn) {
            ap.setViewTextColor(c0689a.hBe, R.color.cp_link_tip_a, 1, this.mSkinType);
            ap.setBackgroundResource(c0689a.hBe, R.drawable.ala_enter_effect_own_bg, this.mSkinType);
            c0689a.hBe.setText(this.mContext.getString(R.string.ala_enter_effect_own));
            c0689a.hBc.setAlpha(1.0f);
        } else {
            ap.setViewTextColor(c0689a.hBe, R.color.cp_cont_d, 1, this.mSkinType);
            ap.setBackgroundResource(c0689a.hBe, R.drawable.ala_enter_effect_not_own_bg, this.mSkinType);
            c0689a.hBe.setText(this.mContext.getString(R.string.ala_enter_effect_not_own));
            c0689a.hBc.setAlpha(0.7f);
        }
        c0689a.hBf.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.cW((alaEnterEffectData.end_time * 1000) - System.currentTimeMillis())));
        if (alaEnterEffectData.downLoadStatus == 100) {
            c0689a.hBg.setVisibility(0);
            c0689a.gwa.setVisibility(8);
        } else if (alaEnterEffectData.downLoadStatus == 102) {
            c0689a.hBg.setVisibility(8);
            c0689a.gwa.setVisibility(0);
        } else {
            c0689a.hBg.setVisibility(8);
            c0689a.gwa.setVisibility(8);
        }
        c0689a.hBh.setBackgroundColor(Color.parseColor(alaEnterEffectData.color));
        ap.setViewTextColor(c0689a.eNh, R.color.cp_cont_d, 1, this.mSkinType);
        if (2 == alaEnterEffectData.categoryType) {
            ap.setViewTextColor(c0689a.eNh, R.color.cp_link_tip_d, 1, this.mSkinType);
            c0689a.eNh.setText(this.mContext.getString(R.string.ala_enter_effect_tdou_des, AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price), alaEnterEffectData.time));
            Drawable drawable = ap.getDrawable(R.drawable.icon_huobi_tdou);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c0689a.eNh.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
            c0689a.eNh.setCompoundDrawables(drawable, null, null, null);
        } else {
            c0689a.eNh.setText(alaEnterEffectData.obtain_way);
            c0689a.eNh.setCompoundDrawables(null, null, null, null);
        }
        a(c0689a);
        return c0689a.getView();
    }

    private void a(C0689a c0689a) {
        if (c0689a != null) {
            ap.setBackgroundResource(c0689a.getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(c0689a.hBf, R.color.cp_cont_d, 1, this.mSkinType);
            ap.setViewTextColor(c0689a.hBd, R.color.cp_cont_b, 1, this.mSkinType);
            if (this.mSkinType == 1) {
                c0689a.gVf.setVisibility(0);
            } else {
                c0689a.gVf.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0689a extends af.a {
        public TextView eNh;
        public View gVf;
        public ProgressBar gwa;
        public TbImageView hBc;
        public TextView hBd;
        public TextView hBe;
        public TextView hBf;
        public ImageView hBg;
        public View hBh;

        public C0689a(View view) {
            super(view);
            initView();
        }

        private void initView() {
            this.hBc = (TbImageView) getView().findViewById(R.id.ala_enter_effect_img);
            this.hBc.setAutoChangeStyle(false);
            this.hBd = (TextView) getView().findViewById(R.id.ala_enter_effect_name);
            this.hBe = (TextView) getView().findViewById(R.id.ala_enter_effect_status);
            this.hBf = (TextView) getView().findViewById(R.id.ala_enter_effect_time_limit);
            this.hBg = (ImageView) getView().findViewById(R.id.ala_enter_effect_download_img);
            this.gwa = (ProgressBar) getView().findViewById(R.id.ala_enter_effect_loading);
            this.gVf = getView().findViewById(R.id.ala_header_cover);
            this.hBh = getView().findViewById(R.id.ala_enter_effect_img_layout);
            this.eNh = (TextView) getView().findViewById(R.id.ala_enter_effect_description);
        }
    }
}
