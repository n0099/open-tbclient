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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText cVJ;
    private ImageView cVK;
    private ImageView cVL;
    private LinearLayout cVM;
    private a cVN;

    /* loaded from: classes.dex */
    public interface a {
        void lB(String str);

        void lC(String str);
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
        this.cVJ = (EditText) findViewById(d.g.edit_search);
        this.cVK = (ImageView) findViewById(d.g.iv_search);
        this.cVL = (ImageView) findViewById(d.g.iv_del_all);
        this.cVM = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        am.c(this.cVK, d.f.icon_emotion_search);
        am.c(this.cVL, d.f.del_search_btn);
        am.h(this.cVJ, d.C0140d.cp_cont_b);
        this.cVJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cVN != null) {
                    SearchEditView.this.cVN.lC(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cVM.setVisibility(4);
                } else {
                    SearchEditView.this.cVM.setVisibility(0);
                }
            }
        });
        this.cVJ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cVJ.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cVN != null) {
                        SearchEditView.this.cVN.lB(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cVJ.setText("");
            }
        });
        dG(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dG(int i) {
        if (i == 0) {
            this.cVJ.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_d));
        } else {
            this.cVJ.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cVN = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cVJ.setText(str);
            this.cVJ.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cVJ.getText().length()) {
            this.cVJ.setSelection(i);
        }
    }

    public boolean apI() {
        return this.cVJ.requestFocus();
    }
}
