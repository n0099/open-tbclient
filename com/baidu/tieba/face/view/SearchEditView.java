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
    private ImageView fdA;
    private LinearLayout fdB;
    private a fdC;
    private EditText fdy;
    private ImageView fdz;

    /* loaded from: classes.dex */
    public interface a {
        void wd(String str);

        void we(String str);
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
        this.fdy = (EditText) findViewById(R.id.edit_search);
        this.fdz = (ImageView) findViewById(R.id.iv_search);
        this.fdA = (ImageView) findViewById(R.id.iv_del_all);
        this.fdB = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        am.c(this.fdz, (int) R.drawable.icon_emotion_search);
        am.c(this.fdA, (int) R.drawable.del_search_btn);
        am.j(this.fdy, R.color.cp_cont_b);
        this.fdy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.fdC != null) {
                    SearchEditView.this.fdC.we(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.fdB.setVisibility(4);
                } else {
                    SearchEditView.this.fdB.setVisibility(0);
                }
            }
        });
        this.fdy.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.fdy.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.fdC != null) {
                        SearchEditView.this.fdC.wd(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.fdB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.fdy.setText("");
            }
        });
        jd(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jd(int i) {
        if (i == 0) {
            this.fdy.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.fdy.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.fdC = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.fdy.setText(str);
            this.fdy.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.fdy.getText().length()) {
            this.fdy.setSelection(i);
        }
    }

    public boolean bhv() {
        return this.fdy.requestFocus();
    }
}
