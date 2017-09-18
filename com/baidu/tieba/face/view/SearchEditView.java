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
    private a cfA;
    private EditText cfw;
    private ImageView cfx;
    private ImageView cfy;
    private LinearLayout cfz;

    /* loaded from: classes.dex */
    public interface a {
        void jS(String str);

        void jT(String str);
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
        this.cfw = (EditText) findViewById(d.h.edit_search);
        this.cfx = (ImageView) findViewById(d.h.iv_search);
        this.cfy = (ImageView) findViewById(d.h.iv_del_all);
        this.cfz = (LinearLayout) findViewById(d.h.iv_del_all_layout);
        aj.c(this.cfx, d.g.icon_emotion_search);
        aj.c(this.cfy, d.g.del_search_btn);
        aj.i(this.cfw, d.e.cp_cont_b);
        this.cfw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.cfA != null) {
                    SearchEditView.this.cfA.jT(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.cfz.setVisibility(4);
                } else {
                    SearchEditView.this.cfz.setVisibility(0);
                }
            }
        });
        this.cfw.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.cfw.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.cfA != null) {
                        SearchEditView.this.cfA.jS(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.cfz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.cfw.setText("");
            }
        });
        du(TbadkCoreApplication.getInst().getSkinType());
    }

    public void du(int i) {
        if (i == 0) {
            this.cfw.setHintTextColor(getResources().getColor(d.e.cp_cont_d));
        } else {
            this.cfw.setHintTextColor(getResources().getColor(d.e.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.cfA = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.cfw.setText(str);
            this.cfw.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.cfw.getText().length()) {
            this.cfw.setSelection(i);
        }
    }

    public boolean aeb() {
        return this.cfw.requestFocus();
    }
}
