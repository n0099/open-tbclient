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
    private ImageView dbA;
    private LinearLayout dbB;
    private a dbC;
    private EditText dby;
    private ImageView dbz;

    /* loaded from: classes.dex */
    public interface a {
        void mf(String str);

        void mg(String str);
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
        this.dby = (EditText) findViewById(e.g.edit_search);
        this.dbz = (ImageView) findViewById(e.g.iv_search);
        this.dbA = (ImageView) findViewById(e.g.iv_del_all);
        this.dbB = (LinearLayout) findViewById(e.g.iv_del_all_layout);
        al.c(this.dbz, e.f.icon_emotion_search);
        al.c(this.dbA, e.f.del_search_btn);
        al.h(this.dby, e.d.cp_cont_b);
        this.dby.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.dbC != null) {
                    SearchEditView.this.dbC.mg(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.dbB.setVisibility(4);
                } else {
                    SearchEditView.this.dbB.setVisibility(0);
                }
            }
        });
        this.dby.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.dby.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.dbC != null) {
                        SearchEditView.this.dbC.mf(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.dbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.dby.setText("");
            }
        });
        dQ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dQ(int i) {
        if (i == 0) {
            this.dby.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        } else {
            this.dby.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.dbC = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.dby.setText(str);
            this.dby.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.dby.getText().length()) {
            this.dby.setSelection(i);
        }
    }

    public boolean arw() {
        return this.dby.requestFocus();
    }
}
