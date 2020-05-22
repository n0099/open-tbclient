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
    private SeekBar.OnSeekBarChangeListener eOU;
    private TextView eZo;
    private int faf;
    private int fag;
    private final int fah;
    private final int fai;
    private TextView mTipView;

    public void setProcessDiff(int i) {
        this.faf = i;
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.faf) + "%");
        }
    }

    public void setTipView(TextView textView) {
        this.mTipView = textView;
    }

    public void setDefThumb(TextView textView) {
        this.eZo = textView;
    }

    public void setDefThumbPos(int i) {
        this.fag = i;
        if (this.eZo != null) {
            this.eZo.setTranslationX(((((getMeasuredWidth() - this.fah) * i) * 1.0f) / 100.0f) + this.fai);
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
        this.faf = 0;
        this.fag = 50;
        this.fah = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds48);
        this.fai = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        super.setOnSeekBarChangeListener(this);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.eOU = onSeekBarChangeListener;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTipView != null) {
            this.mTipView.setTranslationX(getThumb().getBounds().centerX() - (this.mTipView.getMeasuredWidth() / 2));
            this.mTipView.setText((getProgress() - this.faf) + "%");
        }
        if (this.eZo != null) {
            this.eZo.setTranslationX(((((getMeasuredWidth() - this.fah) * this.fag) * 1.0f) / 100.0f) + this.fai);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.eOU != null) {
            this.eOU.onProgressChanged(seekBar, i, z);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (this.eOU != null) {
            this.eOU.onStartTrackingTouch(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (this.eOU != null) {
            this.eOU.onStopTrackingTouch(seekBar);
        }
    }
}
