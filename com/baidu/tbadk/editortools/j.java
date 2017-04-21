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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private g azi;
    private h azj;
    private List<x> azk;
    private SparseArray<b> azl;
    private SparseArray<HashSet<b>> azm;
    private SparseArray<HashSet<Integer>> azn;
    private int azo;
    private int azp;
    private boolean azq;
    private int azr;
    private int azs;
    private boolean azt;
    private LinkedList<p> azu;
    private View.OnClickListener azv;
    private Runnable azw;
    private List<Integer> azx;

    public void Ds() {
        x eB = eB(3);
        if (eB != null && (eB.ayZ instanceof View)) {
            View view = (View) eB.ayZ;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
        }
    }

    public j(Context context) {
        super(context);
        this.azo = 1;
        this.azp = 0;
        this.azq = false;
        this.azr = w.e.common_color_10255;
        this.azs = 0;
        this.azt = true;
        this.azv = new k(this);
        this.azw = new l(this);
        this.azx = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.azk = new LinkedList();
        this.azl = new SparseArray<>();
        this.azm = new SparseArray<>();
        this.azn = new SparseArray<>();
        this.azi = new g(context, this);
        this.azj = new h(context, this);
        this.azu = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.azm.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.azm.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.azl.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.azn.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.azn.put(i3, hashSet2);
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
        x eB;
        if (aVar != null) {
            if (aVar.code == 2) {
                p ez = this.azi.ez(aVar.id);
                if (ez != null) {
                    z = false;
                } else {
                    ez = this.azj.ez(aVar.id);
                    z = true;
                }
                if (ez == null) {
                    Iterator<p> it = this.azu.iterator();
                    while (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                pVar = ez;
                if (pVar != null) {
                    pVar.a(aVar);
                    if (z && (eB = eB(2)) != null && eB.ayZ != null) {
                        eB.ayZ.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.azi.a((x) null);
                this.azj.hide();
            } else if (aVar.id > 0) {
                b bVar = this.azl.get(aVar.id);
                if (bVar != null) {
                    this.azi.ex(aVar.id);
                    x eB2 = eB(aVar.id);
                    if (eB2 != null && eB2.azM == 5) {
                        this.azj.hide();
                        Dt();
                    } else {
                        this.azj.ex(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.azn.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.azl.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.azm.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Dt() {
        boolean z;
        x eB;
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.azw);
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
        if (!z && (eB = eB(3)) != null && (eB.ayZ instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) eB.ayZ);
        }
    }

    public void b(x xVar) {
        if (xVar != null) {
            this.azk.add(xVar);
        }
    }

    private void clear() {
        this.azi.clear();
        this.azj.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.azo = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.azi.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.azj.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aq.e(this, this.azr, i);
        this.azi.onChangeSkinType(i);
        this.azj.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.azx;
    }

    public void u(List<Integer> list) {
        this.azx.clear();
        this.azx.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Do() {
        if (this.azk != null && this.azk.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (x xVar : this.azk) {
                if (xVar.azJ > 0) {
                    linkedList.add(xVar);
                }
                if (xVar.ayZ != null) {
                    xVar.ayZ.setToolId(xVar.id);
                    xVar.ayZ.setEditorTools(this);
                    if (xVar.azM == 6) {
                        this.azj.a(xVar.ayZ);
                    } else if (xVar.azM == 1 || xVar.azM == 2 || xVar.azM == 3 || xVar.azM == 4 || xVar.azM == 5) {
                        this.azi.a(xVar.ayZ, xVar.azM, !xVar.azN);
                        if (xVar.azM == 5 && eB(1) == null) {
                            z = true;
                        }
                    }
                    a(xVar.azO, xVar.id, xVar.ayZ);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.azo) {
                u uVar = new u(getContext());
                if (this.azs > 0 && uVar.ayZ != null && (uVar.ayZ instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) uVar.ayZ).setBackgroundColorId(this.azs);
                }
                if (this.azp > 0) {
                    uVar.azJ = this.azp;
                }
                b(uVar);
                uVar.ayZ.setToolId(uVar.id);
                uVar.ayZ.setEditorTools(this);
                a(uVar.azO, uVar.id, uVar.ayZ);
                this.azj.a(uVar.ayZ);
                if (this.azq) {
                    linkedList.add(this.azo, uVar);
                } else {
                    linkedList.add(0, uVar);
                }
            }
            int i = this.azo + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                x xVar2 = (x) it.next();
                if (i2 < i) {
                    this.azi.a(a(xVar2, 1));
                } else {
                    this.azj.a(a(xVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.azi.a(0, a);
            }
            this.azi.Do();
            this.azj.Do();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.azi.setLayoutParams(layoutParams);
            this.azj.setLayoutParams(layoutParams);
            this.azj.hide();
            removeAllViews();
            addView(this.azi);
            addView(this.azj);
            invalidate();
        }
    }

    public void c(x xVar) {
        if (xVar != null) {
            b(xVar);
            p a = a(xVar, 1);
            a.hide();
            if (this.azi != null) {
                this.azi.a(0, a);
                this.azi.removeAllViews();
                this.azi.Do();
            }
            invalidate();
        }
    }

    public x eB(int i) {
        for (x xVar : this.azk) {
            if (xVar.id == i) {
                return xVar;
            }
        }
        return null;
    }

    public List<x> getAllTools() {
        return this.azk;
    }

    public p ez(int i) {
        p ez = this.azi.ez(i);
        if (ez == null) {
            return this.azj.ez(i);
        }
        return ez;
    }

    public void Du() {
        this.azi.h(this.azv);
    }

    private p a(x xVar, int i) {
        p a = o.a(getContext(), xVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(xVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.azv);
        }
        return a;
    }

    public void bF(boolean z) {
        for (x xVar : this.azk) {
            if (xVar != null && (xVar.ayZ instanceof View) && ((View) xVar.ayZ).getVisibility() == 0 && !xVar.azN) {
                xVar.ayZ.mp();
            }
        }
        if (this.azt) {
            this.azt = false;
            BC();
        }
        if (!Dq() && z) {
            com.baidu.adp.lib.g.h.fS().postDelayed(this.azw, 200L);
        }
        setVisibility(0);
    }

    public void mp() {
        bF(true);
    }

    public void Dv() {
        for (x xVar : this.azk) {
            if (xVar != null && (xVar.ayZ instanceof View) && ((View) xVar.ayZ).getVisibility() == 0 && !xVar.azN) {
                xVar.ayZ.mp();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.azj.hide();
        setVisibility(8);
        Dt();
    }

    public void BC() {
        this.azj.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.azi.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.azi.c(z, i);
    }

    public boolean Dq() {
        return this.azj.Dq();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.azp = i;
    }

    public void setBarLauncherType(int i) {
        this.azi.setBarLauncherType(i);
    }

    public void bD(boolean z) {
        this.azi.bD(z);
    }

    public void bE(boolean z) {
        this.azi.bE(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.azq = z;
    }

    public void setBackgroundColorId(int i) {
        this.azr = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.azs = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void F(View view) {
        if (view instanceof p) {
            p pVar = (p) view;
            b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
            this.azi.a(eB(pVar.getToolId()));
            if (pVar.getToolId() == 1) {
                pVar.hide();
                mp();
                b(new a(1, 3, null));
                return;
            }
            int toolId = pVar.getToolId();
            x eB = eB(toolId);
            if (eB.ayZ == null) {
                if (eB.azO != null && eB.azO.length > 0) {
                    b(new a(eB.azO[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }
}
