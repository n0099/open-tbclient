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
/* loaded from: classes7.dex */
public class AlaLiveMultiBeautyArView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext bdq;
    private int ds120;
    private int ds20;
    private int ds28;
    private int ds3;
    private HListView fAT;
    private a fAU;
    private int fAV;
    private int fAW;
    private HListView fAX;
    private b fAY;
    private int fAZ;
    private com.baidu.live.ar.d fBA;
    private j fBB;
    private int fBC;
    private TextView fBD;
    private int fBa;
    private HListView fBb;
    private c fBc;
    private int fBd;
    private int fBe;
    private FrameLayout fBf;
    private TopTipSeekBar fBg;
    private TextView fBh;
    private TextView fBi;
    private View fBj;
    private int fBk;
    private FrameLayout fBl;
    private TopTipSeekBar fBm;
    private TextView fBn;
    private TextView fBo;
    private BdAlertDialog fBp;
    private h fBq;
    private LinearLayout fBr;
    private ImageView fBs;
    private TextView fBt;
    private ImageView fBu;
    private Button fBv;
    private Button fBw;
    private Button fBx;
    private View fBy;
    private boolean fBz;
    private TextView mTitle;

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.fAV = -1;
        this.fAW = -1;
        this.fAZ = -1;
        this.fBa = -1;
        this.fBd = -1;
        this.fBe = -1;
        this.fBk = 0;
        this.fBz = true;
        this.fBA = com.baidu.live.ar.d.aAc;
        this.fBC = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAV = -1;
        this.fAW = -1;
        this.fAZ = -1;
        this.fBa = -1;
        this.fBd = -1;
        this.fBe = -1;
        this.fBk = 0;
        this.fBz = true;
        this.fBA = com.baidu.live.ar.d.aAc;
        this.fBC = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAV = -1;
        this.fAW = -1;
        this.fAZ = -1;
        this.fBa = -1;
        this.fBd = -1;
        this.fBe = -1;
        this.fBk = 0;
        this.fBz = true;
        this.fBA = com.baidu.live.ar.d.aAc;
        this.fBC = 1;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bFi();
        bFf();
        this.fBl = (FrameLayout) findViewById(a.g.filter_rl_progress);
        this.fBn = (TextView) findViewById(a.g.filter_progress_tv);
        this.fBm = (TopTipSeekBar) findViewById(a.g.filter_value_seekbar);
        this.fBm.setMax(100);
        this.fBm.setTipView(this.fBn);
        this.fBo = (TextView) findViewById(a.g.filter_def_thumb_tv);
        this.fBm.setDefThumb(this.fBo);
        this.fBm.setDefThumbPos(100);
        this.fBm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.fBA.y(AlaLiveMultiBeautyArView.this.fBA.azQ, i);
                if (AlaLiveMultiBeautyArView.this.fBB != null) {
                    int a = AlaLiveMultiBeautyArView.this.fBA.a(AlaLiveMultiBeautyArView.this.fBA.azR, AlaLiveMultiBeautyArView.this.fBq.AT().azC);
                    float f = (((i * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fBB.onFilterSelected(AlaLiveMultiBeautyArView.this.fBA.azR.getName(), AlaLiveMultiBeautyArView.this.fBA.azQ, f);
                }
                if (z) {
                    com.baidu.live.c.AD().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fBf = (FrameLayout) findViewById(a.g.rl_beauty_progress);
        this.fBh = (TextView) findViewById(a.g.progress_tv);
        this.fBi = (TextView) findViewById(a.g.def_thumb_tv);
        this.fBg = (TopTipSeekBar) findViewById(a.g.value_seekbar);
        this.fBj = findViewById(a.g.effect_diff_btn);
        this.fAX = (HListView) findViewById(a.g.beauty_list_view);
        this.fBb = (HListView) findViewById(a.g.feature_list_view);
        this.fBg.setMax(100);
        this.fBg.setTipView(this.fBh);
        this.fBg.setDefThumb(this.fBi);
        bFg();
        bFh();
        this.fBg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (TextUtils.equals(AlaLiveMultiBeautyArView.this.fBA.azS, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.fBA.du(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.fBA.azV) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.fBA.azV)) && com.baidu.live.c.AD().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.c.AD().getBoolean("naturalFace", true)) {
                        com.baidu.live.c.AD().putBoolean("naturalFace", false);
                        if (AlaLiveMultiBeautyArView.this.fBc != null) {
                            AlaLiveMultiBeautyArView.this.fBc.notifyDataSetChanged();
                        }
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.fBA.z(AlaLiveMultiBeautyArView.this.fBA.azS, i - AlaLiveMultiBeautyArView.this.fBk);
                    if (AlaLiveMultiBeautyArView.this.fBB != null) {
                        AlaLiveMultiBeautyArView.this.fBB.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fA(AlaLiveMultiBeautyArView.this.fBA.azS));
                    }
                }
                if (z) {
                    com.baidu.live.c.AD().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fBj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.fBB != null) {
                            AlaLiveMultiBeautyArView.this.fBB.AY();
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
        this.fBx = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fBx.setOnClickListener(this);
        this.fBv = (Button) findViewById(a.g.btn_choose_filter);
        this.fBv.setOnClickListener(this);
        this.fBw = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fBw.setOnClickListener(this);
        this.fBr = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fBs = (ImageView) findViewById(a.g.btn_choose_beauty_level_redot);
        this.fBt = (TextView) findViewById(a.g.thin_face_text_view);
        this.fBu = (ImageView) findViewById(a.g.thin_face_shrink);
        this.fBu.setOnClickListener(this);
        this.fBy = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.AV();
                if (AlaLiveMultiBeautyArView.this.fBB != null) {
                    AlaLiveMultiBeautyArView.this.fBB.AW();
                }
            }
        });
        this.fBD = (TextView) findViewById(a.g.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bFe();
            }
        }, 1000L);
        String string = com.baidu.live.c.AD().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFe() {
        if (com.baidu.live.c.AD().getInt("beauty_tab_redot", 0) != 1) {
            this.fBs.setVisibility(8);
        } else if ((com.baidu.live.c.AD().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.c.AD().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.c.AD().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.c.AD().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.fAY.bFn()) && this.fBx.getVisibility() == 0) {
            this.fBs.setVisibility(0);
        } else {
            this.fBs.setVisibility(8);
        }
    }

    private void bFf() {
        this.fAT = (HListView) findViewById(a.g.filter_list_view);
        if (this.fAT != null) {
            this.fAU = new a(this.fAT);
            this.fAU.sx(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fAT.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fAT.setAdapter((ListAdapter) this.fAU);
            this.fAT.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fAT.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fAV = i;
                AlaLiveMultiBeautyArView.this.fAW = i2;
            }
        });
        this.fAU.a(new a.InterfaceC0587a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0587a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fAW > 0) {
                            AlaLiveMultiBeautyArView.this.fAT.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fAV, AlaLiveMultiBeautyArView.this.fAW, iArr, AlaLiveMultiBeautyArView.this.fAU.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                f fVar = AlaLiveMultiBeautyArView.this.fAU.getDatas().get(i);
                if (!AlaLiveMultiBeautyArView.this.fBA.azQ.equals(com.baidu.tieba.ala.alaar.sticker.a.e.Ef(fVar.AP()))) {
                    AlaLiveMultiBeautyArView.this.Er(fVar.getName());
                }
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName())) {
                    com.baidu.live.ar.d dVar = AlaLiveMultiBeautyArView.this.fBA;
                    com.baidu.minivideo.arface.b.SY();
                    dVar.azQ = com.baidu.minivideo.arface.c.Td();
                } else {
                    AlaLiveMultiBeautyArView.this.fBA.azQ = com.baidu.tieba.ala.alaar.sticker.a.e.Ef(fVar.AP());
                }
                AlaLiveMultiBeautyArView.this.fBA.azR = fVar;
                if (AlaLiveMultiBeautyArView.this.fBB != null && AlaLiveMultiBeautyArView.this.fBq.AT() != null) {
                    int a = AlaLiveMultiBeautyArView.this.fBA.a(fVar, AlaLiveMultiBeautyArView.this.fBq.AT().azC);
                    int fC = AlaLiveMultiBeautyArView.this.fBA.fC(AlaLiveMultiBeautyArView.this.fBA.azQ);
                    float f = (((fC * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a + ", level:" + fC + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fBB.onFilterSelected(AlaLiveMultiBeautyArView.this.fBA.azR.getName(), AlaLiveMultiBeautyArView.this.fBA.azQ, f);
                }
                AlaLiveMultiBeautyArView.this.sv(AlaLiveMultiBeautyArView.this.fBA.fC(AlaLiveMultiBeautyArView.this.fBA.azQ));
            }
        });
    }

    private void bFg() {
        if (this.fAX != null) {
            this.fAY = new b(this.fAX);
            this.fAY.sx(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fAX.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fAX.setAdapter((ListAdapter) this.fAY);
            this.fAX.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fAX.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fAZ = i;
                AlaLiveMultiBeautyArView.this.fBa = i2;
            }
        });
        this.fAY.a(new b.InterfaceC0588b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // com.baidu.tieba.ala.alaar.view.b.InterfaceC0588b
            public void b(int i, int[] iArr) {
                if (i == 0) {
                    AlaLiveMultiBeautyArView.this.bFj();
                    return;
                }
                String str = AlaLiveMultiBeautyArView.this.fAY.fBW[i].fCb;
                AlaLiveMultiBeautyArView.this.fAY.Ew(str);
                AlaLiveMultiBeautyArView.this.bFe();
                AlaLiveMultiBeautyArView.this.fAX.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fAZ, AlaLiveMultiBeautyArView.this.fBa, iArr, AlaLiveMultiBeautyArView.this.fAY.getCount(), true), 300);
                AlaLiveMultiBeautyArView.this.fBA.azS = str;
                if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.setEffectFilterBeautyChooseBlock(AlaLiveMultiBeautyArView.this.fBb);
                    AlaLiveMultiBeautyArView.this.kw(true);
                    AlaLiveMultiBeautyArView.this.bFk();
                    return;
                }
                AlaLiveMultiBeautyArView.this.fBk = AlaLiveMultiBeautyArView.this.fAY.fBW[i].fCc;
                AlaLiveMultiBeautyArView.this.su(AlaLiveMultiBeautyArView.this.fBA.fE(AlaLiveMultiBeautyArView.this.fBA.azS) + AlaLiveMultiBeautyArView.this.fBk);
                AlaLiveMultiBeautyArView.this.fBg.setProcessDiff(AlaLiveMultiBeautyArView.this.fAY.fBW[i].fCc);
            }
        });
    }

    private void bFh() {
        if (this.fBb != null) {
            this.fBc = new c(this.fBb);
            this.fBc.sx(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fBb.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fBb.setAdapter((ListAdapter) this.fBc);
            this.fBb.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fBb.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fBd = i;
                AlaLiveMultiBeautyArView.this.fBe = i2;
            }
        });
        this.fBc.a(new c.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            @Override // com.baidu.tieba.ala.alaar.view.c.a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fAW > 0) {
                            AlaLiveMultiBeautyArView.this.fBb.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fBd, AlaLiveMultiBeautyArView.this.fBe, iArr, AlaLiveMultiBeautyArView.this.fBc.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                com.baidu.live.ar.e eVar = AlaLiveMultiBeautyArView.this.fBc.getDatas().get(i);
                AlaLiveMultiBeautyArView.this.fBA.azV = eVar.getType();
                AlaLiveMultiBeautyArView.this.fBA.azW = eVar.AR();
                AlaLiveMultiBeautyArView.this.fBA.azX = eVar.AQ();
                String Ey = AlaLiveMultiBeautyArView.this.fBc.Ey(eVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.Eg(eVar.AP())) {
                    Ey = com.baidu.tieba.ala.alaar.sticker.a.d.Ej(com.baidu.tieba.ala.alaar.sticker.a.d.Ef(eVar.AP()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, Ey));
                AlaLiveMultiBeautyArView.this.fBg.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.fBA.fD(eVar.getType()), false, Integer.valueOf(eVar.AQ()).intValue());
                } catch (Exception e) {
                }
            }
        });
    }

    private void bFi() {
        this.ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        this.ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        this.ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void AV() {
        if (this.fBA != null) {
            com.baidu.live.c.AD().putString("ala_beauty_config_ar", this.fBA.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
        this.fBq = hVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bdq = bdPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void su(int i) {
        a(i, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fBg.setProgress(i, true);
        } else {
            this.fBg.setProgress(i);
        }
        if (z) {
            this.fBg.setDefThumbPos(com.baidu.live.ar.d.aAb.fE(this.fBA.azS) + this.fBk);
        } else {
            this.fBg.setDefThumbPos(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fBm.setProgress(i, true);
        } else {
            this.fBm.setProgress(i);
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
        int i7 = BdUtilHelper.getScreenSize(this.bdq.getPageActivity()).widthPixels;
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
    public void bFj() {
        if (this.fBp != null) {
            this.fBp.dismiss();
            this.fBp = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.fBp = new BdAlertDialog((Activity) getContext());
        this.fBp.setAutoNight(false);
        this.fBp.setMessage(string);
        this.fBp.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.AX();
                AlaLiveMultiBeautyArView.this.Fd();
            }
        });
        this.fBp.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.Fd();
            }
        });
        this.fBp.setCancelable(false);
        this.fBp.setCanceledOnTouchOutside(false);
        this.fBp.setTitleShowCenter(true);
        this.fBp.setMessageShowCenter(true);
        this.fBp.isShowTitleAndMessage();
        this.fBp.create(this.bdq);
        this.fBp.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AX() {
        if (this.fBB != null) {
            this.fBB.AX();
        }
        bFl();
        String str = this.fBA.azV;
        String str2 = this.fBA.azW;
        String str3 = this.fBA.azX;
        String str4 = com.baidu.live.ar.d.aAc.azS;
        com.baidu.live.ar.d.aAc.fB(com.baidu.live.ar.d.aAb.toJsonString());
        com.baidu.live.ar.d.aAc.azS = str4;
        com.baidu.live.ar.d.aAc.azV = str;
        com.baidu.live.ar.d.aAc.azW = str2;
        com.baidu.live.ar.d.aAc.azX = str3;
        this.fBA = com.baidu.live.ar.d.aAc;
        if (this.fBq != null && this.fBq.AT() != null && this.fBq.AT().azD != null) {
            this.fBA.a(true, this.fBq.AT().azD);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fD = this.fBA.fD(str);
            this.fBg.setProcessDiff(0);
            a(fD, false, fD);
            return;
        }
        su(this.fBA.fE(this.fBA.azS) + this.fBk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.fBp != null) {
            this.fBp.dismiss();
            this.fBp = null;
        }
        this.fBp = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fBz && this.fBv.getWidth() != 0) {
            g((View) this.fBv, false);
            this.fBz = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fBv) {
            g((View) this.fBv, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBv);
            if (this.fAT != null) {
                setEffectFilterBeautyChooseBlock(this.fAT);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
            this.fBC = 0;
            this.fBf.setVisibility(8);
            this.fBl.setVisibility(0);
        } else if (view == this.fBw) {
            g((View) this.fBw, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBw);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fBx) {
            g((View) this.fBx, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBx);
            setEffectFilterBeautyChooseBlock(this.fAX);
            this.fBf.setVisibility(0);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
            this.fBC = 1;
            this.fBf.setVisibility(0);
            this.fBl.setVisibility(8);
        } else if (view == this.fBu) {
            kw(false);
            if (this.fBC == 0) {
                setEffectFilterBeautyChooseBlock(this.fAT);
            } else {
                setEffectFilterBeautyChooseBlock(this.fAX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFk() {
        if (!TextUtils.isEmpty(this.fBA.azV)) {
            if (TextUtils.isEmpty(this.fBA.azX)) {
                su(this.fBA.fD(this.fBA.azV));
                return;
            }
            try {
                this.fBg.setProcessDiff(0);
                a(this.fBA.fD(this.fBA.azV), false, Integer.valueOf(this.fBA.azX).intValue());
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw(boolean z) {
        if (z) {
            this.fBx.setVisibility(8);
            this.fBv.setVisibility(8);
            this.fBt.setVisibility(0);
            this.fBu.setVisibility(0);
            this.fBs.setVisibility(8);
            return;
        }
        this.fBx.setVisibility(0);
        this.fBv.setVisibility(0);
        this.fBt.setVisibility(8);
        this.fBu.setVisibility(8);
        bFe();
        if (!this.fAY.bFn()) {
            this.fAY.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fAT != null) {
            this.fAT.setVisibility(4);
        }
        if (this.fAX != null) {
            this.fAX.setVisibility(4);
        }
        if (this.fBb != null) {
            this.fBb.setVisibility(4);
        }
        this.fBr.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fBv.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fBw.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fBx.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fBB = jVar;
    }

    private void g(View view, boolean z) {
        this.fBy.clearAnimation();
        int width = (this.fBy.getWidth() / 2) + this.fBy.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBy.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fBy.getWidth() / 2);
        this.fBy.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fBy.startAnimation(translateAnimation);
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.d.aAc.fB(com.baidu.live.c.AD().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.d.aAc.azQ) && com.baidu.minivideo.arface.b.SY() != null) {
            com.baidu.live.ar.d dVar = com.baidu.live.ar.d.aAc;
            com.baidu.minivideo.arface.b.SY();
            dVar.azQ = com.baidu.minivideo.arface.c.Td();
        }
        if (TextUtils.isEmpty(g.aAh)) {
            com.baidu.minivideo.arface.b.SY();
            g.fF(com.baidu.minivideo.arface.c.Td());
        }
        this.fBA = com.baidu.live.ar.d.aAc;
        setBeautyAdjustUserData2AR(false);
        if (!TextUtils.equals(this.fBA.azS, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            su(this.fBA.fE(this.fBA.azS) + this.fBk);
        }
        this.fAY.Et(this.fBA.azS);
        this.fAY.notifyDataSetChanged();
        if (this.fBq != null && this.fBq.AT() != null && this.fBq.AT().azC != null) {
            this.fAU.setDatas(this.fBq.AT().azC);
        }
        if (!TextUtils.isEmpty(this.fBA.azQ)) {
            this.fAU.Es(this.fBA.azQ);
        }
        this.fAU.notifyDataSetChanged();
        if (this.fBq != null && this.fBq.AT() != null && this.fBq.AT().azD != null) {
            this.fBA.a(false, this.fBq.AT().azD);
            this.fBc.e(this.fBq.AT().azD, this.fBc.Ex(this.fBA.azV));
            this.fBc.notifyDataSetChanged();
            if (TextUtils.equals(this.fBA.azS, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.fBA.azX)) {
                        i = Integer.valueOf(this.fBA.azX).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                a(this.fBA.fD(this.fBA.azV), false, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautyAdjustUserData2AR(boolean z) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.fBB != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.fAY != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.fAY.fBW.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.fAY.fBW[i2].fCb)) {
                            i = this.fAY.fBW[i2].fCc;
                        }
                    }
                } else {
                    i = 0;
                }
                this.fBB.a(((this.fBA.fE(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bFl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThinFace(int i) {
        if (this.fBB != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.fBA.azW);
            this.fBB.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bFl() {
        setThinFace(this.fBA.fD(this.fBA.azV));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Er(String str) {
        this.fBD.setText(str);
        this.fBD.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fBD, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fBD, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fBD, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.fBD, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void AU() {
        if (this.fAY != null) {
            this.fAY.notifyDataSetChanged();
        }
        if (this.fAU != null) {
            this.fAU.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
