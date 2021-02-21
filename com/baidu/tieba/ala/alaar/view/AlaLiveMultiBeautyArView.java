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
/* loaded from: classes11.dex */
public class AlaLiveMultiBeautyArView extends ILiveMultiBeautyView implements View.OnClickListener {
    private static int ds120;
    private static int ds20;
    private static int ds28;
    private static int ds3;
    private static int gwu;
    private ab aDd;
    private com.baidu.live.ar.k bEu;
    private BdPageContext bqG;
    private final p gwe;
    private final n gwf;
    private final m gwg;
    int gwh;
    private c.a gwi;
    private final o gwj;
    private int gwk;
    private com.baidu.tieba.ala.alaar.makeup.a.c gwl;
    private final i gwm;
    private k gwn;
    private BdAlertDialog gwo;
    private boolean gwp;
    private com.baidu.live.ar.e gwq;
    private com.baidu.live.ar.m gwr;
    private com.baidu.tieba.ala.alaar.makeup.c gws;
    private TextView gwt;

    static /* synthetic */ int b(AlaLiveMultiBeautyArView alaLiveMultiBeautyArView) {
        int i = alaLiveMultiBeautyArView.gwk;
        alaLiveMultiBeautyArView.gwk = i + 1;
        return i;
    }

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.gwe = new p();
        this.gwf = new n();
        this.gwg = new m();
        this.gwh = 0;
        this.gwj = new o();
        this.gwm = new i();
        this.gwn = new k();
        this.gwp = true;
        this.gwq = com.baidu.live.ar.e.aCF;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwe = new p();
        this.gwf = new n();
        this.gwg = new m();
        this.gwh = 0;
        this.gwj = new o();
        this.gwm = new i();
        this.gwn = new k();
        this.gwp = true;
        this.gwq = com.baidu.live.ar.e.aCF;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwe = new p();
        this.gwf = new n();
        this.gwg = new m();
        this.gwh = 0;
        this.gwj = new o();
        this.gwm = new i();
        this.gwn = new k();
        this.gwp = true;
        this.gwq = com.baidu.live.ar.e.aCF;
        initViews();
    }

    public void setFilterFileName(String str) {
        this.gwq.aCr = str;
    }

    public String getFilterFileName() {
        if (TextUtils.isEmpty(this.gwq.aCr) && this.gwq.aCs != null) {
            this.gwq.aCr = com.baidu.tieba.ala.alaar.sticker.a.e.FB(this.gwq.aCs.zx());
        }
        return this.gwq.aCr;
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_beauty_ar_hor_layout, this);
        bQE();
        this.gwk = 0;
        this.gwe.cj(this);
        this.gwe.a(new p.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.tieba.ala.alaar.view.p.a
            public void a(l lVar) {
                if (lVar != AlaLiveMultiBeautyArView.this.gwj) {
                    if (lVar == AlaLiveMultiBeautyArView.this.gwf) {
                        AlaLiveMultiBeautyArView.this.gwf.tF(AlaLiveMultiBeautyArView.this.gwq.fc(AlaLiveMultiBeautyArView.this.getFilterFileName()));
                        return;
                    } else if (lVar == AlaLiveMultiBeautyArView.this.gwg && AlaLiveMultiBeautyArView.this.gwq != null) {
                        if (!TextUtils.equals(AlaLiveMultiBeautyArView.this.gwq.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            AlaLiveMultiBeautyArView.this.tu(AlaLiveMultiBeautyArView.this.gwq.fe(AlaLiveMultiBeautyArView.this.gwq.aCt) + AlaLiveMultiBeautyArView.this.gwh);
                            AlaLiveMultiBeautyArView.this.gwg.gxv.setProcessDiff(AlaLiveMultiBeautyArView.this.gwh);
                            return;
                        }
                        try {
                            AlaLiveMultiBeautyArView.this.c(AlaLiveMultiBeautyArView.this.gwq.fd(AlaLiveMultiBeautyArView.this.gwq.aCw), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gwq.aCy).intValue());
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                AlaLiveMultiBeautyArView.b(AlaLiveMultiBeautyArView.this);
                if (AlaLiveMultiBeautyArView.this.gwl != null && !AlaLiveMultiBeautyArView.this.gwl.bPD()) {
                    AlaLiveMultiBeautyArView.this.gwl.ml(true);
                }
                if (AlaLiveMultiBeautyArView.this.gwk == 1 && AlaLiveMultiBeautyArView.this.gwj.gxW != null) {
                    AlaLiveMultiBeautyArView.this.gwj.tD(AlaLiveMultiBeautyArView.this.gwj.gxW.getCurrentPosition());
                }
                AlaLiveMultiBeautyArView.this.gwj.mp(false);
            }
        });
        this.gwf.cj(this);
        this.gwf.setTitle(getResources().getString(a.h.ala_live_new_beauty_filter));
        this.gwe.b(this.gwf);
        this.gwf.c(new com.baidu.tieba.ala.alaar.view.a(getContext()));
        this.gwf.a(new l.a<com.baidu.live.ar.i>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.i iVar, boolean z) {
                String FB;
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.h.beauty_yuantu).equals(iVar.getName())) {
                    com.baidu.minivideo.arface.b.abI();
                    FB = com.baidu.minivideo.arface.c.abP();
                } else {
                    FB = com.baidu.tieba.ala.alaar.sticker.a.e.FB(iVar.zx());
                }
                if (!AlaLiveMultiBeautyArView.this.gwq.aCr.equals(FB)) {
                    AlaLiveMultiBeautyArView.this.FP(iVar.getName());
                }
                AlaLiveMultiBeautyArView.this.setFilterFileName(FB);
                AlaLiveMultiBeautyArView.this.gwq.aCs = iVar;
                if (AlaLiveMultiBeautyArView.this.gwr != null && AlaLiveMultiBeautyArView.this.bEu.zB() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gwq.a(iVar, AlaLiveMultiBeautyArView.this.bEu.zB().aCd);
                    int fc = AlaLiveMultiBeautyArView.this.gwq.fc(AlaLiveMultiBeautyArView.this.getFilterFileName());
                    float f = (((fc * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + fc + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gwr.onFilterSelected(AlaLiveMultiBeautyArView.this.gwq.aCs.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
                if (AlaLiveMultiBeautyArView.this.gwe.gya == AlaLiveMultiBeautyArView.this.gwf) {
                    AlaLiveMultiBeautyArView.this.gwf.tF(AlaLiveMultiBeautyArView.this.gwq.fc(AlaLiveMultiBeautyArView.this.getFilterFileName()));
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
                AlaLiveMultiBeautyArView.this.gwq.A(AlaLiveMultiBeautyArView.this.getFilterFileName(), i);
                if (AlaLiveMultiBeautyArView.this.gwr != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gwq.a(AlaLiveMultiBeautyArView.this.gwq.aCs, AlaLiveMultiBeautyArView.this.bEu.zB().aCd);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gwr.onFilterSelected(AlaLiveMultiBeautyArView.this.gwq.aCs.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gwq.aCs != null) {
                    try {
                        jSONObject.put("filter_id", AlaLiveMultiBeautyArView.this.gwq.aCs.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("filterbar_clk", jSONObject);
            }
        });
        this.gwg.cj(this);
        this.gwg.setTitle(getResources().getString(a.h.ala_live_new_beauty_beauty));
        this.gwe.b(this.gwg);
        this.gwg.a(new l.a<c.a>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, c.a aVar, boolean z) {
                if (AlaLiveMultiBeautyArView.this.gwe.gya == AlaLiveMultiBeautyArView.this.gwg) {
                    if (i == 0) {
                        AlaLiveMultiBeautyArView.this.bQF();
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gwq.aCt = aVar.gwU;
                    AlaLiveMultiBeautyArView.this.gwg.gxH.FT(aVar.gwU);
                    AlaLiveMultiBeautyArView.this.bQD();
                    if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gwq.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (AlaLiveMultiBeautyArView.this.gwe.gya == AlaLiveMultiBeautyArView.this.gwg && z) {
                            AlaLiveMultiBeautyArView.this.a(aVar);
                            return;
                        }
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gwi = aVar;
                    if (aVar != null) {
                        AlaLiveMultiBeautyArView.this.gwh = aVar.gwV;
                    }
                    AlaLiveMultiBeautyArView.this.tu(AlaLiveMultiBeautyArView.this.gwq.fe(AlaLiveMultiBeautyArView.this.gwq.aCt) + AlaLiveMultiBeautyArView.this.gwh);
                    AlaLiveMultiBeautyArView.this.gwg.gxv.setProcessDiff(AlaLiveMultiBeautyArView.this.gwh);
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
                if (AlaLiveMultiBeautyArView.this.gwe.gya == AlaLiveMultiBeautyArView.this.gwj) {
                    if (z && AlaLiveMultiBeautyArView.this.gws != null) {
                        AlaLiveMultiBeautyArView.this.gws.setValue(i);
                        if (AlaLiveMultiBeautyArView.this.gwq.aCA != null) {
                            AlaLiveMultiBeautyArView.this.gwq.aCA.setValue(AlaLiveMultiBeautyArView.this.gws.bPh());
                            AlaLiveMultiBeautyArView.this.gwr.a(AlaLiveMultiBeautyArView.this.gwq.aCA);
                        }
                    }
                } else if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gwq.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.gwq.cm(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.gwq.aCw) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.gwq.aCw)) && com.baidu.live.d.xc().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.d.xc().getBoolean("naturalFace", true)) {
                        com.baidu.live.d.xc().putBoolean("naturalFace", false);
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.gwq.B(AlaLiveMultiBeautyArView.this.gwq.aCt, i - AlaLiveMultiBeautyArView.this.gwh);
                    if (AlaLiveMultiBeautyArView.this.gwr != null) {
                        AlaLiveMultiBeautyArView.this.gwr.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fb(AlaLiveMultiBeautyArView.this.gwq.aCt));
                    }
                }
                if (z) {
                    com.baidu.live.d.xc().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (AlaLiveMultiBeautyArView.this.gwe.gya != AlaLiveMultiBeautyArView.this.gwj) {
                    if (AlaLiveMultiBeautyArView.this.gwq.aCt != null) {
                        String str = null;
                        if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gwq.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            if (AlaLiveMultiBeautyArView.this.gwq.aCz != null) {
                                str = AlaLiveMultiBeautyArView.this.gwq.aCz.getName();
                            }
                        } else {
                            str = AlaLiveMultiBeautyArView.this.gwi.gwT;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (AlaLiveMultiBeautyArView.this.gwi != null && str != null) {
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
                if (AlaLiveMultiBeautyArView.this.gws != null) {
                    try {
                        jSONObject2.put("makeup_id", AlaLiveMultiBeautyArView.this.gws.getId());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("makeupbar_clk", jSONObject2);
            }
        });
        this.gwg.gxM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.gwe.gya == AlaLiveMultiBeautyArView.this.gwj) {
                            AlaLiveMultiBeautyArView.this.bQI();
                            break;
                        } else {
                            if (AlaLiveMultiBeautyArView.this.gwr != null) {
                                AlaLiveMultiBeautyArView.this.gwr.zF();
                            }
                            AlaLiveMultiBeautyArView.this.setThinFace(0);
                            break;
                        }
                    case 1:
                    case 3:
                    case 4:
                        if (AlaLiveMultiBeautyArView.this.gwe.gya == AlaLiveMultiBeautyArView.this.gwj) {
                            AlaLiveMultiBeautyArView.this.bQH();
                            break;
                        } else {
                            AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                            break;
                        }
                }
                return true;
            }
        });
        this.gwj.cj(this);
        this.gwj.tE(0);
        this.gwj.setTitle(getResources().getString(a.h.ala_live_new_beauty_makeup));
        this.gwe.b(this.gwj);
        this.gwj.a(new l.a<com.baidu.tieba.ala.alaar.makeup.d>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemSelected pos= " + i + ", name=" + dVar.bPb());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bPp = dVar.bPp();
                if (dVar.azu() || bPp == null || bPp.isEmpty()) {
                    AlaLiveMultiBeautyArView.this.b(i, dVar, null);
                } else if (AlaLiveMultiBeautyArView.this.gwe.gya == AlaLiveMultiBeautyArView.this.gwj) {
                    AlaLiveMultiBeautyArView.this.a(dVar);
                }
                if (AlaLiveMultiBeautyArView.this.gwl != null) {
                    AlaLiveMultiBeautyArView.this.gwl.setPosition(i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemClick pos= " + i + ", name=" + dVar.bPb());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bPp = dVar.bPp();
                if (dVar.azu() || bPp == null || bPp.isEmpty()) {
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
        if (this.gwl != null) {
            this.gwj.setPosition(this.gwl.getPosition());
        }
        com.baidu.tieba.ala.alaar.makeup.g.bPt().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.tieba.ala.alaar.makeup.a.b
            public void c(com.baidu.tieba.ala.alaar.makeup.a aVar) {
                com.baidu.tieba.ala.alaar.makeup.a.c bPv = com.baidu.tieba.ala.alaar.makeup.g.bPt().bPv();
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("BeautyAr", "makeupdata onDataLoaded size: " + (AlaLiveMultiBeautyArView.this.gwl == null ? "null" : Integer.valueOf(AlaLiveMultiBeautyArView.this.gwl.size())));
                }
                AlaLiveMultiBeautyArView.this.setMakeupData(bPv);
            }
        });
        this.gwn.cj(this);
        this.gwn.a(new j.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.j.a
            public void a(k kVar, View view) {
                AlaLiveMultiBeautyArView.this.J(false, true);
            }
        });
        findViewById(a.f.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveMultiBeautyArView.this.bQC();
            }
        });
        this.gwt = (TextView) findViewById(a.f.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bQD();
            }
        }, 1000L);
        String string = com.baidu.live.d.xc().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
        this.gwe.c(this.gwg);
        this.gwe.show(false);
    }

    private boolean isShow() {
        ViewParent parent = getParent();
        return parent != null && (parent instanceof ViewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQC() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        zD();
        if (this.gwr != null) {
            this.gwr.onClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar) {
        this.gwm.gxt = dVar;
        this.gwm.a(new l.a<com.baidu.tieba.ala.alaar.makeup.c>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
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
                if (AlaLiveMultiBeautyArView.this.gws != null) {
                    try {
                        jSONObject.put("makeup_id", AlaLiveMultiBeautyArView.this.gws.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("makeupbar_clk", jSONObject);
            }
        });
        this.gwm.a(dVar, this);
        this.gwm.setTitle(dVar.bPb());
        J(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        this.gwm.gxt = aVar;
        this.gwm.ci(this);
        this.gwm.setTitle(aVar.gwT);
        this.gwm.a(new l.a<com.baidu.live.ar.h>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.h hVar, boolean z) {
                AlaLiveMultiBeautyArView.this.gwq.aCw = hVar.getType();
                AlaLiveMultiBeautyArView.this.gwq.aCx = hVar.zz();
                AlaLiveMultiBeautyArView.this.gwq.aCy = hVar.zy();
                AlaLiveMultiBeautyArView.this.gwq.aCz = hVar;
                String FU = AlaLiveMultiBeautyArView.this.gwm.gxj.FU(hVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.FC(hVar.zx())) {
                    FU = com.baidu.tieba.ala.alaar.sticker.a.d.FF(com.baidu.tieba.ala.alaar.sticker.a.d.FB(hVar.zx()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, FU));
                AlaLiveMultiBeautyArView.this.gwg.gxv.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.c(AlaLiveMultiBeautyArView.this.gwq.fd(AlaLiveMultiBeautyArView.this.gwq.aCw), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gwq.aCy).intValue());
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
                if (AlaLiveMultiBeautyArView.this.gwq.aCt != null) {
                    String str = null;
                    try {
                        if (AlaLiveMultiBeautyArView.this.gwq.aCz != null) {
                            str = AlaLiveMultiBeautyArView.this.gwq.aCz.getName();
                        }
                        jSONObject.put("beauty_name", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("beautybar_clk", jSONObject);
            }
        });
        if (this.bEu != null && this.bEu.zB() != null && this.bEu.zB().aCe != null) {
            this.gwq.b(false, this.bEu.zB().aCe);
            List<com.baidu.live.ar.h> list = this.bEu.zB().aCe;
            this.gwm.gxj.e(list, this.gwm.gxj.h(list, this.gwq.aCw));
            this.gwm.gxj.notifyDataSetChanged();
            if (TextUtils.equals(this.gwq.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.gwq.aCy)) {
                        i = Integer.valueOf(this.gwq.aCy).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                c(this.gwq.fd(this.gwq.aCw), false, i);
            }
        }
        J(true, true);
        bQG();
        this.gwn.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeupData(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        boolean z = true;
        this.gwl = cVar;
        if (cVar != null && cVar.bPB() != null && cVar.zv()) {
            bQH();
            this.gwj.setEnable(true);
            this.gwj.gxW.setData(cVar.bPB().getData());
            if (this.gwl != null) {
                this.gwj.setPosition(this.gwl.getPosition());
            }
            o oVar = this.gwj;
            if (!cVar.bPC() || cVar.bPD()) {
                z = false;
            }
            oVar.mp(z);
            return;
        }
        this.gwj.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQD() {
        if (com.baidu.live.d.xc().getInt("beauty_tab_redot", 0) != 1) {
            this.gwg.mp(false);
        } else if (com.baidu.live.d.xc().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.d.xc().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.d.xc().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.d.xc().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.gwg.gxH.bQM()) {
            this.gwg.mp(true);
        } else {
            this.gwg.mp(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements h.a {
        com.baidu.tieba.ala.alaar.makeup.c gwx;
        com.baidu.tieba.ala.alaar.makeup.d gwy;
        int pos;

        public a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
            this.pos = i;
            this.gwx = cVar;
            this.gwy = dVar;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void J(Object obj) {
            if (this.gwy != null && AlaLiveMultiBeautyArView.this.gwm != null && AlaLiveMultiBeautyArView.this.gwm.gxt == this.gwy) {
                AlaLiveMultiBeautyArView.this.gwm.gxi.notifyDataSetChanged();
            } else if (this.gwx instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gwj.gxW.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aF(Object obj) {
            if (this.gwy != null && AlaLiveMultiBeautyArView.this.gwm != null && AlaLiveMultiBeautyArView.this.gwm.gxt == this.gwy) {
                AlaLiveMultiBeautyArView.this.gwm.gxi.tC(this.pos);
                AlaLiveMultiBeautyArView.this.gwm.gxi.notifyDataSetChanged();
            } else if (this.gwy != null && this.pos == this.gwy.gsj) {
                AlaLiveMultiBeautyArView.this.b(this.pos, this.gwx, this.gwy);
            } else if (this.gwx instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gwj.gxW.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void a(Object obj, int i, int i2, String str) {
            if (this.gwy != null && AlaLiveMultiBeautyArView.this.gwm != null && AlaLiveMultiBeautyArView.this.gwm.gxt == this.gwy) {
                AlaLiveMultiBeautyArView.this.gwm.gxi.notifyDataSetChanged();
            } else if (this.gwx instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gwj.gxW.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
        if (dVar != null) {
            dVar.gsj = i;
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
        this.gws = cVar;
        if ("makeupClose".equals(cVar.getTypeName())) {
            bQJ();
        }
        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
        aVar.setResPath(cVar.bPj());
        aVar.setType(cVar.getType().name());
        aVar.setValue(cVar.bPh());
        this.gwq.aCA = aVar;
        if (this.gwr != null) {
            this.gwr.a(aVar);
        }
        if (this.gwe.gya == this.gwj) {
            boolean z = cVar.bPe() > cVar.bPf();
            this.gwg.mq(z);
            if (z) {
                try {
                    this.gwg.gxv.setProcessDiff(0);
                    this.gwj.D(cVar.bPf(), cVar.bPe(), cVar.bPg(), cVar.getValue());
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void zD() {
        if (this.gwq != null) {
            com.baidu.live.d.xc().putString("ala_beauty_config_ar", this.gwq.toJsonString());
            com.baidu.tieba.ala.alaar.makeup.g.bPt().bPy();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.k kVar) {
        this.bEu = kVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bqG = bdPageContext;
        gwu = BdUtilHelper.getScreenSize(this.bqG.getPageActivity()).widthPixels;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(ab abVar) {
        this.aDd = abVar;
    }

    private com.baidu.live.ar.h getCurThinFace() {
        com.baidu.live.ar.h hVar = null;
        if (TextUtils.isEmpty(this.gwq.aCw) || this.bEu == null || this.bEu.zB() == null || this.bEu.zB().aCe == null) {
            return null;
        }
        List<com.baidu.live.ar.h> list = this.bEu.zB().aCe;
        int i = 0;
        while (i < list.size()) {
            com.baidu.live.ar.h hVar2 = list.get(i);
            if (TextUtils.equals(this.gwq.aCw, hVar2.getType())) {
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
        com.baidu.tieba.ala.alaar.makeup.c bPq;
        int fe;
        JSONArray jSONArray = new JSONArray();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            String str = null;
            if (TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                com.baidu.live.ar.h curThinFace = getCurThinFace();
                if (curThinFace != null && !TextUtils.isEmpty(curThinFace.getName())) {
                    str = curThinFace.getName();
                    fe = this.gwq.fd(this.gwq.aCw);
                }
                fe = 0;
            } else {
                if (this.gwg.gxH != null) {
                    for (int i = 0; i < this.gwg.gxH.gwN.length; i++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gwg.gxH.gwN[i].gwU)) {
                            c.a aVar = this.gwg.gxH.gwN[i];
                            int i2 = aVar.gwV;
                            str = aVar.gwT;
                            fe = this.gwq.fe(beautyAdjustKey.getJsonKey()) + i2;
                            break;
                        }
                    }
                }
                fe = 0;
            }
            if (fe != 0 && str != null) {
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
        if (this.gwq.aCs != null) {
            try {
                jSONObject2.put("filter_id", this.gwq.aCs.getId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        s("filter_suc", jSONObject2);
        if (com.baidu.tieba.ala.alaar.makeup.g.bPt().bPu()) {
            JSONArray jSONArray2 = new JSONArray();
            List<com.baidu.tieba.ala.alaar.makeup.d> bPw = com.baidu.tieba.ala.alaar.makeup.g.bPt().bPw();
            if (bPw != null && bPw.size() > 0) {
                for (int i3 = 0; i3 < bPw.size(); i3++) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bPw.get(i3);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bPq = dVar.bPq()) != null && bPq.bPf() < bPq.bPe()) {
                        jSONArray2.put(bPq.getId());
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
    public void tu(int i) {
        c(i, true, 0);
    }

    public void c(int i, boolean z, int i2) {
        if (z) {
            i2 = com.baidu.live.ar.e.aCE.fe(this.gwq.aCt) + this.gwh;
        }
        L(100, i, i2);
    }

    public void L(int i, int i2, int i3) {
        this.gwg.gxv.setMax(i);
        if (Build.VERSION.SDK_INT >= 24) {
            this.gwg.gxv.setProgress(i2, true);
        } else {
            this.gwg.gxv.setProgress(i2);
        }
        this.gwg.gxv.setDefThumbPos(i3);
    }

    @Deprecated
    private static void bQE() {
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
            int i7 = iArr[0] - ((gwu - ds120) / 2);
            int i8 = z ? ((i - 1) * (ds120 + ds20)) + ds28 + ds3 + ds20 : ((ds120 + ds20) * i) + ds28;
            int i9 = ((i4 - i) - 1) * (ds120 + ds20);
            if ((gwu - ds120) / 2 > i8) {
                return (((gwu - ds120) / 2) - i8) + i7;
            }
            return (gwu - ds120) / 2 > i9 ? i7 - (((gwu - ds120) / 2) - i9) : i7;
        }
        return i5;
    }

    public static int bA(int i, int i2) {
        return Math.max(0, Math.min((i - ds120) >> 1, ((ds120 + ds20) * i2) + ds28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQF() {
        if (this.gwo != null) {
            this.gwo.dismiss();
            this.gwo = null;
        }
        String string = getContext().getString(a.h.ar_beauty_is_reset);
        this.gwo = new BdAlertDialog((Activity) getContext());
        this.gwo.setAutoNight(false);
        this.gwo.setMessage(string);
        this.gwo.setPositiveButton(getContext().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.zE();
                AlaLiveMultiBeautyArView.this.FA();
            }
        });
        this.gwo.setNegativeButton(getContext().getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.FA();
            }
        });
        this.gwo.setCancelable(false);
        this.gwo.setCanceledOnTouchOutside(false);
        this.gwo.setTitleShowCenter(true);
        this.gwo.setMessageShowCenter(true);
        this.gwo.isShowTitleAndMessage();
        this.gwo.create(this.bqG);
        this.gwo.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zE() {
        if (this.gwr != null) {
            this.gwr.zE();
        }
        bQK();
        String str = this.gwq.aCw;
        String str2 = this.gwq.aCx;
        String str3 = this.gwq.aCy;
        String str4 = com.baidu.live.ar.e.aCF.aCt;
        com.baidu.live.ar.e.aCF.r(com.baidu.live.ar.e.aCE.toJsonString(), true);
        com.baidu.live.ar.e.aCF.aCt = str4;
        com.baidu.live.ar.e.aCF.aCw = str;
        com.baidu.live.ar.e.aCF.aCx = str2;
        com.baidu.live.ar.e.aCF.aCy = str3;
        this.gwq = com.baidu.live.ar.e.aCF;
        if (this.bEu != null && this.bEu.zB() != null && this.bEu.zB().aCe != null) {
            this.gwq.b(true, this.bEu.zB().aCe);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fd = this.gwq.fd(str);
            this.gwg.gxv.setProcessDiff(0);
            c(fd, false, fd);
            return;
        }
        tu(this.gwq.fe(this.gwq.aCt) + this.gwh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.gwo != null) {
            this.gwo.dismiss();
            this.gwo = null;
        }
        this.gwo = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gwp) {
            this.gwp = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && isShow()) {
            bQC();
            return true;
        }
        return false;
    }

    private void bQG() {
        if (!TextUtils.isEmpty(this.gwq.aCw)) {
            if (TextUtils.isEmpty(this.gwq.aCy)) {
                tu(this.gwq.fd(this.gwq.aCw));
                return;
            }
            try {
                this.gwg.gxv.setProcessDiff(0);
                c(this.gwq.fd(this.gwq.aCw), false, Integer.valueOf(this.gwq.aCy).intValue());
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
        if (this.gwg != null && this.gwg.isEnable()) {
            FN("beautytab_show");
        }
        if (this.gwj != null && this.gwj.isEnable()) {
            FN("makeuptab_show");
        }
        if (this.gwf != null && this.gwf.isEnable()) {
            FN("filtertab_show");
        }
    }

    private void FN(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "beauty");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int i = 0;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            i = this.aDd.mLiveInfo.live_status;
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
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            i = this.aDd.mLiveInfo.live_status;
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
            this.gwe.dismiss(z2);
            if (this.gwm != null) {
                this.gwn.setTitle(this.gwm.getTitle());
            }
            this.gwn.show(z2);
            return;
        }
        if (this.gwe.gya == this.gwj) {
            this.gwg.mq(false);
        }
        this.gwn.dismiss(z2);
        this.gwe.show(z2);
        bQD();
        if (!this.gwg.gxH.bQM()) {
            this.gwg.gxH.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.m mVar) {
        this.gwr = mVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.e.aCF.r(com.baidu.live.d.xc().getString("ala_beauty_config_ar", ""), false);
        if (TextUtils.isEmpty(com.baidu.live.ar.e.aCF.aCr) && com.baidu.minivideo.arface.b.abI() != null) {
            com.baidu.live.ar.e eVar = com.baidu.live.ar.e.aCF;
            com.baidu.minivideo.arface.b.abI();
            eVar.aCr = com.baidu.minivideo.arface.c.abP();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.j.aCT)) {
            com.baidu.minivideo.arface.b.abI();
            com.baidu.live.ar.j.fg(com.baidu.minivideo.arface.c.abP());
        }
        this.gwq = com.baidu.live.ar.e.aCF;
        setBeautyAdjustUserData2AR(false);
        bQH();
        if (this.gwe.gya == this.gwg && !TextUtils.equals(this.gwq.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            tu(this.gwq.fe(this.gwq.aCt) + this.gwh);
        }
        this.gwg.gxH.FQ(this.gwq.aCt);
        this.gwg.gxH.notifyDataSetChanged();
        if (this.bEu != null && this.bEu.zB() != null && this.bEu.zB().aCd != null) {
            this.gwf.gxO.setDatas(this.bEu.zB().aCd);
            if (!TextUtils.isEmpty(getFilterFileName())) {
                this.gwf.gxO.setSelect(g(this.bEu.zB().aCd, getFilterFileName()));
            }
        }
        this.gwf.gxO.notifyDataSetChanged();
    }

    public int g(List<com.baidu.live.ar.i> list, String str) {
        String FB;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getContext().getString(a.h.beauty_yuantu).equals(list.get(i2).getName())) {
                com.baidu.minivideo.arface.b.abI();
                FB = com.baidu.minivideo.arface.c.abP();
                i = i2;
            } else {
                FB = com.baidu.tieba.ala.alaar.sticker.a.e.FB(list.get(i2).zx());
            }
            if (str.equals(FB)) {
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
        if (this.gwr != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.gwg.gxH != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.gwg.gxH.gwN.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gwg.gxH.gwN[i2].gwU)) {
                            i = this.gwg.gxH.gwN[i2].gwV;
                        }
                    }
                } else {
                    i = 0;
                }
                this.gwr.a(((this.gwq.fe(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bQK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQH() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bPw;
        com.baidu.tieba.ala.alaar.makeup.c bPq;
        if (this.gwr != null && com.baidu.tieba.ala.alaar.makeup.g.bPt().bPu() && (bPw = com.baidu.tieba.ala.alaar.makeup.g.bPt().bPw()) != null && bPw.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bPw.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bPw.get(i2);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bPq = dVar.bPq()) != null && bPq.bPf() < bPq.bPe()) {
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bPq.getTypeName());
                        aVar.setValue(bPq.bPh());
                        aVar.setResPath(bPq.bPj());
                        this.gwr.a(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQI() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bPw = com.baidu.tieba.ala.alaar.makeup.g.bPt().bPw();
        if (this.gwr != null && bPw != null && bPw.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bPw.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bPw.get(i2);
                    if (dVar == null || !"makeupClose".equals(dVar.getTypeName())) {
                        i = i2 + 1;
                    } else {
                        com.baidu.tieba.ala.alaar.makeup.c bPq = dVar.bPq();
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bPq.getTypeName());
                        aVar.setValue(bPq.bPh());
                        aVar.setResPath(bPq.bPj());
                        this.gwr.a(aVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bQJ() {
        com.baidu.tieba.ala.alaar.makeup.a.b bPB = this.gwl.bPB();
        if (bPB != null) {
            List<com.baidu.tieba.ala.alaar.makeup.d> data = bPB.getData();
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
        if (this.gwr != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.gwq.aCx);
            this.gwr.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bQK() {
        setThinFace(this.gwq.fd(this.gwq.aCw));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(String str) {
        this.gwt.setText(str);
        this.gwt.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gwt, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gwt, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gwt, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.gwt, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void zC() {
        if (this.gwg.gxH != null) {
            this.gwg.gxH.notifyDataSetChanged();
        }
        if (this.gwf.gxO != null) {
            this.gwf.gxO.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
