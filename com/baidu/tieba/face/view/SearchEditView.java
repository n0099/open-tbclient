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
    private EditText fhh;
    private ImageView fhi;
    private ImageView fhj;
    private LinearLayout fhk;
    private a fhl;

    /* loaded from: classes.dex */
    public interface a {
        void va(String str);

        void vb(String str);
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
        this.fhh = (EditText) findViewById(R.id.edit_search);
        this.fhi = (ImageView) findViewById(R.id.iv_search);
        this.fhj = (ImageView) findViewById(R.id.iv_del_all);
        this.fhk = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        am.setImageResource(this.fhi, R.drawable.icon_emotion_search);
        am.setImageResource(this.fhj, R.drawable.del_search_btn);
        am.setViewTextColor(this.fhh, (int) R.color.cp_cont_b);
        this.fhh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.fhl != null) {
                    SearchEditView.this.fhl.vb(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.fhk.setVisibility(4);
                } else {
                    SearchEditView.this.fhk.setVisibility(0);
                }
            }
        });
        this.fhh.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.fhh.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.fhl != null) {
                        SearchEditView.this.fhl.va(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.fhk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.fhh.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.fhh.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.fhh.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.fhl = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.fhh.setText(str);
            this.fhh.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.fhh.getText().length()) {
            this.fhh.setSelection(i);
        }
    }

    public boolean bfW() {
        return this.fhh.requestFocus();
    }
}
