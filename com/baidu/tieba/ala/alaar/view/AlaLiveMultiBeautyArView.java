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
import com.baidu.live.data.ab;
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
    private static int gyd;
    private ab aED;
    private com.baidu.live.ar.k bFU;
    private BdPageContext bsg;
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
        this.gxZ = com.baidu.live.ar.e.aEf;
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
        this.gxZ = com.baidu.live.ar.e.aEf;
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
        this.gxZ = com.baidu.live.ar.e.aEf;
        initViews();
    }

    public void setFilterFileName(String str) {
        this.gxZ.aDR = str;
    }

    public String getFilterFileName() {
        if (TextUtils.isEmpty(this.gxZ.aDR) && this.gxZ.aDS != null) {
            this.gxZ.aDR = com.baidu.tieba.ala.alaar.sticker.a.e.FK(this.gxZ.aDS.zA());
        }
        return this.gxZ.aDR;
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_beauty_ar_hor_layout, this);
        bQK();
        this.gxT = 0;
        this.gxN.cj(this);
        this.gxN.a(new p.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.tieba.ala.alaar.view.p.a
            public void a(l lVar) {
                if (lVar != AlaLiveMultiBeautyArView.this.gxS) {
                    if (lVar == AlaLiveMultiBeautyArView.this.gxO) {
                        AlaLiveMultiBeautyArView.this.gxO.tH(AlaLiveMultiBeautyArView.this.gxZ.fi(AlaLiveMultiBeautyArView.this.getFilterFileName()));
                        return;
                    } else if (lVar == AlaLiveMultiBeautyArView.this.gxP && AlaLiveMultiBeautyArView.this.gxZ != null) {
                        if (!TextUtils.equals(AlaLiveMultiBeautyArView.this.gxZ.aDT, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            AlaLiveMultiBeautyArView.this.tw(AlaLiveMultiBeautyArView.this.gxZ.fk(AlaLiveMultiBeautyArView.this.gxZ.aDT) + AlaLiveMultiBeautyArView.this.gxQ);
                            AlaLiveMultiBeautyArView.this.gxP.gze.setProcessDiff(AlaLiveMultiBeautyArView.this.gxQ);
                            return;
                        }
                        try {
                            AlaLiveMultiBeautyArView.this.c(AlaLiveMultiBeautyArView.this.gxZ.fj(AlaLiveMultiBeautyArView.this.gxZ.aDW), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gxZ.aDY).intValue());
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                AlaLiveMultiBeautyArView.b(AlaLiveMultiBeautyArView.this);
                if (AlaLiveMultiBeautyArView.this.gxU != null && !AlaLiveMultiBeautyArView.this.gxU.bPJ()) {
                    AlaLiveMultiBeautyArView.this.gxU.ml(true);
                }
                if (AlaLiveMultiBeautyArView.this.gxT == 1 && AlaLiveMultiBeautyArView.this.gxS.gzF != null) {
                    AlaLiveMultiBeautyArView.this.gxS.tF(AlaLiveMultiBeautyArView.this.gxS.gzF.getCurrentPosition());
                }
                AlaLiveMultiBeautyArView.this.gxS.mp(false);
            }
        });
        this.gxO.cj(this);
        this.gxO.setTitle(getResources().getString(a.h.ala_live_new_beauty_filter));
        this.gxN.b(this.gxO);
        this.gxO.c(new com.baidu.tieba.ala.alaar.view.a(getContext()));
        this.gxO.a(new l.a<com.baidu.live.ar.i>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.i iVar, boolean z) {
                String FK;
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.h.beauty_yuantu).equals(iVar.getName())) {
                    com.baidu.minivideo.arface.b.abL();
                    FK = com.baidu.minivideo.arface.c.abS();
                } else {
                    FK = com.baidu.tieba.ala.alaar.sticker.a.e.FK(iVar.zA());
                }
                if (!AlaLiveMultiBeautyArView.this.gxZ.aDR.equals(FK)) {
                    AlaLiveMultiBeautyArView.this.FY(iVar.getName());
                }
                AlaLiveMultiBeautyArView.this.setFilterFileName(FK);
                AlaLiveMultiBeautyArView.this.gxZ.aDS = iVar;
                if (AlaLiveMultiBeautyArView.this.gya != null && AlaLiveMultiBeautyArView.this.bFU.zE() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gxZ.a(iVar, AlaLiveMultiBeautyArView.this.bFU.zE().aDD);
                    int fi = AlaLiveMultiBeautyArView.this.gxZ.fi(AlaLiveMultiBeautyArView.this.getFilterFileName());
                    float f = (((fi * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + fi + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gya.onFilterSelected(AlaLiveMultiBeautyArView.this.gxZ.aDS.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
                if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxO) {
                    AlaLiveMultiBeautyArView.this.gxO.tH(AlaLiveMultiBeautyArView.this.gxZ.fi(AlaLiveMultiBeautyArView.this.getFilterFileName()));
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
                    int a2 = AlaLiveMultiBeautyArView.this.gxZ.a(AlaLiveMultiBeautyArView.this.gxZ.aDS, AlaLiveMultiBeautyArView.this.bFU.zE().aDD);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gya.onFilterSelected(AlaLiveMultiBeautyArView.this.gxZ.aDS.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gxZ.aDS != null) {
                    try {
                        jSONObject.put("filter_id", AlaLiveMultiBeautyArView.this.gxZ.aDS.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.s("filterbar_clk", jSONObject);
            }
        });
        this.gxP.cj(this);
        this.gxP.setTitle(getResources().getString(a.h.ala_live_new_beauty_beauty));
        this.gxN.b(this.gxP);
        this.gxP.a(new l.a<c.a>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, c.a aVar, boolean z) {
                if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxP) {
                    if (i == 0) {
                        AlaLiveMultiBeautyArView.this.bQL();
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gxZ.aDT = aVar.gyD;
                    AlaLiveMultiBeautyArView.this.gxP.gzq.Gc(aVar.gyD);
                    AlaLiveMultiBeautyArView.this.bQJ();
                    if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gxZ.aDT, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
                    AlaLiveMultiBeautyArView.this.tw(AlaLiveMultiBeautyArView.this.gxZ.fk(AlaLiveMultiBeautyArView.this.gxZ.aDT) + AlaLiveMultiBeautyArView.this.gxQ);
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
                        if (AlaLiveMultiBeautyArView.this.gxZ.aEa != null) {
                            AlaLiveMultiBeautyArView.this.gxZ.aEa.setValue(AlaLiveMultiBeautyArView.this.gyb.bPn());
                            AlaLiveMultiBeautyArView.this.gya.a(AlaLiveMultiBeautyArView.this.gxZ.aEa);
                        }
                    }
                } else if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gxZ.aDT, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.gxZ.cn(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.gxZ.aDW) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.gxZ.aDW)) && com.baidu.live.d.xf().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.d.xf().getBoolean("naturalFace", true)) {
                        com.baidu.live.d.xf().putBoolean("naturalFace", false);
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.gxZ.B(AlaLiveMultiBeautyArView.this.gxZ.aDT, i - AlaLiveMultiBeautyArView.this.gxQ);
                    if (AlaLiveMultiBeautyArView.this.gya != null) {
                        AlaLiveMultiBeautyArView.this.gya.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fh(AlaLiveMultiBeautyArView.this.gxZ.aDT));
                    }
                }
                if (z) {
                    com.baidu.live.d.xf().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (AlaLiveMultiBeautyArView.this.gxN.gzJ != AlaLiveMultiBeautyArView.this.gxS) {
                    if (AlaLiveMultiBeautyArView.this.gxZ.aDT != null) {
                        String str = null;
                        if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gxZ.aDT, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            if (AlaLiveMultiBeautyArView.this.gxZ.aDZ != null) {
                                str = AlaLiveMultiBeautyArView.this.gxZ.aDZ.getName();
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
                        AlaLiveMultiBeautyArView.this.s("beautybar_clk", jSONObject);
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
                AlaLiveMultiBeautyArView.this.s("makeupbar_clk", jSONObject2);
            }
        });
        this.gxP.gzv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxS) {
                            AlaLiveMultiBeautyArView.this.bQO();
                            break;
                        } else {
                            if (AlaLiveMultiBeautyArView.this.gya != null) {
                                AlaLiveMultiBeautyArView.this.gya.zI();
                            }
                            AlaLiveMultiBeautyArView.this.setThinFace(0);
                            break;
                        }
                    case 1:
                    case 3:
                    case 4:
                        if (AlaLiveMultiBeautyArView.this.gxN.gzJ == AlaLiveMultiBeautyArView.this.gxS) {
                            AlaLiveMultiBeautyArView.this.bQN();
                            break;
                        } else {
                            AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                            break;
                        }
                }
                return true;
            }
        });
        this.gxS.cj(this);
        this.gxS.tG(0);
        this.gxS.setTitle(getResources().getString(a.h.ala_live_new_beauty_makeup));
        this.gxN.b(this.gxS);
        this.gxS.a(new l.a<com.baidu.tieba.ala.alaar.makeup.d>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemSelected pos= " + i + ", name=" + dVar.bPh());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bPv = dVar.bPv();
                if (dVar.azx() || bPv == null || bPv.isEmpty()) {
                    AlaLiveMultiBeautyArView.this.b(i, dVar, null);
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
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemClick pos= " + i + ", name=" + dVar.bPh());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bPv = dVar.bPv();
                if (dVar.azx() || bPv == null || bPv.isEmpty()) {
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
        com.baidu.tieba.ala.alaar.makeup.g.bPz().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.tieba.ala.alaar.makeup.a.b
            public void c(com.baidu.tieba.ala.alaar.makeup.a aVar) {
                com.baidu.tieba.ala.alaar.makeup.a.c bPB = com.baidu.tieba.ala.alaar.makeup.g.bPz().bPB();
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("BeautyAr", "makeupdata onDataLoaded size: " + (AlaLiveMultiBeautyArView.this.gxU == null ? "null" : Integer.valueOf(AlaLiveMultiBeautyArView.this.gxU.size())));
                }
                AlaLiveMultiBeautyArView.this.setMakeupData(bPB);
            }
        });
        this.gxW.cj(this);
        this.gxW.a(new j.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.j.a
            public void a(k kVar, View view) {
                AlaLiveMultiBeautyArView.this.J(false, true);
            }
        });
        findViewById(a.f.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveMultiBeautyArView.this.bQI();
            }
        });
        this.gyc = (TextView) findViewById(a.f.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bQJ();
            }
        }, 1000L);
        String string = com.baidu.live.d.xf().getString("beauty_face_feature", "");
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
    public void bQI() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        zG();
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
                AlaLiveMultiBeautyArView.this.s("makeupbar_clk", jSONObject);
            }
        });
        this.gxV.a(dVar, this);
        this.gxV.setTitle(dVar.bPh());
        J(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        this.gxV.gzc = aVar;
        this.gxV.ci(this);
        this.gxV.setTitle(aVar.gyC);
        this.gxV.a(new l.a<com.baidu.live.ar.h>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.h hVar, boolean z) {
                AlaLiveMultiBeautyArView.this.gxZ.aDW = hVar.getType();
                AlaLiveMultiBeautyArView.this.gxZ.aDX = hVar.zC();
                AlaLiveMultiBeautyArView.this.gxZ.aDY = hVar.zB();
                AlaLiveMultiBeautyArView.this.gxZ.aDZ = hVar;
                String Gd = AlaLiveMultiBeautyArView.this.gxV.gyS.Gd(hVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.FL(hVar.zA())) {
                    Gd = com.baidu.tieba.ala.alaar.sticker.a.d.FO(com.baidu.tieba.ala.alaar.sticker.a.d.FK(hVar.zA()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, Gd));
                AlaLiveMultiBeautyArView.this.gxP.gze.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.c(AlaLiveMultiBeautyArView.this.gxZ.fj(AlaLiveMultiBeautyArView.this.gxZ.aDW), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gxZ.aDY).intValue());
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
                if (AlaLiveMultiBeautyArView.this.gxZ.aDT != null) {
                    String str = null;
                    try {
                        if (AlaLiveMultiBeautyArView.this.gxZ.aDZ != null) {
                            str = AlaLiveMultiBeautyArView.this.gxZ.aDZ.getName();
                        }
                        jSONObject.put("beauty_name", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.s("beautybar_clk", jSONObject);
            }
        });
        if (this.bFU != null && this.bFU.zE() != null && this.bFU.zE().aDE != null) {
            this.gxZ.c(false, this.bFU.zE().aDE);
            List<com.baidu.live.ar.h> list = this.bFU.zE().aDE;
            this.gxV.gyS.e(list, this.gxV.gyS.h(list, this.gxZ.aDW));
            this.gxV.gyS.notifyDataSetChanged();
            if (TextUtils.equals(this.gxZ.aDT, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.gxZ.aDY)) {
                        i = Integer.valueOf(this.gxZ.aDY).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                c(this.gxZ.fj(this.gxZ.aDW), false, i);
            }
        }
        J(true, true);
        bQM();
        this.gxW.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeupData(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        boolean z = true;
        this.gxU = cVar;
        if (cVar != null && cVar.bPH() != null && cVar.zy()) {
            bQN();
            this.gxS.setEnable(true);
            this.gxS.gzF.setData(cVar.bPH().getData());
            if (this.gxU != null) {
                this.gxS.setPosition(this.gxU.getPosition());
            }
            o oVar = this.gxS;
            if (!cVar.bPI() || cVar.bPJ()) {
                z = false;
            }
            oVar.mp(z);
            return;
        }
        this.gxS.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQJ() {
        if (com.baidu.live.d.xf().getInt("beauty_tab_redot", 0) != 1) {
            this.gxP.mp(false);
        } else if (com.baidu.live.d.xf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.d.xf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.d.xf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.d.xf().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.gxP.gzq.bQS()) {
            this.gxP.mp(true);
        } else {
            this.gxP.mp(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
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
        public void L(Object obj) {
            if (this.gyh != null && AlaLiveMultiBeautyArView.this.gxV != null && AlaLiveMultiBeautyArView.this.gxV.gzc == this.gyh) {
                AlaLiveMultiBeautyArView.this.gxV.gyR.notifyDataSetChanged();
            } else if (this.gyg instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gxS.gzF.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aH(Object obj) {
            if (this.gyh != null && AlaLiveMultiBeautyArView.this.gxV != null && AlaLiveMultiBeautyArView.this.gxV.gzc == this.gyh) {
                AlaLiveMultiBeautyArView.this.gxV.gyR.tE(this.pos);
                AlaLiveMultiBeautyArView.this.gxV.gyR.notifyDataSetChanged();
            } else if (this.gyh != null && this.pos == this.gyh.gtS) {
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
            dVar.gtS = i;
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
            bQP();
        }
        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
        aVar.setResPath(cVar.bPp());
        aVar.setType(cVar.getType().name());
        aVar.setValue(cVar.bPn());
        this.gxZ.aEa = aVar;
        if (this.gya != null) {
            this.gya.a(aVar);
        }
        if (this.gxN.gzJ == this.gxS) {
            boolean z = cVar.bPk() > cVar.bPl();
            this.gxP.mq(z);
            if (z) {
                try {
                    this.gxP.gze.setProcessDiff(0);
                    this.gxS.D(cVar.bPl(), cVar.bPk(), cVar.bPm(), cVar.getValue());
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void zG() {
        if (this.gxZ != null) {
            com.baidu.live.d.xf().putString("ala_beauty_config_ar", this.gxZ.toJsonString());
            com.baidu.tieba.ala.alaar.makeup.g.bPz().bPE();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.k kVar) {
        this.bFU = kVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bsg = bdPageContext;
        gyd = BdUtilHelper.getScreenSize(this.bsg.getPageActivity()).widthPixels;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(ab abVar) {
        this.aED = abVar;
    }

    private com.baidu.live.ar.h getCurThinFace() {
        com.baidu.live.ar.h hVar = null;
        if (TextUtils.isEmpty(this.gxZ.aDW) || this.bFU == null || this.bFU.zE() == null || this.bFU.zE().aDE == null) {
            return null;
        }
        List<com.baidu.live.ar.h> list = this.bFU.zE().aDE;
        int i = 0;
        while (i < list.size()) {
            com.baidu.live.ar.h hVar2 = list.get(i);
            if (TextUtils.equals(this.gxZ.aDW, hVar2.getType())) {
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
        com.baidu.tieba.ala.alaar.makeup.c bPw;
        int fk;
        JSONArray jSONArray = new JSONArray();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            String str = null;
            if (TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                com.baidu.live.ar.h curThinFace = getCurThinFace();
                if (curThinFace != null && !TextUtils.isEmpty(curThinFace.getName())) {
                    str = curThinFace.getName();
                    fk = this.gxZ.fj(this.gxZ.aDW);
                }
                fk = 0;
            } else {
                if (this.gxP.gzq != null) {
                    for (int i = 0; i < this.gxP.gzq.gyw.length; i++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gxP.gzq.gyw[i].gyD)) {
                            c.a aVar = this.gxP.gzq.gyw[i];
                            int i2 = aVar.gyE;
                            str = aVar.gyC;
                            fk = this.gxZ.fk(beautyAdjustKey.getJsonKey()) + i2;
                            break;
                        }
                    }
                }
                fk = 0;
            }
            if (fk != 0 && str != null) {
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
        if (this.gxZ.aDS != null) {
            try {
                jSONObject2.put("filter_id", this.gxZ.aDS.getId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        t("filter_suc", jSONObject2);
        if (com.baidu.tieba.ala.alaar.makeup.g.bPz().bPA()) {
            JSONArray jSONArray2 = new JSONArray();
            List<com.baidu.tieba.ala.alaar.makeup.d> bPC = com.baidu.tieba.ala.alaar.makeup.g.bPz().bPC();
            if (bPC != null && bPC.size() > 0) {
                for (int i3 = 0; i3 < bPC.size(); i3++) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bPC.get(i3);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bPw = dVar.bPw()) != null && bPw.bPl() < bPw.bPk()) {
                        jSONArray2.put(bPw.getId());
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
    public void tw(int i) {
        c(i, true, 0);
    }

    public void c(int i, boolean z, int i2) {
        if (z) {
            i2 = com.baidu.live.ar.e.aEe.fk(this.gxZ.aDT) + this.gxQ;
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
    private static void bQK() {
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

    public static int bA(int i, int i2) {
        return Math.max(0, Math.min((i - ds120) >> 1, ((ds120 + ds20) * i2) + ds28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQL() {
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
                AlaLiveMultiBeautyArView.this.zH();
                AlaLiveMultiBeautyArView.this.FD();
            }
        });
        this.gxX.setNegativeButton(getContext().getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.FD();
            }
        });
        this.gxX.setCancelable(false);
        this.gxX.setCanceledOnTouchOutside(false);
        this.gxX.setTitleShowCenter(true);
        this.gxX.setMessageShowCenter(true);
        this.gxX.isShowTitleAndMessage();
        this.gxX.create(this.bsg);
        this.gxX.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zH() {
        if (this.gya != null) {
            this.gya.zH();
        }
        bQQ();
        String str = this.gxZ.aDW;
        String str2 = this.gxZ.aDX;
        String str3 = this.gxZ.aDY;
        String str4 = com.baidu.live.ar.e.aEf.aDT;
        com.baidu.live.ar.e.aEf.r(com.baidu.live.ar.e.aEe.toJsonString(), true);
        com.baidu.live.ar.e.aEf.aDT = str4;
        com.baidu.live.ar.e.aEf.aDW = str;
        com.baidu.live.ar.e.aEf.aDX = str2;
        com.baidu.live.ar.e.aEf.aDY = str3;
        this.gxZ = com.baidu.live.ar.e.aEf;
        if (this.bFU != null && this.bFU.zE() != null && this.bFU.zE().aDE != null) {
            this.gxZ.c(true, this.bFU.zE().aDE);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fj = this.gxZ.fj(str);
            this.gxP.gze.setProcessDiff(0);
            c(fj, false, fj);
            return;
        }
        tw(this.gxZ.fk(this.gxZ.aDT) + this.gxQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
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
            bQI();
            return true;
        }
        return false;
    }

    private void bQM() {
        if (!TextUtils.isEmpty(this.gxZ.aDW)) {
            if (TextUtils.isEmpty(this.gxZ.aDY)) {
                tw(this.gxZ.fj(this.gxZ.aDW));
                return;
            }
            try {
                this.gxP.gze.setProcessDiff(0);
                c(this.gxZ.fj(this.gxZ.aDW), false, Integer.valueOf(this.gxZ.aDY).intValue());
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
            FW("beautytab_show");
        }
        if (this.gxS != null && this.gxS.isEnable()) {
            FW("makeuptab_show");
        }
        if (this.gxO != null && this.gxO.isEnable()) {
            FW("filtertab_show");
        }
    }

    private void FW(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "beauty");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int i = 0;
        if (this.aED != null && this.aED.mLiveInfo != null) {
            i = this.aED.mLiveInfo.live_status;
        }
        if (i != 1) {
            str2 = UbcStatConstant.Page.LIVE_ACTION;
        } else {
            str2 = "author_liveroom";
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
        if (this.aED != null && this.aED.mLiveInfo != null) {
            i = this.aED.mLiveInfo.live_status;
        }
        if (i != 1) {
            str2 = UbcStatConstant.Page.LIVE_ACTION;
        } else {
            str2 = "author_liveroom";
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
        bQJ();
        if (!this.gxP.gzq.bQS()) {
            this.gxP.gzq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.m mVar) {
        this.gya = mVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.e.aEf.r(com.baidu.live.d.xf().getString("ala_beauty_config_ar", ""), false);
        if (TextUtils.isEmpty(com.baidu.live.ar.e.aEf.aDR) && com.baidu.minivideo.arface.b.abL() != null) {
            com.baidu.live.ar.e eVar = com.baidu.live.ar.e.aEf;
            com.baidu.minivideo.arface.b.abL();
            eVar.aDR = com.baidu.minivideo.arface.c.abS();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.j.aEt)) {
            com.baidu.minivideo.arface.b.abL();
            com.baidu.live.ar.j.fm(com.baidu.minivideo.arface.c.abS());
        }
        this.gxZ = com.baidu.live.ar.e.aEf;
        setBeautyAdjustUserData2AR(false);
        bQN();
        if (this.gxN.gzJ == this.gxP && !TextUtils.equals(this.gxZ.aDT, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            tw(this.gxZ.fk(this.gxZ.aDT) + this.gxQ);
        }
        this.gxP.gzq.FZ(this.gxZ.aDT);
        this.gxP.gzq.notifyDataSetChanged();
        if (this.bFU != null && this.bFU.zE() != null && this.bFU.zE().aDD != null) {
            this.gxO.gzx.setDatas(this.bFU.zE().aDD);
            if (!TextUtils.isEmpty(getFilterFileName())) {
                this.gxO.gzx.setSelect(g(this.bFU.zE().aDD, getFilterFileName()));
            }
        }
        this.gxO.gzx.notifyDataSetChanged();
    }

    public int g(List<com.baidu.live.ar.i> list, String str) {
        String FK;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getContext().getString(a.h.beauty_yuantu).equals(list.get(i2).getName())) {
                com.baidu.minivideo.arface.b.abL();
                FK = com.baidu.minivideo.arface.c.abS();
                i = i2;
            } else {
                FK = com.baidu.tieba.ala.alaar.sticker.a.e.FK(list.get(i2).zA());
            }
            if (str.equals(FK)) {
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
                this.gya.a(((this.gxZ.fk(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bQQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQN() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bPC;
        com.baidu.tieba.ala.alaar.makeup.c bPw;
        if (this.gya != null && com.baidu.tieba.ala.alaar.makeup.g.bPz().bPA() && (bPC = com.baidu.tieba.ala.alaar.makeup.g.bPz().bPC()) != null && bPC.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bPC.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bPC.get(i2);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bPw = dVar.bPw()) != null && bPw.bPl() < bPw.bPk()) {
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bPw.getTypeName());
                        aVar.setValue(bPw.bPn());
                        aVar.setResPath(bPw.bPp());
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
    public void bQO() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bPC = com.baidu.tieba.ala.alaar.makeup.g.bPz().bPC();
        if (this.gya != null && bPC != null && bPC.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bPC.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bPC.get(i2);
                    if (dVar == null || !"makeupClose".equals(dVar.getTypeName())) {
                        i = i2 + 1;
                    } else {
                        com.baidu.tieba.ala.alaar.makeup.c bPw = dVar.bPw();
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bPw.getTypeName());
                        aVar.setValue(bPw.bPn());
                        aVar.setResPath(bPw.bPp());
                        this.gya.a(aVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bQP() {
        com.baidu.tieba.ala.alaar.makeup.a.b bPH = this.gxU.bPH();
        if (bPH != null) {
            List<com.baidu.tieba.ala.alaar.makeup.d> data = bPH.getData();
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
            hashMap.put("thinFace", this.gxZ.aDX);
            this.gya.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bQQ() {
        setThinFace(this.gxZ.fj(this.gxZ.aDW));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FY(String str) {
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
    public void zF() {
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
