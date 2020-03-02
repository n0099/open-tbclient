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
    protected AlaLiveInputEditView egL;
    protected ArrayList<String> egP;
    protected AlaChooseGiftActivity exU;
    protected View.OnClickListener exV;
    protected String exW;
    protected int exX;
    protected int exY;
    protected Context mContext;
    protected View mRootView;

    public abstract void aj(int i, String str);

    public abstract void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void confirm();

    public abstract void d(TextView textView);

    protected abstract int getLayoutResId();

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.exU = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.exW = str;
        this.egP = arrayList;
        this.exX = i;
        this.exY = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(getLayoutResId(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void pd(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bt(View view) {
        if (this.exV != null) {
            this.exV.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.exV = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.egL = alaLiveInputEditView;
        this.egL.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.a.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.egL.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.egL.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.a.d.2
            @Override // com.baidu.live.view.input.b.a
            public void dx(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.pd(Integer.parseInt(str));
                }
            }
        });
    }

    public void bby() {
        this.egL.xS();
        this.egL.getEditView().setFocusable(true);
        this.egL.getEditView().setFocusableInTouchMode(true);
        this.egL.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.egL.getEditView().requestFocus();
                d.this.egL.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.egL.getEditView());
            }
        }, 100L);
    }

    public void bbz() {
        this.egL.setVisibility(8);
        this.egL.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.a.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.egL.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
