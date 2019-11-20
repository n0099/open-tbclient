package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.d;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.b;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes6.dex */
public class AlaEffectPreviewView extends LinearLayout {
    private TextView aLN;
    private int abh;
    private LinearLayout dTz;
    private b.a ezk;
    private ObjectAnimator ezl;
    private ImageView ezm;
    private ImageView mIconView;
    private View mRootView;
    private int mScreenWidth;

    public AlaEffectPreviewView(Context context) {
        super(context);
        initView();
    }

    public AlaEffectPreviewView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public AlaEffectPreviewView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.mRootView = inflate(getContext(), R.layout.ala_enter_effect_preview_view, this);
        this.mIconView = (ImageView) findViewById(R.id.ala_im_user_enter_icon_view);
        this.aLN = (TextView) findViewById(R.id.ala_im_user_enter_content);
        this.dTz = (LinearLayout) findViewById(R.id.ala_enter_effect_content_layout);
        this.ezm = (ImageView) findViewById(R.id.ala_im_user_enter_tail);
    }

    public void setAnimCompleteCallback(b.a aVar) {
        this.ezk = aVar;
    }

    public void setData(AlaEnterEffectData alaEnterEffectData) {
        GradientDrawable gradientDrawable;
        if (alaEnterEffectData != null) {
            String str = alaEnterEffectData.content_first;
            String str2 = alaEnterEffectData.content_last;
            String currentAccountNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
            if (StringUtils.isNull(currentAccountNameShow)) {
                currentAccountNameShow = "";
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (StringUtils.isNull(str) && StringUtils.isNull(str2)) {
                spannableStringBuilder.append((CharSequence) currentAccountNameShow);
                spannableStringBuilder.append((CharSequence) SpannableString.valueOf(getResources().getString(R.string.ala_contribute_rank_enter_suffix)));
            } else {
                if (!StringUtils.isNull(str)) {
                    spannableStringBuilder.append((CharSequence) SpannableString.valueOf(str + HanziToPinyin.Token.SEPARATOR));
                }
                spannableStringBuilder.append((CharSequence) currentAccountNameShow);
                if (!StringUtils.isNull(str2)) {
                    spannableStringBuilder.append((CharSequence) SpannableString.valueOf(HanziToPinyin.Token.SEPARATOR + str2));
                }
            }
            String str3 = alaEnterEffectData.icon_url;
            if (StringUtils.isNull(str3)) {
                this.mIconView.setVisibility(8);
            } else {
                this.mIconView.setVisibility(0);
                c.fT().a(str3, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEffectPreviewView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                        Bitmap rawBitmap;
                        Bitmap copy;
                        Bitmap copy2;
                        super.onLoaded((AnonymousClass1) aVar, str4, i);
                        if (aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
                            try {
                                if (rawBitmap.getConfig() == null) {
                                    copy2 = rawBitmap.copy(Bitmap.Config.ARGB_8888, false);
                                } else {
                                    copy2 = rawBitmap.copy(rawBitmap.getConfig(), false);
                                }
                                copy = copy2;
                            } catch (OutOfMemoryError e) {
                                BdLog.e(e);
                                if (rawBitmap.getConfig() == null) {
                                    try {
                                        copy = rawBitmap.copy(Bitmap.Config.RGB_565, false);
                                    } catch (OutOfMemoryError e2) {
                                        BdLog.e(e2);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (copy != null) {
                                try {
                                    Bitmap resizeBitmap = d.gW().resizeBitmap(copy, l.getEquipmentWidth(AlaEffectPreviewView.this.getContext()), AlaEffectPreviewView.this.getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
                                    if (resizeBitmap != copy) {
                                        copy.recycle();
                                    }
                                    AlaEffectPreviewView.this.mIconView.setImageBitmap(resizeBitmap);
                                } catch (OutOfMemoryError e3) {
                                    BdLog.e(e3);
                                    if (copy != null) {
                                        copy.recycle();
                                    }
                                }
                            }
                        }
                    }
                }, null);
            }
            this.aLN.setText(spannableStringBuilder);
            String str4 = alaEnterEffectData.color;
            if (StringUtils.isNull(str4)) {
                str4 = "#B2FF5460";
            }
            try {
                if (!TextUtils.isEmpty(alaEnterEffectData.startColor) && !TextUtils.isEmpty(alaEnterEffectData.endColor)) {
                    gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(alaEnterEffectData.startColor), Color.parseColor(alaEnterEffectData.endColor)});
                } else {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setColor(Color.parseColor(str4));
                    gradientDrawable = gradientDrawable2;
                }
                if (!TextUtils.isEmpty(alaEnterEffectData.strokeColor)) {
                    gradientDrawable.setStroke(1, Color.parseColor(alaEnterEffectData.strokeColor));
                }
            } catch (IllegalArgumentException e) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(-1291889568);
            }
            gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds10));
            this.dTz.setBackgroundDrawable(gradientDrawable);
            if (3 == alaEnterEffectData.categoryType) {
                this.ezm.setVisibility(0);
            }
        }
    }

    public void aXY() {
        if (getMeasuredWidth() <= 0) {
            measure(0, 0);
        }
        this.mScreenWidth = l.getEquipmentWidth(getContext());
        this.abh = (this.mScreenWidth - getMeasuredWidth()) / 2;
        this.ezl = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        this.ezl.setDuration(3500L);
        this.ezl.setInterpolator(new TimeInterpolator() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEffectPreviewView.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        });
        this.ezl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEffectPreviewView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AlaEffectPreviewView.this.ezk != null) {
                    AlaEffectPreviewView.this.ezk.aYa();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ezl.setEvaluator(new a());
        this.ezl.start();
    }

    public void onDestory() {
        if (this.ezl != null) {
            this.ezl.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends FloatEvaluator {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.animation.TypeEvaluator
        public Float evaluate(float f, Number number, Number number2) {
            float f2;
            float f3 = f * 3500.0f;
            if (f3 <= 500.0f) {
                f2 = (((f3 / 500.0f) - 1.0f) * AlaEffectPreviewView.this.mScreenWidth) + AlaEffectPreviewView.this.abh;
            } else if (3500.0f - f3 > 500.0f) {
                f2 = AlaEffectPreviewView.this.abh;
            } else {
                f2 = ((1.0f - ((3500.0f - f3) / 500.0f)) * AlaEffectPreviewView.this.mScreenWidth) + AlaEffectPreviewView.this.abh;
            }
            return Float.valueOf(f2);
        }
    }
}
