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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText ffl;
    private ImageView ffm;
    private ImageView ffn;
    private LinearLayout ffo;
    private a ffp;

    /* loaded from: classes.dex */
    public interface a {
        void wC(String str);

        void wD(String str);
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
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_search_edit, (ViewGroup) this, true);
        this.ffl = (EditText) findViewById(R.id.edit_search);
        this.ffm = (ImageView) findViewById(R.id.iv_search);
        this.ffn = (ImageView) findViewById(R.id.iv_del_all);
        this.ffo = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        am.c(this.ffm, (int) R.drawable.icon_emotion_search);
        am.c(this.ffn, (int) R.drawable.del_search_btn);
        am.j(this.ffl, R.color.cp_cont_b);
        this.ffl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.ffp != null) {
                    SearchEditView.this.ffp.wD(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.ffo.setVisibility(4);
                } else {
                    SearchEditView.this.ffo.setVisibility(0);
                }
            }
        });
        this.ffl.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.ffl.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.ffp != null) {
                        SearchEditView.this.ffp.wC(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.ffo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.ffl.setText("");
            }
        });
        jg(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jg(int i) {
        if (i == 0) {
            this.ffl.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.ffl.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.ffp = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.ffl.setText(str);
            this.ffl.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.ffl.getText().length()) {
            this.ffl.setSelection(i);
        }
    }

    public boolean big() {
        return this.ffl.requestFocus();
    }
}
