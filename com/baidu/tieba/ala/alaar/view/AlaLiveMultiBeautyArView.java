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
    private static int gwg;
    private ab aDd;
    private com.baidu.live.ar.k bEu;
    private BdPageContext bqG;
    private final p gvQ;
    private final n gvR;
    private final m gvS;
    int gvT;
    private c.a gvU;
    private final o gvV;
    private int gvW;
    private com.baidu.tieba.ala.alaar.makeup.a.c gvX;
    private final i gvY;
    private k gvZ;
    private BdAlertDialog gwa;
    private boolean gwb;
    private com.baidu.live.ar.e gwc;
    private com.baidu.live.ar.m gwd;
    private com.baidu.tieba.ala.alaar.makeup.c gwe;
    private TextView gwf;

    static /* synthetic */ int b(AlaLiveMultiBeautyArView alaLiveMultiBeautyArView) {
        int i = alaLiveMultiBeautyArView.gvW;
        alaLiveMultiBeautyArView.gvW = i + 1;
        return i;
    }

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.gvQ = new p();
        this.gvR = new n();
        this.gvS = new m();
        this.gvT = 0;
        this.gvV = new o();
        this.gvY = new i();
        this.gvZ = new k();
        this.gwb = true;
        this.gwc = com.baidu.live.ar.e.aCF;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvQ = new p();
        this.gvR = new n();
        this.gvS = new m();
        this.gvT = 0;
        this.gvV = new o();
        this.gvY = new i();
        this.gvZ = new k();
        this.gwb = true;
        this.gwc = com.baidu.live.ar.e.aCF;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvQ = new p();
        this.gvR = new n();
        this.gvS = new m();
        this.gvT = 0;
        this.gvV = new o();
        this.gvY = new i();
        this.gvZ = new k();
        this.gwb = true;
        this.gwc = com.baidu.live.ar.e.aCF;
        initViews();
    }

    public void setFilterFileName(String str) {
        this.gwc.aCr = str;
    }

    public String getFilterFileName() {
        if (TextUtils.isEmpty(this.gwc.aCr) && this.gwc.aCs != null) {
            this.gwc.aCr = com.baidu.tieba.ala.alaar.sticker.a.e.FA(this.gwc.aCs.zx());
        }
        return this.gwc.aCr;
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_beauty_ar_hor_layout, this);
        bQx();
        this.gvW = 0;
        this.gvQ.cj(this);
        this.gvQ.a(new p.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.tieba.ala.alaar.view.p.a
            public void a(l lVar) {
                if (lVar != AlaLiveMultiBeautyArView.this.gvV) {
                    if (lVar == AlaLiveMultiBeautyArView.this.gvR) {
                        AlaLiveMultiBeautyArView.this.gvR.tF(AlaLiveMultiBeautyArView.this.gwc.fc(AlaLiveMultiBeautyArView.this.getFilterFileName()));
                        return;
                    } else if (lVar == AlaLiveMultiBeautyArView.this.gvS && AlaLiveMultiBeautyArView.this.gwc != null) {
                        if (!TextUtils.equals(AlaLiveMultiBeautyArView.this.gwc.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            AlaLiveMultiBeautyArView.this.tu(AlaLiveMultiBeautyArView.this.gwc.fe(AlaLiveMultiBeautyArView.this.gwc.aCt) + AlaLiveMultiBeautyArView.this.gvT);
                            AlaLiveMultiBeautyArView.this.gvS.gxh.setProcessDiff(AlaLiveMultiBeautyArView.this.gvT);
                            return;
                        }
                        try {
                            AlaLiveMultiBeautyArView.this.c(AlaLiveMultiBeautyArView.this.gwc.fd(AlaLiveMultiBeautyArView.this.gwc.aCw), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gwc.aCy).intValue());
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                AlaLiveMultiBeautyArView.b(AlaLiveMultiBeautyArView.this);
                if (AlaLiveMultiBeautyArView.this.gvX != null && !AlaLiveMultiBeautyArView.this.gvX.bPw()) {
                    AlaLiveMultiBeautyArView.this.gvX.ml(true);
                }
                if (AlaLiveMultiBeautyArView.this.gvW == 1 && AlaLiveMultiBeautyArView.this.gvV.gxI != null) {
                    AlaLiveMultiBeautyArView.this.gvV.tD(AlaLiveMultiBeautyArView.this.gvV.gxI.getCurrentPosition());
                }
                AlaLiveMultiBeautyArView.this.gvV.mp(false);
            }
        });
        this.gvR.cj(this);
        this.gvR.setTitle(getResources().getString(a.h.ala_live_new_beauty_filter));
        this.gvQ.b(this.gvR);
        this.gvR.c(new com.baidu.tieba.ala.alaar.view.a(getContext()));
        this.gvR.a(new l.a<com.baidu.live.ar.i>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.i iVar, boolean z) {
                String FA;
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.h.beauty_yuantu).equals(iVar.getName())) {
                    com.baidu.minivideo.arface.b.abI();
                    FA = com.baidu.minivideo.arface.c.abP();
                } else {
                    FA = com.baidu.tieba.ala.alaar.sticker.a.e.FA(iVar.zx());
                }
                if (!AlaLiveMultiBeautyArView.this.gwc.aCr.equals(FA)) {
                    AlaLiveMultiBeautyArView.this.FO(iVar.getName());
                }
                AlaLiveMultiBeautyArView.this.setFilterFileName(FA);
                AlaLiveMultiBeautyArView.this.gwc.aCs = iVar;
                if (AlaLiveMultiBeautyArView.this.gwd != null && AlaLiveMultiBeautyArView.this.bEu.zB() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gwc.a(iVar, AlaLiveMultiBeautyArView.this.bEu.zB().aCd);
                    int fc = AlaLiveMultiBeautyArView.this.gwc.fc(AlaLiveMultiBeautyArView.this.getFilterFileName());
                    float f = (((fc * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + fc + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gwd.onFilterSelected(AlaLiveMultiBeautyArView.this.gwc.aCs.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
                if (AlaLiveMultiBeautyArView.this.gvQ.gxM == AlaLiveMultiBeautyArView.this.gvR) {
                    AlaLiveMultiBeautyArView.this.gvR.tF(AlaLiveMultiBeautyArView.this.gwc.fc(AlaLiveMultiBeautyArView.this.getFilterFileName()));
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
                AlaLiveMultiBeautyArView.this.gwc.A(AlaLiveMultiBeautyArView.this.getFilterFileName(), i);
                if (AlaLiveMultiBeautyArView.this.gwd != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gwc.a(AlaLiveMultiBeautyArView.this.gwc.aCs, AlaLiveMultiBeautyArView.this.bEu.zB().aCd);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gwd.onFilterSelected(AlaLiveMultiBeautyArView.this.gwc.aCs.getName(), AlaLiveMultiBeautyArView.this.getFilterFileName(), f);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gwc.aCs != null) {
                    try {
                        jSONObject.put("filter_id", AlaLiveMultiBeautyArView.this.gwc.aCs.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("filterbar_clk", jSONObject);
            }
        });
        this.gvS.cj(this);
        this.gvS.setTitle(getResources().getString(a.h.ala_live_new_beauty_beauty));
        this.gvQ.b(this.gvS);
        this.gvS.a(new l.a<c.a>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, c.a aVar, boolean z) {
                if (AlaLiveMultiBeautyArView.this.gvQ.gxM == AlaLiveMultiBeautyArView.this.gvS) {
                    if (i == 0) {
                        AlaLiveMultiBeautyArView.this.bQy();
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gwc.aCt = aVar.gwG;
                    AlaLiveMultiBeautyArView.this.gvS.gxt.FS(aVar.gwG);
                    AlaLiveMultiBeautyArView.this.bQw();
                    if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gwc.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (AlaLiveMultiBeautyArView.this.gvQ.gxM == AlaLiveMultiBeautyArView.this.gvS && z) {
                            AlaLiveMultiBeautyArView.this.a(aVar);
                            return;
                        }
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gvU = aVar;
                    if (aVar != null) {
                        AlaLiveMultiBeautyArView.this.gvT = aVar.gwH;
                    }
                    AlaLiveMultiBeautyArView.this.tu(AlaLiveMultiBeautyArView.this.gwc.fe(AlaLiveMultiBeautyArView.this.gwc.aCt) + AlaLiveMultiBeautyArView.this.gvT);
                    AlaLiveMultiBeautyArView.this.gvS.gxh.setProcessDiff(AlaLiveMultiBeautyArView.this.gvT);
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
                if (AlaLiveMultiBeautyArView.this.gvQ.gxM == AlaLiveMultiBeautyArView.this.gvV) {
                    if (z && AlaLiveMultiBeautyArView.this.gwe != null) {
                        AlaLiveMultiBeautyArView.this.gwe.setValue(i);
                        if (AlaLiveMultiBeautyArView.this.gwc.aCA != null) {
                            AlaLiveMultiBeautyArView.this.gwc.aCA.setValue(AlaLiveMultiBeautyArView.this.gwe.bPa());
                            AlaLiveMultiBeautyArView.this.gwd.a(AlaLiveMultiBeautyArView.this.gwc.aCA);
                        }
                    }
                } else if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gwc.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.gwc.cm(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.gwc.aCw) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.gwc.aCw)) && com.baidu.live.d.xc().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.d.xc().getBoolean("naturalFace", true)) {
                        com.baidu.live.d.xc().putBoolean("naturalFace", false);
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.gwc.B(AlaLiveMultiBeautyArView.this.gwc.aCt, i - AlaLiveMultiBeautyArView.this.gvT);
                    if (AlaLiveMultiBeautyArView.this.gwd != null) {
                        AlaLiveMultiBeautyArView.this.gwd.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fb(AlaLiveMultiBeautyArView.this.gwc.aCt));
                    }
                }
                if (z) {
                    com.baidu.live.d.xc().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (AlaLiveMultiBeautyArView.this.gvQ.gxM != AlaLiveMultiBeautyArView.this.gvV) {
                    if (AlaLiveMultiBeautyArView.this.gwc.aCt != null) {
                        String str = null;
                        if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gwc.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            if (AlaLiveMultiBeautyArView.this.gwc.aCz != null) {
                                str = AlaLiveMultiBeautyArView.this.gwc.aCz.getName();
                            }
                        } else {
                            str = AlaLiveMultiBeautyArView.this.gvU.gwF;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (AlaLiveMultiBeautyArView.this.gvU != null && str != null) {
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
                if (AlaLiveMultiBeautyArView.this.gwe != null) {
                    try {
                        jSONObject2.put("makeup_id", AlaLiveMultiBeautyArView.this.gwe.getId());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("makeupbar_clk", jSONObject2);
            }
        });
        this.gvS.gxy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.gvQ.gxM == AlaLiveMultiBeautyArView.this.gvV) {
                            AlaLiveMultiBeautyArView.this.bQB();
                            break;
                        } else {
                            if (AlaLiveMultiBeautyArView.this.gwd != null) {
                                AlaLiveMultiBeautyArView.this.gwd.zF();
                            }
                            AlaLiveMultiBeautyArView.this.setThinFace(0);
                            break;
                        }
                    case 1:
                    case 3:
                    case 4:
                        if (AlaLiveMultiBeautyArView.this.gvQ.gxM == AlaLiveMultiBeautyArView.this.gvV) {
                            AlaLiveMultiBeautyArView.this.bQA();
                            break;
                        } else {
                            AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                            break;
                        }
                }
                return true;
            }
        });
        this.gvV.cj(this);
        this.gvV.tE(0);
        this.gvV.setTitle(getResources().getString(a.h.ala_live_new_beauty_makeup));
        this.gvQ.b(this.gvV);
        this.gvV.a(new l.a<com.baidu.tieba.ala.alaar.makeup.d>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemSelected pos= " + i + ", name=" + dVar.bOU());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bPi = dVar.bPi();
                if (dVar.azu() || bPi == null || bPi.isEmpty()) {
                    AlaLiveMultiBeautyArView.this.b(i, dVar, null);
                } else if (AlaLiveMultiBeautyArView.this.gvQ.gxM == AlaLiveMultiBeautyArView.this.gvV) {
                    AlaLiveMultiBeautyArView.this.a(dVar);
                }
                if (AlaLiveMultiBeautyArView.this.gvX != null) {
                    AlaLiveMultiBeautyArView.this.gvX.setPosition(i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemClick pos= " + i + ", name=" + dVar.bOU());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bPi = dVar.bPi();
                if (dVar.azu() || bPi == null || bPi.isEmpty()) {
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
        if (this.gvX != null) {
            this.gvV.setPosition(this.gvX.getPosition());
        }
        com.baidu.tieba.ala.alaar.makeup.g.bPm().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.tieba.ala.alaar.makeup.a.b
            public void c(com.baidu.tieba.ala.alaar.makeup.a aVar) {
                com.baidu.tieba.ala.alaar.makeup.a.c bPo = com.baidu.tieba.ala.alaar.makeup.g.bPm().bPo();
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("BeautyAr", "makeupdata onDataLoaded size: " + (AlaLiveMultiBeautyArView.this.gvX == null ? "null" : Integer.valueOf(AlaLiveMultiBeautyArView.this.gvX.size())));
                }
                AlaLiveMultiBeautyArView.this.setMakeupData(bPo);
            }
        });
        this.gvZ.cj(this);
        this.gvZ.a(new j.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.j.a
            public void a(k kVar, View view) {
                AlaLiveMultiBeautyArView.this.J(false, true);
            }
        });
        findViewById(a.f.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveMultiBeautyArView.this.bQv();
            }
        });
        this.gwf = (TextView) findViewById(a.f.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bQw();
            }
        }, 1000L);
        String string = com.baidu.live.d.xc().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
        this.gvQ.c(this.gvS);
        this.gvQ.show(false);
    }

    private boolean isShow() {
        ViewParent parent = getParent();
        return parent != null && (parent instanceof ViewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQv() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        zD();
        if (this.gwd != null) {
            this.gwd.onClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar) {
        this.gvY.gxf = dVar;
        this.gvY.a(new l.a<com.baidu.tieba.ala.alaar.makeup.c>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
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
                if (AlaLiveMultiBeautyArView.this.gwe != null) {
                    try {
                        jSONObject.put("makeup_id", AlaLiveMultiBeautyArView.this.gwe.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.r("makeupbar_clk", jSONObject);
            }
        });
        this.gvY.a(dVar, this);
        this.gvY.setTitle(dVar.bOU());
        J(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        this.gvY.gxf = aVar;
        this.gvY.ci(this);
        this.gvY.setTitle(aVar.gwF);
        this.gvY.a(new l.a<com.baidu.live.ar.h>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.h hVar, boolean z) {
                AlaLiveMultiBeautyArView.this.gwc.aCw = hVar.getType();
                AlaLiveMultiBeautyArView.this.gwc.aCx = hVar.zz();
                AlaLiveMultiBeautyArView.this.gwc.aCy = hVar.zy();
                AlaLiveMultiBeautyArView.this.gwc.aCz = hVar;
                String FT = AlaLiveMultiBeautyArView.this.gvY.gwV.FT(hVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.FB(hVar.zx())) {
                    FT = com.baidu.tieba.ala.alaar.sticker.a.d.FE(com.baidu.tieba.ala.alaar.sticker.a.d.FA(hVar.zx()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, FT));
                AlaLiveMultiBeautyArView.this.gvS.gxh.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.c(AlaLiveMultiBeautyArView.this.gwc.fd(AlaLiveMultiBeautyArView.this.gwc.aCw), false, Integer.valueOf(AlaLiveMultiBeautyArView.this.gwc.aCy).intValue());
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
                if (AlaLiveMultiBeautyArView.this.gwc.aCt != null) {
                    String str = null;
                    try {
                        if (AlaLiveMultiBeautyArView.this.gwc.aCz != null) {
                            str = AlaLiveMultiBeautyArView.this.gwc.aCz.getName();
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
            this.gwc.b(false, this.bEu.zB().aCe);
            List<com.baidu.live.ar.h> list = this.bEu.zB().aCe;
            this.gvY.gwV.e(list, this.gvY.gwV.h(list, this.gwc.aCw));
            this.gvY.gwV.notifyDataSetChanged();
            if (TextUtils.equals(this.gwc.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.gwc.aCy)) {
                        i = Integer.valueOf(this.gwc.aCy).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                c(this.gwc.fd(this.gwc.aCw), false, i);
            }
        }
        J(true, true);
        bQz();
        this.gvZ.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeupData(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        boolean z = true;
        this.gvX = cVar;
        if (cVar != null && cVar.bPu() != null && cVar.zv()) {
            bQA();
            this.gvV.setEnable(true);
            this.gvV.gxI.setData(cVar.bPu().getData());
            if (this.gvX != null) {
                this.gvV.setPosition(this.gvX.getPosition());
            }
            o oVar = this.gvV;
            if (!cVar.bPv() || cVar.bPw()) {
                z = false;
            }
            oVar.mp(z);
            return;
        }
        this.gvV.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQw() {
        if (com.baidu.live.d.xc().getInt("beauty_tab_redot", 0) != 1) {
            this.gvS.mp(false);
        } else if (com.baidu.live.d.xc().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.d.xc().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.d.xc().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.d.xc().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.gvS.gxt.bQF()) {
            this.gvS.mp(true);
        } else {
            this.gvS.mp(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements h.a {
        com.baidu.tieba.ala.alaar.makeup.c gwj;
        com.baidu.tieba.ala.alaar.makeup.d gwk;
        int pos;

        public a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
            this.pos = i;
            this.gwj = cVar;
            this.gwk = dVar;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void J(Object obj) {
            if (this.gwk != null && AlaLiveMultiBeautyArView.this.gvY != null && AlaLiveMultiBeautyArView.this.gvY.gxf == this.gwk) {
                AlaLiveMultiBeautyArView.this.gvY.gwU.notifyDataSetChanged();
            } else if (this.gwj instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gvV.gxI.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aF(Object obj) {
            if (this.gwk != null && AlaLiveMultiBeautyArView.this.gvY != null && AlaLiveMultiBeautyArView.this.gvY.gxf == this.gwk) {
                AlaLiveMultiBeautyArView.this.gvY.gwU.tC(this.pos);
                AlaLiveMultiBeautyArView.this.gvY.gwU.notifyDataSetChanged();
            } else if (this.gwk != null && this.pos == this.gwk.grV) {
                AlaLiveMultiBeautyArView.this.b(this.pos, this.gwj, this.gwk);
            } else if (this.gwj instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gvV.gxI.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void a(Object obj, int i, int i2, String str) {
            if (this.gwk != null && AlaLiveMultiBeautyArView.this.gvY != null && AlaLiveMultiBeautyArView.this.gvY.gxf == this.gwk) {
                AlaLiveMultiBeautyArView.this.gvY.gwU.notifyDataSetChanged();
            } else if (this.gwj instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gvV.gxI.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
        if (dVar != null) {
            dVar.grV = i;
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
        this.gwe = cVar;
        if ("makeupClose".equals(cVar.getTypeName())) {
            bQC();
        }
        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
        aVar.setResPath(cVar.bPc());
        aVar.setType(cVar.getType().name());
        aVar.setValue(cVar.bPa());
        this.gwc.aCA = aVar;
        if (this.gwd != null) {
            this.gwd.a(aVar);
        }
        if (this.gvQ.gxM == this.gvV) {
            boolean z = cVar.bOX() > cVar.bOY();
            this.gvS.mq(z);
            if (z) {
                try {
                    this.gvS.gxh.setProcessDiff(0);
                    this.gvV.D(cVar.bOY(), cVar.bOX(), cVar.bOZ(), cVar.getValue());
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void zD() {
        if (this.gwc != null) {
            com.baidu.live.d.xc().putString("ala_beauty_config_ar", this.gwc.toJsonString());
            com.baidu.tieba.ala.alaar.makeup.g.bPm().bPr();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.k kVar) {
        this.bEu = kVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bqG = bdPageContext;
        gwg = BdUtilHelper.getScreenSize(this.bqG.getPageActivity()).widthPixels;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(ab abVar) {
        this.aDd = abVar;
    }

    private com.baidu.live.ar.h getCurThinFace() {
        com.baidu.live.ar.h hVar = null;
        if (TextUtils.isEmpty(this.gwc.aCw) || this.bEu == null || this.bEu.zB() == null || this.bEu.zB().aCe == null) {
            return null;
        }
        List<com.baidu.live.ar.h> list = this.bEu.zB().aCe;
        int i = 0;
        while (i < list.size()) {
            com.baidu.live.ar.h hVar2 = list.get(i);
            if (TextUtils.equals(this.gwc.aCw, hVar2.getType())) {
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
        com.baidu.tieba.ala.alaar.makeup.c bPj;
        int fe;
        JSONArray jSONArray = new JSONArray();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            String str = null;
            if (TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                com.baidu.live.ar.h curThinFace = getCurThinFace();
                if (curThinFace != null && !TextUtils.isEmpty(curThinFace.getName())) {
                    str = curThinFace.getName();
                    fe = this.gwc.fd(this.gwc.aCw);
                }
                fe = 0;
            } else {
                if (this.gvS.gxt != null) {
                    for (int i = 0; i < this.gvS.gxt.gwz.length; i++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gvS.gxt.gwz[i].gwG)) {
                            c.a aVar = this.gvS.gxt.gwz[i];
                            int i2 = aVar.gwH;
                            str = aVar.gwF;
                            fe = this.gwc.fe(beautyAdjustKey.getJsonKey()) + i2;
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
        if (this.gwc.aCs != null) {
            try {
                jSONObject2.put("filter_id", this.gwc.aCs.getId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        s("filter_suc", jSONObject2);
        if (com.baidu.tieba.ala.alaar.makeup.g.bPm().bPn()) {
            JSONArray jSONArray2 = new JSONArray();
            List<com.baidu.tieba.ala.alaar.makeup.d> bPp = com.baidu.tieba.ala.alaar.makeup.g.bPm().bPp();
            if (bPp != null && bPp.size() > 0) {
                for (int i3 = 0; i3 < bPp.size(); i3++) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bPp.get(i3);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bPj = dVar.bPj()) != null && bPj.bOY() < bPj.bOX()) {
                        jSONArray2.put(bPj.getId());
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
            i2 = com.baidu.live.ar.e.aCE.fe(this.gwc.aCt) + this.gvT;
        }
        L(100, i, i2);
    }

    public void L(int i, int i2, int i3) {
        this.gvS.gxh.setMax(i);
        if (Build.VERSION.SDK_INT >= 24) {
            this.gvS.gxh.setProgress(i2, true);
        } else {
            this.gvS.gxh.setProgress(i2);
        }
        this.gvS.gxh.setDefThumbPos(i3);
    }

    @Deprecated
    private static void bQx() {
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
            int i7 = iArr[0] - ((gwg - ds120) / 2);
            int i8 = z ? ((i - 1) * (ds120 + ds20)) + ds28 + ds3 + ds20 : ((ds120 + ds20) * i) + ds28;
            int i9 = ((i4 - i) - 1) * (ds120 + ds20);
            if ((gwg - ds120) / 2 > i8) {
                return (((gwg - ds120) / 2) - i8) + i7;
            }
            return (gwg - ds120) / 2 > i9 ? i7 - (((gwg - ds120) / 2) - i9) : i7;
        }
        return i5;
    }

    public static int bz(int i, int i2) {
        return Math.max(0, Math.min((i - ds120) >> 1, ((ds120 + ds20) * i2) + ds28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQy() {
        if (this.gwa != null) {
            this.gwa.dismiss();
            this.gwa = null;
        }
        String string = getContext().getString(a.h.ar_beauty_is_reset);
        this.gwa = new BdAlertDialog((Activity) getContext());
        this.gwa.setAutoNight(false);
        this.gwa.setMessage(string);
        this.gwa.setPositiveButton(getContext().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.zE();
                AlaLiveMultiBeautyArView.this.FA();
            }
        });
        this.gwa.setNegativeButton(getContext().getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.FA();
            }
        });
        this.gwa.setCancelable(false);
        this.gwa.setCanceledOnTouchOutside(false);
        this.gwa.setTitleShowCenter(true);
        this.gwa.setMessageShowCenter(true);
        this.gwa.isShowTitleAndMessage();
        this.gwa.create(this.bqG);
        this.gwa.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zE() {
        if (this.gwd != null) {
            this.gwd.zE();
        }
        bQD();
        String str = this.gwc.aCw;
        String str2 = this.gwc.aCx;
        String str3 = this.gwc.aCy;
        String str4 = com.baidu.live.ar.e.aCF.aCt;
        com.baidu.live.ar.e.aCF.r(com.baidu.live.ar.e.aCE.toJsonString(), true);
        com.baidu.live.ar.e.aCF.aCt = str4;
        com.baidu.live.ar.e.aCF.aCw = str;
        com.baidu.live.ar.e.aCF.aCx = str2;
        com.baidu.live.ar.e.aCF.aCy = str3;
        this.gwc = com.baidu.live.ar.e.aCF;
        if (this.bEu != null && this.bEu.zB() != null && this.bEu.zB().aCe != null) {
            this.gwc.b(true, this.bEu.zB().aCe);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fd = this.gwc.fd(str);
            this.gvS.gxh.setProcessDiff(0);
            c(fd, false, fd);
            return;
        }
        tu(this.gwc.fe(this.gwc.aCt) + this.gvT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.gwa != null) {
            this.gwa.dismiss();
            this.gwa = null;
        }
        this.gwa = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gwb) {
            this.gwb = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && isShow()) {
            bQv();
            return true;
        }
        return false;
    }

    private void bQz() {
        if (!TextUtils.isEmpty(this.gwc.aCw)) {
            if (TextUtils.isEmpty(this.gwc.aCy)) {
                tu(this.gwc.fd(this.gwc.aCw));
                return;
            }
            try {
                this.gvS.gxh.setProcessDiff(0);
                c(this.gwc.fd(this.gwc.aCw), false, Integer.valueOf(this.gwc.aCy).intValue());
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
        if (this.gvS != null && this.gvS.isEnable()) {
            FM("beautytab_show");
        }
        if (this.gvV != null && this.gvV.isEnable()) {
            FM("makeuptab_show");
        }
        if (this.gvR != null && this.gvR.isEnable()) {
            FM("filtertab_show");
        }
    }

    private void FM(String str) {
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
            this.gvQ.dismiss(z2);
            if (this.gvY != null) {
                this.gvZ.setTitle(this.gvY.getTitle());
            }
            this.gvZ.show(z2);
            return;
        }
        if (this.gvQ.gxM == this.gvV) {
            this.gvS.mq(false);
        }
        this.gvZ.dismiss(z2);
        this.gvQ.show(z2);
        bQw();
        if (!this.gvS.gxt.bQF()) {
            this.gvS.gxt.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.m mVar) {
        this.gwd = mVar;
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
        this.gwc = com.baidu.live.ar.e.aCF;
        setBeautyAdjustUserData2AR(false);
        bQA();
        if (this.gvQ.gxM == this.gvS && !TextUtils.equals(this.gwc.aCt, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            tu(this.gwc.fe(this.gwc.aCt) + this.gvT);
        }
        this.gvS.gxt.FP(this.gwc.aCt);
        this.gvS.gxt.notifyDataSetChanged();
        if (this.bEu != null && this.bEu.zB() != null && this.bEu.zB().aCd != null) {
            this.gvR.gxA.setDatas(this.bEu.zB().aCd);
            if (!TextUtils.isEmpty(getFilterFileName())) {
                this.gvR.gxA.setSelect(g(this.bEu.zB().aCd, getFilterFileName()));
            }
        }
        this.gvR.gxA.notifyDataSetChanged();
    }

    public int g(List<com.baidu.live.ar.i> list, String str) {
        String FA;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getContext().getString(a.h.beauty_yuantu).equals(list.get(i2).getName())) {
                com.baidu.minivideo.arface.b.abI();
                FA = com.baidu.minivideo.arface.c.abP();
                i = i2;
            } else {
                FA = com.baidu.tieba.ala.alaar.sticker.a.e.FA(list.get(i2).zx());
            }
            if (str.equals(FA)) {
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
        if (this.gwd != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.gvS.gxt != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.gvS.gxt.gwz.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gvS.gxt.gwz[i2].gwG)) {
                            i = this.gvS.gxt.gwz[i2].gwH;
                        }
                    }
                } else {
                    i = 0;
                }
                this.gwd.a(((this.gwc.fe(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bQD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQA() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bPp;
        com.baidu.tieba.ala.alaar.makeup.c bPj;
        if (this.gwd != null && com.baidu.tieba.ala.alaar.makeup.g.bPm().bPn() && (bPp = com.baidu.tieba.ala.alaar.makeup.g.bPm().bPp()) != null && bPp.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bPp.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bPp.get(i2);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bPj = dVar.bPj()) != null && bPj.bOY() < bPj.bOX()) {
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bPj.getTypeName());
                        aVar.setValue(bPj.bPa());
                        aVar.setResPath(bPj.bPc());
                        this.gwd.a(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQB() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bPp = com.baidu.tieba.ala.alaar.makeup.g.bPm().bPp();
        if (this.gwd != null && bPp != null && bPp.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bPp.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bPp.get(i2);
                    if (dVar == null || !"makeupClose".equals(dVar.getTypeName())) {
                        i = i2 + 1;
                    } else {
                        com.baidu.tieba.ala.alaar.makeup.c bPj = dVar.bPj();
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bPj.getTypeName());
                        aVar.setValue(bPj.bPa());
                        aVar.setResPath(bPj.bPc());
                        this.gwd.a(aVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bQC() {
        com.baidu.tieba.ala.alaar.makeup.a.b bPu = this.gvX.bPu();
        if (bPu != null) {
            List<com.baidu.tieba.ala.alaar.makeup.d> data = bPu.getData();
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
        if (this.gwd != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.gwc.aCx);
            this.gwd.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bQD() {
        setThinFace(this.gwc.fd(this.gwc.aCw));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO(String str) {
        this.gwf.setText(str);
        this.gwf.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gwf, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gwf, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gwf, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.gwf, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void zC() {
        if (this.gvS.gxt != null) {
            this.gvS.gxt.notifyDataSetChanged();
        }
        if (this.gvR.gxA != null) {
            this.gvR.gxA.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
