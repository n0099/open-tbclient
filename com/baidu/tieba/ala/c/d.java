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
    protected View.OnClickListener bJX;
    protected AlaLiveInputEditView fXZ;
    protected ArrayList<String> fYd;
    protected AlaChooseGiftActivity gyc;
    protected String gyd;
    protected int gye;
    protected int gyf;
    protected Context mContext;
    protected View mRootView;

    public abstract void aV(int i, String str);

    protected abstract int bRv();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    protected abstract void initView();

    public abstract void j(TextView textView);

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.gyc = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.gyd = str;
        this.fYd = arrayList;
        this.gye = i;
        this.gyf = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bRv(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void ux(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bV(View view) {
        if (this.bJX != null) {
            this.bJX.onClick(view);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.bJX = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fXZ = alaLiveInputEditView;
        this.fXZ.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.fXZ.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fXZ.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // com.baidu.live.view.input.b.a
            public void hn(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.ux(Integer.parseInt(str));
                }
            }
        });
    }

    public void bLS() {
        this.fXZ.Ng();
        this.fXZ.getEditView().setFocusable(true);
        this.fXZ.getEditView().setFocusableInTouchMode(true);
        this.fXZ.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.fXZ.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.fXZ.getEditView());
            }
        }, 100L);
    }

    public void bLT() {
        this.fXZ.setVisibility(8);
        this.fXZ.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.fXZ.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
