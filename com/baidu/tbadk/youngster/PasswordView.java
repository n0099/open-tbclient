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
    private EditText fGQ;
    private EditText fGR;
    private EditText fGS;
    private EditText fGT;
    private EditText fGU;
    private ImageView fGV;
    private ImageView fGW;
    private ImageView fGX;
    private ImageView fGY;
    private FrameLayout fGZ;
    private List<EditText> fHa;
    private List<ImageView> fHb;
    a fHc;
    Map<EditText, List<TextWatcher>> fHd;
    private Runnable fHe;
    private Runnable fHf;

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
        this.fHa = new ArrayList();
        this.fHb = new ArrayList();
        this.fHd = new HashMap();
        this.fHe = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fGU != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.fGU);
                }
            }
        };
        this.fHf = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fHc != null) {
                    PasswordView.this.fHc.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.fGQ = (EditText) findViewById(R.id.edit_password_a);
        this.fGR = (EditText) findViewById(R.id.edit_password_b);
        this.fGS = (EditText) findViewById(R.id.edit_password_c);
        this.fGT = (EditText) findViewById(R.id.edit_password_d);
        this.fHa.add(this.fGQ);
        this.fHa.add(this.fGR);
        this.fHa.add(this.fGS);
        this.fHa.add(this.fGT);
        this.fGV = (ImageView) findViewById(R.id.edit_dot_a);
        this.fGW = (ImageView) findViewById(R.id.edit_dot_b);
        this.fGX = (ImageView) findViewById(R.id.edit_dot_c);
        this.fGY = (ImageView) findViewById(R.id.edit_dot_d);
        this.fHb.add(this.fGV);
        this.fHb.add(this.fGW);
        this.fHb.add(this.fGX);
        this.fHb.add(this.fGY);
        this.fGZ = (FrameLayout) findViewById(R.id.password_click);
        this.fGZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.bEJ();
            }
        });
        bEN();
        bEO();
        bEM();
        bEL();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.fHa) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void bEI() {
        for (EditText editText : this.fHa) {
            editText.getText().clear();
        }
        bEL();
        bEM();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.fHc = aVar;
    }

    public void bEJ() {
        e.mY().removeCallbacks(this.fHe);
        e.mY().postDelayed(this.fHe, 300L);
    }

    public void bEK() {
        l.hideSoftKeyPad(getContext(), this.fGQ);
    }

    private void bEL() {
        a(this.fGQ);
        this.fGQ.requestFocus();
        this.fGU = this.fGQ;
    }

    private void bEM() {
        for (ImageView imageView : this.fHb) {
            imageView.setVisibility(8);
        }
    }

    private void setEditBackgroundDrawable(EditText editText) {
        editText.setBackgroundDrawable(getEditBackgroundDrawable());
    }

    private Drawable getEditBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(l.getDimens(getContext(), R.dimen.tbds3), c.m(ap.getColor(R.color.cp_cont_b), 0.16f));
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

    private void bEN() {
        int size = this.fHa.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.fHa.get(i2), this.fHa.get(i2 + 1), this.fHb.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.fHa.get(size - 1), this.fHb.get(size - 1));
        }
    }

    private void bEO() {
        for (int size = this.fHa.size() - 1; size > 0; size--) {
            b(this.fHa.get(size), this.fHa.get(size - 1), this.fHb.get(size));
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
                    PasswordView.this.fGU = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fHd.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fHd.put(editText, list);
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
                    e.mY().post(PasswordView.this.fHf);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fHd.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fHd.put(editText, list);
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
                    PasswordView.this.fGU = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.fHa) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bEP() {
        for (EditText editText : this.fHa) {
            for (TextWatcher textWatcher : this.fHd.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mY().removeCallbacks(this.fHe);
        e.mY().removeCallbacks(this.fHf);
        bEP();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.fHa) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.fHb) {
            setEditDotDrawable(imageView);
        }
    }
}
