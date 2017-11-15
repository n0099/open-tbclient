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
    private EditText cmR;
    private ImageView cmS;
    private ImageView cmT;
    private LinearLayout cmU;
    private a cmV;

    /* loaded from: classes.dex */
    public interface a {
        void kk(String str);

        void kl(String str);
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
        this.cmR = (EditText) findViewById(d.g.edit_search);
        this.cmS = (ImageView) findViewById(d.g.iv_search);
        this.cmT = (ImageView) findViewById(d.g.iv_del_all);
        this.cmU = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        aj.c(this.cmS, d.f.icon_emotion_search);
        aj.c(this.cmT, d.f.del_search_btn);
        aj.i(this.cmR, d.C0080d.cp_cont_b);
        this.cmR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cmV != null) {
                    SearchEditView.this.cmV.kl(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cmU.setVisibility(4);
                } else {
                    SearchEditView.this.cmU.setVisibility(0);
                }
            }
        });
        this.cmR.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cmR.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cmV != null) {
                        SearchEditView.this.cmV.kk(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cmU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cmR.setText("");
            }
        });
        dD(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dD(int i) {
        if (i == 0) {
            this.cmR.setHintTextColor(getResources().getColor(d.C0080d.cp_cont_d));
        } else {
            this.cmR.setHintTextColor(getResources().getColor(d.C0080d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cmV = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cmR.setText(str);
            this.cmR.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cmR.getText().length()) {
            this.cmR.setSelection(i);
        }
    }

    public boolean agb() {
        return this.cmR.requestFocus();
    }
}
