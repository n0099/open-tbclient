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
import com.baidu.live.view.input.c;
import com.baidu.tieba.ala.AlaChooseGiftActivity;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class d {
    protected View.OnClickListener bSL;
    protected AlaChooseGiftActivity gSi;
    protected String gSj;
    protected int gSk;
    protected int gSl;
    protected AlaLiveInputEditView gpT;
    protected ArrayList<String> gpX;
    protected Context mContext;
    protected View mRootView;

    protected abstract int bUd();

    public abstract void bb(int i, String str);

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    protected abstract void initView();

    public abstract void l(TextView textView);

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.gSi = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.gSj = str;
        this.gpX = arrayList;
        this.gSk = i;
        this.gSl = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bUd(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void up(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void ck(View view) {
        if (this.bSL != null) {
            this.bSL.onClick(view);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.bSL = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.gpT = alaLiveInputEditView;
        this.gpT.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.gpT.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gpT.setEditViewConfirmCallBack(new c.a() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // com.baidu.live.view.input.c.a
            public void gF(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    try {
                        d.this.up(Integer.parseInt(str));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void bOs() {
        this.gpT.Md();
        this.gpT.getEditView().setFocusable(true);
        this.gpT.getEditView().setFocusableInTouchMode(true);
        this.gpT.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.gpT.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.gpT.getEditView());
            }
        }, 100L);
    }

    public void bOt() {
        this.gpT.setVisibility(8);
        this.gpT.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.gpT.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
