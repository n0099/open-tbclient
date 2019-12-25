package com.baidu.tieba.ala.liveroom.q;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.av;
import com.baidu.live.gift.q;
import com.baidu.live.im.k;
import com.baidu.live.im.view.ImBarrageItemView;
import com.baidu.live.im.view.ImBarrageOptionListView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.view.Switch;
import com.baidu.live.view.input.QuickInputFlexTextView;
/* loaded from: classes2.dex */
public class b extends Dialog {
    private FlexLayout aAU;
    private ImBarrageItemView apN;
    private ImBarrageOptionListView apP;
    private Switch apQ;
    private a fdw;
    private View fdx;
    private C0453b fdy;
    private View mContentView;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, String str, av avVar);

        void bid();

        void onDismiss();

        boolean ux();

        boolean vG();
    }

    public b(@NonNull Context context) {
        super(context, a.j.sdk_TransparentDialog);
        init();
    }

    public void a(a aVar) {
        this.fdw = aVar;
    }

    public void D(String[] strArr) {
        E(strArr);
        vD();
        sl();
        show();
        if (this.mContentView != null) {
            this.mContentView.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.aAU != null && (layoutParams = b.this.aAU.getLayoutParams()) != null) {
                        layoutParams.height = b.this.aAU.realHeight;
                        b.this.aAU.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void bN(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.aAU != null && (layoutParams = this.aAU.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.aAU.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.apN.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.aAU != null && (layoutParams2 = b.this.aAU.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.aAU.realHeight;
                                b.this.aAU.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.apQ != null && this.apQ.isChecked()) {
                this.apN.setVisibility(0);
            }
        }
    }

    public void bnD() {
        if (this.apP != null) {
            this.apP.i(q.rk().rm());
        }
    }

    private void init() {
        initWindow();
        initView();
        qS();
    }

    private void initWindow() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(81);
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.mContentView = LayoutInflater.from(getContext()).inflate(a.h.ala_im_quick_input_list, (ViewGroup) null);
        setContentView(this.mContentView);
        this.apN = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.fdx = findViewById(a.g.layout_barrage);
        this.apQ = (Switch) findViewById(a.g.switch_barrage);
        this.apP = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aAU = (FlexLayout) findViewById(a.g.flex);
        this.apQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.aS(z);
            }
        });
        this.apP.setSelectEnabled(false);
        this.apP.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.tieba.ala.liveroom.q.b.4
            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public boolean vG() {
                return b.this.fdw != null && b.this.fdw.vG();
            }

            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public void bI(int i) {
                b.this.aT(false);
            }
        });
        this.aAU.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.aAU.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.aAU.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                av avVar;
                if (b.this.fdw != null) {
                    if (b.this.fdx.getVisibility() == 0 && b.this.apQ.isChecked()) {
                        av selectInfo = b.this.apP.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.fdw == null || !b.this.fdw.vG())) {
                            BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        avVar = selectInfo;
                    } else {
                        avVar = null;
                    }
                    b.this.fdw.a(i, b.this.fdy.getItem(i), avVar);
                }
            }
        });
    }

    private void qS() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.fdw != null) {
                    b.this.fdw.bid();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.apN != null) {
                    b.this.apN.release();
                }
                if (b.this.fdw != null) {
                    b.this.fdw.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        if (z && this.fdw != null && !this.fdw.ux()) {
            this.apQ.setChecked(false, false);
        } else if (z) {
            this.apP.setSwitchStatus(true);
            if (!TextUtils.isEmpty(k.uF().uI())) {
                this.apP.setSelectId(k.uF().uI());
            } else {
                this.apP.setSelectPos(0);
            }
            this.apP.setSelectEnabled(true);
            aT(true);
        } else {
            this.apP.setSwitchStatus(false);
            this.apP.setSelectEnabled(false);
            this.apN.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(boolean z) {
        if (z) {
            this.apN.setPreview();
        }
        this.apN.setUIInfo(this.apP.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.apN.setVisibility(4);
        } else if (this.apQ != null && this.apQ.isChecked()) {
            this.apN.setVisibility(0);
        }
    }

    private void vD() {
        final av[] aO = k.uF().aO(this.fdw != null && this.fdw.vG());
        if (aO == null) {
            if (this.apQ.isChecked()) {
                this.apQ.setChecked(false, false);
            } else {
                aS(false);
            }
            this.fdx.setVisibility(8);
            return;
        }
        this.fdx.setVisibility(0);
        this.apP.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.b.8
            @Override // java.lang.Runnable
            public void run() {
                b.this.apP.setData(aO, q.rk().rm(), 1);
                if (k.uF().uH()) {
                    if (b.this.apQ.isChecked()) {
                        b.this.apP.setSelectId(k.uF().uI());
                        b.this.aT(true);
                        return;
                    }
                    b.this.apQ.setChecked(true, false);
                } else if (b.this.apQ.isChecked()) {
                    b.this.apQ.setChecked(false, false);
                }
            }
        });
    }

    private void E(String[] strArr) {
        if (this.fdy == null) {
            this.fdy = new C0453b(strArr);
            this.aAU.setAdapter(this.fdy);
            return;
        }
        this.fdy.setDatas(strArr);
        this.fdy.notifyDataSetChanged();
    }

    private void sl() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0453b extends FlexAdapter<String> {
        C0453b(String[] strArr) {
            super(strArr);
        }

        @Override // com.baidu.live.tbadk.widget.flex.FlexAdapter
        public View getView(int i, ViewGroup viewGroup) {
            QuickInputFlexTextView quickInputFlexTextView = new QuickInputFlexTextView(viewGroup.getContext());
            quickInputFlexTextView.setText(getItem(i));
            return quickInputFlexTextView;
        }
    }
}
