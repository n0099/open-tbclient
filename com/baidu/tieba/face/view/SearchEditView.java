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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText cUU;
    private ImageView cUV;
    private ImageView cUW;
    private LinearLayout cUX;
    private a cUY;

    /* loaded from: classes.dex */
    public interface a {
        void lG(String str);

        void lH(String str);
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
        this.cUU = (EditText) findViewById(d.g.edit_search);
        this.cUV = (ImageView) findViewById(d.g.iv_search);
        this.cUW = (ImageView) findViewById(d.g.iv_del_all);
        this.cUX = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        al.c(this.cUV, d.f.icon_emotion_search);
        al.c(this.cUW, d.f.del_search_btn);
        al.h(this.cUU, d.C0141d.cp_cont_b);
        this.cUU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cUY != null) {
                    SearchEditView.this.cUY.lH(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cUX.setVisibility(4);
                } else {
                    SearchEditView.this.cUX.setVisibility(0);
                }
            }
        });
        this.cUU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cUU.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cUY != null) {
                        SearchEditView.this.cUY.lG(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cUU.setText("");
            }
        });
        dC(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dC(int i) {
        if (i == 0) {
            this.cUU.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d));
        } else {
            this.cUU.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cUY = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cUU.setText(str);
            this.cUU.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cUU.getText().length()) {
            this.cUU.setSelection(i);
        }
    }

    public boolean apN() {
        return this.cUU.requestFocus();
    }
}
