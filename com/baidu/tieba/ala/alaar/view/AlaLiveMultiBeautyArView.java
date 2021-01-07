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
/* loaded from: classes11.dex */
public class AlaLiveMultiBeautyArView extends ILiveMultiBeautyView implements View.OnClickListener {
    private static int ds120;
    private static int ds20;
    private static int ds28;
    private static int ds3;
    private static int gyd;
    private x aGe;
    private com.baidu.live.ar.k bFA;
    private BdPageContext brR;
    private final p gxN;
    private final n gxO;
    private final m gxP;
    int gxQ;
    private c.a gxR;
    private final o gxS;
    private int gxT;
    private com.baidu.tieba.ala.alaar.makeup.a.c gxU;
    private final i gxV;
    private k gxW;
    private BdAlertDialog gxX;
    private boolean gxY;
    private com.baidu.live.ar.e gxZ;
    private com.baidu.live.ar.m gya;
    private com.baidu.tieba.ala.alaar.makeup.c gyb;
    private TextView gyc;

    static /* synthetic */ int b(AlaLiveMultiBeautyArView alaLiveMultiBeautyArView) {
        int i = alaLiveMultiBeautyArView.gxT;
        alaLiveMultiBeautyArView.gxT = i + 1;
        return i;
    }

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.gxN = new p();
        this.gxO = new n();
        this.gxP = new m();
        this.gxQ = 0;
        this.gxS = new o();
        this.gxV = new i();
        this.gxW = new k();
        this.gxY = true;
        this.gxZ = com.baidu.live.ar.e.aFN;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxN = new p();
        this.gxO = new n();
        this.gxP = new m();
        this.gxQ = 0;
        this.gxS = new o();
        this.gxV = new i();
        this.gxW = new k();
        this.gxY = true;
        this.gxZ = com.baidu.live.ar.e.aFN;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxN = new p();
        this.gxO = new n();
        this.gxP = new m();
        this.gxQ = 0;
        this.gxS = new o();
        this.gxV = new i();
        this.gxW = new k();
        this.gxY = true;
        this.gxZ = com.baidu.live.ar.e.aFN;
        initViews();
    }

    public void setFilterFileName(String str) {
        this.gxZ.aFz = str;
    }

    public String getFilterFileName() {
        if (TextUtils.isEmpty(this.gxZ.aFz) && this.gxZ.aFA != null) {
            this.gxZ.aFz = com.baidu.tieba.ala.alaar.sticker.a.e.Gn(this.gxZ.aFA.CL());
        }
        return this.gxZ.aFz;
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_beauty_ar_hor_layout, this);
        bTL();
        this.gxT = 0;
        this.gxN.cn(this);
        this.gxN.a(new p.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.tieba.ala.alaar.view.p.a
            public void a(l lVar) {
                if (lVar != AlaLiveMultiBeautyArView.this.gxS) {
                    if (lVar == AlaLiveMultiBeautyArView.this.gxO) {
                        AlaLiveMultiBeautyArView.this.gxO.vf(AlaLiveMultiBeautyArView.this.gxZ.fV(AlaLiveMultiBeautyArView.this.getFilterFileName()));
                        return;
                    } else if (lVar == AlaLiveMultiBeautyArView.this.gxP && AlaLiveMultiBeautyArView.this.gxZ != null) {
                        if (!TextUtils.equals(AlaLiveMultiBeautyArView.this.gxZ.aFB, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            AlaLiveMultiBeautyArView.this.uU(AlaLiveMultiBeautyArView.this.gxZ.fX(AlaLiveMultiBeautyArView.this.gxZ.aFB) + AlaLiveMultiBeautyArView.this.gxQ);
                            AlaLiveMultiBeautyArView.this.gxP.gze.setProcessDiff(AlaLiveMultiBeautyArView.this.gxQ);
                            return;
                        }
                        try {
                            AlaLiveMultiBeautyArView.this.b(AlaLiveMultiBeautyArView.this.gxZ.fW(AlaLiveMultiBeautyArView.this.gxZ.aFE), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gxZ.aFG).intValue());
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                AlaLiveMultiBeautyArView.b(AlaLiveMultiBeautyArView.this);
                if (AlaLiveMultiBeautyArView.this.gxU != null && !AlaLiveMultiBeautyArView.this.gxU.bSK()) {
                    AlaLiveMultiBeautyArView.this.gxU.ml(true);
                }
                if (AlaLiveMultiBeautyArView.this.gxT == 1 && AlaLiveMultiBeautyArView.this.gxS.gzF != null) {
                    AlaLiveMultiBeautyArView.this.gxS.vd(AlaLiveMultiBeautyArView.this.gxS.gzF.getCurrentPosition());
                }
                AlaLiveMultiBeautyArView.this.gxS.mp(false);
            }
        });
        this.gxO.cn(this);
        this.gxO.setTitle(getResources().getString(a.h.ala_live_new_beauty_filter));
        this.gxN.b(this.gxO);
        this.gxO.c(new com.baidu.tieba.ala.alaar.view.a(getContext()));
        this.gxO.a(new l.a<com.baidu.live.ar.i>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.i iVar, boolean z) {
                String Gn;
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.h.beauty_yuantu).equals(iVar.getName())) {
                    com.baidu.minivideo.arface.b.adN();
                    Gn = com.baidu.minivideo.arface.c.adU();
                } else {
                    Gn = com.baidu.tieba.ala.alaar.sticker.a.e.Gn(iVar.CL());
                }
                if (!AlaLiveMultiBeautyArView.this.gxZ.aFz.equals(Gn)) {
                    AlaLiveMultiBeautyArView.this.GB(iVar.getName());
                }
                AlaLiveMultiBeautyArView.this.setFilterFileName(Gn);
                AlaLiveMultiBeautyArView.this.gxZ.aFA = iVar;
                if (AlaLiveMultiBeautyArView.this.gya != null && AlaLiveMultiBeautyArView.this.bFA.CP() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gxZ.a(iVar, AlaLiveMultiBeautyArView.this.bFA.CP().aFl);
                    int fV = AlaLiveMultiBeautyArView.this.gxZ.fV(AlaLiveMultiBeautyArView.this.getFilterFileName());
                    float f = (((fV * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + fV + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gya.onFilterSelected(AlaLiveMultiBeautyArView.this.gxZ.aFA.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
                if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxO) {
                    AlaLiveMultiBeautyArView.this.gxO.vf(AlaLiveMultiBeautyArView.this.gxZ.fV(AlaLiveMultiBeautyArView.this.getFilterFileName()));
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
                AlaLiveMultiBeautyArView.this.gxZ.A(AlaLiveMultiBeautyArView.this.getFilterFileName(), i);
                if (AlaLiveMultiBeautyArView.this.gya != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gxZ.a(AlaLiveMultiBeautyArView.this.gxZ.aFA, AlaLiveMultiBeautyArView.this.bFA.CP().aFl);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gya.onFilterSelected(AlaLiveMultiBeautyArView.this.gxZ.aFA.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gxZ.aFA != null) {
                    try {
                        jSONObject.put("filter_id", AlaLiveMultiBeautyArView.this.gxZ.aFA.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("filterbar_clk", jSONObject);
            }
        });
        this.gxP.cn(this);
        this.gxP.setTitle(getResources().getString(a.h.ala_live_new_beauty_beauty));
        this.gxN.b(this.gxP);
        this.gxP.a(new l.a<c.a>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, c.a aVar, boolean z) {
                if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxP) {
                    if (i == 0) {
                        AlaLiveMultiBeautyArView.this.bTM();
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gxZ.aFB = aVar.gyD;
                    AlaLiveMultiBeautyArView.this.gxP.gzq.GF(aVar.gyD);
                    AlaLiveMultiBeautyArView.this.bTK();
                    if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gxZ.aFB, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxP && z) {
                            AlaLiveMultiBeautyArView.this.a(aVar);
                            return;
                        }
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gxR = aVar;
                    if (aVar != null) {
                        AlaLiveMultiBeautyArView.this.gxQ = aVar.gyE;
                    }
                    AlaLiveMultiBeautyArView.this.uU(AlaLiveMultiBeautyArView.this.gxZ.fX(AlaLiveMultiBeautyArView.this.gxZ.aFB) + AlaLiveMultiBeautyArView.this.gxQ);
                    AlaLiveMultiBeautyArView.this.gxP.gze.setProcessDiff(AlaLiveMultiBeautyArView.this.gxQ);
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
                if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxS) {
                    if (z && AlaLiveMultiBeautyArView.this.gyb != null) {
                        AlaLiveMultiBeautyArView.this.gyb.setValue(i);
                        if (AlaLiveMultiBeautyArView.this.gxZ.aFI != null) {
                            AlaLiveMultiBeautyArView.this.gxZ.aFI.setValue(AlaLiveMultiBeautyArView.this.gyb.bSo());
                            AlaLiveMultiBeautyArView.this.gya.a(AlaLiveMultiBeautyArView.this.gxZ.aFI);
                        }
                    }
                } else if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gxZ.aFB, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.gxZ.dP(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.gxZ.aFE) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.gxZ.aFE)) && com.baidu.live.d.Ba().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.d.Ba().getBoolean("naturalFace", true)) {
                        com.baidu.live.d.Ba().putBoolean("naturalFace", false);
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.gxZ.B(AlaLiveMultiBeautyArView.this.gxZ.aFB, i - AlaLiveMultiBeautyArView.this.gxQ);
                    if (AlaLiveMultiBeautyArView.this.gya != null) {
                        AlaLiveMultiBeautyArView.this.gya.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fU(AlaLiveMultiBeautyArView.this.gxZ.aFB));
                    }
                }
                if (z) {
                    com.baidu.live.d.Ba().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (AlaLiveMultiBeautyArView.this.gxN.gzJ != AlaLiveMultiBeautyArView.this.gxS) {
                    if (AlaLiveMultiBeautyArView.this.gxZ.aFB != null) {
                        String str = null;
                        if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gxZ.aFB, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            if (AlaLiveMultiBeautyArView.this.gxZ.aFH != null) {
                                str = AlaLiveMultiBeautyArView.this.gxZ.aFH.getName();
                            }
                        } else {
                            str = AlaLiveMultiBeautyArView.this.gxR.gyC;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (AlaLiveMultiBeautyArView.this.gxR != null && str != null) {
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
                if (AlaLiveMultiBeautyArView.this.gyb != null) {
                    try {
                        jSONObject2.put("makeup_id", AlaLiveMultiBeautyArView.this.gyb.getId());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("makeupbar_clk", jSONObject2);
            }
        });
        this.gxP.gzv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxS) {
                            AlaLiveMultiBeautyArView.this.bTP();
                            break;
                        } else {
                            if (AlaLiveMultiBeautyArView.this.gya != null) {
                                AlaLiveMultiBeautyArView.this.gya.CT();
                            }
                            AlaLiveMultiBeautyArView.this.setThinFace(0);
                            break;
                        }
                    case 1:
                    case 3:
                    case 4:
                        if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxS) {
                            AlaLiveMultiBeautyArView.this.bTO();
                            break;
                        } else {
                            AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                            break;
                        }
                }
                return true;
            }
        });
        this.gxS.cn(this);
        this.gxS.ve(0);
        this.gxS.setTitle(getResources().getString(a.h.ala_live_new_beauty_makeup));
        this.gxN.b(this.gxS);
        this.gxS.a(new l.a<com.baidu.tieba.ala.alaar.makeup.d>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemSelected pos= " + i + ", name=" + dVar.bSi());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bSw = dVar.bSw();
                if (dVar.aCQ() || bSw == null || bSw.isEmpty()) {
                    AlaLiveMultiBeautyArView.this.b(i, dVar, (com.baidu.tieba.ala.alaar.makeup.d) null);
                } else if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxS) {
                    AlaLiveMultiBeautyArView.this.a(dVar);
                }
                if (AlaLiveMultiBeautyArView.this.gxU != null) {
                    AlaLiveMultiBeautyArView.this.gxU.setPosition(i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemClick pos= " + i + ", name=" + dVar.bSi());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bSw = dVar.bSw();
                if (dVar.aCQ() || bSw == null || bSw.isEmpty()) {
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
        if (this.gxU != null) {
            this.gxS.setPosition(this.gxU.getPosition());
        }
        com.baidu.tieba.ala.alaar.makeup.g.bSA().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.tieba.ala.alaar.makeup.a.b
            public void c(com.baidu.tieba.ala.alaar.makeup.a aVar) {
                com.baidu.tieba.ala.alaar.makeup.a.c bSC = com.baidu.tieba.ala.alaar.makeup.g.bSA().bSC();
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("BeautyAr", "makeupdata onDataLoaded size: " + (AlaLiveMultiBeautyArView.this.gxU == null ? "null" : Integer.valueOf(AlaLiveMultiBeautyArView.this.gxU.size())));
                }
                AlaLiveMultiBeautyArView.this.setMakeupData(bSC);
            }
        });
        this.gxW.cn(this);
        this.gxW.a(new j.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.j.a
            public void a(k kVar, View view) {
                AlaLiveMultiBeautyArView.this.J(false, true);
            }
        });
        findViewById(a.f.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveMultiBeautyArView.this.bTJ();
            }
        });
        this.gyc = (TextView) findViewById(a.f.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bTK();
            }
        }, 1000L);
        String string = com.baidu.live.d.Ba().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
        this.gxN.c(this.gxP);
        this.gxN.show(false);
    }

    private boolean isShow() {
        ViewParent parent = getParent();
        return parent != null && (parent instanceof ViewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTJ() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        CR();
        if (this.gya != null) {
            this.gya.onClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar) {
        this.gxV.gzc = dVar;
        this.gxV.a(new l.a<com.baidu.tieba.ala.alaar.makeup.c>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
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
                if (AlaLiveMultiBeautyArView.this.gyb != null) {
                    try {
                        jSONObject.put("makeup_id", AlaLiveMultiBeautyArView.this.gyb.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("makeupbar_clk", jSONObject);
            }
        });
        this.gxV.a(dVar, this);
        this.gxV.setTitle(dVar.bSi());
        J(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        this.gxV.gzc = aVar;
        this.gxV.cm(this);
        this.gxV.setTitle(aVar.gyC);
        this.gxV.a(new l.a<com.baidu.live.ar.h>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.h hVar, boolean z) {
                AlaLiveMultiBeautyArView.this.gxZ.aFE = hVar.getType();
                AlaLiveMultiBeautyArView.this.gxZ.aFF = hVar.CN();
                AlaLiveMultiBeautyArView.this.gxZ.aFG = hVar.CM();
                AlaLiveMultiBeautyArView.this.gxZ.aFH = hVar;
                String GG = AlaLiveMultiBeautyArView.this.gxV.gyS.GG(hVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.Go(hVar.CL())) {
                    GG = com.baidu.tieba.ala.alaar.sticker.a.d.Gr(com.baidu.tieba.ala.alaar.sticker.a.d.Gn(hVar.CL()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, GG));
                AlaLiveMultiBeautyArView.this.gxP.gze.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.b(AlaLiveMultiBeautyArView.this.gxZ.fW(AlaLiveMultiBeautyArView.this.gxZ.aFE), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gxZ.aFG).intValue());
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
                if (AlaLiveMultiBeautyArView.this.gxZ.aFB != null) {
                    String str = null;
                    try {
                        if (AlaLiveMultiBeautyArView.this.gxZ.aFH != null) {
                            str = AlaLiveMultiBeautyArView.this.gxZ.aFH.getName();
                        }
                        jSONObject.put("beauty_name", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("beautybar_clk", jSONObject);
            }
        });
        if (this.bFA != null && this.bFA.CP() != null && this.bFA.CP().aFm != null) {
            this.gxZ.b(false, this.bFA.CP().aFm);
            List<com.baidu.live.ar.h> list = this.bFA.CP().aFm;
            this.gxV.gyS.e(list, this.gxV.gyS.i(list, this.gxZ.aFE));
            this.gxV.gyS.notifyDataSetChanged();
            if (TextUtils.equals(this.gxZ.aFB, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.gxZ.aFG)) {
                        i = Integer.valueOf(this.gxZ.aFG).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                b(this.gxZ.fW(this.gxZ.aFE), false, i);
            }
        }
        J(true, true);
        bTN();
        this.gxW.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeupData(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        boolean z = true;
        this.gxU = cVar;
        if (cVar != null && cVar.bSI() != null && cVar.CJ()) {
            bTO();
            this.gxS.setEnable(true);
            this.gxS.gzF.setData(cVar.bSI().getData());
            if (this.gxU != null) {
                this.gxS.setPosition(this.gxU.getPosition());
            }
            o oVar = this.gxS;
            if (!cVar.bSJ() || cVar.bSK()) {
                z = false;
            }
            oVar.mp(z);
            return;
        }
        this.gxS.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTK() {
        if (com.baidu.live.d.Ba().getInt("beauty_tab_redot", 0) != 1) {
            this.gxP.mp(false);
        } else if (com.baidu.live.d.Ba().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.d.Ba().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.d.Ba().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.d.Ba().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.gxP.gzq.bTT()) {
            this.gxP.mp(true);
        } else {
            this.gxP.mp(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements h.a {
        com.baidu.tieba.ala.alaar.makeup.c gyg;
        com.baidu.tieba.ala.alaar.makeup.d gyh;
        int pos;

        public a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
            this.pos = i;
            this.gyg = cVar;
            this.gyh = dVar;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void J(Object obj) {
            if (this.gyh != null && AlaLiveMultiBeautyArView.this.gxV != null && AlaLiveMultiBeautyArView.this.gxV.gzc == this.gyh) {
                AlaLiveMultiBeautyArView.this.gxV.gyR.notifyDataSetChanged();
            } else if (this.gyg instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gxS.gzF.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aF(Object obj) {
            if (this.gyh != null && AlaLiveMultiBeautyArView.this.gxV != null && AlaLiveMultiBeautyArView.this.gxV.gzc == this.gyh) {
                AlaLiveMultiBeautyArView.this.gxV.gyR.vc(this.pos);
                AlaLiveMultiBeautyArView.this.gxV.gyR.notifyDataSetChanged();
            } else if (this.gyh != null && this.pos == this.gyh.gtT) {
                AlaLiveMultiBeautyArView.this.b(this.pos, this.gyg, this.gyh);
            } else if (this.gyg instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gxS.gzF.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void a(Object obj, int i, int i2, String str) {
            if (this.gyh != null && AlaLiveMultiBeautyArView.this.gxV != null && AlaLiveMultiBeautyArView.this.gxV.gzc == this.gyh) {
                AlaLiveMultiBeautyArView.this.gxV.gyR.notifyDataSetChanged();
            } else if (this.gyg instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gxS.gzF.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
        if (dVar != null) {
            dVar.gtT = i;
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
        this.gyb = cVar;
        if ("makeupClose".equals(cVar.getTypeName())) {
            bTQ();
        }
        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
        aVar.setResPath(cVar.bSq());
        aVar.setType(cVar.getType().name());
        aVar.setValue(cVar.bSo());
        this.gxZ.aFI = aVar;
        if (this.gya != null) {
            this.gya.a(aVar);
        }
        if (this.gxN.gzJ == this.gxS) {
            boolean z = cVar.bSl() > cVar.bSm();
            this.gxP.mq(z);
            if (z) {
                try {
                    this.gxP.gze.setProcessDiff(0);
                    this.gxS.D(cVar.bSm(), cVar.bSl(), cVar.bSn(), cVar.getValue());
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void CR() {
        if (this.gxZ != null) {
            com.baidu.live.d.Ba().putString("ala_beauty_config_ar", this.gxZ.toJsonString());
            com.baidu.tieba.ala.alaar.makeup.g.bSA().bSF();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.k kVar) {
        this.bFA = kVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.brR = bdPageContext;
        gyd = BdUtilHelper.getScreenSize(this.brR.getPageActivity()).widthPixels;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(x xVar) {
        this.aGe = xVar;
    }

    private com.baidu.live.ar.h getCurThinFace() {
        com.baidu.live.ar.h hVar = null;
        if (TextUtils.isEmpty(this.gxZ.aFE) || this.bFA == null || this.bFA.CP() == null || this.bFA.CP().aFm == null) {
            return null;
        }
        List<com.baidu.live.ar.h> list = this.bFA.CP().aFm;
        int i = 0;
        while (i < list.size()) {
            com.baidu.live.ar.h hVar2 = list.get(i);
            if (TextUtils.equals(this.gxZ.aFE, hVar2.getType())) {
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
        com.baidu.tieba.ala.alaar.makeup.c bSx;
        int fX;
        JSONArray jSONArray = new JSONArray();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            String str = null;
            if (TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                com.baidu.live.ar.h curThinFace = getCurThinFace();
                if (curThinFace != null && !TextUtils.isEmpty(curThinFace.getName())) {
                    str = curThinFace.getName();
                    fX = this.gxZ.fW(this.gxZ.aFE);
                }
                fX = 0;
            } else {
                if (this.gxP.gzq != null) {
                    for (int i = 0; i < this.gxP.gzq.gyw.length; i++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gxP.gzq.gyw[i].gyD)) {
                            c.a aVar = this.gxP.gzq.gyw[i];
                            int i2 = aVar.gyE;
                            str = aVar.gyC;
                            fX = this.gxZ.fX(beautyAdjustKey.getJsonKey()) + i2;
                            break;
                        }
                    }
                }
                fX = 0;
            }
            if (fX != 0 && str != null) {
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
        if (this.gxZ.aFA != null) {
            try {
                jSONObject2.put("filter_id", this.gxZ.aFA.getId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        s("filter_suc", jSONObject2);
        if (com.baidu.tieba.ala.alaar.makeup.g.bSA().bSB()) {
            JSONArray jSONArray2 = new JSONArray();
            List<com.baidu.tieba.ala.alaar.makeup.d> bSD = com.baidu.tieba.ala.alaar.makeup.g.bSA().bSD();
            if (bSD != null && bSD.size() > 0) {
                for (int i3 = 0; i3 < bSD.size(); i3++) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bSD.get(i3);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bSx = dVar.bSx()) != null && bSx.bSm() < bSx.bSl()) {
                        jSONArray2.put(bSx.getId());
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
    public void uU(int i) {
        b(i, true, 0);
    }

    public void b(int i, boolean z, int i2) {
        if (z) {
            i2 = com.baidu.live.ar.e.aFM.fX(this.gxZ.aFB) + this.gxQ;
        }
        L(100, i, i2);
    }

    public void L(int i, int i2, int i3) {
        this.gxP.gze.setMax(i);
        if (Build.VERSION.SDK_INT >= 24) {
            this.gxP.gze.setProgress(i2, true);
        } else {
            this.gxP.gze.setProgress(i2);
        }
        this.gxP.gze.setDefThumbPos(i3);
    }

    @Deprecated
    private static void bTL() {
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
            int i7 = iArr[0] - ((gyd - ds120) / 2);
            int i8 = z ? ((i - 1) * (ds120 + ds20)) + ds28 + ds3 + ds20 : ((ds120 + ds20) * i) + ds28;
            int i9 = ((i4 - i) - 1) * (ds120 + ds20);
            if ((gyd - ds120) / 2 > i8) {
                return (((gyd - ds120) / 2) - i8) + i7;
            }
            return (gyd - ds120) / 2 > i9 ? i7 - (((gyd - ds120) / 2) - i9) : i7;
        }
        return i5;
    }

    public static int bC(int i, int i2) {
        return Math.max(0, Math.min((i - ds120) >> 1, ((ds120 + ds20) * i2) + ds28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTM() {
        if (this.gxX != null) {
            this.gxX.dismiss();
            this.gxX = null;
        }
        String string = getContext().getString(a.h.ar_beauty_is_reset);
        this.gxX = new BdAlertDialog((Activity) getContext());
        this.gxX.setAutoNight(false);
        this.gxX.setMessage(string);
        this.gxX.setPositiveButton(getContext().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.CS();
                AlaLiveMultiBeautyArView.this.If();
            }
        });
        this.gxX.setNegativeButton(getContext().getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.If();
            }
        });
        this.gxX.setCancelable(false);
        this.gxX.setCanceledOnTouchOutside(false);
        this.gxX.setTitleShowCenter(true);
        this.gxX.setMessageShowCenter(true);
        this.gxX.isShowTitleAndMessage();
        this.gxX.create(this.brR);
        this.gxX.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CS() {
        if (this.gya != null) {
            this.gya.CS();
        }
        bTR();
        String str = this.gxZ.aFE;
        String str2 = this.gxZ.aFF;
        String str3 = this.gxZ.aFG;
        String str4 = com.baidu.live.ar.e.aFN.aFB;
        com.baidu.live.ar.e.aFN.r(com.baidu.live.ar.e.aFM.toJsonString(), true);
        com.baidu.live.ar.e.aFN.aFB = str4;
        com.baidu.live.ar.e.aFN.aFE = str;
        com.baidu.live.ar.e.aFN.aFF = str2;
        com.baidu.live.ar.e.aFN.aFG = str3;
        this.gxZ = com.baidu.live.ar.e.aFN;
        if (this.bFA != null && this.bFA.CP() != null && this.bFA.CP().aFm != null) {
            this.gxZ.b(true, this.bFA.CP().aFm);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fW = this.gxZ.fW(str);
            this.gxP.gze.setProcessDiff(0);
            b(fW, false, fW);
            return;
        }
        uU(this.gxZ.fX(this.gxZ.aFB) + this.gxQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If() {
        if (this.gxX != null) {
            this.gxX.dismiss();
            this.gxX = null;
        }
        this.gxX = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gxY) {
            this.gxY = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && isShow()) {
            bTJ();
            return true;
        }
        return false;
    }

    private void bTN() {
        if (!TextUtils.isEmpty(this.gxZ.aFE)) {
            if (TextUtils.isEmpty(this.gxZ.aFG)) {
                uU(this.gxZ.fW(this.gxZ.aFE));
                return;
            }
            try {
                this.gxP.gze.setProcessDiff(0);
                b(this.gxZ.fW(this.gxZ.aFE), false, Integer.valueOf(this.gxZ.aFG).intValue());
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
        if (this.gxP != null && this.gxP.isEnable()) {
            Gz("beautytab_show");
        }
        if (this.gxS != null && this.gxS.isEnable()) {
            Gz("makeuptab_show");
        }
        if (this.gxO != null && this.gxO.isEnable()) {
            Gz("filtertab_show");
        }
    }

    private void Gz(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "beauty");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int i = 0;
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            i = this.aGe.mLiveInfo.live_status;
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
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            i = this.aGe.mLiveInfo.live_status;
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
            this.gxN.dismiss(z2);
            if (this.gxV != null) {
                this.gxW.setTitle(this.gxV.getTitle());
            }
            this.gxW.show(z2);
            return;
        }
        if (this.gxN.gzJ == this.gxS) {
            this.gxP.mq(false);
        }
        this.gxW.dismiss(z2);
        this.gxN.show(z2);
        bTK();
        if (!this.gxP.gzq.bTT()) {
            this.gxP.gzq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.m mVar) {
        this.gya = mVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.e.aFN.r(com.baidu.live.d.Ba().getString("ala_beauty_config_ar", ""), false);
        if (TextUtils.isEmpty(com.baidu.live.ar.e.aFN.aFz) && com.baidu.minivideo.arface.b.adN() != null) {
            com.baidu.live.ar.e eVar = com.baidu.live.ar.e.aFN;
            com.baidu.minivideo.arface.b.adN();
            eVar.aFz = com.baidu.minivideo.arface.c.adU();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.j.aGb)) {
            com.baidu.minivideo.arface.b.adN();
            com.baidu.live.ar.j.fZ(com.baidu.minivideo.arface.c.adU());
        }
        this.gxZ = com.baidu.live.ar.e.aFN;
        setBeautyAdjustUserData2AR(false);
        bTO();
        if (this.gxN.gzJ == this.gxP && !TextUtils.equals(this.gxZ.aFB, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            uU(this.gxZ.fX(this.gxZ.aFB) + this.gxQ);
        }
        this.gxP.gzq.GC(this.gxZ.aFB);
        this.gxP.gzq.notifyDataSetChanged();
        if (this.bFA != null && this.bFA.CP() != null && this.bFA.CP().aFl != null) {
            this.gxO.gzx.setDatas(this.bFA.CP().aFl);
            if (!TextUtils.isEmpty(getFilterFileName())) {
                this.gxO.gzx.setSelect(h(this.bFA.CP().aFl, getFilterFileName()));
            }
        }
        this.gxO.gzx.notifyDataSetChanged();
    }

    public int h(List<com.baidu.live.ar.i> list, String str) {
        String Gn;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getContext().getString(a.h.beauty_yuantu).equals(list.get(i2).getName())) {
                com.baidu.minivideo.arface.b.adN();
                Gn = com.baidu.minivideo.arface.c.adU();
                i = i2;
            } else {
                Gn = com.baidu.tieba.ala.alaar.sticker.a.e.Gn(list.get(i2).CL());
            }
            if (str.equals(Gn)) {
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
        if (this.gya != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.gxP.gzq != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.gxP.gzq.gyw.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gxP.gzq.gyw[i2].gyD)) {
                            i = this.gxP.gzq.gyw[i2].gyE;
                        }
                    }
                } else {
                    i = 0;
                }
                this.gya.a(((this.gxZ.fX(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bTR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTO() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bSD;
        com.baidu.tieba.ala.alaar.makeup.c bSx;
        if (this.gya != null && com.baidu.tieba.ala.alaar.makeup.g.bSA().bSB() && (bSD = com.baidu.tieba.ala.alaar.makeup.g.bSA().bSD()) != null && bSD.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bSD.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bSD.get(i2);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bSx = dVar.bSx()) != null && bSx.bSm() < bSx.bSl()) {
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bSx.getTypeName());
                        aVar.setValue(bSx.bSo());
                        aVar.setResPath(bSx.bSq());
                        this.gya.a(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTP() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bSD = com.baidu.tieba.ala.alaar.makeup.g.bSA().bSD();
        if (this.gya != null && bSD != null && bSD.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bSD.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bSD.get(i2);
                    if (dVar == null || !"makeupClose".equals(dVar.getTypeName())) {
                        i = i2 + 1;
                    } else {
                        com.baidu.tieba.ala.alaar.makeup.c bSx = dVar.bSx();
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bSx.getTypeName());
                        aVar.setValue(bSx.bSo());
                        aVar.setResPath(bSx.bSq());
                        this.gya.a(aVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bTQ() {
        com.baidu.tieba.ala.alaar.makeup.a.b bSI = this.gxU.bSI();
        if (bSI != null) {
            List<com.baidu.tieba.ala.alaar.makeup.d> data = bSI.getData();
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
        if (this.gya != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.gxZ.aFF);
            this.gya.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bTR() {
        setThinFace(this.gxZ.fW(this.gxZ.aFE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GB(String str) {
        this.gyc.setText(str);
        this.gyc.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gyc, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gyc, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gyc, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.gyc, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void CQ() {
        if (this.gxP.gzq != null) {
            this.gxP.gzq.notifyDataSetChanged();
        }
        if (this.gxO.gzx != null) {
            this.gxO.gzx.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
