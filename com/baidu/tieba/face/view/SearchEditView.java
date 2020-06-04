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
    private EditText had;
    private ImageView hae;
    private ImageView haf;
    private LinearLayout hag;
    private a hah;

    /* loaded from: classes.dex */
    public interface a {
        void DR(String str);

        void DS(String str);
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
        this.had = (EditText) findViewById(R.id.edit_search);
        this.hae = (ImageView) findViewById(R.id.iv_search);
        this.haf = (ImageView) findViewById(R.id.iv_del_all);
        this.hag = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        am.setImageResource(this.hae, R.drawable.icon_emotion_search);
        am.setImageResource(this.haf, R.drawable.del_search_btn);
        am.setViewTextColor(this.had, (int) R.color.cp_cont_b);
        this.had.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.hah != null) {
                    SearchEditView.this.hah.DS(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.hag.setVisibility(4);
                } else {
                    SearchEditView.this.hag.setVisibility(0);
                }
            }
        });
        this.had.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.had.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.hah != null) {
                        SearchEditView.this.hah.DR(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.hag.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.had.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.had.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.had.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.hah = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.had.setText(str);
            this.had.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.had.getText().length()) {
            this.had.setSelection(i);
        }
    }

    public boolean bRb() {
        return this.had.requestFocus();
    }
}
