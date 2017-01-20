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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private SparseArray<HashSet<Integer>> atA;
    private int atB;
    private int atC;
    private boolean atD;
    private int atE;
    private int atF;
    private boolean atG;
    private LinkedList<p> atH;
    private View.OnClickListener atI;
    private Runnable atJ;
    private List<Integer> atK;
    private g atv;
    private h atw;
    private List<x> atx;
    private SparseArray<b> aty;
    private SparseArray<HashSet<b>> atz;

    public void CB() {
        x eD = eD(3);
        if (eD != null && (eD.atm instanceof View)) {
            View view = (View) eD.atm;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
        }
    }

    public j(Context context) {
        super(context);
        this.atB = 1;
        this.atC = 0;
        this.atD = false;
        this.atE = r.e.common_color_10255;
        this.atF = 0;
        this.atG = true;
        this.atI = new k(this);
        this.atJ = new l(this);
        this.atK = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.atx = new LinkedList();
        this.aty = new SparseArray<>();
        this.atz = new SparseArray<>();
        this.atA = new SparseArray<>();
        this.atv = new g(context, this);
        this.atw = new h(context, this);
        this.atH = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.atz.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.atz.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aty.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.atA.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.atA.put(i3, hashSet2);
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
        x eD;
        if (aVar != null) {
            if (aVar.code == 2) {
                p eB = this.atv.eB(aVar.id);
                if (eB != null) {
                    z = false;
                } else {
                    eB = this.atw.eB(aVar.id);
                    z = true;
                }
                if (eB == null) {
                    Iterator<p> it = this.atH.iterator();
                    while (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                pVar = eB;
                if (pVar != null) {
                    pVar.a(aVar);
                    if (z && (eD = eD(2)) != null && eD.atm != null) {
                        eD.atm.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.atv.a((x) null);
                this.atw.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aty.get(aVar.id);
                if (bVar != null) {
                    this.atv.ez(aVar.id);
                    x eD2 = eD(aVar.id);
                    if (eD2 != null && eD2.atZ == 5) {
                        this.atw.hide();
                        CC();
                    } else {
                        this.atw.ez(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.atA.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aty.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.atz.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void CC() {
        boolean z;
        x eD;
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.atJ);
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
        if (!z && (eD = eD(3)) != null && (eD.atm instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) eD.atm);
        }
    }

    public void b(x xVar) {
        if (xVar != null) {
            this.atx.add(xVar);
        }
    }

    private void clear() {
        this.atv.clear();
        this.atw.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.atB = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.atv.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.atw.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.e(this, this.atE, i);
        this.atv.onChangeSkinType(i);
        this.atw.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.atK;
    }

    public void w(List<Integer> list) {
        this.atK.clear();
        this.atK.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Cx() {
        if (this.atx != null && this.atx.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (x xVar : this.atx) {
                if (xVar.atW > 0) {
                    linkedList.add(xVar);
                }
                if (xVar.atm != null) {
                    xVar.atm.setToolId(xVar.id);
                    xVar.atm.setEditorTools(this);
                    if (xVar.atZ == 6) {
                        this.atw.a(xVar.atm);
                    } else if (xVar.atZ == 1 || xVar.atZ == 2 || xVar.atZ == 3 || xVar.atZ == 4 || xVar.atZ == 5) {
                        this.atv.a(xVar.atm, xVar.atZ, !xVar.aua);
                        if (xVar.atZ == 5 && eD(1) == null) {
                            z = true;
                        }
                    }
                    a(xVar.aub, xVar.id, xVar.atm);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.atB) {
                u uVar = new u(getContext());
                if (this.atF > 0 && uVar.atm != null && (uVar.atm instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) uVar.atm).setBackgroundColorId(this.atF);
                }
                if (this.atC > 0) {
                    uVar.atW = this.atC;
                }
                b(uVar);
                uVar.atm.setToolId(uVar.id);
                uVar.atm.setEditorTools(this);
                a(uVar.aub, uVar.id, uVar.atm);
                this.atw.a(uVar.atm);
                if (this.atD) {
                    linkedList.add(this.atB, uVar);
                } else {
                    linkedList.add(0, uVar);
                }
            }
            int i = this.atB + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                x xVar2 = (x) it.next();
                if (i2 < i) {
                    this.atv.a(a(xVar2, 1));
                } else {
                    this.atw.a(a(xVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.atv.a(0, a);
            }
            this.atv.Cx();
            this.atw.Cx();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.atv.setLayoutParams(layoutParams);
            this.atw.setLayoutParams(layoutParams);
            this.atw.hide();
            removeAllViews();
            addView(this.atv);
            addView(this.atw);
            invalidate();
        }
    }

    public void c(x xVar) {
        if (xVar != null) {
            b(xVar);
            p a = a(xVar, 1);
            a.hide();
            if (this.atv != null) {
                this.atv.a(0, a);
                this.atv.removeAllViews();
                this.atv.Cx();
            }
            invalidate();
        }
    }

    public x eD(int i) {
        for (x xVar : this.atx) {
            if (xVar.id == i) {
                return xVar;
            }
        }
        return null;
    }

    public List<x> getAllTools() {
        return this.atx;
    }

    public p eB(int i) {
        p eB = this.atv.eB(i);
        if (eB == null) {
            return this.atw.eB(i);
        }
        return eB;
    }

    public void CD() {
        this.atv.h(this.atI);
    }

    private p a(x xVar, int i) {
        p a = o.a(getContext(), xVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(xVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.atI);
        }
        return a;
    }

    public void bE(boolean z) {
        for (x xVar : this.atx) {
            if (xVar != null && (xVar.atm instanceof View) && ((View) xVar.atm).getVisibility() == 0 && !xVar.aua) {
                xVar.atm.lr();
            }
        }
        if (this.atG) {
            this.atG = false;
            AK();
        }
        if (!Cz() && z) {
            com.baidu.adp.lib.g.h.eE().postDelayed(this.atJ, 200L);
        }
        setVisibility(0);
    }

    public void lr() {
        bE(true);
    }

    public void CE() {
        for (x xVar : this.atx) {
            if (xVar != null && (xVar.atm instanceof View) && ((View) xVar.atm).getVisibility() == 0 && !xVar.aua) {
                xVar.atm.lr();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.atw.hide();
        setVisibility(8);
        CC();
    }

    public void AK() {
        this.atw.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.atv.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.atv.c(z, i);
    }

    public boolean Cz() {
        return this.atw.Cz();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.atC = i;
    }

    public void setBarLauncherType(int i) {
        this.atv.setBarLauncherType(i);
    }

    public void bC(boolean z) {
        this.atv.bC(z);
    }

    public void bD(boolean z) {
        this.atv.bD(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.atD = z;
    }

    public void setBackgroundColorId(int i) {
        this.atE = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.atF = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void H(View view) {
        if (view instanceof p) {
            p pVar = (p) view;
            b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
            this.atv.a(eD(pVar.getToolId()));
            if (pVar.getToolId() == 1) {
                pVar.hide();
                lr();
                b(new a(1, 3, null));
                return;
            }
            int toolId = pVar.getToolId();
            x eD = eD(toolId);
            if (eD.atm == null) {
                if (eD.aub != null && eD.aub.length > 0) {
                    b(new a(eD.aub[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }
}
