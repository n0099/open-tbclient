package com.baidu.tieba.ala.b;

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
    protected AlaLiveInputEditView eTR;
    protected ArrayList<String> eTV;
    protected AlaChooseGiftActivity fqS;
    protected View.OnClickListener fqT;
    protected String fqU;
    protected int fqV;
    protected int fqW;
    protected Context mContext;
    protected View mRootView;

    public abstract void aD(int i, String str);

    protected abstract int bto();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void e(TextView textView);

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.fqS = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.fqU = str;
        this.eTV = arrayList;
        this.fqV = i;
        this.fqW = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bto(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void qd(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bv(View view) {
        if (this.fqT != null) {
            this.fqT.onClick(view);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.fqT = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.eTR = alaLiveInputEditView;
        this.eTR.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.b.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.eTR.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.eTR.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.b.d.2
            @Override // com.baidu.live.view.input.b.a
            public void eW(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.qd(Integer.parseInt(str));
                }
            }
        });
    }

    public void bpa() {
        this.eTR.El();
        this.eTR.getEditView().setFocusable(true);
        this.eTR.getEditView().setFocusableInTouchMode(true);
        this.eTR.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.eTR.getEditView().requestFocus();
                d.this.eTR.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.eTR.getEditView());
            }
        }, 100L);
    }

    public void bpb() {
        this.eTR.setVisibility(8);
        this.eTR.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.eTR.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
