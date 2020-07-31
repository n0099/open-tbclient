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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText hsb;
    private ImageView hsc;
    private ImageView hsd;
    private LinearLayout hse;
    private a hsf;

    /* loaded from: classes.dex */
    public interface a {
        void Fd(String str);

        void Fe(String str);
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
        this.hsb = (EditText) findViewById(R.id.edit_search);
        this.hsc = (ImageView) findViewById(R.id.iv_search);
        this.hsd = (ImageView) findViewById(R.id.iv_del_all);
        this.hse = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        ao.setImageResource(this.hsc, R.drawable.icon_emotion_search);
        ao.setImageResource(this.hsd, R.drawable.del_search_btn);
        ao.setViewTextColor(this.hsb, R.color.cp_cont_b);
        this.hsb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.hsf != null) {
                    SearchEditView.this.hsf.Fe(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.hse.setVisibility(4);
                } else {
                    SearchEditView.this.hse.setVisibility(0);
                }
            }
        });
        this.hsb.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.hsb.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.hsf != null) {
                        SearchEditView.this.hsf.Fd(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.hse.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.hsb.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.hsb.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.hsb.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.hsf = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.hsb.setText(str);
            this.hsb.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.hsb.getText().length()) {
            this.hsb.setSelection(i);
        }
    }

    public boolean bXr() {
        return this.hsb.requestFocus();
    }
}
