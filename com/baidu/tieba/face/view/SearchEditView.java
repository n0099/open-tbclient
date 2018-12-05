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
    private EditText drp;
    private ImageView drq;
    private ImageView drr;
    private LinearLayout drs;
    private a drt;

    /* loaded from: classes.dex */
    public interface a {
        void nh(String str);

        void ni(String str);
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
        this.drp = (EditText) findViewById(e.g.edit_search);
        this.drq = (ImageView) findViewById(e.g.iv_search);
        this.drr = (ImageView) findViewById(e.g.iv_del_all);
        this.drs = (LinearLayout) findViewById(e.g.iv_del_all_layout);
        al.c(this.drq, e.f.icon_emotion_search);
        al.c(this.drr, e.f.del_search_btn);
        al.h(this.drp, e.d.cp_cont_b);
        this.drp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.drt != null) {
                    SearchEditView.this.drt.ni(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.drs.setVisibility(4);
                } else {
                    SearchEditView.this.drs.setVisibility(0);
                }
            }
        });
        this.drp.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.drp.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.drt != null) {
                        SearchEditView.this.drt.nh(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.drs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.drp.setText("");
            }
        });
        eC(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eC(int i) {
        if (i == 0) {
            this.drp.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        } else {
            this.drp.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.drt = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.drp.setText(str);
            this.drp.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.drp.getText().length()) {
            this.drp.setSelection(i);
        }
    }

    public boolean awc() {
        return this.drp.requestFocus();
    }
}
