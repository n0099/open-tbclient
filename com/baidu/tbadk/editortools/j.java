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
    private g aoF;
    private h aoG;
    private List<v> aoH;
    private SparseArray<b> aoI;
    private SparseArray<HashSet<b>> aoJ;
    private SparseArray<HashSet<Integer>> aoK;
    private int aoL;
    private int aoM;
    private boolean aoN;
    private int aoO;
    private int aoP;
    private boolean aoQ;
    private LinkedList<p> aoR;
    private View.OnClickListener aoS;
    private Runnable aoT;

    public j(Context context) {
        super(context);
        this.aoL = 1;
        this.aoM = 0;
        this.aoN = false;
        this.aoO = i.c.editor_background;
        this.aoP = 0;
        this.aoQ = true;
        this.aoS = new k(this);
        this.aoT = new l(this);
        init(context);
    }

    private void init(Context context) {
        this.aoH = new LinkedList();
        this.aoI = new SparseArray<>();
        this.aoJ = new SparseArray<>();
        this.aoK = new SparseArray<>();
        this.aoF = new g(context, this);
        this.aoG = new h(context, this);
        this.aoR = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aoJ.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aoJ.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aoI.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aoK.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aoK.put(i3, hashSet2);
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
        v dL;
        if (aVar != null) {
            if (aVar.code == 2) {
                p dJ = this.aoF.dJ(aVar.id);
                if (dJ != null) {
                    z = false;
                } else {
                    dJ = this.aoG.dJ(aVar.id);
                    z = true;
                }
                if (dJ == null) {
                    Iterator<p> it = this.aoR.iterator();
                    while (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                pVar = dJ;
                if (pVar != null) {
                    pVar.a(aVar);
                    if (z && (dL = dL(2)) != null && dL.aox != null) {
                        dL.aox.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aoF.a((v) null);
                this.aoG.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aoI.get(aVar.id);
                if (bVar != null) {
                    this.aoF.dH(aVar.id);
                    v dL2 = dL(aVar.id);
                    if (dL2 != null && dL2.api == 5) {
                        this.aoG.hide();
                        AD();
                    } else {
                        this.aoG.dH(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aoK.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aoI.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aoJ.get(aVar.code);
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
        v dL;
        com.baidu.adp.lib.g.h.hi().removeCallbacks(this.aoT);
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
        if (!z && (dL = dL(3)) != null && (dL.aox instanceof View)) {
            com.baidu.adp.lib.util.k.c(getContext(), (View) dL.aox);
        }
    }

    public void b(v vVar) {
        if (vVar != null) {
            this.aoH.add(vVar);
        }
    }

    private void clear() {
        this.aoF.clear();
        this.aoG.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aoL = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aoF.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aoG.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.d(this, this.aoO, i);
        this.aoF.onChangeSkinType(i);
        this.aoG.onChangeSkinType(i);
    }

    public void Az() {
        if (this.aoH != null && this.aoH.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (v vVar : this.aoH) {
                if (vVar.apf > 0) {
                    linkedList.add(vVar);
                }
                if (vVar.aox != null) {
                    vVar.aox.setToolId(vVar.id);
                    vVar.aox.setEditorTools(this);
                    if (vVar.api == 6) {
                        this.aoG.a(vVar.aox);
                    } else if (vVar.api == 1 || vVar.api == 2 || vVar.api == 3 || vVar.api == 4 || vVar.api == 5) {
                        this.aoF.a(vVar.aox, vVar.api, !vVar.apj);
                        if (vVar.api == 5 && dL(1) == null) {
                            z = true;
                        }
                    }
                    a(vVar.apk, vVar.id, vVar.aox);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.aoL) {
                t tVar = new t(getContext());
                if (this.aoP > 0 && tVar.aox != null && (tVar.aox instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) tVar.aox).setBackgroundColorId(this.aoP);
                }
                if (this.aoM > 0) {
                    tVar.apf = this.aoM;
                }
                b(tVar);
                tVar.aox.setToolId(tVar.id);
                tVar.aox.setEditorTools(this);
                a(tVar.apk, tVar.id, tVar.aox);
                this.aoG.a(tVar.aox);
                if (this.aoN) {
                    linkedList.add(this.aoL, tVar);
                } else {
                    linkedList.add(0, tVar);
                }
            }
            int i = this.aoL + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                v vVar2 = (v) it.next();
                if (i2 < i) {
                    this.aoF.a(a(vVar2, 1));
                } else {
                    this.aoG.a(a(vVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.aoF.a(0, a);
            }
            this.aoF.Az();
            this.aoG.Az();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aoF.setLayoutParams(layoutParams);
            this.aoG.setLayoutParams(layoutParams);
            this.aoG.hide();
            removeAllViews();
            addView(this.aoF);
            addView(this.aoG);
            invalidate();
        }
    }

    public v dL(int i) {
        for (v vVar : this.aoH) {
            if (vVar.id == i) {
                return vVar;
            }
        }
        return null;
    }

    public List<v> getAllTools() {
        return this.aoH;
    }

    public p dJ(int i) {
        p dJ = this.aoF.dJ(i);
        if (dJ == null) {
            return this.aoG.dJ(i);
        }
        return dJ;
    }

    public void AE() {
        this.aoF.e(this.aoS);
    }

    private p a(v vVar, int i) {
        p a = o.a(getContext(), vVar, i);
        if (a instanceof View) {
            ((View) a).setOnClickListener(this.aoS);
        }
        return a;
    }

    public void oy() {
        for (v vVar : this.aoH) {
            if (vVar != null && (vVar.aox instanceof View) && ((View) vVar.aox).getVisibility() == 0 && !vVar.apj) {
                vVar.aox.oy();
            }
        }
        if (this.aoQ) {
            this.aoQ = false;
            zk();
        }
        if (!AB()) {
            com.baidu.adp.lib.g.h.hi().postDelayed(this.aoT, 200L);
        }
        setVisibility(0);
    }

    public void hide() {
        this.aoG.hide();
        setVisibility(8);
        AD();
    }

    public void zk() {
        this.aoG.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aoF.setBarLauncherEnabled(z);
    }

    public boolean AB() {
        return this.aoG.AB();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aoM = i;
    }

    public void setBarLauncherType(int i) {
        this.aoF.setBarLauncherType(i);
    }

    public void setBarLinePostion(int i) {
        this.aoF.setLinePosition(i);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aoN = z;
    }

    public void setBackgroundColorId(int i) {
        this.aoO = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aoP = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
