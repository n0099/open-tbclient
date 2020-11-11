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
    private EditText fMG;
    private EditText fMH;
    private EditText fMI;
    private EditText fMJ;
    private EditText fMK;
    private ImageView fML;
    private ImageView fMM;
    private ImageView fMN;
    private ImageView fMO;
    private FrameLayout fMP;
    private List<EditText> fMQ;
    private List<ImageView> fMR;
    a fMS;
    Map<EditText, List<TextWatcher>> fMT;
    private Runnable fMU;
    private Runnable fMV;

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
        this.fMQ = new ArrayList();
        this.fMR = new ArrayList();
        this.fMT = new HashMap();
        this.fMU = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fMK != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.fMK);
                }
            }
        };
        this.fMV = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fMS != null) {
                    PasswordView.this.fMS.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.fMG = (EditText) findViewById(R.id.edit_password_a);
        this.fMH = (EditText) findViewById(R.id.edit_password_b);
        this.fMI = (EditText) findViewById(R.id.edit_password_c);
        this.fMJ = (EditText) findViewById(R.id.edit_password_d);
        this.fMQ.add(this.fMG);
        this.fMQ.add(this.fMH);
        this.fMQ.add(this.fMI);
        this.fMQ.add(this.fMJ);
        this.fML = (ImageView) findViewById(R.id.edit_dot_a);
        this.fMM = (ImageView) findViewById(R.id.edit_dot_b);
        this.fMN = (ImageView) findViewById(R.id.edit_dot_c);
        this.fMO = (ImageView) findViewById(R.id.edit_dot_d);
        this.fMR.add(this.fML);
        this.fMR.add(this.fMM);
        this.fMR.add(this.fMN);
        this.fMR.add(this.fMO);
        this.fMP = (FrameLayout) findViewById(R.id.password_click);
        this.fMP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.bHi();
            }
        });
        bHm();
        bHn();
        bHl();
        bHk();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.fMQ) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void bHh() {
        for (EditText editText : this.fMQ) {
            editText.getText().clear();
        }
        bHk();
        bHl();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.fMS = aVar;
    }

    public void bHi() {
        e.mY().removeCallbacks(this.fMU);
        e.mY().postDelayed(this.fMU, 300L);
    }

    public void bHj() {
        l.hideSoftKeyPad(getContext(), this.fMG);
    }

    private void bHk() {
        a(this.fMG);
        this.fMG.requestFocus();
        this.fMK = this.fMG;
    }

    private void bHl() {
        for (ImageView imageView : this.fMR) {
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

    private void bHm() {
        int size = this.fMQ.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.fMQ.get(i2), this.fMQ.get(i2 + 1), this.fMR.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.fMQ.get(size - 1), this.fMR.get(size - 1));
        }
    }

    private void bHn() {
        for (int size = this.fMQ.size() - 1; size > 0; size--) {
            b(this.fMQ.get(size), this.fMQ.get(size - 1), this.fMR.get(size));
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
                    PasswordView.this.fMK = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fMT.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fMT.put(editText, list);
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
                    e.mY().post(PasswordView.this.fMV);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fMT.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fMT.put(editText, list);
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
                    PasswordView.this.fMK = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.fMQ) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bHo() {
        for (EditText editText : this.fMQ) {
            for (TextWatcher textWatcher : this.fMT.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mY().removeCallbacks(this.fMU);
        e.mY().removeCallbacks(this.fMV);
        bHo();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.fMQ) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.fMR) {
            setEditDotDrawable(imageView);
        }
    }
}
