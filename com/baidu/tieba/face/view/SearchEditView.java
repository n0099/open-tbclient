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
    private EditText eXX;
    private ImageView eXY;
    private ImageView eXZ;
    private LinearLayout eYa;
    private a eYb;

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
        this.eXX = (EditText) findViewById(R.id.edit_search);
        this.eXY = (ImageView) findViewById(R.id.iv_search);
        this.eXZ = (ImageView) findViewById(R.id.iv_del_all);
        this.eYa = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        al.c(this.eXY, (int) R.drawable.icon_emotion_search);
        al.c(this.eXZ, (int) R.drawable.del_search_btn);
        al.j(this.eXX, R.color.cp_cont_b);
        this.eXX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.face.view.SearchEditView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (SearchEditView.this.eYb != null) {
                    SearchEditView.this.eYb.vz(editable.toString().trim());
                }
                if (editable.toString().trim().length() == 0) {
                    SearchEditView.this.eYa.setVisibility(4);
                } else {
                    SearchEditView.this.eYa.setVisibility(0);
                }
            }
        });
        this.eXX.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.face.view.SearchEditView.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    String trim = SearchEditView.this.eXX.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim) && SearchEditView.this.eYb != null) {
                        SearchEditView.this.eYb.vy(trim);
                    }
                    return true;
                }
                return false;
            }
        });
        this.eYa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.face.view.SearchEditView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchEditView.this.eXX.setText("");
            }
        });
        iW(TbadkCoreApplication.getInst().getSkinType());
    }

    public void iW(int i) {
        if (i == 0) {
            this.eXX.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        } else {
            this.eXX.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        }
    }

    public void setCallback(a aVar) {
        this.eYb = aVar;
    }

    public void setText(String str) {
        if (str != null) {
            this.eXX.setText(str);
            this.eXX.setSelection(str.length());
        }
    }

    public void setSelection(int i) {
        if (i <= this.eXX.getText().length()) {
            this.eXX.setSelection(i);
        }
    }

    public boolean bfl() {
        return this.eXX.requestFocus();
    }
}
