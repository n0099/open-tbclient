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
    private EditText fTU;
    private EditText fTV;
    private EditText fTW;
    private EditText fTX;
    private EditText fTY;
    private ImageView fTZ;
    private ImageView fUa;
    private ImageView fUb;
    private ImageView fUc;
    private FrameLayout fUd;
    private List<EditText> fUe;
    private List<ImageView> fUf;
    a fUg;
    Map<EditText, List<TextWatcher>> fUh;
    private Runnable fUi;
    private Runnable fUj;

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
        this.fUe = new ArrayList();
        this.fUf = new ArrayList();
        this.fUh = new HashMap();
        this.fUi = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fTY != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.fTY);
                }
            }
        };
        this.fUj = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fUg != null) {
                    PasswordView.this.fUg.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.fTU = (EditText) findViewById(R.id.edit_password_a);
        this.fTV = (EditText) findViewById(R.id.edit_password_b);
        this.fTW = (EditText) findViewById(R.id.edit_password_c);
        this.fTX = (EditText) findViewById(R.id.edit_password_d);
        this.fUe.add(this.fTU);
        this.fUe.add(this.fTV);
        this.fUe.add(this.fTW);
        this.fUe.add(this.fTX);
        this.fTZ = (ImageView) findViewById(R.id.edit_dot_a);
        this.fUa = (ImageView) findViewById(R.id.edit_dot_b);
        this.fUb = (ImageView) findViewById(R.id.edit_dot_c);
        this.fUc = (ImageView) findViewById(R.id.edit_dot_d);
        this.fUf.add(this.fTZ);
        this.fUf.add(this.fUa);
        this.fUf.add(this.fUb);
        this.fUf.add(this.fUc);
        this.fUd = (FrameLayout) findViewById(R.id.password_click);
        this.fUd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.bKb();
            }
        });
        bKf();
        bKg();
        bKe();
        bKd();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.fUe) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void bKa() {
        for (EditText editText : this.fUe) {
            editText.getText().clear();
        }
        bKd();
        bKe();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.fUg = aVar;
    }

    public void bKb() {
        e.mY().removeCallbacks(this.fUi);
        e.mY().postDelayed(this.fUi, 300L);
    }

    public void bKc() {
        l.hideSoftKeyPad(getContext(), this.fTU);
    }

    private void bKd() {
        a(this.fTU);
        this.fTU.requestFocus();
        this.fTY = this.fTU;
    }

    private void bKe() {
        for (ImageView imageView : this.fUf) {
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

    private void bKf() {
        int size = this.fUe.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.fUe.get(i2), this.fUe.get(i2 + 1), this.fUf.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.fUe.get(size - 1), this.fUf.get(size - 1));
        }
    }

    private void bKg() {
        for (int size = this.fUe.size() - 1; size > 0; size--) {
            b(this.fUe.get(size), this.fUe.get(size - 1), this.fUf.get(size));
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
                    PasswordView.this.fTY = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fUh.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fUh.put(editText, list);
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
                    e.mY().post(PasswordView.this.fUj);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fUh.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fUh.put(editText, list);
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
                    PasswordView.this.fTY = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.fUe) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bKh() {
        for (EditText editText : this.fUe) {
            for (TextWatcher textWatcher : this.fUh.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mY().removeCallbacks(this.fUi);
        e.mY().removeCallbacks(this.fUj);
        bKh();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.fUe) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.fUf) {
            setEditDotDrawable(imageView);
        }
    }
}
