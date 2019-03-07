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
    private EditText eIe;
    private ImageView eIf;
    private ImageView eIg;
    private LinearLayout eIh;
    private a eIi;

    /* loaded from: classes.dex */
    public interface a {
        void ug(String str);

        void uh(String str);
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
        this.eIe = (EditText) findViewById(d.g.edit_search);
        this.eIf = (ImageView) findViewById(d.g.iv_search);
        this.eIg = (ImageView) findViewById(d.g.iv_del_all);
        this.eIh = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        al.c(this.eIf, d.f.icon_emotion_search);
        al.c(this.eIg, d.f.del_search_btn);
        al.j(this.eIe, d.C0236d.cp_cont_b);
        this.eIe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.eIi != null) {
                    SearchEditView.this.eIi.uh(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.eIh.setVisibility(4);
                } else {
                    SearchEditView.this.eIh.setVisibility(0);
                }
            }
        });
        this.eIe.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.eIe.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.eIi != null) {
                        SearchEditView.this.eIi.ug(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.eIh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.eIe.setText("");
            }
        });
        ij(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ij(int i) {
        if (i == 0) {
            this.eIe.setHintTextColor(getResources().getColor(d.C0236d.cp_cont_d));
        } else {
            this.eIe.setHintTextColor(getResources().getColor(d.C0236d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.eIi = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.eIe.setText(str);
            this.eIe.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.eIe.getText().length()) {
            this.eIe.setSelection(i);
        }
    }

    public boolean aXR() {
        return this.eIe.requestFocus();
    }
}
