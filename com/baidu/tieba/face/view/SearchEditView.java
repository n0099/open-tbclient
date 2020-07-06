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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText hmp;
    private ImageView hmq;
    private ImageView hmr;
    private LinearLayout hms;
    private a hmt;

    /* loaded from: classes.dex */
    public interface a {
        void Es(String str);

        void Et(String str);
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
        this.hmp = (EditText) findViewById(R.id.edit_search);
        this.hmq = (ImageView) findViewById(R.id.iv_search);
        this.hmr = (ImageView) findViewById(R.id.iv_del_all);
        this.hms = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        an.setImageResource(this.hmq, R.drawable.icon_emotion_search);
        an.setImageResource(this.hmr, R.drawable.del_search_btn);
        an.setViewTextColor(this.hmp, (int) R.color.cp_cont_b);
        this.hmp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.hmt != null) {
                    SearchEditView.this.hmt.Et(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.hms.setVisibility(4);
                } else {
                    SearchEditView.this.hms.setVisibility(0);
                }
            }
        });
        this.hmp.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.hmp.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.hmt != null) {
                        SearchEditView.this.hmt.Es(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.hms.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.hmp.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.hmp.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.hmp.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.hmt = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.hmp.setText(str);
            this.hmp.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.hmp.getText().length()) {
            this.hmp.setSelection(i);
        }
    }

    public boolean bTY() {
        return this.hmp.requestFocus();
    }
}
