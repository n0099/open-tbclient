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
    protected View.OnClickListener bEq;
    protected AlaLiveInputEditView fSj;
    protected ArrayList<String> fSn;
    protected AlaChooseGiftActivity gso;
    protected String gsp;
    protected int gsq;
    protected int gsr;
    protected Context mContext;
    protected View mRootView;

    public abstract void aR(int i, String str);

    protected abstract int bOV();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void f(TextView textView);

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.gso = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.gsp = str;
        this.fSn = arrayList;
        this.gsq = i;
        this.gsr = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bOV(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void un(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bR(View view) {
        if (this.bEq != null) {
            this.bEq.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.bEq = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fSj = alaLiveInputEditView;
        this.fSj.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.fSj.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fSj.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // com.baidu.live.view.input.b.a
            public void hg(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.un(Integer.parseInt(str));
                }
            }
        });
    }

    public void bJt() {
        this.fSj.MG();
        this.fSj.getEditView().setFocusable(true);
        this.fSj.getEditView().setFocusableInTouchMode(true);
        this.fSj.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.fSj.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.fSj.getEditView());
            }
        }, 100L);
    }

    public void bJu() {
        this.fSj.setVisibility(8);
        this.fSj.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.fSj.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
