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
    private EditText cbM;
    private ImageView cbN;
    private ImageView cbO;
    private LinearLayout cbP;
    private a cbQ;

    /* loaded from: classes.dex */
    public interface a {
        void jD(String str);

        void jE(String str);
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
        this.cbM = (EditText) findViewById(d.h.edit_search);
        this.cbN = (ImageView) findViewById(d.h.iv_search);
        this.cbO = (ImageView) findViewById(d.h.iv_del_all);
        this.cbP = (LinearLayout) findViewById(d.h.iv_del_all_layout);
        ai.c(this.cbN, d.g.icon_emotion_search);
        ai.c(this.cbO, d.g.del_search_btn);
        this.cbM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cbQ != null) {
                    SearchEditView.this.cbQ.jE(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cbP.setVisibility(4);
                } else {
                    SearchEditView.this.cbP.setVisibility(0);
                }
            }
        });
        this.cbM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cbM.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cbQ != null) {
                        SearchEditView.this.cbQ.jD(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cbP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cbM.setText("");
            }
        });
    }

    public void setCallback(a aVar) {
        this.cbQ = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cbM.setText(str);
            this.cbM.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cbM.getText().length()) {
            this.cbM.setSelection(i);
        }
    }

    public boolean acW() {
        return this.cbM.requestFocus();
    }
}
