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
    private EditText cfe;
    private ImageView cff;
    private ImageView cfg;
    private LinearLayout cfh;
    private a cfi;

    /* loaded from: classes.dex */
    public interface a {
        void jM(String str);

        void jN(String str);
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
        this.cfe = (EditText) findViewById(d.h.edit_search);
        this.cff = (ImageView) findViewById(d.h.iv_search);
        this.cfg = (ImageView) findViewById(d.h.iv_del_all);
        this.cfh = (LinearLayout) findViewById(d.h.iv_del_all_layout);
        aj.c(this.cff, d.g.icon_emotion_search);
        aj.c(this.cfg, d.g.del_search_btn);
        aj.i(this.cfe, d.e.cp_cont_b);
        this.cfe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cfi != null) {
                    SearchEditView.this.cfi.jN(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cfh.setVisibility(4);
                } else {
                    SearchEditView.this.cfh.setVisibility(0);
                }
            }
        });
        this.cfe.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cfe.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cfi != null) {
                        SearchEditView.this.cfi.jM(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cfh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cfe.setText("");
            }
        });
        dD(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dD(int i) {
        if (i == 0) {
            this.cfe.setHintTextColor(getResources().getColor(d.e.cp_cont_d));
        } else {
            this.cfe.setHintTextColor(getResources().getColor(d.e.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cfi = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cfe.setText(str);
            this.cfe.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cfe.getText().length()) {
            this.cfe.setSelection(i);
        }
    }

    public boolean adG() {
        return this.cfe.requestFocus();
    }
}
