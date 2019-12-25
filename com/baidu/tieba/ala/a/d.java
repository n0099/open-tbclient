package com.baidu.tieba.ala.a;

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
/* loaded from: classes2.dex */
public abstract class d {
    protected ArrayList<String> ecC;
    protected AlaLiveInputEditView ecy;
    protected int esA;
    protected int esB;
    protected AlaChooseGiftActivity esx;
    protected View.OnClickListener esy;
    protected String esz;
    protected Context mContext;
    protected View mRootView;

    public abstract void ag(int i, String str);

    public abstract void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void confirm();

    public abstract void d(TextView textView);

    protected abstract int getLayoutResId();

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.esx = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.esz = str;
        this.ecC = arrayList;
        this.esA = i;
        this.esB = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(getLayoutResId(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void oL(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bp(View view) {
        if (this.esy != null) {
            this.esy.onClick(view);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.esy = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.ecy = alaLiveInputEditView;
        this.ecy.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.a.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.ecy.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.ecy.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.a.d.2
            @Override // com.baidu.live.view.input.b.a
            public void dk(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.oL(Integer.parseInt(str));
                }
            }
        });
    }

    public void aYN() {
        this.ecy.vC();
        this.ecy.getEditView().setFocusable(true);
        this.ecy.getEditView().setFocusableInTouchMode(true);
        this.ecy.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.ecy.getEditView().requestFocus();
                d.this.ecy.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.ecy.getEditView());
            }
        }, 100L);
    }

    public void aYO() {
        this.ecy.setVisibility(8);
        this.ecy.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.a.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.ecy.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
