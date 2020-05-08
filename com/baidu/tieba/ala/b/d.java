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
    protected AlaLiveInputEditView eHj;
    protected ArrayList<String> eHn;
    protected AlaChooseGiftActivity fde;
    protected View.OnClickListener fdf;
    protected String fdg;
    protected int fdh;
    protected int fdi;
    protected Context mContext;
    protected View mRootView;

    public abstract void ay(int i, String str);

    protected abstract int bnu();

    public abstract void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void confirm();

    public abstract void e(TextView textView);

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.fde = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.fdg = str;
        this.eHn = arrayList;
        this.fdh = i;
        this.fdi = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bnu(), (ViewGroup) null);
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
        if (this.fdf != null) {
            this.fdf.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.fdf = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.eHj = alaLiveInputEditView;
        this.eHj.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.b.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.eHj.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.eHj.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.b.d.2
            @Override // com.baidu.live.view.input.b.a
            public void em(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.pA(Integer.parseInt(str));
                }
            }
        });
    }

    public void bjE() {
        this.eHj.CO();
        this.eHj.getEditView().setFocusable(true);
        this.eHj.getEditView().setFocusableInTouchMode(true);
        this.eHj.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.eHj.getEditView().requestFocus();
                d.this.eHj.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.eHj.getEditView());
            }
        }, 100L);
    }

    public void bjF() {
        this.eHj.setVisibility(8);
        this.eHj.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.eHj.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
