package com.baidu.tieba.ala.liveroom.t;

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
import com.baidu.live.data.az;
import com.baidu.live.gift.q;
import com.baidu.live.im.k;
import com.baidu.live.im.view.ImBarrageItemView;
import com.baidu.live.im.view.ImBarrageOptionListView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.view.Switch;
import com.baidu.live.view.input.QuickInputFlexTextView;
/* loaded from: classes2.dex */
public class b extends Dialog {
    private FlexLayout aBH;
    private ImBarrageOptionListView aqB;
    private Switch aqC;
    private ImBarrageItemView aqz;
    private a fgC;
    private View fgD;
    private C0457b fgE;
    private View mContentView;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, String str, az azVar);

        void biO();

        void onDismiss();

        boolean uO();

        boolean vX();
    }

    public b(@NonNull Context context) {
        super(context, a.j.sdk_TransparentDialog);
        init();
    }

    public void a(a aVar) {
        this.fgC = aVar;
    }

    public void D(String[] strArr) {
        E(strArr);
        vU();
        sB();
        show();
        if (this.mContentView != null) {
            this.mContentView.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.t.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.aBH != null && (layoutParams = b.this.aBH.getLayoutParams()) != null) {
                        layoutParams.height = b.this.aBH.realHeight;
                        b.this.aBH.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void bN(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.aBH != null && (layoutParams = this.aBH.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.aBH.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.aqz.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.t.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.aBH != null && (layoutParams2 = b.this.aBH.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.aBH.realHeight;
                                b.this.aBH.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.aqC != null && this.aqC.isChecked()) {
                this.aqz.setVisibility(0);
            }
        }
    }

    public void boD() {
        if (this.aqB != null) {
            this.aqB.i(q.rw().ry());
        }
    }

    private void init() {
        initWindow();
        initView();
        re();
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
        this.aqz = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.fgD = findViewById(a.g.layout_barrage);
        this.aqC = (Switch) findViewById(a.g.switch_barrage);
        this.aqB = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aBH = (FlexLayout) findViewById(a.g.flex);
        this.aqC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.aU(z);
            }
        });
        this.aqB.setSelectEnabled(false);
        this.aqB.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.tieba.ala.liveroom.t.b.4
            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public boolean vX() {
                return b.this.fgC != null && b.this.fgC.vX();
            }

            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public void bI(int i) {
                b.this.aV(false);
            }
        });
        this.aBH.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.aBH.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.aBH.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                az azVar;
                if (b.this.fgC != null) {
                    if (b.this.fgD.getVisibility() == 0 && b.this.aqC.isChecked()) {
                        az selectInfo = b.this.aqB.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.fgC == null || !b.this.fgC.vX())) {
                            BdUtilHelper.showToast(b.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        azVar = selectInfo;
                    } else {
                        azVar = null;
                    }
                    b.this.fgC.a(i, b.this.fgE.getItem(i), azVar);
                }
            }
        });
    }

    private void re() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.fgC != null) {
                    b.this.fgC.biO();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.aqz != null) {
                    b.this.aqz.release();
                }
                if (b.this.fgC != null) {
                    b.this.fgC.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(boolean z) {
        if (z && this.fgC != null && !this.fgC.uO()) {
            this.aqC.setChecked(false, false);
        } else if (z) {
            this.aqB.setSwitchStatus(true);
            if (!TextUtils.isEmpty(k.uW().uZ())) {
                this.aqB.setSelectId(k.uW().uZ());
            } else {
                this.aqB.setSelectPos(0);
            }
            this.aqB.setSelectEnabled(true);
            aV(true);
        } else {
            this.aqB.setSwitchStatus(false);
            this.aqB.setSelectEnabled(false);
            this.aqz.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(boolean z) {
        if (z) {
            this.aqz.setPreview();
        }
        this.aqz.setUIInfo(this.aqB.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aqz.setVisibility(4);
        } else if (this.aqC != null && this.aqC.isChecked()) {
            this.aqz.setVisibility(0);
        }
    }

    private void vU() {
        final az[] aQ = k.uW().aQ(this.fgC != null && this.fgC.vX());
        if (aQ == null) {
            if (this.aqC.isChecked()) {
                this.aqC.setChecked(false, false);
            } else {
                aU(false);
            }
            this.fgD.setVisibility(8);
            return;
        }
        this.fgD.setVisibility(0);
        this.aqB.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.t.b.8
            @Override // java.lang.Runnable
            public void run() {
                b.this.aqB.setData(aQ, q.rw().ry(), 1);
                if (k.uW().uY()) {
                    if (b.this.aqC.isChecked()) {
                        b.this.aqB.setSelectId(k.uW().uZ());
                        b.this.aV(true);
                        return;
                    }
                    b.this.aqC.setChecked(true, false);
                } else if (b.this.aqC.isChecked()) {
                    b.this.aqC.setChecked(false, false);
                }
            }
        });
    }

    private void E(String[] strArr) {
        if (this.fgE == null) {
            this.fgE = new C0457b(strArr);
            this.aBH.setAdapter(this.fgE);
            return;
        }
        this.fgE.setDatas(strArr);
        this.fgE.notifyDataSetChanged();
    }

    private void sB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0457b extends FlexAdapter<String> {
        C0457b(String[] strArr) {
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
