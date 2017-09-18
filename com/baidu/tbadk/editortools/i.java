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
    private SparseArray<b> aBA;
    private SparseArray<HashSet<b>> aBB;
    private SparseArray<HashSet<Integer>> aBC;
    private int aBD;
    private int aBE;
    private boolean aBF;
    private int aBG;
    private int aBH;
    private boolean aBI;
    private LinkedList<l> aBJ;
    private boolean aBK;
    private View.OnClickListener aBL;
    private Runnable aBM;
    private List<Integer> aBN;
    private g aBw;
    private View aBx;
    private h aBy;
    private List<r> aBz;

    public void Da() {
        r eE = eE(3);
        if (eE != null && (eE.aBn instanceof View)) {
            View view = (View) eE.aBn;
            view.requestFocus();
            com.baidu.adp.lib.util.k.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aBD = 1;
        this.aBE = 0;
        this.aBF = false;
        this.aBG = d.e.common_color_10255;
        this.aBH = 0;
        this.aBI = true;
        this.aBK = false;
        this.aBL = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.K(view);
            }
        };
        this.aBM = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Da();
            }
        };
        this.aBN = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aBK = z;
    }

    public boolean Db() {
        return this.aBK;
    }

    private void init(Context context) {
        this.aBz = new LinkedList();
        this.aBA = new SparseArray<>();
        this.aBB = new SparseArray<>();
        this.aBC = new SparseArray<>();
        this.aBw = new g(context, this);
        this.aBy = new h(context, this);
        this.aBJ = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aBB.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aBB.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aBA.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aBC.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aBC.put(i3, hashSet2);
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
        r eE;
        if (aVar != null) {
            if (aVar.code == 2) {
                l eC = this.aBw.eC(aVar.id);
                if (eC != null) {
                    z = false;
                } else {
                    eC = this.aBy.eC(aVar.id);
                    z = true;
                }
                if (eC == null) {
                    Iterator<l> it = this.aBJ.iterator();
                    while (it.hasNext()) {
                        lVar = it.next();
                        if (lVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                lVar = eC;
                if (lVar != null) {
                    lVar.a(aVar);
                    if (z && (eE = eE(2)) != null && eE.aBn != null) {
                        eE.aBn.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aBw.a((r) null);
                this.aBy.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aBA.get(aVar.id);
                if (bVar != null) {
                    this.aBw.eA(aVar.id);
                    r eE2 = eE(aVar.id);
                    if (eE2 != null && eE2.aCc == 5) {
                        this.aBy.hide();
                        Dc();
                    } else {
                        this.aBy.eA(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aBC.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aBA.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aBB.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Dc() {
        boolean z;
        r eE;
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.aBM);
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
        if (!z && (eE = eE(3)) != null && (eE.aBn instanceof View)) {
            com.baidu.adp.lib.util.k.a(getContext(), (View) eE.aBn);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aBz.add(rVar);
        }
    }

    private void clear() {
        this.aBw.clear();
        this.aBy.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aBD = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aBw.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aBy.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.e(this, this.aBG, i);
        if (this.aBx != null) {
            aj.e(this.aBx, d.e.cp_bg_line_c, i);
        }
        this.aBw.onChangeSkinType(i);
        this.aBy.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aBN;
    }

    public void A(List<Integer> list) {
        this.aBN.clear();
        this.aBN.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CW() {
        if (this.aBz != null && this.aBz.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aBz) {
                if (rVar.aBZ > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aBn != null) {
                    rVar.aBn.setToolId(rVar.id);
                    rVar.aBn.setEditorTools(this);
                    if (rVar.aCc == 6) {
                        this.aBy.a(rVar.aBn);
                    } else if (rVar.aCc == 1 || rVar.aCc == 2 || rVar.aCc == 3 || rVar.aCc == 4 || rVar.aCc == 5) {
                        this.aBw.a(rVar.aBn, rVar.aCc, !rVar.aCd);
                        if (rVar.aCc == 5 && eE(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aCe, rVar.id, rVar.aBn);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aCb - rVar3.aCb;
                }
            });
            if (linkedList.size() > this.aBD) {
                o oVar = new o(getContext());
                if (this.aBH > 0 && oVar.aBn != null && (oVar.aBn instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aBn).setBackgroundColorId(this.aBH);
                }
                if (this.aBE > 0) {
                    oVar.aBZ = this.aBE;
                }
                b(oVar);
                oVar.aBn.setToolId(oVar.id);
                oVar.aBn.setEditorTools(this);
                a(oVar.aCe, oVar.id, oVar.aBn);
                this.aBy.a(oVar.aBn);
                if (this.aBF) {
                    linkedList.add(this.aBD, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aBD + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aBw.a(a(rVar2, 1));
                } else {
                    this.aBy.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aBw.a(0, a);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.f.ds1));
            this.aBx = new View(getContext());
            this.aBx.setLayoutParams(layoutParams);
            this.aBx.setBackgroundResource(d.e.cp_bg_line_c);
            this.aBw.CW();
            this.aBy.CW();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.aBw.setLayoutParams(layoutParams2);
            this.aBy.setLayoutParams(layoutParams2);
            this.aBy.hide();
            removeAllViews();
            addView(this.aBx);
            addView(this.aBw);
            addView(this.aBy);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aBw != null) {
                this.aBw.a(0, a);
                this.aBw.removeAllViews();
                this.aBw.CW();
            }
            invalidate();
        }
    }

    public r eE(int i) {
        for (r rVar : this.aBz) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aBz;
    }

    public l eC(int i) {
        l eC = this.aBw.eC(i);
        if (eC == null) {
            return this.aBy.eC(i);
        }
        return eC;
    }

    public void Dd() {
        this.aBw.d(this.aBL);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aBL);
        }
        return a;
    }

    public void bF(boolean z) {
        for (r rVar : this.aBz) {
            if (rVar != null && (rVar.aBn instanceof View) && ((View) rVar.aBn).getVisibility() == 0 && !rVar.aCd) {
                rVar.aBn.lK();
            }
        }
        if (this.aBI) {
            this.aBI = false;
            Bp();
        }
        if (!CY() && z) {
            com.baidu.adp.lib.g.e.fQ().postDelayed(this.aBM, 200L);
        }
        setVisibility(0);
    }

    public void lK() {
        bF(true);
    }

    public void De() {
        for (r rVar : this.aBz) {
            if (rVar != null && (rVar.aBn instanceof View) && ((View) rVar.aBn).getVisibility() == 0 && !rVar.aCd) {
                rVar.aBn.lK();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aBy.hide();
        setVisibility(8);
        Dc();
    }

    public void Bp() {
        this.aBy.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aBw.setBarLauncherEnabled(z);
    }

    public void d(boolean z, int i) {
        this.aBw.d(z, i);
    }

    public boolean CY() {
        return this.aBy.CY();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aBE = i;
    }

    public void setBarLauncherType(int i) {
        this.aBw.setBarLauncherType(i);
    }

    public void bD(boolean z) {
        this.aBw.bD(z);
    }

    public void bE(boolean z) {
        this.aBw.bE(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aBF = z;
    }

    public void setBackgroundColorId(int i) {
        this.aBG = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aBH = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void K(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r eE = eE(toolId);
            if (eE.lT()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.aBw.a(eE);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lK();
                    b(new a(1, 3, null));
                } else if (eE.aBn == null) {
                    if (eE.aCe != null && eE.aCe.length > 0) {
                        b(new a(eE.aCe[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
