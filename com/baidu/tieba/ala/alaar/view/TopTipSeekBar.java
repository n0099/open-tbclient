package com.baidu.tieba.ala.alaar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class TopTipSeekBar extends SeekBar implements SeekBar.OnSeekBarChangeListener {
    private SeekBar.OnSeekBarChangeListener eAu;
    private TextView eMR;
    private int eNI;
    private int eNJ;
    private final int eNK;
    private final int eNL;
    private TextView mTipView;

    public void setProcessDiff(int i) {
        this.eNI = i;
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.eNI) + "%");
        }
    }

    public void setTipView(TextView textView) {
        this.mTipView = textView;
    }

    public void setDefThumb(TextView textView) {
        this.eMR = textView;
    }

    public void setDefThumbPos(int i) {
        this.eNJ = i;
        if (this.eMR != null) {
            this.eMR.setTranslationX(((((getMeasuredWidth() - this.eNK) * i) * 1.0f) / 100.0f) + this.eNL);
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
        this.eNI = 0;
        this.eNJ = 50;
        this.eNK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds48);
        this.eNL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        super.setOnSeekBarChangeListener(this);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.eAu = onSeekBarChangeListener;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.eNI) + "%");
        }
        if (this.eMR != null) {
            this.eMR.setTranslationX(((((getMeasuredWidth() - this.eNK) * this.eNJ) * 1.0f) / 100.0f) + this.eNL);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.eAu != null) {
            this.eAu.onProgressChanged(seekBar, i, z);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (this.eAu != null) {
            this.eAu.onStartTrackingTouch(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.eAu != null) {
            this.eAu.onStopTrackingTouch(seekBar);
        }
    }
}
