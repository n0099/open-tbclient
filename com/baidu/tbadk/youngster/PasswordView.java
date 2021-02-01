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
    private EditText gbh;
    private EditText gbi;
    private EditText gbj;
    private EditText gbk;
    private EditText gbl;
    private ImageView gbm;
    private ImageView gbn;
    private ImageView gbo;
    private ImageView gbp;
    private FrameLayout gbq;
    private List<EditText> gbr;
    private List<ImageView> gbs;
    a gbt;
    Map<EditText, List<TextWatcher>> gbu;
    private Runnable gbv;
    private Runnable gbw;

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
        this.gbr = new ArrayList();
        this.gbs = new ArrayList();
        this.gbu = new HashMap();
        this.gbv = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.gbl != null) {
                    l.showSoftKeyPad(PasswordView.this.getContext(), PasswordView.this.gbl);
                }
            }
        };
        this.gbw = new Runnable() { // from class: com.baidu.tbadk.youngster.PasswordView.2
            @Override // java.lang.Runnable
            public void run() {
                if (PasswordView.this.gbt != null) {
                    PasswordView.this.gbt.onComplete();
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_password, this);
        this.gbh = (EditText) findViewById(R.id.edit_password_a);
        this.gbi = (EditText) findViewById(R.id.edit_password_b);
        this.gbj = (EditText) findViewById(R.id.edit_password_c);
        this.gbk = (EditText) findViewById(R.id.edit_password_d);
        this.gbr.add(this.gbh);
        this.gbr.add(this.gbi);
        this.gbr.add(this.gbj);
        this.gbr.add(this.gbk);
        this.gbm = (ImageView) findViewById(R.id.edit_dot_a);
        this.gbn = (ImageView) findViewById(R.id.edit_dot_b);
        this.gbo = (ImageView) findViewById(R.id.edit_dot_c);
        this.gbp = (ImageView) findViewById(R.id.edit_dot_d);
        this.gbs.add(this.gbm);
        this.gbs.add(this.gbn);
        this.gbs.add(this.gbo);
        this.gbs.add(this.gbp);
        this.gbq = (FrameLayout) findViewById(R.id.password_click);
        this.gbq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.PasswordView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PasswordView.this.bIV();
            }
        });
        bIZ();
        bJa();
        bIY();
        bIX();
        onChangeSkinType();
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        for (EditText editText : this.gbr) {
            sb.append(editText.getText().toString());
        }
        return sb.toString();
    }

    public void bIU() {
        for (EditText editText : this.gbr) {
            editText.getText().clear();
        }
        bIX();
        bIY();
    }

    public void setOnPasswordInputComplete(a aVar) {
        this.gbt = aVar;
    }

    public void bIV() {
        e.mA().removeCallbacks(this.gbv);
        e.mA().postDelayed(this.gbv, 300L);
    }

    public void bIW() {
        l.hideSoftKeyPad(getContext(), this.gbh);
    }

    private void bIX() {
        c(this.gbh);
        this.gbh.requestFocus();
        this.gbl = this.gbh;
    }

    private void bIY() {
        for (ImageView imageView : this.gbs) {
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

    private void bIZ() {
        int size = this.gbr.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            a(this.gbr.get(i2), this.gbr.get(i2 + 1), this.gbs.get(i2));
            i = i2 + 1;
        }
        if (size - 1 >= 0) {
            a(this.gbr.get(size - 1), this.gbs.get(size - 1));
        }
    }

    private void bJa() {
        for (int size = this.gbr.size() - 1; size > 0; size--) {
            b(this.gbr.get(size), this.gbr.get(size - 1), this.gbs.get(size));
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
                    PasswordView.this.gbl = editText2;
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.gbu.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.gbu.put(editText, list);
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
                    e.mA().post(PasswordView.this.gbw);
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        editText.addTextChangedListener(textWatcher);
        List<TextWatcher> list = this.gbu.get(editText);
        if (y.isEmpty(list)) {
            list = new ArrayList<>();
            this.gbu.put(editText, list);
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
                    PasswordView.this.gbl = editText2;
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EditText editText) {
        if (editText != null) {
            for (EditText editText2 : this.gbr) {
                editText2.setFocusableInTouchMode(false);
            }
            editText.setFocusableInTouchMode(true);
        }
    }

    private void bJb() {
        for (EditText editText : this.gbr) {
            for (TextWatcher textWatcher : this.gbu.get(editText)) {
                editText.removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.mA().removeCallbacks(this.gbv);
        e.mA().removeCallbacks(this.gbw);
        bJb();
    }

    public void onChangeSkinType() {
        for (EditText editText : this.gbr) {
            setEditBackgroundDrawable(editText);
        }
        for (ImageView imageView : this.gbs) {
            setEditDotDrawable(imageView);
        }
    }
}
