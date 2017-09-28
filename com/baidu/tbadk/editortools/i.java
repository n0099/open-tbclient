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
    private g aAQ;
    private View aAR;
    private h aAS;
    private List<r> aAT;
    private SparseArray<b> aAU;
    private SparseArray<HashSet<b>> aAV;
    private SparseArray<HashSet<Integer>> aAW;
    private int aAX;
    private int aAY;
    private boolean aAZ;
    private int aBa;
    private int aBb;
    private boolean aBc;
    private LinkedList<l> aBd;
    private boolean aBe;
    private View.OnClickListener aBf;
    private Runnable aBg;
    private List<Integer> aBh;

    public void CE() {
        r eP = eP(3);
        if (eP != null && (eP.aAH instanceof View)) {
            View view = (View) eP.aAH;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aAX = 1;
        this.aAY = 0;
        this.aAZ = false;
        this.aBa = d.e.common_color_10255;
        this.aBb = 0;
        this.aBc = true;
        this.aBe = false;
        this.aBf = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.L(view);
            }
        };
        this.aBg = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.CE();
            }
        };
        this.aBh = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aBe = z;
    }

    public boolean CF() {
        return this.aBe;
    }

    private void init(Context context) {
        this.aAT = new LinkedList();
        this.aAU = new SparseArray<>();
        this.aAV = new SparseArray<>();
        this.aAW = new SparseArray<>();
        this.aAQ = new g(context, this);
        this.aAS = new h(context, this);
        this.aBd = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aAV.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aAV.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aAU.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aAW.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aAW.put(i3, hashSet2);
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
                l eN = this.aAQ.eN(aVar.id);
                if (eN != null) {
                    z = false;
                } else {
                    eN = this.aAS.eN(aVar.id);
                    z = true;
                }
                if (eN == null) {
                    Iterator<l> it = this.aBd.iterator();
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
                    if (z && (eP = eP(2)) != null && eP.aAH != null) {
                        eP.aAH.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aAQ.a((r) null);
                this.aAS.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aAU.get(aVar.id);
                if (bVar != null) {
                    this.aAQ.eL(aVar.id);
                    r eP2 = eP(aVar.id);
                    if (eP2 != null && eP2.aBw == 5) {
                        this.aAS.hide();
                        CG();
                    } else {
                        this.aAS.eL(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aAW.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aAU.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aAV.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void CG() {
        boolean z;
        r eP;
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aBg);
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
        if (!z && (eP = eP(3)) != null && (eP.aAH instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) eP.aAH);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aAT.add(rVar);
        }
    }

    private void clear() {
        this.aAQ.clear();
        this.aAS.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aAX = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aAQ.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aAS.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.e(this, this.aBa, i);
        if (this.aAR != null) {
            aj.e(this.aAR, d.e.cp_bg_line_c, i);
        }
        this.aAQ.onChangeSkinType(i);
        this.aAS.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aBh;
    }

    public void z(List<Integer> list) {
        this.aBh.clear();
        this.aBh.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CA() {
        if (this.aAT != null && this.aAT.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aAT) {
                if (rVar.aBt > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aAH != null) {
                    rVar.aAH.setToolId(rVar.id);
                    rVar.aAH.setEditorTools(this);
                    if (rVar.aBw == 6) {
                        this.aAS.a(rVar.aAH);
                    } else if (rVar.aBw == 1 || rVar.aBw == 2 || rVar.aBw == 3 || rVar.aBw == 4 || rVar.aBw == 5) {
                        this.aAQ.a(rVar.aAH, rVar.aBw, !rVar.aBx);
                        if (rVar.aBw == 5 && eP(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aBy, rVar.id, rVar.aAH);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aBv - rVar3.aBv;
                }
            });
            if (linkedList.size() > this.aAX) {
                o oVar = new o(getContext());
                if (this.aBb > 0 && oVar.aAH != null && (oVar.aAH instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aAH).setBackgroundColorId(this.aBb);
                }
                if (this.aAY > 0) {
                    oVar.aBt = this.aAY;
                }
                b(oVar);
                oVar.aAH.setToolId(oVar.id);
                oVar.aAH.setEditorTools(this);
                a(oVar.aBy, oVar.id, oVar.aAH);
                this.aAS.a(oVar.aAH);
                if (this.aAZ) {
                    linkedList.add(this.aAX, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aAX + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aAQ.a(a(rVar2, 1));
                } else {
                    this.aAS.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aAQ.a(0, a);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.f.ds1));
            this.aAR = new View(getContext());
            this.aAR.setLayoutParams(layoutParams);
            this.aAR.setBackgroundResource(d.e.cp_bg_line_c);
            this.aAQ.CA();
            this.aAS.CA();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.aAQ.setLayoutParams(layoutParams2);
            this.aAS.setLayoutParams(layoutParams2);
            this.aAS.hide();
            removeAllViews();
            addView(this.aAR);
            addView(this.aAQ);
            addView(this.aAS);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aAQ != null) {
                this.aAQ.a(0, a);
                this.aAQ.removeAllViews();
                this.aAQ.CA();
            }
            invalidate();
        }
    }

    public r eP(int i) {
        for (r rVar : this.aAT) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aAT;
    }

    public l eN(int i) {
        l eN = this.aAQ.eN(i);
        if (eN == null) {
            return this.aAS.eN(i);
        }
        return eN;
    }

    public void CH() {
        this.aAQ.d(this.aBf);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aBf);
        }
        return a;
    }

    public void bE(boolean z) {
        for (r rVar : this.aAT) {
            if (rVar != null && (rVar.aAH instanceof View) && ((View) rVar.aAH).getVisibility() == 0 && !rVar.aBx) {
                rVar.aAH.lM();
            }
        }
        if (this.aBc) {
            this.aBc = false;
            AN();
        }
        if (!CC() && z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.aBg, 200L);
        }
        setVisibility(0);
    }

    public void lM() {
        bE(true);
    }

    public void CI() {
        for (r rVar : this.aAT) {
            if (rVar != null && (rVar.aAH instanceof View) && ((View) rVar.aAH).getVisibility() == 0 && !rVar.aBx) {
                rVar.aAH.lM();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aAS.hide();
        setVisibility(8);
        CG();
    }

    public void AN() {
        this.aAS.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aAQ.setBarLauncherEnabled(z);
    }

    public void d(boolean z, int i) {
        this.aAQ.d(z, i);
    }

    public boolean CC() {
        return this.aAS.CC();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aAY = i;
    }

    public void setBarLauncherType(int i) {
        this.aAQ.setBarLauncherType(i);
    }

    public void bC(boolean z) {
        this.aAQ.bC(z);
    }

    public void bD(boolean z) {
        this.aAQ.bD(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aAZ = z;
    }

    public void setBackgroundColorId(int i) {
        this.aBa = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aBb = i;
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
            if (eP.lV()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.aAQ.a(eP);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lM();
                    b(new a(1, 3, null));
                } else if (eP.aAH == null) {
                    if (eP.aBy != null && eP.aBy.length > 0) {
                        b(new a(eP.aBy[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
