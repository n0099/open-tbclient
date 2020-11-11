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
    private EditText itS;
    private ImageView itT;
    private ImageView itU;
    private LinearLayout itV;
    private a itW;

    /* loaded from: classes.dex */
    public interface a {
        void JF(String str);

        void JG(String str);
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
        this.itS = (EditText) findViewById(R.id.edit_search);
        this.itT = (ImageView) findViewById(R.id.iv_search);
        this.itU = (ImageView) findViewById(R.id.iv_del_all);
        this.itV = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        ap.setImageResource(this.itT, R.drawable.icon_emotion_search);
        ap.setImageResource(this.itU, R.drawable.del_search_btn);
        ap.setViewTextColor(this.itS, R.color.cp_cont_b);
        this.itS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.itW != null) {
                    SearchEditView.this.itW.JG(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.itV.setVisibility(4);
                } else {
                    SearchEditView.this.itV.setVisibility(0);
                }
            }
        });
        this.itS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.itS.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.itW != null) {
                        SearchEditView.this.itW.JF(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.itV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.itS.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.itS.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.itS.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.itW = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.itS.setText(str);
            this.itS.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.itS.getText().length()) {
            this.itS.setSelection(i);
        }
    }

    public boolean cuh() {
        return this.itS.requestFocus();
    }
}
