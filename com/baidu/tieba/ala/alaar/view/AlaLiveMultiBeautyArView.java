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
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyArView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext aWZ;
    private int ds120;
    private int ds20;
    private int ds28;
    private int ds3;
    private TextView fkA;
    private View fkB;
    private int fkC;
    private FrameLayout fkD;
    private TopTipSeekBar fkE;
    private TextView fkF;
    private TextView fkG;
    private BdAlertDialog fkH;
    private h fkI;
    private LinearLayout fkJ;
    private ImageView fkK;
    private TextView fkL;
    private ImageView fkM;
    private Button fkN;
    private Button fkO;
    private Button fkP;
    private View fkQ;
    private boolean fkR;
    private com.baidu.live.ar.d fkS;
    private j fkT;
    private int fkU;
    private TextView fkV;
    private HListView fkl;
    private a fkm;
    private int fkn;
    private int fko;
    private HListView fkp;
    private b fkq;
    private int fkr;
    private int fks;
    private HListView fkt;
    private c fku;
    private int fkv;
    private int fkw;
    private FrameLayout fkx;
    private TopTipSeekBar fky;
    private TextView fkz;
    private TextView mTitle;

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.fkn = -1;
        this.fko = -1;
        this.fkr = -1;
        this.fks = -1;
        this.fkv = -1;
        this.fkw = -1;
        this.fkC = 0;
        this.fkR = true;
        this.fkS = com.baidu.live.ar.d.avc;
        this.fkU = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fkn = -1;
        this.fko = -1;
        this.fkr = -1;
        this.fks = -1;
        this.fkv = -1;
        this.fkw = -1;
        this.fkC = 0;
        this.fkR = true;
        this.fkS = com.baidu.live.ar.d.avc;
        this.fkU = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fkn = -1;
        this.fko = -1;
        this.fkr = -1;
        this.fks = -1;
        this.fkv = -1;
        this.fkw = -1;
        this.fkC = 0;
        this.fkR = true;
        this.fkS = com.baidu.live.ar.d.avc;
        this.fkU = 1;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bsY();
        bsV();
        this.fkD = (FrameLayout) findViewById(a.g.filter_rl_progress);
        this.fkF = (TextView) findViewById(a.g.filter_progress_tv);
        this.fkE = (TopTipSeekBar) findViewById(a.g.filter_value_seekbar);
        this.fkE.setMax(100);
        this.fkE.setTipView(this.fkF);
        this.fkG = (TextView) findViewById(a.g.filter_def_thumb_tv);
        this.fkE.setDefThumb(this.fkG);
        this.fkE.setDefThumbPos(100);
        this.fkE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.fkS.x(AlaLiveMultiBeautyArView.this.fkS.auQ, i);
                if (AlaLiveMultiBeautyArView.this.fkT != null) {
                    int a = AlaLiveMultiBeautyArView.this.fkS.a(AlaLiveMultiBeautyArView.this.fkS.auR, AlaLiveMultiBeautyArView.this.fkI.vv().auC);
                    float f = (((i * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fkT.onFilterSelected(AlaLiveMultiBeautyArView.this.fkS.auR.getName(), AlaLiveMultiBeautyArView.this.fkS.auQ, f);
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
        this.fkx = (FrameLayout) findViewById(a.g.rl_beauty_progress);
        this.fkz = (TextView) findViewById(a.g.progress_tv);
        this.fkA = (TextView) findViewById(a.g.def_thumb_tv);
        this.fky = (TopTipSeekBar) findViewById(a.g.value_seekbar);
        this.fkB = findViewById(a.g.effect_diff_btn);
        this.fkp = (HListView) findViewById(a.g.beauty_list_view);
        this.fkt = (HListView) findViewById(a.g.feature_list_view);
        this.fky.setMax(100);
        this.fky.setTipView(this.fkz);
        this.fky.setDefThumb(this.fkA);
        bsW();
        bsX();
        this.fky.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (TextUtils.equals(AlaLiveMultiBeautyArView.this.fkS.auS, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.fkS.bG(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.fkS.auV) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.fkS.auV)) && com.baidu.live.c.vf().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.c.vf().getBoolean("naturalFace", true)) {
                        com.baidu.live.c.vf().putBoolean("naturalFace", false);
                        if (AlaLiveMultiBeautyArView.this.fku != null) {
                            AlaLiveMultiBeautyArView.this.fku.notifyDataSetChanged();
                        }
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.fkS.y(AlaLiveMultiBeautyArView.this.fkS.auS, i - AlaLiveMultiBeautyArView.this.fkC);
                    if (AlaLiveMultiBeautyArView.this.fkT != null) {
                        AlaLiveMultiBeautyArView.this.fkT.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.ei(AlaLiveMultiBeautyArView.this.fkS.auS));
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
        this.fkB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.fkT != null) {
                            AlaLiveMultiBeautyArView.this.fkT.vA();
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
        this.fkP = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fkP.setOnClickListener(this);
        this.fkN = (Button) findViewById(a.g.btn_choose_filter);
        this.fkN.setOnClickListener(this);
        this.fkO = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fkO.setOnClickListener(this);
        this.fkJ = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fkK = (ImageView) findViewById(a.g.btn_choose_beauty_level_redot);
        this.fkL = (TextView) findViewById(a.g.thin_face_text_view);
        this.fkM = (ImageView) findViewById(a.g.thin_face_shrink);
        this.fkM.setOnClickListener(this);
        this.fkQ = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.vx();
                if (AlaLiveMultiBeautyArView.this.fkT != null) {
                    AlaLiveMultiBeautyArView.this.fkT.vy();
                }
            }
        });
        this.fkV = (TextView) findViewById(a.g.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bsU();
            }
        }, 1000L);
        String string = com.baidu.live.c.vf().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsU() {
        if (com.baidu.live.c.vf().getInt("beauty_tab_redot", 0) != 1) {
            this.fkK.setVisibility(8);
        } else if ((com.baidu.live.c.vf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.c.vf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.c.vf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.c.vf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.fkq.btd()) && this.fkP.getVisibility() == 0) {
            this.fkK.setVisibility(0);
        } else {
            this.fkK.setVisibility(8);
        }
    }

    private void bsV() {
        this.fkl = (HListView) findViewById(a.g.filter_list_view);
        if (this.fkl != null) {
            this.fkm = new a(this.fkl);
            this.fkm.pW(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fkl.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fkl.setAdapter((ListAdapter) this.fkm);
            this.fkl.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fkl.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fkn = i;
                AlaLiveMultiBeautyArView.this.fko = i2;
            }
        });
        this.fkm.a(new a.InterfaceC0530a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0530a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fko > 0) {
                            AlaLiveMultiBeautyArView.this.fkl.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fkn, AlaLiveMultiBeautyArView.this.fko, iArr, AlaLiveMultiBeautyArView.this.fkm.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                f fVar = AlaLiveMultiBeautyArView.this.fkm.getDatas().get(i);
                if (!AlaLiveMultiBeautyArView.this.fkS.auQ.equals(com.baidu.tieba.ala.alaar.sticker.a.e.AZ(fVar.vr()))) {
                    AlaLiveMultiBeautyArView.this.Bl(fVar.getName());
                }
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName())) {
                    com.baidu.live.ar.d dVar = AlaLiveMultiBeautyArView.this.fkS;
                    com.baidu.minivideo.arface.b.MZ();
                    dVar.auQ = com.baidu.minivideo.arface.c.Ne();
                } else {
                    AlaLiveMultiBeautyArView.this.fkS.auQ = com.baidu.tieba.ala.alaar.sticker.a.e.AZ(fVar.vr());
                }
                AlaLiveMultiBeautyArView.this.fkS.auR = fVar;
                if (AlaLiveMultiBeautyArView.this.fkT != null && AlaLiveMultiBeautyArView.this.fkI.vv() != null) {
                    int a = AlaLiveMultiBeautyArView.this.fkS.a(fVar, AlaLiveMultiBeautyArView.this.fkI.vv().auC);
                    int ek = AlaLiveMultiBeautyArView.this.fkS.ek(AlaLiveMultiBeautyArView.this.fkS.auQ);
                    float f = (((ek * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a + ", level:" + ek + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fkT.onFilterSelected(AlaLiveMultiBeautyArView.this.fkS.auR.getName(), AlaLiveMultiBeautyArView.this.fkS.auQ, f);
                }
                AlaLiveMultiBeautyArView.this.pU(AlaLiveMultiBeautyArView.this.fkS.ek(AlaLiveMultiBeautyArView.this.fkS.auQ));
            }
        });
    }

    private void bsW() {
        if (this.fkp != null) {
            this.fkq = new b(this.fkp);
            this.fkq.pW(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fkp.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fkp.setAdapter((ListAdapter) this.fkq);
            this.fkp.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fkp.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fkr = i;
                AlaLiveMultiBeautyArView.this.fks = i2;
            }
        });
        this.fkq.a(new b.InterfaceC0531b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // com.baidu.tieba.ala.alaar.view.b.InterfaceC0531b
            public void b(int i, int[] iArr) {
                if (i == 0) {
                    AlaLiveMultiBeautyArView.this.bsZ();
                    return;
                }
                String str = AlaLiveMultiBeautyArView.this.fkq.flo[i].flt;
                AlaLiveMultiBeautyArView.this.fkq.Bq(str);
                AlaLiveMultiBeautyArView.this.bsU();
                AlaLiveMultiBeautyArView.this.fkp.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fkr, AlaLiveMultiBeautyArView.this.fks, iArr, AlaLiveMultiBeautyArView.this.fkq.getCount(), true), 300);
                AlaLiveMultiBeautyArView.this.fkS.auS = str;
                if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.setEffectFilterBeautyChooseBlock(AlaLiveMultiBeautyArView.this.fkt);
                    AlaLiveMultiBeautyArView.this.js(true);
                    AlaLiveMultiBeautyArView.this.bta();
                    return;
                }
                AlaLiveMultiBeautyArView.this.fkC = AlaLiveMultiBeautyArView.this.fkq.flo[i].flu;
                AlaLiveMultiBeautyArView.this.pT(AlaLiveMultiBeautyArView.this.fkS.em(AlaLiveMultiBeautyArView.this.fkS.auS) + AlaLiveMultiBeautyArView.this.fkC);
                AlaLiveMultiBeautyArView.this.fky.setProcessDiff(AlaLiveMultiBeautyArView.this.fkq.flo[i].flu);
            }
        });
    }

    private void bsX() {
        if (this.fkt != null) {
            this.fku = new c(this.fkt);
            this.fku.pW(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fkt.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fkt.setAdapter((ListAdapter) this.fku);
            this.fkt.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fkt.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fkv = i;
                AlaLiveMultiBeautyArView.this.fkw = i2;
            }
        });
        this.fku.a(new c.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            @Override // com.baidu.tieba.ala.alaar.view.c.a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fko > 0) {
                            AlaLiveMultiBeautyArView.this.fkt.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fkv, AlaLiveMultiBeautyArView.this.fkw, iArr, AlaLiveMultiBeautyArView.this.fku.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                com.baidu.live.ar.e eVar = AlaLiveMultiBeautyArView.this.fku.getDatas().get(i);
                AlaLiveMultiBeautyArView.this.fkS.auV = eVar.getType();
                AlaLiveMultiBeautyArView.this.fkS.auW = eVar.vt();
                AlaLiveMultiBeautyArView.this.fkS.auX = eVar.vs();
                String Bs = AlaLiveMultiBeautyArView.this.fku.Bs(eVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.Ba(eVar.vr())) {
                    Bs = com.baidu.tieba.ala.alaar.sticker.a.d.Bd(com.baidu.tieba.ala.alaar.sticker.a.d.AZ(eVar.vr()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, Bs));
                AlaLiveMultiBeautyArView.this.fky.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.c(AlaLiveMultiBeautyArView.this.fkS.el(eVar.getType()), false, Integer.valueOf(eVar.vs()).intValue());
                } catch (Exception e) {
                }
            }
        });
    }

    private void bsY() {
        this.ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        this.ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        this.ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vx() {
        if (this.fkS != null) {
            com.baidu.live.c.vf().putString("ala_beauty_config_ar", this.fkS.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
        this.fkI = hVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aWZ = bdPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pT(int i) {
        c(i, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fky.setProgress(i, true);
        } else {
            this.fky.setProgress(i);
        }
        if (z) {
            this.fky.setDefThumbPos(com.baidu.live.ar.d.avb.em(this.fkS.auS) + this.fkC);
        } else {
            this.fky.setDefThumbPos(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pU(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fkE.setProgress(i, true);
        } else {
            this.fkE.setProgress(i);
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
        int i7 = BdUtilHelper.getScreenSize(this.aWZ.getPageActivity()).widthPixels;
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
    public void bsZ() {
        if (this.fkH != null) {
            this.fkH.dismiss();
            this.fkH = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.fkH = new BdAlertDialog((Activity) getContext());
        this.fkH.setAutoNight(false);
        this.fkH.setMessage(string);
        this.fkH.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.vz();
                AlaLiveMultiBeautyArView.this.yY();
            }
        });
        this.fkH.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.yY();
            }
        });
        this.fkH.setCancelable(false);
        this.fkH.setCanceledOnTouchOutside(false);
        this.fkH.setTitleShowCenter(true);
        this.fkH.setMessageShowCenter(true);
        this.fkH.isShowTitleAndMessage();
        this.fkH.create(this.aWZ);
        this.fkH.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vz() {
        if (this.fkT != null) {
            this.fkT.vz();
        }
        btb();
        String str = this.fkS.auV;
        String str2 = this.fkS.auW;
        String str3 = this.fkS.auX;
        String str4 = com.baidu.live.ar.d.avc.auS;
        com.baidu.live.ar.d.avc.ej(com.baidu.live.ar.d.avb.toJsonString());
        com.baidu.live.ar.d.avc.auS = str4;
        com.baidu.live.ar.d.avc.auV = str;
        com.baidu.live.ar.d.avc.auW = str2;
        com.baidu.live.ar.d.avc.auX = str3;
        this.fkS = com.baidu.live.ar.d.avc;
        if (this.fkI != null && this.fkI.vv() != null && this.fkI.vv().auD != null) {
            this.fkS.a(true, this.fkI.vv().auD);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int el = this.fkS.el(str);
            this.fky.setProcessDiff(0);
            c(el, false, el);
            return;
        }
        pT(this.fkS.em(this.fkS.auS) + this.fkC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY() {
        if (this.fkH != null) {
            this.fkH.dismiss();
            this.fkH = null;
        }
        this.fkH = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fkR && this.fkN.getWidth() != 0) {
            h((View) this.fkN, false);
            this.fkR = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fkN) {
            h((View) this.fkN, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fkN);
            if (this.fkl != null) {
                setEffectFilterBeautyChooseBlock(this.fkl);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
            this.fkU = 0;
            this.fkx.setVisibility(8);
            this.fkD.setVisibility(0);
        } else if (view == this.fkO) {
            h((View) this.fkO, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fkO);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fkP) {
            h((View) this.fkP, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fkP);
            setEffectFilterBeautyChooseBlock(this.fkp);
            this.fkx.setVisibility(0);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
            this.fkU = 1;
            this.fkx.setVisibility(0);
            this.fkD.setVisibility(8);
        } else if (view == this.fkM) {
            js(false);
            if (this.fkU == 0) {
                setEffectFilterBeautyChooseBlock(this.fkl);
            } else {
                setEffectFilterBeautyChooseBlock(this.fkp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bta() {
        if (!TextUtils.isEmpty(this.fkS.auV)) {
            if (TextUtils.isEmpty(this.fkS.auX)) {
                pT(this.fkS.el(this.fkS.auV));
                return;
            }
            try {
                this.fky.setProcessDiff(0);
                c(this.fkS.el(this.fkS.auV), false, Integer.valueOf(this.fkS.auX).intValue());
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(boolean z) {
        if (z) {
            this.fkP.setVisibility(8);
            this.fkN.setVisibility(8);
            this.fkL.setVisibility(0);
            this.fkM.setVisibility(0);
            this.fkK.setVisibility(8);
            return;
        }
        this.fkP.setVisibility(0);
        this.fkN.setVisibility(0);
        this.fkL.setVisibility(8);
        this.fkM.setVisibility(8);
        bsU();
        if (!this.fkq.btd()) {
            this.fkq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fkl != null) {
            this.fkl.setVisibility(4);
        }
        if (this.fkp != null) {
            this.fkp.setVisibility(4);
        }
        if (this.fkt != null) {
            this.fkt.setVisibility(4);
        }
        this.fkJ.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fkN.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fkO.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fkP.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fkT = jVar;
    }

    private void h(View view, boolean z) {
        this.fkQ.clearAnimation();
        int width = (this.fkQ.getWidth() / 2) + this.fkQ.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkQ.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fkQ.getWidth() / 2);
        this.fkQ.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fkQ.startAnimation(translateAnimation);
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.d.avc.ej(com.baidu.live.c.vf().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.d.avc.auQ) && com.baidu.minivideo.arface.b.MZ() != null) {
            com.baidu.live.ar.d dVar = com.baidu.live.ar.d.avc;
            com.baidu.minivideo.arface.b.MZ();
            dVar.auQ = com.baidu.minivideo.arface.c.Ne();
        }
        if (TextUtils.isEmpty(g.avh)) {
            com.baidu.minivideo.arface.b.MZ();
            g.en(com.baidu.minivideo.arface.c.Ne());
        }
        this.fkS = com.baidu.live.ar.d.avc;
        setBeautyAdjustUserData2AR(false);
        if (!TextUtils.equals(this.fkS.auS, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            pT(this.fkS.em(this.fkS.auS) + this.fkC);
        }
        this.fkq.Bn(this.fkS.auS);
        this.fkq.notifyDataSetChanged();
        if (this.fkI != null && this.fkI.vv() != null && this.fkI.vv().auC != null) {
            this.fkm.setDatas(this.fkI.vv().auC);
        }
        if (!TextUtils.isEmpty(this.fkS.auQ)) {
            this.fkm.Bm(this.fkS.auQ);
        }
        this.fkm.notifyDataSetChanged();
        if (this.fkI != null && this.fkI.vv() != null && this.fkI.vv().auD != null) {
            this.fkS.a(false, this.fkI.vv().auD);
            this.fku.e(this.fkI.vv().auD, this.fku.Br(this.fkS.auV));
            this.fku.notifyDataSetChanged();
            if (TextUtils.equals(this.fkS.auS, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.fkS.auX)) {
                        i = Integer.valueOf(this.fkS.auX).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                c(this.fkS.el(this.fkS.auV), false, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautyAdjustUserData2AR(boolean z) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.fkT != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.fkq != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.fkq.flo.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.fkq.flo[i2].flt)) {
                            i = this.fkq.flo[i2].flu;
                        }
                    }
                } else {
                    i = 0;
                }
                this.fkT.a(((this.fkS.em(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            btb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThinFace(int i) {
        if (this.fkT != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.fkS.auW);
            this.fkT.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void btb() {
        setThinFace(this.fkS.el(this.fkS.auV));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl(String str) {
        this.fkV.setText(str);
        this.fkV.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fkV, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fkV, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fkV, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.fkV, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vw() {
        if (this.fkq != null) {
            this.fkq.notifyDataSetChanged();
        }
        if (this.fkm != null) {
            this.fkm.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
