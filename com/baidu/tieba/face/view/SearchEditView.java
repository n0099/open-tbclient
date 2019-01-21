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
    private EditText duN;
    private ImageView duO;
    private ImageView duP;
    private LinearLayout duQ;
    private a duR;

    /* loaded from: classes.dex */
    public interface a {
        void nA(String str);

        void nB(String str);
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
        this.duN = (EditText) findViewById(e.g.edit_search);
        this.duO = (ImageView) findViewById(e.g.iv_search);
        this.duP = (ImageView) findViewById(e.g.iv_del_all);
        this.duQ = (LinearLayout) findViewById(e.g.iv_del_all_layout);
        al.c(this.duO, e.f.icon_emotion_search);
        al.c(this.duP, e.f.del_search_btn);
        al.h(this.duN, e.d.cp_cont_b);
        this.duN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.duR != null) {
                    SearchEditView.this.duR.nB(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.duQ.setVisibility(4);
                } else {
                    SearchEditView.this.duQ.setVisibility(0);
                }
            }
        });
        this.duN.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.duN.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.duR != null) {
                        SearchEditView.this.duR.nA(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.duQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.duN.setText("");
            }
        });
        eD(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eD(int i) {
        if (i == 0) {
            this.duN.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        } else {
            this.duN.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.duR = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.duN.setText(str);
            this.duN.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.duN.getText().length()) {
            this.duN.setSelection(i);
        }
    }

    public boolean axo() {
        return this.duN.requestFocus();
    }
}
