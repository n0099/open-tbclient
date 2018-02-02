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
    private EditText dpj;
    private ImageView dpk;
    private ImageView dpl;
    private LinearLayout dpm;
    private a dpn;

    /* loaded from: classes.dex */
    public interface a {
        void kN(String str);

        void kO(String str);
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
        this.dpj = (EditText) findViewById(d.g.edit_search);
        this.dpk = (ImageView) findViewById(d.g.iv_search);
        this.dpl = (ImageView) findViewById(d.g.iv_del_all);
        this.dpm = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        aj.c(this.dpk, d.f.icon_emotion_search);
        aj.c(this.dpl, d.f.del_search_btn);
        aj.r(this.dpj, d.C0108d.cp_cont_b);
        this.dpj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.dpn != null) {
                    SearchEditView.this.dpn.kO(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.dpm.setVisibility(4);
                } else {
                    SearchEditView.this.dpm.setVisibility(0);
                }
            }
        });
        this.dpj.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.dpj.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.dpn != null) {
                        SearchEditView.this.dpn.kN(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.dpm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.dpj.setText("");
            }
        });
        gz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void gz(int i) {
        if (i == 0) {
            this.dpj.setHintTextColor(getResources().getColor(d.C0108d.cp_cont_d));
        } else {
            this.dpj.setHintTextColor(getResources().getColor(d.C0108d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.dpn = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.dpj.setText(str);
            this.dpj.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.dpj.getText().length()) {
            this.dpj.setSelection(i);
        }
    }

    public boolean aqB() {
        return this.dpj.requestFocus();
    }
}
