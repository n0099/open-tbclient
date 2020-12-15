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
    private static int gnG;
    private w aFN;
    private com.baidu.live.ar.j bAN;
    private BdPageContext bqi;
    private BdAlertDialog gnA;
    private boolean gnB;
    private com.baidu.live.ar.d gnC;
    private com.baidu.live.ar.l gnD;
    private com.baidu.tieba.ala.alaar.makeup.c gnE;
    private TextView gnF;
    private final p gnq;
    private final n gnr;
    private final m gns;
    int gnt;
    private c.a gnu;
    private final o gnv;
    private int gnw;
    private com.baidu.tieba.ala.alaar.makeup.a.c gnx;
    private final i gny;
    private k gnz;

    static /* synthetic */ int b(AlaLiveMultiBeautyArView alaLiveMultiBeautyArView) {
        int i = alaLiveMultiBeautyArView.gnw;
        alaLiveMultiBeautyArView.gnw = i + 1;
        return i;
    }

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.gnq = new p();
        this.gnr = new n();
        this.gns = new m();
        this.gnt = 0;
        this.gnv = new o();
        this.gny = new i();
        this.gnz = new k();
        this.gnB = true;
        this.gnC = com.baidu.live.ar.d.aFv;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnq = new p();
        this.gnr = new n();
        this.gns = new m();
        this.gnt = 0;
        this.gnv = new o();
        this.gny = new i();
        this.gnz = new k();
        this.gnB = true;
        this.gnC = com.baidu.live.ar.d.aFv;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnq = new p();
        this.gnr = new n();
        this.gns = new m();
        this.gnt = 0;
        this.gnv = new o();
        this.gny = new i();
        this.gnz = new k();
        this.gnB = true;
        this.gnC = com.baidu.live.ar.d.aFv;
        initViews();
    }

    public void setFilterFileName(String str) {
        this.gnC.aFh = str;
    }

    public String getFilterFileName() {
        if (TextUtils.isEmpty(this.gnC.aFh) && this.gnC.aFi != null) {
            this.gnC.aFh = com.baidu.tieba.ala.alaar.sticker.a.e.Gp(this.gnC.aFi.Dv());
        }
        return this.gnC.aFh;
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_beauty_ar_hor_layout, this);
        bRm();
        this.gnw = 0;
        this.gnq.ce(this);
        this.gnq.a(new p.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.tieba.ala.alaar.view.p.a
            public void a(l lVar) {
                if (lVar != AlaLiveMultiBeautyArView.this.gnv) {
                    if (lVar == AlaLiveMultiBeautyArView.this.gnr) {
                        AlaLiveMultiBeautyArView.this.gnr.uT(AlaLiveMultiBeautyArView.this.gnC.gl(AlaLiveMultiBeautyArView.this.getFilterFileName()));
                        return;
                    } else if (lVar == AlaLiveMultiBeautyArView.this.gns && AlaLiveMultiBeautyArView.this.gnC != null) {
                        if (!TextUtils.equals(AlaLiveMultiBeautyArView.this.gnC.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            AlaLiveMultiBeautyArView.this.uI(AlaLiveMultiBeautyArView.this.gnC.gn(AlaLiveMultiBeautyArView.this.gnC.aFj) + AlaLiveMultiBeautyArView.this.gnt);
                            AlaLiveMultiBeautyArView.this.gns.goH.setProcessDiff(AlaLiveMultiBeautyArView.this.gnt);
                            return;
                        }
                        try {
                            AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.gnC.gm(AlaLiveMultiBeautyArView.this.gnC.aFm), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gnC.aFo).intValue());
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                AlaLiveMultiBeautyArView.b(AlaLiveMultiBeautyArView.this);
                if (AlaLiveMultiBeautyArView.this.gnx != null && !AlaLiveMultiBeautyArView.this.gnx.bQj()) {
                    AlaLiveMultiBeautyArView.this.gnx.lO(true);
                }
                if (AlaLiveMultiBeautyArView.this.gnw == 1 && AlaLiveMultiBeautyArView.this.gnv.gpi != null) {
                    AlaLiveMultiBeautyArView.this.gnv.uR(AlaLiveMultiBeautyArView.this.gnv.gpi.getCurrentPosition());
                }
                AlaLiveMultiBeautyArView.this.gnv.lS(false);
            }
        });
        this.gnr.ce(this);
        this.gnr.setTitle(getResources().getString(a.h.ala_live_new_beauty_filter));
        this.gnq.b(this.gnr);
        this.gnr.c(new com.baidu.tieba.ala.alaar.view.a(getContext()));
        this.gnr.a(new l.a<com.baidu.live.ar.h>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
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
                if (!AlaLiveMultiBeautyArView.this.gnC.aFh.equals(Gp)) {
                    AlaLiveMultiBeautyArView.this.GE(hVar.getName());
                }
                AlaLiveMultiBeautyArView.this.setFilterFileName(Gp);
                AlaLiveMultiBeautyArView.this.gnC.aFi = hVar;
                if (AlaLiveMultiBeautyArView.this.gnD != null && AlaLiveMultiBeautyArView.this.bAN.Dz() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gnC.a(hVar, AlaLiveMultiBeautyArView.this.bAN.Dz().aET);
                    int gl = AlaLiveMultiBeautyArView.this.gnC.gl(AlaLiveMultiBeautyArView.this.getFilterFileName());
                    float f = (((gl * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + gl + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gnD.onFilterSelected(AlaLiveMultiBeautyArView.this.gnC.aFi.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
                if (AlaLiveMultiBeautyArView.this.gnq.gpm == AlaLiveMultiBeautyArView.this.gnr) {
                    AlaLiveMultiBeautyArView.this.gnr.uT(AlaLiveMultiBeautyArView.this.gnC.gl(AlaLiveMultiBeautyArView.this.getFilterFileName()));
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
                AlaLiveMultiBeautyArView.this.gnC.A(AlaLiveMultiBeautyArView.this.getFilterFileName(), i);
                if (AlaLiveMultiBeautyArView.this.gnD != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gnC.a(AlaLiveMultiBeautyArView.this.gnC.aFi, AlaLiveMultiBeautyArView.this.bAN.Dz().aET);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gnD.onFilterSelected(AlaLiveMultiBeautyArView.this.gnC.aFi.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gnC.aFi != null) {
                    try {
                        jSONObject.put("filter_id", AlaLiveMultiBeautyArView.this.gnC.aFi.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("filterbar_clk", jSONObject);
            }
        });
        this.gns.ce(this);
        this.gns.setTitle(getResources().getString(a.h.ala_live_new_beauty_beauty));
        this.gnq.b(this.gns);
        this.gns.a(new l.a<c.a>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, c.a aVar, boolean z) {
                if (AlaLiveMultiBeautyArView.this.gnq.gpm == AlaLiveMultiBeautyArView.this.gns) {
                    if (i == 0) {
                        AlaLiveMultiBeautyArView.this.bRn();
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gnC.aFj = aVar.gog;
                    AlaLiveMultiBeautyArView.this.gns.goT.GI(aVar.gog);
                    AlaLiveMultiBeautyArView.this.bRl();
                    if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gnC.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (AlaLiveMultiBeautyArView.this.gnq.gpm == AlaLiveMultiBeautyArView.this.gns && z) {
                            AlaLiveMultiBeautyArView.this.a(aVar);
                            return;
                        }
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gnu = aVar;
                    if (aVar != null) {
                        AlaLiveMultiBeautyArView.this.gnt = aVar.goh;
                    }
                    AlaLiveMultiBeautyArView.this.uI(AlaLiveMultiBeautyArView.this.gnC.gn(AlaLiveMultiBeautyArView.this.gnC.aFj) + AlaLiveMultiBeautyArView.this.gnt);
                    AlaLiveMultiBeautyArView.this.gns.goH.setProcessDiff(AlaLiveMultiBeautyArView.this.gnt);
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
                if (AlaLiveMultiBeautyArView.this.gnq.gpm == AlaLiveMultiBeautyArView.this.gnv) {
                    if (z && AlaLiveMultiBeautyArView.this.gnE != null) {
                        AlaLiveMultiBeautyArView.this.gnE.setValue(i);
                        if (AlaLiveMultiBeautyArView.this.gnC.aFq != null) {
                            AlaLiveMultiBeautyArView.this.gnC.aFq.setValue(AlaLiveMultiBeautyArView.this.gnE.bPN());
                            AlaLiveMultiBeautyArView.this.gnD.a(AlaLiveMultiBeautyArView.this.gnC.aFq);
                        }
                    }
                } else if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gnC.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.gnC.dS(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.gnC.aFm) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.gnC.aFm)) && com.baidu.live.d.BM().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.d.BM().getBoolean("naturalFace", true)) {
                        com.baidu.live.d.BM().putBoolean("naturalFace", false);
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.gnC.B(AlaLiveMultiBeautyArView.this.gnC.aFj, i - AlaLiveMultiBeautyArView.this.gnt);
                    if (AlaLiveMultiBeautyArView.this.gnD != null) {
                        AlaLiveMultiBeautyArView.this.gnD.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.gk(AlaLiveMultiBeautyArView.this.gnC.aFj));
                    }
                }
                if (z) {
                    com.baidu.live.d.BM().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (AlaLiveMultiBeautyArView.this.gnq.gpm != AlaLiveMultiBeautyArView.this.gnv) {
                    if (AlaLiveMultiBeautyArView.this.gnC.aFj != null) {
                        String str = null;
                        if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gnC.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            if (AlaLiveMultiBeautyArView.this.gnC.aFp != null) {
                                str = AlaLiveMultiBeautyArView.this.gnC.aFp.getName();
                            }
                        } else {
                            str = AlaLiveMultiBeautyArView.this.gnu.gof;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (AlaLiveMultiBeautyArView.this.gnu != null && str != null) {
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
                if (AlaLiveMultiBeautyArView.this.gnE != null) {
                    try {
                        jSONObject2.put("makeup_id", AlaLiveMultiBeautyArView.this.gnE.getId());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("makeupbar_clk", jSONObject2);
            }
        });
        this.gns.goY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.gnq.gpm == AlaLiveMultiBeautyArView.this.gnv) {
                            AlaLiveMultiBeautyArView.this.bRq();
                            break;
                        } else {
                            if (AlaLiveMultiBeautyArView.this.gnD != null) {
                                AlaLiveMultiBeautyArView.this.gnD.DE();
                            }
                            AlaLiveMultiBeautyArView.this.setThinFace(0);
                            break;
                        }
                    case 1:
                    case 3:
                    case 4:
                        if (AlaLiveMultiBeautyArView.this.gnq.gpm == AlaLiveMultiBeautyArView.this.gnv) {
                            AlaLiveMultiBeautyArView.this.bRp();
                            break;
                        } else {
                            AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                            break;
                        }
                }
                return true;
            }
        });
        this.gnv.ce(this);
        this.gnv.uS(0);
        this.gnv.setTitle(getResources().getString(a.h.ala_live_new_beauty_makeup));
        this.gnq.b(this.gnv);
        this.gnv.a(new l.a<com.baidu.tieba.ala.alaar.makeup.d>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemSelected pos= " + i + ", name=" + dVar.bPH());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bPV = dVar.bPV();
                if (dVar.aBy() || bPV == null || bPV.isEmpty()) {
                    AlaLiveMultiBeautyArView.this.b(i, dVar, null);
                } else if (AlaLiveMultiBeautyArView.this.gnq.gpm == AlaLiveMultiBeautyArView.this.gnv) {
                    AlaLiveMultiBeautyArView.this.a(dVar);
                }
                if (AlaLiveMultiBeautyArView.this.gnx != null) {
                    AlaLiveMultiBeautyArView.this.gnx.setPosition(i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemClick pos= " + i + ", name=" + dVar.bPH());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bPV = dVar.bPV();
                if (dVar.aBy() || bPV == null || bPV.isEmpty()) {
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
        if (this.gnx != null) {
            this.gnv.setPosition(this.gnx.getPosition());
        }
        com.baidu.tieba.ala.alaar.makeup.g.bPZ().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.tieba.ala.alaar.makeup.a.b
            public void c(com.baidu.tieba.ala.alaar.makeup.a aVar) {
                com.baidu.tieba.ala.alaar.makeup.a.c bQb = com.baidu.tieba.ala.alaar.makeup.g.bPZ().bQb();
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("BeautyAr", "makeupdata onDataLoaded size: " + (AlaLiveMultiBeautyArView.this.gnx == null ? "null" : Integer.valueOf(AlaLiveMultiBeautyArView.this.gnx.size())));
                }
                AlaLiveMultiBeautyArView.this.setMakeupData(bQb);
            }
        });
        this.gnz.ce(this);
        this.gnz.a(new j.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.j.a
            public void a(k kVar, View view) {
                AlaLiveMultiBeautyArView.this.H(false, true);
            }
        });
        findViewById(a.f.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveMultiBeautyArView.this.bRk();
            }
        });
        this.gnF = (TextView) findViewById(a.f.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bRl();
            }
        }, 1000L);
        String string = com.baidu.live.d.BM().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
        this.gnq.c(this.gns);
        this.gnq.show(false);
    }

    private boolean isShow() {
        ViewParent parent = getParent();
        return parent != null && (parent instanceof ViewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRk() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        DB();
        if (this.gnD != null) {
            this.gnD.DC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar) {
        this.gny.goF = dVar;
        this.gny.a(new l.a<com.baidu.tieba.ala.alaar.makeup.c>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
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
                if (AlaLiveMultiBeautyArView.this.gnE != null) {
                    try {
                        jSONObject.put("makeup_id", AlaLiveMultiBeautyArView.this.gnE.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("makeupbar_clk", jSONObject);
            }
        });
        this.gny.a(dVar, this);
        this.gny.setTitle(dVar.bPH());
        H(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        this.gny.goF = aVar;
        this.gny.cd(this);
        this.gny.setTitle(aVar.gof);
        this.gny.a(new l.a<com.baidu.live.ar.g>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.g gVar, boolean z) {
                AlaLiveMultiBeautyArView.this.gnC.aFm = gVar.getType();
                AlaLiveMultiBeautyArView.this.gnC.aFn = gVar.Dx();
                AlaLiveMultiBeautyArView.this.gnC.aFo = gVar.Dw();
                AlaLiveMultiBeautyArView.this.gnC.aFp = gVar;
                String GJ = AlaLiveMultiBeautyArView.this.gny.gov.GJ(gVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.Gq(gVar.Dv())) {
                    GJ = com.baidu.tieba.ala.alaar.sticker.a.d.Gt(com.baidu.tieba.ala.alaar.sticker.a.d.Gp(gVar.Dv()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, GJ));
                AlaLiveMultiBeautyArView.this.gns.goH.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.gnC.gm(AlaLiveMultiBeautyArView.this.gnC.aFm), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gnC.aFo).intValue());
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
                if (AlaLiveMultiBeautyArView.this.gnC.aFj != null) {
                    String str = null;
                    try {
                        if (AlaLiveMultiBeautyArView.this.gnC.aFp != null) {
                            str = AlaLiveMultiBeautyArView.this.gnC.aFp.getName();
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
            this.gnC.a(false, this.bAN.Dz().aEU);
            List<com.baidu.live.ar.g> list = this.bAN.Dz().aEU;
            this.gny.gov.e(list, this.gny.gov.i(list, this.gnC.aFm));
            this.gny.gov.notifyDataSetChanged();
            if (TextUtils.equals(this.gnC.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.gnC.aFo)) {
                        i = Integer.valueOf(this.gnC.aFo).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                a(this.gnC.gm(this.gnC.aFm), false, i);
            }
        }
        H(true, true);
        bRo();
        this.gnz.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeupData(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        boolean z = true;
        this.gnx = cVar;
        if (cVar != null && cVar.bQh() != null && cVar.Dt()) {
            bRp();
            this.gnv.setEnable(true);
            this.gnv.gpi.setData(cVar.bQh().getData());
            if (this.gnx != null) {
                this.gnv.setPosition(this.gnx.getPosition());
            }
            o oVar = this.gnv;
            if (!cVar.bQi() || cVar.bQj()) {
                z = false;
            }
            oVar.lS(z);
            return;
        }
        this.gnv.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRl() {
        if (com.baidu.live.d.BM().getInt("beauty_tab_redot", 0) != 1) {
            this.gns.lS(false);
        } else if (com.baidu.live.d.BM().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.d.BM().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.d.BM().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.d.BM().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.gns.goT.bRu()) {
            this.gns.lS(true);
        } else {
            this.gns.lS(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements h.a {
        com.baidu.tieba.ala.alaar.makeup.c gnJ;
        com.baidu.tieba.ala.alaar.makeup.d gnK;
        int pos;

        public a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
            this.pos = i;
            this.gnJ = cVar;
            this.gnK = dVar;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aD(Object obj) {
            if (this.gnK != null && AlaLiveMultiBeautyArView.this.gny != null && AlaLiveMultiBeautyArView.this.gny.goF == this.gnK) {
                AlaLiveMultiBeautyArView.this.gny.gou.notifyDataSetChanged();
            } else if (this.gnJ instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gnv.gpi.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aE(Object obj) {
            if (this.gnK != null && AlaLiveMultiBeautyArView.this.gny != null && AlaLiveMultiBeautyArView.this.gny.goF == this.gnK) {
                AlaLiveMultiBeautyArView.this.gny.gou.uQ(this.pos);
                AlaLiveMultiBeautyArView.this.gny.gou.notifyDataSetChanged();
            } else if (this.gnK != null && this.pos == this.gnK.gju) {
                AlaLiveMultiBeautyArView.this.b(this.pos, this.gnJ, this.gnK);
            } else if (this.gnJ instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gnv.gpi.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void a(Object obj, int i, int i2, String str) {
            if (this.gnK != null && AlaLiveMultiBeautyArView.this.gny != null && AlaLiveMultiBeautyArView.this.gny.goF == this.gnK) {
                AlaLiveMultiBeautyArView.this.gny.gou.notifyDataSetChanged();
            } else if (this.gnJ instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gnv.gpi.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
        if (dVar != null) {
            dVar.gju = i;
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
        this.gnE = cVar;
        if ("makeupClose".equals(cVar.getTypeName())) {
            bRr();
        }
        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
        aVar.setResPath(cVar.bPP());
        aVar.setType(cVar.getType().name());
        aVar.setValue(cVar.bPN());
        this.gnC.aFq = aVar;
        if (this.gnD != null) {
            this.gnD.a(aVar);
        }
        if (this.gnq.gpm == this.gnv) {
            boolean z = cVar.bPK() > cVar.bPL();
            this.gns.lT(z);
            if (z) {
                try {
                    this.gns.goH.setProcessDiff(0);
                    this.gnv.C(cVar.bPL(), cVar.bPK(), cVar.bPM(), cVar.getValue());
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void DB() {
        if (this.gnC != null) {
            com.baidu.live.d.BM().putString("ala_beauty_config_ar", this.gnC.toJsonString());
            com.baidu.tieba.ala.alaar.makeup.g.bPZ().bQe();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.j jVar) {
        this.bAN = jVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bqi = bdPageContext;
        gnG = BdUtilHelper.getScreenSize(this.bqi.getPageActivity()).widthPixels;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(w wVar) {
        this.aFN = wVar;
    }

    private com.baidu.live.ar.g getCurThinFace() {
        if (TextUtils.isEmpty(this.gnC.aFm) || this.bAN == null || this.bAN.Dz() == null || this.bAN.Dz().aEU == null) {
            return null;
        }
        List<com.baidu.live.ar.g> list = this.bAN.Dz().aEU;
        com.baidu.live.ar.g gVar = null;
        for (int i = 0; i < list.size(); i++) {
            gVar = list.get(i);
            if (TextUtils.equals(this.gnC.aFm, gVar.getType())) {
                return gVar;
            }
        }
        return gVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        com.baidu.tieba.ala.alaar.makeup.c bPW;
        String str;
        int gn;
        JSONArray jSONArray = new JSONArray();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            if (TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                com.baidu.live.ar.g curThinFace = getCurThinFace();
                if (curThinFace != null && !TextUtils.isEmpty(curThinFace.getName())) {
                    str = curThinFace.getName();
                    gn = this.gnC.gm(this.gnC.aFm);
                }
                str = null;
                gn = 0;
            } else {
                if (this.gns.goT != null) {
                    for (int i = 0; i < this.gns.goT.gnZ.length; i++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gns.goT.gnZ[i].gog)) {
                            c.a aVar = this.gns.goT.gnZ[i];
                            int i2 = aVar.goh;
                            str = aVar.gof;
                            gn = this.gnC.gn(beautyAdjustKey.getJsonKey()) + i2;
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
        if (this.gnC.aFi != null) {
            try {
                jSONObject2.put("filter_id", this.gnC.aFi.getId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        r("filter_suc", jSONObject2);
        if (com.baidu.tieba.ala.alaar.makeup.g.bPZ().bQa()) {
            JSONArray jSONArray2 = new JSONArray();
            List<com.baidu.tieba.ala.alaar.makeup.d> bQc = com.baidu.tieba.ala.alaar.makeup.g.bPZ().bQc();
            if (bQc != null && bQc.size() > 0) {
                for (int i3 = 0; i3 < bQc.size(); i3++) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bQc.get(i3);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bPW = dVar.bPW()) != null && bPW.bPL() < bPW.bPK()) {
                        jSONArray2.put(bPW.getId());
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
            i2 = com.baidu.live.ar.d.aFu.gn(this.gnC.aFj) + this.gnt;
        }
        J(100, i, i2);
    }

    public void J(int i, int i2, int i3) {
        this.gns.goH.setMax(i);
        if (Build.VERSION.SDK_INT >= 24) {
            this.gns.goH.setProgress(i2, true);
        } else {
            this.gns.goH.setProgress(i2);
        }
        this.gns.goH.setDefThumbPos(i3);
    }

    @Deprecated
    private static void bRm() {
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
            int i7 = iArr[0] - ((gnG - ds120) / 2);
            int i8 = z ? ((i - 1) * (ds120 + ds20)) + ds28 + ds3 + ds20 : ((ds120 + ds20) * i) + ds28;
            int i9 = ((i4 - i) - 1) * (ds120 + ds20);
            if ((gnG - ds120) / 2 > i8) {
                return (((gnG - ds120) / 2) - i8) + i7;
            }
            return (gnG - ds120) / 2 > i9 ? i7 - (((gnG - ds120) / 2) - i9) : i7;
        }
        return i5;
    }

    public static int bE(int i, int i2) {
        return Math.max(0, Math.min((i - ds120) >> 1, ((ds120 + ds20) * i2) + ds28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRn() {
        if (this.gnA != null) {
            this.gnA.dismiss();
            this.gnA = null;
        }
        String string = getContext().getString(a.h.ar_beauty_is_reset);
        this.gnA = new BdAlertDialog((Activity) getContext());
        this.gnA.setAutoNight(false);
        this.gnA.setMessage(string);
        this.gnA.setPositiveButton(getContext().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.DD();
                AlaLiveMultiBeautyArView.this.ID();
            }
        });
        this.gnA.setNegativeButton(getContext().getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.ID();
            }
        });
        this.gnA.setCancelable(false);
        this.gnA.setCanceledOnTouchOutside(false);
        this.gnA.setTitleShowCenter(true);
        this.gnA.setMessageShowCenter(true);
        this.gnA.isShowTitleAndMessage();
        this.gnA.create(this.bqi);
        this.gnA.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD() {
        if (this.gnD != null) {
            this.gnD.DD();
        }
        bRs();
        String str = this.gnC.aFm;
        String str2 = this.gnC.aFn;
        String str3 = this.gnC.aFo;
        String str4 = com.baidu.live.ar.d.aFv.aFj;
        com.baidu.live.ar.d.aFv.r(com.baidu.live.ar.d.aFu.toJsonString(), true);
        com.baidu.live.ar.d.aFv.aFj = str4;
        com.baidu.live.ar.d.aFv.aFm = str;
        com.baidu.live.ar.d.aFv.aFn = str2;
        com.baidu.live.ar.d.aFv.aFo = str3;
        this.gnC = com.baidu.live.ar.d.aFv;
        if (this.bAN != null && this.bAN.Dz() != null && this.bAN.Dz().aEU != null) {
            this.gnC.a(true, this.bAN.Dz().aEU);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int gm = this.gnC.gm(str);
            this.gns.goH.setProcessDiff(0);
            a(gm, false, gm);
            return;
        }
        uI(this.gnC.gn(this.gnC.aFj) + this.gnt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID() {
        if (this.gnA != null) {
            this.gnA.dismiss();
            this.gnA = null;
        }
        this.gnA = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gnB) {
            this.gnB = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && isShow()) {
            bRk();
            return true;
        }
        return false;
    }

    private void bRo() {
        if (!TextUtils.isEmpty(this.gnC.aFm)) {
            if (TextUtils.isEmpty(this.gnC.aFo)) {
                uI(this.gnC.gm(this.gnC.aFm));
                return;
            }
            try {
                this.gns.goH.setProcessDiff(0);
                a(this.gnC.gm(this.gnC.aFm), false, Integer.valueOf(this.gnC.aFo).intValue());
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
        if (this.gns != null && this.gns.isEnable()) {
            GC("beautytab_show");
        }
        if (this.gnv != null && this.gnv.isEnable()) {
            GC("makeuptab_show");
        }
        if (this.gnr != null && this.gnr.isEnable()) {
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
            this.gnq.dismiss(z2);
            if (this.gny != null) {
                this.gnz.setTitle(this.gny.getTitle());
            }
            this.gnz.show(z2);
            return;
        }
        if (this.gnq.gpm == this.gnv) {
            this.gns.lT(false);
        }
        this.gnz.dismiss(z2);
        this.gnq.show(z2);
        bRl();
        if (!this.gns.goT.bRu()) {
            this.gns.goT.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.l lVar) {
        this.gnD = lVar;
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
        this.gnC = com.baidu.live.ar.d.aFv;
        setBeautyAdjustUserData2AR(false);
        bRp();
        if (this.gnq.gpm == this.gns && !TextUtils.equals(this.gnC.aFj, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            uI(this.gnC.gn(this.gnC.aFj) + this.gnt);
        }
        this.gns.goT.GF(this.gnC.aFj);
        this.gns.goT.notifyDataSetChanged();
        if (this.bAN != null && this.bAN.Dz() != null && this.bAN.Dz().aET != null) {
            this.gnr.gpa.setDatas(this.bAN.Dz().aET);
            if (!TextUtils.isEmpty(getFilterFileName())) {
                this.gnr.gpa.setSelect(h(this.bAN.Dz().aET, getFilterFileName()));
            }
        }
        this.gnr.gpa.notifyDataSetChanged();
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
        if (this.gnD != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.gns.goT != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.gns.goT.gnZ.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gns.goT.gnZ[i2].gog)) {
                            i = this.gns.goT.gnZ[i2].goh;
                        }
                    }
                } else {
                    i = 0;
                }
                this.gnD.a(((this.gnC.gn(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bRs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRp() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bQc;
        com.baidu.tieba.ala.alaar.makeup.c bPW;
        if (this.gnD != null && com.baidu.tieba.ala.alaar.makeup.g.bPZ().bQa() && (bQc = com.baidu.tieba.ala.alaar.makeup.g.bPZ().bQc()) != null && bQc.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bQc.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bQc.get(i2);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bPW = dVar.bPW()) != null && bPW.bPL() < bPW.bPK()) {
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bPW.getTypeName());
                        aVar.setValue(bPW.bPN());
                        aVar.setResPath(bPW.bPP());
                        this.gnD.a(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRq() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bQc = com.baidu.tieba.ala.alaar.makeup.g.bPZ().bQc();
        if (this.gnD != null && bQc != null && bQc.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bQc.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bQc.get(i2);
                    if (dVar == null || !"makeupClose".equals(dVar.getTypeName())) {
                        i = i2 + 1;
                    } else {
                        com.baidu.tieba.ala.alaar.makeup.c bPW = dVar.bPW();
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bPW.getTypeName());
                        aVar.setValue(bPW.bPN());
                        aVar.setResPath(bPW.bPP());
                        this.gnD.a(aVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bRr() {
        com.baidu.tieba.ala.alaar.makeup.a.b bQh = this.gnx.bQh();
        if (bQh != null) {
            List<com.baidu.tieba.ala.alaar.makeup.d> data = bQh.getData();
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
        if (this.gnD != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.gnC.aFn);
            this.gnD.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bRs() {
        setThinFace(this.gnC.gm(this.gnC.aFm));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE(String str) {
        this.gnF.setText(str);
        this.gnF.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gnF, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gnF, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gnF, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.gnF, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void DA() {
        if (this.gns.goT != null) {
            this.gns.goT.notifyDataSetChanged();
        }
        if (this.gnr.gpa != null) {
            this.gnr.gpa.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
