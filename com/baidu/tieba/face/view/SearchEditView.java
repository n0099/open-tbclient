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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText cba;
    private ImageView cbb;
    private ImageView cbc;
    private LinearLayout cbd;
    private a cbe;

    /* loaded from: classes.dex */
    public interface a {
        void jB(String str);

        void jC(String str);
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
        LayoutInflater.from(getContext()).inflate(d.j.emotion_search_edit, (ViewGroup) this, true);
        this.cba = (EditText) findViewById(d.h.edit_search);
        this.cbb = (ImageView) findViewById(d.h.iv_search);
        this.cbc = (ImageView) findViewById(d.h.iv_del_all);
        this.cbd = (LinearLayout) findViewById(d.h.iv_del_all_layout);
        ai.c(this.cbb, d.g.icon_emotion_search);
        ai.c(this.cbc, d.g.del_search_btn);
        this.cba.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cbe != null) {
                    SearchEditView.this.cbe.jC(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cbd.setVisibility(4);
                } else {
                    SearchEditView.this.cbd.setVisibility(0);
                }
            }
        });
        this.cba.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cba.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cbe != null) {
                        SearchEditView.this.cbe.jB(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cbd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cba.setText("");
            }
        });
    }

    public void setCallback(a aVar) {
        this.cbe = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cba.setText(str);
            this.cba.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cba.getText().length()) {
            this.cba.setSelection(i);
        }
    }

    public boolean acB() {
        return this.cba.requestFocus();
    }
}
