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
    private g azg;
    private h azh;
    private List<x> azi;
    private SparseArray<b> azj;
    private SparseArray<HashSet<b>> azk;
    private SparseArray<HashSet<Integer>> azl;
    private int azm;
    private int azn;
    private boolean azo;
    private int azp;
    private int azq;
    private boolean azr;
    private LinkedList<p> azs;
    private View.OnClickListener azt;
    private Runnable azu;
    private List<Integer> azv;

    public void Cx() {
        x ex = ex(3);
        if (ex != null && (ex.ayX instanceof View)) {
            View view = (View) ex.ayX;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
        }
    }

    public j(Context context) {
        super(context);
        this.azm = 1;
        this.azn = 0;
        this.azo = false;
        this.azp = w.e.common_color_10255;
        this.azq = 0;
        this.azr = true;
        this.azt = new k(this);
        this.azu = new l(this);
        this.azv = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.azi = new LinkedList();
        this.azj = new SparseArray<>();
        this.azk = new SparseArray<>();
        this.azl = new SparseArray<>();
        this.azg = new g(context, this);
        this.azh = new h(context, this);
        this.azs = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.azk.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.azk.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.azj.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.azl.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.azl.put(i3, hashSet2);
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
        x ex;
        if (aVar != null) {
            if (aVar.code == 2) {
                p ev = this.azg.ev(aVar.id);
                if (ev != null) {
                    z = false;
                } else {
                    ev = this.azh.ev(aVar.id);
                    z = true;
                }
                if (ev == null) {
                    Iterator<p> it = this.azs.iterator();
                    while (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                pVar = ev;
                if (pVar != null) {
                    pVar.a(aVar);
                    if (z && (ex = ex(2)) != null && ex.ayX != null) {
                        ex.ayX.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.azg.a((x) null);
                this.azh.hide();
            } else if (aVar.id > 0) {
                b bVar = this.azj.get(aVar.id);
                if (bVar != null) {
                    this.azg.et(aVar.id);
                    x ex2 = ex(aVar.id);
                    if (ex2 != null && ex2.azK == 5) {
                        this.azh.hide();
                        Cy();
                    } else {
                        this.azh.et(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.azl.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.azj.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.azk.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Cy() {
        boolean z;
        x ex;
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.azu);
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
        if (!z && (ex = ex(3)) != null && (ex.ayX instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) ex.ayX);
        }
    }

    public void b(x xVar) {
        if (xVar != null) {
            this.azi.add(xVar);
        }
    }

    private void clear() {
        this.azg.clear();
        this.azh.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.azm = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.azg.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.azh.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aq.e(this, this.azp, i);
        this.azg.onChangeSkinType(i);
        this.azh.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.azv;
    }

    public void v(List<Integer> list) {
        this.azv.clear();
        this.azv.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Ct() {
        if (this.azi != null && this.azi.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (x xVar : this.azi) {
                if (xVar.azH > 0) {
                    linkedList.add(xVar);
                }
                if (xVar.ayX != null) {
                    xVar.ayX.setToolId(xVar.id);
                    xVar.ayX.setEditorTools(this);
                    if (xVar.azK == 6) {
                        this.azh.a(xVar.ayX);
                    } else if (xVar.azK == 1 || xVar.azK == 2 || xVar.azK == 3 || xVar.azK == 4 || xVar.azK == 5) {
                        this.azg.a(xVar.ayX, xVar.azK, !xVar.azL);
                        if (xVar.azK == 5 && ex(1) == null) {
                            z = true;
                        }
                    }
                    a(xVar.azM, xVar.id, xVar.ayX);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.azm) {
                u uVar = new u(getContext());
                if (this.azq > 0 && uVar.ayX != null && (uVar.ayX instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) uVar.ayX).setBackgroundColorId(this.azq);
                }
                if (this.azn > 0) {
                    uVar.azH = this.azn;
                }
                b(uVar);
                uVar.ayX.setToolId(uVar.id);
                uVar.ayX.setEditorTools(this);
                a(uVar.azM, uVar.id, uVar.ayX);
                this.azh.a(uVar.ayX);
                if (this.azo) {
                    linkedList.add(this.azm, uVar);
                } else {
                    linkedList.add(0, uVar);
                }
            }
            int i = this.azm + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                x xVar2 = (x) it.next();
                if (i2 < i) {
                    this.azg.a(a(xVar2, 1));
                } else {
                    this.azh.a(a(xVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.azg.a(0, a);
            }
            this.azg.Ct();
            this.azh.Ct();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.azg.setLayoutParams(layoutParams);
            this.azh.setLayoutParams(layoutParams);
            this.azh.hide();
            removeAllViews();
            addView(this.azg);
            addView(this.azh);
            invalidate();
        }
    }

    public void c(x xVar) {
        if (xVar != null) {
            b(xVar);
            p a = a(xVar, 1);
            a.hide();
            if (this.azg != null) {
                this.azg.a(0, a);
                this.azg.removeAllViews();
                this.azg.Ct();
            }
            invalidate();
        }
    }

    public x ex(int i) {
        for (x xVar : this.azi) {
            if (xVar.id == i) {
                return xVar;
            }
        }
        return null;
    }

    public List<x> getAllTools() {
        return this.azi;
    }

    public p ev(int i) {
        p ev = this.azg.ev(i);
        if (ev == null) {
            return this.azh.ev(i);
        }
        return ev;
    }

    public void Cz() {
        this.azg.h(this.azt);
    }

    private p a(x xVar, int i) {
        p a = o.a(getContext(), xVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(xVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.azt);
        }
        return a;
    }

    public void bF(boolean z) {
        for (x xVar : this.azi) {
            if (xVar != null && (xVar.ayX instanceof View) && ((View) xVar.ayX).getVisibility() == 0 && !xVar.azL) {
                xVar.ayX.lW();
            }
        }
        if (this.azr) {
            this.azr = false;
            AN();
        }
        if (!Cv() && z) {
            com.baidu.adp.lib.g.h.fS().postDelayed(this.azu, 200L);
        }
        setVisibility(0);
    }

    public void lW() {
        bF(true);
    }

    public void CA() {
        for (x xVar : this.azi) {
            if (xVar != null && (xVar.ayX instanceof View) && ((View) xVar.ayX).getVisibility() == 0 && !xVar.azL) {
                xVar.ayX.lW();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.azh.hide();
        setVisibility(8);
        Cy();
    }

    public void AN() {
        this.azh.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.azg.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.azg.c(z, i);
    }

    public boolean Cv() {
        return this.azh.Cv();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.azn = i;
    }

    public void setBarLauncherType(int i) {
        this.azg.setBarLauncherType(i);
    }

    public void bD(boolean z) {
        this.azg.bD(z);
    }

    public void bE(boolean z) {
        this.azg.bE(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.azo = z;
    }

    public void setBackgroundColorId(int i) {
        this.azp = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.azq = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void E(View view) {
        if (view instanceof p) {
            p pVar = (p) view;
            b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
            this.azg.a(ex(pVar.getToolId()));
            if (pVar.getToolId() == 1) {
                pVar.hide();
                lW();
                b(new a(1, 3, null));
                return;
            }
            int toolId = pVar.getToolId();
            x ex = ex(toolId);
            if (ex.ayX == null) {
                if (ex.azM != null && ex.azM.length > 0) {
                    b(new a(ex.azM[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }
}
