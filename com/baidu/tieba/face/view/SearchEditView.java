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
    private EditText cvE;
    private ImageView cvF;
    private ImageView cvG;
    private LinearLayout cvH;
    private a cvI;

    /* loaded from: classes.dex */
    public interface a {
        void kt(String str);

        void ku(String str);
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
        this.cvE = (EditText) findViewById(d.g.edit_search);
        this.cvF = (ImageView) findViewById(d.g.iv_search);
        this.cvG = (ImageView) findViewById(d.g.iv_del_all);
        this.cvH = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        aj.c(this.cvF, d.f.icon_emotion_search);
        aj.c(this.cvG, d.f.del_search_btn);
        aj.i(this.cvE, d.C0082d.cp_cont_b);
        this.cvE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cvI != null) {
                    SearchEditView.this.cvI.ku(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cvH.setVisibility(4);
                } else {
                    SearchEditView.this.cvH.setVisibility(0);
                }
            }
        });
        this.cvE.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cvE.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cvI != null) {
                        SearchEditView.this.cvI.kt(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cvH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cvE.setText("");
            }
        });
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dE(int i) {
        if (i == 0) {
            this.cvE.setHintTextColor(getResources().getColor(d.C0082d.cp_cont_d));
        } else {
            this.cvE.setHintTextColor(getResources().getColor(d.C0082d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cvI = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cvE.setText(str);
            this.cvE.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cvE.getText().length()) {
            this.cvE.setSelection(i);
        }
    }

    public boolean ahM() {
        return this.cvE.requestFocus();
    }
}
