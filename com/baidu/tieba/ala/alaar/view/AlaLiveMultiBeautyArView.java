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
    private BdPageContext bdo;
    private int ds120;
    private int ds20;
    private int ds28;
    private int ds3;
    private HListView fAP;
    private a fAQ;
    private int fAR;
    private int fAS;
    private HListView fAT;
    private b fAU;
    private int fAV;
    private int fAW;
    private HListView fAX;
    private c fAY;
    private int fAZ;
    private int fBa;
    private FrameLayout fBb;
    private TopTipSeekBar fBc;
    private TextView fBd;
    private TextView fBe;
    private View fBf;
    private int fBg;
    private FrameLayout fBh;
    private TopTipSeekBar fBi;
    private TextView fBj;
    private TextView fBk;
    private BdAlertDialog fBl;
    private h fBm;
    private LinearLayout fBn;
    private ImageView fBo;
    private TextView fBp;
    private ImageView fBq;
    private Button fBr;
    private Button fBs;
    private Button fBt;
    private View fBu;
    private boolean fBv;
    private com.baidu.live.ar.d fBw;
    private j fBx;
    private int fBy;
    private TextView fBz;
    private TextView mTitle;

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.fAR = -1;
        this.fAS = -1;
        this.fAV = -1;
        this.fAW = -1;
        this.fAZ = -1;
        this.fBa = -1;
        this.fBg = 0;
        this.fBv = true;
        this.fBw = com.baidu.live.ar.d.aAa;
        this.fBy = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAR = -1;
        this.fAS = -1;
        this.fAV = -1;
        this.fAW = -1;
        this.fAZ = -1;
        this.fBa = -1;
        this.fBg = 0;
        this.fBv = true;
        this.fBw = com.baidu.live.ar.d.aAa;
        this.fBy = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAR = -1;
        this.fAS = -1;
        this.fAV = -1;
        this.fAW = -1;
        this.fAZ = -1;
        this.fBa = -1;
        this.fBg = 0;
        this.fBv = true;
        this.fBw = com.baidu.live.ar.d.aAa;
        this.fBy = 1;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bFh();
        bFe();
        this.fBh = (FrameLayout) findViewById(a.g.filter_rl_progress);
        this.fBj = (TextView) findViewById(a.g.filter_progress_tv);
        this.fBi = (TopTipSeekBar) findViewById(a.g.filter_value_seekbar);
        this.fBi.setMax(100);
        this.fBi.setTipView(this.fBj);
        this.fBk = (TextView) findViewById(a.g.filter_def_thumb_tv);
        this.fBi.setDefThumb(this.fBk);
        this.fBi.setDefThumbPos(100);
        this.fBi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.fBw.y(AlaLiveMultiBeautyArView.this.fBw.azO, i);
                if (AlaLiveMultiBeautyArView.this.fBx != null) {
                    int a = AlaLiveMultiBeautyArView.this.fBw.a(AlaLiveMultiBeautyArView.this.fBw.azP, AlaLiveMultiBeautyArView.this.fBm.AT().azA);
                    float f = (((i * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fBx.onFilterSelected(AlaLiveMultiBeautyArView.this.fBw.azP.getName(), AlaLiveMultiBeautyArView.this.fBw.azO, f);
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
        this.fBb = (FrameLayout) findViewById(a.g.rl_beauty_progress);
        this.fBd = (TextView) findViewById(a.g.progress_tv);
        this.fBe = (TextView) findViewById(a.g.def_thumb_tv);
        this.fBc = (TopTipSeekBar) findViewById(a.g.value_seekbar);
        this.fBf = findViewById(a.g.effect_diff_btn);
        this.fAT = (HListView) findViewById(a.g.beauty_list_view);
        this.fAX = (HListView) findViewById(a.g.feature_list_view);
        this.fBc.setMax(100);
        this.fBc.setTipView(this.fBd);
        this.fBc.setDefThumb(this.fBe);
        bFf();
        bFg();
        this.fBc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (TextUtils.equals(AlaLiveMultiBeautyArView.this.fBw.azQ, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.fBw.du(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.fBw.azT) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.fBw.azT)) && com.baidu.live.c.AD().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.c.AD().getBoolean("naturalFace", true)) {
                        com.baidu.live.c.AD().putBoolean("naturalFace", false);
                        if (AlaLiveMultiBeautyArView.this.fAY != null) {
                            AlaLiveMultiBeautyArView.this.fAY.notifyDataSetChanged();
                        }
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.fBw.z(AlaLiveMultiBeautyArView.this.fBw.azQ, i - AlaLiveMultiBeautyArView.this.fBg);
                    if (AlaLiveMultiBeautyArView.this.fBx != null) {
                        AlaLiveMultiBeautyArView.this.fBx.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fz(AlaLiveMultiBeautyArView.this.fBw.azQ));
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
        this.fBf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.fBx != null) {
                            AlaLiveMultiBeautyArView.this.fBx.AY();
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
        this.fBt = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fBt.setOnClickListener(this);
        this.fBr = (Button) findViewById(a.g.btn_choose_filter);
        this.fBr.setOnClickListener(this);
        this.fBs = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fBs.setOnClickListener(this);
        this.fBn = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fBo = (ImageView) findViewById(a.g.btn_choose_beauty_level_redot);
        this.fBp = (TextView) findViewById(a.g.thin_face_text_view);
        this.fBq = (ImageView) findViewById(a.g.thin_face_shrink);
        this.fBq.setOnClickListener(this);
        this.fBu = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.AV();
                if (AlaLiveMultiBeautyArView.this.fBx != null) {
                    AlaLiveMultiBeautyArView.this.fBx.AW();
                }
            }
        });
        this.fBz = (TextView) findViewById(a.g.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bFd();
            }
        }, 1000L);
        String string = com.baidu.live.c.AD().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFd() {
        if (com.baidu.live.c.AD().getInt("beauty_tab_redot", 0) != 1) {
            this.fBo.setVisibility(8);
        } else if ((com.baidu.live.c.AD().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.c.AD().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.c.AD().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.c.AD().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.fAU.bFm()) && this.fBt.getVisibility() == 0) {
            this.fBo.setVisibility(0);
        } else {
            this.fBo.setVisibility(8);
        }
    }

    private void bFe() {
        this.fAP = (HListView) findViewById(a.g.filter_list_view);
        if (this.fAP != null) {
            this.fAQ = new a(this.fAP);
            this.fAQ.sx(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fAP.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fAP.setAdapter((ListAdapter) this.fAQ);
            this.fAP.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fAP.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fAR = i;
                AlaLiveMultiBeautyArView.this.fAS = i2;
            }
        });
        this.fAQ.a(new a.InterfaceC0587a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0587a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fAS > 0) {
                            AlaLiveMultiBeautyArView.this.fAP.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fAR, AlaLiveMultiBeautyArView.this.fAS, iArr, AlaLiveMultiBeautyArView.this.fAQ.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                f fVar = AlaLiveMultiBeautyArView.this.fAQ.getDatas().get(i);
                if (!AlaLiveMultiBeautyArView.this.fBw.azO.equals(com.baidu.tieba.ala.alaar.sticker.a.e.Ee(fVar.AP()))) {
                    AlaLiveMultiBeautyArView.this.Eq(fVar.getName());
                }
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName())) {
                    com.baidu.live.ar.d dVar = AlaLiveMultiBeautyArView.this.fBw;
                    com.baidu.minivideo.arface.b.SY();
                    dVar.azO = com.baidu.minivideo.arface.c.Td();
                } else {
                    AlaLiveMultiBeautyArView.this.fBw.azO = com.baidu.tieba.ala.alaar.sticker.a.e.Ee(fVar.AP());
                }
                AlaLiveMultiBeautyArView.this.fBw.azP = fVar;
                if (AlaLiveMultiBeautyArView.this.fBx != null && AlaLiveMultiBeautyArView.this.fBm.AT() != null) {
                    int a = AlaLiveMultiBeautyArView.this.fBw.a(fVar, AlaLiveMultiBeautyArView.this.fBm.AT().azA);
                    int fB = AlaLiveMultiBeautyArView.this.fBw.fB(AlaLiveMultiBeautyArView.this.fBw.azO);
                    float f = (((fB * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a + ", level:" + fB + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fBx.onFilterSelected(AlaLiveMultiBeautyArView.this.fBw.azP.getName(), AlaLiveMultiBeautyArView.this.fBw.azO, f);
                }
                AlaLiveMultiBeautyArView.this.sv(AlaLiveMultiBeautyArView.this.fBw.fB(AlaLiveMultiBeautyArView.this.fBw.azO));
            }
        });
    }

    private void bFf() {
        if (this.fAT != null) {
            this.fAU = new b(this.fAT);
            this.fAU.sx(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fAT.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fAT.setAdapter((ListAdapter) this.fAU);
            this.fAT.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fAT.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fAV = i;
                AlaLiveMultiBeautyArView.this.fAW = i2;
            }
        });
        this.fAU.a(new b.InterfaceC0588b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // com.baidu.tieba.ala.alaar.view.b.InterfaceC0588b
            public void b(int i, int[] iArr) {
                if (i == 0) {
                    AlaLiveMultiBeautyArView.this.bFi();
                    return;
                }
                String str = AlaLiveMultiBeautyArView.this.fAU.fBS[i].fBX;
                AlaLiveMultiBeautyArView.this.fAU.Ev(str);
                AlaLiveMultiBeautyArView.this.bFd();
                AlaLiveMultiBeautyArView.this.fAT.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fAV, AlaLiveMultiBeautyArView.this.fAW, iArr, AlaLiveMultiBeautyArView.this.fAU.getCount(), true), 300);
                AlaLiveMultiBeautyArView.this.fBw.azQ = str;
                if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.setEffectFilterBeautyChooseBlock(AlaLiveMultiBeautyArView.this.fAX);
                    AlaLiveMultiBeautyArView.this.ku(true);
                    AlaLiveMultiBeautyArView.this.bFj();
                    return;
                }
                AlaLiveMultiBeautyArView.this.fBg = AlaLiveMultiBeautyArView.this.fAU.fBS[i].fBY;
                AlaLiveMultiBeautyArView.this.su(AlaLiveMultiBeautyArView.this.fBw.fD(AlaLiveMultiBeautyArView.this.fBw.azQ) + AlaLiveMultiBeautyArView.this.fBg);
                AlaLiveMultiBeautyArView.this.fBc.setProcessDiff(AlaLiveMultiBeautyArView.this.fAU.fBS[i].fBY);
            }
        });
    }

    private void bFg() {
        if (this.fAX != null) {
            this.fAY = new c(this.fAX);
            this.fAY.sx(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fAX.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fAX.setAdapter((ListAdapter) this.fAY);
            this.fAX.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fAX.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fAZ = i;
                AlaLiveMultiBeautyArView.this.fBa = i2;
            }
        });
        this.fAY.a(new c.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            @Override // com.baidu.tieba.ala.alaar.view.c.a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fAS > 0) {
                            AlaLiveMultiBeautyArView.this.fAX.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fAZ, AlaLiveMultiBeautyArView.this.fBa, iArr, AlaLiveMultiBeautyArView.this.fAY.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                com.baidu.live.ar.e eVar = AlaLiveMultiBeautyArView.this.fAY.getDatas().get(i);
                AlaLiveMultiBeautyArView.this.fBw.azT = eVar.getType();
                AlaLiveMultiBeautyArView.this.fBw.azU = eVar.AR();
                AlaLiveMultiBeautyArView.this.fBw.azV = eVar.AQ();
                String Ex = AlaLiveMultiBeautyArView.this.fAY.Ex(eVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.Ef(eVar.AP())) {
                    Ex = com.baidu.tieba.ala.alaar.sticker.a.d.Ei(com.baidu.tieba.ala.alaar.sticker.a.d.Ee(eVar.AP()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, Ex));
                AlaLiveMultiBeautyArView.this.fBc.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.fBw.fC(eVar.getType()), false, Integer.valueOf(eVar.AQ()).intValue());
                } catch (Exception e) {
                }
            }
        });
    }

    private void bFh() {
        this.ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        this.ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        this.ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void AV() {
        if (this.fBw != null) {
            com.baidu.live.c.AD().putString("ala_beauty_config_ar", this.fBw.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
        this.fBm = hVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bdo = bdPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void su(int i) {
        a(i, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fBc.setProgress(i, true);
        } else {
            this.fBc.setProgress(i);
        }
        if (z) {
            this.fBc.setDefThumbPos(com.baidu.live.ar.d.azZ.fD(this.fBw.azQ) + this.fBg);
        } else {
            this.fBc.setDefThumbPos(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fBi.setProgress(i, true);
        } else {
            this.fBi.setProgress(i);
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
        int i7 = BdUtilHelper.getScreenSize(this.bdo.getPageActivity()).widthPixels;
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
    public void bFi() {
        if (this.fBl != null) {
            this.fBl.dismiss();
            this.fBl = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.fBl = new BdAlertDialog((Activity) getContext());
        this.fBl.setAutoNight(false);
        this.fBl.setMessage(string);
        this.fBl.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.AX();
                AlaLiveMultiBeautyArView.this.Fd();
            }
        });
        this.fBl.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.Fd();
            }
        });
        this.fBl.setCancelable(false);
        this.fBl.setCanceledOnTouchOutside(false);
        this.fBl.setTitleShowCenter(true);
        this.fBl.setMessageShowCenter(true);
        this.fBl.isShowTitleAndMessage();
        this.fBl.create(this.bdo);
        this.fBl.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AX() {
        if (this.fBx != null) {
            this.fBx.AX();
        }
        bFk();
        String str = this.fBw.azT;
        String str2 = this.fBw.azU;
        String str3 = this.fBw.azV;
        String str4 = com.baidu.live.ar.d.aAa.azQ;
        com.baidu.live.ar.d.aAa.fA(com.baidu.live.ar.d.azZ.toJsonString());
        com.baidu.live.ar.d.aAa.azQ = str4;
        com.baidu.live.ar.d.aAa.azT = str;
        com.baidu.live.ar.d.aAa.azU = str2;
        com.baidu.live.ar.d.aAa.azV = str3;
        this.fBw = com.baidu.live.ar.d.aAa;
        if (this.fBm != null && this.fBm.AT() != null && this.fBm.AT().azB != null) {
            this.fBw.a(true, this.fBm.AT().azB);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fC = this.fBw.fC(str);
            this.fBc.setProcessDiff(0);
            a(fC, false, fC);
            return;
        }
        su(this.fBw.fD(this.fBw.azQ) + this.fBg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.fBl != null) {
            this.fBl.dismiss();
            this.fBl = null;
        }
        this.fBl = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fBv && this.fBr.getWidth() != 0) {
            g((View) this.fBr, false);
            this.fBv = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fBr) {
            g((View) this.fBr, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBr);
            if (this.fAP != null) {
                setEffectFilterBeautyChooseBlock(this.fAP);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
            this.fBy = 0;
            this.fBb.setVisibility(8);
            this.fBh.setVisibility(0);
        } else if (view == this.fBs) {
            g((View) this.fBs, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBs);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fBt) {
            g((View) this.fBt, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBt);
            setEffectFilterBeautyChooseBlock(this.fAT);
            this.fBb.setVisibility(0);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
            this.fBy = 1;
            this.fBb.setVisibility(0);
            this.fBh.setVisibility(8);
        } else if (view == this.fBq) {
            ku(false);
            if (this.fBy == 0) {
                setEffectFilterBeautyChooseBlock(this.fAP);
            } else {
                setEffectFilterBeautyChooseBlock(this.fAT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFj() {
        if (!TextUtils.isEmpty(this.fBw.azT)) {
            if (TextUtils.isEmpty(this.fBw.azV)) {
                su(this.fBw.fC(this.fBw.azT));
                return;
            }
            try {
                this.fBc.setProcessDiff(0);
                a(this.fBw.fC(this.fBw.azT), false, Integer.valueOf(this.fBw.azV).intValue());
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ku(boolean z) {
        if (z) {
            this.fBt.setVisibility(8);
            this.fBr.setVisibility(8);
            this.fBp.setVisibility(0);
            this.fBq.setVisibility(0);
            this.fBo.setVisibility(8);
            return;
        }
        this.fBt.setVisibility(0);
        this.fBr.setVisibility(0);
        this.fBp.setVisibility(8);
        this.fBq.setVisibility(8);
        bFd();
        if (!this.fAU.bFm()) {
            this.fAU.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fAP != null) {
            this.fAP.setVisibility(4);
        }
        if (this.fAT != null) {
            this.fAT.setVisibility(4);
        }
        if (this.fAX != null) {
            this.fAX.setVisibility(4);
        }
        this.fBn.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fBr.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fBs.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fBt.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fBx = jVar;
    }

    private void g(View view, boolean z) {
        this.fBu.clearAnimation();
        int width = (this.fBu.getWidth() / 2) + this.fBu.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBu.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fBu.getWidth() / 2);
        this.fBu.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fBu.startAnimation(translateAnimation);
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.d.aAa.fA(com.baidu.live.c.AD().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.d.aAa.azO) && com.baidu.minivideo.arface.b.SY() != null) {
            com.baidu.live.ar.d dVar = com.baidu.live.ar.d.aAa;
            com.baidu.minivideo.arface.b.SY();
            dVar.azO = com.baidu.minivideo.arface.c.Td();
        }
        if (TextUtils.isEmpty(g.aAf)) {
            com.baidu.minivideo.arface.b.SY();
            g.fE(com.baidu.minivideo.arface.c.Td());
        }
        this.fBw = com.baidu.live.ar.d.aAa;
        setBeautyAdjustUserData2AR(false);
        if (!TextUtils.equals(this.fBw.azQ, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            su(this.fBw.fD(this.fBw.azQ) + this.fBg);
        }
        this.fAU.Es(this.fBw.azQ);
        this.fAU.notifyDataSetChanged();
        if (this.fBm != null && this.fBm.AT() != null && this.fBm.AT().azA != null) {
            this.fAQ.setDatas(this.fBm.AT().azA);
        }
        if (!TextUtils.isEmpty(this.fBw.azO)) {
            this.fAQ.Er(this.fBw.azO);
        }
        this.fAQ.notifyDataSetChanged();
        if (this.fBm != null && this.fBm.AT() != null && this.fBm.AT().azB != null) {
            this.fBw.a(false, this.fBm.AT().azB);
            this.fAY.e(this.fBm.AT().azB, this.fAY.Ew(this.fBw.azT));
            this.fAY.notifyDataSetChanged();
            if (TextUtils.equals(this.fBw.azQ, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.fBw.azV)) {
                        i = Integer.valueOf(this.fBw.azV).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                a(this.fBw.fC(this.fBw.azT), false, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautyAdjustUserData2AR(boolean z) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.fBx != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.fAU != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.fAU.fBS.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.fAU.fBS[i2].fBX)) {
                            i = this.fAU.fBS[i2].fBY;
                        }
                    }
                } else {
                    i = 0;
                }
                this.fBx.a(((this.fBw.fD(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bFk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThinFace(int i) {
        if (this.fBx != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.fBw.azU);
            this.fBx.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bFk() {
        setThinFace(this.fBw.fC(this.fBw.azT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq(String str) {
        this.fBz.setText(str);
        this.fBz.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fBz, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fBz, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fBz, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.fBz, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void AU() {
        if (this.fAU != null) {
            this.fAU.notifyDataSetChanged();
        }
        if (this.fAQ != null) {
            this.fAQ.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
