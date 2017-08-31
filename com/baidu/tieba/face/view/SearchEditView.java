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
    private EditText ceE;
    private ImageView ceF;
    private ImageView ceG;
    private LinearLayout ceH;
    private a ceI;

    /* loaded from: classes.dex */
    public interface a {
        void jQ(String str);

        void jR(String str);
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
        this.ceE = (EditText) findViewById(d.h.edit_search);
        this.ceF = (ImageView) findViewById(d.h.iv_search);
        this.ceG = (ImageView) findViewById(d.h.iv_del_all);
        this.ceH = (LinearLayout) findViewById(d.h.iv_del_all_layout);
        aj.c(this.ceF, d.g.icon_emotion_search);
        aj.c(this.ceG, d.g.del_search_btn);
        aj.i(this.ceE, d.e.cp_cont_b);
        this.ceE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.ceI != null) {
                    SearchEditView.this.ceI.jR(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.ceH.setVisibility(4);
                } else {
                    SearchEditView.this.ceH.setVisibility(0);
                }
            }
        });
        this.ceE.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.ceE.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.ceI != null) {
                        SearchEditView.this.ceI.jQ(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.ceH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.ceE.setText("");
            }
        });
        du(TbadkCoreApplication.getInst().getSkinType());
    }

    public void du(int i) {
        if (i == 0) {
            this.ceE.setHintTextColor(getResources().getColor(d.e.cp_cont_d));
        } else {
            this.ceE.setHintTextColor(getResources().getColor(d.e.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.ceI = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.ceE.setText(str);
            this.ceE.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.ceE.getText().length()) {
            this.ceE.setSelection(i);
        }
    }

    public boolean adQ() {
        return this.ceE.requestFocus();
    }
}
