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
    private EditText cfq;
    private ImageView cfr;
    private ImageView cfs;
    private LinearLayout cft;
    private a cfu;

    /* loaded from: classes.dex */
    public interface a {
        void jO(String str);

        void jP(String str);
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
        this.cfq = (EditText) findViewById(d.h.edit_search);
        this.cfr = (ImageView) findViewById(d.h.iv_search);
        this.cfs = (ImageView) findViewById(d.h.iv_del_all);
        this.cft = (LinearLayout) findViewById(d.h.iv_del_all_layout);
        aj.c(this.cfr, d.g.icon_emotion_search);
        aj.c(this.cfs, d.g.del_search_btn);
        aj.i(this.cfq, d.e.cp_cont_b);
        this.cfq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cfu != null) {
                    SearchEditView.this.cfu.jP(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cft.setVisibility(4);
                } else {
                    SearchEditView.this.cft.setVisibility(0);
                }
            }
        });
        this.cfq.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cfq.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cfu != null) {
                        SearchEditView.this.cfu.jO(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cft.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cfq.setText("");
            }
        });
        dE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dE(int i) {
        if (i == 0) {
            this.cfq.setHintTextColor(getResources().getColor(d.e.cp_cont_d));
        } else {
            this.cfq.setHintTextColor(getResources().getColor(d.e.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cfu = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cfq.setText(str);
            this.cfq.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cfq.getText().length()) {
            this.cfq.setSelection(i);
        }
    }

    public boolean adL() {
        return this.cfq.requestFocus();
    }
}
