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
    private LinearLayout hFA;
    private a hFB;
    private EditText hFx;
    private ImageView hFy;
    private ImageView hFz;

    /* loaded from: classes.dex */
    public interface a {
        void HF(String str);

        void HG(String str);
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
        this.hFx = (EditText) findViewById(R.id.edit_search);
        this.hFy = (ImageView) findViewById(R.id.iv_search);
        this.hFz = (ImageView) findViewById(R.id.iv_del_all);
        this.hFA = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        ap.setImageResource(this.hFy, R.drawable.icon_emotion_search);
        ap.setImageResource(this.hFz, R.drawable.del_search_btn);
        ap.setViewTextColor(this.hFx, R.color.cp_cont_b);
        this.hFx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.hFB != null) {
                    SearchEditView.this.hFB.HG(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.hFA.setVisibility(4);
                } else {
                    SearchEditView.this.hFA.setVisibility(0);
                }
            }
        });
        this.hFx.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.hFx.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.hFB != null) {
                        SearchEditView.this.hFB.HF(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.hFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.hFx.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.hFx.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.hFx.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.hFB = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.hFx.setText(str);
            this.hFx.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.hFx.getText().length()) {
            this.hFx.setSelection(i);
        }
    }

    public boolean chO() {
        return this.hFx.requestFocus();
    }
}
