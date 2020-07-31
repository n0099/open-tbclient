package com.baidu.tieba.ala.alaar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class TopTipSeekBar extends SeekBar implements SeekBar.OnSeekBarChangeListener {
    private SeekBar.OnSeekBarChangeListener fdS;
    private TextView fpI;
    private int fqI;
    private int fqJ;
    private final int fqK;
    private final int fqL;
    private TextView mTipView;

    public void setProcessDiff(int i) {
        this.fqI = i;
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.fqI) + "%");
        }
    }

    public void setTipView(TextView textView) {
        this.mTipView = textView;
    }

    public void setDefThumb(TextView textView) {
        this.fpI = textView;
    }

    public void setDefThumbPos(int i) {
        this.fqJ = i;
        if (this.fpI != null) {
            this.fpI.setTranslationX(((((getMeasuredWidth() - this.fqK) * i) * 1.0f) / 100.0f) + this.fqL);
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
        this.fqI = 0;
        this.fqJ = 50;
        this.fqK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds48);
        this.fqL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        super.setOnSeekBarChangeListener(this);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.fdS = onSeekBarChangeListener;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.fqI) + "%");
        }
        if (this.fpI != null) {
            this.fpI.setTranslationX(((((getMeasuredWidth() - this.fqK) * this.fqJ) * 1.0f) / 100.0f) + this.fqL);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.fdS != null) {
            this.fdS.onProgressChanged(seekBar, i, z);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (this.fdS != null) {
            this.fdS.onStartTrackingTouch(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.fdS != null) {
            this.fdS.onStopTrackingTouch(seekBar);
        }
    }
}
