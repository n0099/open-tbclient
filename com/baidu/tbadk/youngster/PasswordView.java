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
    private EditText gdA;
    private EditText gdB;
    private EditText gdC;
    private ImageView gdD;
    private ImageView gdE;
    private ImageView gdF;
    private ImageView gdG;
    private FrameLayout gdH;
    private List<EditText> gdI;
    private List<ImageView> gdJ;
    a gdK;
    Map<EditText, List<TextWatcher>> gdL;
    private Runnable gdM;
    private Runnable gdN;
    private EditText gdy;
    private EditText gdz;

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
        this.gdI = new ArrayList();
        this.gdJ = new ArrayList();
        this.gdL = new HashMap();
        this.gdM = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.gdC != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.gdC);
                }
            }
        };
        this.gdN = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.gdK != null) {
                    PasswordView.this.gdK.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.gdy = (EditText) findViewById(R.id.edit_password_a);
        this.gdz = (EditText) findViewById(R.id.edit_password_b);
        this.gdA = (EditText) findViewById(R.id.edit_password_c);
        this.gdB = (EditText) findViewById(R.id.edit_password_d);
        this.gdI.add(this.gdy);
        this.gdI.add(this.gdz);
        this.gdI.add(this.gdA);
        this.gdI.add(this.gdB);
        this.gdD = (ImageView) findViewById(R.id.edit_dot_a);
        this.gdE = (ImageView) findViewById(R.id.edit_dot_b);
        this.gdF = (ImageView) findViewById(R.id.edit_dot_c);
        this.gdG = (ImageView) findViewById(R.id.edit_dot_d);
        this.gdJ.add(this.gdD);
        this.gdJ.add(this.gdE);
        this.gdJ.add(this.gdF);
        this.gdJ.add(this.gdG);
        this.gdH = (FrameLayout) findViewById(R.id.password_click);
        this.gdH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.bMu();
            }
        });
        bMy();
        bMz();
        bMx();
        bMw();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.gdI) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void bMt() {
        for (EditText editText : this.gdI) {
            editText.getText().clear();
        }
        bMw();
        bMx();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.gdK = aVar;
    }

    public void bMu() {
        e.mB().removeCallbacks(this.gdM);
        e.mB().postDelayed(this.gdM, 300L);
    }

    public void bMv() {
        l.hideSoftKeyPad(getContext(), this.gdy);
    }

    private void bMw() {
        c(this.gdy);
        this.gdy.requestFocus();
        this.gdC = this.gdy;
    }

    private void bMx() {
        for (ImageView imageView : this.gdJ) {
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

    private void bMy() {
        int size = this.gdI.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.gdI.get(i2), this.gdI.get(i2 + 1), this.gdJ.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.gdI.get(size - 1), this.gdJ.get(size - 1));
        }
    }

    private void bMz() {
        for (int size = this.gdI.size() - 1; size > 0; size--) {
            b(this.gdI.get(size), this.gdI.get(size - 1), this.gdJ.get(size));
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
                    PasswordView.this.gdC = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.gdL.get(editText);
        if (x.isEmpty(list)) {
            list = new ArrayList<>();
            this.gdL.put(editText, list);
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
                    e.mB().post(PasswordView.this.gdN);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.gdL.get(editText);
        if (x.isEmpty(list)) {
            list = new ArrayList<>();
            this.gdL.put(editText, list);
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
                    PasswordView.this.gdC = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.gdI) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bMA() {
        for (EditText editText : this.gdI) {
            for (TextWatcher textWatcher : this.gdL.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mB().removeCallbacks(this.gdM);
        e.mB().removeCallbacks(this.gdN);
        bMA();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.gdI) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.gdJ) {
            setEditDotDrawable(imageView);
        }
    }
}
