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
    private EditText iFA;
    private ImageView iFB;
    private ImageView iFC;
    private LinearLayout iFD;
    private a iFE;

    /* loaded from: classes.dex */
    public interface a {
        void JW(String str);

        void JX(String str);
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
        this.iFA = (EditText) findViewById(R.id.edit_search);
        this.iFB = (ImageView) findViewById(R.id.iv_search);
        this.iFC = (ImageView) findViewById(R.id.iv_del_all);
        this.iFD = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        ap.setImageResource(this.iFB, R.drawable.icon_emotion_search);
        ap.setImageResource(this.iFC, R.drawable.del_search_btn);
        ap.setViewTextColor(this.iFA, R.color.CAM_X0105);
        this.iFA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.iFE != null) {
                    SearchEditView.this.iFE.JX(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.iFD.setVisibility(4);
                } else {
                    SearchEditView.this.iFD.setVisibility(0);
                }
            }
        });
        this.iFA.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.iFA.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.iFE != null) {
                        SearchEditView.this.iFE.JW(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.iFD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.iFA.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.iFA.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        } else {
            this.iFA.setHintTextColor(getResources().getColor(R.color.CAM_X0109_1));
        }
    }

    public void setCallback(a aVar) {
        this.iFE = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.iFA.setText(str);
            this.iFA.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.iFA.getText().length()) {
            this.iFA.setSelection(i);
        }
    }

    public boolean cya() {
        return this.iFA.requestFocus();
    }
}
