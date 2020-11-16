package com.baidu.tbadk.youngster;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class PasswordView extends RelativeLayout {
    private EditText fMj;
    private EditText fMk;
    private EditText fMl;
    private EditText fMm;
    private EditText fMn;
    private ImageView fMo;
    private ImageView fMp;
    private ImageView fMq;
    private ImageView fMr;
    private FrameLayout fMs;
    private List<EditText> fMt;
    private List<ImageView> fMu;
    a fMv;
    Map<EditText, List<TextWatcher>> fMw;
    private Runnable fMx;
    private Runnable fMy;

    /* loaded from: classes.dex */
    interface a {
        void onComplete();
    }

    public PasswordView(Context context) {
        this(context, null);
    }

    public PasswordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PasswordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fMt = new ArrayList();
        this.fMu = new ArrayList();
        this.fMw = new HashMap();
        this.fMx = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fMn != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.fMn);
                }
            }
        };
        this.fMy = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fMv != null) {
                    PasswordView.this.fMv.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.fMj = (EditText) findViewById(R.id.edit_password_a);
        this.fMk = (EditText) findViewById(R.id.edit_password_b);
        this.fMl = (EditText) findViewById(R.id.edit_password_c);
        this.fMm = (EditText) findViewById(R.id.edit_password_d);
        this.fMt.add(this.fMj);
        this.fMt.add(this.fMk);
        this.fMt.add(this.fMl);
        this.fMt.add(this.fMm);
        this.fMo = (ImageView) findViewById(R.id.edit_dot_a);
        this.fMp = (ImageView) findViewById(R.id.edit_dot_b);
        this.fMq = (ImageView) findViewById(R.id.edit_dot_c);
        this.fMr = (ImageView) findViewById(R.id.edit_dot_d);
        this.fMu.add(this.fMo);
        this.fMu.add(this.fMp);
        this.fMu.add(this.fMq);
        this.fMu.add(this.fMr);
        this.fMs = (FrameLayout) findViewById(R.id.password_click);
        this.fMs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.bGB();
            }
        });
        bGF();
        bGG();
        bGE();
        bGD();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.fMt) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void bGA() {
        for (EditText editText : this.fMt) {
            editText.getText().clear();
        }
        bGD();
        bGE();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.fMv = aVar;
    }

    public void bGB() {
        e.mY().removeCallbacks(this.fMx);
        e.mY().postDelayed(this.fMx, 300L);
    }

    public void bGC() {
        l.hideSoftKeyPad(getContext(), this.fMj);
    }

    private void bGD() {
        a(this.fMj);
        this.fMj.requestFocus();
        this.fMn = this.fMj;
    }

    private void bGE() {
        for (ImageView imageView : this.fMu) {
            imageView.setVisibility(8);
        }
    }

    private void setEditBackgroundDrawable(EditText editText) {
        editText.setBackgroundDrawable(getEditBackgroundDrawable());
    }

    private Drawable getEditBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(l.getDimens(getContext(), R.dimen.tbds3), c.m(ap.getColor(R.color.CAM_X0105), 0.16f));
        return gradientDrawable;
    }

    private void setEditDotDrawable(ImageView imageView) {
        imageView.setImageDrawable(getEditDotDrawable());
    }

    private Drawable getEditDotDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ap.getColor(R.color.CAM_X0107));
        return gradientDrawable;
    }

    private void bGF() {
        int size = this.fMt.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.fMt.get(i2), this.fMt.get(i2 + 1), this.fMu.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.fMt.get(size - 1), this.fMu.get(size - 1));
        }
    }

    private void bGG() {
        for (int size = this.fMt.size() - 1; size > 0; size--) {
            b(this.fMt.get(size), this.fMt.get(size - 1), this.fMu.get(size));
        }
    }

    private void a(EditText editText, final EditText editText2, final ImageView imageView) {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tbadk.youngster.PasswordView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    imageView.setVisibility(0);
                    PasswordView.this.a(editText2);
                    editText2.requestFocus();
                    PasswordView.this.fMn = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fMw.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fMw.put(editText, list);
        }
        list.add(textWatcher);
    }

    private void a(EditText editText, final ImageView imageView) {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tbadk.youngster.PasswordView.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    imageView.setVisibility(0);
                    e.mY().post(PasswordView.this.fMy);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fMw.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fMw.put(editText, list);
        }
        list.add(textWatcher);
    }

    private void b(final EditText editText, final EditText editText2, final ImageView imageView) {
        editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.youngster.PasswordView.6
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    if (editText.getText().length() > 0) {
                        editText.getText().clear();
                    } else {
                        editText2.getText().clear();
                    }
                    imageView.setVisibility(8);
                    PasswordView.this.a(editText2);
                    editText2.requestFocus();
                    PasswordView.this.fMn = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.fMt) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bGH() {
        for (EditText editText : this.fMt) {
            for (TextWatcher textWatcher : this.fMw.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mY().removeCallbacks(this.fMx);
        e.mY().removeCallbacks(this.fMy);
        bGH();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.fMt) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.fMu) {
            setEditDotDrawable(imageView);
        }
    }
}
