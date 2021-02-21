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
    protected View.OnClickListener bRl;
    protected String gQA;
    protected int gQB;
    protected int gQC;
    protected AlaChooseGiftActivity gQz;
    protected AlaLiveInputEditView gok;
    protected ArrayList<String> goo;
    protected Context mContext;
    protected View mRootView;

    protected abstract int bTX();

    public abstract void bb(int i, String str);

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    protected abstract void initView();

    public abstract void l(TextView textView);

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.gQz = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.gQA = str;
        this.goo = arrayList;
        this.gQB = i;
        this.gQC = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bTX(), (ViewGroup) null);
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

    public void ck(View view) {
        if (this.bRl != null) {
            this.bRl.onClick(view);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.bRl = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.gok = alaLiveInputEditView;
        this.gok.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.gok.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gok.setEditViewConfirmCallBack(new c.a() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // com.baidu.live.view.input.c.a
            public void gz(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    try {
                        d.this.un(Integer.parseInt(str));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void bOm() {
        this.gok.Ma();
        this.gok.getEditView().setFocusable(true);
        this.gok.getEditView().setFocusableInTouchMode(true);
        this.gok.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.gok.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.gok.getEditView());
            }
        }, 100L);
    }

    public void bOn() {
        this.gok.setVisibility(8);
        this.gok.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.gok.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
