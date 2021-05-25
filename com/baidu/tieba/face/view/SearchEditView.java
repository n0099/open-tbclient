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
    public EditText f14593e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f14594f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f14595g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f14596h;

    /* renamed from: i  reason: collision with root package name */
    public d f14597i;

    /* loaded from: classes4.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (SearchEditView.this.f14597i != null) {
                SearchEditView.this.f14597i.onTextChanged(editable.toString().trim());
            }
            if (editable.toString().trim().length() == 0) {
                SearchEditView.this.f14596h.setVisibility(4);
            } else {
                SearchEditView.this.f14596h.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TextView.OnEditorActionListener {
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 3) {
                String trim = SearchEditView.this.f14593e.getText().toString().trim();
                if (TextUtils.isEmpty(trim) || SearchEditView.this.f14597i == null) {
                    return true;
                }
                SearchEditView.this.f14597i.onClickSearch(trim);
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
            SearchEditView.this.f14593e.setText("");
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
        this.f14593e = (EditText) findViewById(R.id.edit_search);
        this.f14594f = (ImageView) findViewById(R.id.iv_search);
        this.f14595g = (ImageView) findViewById(R.id.iv_del_all);
        this.f14596h = (LinearLayout) findViewById(R.id.iv_del_all_layout);
        SkinManager.setImageResource(this.f14594f, R.drawable.icon_emotion_search);
        SkinManager.setImageResource(this.f14595g, R.drawable.del_search_btn);
        SkinManager.setViewTextColor(this.f14593e, R.color.CAM_X0105);
        this.f14593e.addTextChangedListener(new a());
        this.f14593e.setOnEditorActionListener(new b());
        this.f14596h.setOnClickListener(new c());
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i2) {
        if (i2 == 0) {
            this.f14593e.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        } else {
            this.f14593e.setHintTextColor(getResources().getColor(R.color.CAM_X0109_1));
        }
    }

    public boolean f() {
        return this.f14593e.requestFocus();
    }

    public void setCallback(d dVar) {
        this.f14597i = dVar;
    }

    public void setSelection(int i2) {
        if (i2 <= this.f14593e.getText().length()) {
            this.f14593e.setSelection(i2);
        }
    }

    public void setText(String str) {
        if (str != null) {
            this.f14593e.setText(str);
            this.f14593e.setSelection(str.length());
        }
    }

    public SearchEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public SearchEditView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d();
    }
}
