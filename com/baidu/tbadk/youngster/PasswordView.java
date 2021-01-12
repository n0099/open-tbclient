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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class PasswordView extends RelativeLayout {
    private EditText fYP;
    private EditText fYQ;
    private EditText fYR;
    private EditText fYS;
    private EditText fYT;
    private ImageView fYU;
    private ImageView fYV;
    private ImageView fYW;
    private ImageView fYX;
    private FrameLayout fYY;
    private List<EditText> fYZ;
    private List<ImageView> fZa;
    a fZb;
    Map<EditText, List<TextWatcher>> fZc;
    private Runnable fZd;
    private Runnable fZe;

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
        this.fYZ = new ArrayList();
        this.fZa = new ArrayList();
        this.fZc = new HashMap();
        this.fZd = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fYT != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.fYT);
                }
            }
        };
        this.fZe = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fZb != null) {
                    PasswordView.this.fZb.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.fYP = (EditText) findViewById(R.id.edit_password_a);
        this.fYQ = (EditText) findViewById(R.id.edit_password_b);
        this.fYR = (EditText) findViewById(R.id.edit_password_c);
        this.fYS = (EditText) findViewById(R.id.edit_password_d);
        this.fYZ.add(this.fYP);
        this.fYZ.add(this.fYQ);
        this.fYZ.add(this.fYR);
        this.fYZ.add(this.fYS);
        this.fYU = (ImageView) findViewById(R.id.edit_dot_a);
        this.fYV = (ImageView) findViewById(R.id.edit_dot_b);
        this.fYW = (ImageView) findViewById(R.id.edit_dot_c);
        this.fYX = (ImageView) findViewById(R.id.edit_dot_d);
        this.fZa.add(this.fYU);
        this.fZa.add(this.fYV);
        this.fZa.add(this.fYW);
        this.fZa.add(this.fYX);
        this.fYY = (FrameLayout) findViewById(R.id.password_click);
        this.fYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.bIC();
            }
        });
        bIG();
        bIH();
        bIF();
        bIE();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.fYZ) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void bIB() {
        for (EditText editText : this.fYZ) {
            editText.getText().clear();
        }
        bIE();
        bIF();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.fZb = aVar;
    }

    public void bIC() {
        e.mB().removeCallbacks(this.fZd);
        e.mB().postDelayed(this.fZd, 300L);
    }

    public void bID() {
        l.hideSoftKeyPad(getContext(), this.fYP);
    }

    private void bIE() {
        c(this.fYP);
        this.fYP.requestFocus();
        this.fYT = this.fYP;
    }

    private void bIF() {
        for (ImageView imageView : this.fZa) {
            imageView.setVisibility(8);
        }
    }

    private void setEditBackgroundDrawable(EditText editText) {
        editText.setBackgroundDrawable(getEditBackgroundDrawable());
    }

    private Drawable getEditBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(l.getDimens(getContext(), R.dimen.tbds3), c.m(ao.getColor(R.color.CAM_X0105), 0.16f));
        return gradientDrawable;
    }

    private void setEditDotDrawable(ImageView imageView) {
        imageView.setImageDrawable(getEditDotDrawable());
    }

    private Drawable getEditDotDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ao.getColor(R.color.CAM_X0107));
        return gradientDrawable;
    }

    private void bIG() {
        int size = this.fYZ.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.fYZ.get(i2), this.fYZ.get(i2 + 1), this.fZa.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.fYZ.get(size - 1), this.fZa.get(size - 1));
        }
    }

    private void bIH() {
        for (int size = this.fYZ.size() - 1; size > 0; size--) {
            b(this.fYZ.get(size), this.fYZ.get(size - 1), this.fZa.get(size));
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
                    PasswordView.this.c(editText2);
                    editText2.requestFocus();
                    PasswordView.this.fYT = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fZc.get(editText);
        if (x.isEmpty(list)) {
            list = new ArrayList<>();
            this.fZc.put(editText, list);
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
                    e.mB().post(PasswordView.this.fZe);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fZc.get(editText);
        if (x.isEmpty(list)) {
            list = new ArrayList<>();
            this.fZc.put(editText, list);
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
                    PasswordView.this.c(editText2);
                    editText2.requestFocus();
                    PasswordView.this.fYT = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.fYZ) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bII() {
        for (EditText editText : this.fYZ) {
            for (TextWatcher textWatcher : this.fZc.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mB().removeCallbacks(this.fZd);
        e.mB().removeCallbacks(this.fZe);
        bII();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.fYZ) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.fZa) {
            setEditDotDrawable(imageView);
        }
    }
}
