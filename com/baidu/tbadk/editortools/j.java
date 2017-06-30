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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private int aAa;
    private int aAb;
    private boolean aAc;
    private int aAd;
    private int aAe;
    private boolean aAf;
    private LinkedList<p> aAg;
    private boolean aAh;
    private View.OnClickListener aAi;
    private Runnable aAj;
    private List<Integer> aAk;
    private g azU;
    private h azV;
    private List<x> azW;
    private SparseArray<b> azX;
    private SparseArray<HashSet<b>> azY;
    private SparseArray<HashSet<Integer>> azZ;

    public void CL() {
        x eA = eA(3);
        if (eA != null && (eA.azL instanceof View)) {
            View view = (View) eA.azL;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
        }
    }

    public j(Context context) {
        super(context);
        this.aAa = 1;
        this.aAb = 0;
        this.aAc = false;
        this.aAd = w.e.common_color_10255;
        this.aAe = 0;
        this.aAf = true;
        this.aAh = false;
        this.aAi = new k(this);
        this.aAj = new l(this);
        this.aAk = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aAh = z;
    }

    public boolean CM() {
        return this.aAh;
    }

    private void init(Context context) {
        this.azW = new LinkedList();
        this.azX = new SparseArray<>();
        this.azY = new SparseArray<>();
        this.azZ = new SparseArray<>();
        this.azU = new g(context, this);
        this.azV = new h(context, this);
        this.aAg = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.azY.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.azY.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.azX.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.azZ.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.azZ.put(i3, hashSet2);
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
        p pVar;
        x eA;
        if (aVar != null) {
            if (aVar.code == 2) {
                p ey = this.azU.ey(aVar.id);
                if (ey != null) {
                    z = false;
                } else {
                    ey = this.azV.ey(aVar.id);
                    z = true;
                }
                if (ey == null) {
                    Iterator<p> it = this.aAg.iterator();
                    while (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                pVar = ey;
                if (pVar != null) {
                    pVar.a(aVar);
                    if (z && (eA = eA(2)) != null && eA.azL != null) {
                        eA.azL.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.azU.a((x) null);
                this.azV.hide();
            } else if (aVar.id > 0) {
                b bVar = this.azX.get(aVar.id);
                if (bVar != null) {
                    this.azU.ew(aVar.id);
                    x eA2 = eA(aVar.id);
                    if (eA2 != null && eA2.aAz == 5) {
                        this.azV.hide();
                        CN();
                    } else {
                        this.azV.ew(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.azZ.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.azX.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.azY.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void CN() {
        boolean z;
        x eA;
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aAj);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.k.b(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && (eA = eA(3)) != null && (eA.azL instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) eA.azL);
        }
    }

    public void b(x xVar) {
        if (xVar != null) {
            this.azW.add(xVar);
        }
    }

    private void clear() {
        this.azU.clear();
        this.azV.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aAa = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.azU.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.azV.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        as.e(this, this.aAd, i);
        this.azU.onChangeSkinType(i);
        this.azV.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aAk;
    }

    public void x(List<Integer> list) {
        this.aAk.clear();
        this.aAk.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CH() {
        if (this.azW != null && this.azW.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (x xVar : this.azW) {
                if (xVar.aAw > 0) {
                    linkedList.add(xVar);
                }
                if (xVar.azL != null) {
                    xVar.azL.setToolId(xVar.id);
                    xVar.azL.setEditorTools(this);
                    if (xVar.aAz == 6) {
                        this.azV.a(xVar.azL);
                    } else if (xVar.aAz == 1 || xVar.aAz == 2 || xVar.aAz == 3 || xVar.aAz == 4 || xVar.aAz == 5) {
                        this.azU.a(xVar.azL, xVar.aAz, !xVar.aAA);
                        if (xVar.aAz == 5 && eA(1) == null) {
                            z = true;
                        }
                    }
                    a(xVar.aAB, xVar.id, xVar.azL);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.aAa) {
                u uVar = new u(getContext());
                if (this.aAe > 0 && uVar.azL != null && (uVar.azL instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) uVar.azL).setBackgroundColorId(this.aAe);
                }
                if (this.aAb > 0) {
                    uVar.aAw = this.aAb;
                }
                b(uVar);
                uVar.azL.setToolId(uVar.id);
                uVar.azL.setEditorTools(this);
                a(uVar.aAB, uVar.id, uVar.azL);
                this.azV.a(uVar.azL);
                if (this.aAc) {
                    linkedList.add(this.aAa, uVar);
                } else {
                    linkedList.add(0, uVar);
                }
            }
            int i = this.aAa + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                x xVar2 = (x) it.next();
                if (i2 < i) {
                    this.azU.a(a(xVar2, 1));
                } else {
                    this.azV.a(a(xVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.azU.a(0, a);
            }
            this.azU.CH();
            this.azV.CH();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.azU.setLayoutParams(layoutParams);
            this.azV.setLayoutParams(layoutParams);
            this.azV.hide();
            removeAllViews();
            addView(this.azU);
            addView(this.azV);
            invalidate();
        }
    }

    public void c(x xVar) {
        if (xVar != null) {
            b(xVar);
            p a = a(xVar, 1);
            a.hide();
            if (this.azU != null) {
                this.azU.a(0, a);
                this.azU.removeAllViews();
                this.azU.CH();
            }
            invalidate();
        }
    }

    public x eA(int i) {
        for (x xVar : this.azW) {
            if (xVar.id == i) {
                return xVar;
            }
        }
        return null;
    }

    public List<x> getAllTools() {
        return this.azW;
    }

    public p ey(int i) {
        p ey = this.azU.ey(i);
        if (ey == null) {
            return this.azV.ey(i);
        }
        return ey;
    }

    public void CO() {
        this.azU.h(this.aAi);
    }

    private p a(x xVar, int i) {
        p a = o.a(getContext(), xVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(xVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aAi);
        }
        return a;
    }

    public void bD(boolean z) {
        for (x xVar : this.azW) {
            if (xVar != null && (xVar.azL instanceof View) && ((View) xVar.azL).getVisibility() == 0 && !xVar.aAA) {
                xVar.azL.lM();
            }
        }
        if (this.aAf) {
            this.aAf = false;
            Bb();
        }
        if (!CJ() && z) {
            com.baidu.adp.lib.g.h.fR().postDelayed(this.aAj, 200L);
        }
        setVisibility(0);
    }

    public void lM() {
        bD(true);
    }

    public void CP() {
        for (x xVar : this.azW) {
            if (xVar != null && (xVar.azL instanceof View) && ((View) xVar.azL).getVisibility() == 0 && !xVar.aAA) {
                xVar.azL.lM();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.azV.hide();
        setVisibility(8);
        CN();
    }

    public void Bb() {
        this.azV.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.azU.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.azU.c(z, i);
    }

    public boolean CJ() {
        return this.azV.CJ();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aAb = i;
    }

    public void setBarLauncherType(int i) {
        this.azU.setBarLauncherType(i);
    }

    public void bB(boolean z) {
        this.azU.bB(z);
    }

    public void bC(boolean z) {
        this.azU.bC(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aAc = z;
    }

    public void setBackgroundColorId(int i) {
        this.aAd = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aAe = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void F(View view) {
        if (view instanceof p) {
            p pVar = (p) view;
            int toolId = pVar.getToolId();
            x eA = eA(toolId);
            if (eA.lV()) {
                b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
                this.azU.a(eA);
                if (pVar.getToolId() == 1) {
                    pVar.hide();
                    lM();
                    b(new a(1, 3, null));
                } else if (eA.azL == null) {
                    if (eA.aAB != null && eA.aAB.length > 0) {
                        b(new a(eA.aAB[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
