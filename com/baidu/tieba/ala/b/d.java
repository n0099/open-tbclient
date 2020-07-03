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
    protected AlaChooseGiftActivity fCd;
    protected View.OnClickListener fCe;
    protected String fCf;
    protected int fCg;
    protected int fCh;
    protected AlaLiveInputEditView fec;
    protected ArrayList<String> feg;
    protected Context mContext;
    protected View mRootView;

    public abstract void aF(int i, String str);

    protected abstract int bwi();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void e(TextView textView);

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.fCd = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.fCf = str;
        this.feg = arrayList;
        this.fCg = i;
        this.fCh = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bwi(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void qC(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void by(View view) {
        if (this.fCe != null) {
            this.fCe.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.fCe = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fec = alaLiveInputEditView;
        this.fec.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.b.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.fec.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fec.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.b.d.2
            @Override // com.baidu.live.view.input.b.a
            public void fc(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.qC(Integer.parseInt(str));
                }
            }
        });
    }

    public void brA() {
        this.fec.EO();
        this.fec.getEditView().setFocusable(true);
        this.fec.getEditView().setFocusableInTouchMode(true);
        this.fec.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.fec.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.fec.getEditView());
            }
        }, 100L);
    }

    public void brB() {
        this.fec.setVisibility(8);
        this.fec.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.fec.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
