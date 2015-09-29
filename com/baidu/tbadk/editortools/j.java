package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private g aoQ;
    private h aoR;
    private List<v> aoS;
    private SparseArray<b> aoT;
    private SparseArray<HashSet<b>> aoU;
    private SparseArray<HashSet<Integer>> aoV;
    private int aoW;
    private int aoX;
    private boolean aoY;
    private int aoZ;
    private int apa;
    private boolean apb;
    private LinkedList<p> apc;
    private View.OnClickListener apd;
    private Runnable ape;

    public void AC() {
        v dU = dU(3);
        if (dU != null && (dU.aoI instanceof View)) {
            View view = (View) dU.aoI;
            view.requestFocus();
            com.baidu.adp.lib.util.k.d(getContext(), view);
        }
    }

    public j(Context context) {
        super(context);
        this.aoW = 1;
        this.aoX = 0;
        this.aoY = false;
        this.aoZ = i.c.editor_background;
        this.apa = 0;
        this.apb = true;
        this.apd = new k(this);
        this.ape = new l(this);
        init(context);
    }

    private void init(Context context) {
        this.aoS = new LinkedList();
        this.aoT = new SparseArray<>();
        this.aoU = new SparseArray<>();
        this.aoV = new SparseArray<>();
        this.aoQ = new g(context, this);
        this.aoR = new h(context, this);
        this.apc = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aoU.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aoU.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aoT.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aoV.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aoV.put(i3, hashSet2);
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
                p dS = this.aoQ.dS(aVar.id);
                if (dS != null) {
                    z = false;
                } else {
                    dS = this.aoR.dS(aVar.id);
                    z = true;
                }
                if (dS == null) {
                    Iterator<p> it = this.apc.iterator();
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
                    if (z && (dU = dU(2)) != null && dU.aoI != null) {
                        dU.aoI.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aoQ.a((v) null);
                this.aoR.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aoT.get(aVar.id);
                if (bVar != null) {
                    this.aoQ.dQ(aVar.id);
                    v dU2 = dU(aVar.id);
                    if (dU2 != null && dU2.apu == 5) {
                        this.aoR.hide();
                        AD();
                    } else {
                        this.aoR.dQ(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aoV.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aoT.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aoU.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    private void AD() {
        boolean z;
        v dU;
        com.baidu.adp.lib.g.h.hg().removeCallbacks(this.ape);
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
        if (!z && (dU = dU(3)) != null && (dU.aoI instanceof View)) {
            com.baidu.adp.lib.util.k.c(getContext(), (View) dU.aoI);
        }
    }

    public void b(v vVar) {
        if (vVar != null) {
            this.aoS.add(vVar);
        }
    }

    private void clear() {
        this.aoQ.clear();
        this.aoR.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aoW = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aoQ.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aoR.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.d(this, this.aoZ, i);
        this.aoQ.onChangeSkinType(i);
        this.aoR.onChangeSkinType(i);
    }

    public void Ay() {
        if (this.aoS != null && this.aoS.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (v vVar : this.aoS) {
                if (vVar.apr > 0) {
                    linkedList.add(vVar);
                }
                if (vVar.aoI != null) {
                    vVar.aoI.setToolId(vVar.id);
                    vVar.aoI.setEditorTools(this);
                    if (vVar.apu == 6) {
                        this.aoR.a(vVar.aoI);
                    } else if (vVar.apu == 1 || vVar.apu == 2 || vVar.apu == 3 || vVar.apu == 4 || vVar.apu == 5) {
                        this.aoQ.a(vVar.aoI, vVar.apu, !vVar.apv);
                        if (vVar.apu == 5 && dU(1) == null) {
                            z = true;
                        }
                    }
                    a(vVar.apw, vVar.id, vVar.aoI);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.aoW) {
                t tVar = new t(getContext());
                if (this.apa > 0 && tVar.aoI != null && (tVar.aoI instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) tVar.aoI).setBackgroundColorId(this.apa);
                }
                if (this.aoX > 0) {
                    tVar.apr = this.aoX;
                }
                b(tVar);
                tVar.aoI.setToolId(tVar.id);
                tVar.aoI.setEditorTools(this);
                a(tVar.apw, tVar.id, tVar.aoI);
                this.aoR.a(tVar.aoI);
                if (this.aoY) {
                    linkedList.add(this.aoW, tVar);
                } else {
                    linkedList.add(0, tVar);
                }
            }
            int i = this.aoW + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                v vVar2 = (v) it.next();
                if (i2 < i) {
                    this.aoQ.a(a(vVar2, 1));
                } else {
                    this.aoR.a(a(vVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.aoQ.a(0, a);
            }
            this.aoQ.Ay();
            this.aoR.Ay();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aoQ.setLayoutParams(layoutParams);
            this.aoR.setLayoutParams(layoutParams);
            this.aoR.hide();
            removeAllViews();
            addView(this.aoQ);
            addView(this.aoR);
            invalidate();
        }
    }

    public v dU(int i) {
        for (v vVar : this.aoS) {
            if (vVar.id == i) {
                return vVar;
            }
        }
        return null;
    }

    public List<v> getAllTools() {
        return this.aoS;
    }

    public p dS(int i) {
        p dS = this.aoQ.dS(i);
        if (dS == null) {
            return this.aoR.dS(i);
        }
        return dS;
    }

    public void AE() {
        this.aoQ.e(this.apd);
    }

    private p a(v vVar, int i) {
        p a = o.a(getContext(), vVar, i);
        if (a instanceof View) {
            ((View) a).setOnClickListener(this.apd);
        }
        return a;
    }

    public void bf(boolean z) {
        for (v vVar : this.aoS) {
            if (vVar != null && (vVar.aoI instanceof View) && ((View) vVar.aoI).getVisibility() == 0 && !vVar.apv) {
                vVar.aoI.ow();
            }
        }
        if (this.apb) {
            this.apb = false;
            za();
        }
        if (!AA() && z) {
            com.baidu.adp.lib.g.h.hg().postDelayed(this.ape, 200L);
        }
        setVisibility(0);
    }

    public void ow() {
        bf(true);
    }

    public void hide() {
        this.aoR.hide();
        setVisibility(8);
        AD();
    }

    public void za() {
        this.aoR.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aoQ.setBarLauncherEnabled(z);
    }

    public boolean AA() {
        return this.aoR.AA();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aoX = i;
    }

    public void setBarLauncherType(int i) {
        this.aoQ.setBarLauncherType(i);
    }

    public void setBarLinePostion(int i) {
        this.aoQ.setLinePosition(i);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aoY = z;
    }

    public void setBackgroundColorId(int i) {
        this.aoZ = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.apa = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
