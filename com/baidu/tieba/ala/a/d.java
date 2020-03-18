package com.baidu.tieba.ala.a;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.b;
import com.baidu.tieba.ala.AlaChooseGiftActivity;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class d {
    protected AlaLiveInputEditView eho;
    protected ArrayList<String> ehs;
    protected AlaChooseGiftActivity eyF;
    protected View.OnClickListener eyG;
    protected String eyH;
    protected int eyI;
    protected int eyJ;
    protected Context mContext;
    protected View mRootView;

    public abstract void aj(int i, String str);

    public abstract void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void confirm();

    public abstract void d(TextView textView);

    protected abstract int getLayoutResId();

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.eyF = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.eyH = str;
        this.ehs = arrayList;
        this.eyI = i;
        this.eyJ = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(getLayoutResId(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void pf(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bt(View view) {
        if (this.eyG != null) {
            this.eyG.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.eyG = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.eho = alaLiveInputEditView;
        this.eho.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.a.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.eho.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.eho.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.a.d.2
            @Override // com.baidu.live.view.input.b.a
            public void dw(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.pf(Integer.parseInt(str));
                }
            }
        });
    }

    public void bbD() {
        this.eho.xX();
        this.eho.getEditView().setFocusable(true);
        this.eho.getEditView().setFocusableInTouchMode(true);
        this.eho.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.eho.getEditView().requestFocus();
                d.this.eho.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.eho.getEditView());
            }
        }, 100L);
    }

    public void bbE() {
        this.eho.setVisibility(8);
        this.eho.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.a.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.eho.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
