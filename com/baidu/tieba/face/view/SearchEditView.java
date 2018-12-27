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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText dud;
    private ImageView due;
    private ImageView duf;
    private LinearLayout dug;
    private a duh;

    /* loaded from: classes.dex */
    public interface a {
        void nk(String str);

        void nl(String str);
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
        LayoutInflater.from(getContext()).inflate(e.h.emotion_search_edit, (ViewGroup) this, true);
        this.dud = (EditText) findViewById(e.g.edit_search);
        this.due = (ImageView) findViewById(e.g.iv_search);
        this.duf = (ImageView) findViewById(e.g.iv_del_all);
        this.dug = (LinearLayout) findViewById(e.g.iv_del_all_layout);
        al.c(this.due, e.f.icon_emotion_search);
        al.c(this.duf, e.f.del_search_btn);
        al.h(this.dud, e.d.cp_cont_b);
        this.dud.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.duh != null) {
                    SearchEditView.this.duh.nl(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.dug.setVisibility(4);
                } else {
                    SearchEditView.this.dug.setVisibility(0);
                }
            }
        });
        this.dud.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.dud.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.duh != null) {
                        SearchEditView.this.duh.nk(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.dug.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.dud.setText("");
            }
        });
        eD(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eD(int i) {
        if (i == 0) {
            this.dud.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        } else {
            this.dud.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.duh = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.dud.setText(str);
            this.dud.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.dud.getText().length()) {
            this.dud.setSelection(i);
        }
    }

    public boolean awR() {
        return this.dud.requestFocus();
    }
}
