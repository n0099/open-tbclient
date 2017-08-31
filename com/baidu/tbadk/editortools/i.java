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
    private View aBA;
    private h aBB;
    private List<r> aBC;
    private SparseArray<b> aBD;
    private SparseArray<HashSet<b>> aBE;
    private SparseArray<HashSet<Integer>> aBF;
    private int aBG;
    private int aBH;
    private boolean aBI;
    private int aBJ;
    private int aBK;
    private boolean aBL;
    private LinkedList<l> aBM;
    private boolean aBN;
    private View.OnClickListener aBO;
    private Runnable aBP;
    private List<Integer> aBQ;
    private g aBz;

    public void Da() {
        r eE = eE(3);
        if (eE != null && (eE.aBq instanceof View)) {
            View view = (View) eE.aBq;
            view.requestFocus();
            com.baidu.adp.lib.util.k.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aBG = 1;
        this.aBH = 0;
        this.aBI = false;
        this.aBJ = d.e.common_color_10255;
        this.aBK = 0;
        this.aBL = true;
        this.aBN = false;
        this.aBO = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.K(view);
            }
        };
        this.aBP = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Da();
            }
        };
        this.aBQ = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aBN = z;
    }

    public boolean Db() {
        return this.aBN;
    }

    private void init(Context context) {
        this.aBC = new LinkedList();
        this.aBD = new SparseArray<>();
        this.aBE = new SparseArray<>();
        this.aBF = new SparseArray<>();
        this.aBz = new g(context, this);
        this.aBB = new h(context, this);
        this.aBM = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aBE.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aBE.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aBD.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aBF.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aBF.put(i3, hashSet2);
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
                l eC = this.aBz.eC(aVar.id);
                if (eC != null) {
                    z = false;
                } else {
                    eC = this.aBB.eC(aVar.id);
                    z = true;
                }
                if (eC == null) {
                    Iterator<l> it = this.aBM.iterator();
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
                    if (z && (eE = eE(2)) != null && eE.aBq != null) {
                        eE.aBq.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aBz.a((r) null);
                this.aBB.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aBD.get(aVar.id);
                if (bVar != null) {
                    this.aBz.eA(aVar.id);
                    r eE2 = eE(aVar.id);
                    if (eE2 != null && eE2.aCf == 5) {
                        this.aBB.hide();
                        Dc();
                    } else {
                        this.aBB.eA(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aBF.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aBD.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aBE.get(aVar.code);
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
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.aBP);
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
        if (!z && (eE = eE(3)) != null && (eE.aBq instanceof View)) {
            com.baidu.adp.lib.util.k.a(getContext(), (View) eE.aBq);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aBC.add(rVar);
        }
    }

    private void clear() {
        this.aBz.clear();
        this.aBB.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aBG = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aBz.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aBB.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.e(this, this.aBJ, i);
        if (this.aBA != null) {
            aj.e(this.aBA, d.e.cp_bg_line_c, i);
        }
        this.aBz.onChangeSkinType(i);
        this.aBB.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aBQ;
    }

    public void A(List<Integer> list) {
        this.aBQ.clear();
        this.aBQ.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CW() {
        if (this.aBC != null && this.aBC.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aBC) {
                if (rVar.aCc > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aBq != null) {
                    rVar.aBq.setToolId(rVar.id);
                    rVar.aBq.setEditorTools(this);
                    if (rVar.aCf == 6) {
                        this.aBB.a(rVar.aBq);
                    } else if (rVar.aCf == 1 || rVar.aCf == 2 || rVar.aCf == 3 || rVar.aCf == 4 || rVar.aCf == 5) {
                        this.aBz.a(rVar.aBq, rVar.aCf, !rVar.aCg);
                        if (rVar.aCf == 5 && eE(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aCh, rVar.id, rVar.aBq);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aCe - rVar3.aCe;
                }
            });
            if (linkedList.size() > this.aBG) {
                o oVar = new o(getContext());
                if (this.aBK > 0 && oVar.aBq != null && (oVar.aBq instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aBq).setBackgroundColorId(this.aBK);
                }
                if (this.aBH > 0) {
                    oVar.aCc = this.aBH;
                }
                b(oVar);
                oVar.aBq.setToolId(oVar.id);
                oVar.aBq.setEditorTools(this);
                a(oVar.aCh, oVar.id, oVar.aBq);
                this.aBB.a(oVar.aBq);
                if (this.aBI) {
                    linkedList.add(this.aBG, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aBG + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aBz.a(a(rVar2, 1));
                } else {
                    this.aBB.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aBz.a(0, a);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.f.ds1));
            this.aBA = new View(getContext());
            this.aBA.setLayoutParams(layoutParams);
            this.aBA.setBackgroundResource(d.e.cp_bg_line_c);
            this.aBz.CW();
            this.aBB.CW();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.aBz.setLayoutParams(layoutParams2);
            this.aBB.setLayoutParams(layoutParams2);
            this.aBB.hide();
            removeAllViews();
            addView(this.aBA);
            addView(this.aBz);
            addView(this.aBB);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aBz != null) {
                this.aBz.a(0, a);
                this.aBz.removeAllViews();
                this.aBz.CW();
            }
            invalidate();
        }
    }

    public r eE(int i) {
        for (r rVar : this.aBC) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aBC;
    }

    public l eC(int i) {
        l eC = this.aBz.eC(i);
        if (eC == null) {
            return this.aBB.eC(i);
        }
        return eC;
    }

    public void Dd() {
        this.aBz.d(this.aBO);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aBO);
        }
        return a;
    }

    public void bF(boolean z) {
        for (r rVar : this.aBC) {
            if (rVar != null && (rVar.aBq instanceof View) && ((View) rVar.aBq).getVisibility() == 0 && !rVar.aCg) {
                rVar.aBq.lK();
            }
        }
        if (this.aBL) {
            this.aBL = false;
            Bp();
        }
        if (!CY() && z) {
            com.baidu.adp.lib.g.e.fQ().postDelayed(this.aBP, 200L);
        }
        setVisibility(0);
    }

    public void lK() {
        bF(true);
    }

    public void De() {
        for (r rVar : this.aBC) {
            if (rVar != null && (rVar.aBq instanceof View) && ((View) rVar.aBq).getVisibility() == 0 && !rVar.aCg) {
                rVar.aBq.lK();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aBB.hide();
        setVisibility(8);
        Dc();
    }

    public void Bp() {
        this.aBB.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aBz.setBarLauncherEnabled(z);
    }

    public void d(boolean z, int i) {
        this.aBz.d(z, i);
    }

    public boolean CY() {
        return this.aBB.CY();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aBH = i;
    }

    public void setBarLauncherType(int i) {
        this.aBz.setBarLauncherType(i);
    }

    public void bD(boolean z) {
        this.aBz.bD(z);
    }

    public void bE(boolean z) {
        this.aBz.bE(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aBI = z;
    }

    public void setBackgroundColorId(int i) {
        this.aBJ = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aBK = i;
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
                this.aBz.a(eE);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lK();
                    b(new a(1, 3, null));
                } else if (eE.aBq == null) {
                    if (eE.aCh != null && eE.aCh.length > 0) {
                        b(new a(eE.aCh[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
