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
    private EditText gLg;
    private ImageView gLh;
    private ImageView gLi;
    private LinearLayout gLj;
    private a gLk;

    /* loaded from: classes.dex */
    public interface a {
        void Ci(String str);

        void Cj(String str);
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
        this.gLg = (EditText) findViewById(R.id.edit_search);
        this.gLh = (ImageView) findViewById(R.id.iv_search);
        this.gLi = (ImageView) findViewById(R.id.iv_del_all);
        this.gLj = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        am.setImageResource(this.gLh, R.drawable.icon_emotion_search);
        am.setImageResource(this.gLi, R.drawable.del_search_btn);
        am.setViewTextColor(this.gLg, (int) R.color.cp_cont_b);
        this.gLg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.gLk != null) {
                    SearchEditView.this.gLk.Cj(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.gLj.setVisibility(4);
                } else {
                    SearchEditView.this.gLj.setVisibility(0);
                }
            }
        });
        this.gLg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.gLg.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.gLk != null) {
                        SearchEditView.this.gLk.Ci(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.gLj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.gLg.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.gLg.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.gLg.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.gLk = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.gLg.setText(str);
            this.gLg.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.gLg.getText().length()) {
            this.gLg.setSelection(i);
        }
    }

    public boolean bKE() {
        return this.gLg.requestFocus();
    }
}
