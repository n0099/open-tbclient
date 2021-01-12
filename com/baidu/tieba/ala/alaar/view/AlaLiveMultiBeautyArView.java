package com.baidu.tieba.ala.alaar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.alaar.makeup.a;
import com.baidu.tieba.ala.alaar.sticker.a.h;
import com.baidu.tieba.ala.alaar.view.c;
import com.baidu.tieba.ala.alaar.view.j;
import com.baidu.tieba.ala.alaar.view.l;
import com.baidu.tieba.ala.alaar.view.p;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLiveMultiBeautyArView extends ILiveMultiBeautyView implements View.OnClickListener {
    private static int ds120;
    private static int ds20;
    private static int ds28;
    private static int ds3;
    private static int gtw;
    private x aBr;
    private com.baidu.live.ar.k bAO;
    private BdPageContext bnf;
    private final p gtg;
    private final n gth;
    private final m gti;
    int gtj;
    private c.a gtk;
    private final o gtl;
    private int gtm;
    private com.baidu.tieba.ala.alaar.makeup.a.c gtn;
    private final i gto;
    private k gtp;
    private BdAlertDialog gtq;
    private boolean gtr;
    private com.baidu.live.ar.e gts;
    private com.baidu.live.ar.m gtt;
    private com.baidu.tieba.ala.alaar.makeup.c gtu;
    private TextView gtv;

    static /* synthetic */ int b(AlaLiveMultiBeautyArView alaLiveMultiBeautyArView) {
        int i = alaLiveMultiBeautyArView.gtm;
        alaLiveMultiBeautyArView.gtm = i + 1;
        return i;
    }

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.gtg = new p();
        this.gth = new n();
        this.gti = new m();
        this.gtj = 0;
        this.gtl = new o();
        this.gto = new i();
        this.gtp = new k();
        this.gtr = true;
        this.gts = com.baidu.live.ar.e.aBa;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtg = new p();
        this.gth = new n();
        this.gti = new m();
        this.gtj = 0;
        this.gtl = new o();
        this.gto = new i();
        this.gtp = new k();
        this.gtr = true;
        this.gts = com.baidu.live.ar.e.aBa;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtg = new p();
        this.gth = new n();
        this.gti = new m();
        this.gtj = 0;
        this.gtl = new o();
        this.gto = new i();
        this.gtp = new k();
        this.gtr = true;
        this.gts = com.baidu.live.ar.e.aBa;
        initViews();
    }

    public void setFilterFileName(String str) {
        this.gts.aAM = str;
    }

    public String getFilterFileName() {
        if (TextUtils.isEmpty(this.gts.aAM) && this.gts.aAN != null) {
            this.gts.aAM = com.baidu.tieba.ala.alaar.sticker.a.e.Fc(this.gts.aAN.yQ());
        }
        return this.gts.aAM;
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_beauty_ar_hor_layout, this);
        bPT();
        this.gtm = 0;
        this.gtg.cn(this);
        this.gtg.a(new p.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.tieba.ala.alaar.view.p.a
            public void a(l lVar) {
                if (lVar != AlaLiveMultiBeautyArView.this.gtl) {
                    if (lVar == AlaLiveMultiBeautyArView.this.gth) {
                        AlaLiveMultiBeautyArView.this.gth.tz(AlaLiveMultiBeautyArView.this.gts.eK(AlaLiveMultiBeautyArView.this.getFilterFileName()));
                        return;
                    } else if (lVar == AlaLiveMultiBeautyArView.this.gti && AlaLiveMultiBeautyArView.this.gts != null) {
                        if (!TextUtils.equals(AlaLiveMultiBeautyArView.this.gts.aAO, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            AlaLiveMultiBeautyArView.this.to(AlaLiveMultiBeautyArView.this.gts.eM(AlaLiveMultiBeautyArView.this.gts.aAO) + AlaLiveMultiBeautyArView.this.gtj);
                            AlaLiveMultiBeautyArView.this.gti.gux.setProcessDiff(AlaLiveMultiBeautyArView.this.gtj);
                            return;
                        }
                        try {
                            AlaLiveMultiBeautyArView.this.c(AlaLiveMultiBeautyArView.this.gts.eL(AlaLiveMultiBeautyArView.this.gts.aAR), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gts.aAT).intValue());
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                AlaLiveMultiBeautyArView.b(AlaLiveMultiBeautyArView.this);
                if (AlaLiveMultiBeautyArView.this.gtn != null && !AlaLiveMultiBeautyArView.this.gtn.bOS()) {
                    AlaLiveMultiBeautyArView.this.gtn.mh(true);
                }
                if (AlaLiveMultiBeautyArView.this.gtm == 1 && AlaLiveMultiBeautyArView.this.gtl.guY != null) {
                    AlaLiveMultiBeautyArView.this.gtl.tx(AlaLiveMultiBeautyArView.this.gtl.guY.getCurrentPosition());
                }
                AlaLiveMultiBeautyArView.this.gtl.ml(false);
            }
        });
        this.gth.cn(this);
        this.gth.setTitle(getResources().getString(a.h.ala_live_new_beauty_filter));
        this.gtg.b(this.gth);
        this.gth.c(new com.baidu.tieba.ala.alaar.view.a(getContext()));
        this.gth.a(new l.a<com.baidu.live.ar.i>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.i iVar, boolean z) {
                String Fc;
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.h.beauty_yuantu).equals(iVar.getName())) {
                    com.baidu.minivideo.arface.b.ZU();
                    Fc = com.baidu.minivideo.arface.c.aab();
                } else {
                    Fc = com.baidu.tieba.ala.alaar.sticker.a.e.Fc(iVar.yQ());
                }
                if (!AlaLiveMultiBeautyArView.this.gts.aAM.equals(Fc)) {
                    AlaLiveMultiBeautyArView.this.Fq(iVar.getName());
                }
                AlaLiveMultiBeautyArView.this.setFilterFileName(Fc);
                AlaLiveMultiBeautyArView.this.gts.aAN = iVar;
                if (AlaLiveMultiBeautyArView.this.gtt != null && AlaLiveMultiBeautyArView.this.bAO.yU() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gts.a(iVar, AlaLiveMultiBeautyArView.this.bAO.yU().aAy);
                    int eK = AlaLiveMultiBeautyArView.this.gts.eK(AlaLiveMultiBeautyArView.this.getFilterFileName());
                    float f = (((eK * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + eK + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gtt.onFilterSelected(AlaLiveMultiBeautyArView.this.gts.aAN.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
                if (AlaLiveMultiBeautyArView.this.gtg.gvc == AlaLiveMultiBeautyArView.this.gth) {
                    AlaLiveMultiBeautyArView.this.gth.tz(AlaLiveMultiBeautyArView.this.gts.eK(AlaLiveMultiBeautyArView.this.getFilterFileName()));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.live.ar.i iVar, boolean z) {
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void a(com.baidu.live.ar.i iVar, SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.gts.A(AlaLiveMultiBeautyArView.this.getFilterFileName(), i);
                if (AlaLiveMultiBeautyArView.this.gtt != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gts.a(AlaLiveMultiBeautyArView.this.gts.aAN, AlaLiveMultiBeautyArView.this.bAO.yU().aAy);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gtt.onFilterSelected(AlaLiveMultiBeautyArView.this.gts.aAN.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gts.aAN != null) {
                    try {
                        jSONObject.put("filter_id", AlaLiveMultiBeautyArView.this.gts.aAN.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("filterbar_clk", jSONObject);
            }
        });
        this.gti.cn(this);
        this.gti.setTitle(getResources().getString(a.h.ala_live_new_beauty_beauty));
        this.gtg.b(this.gti);
        this.gti.a(new l.a<c.a>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, c.a aVar, boolean z) {
                if (AlaLiveMultiBeautyArView.this.gtg.gvc == AlaLiveMultiBeautyArView.this.gti) {
                    if (i == 0) {
                        AlaLiveMultiBeautyArView.this.bPU();
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gts.aAO = aVar.gtW;
                    AlaLiveMultiBeautyArView.this.gti.guJ.Fu(aVar.gtW);
                    AlaLiveMultiBeautyArView.this.bPS();
                    if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gts.aAO, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (AlaLiveMultiBeautyArView.this.gtg.gvc == AlaLiveMultiBeautyArView.this.gti && z) {
                            AlaLiveMultiBeautyArView.this.a(aVar);
                            return;
                        }
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gtk = aVar;
                    if (aVar != null) {
                        AlaLiveMultiBeautyArView.this.gtj = aVar.gtX;
                    }
                    AlaLiveMultiBeautyArView.this.to(AlaLiveMultiBeautyArView.this.gts.eM(AlaLiveMultiBeautyArView.this.gts.aAO) + AlaLiveMultiBeautyArView.this.gtj);
                    AlaLiveMultiBeautyArView.this.gti.gux.setProcessDiff(AlaLiveMultiBeautyArView.this.gtj);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, c.a aVar, boolean z) {
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void a(c.a aVar, SeekBar seekBar, int i, boolean z) {
                if (AlaLiveMultiBeautyArView.this.gtg.gvc == AlaLiveMultiBeautyArView.this.gtl) {
                    if (z && AlaLiveMultiBeautyArView.this.gtu != null) {
                        AlaLiveMultiBeautyArView.this.gtu.setValue(i);
                        if (AlaLiveMultiBeautyArView.this.gts.aAV != null) {
                            AlaLiveMultiBeautyArView.this.gts.aAV.setValue(AlaLiveMultiBeautyArView.this.gtu.bOw());
                            AlaLiveMultiBeautyArView.this.gtt.a(AlaLiveMultiBeautyArView.this.gts.aAV);
                        }
                    }
                } else if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gts.aAO, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.gts.cj(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.gts.aAR) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.gts.aAR)) && com.baidu.live.d.xf().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.d.xf().getBoolean("naturalFace", true)) {
                        com.baidu.live.d.xf().putBoolean("naturalFace", false);
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.gts.B(AlaLiveMultiBeautyArView.this.gts.aAO, i - AlaLiveMultiBeautyArView.this.gtj);
                    if (AlaLiveMultiBeautyArView.this.gtt != null) {
                        AlaLiveMultiBeautyArView.this.gtt.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.eJ(AlaLiveMultiBeautyArView.this.gts.aAO));
                    }
                }
                if (z) {
                    com.baidu.live.d.xf().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (AlaLiveMultiBeautyArView.this.gtg.gvc != AlaLiveMultiBeautyArView.this.gtl) {
                    if (AlaLiveMultiBeautyArView.this.gts.aAO != null) {
                        String str = null;
                        if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gts.aAO, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            if (AlaLiveMultiBeautyArView.this.gts.aAU != null) {
                                str = AlaLiveMultiBeautyArView.this.gts.aAU.getName();
                            }
                        } else {
                            str = AlaLiveMultiBeautyArView.this.gtk.gtV;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (AlaLiveMultiBeautyArView.this.gtk != null && str != null) {
                            try {
                                jSONObject.put("beauty_name", str);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        AlaLiveMultiBeautyArView.this.r("beautybar_clk", jSONObject);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gtu != null) {
                    try {
                        jSONObject2.put("makeup_id", AlaLiveMultiBeautyArView.this.gtu.getId());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("makeupbar_clk", jSONObject2);
            }
        });
        this.gti.guO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.gtg.gvc == AlaLiveMultiBeautyArView.this.gtl) {
                            AlaLiveMultiBeautyArView.this.bPX();
                            break;
                        } else {
                            if (AlaLiveMultiBeautyArView.this.gtt != null) {
                                AlaLiveMultiBeautyArView.this.gtt.yY();
                            }
                            AlaLiveMultiBeautyArView.this.setThinFace(0);
                            break;
                        }
                    case 1:
                    case 3:
                    case 4:
                        if (AlaLiveMultiBeautyArView.this.gtg.gvc == AlaLiveMultiBeautyArView.this.gtl) {
                            AlaLiveMultiBeautyArView.this.bPW();
                            break;
                        } else {
                            AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                            break;
                        }
                }
                return true;
            }
        });
        this.gtl.cn(this);
        this.gtl.ty(0);
        this.gtl.setTitle(getResources().getString(a.h.ala_live_new_beauty_makeup));
        this.gtg.b(this.gtl);
        this.gtl.a(new l.a<com.baidu.tieba.ala.alaar.makeup.d>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemSelected pos= " + i + ", name=" + dVar.bOq());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bOE = dVar.bOE();
                if (dVar.ayW() || bOE == null || bOE.isEmpty()) {
                    AlaLiveMultiBeautyArView.this.b(i, dVar, null);
                } else if (AlaLiveMultiBeautyArView.this.gtg.gvc == AlaLiveMultiBeautyArView.this.gtl) {
                    AlaLiveMultiBeautyArView.this.a(dVar);
                }
                if (AlaLiveMultiBeautyArView.this.gtn != null) {
                    AlaLiveMultiBeautyArView.this.gtn.setPosition(i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemClick pos= " + i + ", name=" + dVar.bOq());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bOE = dVar.bOE();
                if (dVar.ayW() || bOE == null || bOE.isEmpty()) {
                    return AlaLiveMultiBeautyArView.this.a(i, dVar, (com.baidu.tieba.ala.alaar.makeup.d) null);
                }
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void a(com.baidu.tieba.ala.alaar.makeup.d dVar, SeekBar seekBar, int i, boolean z) {
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
        });
        if (this.gtn != null) {
            this.gtl.setPosition(this.gtn.getPosition());
        }
        com.baidu.tieba.ala.alaar.makeup.g.bOI().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.tieba.ala.alaar.makeup.a.b
            public void c(com.baidu.tieba.ala.alaar.makeup.a aVar) {
                com.baidu.tieba.ala.alaar.makeup.a.c bOK = com.baidu.tieba.ala.alaar.makeup.g.bOI().bOK();
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("BeautyAr", "makeupdata onDataLoaded size: " + (AlaLiveMultiBeautyArView.this.gtn == null ? "null" : Integer.valueOf(AlaLiveMultiBeautyArView.this.gtn.size())));
                }
                AlaLiveMultiBeautyArView.this.setMakeupData(bOK);
            }
        });
        this.gtp.cn(this);
        this.gtp.a(new j.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.j.a
            public void a(k kVar, View view) {
                AlaLiveMultiBeautyArView.this.J(false, true);
            }
        });
        findViewById(a.f.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveMultiBeautyArView.this.bPR();
            }
        });
        this.gtv = (TextView) findViewById(a.f.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bPS();
            }
        }, 1000L);
        String string = com.baidu.live.d.xf().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
        this.gtg.c(this.gti);
        this.gtg.show(false);
    }

    private boolean isShow() {
        ViewParent parent = getParent();
        return parent != null && (parent instanceof ViewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPR() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        yW();
        if (this.gtt != null) {
            this.gtt.onClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar) {
        this.gto.guv = dVar;
        this.gto.a(new l.a<com.baidu.tieba.ala.alaar.makeup.c>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, boolean z) {
                AlaLiveMultiBeautyArView.this.b(i, cVar, dVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, boolean z) {
                return AlaLiveMultiBeautyArView.this.a(i, cVar, dVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void a(com.baidu.tieba.ala.alaar.makeup.c cVar, SeekBar seekBar, int i, boolean z) {
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gtu != null) {
                    try {
                        jSONObject.put("makeup_id", AlaLiveMultiBeautyArView.this.gtu.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("makeupbar_clk", jSONObject);
            }
        });
        this.gto.a(dVar, this);
        this.gto.setTitle(dVar.bOq());
        J(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        this.gto.guv = aVar;
        this.gto.cm(this);
        this.gto.setTitle(aVar.gtV);
        this.gto.a(new l.a<com.baidu.live.ar.h>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.h hVar, boolean z) {
                AlaLiveMultiBeautyArView.this.gts.aAR = hVar.getType();
                AlaLiveMultiBeautyArView.this.gts.aAS = hVar.yS();
                AlaLiveMultiBeautyArView.this.gts.aAT = hVar.yR();
                AlaLiveMultiBeautyArView.this.gts.aAU = hVar;
                String Fv = AlaLiveMultiBeautyArView.this.gto.gul.Fv(hVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.Fd(hVar.yQ())) {
                    Fv = com.baidu.tieba.ala.alaar.sticker.a.d.Fg(com.baidu.tieba.ala.alaar.sticker.a.d.Fc(hVar.yQ()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, Fv));
                AlaLiveMultiBeautyArView.this.gti.gux.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.c(AlaLiveMultiBeautyArView.this.gts.eL(AlaLiveMultiBeautyArView.this.gts.aAR), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gts.aAT).intValue());
                } catch (Exception e) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.live.ar.h hVar, boolean z) {
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void a(com.baidu.live.ar.h hVar, SeekBar seekBar, int i, boolean z) {
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gts.aAO != null) {
                    String str = null;
                    try {
                        if (AlaLiveMultiBeautyArView.this.gts.aAU != null) {
                            str = AlaLiveMultiBeautyArView.this.gts.aAU.getName();
                        }
                        jSONObject.put("beauty_name", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("beautybar_clk", jSONObject);
            }
        });
        if (this.bAO != null && this.bAO.yU() != null && this.bAO.yU().aAz != null) {
            this.gts.b(false, this.bAO.yU().aAz);
            List<com.baidu.live.ar.h> list = this.bAO.yU().aAz;
            this.gto.gul.e(list, this.gto.gul.i(list, this.gts.aAR));
            this.gto.gul.notifyDataSetChanged();
            if (TextUtils.equals(this.gts.aAO, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.gts.aAT)) {
                        i = Integer.valueOf(this.gts.aAT).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                c(this.gts.eL(this.gts.aAR), false, i);
            }
        }
        J(true, true);
        bPV();
        this.gtp.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeupData(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        boolean z = true;
        this.gtn = cVar;
        if (cVar != null && cVar.bOQ() != null && cVar.yO()) {
            bPW();
            this.gtl.setEnable(true);
            this.gtl.guY.setData(cVar.bOQ().getData());
            if (this.gtn != null) {
                this.gtl.setPosition(this.gtn.getPosition());
            }
            o oVar = this.gtl;
            if (!cVar.bOR() || cVar.bOS()) {
                z = false;
            }
            oVar.ml(z);
            return;
        }
        this.gtl.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPS() {
        if (com.baidu.live.d.xf().getInt("beauty_tab_redot", 0) != 1) {
            this.gti.ml(false);
        } else if (com.baidu.live.d.xf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.d.xf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.d.xf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.d.xf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.gti.guJ.bQb()) {
            this.gti.ml(true);
        } else {
            this.gti.ml(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements h.a {
        com.baidu.tieba.ala.alaar.makeup.d gtA;
        com.baidu.tieba.ala.alaar.makeup.c gtz;
        int pos;

        public a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
            this.pos = i;
            this.gtz = cVar;
            this.gtA = dVar;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void J(Object obj) {
            if (this.gtA != null && AlaLiveMultiBeautyArView.this.gto != null && AlaLiveMultiBeautyArView.this.gto.guv == this.gtA) {
                AlaLiveMultiBeautyArView.this.gto.guk.notifyDataSetChanged();
            } else if (this.gtz instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gtl.guY.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aF(Object obj) {
            if (this.gtA != null && AlaLiveMultiBeautyArView.this.gto != null && AlaLiveMultiBeautyArView.this.gto.guv == this.gtA) {
                AlaLiveMultiBeautyArView.this.gto.guk.tw(this.pos);
                AlaLiveMultiBeautyArView.this.gto.guk.notifyDataSetChanged();
            } else if (this.gtA != null && this.pos == this.gtA.gpm) {
                AlaLiveMultiBeautyArView.this.b(this.pos, this.gtz, this.gtA);
            } else if (this.gtz instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gtl.guY.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void a(Object obj, int i, int i2, String str) {
            if (this.gtA != null && AlaLiveMultiBeautyArView.this.gto != null && AlaLiveMultiBeautyArView.this.gto.guv == this.gtA) {
                AlaLiveMultiBeautyArView.this.gto.guk.notifyDataSetChanged();
            } else if (this.gtz instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gtl.guY.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
        if (dVar != null) {
            dVar.gpm = i;
        }
        if (cVar.isLoading()) {
            return true;
        }
        if (!cVar.isLoaded()) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(getContext(), a.h.sdk_network_not_available);
                return true;
            }
            cVar.download(new a(i, cVar, dVar));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
        if (dVar != null) {
            dVar.setPosition(i);
        }
        this.gtu = cVar;
        if ("makeupClose".equals(cVar.getTypeName())) {
            bPY();
        }
        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
        aVar.setResPath(cVar.bOy());
        aVar.setType(cVar.getType().name());
        aVar.setValue(cVar.bOw());
        this.gts.aAV = aVar;
        if (this.gtt != null) {
            this.gtt.a(aVar);
        }
        if (this.gtg.gvc == this.gtl) {
            boolean z = cVar.bOt() > cVar.bOu();
            this.gti.mm(z);
            if (z) {
                try {
                    this.gti.gux.setProcessDiff(0);
                    this.gtl.D(cVar.bOu(), cVar.bOt(), cVar.bOv(), cVar.getValue());
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void yW() {
        if (this.gts != null) {
            com.baidu.live.d.xf().putString("ala_beauty_config_ar", this.gts.toJsonString());
            com.baidu.tieba.ala.alaar.makeup.g.bOI().bON();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.k kVar) {
        this.bAO = kVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bnf = bdPageContext;
        gtw = BdUtilHelper.getScreenSize(this.bnf.getPageActivity()).widthPixels;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(x xVar) {
        this.aBr = xVar;
    }

    private com.baidu.live.ar.h getCurThinFace() {
        com.baidu.live.ar.h hVar = null;
        if (TextUtils.isEmpty(this.gts.aAR) || this.bAO == null || this.bAO.yU() == null || this.bAO.yU().aAz == null) {
            return null;
        }
        List<com.baidu.live.ar.h> list = this.bAO.yU().aAz;
        int i = 0;
        while (i < list.size()) {
            com.baidu.live.ar.h hVar2 = list.get(i);
            if (TextUtils.equals(this.gts.aAR, hVar2.getType())) {
                return hVar2;
            }
            i++;
            hVar = hVar2;
        }
        return hVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        com.baidu.tieba.ala.alaar.makeup.c bOF;
        int eM;
        JSONArray jSONArray = new JSONArray();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            String str = null;
            if (TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                com.baidu.live.ar.h curThinFace = getCurThinFace();
                if (curThinFace != null && !TextUtils.isEmpty(curThinFace.getName())) {
                    str = curThinFace.getName();
                    eM = this.gts.eL(this.gts.aAR);
                }
                eM = 0;
            } else {
                if (this.gti.guJ != null) {
                    for (int i = 0; i < this.gti.guJ.gtP.length; i++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gti.guJ.gtP[i].gtW)) {
                            c.a aVar = this.gti.guJ.gtP[i];
                            int i2 = aVar.gtX;
                            str = aVar.gtV;
                            eM = this.gts.eM(beautyAdjustKey.getJsonKey()) + i2;
                            break;
                        }
                    }
                }
                eM = 0;
            }
            if (eM != 0 && str != null) {
                jSONArray.put(str);
            }
        }
        JSONObject jSONObject = new JSONObject();
        if (jSONArray.length() > 0) {
            try {
                jSONObject.put("beauty_name", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        s("beauty_suc", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        if (this.gts.aAN != null) {
            try {
                jSONObject2.put("filter_id", this.gts.aAN.getId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        s("filter_suc", jSONObject2);
        if (com.baidu.tieba.ala.alaar.makeup.g.bOI().bOJ()) {
            JSONArray jSONArray2 = new JSONArray();
            List<com.baidu.tieba.ala.alaar.makeup.d> bOL = com.baidu.tieba.ala.alaar.makeup.g.bOI().bOL();
            if (bOL != null && bOL.size() > 0) {
                for (int i3 = 0; i3 < bOL.size(); i3++) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bOL.get(i3);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bOF = dVar.bOF()) != null && bOF.bOu() < bOF.bOt()) {
                        jSONArray2.put(bOF.getId());
                    }
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONArray2.length() > 0) {
                try {
                    jSONObject3.put("makeup_id", jSONArray2);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            s("makeup_suc", jSONObject3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(int i) {
        c(i, true, 0);
    }

    public void c(int i, boolean z, int i2) {
        if (z) {
            i2 = com.baidu.live.ar.e.aAZ.eM(this.gts.aAO) + this.gtj;
        }
        L(100, i, i2);
    }

    public void L(int i, int i2, int i3) {
        this.gti.gux.setMax(i);
        if (Build.VERSION.SDK_INT >= 24) {
            this.gti.gux.setProgress(i2, true);
        } else {
            this.gti.gux.setProgress(i2);
        }
        this.gti.gux.setDefThumbPos(i3);
    }

    @Deprecated
    private static void bPT() {
        ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds120);
        ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds28);
        ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds3);
    }

    public static int a(int i, int i2, int i3, int[] iArr, int i4, boolean z) {
        int i5;
        int i6 = (i3 / 2) + i2;
        if (i >= i2 + i3) {
            i5 = (((i - i6) + 1) * ds120) + ds28;
        } else {
            i5 = ((i - i6) * ds120) + ds28 + (ds120 / 2);
        }
        if (iArr != null) {
            int i7 = iArr[0] - ((gtw - ds120) / 2);
            int i8 = z ? ((i - 1) * (ds120 + ds20)) + ds28 + ds3 + ds20 : ((ds120 + ds20) * i) + ds28;
            int i9 = ((i4 - i) - 1) * (ds120 + ds20);
            if ((gtw - ds120) / 2 > i8) {
                return (((gtw - ds120) / 2) - i8) + i7;
            }
            return (gtw - ds120) / 2 > i9 ? i7 - (((gtw - ds120) / 2) - i9) : i7;
        }
        return i5;
    }

    public static int bC(int i, int i2) {
        return Math.max(0, Math.min((i - ds120) >> 1, ((ds120 + ds20) * i2) + ds28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPU() {
        if (this.gtq != null) {
            this.gtq.dismiss();
            this.gtq = null;
        }
        String string = getContext().getString(a.h.ar_beauty_is_reset);
        this.gtq = new BdAlertDialog((Activity) getContext());
        this.gtq.setAutoNight(false);
        this.gtq.setMessage(string);
        this.gtq.setPositiveButton(getContext().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.yX();
                AlaLiveMultiBeautyArView.this.Ek();
            }
        });
        this.gtq.setNegativeButton(getContext().getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.Ek();
            }
        });
        this.gtq.setCancelable(false);
        this.gtq.setCanceledOnTouchOutside(false);
        this.gtq.setTitleShowCenter(true);
        this.gtq.setMessageShowCenter(true);
        this.gtq.isShowTitleAndMessage();
        this.gtq.create(this.bnf);
        this.gtq.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yX() {
        if (this.gtt != null) {
            this.gtt.yX();
        }
        bPZ();
        String str = this.gts.aAR;
        String str2 = this.gts.aAS;
        String str3 = this.gts.aAT;
        String str4 = com.baidu.live.ar.e.aBa.aAO;
        com.baidu.live.ar.e.aBa.r(com.baidu.live.ar.e.aAZ.toJsonString(), true);
        com.baidu.live.ar.e.aBa.aAO = str4;
        com.baidu.live.ar.e.aBa.aAR = str;
        com.baidu.live.ar.e.aBa.aAS = str2;
        com.baidu.live.ar.e.aBa.aAT = str3;
        this.gts = com.baidu.live.ar.e.aBa;
        if (this.bAO != null && this.bAO.yU() != null && this.bAO.yU().aAz != null) {
            this.gts.b(true, this.bAO.yU().aAz);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int eL = this.gts.eL(str);
            this.gti.gux.setProcessDiff(0);
            c(eL, false, eL);
            return;
        }
        to(this.gts.eM(this.gts.aAO) + this.gtj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ek() {
        if (this.gtq != null) {
            this.gtq.dismiss();
            this.gtq = null;
        }
        this.gtq = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gtr) {
            this.gtr = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && isShow()) {
            bPR();
            return true;
        }
        return false;
    }

    private void bPV() {
        if (!TextUtils.isEmpty(this.gts.aAR)) {
            if (TextUtils.isEmpty(this.gts.aAT)) {
                to(this.gts.eL(this.gts.aAR));
                return;
            }
            try {
                this.gti.gux.setProcessDiff(0);
                c(this.gts.eL(this.gts.aAR), false, Integer.valueOf(this.gts.aAT).intValue());
            } catch (Exception e) {
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if ((i == 0) != (getVisibility() == 0)) {
            J(false, false);
        }
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        J(false, false);
        if (this.gti != null && this.gti.isEnable()) {
            Fo("beautytab_show");
        }
        if (this.gtl != null && this.gtl.isEnable()) {
            Fo("makeuptab_show");
        }
        if (this.gth != null && this.gth.isEnable()) {
            Fo("filtertab_show");
        }
    }

    private void Fo(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "beauty");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int i = 0;
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            i = this.aBr.mLiveInfo.live_status;
        }
        if (i != 1) {
            str2 = UbcStatConstant.Page.LIVE_ACTION;
        } else {
            str2 = "author_liveroom";
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", str2, str).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, JSONObject jSONObject) {
        String str2;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "beauty");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int i = 0;
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            i = this.aBr.mLiveInfo.live_status;
        }
        if (i != 1) {
            str2 = UbcStatConstant.Page.LIVE_ACTION;
        } else {
            str2 = "author_liveroom";
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str2, str).setContentExt(jSONObject));
    }

    private void s(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "beauty");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", str).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z, boolean z2) {
        if (z) {
            this.gtg.dismiss(z2);
            if (this.gto != null) {
                this.gtp.setTitle(this.gto.getTitle());
            }
            this.gtp.show(z2);
            return;
        }
        if (this.gtg.gvc == this.gtl) {
            this.gti.mm(false);
        }
        this.gtp.dismiss(z2);
        this.gtg.show(z2);
        bPS();
        if (!this.gti.guJ.bQb()) {
            this.gti.guJ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.m mVar) {
        this.gtt = mVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.e.aBa.r(com.baidu.live.d.xf().getString("ala_beauty_config_ar", ""), false);
        if (TextUtils.isEmpty(com.baidu.live.ar.e.aBa.aAM) && com.baidu.minivideo.arface.b.ZU() != null) {
            com.baidu.live.ar.e eVar = com.baidu.live.ar.e.aBa;
            com.baidu.minivideo.arface.b.ZU();
            eVar.aAM = com.baidu.minivideo.arface.c.aab();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.j.aBo)) {
            com.baidu.minivideo.arface.b.ZU();
            com.baidu.live.ar.j.eO(com.baidu.minivideo.arface.c.aab());
        }
        this.gts = com.baidu.live.ar.e.aBa;
        setBeautyAdjustUserData2AR(false);
        bPW();
        if (this.gtg.gvc == this.gti && !TextUtils.equals(this.gts.aAO, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            to(this.gts.eM(this.gts.aAO) + this.gtj);
        }
        this.gti.guJ.Fr(this.gts.aAO);
        this.gti.guJ.notifyDataSetChanged();
        if (this.bAO != null && this.bAO.yU() != null && this.bAO.yU().aAy != null) {
            this.gth.guQ.setDatas(this.bAO.yU().aAy);
            if (!TextUtils.isEmpty(getFilterFileName())) {
                this.gth.guQ.setSelect(h(this.bAO.yU().aAy, getFilterFileName()));
            }
        }
        this.gth.guQ.notifyDataSetChanged();
    }

    public int h(List<com.baidu.live.ar.i> list, String str) {
        String Fc;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getContext().getString(a.h.beauty_yuantu).equals(list.get(i2).getName())) {
                com.baidu.minivideo.arface.b.ZU();
                Fc = com.baidu.minivideo.arface.c.aab();
                i = i2;
            } else {
                Fc = com.baidu.tieba.ala.alaar.sticker.a.e.Fc(list.get(i2).yQ());
            }
            if (str.equals(Fc)) {
                return i2;
            }
        }
        if (i < 0) {
            i = -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautyAdjustUserData2AR(boolean z) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.gtt != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.gti.guJ != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.gti.guJ.gtP.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gti.guJ.gtP[i2].gtW)) {
                            i = this.gti.guJ.gtP[i2].gtX;
                        }
                    }
                } else {
                    i = 0;
                }
                this.gtt.a(((this.gts.eM(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bPZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPW() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bOL;
        com.baidu.tieba.ala.alaar.makeup.c bOF;
        if (this.gtt != null && com.baidu.tieba.ala.alaar.makeup.g.bOI().bOJ() && (bOL = com.baidu.tieba.ala.alaar.makeup.g.bOI().bOL()) != null && bOL.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bOL.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bOL.get(i2);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bOF = dVar.bOF()) != null && bOF.bOu() < bOF.bOt()) {
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bOF.getTypeName());
                        aVar.setValue(bOF.bOw());
                        aVar.setResPath(bOF.bOy());
                        this.gtt.a(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPX() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bOL = com.baidu.tieba.ala.alaar.makeup.g.bOI().bOL();
        if (this.gtt != null && bOL != null && bOL.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bOL.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bOL.get(i2);
                    if (dVar == null || !"makeupClose".equals(dVar.getTypeName())) {
                        i = i2 + 1;
                    } else {
                        com.baidu.tieba.ala.alaar.makeup.c bOF = dVar.bOF();
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bOF.getTypeName());
                        aVar.setValue(bOF.bOw());
                        aVar.setResPath(bOF.bOy());
                        this.gtt.a(aVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bPY() {
        com.baidu.tieba.ala.alaar.makeup.a.b bOQ = this.gtn.bOQ();
        if (bOQ != null) {
            List<com.baidu.tieba.ala.alaar.makeup.d> data = bOQ.getData();
            for (int i = 0; i < data.size(); i++) {
                com.baidu.tieba.ala.alaar.makeup.d dVar = data.get(i);
                if (dVar != null) {
                    dVar.setPosition(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThinFace(int i) {
        if (this.gtt != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.gts.aAS);
            this.gtt.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bPZ() {
        setThinFace(this.gts.eL(this.gts.aAR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fq(String str) {
        this.gtv.setText(str);
        this.gtv.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gtv, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gtv, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gtv, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.gtv, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void yV() {
        if (this.gti.guJ != null) {
            this.gti.guJ.notifyDataSetChanged();
        }
        if (this.gth.guQ != null) {
            this.gth.guQ.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
