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
    private EditText fmh;
    private EditText fmi;
    private EditText fmj;
    private EditText fmk;
    private EditText fml;
    private ImageView fmm;
    private ImageView fmn;
    private ImageView fmo;
    private ImageView fmq;
    private FrameLayout fmr;
    private List<EditText> fms;
    private List<ImageView> fmt;
    a fmu;
    Map<EditText, List<TextWatcher>> fmv;
    private Runnable fmw;
    private Runnable fmx;

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
        this.fms = new ArrayList();
        this.fmt = new ArrayList();
        this.fmv = new HashMap();
        this.fmw = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fml != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.fml);
                }
            }
        };
        this.fmx = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fmu != null) {
                    PasswordView.this.fmu.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.fmh = (EditText) findViewById(R.id.edit_password_a);
        this.fmi = (EditText) findViewById(R.id.edit_password_b);
        this.fmj = (EditText) findViewById(R.id.edit_password_c);
        this.fmk = (EditText) findViewById(R.id.edit_password_d);
        this.fms.add(this.fmh);
        this.fms.add(this.fmi);
        this.fms.add(this.fmj);
        this.fms.add(this.fmk);
        this.fmm = (ImageView) findViewById(R.id.edit_dot_a);
        this.fmn = (ImageView) findViewById(R.id.edit_dot_b);
        this.fmo = (ImageView) findViewById(R.id.edit_dot_c);
        this.fmq = (ImageView) findViewById(R.id.edit_dot_d);
        this.fmt.add(this.fmm);
        this.fmt.add(this.fmn);
        this.fmt.add(this.fmo);
        this.fmt.add(this.fmq);
        this.fmr = (FrameLayout) findViewById(R.id.password_click);
        this.fmr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.bAg();
            }
        });
        bAk();
        bAl();
        bAj();
        bAi();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.fms) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void bAf() {
        for (EditText editText : this.fms) {
            editText.getText().clear();
        }
        bAi();
        bAj();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.fmu = aVar;
    }

    public void bAg() {
        e.mX().removeCallbacks(this.fmw);
        e.mX().postDelayed(this.fmw, 300L);
    }

    public void bAh() {
        l.hideSoftKeyPad(getContext(), this.fmh);
    }

    private void bAi() {
        a(this.fmh);
        this.fmh.requestFocus();
        this.fml = this.fmh;
    }

    private void bAj() {
        for (ImageView imageView : this.fmt) {
            imageView.setVisibility(8);
        }
    }

    private void setEditBackgroundDrawable(EditText editText) {
        editText.setBackgroundDrawable(getEditBackgroundDrawable());
    }

    private Drawable getEditBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(l.getDimens(getContext(), R.dimen.tbds3), c.l(ap.getColor(R.color.cp_cont_b), 0.16f));
        return gradientDrawable;
    }

    private void setEditDotDrawable(ImageView imageView) {
        imageView.setImageDrawable(getEditDotDrawable());
    }

    private Drawable getEditDotDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ap.getColor(R.color.cp_cont_j));
        return gradientDrawable;
    }

    private void bAk() {
        int size = this.fms.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.fms.get(i2), this.fms.get(i2 + 1), this.fmt.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.fms.get(size - 1), this.fmt.get(size - 1));
        }
    }

    private void bAl() {
        for (int size = this.fms.size() - 1; size > 0; size--) {
            b(this.fms.get(size), this.fms.get(size - 1), this.fmt.get(size));
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
                    PasswordView.this.fml = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fmv.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fmv.put(editText, list);
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
                    e.mX().post(PasswordView.this.fmx);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fmv.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fmv.put(editText, list);
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
                    PasswordView.this.fml = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.fms) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bAm() {
        for (EditText editText : this.fms) {
            for (TextWatcher textWatcher : this.fmv.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mX().removeCallbacks(this.fmw);
        e.mX().removeCallbacks(this.fmx);
        bAm();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.fms) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.fmt) {
            setEditDotDrawable(imageView);
        }
    }
}
