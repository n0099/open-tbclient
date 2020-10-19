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
    private EditText ibt;
    private ImageView ibu;
    private ImageView ibv;
    private LinearLayout ibw;
    private a ibx;

    /* loaded from: classes.dex */
    public interface a {
        void IP(String str);

        void IQ(String str);
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
        this.ibt = (EditText) findViewById(R.id.edit_search);
        this.ibu = (ImageView) findViewById(R.id.iv_search);
        this.ibv = (ImageView) findViewById(R.id.iv_del_all);
        this.ibw = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        ap.setImageResource(this.ibu, R.drawable.icon_emotion_search);
        ap.setImageResource(this.ibv, R.drawable.del_search_btn);
        ap.setViewTextColor(this.ibt, R.color.cp_cont_b);
        this.ibt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.ibx != null) {
                    SearchEditView.this.ibx.IQ(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.ibw.setVisibility(4);
                } else {
                    SearchEditView.this.ibw.setVisibility(0);
                }
            }
        });
        this.ibt.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.ibt.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.ibx != null) {
                        SearchEditView.this.ibx.IP(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.ibw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.ibt.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.ibt.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.ibt.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.ibx = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.ibt.setText(str);
            this.ibt.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.ibt.getText().length()) {
            this.ibt.setSelection(i);
        }
    }

    public boolean coz() {
        return this.ibt.requestFocus();
    }
}
