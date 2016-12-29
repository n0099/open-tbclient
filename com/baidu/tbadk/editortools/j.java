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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private int auA;
    private boolean auB;
    private LinkedList<p> auC;
    private View.OnClickListener auD;
    private Runnable auE;
    private List<Integer> auF;
    private g auq;
    private h aur;
    private List<x> aus;
    private SparseArray<b> aut;
    private SparseArray<HashSet<b>> auu;
    private SparseArray<HashSet<Integer>> auv;
    private int auw;
    private int aux;
    private boolean auy;
    private int auz;

    public void CG() {
        x eC = eC(3);
        if (eC != null && (eC.auh instanceof View)) {
            View view = (View) eC.auh;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
        }
    }

    public j(Context context) {
        super(context);
        this.auw = 1;
        this.aux = 0;
        this.auy = false;
        this.auz = r.d.common_color_10255;
        this.auA = 0;
        this.auB = true;
        this.auD = new k(this);
        this.auE = new l(this);
        this.auF = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.aus = new LinkedList();
        this.aut = new SparseArray<>();
        this.auu = new SparseArray<>();
        this.auv = new SparseArray<>();
        this.auq = new g(context, this);
        this.aur = new h(context, this);
        this.auC = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.auu.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.auu.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aut.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.auv.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.auv.put(i3, hashSet2);
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
        x eC;
        if (aVar != null) {
            if (aVar.code == 2) {
                p eA = this.auq.eA(aVar.id);
                if (eA != null) {
                    z = false;
                } else {
                    eA = this.aur.eA(aVar.id);
                    z = true;
                }
                if (eA == null) {
                    Iterator<p> it = this.auC.iterator();
                    while (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                pVar = eA;
                if (pVar != null) {
                    pVar.a(aVar);
                    if (z && (eC = eC(2)) != null && eC.auh != null) {
                        eC.auh.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.auq.a((x) null);
                this.aur.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aut.get(aVar.id);
                if (bVar != null) {
                    this.auq.ey(aVar.id);
                    x eC2 = eC(aVar.id);
                    if (eC2 != null && eC2.auU == 5) {
                        this.aur.hide();
                        CH();
                    } else {
                        this.aur.ey(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.auv.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aut.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.auu.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void CH() {
        boolean z;
        x eC;
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.auE);
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
        if (!z && (eC = eC(3)) != null && (eC.auh instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) eC.auh);
        }
    }

    public void b(x xVar) {
        if (xVar != null) {
            this.aus.add(xVar);
        }
    }

    private void clear() {
        this.auq.clear();
        this.aur.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.auw = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.auq.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aur.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ar.e(this, this.auz, i);
        this.auq.onChangeSkinType(i);
        this.aur.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.auF;
    }

    public void y(List<Integer> list) {
        this.auF.clear();
        this.auF.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CC() {
        if (this.aus != null && this.aus.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (x xVar : this.aus) {
                if (xVar.auR > 0) {
                    linkedList.add(xVar);
                }
                if (xVar.auh != null) {
                    xVar.auh.setToolId(xVar.id);
                    xVar.auh.setEditorTools(this);
                    if (xVar.auU == 6) {
                        this.aur.a(xVar.auh);
                    } else if (xVar.auU == 1 || xVar.auU == 2 || xVar.auU == 3 || xVar.auU == 4 || xVar.auU == 5) {
                        this.auq.a(xVar.auh, xVar.auU, !xVar.auV);
                        if (xVar.auU == 5 && eC(1) == null) {
                            z = true;
                        }
                    }
                    a(xVar.auW, xVar.id, xVar.auh);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.auw) {
                u uVar = new u(getContext());
                if (this.auA > 0 && uVar.auh != null && (uVar.auh instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) uVar.auh).setBackgroundColorId(this.auA);
                }
                if (this.aux > 0) {
                    uVar.auR = this.aux;
                }
                b(uVar);
                uVar.auh.setToolId(uVar.id);
                uVar.auh.setEditorTools(this);
                a(uVar.auW, uVar.id, uVar.auh);
                this.aur.a(uVar.auh);
                if (this.auy) {
                    linkedList.add(this.auw, uVar);
                } else {
                    linkedList.add(0, uVar);
                }
            }
            int i = this.auw + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                x xVar2 = (x) it.next();
                if (i2 < i) {
                    this.auq.a(a(xVar2, 1));
                } else {
                    this.aur.a(a(xVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.auq.a(0, a);
            }
            this.auq.CC();
            this.aur.CC();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.auq.setLayoutParams(layoutParams);
            this.aur.setLayoutParams(layoutParams);
            this.aur.hide();
            removeAllViews();
            addView(this.auq);
            addView(this.aur);
            invalidate();
        }
    }

    public void c(x xVar) {
        if (xVar != null) {
            b(xVar);
            p a = a(xVar, 1);
            a.hide();
            if (this.auq != null) {
                this.auq.a(0, a);
                this.auq.removeAllViews();
                this.auq.CC();
            }
            invalidate();
        }
    }

    public x eC(int i) {
        for (x xVar : this.aus) {
            if (xVar.id == i) {
                return xVar;
            }
        }
        return null;
    }

    public List<x> getAllTools() {
        return this.aus;
    }

    public p eA(int i) {
        p eA = this.auq.eA(i);
        if (eA == null) {
            return this.aur.eA(i);
        }
        return eA;
    }

    public void CI() {
        this.auq.h(this.auD);
    }

    private p a(x xVar, int i) {
        p a = o.a(getContext(), xVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(xVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.auD);
        }
        return a;
    }

    public void bE(boolean z) {
        for (x xVar : this.aus) {
            if (xVar != null && (xVar.auh instanceof View) && ((View) xVar.auh).getVisibility() == 0 && !xVar.auV) {
                xVar.auh.lz();
            }
        }
        if (this.auB) {
            this.auB = false;
            AP();
        }
        if (!CE() && z) {
            com.baidu.adp.lib.h.h.eG().postDelayed(this.auE, 200L);
        }
        setVisibility(0);
    }

    public void lz() {
        bE(true);
    }

    public void CJ() {
        for (x xVar : this.aus) {
            if (xVar != null && (xVar.auh instanceof View) && ((View) xVar.auh).getVisibility() == 0 && !xVar.auV) {
                xVar.auh.lz();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aur.hide();
        setVisibility(8);
        CH();
    }

    public void AP() {
        this.aur.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.auq.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.auq.c(z, i);
    }

    public boolean CE() {
        return this.aur.CE();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aux = i;
    }

    public void setBarLauncherType(int i) {
        this.auq.setBarLauncherType(i);
    }

    public void bC(boolean z) {
        this.auq.bC(z);
    }

    public void bD(boolean z) {
        this.auq.bD(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.auy = z;
    }

    public void setBackgroundColorId(int i) {
        this.auz = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.auA = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void J(View view) {
        if (view instanceof p) {
            p pVar = (p) view;
            b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
            this.auq.a(eC(pVar.getToolId()));
            if (pVar.getToolId() == 1) {
                pVar.hide();
                lz();
                b(new a(1, 3, null));
                return;
            }
            int toolId = pVar.getToolId();
            x eC = eC(toolId);
            if (eC.auh == null) {
                if (eC.auW != null && eC.auW.length > 0) {
                    b(new a(eC.auW[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }
}
