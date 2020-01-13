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
    protected AlaLiveInputEditView ecH;
    protected ArrayList<String> ecL;
    protected AlaChooseGiftActivity etJ;
    protected View.OnClickListener etK;
    protected String etL;
    protected int etM;
    protected int etN;
    protected Context mContext;
    protected View mRootView;

    public abstract void ai(int i, String str);

    public abstract void c(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

    public abstract void confirm();

    public abstract void d(TextView textView);

    protected abstract int getLayoutResId();

    protected abstract void initView();

    public d(AlaChooseGiftActivity alaChooseGiftActivity, FrameLayout frameLayout, String str, ArrayList<String> arrayList, int i, int i2) {
        this.etJ = alaChooseGiftActivity;
        this.mContext = alaChooseGiftActivity.getPageContext().getPageActivity();
        this.etL = str;
        this.ecL = arrayList;
        this.etM = i;
        this.etN = i2;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(getLayoutResId(), (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(this.mRootView);
        initView();
    }

    public void oM(int i) {
    }

    public void a(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void bt(View view) {
        if (this.etK != null) {
            this.etK.onClick(view);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.etK = onClickListener;
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.ecH = alaLiveInputEditView;
        this.ecH.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.a.d.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    d.this.ecH.setSendEnabled(false);
                } else {
                    d.this.a(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.ecH.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.a.d.2
            @Override // com.baidu.live.view.input.b.a
            public void dm(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    d.this.oM(Integer.parseInt(str));
                }
            }
        });
    }

    public void aZh() {
        this.ecH.vT();
        this.ecH.getEditView().setFocusable(true);
        this.ecH.getEditView().setFocusableInTouchMode(true);
        this.ecH.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.ecH.getEditView().requestFocus();
                d.this.ecH.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(d.this.mContext, d.this.ecH.getEditView());
            }
        }, 100L);
    }

    public void aZi() {
        this.ecH.setVisibility(8);
        this.ecH.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.a.d.4
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(d.this.mContext, d.this.ecH.getEditView());
            }
        });
    }

    public void onDestroy() {
    }
}
