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
    private EditText iRM;
    private ImageView iRN;
    private ImageView iRO;
    private LinearLayout iRP;
    private a iRQ;

    /* loaded from: classes.dex */
    public interface a {
        void JT(String str);

        void JU(String str);
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
        this.iRM = (EditText) findViewById(R.id.edit_search);
        this.iRN = (ImageView) findViewById(R.id.iv_search);
        this.iRO = (ImageView) findViewById(R.id.iv_del_all);
        this.iRP = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        ao.setImageResource(this.iRN, R.drawable.icon_emotion_search);
        ao.setImageResource(this.iRO, R.drawable.del_search_btn);
        ao.setViewTextColor(this.iRM, R.color.CAM_X0105);
        this.iRM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.iRQ != null) {
                    SearchEditView.this.iRQ.JU(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.iRP.setVisibility(4);
                } else {
                    SearchEditView.this.iRP.setVisibility(0);
                }
            }
        });
        this.iRM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.iRM.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.iRQ != null) {
                        SearchEditView.this.iRQ.JT(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.iRP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.iRM.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.iRM.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        } else {
            this.iRM.setHintTextColor(getResources().getColor(R.color.CAM_X0109_1));
        }
    }

    public void setCallback(a aVar) {
        this.iRQ = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.iRM.setText(str);
            this.iRM.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.iRM.getText().length()) {
            this.iRM.setSelection(i);
        }
    }

    public boolean cAU() {
        return this.iRM.requestFocus();
    }
}
