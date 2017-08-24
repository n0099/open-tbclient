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
    private EditText cbN;
    private ImageView cbO;
    private ImageView cbP;
    private LinearLayout cbQ;
    private a cbR;

    /* loaded from: classes.dex */
    public interface a {
        void jG(String str);

        void jH(String str);
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
        this.cbN = (EditText) findViewById(d.h.edit_search);
        this.cbO = (ImageView) findViewById(d.h.iv_search);
        this.cbP = (ImageView) findViewById(d.h.iv_del_all);
        this.cbQ = (LinearLayout) findViewById(d.h.iv_del_all_layout);
        ai.c(this.cbO, d.g.icon_emotion_search);
        ai.c(this.cbP, d.g.del_search_btn);
        this.cbN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cbR != null) {
                    SearchEditView.this.cbR.jH(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cbQ.setVisibility(4);
                } else {
                    SearchEditView.this.cbQ.setVisibility(0);
                }
            }
        });
        this.cbN.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cbN.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cbR != null) {
                        SearchEditView.this.cbR.jG(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cbQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cbN.setText("");
            }
        });
    }

    public void setCallback(a aVar) {
        this.cbR = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cbN.setText(str);
            this.cbN.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cbN.getText().length()) {
            this.cbN.setSelection(i);
        }
    }

    public boolean acS() {
        return this.cbN.requestFocus();
    }
}
