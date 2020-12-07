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
/* loaded from: classes4.dex */
public abstract class d {
    protected View.OnClickListener bNu;
    protected int gGA;
    protected int gGB;
    protected AlaChooseGiftActivity gGy;
    protected String gGz;
    protected AlaLiveInputEditView gfR;
    protected ArrayList<String> gfV;
    protected Context mContext;
    protected View mRootView;

    public abstract void aT(int i, String str);

    protected abstract int bUy();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    protected abstract void initView();

    public abstract void j(TextView textView);

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.gGy = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.gGz = str;
        this.gfV = arrayList;
        this.gGA = i;
        this.gGB = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bUy(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void vC(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void cf(View view) {
        if (this.bNu != null) {
            this.bNu.onClick(view);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.bNu = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.gfR = alaLiveInputEditView;
        this.gfR.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.gfR.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gfR.setEditViewConfirmCallBack(new c.a() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // com.baidu.live.view.input.c.a
            public void hC(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.vC(Integer.parseInt(str));
                }
            }
        });
    }

    public void bOU() {
        this.gfR.OS();
        this.gfR.getEditView().setFocusable(true);
        this.gfR.getEditView().setFocusableInTouchMode(true);
        this.gfR.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.gfR.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.gfR.getEditView());
            }
        }, 100L);
    }

    public void bOV() {
        this.gfR.setVisibility(8);
        this.gfR.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.gfR.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
