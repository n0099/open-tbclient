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
    private EditText gaU;
    private ImageView gaV;
    private ImageView gaW;
    private LinearLayout gaX;
    private a gaY;

    /* loaded from: classes.dex */
    public interface a {
        void As(String str);

        void At(String str);
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
        this.gaU = (EditText) findViewById(R.id.edit_search);
        this.gaV = (ImageView) findViewById(R.id.iv_search);
        this.gaW = (ImageView) findViewById(R.id.iv_del_all);
        this.gaX = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        am.setImageResource(this.gaV, R.drawable.icon_emotion_search);
        am.setImageResource(this.gaW, R.drawable.del_search_btn);
        am.setViewTextColor(this.gaU, (int) R.color.cp_cont_b);
        this.gaU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.gaY != null) {
                    SearchEditView.this.gaY.At(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.gaX.setVisibility(4);
                } else {
                    SearchEditView.this.gaX.setVisibility(0);
                }
            }
        });
        this.gaU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.gaU.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.gaY != null) {
                        SearchEditView.this.gaY.As(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.gaX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.gaU.setText("");
            }
        });
        onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkin(int i) {
        if (i == 0) {
            this.gaU.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.gaU.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.gaY = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.gaU.setText(str);
            this.gaU.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.gaU.getText().length()) {
            this.gaU.setSelection(i);
        }
    }

    public boolean bzX() {
        return this.gaU.requestFocus();
    }
}
