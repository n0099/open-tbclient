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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText eHN;
    private ImageView eHO;
    private ImageView eHP;
    private LinearLayout eHQ;
    private a eHR;

    /* loaded from: classes.dex */
    public interface a {
        void ue(String str);

        void uf(String str);
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
        this.eHN = (EditText) findViewById(d.g.edit_search);
        this.eHO = (ImageView) findViewById(d.g.iv_search);
        this.eHP = (ImageView) findViewById(d.g.iv_del_all);
        this.eHQ = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        al.c(this.eHO, d.f.icon_emotion_search);
        al.c(this.eHP, d.f.del_search_btn);
        al.j(this.eHN, d.C0277d.cp_cont_b);
        this.eHN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.eHR != null) {
                    SearchEditView.this.eHR.uf(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.eHQ.setVisibility(4);
                } else {
                    SearchEditView.this.eHQ.setVisibility(0);
                }
            }
        });
        this.eHN.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.eHN.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.eHR != null) {
                        SearchEditView.this.eHR.ue(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.eHQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.eHN.setText("");
            }
        });
        ii(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ii(int i) {
        if (i == 0) {
            this.eHN.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_d));
        } else {
            this.eHN.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.eHR = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.eHN.setText(str);
            this.eHN.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.eHN.getText().length()) {
            this.eHN.setSelection(i);
        }
    }

    public boolean aXO() {
        return this.eHN.requestFocus();
    }
}
