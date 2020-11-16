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
    private static int gfw;
    private w aDh;
    private BdPageContext bkZ;
    private com.baidu.live.ar.j bvD;
    private final p gfg;
    private final n gfh;
    private final m gfi;
    int gfj;
    private c.a gfk;
    private final o gfl;
    private int gfm;
    private com.baidu.tieba.ala.alaar.makeup.a.c gfn;
    private final i gfo;
    private k gfp;
    private BdAlertDialog gfq;
    private boolean gfr;
    private com.baidu.live.ar.d gfs;
    private com.baidu.live.ar.l gft;
    private com.baidu.tieba.ala.alaar.makeup.c gfu;
    private TextView gfv;

    static /* synthetic */ int b(AlaLiveMultiBeautyArView alaLiveMultiBeautyArView) {
        int i = alaLiveMultiBeautyArView.gfm;
        alaLiveMultiBeautyArView.gfm = i + 1;
        return i;
    }

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.gfg = new p();
        this.gfh = new n();
        this.gfi = new m();
        this.gfj = 0;
        this.gfl = new o();
        this.gfo = new i();
        this.gfp = new k();
        this.gfr = true;
        this.gfs = com.baidu.live.ar.d.aCP;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfg = new p();
        this.gfh = new n();
        this.gfi = new m();
        this.gfj = 0;
        this.gfl = new o();
        this.gfo = new i();
        this.gfp = new k();
        this.gfr = true;
        this.gfs = com.baidu.live.ar.d.aCP;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gfg = new p();
        this.gfh = new n();
        this.gfi = new m();
        this.gfj = 0;
        this.gfl = new o();
        this.gfo = new i();
        this.gfp = new k();
        this.gfr = true;
        this.gfs = com.baidu.live.ar.d.aCP;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_beauty_ar_hor_layout, this);
        bNA();
        this.gfm = 0;
        this.gfg.bX(this);
        this.gfg.a(new p.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.tieba.ala.alaar.view.p.a
            public void a(l lVar) {
                if (lVar != AlaLiveMultiBeautyArView.this.gfl) {
                    if (lVar == AlaLiveMultiBeautyArView.this.gfh) {
                        AlaLiveMultiBeautyArView.this.gfh.up(AlaLiveMultiBeautyArView.this.gfs.fQ(AlaLiveMultiBeautyArView.this.gfs.aCB));
                        return;
                    } else {
                        if (lVar == AlaLiveMultiBeautyArView.this.gfi) {
                        }
                        return;
                    }
                }
                AlaLiveMultiBeautyArView.b(AlaLiveMultiBeautyArView.this);
                if (AlaLiveMultiBeautyArView.this.gfn != null && !AlaLiveMultiBeautyArView.this.gfn.bMx()) {
                    AlaLiveMultiBeautyArView.this.gfn.lt(true);
                }
                if (AlaLiveMultiBeautyArView.this.gfm == 1 && AlaLiveMultiBeautyArView.this.gfl.ggW != null) {
                    AlaLiveMultiBeautyArView.this.gfl.un(AlaLiveMultiBeautyArView.this.gfl.ggW.getCurrentPosition());
                }
                AlaLiveMultiBeautyArView.this.gfl.lx(false);
            }
        });
        this.gfh.bX(this);
        this.gfh.setTitle(getResources().getString(a.h.ala_live_new_beauty_filter));
        this.gfg.b(this.gfh);
        this.gfh.c(new com.baidu.tieba.ala.alaar.view.a(getContext()));
        this.gfh.a(new l.a<com.baidu.live.ar.h>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.h hVar, boolean z) {
                String FA;
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.h.beauty_yuantu).equals(hVar.getName())) {
                    com.baidu.minivideo.arface.b.Zs();
                    FA = com.baidu.minivideo.arface.c.Zx();
                } else {
                    FA = com.baidu.tieba.ala.alaar.sticker.a.e.FA(hVar.BL());
                }
                if (!AlaLiveMultiBeautyArView.this.gfs.aCB.equals(FA)) {
                    AlaLiveMultiBeautyArView.this.FP(hVar.getName());
                }
                AlaLiveMultiBeautyArView.this.gfs.aCB = FA;
                AlaLiveMultiBeautyArView.this.gfs.aCC = hVar;
                if (AlaLiveMultiBeautyArView.this.gft != null && AlaLiveMultiBeautyArView.this.bvD.BP() != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gfs.a(hVar, AlaLiveMultiBeautyArView.this.bvD.BP().aCn);
                    int fQ = AlaLiveMultiBeautyArView.this.gfs.fQ(AlaLiveMultiBeautyArView.this.gfs.aCB);
                    float f = (((fQ * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a2 + ", level:" + fQ + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gft.onFilterSelected(AlaLiveMultiBeautyArView.this.gfs.aCC.getName(), AlaLiveMultiBeautyArView.this.gfs.aCB, f);
                }
                if (AlaLiveMultiBeautyArView.this.gfg.gha == AlaLiveMultiBeautyArView.this.gfh) {
                    AlaLiveMultiBeautyArView.this.gfh.up(AlaLiveMultiBeautyArView.this.gfs.fQ(AlaLiveMultiBeautyArView.this.gfs.aCB));
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
                AlaLiveMultiBeautyArView.this.gfs.y(AlaLiveMultiBeautyArView.this.gfs.aCB, i);
                if (AlaLiveMultiBeautyArView.this.gft != null) {
                    int a2 = AlaLiveMultiBeautyArView.this.gfs.a(AlaLiveMultiBeautyArView.this.gfs.aCC, AlaLiveMultiBeautyArView.this.bvD.BP().aCn);
                    float f = (((i * 1.0f) / 100.0f) * (a2 * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a2 + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.gft.onFilterSelected(AlaLiveMultiBeautyArView.this.gfs.aCC.getName(), AlaLiveMultiBeautyArView.this.gfs.aCB, f);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                JSONObject jSONObject = new JSONObject();
                if (AlaLiveMultiBeautyArView.this.gfs.aCC != null) {
                    try {
                        jSONObject.put("filter_id", AlaLiveMultiBeautyArView.this.gfs.aCC.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("filterbar_clk", jSONObject);
            }
        });
        this.gfi.bX(this);
        this.gfi.setTitle(getResources().getString(a.h.ala_live_new_beauty_beauty));
        this.gfg.b(this.gfi);
        this.gfi.a(new l.a<c.a>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, c.a aVar, boolean z) {
                if (AlaLiveMultiBeautyArView.this.gfg.gha == AlaLiveMultiBeautyArView.this.gfi) {
                    if (i == 0) {
                        AlaLiveMultiBeautyArView.this.bNB();
                        return;
                    }
                    String str = aVar.gfV;
                    AlaLiveMultiBeautyArView.this.gfi.ggH.FT(str);
                    AlaLiveMultiBeautyArView.this.bNz();
                    AlaLiveMultiBeautyArView.this.gfs.aCD = str;
                    if (TextUtils.equals(str, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (AlaLiveMultiBeautyArView.this.gfg.gha == AlaLiveMultiBeautyArView.this.gfi && z) {
                            AlaLiveMultiBeautyArView.this.a(aVar);
                            return;
                        }
                        return;
                    }
                    AlaLiveMultiBeautyArView.this.gfk = aVar;
                    if (aVar != null) {
                        AlaLiveMultiBeautyArView.this.gfj = aVar.gfW;
                    }
                    AlaLiveMultiBeautyArView.this.ue(AlaLiveMultiBeautyArView.this.gfs.fS(AlaLiveMultiBeautyArView.this.gfs.aCD) + aVar.gfW);
                    AlaLiveMultiBeautyArView.this.gfi.ggv.setProcessDiff(aVar.gfW);
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
                if (AlaLiveMultiBeautyArView.this.gfg.gha == AlaLiveMultiBeautyArView.this.gfl) {
                    if (z && AlaLiveMultiBeautyArView.this.gfu != null) {
                        AlaLiveMultiBeautyArView.this.gfu.setValue(i);
                        if (AlaLiveMultiBeautyArView.this.gfs.aCK != null) {
                            AlaLiveMultiBeautyArView.this.gfs.aCK.setValue(AlaLiveMultiBeautyArView.this.gfu.bMb());
                            AlaLiveMultiBeautyArView.this.gft.a(AlaLiveMultiBeautyArView.this.gfs.aCK);
                        }
                    }
                } else if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gfs.aCD, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    AlaLiveMultiBeautyArView.this.gfs.dz(i);
                    AlaLiveMultiBeautyArView.this.setThinFace(i);
                    if ((TextUtils.equals("naturalFace", AlaLiveMultiBeautyArView.this.gfs.aCG) || TextUtils.isEmpty(AlaLiveMultiBeautyArView.this.gfs.aCG)) && com.baidu.live.d.Aq().getInt("beauty_subitem_redot", 0) == 1 && com.baidu.live.d.Aq().getBoolean("naturalFace", true)) {
                        com.baidu.live.d.Aq().putBoolean("naturalFace", false);
                    }
                } else {
                    AlaLiveMultiBeautyArView.this.gfs.z(AlaLiveMultiBeautyArView.this.gfs.aCD, i - AlaLiveMultiBeautyArView.this.gfj);
                    if (AlaLiveMultiBeautyArView.this.gft != null) {
                        AlaLiveMultiBeautyArView.this.gft.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.fO(AlaLiveMultiBeautyArView.this.gfs.aCD));
                    }
                }
                if (z) {
                    com.baidu.live.d.Aq().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // com.baidu.tieba.ala.alaar.view.l.a
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (AlaLiveMultiBeautyArView.this.gfg.gha != AlaLiveMultiBeautyArView.this.gfl) {
                    if (AlaLiveMultiBeautyArView.this.gfs.aCD != null) {
                        String str = null;
                        if (TextUtils.equals(AlaLiveMultiBeautyArView.this.gfs.aCD, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                            if (AlaLiveMultiBeautyArView.this.gfs.aCJ != null) {
                                str = AlaLiveMultiBeautyArView.this.gfs.aCJ.getName();
                            }
                        } else {
                            str = AlaLiveMultiBeautyArView.this.gfk.mShowName;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (AlaLiveMultiBeautyArView.this.gfk != null && str != null) {
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
                if (AlaLiveMultiBeautyArView.this.gfu != null) {
                    try {
                        jSONObject2.put("makeup_id", AlaLiveMultiBeautyArView.this.gfu.getId());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("makeupbar_clk", jSONObject2);
            }
        });
        this.gfi.ggM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.gfg.gha == AlaLiveMultiBeautyArView.this.gfl) {
                            AlaLiveMultiBeautyArView.this.bNE();
                            break;
                        } else {
                            if (AlaLiveMultiBeautyArView.this.gft != null) {
                                AlaLiveMultiBeautyArView.this.gft.BU();
                            }
                            AlaLiveMultiBeautyArView.this.setThinFace(0);
                            break;
                        }
                    case 1:
                    case 3:
                    case 4:
                        if (AlaLiveMultiBeautyArView.this.gfg.gha == AlaLiveMultiBeautyArView.this.gfl) {
                            AlaLiveMultiBeautyArView.this.bND();
                            break;
                        } else {
                            AlaLiveMultiBeautyArView.this.setBeautyAdjustUserData2AR(true);
                            break;
                        }
                }
                return true;
            }
        });
        this.gfl.bX(this);
        this.gfl.uo(0);
        this.gfl.setTitle(getResources().getString(a.h.ala_live_new_beauty_makeup));
        this.gfg.b(this.gfl);
        this.gfl.a(new l.a<com.baidu.tieba.ala.alaar.makeup.d>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemSelected pos= " + i + ", name=" + dVar.getName());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bMj = dVar.bMj();
                if (dVar.ayp() || bMj == null || bMj.isEmpty()) {
                    AlaLiveMultiBeautyArView.this.b(i, dVar, null);
                } else if (AlaLiveMultiBeautyArView.this.gfg.gha == AlaLiveMultiBeautyArView.this.gfl) {
                    AlaLiveMultiBeautyArView.this.a(dVar);
                }
                if (AlaLiveMultiBeautyArView.this.gfn != null) {
                    AlaLiveMultiBeautyArView.this.gfn.setPosition(i);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: b  reason: avoid collision after fix types in other method */
            public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.d dVar, boolean z) {
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "ArView MKGroup onItemClick pos= " + i + ", name=" + dVar.getName());
                }
                List<com.baidu.tieba.ala.alaar.makeup.c> bMj = dVar.bMj();
                if (dVar.ayp() || bMj == null || bMj.isEmpty()) {
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
        if (this.gfn != null) {
            this.gfl.setPosition(this.gfn.getPosition());
        }
        com.baidu.tieba.ala.alaar.makeup.g.bMn().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.tieba.ala.alaar.makeup.a.b
            public void c(com.baidu.tieba.ala.alaar.makeup.a aVar) {
                com.baidu.tieba.ala.alaar.makeup.a.c bMp = com.baidu.tieba.ala.alaar.makeup.g.bMn().bMp();
                if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                    com.baidu.tieba.ala.alaar.makeup.h.d("BeautyAr", "makeupdata onDataLoaded size: " + (AlaLiveMultiBeautyArView.this.gfn == null ? "null" : Integer.valueOf(AlaLiveMultiBeautyArView.this.gfn.size())));
                }
                AlaLiveMultiBeautyArView.this.setMakeupData(bMp);
            }
        });
        this.gfp.bX(this);
        this.gfp.a(new j.a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.12
            @Override // com.baidu.tieba.ala.alaar.view.j.a
            public void a(k kVar, View view) {
                AlaLiveMultiBeautyArView.this.H(false, true);
            }
        });
        findViewById(a.f.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveMultiBeautyArView.this.bNy();
            }
        });
        this.gfv = (TextView) findViewById(a.f.filter_select_anim);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveMultiBeautyArView.this.bNz();
            }
        }, 1000L);
        String string = com.baidu.live.d.Aq().getString("beauty_face_feature", "");
        if (!TextUtils.isEmpty(string)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, string));
        }
        this.gfg.c(this.gfi);
        this.gfg.show(false);
    }

    private boolean isShow() {
        ViewParent parent = getParent();
        return parent != null && (parent instanceof ViewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNy() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
        BR();
        if (this.gft != null) {
            this.gft.BS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.tieba.ala.alaar.makeup.d dVar) {
        this.gfo.ggt = dVar;
        this.gfo.a(new l.a<com.baidu.tieba.ala.alaar.makeup.c>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
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
                if (AlaLiveMultiBeautyArView.this.gfu != null) {
                    try {
                        jSONObject.put("makeup_id", AlaLiveMultiBeautyArView.this.gfu.getId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("makeupbar_clk", jSONObject);
            }
        });
        this.gfo.a(dVar, this);
        this.gfo.setTitle(dVar.getName());
        H(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.a aVar) {
        this.gfo.ggt = aVar;
        this.gfo.bW(this);
        this.gfo.setTitle(aVar.mShowName);
        this.gfo.a(new l.a<com.baidu.live.ar.g>() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alaar.view.l.a
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void b(int i, com.baidu.live.ar.g gVar, boolean z) {
                AlaLiveMultiBeautyArView.this.gfs.aCG = gVar.getType();
                AlaLiveMultiBeautyArView.this.gfs.aCH = gVar.BN();
                AlaLiveMultiBeautyArView.this.gfs.aCI = gVar.BM();
                AlaLiveMultiBeautyArView.this.gfs.aCJ = gVar;
                String FV = AlaLiveMultiBeautyArView.this.gfo.ggk.FV(gVar.getType());
                if (com.baidu.tieba.ala.alaar.sticker.a.d.FB(gVar.BL())) {
                    FV = com.baidu.tieba.ala.alaar.sticker.a.d.FE(com.baidu.tieba.ala.alaar.sticker.a.d.FA(gVar.BL()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913196, FV));
                AlaLiveMultiBeautyArView.this.gfi.ggv.setProcessDiff(0);
                try {
                    AlaLiveMultiBeautyArView.this.a(AlaLiveMultiBeautyArView.this.gfs.fR(gVar.getType()), false, Integer.valueOf(gVar.BM()).intValue());
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
                if (AlaLiveMultiBeautyArView.this.gfs.aCD != null) {
                    String str = null;
                    try {
                        if (AlaLiveMultiBeautyArView.this.gfs.aCJ != null) {
                            str = AlaLiveMultiBeautyArView.this.gfs.aCJ.getName();
                        }
                        jSONObject.put("beauty_name", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                AlaLiveMultiBeautyArView.this.q("beautybar_clk", jSONObject);
            }
        });
        if (this.bvD != null && this.bvD.BP() != null && this.bvD.BP().aCo != null) {
            this.gfs.a(false, this.bvD.BP().aCo);
            this.gfo.ggk.e(this.bvD.BP().aCo, this.gfo.ggk.FU(this.gfs.aCG));
            this.gfo.ggk.notifyDataSetChanged();
            if (TextUtils.equals(this.gfs.aCD, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                int i = 40;
                try {
                    if (!TextUtils.isEmpty(this.gfs.aCI)) {
                        i = Integer.valueOf(this.gfs.aCI).intValue();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                a(this.gfs.fR(this.gfs.aCG), false, i);
            }
        }
        H(true, true);
        bNC();
        this.gfp.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMakeupData(com.baidu.tieba.ala.alaar.makeup.a.c cVar) {
        boolean z = true;
        this.gfn = cVar;
        if (cVar != null && cVar.bMv() != null && cVar.BJ()) {
            bND();
            this.gfl.setEnable(true);
            this.gfl.ggW.setData(cVar.bMv().getData());
            if (this.gfn != null) {
                this.gfl.setPosition(this.gfn.getPosition());
            }
            o oVar = this.gfl;
            if (!cVar.bMw() || cVar.bMx()) {
                z = false;
            }
            oVar.lx(z);
            return;
        }
        this.gfl.setEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNz() {
        if (com.baidu.live.d.Aq().getInt("beauty_tab_redot", 0) != 1) {
            this.gfi.lx(false);
        } else if (com.baidu.live.d.Aq().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.faceWidth.getJsonKey(), true) || com.baidu.live.d.Aq().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength.getJsonKey(), true) || com.baidu.live.d.Aq().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.upCount.getJsonKey(), true) || com.baidu.live.d.Aq().getBoolean(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance.getJsonKey(), true) || this.gfi.ggH.bNI()) {
            this.gfi.lx(true);
        } else {
            this.gfi.lx(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements h.a {
        com.baidu.tieba.ala.alaar.makeup.d gfA;
        com.baidu.tieba.ala.alaar.makeup.c gfz;
        int pos;

        public a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
            this.pos = i;
            this.gfz = cVar;
            this.gfA = dVar;
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aD(Object obj) {
            if (this.gfA != null && AlaLiveMultiBeautyArView.this.gfo != null && AlaLiveMultiBeautyArView.this.gfo.ggt == this.gfA) {
                AlaLiveMultiBeautyArView.this.gfo.ggj.notifyDataSetChanged();
            } else if (this.gfz instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gfl.ggW.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void aE(Object obj) {
            if (this.gfA != null && AlaLiveMultiBeautyArView.this.gfo != null && AlaLiveMultiBeautyArView.this.gfo.ggt == this.gfA) {
                AlaLiveMultiBeautyArView.this.gfo.ggj.um(this.pos);
                AlaLiveMultiBeautyArView.this.gfo.ggj.notifyDataSetChanged();
            } else if (this.gfA != null && this.pos == this.gfA.gbh) {
                AlaLiveMultiBeautyArView.this.b(this.pos, this.gfz, this.gfA);
            } else if (this.gfz instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gfl.ggW.notifyDataSetChanged();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
        public void a(Object obj, int i, int i2, String str) {
            if (this.gfA != null && AlaLiveMultiBeautyArView.this.gfo != null && AlaLiveMultiBeautyArView.this.gfo.ggt == this.gfA) {
                AlaLiveMultiBeautyArView.this.gfo.ggj.notifyDataSetChanged();
            } else if (this.gfz instanceof com.baidu.tieba.ala.alaar.makeup.d) {
                AlaLiveMultiBeautyArView.this.gfl.ggW.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, com.baidu.tieba.ala.alaar.makeup.c cVar, com.baidu.tieba.ala.alaar.makeup.d dVar) {
        if (dVar != null) {
            dVar.gbh = i;
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
        this.gfu = cVar;
        if ("makeupClose".equals(cVar.getTypeName())) {
            bNF();
        }
        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
        aVar.setResPath(cVar.bMd());
        aVar.setType(cVar.getType().name());
        aVar.setValue(cVar.bMb());
        this.gfs.aCK = aVar;
        if (this.gft != null) {
            this.gft.a(aVar);
        }
        if (this.gfg.gha == this.gfl) {
            boolean z = cVar.bLY() > cVar.bLZ();
            this.gfi.ly(z);
            if (z) {
                try {
                    this.gfi.ggv.setProcessDiff(0);
                    this.gfl.y(cVar.bLZ(), cVar.bLY(), cVar.bMa(), cVar.getValue());
                } catch (Exception e) {
                }
            }
        }
        return false;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void BR() {
        if (this.gfs != null) {
            com.baidu.live.d.Aq().putString("ala_beauty_config_ar", this.gfs.toJsonString());
            com.baidu.tieba.ala.alaar.makeup.g.bMn().bMs();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.j jVar) {
        this.bvD = jVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bkZ = bdPageContext;
        gfw = BdUtilHelper.getScreenSize(this.bkZ.getPageActivity()).widthPixels;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(w wVar) {
        this.aDh = wVar;
    }

    private com.baidu.live.ar.g getCurThinFace() {
        if (TextUtils.isEmpty(this.gfs.aCG) || this.bvD == null || this.bvD.BP() == null || this.bvD.BP().aCo == null) {
            return null;
        }
        List<com.baidu.live.ar.g> list = this.bvD.BP().aCo;
        com.baidu.live.ar.g gVar = null;
        for (int i = 0; i < list.size(); i++) {
            gVar = list.get(i);
            if (TextUtils.equals(this.gfs.aCG, gVar.getType())) {
                return gVar;
            }
        }
        return gVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        com.baidu.tieba.ala.alaar.makeup.c bMk;
        String str;
        int fS;
        JSONArray jSONArray = new JSONArray();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            if (TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                com.baidu.live.ar.g curThinFace = getCurThinFace();
                if (curThinFace != null && !TextUtils.isEmpty(curThinFace.getName())) {
                    str = curThinFace.getName();
                    fS = this.gfs.fR(this.gfs.aCG);
                }
                str = null;
                fS = 0;
            } else {
                if (this.gfi.ggH != null) {
                    for (int i = 0; i < this.gfi.ggH.gfP.length; i++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gfi.ggH.gfP[i].gfV)) {
                            c.a aVar = this.gfi.ggH.gfP[i];
                            int i2 = aVar.gfW;
                            str = aVar.mShowName;
                            fS = this.gfs.fS(beautyAdjustKey.getJsonKey()) + i2;
                            break;
                        }
                    }
                }
                str = null;
                fS = 0;
            }
            if (fS != 0 && str != null) {
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
        if (this.gfs.aCC != null) {
            try {
                jSONObject2.put("filter_id", this.gfs.aCC.getId());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        r("filter_suc", jSONObject2);
        if (com.baidu.tieba.ala.alaar.makeup.g.bMn().bMo()) {
            JSONArray jSONArray2 = new JSONArray();
            List<com.baidu.tieba.ala.alaar.makeup.d> bMq = com.baidu.tieba.ala.alaar.makeup.g.bMn().bMq();
            if (bMq != null && bMq.size() > 0) {
                for (int i3 = 0; i3 < bMq.size(); i3++) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bMq.get(i3);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bMk = dVar.bMk()) != null && bMk.bLZ() < bMk.bLY()) {
                        jSONArray2.put(bMk.getId());
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
    public void ue(int i) {
        a(i, true, 0);
    }

    public void a(int i, boolean z, int i2) {
        if (z) {
            i2 = com.baidu.live.ar.d.aCO.fS(this.gfs.aCD) + this.gfj;
        }
        K(100, i, i2);
    }

    public void K(int i, int i2, int i3) {
        this.gfi.ggv.setMax(i);
        if (Build.VERSION.SDK_INT >= 24) {
            this.gfi.ggv.setProgress(i2, true);
        } else {
            this.gfi.ggv.setProgress(i2);
        }
        this.gfi.ggv.setDefThumbPos(i3);
    }

    @Deprecated
    private static void bNA() {
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
            int i7 = iArr[0] - ((gfw - ds120) / 2);
            int i8 = z ? ((i - 1) * (ds120 + ds20)) + ds28 + ds3 + ds20 : ((ds120 + ds20) * i) + ds28;
            int i9 = ((i4 - i) - 1) * (ds120 + ds20);
            if ((gfw - ds120) / 2 > i8) {
                return (((gfw - ds120) / 2) - i8) + i7;
            }
            return (gfw - ds120) / 2 > i9 ? i7 - (((gfw - ds120) / 2) - i9) : i7;
        }
        return i5;
    }

    public static int bC(int i, int i2) {
        return Math.max(0, Math.min((i - ds120) >> 1, ((ds120 + ds20) * i2) + ds28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNB() {
        if (this.gfq != null) {
            this.gfq.dismiss();
            this.gfq = null;
        }
        String string = getContext().getString(a.h.ar_beauty_is_reset);
        this.gfq = new BdAlertDialog((Activity) getContext());
        this.gfq.setAutoNight(false);
        this.gfq.setMessage(string);
        this.gfq.setPositiveButton(getContext().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.BT();
                AlaLiveMultiBeautyArView.this.GM();
            }
        });
        this.gfq.setNegativeButton(getContext().getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.GM();
            }
        });
        this.gfq.setCancelable(false);
        this.gfq.setCanceledOnTouchOutside(false);
        this.gfq.setTitleShowCenter(true);
        this.gfq.setMessageShowCenter(true);
        this.gfq.isShowTitleAndMessage();
        this.gfq.create(this.bkZ);
        this.gfq.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BT() {
        if (this.gft != null) {
            this.gft.BT();
        }
        bNG();
        String str = this.gfs.aCG;
        String str2 = this.gfs.aCH;
        String str3 = this.gfs.aCI;
        String str4 = com.baidu.live.ar.d.aCP.aCD;
        com.baidu.live.ar.d.aCP.fP(com.baidu.live.ar.d.aCO.toJsonString());
        com.baidu.live.ar.d.aCP.aCD = str4;
        com.baidu.live.ar.d.aCP.aCG = str;
        com.baidu.live.ar.d.aCP.aCH = str2;
        com.baidu.live.ar.d.aCP.aCI = str3;
        this.gfs = com.baidu.live.ar.d.aCP;
        if (this.bvD != null && this.bvD.BP() != null && this.bvD.BP().aCo != null) {
            this.gfs.a(true, this.bvD.BP().aCo);
        }
        if (TextUtils.equals(str4, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            int fR = this.gfs.fR(str);
            this.gfi.ggv.setProcessDiff(0);
            a(fR, false, fR);
            return;
        }
        ue(this.gfs.fS(this.gfs.aCD) + this.gfj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM() {
        if (this.gfq != null) {
            this.gfq.dismiss();
            this.gfq = null;
        }
        this.gfq = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gfr) {
            this.gfr = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && isShow()) {
            bNy();
            return true;
        }
        return false;
    }

    private void bNC() {
        if (!TextUtils.isEmpty(this.gfs.aCG)) {
            if (TextUtils.isEmpty(this.gfs.aCI)) {
                ue(this.gfs.fR(this.gfs.aCG));
                return;
            }
            try {
                this.gfi.ggv.setProcessDiff(0);
                a(this.gfs.fR(this.gfs.aCG), false, Integer.valueOf(this.gfs.aCI).intValue());
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
        if (this.gfi != null && this.gfi.isEnable()) {
            FN("beautytab_show");
        }
        if (this.gfl != null && this.gfl.isEnable()) {
            FN("makeuptab_show");
        }
        if (this.gfh != null && this.gfh.isEnable()) {
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
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            i = this.aDh.mLiveInfo.live_status;
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
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            i = this.aDh.mLiveInfo.live_status;
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
            this.gfg.dismiss(z2);
            if (this.gfo != null) {
                this.gfp.setTitle(this.gfo.getTitle());
            }
            this.gfp.show(z2);
            return;
        }
        if (this.gfg.gha == this.gfl) {
            this.gfi.ly(false);
        }
        this.gfp.dismiss(z2);
        this.gfg.show(z2);
        bNz();
        if (!this.gfi.ggH.bNI()) {
            this.gfi.ggH.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.l lVar) {
        this.gft = lVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.d.aCP.fP(com.baidu.live.d.Aq().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.d.aCP.aCB) && com.baidu.minivideo.arface.b.Zs() != null) {
            com.baidu.live.ar.d dVar = com.baidu.live.ar.d.aCP;
            com.baidu.minivideo.arface.b.Zs();
            dVar.aCB = com.baidu.minivideo.arface.c.Zx();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.i.aDe)) {
            com.baidu.minivideo.arface.b.Zs();
            com.baidu.live.ar.i.fU(com.baidu.minivideo.arface.c.Zx());
        }
        this.gfs = com.baidu.live.ar.d.aCP;
        setBeautyAdjustUserData2AR(false);
        bND();
        if (this.gfg.gha == this.gfi && !TextUtils.equals(this.gfs.aCD, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
            ue(this.gfs.fS(this.gfs.aCD) + this.gfj);
        }
        this.gfi.ggH.FQ(this.gfs.aCD);
        this.gfi.ggH.notifyDataSetChanged();
        if (this.bvD != null && this.bvD.BP() != null && this.bvD.BP().aCn != null) {
            this.gfh.ggO.setDatas(this.bvD.BP().aCn);
            if (!TextUtils.isEmpty(this.gfs.aCB)) {
                this.gfh.ggO.setSelect(h(this.bvD.BP().aCn, this.gfs.aCB));
            }
        }
        this.gfh.ggO.notifyDataSetChanged();
    }

    public int h(List<com.baidu.live.ar.h> list, String str) {
        String FA;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (getContext().getString(a.h.beauty_yuantu).equals(list.get(i2).getName())) {
                com.baidu.minivideo.arface.b.Zs();
                FA = com.baidu.minivideo.arface.c.Zx();
                i = i2;
            } else {
                FA = com.baidu.tieba.ala.alaar.sticker.a.e.FA(list.get(i2).BL());
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
        if (this.gft != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.gfi.ggH != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.gfi.ggH.gfP.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.gfi.ggH.gfP[i2].gfV)) {
                            i = this.gfi.ggH.gfP[i2].gfW;
                        }
                    }
                } else {
                    i = 0;
                }
                this.gft.a(((this.gfs.fS(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
            bNG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bND() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bMq;
        com.baidu.tieba.ala.alaar.makeup.c bMk;
        if (this.gft != null && com.baidu.tieba.ala.alaar.makeup.g.bMn().bMo() && (bMq = com.baidu.tieba.ala.alaar.makeup.g.bMn().bMq()) != null && bMq.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bMq.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bMq.get(i2);
                    if (dVar != null && !"makeupClose".equals(dVar.getTypeName()) && (bMk = dVar.bMk()) != null && bMk.bLZ() < bMk.bLY()) {
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bMk.getTypeName());
                        aVar.setValue(bMk.bMb());
                        aVar.setResPath(bMk.bMd());
                        this.gft.a(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNE() {
        List<com.baidu.tieba.ala.alaar.makeup.d> bMq = com.baidu.tieba.ala.alaar.makeup.g.bMn().bMq();
        if (this.gft != null && bMq != null && bMq.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bMq.size()) {
                    com.baidu.tieba.ala.alaar.makeup.d dVar = bMq.get(i2);
                    if (dVar == null || !"makeupClose".equals(dVar.getTypeName())) {
                        i = i2 + 1;
                    } else {
                        com.baidu.tieba.ala.alaar.makeup.c bMk = dVar.bMk();
                        com.baidu.tieba.ala.alaar.makeup.a.a aVar = new com.baidu.tieba.ala.alaar.makeup.a.a();
                        aVar.setType(bMk.getTypeName());
                        aVar.setValue(bMk.bMb());
                        aVar.setResPath(bMk.bMd());
                        this.gft.a(aVar);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void bNF() {
        com.baidu.tieba.ala.alaar.makeup.a.b bMv = this.gfn.bMv();
        if (bMv != null) {
            List<com.baidu.tieba.ala.alaar.makeup.d> data = bMv.getData();
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
        if (this.gft != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("thinFace", this.gfs.aCH);
            this.gft.a((1.0f * i) / 100.0f, hashMap);
        }
    }

    private void bNG() {
        setThinFace(this.gfs.fR(this.gfs.aCG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(String str) {
        this.gfv.setText(str);
        this.gfv.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gfv, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gfv, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gfv, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.gfv, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void BQ() {
        if (this.gfi.ggH != null) {
            this.gfi.ggH.notifyDataSetChanged();
        }
        if (this.gfh.ggO != null) {
            this.gfh.ggO.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
