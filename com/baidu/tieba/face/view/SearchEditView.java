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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private ImageView hMA;
    private LinearLayout hMB;
    private a hMC;
    private EditText hMy;
    private ImageView hMz;

    /* loaded from: classes.dex */
    public interface a {
        void Ic(String str);

        void Id(String str);
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
        this.hMy = (EditText) findViewById(R.id.edit_search);
        this.hMz = (ImageView) findViewById(R.id.iv_search);
        this.hMA = (ImageView) findViewById(R.id.iv_del_all);
        this.hMB = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        ap.setImageResource(this.hMz, R.drawable.icon_emotion_search);
        ap.setImageResource(this.hMA, R.drawable.del_search_btn);
        ap.setViewTextColor(this.hMy, R.color.cp_cont_b);
        this.hMy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.hMC != null) {
                    SearchEditView.this.hMC.Id(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.hMB.setVisibility(4);
                } else {
                    SearchEditView.this.hMB.setVisibility(0);
                }
            }
        });
        this.hMy.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.hMy.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.hMC != null) {
                        SearchEditView.this.hMC.Ic(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.hMB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.hMy.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.hMy.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.hMy.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.hMC = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.hMy.setText(str);
            this.hMy.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.hMy.getText().length()) {
            this.hMy.setSelection(i);
        }
    }

    public boolean clb() {
        return this.hMy.requestFocus();
    }
}
