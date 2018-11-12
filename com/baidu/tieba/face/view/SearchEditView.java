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
    private EditText dkN;
    private ImageView dkO;
    private ImageView dkP;
    private LinearLayout dkQ;
    private a dkR;

    /* loaded from: classes.dex */
    public interface a {
        void mI(String str);

        void mJ(String str);
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
        this.dkN = (EditText) findViewById(e.g.edit_search);
        this.dkO = (ImageView) findViewById(e.g.iv_search);
        this.dkP = (ImageView) findViewById(e.g.iv_del_all);
        this.dkQ = (LinearLayout) findViewById(e.g.iv_del_all_layout);
        al.c(this.dkO, e.f.icon_emotion_search);
        al.c(this.dkP, e.f.del_search_btn);
        al.h(this.dkN, e.d.cp_cont_b);
        this.dkN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.dkR != null) {
                    SearchEditView.this.dkR.mJ(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.dkQ.setVisibility(4);
                } else {
                    SearchEditView.this.dkQ.setVisibility(0);
                }
            }
        });
        this.dkN.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.dkN.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.dkR != null) {
                        SearchEditView.this.dkR.mI(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.dkQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.dkN.setText("");
            }
        });
        eo(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eo(int i) {
        if (i == 0) {
            this.dkN.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        } else {
            this.dkN.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.dkR = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.dkN.setText(str);
            this.dkN.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.dkN.getText().length()) {
            this.dkN.setSelection(i);
        }
    }

    public boolean aur() {
        return this.dkN.requestFocus();
    }
}
