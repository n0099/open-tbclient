package com.baidu.tieba.ala.alaar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class TopTipSeekBar extends SeekBar implements SeekBar.OnSeekBarChangeListener {
    private TextView fBe;
    private int fCe;
    private int fCf;
    private final int fCg;
    private final int fCh;
    private SeekBar.OnSeekBarChangeListener fpk;
    private TextView mTipView;

    public void setProcessDiff(int i) {
        this.fCe = i;
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.fCe) + "%");
        }
    }

    public void setTipView(TextView textView) {
        this.mTipView = textView;
    }

    public void setDefThumb(TextView textView) {
        this.fBe = textView;
    }

    public void setDefThumbPos(int i) {
        this.fCf = i;
        if (this.fBe != null) {
            this.fBe.setTranslationX(((((getMeasuredWidth() - this.fCg) * i) * 1.0f) / 100.0f) + this.fCh);
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
        this.fCe = 0;
        this.fCf = 50;
        this.fCg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds48);
        this.fCh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        super.setOnSeekBarChangeListener(this);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fpk = onSeekBarChangeListener;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.fCe) + "%");
        }
        if (this.fBe != null) {
            this.fBe.setTranslationX(((((getMeasuredWidth() - this.fCg) * this.fCf) * 1.0f) / 100.0f) + this.fCh);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.fpk != null) {
            this.fpk.onProgressChanged(seekBar, i, z);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (this.fpk != null) {
            this.fpk.onStartTrackingTouch(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.fpk != null) {
            this.fpk.onStopTrackingTouch(seekBar);
        }
    }
}
