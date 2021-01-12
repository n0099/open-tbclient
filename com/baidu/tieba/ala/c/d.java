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
    protected View.OnClickListener bNv;
    protected AlaChooseGiftActivity gNF;
    protected String gNG;
    protected int gNH;
    protected int gNI;
    protected AlaLiveInputEditView glq;
    protected ArrayList<String> glu;
    protected Context mContext;
    protected View mRootView;

    public abstract void aW(int i, String str);

    protected abstract int bTm();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    protected abstract void initView();

    public abstract void l(TextView textView);

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.gNF = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.gNG = str;
        this.glu = arrayList;
        this.gNH = i;
        this.gNI = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bTm(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void uh(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void co(View view) {
        if (this.bNv != null) {
            this.bNv.onClick(view);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.bNv = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.glq = alaLiveInputEditView;
        this.glq.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.glq.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.glq.setEditViewConfirmCallBack(new c.a() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // com.baidu.live.view.input.c.a
            public void gb(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    try {
                        d.this.uh(Integer.parseInt(str));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void bNE() {
        this.glq.KC();
        this.glq.getEditView().setFocusable(true);
        this.glq.getEditView().setFocusableInTouchMode(true);
        this.glq.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.glq.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.glq.getEditView());
            }
        }, 100L);
    }

    public void bNF() {
        this.glq.setVisibility(8);
        this.glq.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.glq.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
