package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private SparseArray<b> aqA;
    private SparseArray<HashSet<b>> aqB;
    private SparseArray<HashSet<Integer>> aqC;
    private int aqD;
    private int aqE;
    private boolean aqF;
    private int aqG;
    private int aqH;
    private boolean aqI;
    private LinkedList<s> aqJ;
    private j aqK;
    private View.OnClickListener aqL;
    private Runnable aqM;
    private Runnable aqN;
    private Boolean aqO;
    private List<Integer> aqP;
    private g aqx;
    private h aqy;
    private List<aa> aqz;

    public void Bs() {
        aa el = el(3);
        if (el != null && (el.aqi instanceof View)) {
            View view = (View) el.aqi;
            view.requestFocus();
            com.baidu.adp.lib.util.k.b(getContext(), view);
            com.baidu.adp.lib.h.h.dM().postDelayed(this.aqN, 1000L);
        }
    }

    public l(Context context) {
        super(context);
        this.aqD = 1;
        this.aqE = 0;
        this.aqF = false;
        this.aqG = u.d.common_color_10255;
        this.aqH = 0;
        this.aqI = true;
        this.aqL = new m(this);
        this.aqM = new n(this);
        this.aqN = new o(this);
        this.aqP = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.aqz = new LinkedList();
        this.aqA = new SparseArray<>();
        this.aqB = new SparseArray<>();
        this.aqC = new SparseArray<>();
        this.aqx = new g(context, this);
        this.aqy = new h(context, this);
        this.aqJ = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aqB.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aqB.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aqA.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aqC.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aqC.put(i3, hashSet2);
                    }
                    hashSet2.add(Integer.valueOf(i));
                    i2++;
                }
            }
        }
    }

    public void b(a aVar) {
        HashSet<Integer> hashSet;
        boolean z;
        s sVar;
        aa el;
        if (aVar != null) {
            if (aVar.code == 2) {
                s ej = this.aqx.ej(aVar.id);
                if (ej != null) {
                    z = false;
                } else {
                    ej = this.aqy.ej(aVar.id);
                    z = true;
                }
                if (ej == null) {
                    Iterator<s> it = this.aqJ.iterator();
                    while (it.hasNext()) {
                        sVar = it.next();
                        if (sVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                sVar = ej;
                if (sVar != null) {
                    sVar.a(aVar);
                    if (z && (el = el(2)) != null && el.aqi != null) {
                        el.aqi.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aqx.a((aa) null);
                this.aqy.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aqA.get(aVar.id);
                if (bVar != null) {
                    this.aqx.eh(aVar.id);
                    aa el2 = el(aVar.id);
                    if (el2 != null && el2.are == 5) {
                        this.aqy.hide();
                        Bt();
                    } else {
                        this.aqy.eh(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aqC.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aqA.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aqB.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Bt() {
        boolean z;
        aa el;
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aqM);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.k.a(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && (el = el(3)) != null && (el.aqi instanceof View)) {
            com.baidu.adp.lib.util.k.a(getContext(), (View) el.aqi);
        }
    }

    public void b(aa aaVar) {
        if (aaVar != null) {
            this.aqz.add(aaVar);
        }
    }

    private void clear() {
        this.aqx.clear();
        this.aqy.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aqD = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aqx.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aqy.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        av.e(this, this.aqG, i);
        this.aqx.onChangeSkinType(i);
        this.aqy.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aqP;
    }

    public void y(List<Integer> list) {
        this.aqP.clear();
        this.aqP.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Bm() {
        if (this.aqz != null && this.aqz.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (aa aaVar : this.aqz) {
                if (aaVar.arb > 0) {
                    linkedList.add(aaVar);
                }
                if (aaVar.aqi != null) {
                    aaVar.aqi.setToolId(aaVar.id);
                    aaVar.aqi.setEditorTools(this);
                    if (aaVar.are == 6) {
                        this.aqy.a(aaVar.aqi);
                    } else if (aaVar.are == 1 || aaVar.are == 2 || aaVar.are == 3 || aaVar.are == 4 || aaVar.are == 5) {
                        this.aqx.a(aaVar.aqi, aaVar.are, !aaVar.arf);
                        if (aaVar.are == 5 && el(1) == null) {
                            z = true;
                        }
                    }
                    a(aaVar.arg, aaVar.id, aaVar.aqi);
                }
            }
            Collections.sort(linkedList, new p(this));
            if (linkedList.size() > this.aqD) {
                x xVar = new x(getContext());
                if (this.aqH > 0 && xVar.aqi != null && (xVar.aqi instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) xVar.aqi).setBackgroundColorId(this.aqH);
                }
                if (this.aqE > 0) {
                    xVar.arb = this.aqE;
                }
                b(xVar);
                xVar.aqi.setToolId(xVar.id);
                xVar.aqi.setEditorTools(this);
                a(xVar.arg, xVar.id, xVar.aqi);
                this.aqy.a(xVar.aqi);
                if (this.aqF) {
                    linkedList.add(this.aqD, xVar);
                } else {
                    linkedList.add(0, xVar);
                }
            }
            int i = this.aqD + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                aa aaVar2 = (aa) it.next();
                if (i2 < i) {
                    this.aqx.a(a(aaVar2, 1));
                } else {
                    this.aqy.a(a(aaVar2, 2));
                }
                i2++;
            }
            if (z) {
                q qVar = new q();
                b(qVar);
                s a = a(qVar, 1);
                a.hide();
                this.aqx.a(0, a);
            }
            this.aqx.Bm();
            this.aqy.Bm();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aqx.setLayoutParams(layoutParams);
            this.aqy.setLayoutParams(layoutParams);
            this.aqy.hide();
            removeAllViews();
            addView(this.aqx);
            addView(this.aqy);
            invalidate();
        }
    }

    public void c(aa aaVar) {
        if (aaVar != null) {
            b(aaVar);
            s a = a(aaVar, 1);
            a.hide();
            if (this.aqx != null) {
                this.aqx.a(0, a);
                this.aqx.removeAllViews();
                this.aqx.Bm();
            }
            invalidate();
        }
    }

    public aa el(int i) {
        for (aa aaVar : this.aqz) {
            if (aaVar.id == i) {
                return aaVar;
            }
        }
        return null;
    }

    public List<aa> getAllTools() {
        return this.aqz;
    }

    public s ej(int i) {
        s ej = this.aqx.ej(i);
        if (ej == null) {
            return this.aqy.ej(i);
        }
        return ej;
    }

    public void Bu() {
        this.aqx.i(this.aqL);
    }

    private s a(aa aaVar, int i) {
        s a = r.a(getContext(), aaVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(aaVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aqL);
        }
        return a;
    }

    public void bw(boolean z) {
        for (aa aaVar : this.aqz) {
            if (aaVar != null && (aaVar.aqi instanceof View) && ((View) aaVar.aqi).getVisibility() == 0 && !aaVar.arf) {
                aaVar.aqi.kF();
            }
        }
        if (this.aqI) {
            this.aqI = false;
            zD();
        }
        if (!Bo() && z) {
            com.baidu.adp.lib.h.h.dM().postDelayed(this.aqM, 200L);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bv() {
        if (this.aqK == null) {
            this.aqK = new j(getResources().getString(u.j.graffiti_reply_tips), "graffiti_reply_tip_show", 24, 2);
        }
        s ej = ej(this.aqK.Bq());
        if ((ej instanceof View) && el(this.aqK.getToolId()) != null) {
            this.aqK.c(getContext(), (View) ej);
        }
    }

    public void kF() {
        bw(true);
    }

    public void Bw() {
        for (aa aaVar : this.aqz) {
            if (aaVar != null && (aaVar.aqi instanceof View) && ((View) aaVar.aqi).getVisibility() == 0 && !aaVar.arf) {
                aaVar.aqi.kF();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.aqK != null) {
            this.aqK.Br();
        }
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aqN);
        this.aqy.hide();
        setVisibility(8);
        Bt();
    }

    public void zD() {
        this.aqy.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aqx.setBarLauncherEnabled(z);
    }

    public boolean Bo() {
        return this.aqy.Bo();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aqE = i;
    }

    public void setBarLauncherType(int i) {
        this.aqx.setBarLauncherType(i);
    }

    public void bu(boolean z) {
        this.aqx.bu(z);
    }

    public void bv(boolean z) {
        this.aqx.bv(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aqF = z;
    }

    public void setBackgroundColorId(int i) {
        this.aqG = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aqH = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void H(View view) {
        if (view instanceof s) {
            s sVar = (s) view;
            b(new a(31, 0, Integer.valueOf(sVar.getToolId())));
            this.aqx.a(el(sVar.getToolId()));
            if (this.aqK != null) {
                this.aqK.Br();
                com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aqN);
            }
            if (sVar.getToolId() == 1) {
                sVar.hide();
                kF();
                b(new a(1, 3, null));
                return;
            }
            int toolId = sVar.getToolId();
            aa el = el(toolId);
            if (el.aqi == null) {
                if (el.arg != null && el.arg.length > 0) {
                    b(new a(el.arg[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }

    public void Bx() {
        if (this.aqK != null) {
            this.aqK.Br();
            this.aqK = null;
        }
    }

    public void setCanshowTogetherhi(Boolean bool) {
        this.aqO = bool;
    }

    public Boolean getCanshowTogetherhi() {
        return this.aqO;
    }
}
