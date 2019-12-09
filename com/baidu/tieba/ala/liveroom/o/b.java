package com.baidu.tieba.ala.liveroom.o;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import com.baidu.live.data.ao;
import com.baidu.live.gift.o;
import com.baidu.live.im.k;
import com.baidu.live.im.view.ImBarrageItemView;
import com.baidu.live.im.view.ImBarrageOptionListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.view.Switch;
import com.baidu.live.view.input.QuickInputFlexTextView;
/* loaded from: classes6.dex */
public class b extends Dialog {
    private ImBarrageItemView ahL;
    private ImBarrageOptionListView ahN;
    private Switch ahO;
    private FlexLayout ata;
    private a emX;
    private View emY;
    private C0363b emZ;
    private View mContentView;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, String str, ao aoVar);

        void aav();

        void onDismiss();

        boolean sG();
    }

    public b(@NonNull Context context) {
        super(context, a.j.sdk_TransparentDialog);
        init();
    }

    public void a(a aVar) {
        this.emX = aVar;
    }

    public void u(String[] strArr) {
        v(strArr);
        aVL();
        qB();
        show();
        if (this.mContentView != null) {
            this.mContentView.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.ata != null && (layoutParams = b.this.ata.getLayoutParams()) != null) {
                        layoutParams.height = b.this.ata.realHeight;
                        b.this.ata.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void bw(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.ata != null && (layoutParams = this.ata.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.ata.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.ahL.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.ata != null && (layoutParams2 = b.this.ata.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.ata.realHeight;
                                b.this.ata.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.ahO != null && this.ahO.isChecked()) {
                this.ahL.setVisibility(0);
            }
        }
    }

    public void aVK() {
        if (this.ahN != null) {
            this.ahN.j(o.pI().pK());
        }
    }

    private void init() {
        wD();
        initView();
        pv();
    }

    private void wD() {
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
        this.ahL = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.emY = findViewById(a.g.layout_barrage);
        this.ahO = (Switch) findViewById(a.g.switch_barrage);
        this.ahN = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.ata = (FlexLayout) findViewById(a.g.flex);
        this.ahO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.aB(z);
            }
        });
        this.ahN.setSelectEnabled(false);
        this.ahN.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public void bu(int i) {
                b.this.aC(false);
            }
        });
        this.ata.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.ata.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.ata.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                ao aoVar;
                if (b.this.emX != null) {
                    if (b.this.emY.getVisibility() == 0 && b.this.ahO.isChecked()) {
                        aoVar = b.this.ahN.getSelectInfo();
                    } else {
                        aoVar = null;
                    }
                    b.this.emX.a(i, b.this.emZ.getItem(i), aoVar);
                }
            }
        });
    }

    private void pv() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.emX != null) {
                    b.this.emX.aav();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.ahL != null) {
                    b.this.ahL.release();
                }
                if (b.this.emX != null) {
                    b.this.emX.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(boolean z) {
        if (z && this.emX != null && !this.emX.sG()) {
            this.ahO.setChecked(false, false);
        } else if (z) {
            k.sN().ax(true);
            this.ahN.setSelectEnabled(true);
            this.ahN.setSelect(k.sN().getSelect());
            aC(true);
        } else {
            k.sN().ax(false);
            this.ahN.setSelect(k.sN().getSelect());
            this.ahN.setSelectEnabled(false);
            this.ahL.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(boolean z) {
        if (z) {
            this.ahL.setPreview();
        }
        this.ahL.setUIInfo(this.ahN.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.ahL.setVisibility(4);
        } else if (this.ahO != null && this.ahO.isChecked()) {
            this.ahL.setVisibility(0);
        }
    }

    private void aVL() {
        final ao[] sO = k.sN().sO();
        if (sO == null) {
            if (this.ahO.isChecked()) {
                this.ahO.setChecked(false, false);
            } else {
                aB(false);
            }
            this.emY.setVisibility(8);
            return;
        }
        this.emY.setVisibility(0);
        this.ahN.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.b.8
            @Override // java.lang.Runnable
            public void run() {
                b.this.ahN.setData(sO, o.pI().pK(), 1);
                if (k.sN().sP()) {
                    if (b.this.ahO.isChecked()) {
                        b.this.ahN.setSelect(k.sN().getSelect());
                        b.this.aC(true);
                        return;
                    }
                    b.this.ahO.setChecked(true, false);
                } else if (b.this.ahO.isChecked()) {
                    b.this.ahO.setChecked(false, false);
                }
            }
        });
    }

    private void v(String[] strArr) {
        if (this.emZ == null) {
            this.emZ = new C0363b(strArr);
            this.ata.setAdapter(this.emZ);
            return;
        }
        this.emZ.setDatas(strArr);
        this.emZ.notifyDataSetChanged();
    }

    private void qB() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0363b extends FlexAdapter<String> {
        C0363b(String[] strArr) {
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
