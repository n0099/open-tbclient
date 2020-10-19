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
    private ImageView fyA;
    private ImageView fyB;
    private ImageView fyC;
    private ImageView fyD;
    private FrameLayout fyE;
    private List<EditText> fyF;
    private List<ImageView> fyG;
    a fyH;
    Map<EditText, List<TextWatcher>> fyI;
    private Runnable fyJ;
    private Runnable fyK;
    private EditText fyv;
    private EditText fyw;
    private EditText fyx;
    private EditText fyy;
    private EditText fyz;

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
        this.fyF = new ArrayList();
        this.fyG = new ArrayList();
        this.fyI = new HashMap();
        this.fyJ = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fyz != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.fyz);
                }
            }
        };
        this.fyK = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.fyH != null) {
                    PasswordView.this.fyH.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.fyv = (EditText) findViewById(R.id.edit_password_a);
        this.fyw = (EditText) findViewById(R.id.edit_password_b);
        this.fyx = (EditText) findViewById(R.id.edit_password_c);
        this.fyy = (EditText) findViewById(R.id.edit_password_d);
        this.fyF.add(this.fyv);
        this.fyF.add(this.fyw);
        this.fyF.add(this.fyx);
        this.fyF.add(this.fyy);
        this.fyA = (ImageView) findViewById(R.id.edit_dot_a);
        this.fyB = (ImageView) findViewById(R.id.edit_dot_b);
        this.fyC = (ImageView) findViewById(R.id.edit_dot_c);
        this.fyD = (ImageView) findViewById(R.id.edit_dot_d);
        this.fyG.add(this.fyA);
        this.fyG.add(this.fyB);
        this.fyG.add(this.fyC);
        this.fyG.add(this.fyD);
        this.fyE = (FrameLayout) findViewById(R.id.password_click);
        this.fyE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.bCQ();
            }
        });
        bCU();
        bCV();
        bCT();
        bCS();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.fyF) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void bCP() {
        for (EditText editText : this.fyF) {
            editText.getText().clear();
        }
        bCS();
        bCT();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.fyH = aVar;
    }

    public void bCQ() {
        e.mY().removeCallbacks(this.fyJ);
        e.mY().postDelayed(this.fyJ, 300L);
    }

    public void bCR() {
        l.hideSoftKeyPad(getContext(), this.fyv);
    }

    private void bCS() {
        a(this.fyv);
        this.fyv.requestFocus();
        this.fyz = this.fyv;
    }

    private void bCT() {
        for (ImageView imageView : this.fyG) {
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

    private void bCU() {
        int size = this.fyF.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.fyF.get(i2), this.fyF.get(i2 + 1), this.fyG.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.fyF.get(size - 1), this.fyG.get(size - 1));
        }
    }

    private void bCV() {
        for (int size = this.fyF.size() - 1; size > 0; size--) {
            b(this.fyF.get(size), this.fyF.get(size - 1), this.fyG.get(size));
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
                    PasswordView.this.fyz = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fyI.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fyI.put(editText, list);
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
                    e.mY().post(PasswordView.this.fyK);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.fyI.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.fyI.put(editText, list);
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
                    PasswordView.this.fyz = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.fyF) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bCW() {
        for (EditText editText : this.fyF) {
            for (TextWatcher textWatcher : this.fyI.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mY().removeCallbacks(this.fyJ);
        e.mY().removeCallbacks(this.fyK);
        bCW();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.fyF) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.fyG) {
            setEditDotDrawable(imageView);
        }
    }
}
