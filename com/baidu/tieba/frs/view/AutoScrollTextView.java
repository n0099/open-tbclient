package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AutoScrollTextView extends TextView implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public float f16716e;

    /* renamed from: f  reason: collision with root package name */
    public float f16717f;

    /* renamed from: g  reason: collision with root package name */
    public float f16718g;

    /* renamed from: h  reason: collision with root package name */
    public float f16719h;
    public float i;
    public boolean j;
    public Paint k;
    public String l;
    public View.OnClickListener m;
    public float n;

    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean isStarting;
        public float step;

        /* loaded from: classes4.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBooleanArray(new boolean[]{this.isStarting});
            parcel.writeFloat(this.step);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.isStarting = false;
            this.step = 0.0f;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.isStarting = false;
            this.step = 0.0f;
            parcel.readBooleanArray(null);
            this.step = parcel.readFloat();
        }
    }

    public AutoScrollTextView(Context context) {
        super(context);
        this.f16716e = 0.0f;
        this.f16717f = 0.0f;
        this.f16718g = 0.0f;
        this.f16719h = 0.0f;
        this.i = 0.0f;
        this.j = false;
        this.k = null;
        this.l = "";
        b();
    }

    public void a(WindowManager windowManager) {
        TextPaint paint = getPaint();
        this.k = paint;
        paint.setColor(-1);
        String charSequence = getText().toString();
        this.l = charSequence;
        this.f16716e = this.k.measureText(charSequence);
        float width = getWidth();
        this.f16717f = width;
        if (width == 0.0f && windowManager != null) {
            this.f16717f = windowManager.getDefaultDisplay().getWidth();
        }
        float f2 = this.f16716e;
        this.f16718g = f2;
        this.f16719h = f2;
        this.i = f2 * 2.0f;
        getTextSize();
    }

    public final void b() {
        setOnClickListener(this);
    }

    public void c() {
        this.j = true;
        invalidate();
    }

    public void d(float f2) {
        this.n = f2;
        setWidth((int) ((f2 - 0.5f) * 3000.0f));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.j) {
            float f2 = this.n;
            if (f2 > 0.5f) {
                setWidth((int) ((f2 - 0.5f) * 3000.0f));
                canvas.drawText(this.l, this.f16719h - this.f16718g, getTextSize() + 2.7f, this.k);
                return;
            }
            return;
        }
        canvas.drawText(this.l, this.f16719h - this.f16718g, getTextSize() + 2.7f, this.k);
        float dimensionPixelOffset = this.f16718g + TbadkApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds3);
        this.f16718g = dimensionPixelOffset;
        if (dimensionPixelOffset > this.i) {
            this.f16718g = this.f16716e;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f16718g = savedState.step;
        this.j = savedState.isStarting;
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.step = this.f16718g;
        savedState.isStarting = this.j;
        return savedState;
    }

    public void setClickliner(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16716e = 0.0f;
        this.f16717f = 0.0f;
        this.f16718g = 0.0f;
        this.f16719h = 0.0f;
        this.i = 0.0f;
        this.j = false;
        this.k = null;
        this.l = "";
        b();
    }
}
