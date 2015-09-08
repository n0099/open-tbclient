package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private int aqA;
    private boolean aqB;
    private LinkedList<p> aqC;
    private View.OnClickListener aqD;
    private Runnable aqE;
    private g aqq;
    private h aqr;
    private List<v> aqs;
    private SparseArray<b> aqt;
    private SparseArray<HashSet<b>> aqu;
    private SparseArray<HashSet<Integer>> aqv;
    private int aqw;
    private int aqx;
    private boolean aqy;
    private int aqz;

    public j(Context context) {
        super(context);
        this.aqw = 1;
        this.aqx = 0;
        this.aqy = false;
        this.aqz = i.c.editor_background;
        this.aqA = 0;
        this.aqB = true;
        this.aqD = new k(this);
        this.aqE = new l(this);
        init(context);
    }

    private void init(Context context) {
        this.aqs = new LinkedList();
        this.aqt = new SparseArray<>();
        this.aqu = new SparseArray<>();
        this.aqv = new SparseArray<>();
        this.aqq = new g(context, this);
        this.aqr = new h(context, this);
        this.aqC = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aqu.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aqu.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aqt.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aqv.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aqv.put(i3, hashSet2);
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
        v dT;
        if (aVar != null) {
            if (aVar.code == 2) {
                p dR = this.aqq.dR(aVar.id);
                if (dR != null) {
                    z = false;
                } else {
                    dR = this.aqr.dR(aVar.id);
                    z = true;
                }
                if (dR == null) {
                    Iterator<p> it = this.aqC.iterator();
                    while (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                pVar = dR;
                if (pVar != null) {
                    pVar.a(aVar);
                    if (z && (dT = dT(2)) != null && dT.aqi != null) {
                        dT.aqi.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aqq.a((v) null);
                this.aqr.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aqt.get(aVar.id);
                if (bVar != null) {
                    this.aqq.dP(aVar.id);
                    v dT2 = dT(aVar.id);
                    if (dT2 != null && dT2.aqT == 5) {
                        this.aqr.hide();
                        AQ();
                    } else {
                        this.aqr.dP(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aqv.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aqt.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aqu.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    private void AQ() {
        boolean z;
        v dT;
        com.baidu.adp.lib.g.h.hf().removeCallbacks(this.aqE);
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
        if (!z && (dT = dT(3)) != null && (dT.aqi instanceof View)) {
            com.baidu.adp.lib.util.k.c(getContext(), (View) dT.aqi);
        }
    }

    public void b(v vVar) {
        if (vVar != null) {
            this.aqs.add(vVar);
        }
    }

    private void clear() {
        this.aqq.clear();
        this.aqr.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aqw = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aqq.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aqr.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.d(this, this.aqz, i);
        this.aqq.onChangeSkinType(i);
        this.aqr.onChangeSkinType(i);
    }

    public void AM() {
        if (this.aqs != null && this.aqs.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (v vVar : this.aqs) {
                if (vVar.aqQ > 0) {
                    linkedList.add(vVar);
                }
                if (vVar.aqi != null) {
                    vVar.aqi.setToolId(vVar.id);
                    vVar.aqi.setEditorTools(this);
                    if (vVar.aqT == 6) {
                        this.aqr.a(vVar.aqi);
                    } else if (vVar.aqT == 1 || vVar.aqT == 2 || vVar.aqT == 3 || vVar.aqT == 4 || vVar.aqT == 5) {
                        this.aqq.a(vVar.aqi, vVar.aqT, !vVar.aqU);
                        if (vVar.aqT == 5 && dT(1) == null) {
                            z = true;
                        }
                    }
                    a(vVar.aqV, vVar.id, vVar.aqi);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.aqw) {
                t tVar = new t(getContext());
                if (this.aqA > 0 && tVar.aqi != null && (tVar.aqi instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) tVar.aqi).setBackgroundColorId(this.aqA);
                }
                if (this.aqx > 0) {
                    tVar.aqQ = this.aqx;
                }
                b(tVar);
                tVar.aqi.setToolId(tVar.id);
                tVar.aqi.setEditorTools(this);
                a(tVar.aqV, tVar.id, tVar.aqi);
                this.aqr.a(tVar.aqi);
                if (this.aqy) {
                    linkedList.add(this.aqw, tVar);
                } else {
                    linkedList.add(0, tVar);
                }
            }
            int i = this.aqw + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                v vVar2 = (v) it.next();
                if (i2 < i) {
                    this.aqq.a(a(vVar2, 1));
                } else {
                    this.aqr.a(a(vVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.aqq.a(0, a);
            }
            this.aqq.AM();
            this.aqr.AM();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aqq.setLayoutParams(layoutParams);
            this.aqr.setLayoutParams(layoutParams);
            this.aqr.hide();
            removeAllViews();
            addView(this.aqq);
            addView(this.aqr);
            invalidate();
        }
    }

    public v dT(int i) {
        for (v vVar : this.aqs) {
            if (vVar.id == i) {
                return vVar;
            }
        }
        return null;
    }

    public List<v> getAllTools() {
        return this.aqs;
    }

    public p dR(int i) {
        p dR = this.aqq.dR(i);
        if (dR == null) {
            return this.aqr.dR(i);
        }
        return dR;
    }

    public void AR() {
        this.aqq.e(this.aqD);
    }

    private p a(v vVar, int i) {
        p a = o.a(getContext(), vVar, i);
        if (a instanceof View) {
            ((View) a).setOnClickListener(this.aqD);
        }
        return a;
    }

    public void ov() {
        for (v vVar : this.aqs) {
            if (vVar != null && (vVar.aqi instanceof View) && ((View) vVar.aqi).getVisibility() == 0 && !vVar.aqU) {
                vVar.aqi.ov();
            }
        }
        if (this.aqB) {
            this.aqB = false;
            zr();
        }
        if (!AO()) {
            com.baidu.adp.lib.g.h.hf().postDelayed(this.aqE, 200L);
        }
        setVisibility(0);
    }

    public void hide() {
        this.aqr.hide();
        setVisibility(8);
        AQ();
    }

    public void zr() {
        this.aqr.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aqq.setBarLauncherEnabled(z);
    }

    public boolean AO() {
        return this.aqr.AO();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aqx = i;
    }

    public void setBarLauncherType(int i) {
        this.aqq.setBarLauncherType(i);
    }

    public void setBarLinePostion(int i) {
        this.aqq.setLinePosition(i);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aqy = z;
    }

    public void setBackgroundColorId(int i) {
        this.aqz = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aqA = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
