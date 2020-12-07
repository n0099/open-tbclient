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
    private static int gnE;
    private w aFN;
    private com.baidu.live.ar.j bAN;
    private BdPageContext bqi;
    private com.baidu.live.ar.d gnA;
    private com.baidu.live.ar.l gnB;
    private com.baidu.tieba.ala.alaar.makeup.c gnC;
    private TextView gnD;
    private final p gno;
    private final n gnp;
    private final m gnq;
    int gnr;
    private c.a gns;
    private final o gnt;
    private int gnu;
    private com.baidu.tieba.ala.alaar.makeup.a.c gnv;
    private final i gnw;
    private k gnx;
    private BdAlertDialog gny;
    private boolean gnz;

    static /* synthetic */ int b(AlaLiveMultiBeautyArView alaLiveMultiBeautyArView) {
        int i = alaLiveMultiBeautyArView.gnu;
        alaLiveMultiBeautyArView.gnu = i + 1;
        return i;
    }

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.gno = new p();
        this.gnp = new n();
        this.gnq = new m();
        this.gnr = 0;
        this.gnt = new o();
        this.gnw = new i();
        this.gnx = new k();
        this.gnz = true;
        this.gnA = com.baidu.live.ar.d.aFv;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gno = new p();
        this.gnp = new n();
        this.gnq = new m();
        this.gnr = 0;
        this.gnt = new o();
        this.gnw = new i();
        this.gnx = new k();
        this.gnz = true;
        this.gnA = com.baidu.live.ar.d.aFv;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gno = new p();
        this.gnp = new n();
        this.gnq = new m();
        this.gnr = 0;
        this.gnt = new o();
        this.gnw = new i();
        this.gnx = new k();
        this.gnz = true;
        this.gnA = com.baidu.live.ar.d.aFv;
        initViews();
    }

    public void setFilterFileName(String str) {
        this.gnA.aFh = str;
    }

    public String getFilterFileName() {
        if (TextUtils.isEmpty(this.gnA.aFh) && this.gnA.aFi != null) {
            this.gnA.aFh = com.baidu.tieba.ala.alaar.sticker.a.e.Gp(this.gnA.aFi.Dv());
        }
        return this.gnA.aFh;
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_beauty_ar_hor_layout, this);
        bRl();
        this.gnu = 0;
        this.gno.ce(this);
        this.gno.a(new p.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.tieba.ala.alaar.view.p.a
            public void a(l lVar) {
                if (lVar != AlaLiveMultiBeautyArView.this.gnt) {
                    if (lVar == AlaLiveMultiBeautyArView.this.gnp) {
                        AlaLiveMultiBeautyArView.this.gnp.uT(AlaLiveMultiBeautyArView.this.gnA.gl(AlaLiveMultiBeautyArView.this.getFilterFileName()));
                        return;
                    } else if (lVar == AlaLiveMultiBeautyArView.this.gnq && AlaLiveMultiBeautyArView.this.gnA != null) {
                        if (!TextUtils.equals(AlaLiveMultiBeautyArView.this.gnA.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            AlaLiveMultiBeautyArView.this.uI(AlaLiveMultiBeautyArView.this.gnA.gn(AlaLiveMultiBeautyArView.this.gnA.aFj) + AlaLiveMultiBeautyArView.this.gnr);
                            AlaLiveMultiBeautyArView.this.gnq.goF.setProcessDiff(AlaLiveMultiBeautyArView.this.gnr);
                            return;
                        }
                        try {
                            AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.gnA.gm(AlaLiveMultiBeautyArView.this.gnA.aFm), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gnA.aFo).intValue());
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                AlaLiveMultiBeautyArView.b(AlaLiveMultiBeautyArView.this);
                if (AlaLiveMultiBeautyArView.this.gnv != null && !AlaLiveMultiBeautyArView.this.gnv.bQi()) {
                    AlaLiveMultiBeautyArView.this.gnv.lO(true);
                }
                if (AlaLiveMultiBeautyArView.this.gnu == 1 && AlaLiveMultiBeautyArView.this.gnt.gpg != null) {
                    AlaLiveMultiBeautyArView.this.gnt.uR(AlaLiveMultiBeautyArView.this.gnt.gpg.getCurrentPosition());
                }
                AlaLiveMultiBeautyArView.this.gnt.lS(false);
            }
        });
        this.gnp.ce(this);
        this.gnp.setTitle(getResources().getString(a.h.ala_live_new_beauty_filter));
        this.gno.b(this.gnp);
        this.gnp.c(new com.baidu.tieba.ala.alaar.view.a(getContext()));
        this.gnp.a(new l.a<com.baidu.live.ar.h>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.h hVar, boolean z) {
                String Gp;
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.h.beauty_yuantu).equals(hVar.getName())) {
                    com.baidu.minivideo.arface.b.abY();
                    Gp = com.baidu.minivideo.arface.c.acf();
                } else {
                    Gp = com.baidu.tieba.ala.alaar.sticker.a.e.Gp(hVar.Dv());
                }
                if (!AlaLiveMultiBeautyArView.this.gnA.aFh.equals(Gp)) {
                    AlaLiveMultiBeautyArView.this.GE(hVar.getName());
                }
                AlaLiveMultiBeautyArView.this.setFilterFileName(Gp);
                AlaLiveMultiBeautyArView.this.gnA.aFi = hVar;
                if (AlaLiveMultiBeautyArView.this.gnB != null && AlaLiveMultiBeautyArView.this.bAN.Dz() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gnA.a(hVar, AlaLiveMultiBeautyArView.this.bAN.Dz().aET);
                    int gl = AlaLiveMultiBeautyArView.this.gnA.gl(AlaLiveMultiBeautyArView.this.getFilterFileName());
                    float f = (((gl * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + gl + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gnB.onFilterSelected(AlaLiveMultiBeautyArView.this.gnA.aFi.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
                if (AlaLiveMultiBeautyArView.this.gno.gpk == AlaLiveMultiBeautyArView.this.gnp) {
                    AlaLiveMultiBeautyArView.this.gnp.uT(AlaLiveMultiBeautyArView.this.gnA.gl(AlaLiveMultiBeautyArView.this.getFilterFileName()));
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
                AlaLiveMultiBeautyArView.this.gnA.A(AlaLiveMultiBeautyArView.this.getFilterFileName(), i);
                if (AlaLiveMultiBeautyArView.this.gnB != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gnA.a(AlaLiveMultiBeautyArView.this.gnA.aFi, AlaLiveMultiBeautyArView.this.bAN.Dz().aET);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gnB.onFilterSelected(AlaLiveMultiBeautyArView.this.gnA.aFi.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gnA.aFi != null) {
                    try {
                        jSONObject.put("filter_id", AlaLiveMultiBeautyArView.this.gnA.aFi.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("filterbar_clk", jSONObject);
            }
        });
        this.gnq.ce(this);
        this.gnq.setTitle(getResources().getString(a.h.ala_live_new_beauty_beauty));
        this.gno.b(this.gnq);
        this.gnq.a(new l.a<c.a>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, c.a aVar, boolean z) {
                if (AlaLiveMultiBeautyArView.this.gno.gpk == AlaLiveMultiBeautyArView.this.gnq) {
                    if (i == 0) {
                        AlaLiveMultiBeautyArView.this.bRm();
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gnA.aFj = aVar.goe;
                    AlaLiveMultiBeautyArView.this.gnq.goR.GI(aVar.goe);
                    AlaLiveMultiBeautyArView.this.bRk();
                    if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gnA.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (AlaLiveMultiBeautyArView.this.gno.gpk == AlaLiveMultiBeautyArView.this.gnq && z) {
                            AlaLiveMultiBeautyArView.this.a(aVar);
                            return;
                        }
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gns = aVar;
                    if (aVar != null) {
                        AlaLiveMultiBeautyArView.this.gnr = aVar.gof;
                    }
                    AlaLiveMultiBeautyArView.this.uI(AlaLiveMultiBeautyArView.this.gnA.gn(AlaLiveMultiBeautyArView.this.gnA.aFj) + AlaLiveMultiBeautyArView.this.gnr);
                    AlaLiveMultiBeautyArView.this.gnq.goF.setProcessDiff(AlaLiveMultiBeautyArView.this.gnr);
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
                if (AlaLiveMultiBeautyArView.this.gno.gpk == AlaLiveMultiBeautyArView.this.gnt) {
                    if (z && AlaLiveMultiBeautyArView.this.gnC != null) {
                        AlaLiveMultiBeautyArView.this.gnC.setValue(i);
                        if (AlaLiveMultiBeautyArView.this.gnA.aFq != null) {
                            AlaLiveMultiBeautyArView.this.gnA.aFq.setValue(AlaLiveMultiBeautyArView.this.gnC.bPM());
                            AlaLiveMultiBeautyArView.this.gnB.a(AlaLiveMultiBeautyArView.this.gnA.aFq);
                        }
                    }
                } else if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gnA.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.gnA.dS(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.gnA.aFm) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.gnA.aFm)) && com.baidu.live.d.BM().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.d.BM().getBoolean("naturalFace", true)) {
                        com.baidu.live.d.BM().putBoolean("naturalFace", false);
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.gnA.B(AlaLiveMultiBeautyArView.this.gnA.aFj, i - AlaLiveMultiBeautyArView.this.gnr);
                    if (AlaLiveMultiBeautyArView.this.gnB != null) {
                        AlaLiveMultiBeautyArView.this.gnB.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.gk(AlaLiveMultiBeautyArView.this.gnA.aFj));
                    }
                }
                if (z) {
                    com.baidu.live.d.BM().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (AlaLiveMultiBeautyArView.this.gno.gpk != AlaLiveMultiBeautyArView.this.gnt) {
                    if (AlaLiveMultiBeautyArView.this.gnA.aFj != null) {
                        String str = null;
                        if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gnA.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            if (AlaLiveMultiBeautyArView.this.gnA.aFp != null) {
                                str = AlaLiveMultiBeautyArView.this.gnA.aFp.getName();
                            }
                        } else {
                            str = AlaLiveMultiBeautyArView.this.gns.god;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (AlaLiveMultiBeautyArView.this.gns != null && str != null) {
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
                if (AlaLiveMultiBeautyArView.this.gnC != null) {
                    try {
                        jSONObject2.put("makeup_id", AlaLiveMultiBeautyArView.this.gnC.getId());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("makeupbar_clk", jSONObject2);
            }
        });
        this.gnq.goW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.gno.gpk == AlaLiveMultiBeautyArView.this.gnt) {
                            AlaLiveMultiBeautyArView.this.bRp();
                            break;
                        } else {
                            if (AlaLiveMultiBeautyArView.this.gnB != null) {
                                AlaLiveMultiBeautyArView.this.gnB.DE();
                            }
                            AlaLiveMultiBeautyArView.this.setThinFace(0);
                            break;
                        }
                    case 1:
                    case 3:
                    case 4:
                        if (AlaLiveMultiBeautyArView.this.gno.gpk == AlaLiveMultiBeautyArView.this.gnt) {
                            AlaLiveMultiBeautyArView.this.bRo();
                            break;
                        } else {
                            AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                            break;
                        }
                }
                return true;
            }
        });
        this.gnt.ce(this);
        this.gnt.uS(0);
        this.gnt.setTitle(getResources().getString(a.h.ala_live_new_beauty_makeup));
        this.gno.b(this.gnt);
        this.gnt.a(new l.a<com.baidu.tieba.ala.alaar.makeup.d>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemSelected pos= " + i + ", name=" + dVar.bPG());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bPU = dVar.bPU();
                if (dVar.aBy() || bPU == null || bPU.isEmpty()) {
                    AlaLiveMultiBeautyArView.this.b(i, dVar, null);
                } else if (AlaLiveMultiBeautyArView.this.gno.gpk == AlaLiveMultiBeautyArView.this.gnt) {
                    AlaLiveMultiBeautyArView.this.a(dVar);
                }
                if (AlaLiveMultiBeautyArView.this.gnv != null) {
                    AlaLiveMultiBeautyArView.this.gnv.setPosition(i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemClick pos= " + i + ", name=" + dVar.bPG());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bPU = dVar.bPU();
                if (dVar.aBy() || bPU == null || bPU.isEmpty()) {
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
        if (this.gnv != null) {
            this.gnt.setPosition(this.gnv.getPosition());
        }
        com.baidu.tieba.ala.alaar.makeup.g.bPY().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.tieba.ala.alaar.makeup.a.b
            public void c(com.baidu.tieba.ala.alaar.makeup.a aVar) {
                com.baidu.tieba.ala.alaar.makeup.a.c bQa = com.baidu.tieba.ala.alaar.makeup.g.bPY().bQa();
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("BeautyAr", "makeupdata onDataLoaded size: " + (AlaLiveMultiBeautyArView.this.gnv == null ? "null" : Integer.valueOf(AlaLiveMultiBeautyArView.this.gnv.size())));
                }
                AlaLiveMultiBeautyArView.this.setMakeupData(bQa);
            }
        });
        this.gnx.ce(this);
        this.gnx.a(new j.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.j.a
            public void a(k kVar, View view) {
                AlaLiveMultiBeautyArView.this.H(false, true);
            }
        });
        findViewById(a.f.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveMultiBeautyArView.this.bRj();
            }
        });
        this.gnD = (TextView) findViewById(a.f.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bRk();
            }
        }, 1000L);
        String string = com.baidu.live.d.BM().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
        this.gno.c(this.gnq);
        this.gno.show(false);
    }

    private boolean isShow() {
        ViewParent parent = getParent();
        return parent != null && (parent instanceof ViewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRj() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        DB();
        if (this.gnB != null) {
            this.gnB.DC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar) {
        this.gnw.goD = dVar;
        this.gnw.a(new l.a<com.baidu.tieba.ala.alaar.makeup.c>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
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
                if (AlaLiveMultiBeautyArView.this.gnC != null) {
                    try {
                        jSONObject.put("makeup_id", AlaLiveMultiBeautyArView.this.gnC.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("makeupbar_clk", jSONObject);
            }
        });
        this.gnw.a(dVar, this);
        this.gnw.setTitle(dVar.bPG());
        H(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        this.gnw.goD = aVar;
        this.gnw.cd(this);
        this.gnw.setTitle(aVar.god);
        this.gnw.a(new l.a<com.baidu.live.ar.g>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.g gVar, boolean z) {
                AlaLiveMultiBeautyArView.this.gnA.aFm = gVar.getType();
                AlaLiveMultiBeautyArView.this.gnA.aFn = gVar.Dx();
                AlaLiveMultiBeautyArView.this.gnA.aFo = gVar.Dw();
                AlaLiveMultiBeautyArView.this.gnA.aFp = gVar;
                String GJ = AlaLiveMultiBeautyArView.this.gnw.got.GJ(gVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.Gq(gVar.Dv())) {
                    GJ = com.baidu.tieba.ala.alaar.sticker.a.d.Gt(com.baidu.tieba.ala.alaar.sticker.a.d.Gp(gVar.Dv()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, GJ));
                AlaLiveMultiBeautyArView.this.gnq.goF.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.gnA.gm(AlaLiveMultiBeautyArView.this.gnA.aFm), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gnA.aFo).intValue());
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
                if (AlaLiveMultiBeautyArView.this.gnA.aFj != null) {
                    String str = null;
                    try {
                        if (AlaLiveMultiBeautyArView.this.gnA.aFp != null) {
                            str = AlaLiveMultiBeautyArView.this.gnA.aFp.getName();
                        }
                        jSONObject.put("beauty_name", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("beautybar_clk", jSONObject);
            }
        });
        if (this.bAN != null && this.bAN.Dz() != null && this.bAN.Dz().aEU != null) {
            this.gnA.a(false, this.bAN.Dz().aEU);
            List<com.baidu.live.ar.g> list = this.bAN.Dz().aEU;
            this.gnw.got.e(list, this.gnw.got.i(list, this.gnA.aFm));
            this.gnw.got.notifyDataSetChanged();
            if (TextUtils.equals(this.gnA.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.gnA.aFo)) {
                        i = Integer.valueOf(this.gnA.aFo).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                a(this.gnA.gm(this.gnA.aFm), false, i);
            }
        }
        H(true, true);
        bRn();
        this.gnx.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeupData(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        boolean z = true;
        this.gnv = cVar;
        if (cVar != null && cVar.bQg() != null && cVar.Dt()) {
            bRo();
            this.gnt.setEnable(true);
            this.gnt.gpg.setData(cVar.bQg().getData());
            if (this.gnv != null) {
                this.gnt.setPosition(this.gnv.getPosition());
            }
            o oVar = this.gnt;
            if (!cVar.bQh() || cVar.bQi()) {
                z = false;
            }
            oVar.lS(z);
            return;
        }
        this.gnt.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRk() {
        if (com.baidu.live.d.BM().getInt("beauty_tab_redot", 0) != 1) {
            this.gnq.lS(false);
        } else if (com.baidu.live.d.BM().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.d.BM().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.d.BM().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.d.BM().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.gnq.goR.bRt()) {
            this.gnq.lS(true);
        } else {
            this.gnq.lS(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements h.a {
        com.baidu.tieba.ala.alaar.makeup.c gnH;
        com.baidu.tieba.ala.alaar.makeup.d gnI;
        int pos;

        public a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
            this.pos = i;
            this.gnH = cVar;
            this.gnI = dVar;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aD(Object obj) {
            if (this.gnI != null && AlaLiveMultiBeautyArView.this.gnw != null && AlaLiveMultiBeautyArView.this.gnw.goD == this.gnI) {
                AlaLiveMultiBeautyArView.this.gnw.gos.notifyDataSetChanged();
            } else if (this.gnH instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gnt.gpg.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aE(Object obj) {
            if (this.gnI != null && AlaLiveMultiBeautyArView.this.gnw != null && AlaLiveMultiBeautyArView.this.gnw.goD == this.gnI) {
                AlaLiveMultiBeautyArView.this.gnw.gos.uQ(this.pos);
                AlaLiveMultiBeautyArView.this.gnw.gos.notifyDataSetChanged();
            } else if (this.gnI != null && this.pos == this.gnI.gjs) {
                AlaLiveMultiBeautyArView.this.b(this.pos, this.gnH, this.gnI);
            } else if (this.gnH instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gnt.gpg.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void a(Object obj, int i, int i2, String str) {
            if (this.gnI != null && AlaLiveMultiBeautyArView.this.gnw != null && AlaLiveMultiBeautyArView.this.gnw.goD == this.gnI) {
                AlaLiveMultiBeautyArView.this.gnw.gos.notifyDataSetChanged();
            } else if (this.gnH instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gnt.gpg.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
        if (dVar != null) {
            dVar.gjs = i;
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
        this.gnC = cVar;
        if ("makeupClose".equals(cVar.getTypeName())) {
            bRq();
        }
        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
        aVar.setResPath(cVar.bPO());
        aVar.setType(cVar.getType().name());
        aVar.setValue(cVar.bPM());
        this.gnA.aFq = aVar;
        if (this.gnB != null) {
            this.gnB.a(aVar);
        }
        if (this.gno.gpk == this.gnt) {
            boolean z = cVar.bPJ() > cVar.bPK();
            this.gnq.lT(z);
            if (z) {
                try {
                    this.gnq.goF.setProcessDiff(0);
                    this.gnt.C(cVar.bPK(), cVar.bPJ(), cVar.bPL(), cVar.getValue());
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void DB() {
        if (this.gnA != null) {
            com.baidu.live.d.BM().putString("ala_beauty_config_ar", this.gnA.toJsonString());
            com.baidu.tieba.ala.alaar.makeup.g.bPY().bQd();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.j jVar) {
        this.bAN = jVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bqi = bdPageContext;
        gnE = BdUtilHelper.getScreenSize(this.bqi.getPageActivity()).widthPixels;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(w wVar) {
        this.aFN = wVar;
    }

    private com.baidu.live.ar.g getCurThinFace() {
        if (TextUtils.isEmpty(this.gnA.aFm) || this.bAN == null || this.bAN.Dz() == null || this.bAN.Dz().aEU == null) {
            return null;
        }
        List<com.baidu.live.ar.g> list = this.bAN.Dz().aEU;
        com.baidu.live.ar.g gVar = null;
        for (int i = 0; i < list.size(); i++) {
            gVar = list.get(i);
            if (TextUtils.equals(this.gnA.aFm, gVar.getType())) {
                return gVar;
            }
        }
        return gVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        com.baidu.tieba.ala.alaar.makeup.c bPV;
        String str;
        int gn;
        JSONArray jSONArray = new JSONArray();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            if (TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                com.baidu.live.ar.g curThinFace = getCurThinFace();
                if (curThinFace != null && !TextUtils.isEmpty(curThinFace.getName())) {
                    str = curThinFace.getName();
                    gn = this.gnA.gm(this.gnA.aFm);
                }
                str = null;
                gn = 0;
            } else {
                if (this.gnq.goR != null) {
                    for (int i = 0; i < this.gnq.goR.gnX.length; i++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gnq.goR.gnX[i].goe)) {
                            c.a aVar = this.gnq.goR.gnX[i];
                            int i2 = aVar.gof;
                            str = aVar.god;
                            gn = this.gnA.gn(beautyAdjustKey.getJsonKey()) + i2;
                            break;
                        }
                    }
                }
                str = null;
                gn = 0;
            }
            if (gn != 0 && str != null) {
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
        if (this.gnA.aFi != null) {
            try {
                jSONObject2.put("filter_id", this.gnA.aFi.getId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        r("filter_suc", jSONObject2);
        if (com.baidu.tieba.ala.alaar.makeup.g.bPY().bPZ()) {
            JSONArray jSONArray2 = new JSONArray();
            List<com.baidu.tieba.ala.alaar.makeup.d> bQb = com.baidu.tieba.ala.alaar.makeup.g.bPY().bQb();
            if (bQb != null && bQb.size() > 0) {
                for (int i3 = 0; i3 < bQb.size(); i3++) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bQb.get(i3);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bPV = dVar.bPV()) != null && bPV.bPK() < bPV.bPJ()) {
                        jSONArray2.put(bPV.getId());
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
    public void uI(int i) {
        a(i, true, 0);
    }

    public void a(int i, boolean z, int i2) {
        if (z) {
            i2 = com.baidu.live.ar.d.aFu.gn(this.gnA.aFj) + this.gnr;
        }
        J(100, i, i2);
    }

    public void J(int i, int i2, int i3) {
        this.gnq.goF.setMax(i);
        if (Build.VERSION.SDK_INT >= 24) {
            this.gnq.goF.setProgress(i2, true);
        } else {
            this.gnq.goF.setProgress(i2);
        }
        this.gnq.goF.setDefThumbPos(i3);
    }

    @Deprecated
    private static void bRl() {
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
            int i7 = iArr[0] - ((gnE - ds120) / 2);
            int i8 = z ? ((i - 1) * (ds120 + ds20)) + ds28 + ds3 + ds20 : ((ds120 + ds20) * i) + ds28;
            int i9 = ((i4 - i) - 1) * (ds120 + ds20);
            if ((gnE - ds120) / 2 > i8) {
                return (((gnE - ds120) / 2) - i8) + i7;
            }
            return (gnE - ds120) / 2 > i9 ? i7 - (((gnE - ds120) / 2) - i9) : i7;
        }
        return i5;
    }

    public static int bE(int i, int i2) {
        return Math.max(0, Math.min((i - ds120) >> 1, ((ds120 + ds20) * i2) + ds28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRm() {
        if (this.gny != null) {
            this.gny.dismiss();
            this.gny = null;
        }
        String string = getContext().getString(a.h.ar_beauty_is_reset);
        this.gny = new BdAlertDialog((Activity) getContext());
        this.gny.setAutoNight(false);
        this.gny.setMessage(string);
        this.gny.setPositiveButton(getContext().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.DD();
                AlaLiveMultiBeautyArView.this.ID();
            }
        });
        this.gny.setNegativeButton(getContext().getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.ID();
            }
        });
        this.gny.setCancelable(false);
        this.gny.setCanceledOnTouchOutside(false);
        this.gny.setTitleShowCenter(true);
        this.gny.setMessageShowCenter(true);
        this.gny.isShowTitleAndMessage();
        this.gny.create(this.bqi);
        this.gny.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD() {
        if (this.gnB != null) {
            this.gnB.DD();
        }
        bRr();
        String str = this.gnA.aFm;
        String str2 = this.gnA.aFn;
        String str3 = this.gnA.aFo;
        String str4 = com.baidu.live.ar.d.aFv.aFj;
        com.baidu.live.ar.d.aFv.r(com.baidu.live.ar.d.aFu.toJsonString(), true);
        com.baidu.live.ar.d.aFv.aFj = str4;
        com.baidu.live.ar.d.aFv.aFm = str;
        com.baidu.live.ar.d.aFv.aFn = str2;
        com.baidu.live.ar.d.aFv.aFo = str3;
        this.gnA = com.baidu.live.ar.d.aFv;
        if (this.bAN != null && this.bAN.Dz() != null && this.bAN.Dz().aEU != null) {
            this.gnA.a(true, this.bAN.Dz().aEU);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int gm = this.gnA.gm(str);
            this.gnq.goF.setProcessDiff(0);
            a(gm, false, gm);
            return;
        }
        uI(this.gnA.gn(this.gnA.aFj) + this.gnr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID() {
        if (this.gny != null) {
            this.gny.dismiss();
            this.gny = null;
        }
        this.gny = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gnz) {
            this.gnz = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && isShow()) {
            bRj();
            return true;
        }
        return false;
    }

    private void bRn() {
        if (!TextUtils.isEmpty(this.gnA.aFm)) {
            if (TextUtils.isEmpty(this.gnA.aFo)) {
                uI(this.gnA.gm(this.gnA.aFm));
                return;
            }
            try {
                this.gnq.goF.setProcessDiff(0);
                a(this.gnA.gm(this.gnA.aFm), false, Integer.valueOf(this.gnA.aFo).intValue());
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
        if (this.gnq != null && this.gnq.isEnable()) {
            GC("beautytab_show");
        }
        if (this.gnt != null && this.gnt.isEnable()) {
            GC("makeuptab_show");
        }
        if (this.gnp != null && this.gnp.isEnable()) {
            GC("filtertab_show");
        }
    }

    private void GC(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "beauty");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int i = 0;
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            i = this.aFN.mLiveInfo.live_status;
        }
        if (i != 1) {
            str2 = UbcStatConstant.Page.LIVE_ACTION;
        } else {
            str2 = "author_liveroom";
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
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            i = this.aFN.mLiveInfo.live_status;
        }
        if (i != 1) {
            str2 = UbcStatConstant.Page.LIVE_ACTION;
        } else {
            str2 = "author_liveroom";
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
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", str).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z, boolean z2) {
        if (z) {
            this.gno.dismiss(z2);
            if (this.gnw != null) {
                this.gnx.setTitle(this.gnw.getTitle());
            }
            this.gnx.show(z2);
            return;
        }
        if (this.gno.gpk == this.gnt) {
            this.gnq.lT(false);
        }
        this.gnx.dismiss(z2);
        this.gno.show(z2);
        bRk();
        if (!this.gnq.goR.bRt()) {
            this.gnq.goR.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.l lVar) {
        this.gnB = lVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.d.aFv.r(com.baidu.live.d.BM().getString("ala_beauty_config_ar", ""), false);
        if (TextUtils.isEmpty(com.baidu.live.ar.d.aFv.aFh) && com.baidu.minivideo.arface.b.abY() != null) {
            com.baidu.live.ar.d dVar = com.baidu.live.ar.d.aFv;
            com.baidu.minivideo.arface.b.abY();
            dVar.aFh = com.baidu.minivideo.arface.c.acf();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.i.aFK)) {
            com.baidu.minivideo.arface.b.abY();
            com.baidu.live.ar.i.gp(com.baidu.minivideo.arface.c.acf());
        }
        this.gnA = com.baidu.live.ar.d.aFv;
        setBeautyAdjustUserData2AR(false);
        bRo();
        if (this.gno.gpk == this.gnq && !TextUtils.equals(this.gnA.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            uI(this.gnA.gn(this.gnA.aFj) + this.gnr);
        }
        this.gnq.goR.GF(this.gnA.aFj);
        this.gnq.goR.notifyDataSetChanged();
        if (this.bAN != null && this.bAN.Dz() != null && this.bAN.Dz().aET != null) {
            this.gnp.goY.setDatas(this.bAN.Dz().aET);
            if (!TextUtils.isEmpty(getFilterFileName())) {
                this.gnp.goY.setSelect(h(this.bAN.Dz().aET, getFilterFileName()));
            }
        }
        this.gnp.goY.notifyDataSetChanged();
    }

    public int h(List<com.baidu.live.ar.h> list, String str) {
        String Gp;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getContext().getString(a.h.beauty_yuantu).equals(list.get(i2).getName())) {
                com.baidu.minivideo.arface.b.abY();
                Gp = com.baidu.minivideo.arface.c.acf();
                i = i2;
            } else {
                Gp = com.baidu.tieba.ala.alaar.sticker.a.e.Gp(list.get(i2).Dv());
            }
            if (str.equals(Gp)) {
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
        if (this.gnB != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.gnq.goR != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.gnq.goR.gnX.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gnq.goR.gnX[i2].goe)) {
                            i = this.gnq.goR.gnX[i2].gof;
                        }
                    }
                } else {
                    i = 0;
                }
                this.gnB.a(((this.gnA.gn(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bRr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRo() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bQb;
        com.baidu.tieba.ala.alaar.makeup.c bPV;
        if (this.gnB != null && com.baidu.tieba.ala.alaar.makeup.g.bPY().bPZ() && (bQb = com.baidu.tieba.ala.alaar.makeup.g.bPY().bQb()) != null && bQb.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bQb.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bQb.get(i2);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bPV = dVar.bPV()) != null && bPV.bPK() < bPV.bPJ()) {
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bPV.getTypeName());
                        aVar.setValue(bPV.bPM());
                        aVar.setResPath(bPV.bPO());
                        this.gnB.a(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRp() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bQb = com.baidu.tieba.ala.alaar.makeup.g.bPY().bQb();
        if (this.gnB != null && bQb != null && bQb.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bQb.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bQb.get(i2);
                    if (dVar == null || !"makeupClose".equals(dVar.getTypeName())) {
                        i = i2 + 1;
                    } else {
                        com.baidu.tieba.ala.alaar.makeup.c bPV = dVar.bPV();
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bPV.getTypeName());
                        aVar.setValue(bPV.bPM());
                        aVar.setResPath(bPV.bPO());
                        this.gnB.a(aVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bRq() {
        com.baidu.tieba.ala.alaar.makeup.a.b bQg = this.gnv.bQg();
        if (bQg != null) {
            List<com.baidu.tieba.ala.alaar.makeup.d> data = bQg.getData();
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
        if (this.gnB != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.gnA.aFn);
            this.gnB.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bRr() {
        setThinFace(this.gnA.gm(this.gnA.aFm));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE(String str) {
        this.gnD.setText(str);
        this.gnD.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gnD, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gnD, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gnD, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.gnD, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void DA() {
        if (this.gnq.goR != null) {
            this.gnq.goR.notifyDataSetChanged();
        }
        if (this.gnp.goY != null) {
            this.gnp.goY.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
