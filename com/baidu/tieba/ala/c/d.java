package com.baidu.tieba.ala.c;

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
/* loaded from: classes4.dex */
public abstract class d {
    protected View.OnClickListener bIm;
    protected AlaLiveInputEditView fXG;
    protected ArrayList<String> fXK;
    protected AlaChooseGiftActivity gxJ;
    protected String gxK;
    protected int gxL;
    protected int gxM;
    protected Context mContext;
    protected View mRootView;

    public abstract void aT(int i, String str);

    protected abstract int bQO();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    protected abstract void initView();

    public abstract void j(TextView textView);

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.gxJ = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.gxK = str;
        this.fXK = arrayList;
        this.gxL = i;
        this.gxM = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bQO(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void uV(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bY(View view) {
        if (this.bIm != null) {
            this.bIm.onClick(view);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.bIm = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fXG = alaLiveInputEditView;
        this.fXG.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.fXG.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fXG.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // com.baidu.live.view.input.b.a
            public void hh(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.uV(Integer.parseInt(str));
                }
            }
        });
    }

    public void bLl() {
        this.fXG.Mx();
        this.fXG.getEditView().setFocusable(true);
        this.fXG.getEditView().setFocusableInTouchMode(true);
        this.fXG.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.fXG.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.fXG.getEditView());
            }
        }, 100L);
    }

    public void bLm() {
        this.fXG.setVisibility(8);
        this.fXG.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.fXG.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
