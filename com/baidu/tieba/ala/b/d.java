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
/* loaded from: classes4.dex */
public abstract class d {
    protected AlaChooseGiftActivity fHn;
    protected View.OnClickListener fHo;
    protected String fHp;
    protected int fHq;
    protected int fHr;
    protected AlaLiveInputEditView fiV;
    protected ArrayList<String> fiZ;
    protected Context mContext;
    protected View mRootView;

    public abstract void aH(int i, String str);

    protected abstract int bzx();

    public abstract void confirm();

    public abstract void d(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void g(TextView textView);

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.fHn = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.fHp = str;
        this.fiZ = arrayList;
        this.fHq = i;
        this.fHr = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(bzx(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void qR(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bE(View view) {
        if (this.fHo != null) {
            this.fHo.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.fHo = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fiV = alaLiveInputEditView;
        this.fiV.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.b.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.fiV.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fiV.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.b.d.2
            @Override // com.baidu.live.view.input.b.a
            public void fb(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.qR(Integer.parseInt(str));
                }
            }
        });
    }

    public void buH() {
        this.fiV.EV();
        this.fiV.getEditView().setFocusable(true);
        this.fiV.getEditView().setFocusableInTouchMode(true);
        this.fiV.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.fiV.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.fiV.getEditView());
            }
        }, 100L);
    }

    public void buI() {
        this.fiV.setVisibility(8);
        this.fiV.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.fiV.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
