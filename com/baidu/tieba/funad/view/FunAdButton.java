package com.baidu.tieba.funad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.recapp.k;
/* loaded from: classes5.dex */
public class FunAdButton extends Button implements k {
    private Runnable jTB;
    private boolean jTC;

    public FunAdButton(Context context) {
        super(context, null, 0);
        this.jTC = false;
    }

    public FunAdButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.jTC = false;
    }

    public FunAdButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jTC = false;
    }

    public void setTextDelay(final CharSequence charSequence, long j) {
        this.jTC = false;
        if (this.jTB == null) {
            this.jTB = new Runnable() { // from class: com.baidu.tieba.funad.view.FunAdButton.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!FunAdButton.this.jTC) {
                        FunAdButton.this.setText(charSequence);
                    }
                }
            };
        } else {
            removeCallbacks(this.jTB);
        }
        postDelayed(this.jTB, j);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.jTC = true;
    }

    @Override // com.baidu.tieba.recapp.k
    public void onResume() {
    }

    @Override // com.baidu.tieba.recapp.k
    public void onDestroy() {
        if (this.jTB != null) {
            removeCallbacks(this.jTB);
            this.jTB = null;
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void onPause() {
        if (this.jTB != null) {
            removeCallbacks(this.jTB);
            this.jTB = null;
        }
    }
}
