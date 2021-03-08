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
    private EditText gcI;
    private EditText gcJ;
    private EditText gcK;
    private EditText gcL;
    private EditText gcM;
    private ImageView gcN;
    private ImageView gcO;
    private ImageView gcP;
    private ImageView gcQ;
    private FrameLayout gcR;
    private List<EditText> gcS;
    private List<ImageView> gcT;
    a gcU;
    Map<EditText, List<TextWatcher>> gcV;
    private Runnable gcW;
    private Runnable gcX;

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
        this.gcS = new ArrayList();
        this.gcT = new ArrayList();
        this.gcV = new HashMap();
        this.gcW = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.gcM != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.gcM);
                }
            }
        };
        this.gcX = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.gcU != null) {
                    PasswordView.this.gcU.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.gcI = (EditText) findViewById(R.id.edit_password_a);
        this.gcJ = (EditText) findViewById(R.id.edit_password_b);
        this.gcK = (EditText) findViewById(R.id.edit_password_c);
        this.gcL = (EditText) findViewById(R.id.edit_password_d);
        this.gcS.add(this.gcI);
        this.gcS.add(this.gcJ);
        this.gcS.add(this.gcK);
        this.gcS.add(this.gcL);
        this.gcN = (ImageView) findViewById(R.id.edit_dot_a);
        this.gcO = (ImageView) findViewById(R.id.edit_dot_b);
        this.gcP = (ImageView) findViewById(R.id.edit_dot_c);
        this.gcQ = (ImageView) findViewById(R.id.edit_dot_d);
        this.gcT.add(this.gcN);
        this.gcT.add(this.gcO);
        this.gcT.add(this.gcP);
        this.gcT.add(this.gcQ);
        this.gcR = (FrameLayout) findViewById(R.id.password_click);
        this.gcR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.bIZ();
            }
        });
        bJd();
        bJe();
        bJc();
        bJb();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.gcS) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void bIY() {
        for (EditText editText : this.gcS) {
            editText.getText().clear();
        }
        bJb();
        bJc();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.gcU = aVar;
    }

    public void bIZ() {
        e.mA().removeCallbacks(this.gcW);
        e.mA().postDelayed(this.gcW, 300L);
    }

    public void bJa() {
        l.hideSoftKeyPad(getContext(), this.gcI);
    }

    private void bJb() {
        c(this.gcI);
        this.gcI.requestFocus();
        this.gcM = this.gcI;
    }

    private void bJc() {
        for (ImageView imageView : this.gcT) {
            imageView.setVisibility(8);
        }
    }

    private void setEditBackgroundDrawable(EditText editText) {
        editText.setBackgroundDrawable(getEditBackgroundDrawable());
    }

    private Drawable getEditBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(l.getDimens(getContext(), R.dimen.tbds3), c.l(ap.getColor(R.color.CAM_X0105), 0.16f));
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

    private void bJd() {
        int size = this.gcS.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.gcS.get(i2), this.gcS.get(i2 + 1), this.gcT.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.gcS.get(size - 1), this.gcT.get(size - 1));
        }
    }

    private void bJe() {
        for (int size = this.gcS.size() - 1; size > 0; size--) {
            b(this.gcS.get(size), this.gcS.get(size - 1), this.gcT.get(size));
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
                    PasswordView.this.gcM = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.gcV.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.gcV.put(editText, list);
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
                    e.mA().post(PasswordView.this.gcX);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.gcV.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.gcV.put(editText, list);
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
                    PasswordView.this.gcM = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.gcS) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bJf() {
        for (EditText editText : this.gcS) {
            for (TextWatcher textWatcher : this.gcV.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mA().removeCallbacks(this.gcW);
        e.mA().removeCallbacks(this.gcX);
        bJf();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.gcS) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.gcT) {
            setEditDotDrawable(imageView);
        }
    }
}
