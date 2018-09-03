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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText cVF;
    private ImageView cVG;
    private ImageView cVH;
    private LinearLayout cVI;
    private a cVJ;

    /* loaded from: classes.dex */
    public interface a {
        void lD(String str);

        void lE(String str);
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
        LayoutInflater.from(getContext()).inflate(f.h.emotion_search_edit, (ViewGroup) this, true);
        this.cVF = (EditText) findViewById(f.g.edit_search);
        this.cVG = (ImageView) findViewById(f.g.iv_search);
        this.cVH = (ImageView) findViewById(f.g.iv_del_all);
        this.cVI = (LinearLayout) findViewById(f.g.iv_del_all_layout);
        am.c(this.cVG, f.C0146f.icon_emotion_search);
        am.c(this.cVH, f.C0146f.del_search_btn);
        am.h(this.cVF, f.d.cp_cont_b);
        this.cVF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cVJ != null) {
                    SearchEditView.this.cVJ.lE(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cVI.setVisibility(4);
                } else {
                    SearchEditView.this.cVI.setVisibility(0);
                }
            }
        });
        this.cVF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cVF.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cVJ != null) {
                        SearchEditView.this.cVJ.lD(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cVI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cVF.setText("");
            }
        });
        dF(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dF(int i) {
        if (i == 0) {
            this.cVF.setHintTextColor(getResources().getColor(f.d.cp_cont_d));
        } else {
            this.cVF.setHintTextColor(getResources().getColor(f.d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cVJ = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cVF.setText(str);
            this.cVF.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cVF.getText().length()) {
            this.cVF.setSelection(i);
        }
    }

    public boolean apI() {
        return this.cVF.requestFocus();
    }
}
