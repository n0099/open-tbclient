package com.baidu.tieba.face.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText cKK;
    private ImageView cKL;
    private ImageView cKM;
    private LinearLayout cKN;
    private a cKO;

    /* loaded from: classes.dex */
    public interface a {
        void kX(String str);

        void kY(String str);
    }

    public SearchEditView(Context context) {
        super(context);
        init();
    }

    public SearchEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SearchEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.emotion_search_edit, (ViewGroup) this, true);
        this.cKK = (EditText) findViewById(d.g.edit_search);
        this.cKL = (ImageView) findViewById(d.g.iv_search);
        this.cKM = (ImageView) findViewById(d.g.iv_del_all);
        this.cKN = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        ak.c(this.cKL, d.f.icon_emotion_search);
        ak.c(this.cKM, d.f.del_search_btn);
        ak.h(this.cKK, d.C0126d.cp_cont_b);
        this.cKK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cKO != null) {
                    SearchEditView.this.cKO.kY(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cKN.setVisibility(4);
                } else {
                    SearchEditView.this.cKN.setVisibility(0);
                }
            }
        });
        this.cKK.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cKK.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cKO != null) {
                        SearchEditView.this.cKO.kX(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cKN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SearchEditView.this.cKK.setText("");
            }
        });
        dA(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dA(int i) {
        if (i == 0) {
            this.cKK.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_d));
        } else {
            this.cKK.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cKO = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cKK.setText(str);
            this.cKK.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cKK.getText().length()) {
            this.cKK.setSelection(i);
        }
    }

    public boolean alH() {
        return this.cKK.requestFocus();
    }
}
