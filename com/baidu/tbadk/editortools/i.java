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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private g aBX;
    private h aBY;
    private List<r> aBZ;
    private SparseArray<b> aCa;
    private SparseArray<HashSet<b>> aCb;
    private SparseArray<HashSet<Integer>> aCc;
    private int aCd;
    private int aCe;
    private boolean aCf;
    private int aCg;
    private int aCh;
    private boolean aCi;
    private LinkedList<l> aCj;
    private boolean aCk;
    private boolean aCl;
    private View.OnClickListener aCm;
    private Runnable aCn;
    private List<Integer> aCo;

    public void Di() {
        r eP = eP(3);
        if (eP != null && (eP.aBO instanceof View)) {
            View view = (View) eP.aBO;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aCd = 1;
        this.aCe = 0;
        this.aCf = false;
        this.aCg = d.C0082d.common_color_10255;
        this.aCh = 0;
        this.aCi = true;
        this.aCk = false;
        this.aCl = false;
        this.aCm = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.L(view);
            }
        };
        this.aCn = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Di();
            }
        };
        this.aCo = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aCk = z;
    }

    public boolean Dj() {
        return this.aCk;
    }

    public boolean Dk() {
        return this.aCl;
    }

    public void setIsFromPb(boolean z) {
        this.aCl = z;
    }

    private void init(Context context) {
        this.aBZ = new LinkedList();
        this.aCa = new SparseArray<>();
        this.aCb = new SparseArray<>();
        this.aCc = new SparseArray<>();
        this.aBX = new g(context, this);
        this.aBY = new h(context, this);
        this.aCj = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aCb.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aCb.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aCa.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aCc.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aCc.put(i3, hashSet2);
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
        l lVar;
        r eP;
        if (aVar != null) {
            if (aVar.code == 2) {
                l eN = this.aBX.eN(aVar.id);
                if (eN != null) {
                    z = false;
                } else {
                    eN = this.aBY.eN(aVar.id);
                    z = true;
                }
                if (eN == null) {
                    Iterator<l> it = this.aCj.iterator();
                    while (it.hasNext()) {
                        lVar = it.next();
                        if (lVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                lVar = eN;
                if (lVar != null) {
                    lVar.a(aVar);
                    if (z && (eP = eP(2)) != null && eP.aBO != null) {
                        eP.aBO.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aBX.a((r) null);
                Bm();
            } else if (aVar.id > 0) {
                b bVar = this.aCa.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aBX.eL(aVar.id);
                    }
                    r eP2 = eP(aVar.id);
                    if (eP2 != null && eP2.aCE == 5) {
                        Bm();
                        Dl();
                    } else {
                        this.aBY.eL(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aCc.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aCa.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aCb.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Dl() {
        boolean z;
        r eP;
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aCn);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.l.a(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && (eP = eP(3)) != null && (eP.aBO instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) eP.aBO);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aBZ.add(rVar);
        }
    }

    private void clear() {
        this.aBX.clear();
        this.aBY.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aCd = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aBX.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aBY.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.e(this, this.aCg, i);
        this.aBX.onChangeSkinType(i);
        this.aBY.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aCo;
    }

    public void B(List<Integer> list) {
        this.aCo.clear();
        this.aCo.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void De() {
        o oVar;
        if (this.aBZ != null && this.aBZ.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aBZ) {
                if (rVar.aCB > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aBO != null) {
                    rVar.aBO.setToolId(rVar.id);
                    rVar.aBO.setEditorTools(this);
                    if (rVar.aCE == 6) {
                        this.aBY.a(rVar.aBO);
                    } else if (rVar.aCE == 1 || rVar.aCE == 2 || rVar.aCE == 3 || rVar.aCE == 4 || rVar.aCE == 5) {
                        this.aBX.a(rVar.aBO, rVar.aCE, !rVar.aCF);
                        if (rVar.aCE == 5 && eP(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aCG, rVar.id, rVar.aBO);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aCD - rVar3.aCD;
                }
            });
            if (linkedList.size() > this.aCd) {
                if (this.aCl) {
                    oVar = new o(getContext(), true);
                } else {
                    oVar = new o(getContext());
                }
                if (this.aCh > 0 && oVar.aBO != null && (oVar.aBO instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aBO).setBackgroundColorId(this.aCh);
                }
                if (this.aCe > 0) {
                    oVar.aCB = this.aCe;
                }
                b(oVar);
                oVar.aBO.setToolId(oVar.id);
                oVar.aBO.setEditorTools(this);
                a(oVar.aCG, oVar.id, oVar.aBO);
                this.aBY.a(oVar.aBO);
                if (this.aCf) {
                    linkedList.add(this.aCd, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aCd + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aBX.a(a(rVar2, 1));
                } else {
                    this.aBY.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aBX.a(0, a);
            }
            this.aBX.De();
            this.aBY.De();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aBX.setLayoutParams(layoutParams);
            this.aBY.setLayoutParams(layoutParams);
            this.aBY.hide();
            if (this.aCl) {
                this.aBX.setPadding(0, 0, 0, 0);
            }
            Bm();
            removeAllViews();
            addView(this.aBX);
            addView(this.aBY);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aBX != null) {
                this.aBX.a(0, a);
                this.aBX.removeAllViews();
                this.aBX.De();
            }
            invalidate();
        }
    }

    public r eP(int i) {
        for (r rVar : this.aBZ) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aBZ;
    }

    public l eN(int i) {
        l eN = this.aBX.eN(i);
        if (eN == null) {
            return this.aBY.eN(i);
        }
        return eN;
    }

    public void Dm() {
        this.aBX.d(this.aCm);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aCm);
        }
        return a;
    }

    public void bz(boolean z) {
        for (r rVar : this.aBZ) {
            if (rVar != null && (rVar.aBO instanceof View) && ((View) rVar.aBO).getVisibility() == 0 && !rVar.aCF) {
                rVar.aBO.lE();
            }
        }
        if (this.aCi) {
            this.aCi = false;
            Bm();
        }
        if (!Dg() && z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.aCn, 200L);
        }
        setVisibility(0);
    }

    public void lE() {
        bz(true);
    }

    public void hide() {
        Bm();
        setVisibility(8);
        Dl();
    }

    public void Bm() {
        this.aBY.hide();
        this.aBX.a((r) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aBX.setBarLauncherEnabled(z);
    }

    public void d(boolean z, int i) {
        this.aBX.d(z, i);
    }

    public boolean Dg() {
        return this.aBY.Dg();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aCe = i;
    }

    public void setBarLauncherType(int i) {
        this.aBX.setBarLauncherType(i);
    }

    public void bx(boolean z) {
        this.aBX.bx(z);
    }

    public void by(boolean z) {
        this.aBX.by(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aCf = z;
    }

    public void setBackgroundColorId(int i) {
        this.aCg = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aCh = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void L(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r eP = eP(toolId);
            if (eP.lS()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.aBX.a(eP);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lE();
                    b(new a(1, 3, null));
                } else if (eP.aBO == null) {
                    if (eP.aCG != null && eP.aCG.length > 0) {
                        b(new a(eP.aCG[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Dn() {
        this.aBX.a((r) null);
    }
}
