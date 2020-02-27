package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.R;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public abstract class LoadingLayout extends FrameLayout implements com.baidu.tbadk.widget.pulltorefresh.library.a {
    static final Interpolator bNq = new LinearInterpolator();
    protected final PullToRefreshBase.Mode dMT;
    private FrameLayout dNo;
    private boolean dNp;
    private final TextView dNq;
    private final TextView dNr;
    protected final PullToRefreshBase.Orientation dNs;
    private CharSequence dNt;
    private CharSequence dNu;
    private CharSequence dNv;
    protected final ImageView mHeaderImage;
    protected final ProgressBar mHeaderProgress;

    protected abstract int getDefaultDrawableResId();

    protected abstract void onLoadingDrawableSet(Drawable drawable);

    protected abstract void onPullImpl(float f);

    protected abstract void pullToRefreshImpl();

    protected abstract void refreshingImpl();

    protected abstract void releaseToRefreshImpl();

    protected abstract void resetImpl();

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.dMT = mode;
        this.dNs = orientation;
        switch (orientation) {
            case HORIZONTAL:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(R.layout.tbadkcore_pull_to_refresh_header_vertical, this);
                break;
        }
        this.dNo = (FrameLayout) findViewById(R.id.fl_inner);
        this.dNq = (TextView) this.dNo.findViewById(R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.dNo.findViewById(R.id.pull_to_refresh_progress);
        this.dNr = (TextView) this.dNo.findViewById(R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.dNo.findViewById(R.id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dNo.getLayoutParams();
        switch (mode) {
            case PULL_FROM_END:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.dNt = context.getString(R.string.pull_to_refresh_pull_label);
                this.dNu = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.dNv = context.getString(R.string.pull_to_refresh_release_label);
                break;
            default:
                layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.dNt = context.getString(R.string.pull_to_refresh_pull_label);
                this.dNu = context.getString(R.string.pull_to_refresh_refreshing_label);
                this.dNv = context.getString(R.string.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(18) && (drawable = typedArray.getDrawable(18)) != null) {
            b.setBackground(this, drawable);
        }
        if (typedArray.hasValue(2)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(2, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(11)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(11, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(4) && (colorStateList2 = typedArray.getColorStateList(4)) != null) {
            setTextColor(colorStateList2);
        }
        if (typedArray.hasValue(0) && (colorStateList = typedArray.getColorStateList(0)) != null) {
            setSubTextColor(colorStateList);
        }
        Drawable drawable2 = typedArray.hasValue(14) ? typedArray.getDrawable(14) : null;
        switch (mode) {
            case PULL_FROM_END:
                if (typedArray.hasValue(5)) {
                    drawable2 = typedArray.getDrawable(5);
                    break;
                } else if (typedArray.hasValue(7)) {
                    a.cI("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(7);
                    break;
                }
                break;
            default:
                if (typedArray.hasValue(16)) {
                    drawable2 = typedArray.getDrawable(16);
                    break;
                } else if (typedArray.hasValue(17)) {
                    a.cI("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(17);
                    break;
                }
                break;
        }
        setLoadingDrawable(drawable2 == null ? am.getDrawable(getDefaultDrawableResId()) : drawable2);
        reset();
    }

    public final void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    public final void setWidth(int i) {
        getLayoutParams().width = i;
        requestLayout();
    }

    public final int getContentSize() {
        switch (this.dNs) {
            case HORIZONTAL:
                return this.dNo.getWidth();
            default:
                return this.dNo.getHeight();
        }
    }

    public final void onPull(float f) {
        if (!this.dNp) {
            onPullImpl(f);
        }
    }

    public final void pullToRefresh() {
        if (this.dNq != null) {
            this.dNq.setText(this.dNt);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.dNq != null) {
            this.dNq.setText(this.dNu);
        }
        if (this.dNp) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.dNr != null) {
            this.dNr.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.dNq != null) {
            this.dNq.setText(this.dNv);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.dNq != null) {
            this.dNq.setText(this.dNt);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.dNp) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.dNr != null) {
            if (TextUtils.isEmpty(this.dNr.getText())) {
                this.dNr.setVisibility(8);
            } else {
                this.dNr.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.mHeaderImage.setImageDrawable(drawable);
        this.dNp = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setPullLabel(CharSequence charSequence) {
        this.dNt = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.dNu = charSequence;
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.dNv = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.dNq.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.dNr != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.dNr.setVisibility(8);
                return;
            }
            this.dNr.setText(charSequence);
            if (8 == this.dNr.getVisibility()) {
                this.dNr.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.dNr != null) {
            this.dNr.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.dNr != null) {
            this.dNr.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.dNq != null) {
            this.dNq.setTextAppearance(getContext(), i);
        }
        if (this.dNr != null) {
            this.dNr.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.dNq != null) {
            this.dNq.setTextColor(colorStateList);
        }
        if (this.dNr != null) {
            this.dNr.setTextColor(colorStateList);
        }
    }

    public void setTextColor(int i) {
        if (this.dNq != null) {
            this.dNq.setTextColor(i);
        }
    }

    public void setTextSize(int i) {
        if (this.dNq != null) {
            this.dNq.setTextSize(0, i);
        }
    }
}
