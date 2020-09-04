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
    private List<ImageView> fjA;
    a fjB;
    Map<EditText, List<TextWatcher>> fjC;
    private Runnable fjD;
    private Runnable fjE;
    private EditText fjp;
    private EditText fjq;
    private EditText fjr;
    private EditText fjs;
    private EditText fjt;
    private ImageView fju;
    private ImageView fjv;
    private ImageView fjw;
    private ImageView fjx;
    private FrameLayout fjy;
    private List<EditText> fjz;

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
        this.fjz = new ArrayList();
        this.fjA = new ArrayList();
        this.fjC = new HashMap();
        this.fjD = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fjt != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.fjt);
                }
            }
        };
        this.fjE = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fjB != null) {
                    PasswordView.this.fjB.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.fjp = (EditText) findViewById(R.id.edit_password_a);
        this.fjq = (EditText) findViewById(R.id.edit_password_b);
        this.fjr = (EditText) findViewById(R.id.edit_password_c);
        this.fjs = (EditText) findViewById(R.id.edit_password_d);
        this.fjz.add(this.fjp);
        this.fjz.add(this.fjq);
        this.fjz.add(this.fjr);
        this.fjz.add(this.fjs);
        this.fju = (ImageView) findViewById(R.id.edit_dot_a);
        this.fjv = (ImageView) findViewById(R.id.edit_dot_b);
        this.fjw = (ImageView) findViewById(R.id.edit_dot_c);
        this.fjx = (ImageView) findViewById(R.id.edit_dot_d);
        this.fjA.add(this.fju);
        this.fjA.add(this.fjv);
        this.fjA.add(this.fjw);
        this.fjA.add(this.fjx);
        this.fjy = (FrameLayout) findViewById(R.id.password_click);
        this.fjy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.byX();
            }
        });
        bzb();
        bzc();
        bza();
        byZ();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.fjz) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void byW() {
        for (EditText editText : this.fjz) {
            editText.getText().clear();
        }
        byZ();
        bza();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.fjB = aVar;
    }

    public void byX() {
        e.mS().removeCallbacks(this.fjD);
        e.mS().postDelayed(this.fjD, 300L);
    }

    public void byY() {
        l.hideSoftKeyPad(getContext(), this.fjp);
    }

    private void byZ() {
        a(this.fjp);
        this.fjp.requestFocus();
        this.fjt = this.fjp;
    }

    private void bza() {
        for (ImageView imageView : this.fjA) {
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

    private void bzb() {
        int size = this.fjz.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.fjz.get(i2), this.fjz.get(i2 + 1), this.fjA.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.fjz.get(size - 1), this.fjA.get(size - 1));
        }
    }

    private void bzc() {
        for (int size = this.fjz.size() - 1; size > 0; size--) {
            b(this.fjz.get(size), this.fjz.get(size - 1), this.fjA.get(size));
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
                    PasswordView.this.fjt = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fjC.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fjC.put(editText, list);
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
                    e.mS().post(PasswordView.this.fjE);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fjC.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fjC.put(editText, list);
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
                    PasswordView.this.fjt = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.fjz) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bzd() {
        for (EditText editText : this.fjz) {
            for (TextWatcher textWatcher : this.fjC.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mS().removeCallbacks(this.fjD);
        e.mS().removeCallbacks(this.fjE);
        bzd();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.fjz) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.fjA) {
            setEditDotDrawable(imageView);
        }
    }
}
