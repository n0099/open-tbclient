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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.f;
import com.baidu.live.ar.g;
import com.baidu.live.ar.h;
import com.baidu.live.ar.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.alaar.view.a;
import com.baidu.tieba.ala.alaar.view.b;
import com.baidu.tieba.ala.alaar.view.c;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AlaLiveMultiBeautyArView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext aXY;
    private int ds120;
    private int ds20;
    private int ds28;
    private int ds3;
    private int fpA;
    private HListView fpB;
    private c fpC;
    private int fpD;
    private int fpE;
    private FrameLayout fpF;
    private TopTipSeekBar fpG;
    private TextView fpH;
    private TextView fpI;
    private View fpJ;
    private int fpK;
    private FrameLayout fpL;
    private TopTipSeekBar fpM;
    private TextView fpN;
    private TextView fpO;
    private BdAlertDialog fpP;
    private h fpQ;
    private LinearLayout fpR;
    private ImageView fpS;
    private TextView fpT;
    private ImageView fpU;
    private Button fpV;
    private Button fpW;
    private Button fpX;
    private View fpY;
    private boolean fpZ;
    private HListView fpt;
    private a fpu;
    private int fpv;
    private int fpw;
    private HListView fpx;
    private b fpy;
    private int fpz;
    private com.baidu.live.ar.d fqa;
    private j fqb;
    private int fqc;
    private TextView fqd;
    private TextView mTitle;

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.fpv = -1;
        this.fpw = -1;
        this.fpz = -1;
        this.fpA = -1;
        this.fpD = -1;
        this.fpE = -1;
        this.fpK = 0;
        this.fpZ = true;
        this.fqa = com.baidu.live.ar.d.auY;
        this.fqc = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fpv = -1;
        this.fpw = -1;
        this.fpz = -1;
        this.fpA = -1;
        this.fpD = -1;
        this.fpE = -1;
        this.fpK = 0;
        this.fpZ = true;
        this.fqa = com.baidu.live.ar.d.auY;
        this.fqc = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fpv = -1;
        this.fpw = -1;
        this.fpz = -1;
        this.fpA = -1;
        this.fpD = -1;
        this.fpE = -1;
        this.fpK = 0;
        this.fpZ = true;
        this.fqa = com.baidu.live.ar.d.auY;
        this.fqc = 1;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bwi();
        bwf();
        this.fpL = (FrameLayout) findViewById(a.g.filter_rl_progress);
        this.fpN = (TextView) findViewById(a.g.filter_progress_tv);
        this.fpM = (TopTipSeekBar) findViewById(a.g.filter_value_seekbar);
        this.fpM.setMax(100);
        this.fpM.setTipView(this.fpN);
        this.fpO = (TextView) findViewById(a.g.filter_def_thumb_tv);
        this.fpM.setDefThumb(this.fpO);
        this.fpM.setDefThumbPos(100);
        this.fpM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.fqa.x(AlaLiveMultiBeautyArView.this.fqa.auM, i);
                if (AlaLiveMultiBeautyArView.this.fqb != null) {
                    int a = AlaLiveMultiBeautyArView.this.fqa.a(AlaLiveMultiBeautyArView.this.fqa.auN, AlaLiveMultiBeautyArView.this.fpQ.vv().auy);
                    float f = (((i * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fqb.onFilterSelected(AlaLiveMultiBeautyArView.this.fqa.auN.getName(), AlaLiveMultiBeautyArView.this.fqa.auM, f);
                }
                if (z) {
                    com.baidu.live.c.vf().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fpF = (FrameLayout) findViewById(a.g.rl_beauty_progress);
        this.fpH = (TextView) findViewById(a.g.progress_tv);
        this.fpI = (TextView) findViewById(a.g.def_thumb_tv);
        this.fpG = (TopTipSeekBar) findViewById(a.g.value_seekbar);
        this.fpJ = findViewById(a.g.effect_diff_btn);
        this.fpx = (HListView) findViewById(a.g.beauty_list_view);
        this.fpB = (HListView) findViewById(a.g.feature_list_view);
        this.fpG.setMax(100);
        this.fpG.setTipView(this.fpH);
        this.fpG.setDefThumb(this.fpI);
        bwg();
        bwh();
        this.fpG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (TextUtils.equals(AlaLiveMultiBeautyArView.this.fqa.auO, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.fqa.bI(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.fqa.auR) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.fqa.auR)) && com.baidu.live.c.vf().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.c.vf().getBoolean("naturalFace", true)) {
                        com.baidu.live.c.vf().putBoolean("naturalFace", false);
                        if (AlaLiveMultiBeautyArView.this.fpC != null) {
                            AlaLiveMultiBeautyArView.this.fpC.notifyDataSetChanged();
                        }
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.fqa.y(AlaLiveMultiBeautyArView.this.fqa.auO, i - AlaLiveMultiBeautyArView.this.fpK);
                    if (AlaLiveMultiBeautyArView.this.fqb != null) {
                        AlaLiveMultiBeautyArView.this.fqb.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.eh(AlaLiveMultiBeautyArView.this.fqa.auO));
                    }
                }
                if (z) {
                    com.baidu.live.c.vf().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fpJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.fqb != null) {
                            AlaLiveMultiBeautyArView.this.fqb.vA();
                        }
                        AlaLiveMultiBeautyArView.this.setThinFace(0);
                        break;
                    case 1:
                    case 3:
                    case 4:
                        AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                        break;
                }
                return true;
            }
        });
        this.fpX = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fpX.setOnClickListener(this);
        this.fpV = (Button) findViewById(a.g.btn_choose_filter);
        this.fpV.setOnClickListener(this);
        this.fpW = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fpW.setOnClickListener(this);
        this.fpR = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fpS = (ImageView) findViewById(a.g.btn_choose_beauty_level_redot);
        this.fpT = (TextView) findViewById(a.g.thin_face_text_view);
        this.fpU = (ImageView) findViewById(a.g.thin_face_shrink);
        this.fpU.setOnClickListener(this);
        this.fpY = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.vx();
                if (AlaLiveMultiBeautyArView.this.fqb != null) {
                    AlaLiveMultiBeautyArView.this.fqb.vy();
                }
            }
        });
        this.fqd = (TextView) findViewById(a.g.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bwe();
            }
        }, 1000L);
        String string = com.baidu.live.c.vf().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwe() {
        if (com.baidu.live.c.vf().getInt("beauty_tab_redot", 0) != 1) {
            this.fpS.setVisibility(8);
        } else if ((com.baidu.live.c.vf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.c.vf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.c.vf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.c.vf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.fpy.bwn()) && this.fpX.getVisibility() == 0) {
            this.fpS.setVisibility(0);
        } else {
            this.fpS.setVisibility(8);
        }
    }

    private void bwf() {
        this.fpt = (HListView) findViewById(a.g.filter_list_view);
        if (this.fpt != null) {
            this.fpu = new a(this.fpt);
            this.fpu.ql(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fpt.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fpt.setAdapter((ListAdapter) this.fpu);
            this.fpt.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fpt.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fpv = i;
                AlaLiveMultiBeautyArView.this.fpw = i2;
            }
        });
        this.fpu.a(new a.InterfaceC0541a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0541a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fpw > 0) {
                            AlaLiveMultiBeautyArView.this.fpt.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fpv, AlaLiveMultiBeautyArView.this.fpw, iArr, AlaLiveMultiBeautyArView.this.fpu.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                f fVar = AlaLiveMultiBeautyArView.this.fpu.getDatas().get(i);
                if (!AlaLiveMultiBeautyArView.this.fqa.auM.equals(com.baidu.tieba.ala.alaar.sticker.a.e.BK(fVar.vr()))) {
                    AlaLiveMultiBeautyArView.this.BW(fVar.getName());
                }
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName())) {
                    com.baidu.live.ar.d dVar = AlaLiveMultiBeautyArView.this.fqa;
                    com.baidu.minivideo.arface.b.Ne();
                    dVar.auM = com.baidu.minivideo.arface.c.Nj();
                } else {
                    AlaLiveMultiBeautyArView.this.fqa.auM = com.baidu.tieba.ala.alaar.sticker.a.e.BK(fVar.vr());
                }
                AlaLiveMultiBeautyArView.this.fqa.auN = fVar;
                if (AlaLiveMultiBeautyArView.this.fqb != null && AlaLiveMultiBeautyArView.this.fpQ.vv() != null) {
                    int a = AlaLiveMultiBeautyArView.this.fqa.a(fVar, AlaLiveMultiBeautyArView.this.fpQ.vv().auy);
                    int ej = AlaLiveMultiBeautyArView.this.fqa.ej(AlaLiveMultiBeautyArView.this.fqa.auM);
                    float f = (((ej * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a + ", level:" + ej + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fqb.onFilterSelected(AlaLiveMultiBeautyArView.this.fqa.auN.getName(), AlaLiveMultiBeautyArView.this.fqa.auM, f);
                }
                AlaLiveMultiBeautyArView.this.qj(AlaLiveMultiBeautyArView.this.fqa.ej(AlaLiveMultiBeautyArView.this.fqa.auM));
            }
        });
    }

    private void bwg() {
        if (this.fpx != null) {
            this.fpy = new b(this.fpx);
            this.fpy.ql(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fpx.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fpx.setAdapter((ListAdapter) this.fpy);
            this.fpx.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fpx.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fpz = i;
                AlaLiveMultiBeautyArView.this.fpA = i2;
            }
        });
        this.fpy.a(new b.InterfaceC0542b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // com.baidu.tieba.ala.alaar.view.b.InterfaceC0542b
            public void b(int i, int[] iArr) {
                if (i == 0) {
                    AlaLiveMultiBeautyArView.this.bwj();
                    return;
                }
                String str = AlaLiveMultiBeautyArView.this.fpy.fqw[i].fqB;
                AlaLiveMultiBeautyArView.this.fpy.Cb(str);
                AlaLiveMultiBeautyArView.this.bwe();
                AlaLiveMultiBeautyArView.this.fpx.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fpz, AlaLiveMultiBeautyArView.this.fpA, iArr, AlaLiveMultiBeautyArView.this.fpy.getCount(), true), 300);
                AlaLiveMultiBeautyArView.this.fqa.auO = str;
                if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.setEffectFilterBeautyChooseBlock(AlaLiveMultiBeautyArView.this.fpB);
                    AlaLiveMultiBeautyArView.this.jW(true);
                    AlaLiveMultiBeautyArView.this.bwk();
                    return;
                }
                AlaLiveMultiBeautyArView.this.fpK = AlaLiveMultiBeautyArView.this.fpy.fqw[i].fqC;
                AlaLiveMultiBeautyArView.this.qi(AlaLiveMultiBeautyArView.this.fqa.el(AlaLiveMultiBeautyArView.this.fqa.auO) + AlaLiveMultiBeautyArView.this.fpK);
                AlaLiveMultiBeautyArView.this.fpG.setProcessDiff(AlaLiveMultiBeautyArView.this.fpy.fqw[i].fqC);
            }
        });
    }

    private void bwh() {
        if (this.fpB != null) {
            this.fpC = new c(this.fpB);
            this.fpC.ql(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fpB.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fpB.setAdapter((ListAdapter) this.fpC);
            this.fpB.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fpB.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fpD = i;
                AlaLiveMultiBeautyArView.this.fpE = i2;
            }
        });
        this.fpC.a(new c.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            @Override // com.baidu.tieba.ala.alaar.view.c.a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fpw > 0) {
                            AlaLiveMultiBeautyArView.this.fpB.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fpD, AlaLiveMultiBeautyArView.this.fpE, iArr, AlaLiveMultiBeautyArView.this.fpC.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                com.baidu.live.ar.e eVar = AlaLiveMultiBeautyArView.this.fpC.getDatas().get(i);
                AlaLiveMultiBeautyArView.this.fqa.auR = eVar.getType();
                AlaLiveMultiBeautyArView.this.fqa.auS = eVar.vt();
                AlaLiveMultiBeautyArView.this.fqa.auT = eVar.vs();
                String Cd = AlaLiveMultiBeautyArView.this.fpC.Cd(eVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.BL(eVar.vr())) {
                    Cd = com.baidu.tieba.ala.alaar.sticker.a.d.BO(com.baidu.tieba.ala.alaar.sticker.a.d.BK(eVar.vr()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, Cd));
                AlaLiveMultiBeautyArView.this.fpG.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.c(AlaLiveMultiBeautyArView.this.fqa.ek(eVar.getType()), false, Integer.valueOf(eVar.vs()).intValue());
                } catch (Exception e) {
                }
            }
        });
    }

    private void bwi() {
        this.ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        this.ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        this.ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vx() {
        if (this.fqa != null) {
            com.baidu.live.c.vf().putString("ala_beauty_config_ar", this.fqa.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
        this.fpQ = hVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aXY = bdPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(int i) {
        c(i, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fpG.setProgress(i, true);
        } else {
            this.fpG.setProgress(i);
        }
        if (z) {
            this.fpG.setDefThumbPos(com.baidu.live.ar.d.auX.el(this.fqa.auO) + this.fpK);
        } else {
            this.fpG.setDefThumbPos(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fpM.setProgress(i, true);
        } else {
            this.fpM.setProgress(i);
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
        int i7 = BdUtilHelper.getScreenSize(this.aXY.getPageActivity()).widthPixels;
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
    public void bwj() {
        if (this.fpP != null) {
            this.fpP.dismiss();
            this.fpP = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.fpP = new BdAlertDialog((Activity) getContext());
        this.fpP.setAutoNight(false);
        this.fpP.setMessage(string);
        this.fpP.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.vz();
                AlaLiveMultiBeautyArView.this.zA();
            }
        });
        this.fpP.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.zA();
            }
        });
        this.fpP.setCancelable(false);
        this.fpP.setCanceledOnTouchOutside(false);
        this.fpP.setTitleShowCenter(true);
        this.fpP.setMessageShowCenter(true);
        this.fpP.isShowTitleAndMessage();
        this.fpP.create(this.aXY);
        this.fpP.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vz() {
        if (this.fqb != null) {
            this.fqb.vz();
        }
        bwl();
        String str = this.fqa.auR;
        String str2 = this.fqa.auS;
        String str3 = this.fqa.auT;
        String str4 = com.baidu.live.ar.d.auY.auO;
        com.baidu.live.ar.d.auY.ei(com.baidu.live.ar.d.auX.toJsonString());
        com.baidu.live.ar.d.auY.auO = str4;
        com.baidu.live.ar.d.auY.auR = str;
        com.baidu.live.ar.d.auY.auS = str2;
        com.baidu.live.ar.d.auY.auT = str3;
        this.fqa = com.baidu.live.ar.d.auY;
        if (this.fpQ != null && this.fpQ.vv() != null && this.fpQ.vv().auz != null) {
            this.fqa.a(true, this.fpQ.vv().auz);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int ek = this.fqa.ek(str);
            this.fpG.setProcessDiff(0);
            c(ek, false, ek);
            return;
        }
        qi(this.fqa.el(this.fqa.auO) + this.fpK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA() {
        if (this.fpP != null) {
            this.fpP.dismiss();
            this.fpP = null;
        }
        this.fpP = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fpZ && this.fpV.getWidth() != 0) {
            h((View) this.fpV, false);
            this.fpZ = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fpV) {
            h((View) this.fpV, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fpV);
            if (this.fpt != null) {
                setEffectFilterBeautyChooseBlock(this.fpt);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
            this.fqc = 0;
            this.fpF.setVisibility(8);
            this.fpL.setVisibility(0);
        } else if (view == this.fpW) {
            h((View) this.fpW, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fpW);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fpX) {
            h((View) this.fpX, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fpX);
            setEffectFilterBeautyChooseBlock(this.fpx);
            this.fpF.setVisibility(0);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
            this.fqc = 1;
            this.fpF.setVisibility(0);
            this.fpL.setVisibility(8);
        } else if (view == this.fpU) {
            jW(false);
            if (this.fqc == 0) {
                setEffectFilterBeautyChooseBlock(this.fpt);
            } else {
                setEffectFilterBeautyChooseBlock(this.fpx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwk() {
        if (!TextUtils.isEmpty(this.fqa.auR)) {
            if (TextUtils.isEmpty(this.fqa.auT)) {
                qi(this.fqa.ek(this.fqa.auR));
                return;
            }
            try {
                this.fpG.setProcessDiff(0);
                c(this.fqa.ek(this.fqa.auR), false, Integer.valueOf(this.fqa.auT).intValue());
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jW(boolean z) {
        if (z) {
            this.fpX.setVisibility(8);
            this.fpV.setVisibility(8);
            this.fpT.setVisibility(0);
            this.fpU.setVisibility(0);
            this.fpS.setVisibility(8);
            return;
        }
        this.fpX.setVisibility(0);
        this.fpV.setVisibility(0);
        this.fpT.setVisibility(8);
        this.fpU.setVisibility(8);
        bwe();
        if (!this.fpy.bwn()) {
            this.fpy.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fpt != null) {
            this.fpt.setVisibility(4);
        }
        if (this.fpx != null) {
            this.fpx.setVisibility(4);
        }
        if (this.fpB != null) {
            this.fpB.setVisibility(4);
        }
        this.fpR.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fpV.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fpW.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fpX.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fqb = jVar;
    }

    private void h(View view, boolean z) {
        this.fpY.clearAnimation();
        int width = (this.fpY.getWidth() / 2) + this.fpY.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fpY.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fpY.getWidth() / 2);
        this.fpY.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fpY.startAnimation(translateAnimation);
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.d.auY.ei(com.baidu.live.c.vf().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.d.auY.auM) && com.baidu.minivideo.arface.b.Ne() != null) {
            com.baidu.live.ar.d dVar = com.baidu.live.ar.d.auY;
            com.baidu.minivideo.arface.b.Ne();
            dVar.auM = com.baidu.minivideo.arface.c.Nj();
        }
        if (TextUtils.isEmpty(g.avd)) {
            com.baidu.minivideo.arface.b.Ne();
            g.em(com.baidu.minivideo.arface.c.Nj());
        }
        this.fqa = com.baidu.live.ar.d.auY;
        setBeautyAdjustUserData2AR(false);
        if (!TextUtils.equals(this.fqa.auO, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            qi(this.fqa.el(this.fqa.auO) + this.fpK);
        }
        this.fpy.BY(this.fqa.auO);
        this.fpy.notifyDataSetChanged();
        if (this.fpQ != null && this.fpQ.vv() != null && this.fpQ.vv().auy != null) {
            this.fpu.setDatas(this.fpQ.vv().auy);
        }
        if (!TextUtils.isEmpty(this.fqa.auM)) {
            this.fpu.BX(this.fqa.auM);
        }
        this.fpu.notifyDataSetChanged();
        if (this.fpQ != null && this.fpQ.vv() != null && this.fpQ.vv().auz != null) {
            this.fqa.a(false, this.fpQ.vv().auz);
            this.fpC.e(this.fpQ.vv().auz, this.fpC.Cc(this.fqa.auR));
            this.fpC.notifyDataSetChanged();
            if (TextUtils.equals(this.fqa.auO, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.fqa.auT)) {
                        i = Integer.valueOf(this.fqa.auT).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                c(this.fqa.ek(this.fqa.auR), false, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautyAdjustUserData2AR(boolean z) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.fqb != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.fpy != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.fpy.fqw.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.fpy.fqw[i2].fqB)) {
                            i = this.fpy.fqw[i2].fqC;
                        }
                    }
                } else {
                    i = 0;
                }
                this.fqb.a(((this.fqa.el(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bwl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThinFace(int i) {
        if (this.fqb != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.fqa.auS);
            this.fqb.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bwl() {
        setThinFace(this.fqa.ek(this.fqa.auR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BW(String str) {
        this.fqd.setText(str);
        this.fqd.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fqd, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fqd, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fqd, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.fqd, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vw() {
        if (this.fpy != null) {
            this.fpy.notifyDataSetChanged();
        }
        if (this.fpu != null) {
            this.fpu.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
