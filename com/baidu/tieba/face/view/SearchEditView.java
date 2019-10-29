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
    private EditText fhY;
    private ImageView fhZ;
    private ImageView fia;
    private LinearLayout fib;
    private a fic;

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
        this.fhY = (EditText) findViewById(R.id.edit_search);
        this.fhZ = (ImageView) findViewById(R.id.iv_search);
        this.fia = (ImageView) findViewById(R.id.iv_del_all);
        this.fib = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        am.setImageResource(this.fhZ, R.drawable.icon_emotion_search);
        am.setImageResource(this.fia, R.drawable.del_search_btn);
        am.setViewTextColor(this.fhY, (int) R.color.cp_cont_b);
        this.fhY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.fic != null) {
                    SearchEditView.this.fic.vb(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.fib.setVisibility(4);
                } else {
                    SearchEditView.this.fib.setVisibility(0);
                }
            }
        });
        this.fhY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.fhY.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.fic != null) {
                        SearchEditView.this.fic.va(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.fib.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.fhY.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.fhY.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.fhY.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.fic = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.fhY.setText(str);
            this.fhY.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.fhY.getText().length()) {
            this.fhY.setSelection(i);
        }
    }

    public boolean bfY() {
        return this.fhY.requestFocus();
    }
}
