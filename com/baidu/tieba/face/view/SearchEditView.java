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
    private EditText djI;
    private ImageView djJ;
    private ImageView djK;
    private LinearLayout djL;
    private a djM;

    /* loaded from: classes.dex */
    public interface a {
        void mH(String str);

        void mI(String str);
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
        this.djI = (EditText) findViewById(e.g.edit_search);
        this.djJ = (ImageView) findViewById(e.g.iv_search);
        this.djK = (ImageView) findViewById(e.g.iv_del_all);
        this.djL = (LinearLayout) findViewById(e.g.iv_del_all_layout);
        al.c(this.djJ, e.f.icon_emotion_search);
        al.c(this.djK, e.f.del_search_btn);
        al.h(this.djI, e.d.cp_cont_b);
        this.djI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.djM != null) {
                    SearchEditView.this.djM.mI(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.djL.setVisibility(4);
                } else {
                    SearchEditView.this.djL.setVisibility(0);
                }
            }
        });
        this.djI.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.djI.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.djM != null) {
                        SearchEditView.this.djM.mH(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.djL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.djI.setText("");
            }
        });
        ea(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ea(int i) {
        if (i == 0) {
            this.djI.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        } else {
            this.djI.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.djM = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.djI.setText(str);
            this.djI.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.djI.getText().length()) {
            this.djI.setSelection(i);
        }
    }

    public boolean auS() {
        return this.djI.requestFocus();
    }
}
