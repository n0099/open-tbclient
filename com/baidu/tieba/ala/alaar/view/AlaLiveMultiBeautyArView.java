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
    private BdPageContext aOl;
    private int ds120;
    private int ds20;
    private int ds28;
    private int ds3;
    private HListView eMG;
    private a eMH;
    private int eMI;
    private int eMJ;
    private HListView eMK;
    private b eML;
    private int eMM;
    private int eMN;
    private FrameLayout eMO;
    private TopTipSeekBar eMP;
    private TextView eMQ;
    private TextView eMR;
    private View eMS;
    private int eMT;
    private FrameLayout eMU;
    private TopTipSeekBar eMV;
    private TextView eMW;
    private TextView eMX;
    private BdAlertDialog eMY;
    private f eMZ;
    private LinearLayout eNa;
    private Button eNb;
    private Button eNc;
    private Button eNd;
    private View eNe;
    private boolean eNf;
    private com.baidu.live.ar.c eNg;
    private h eNh;
    private int eNi;
    private TextView eNj;
    private TextView mTitle;

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.eMI = -1;
        this.eMJ = -1;
        this.eMM = -1;
        this.eMN = -1;
        this.eMT = 0;
        this.eNf = true;
        this.eNg = com.baidu.live.ar.c.aoi;
        this.eNi = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eMI = -1;
        this.eMJ = -1;
        this.eMM = -1;
        this.eMN = -1;
        this.eMT = 0;
        this.eNf = true;
        this.eNg = com.baidu.live.ar.c.aoi;
        this.eNi = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eMI = -1;
        this.eMJ = -1;
        this.eMM = -1;
        this.eMN = -1;
        this.eMT = 0;
        this.eNf = true;
        this.eNg = com.baidu.live.ar.c.aoi;
        this.eNi = 1;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bkH();
        this.eMG = (HListView) findViewById(a.g.filter_list_view);
        if (this.eMG != null) {
            this.eMH = new a(this.eMG);
            this.eMH.oV(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.eMG.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eMG.setAdapter((ListAdapter) this.eMH);
            this.eMG.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.eMG.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.eMI = i;
                AlaLiveMultiBeautyArView.this.eMJ = i2;
            }
        });
        this.eMH.a(new a.InterfaceC0475a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0475a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.eMJ > 0) {
                            AlaLiveMultiBeautyArView.this.eMG.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.eMI, AlaLiveMultiBeautyArView.this.eMJ, iArr, AlaLiveMultiBeautyArView.this.eMH.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                d dVar = AlaLiveMultiBeautyArView.this.eMH.getDatas().get(i);
                if (!AlaLiveMultiBeautyArView.this.eNg.aoa.equals(e.za(dVar.tQ()))) {
                    AlaLiveMultiBeautyArView.this.zm(dVar.getName());
                }
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(dVar.getName())) {
                    com.baidu.live.ar.c cVar = AlaLiveMultiBeautyArView.this.eNg;
                    com.baidu.minivideo.arface.b.JX();
                    cVar.aoa = com.baidu.minivideo.arface.c.Ka();
                } else {
                    AlaLiveMultiBeautyArView.this.eNg.aoa = e.za(dVar.tQ());
                }
                AlaLiveMultiBeautyArView.this.eNg.aob = dVar;
                if (AlaLiveMultiBeautyArView.this.eNh != null) {
                    int a = AlaLiveMultiBeautyArView.this.eNg.a(dVar, AlaLiveMultiBeautyArView.this.eMZ.tT().anP);
                    int dE = AlaLiveMultiBeautyArView.this.eNg.dE(AlaLiveMultiBeautyArView.this.eNg.aoa);
                    float f = (((dE * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a + ", level:" + dE + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.eNh.onFilterSelected(AlaLiveMultiBeautyArView.this.eNg.aoa, f);
                }
                AlaLiveMultiBeautyArView.this.oT(AlaLiveMultiBeautyArView.this.eNg.dE(AlaLiveMultiBeautyArView.this.eNg.aoa));
            }
        });
        this.eMU = (FrameLayout) findViewById(a.g.filter_rl_progress);
        this.eMW = (TextView) findViewById(a.g.filter_progress_tv);
        this.eMV = (TopTipSeekBar) findViewById(a.g.filter_value_seekbar);
        this.eMV.setMax(100);
        this.eMV.setTipView(this.eMW);
        this.eMX = (TextView) findViewById(a.g.filter_def_thumb_tv);
        this.eMV.setDefThumb(this.eMX);
        this.eMV.setDefThumbPos(100);
        this.eMV.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.eNg.t(AlaLiveMultiBeautyArView.this.eNg.aoa, i);
                if (AlaLiveMultiBeautyArView.this.eNh != null) {
                    int a = AlaLiveMultiBeautyArView.this.eNg.a(AlaLiveMultiBeautyArView.this.eNg.aob, AlaLiveMultiBeautyArView.this.eMZ.tT().anP);
                    float f = (((i * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.eNh.onFilterSelected(AlaLiveMultiBeautyArView.this.eNg.aoa, f);
                }
                if (z) {
                    com.baidu.live.c.tG().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eMO = (FrameLayout) findViewById(a.g.rl_beauty_progress);
        this.eMQ = (TextView) findViewById(a.g.progress_tv);
        this.eMR = (TextView) findViewById(a.g.def_thumb_tv);
        this.eMP = (TopTipSeekBar) findViewById(a.g.value_seekbar);
        this.eMS = findViewById(a.g.effect_diff_btn);
        this.eMK = (HListView) findViewById(a.g.beauty_list_view);
        this.eMP.setMax(100);
        this.eMP.setTipView(this.eMQ);
        this.eMP.setDefThumb(this.eMR);
        if (this.eMK != null) {
            this.eML = new b(this.eMK);
            this.eML.oV(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.eMK.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eMK.setAdapter((ListAdapter) this.eML);
            this.eMK.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.eMK.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.eMM = i;
                AlaLiveMultiBeautyArView.this.eMN = i2;
            }
        });
        this.eML.a(new b.InterfaceC0476b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            @Override // com.baidu.tieba.ala.alaar.view.b.InterfaceC0476b
            public void b(int i, int[] iArr) {
                if (i == 0) {
                    AlaLiveMultiBeautyArView.this.bkI();
                    return;
                }
                AlaLiveMultiBeautyArView.this.eMK.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.eMM, AlaLiveMultiBeautyArView.this.eMN, iArr, AlaLiveMultiBeautyArView.this.eML.getCount(), true), 300);
                AlaLiveMultiBeautyArView.this.eNg.aoc = AlaLiveMultiBeautyArView.this.eML.eNA[i].eNF;
                AlaLiveMultiBeautyArView.this.eMT = AlaLiveMultiBeautyArView.this.eML.eNA[i].eNG;
                AlaLiveMultiBeautyArView.this.oS(AlaLiveMultiBeautyArView.this.eNg.dF(AlaLiveMultiBeautyArView.this.eNg.aoc) + AlaLiveMultiBeautyArView.this.eMT);
                AlaLiveMultiBeautyArView.this.eMP.setProcessDiff(AlaLiveMultiBeautyArView.this.eML.eNA[i].eNG);
            }
        });
        this.eMP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.eNg.u(AlaLiveMultiBeautyArView.this.eNg.aoc, i - AlaLiveMultiBeautyArView.this.eMT);
                if (AlaLiveMultiBeautyArView.this.eNh != null) {
                    AlaLiveMultiBeautyArView.this.eNh.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.dC(AlaLiveMultiBeautyArView.this.eNg.aoc));
                }
                if (z) {
                    com.baidu.live.c.tG().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eMS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.eNh != null) {
                            AlaLiveMultiBeautyArView.this.eNh.tY();
                            return true;
                        }
                        return true;
                    case 1:
                    case 3:
                    case 4:
                        AlaLiveMultiBeautyArView.this.bkJ();
                        return true;
                    case 2:
                    default:
                        return true;
                }
            }
        });
        this.eNd = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.eNd.setOnClickListener(this);
        this.eNb = (Button) findViewById(a.g.btn_choose_filter);
        this.eNb.setOnClickListener(this);
        this.eNc = (Button) findViewById(a.g.btn_choose_face_shape);
        this.eNc.setOnClickListener(this);
        this.eNa = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.eNe = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.tV();
                if (AlaLiveMultiBeautyArView.this.eNh != null) {
                    AlaLiveMultiBeautyArView.this.eNh.tW();
                }
            }
        });
        this.eNj = (TextView) findViewById(a.g.filter_select_anim);
    }

    private void bkH() {
        this.ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        this.ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        this.ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void tV() {
        if (this.eNg != null) {
            com.baidu.live.c.tG().putString("ala_beauty_config_ar", this.eNg.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(f fVar) {
        this.eMZ = fVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aOl = bdPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.eMP.setProgress(i, true);
        } else {
            this.eMP.setProgress(i);
        }
        this.eMP.setDefThumbPos(com.baidu.live.ar.c.aoh.dF(this.eNg.aoc) + this.eMT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oT(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.eMV.setProgress(i, true);
        } else {
            this.eMV.setProgress(i);
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
        int i7 = BdUtilHelper.getScreenSize(this.aOl.getPageActivity()).widthPixels;
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
    public void bkI() {
        if (this.eMY != null) {
            this.eMY.dismiss();
            this.eMY = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.eMY = new BdAlertDialog((Activity) getContext());
        this.eMY.setAutoNight(false);
        this.eMY.setMessage(string);
        this.eMY.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (AlaLiveMultiBeautyArView.this.eNh != null) {
                    AlaLiveMultiBeautyArView.this.eNh.tX();
                }
                String str = com.baidu.live.ar.c.aoi.aoc;
                com.baidu.live.ar.c.aoi.dD(com.baidu.live.ar.c.aoh.toJsonString());
                com.baidu.live.ar.c.aoi.aoc = str;
                AlaLiveMultiBeautyArView.this.eNg = com.baidu.live.ar.c.aoi;
                AlaLiveMultiBeautyArView.this.oS(AlaLiveMultiBeautyArView.this.eNg.dF(AlaLiveMultiBeautyArView.this.eNg.aoc) + AlaLiveMultiBeautyArView.this.eMT);
                AlaLiveMultiBeautyArView.this.xk();
            }
        });
        this.eMY.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.xk();
            }
        });
        this.eMY.setCancelable(false);
        this.eMY.setCanceledOnTouchOutside(false);
        this.eMY.setTitleShowCenter(true);
        this.eMY.setMessageShowCenter(true);
        this.eMY.isShowTitleAndMessage();
        this.eMY.create(this.aOl);
        this.eMY.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xk() {
        if (this.eMY != null) {
            this.eMY.dismiss();
            this.eMY = null;
        }
        this.eMY = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eNf && this.eNb.getWidth() != 0) {
            e((View) this.eNb, false);
            this.eNf = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eNb) {
            e((View) this.eNb, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eNb);
            if (this.eMG != null) {
                setEffectFilterBeautyChooseBlock(this.eMG);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
            this.eNi = 0;
            this.eMO.setVisibility(8);
            this.eMU.setVisibility(0);
        } else if (view == this.eNc) {
            e((View) this.eNc, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eNc);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.eNd) {
            e((View) this.eNd, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eNd);
            setEffectFilterBeautyChooseBlock(this.eMK);
            this.eMO.setVisibility(0);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
            this.eNi = 1;
            this.eMO.setVisibility(0);
            this.eMU.setVisibility(8);
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.eMG != null) {
            this.eMG.setVisibility(4);
        }
        if (this.eMK != null) {
            this.eMK.setVisibility(4);
        }
        this.eNa.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.eNb.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eNc.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eNd.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(h hVar) {
        this.eNh = hVar;
    }

    private void e(View view, boolean z) {
        this.eNe.clearAnimation();
        int width = (this.eNe.getWidth() / 2) + this.eNe.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNe.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.eNe.getWidth() / 2);
        this.eNe.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.eNe.startAnimation(translateAnimation);
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.c.aoi.dD(com.baidu.live.c.tG().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.c.aoi.aoa) && com.baidu.minivideo.arface.b.JX() != null) {
            com.baidu.live.ar.c cVar = com.baidu.live.ar.c.aoi;
            com.baidu.minivideo.arface.b.JX();
            cVar.aoa = com.baidu.minivideo.arface.c.Ka();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.e.aol)) {
            com.baidu.minivideo.arface.b.JX();
            com.baidu.live.ar.e.dG(com.baidu.minivideo.arface.c.Ka());
        }
        this.eNg = com.baidu.live.ar.c.aoi;
        bkJ();
        oS(this.eNg.dF(this.eNg.aoc) + this.eMT);
        this.eML.zo(this.eNg.aoc);
        this.eML.notifyDataSetChanged();
        if (this.eMZ != null && this.eMZ.tT() != null && this.eMZ.tT().anP != null) {
            this.eMH.setDatas(this.eMZ.tT().anP);
        }
        if (!TextUtils.isEmpty(this.eNg.aoa)) {
            this.eMH.zn(this.eNg.aoa);
        }
        this.eMH.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkJ() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.eNh != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.eML != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.eML.eNA.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.eML.eNA[i2].eNF)) {
                            i = this.eML.eNA[i2].eNG;
                        }
                    }
                } else {
                    i = 0;
                }
                this.eNh.a(((this.eNg.dF(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zm(String str) {
        this.eNj.setText(str);
        this.eNj.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eNj, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eNj, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eNj, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.eNj, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void tU() {
        if (this.eML != null) {
            this.eML.notifyDataSetChanged();
        }
        if (this.eMH != null) {
            this.eMH.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
