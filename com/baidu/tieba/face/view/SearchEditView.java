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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private ImageView cmA;
    private LinearLayout cmB;
    private a cmC;
    private EditText cmy;
    private ImageView cmz;

    /* loaded from: classes.dex */
    public interface a {
        void kj(String str);

        void kk(String str);
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
        this.cmy = (EditText) findViewById(d.g.edit_search);
        this.cmz = (ImageView) findViewById(d.g.iv_search);
        this.cmA = (ImageView) findViewById(d.g.iv_del_all);
        this.cmB = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        aj.c(this.cmz, d.f.icon_emotion_search);
        aj.c(this.cmA, d.f.del_search_btn);
        aj.i(this.cmy, d.C0080d.cp_cont_b);
        this.cmy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cmC != null) {
                    SearchEditView.this.cmC.kk(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cmB.setVisibility(4);
                } else {
                    SearchEditView.this.cmB.setVisibility(0);
                }
            }
        });
        this.cmy.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cmy.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cmC != null) {
                        SearchEditView.this.cmC.kj(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cmB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cmy.setText("");
            }
        });
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dE(int i) {
        if (i == 0) {
            this.cmy.setHintTextColor(getResources().getColor(d.C0080d.cp_cont_d));
        } else {
            this.cmy.setHintTextColor(getResources().getColor(d.C0080d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cmC = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cmy.setText(str);
            this.cmy.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cmy.getText().length()) {
            this.cmy.setSelection(i);
        }
    }

    public boolean afN() {
        return this.cmy.requestFocus();
    }
}
