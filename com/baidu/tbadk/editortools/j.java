package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private g aoR;
    private h aoS;
    private List<v> aoT;
    private SparseArray<b> aoU;
    private SparseArray<HashSet<b>> aoV;
    private SparseArray<HashSet<Integer>> aoW;
    private int aoX;
    private int aoY;
    private boolean aoZ;
    private int apa;
    private int apb;
    private boolean apc;
    private LinkedList<p> apd;
    private View.OnClickListener ape;
    private Runnable apf;

    public void Az() {
        v dU = dU(3);
        if (dU != null && (dU.aoJ instanceof View)) {
            View view = (View) dU.aoJ;
            view.requestFocus();
            com.baidu.adp.lib.util.k.d(getContext(), view);
        }
    }

    public j(Context context) {
        super(context);
        this.aoX = 1;
        this.aoY = 0;
        this.aoZ = false;
        this.apa = i.c.editor_background;
        this.apb = 0;
        this.apc = true;
        this.ape = new k(this);
        this.apf = new l(this);
        init(context);
    }

    private void init(Context context) {
        this.aoT = new LinkedList();
        this.aoU = new SparseArray<>();
        this.aoV = new SparseArray<>();
        this.aoW = new SparseArray<>();
        this.aoR = new g(context, this);
        this.aoS = new h(context, this);
        this.apd = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aoV.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aoV.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aoU.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aoW.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aoW.put(i3, hashSet2);
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
        v dU;
        if (aVar != null) {
            if (aVar.code == 2) {
                p dS = this.aoR.dS(aVar.id);
                if (dS != null) {
                    z = false;
                } else {
                    dS = this.aoS.dS(aVar.id);
                    z = true;
                }
                if (dS == null) {
                    Iterator<p> it = this.apd.iterator();
                    while (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                pVar = dS;
                if (pVar != null) {
                    pVar.a(aVar);
                    if (z && (dU = dU(2)) != null && dU.aoJ != null) {
                        dU.aoJ.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aoR.a((v) null);
                this.aoS.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aoU.get(aVar.id);
                if (bVar != null) {
                    this.aoR.dQ(aVar.id);
                    v dU2 = dU(aVar.id);
                    if (dU2 != null && dU2.apv == 5) {
                        this.aoS.hide();
                        AA();
                    } else {
                        this.aoS.dQ(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aoW.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aoU.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aoV.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    private void AA() {
        boolean z;
        v dU;
        com.baidu.adp.lib.g.h.hg().removeCallbacks(this.apf);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.k.c(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && (dU = dU(3)) != null && (dU.aoJ instanceof View)) {
            com.baidu.adp.lib.util.k.c(getContext(), (View) dU.aoJ);
        }
    }

    public void b(v vVar) {
        if (vVar != null) {
            this.aoT.add(vVar);
        }
    }

    private void clear() {
        this.aoR.clear();
        this.aoS.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aoX = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aoR.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aoS.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        an.d(this, this.apa, i);
        this.aoR.onChangeSkinType(i);
        this.aoS.onChangeSkinType(i);
    }

    public void Av() {
        if (this.aoT != null && this.aoT.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (v vVar : this.aoT) {
                if (vVar.aps > 0) {
                    linkedList.add(vVar);
                }
                if (vVar.aoJ != null) {
                    vVar.aoJ.setToolId(vVar.id);
                    vVar.aoJ.setEditorTools(this);
                    if (vVar.apv == 6) {
                        this.aoS.a(vVar.aoJ);
                    } else if (vVar.apv == 1 || vVar.apv == 2 || vVar.apv == 3 || vVar.apv == 4 || vVar.apv == 5) {
                        this.aoR.a(vVar.aoJ, vVar.apv, !vVar.apw);
                        if (vVar.apv == 5 && dU(1) == null) {
                            z = true;
                        }
                    }
                    a(vVar.apx, vVar.id, vVar.aoJ);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.aoX) {
                t tVar = new t(getContext());
                if (this.apb > 0 && tVar.aoJ != null && (tVar.aoJ instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) tVar.aoJ).setBackgroundColorId(this.apb);
                }
                if (this.aoY > 0) {
                    tVar.aps = this.aoY;
                }
                b(tVar);
                tVar.aoJ.setToolId(tVar.id);
                tVar.aoJ.setEditorTools(this);
                a(tVar.apx, tVar.id, tVar.aoJ);
                this.aoS.a(tVar.aoJ);
                if (this.aoZ) {
                    linkedList.add(this.aoX, tVar);
                } else {
                    linkedList.add(0, tVar);
                }
            }
            int i = this.aoX + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                v vVar2 = (v) it.next();
                if (i2 < i) {
                    this.aoR.a(a(vVar2, 1));
                } else {
                    this.aoS.a(a(vVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.aoR.a(0, a);
            }
            this.aoR.Av();
            this.aoS.Av();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aoR.setLayoutParams(layoutParams);
            this.aoS.setLayoutParams(layoutParams);
            this.aoS.hide();
            removeAllViews();
            addView(this.aoR);
            addView(this.aoS);
            invalidate();
        }
    }

    public v dU(int i) {
        for (v vVar : this.aoT) {
            if (vVar.id == i) {
                return vVar;
            }
        }
        return null;
    }

    public List<v> getAllTools() {
        return this.aoT;
    }

    public p dS(int i) {
        p dS = this.aoR.dS(i);
        if (dS == null) {
            return this.aoS.dS(i);
        }
        return dS;
    }

    public void AB() {
        this.aoR.e(this.ape);
    }

    private p a(v vVar, int i) {
        p a = o.a(getContext(), vVar, i);
        if (a instanceof View) {
            ((View) a).setOnClickListener(this.ape);
        }
        return a;
    }

    public void bf(boolean z) {
        for (v vVar : this.aoT) {
            if (vVar != null && (vVar.aoJ instanceof View) && ((View) vVar.aoJ).getVisibility() == 0 && !vVar.apw) {
                vVar.aoJ.ow();
            }
        }
        if (this.apc) {
            this.apc = false;
            yX();
        }
        if (!Ax() && z) {
            com.baidu.adp.lib.g.h.hg().postDelayed(this.apf, 200L);
        }
        setVisibility(0);
    }

    public void ow() {
        bf(true);
    }

    public void hide() {
        this.aoS.hide();
        setVisibility(8);
        AA();
    }

    public void yX() {
        this.aoS.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aoR.setBarLauncherEnabled(z);
    }

    public boolean Ax() {
        return this.aoS.Ax();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aoY = i;
    }

    public void setBarLauncherType(int i) {
        this.aoR.setBarLauncherType(i);
    }

    public void setBarLinePostion(int i) {
        this.aoR.setLinePosition(i);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aoZ = z;
    }

    public void setBackgroundColorId(int i) {
        this.apa = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.apb = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
