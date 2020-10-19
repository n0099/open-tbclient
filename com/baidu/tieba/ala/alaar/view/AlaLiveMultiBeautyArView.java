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
    private BdPageContext bjV;
    private int ds120;
    private int ds20;
    private int ds28;
    private int ds3;
    private FrameLayout fQA;
    private TopTipSeekBar fQB;
    private TextView fQC;
    private TextView fQD;
    private View fQE;
    private int fQF;
    private FrameLayout fQG;
    private TopTipSeekBar fQH;
    private TextView fQI;
    private TextView fQJ;
    private BdAlertDialog fQK;
    private h fQL;
    private LinearLayout fQM;
    private ImageView fQN;
    private TextView fQO;
    private ImageView fQP;
    private Button fQQ;
    private Button fQR;
    private Button fQS;
    private View fQT;
    private boolean fQU;
    private com.baidu.live.ar.d fQV;
    private j fQW;
    private int fQX;
    private TextView fQY;
    private HListView fQo;
    private a fQp;
    private int fQq;
    private int fQr;
    private HListView fQs;
    private b fQt;
    private int fQu;
    private int fQv;
    private HListView fQw;
    private c fQx;
    private int fQy;
    private int fQz;
    private TextView mTitle;

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.fQq = -1;
        this.fQr = -1;
        this.fQu = -1;
        this.fQv = -1;
        this.fQy = -1;
        this.fQz = -1;
        this.fQF = 0;
        this.fQU = true;
        this.fQV = com.baidu.live.ar.d.aDN;
        this.fQX = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fQq = -1;
        this.fQr = -1;
        this.fQu = -1;
        this.fQv = -1;
        this.fQy = -1;
        this.fQz = -1;
        this.fQF = 0;
        this.fQU = true;
        this.fQV = com.baidu.live.ar.d.aDN;
        this.fQX = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fQq = -1;
        this.fQr = -1;
        this.fQu = -1;
        this.fQv = -1;
        this.fQy = -1;
        this.fQz = -1;
        this.fQF = 0;
        this.fQU = true;
        this.fQV = com.baidu.live.ar.d.aDN;
        this.fQX = 1;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bJk();
        bJh();
        this.fQG = (FrameLayout) findViewById(a.g.filter_rl_progress);
        this.fQI = (TextView) findViewById(a.g.filter_progress_tv);
        this.fQH = (TopTipSeekBar) findViewById(a.g.filter_value_seekbar);
        this.fQH.setMax(100);
        this.fQH.setTipView(this.fQI);
        this.fQJ = (TextView) findViewById(a.g.filter_def_thumb_tv);
        this.fQH.setDefThumb(this.fQJ);
        this.fQH.setDefThumbPos(100);
        this.fQH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.fQV.y(AlaLiveMultiBeautyArView.this.fQV.aDB, i);
                if (AlaLiveMultiBeautyArView.this.fQW != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.fQV.a(AlaLiveMultiBeautyArView.this.fQV.aDC, AlaLiveMultiBeautyArView.this.fQL.Cf().aDn);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fQW.onFilterSelected(AlaLiveMultiBeautyArView.this.fQV.aDC.getName(), AlaLiveMultiBeautyArView.this.fQV.aDB, f);
                }
                if (z) {
                    com.baidu.live.c.AZ().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fQA = (FrameLayout) findViewById(a.g.rl_beauty_progress);
        this.fQC = (TextView) findViewById(a.g.progress_tv);
        this.fQD = (TextView) findViewById(a.g.def_thumb_tv);
        this.fQB = (TopTipSeekBar) findViewById(a.g.value_seekbar);
        this.fQE = findViewById(a.g.effect_diff_btn);
        this.fQs = (HListView) findViewById(a.g.beauty_list_view);
        this.fQw = (HListView) findViewById(a.g.feature_list_view);
        this.fQB.setMax(100);
        this.fQB.setTipView(this.fQC);
        this.fQB.setDefThumb(this.fQD);
        bJi();
        bJj();
        this.fQB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (TextUtils.equals(AlaLiveMultiBeautyArView.this.fQV.aDD, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.fQV.dD(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.fQV.aDG) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.fQV.aDG)) && com.baidu.live.c.AZ().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.c.AZ().getBoolean("naturalFace", true)) {
                        com.baidu.live.c.AZ().putBoolean("naturalFace", false);
                        if (AlaLiveMultiBeautyArView.this.fQx != null) {
                            AlaLiveMultiBeautyArView.this.fQx.notifyDataSetChanged();
                        }
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.fQV.z(AlaLiveMultiBeautyArView.this.fQV.aDD, i - AlaLiveMultiBeautyArView.this.fQF);
                    if (AlaLiveMultiBeautyArView.this.fQW != null) {
                        AlaLiveMultiBeautyArView.this.fQW.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fQ(AlaLiveMultiBeautyArView.this.fQV.aDD));
                    }
                }
                if (z) {
                    com.baidu.live.c.AZ().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fQE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.fQW != null) {
                            AlaLiveMultiBeautyArView.this.fQW.Ck();
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
        this.fQS = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fQS.setOnClickListener(this);
        this.fQQ = (Button) findViewById(a.g.btn_choose_filter);
        this.fQQ.setOnClickListener(this);
        this.fQR = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fQR.setOnClickListener(this);
        this.fQM = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fQN = (ImageView) findViewById(a.g.btn_choose_beauty_level_redot);
        this.fQO = (TextView) findViewById(a.g.thin_face_text_view);
        this.fQP = (ImageView) findViewById(a.g.thin_face_shrink);
        this.fQP.setOnClickListener(this);
        this.fQT = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.Ch();
                if (AlaLiveMultiBeautyArView.this.fQW != null) {
                    AlaLiveMultiBeautyArView.this.fQW.Ci();
                }
            }
        });
        this.fQY = (TextView) findViewById(a.g.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bJg();
            }
        }, 1000L);
        String string = com.baidu.live.c.AZ().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJg() {
        if (com.baidu.live.c.AZ().getInt("beauty_tab_redot", 0) != 1) {
            this.fQN.setVisibility(8);
        } else if ((com.baidu.live.c.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.c.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.c.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.c.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.fQt.bJp()) && this.fQS.getVisibility() == 0) {
            this.fQN.setVisibility(0);
        } else {
            this.fQN.setVisibility(8);
        }
    }

    private void bJh() {
        this.fQo = (HListView) findViewById(a.g.filter_list_view);
        if (this.fQo != null) {
            this.fQp = new a(this.fQo);
            this.fQp.tn(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fQo.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fQo.setAdapter((ListAdapter) this.fQp);
            this.fQo.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fQo.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fQq = i;
                AlaLiveMultiBeautyArView.this.fQr = i2;
            }
        });
        this.fQp.a(new a.InterfaceC0600a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0600a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fQr > 0) {
                            AlaLiveMultiBeautyArView.this.fQo.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fQq, AlaLiveMultiBeautyArView.this.fQr, iArr, AlaLiveMultiBeautyArView.this.fQp.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                f fVar = AlaLiveMultiBeautyArView.this.fQp.getDatas().get(i);
                if (!AlaLiveMultiBeautyArView.this.fQV.aDB.equals(com.baidu.tieba.ala.alaar.sticker.a.e.Fn(fVar.Cb()))) {
                    AlaLiveMultiBeautyArView.this.FA(fVar.getName());
                }
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName())) {
                    com.baidu.live.ar.d dVar = AlaLiveMultiBeautyArView.this.fQV;
                    com.baidu.minivideo.arface.b.VI();
                    dVar.aDB = com.baidu.minivideo.arface.c.VN();
                } else {
                    AlaLiveMultiBeautyArView.this.fQV.aDB = com.baidu.tieba.ala.alaar.sticker.a.e.Fn(fVar.Cb());
                }
                AlaLiveMultiBeautyArView.this.fQV.aDC = fVar;
                if (AlaLiveMultiBeautyArView.this.fQW != null && AlaLiveMultiBeautyArView.this.fQL.Cf() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.fQV.a(fVar, AlaLiveMultiBeautyArView.this.fQL.Cf().aDn);
                    int fS = AlaLiveMultiBeautyArView.this.fQV.fS(AlaLiveMultiBeautyArView.this.fQV.aDB);
                    float f = (((fS * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + fS + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fQW.onFilterSelected(AlaLiveMultiBeautyArView.this.fQV.aDC.getName(), AlaLiveMultiBeautyArView.this.fQV.aDB, f);
                }
                AlaLiveMultiBeautyArView.this.tl(AlaLiveMultiBeautyArView.this.fQV.fS(AlaLiveMultiBeautyArView.this.fQV.aDB));
            }
        });
    }

    private void bJi() {
        if (this.fQs != null) {
            this.fQt = new b(this.fQs);
            this.fQt.tn(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fQs.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fQs.setAdapter((ListAdapter) this.fQt);
            this.fQs.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fQs.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fQu = i;
                AlaLiveMultiBeautyArView.this.fQv = i2;
            }
        });
        this.fQt.a(new b.InterfaceC0601b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // com.baidu.tieba.ala.alaar.view.b.InterfaceC0601b
            public void b(int i, int[] iArr) {
                if (i == 0) {
                    AlaLiveMultiBeautyArView.this.bJl();
                    return;
                }
                String str = AlaLiveMultiBeautyArView.this.fQt.fRr[i].fRw;
                AlaLiveMultiBeautyArView.this.fQt.FF(str);
                AlaLiveMultiBeautyArView.this.bJg();
                AlaLiveMultiBeautyArView.this.fQs.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fQu, AlaLiveMultiBeautyArView.this.fQv, iArr, AlaLiveMultiBeautyArView.this.fQt.getCount(), true), 300);
                AlaLiveMultiBeautyArView.this.fQV.aDD = str;
                if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.setEffectFilterBeautyChooseBlock(AlaLiveMultiBeautyArView.this.fQw);
                    AlaLiveMultiBeautyArView.this.kW(true);
                    AlaLiveMultiBeautyArView.this.bJm();
                    return;
                }
                AlaLiveMultiBeautyArView.this.fQF = AlaLiveMultiBeautyArView.this.fQt.fRr[i].fRx;
                AlaLiveMultiBeautyArView.this.tk(AlaLiveMultiBeautyArView.this.fQV.fU(AlaLiveMultiBeautyArView.this.fQV.aDD) + AlaLiveMultiBeautyArView.this.fQF);
                AlaLiveMultiBeautyArView.this.fQB.setProcessDiff(AlaLiveMultiBeautyArView.this.fQt.fRr[i].fRx);
            }
        });
    }

    private void bJj() {
        if (this.fQw != null) {
            this.fQx = new c(this.fQw);
            this.fQx.tn(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.fQw.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.fQw.setAdapter((ListAdapter) this.fQx);
            this.fQw.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fQw.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.fQy = i;
                AlaLiveMultiBeautyArView.this.fQz = i2;
            }
        });
        this.fQx.a(new c.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            @Override // com.baidu.tieba.ala.alaar.view.c.a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.fQr > 0) {
                            AlaLiveMultiBeautyArView.this.fQw.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.fQy, AlaLiveMultiBeautyArView.this.fQz, iArr, AlaLiveMultiBeautyArView.this.fQx.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                com.baidu.live.ar.e eVar = AlaLiveMultiBeautyArView.this.fQx.getDatas().get(i);
                AlaLiveMultiBeautyArView.this.fQV.aDG = eVar.getType();
                AlaLiveMultiBeautyArView.this.fQV.aDH = eVar.Cd();
                AlaLiveMultiBeautyArView.this.fQV.aDI = eVar.Cc();
                String FH = AlaLiveMultiBeautyArView.this.fQx.FH(eVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.Fo(eVar.Cb())) {
                    FH = com.baidu.tieba.ala.alaar.sticker.a.d.Fr(com.baidu.tieba.ala.alaar.sticker.a.d.Fn(eVar.Cb()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, FH));
                AlaLiveMultiBeautyArView.this.fQB.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.fQV.fT(eVar.getType()), false, Integer.valueOf(eVar.Cc()).intValue());
                } catch (Exception e) {
                }
            }
        });
    }

    private void bJk() {
        this.ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        this.ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        this.ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void Ch() {
        if (this.fQV != null) {
            com.baidu.live.c.AZ().putString("ala_beauty_config_ar", this.fQV.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
        this.fQL = hVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bjV = bdPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tk(int i) {
        a(i, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fQB.setProgress(i, true);
        } else {
            this.fQB.setProgress(i);
        }
        if (z) {
            this.fQB.setDefThumbPos(com.baidu.live.ar.d.aDM.fU(this.fQV.aDD) + this.fQF);
        } else {
            this.fQB.setDefThumbPos(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.fQH.setProgress(i, true);
        } else {
            this.fQH.setProgress(i);
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
        int i7 = BdUtilHelper.getScreenSize(this.bjV.getPageActivity()).widthPixels;
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
    public void bJl() {
        if (this.fQK != null) {
            this.fQK.dismiss();
            this.fQK = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.fQK = new BdAlertDialog((Activity) getContext());
        this.fQK.setAutoNight(false);
        this.fQK.setMessage(string);
        this.fQK.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.Cj();
                AlaLiveMultiBeautyArView.this.Gz();
            }
        });
        this.fQK.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.Gz();
            }
        });
        this.fQK.setCancelable(false);
        this.fQK.setCanceledOnTouchOutside(false);
        this.fQK.setTitleShowCenter(true);
        this.fQK.setMessageShowCenter(true);
        this.fQK.isShowTitleAndMessage();
        this.fQK.create(this.bjV);
        this.fQK.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj() {
        if (this.fQW != null) {
            this.fQW.Cj();
        }
        bJn();
        String str = this.fQV.aDG;
        String str2 = this.fQV.aDH;
        String str3 = this.fQV.aDI;
        String str4 = com.baidu.live.ar.d.aDN.aDD;
        com.baidu.live.ar.d.aDN.fR(com.baidu.live.ar.d.aDM.toJsonString());
        com.baidu.live.ar.d.aDN.aDD = str4;
        com.baidu.live.ar.d.aDN.aDG = str;
        com.baidu.live.ar.d.aDN.aDH = str2;
        com.baidu.live.ar.d.aDN.aDI = str3;
        this.fQV = com.baidu.live.ar.d.aDN;
        if (this.fQL != null && this.fQL.Cf() != null && this.fQL.Cf().aDo != null) {
            this.fQV.a(true, this.fQL.Cf().aDo);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fT = this.fQV.fT(str);
            this.fQB.setProcessDiff(0);
            a(fT, false, fT);
            return;
        }
        tk(this.fQV.fU(this.fQV.aDD) + this.fQF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gz() {
        if (this.fQK != null) {
            this.fQK.dismiss();
            this.fQK = null;
        }
        this.fQK = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fQU && this.fQQ.getWidth() != 0) {
            g((View) this.fQQ, false);
            this.fQU = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fQQ) {
            g((View) this.fQQ, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fQQ);
            if (this.fQo != null) {
                setEffectFilterBeautyChooseBlock(this.fQo);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
            this.fQX = 0;
            this.fQA.setVisibility(8);
            this.fQG.setVisibility(0);
        } else if (view == this.fQR) {
            g((View) this.fQR, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fQR);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fQS) {
            g((View) this.fQS, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fQS);
            setEffectFilterBeautyChooseBlock(this.fQs);
            this.fQA.setVisibility(0);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
            this.fQX = 1;
            this.fQA.setVisibility(0);
            this.fQG.setVisibility(8);
        } else if (view == this.fQP) {
            kW(false);
            if (this.fQX == 0) {
                setEffectFilterBeautyChooseBlock(this.fQo);
            } else {
                setEffectFilterBeautyChooseBlock(this.fQs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJm() {
        if (!TextUtils.isEmpty(this.fQV.aDG)) {
            if (TextUtils.isEmpty(this.fQV.aDI)) {
                tk(this.fQV.fT(this.fQV.aDG));
                return;
            }
            try {
                this.fQB.setProcessDiff(0);
                a(this.fQV.fT(this.fQV.aDG), false, Integer.valueOf(this.fQV.aDI).intValue());
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(boolean z) {
        if (z) {
            this.fQS.setVisibility(8);
            this.fQQ.setVisibility(8);
            this.fQO.setVisibility(0);
            this.fQP.setVisibility(0);
            this.fQN.setVisibility(8);
            return;
        }
        this.fQS.setVisibility(0);
        this.fQQ.setVisibility(0);
        this.fQO.setVisibility(8);
        this.fQP.setVisibility(8);
        bJg();
        if (!this.fQt.bJp()) {
            this.fQt.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fQo != null) {
            this.fQo.setVisibility(4);
        }
        if (this.fQs != null) {
            this.fQs.setVisibility(4);
        }
        if (this.fQw != null) {
            this.fQw.setVisibility(4);
        }
        this.fQM.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fQQ.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fQR.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fQS.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fQW = jVar;
    }

    private void g(View view, boolean z) {
        this.fQT.clearAnimation();
        int width = (this.fQT.getWidth() / 2) + this.fQT.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fQT.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fQT.getWidth() / 2);
        this.fQT.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fQT.startAnimation(translateAnimation);
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.d.aDN.fR(com.baidu.live.c.AZ().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.d.aDN.aDB) && com.baidu.minivideo.arface.b.VI() != null) {
            com.baidu.live.ar.d dVar = com.baidu.live.ar.d.aDN;
            com.baidu.minivideo.arface.b.VI();
            dVar.aDB = com.baidu.minivideo.arface.c.VN();
        }
        if (TextUtils.isEmpty(g.aDS)) {
            com.baidu.minivideo.arface.b.VI();
            g.fV(com.baidu.minivideo.arface.c.VN());
        }
        this.fQV = com.baidu.live.ar.d.aDN;
        setBeautyAdjustUserData2AR(false);
        if (!TextUtils.equals(this.fQV.aDD, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            tk(this.fQV.fU(this.fQV.aDD) + this.fQF);
        }
        this.fQt.FC(this.fQV.aDD);
        this.fQt.notifyDataSetChanged();
        if (this.fQL != null && this.fQL.Cf() != null && this.fQL.Cf().aDn != null) {
            this.fQp.setDatas(this.fQL.Cf().aDn);
        }
        if (!TextUtils.isEmpty(this.fQV.aDB)) {
            this.fQp.FB(this.fQV.aDB);
        }
        this.fQp.notifyDataSetChanged();
        if (this.fQL != null && this.fQL.Cf() != null && this.fQL.Cf().aDo != null) {
            this.fQV.a(false, this.fQL.Cf().aDo);
            this.fQx.e(this.fQL.Cf().aDo, this.fQx.FG(this.fQV.aDG));
            this.fQx.notifyDataSetChanged();
            if (TextUtils.equals(this.fQV.aDD, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.fQV.aDI)) {
                        i = Integer.valueOf(this.fQV.aDI).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                a(this.fQV.fT(this.fQV.aDG), false, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautyAdjustUserData2AR(boolean z) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.fQW != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.fQt != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.fQt.fRr.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.fQt.fRr[i2].fRw)) {
                            i = this.fQt.fRr[i2].fRx;
                        }
                    }
                } else {
                    i = 0;
                }
                this.fQW.a(((this.fQV.fU(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bJn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThinFace(int i) {
        if (this.fQW != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.fQV.aDH);
            this.fQW.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bJn() {
        setThinFace(this.fQV.fT(this.fQV.aDG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA(String str) {
        this.fQY.setText(str);
        this.fQY.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fQY, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fQY, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fQY, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.fQY, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void Cg() {
        if (this.fQt != null) {
            this.fQt.notifyDataSetChanged();
        }
        if (this.fQp != null) {
            this.fQp.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
