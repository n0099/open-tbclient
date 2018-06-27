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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText cSW;
    private ImageView cSX;
    private ImageView cSY;
    private LinearLayout cSZ;
    private a cTa;

    /* loaded from: classes.dex */
    public interface a {
        void lC(String str);

        void lD(String str);
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
        LayoutInflater.from(getContext()).inflate(d.i.emotion_search_edit, (ViewGroup) this, true);
        this.cSW = (EditText) findViewById(d.g.edit_search);
        this.cSX = (ImageView) findViewById(d.g.iv_search);
        this.cSY = (ImageView) findViewById(d.g.iv_del_all);
        this.cSZ = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        am.c(this.cSX, d.f.icon_emotion_search);
        am.c(this.cSY, d.f.del_search_btn);
        am.h(this.cSW, d.C0142d.cp_cont_b);
        this.cSW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cTa != null) {
                    SearchEditView.this.cTa.lD(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cSZ.setVisibility(4);
                } else {
                    SearchEditView.this.cSZ.setVisibility(0);
                }
            }
        });
        this.cSW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cSW.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cTa != null) {
                        SearchEditView.this.cTa.lC(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cSZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cSW.setText("");
            }
        });
        dD(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dD(int i) {
        if (i == 0) {
            this.cSW.setHintTextColor(getResources().getColor(d.C0142d.cp_cont_d));
        } else {
            this.cSW.setHintTextColor(getResources().getColor(d.C0142d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cTa = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cSW.setText(str);
            this.cSW.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cSW.getText().length()) {
            this.cSW.setSelection(i);
        }
    }

    public boolean aph() {
        return this.cSW.requestFocus();
    }
}
