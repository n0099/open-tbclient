package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class AutoScrollTextView extends TextView implements View.OnClickListener {
    private float ijf;
    private float ijg;
    private float ijh;
    private float iji;
    public boolean ijj;
    private View.OnClickListener ijk;
    public boolean isStarting;
    private Paint paint;
    private float progress;
    private float step;
    private String text;
    private float y;

    public AutoScrollTextView(Context context) {
        super(context);
        this.ijf = 0.0f;
        this.ijg = 0.0f;
        this.step = 0.0f;
        this.y = 0.0f;
        this.ijh = 0.0f;
        this.iji = 0.0f;
        this.isStarting = false;
        this.ijj = false;
        this.paint = null;
        this.text = "";
        initView();
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ijf = 0.0f;
        this.ijg = 0.0f;
        this.step = 0.0f;
        this.y = 0.0f;
        this.ijh = 0.0f;
        this.iji = 0.0f;
        this.isStarting = false;
        this.ijj = false;
        this.paint = null;
        this.text = "";
        initView();
    }

    private void initView() {
        setOnClickListener(this);
    }

    public void b(WindowManager windowManager) {
        this.paint = getPaint();
        this.paint.setColor(-1);
        this.text = getText().toString();
        this.ijf = this.paint.measureText(this.text);
        this.ijg = getWidth();
        if (this.ijg == 0.0f && windowManager != null) {
            this.ijg = windowManager.getDefaultDisplay().getWidth();
        }
        this.step = this.ijf;
        this.ijh = this.ijf;
        this.iji = this.ijf * 2.0f;
        this.y = getTextSize();
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.step = this.step;
        savedState.isStarting = this.isStarting;
        return savedState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.step = savedState.step;
        this.isStarting = savedState.isStarting;
    }

    /* loaded from: classes16.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.frs.view.AutoScrollTextView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: wO */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: V */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        public boolean isStarting;
        public float step;

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.isStarting = false;
            this.step = 0.0f;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBooleanArray(new boolean[]{this.isStarting});
            parcel.writeFloat(this.step);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
        private SavedState(Parcel parcel) {
            super(parcel);
            this.isStarting = false;
            this.step = 0.0f;
            byte[] bArr = 0;
            parcel.readBooleanArray(null);
            if (0 != 0 && bArr.length > 0) {
                this.isStarting = bArr[0];
            }
            this.step = parcel.readFloat();
        }
    }

    public void ceb() {
        this.isStarting = true;
        invalidate();
    }

    public void ai(float f) {
        this.progress = f;
        setWidth((int) (3000.0f * (this.progress - 0.5f)));
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.isStarting) {
            if (this.progress > 0.5f) {
                setWidth((int) (3000.0f * (this.progress - 0.5f)));
                canvas.drawText(this.text, this.ijh - this.step, getTextSize() + 2.7f, this.paint);
                return;
            }
            return;
        }
        canvas.drawText(this.text, this.ijh - this.step, getTextSize() + 2.7f, this.paint);
        this.step = TbadkApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds3) + this.step;
        if (this.step > this.iji) {
            this.step = this.ijf;
        }
        invalidate();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ijk != null) {
            this.ijk.onClick(view);
        }
    }

    public void setClickliner(View.OnClickListener onClickListener) {
        this.ijk = onClickListener;
    }
}
