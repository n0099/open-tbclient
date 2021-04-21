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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class SearchEditView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public EditText f15237e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f15238f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15239g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f15240h;
    public d i;

    /* loaded from: classes4.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (SearchEditView.this.i != null) {
                SearchEditView.this.i.onTextChanged(editable.toString().trim());
            }
            if (editable.toString().trim().length() == 0) {
                SearchEditView.this.f15240h.setVisibility(4);
            } else {
                SearchEditView.this.f15240h.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TextView.OnEditorActionListener {
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
                String trim = SearchEditView.this.f15237e.getText().toString().trim();
                if (TextUtils.isEmpty(trim) || SearchEditView.this.i == null) {
                    return true;
                }
                SearchEditView.this.i.onClickSearch(trim);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchEditView.this.f15237e.setText("");
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onClickSearch(String str);

        void onTextChanged(String str);
    }

    public SearchEditView(Context context) {
        super(context);
        d();
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_search_edit, (ViewGroup) this, true);
        this.f15237e = (EditText) findViewById(R.id.edit_search);
        this.f15238f = (ImageView) findViewById(R.id.iv_search);
        this.f15239g = (ImageView) findViewById(R.id.iv_del_all);
        this.f15240h = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        SkinManager.setImageResource(this.f15238f, R.drawable.icon_emotion_search);
        SkinManager.setImageResource(this.f15239g, R.drawable.del_search_btn);
        SkinManager.setViewTextColor(this.f15237e, R.color.CAM_X0105);
        this.f15237e.addTextChangedListener(new a());
        this.f15237e.setOnEditorActionListener(new b());
        this.f15240h.setOnClickListener(new c());
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i) {
        if (i == 0) {
            this.f15237e.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        } else {
            this.f15237e.setHintTextColor(getResources().getColor(R.color.CAM_X0109_1));
        }
    }

    public boolean f() {
        return this.f15237e.requestFocus();
    }

    public void setCallback(d dVar) {
        this.i = dVar;
    }

    public void setSelection(int i) {
        if (i <= this.f15237e.getText().length()) {
            this.f15237e.setSelection(i);
        }
    }

    public void setText(String str) {
        if (str != null) {
            this.f15237e.setText(str);
            this.f15237e.setSelection(str.length());
        }
    }

    public SearchEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public SearchEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d();
    }
}
