package com.baidu.tieba.ala.alaar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class TopTipSeekBar extends SeekBar implements SeekBar.OnSeekBarChangeListener {
    private SeekBar.OnSeekBarChangeListener gjA;
    private int gzL;
    private int gzM;
    private final int gzN;
    private final int gzO;
    private TextView gzu;
    private int mOffset;
    private TextView mTipView;

    public void setProcessDiff(int i) {
        this.gzL = i;
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.gzL) + "%");
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "setProgress " + i);
        }
        super.setProgress(i);
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i, boolean z) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "setProgress " + i);
        }
        super.setProgress(i, z);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar
    public synchronized void setMax(int i) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "setMax " + i);
        }
        super.setMax(i);
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "initSeekBar[" + i + ", " + i2 + "], v=" + i4 + ", diff=" + (0 - i) + ", max:" + (i2 - i));
        }
        this.mOffset = 0 - i;
        setMax(i2 - i);
        if (z && Build.VERSION.SDK_INT >= 24) {
            setProgress(i4, true);
        } else {
            setProgress(i4);
        }
        setDefThumbPos(this.mOffset + i3);
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.gzL) + "%");
        }
    }

    public int getOffset() {
        return this.mOffset;
    }

    public void setTipView(TextView textView) {
        this.mTipView = textView;
    }

    public void setDefThumb(TextView textView) {
        this.gzu = textView;
    }

    public void setDefThumbPos(int i) {
        this.gzM = i;
        if (this.gzu != null) {
            this.gzu.setTranslationX(((((getMeasuredWidth() - this.gzN) * i) * 1.0f) / 100.0f) + this.gzO);
        }
    }

    public TopTipSeekBar(Context context) {
        this(context, null);
    }

    public TopTipSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopTipSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzL = 0;
        this.mOffset = 0;
        this.gzM = 50;
        this.gzN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds48);
        this.gzO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        j(context, attributeSet);
    }

    private void j(Context context, AttributeSet attributeSet) {
        super.setOnSeekBarChangeListener(this);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.gjA = onSeekBarChangeListener;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.gzL) + "%");
        }
        if (this.gzu != null) {
            this.gzu.setTranslationX(((((getMeasuredWidth() - this.gzN) * this.gzM) * 1.0f) / 100.0f) + this.gzO);
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized int getProgress() {
        return super.getProgress() - this.mOffset;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("seekbar", "onProgressChanged " + i + ", to " + (i - this.mOffset));
        }
        if (this.gjA != null) {
            this.gjA.onProgressChanged(seekBar, i, z);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (this.gjA != null) {
            this.gjA.onStartTrackingTouch(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.gjA != null) {
            this.gjA.onStopTrackingTouch(seekBar);
        }
    }
}
