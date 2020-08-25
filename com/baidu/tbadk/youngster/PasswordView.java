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
/* loaded from: classes2.dex */
public class PasswordView extends RelativeLayout {
    private Runnable fjA;
    private EditText fjl;
    private EditText fjm;
    private EditText fjn;
    private EditText fjo;
    private EditText fjp;
    private ImageView fjq;
    private ImageView fjr;
    private ImageView fjs;
    private ImageView fjt;
    private FrameLayout fju;
    private List<EditText> fjv;
    private List<ImageView> fjw;
    a fjx;
    Map<EditText, List<TextWatcher>> fjy;
    private Runnable fjz;

    /* loaded from: classes2.dex */
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
        this.fjv = new ArrayList();
        this.fjw = new ArrayList();
        this.fjy = new HashMap();
        this.fjz = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fjp != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.fjp);
                }
            }
        };
        this.fjA = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fjx != null) {
                    PasswordView.this.fjx.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.fjl = (EditText) findViewById(R.id.edit_password_a);
        this.fjm = (EditText) findViewById(R.id.edit_password_b);
        this.fjn = (EditText) findViewById(R.id.edit_password_c);
        this.fjo = (EditText) findViewById(R.id.edit_password_d);
        this.fjv.add(this.fjl);
        this.fjv.add(this.fjm);
        this.fjv.add(this.fjn);
        this.fjv.add(this.fjo);
        this.fjq = (ImageView) findViewById(R.id.edit_dot_a);
        this.fjr = (ImageView) findViewById(R.id.edit_dot_b);
        this.fjs = (ImageView) findViewById(R.id.edit_dot_c);
        this.fjt = (ImageView) findViewById(R.id.edit_dot_d);
        this.fjw.add(this.fjq);
        this.fjw.add(this.fjr);
        this.fjw.add(this.fjs);
        this.fjw.add(this.fjt);
        this.fju = (FrameLayout) findViewById(R.id.password_click);
        this.fju.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.byW();
            }
        });
        bza();
        bzb();
        byZ();
        byY();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.fjv) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void byV() {
        for (EditText editText : this.fjv) {
            editText.getText().clear();
        }
        byY();
        byZ();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.fjx = aVar;
    }

    public void byW() {
        e.mS().removeCallbacks(this.fjz);
        e.mS().postDelayed(this.fjz, 300L);
    }

    public void byX() {
        l.hideSoftKeyPad(getContext(), this.fjl);
    }

    private void byY() {
        a(this.fjl);
        this.fjl.requestFocus();
        this.fjp = this.fjl;
    }

    private void byZ() {
        for (ImageView imageView : this.fjw) {
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

    private void bza() {
        int size = this.fjv.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.fjv.get(i2), this.fjv.get(i2 + 1), this.fjw.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.fjv.get(size - 1), this.fjw.get(size - 1));
        }
    }

    private void bzb() {
        for (int size = this.fjv.size() - 1; size > 0; size--) {
            b(this.fjv.get(size), this.fjv.get(size - 1), this.fjw.get(size));
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
                    PasswordView.this.fjp = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fjy.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fjy.put(editText, list);
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
                    e.mS().post(PasswordView.this.fjA);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fjy.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fjy.put(editText, list);
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
                    PasswordView.this.fjp = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.fjv) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bzc() {
        for (EditText editText : this.fjv) {
            for (TextWatcher textWatcher : this.fjy.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mS().removeCallbacks(this.fjz);
        e.mS().removeCallbacks(this.fjA);
        bzc();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.fjv) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.fjw) {
            setEditDotDrawable(imageView);
        }
    }
}
