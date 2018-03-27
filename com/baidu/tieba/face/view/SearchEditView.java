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
    private EditText drT;
    private ImageView drU;
    private ImageView drV;
    private LinearLayout drW;
    private a drX;

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
        this.drT = (EditText) findViewById(d.g.edit_search);
        this.drU = (ImageView) findViewById(d.g.iv_search);
        this.drV = (ImageView) findViewById(d.g.iv_del_all);
        this.drW = (LinearLayout) findViewById(d.g.iv_del_all_layout);
        aj.c(this.drU, d.f.icon_emotion_search);
        aj.c(this.drV, d.f.del_search_btn);
        aj.r(this.drT, d.C0141d.cp_cont_b);
        this.drT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.drX != null) {
                    SearchEditView.this.drX.kV(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.drW.setVisibility(4);
                } else {
                    SearchEditView.this.drW.setVisibility(0);
                }
            }
        });
        this.drT.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.drT.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.drX != null) {
                        SearchEditView.this.drX.kU(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.drW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.drT.setText("");
            }
        });
        gB(TbadkCoreApplication.getInst().getSkinType());
    }

    public void gB(int i) {
        if (i == 0) {
            this.drT.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d));
        } else {
            this.drT.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.drX = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.drT.setText(str);
            this.drT.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.drT.getText().length()) {
            this.drT.setSelection(i);
        }
    }

    public boolean arr() {
        return this.drT.requestFocus();
    }
}
