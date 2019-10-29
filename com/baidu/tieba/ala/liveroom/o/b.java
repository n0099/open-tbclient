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
    private ImBarrageItemView aie;
    private ImBarrageOptionListView aig;
    private Switch aih;
    private FlexLayout ats;
    private a enQ;
    private View enR;
    private C0368b enS;
    private View mContentView;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, String str, ao aoVar);

        void aax();

        void onDismiss();

        boolean sF();
    }

    public b(@NonNull Context context) {
        super(context, a.j.sdk_TransparentDialog);
        init();
    }

    public void a(a aVar) {
        this.enQ = aVar;
    }

    public void u(String[] strArr) {
        v(strArr);
        aVN();
        qA();
        show();
        if (this.mContentView != null) {
            this.mContentView.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.ats != null && (layoutParams = b.this.ats.getLayoutParams()) != null) {
                        layoutParams.height = b.this.ats.realHeight;
                        b.this.ats.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    public void bw(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.ats != null && (layoutParams = this.ats.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.ats.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.aie.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.ats != null && (layoutParams2 = b.this.ats.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.ats.realHeight;
                                b.this.ats.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.aih != null && this.aih.isChecked()) {
                this.aie.setVisibility(0);
            }
        }
    }

    public void aVM() {
        if (this.aig != null) {
            this.aig.j(o.pI().pK());
        }
    }

    private void init() {
        wC();
        initView();
        pv();
    }

    private void wC() {
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
        this.aie = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.enR = findViewById(a.g.layout_barrage);
        this.aih = (Switch) findViewById(a.g.switch_barrage);
        this.aig = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.ats = (FlexLayout) findViewById(a.g.flex);
        this.aih.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.aB(z);
            }
        });
        this.aig.setSelectEnabled(false);
        this.aig.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public void bu(int i) {
                b.this.aC(false);
            }
        });
        this.ats.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.ats.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.ats.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                ao aoVar;
                if (b.this.enQ != null) {
                    if (b.this.enR.getVisibility() == 0 && b.this.aih.isChecked()) {
                        aoVar = b.this.aig.getSelectInfo();
                    } else {
                        aoVar = null;
                    }
                    b.this.enQ.a(i, b.this.enS.getItem(i), aoVar);
                }
            }
        });
    }

    private void pv() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.enQ != null) {
                    b.this.enQ.aax();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.aie != null) {
                    b.this.aie.release();
                }
                if (b.this.enQ != null) {
                    b.this.enQ.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(boolean z) {
        if (z && this.enQ != null && !this.enQ.sF()) {
            this.aih.setChecked(false, false);
        } else if (z) {
            k.sM().ax(true);
            this.aig.setSelectEnabled(true);
            this.aig.setSelect(k.sM().getSelect());
            aC(true);
        } else {
            k.sM().ax(false);
            this.aig.setSelect(k.sM().getSelect());
            this.aig.setSelectEnabled(false);
            this.aie.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(boolean z) {
        if (z) {
            this.aie.setPreview();
        }
        this.aie.setUIInfo(this.aig.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aie.setVisibility(4);
        } else if (this.aih != null && this.aih.isChecked()) {
            this.aie.setVisibility(0);
        }
    }

    private void aVN() {
        final ao[] sN = k.sM().sN();
        if (sN == null) {
            if (this.aih.isChecked()) {
                this.aih.setChecked(false, false);
            } else {
                aB(false);
            }
            this.enR.setVisibility(8);
            return;
        }
        this.enR.setVisibility(0);
        this.aig.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.b.8
            @Override // java.lang.Runnable
            public void run() {
                b.this.aig.setData(sN, o.pI().pK(), 1);
                if (k.sM().sO()) {
                    if (b.this.aih.isChecked()) {
                        b.this.aig.setSelect(k.sM().getSelect());
                        b.this.aC(true);
                        return;
                    }
                    b.this.aih.setChecked(true, false);
                } else if (b.this.aih.isChecked()) {
                    b.this.aih.setChecked(false, false);
                }
            }
        });
    }

    private void v(String[] strArr) {
        if (this.enS == null) {
            this.enS = new C0368b(strArr);
            this.ats.setAdapter(this.enS);
            return;
        }
        this.enS.setDatas(strArr);
        this.enS.notifyDataSetChanged();
    }

    private void qA() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0368b extends FlexAdapter<String> {
        C0368b(String[] strArr) {
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
