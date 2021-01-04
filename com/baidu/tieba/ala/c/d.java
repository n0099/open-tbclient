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
/* loaded from: classes11.dex */
public abstract class d {
    protected View.OnClickListener bSh;
    protected AlaChooseGiftActivity gSl;
    protected String gSm;
    protected int gSn;
    protected int gSo;
    protected AlaLiveInputEditView gpX;
    protected ArrayList<String> gqb;
    protected Context mContext;
    protected View mRootView;

    public abstract void aV(int i, String str);

    protected abstract int bXd();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    protected abstract void initView();

    public abstract void l(TextView textView);

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.gSl = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.gSm = str;
        this.gqb = arrayList;
        this.gSn = i;
        this.gSo = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bXd(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void vN(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void co(View view) {
        if (this.bSh != null) {
            this.bSh.onClick(view);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.bSh = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.gpX = alaLiveInputEditView;
        this.gpX.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.gpX.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gpX.setEditViewConfirmCallBack(new c.a() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // com.baidu.live.view.input.c.a
            public void hn(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    try {
                        d.this.vN(Integer.parseInt(str));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void bRv() {
        this.gpX.Ox();
        this.gpX.getEditView().setFocusable(true);
        this.gpX.getEditView().setFocusableInTouchMode(true);
        this.gpX.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.gpX.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.gpX.getEditView());
            }
        }, 100L);
    }

    public void bRw() {
        this.gpX.setVisibility(8);
        this.gpX.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.gpX.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
