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
    private static int fZY;
    private w aEc;
    private BdPageContext blq;
    private final p fZH;
    private final n fZI;
    private final m fZJ;
    int fZK;
    private c.a fZL;
    private final o fZM;
    private int fZN;
    private com.baidu.tieba.ala.alaar.makeup.a.c fZO;
    private final i fZP;
    private k fZQ;
    private BdAlertDialog fZR;
    private com.baidu.live.ar.i fZS;
    private boolean fZT;
    private com.baidu.live.ar.d fZU;
    private com.baidu.live.ar.k fZV;
    private com.baidu.tieba.ala.alaar.makeup.c fZW;
    private TextView fZX;

    static /* synthetic */ int b(AlaLiveMultiBeautyArView alaLiveMultiBeautyArView) {
        int i = alaLiveMultiBeautyArView.fZN;
        alaLiveMultiBeautyArView.fZN = i + 1;
        return i;
    }

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.fZH = new p();
        this.fZI = new n();
        this.fZJ = new m();
        this.fZK = 0;
        this.fZM = new o();
        this.fZP = new i();
        this.fZQ = new k();
        this.fZT = true;
        this.fZU = com.baidu.live.ar.d.aDT;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fZH = new p();
        this.fZI = new n();
        this.fZJ = new m();
        this.fZK = 0;
        this.fZM = new o();
        this.fZP = new i();
        this.fZQ = new k();
        this.fZT = true;
        this.fZU = com.baidu.live.ar.d.aDT;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fZH = new p();
        this.fZI = new n();
        this.fZJ = new m();
        this.fZK = 0;
        this.fZM = new o();
        this.fZP = new i();
        this.fZQ = new k();
        this.fZT = true;
        this.fZU = com.baidu.live.ar.d.aDT;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bLH();
        this.fZN = 0;
        this.fZH.bQ(this);
        this.fZH.a(new p.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.tieba.ala.alaar.view.p.a
            public void a(l lVar) {
                if (lVar != AlaLiveMultiBeautyArView.this.fZM) {
                    if (lVar == AlaLiveMultiBeautyArView.this.fZI) {
                        AlaLiveMultiBeautyArView.this.fZI.tH(AlaLiveMultiBeautyArView.this.fZU.fS(AlaLiveMultiBeautyArView.this.fZU.aDF));
                        return;
                    } else {
                        if (lVar == AlaLiveMultiBeautyArView.this.fZJ) {
                        }
                        return;
                    }
                }
                AlaLiveMultiBeautyArView.b(AlaLiveMultiBeautyArView.this);
                if (AlaLiveMultiBeautyArView.this.fZO != null && !AlaLiveMultiBeautyArView.this.fZO.bKF()) {
                    AlaLiveMultiBeautyArView.this.fZO.lj(true);
                }
                if (AlaLiveMultiBeautyArView.this.fZN == 1 && AlaLiveMultiBeautyArView.this.fZM.gbA != null) {
                    AlaLiveMultiBeautyArView.this.fZM.tF(AlaLiveMultiBeautyArView.this.fZM.gbA.getCurrentPosition());
                }
                AlaLiveMultiBeautyArView.this.fZM.ln(false);
            }
        });
        this.fZI.bQ(this);
        this.fZI.setTitle(getResources().getString(a.i.ala_live_new_beauty_filter));
        this.fZH.b(this.fZI);
        this.fZI.c(new com.baidu.tieba.ala.alaar.view.a(getContext()));
        this.fZI.a(new l.a<com.baidu.live.ar.g>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.g gVar, boolean z) {
                String FL;
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(gVar.getName())) {
                    com.baidu.minivideo.arface.b.XC();
                    FL = com.baidu.minivideo.arface.c.XH();
                } else {
                    FL = com.baidu.tieba.ala.alaar.sticker.a.e.FL(gVar.Cc());
                }
                if (!AlaLiveMultiBeautyArView.this.fZU.aDF.equals(FL)) {
                    AlaLiveMultiBeautyArView.this.Ga(gVar.getName());
                }
                AlaLiveMultiBeautyArView.this.fZU.aDF = FL;
                AlaLiveMultiBeautyArView.this.fZU.aDG = gVar;
                if (AlaLiveMultiBeautyArView.this.fZV != null && AlaLiveMultiBeautyArView.this.fZS.Cg() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.fZU.a(gVar, AlaLiveMultiBeautyArView.this.fZS.Cg().aDr);
                    int fS = AlaLiveMultiBeautyArView.this.fZU.fS(AlaLiveMultiBeautyArView.this.fZU.aDF);
                    float f = (((fS * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + fS + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fZV.onFilterSelected(AlaLiveMultiBeautyArView.this.fZU.aDG.getName(), AlaLiveMultiBeautyArView.this.fZU.aDF, f);
                }
                if (AlaLiveMultiBeautyArView.this.fZH.gbE == AlaLiveMultiBeautyArView.this.fZI) {
                    AlaLiveMultiBeautyArView.this.fZI.tH(AlaLiveMultiBeautyArView.this.fZU.fS(AlaLiveMultiBeautyArView.this.fZU.aDF));
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
                AlaLiveMultiBeautyArView.this.fZU.y(AlaLiveMultiBeautyArView.this.fZU.aDF, i);
                if (AlaLiveMultiBeautyArView.this.fZV != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.fZU.a(AlaLiveMultiBeautyArView.this.fZU.aDG, AlaLiveMultiBeautyArView.this.fZS.Cg().aDr);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.fZV.onFilterSelected(AlaLiveMultiBeautyArView.this.fZU.aDG.getName(), AlaLiveMultiBeautyArView.this.fZU.aDF, f);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.fZU.aDG != null) {
                    try {
                        jSONObject.put("filter_id", AlaLiveMultiBeautyArView.this.fZU.aDG.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("filterbar_clk", jSONObject);
            }
        });
        this.fZJ.bQ(this);
        this.fZJ.setTitle(getResources().getString(a.i.ala_live_new_beauty_beauty));
        this.fZH.b(this.fZJ);
        this.fZJ.a(new l.a<c.a>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, c.a aVar, boolean z) {
                if (AlaLiveMultiBeautyArView.this.fZH.gbE == AlaLiveMultiBeautyArView.this.fZJ) {
                    if (i == 0) {
                        AlaLiveMultiBeautyArView.this.bLI();
                        return;
                    }
                    String str = aVar.gay;
                    AlaLiveMultiBeautyArView.this.fZJ.gbl.Ge(str);
                    AlaLiveMultiBeautyArView.this.bLG();
                    AlaLiveMultiBeautyArView.this.fZU.aDH = str;
                    if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (AlaLiveMultiBeautyArView.this.fZH.gbE == AlaLiveMultiBeautyArView.this.fZJ && z) {
                            AlaLiveMultiBeautyArView.this.a(aVar);
                            return;
                        }
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.fZL = aVar;
                    if (aVar != null) {
                        AlaLiveMultiBeautyArView.this.fZK = aVar.gaz;
                    }
                    AlaLiveMultiBeautyArView.this.tw(AlaLiveMultiBeautyArView.this.fZU.fU(AlaLiveMultiBeautyArView.this.fZU.aDH) + aVar.gaz);
                    AlaLiveMultiBeautyArView.this.fZJ.gaY.setProcessDiff(aVar.gaz);
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
                if (AlaLiveMultiBeautyArView.this.fZH.gbE == AlaLiveMultiBeautyArView.this.fZM) {
                    if (z && AlaLiveMultiBeautyArView.this.fZW != null) {
                        AlaLiveMultiBeautyArView.this.fZW.setValue(i);
                        if (AlaLiveMultiBeautyArView.this.fZU.aDO != null) {
                            AlaLiveMultiBeautyArView.this.fZU.aDO.setValue(AlaLiveMultiBeautyArView.this.fZW.bKj());
                            AlaLiveMultiBeautyArView.this.fZV.a(AlaLiveMultiBeautyArView.this.fZU.aDO);
                        }
                    }
                } else if (TextUtils.equals(AlaLiveMultiBeautyArView.this.fZU.aDH, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.fZU.dD(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.fZU.aDK) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.fZU.aDK)) && com.baidu.live.d.AZ().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.d.AZ().getBoolean("naturalFace", true)) {
                        com.baidu.live.d.AZ().putBoolean("naturalFace", false);
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.fZU.z(AlaLiveMultiBeautyArView.this.fZU.aDH, i - AlaLiveMultiBeautyArView.this.fZK);
                    if (AlaLiveMultiBeautyArView.this.fZV != null) {
                        AlaLiveMultiBeautyArView.this.fZV.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fQ(AlaLiveMultiBeautyArView.this.fZU.aDH));
                    }
                }
                if (z) {
                    com.baidu.live.d.AZ().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (AlaLiveMultiBeautyArView.this.fZH.gbE != AlaLiveMultiBeautyArView.this.fZM) {
                    if (AlaLiveMultiBeautyArView.this.fZU.aDH != null) {
                        String str = null;
                        if (TextUtils.equals(AlaLiveMultiBeautyArView.this.fZU.aDH, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            if (AlaLiveMultiBeautyArView.this.fZU.aDN != null) {
                                str = AlaLiveMultiBeautyArView.this.fZU.aDN.getName();
                            }
                        } else {
                            str = AlaLiveMultiBeautyArView.this.fZL.mShowName;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (AlaLiveMultiBeautyArView.this.fZL != null && str != null) {
                            try {
                                jSONObject.put("beauty_name", str);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        AlaLiveMultiBeautyArView.this.q("beautybar_clk", jSONObject);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.fZW != null) {
                    try {
                        jSONObject2.put("makeup_id", AlaLiveMultiBeautyArView.this.fZW.getId());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("makeupbar_clk", jSONObject2);
            }
        });
        this.fZJ.gbq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.fZH.gbE == AlaLiveMultiBeautyArView.this.fZM) {
                            AlaLiveMultiBeautyArView.this.bLL();
                            break;
                        } else {
                            if (AlaLiveMultiBeautyArView.this.fZV != null) {
                                AlaLiveMultiBeautyArView.this.fZV.Cl();
                            }
                            AlaLiveMultiBeautyArView.this.setThinFace(0);
                            break;
                        }
                    case 1:
                    case 3:
                    case 4:
                        if (AlaLiveMultiBeautyArView.this.fZH.gbE == AlaLiveMultiBeautyArView.this.fZM) {
                            AlaLiveMultiBeautyArView.this.bLK();
                            break;
                        } else {
                            AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                            break;
                        }
                }
                return true;
            }
        });
        this.fZM.bQ(this);
        this.fZM.tG(0);
        this.fZM.setTitle(getResources().getString(a.i.ala_live_new_beauty_makeup));
        this.fZH.b(this.fZM);
        this.fZM.a(new l.a<com.baidu.tieba.ala.alaar.makeup.d>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemSelected pos= " + i + ", name=" + dVar.getName());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bKr = dVar.bKr();
                if (dVar.awx() || bKr == null || bKr.isEmpty()) {
                    AlaLiveMultiBeautyArView.this.b(i, dVar, null);
                } else if (AlaLiveMultiBeautyArView.this.fZH.gbE == AlaLiveMultiBeautyArView.this.fZM) {
                    AlaLiveMultiBeautyArView.this.a(dVar);
                }
                if (AlaLiveMultiBeautyArView.this.fZO != null) {
                    AlaLiveMultiBeautyArView.this.fZO.setPosition(i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemClick pos= " + i + ", name=" + dVar.getName());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bKr = dVar.bKr();
                if (dVar.awx() || bKr == null || bKr.isEmpty()) {
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
        if (this.fZO != null) {
            this.fZM.setPosition(this.fZO.getPosition());
        }
        com.baidu.tieba.ala.alaar.makeup.g.bKv().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.tieba.ala.alaar.makeup.a.b
            public void c(com.baidu.tieba.ala.alaar.makeup.a aVar) {
                com.baidu.tieba.ala.alaar.makeup.a.c bKx = com.baidu.tieba.ala.alaar.makeup.g.bKv().bKx();
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("BeautyAr", "makeupdata onDataLoaded size: " + (AlaLiveMultiBeautyArView.this.fZO == null ? "null" : Integer.valueOf(AlaLiveMultiBeautyArView.this.fZO.size())));
                }
                AlaLiveMultiBeautyArView.this.setMakeupData(bKx);
            }
        });
        this.fZQ.bQ(this);
        this.fZQ.a(new j.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.j.a
            public void a(k kVar, View view) {
                AlaLiveMultiBeautyArView.this.H(false, true);
            }
        });
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.Ci();
                if (AlaLiveMultiBeautyArView.this.fZV != null) {
                    AlaLiveMultiBeautyArView.this.fZV.Cj();
                }
            }
        });
        this.fZX = (TextView) findViewById(a.g.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bLG();
            }
        }, 1000L);
        String string = com.baidu.live.d.AZ().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
        this.fZH.c(this.fZJ);
        this.fZH.show(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar) {
        this.fZP.gaW = dVar;
        this.fZP.a(new l.a<com.baidu.tieba.ala.alaar.makeup.c>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
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
                if (AlaLiveMultiBeautyArView.this.fZW != null) {
                    try {
                        jSONObject.put("makeup_id", AlaLiveMultiBeautyArView.this.fZW.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("makeupbar_clk", jSONObject);
            }
        });
        this.fZP.a(dVar, this);
        this.fZP.setTitle(dVar.getName());
        H(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        this.fZP.gaW = aVar;
        this.fZP.bP(this);
        this.fZP.setTitle(aVar.mShowName);
        this.fZP.a(new l.a<com.baidu.live.ar.f>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.f fVar, boolean z) {
                AlaLiveMultiBeautyArView.this.fZU.aDK = fVar.getType();
                AlaLiveMultiBeautyArView.this.fZU.aDL = fVar.Ce();
                AlaLiveMultiBeautyArView.this.fZU.aDM = fVar.Cd();
                AlaLiveMultiBeautyArView.this.fZU.aDN = fVar;
                String Gg = AlaLiveMultiBeautyArView.this.fZP.gaN.Gg(fVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.FM(fVar.Cc())) {
                    Gg = com.baidu.tieba.ala.alaar.sticker.a.d.FP(com.baidu.tieba.ala.alaar.sticker.a.d.FL(fVar.Cc()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, Gg));
                AlaLiveMultiBeautyArView.this.fZJ.gaY.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.fZU.fT(fVar.getType()), false, Integer.valueOf(fVar.Cd()).intValue());
                } catch (Exception e) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.live.ar.f fVar, boolean z) {
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void a(com.baidu.live.ar.f fVar, SeekBar seekBar, int i, boolean z) {
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.fZU.aDH != null) {
                    String str = null;
                    try {
                        if (AlaLiveMultiBeautyArView.this.fZU.aDN != null) {
                            str = AlaLiveMultiBeautyArView.this.fZU.aDN.getName();
                        }
                        jSONObject.put("beauty_name", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("beautybar_clk", jSONObject);
            }
        });
        if (this.fZS != null && this.fZS.Cg() != null && this.fZS.Cg().aDs != null) {
            this.fZU.a(false, this.fZS.Cg().aDs);
            this.fZP.gaN.e(this.fZS.Cg().aDs, this.fZP.gaN.Gf(this.fZU.aDK));
            this.fZP.gaN.notifyDataSetChanged();
            if (TextUtils.equals(this.fZU.aDH, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.fZU.aDM)) {
                        i = Integer.valueOf(this.fZU.aDM).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                a(this.fZU.fT(this.fZU.aDK), false, i);
            }
        }
        H(true, true);
        bLJ();
        this.fZQ.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeupData(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        boolean z = true;
        this.fZO = cVar;
        if (cVar != null && cVar.bKD() != null && cVar.Ca()) {
            bLK();
            this.fZM.setEnable(true);
            this.fZM.gbA.setData(cVar.bKD().getData());
            if (this.fZO != null) {
                this.fZM.setPosition(this.fZO.getPosition());
            }
            o oVar = this.fZM;
            if (!cVar.bKE() || cVar.bKF()) {
                z = false;
            }
            oVar.ln(z);
            return;
        }
        this.fZM.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLG() {
        if (com.baidu.live.d.AZ().getInt("beauty_tab_redot", 0) != 1) {
            this.fZJ.ln(false);
        } else if (com.baidu.live.d.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.d.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.d.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.d.AZ().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.fZJ.gbl.bLP()) {
            this.fZJ.ln(true);
        } else {
            this.fZJ.ln(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements h.a {
        com.baidu.tieba.ala.alaar.makeup.c gab;
        com.baidu.tieba.ala.alaar.makeup.d gac;
        int pos;

        public a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
            this.pos = i;
            this.gab = cVar;
            this.gac = dVar;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aD(Object obj) {
            if (this.gac != null && AlaLiveMultiBeautyArView.this.fZP != null && AlaLiveMultiBeautyArView.this.fZP.gaW == this.gac) {
                AlaLiveMultiBeautyArView.this.fZP.gaM.notifyDataSetChanged();
            } else if (this.gab instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.fZM.gbA.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aE(Object obj) {
            if (this.gac != null && AlaLiveMultiBeautyArView.this.fZP != null && AlaLiveMultiBeautyArView.this.fZP.gaW == this.gac) {
                AlaLiveMultiBeautyArView.this.fZP.gaM.tE(this.pos);
                AlaLiveMultiBeautyArView.this.fZP.gaM.notifyDataSetChanged();
            } else if (this.gac != null && this.pos == this.gac.fVJ) {
                AlaLiveMultiBeautyArView.this.b(this.pos, this.gab, this.gac);
            } else if (this.gab instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.fZM.gbA.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void a(Object obj, int i, int i2, String str) {
            if (this.gac != null && AlaLiveMultiBeautyArView.this.fZP != null && AlaLiveMultiBeautyArView.this.fZP.gaW == this.gac) {
                AlaLiveMultiBeautyArView.this.fZP.gaM.notifyDataSetChanged();
            } else if (this.gab instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.fZM.gbA.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
        if (dVar != null) {
            dVar.fVJ = i;
        }
        if (cVar.isLoading()) {
            return true;
        }
        if (!cVar.isLoaded()) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(getContext(), a.i.sdk_network_not_available);
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
        this.fZW = cVar;
        if ("makeupClose".equals(cVar.getTypeName())) {
            bLM();
        }
        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
        aVar.setResPath(cVar.bKl());
        aVar.setType(cVar.getType().name());
        aVar.setValue(cVar.bKj());
        this.fZU.aDO = aVar;
        if (this.fZV != null) {
            this.fZV.a(aVar);
        }
        if (this.fZH.gbE == this.fZM) {
            boolean z = cVar.bKg() > cVar.bKh();
            this.fZJ.lo(z);
            if (z) {
                try {
                    this.fZJ.gaY.setProcessDiff(0);
                    this.fZM.x(cVar.bKh(), cVar.bKg(), cVar.bKi(), cVar.getValue());
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void Ci() {
        if (this.fZU != null) {
            com.baidu.live.d.AZ().putString("ala_beauty_config_ar", this.fZU.toJsonString());
            com.baidu.tieba.ala.alaar.makeup.g.bKv().bKA();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.i iVar) {
        this.fZS = iVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.blq = bdPageContext;
        fZY = BdUtilHelper.getScreenSize(this.blq.getPageActivity()).widthPixels;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(w wVar) {
        this.aEc = wVar;
    }

    private com.baidu.live.ar.f getCurThinFace() {
        if (TextUtils.isEmpty(this.fZU.aDK) || this.fZS == null || this.fZS.Cg() == null || this.fZS.Cg().aDs == null) {
            return null;
        }
        List<com.baidu.live.ar.f> list = this.fZS.Cg().aDs;
        com.baidu.live.ar.f fVar = null;
        for (int i = 0; i < list.size(); i++) {
            fVar = list.get(i);
            if (TextUtils.equals(this.fZU.aDK, fVar.getType())) {
                return fVar;
            }
        }
        return fVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        com.baidu.tieba.ala.alaar.makeup.c bKs;
        String str;
        int fU;
        JSONArray jSONArray = new JSONArray();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            if (TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                com.baidu.live.ar.f curThinFace = getCurThinFace();
                if (curThinFace != null && !TextUtils.isEmpty(curThinFace.getName())) {
                    str = curThinFace.getName();
                    fU = this.fZU.fT(this.fZU.aDK);
                }
                str = null;
                fU = 0;
            } else {
                if (this.fZJ.gbl != null) {
                    for (int i = 0; i < this.fZJ.gbl.gas.length; i++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.fZJ.gbl.gas[i].gay)) {
                            c.a aVar = this.fZJ.gbl.gas[i];
                            int i2 = aVar.gaz;
                            str = aVar.mShowName;
                            fU = this.fZU.fU(beautyAdjustKey.getJsonKey()) + i2;
                            break;
                        }
                    }
                }
                str = null;
                fU = 0;
            }
            if (fU != 0 && str != null) {
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
        r("beauty_suc", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        if (this.fZU.aDG != null) {
            try {
                jSONObject2.put("filter_id", this.fZU.aDG.getId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        r("filter_suc", jSONObject2);
        if (com.baidu.tieba.ala.alaar.makeup.g.bKv().bKw()) {
            JSONArray jSONArray2 = new JSONArray();
            List<com.baidu.tieba.ala.alaar.makeup.d> bKy = com.baidu.tieba.ala.alaar.makeup.g.bKv().bKy();
            if (bKy != null && bKy.size() > 0) {
                for (int i3 = 0; i3 < bKy.size(); i3++) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bKy.get(i3);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bKs = dVar.bKs()) != null && bKs.bKh() < bKs.bKg()) {
                        jSONArray2.put(bKs.getId());
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
            r("makeup_suc", jSONObject3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(int i) {
        a(i, true, 0);
    }

    public void a(int i, boolean z, int i2) {
        if (z) {
            i2 = com.baidu.live.ar.d.aDS.fU(this.fZU.aDH) + this.fZK;
        }
        I(100, i, i2);
    }

    public void I(int i, int i2, int i3) {
        this.fZJ.gaY.setMax(i);
        if (Build.VERSION.SDK_INT >= 24) {
            this.fZJ.gaY.setProgress(i2, true);
        } else {
            this.fZJ.gaY.setProgress(i2);
        }
        this.fZJ.gaY.setDefThumbPos(i3);
    }

    @Deprecated
    private static void bLH() {
        ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
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
            int i7 = iArr[0] - ((fZY - ds120) / 2);
            int i8 = z ? ((i - 1) * (ds120 + ds20)) + ds28 + ds3 + ds20 : ((ds120 + ds20) * i) + ds28;
            int i9 = ((i4 - i) - 1) * (ds120 + ds20);
            if ((fZY - ds120) / 2 > i8) {
                return (((fZY - ds120) / 2) - i8) + i7;
            }
            return (fZY - ds120) / 2 > i9 ? i7 - (((fZY - ds120) / 2) - i9) : i7;
        }
        return i5;
    }

    public static int bC(int i, int i2) {
        return Math.max(0, Math.min((i - ds120) >> 1, ((ds120 + ds20) * i2) + ds28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLI() {
        if (this.fZR != null) {
            this.fZR.dismiss();
            this.fZR = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.fZR = new BdAlertDialog((Activity) getContext());
        this.fZR.setAutoNight(false);
        this.fZR.setMessage(string);
        this.fZR.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.Ck();
                AlaLiveMultiBeautyArView.this.GU();
            }
        });
        this.fZR.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.GU();
            }
        });
        this.fZR.setCancelable(false);
        this.fZR.setCanceledOnTouchOutside(false);
        this.fZR.setTitleShowCenter(true);
        this.fZR.setMessageShowCenter(true);
        this.fZR.isShowTitleAndMessage();
        this.fZR.create(this.blq);
        this.fZR.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ck() {
        if (this.fZV != null) {
            this.fZV.Ck();
        }
        bLN();
        String str = this.fZU.aDK;
        String str2 = this.fZU.aDL;
        String str3 = this.fZU.aDM;
        String str4 = com.baidu.live.ar.d.aDT.aDH;
        com.baidu.live.ar.d.aDT.fR(com.baidu.live.ar.d.aDS.toJsonString());
        com.baidu.live.ar.d.aDT.aDH = str4;
        com.baidu.live.ar.d.aDT.aDK = str;
        com.baidu.live.ar.d.aDT.aDL = str2;
        com.baidu.live.ar.d.aDT.aDM = str3;
        this.fZU = com.baidu.live.ar.d.aDT;
        if (this.fZS != null && this.fZS.Cg() != null && this.fZS.Cg().aDs != null) {
            this.fZU.a(true, this.fZS.Cg().aDs);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fT = this.fZU.fT(str);
            this.fZJ.gaY.setProcessDiff(0);
            a(fT, false, fT);
            return;
        }
        tw(this.fZU.fU(this.fZU.aDH) + this.fZK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        if (this.fZR != null) {
            this.fZR.dismiss();
            this.fZR = null;
        }
        this.fZR = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fZT) {
            this.fZT = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void bLJ() {
        if (!TextUtils.isEmpty(this.fZU.aDK)) {
            if (TextUtils.isEmpty(this.fZU.aDM)) {
                tw(this.fZU.fT(this.fZU.aDK));
                return;
            }
            try {
                this.fZJ.gaY.setProcessDiff(0);
                a(this.fZU.fT(this.fZU.aDK), false, Integer.valueOf(this.fZU.aDM).intValue());
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
        if (this.fZJ != null && this.fZJ.isEnable()) {
            FY("beautytab_show");
        }
        if (this.fZM != null && this.fZM.isEnable()) {
            FY("makeuptab_show");
        }
        if (this.fZI != null && this.fZI.isEnable()) {
            FY("filtertab_show");
        }
    }

    private void FY(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "beauty");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int i = 0;
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            i = this.aEc.mLiveInfo.live_status;
        }
        if (i != 1) {
            str2 = UbcStatConstant.Page.LIVE_ACTION;
        } else {
            str2 = UbcStatConstant.Page.AUTHOR_LIVE_ROOM;
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", str2, str).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, JSONObject jSONObject) {
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
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            i = this.aEc.mLiveInfo.live_status;
        }
        if (i != 1) {
            str2 = UbcStatConstant.Page.LIVE_ACTION;
        } else {
            str2 = UbcStatConstant.Page.AUTHOR_LIVE_ROOM;
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", str2, str).setContentExt(jSONObject));
    }

    private void r(String str, JSONObject jSONObject) {
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
            this.fZH.dismiss(z2);
            if (this.fZP != null) {
                this.fZQ.setTitle(this.fZP.getTitle());
            }
            this.fZQ.show(z2);
            return;
        }
        if (this.fZH.gbE == this.fZM) {
            this.fZJ.lo(false);
        }
        this.fZQ.dismiss(z2);
        this.fZH.show(z2);
        bLG();
        if (!this.fZJ.gbl.bLP()) {
            this.fZJ.gbl.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.k kVar) {
        this.fZV = kVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.d.aDT.fR(com.baidu.live.d.AZ().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.d.aDT.aDF) && com.baidu.minivideo.arface.b.XC() != null) {
            com.baidu.live.ar.d dVar = com.baidu.live.ar.d.aDT;
            com.baidu.minivideo.arface.b.XC();
            dVar.aDF = com.baidu.minivideo.arface.c.XH();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.h.aDZ)) {
            com.baidu.minivideo.arface.b.XC();
            com.baidu.live.ar.h.fV(com.baidu.minivideo.arface.c.XH());
        }
        this.fZU = com.baidu.live.ar.d.aDT;
        setBeautyAdjustUserData2AR(false);
        bLK();
        if (this.fZH.gbE == this.fZJ && !TextUtils.equals(this.fZU.aDH, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            tw(this.fZU.fU(this.fZU.aDH) + this.fZK);
        }
        this.fZJ.gbl.Gb(this.fZU.aDH);
        this.fZJ.gbl.notifyDataSetChanged();
        if (this.fZS != null && this.fZS.Cg() != null && this.fZS.Cg().aDr != null) {
            this.fZI.gbs.setDatas(this.fZS.Cg().aDr);
            if (!TextUtils.isEmpty(this.fZU.aDF)) {
                this.fZI.gbs.setSelect(i(this.fZS.Cg().aDr, this.fZU.aDF));
            }
        }
        this.fZI.gbs.notifyDataSetChanged();
    }

    public int i(List<com.baidu.live.ar.g> list, String str) {
        String FL;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getContext().getString(a.i.beauty_yuantu).equals(list.get(i2).getName())) {
                com.baidu.minivideo.arface.b.XC();
                FL = com.baidu.minivideo.arface.c.XH();
                i = i2;
            } else {
                FL = com.baidu.tieba.ala.alaar.sticker.a.e.FL(list.get(i2).Cc());
            }
            if (str.equals(FL)) {
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
        if (this.fZV != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.fZJ.gbl != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.fZJ.gbl.gas.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.fZJ.gbl.gas[i2].gay)) {
                            i = this.fZJ.gbl.gas[i2].gaz;
                        }
                    }
                } else {
                    i = 0;
                }
                this.fZV.a(((this.fZU.fU(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bLN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLK() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bKy;
        com.baidu.tieba.ala.alaar.makeup.c bKs;
        if (this.fZV != null && com.baidu.tieba.ala.alaar.makeup.g.bKv().bKw() && (bKy = com.baidu.tieba.ala.alaar.makeup.g.bKv().bKy()) != null && bKy.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bKy.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bKy.get(i2);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bKs = dVar.bKs()) != null && bKs.bKh() < bKs.bKg()) {
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bKs.getTypeName());
                        aVar.setValue(bKs.bKj());
                        aVar.setResPath(bKs.bKl());
                        this.fZV.a(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLL() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bKy = com.baidu.tieba.ala.alaar.makeup.g.bKv().bKy();
        if (this.fZV != null && bKy != null && bKy.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bKy.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bKy.get(i2);
                    if (dVar == null || !"makeupClose".equals(dVar.getTypeName())) {
                        i = i2 + 1;
                    } else {
                        com.baidu.tieba.ala.alaar.makeup.c bKs = dVar.bKs();
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bKs.getTypeName());
                        aVar.setValue(bKs.bKj());
                        aVar.setResPath(bKs.bKl());
                        this.fZV.a(aVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bLM() {
        com.baidu.tieba.ala.alaar.makeup.a.b bKD = this.fZO.bKD();
        if (bKD != null) {
            List<com.baidu.tieba.ala.alaar.makeup.d> data = bKD.getData();
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
        if (this.fZV != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.fZU.aDL);
            this.fZV.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bLN() {
        setThinFace(this.fZU.fT(this.fZU.aDK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga(String str) {
        this.fZX.setText(str);
        this.fZX.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fZX, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fZX, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fZX, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.fZX, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void Ch() {
        if (this.fZJ.gbl != null) {
            this.fZJ.gbl.notifyDataSetChanged();
        }
        if (this.fZI.gbs != null) {
            this.fZI.gbs.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
