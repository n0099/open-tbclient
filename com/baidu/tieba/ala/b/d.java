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
    protected AlaLiveInputEditView eHe;
    protected ArrayList<String> eHi;
    protected AlaChooseGiftActivity fcZ;
    protected View.OnClickListener fda;
    protected String fdb;
    protected int fdc;
    protected int fdd;
    protected Context mContext;
    protected View mRootView;

    public abstract void ay(int i, String str);

    protected abstract int bnw();

    public abstract void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void confirm();

    public abstract void e(TextView textView);

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.fcZ = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.fdb = str;
        this.eHi = arrayList;
        this.fdc = i;
        this.fdd = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bnw(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void pA(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bw(View view) {
        if (this.fda != null) {
            this.fda.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.fda = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.eHe = alaLiveInputEditView;
        this.eHe.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.b.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.eHe.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.eHe.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.b.d.2
            @Override // com.baidu.live.view.input.b.a
            public void em(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.pA(Integer.parseInt(str));
                }
            }
        });
    }

    public void bjG() {
        this.eHe.CP();
        this.eHe.getEditView().setFocusable(true);
        this.eHe.getEditView().setFocusableInTouchMode(true);
        this.eHe.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.eHe.getEditView().requestFocus();
                d.this.eHe.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.eHe.getEditView());
            }
        }, 100L);
    }

    public void bjH() {
        this.eHe.setVisibility(8);
        this.eHe.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.eHe.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
