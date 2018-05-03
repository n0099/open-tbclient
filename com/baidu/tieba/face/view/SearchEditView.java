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
    private EditText cKH;
    private ImageView cKI;
    private ImageView cKJ;
    private LinearLayout cKK;
    private a cKL;

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
        this.cKH = (EditText) findViewById(d.g.edit_search);
        this.cKI = (ImageView) findViewById(d.g.iv_search);
        this.cKJ = (ImageView) findViewById(d.g.iv_del_all);
        this.cKK = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        ak.c(this.cKI, d.f.icon_emotion_search);
        ak.c(this.cKJ, d.f.del_search_btn);
        ak.h(this.cKH, d.C0126d.cp_cont_b);
        this.cKH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cKL != null) {
                    SearchEditView.this.cKL.kY(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cKK.setVisibility(4);
                } else {
                    SearchEditView.this.cKK.setVisibility(0);
                }
            }
        });
        this.cKH.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cKH.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cKL != null) {
                        SearchEditView.this.cKL.kX(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SearchEditView.this.cKH.setText("");
            }
        });
        dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dz(int i) {
        if (i == 0) {
            this.cKH.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_d));
        } else {
            this.cKH.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cKL = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cKH.setText(str);
            this.cKH.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cKH.getText().length()) {
            this.cKH.setSelection(i);
        }
    }

    public boolean alH() {
        return this.cKH.requestFocus();
    }
}
