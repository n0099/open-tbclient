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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText cvR;
    private ImageView cvS;
    private ImageView cvT;
    private LinearLayout cvU;
    private a cvV;

    /* loaded from: classes.dex */
    public interface a {
        void kr(String str);

        void ks(String str);
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
        LayoutInflater.from(getContext()).inflate(d.h.emotion_search_edit, (ViewGroup) this, true);
        this.cvR = (EditText) findViewById(d.g.edit_search);
        this.cvS = (ImageView) findViewById(d.g.iv_search);
        this.cvT = (ImageView) findViewById(d.g.iv_del_all);
        this.cvU = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        aj.c(this.cvS, d.f.icon_emotion_search);
        aj.c(this.cvT, d.f.del_search_btn);
        aj.i(this.cvR, d.C0095d.cp_cont_b);
        this.cvR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cvV != null) {
                    SearchEditView.this.cvV.ks(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cvU.setVisibility(4);
                } else {
                    SearchEditView.this.cvU.setVisibility(0);
                }
            }
        });
        this.cvR.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cvR.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cvV != null) {
                        SearchEditView.this.cvV.kr(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cvU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cvR.setText("");
            }
        });
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dE(int i) {
        if (i == 0) {
            this.cvR.setHintTextColor(getResources().getColor(d.C0095d.cp_cont_d));
        } else {
            this.cvR.setHintTextColor(getResources().getColor(d.C0095d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cvV = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cvR.setText(str);
            this.cvR.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cvR.getText().length()) {
            this.cvR.setSelection(i);
        }
    }

    public boolean ahT() {
        return this.cvR.requestFocus();
    }
}
