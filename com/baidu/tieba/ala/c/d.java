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
    protected View.OnClickListener bBu;
    protected AlaLiveInputEditView fJP;
    protected ArrayList<String> fJT;
    protected AlaChooseGiftActivity gim;
    protected String gin;
    protected int gio;
    protected int gip;
    protected Context mContext;
    protected View mRootView;

    public abstract void aQ(int i, String str);

    protected abstract int bMt();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void f(TextView textView);

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.gim = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.gin = str;
        this.fJT = arrayList;
        this.gio = i;
        this.gip = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bMt(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void tU(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bO(View view) {
        if (this.bBu != null) {
            this.bBu.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.bBu = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fJP = alaLiveInputEditView;
        this.fJP.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.fJP.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fJP.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // com.baidu.live.view.input.b.a
            public void gV(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.tU(Integer.parseInt(str));
                }
            }
        });
    }

    public void bHC() {
        this.fJP.Mm();
        this.fJP.getEditView().setFocusable(true);
        this.fJP.getEditView().setFocusableInTouchMode(true);
        this.fJP.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.fJP.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.fJP.getEditView());
            }
        }, 100L);
    }

    public void bHD() {
        this.fJP.setVisibility(8);
        this.fJP.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.fJP.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
