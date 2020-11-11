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
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class AlaLiveMultiBeautyArView extends ILiveMultiBeautyView implements View.OnClickListener {
    private static int ds120;
    private static int ds20;
    private static int ds28;
    private static int ds3;
    private static int gfP;
    private w aES;
    private BdPageContext bmK;
    private com.baidu.live.ar.j bxo;
    private final n gfA;
    private final m gfB;
    int gfC;
    private c.a gfD;
    private final o gfE;
    private int gfF;
    private com.baidu.tieba.ala.alaar.makeup.a.c gfG;
    private final i gfH;
    private k gfI;
    private BdAlertDialog gfJ;
    private boolean gfK;
    private com.baidu.live.ar.d gfL;
    private com.baidu.live.ar.l gfM;
    private com.baidu.tieba.ala.alaar.makeup.c gfN;
    private TextView gfO;
    private final p gfz;

    static /* synthetic */ int b(AlaLiveMultiBeautyArView alaLiveMultiBeautyArView) {
        int i = alaLiveMultiBeautyArView.gfF;
        alaLiveMultiBeautyArView.gfF = i + 1;
        return i;
    }

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.gfz = new p();
        this.gfA = new n();
        this.gfB = new m();
        this.gfC = 0;
        this.gfE = new o();
        this.gfH = new i();
        this.gfI = new k();
        this.gfK = true;
        this.gfL = com.baidu.live.ar.d.aEA;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfz = new p();
        this.gfA = new n();
        this.gfB = new m();
        this.gfC = 0;
        this.gfE = new o();
        this.gfH = new i();
        this.gfI = new k();
        this.gfK = true;
        this.gfL = com.baidu.live.ar.d.aEA;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gfz = new p();
        this.gfA = new n();
        this.gfB = new m();
        this.gfC = 0;
        this.gfE = new o();
        this.gfH = new i();
        this.gfI = new k();
        this.gfK = true;
        this.gfL = com.baidu.live.ar.d.aEA;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_beauty_ar_hor_layout, this);
        bOh();
        this.gfF = 0;
        this.gfz.bU(this);
        this.gfz.a(new p.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.tieba.ala.alaar.view.p.a
            public void a(l lVar) {
                if (lVar != AlaLiveMultiBeautyArView.this.gfE) {
                    if (lVar == AlaLiveMultiBeautyArView.this.gfA) {
                        AlaLiveMultiBeautyArView.this.gfA.tR(AlaLiveMultiBeautyArView.this.gfL.fW(AlaLiveMultiBeautyArView.this.gfL.aEm));
                        return;
                    } else {
                        if (lVar == AlaLiveMultiBeautyArView.this.gfB) {
                        }
                        return;
                    }
                }
                AlaLiveMultiBeautyArView.b(AlaLiveMultiBeautyArView.this);
                if (AlaLiveMultiBeautyArView.this.gfG != null && !AlaLiveMultiBeautyArView.this.gfG.bNe()) {
                    AlaLiveMultiBeautyArView.this.gfG.ls(true);
                }
                if (AlaLiveMultiBeautyArView.this.gfF == 1 && AlaLiveMultiBeautyArView.this.gfE.ghp != null) {
                    AlaLiveMultiBeautyArView.this.gfE.tP(AlaLiveMultiBeautyArView.this.gfE.ghp.getCurrentPosition());
                }
                AlaLiveMultiBeautyArView.this.gfE.lw(false);
            }
        });
        this.gfA.bU(this);
        this.gfA.setTitle(getResources().getString(a.h.ala_live_new_beauty_filter));
        this.gfz.b(this.gfA);
        this.gfA.c(new com.baidu.tieba.ala.alaar.view.a(getContext()));
        this.gfA.a(new l.a<com.baidu.live.ar.h>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.h hVar, boolean z) {
                String FZ;
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.h.beauty_yuantu).equals(hVar.getName())) {
                    com.baidu.minivideo.arface.b.aab();
                    FZ = com.baidu.minivideo.arface.c.aag();
                } else {
                    FZ = com.baidu.tieba.ala.alaar.sticker.a.e.FZ(hVar.Cu());
                }
                if (!AlaLiveMultiBeautyArView.this.gfL.aEm.equals(FZ)) {
                    AlaLiveMultiBeautyArView.this.Go(hVar.getName());
                }
                AlaLiveMultiBeautyArView.this.gfL.aEm = FZ;
                AlaLiveMultiBeautyArView.this.gfL.aEn = hVar;
                if (AlaLiveMultiBeautyArView.this.gfM != null && AlaLiveMultiBeautyArView.this.bxo.Cy() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gfL.a(hVar, AlaLiveMultiBeautyArView.this.bxo.Cy().aDY);
                    int fW = AlaLiveMultiBeautyArView.this.gfL.fW(AlaLiveMultiBeautyArView.this.gfL.aEm);
                    float f = (((fW * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + fW + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gfM.onFilterSelected(AlaLiveMultiBeautyArView.this.gfL.aEn.getName(), AlaLiveMultiBeautyArView.this.gfL.aEm, f);
                }
                if (AlaLiveMultiBeautyArView.this.gfz.ght == AlaLiveMultiBeautyArView.this.gfA) {
                    AlaLiveMultiBeautyArView.this.gfA.tR(AlaLiveMultiBeautyArView.this.gfL.fW(AlaLiveMultiBeautyArView.this.gfL.aEm));
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
                AlaLiveMultiBeautyArView.this.gfL.y(AlaLiveMultiBeautyArView.this.gfL.aEm, i);
                if (AlaLiveMultiBeautyArView.this.gfM != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gfL.a(AlaLiveMultiBeautyArView.this.gfL.aEn, AlaLiveMultiBeautyArView.this.bxo.Cy().aDY);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gfM.onFilterSelected(AlaLiveMultiBeautyArView.this.gfL.aEn.getName(), AlaLiveMultiBeautyArView.this.gfL.aEm, f);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gfL.aEn != null) {
                    try {
                        jSONObject.put("filter_id", AlaLiveMultiBeautyArView.this.gfL.aEn.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.s("filterbar_clk", jSONObject);
            }
        });
        this.gfB.bU(this);
        this.gfB.setTitle(getResources().getString(a.h.ala_live_new_beauty_beauty));
        this.gfz.b(this.gfB);
        this.gfB.a(new l.a<c.a>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, c.a aVar, boolean z) {
                if (AlaLiveMultiBeautyArView.this.gfz.ght == AlaLiveMultiBeautyArView.this.gfB) {
                    if (i == 0) {
                        AlaLiveMultiBeautyArView.this.bOi();
                        return;
                    }
                    String str = aVar.ggo;
                    AlaLiveMultiBeautyArView.this.gfB.gha.Gs(str);
                    AlaLiveMultiBeautyArView.this.bOg();
                    AlaLiveMultiBeautyArView.this.gfL.aEo = str;
                    if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (AlaLiveMultiBeautyArView.this.gfz.ght == AlaLiveMultiBeautyArView.this.gfB && z) {
                            AlaLiveMultiBeautyArView.this.a(aVar);
                            return;
                        }
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gfD = aVar;
                    if (aVar != null) {
                        AlaLiveMultiBeautyArView.this.gfC = aVar.ggp;
                    }
                    AlaLiveMultiBeautyArView.this.tG(AlaLiveMultiBeautyArView.this.gfL.fY(AlaLiveMultiBeautyArView.this.gfL.aEo) + aVar.ggp);
                    AlaLiveMultiBeautyArView.this.gfB.ggO.setProcessDiff(aVar.ggp);
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
                if (AlaLiveMultiBeautyArView.this.gfz.ght == AlaLiveMultiBeautyArView.this.gfE) {
                    if (z && AlaLiveMultiBeautyArView.this.gfN != null) {
                        AlaLiveMultiBeautyArView.this.gfN.setValue(i);
                        if (AlaLiveMultiBeautyArView.this.gfL.aEv != null) {
                            AlaLiveMultiBeautyArView.this.gfL.aEv.setValue(AlaLiveMultiBeautyArView.this.gfN.bMI());
                            AlaLiveMultiBeautyArView.this.gfM.a(AlaLiveMultiBeautyArView.this.gfL.aEv);
                        }
                    }
                } else if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gfL.aEo, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.gfL.dD(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.gfL.aEr) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.gfL.aEr)) && com.baidu.live.d.AZ().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.d.AZ().getBoolean("naturalFace", true)) {
                        com.baidu.live.d.AZ().putBoolean("naturalFace", false);
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.gfL.z(AlaLiveMultiBeautyArView.this.gfL.aEo, i - AlaLiveMultiBeautyArView.this.gfC);
                    if (AlaLiveMultiBeautyArView.this.gfM != null) {
                        AlaLiveMultiBeautyArView.this.gfM.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fU(AlaLiveMultiBeautyArView.this.gfL.aEo));
                    }
                }
                if (z) {
                    com.baidu.live.d.AZ().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (AlaLiveMultiBeautyArView.this.gfz.ght != AlaLiveMultiBeautyArView.this.gfE) {
                    if (AlaLiveMultiBeautyArView.this.gfL.aEo != null) {
                        String str = null;
                        if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gfL.aEo, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            if (AlaLiveMultiBeautyArView.this.gfL.aEu != null) {
                                str = AlaLiveMultiBeautyArView.this.gfL.aEu.getName();
                            }
                        } else {
                            str = AlaLiveMultiBeautyArView.this.gfD.mShowName;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (AlaLiveMultiBeautyArView.this.gfD != null && str != null) {
                            try {
                                jSONObject.put("beauty_name", str);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        AlaLiveMultiBeautyArView.this.s("beautybar_clk", jSONObject);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gfN != null) {
                    try {
                        jSONObject2.put("makeup_id", AlaLiveMultiBeautyArView.this.gfN.getId());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.s("makeupbar_clk", jSONObject2);
            }
        });
        this.gfB.ghf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.gfz.ght == AlaLiveMultiBeautyArView.this.gfE) {
                            AlaLiveMultiBeautyArView.this.bOl();
                            break;
                        } else {
                            if (AlaLiveMultiBeautyArView.this.gfM != null) {
                                AlaLiveMultiBeautyArView.this.gfM.CD();
                            }
                            AlaLiveMultiBeautyArView.this.setThinFace(0);
                            break;
                        }
                    case 1:
                    case 3:
                    case 4:
                        if (AlaLiveMultiBeautyArView.this.gfz.ght == AlaLiveMultiBeautyArView.this.gfE) {
                            AlaLiveMultiBeautyArView.this.bOk();
                            break;
                        } else {
                            AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                            break;
                        }
                }
                return true;
            }
        });
        this.gfE.bU(this);
        this.gfE.tQ(0);
        this.gfE.setTitle(getResources().getString(a.h.ala_live_new_beauty_makeup));
        this.gfz.b(this.gfE);
        this.gfE.a(new l.a<com.baidu.tieba.ala.alaar.makeup.d>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemSelected pos= " + i + ", name=" + dVar.getName());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bMQ = dVar.bMQ();
                if (dVar.ayX() || bMQ == null || bMQ.isEmpty()) {
                    AlaLiveMultiBeautyArView.this.b(i, dVar, null);
                } else if (AlaLiveMultiBeautyArView.this.gfz.ght == AlaLiveMultiBeautyArView.this.gfE) {
                    AlaLiveMultiBeautyArView.this.a(dVar);
                }
                if (AlaLiveMultiBeautyArView.this.gfG != null) {
                    AlaLiveMultiBeautyArView.this.gfG.setPosition(i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemClick pos= " + i + ", name=" + dVar.getName());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bMQ = dVar.bMQ();
                if (dVar.ayX() || bMQ == null || bMQ.isEmpty()) {
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
        if (this.gfG != null) {
            this.gfE.setPosition(this.gfG.getPosition());
        }
        com.baidu.tieba.ala.alaar.makeup.g.bMU().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.tieba.ala.alaar.makeup.a.b
            public void c(com.baidu.tieba.ala.alaar.makeup.a aVar) {
                com.baidu.tieba.ala.alaar.makeup.a.c bMW = com.baidu.tieba.ala.alaar.makeup.g.bMU().bMW();
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("BeautyAr", "makeupdata onDataLoaded size: " + (AlaLiveMultiBeautyArView.this.gfG == null ? "null" : Integer.valueOf(AlaLiveMultiBeautyArView.this.gfG.size())));
                }
                AlaLiveMultiBeautyArView.this.setMakeupData(bMW);
            }
        });
        this.gfI.bU(this);
        this.gfI.a(new j.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.j.a
            public void a(k kVar, View view) {
                AlaLiveMultiBeautyArView.this.H(false, true);
            }
        });
        findViewById(a.f.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveMultiBeautyArView.this.bOf();
            }
        });
        this.gfO = (TextView) findViewById(a.f.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bOg();
            }
        }, 1000L);
        String string = com.baidu.live.d.AZ().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
        this.gfz.c(this.gfB);
        this.gfz.show(false);
    }

    private boolean isShow() {
        ViewParent parent = getParent();
        return parent != null && (parent instanceof ViewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOf() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        CA();
        if (this.gfM != null) {
            this.gfM.CB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar) {
        this.gfH.ggM = dVar;
        this.gfH.a(new l.a<com.baidu.tieba.ala.alaar.makeup.c>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
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
                if (AlaLiveMultiBeautyArView.this.gfN != null) {
                    try {
                        jSONObject.put("makeup_id", AlaLiveMultiBeautyArView.this.gfN.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.s("makeupbar_clk", jSONObject);
            }
        });
        this.gfH.a(dVar, this);
        this.gfH.setTitle(dVar.getName());
        H(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        this.gfH.ggM = aVar;
        this.gfH.bT(this);
        this.gfH.setTitle(aVar.mShowName);
        this.gfH.a(new l.a<com.baidu.live.ar.g>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.g gVar, boolean z) {
                AlaLiveMultiBeautyArView.this.gfL.aEr = gVar.getType();
                AlaLiveMultiBeautyArView.this.gfL.aEs = gVar.Cw();
                AlaLiveMultiBeautyArView.this.gfL.aEt = gVar.Cv();
                AlaLiveMultiBeautyArView.this.gfL.aEu = gVar;
                String Gu = AlaLiveMultiBeautyArView.this.gfH.ggD.Gu(gVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.Ga(gVar.Cu())) {
                    Gu = com.baidu.tieba.ala.alaar.sticker.a.d.Gd(com.baidu.tieba.ala.alaar.sticker.a.d.FZ(gVar.Cu()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, Gu));
                AlaLiveMultiBeautyArView.this.gfB.ggO.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.gfL.fX(gVar.getType()), false, Integer.valueOf(gVar.Cv()).intValue());
                } catch (Exception e) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.live.ar.g gVar, boolean z) {
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void a(com.baidu.live.ar.g gVar, SeekBar seekBar, int i, boolean z) {
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gfL.aEo != null) {
                    String str = null;
                    try {
                        if (AlaLiveMultiBeautyArView.this.gfL.aEu != null) {
                            str = AlaLiveMultiBeautyArView.this.gfL.aEu.getName();
                        }
                        jSONObject.put("beauty_name", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.s("beautybar_clk", jSONObject);
            }
        });
        if (this.bxo != null && this.bxo.Cy() != null && this.bxo.Cy().aDZ != null) {
            this.gfL.a(false, this.bxo.Cy().aDZ);
            this.gfH.ggD.e(this.bxo.Cy().aDZ, this.gfH.ggD.Gt(this.gfL.aEr));
            this.gfH.ggD.notifyDataSetChanged();
            if (TextUtils.equals(this.gfL.aEo, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.gfL.aEt)) {
                        i = Integer.valueOf(this.gfL.aEt).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                a(this.gfL.fX(this.gfL.aEr), false, i);
            }
        }
        H(true, true);
        bOj();
        this.gfI.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeupData(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        boolean z = true;
        this.gfG = cVar;
        if (cVar != null && cVar.bNc() != null && cVar.Cs()) {
            bOk();
            this.gfE.setEnable(true);
            this.gfE.ghp.setData(cVar.bNc().getData());
            if (this.gfG != null) {
                this.gfE.setPosition(this.gfG.getPosition());
            }
            o oVar = this.gfE;
            if (!cVar.bNd() || cVar.bNe()) {
                z = false;
            }
            oVar.lw(z);
            return;
        }
        this.gfE.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOg() {
        if (com.baidu.live.d.AZ().getInt("beauty_tab_redot", 0) != 1) {
            this.gfB.lw(false);
        } else if (com.baidu.live.d.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.d.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.d.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.d.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.gfB.gha.bOp()) {
            this.gfB.lw(true);
        } else {
            this.gfB.lw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements h.a {
        com.baidu.tieba.ala.alaar.makeup.c gfS;
        com.baidu.tieba.ala.alaar.makeup.d gfT;
        int pos;

        public a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
            this.pos = i;
            this.gfS = cVar;
            this.gfT = dVar;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aD(Object obj) {
            if (this.gfT != null && AlaLiveMultiBeautyArView.this.gfH != null && AlaLiveMultiBeautyArView.this.gfH.ggM == this.gfT) {
                AlaLiveMultiBeautyArView.this.gfH.ggC.notifyDataSetChanged();
            } else if (this.gfS instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gfE.ghp.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aE(Object obj) {
            if (this.gfT != null && AlaLiveMultiBeautyArView.this.gfH != null && AlaLiveMultiBeautyArView.this.gfH.ggM == this.gfT) {
                AlaLiveMultiBeautyArView.this.gfH.ggC.tO(this.pos);
                AlaLiveMultiBeautyArView.this.gfH.ggC.notifyDataSetChanged();
            } else if (this.gfT != null && this.pos == this.gfT.gbA) {
                AlaLiveMultiBeautyArView.this.b(this.pos, this.gfS, this.gfT);
            } else if (this.gfS instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gfE.ghp.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void a(Object obj, int i, int i2, String str) {
            if (this.gfT != null && AlaLiveMultiBeautyArView.this.gfH != null && AlaLiveMultiBeautyArView.this.gfH.ggM == this.gfT) {
                AlaLiveMultiBeautyArView.this.gfH.ggC.notifyDataSetChanged();
            } else if (this.gfS instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gfE.ghp.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
        if (dVar != null) {
            dVar.gbA = i;
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
        this.gfN = cVar;
        if ("makeupClose".equals(cVar.getTypeName())) {
            bOm();
        }
        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
        aVar.setResPath(cVar.bMK());
        aVar.setType(cVar.getType().name());
        aVar.setValue(cVar.bMI());
        this.gfL.aEv = aVar;
        if (this.gfM != null) {
            this.gfM.a(aVar);
        }
        if (this.gfz.ght == this.gfE) {
            boolean z = cVar.bMF() > cVar.bMG();
            this.gfB.lx(z);
            if (z) {
                try {
                    this.gfB.ggO.setProcessDiff(0);
                    this.gfE.x(cVar.bMG(), cVar.bMF(), cVar.bMH(), cVar.getValue());
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void CA() {
        if (this.gfL != null) {
            com.baidu.live.d.AZ().putString("ala_beauty_config_ar", this.gfL.toJsonString());
            com.baidu.tieba.ala.alaar.makeup.g.bMU().bMZ();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.j jVar) {
        this.bxo = jVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bmK = bdPageContext;
        gfP = BdUtilHelper.getScreenSize(this.bmK.getPageActivity()).widthPixels;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(w wVar) {
        this.aES = wVar;
    }

    private com.baidu.live.ar.g getCurThinFace() {
        if (TextUtils.isEmpty(this.gfL.aEr) || this.bxo == null || this.bxo.Cy() == null || this.bxo.Cy().aDZ == null) {
            return null;
        }
        List<com.baidu.live.ar.g> list = this.bxo.Cy().aDZ;
        com.baidu.live.ar.g gVar = null;
        for (int i = 0; i < list.size(); i++) {
            gVar = list.get(i);
            if (TextUtils.equals(this.gfL.aEr, gVar.getType())) {
                return gVar;
            }
        }
        return gVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        com.baidu.tieba.ala.alaar.makeup.c bMR;
        String str;
        int fY;
        JSONArray jSONArray = new JSONArray();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            if (TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                com.baidu.live.ar.g curThinFace = getCurThinFace();
                if (curThinFace != null && !TextUtils.isEmpty(curThinFace.getName())) {
                    str = curThinFace.getName();
                    fY = this.gfL.fX(this.gfL.aEr);
                }
                str = null;
                fY = 0;
            } else {
                if (this.gfB.gha != null) {
                    for (int i = 0; i < this.gfB.gha.ggi.length; i++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gfB.gha.ggi[i].ggo)) {
                            c.a aVar = this.gfB.gha.ggi[i];
                            int i2 = aVar.ggp;
                            str = aVar.mShowName;
                            fY = this.gfL.fY(beautyAdjustKey.getJsonKey()) + i2;
                            break;
                        }
                    }
                }
                str = null;
                fY = 0;
            }
            if (fY != 0 && str != null) {
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
        t("beauty_suc", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        if (this.gfL.aEn != null) {
            try {
                jSONObject2.put("filter_id", this.gfL.aEn.getId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        t("filter_suc", jSONObject2);
        if (com.baidu.tieba.ala.alaar.makeup.g.bMU().bMV()) {
            JSONArray jSONArray2 = new JSONArray();
            List<com.baidu.tieba.ala.alaar.makeup.d> bMX = com.baidu.tieba.ala.alaar.makeup.g.bMU().bMX();
            if (bMX != null && bMX.size() > 0) {
                for (int i3 = 0; i3 < bMX.size(); i3++) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bMX.get(i3);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bMR = dVar.bMR()) != null && bMR.bMG() < bMR.bMF()) {
                        jSONArray2.put(bMR.getId());
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
            t("makeup_suc", jSONObject3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tG(int i) {
        a(i, true, 0);
    }

    public void a(int i, boolean z, int i2) {
        if (z) {
            i2 = com.baidu.live.ar.d.aEz.fY(this.gfL.aEo) + this.gfC;
        }
        I(100, i, i2);
    }

    public void I(int i, int i2, int i3) {
        this.gfB.ggO.setMax(i);
        if (Build.VERSION.SDK_INT >= 24) {
            this.gfB.ggO.setProgress(i2, true);
        } else {
            this.gfB.ggO.setProgress(i2);
        }
        this.gfB.ggO.setDefThumbPos(i3);
    }

    @Deprecated
    private static void bOh() {
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
            int i7 = iArr[0] - ((gfP - ds120) / 2);
            int i8 = z ? ((i - 1) * (ds120 + ds20)) + ds28 + ds3 + ds20 : ((ds120 + ds20) * i) + ds28;
            int i9 = ((i4 - i) - 1) * (ds120 + ds20);
            if ((gfP - ds120) / 2 > i8) {
                return (((gfP - ds120) / 2) - i8) + i7;
            }
            return (gfP - ds120) / 2 > i9 ? i7 - (((gfP - ds120) / 2) - i9) : i7;
        }
        return i5;
    }

    public static int bC(int i, int i2) {
        return Math.max(0, Math.min((i - ds120) >> 1, ((ds120 + ds20) * i2) + ds28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOi() {
        if (this.gfJ != null) {
            this.gfJ.dismiss();
            this.gfJ = null;
        }
        String string = getContext().getString(a.h.ar_beauty_is_reset);
        this.gfJ = new BdAlertDialog((Activity) getContext());
        this.gfJ.setAutoNight(false);
        this.gfJ.setMessage(string);
        this.gfJ.setPositiveButton(getContext().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.CC();
                AlaLiveMultiBeautyArView.this.Hv();
            }
        });
        this.gfJ.setNegativeButton(getContext().getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.Hv();
            }
        });
        this.gfJ.setCancelable(false);
        this.gfJ.setCanceledOnTouchOutside(false);
        this.gfJ.setTitleShowCenter(true);
        this.gfJ.setMessageShowCenter(true);
        this.gfJ.isShowTitleAndMessage();
        this.gfJ.create(this.bmK);
        this.gfJ.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CC() {
        if (this.gfM != null) {
            this.gfM.CC();
        }
        bOn();
        String str = this.gfL.aEr;
        String str2 = this.gfL.aEs;
        String str3 = this.gfL.aEt;
        String str4 = com.baidu.live.ar.d.aEA.aEo;
        com.baidu.live.ar.d.aEA.fV(com.baidu.live.ar.d.aEz.toJsonString());
        com.baidu.live.ar.d.aEA.aEo = str4;
        com.baidu.live.ar.d.aEA.aEr = str;
        com.baidu.live.ar.d.aEA.aEs = str2;
        com.baidu.live.ar.d.aEA.aEt = str3;
        this.gfL = com.baidu.live.ar.d.aEA;
        if (this.bxo != null && this.bxo.Cy() != null && this.bxo.Cy().aDZ != null) {
            this.gfL.a(true, this.bxo.Cy().aDZ);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fX = this.gfL.fX(str);
            this.gfB.ggO.setProcessDiff(0);
            a(fX, false, fX);
            return;
        }
        tG(this.gfL.fY(this.gfL.aEo) + this.gfC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv() {
        if (this.gfJ != null) {
            this.gfJ.dismiss();
            this.gfJ = null;
        }
        this.gfJ = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gfK) {
            this.gfK = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && isShow()) {
            bOf();
            return true;
        }
        return false;
    }

    private void bOj() {
        if (!TextUtils.isEmpty(this.gfL.aEr)) {
            if (TextUtils.isEmpty(this.gfL.aEt)) {
                tG(this.gfL.fX(this.gfL.aEr));
                return;
            }
            try {
                this.gfB.ggO.setProcessDiff(0);
                a(this.gfL.fX(this.gfL.aEr), false, Integer.valueOf(this.gfL.aEt).intValue());
            } catch (Exception e) {
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if ((i == 0) != (getVisibility() == 0)) {
            H(false, false);
        }
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        H(false, false);
        if (this.gfB != null && this.gfB.isEnable()) {
            Gm("beautytab_show");
        }
        if (this.gfE != null && this.gfE.isEnable()) {
            Gm("makeuptab_show");
        }
        if (this.gfA != null && this.gfA.isEnable()) {
            Gm("filtertab_show");
        }
    }

    private void Gm(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "beauty");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int i = 0;
        if (this.aES != null && this.aES.mLiveInfo != null) {
            i = this.aES.mLiveInfo.live_status;
        }
        if (i != 1) {
            str2 = UbcStatConstant.Page.LIVE_ACTION;
        } else {
            str2 = UbcStatConstant.Page.AUTHOR_LIVE_ROOM;
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", str2, str).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, JSONObject jSONObject) {
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
        if (this.aES != null && this.aES.mLiveInfo != null) {
            i = this.aES.mLiveInfo.live_status;
        }
        if (i != 1) {
            str2 = UbcStatConstant.Page.LIVE_ACTION;
        } else {
            str2 = UbcStatConstant.Page.AUTHOR_LIVE_ROOM;
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str2, str).setContentExt(jSONObject));
    }

    private void t(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "beauty");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, str).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z, boolean z2) {
        if (z) {
            this.gfz.dismiss(z2);
            if (this.gfH != null) {
                this.gfI.setTitle(this.gfH.getTitle());
            }
            this.gfI.show(z2);
            return;
        }
        if (this.gfz.ght == this.gfE) {
            this.gfB.lx(false);
        }
        this.gfI.dismiss(z2);
        this.gfz.show(z2);
        bOg();
        if (!this.gfB.gha.bOp()) {
            this.gfB.gha.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.l lVar) {
        this.gfM = lVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.d.aEA.fV(com.baidu.live.d.AZ().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.d.aEA.aEm) && com.baidu.minivideo.arface.b.aab() != null) {
            com.baidu.live.ar.d dVar = com.baidu.live.ar.d.aEA;
            com.baidu.minivideo.arface.b.aab();
            dVar.aEm = com.baidu.minivideo.arface.c.aag();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.i.aEP)) {
            com.baidu.minivideo.arface.b.aab();
            com.baidu.live.ar.i.ga(com.baidu.minivideo.arface.c.aag());
        }
        this.gfL = com.baidu.live.ar.d.aEA;
        setBeautyAdjustUserData2AR(false);
        bOk();
        if (this.gfz.ght == this.gfB && !TextUtils.equals(this.gfL.aEo, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            tG(this.gfL.fY(this.gfL.aEo) + this.gfC);
        }
        this.gfB.gha.Gp(this.gfL.aEo);
        this.gfB.gha.notifyDataSetChanged();
        if (this.bxo != null && this.bxo.Cy() != null && this.bxo.Cy().aDY != null) {
            this.gfA.ghh.setDatas(this.bxo.Cy().aDY);
            if (!TextUtils.isEmpty(this.gfL.aEm)) {
                this.gfA.ghh.setSelect(i(this.bxo.Cy().aDY, this.gfL.aEm));
            }
        }
        this.gfA.ghh.notifyDataSetChanged();
    }

    public int i(List<com.baidu.live.ar.h> list, String str) {
        String FZ;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getContext().getString(a.h.beauty_yuantu).equals(list.get(i2).getName())) {
                com.baidu.minivideo.arface.b.aab();
                FZ = com.baidu.minivideo.arface.c.aag();
                i = i2;
            } else {
                FZ = com.baidu.tieba.ala.alaar.sticker.a.e.FZ(list.get(i2).Cu());
            }
            if (str.equals(FZ)) {
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
        if (this.gfM != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.gfB.gha != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.gfB.gha.ggi.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gfB.gha.ggi[i2].ggo)) {
                            i = this.gfB.gha.ggi[i2].ggp;
                        }
                    }
                } else {
                    i = 0;
                }
                this.gfM.a(((this.gfL.fY(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bOn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOk() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bMX;
        com.baidu.tieba.ala.alaar.makeup.c bMR;
        if (this.gfM != null && com.baidu.tieba.ala.alaar.makeup.g.bMU().bMV() && (bMX = com.baidu.tieba.ala.alaar.makeup.g.bMU().bMX()) != null && bMX.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bMX.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bMX.get(i2);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bMR = dVar.bMR()) != null && bMR.bMG() < bMR.bMF()) {
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bMR.getTypeName());
                        aVar.setValue(bMR.bMI());
                        aVar.setResPath(bMR.bMK());
                        this.gfM.a(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOl() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bMX = com.baidu.tieba.ala.alaar.makeup.g.bMU().bMX();
        if (this.gfM != null && bMX != null && bMX.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bMX.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bMX.get(i2);
                    if (dVar == null || !"makeupClose".equals(dVar.getTypeName())) {
                        i = i2 + 1;
                    } else {
                        com.baidu.tieba.ala.alaar.makeup.c bMR = dVar.bMR();
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bMR.getTypeName());
                        aVar.setValue(bMR.bMI());
                        aVar.setResPath(bMR.bMK());
                        this.gfM.a(aVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bOm() {
        com.baidu.tieba.ala.alaar.makeup.a.b bNc = this.gfG.bNc();
        if (bNc != null) {
            List<com.baidu.tieba.ala.alaar.makeup.d> data = bNc.getData();
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
        if (this.gfM != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.gfL.aEs);
            this.gfM.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bOn() {
        setThinFace(this.gfL.fX(this.gfL.aEr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Go(String str) {
        this.gfO.setText(str);
        this.gfO.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gfO, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gfO, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gfO, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.gfO, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void Cz() {
        if (this.gfB.gha != null) {
            this.gfB.gha.notifyDataSetChanged();
        }
        if (this.gfA.ghh != null) {
            this.gfA.ghh.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
