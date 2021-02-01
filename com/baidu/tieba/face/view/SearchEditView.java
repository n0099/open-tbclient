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
    private EditText iSM;
    private ImageView iSN;
    private ImageView iSO;
    private LinearLayout iSP;
    private a iSQ;

    /* loaded from: classes.dex */
    public interface a {
        void Jt(String str);

        void Ju(String str);
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
        this.iSM = (EditText) findViewById(R.id.edit_search);
        this.iSN = (ImageView) findViewById(R.id.iv_search);
        this.iSO = (ImageView) findViewById(R.id.iv_del_all);
        this.iSP = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        ap.setImageResource(this.iSN, R.drawable.icon_emotion_search);
        ap.setImageResource(this.iSO, R.drawable.del_search_btn);
        ap.setViewTextColor(this.iSM, R.color.CAM_X0105);
        this.iSM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.iSQ != null) {
                    SearchEditView.this.iSQ.Ju(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.iSP.setVisibility(4);
                } else {
                    SearchEditView.this.iSP.setVisibility(0);
                }
            }
        });
        this.iSM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.iSM.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.iSQ != null) {
                        SearchEditView.this.iSQ.Jt(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.iSP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.iSM.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.iSM.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        } else {
            this.iSM.setHintTextColor(getResources().getColor(R.color.CAM_X0109_1));
        }
    }

    public void setCallback(a aVar) {
        this.iSQ = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.iSM.setText(str);
            this.iSM.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.iSM.getText().length()) {
            this.iSM.setSelection(i);
        }
    }

    public boolean cyn() {
        return this.iSM.requestFocus();
    }
}
