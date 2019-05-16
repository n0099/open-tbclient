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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText eXW;
    private ImageView eXX;
    private ImageView eXY;
    private LinearLayout eXZ;
    private a eYa;

    /* loaded from: classes.dex */
    public interface a {
        void vy(String str);

        void vz(String str);
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
        this.eXW = (EditText) findViewById(R.id.edit_search);
        this.eXX = (ImageView) findViewById(R.id.iv_search);
        this.eXY = (ImageView) findViewById(R.id.iv_del_all);
        this.eXZ = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        al.c(this.eXX, (int) R.drawable.icon_emotion_search);
        al.c(this.eXY, (int) R.drawable.del_search_btn);
        al.j(this.eXW, R.color.cp_cont_b);
        this.eXW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.eYa != null) {
                    SearchEditView.this.eYa.vz(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.eXZ.setVisibility(4);
                } else {
                    SearchEditView.this.eXZ.setVisibility(0);
                }
            }
        });
        this.eXW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.eXW.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.eYa != null) {
                        SearchEditView.this.eYa.vy(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.eXZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.eXW.setText("");
            }
        });
        iW(TbadkCoreApplication.getInst().getSkinType());
    }

    public void iW(int i) {
        if (i == 0) {
            this.eXW.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.eXW.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.eYa = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.eXW.setText(str);
            this.eXW.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.eXW.getText().length()) {
            this.eXW.setSelection(i);
        }
    }

    public boolean bfi() {
        return this.eXW.requestFocus();
    }
}
