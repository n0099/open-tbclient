package com.baidu.tieba.hp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import com.baidu.tieba.al;
import com.mofamulu.tieba.ch.as;
import com.mofamulu.tieba.ch.av;
import com.mofamulu.tieba.ch.ba;
import com.mofamulu.tieba.ch.bf;
/* loaded from: classes.dex */
public class AccountTextView extends TextView implements ba {
    protected String a;
    protected volatile String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private volatile int h;

    public AccountTextView(Context context) {
        super(context);
        this.c = true;
        this.d = true;
        this.e = false;
        this.f = false;
    }

    public AccountTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = true;
        this.d = true;
        this.e = false;
        this.f = false;
        a(context, attributeSet);
    }

    public AccountTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = true;
        this.d = true;
        this.e = false;
        this.f = false;
        a(context, attributeSet);
        setText("");
    }

    protected void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, al.AccountTextView);
        if (obtainStyledAttributes != null) {
            this.d = obtainStyledAttributes.getBoolean(1, this.d);
            this.e = obtainStyledAttributes.getBoolean(2, this.e);
            this.f = obtainStyledAttributes.getBoolean(3, this.f);
        }
        obtainStyledAttributes.recycle();
        this.g = getCurrentTextColor();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        this.g = i;
        if (this.h == 0) {
            super.setTextColor(i);
        } else {
            super.setTextColor(this.h);
        }
    }

    @Override // android.widget.TextView
    public void setHighlightColor(int i) {
        if (this.h == 0) {
            super.setHighlightColor(i);
        } else {
            super.setHighlightColor(this.h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (super.getText() == null) {
            setMeasuredDimension(1, getSuggestedMinimumHeight());
            Log.w("tbhp_n", "null text in textview.orginalUserId:" + this.b + ", rendered:" + this.a);
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence == null || charSequence.length() == 0 || charSequence.equals("author")) {
            super.setText("", bufferType);
            this.b = null;
        } else if (charSequence.equals(this.b)) {
            if (this.c) {
                if (this.h != 0) {
                    super.setTextColor(this.h);
                } else {
                    super.setTextColor(this.g);
                }
            }
        } else if (this.a != null && this.a.equals(charSequence)) {
            super.setText(charSequence, bufferType);
        } else {
            if (charSequence instanceof String) {
                this.b = (String) charSequence;
            } else {
                this.b = charSequence.toString();
            }
            super.setText(charSequence, bufferType);
            this.h = 0;
            if (this.c || this.d || this.f) {
                as.a(getContext(), this.b, this);
            }
        }
    }

    @Override // com.mofamulu.tieba.ch.ba
    public void a(av avVar) {
        if (this.b != null && avVar != null && this.b.equals(avVar.a())) {
            if (this.c) {
                this.h = avVar.c();
                if (this.h != 0) {
                    super.setTextColor(this.h);
                } else {
                    super.setTextColor(this.g);
                }
            }
            if (avVar.g() != 0) {
                this.a = avVar.a();
                super.setText(avVar.a(), TextView.BufferType.NORMAL);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(avVar.a());
            if (this.d) {
                if (bf.b(avVar.b())) {
                    sb.append('[').append(avVar.b()).append(']');
                }
                if (this.e && bf.b(avVar.d()) && !avVar.d().equals(avVar.b())) {
                    sb.append('(').append(avVar.d()).append(')');
                }
            }
            if (this.f && bf.b(avVar.e())) {
                sb.append(" - ").append(avVar.e());
            }
            this.a = sb.toString();
            super.setText(this.a, TextView.BufferType.NORMAL);
        }
    }
}
