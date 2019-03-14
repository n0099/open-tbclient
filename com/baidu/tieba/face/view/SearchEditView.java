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
    private EditText eIa;
    private ImageView eIb;
    private ImageView eIc;
    private LinearLayout eId;
    private a eIe;

    /* loaded from: classes.dex */
    public interface a {
        void uf(String str);

        void ug(String str);
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
        this.eIa = (EditText) findViewById(d.g.edit_search);
        this.eIb = (ImageView) findViewById(d.g.iv_search);
        this.eIc = (ImageView) findViewById(d.g.iv_del_all);
        this.eId = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        al.c(this.eIb, d.f.icon_emotion_search);
        al.c(this.eIc, d.f.del_search_btn);
        al.j(this.eIa, d.C0277d.cp_cont_b);
        this.eIa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.eIe != null) {
                    SearchEditView.this.eIe.ug(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.eId.setVisibility(4);
                } else {
                    SearchEditView.this.eId.setVisibility(0);
                }
            }
        });
        this.eIa.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.eIa.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.eIe != null) {
                        SearchEditView.this.eIe.uf(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.eId.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.eIa.setText("");
            }
        });
        ij(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ij(int i) {
        if (i == 0) {
            this.eIa.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_d));
        } else {
            this.eIa.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.eIe = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.eIa.setText(str);
            this.eIa.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.eIa.getText().length()) {
            this.eIa.setSelection(i);
        }
    }

    public boolean aXR() {
        return this.eIa.requestFocus();
    }
}
