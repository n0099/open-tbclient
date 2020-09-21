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
    private BdPageContext bgf;
    private int ds120;
    private int ds20;
    private int ds28;
    private int ds3;
    private TextView fEA;
    private BdAlertDialog fEB;
    private h fEC;
    private LinearLayout fED;
    private ImageView fEE;
    private TextView fEF;
    private ImageView fEG;
    private Button fEH;
    private Button fEI;
    private Button fEJ;
    private View fEK;
    private boolean fEL;
    private com.baidu.live.ar.d fEM;
    private j fEN;
    private int fEO;
    private TextView fEP;
    private HListView fEf;
    private a fEg;
    private int fEh;
    private int fEi;
    private HListView fEj;
    private b fEk;
    private int fEl;
    private int fEm;
    private HListView fEn;
    private c fEo;
    private int fEp;
    private int fEq;
    private FrameLayout fEr;
    private TopTipSeekBar fEs;
    private TextView fEt;
    private TextView fEu;
    private View fEv;
    private int fEw;
    private FrameLayout fEx;
    private TopTipSeekBar fEy;
    private TextView fEz;
    private TextView mTitle;

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.fEh = -1;
        this.fEi = -1;
        this.fEl = -1;
        this.fEm = -1;
        this.fEp = -1;
        this.fEq = -1;
        this.fEw = 0;
        this.fEL = true;
        this.fEM = com.baidu.live.ar.d.aAI;
        this.fEO = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEh = -1;
        this.fEi = -1;
        this.fEl = -1;
        this.fEm = -1;
        this.fEp = -1;
        this.fEq = -1;
        this.fEw = 0;
        this.fEL = true;
        this.fEM = com.baidu.live.ar.d.aAI;
        this.fEO = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEh = -1;
        this.fEi = -1;
        this.fEl = -1;
        this.fEm = -1;
        this.fEp = -1;
        this.fEq = -1;
        this.fEw = 0;
        this.fEL = true;
        this.fEM = com.baidu.live.ar.d.aAI;
        this.fEO = 1;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bGy();
        bGv();
        this.fEx = (FrameLayout) findViewById(a.g.filter_rl_progress);
        this.fEz = (TextView) findViewById(a.g.filter_progress_tv);
        this.fEy = (TopTipSeekBar) findViewById(a.g.filter_value_seekbar);
        this.fEy.setMax(100);
        this.fEy.setTipView(this.fEz);
        this.fEA = (TextView) findViewById(a.g.filter_def_thumb_tv);
        this.fEy.setDefThumb(this.fEA);
        this.fEy.setDefThumbPos(100);
        this.fEy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.fEM.y(AlaLiveMultiBeautyArView.this.fEM.aAw, i);
                if (AlaLiveMultiBeautyArView.this.fEN != null) {
                    int a = AlaLiveMultiBeautyArView.this.fEM.a(AlaLiveMultiBeautyArView.this.fEM.aAx, AlaLiveMultiBeautyArView.this.fEC.Bi().aAi);
                    float f = (((i * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fEN.onFilterSelected(AlaLiveMultiBeautyArView.this.fEM.aAx.getName(), AlaLiveMultiBeautyArView.this.fEM.aAw, f);
                }
                if (z) {
                    com.baidu.live.c.AR().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fEr = (FrameLayout) findViewById(a.g.rl_beauty_progress);
        this.fEt = (TextView) findViewById(a.g.progress_tv);
        this.fEu = (TextView) findViewById(a.g.def_thumb_tv);
        this.fEs = (TopTipSeekBar) findViewById(a.g.value_seekbar);
        this.fEv = findViewById(a.g.effect_diff_btn);
        this.fEj = (HListView) findViewById(a.g.beauty_list_view);
        this.fEn = (HListView) findViewById(a.g.feature_list_view);
        this.fEs.setMax(100);
        this.fEs.setTipView(this.fEt);
        this.fEs.setDefThumb(this.fEu);
        bGw();
        bGx();
        this.fEs.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (TextUtils.equals(AlaLiveMultiBeautyArView.this.fEM.aAy, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.fEM.dy(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.fEM.aAB) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.fEM.aAB)) && com.baidu.live.c.AR().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.c.AR().getBoolean("naturalFace", true)) {
                        com.baidu.live.c.AR().putBoolean("naturalFace", false);
                        if (AlaLiveMultiBeautyArView.this.fEo != null) {
                            AlaLiveMultiBeautyArView.this.fEo.notifyDataSetChanged();
                        }
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.fEM.z(AlaLiveMultiBeautyArView.this.fEM.aAy, i - AlaLiveMultiBeautyArView.this.fEw);
                    if (AlaLiveMultiBeautyArView.this.fEN != null) {
                        AlaLiveMultiBeautyArView.this.fEN.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fC(AlaLiveMultiBeautyArView.this.fEM.aAy));
                    }
                }
                if (z) {
                    com.baidu.live.c.AR().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fEv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.fEN != null) {
                            AlaLiveMultiBeautyArView.this.fEN.Bn();
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
        this.fEJ = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fEJ.setOnClickListener(this);
        this.fEH = (Button) findViewById(a.g.btn_choose_filter);
        this.fEH.setOnClickListener(this);
        this.fEI = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fEI.setOnClickListener(this);
        this.fED = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fEE = (ImageView) findViewById(a.g.btn_choose_beauty_level_redot);
        this.fEF = (TextView) findViewById(a.g.thin_face_text_view);
        this.fEG = (ImageView) findViewById(a.g.thin_face_shrink);
        this.fEG.setOnClickListener(this);
        this.fEK = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.Bk();
                if (AlaLiveMultiBeautyArView.this.fEN != null) {
                    AlaLiveMultiBeautyArView.this.fEN.Bl();
                }
            }
        });
        this.fEP = (TextView) findViewById(a.g.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bGu();
            }
        }, 1000L);
        String string = com.baidu.live.c.AR().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGu() {
        if (com.baidu.live.c.AR().getInt("beauty_tab_redot", 0) != 1) {
            this.fEE.setVisibility(8);
        } else if ((com.baidu.live.c.AR().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.c.AR().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.c.AR().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.c.AR().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.fEk.bGD()) && this.fEJ.getVisibility() == 0) {
            this.fEE.setVisibility(0);
        } else {
            this.fEE.setVisibility(8);
        }
    }

    private void bGv() {
        this.fEf = (HListView) findViewById(a.g.filter_list_view);
        if (this.fEf != null) {
            this.fEg = new a(this.fEf);
            this.fEg.sP(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fEf.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fEf.setAdapter((ListAdapter) this.fEg);
            this.fEf.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fEf.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fEh = i;
                AlaLiveMultiBeautyArView.this.fEi = i2;
            }
        });
        this.fEg.a(new a.InterfaceC0583a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0583a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fEi > 0) {
                            AlaLiveMultiBeautyArView.this.fEf.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fEh, AlaLiveMultiBeautyArView.this.fEi, iArr, AlaLiveMultiBeautyArView.this.fEg.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                f fVar = AlaLiveMultiBeautyArView.this.fEg.getDatas().get(i);
                if (!AlaLiveMultiBeautyArView.this.fEM.aAw.equals(com.baidu.tieba.ala.alaar.sticker.a.e.EC(fVar.Be()))) {
                    AlaLiveMultiBeautyArView.this.EP(fVar.getName());
                }
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName())) {
                    com.baidu.live.ar.d dVar = AlaLiveMultiBeautyArView.this.fEM;
                    com.baidu.minivideo.arface.b.TP();
                    dVar.aAw = com.baidu.minivideo.arface.c.TU();
                } else {
                    AlaLiveMultiBeautyArView.this.fEM.aAw = com.baidu.tieba.ala.alaar.sticker.a.e.EC(fVar.Be());
                }
                AlaLiveMultiBeautyArView.this.fEM.aAx = fVar;
                if (AlaLiveMultiBeautyArView.this.fEN != null && AlaLiveMultiBeautyArView.this.fEC.Bi() != null) {
                    int a = AlaLiveMultiBeautyArView.this.fEM.a(fVar, AlaLiveMultiBeautyArView.this.fEC.Bi().aAi);
                    int fE = AlaLiveMultiBeautyArView.this.fEM.fE(AlaLiveMultiBeautyArView.this.fEM.aAw);
                    float f = (((fE * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a + ", level:" + fE + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fEN.onFilterSelected(AlaLiveMultiBeautyArView.this.fEM.aAx.getName(), AlaLiveMultiBeautyArView.this.fEM.aAw, f);
                }
                AlaLiveMultiBeautyArView.this.sN(AlaLiveMultiBeautyArView.this.fEM.fE(AlaLiveMultiBeautyArView.this.fEM.aAw));
            }
        });
    }

    private void bGw() {
        if (this.fEj != null) {
            this.fEk = new b(this.fEj);
            this.fEk.sP(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fEj.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fEj.setAdapter((ListAdapter) this.fEk);
            this.fEj.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fEj.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fEl = i;
                AlaLiveMultiBeautyArView.this.fEm = i2;
            }
        });
        this.fEk.a(new b.InterfaceC0584b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // com.baidu.tieba.ala.alaar.view.b.InterfaceC0584b
            public void b(int i, int[] iArr) {
                if (i == 0) {
                    AlaLiveMultiBeautyArView.this.bGz();
                    return;
                }
                String str = AlaLiveMultiBeautyArView.this.fEk.fFi[i].fFn;
                AlaLiveMultiBeautyArView.this.fEk.EU(str);
                AlaLiveMultiBeautyArView.this.bGu();
                AlaLiveMultiBeautyArView.this.fEj.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fEl, AlaLiveMultiBeautyArView.this.fEm, iArr, AlaLiveMultiBeautyArView.this.fEk.getCount(), true), 300);
                AlaLiveMultiBeautyArView.this.fEM.aAy = str;
                if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.setEffectFilterBeautyChooseBlock(AlaLiveMultiBeautyArView.this.fEn);
                    AlaLiveMultiBeautyArView.this.ky(true);
                    AlaLiveMultiBeautyArView.this.bGA();
                    return;
                }
                AlaLiveMultiBeautyArView.this.fEw = AlaLiveMultiBeautyArView.this.fEk.fFi[i].fFo;
                AlaLiveMultiBeautyArView.this.sM(AlaLiveMultiBeautyArView.this.fEM.fG(AlaLiveMultiBeautyArView.this.fEM.aAy) + AlaLiveMultiBeautyArView.this.fEw);
                AlaLiveMultiBeautyArView.this.fEs.setProcessDiff(AlaLiveMultiBeautyArView.this.fEk.fFi[i].fFo);
            }
        });
    }

    private void bGx() {
        if (this.fEn != null) {
            this.fEo = new c(this.fEn);
            this.fEo.sP(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fEn.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fEn.setAdapter((ListAdapter) this.fEo);
            this.fEn.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fEn.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fEp = i;
                AlaLiveMultiBeautyArView.this.fEq = i2;
            }
        });
        this.fEo.a(new c.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            @Override // com.baidu.tieba.ala.alaar.view.c.a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fEi > 0) {
                            AlaLiveMultiBeautyArView.this.fEn.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fEp, AlaLiveMultiBeautyArView.this.fEq, iArr, AlaLiveMultiBeautyArView.this.fEo.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                com.baidu.live.ar.e eVar = AlaLiveMultiBeautyArView.this.fEo.getDatas().get(i);
                AlaLiveMultiBeautyArView.this.fEM.aAB = eVar.getType();
                AlaLiveMultiBeautyArView.this.fEM.aAC = eVar.Bg();
                AlaLiveMultiBeautyArView.this.fEM.aAD = eVar.Bf();
                String EW = AlaLiveMultiBeautyArView.this.fEo.EW(eVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.ED(eVar.Be())) {
                    EW = com.baidu.tieba.ala.alaar.sticker.a.d.EG(com.baidu.tieba.ala.alaar.sticker.a.d.EC(eVar.Be()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, EW));
                AlaLiveMultiBeautyArView.this.fEs.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.fEM.fF(eVar.getType()), false, Integer.valueOf(eVar.Bf()).intValue());
                } catch (Exception e) {
                }
            }
        });
    }

    private void bGy() {
        this.ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        this.ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        this.ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void Bk() {
        if (this.fEM != null) {
            com.baidu.live.c.AR().putString("ala_beauty_config_ar", this.fEM.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
        this.fEC = hVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bgf = bdPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sM(int i) {
        a(i, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fEs.setProgress(i, true);
        } else {
            this.fEs.setProgress(i);
        }
        if (z) {
            this.fEs.setDefThumbPos(com.baidu.live.ar.d.aAH.fG(this.fEM.aAy) + this.fEw);
        } else {
            this.fEs.setDefThumbPos(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fEy.setProgress(i, true);
        } else {
            this.fEy.setProgress(i);
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
        int i7 = BdUtilHelper.getScreenSize(this.bgf.getPageActivity()).widthPixels;
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
    public void bGz() {
        if (this.fEB != null) {
            this.fEB.dismiss();
            this.fEB = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.fEB = new BdAlertDialog((Activity) getContext());
        this.fEB.setAutoNight(false);
        this.fEB.setMessage(string);
        this.fEB.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.Bm();
                AlaLiveMultiBeautyArView.this.FD();
            }
        });
        this.fEB.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.FD();
            }
        });
        this.fEB.setCancelable(false);
        this.fEB.setCanceledOnTouchOutside(false);
        this.fEB.setTitleShowCenter(true);
        this.fEB.setMessageShowCenter(true);
        this.fEB.isShowTitleAndMessage();
        this.fEB.create(this.bgf);
        this.fEB.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm() {
        if (this.fEN != null) {
            this.fEN.Bm();
        }
        bGB();
        String str = this.fEM.aAB;
        String str2 = this.fEM.aAC;
        String str3 = this.fEM.aAD;
        String str4 = com.baidu.live.ar.d.aAI.aAy;
        com.baidu.live.ar.d.aAI.fD(com.baidu.live.ar.d.aAH.toJsonString());
        com.baidu.live.ar.d.aAI.aAy = str4;
        com.baidu.live.ar.d.aAI.aAB = str;
        com.baidu.live.ar.d.aAI.aAC = str2;
        com.baidu.live.ar.d.aAI.aAD = str3;
        this.fEM = com.baidu.live.ar.d.aAI;
        if (this.fEC != null && this.fEC.Bi() != null && this.fEC.Bi().aAj != null) {
            this.fEM.a(true, this.fEC.Bi().aAj);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fF = this.fEM.fF(str);
            this.fEs.setProcessDiff(0);
            a(fF, false, fF);
            return;
        }
        sM(this.fEM.fG(this.fEM.aAy) + this.fEw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        if (this.fEB != null) {
            this.fEB.dismiss();
            this.fEB = null;
        }
        this.fEB = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fEL && this.fEH.getWidth() != 0) {
            g((View) this.fEH, false);
            this.fEL = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fEH) {
            g((View) this.fEH, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fEH);
            if (this.fEf != null) {
                setEffectFilterBeautyChooseBlock(this.fEf);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
            this.fEO = 0;
            this.fEr.setVisibility(8);
            this.fEx.setVisibility(0);
        } else if (view == this.fEI) {
            g((View) this.fEI, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fEI);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fEJ) {
            g((View) this.fEJ, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fEJ);
            setEffectFilterBeautyChooseBlock(this.fEj);
            this.fEr.setVisibility(0);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
            this.fEO = 1;
            this.fEr.setVisibility(0);
            this.fEx.setVisibility(8);
        } else if (view == this.fEG) {
            ky(false);
            if (this.fEO == 0) {
                setEffectFilterBeautyChooseBlock(this.fEf);
            } else {
                setEffectFilterBeautyChooseBlock(this.fEj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGA() {
        if (!TextUtils.isEmpty(this.fEM.aAB)) {
            if (TextUtils.isEmpty(this.fEM.aAD)) {
                sM(this.fEM.fF(this.fEM.aAB));
                return;
            }
            try {
                this.fEs.setProcessDiff(0);
                a(this.fEM.fF(this.fEM.aAB), false, Integer.valueOf(this.fEM.aAD).intValue());
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ky(boolean z) {
        if (z) {
            this.fEJ.setVisibility(8);
            this.fEH.setVisibility(8);
            this.fEF.setVisibility(0);
            this.fEG.setVisibility(0);
            this.fEE.setVisibility(8);
            return;
        }
        this.fEJ.setVisibility(0);
        this.fEH.setVisibility(0);
        this.fEF.setVisibility(8);
        this.fEG.setVisibility(8);
        bGu();
        if (!this.fEk.bGD()) {
            this.fEk.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fEf != null) {
            this.fEf.setVisibility(4);
        }
        if (this.fEj != null) {
            this.fEj.setVisibility(4);
        }
        if (this.fEn != null) {
            this.fEn.setVisibility(4);
        }
        this.fED.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fEH.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fEI.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fEJ.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fEN = jVar;
    }

    private void g(View view, boolean z) {
        this.fEK.clearAnimation();
        int width = (this.fEK.getWidth() / 2) + this.fEK.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fEK.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fEK.getWidth() / 2);
        this.fEK.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fEK.startAnimation(translateAnimation);
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.d.aAI.fD(com.baidu.live.c.AR().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.d.aAI.aAw) && com.baidu.minivideo.arface.b.TP() != null) {
            com.baidu.live.ar.d dVar = com.baidu.live.ar.d.aAI;
            com.baidu.minivideo.arface.b.TP();
            dVar.aAw = com.baidu.minivideo.arface.c.TU();
        }
        if (TextUtils.isEmpty(g.aAN)) {
            com.baidu.minivideo.arface.b.TP();
            g.fH(com.baidu.minivideo.arface.c.TU());
        }
        this.fEM = com.baidu.live.ar.d.aAI;
        setBeautyAdjustUserData2AR(false);
        if (!TextUtils.equals(this.fEM.aAy, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            sM(this.fEM.fG(this.fEM.aAy) + this.fEw);
        }
        this.fEk.ER(this.fEM.aAy);
        this.fEk.notifyDataSetChanged();
        if (this.fEC != null && this.fEC.Bi() != null && this.fEC.Bi().aAi != null) {
            this.fEg.setDatas(this.fEC.Bi().aAi);
        }
        if (!TextUtils.isEmpty(this.fEM.aAw)) {
            this.fEg.EQ(this.fEM.aAw);
        }
        this.fEg.notifyDataSetChanged();
        if (this.fEC != null && this.fEC.Bi() != null && this.fEC.Bi().aAj != null) {
            this.fEM.a(false, this.fEC.Bi().aAj);
            this.fEo.e(this.fEC.Bi().aAj, this.fEo.EV(this.fEM.aAB));
            this.fEo.notifyDataSetChanged();
            if (TextUtils.equals(this.fEM.aAy, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.fEM.aAD)) {
                        i = Integer.valueOf(this.fEM.aAD).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                a(this.fEM.fF(this.fEM.aAB), false, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautyAdjustUserData2AR(boolean z) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.fEN != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.fEk != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.fEk.fFi.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.fEk.fFi[i2].fFn)) {
                            i = this.fEk.fFi[i2].fFo;
                        }
                    }
                } else {
                    i = 0;
                }
                this.fEN.a(((this.fEM.fG(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bGB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThinFace(int i) {
        if (this.fEN != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.fEM.aAC);
            this.fEN.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bGB() {
        setThinFace(this.fEM.fF(this.fEM.aAB));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EP(String str) {
        this.fEP.setText(str);
        this.fEP.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fEP, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fEP, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fEP, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.fEP, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void Bj() {
        if (this.fEk != null) {
            this.fEk.notifyDataSetChanged();
        }
        if (this.fEg != null) {
            this.fEg.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
