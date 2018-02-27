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
    private EditText drQ;
    private ImageView drR;
    private ImageView drS;
    private LinearLayout drT;
    private a drU;

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
        this.drQ = (EditText) findViewById(d.g.edit_search);
        this.drR = (ImageView) findViewById(d.g.iv_search);
        this.drS = (ImageView) findViewById(d.g.iv_del_all);
        this.drT = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        aj.c(this.drR, d.f.icon_emotion_search);
        aj.c(this.drS, d.f.del_search_btn);
        aj.r(this.drQ, d.C0141d.cp_cont_b);
        this.drQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.drU != null) {
                    SearchEditView.this.drU.kV(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.drT.setVisibility(4);
                } else {
                    SearchEditView.this.drT.setVisibility(0);
                }
            }
        });
        this.drQ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.drQ.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.drU != null) {
                        SearchEditView.this.drU.kU(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.drT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.drQ.setText("");
            }
        });
        gB(TbadkCoreApplication.getInst().getSkinType());
    }

    public void gB(int i) {
        if (i == 0) {
            this.drQ.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d));
        } else {
            this.drQ.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.drU = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.drQ.setText(str);
            this.drQ.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.drQ.getText().length()) {
            this.drQ.setSelection(i);
        }
    }

    public boolean arq() {
        return this.drQ.requestFocus();
    }
}
