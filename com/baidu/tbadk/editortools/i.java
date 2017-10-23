package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
    private g aAE;
    private View aAF;
    private h aAG;
    private List<r> aAH;
    private SparseArray<b> aAI;
    private SparseArray<HashSet<b>> aAJ;
    private SparseArray<HashSet<Integer>> aAK;
    private int aAL;
    private int aAM;
    private boolean aAN;
    private int aAO;
    private int aAP;
    private boolean aAQ;
    private LinkedList<l> aAR;
    private boolean aAS;
    private View.OnClickListener aAT;
    private Runnable aAU;
    private List<Integer> aAV;

    public void Cy() {
        r eO = eO(3);
        if (eO != null && (eO.aAv instanceof View)) {
            View view = (View) eO.aAv;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aAL = 1;
        this.aAM = 0;
        this.aAN = false;
        this.aAO = d.e.common_color_10255;
        this.aAP = 0;
        this.aAQ = true;
        this.aAS = false;
        this.aAT = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.L(view);
            }
        };
        this.aAU = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Cy();
            }
        };
        this.aAV = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aAS = z;
    }

    public boolean Cz() {
        return this.aAS;
    }

    private void init(Context context) {
        this.aAH = new LinkedList();
        this.aAI = new SparseArray<>();
        this.aAJ = new SparseArray<>();
        this.aAK = new SparseArray<>();
        this.aAE = new g(context, this);
        this.aAG = new h(context, this);
        this.aAR = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aAJ.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aAJ.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aAI.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aAK.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aAK.put(i3, hashSet2);
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
        r eO;
        if (aVar != null) {
            if (aVar.code == 2) {
                l eM = this.aAE.eM(aVar.id);
                if (eM != null) {
                    z = false;
                } else {
                    eM = this.aAG.eM(aVar.id);
                    z = true;
                }
                if (eM == null) {
                    Iterator<l> it = this.aAR.iterator();
                    while (it.hasNext()) {
                        lVar = it.next();
                        if (lVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                lVar = eM;
                if (lVar != null) {
                    lVar.a(aVar);
                    if (z && (eO = eO(2)) != null && eO.aAv != null) {
                        eO.aAv.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aAE.a((r) null);
                this.aAG.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aAI.get(aVar.id);
                if (bVar != null) {
                    this.aAE.eK(aVar.id);
                    r eO2 = eO(aVar.id);
                    if (eO2 != null && eO2.aBk == 5) {
                        this.aAG.hide();
                        CA();
                    } else {
                        this.aAG.eK(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aAK.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aAI.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aAJ.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void CA() {
        boolean z;
        r eO;
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aAU);
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
        if (!z && (eO = eO(3)) != null && (eO.aAv instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) eO.aAv);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aAH.add(rVar);
        }
    }

    private void clear() {
        this.aAE.clear();
        this.aAG.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aAL = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aAE.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aAG.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.e(this, this.aAO, i);
        if (this.aAF != null) {
            aj.e(this.aAF, d.e.cp_bg_line_c, i);
        }
        this.aAE.onChangeSkinType(i);
        this.aAG.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aAV;
    }

    public void z(List<Integer> list) {
        this.aAV.clear();
        this.aAV.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Cu() {
        if (this.aAH != null && this.aAH.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aAH) {
                if (rVar.aBh > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aAv != null) {
                    rVar.aAv.setToolId(rVar.id);
                    rVar.aAv.setEditorTools(this);
                    if (rVar.aBk == 6) {
                        this.aAG.a(rVar.aAv);
                    } else if (rVar.aBk == 1 || rVar.aBk == 2 || rVar.aBk == 3 || rVar.aBk == 4 || rVar.aBk == 5) {
                        this.aAE.a(rVar.aAv, rVar.aBk, !rVar.aBl);
                        if (rVar.aBk == 5 && eO(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aBm, rVar.id, rVar.aAv);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aBj - rVar3.aBj;
                }
            });
            if (linkedList.size() > this.aAL) {
                o oVar = new o(getContext());
                if (this.aAP > 0 && oVar.aAv != null && (oVar.aAv instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aAv).setBackgroundColorId(this.aAP);
                }
                if (this.aAM > 0) {
                    oVar.aBh = this.aAM;
                }
                b(oVar);
                oVar.aAv.setToolId(oVar.id);
                oVar.aAv.setEditorTools(this);
                a(oVar.aBm, oVar.id, oVar.aAv);
                this.aAG.a(oVar.aAv);
                if (this.aAN) {
                    linkedList.add(this.aAL, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aAL + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aAE.a(a(rVar2, 1));
                } else {
                    this.aAG.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aAE.a(0, a);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.f.ds1));
            this.aAF = new View(getContext());
            this.aAF.setLayoutParams(layoutParams);
            this.aAF.setBackgroundResource(d.e.cp_bg_line_c);
            this.aAE.Cu();
            this.aAG.Cu();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.aAE.setLayoutParams(layoutParams2);
            this.aAG.setLayoutParams(layoutParams2);
            this.aAG.hide();
            removeAllViews();
            addView(this.aAF);
            addView(this.aAE);
            addView(this.aAG);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aAE != null) {
                this.aAE.a(0, a);
                this.aAE.removeAllViews();
                this.aAE.Cu();
            }
            invalidate();
        }
    }

    public r eO(int i) {
        for (r rVar : this.aAH) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aAH;
    }

    public l eM(int i) {
        l eM = this.aAE.eM(i);
        if (eM == null) {
            return this.aAG.eM(i);
        }
        return eM;
    }

    public void CB() {
        this.aAE.d(this.aAT);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aAT);
        }
        return a;
    }

    public void bD(boolean z) {
        for (r rVar : this.aAH) {
            if (rVar != null && (rVar.aAv instanceof View) && ((View) rVar.aAv).getVisibility() == 0 && !rVar.aBl) {
                rVar.aAv.lM();
            }
        }
        if (this.aAQ) {
            this.aAQ = false;
            AH();
        }
        if (!Cw() && z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.aAU, 200L);
        }
        setVisibility(0);
    }

    public void lM() {
        bD(true);
    }

    public void CC() {
        for (r rVar : this.aAH) {
            if (rVar != null && (rVar.aAv instanceof View) && ((View) rVar.aAv).getVisibility() == 0 && !rVar.aBl) {
                rVar.aAv.lM();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aAG.hide();
        setVisibility(8);
        CA();
    }

    public void AH() {
        this.aAG.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aAE.setBarLauncherEnabled(z);
    }

    public void d(boolean z, int i) {
        this.aAE.d(z, i);
    }

    public boolean Cw() {
        return this.aAG.Cw();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aAM = i;
    }

    public void setBarLauncherType(int i) {
        this.aAE.setBarLauncherType(i);
    }

    public void bB(boolean z) {
        this.aAE.bB(z);
    }

    public void bC(boolean z) {
        this.aAE.bC(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aAN = z;
    }

    public void setBackgroundColorId(int i) {
        this.aAO = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aAP = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void L(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r eO = eO(toolId);
            if (eO.lV()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.aAE.a(eO);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lM();
                    b(new a(1, 3, null));
                } else if (eO.aAv == null) {
                    if (eO.aBm != null && eO.aBm.length > 0) {
                        b(new a(eO.aBm[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
