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
    private EditText doO;
    private ImageView doP;
    private ImageView doQ;
    private LinearLayout doR;
    private a doS;

    /* loaded from: classes.dex */
    public interface a {
        void kF(String str);

        void kG(String str);
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
        this.doO = (EditText) findViewById(d.g.edit_search);
        this.doP = (ImageView) findViewById(d.g.iv_search);
        this.doQ = (ImageView) findViewById(d.g.iv_del_all);
        this.doR = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        aj.c(this.doP, d.f.icon_emotion_search);
        aj.c(this.doQ, d.f.del_search_btn);
        aj.r(this.doO, d.C0107d.cp_cont_b);
        this.doO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.doS != null) {
                    SearchEditView.this.doS.kG(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.doR.setVisibility(4);
                } else {
                    SearchEditView.this.doR.setVisibility(0);
                }
            }
        });
        this.doO.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.doO.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.doS != null) {
                        SearchEditView.this.doS.kF(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.doR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.doO.setText("");
            }
        });
        gz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void gz(int i) {
        if (i == 0) {
            this.doO.setHintTextColor(getResources().getColor(d.C0107d.cp_cont_d));
        } else {
            this.doO.setHintTextColor(getResources().getColor(d.C0107d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.doS = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.doO.setText(str);
            this.doO.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.doO.getText().length()) {
            this.doO.setSelection(i);
        }
    }

    public boolean aqw() {
        return this.doO.requestFocus();
    }
}
