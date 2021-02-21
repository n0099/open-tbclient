package com.baidu.tieba.funad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.recapp.l;
/* loaded from: classes5.dex */
public class FunAdButton extends Button implements l {
    private Runnable jTP;
    private boolean jTQ;

    public FunAdButton(Context context) {
        super(context, null, 0);
        this.jTQ = false;
    }

    public FunAdButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.jTQ = false;
    }

    public FunAdButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jTQ = false;
    }

    public void setTextDelay(final CharSequence charSequence, long j) {
        this.jTQ = false;
        if (this.jTP == null) {
            this.jTP = new Runnable() { // from class: com.baidu.tieba.funad.view.FunAdButton.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!FunAdButton.this.jTQ) {
                        FunAdButton.this.setText(charSequence);
                    }
                }
            };
        } else {
            removeCallbacks(this.jTP);
        }
        postDelayed(this.jTP, j);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.jTQ = true;
    }

    @Override // com.baidu.tieba.recapp.l
    public void onResume() {
    }

    @Override // com.baidu.tieba.recapp.l
    public void onDestroy() {
        if (this.jTP != null) {
            removeCallbacks(this.jTP);
            this.jTP = null;
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void onPause() {
        if (this.jTP != null) {
            removeCallbacks(this.jTP);
            this.jTP = null;
        }
    }
}
