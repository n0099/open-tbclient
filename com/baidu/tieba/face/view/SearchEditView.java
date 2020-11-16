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
    private EditText iuG;
    private ImageView iuH;
    private ImageView iuI;
    private LinearLayout iuJ;
    private a iuK;

    /* loaded from: classes.dex */
    public interface a {
        void Jg(String str);

        void Jh(String str);
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
        this.iuG = (EditText) findViewById(R.id.edit_search);
        this.iuH = (ImageView) findViewById(R.id.iv_search);
        this.iuI = (ImageView) findViewById(R.id.iv_del_all);
        this.iuJ = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        ap.setImageResource(this.iuH, R.drawable.icon_emotion_search);
        ap.setImageResource(this.iuI, R.drawable.del_search_btn);
        ap.setViewTextColor(this.iuG, R.color.CAM_X0105);
        this.iuG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.iuK != null) {
                    SearchEditView.this.iuK.Jh(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.iuJ.setVisibility(4);
                } else {
                    SearchEditView.this.iuJ.setVisibility(0);
                }
            }
        });
        this.iuG.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.iuG.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.iuK != null) {
                        SearchEditView.this.iuK.Jg(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.iuJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.iuG.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.iuG.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        } else {
            this.iuG.setHintTextColor(getResources().getColor(R.color.CAM_X0109_1));
        }
    }

    public void setCallback(a aVar) {
        this.iuK = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.iuG.setText(str);
            this.iuG.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.iuG.getText().length()) {
            this.iuG.setSelection(i);
        }
    }

    public boolean ctK() {
        return this.iuG.requestFocus();
    }
}
