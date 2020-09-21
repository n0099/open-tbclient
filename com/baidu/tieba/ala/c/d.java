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
    protected AlaChooseGiftActivity fVS;
    protected View.OnClickListener fVT;
    protected String fVU;
    protected int fVV;
    protected int fVW;
    protected AlaLiveInputEditView fxG;
    protected ArrayList<String> fxK;
    protected Context mContext;
    protected View mRootView;

    public abstract void aF(int i, String str);

    protected abstract int bJJ();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void f(TextView textView);

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.fVS = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.fVU = str;
        this.fxK = arrayList;
        this.fVV = i;
        this.fVW = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bJJ(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void tw(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bK(View view) {
        if (this.fVT != null) {
            this.fVT.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.fVT = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fxG = alaLiveInputEditView;
        this.fxG.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.fxG.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fxG.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // com.baidu.live.view.input.b.a
            public void gH(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.tw(Integer.parseInt(str));
                }
            }
        });
    }

    public void bEQ() {
        this.fxG.Lh();
        this.fxG.getEditView().setFocusable(true);
        this.fxG.getEditView().setFocusableInTouchMode(true);
        this.fxG.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.fxG.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.fxG.getEditView());
            }
        }, 100L);
    }

    public void bER() {
        this.fxG.setVisibility(8);
        this.fxG.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.fxG.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
