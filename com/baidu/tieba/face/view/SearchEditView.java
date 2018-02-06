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
    private EditText dsc;
    private ImageView dsd;
    private ImageView dse;
    private LinearLayout dsf;
    private a dsg;

    /* loaded from: classes.dex */
    public interface a {
        void kU(String str);

        void kV(String str);
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
        this.dsc = (EditText) findViewById(d.g.edit_search);
        this.dsd = (ImageView) findViewById(d.g.iv_search);
        this.dse = (ImageView) findViewById(d.g.iv_del_all);
        this.dsf = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        aj.c(this.dsd, d.f.icon_emotion_search);
        aj.c(this.dse, d.f.del_search_btn);
        aj.r(this.dsc, d.C0140d.cp_cont_b);
        this.dsc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.dsg != null) {
                    SearchEditView.this.dsg.kV(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.dsf.setVisibility(4);
                } else {
                    SearchEditView.this.dsf.setVisibility(0);
                }
            }
        });
        this.dsc.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.dsc.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.dsg != null) {
                        SearchEditView.this.dsg.kU(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.dsf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.dsc.setText("");
            }
        });
        gB(TbadkCoreApplication.getInst().getSkinType());
    }

    public void gB(int i) {
        if (i == 0) {
            this.dsc.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_d));
        } else {
            this.dsc.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.dsg = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.dsc.setText(str);
            this.dsc.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.dsc.getText().length()) {
            this.dsc.setSelection(i);
        }
    }

    public boolean arr() {
        return this.dsc.requestFocus();
    }
}
