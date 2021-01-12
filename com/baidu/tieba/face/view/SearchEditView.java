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
    private EditText iNf;
    private ImageView iNg;
    private ImageView iNh;
    private LinearLayout iNi;
    private a iNj;

    /* loaded from: classes.dex */
    public interface a {
        void II(String str);

        void IJ(String str);
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
        this.iNf = (EditText) findViewById(R.id.edit_search);
        this.iNg = (ImageView) findViewById(R.id.iv_search);
        this.iNh = (ImageView) findViewById(R.id.iv_del_all);
        this.iNi = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        ao.setImageResource(this.iNg, R.drawable.icon_emotion_search);
        ao.setImageResource(this.iNh, R.drawable.del_search_btn);
        ao.setViewTextColor(this.iNf, R.color.CAM_X0105);
        this.iNf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.iNj != null) {
                    SearchEditView.this.iNj.IJ(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.iNi.setVisibility(4);
                } else {
                    SearchEditView.this.iNi.setVisibility(0);
                }
            }
        });
        this.iNf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.iNf.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.iNj != null) {
                        SearchEditView.this.iNj.II(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.iNi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.iNf.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.iNf.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        } else {
            this.iNf.setHintTextColor(getResources().getColor(R.color.CAM_X0109_1));
        }
    }

    public void setCallback(a aVar) {
        this.iNj = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.iNf.setText(str);
            this.iNf.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.iNf.getText().length()) {
            this.iNf.setSelection(i);
        }
    }

    public boolean cxc() {
        return this.iNf.requestFocus();
    }
}
