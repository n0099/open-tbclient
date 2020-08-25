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
/* loaded from: classes7.dex */
public abstract class d {
    protected AlaChooseGiftActivity fSE;
    protected View.OnClickListener fSF;
    protected String fSG;
    protected int fSH;
    protected int fSI;
    protected AlaLiveInputEditView fur;
    protected ArrayList<String> fuv;
    protected Context mContext;
    protected View mRootView;

    public abstract void aF(int i, String str);

    protected abstract int bIA();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void f(TextView textView);

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.fSE = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.fSG = str;
        this.fuv = arrayList;
        this.fSH = i;
        this.fSI = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bIA(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void td(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bG(View view) {
        if (this.fSF != null) {
            this.fSF.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.fSF = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fur = alaLiveInputEditView;
        this.fur.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.b.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.fur.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fur.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.b.d.2
            @Override // com.baidu.live.view.input.b.a
            public void gw(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.td(Integer.parseInt(str));
                }
            }
        });
    }

    public void bDC() {
        this.fur.KA();
        this.fur.getEditView().setFocusable(true);
        this.fur.getEditView().setFocusableInTouchMode(true);
        this.fur.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.fur.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.fur.getEditView());
            }
        }, 100L);
    }

    public void bDD() {
        this.fur.setVisibility(8);
        this.fur.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.fur.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
