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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SearchEditView extends RelativeLayout {
    private EditText bZU;
    private ImageView bZV;
    private ImageView bZW;
    private LinearLayout bZX;
    private a bZY;

    /* loaded from: classes.dex */
    public interface a {
        void jx(String str);

        void jy(String str);
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
        LayoutInflater.from(getContext()).inflate(d.j.emotion_search_edit, (ViewGroup) this, true);
        this.bZU = (EditText) findViewById(d.h.edit_search);
        this.bZV = (ImageView) findViewById(d.h.iv_search);
        this.bZW = (ImageView) findViewById(d.h.iv_del_all);
        this.bZX = (LinearLayout) findViewById(d.h.iv_del_all_layout);
        ai.c(this.bZV, d.g.icon_emotion_search);
        ai.c(this.bZW, d.g.del_search_btn);
        this.bZU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.bZY != null) {
                    SearchEditView.this.bZY.jy(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.bZX.setVisibility(4);
                } else {
                    SearchEditView.this.bZX.setVisibility(0);
                }
            }
        });
        this.bZU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.bZU.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.bZY != null) {
                        SearchEditView.this.bZY.jx(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.bZX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.bZU.setText("");
            }
        });
    }

    public void setCallback(a aVar) {
        this.bZY = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.bZU.setText(str);
            this.bZU.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.bZU.getText().length()) {
            this.bZU.setSelection(i);
        }
    }

    public boolean acw() {
        return this.bZU.requestFocus();
    }
}
