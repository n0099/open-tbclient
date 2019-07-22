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
    private EditText fcY;
    private ImageView fcZ;
    private ImageView fda;
    private LinearLayout fdb;
    private a fdc;

    /* loaded from: classes.dex */
    public interface a {
        void wc(String str);

        void wd(String str);
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
        this.fcY = (EditText) findViewById(R.id.edit_search);
        this.fcZ = (ImageView) findViewById(R.id.iv_search);
        this.fda = (ImageView) findViewById(R.id.iv_del_all);
        this.fdb = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        am.c(this.fcZ, (int) R.drawable.icon_emotion_search);
        am.c(this.fda, (int) R.drawable.del_search_btn);
        am.j(this.fcY, R.color.cp_cont_b);
        this.fcY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.fdc != null) {
                    SearchEditView.this.fdc.wd(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.fdb.setVisibility(4);
                } else {
                    SearchEditView.this.fdb.setVisibility(0);
                }
            }
        });
        this.fcY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.fcY.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.fdc != null) {
                        SearchEditView.this.fdc.wc(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.fdb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.fcY.setText("");
            }
        });
        jc(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jc(int i) {
        if (i == 0) {
            this.fcY.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.fcY.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.fdc = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.fcY.setText(str);
            this.fcY.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.fcY.getText().length()) {
            this.fcY.setSelection(i);
        }
    }

    public boolean bho() {
        return this.fcY.requestFocus();
    }
}
