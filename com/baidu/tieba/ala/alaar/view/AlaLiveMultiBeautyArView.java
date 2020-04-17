package com.baidu.tieba.ala.alaar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.d;
import com.baidu.live.ar.f;
import com.baidu.live.ar.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.sticker.a.e;
import com.baidu.tieba.ala.alaar.view.a;
import com.baidu.tieba.ala.alaar.view.b;
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyArView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext aOf;
    private int ds120;
    private int ds20;
    private int ds28;
    private int ds3;
    private HListView eMB;
    private a eMC;
    private int eMD;
    private int eME;
    private HListView eMF;
    private b eMG;
    private int eMH;
    private int eMI;
    private FrameLayout eMJ;
    private TopTipSeekBar eMK;
    private TextView eML;
    private TextView eMM;
    private View eMN;
    private int eMO;
    private FrameLayout eMP;
    private TopTipSeekBar eMQ;
    private TextView eMR;
    private TextView eMS;
    private BdAlertDialog eMT;
    private f eMU;
    private LinearLayout eMV;
    private Button eMW;
    private Button eMX;
    private Button eMY;
    private View eMZ;
    private boolean eNa;
    private com.baidu.live.ar.c eNb;
    private h eNc;
    private int eNd;
    private TextView eNe;
    private TextView mTitle;

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.eMD = -1;
        this.eME = -1;
        this.eMH = -1;
        this.eMI = -1;
        this.eMO = 0;
        this.eNa = true;
        this.eNb = com.baidu.live.ar.c.aoc;
        this.eNd = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eMD = -1;
        this.eME = -1;
        this.eMH = -1;
        this.eMI = -1;
        this.eMO = 0;
        this.eNa = true;
        this.eNb = com.baidu.live.ar.c.aoc;
        this.eNd = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eMD = -1;
        this.eME = -1;
        this.eMH = -1;
        this.eMI = -1;
        this.eMO = 0;
        this.eNa = true;
        this.eNb = com.baidu.live.ar.c.aoc;
        this.eNd = 1;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bkJ();
        this.eMB = (HListView) findViewById(a.g.filter_list_view);
        if (this.eMB != null) {
            this.eMC = new a(this.eMB);
            this.eMC.oV(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.eMB.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eMB.setAdapter((ListAdapter) this.eMC);
            this.eMB.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.eMB.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.eMD = i;
                AlaLiveMultiBeautyArView.this.eME = i2;
            }
        });
        this.eMC.a(new a.InterfaceC0454a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0454a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.eME > 0) {
                            AlaLiveMultiBeautyArView.this.eMB.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.eMD, AlaLiveMultiBeautyArView.this.eME, iArr, AlaLiveMultiBeautyArView.this.eMC.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                d dVar = AlaLiveMultiBeautyArView.this.eMC.getDatas().get(i);
                if (!AlaLiveMultiBeautyArView.this.eNb.anU.equals(e.yX(dVar.tR()))) {
                    AlaLiveMultiBeautyArView.this.zj(dVar.getName());
                }
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(dVar.getName())) {
                    com.baidu.live.ar.c cVar = AlaLiveMultiBeautyArView.this.eNb;
                    com.baidu.minivideo.arface.b.JY();
                    cVar.anU = com.baidu.minivideo.arface.c.Kb();
                } else {
                    AlaLiveMultiBeautyArView.this.eNb.anU = e.yX(dVar.tR());
                }
                AlaLiveMultiBeautyArView.this.eNb.anV = dVar;
                if (AlaLiveMultiBeautyArView.this.eNc != null) {
                    int a = AlaLiveMultiBeautyArView.this.eNb.a(dVar, AlaLiveMultiBeautyArView.this.eMU.tU().anJ);
                    int dE = AlaLiveMultiBeautyArView.this.eNb.dE(AlaLiveMultiBeautyArView.this.eNb.anU);
                    float f = (((dE * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a + ", level:" + dE + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.eNc.onFilterSelected(AlaLiveMultiBeautyArView.this.eNb.anU, f);
                }
                AlaLiveMultiBeautyArView.this.oT(AlaLiveMultiBeautyArView.this.eNb.dE(AlaLiveMultiBeautyArView.this.eNb.anU));
            }
        });
        this.eMP = (FrameLayout) findViewById(a.g.filter_rl_progress);
        this.eMR = (TextView) findViewById(a.g.filter_progress_tv);
        this.eMQ = (TopTipSeekBar) findViewById(a.g.filter_value_seekbar);
        this.eMQ.setMax(100);
        this.eMQ.setTipView(this.eMR);
        this.eMS = (TextView) findViewById(a.g.filter_def_thumb_tv);
        this.eMQ.setDefThumb(this.eMS);
        this.eMQ.setDefThumbPos(100);
        this.eMQ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.eNb.t(AlaLiveMultiBeautyArView.this.eNb.anU, i);
                if (AlaLiveMultiBeautyArView.this.eNc != null) {
                    int a = AlaLiveMultiBeautyArView.this.eNb.a(AlaLiveMultiBeautyArView.this.eNb.anV, AlaLiveMultiBeautyArView.this.eMU.tU().anJ);
                    float f = (((i * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.eNc.onFilterSelected(AlaLiveMultiBeautyArView.this.eNb.anU, f);
                }
                if (z) {
                    com.baidu.live.c.tH().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eMJ = (FrameLayout) findViewById(a.g.rl_beauty_progress);
        this.eML = (TextView) findViewById(a.g.progress_tv);
        this.eMM = (TextView) findViewById(a.g.def_thumb_tv);
        this.eMK = (TopTipSeekBar) findViewById(a.g.value_seekbar);
        this.eMN = findViewById(a.g.effect_diff_btn);
        this.eMF = (HListView) findViewById(a.g.beauty_list_view);
        this.eMK.setMax(100);
        this.eMK.setTipView(this.eML);
        this.eMK.setDefThumb(this.eMM);
        if (this.eMF != null) {
            this.eMG = new b(this.eMF);
            this.eMG.oV(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.eMF.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eMF.setAdapter((ListAdapter) this.eMG);
            this.eMF.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.eMF.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.eMH = i;
                AlaLiveMultiBeautyArView.this.eMI = i2;
            }
        });
        this.eMG.a(new b.InterfaceC0455b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            @Override // com.baidu.tieba.ala.alaar.view.b.InterfaceC0455b
            public void b(int i, int[] iArr) {
                if (i == 0) {
                    AlaLiveMultiBeautyArView.this.bkK();
                    return;
                }
                AlaLiveMultiBeautyArView.this.eMF.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.eMH, AlaLiveMultiBeautyArView.this.eMI, iArr, AlaLiveMultiBeautyArView.this.eMG.getCount(), true), 300);
                AlaLiveMultiBeautyArView.this.eNb.anW = AlaLiveMultiBeautyArView.this.eMG.eNv[i].eNA;
                AlaLiveMultiBeautyArView.this.eMO = AlaLiveMultiBeautyArView.this.eMG.eNv[i].eNB;
                AlaLiveMultiBeautyArView.this.oS(AlaLiveMultiBeautyArView.this.eNb.dF(AlaLiveMultiBeautyArView.this.eNb.anW) + AlaLiveMultiBeautyArView.this.eMO);
                AlaLiveMultiBeautyArView.this.eMK.setProcessDiff(AlaLiveMultiBeautyArView.this.eMG.eNv[i].eNB);
            }
        });
        this.eMK.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.eNb.u(AlaLiveMultiBeautyArView.this.eNb.anW, i - AlaLiveMultiBeautyArView.this.eMO);
                if (AlaLiveMultiBeautyArView.this.eNc != null) {
                    AlaLiveMultiBeautyArView.this.eNc.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.dC(AlaLiveMultiBeautyArView.this.eNb.anW));
                }
                if (z) {
                    com.baidu.live.c.tH().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eMN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.eNc != null) {
                            AlaLiveMultiBeautyArView.this.eNc.tZ();
                            return true;
                        }
                        return true;
                    case 1:
                    case 3:
                    case 4:
                        AlaLiveMultiBeautyArView.this.bkL();
                        return true;
                    case 2:
                    default:
                        return true;
                }
            }
        });
        this.eMY = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.eMY.setOnClickListener(this);
        this.eMW = (Button) findViewById(a.g.btn_choose_filter);
        this.eMW.setOnClickListener(this);
        this.eMX = (Button) findViewById(a.g.btn_choose_face_shape);
        this.eMX.setOnClickListener(this);
        this.eMV = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.eMZ = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.tW();
                if (AlaLiveMultiBeautyArView.this.eNc != null) {
                    AlaLiveMultiBeautyArView.this.eNc.tX();
                }
            }
        });
        this.eNe = (TextView) findViewById(a.g.filter_select_anim);
    }

    private void bkJ() {
        this.ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        this.ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        this.ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void tW() {
        if (this.eNb != null) {
            com.baidu.live.c.tH().putString("ala_beauty_config_ar", this.eNb.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(f fVar) {
        this.eMU = fVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aOf = bdPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.eMK.setProgress(i, true);
        } else {
            this.eMK.setProgress(i);
        }
        this.eMK.setDefThumbPos(com.baidu.live.ar.c.aob.dF(this.eNb.anW) + this.eMO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oT(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.eMQ.setProgress(i, true);
        } else {
            this.eMQ.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, int i2, int i3, int[] iArr, int i4, boolean z) {
        int i5;
        int i6 = (i3 / 2) + i2;
        if (i >= i2 + i3) {
            i5 = (((i - i6) + 1) * this.ds120) + this.ds28;
        } else {
            i5 = ((i - i6) * this.ds120) + this.ds28 + (this.ds120 / 2);
        }
        int i7 = BdUtilHelper.getScreenSize(this.aOf.getPageActivity()).widthPixels;
        if (iArr != null) {
            int i8 = iArr[0] - ((i7 - this.ds120) / 2);
            int i9 = z ? ((i - 1) * (this.ds120 + this.ds20)) + this.ds28 + this.ds3 + this.ds20 : ((this.ds120 + this.ds20) * i) + this.ds28;
            int i10 = ((i4 - i) - 1) * (this.ds120 + this.ds20);
            if ((i7 - this.ds120) / 2 > i9) {
                return (((i7 - this.ds120) / 2) - i9) + i8;
            }
            return (i7 - this.ds120) / 2 > i10 ? i8 - (((i7 - this.ds120) / 2) - i10) : i8;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkK() {
        if (this.eMT != null) {
            this.eMT.dismiss();
            this.eMT = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.eMT = new BdAlertDialog((Activity) getContext());
        this.eMT.setAutoNight(false);
        this.eMT.setMessage(string);
        this.eMT.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (AlaLiveMultiBeautyArView.this.eNc != null) {
                    AlaLiveMultiBeautyArView.this.eNc.tY();
                }
                String str = com.baidu.live.ar.c.aoc.anW;
                com.baidu.live.ar.c.aoc.dD(com.baidu.live.ar.c.aob.toJsonString());
                com.baidu.live.ar.c.aoc.anW = str;
                AlaLiveMultiBeautyArView.this.eNb = com.baidu.live.ar.c.aoc;
                AlaLiveMultiBeautyArView.this.oS(AlaLiveMultiBeautyArView.this.eNb.dF(AlaLiveMultiBeautyArView.this.eNb.anW) + AlaLiveMultiBeautyArView.this.eMO);
                AlaLiveMultiBeautyArView.this.xl();
            }
        });
        this.eMT.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.xl();
            }
        });
        this.eMT.setCancelable(false);
        this.eMT.setCanceledOnTouchOutside(false);
        this.eMT.setTitleShowCenter(true);
        this.eMT.setMessageShowCenter(true);
        this.eMT.isShowTitleAndMessage();
        this.eMT.create(this.aOf);
        this.eMT.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl() {
        if (this.eMT != null) {
            this.eMT.dismiss();
            this.eMT = null;
        }
        this.eMT = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eNa && this.eMW.getWidth() != 0) {
            e((View) this.eMW, false);
            this.eNa = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eMW) {
            e((View) this.eMW, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eMW);
            if (this.eMB != null) {
                setEffectFilterBeautyChooseBlock(this.eMB);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
            this.eNd = 0;
            this.eMJ.setVisibility(8);
            this.eMP.setVisibility(0);
        } else if (view == this.eMX) {
            e((View) this.eMX, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eMX);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.eMY) {
            e((View) this.eMY, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eMY);
            setEffectFilterBeautyChooseBlock(this.eMF);
            this.eMJ.setVisibility(0);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
            this.eNd = 1;
            this.eMJ.setVisibility(0);
            this.eMP.setVisibility(8);
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.eMB != null) {
            this.eMB.setVisibility(4);
        }
        if (this.eMF != null) {
            this.eMF.setVisibility(4);
        }
        this.eMV.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.eMW.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eMX.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eMY.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(h hVar) {
        this.eNc = hVar;
    }

    private void e(View view, boolean z) {
        this.eMZ.clearAnimation();
        int width = (this.eMZ.getWidth() / 2) + this.eMZ.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMZ.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.eMZ.getWidth() / 2);
        this.eMZ.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.eMZ.startAnimation(translateAnimation);
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.c.aoc.dD(com.baidu.live.c.tH().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.c.aoc.anU) && com.baidu.minivideo.arface.b.JY() != null) {
            com.baidu.live.ar.c cVar = com.baidu.live.ar.c.aoc;
            com.baidu.minivideo.arface.b.JY();
            cVar.anU = com.baidu.minivideo.arface.c.Kb();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.e.aof)) {
            com.baidu.minivideo.arface.b.JY();
            com.baidu.live.ar.e.dG(com.baidu.minivideo.arface.c.Kb());
        }
        this.eNb = com.baidu.live.ar.c.aoc;
        bkL();
        oS(this.eNb.dF(this.eNb.anW) + this.eMO);
        this.eMG.zl(this.eNb.anW);
        this.eMG.notifyDataSetChanged();
        if (this.eMU != null && this.eMU.tU() != null && this.eMU.tU().anJ != null) {
            this.eMC.setDatas(this.eMU.tU().anJ);
        }
        if (!TextUtils.isEmpty(this.eNb.anU)) {
            this.eMC.zk(this.eNb.anU);
        }
        this.eMC.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkL() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.eNc != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.eMG != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.eMG.eNv.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.eMG.eNv[i2].eNA)) {
                            i = this.eMG.eNv[i2].eNB;
                        }
                    }
                } else {
                    i = 0;
                }
                this.eNc.a(((this.eNb.dF(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(String str) {
        this.eNe.setText(str);
        this.eNe.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eNe, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eNe, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eNe, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.eNe, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void tV() {
        if (this.eMG != null) {
            this.eMG.notifyDataSetChanged();
        }
        if (this.eMC != null) {
            this.eMC.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
