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
import com.baidu.tbadk.core.util.ai;
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
    private Runnable aCA;
    private List<Integer> aCB;
    private g aCl;
    private h aCm;
    private List<r> aCn;
    private SparseArray<b> aCo;
    private SparseArray<HashSet<b>> aCp;
    private SparseArray<HashSet<Integer>> aCq;
    private int aCr;
    private int aCs;
    private boolean aCt;
    private int aCu;
    private int aCv;
    private boolean aCw;
    private LinkedList<l> aCx;
    private boolean aCy;
    private View.OnClickListener aCz;

    public void Df() {
        r eE = eE(3);
        if (eE != null && (eE.aCc instanceof View)) {
            View view = (View) eE.aCc;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aCr = 1;
        this.aCs = 0;
        this.aCt = false;
        this.aCu = d.e.common_color_10255;
        this.aCv = 0;
        this.aCw = true;
        this.aCy = false;
        this.aCz = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.F(view);
            }
        };
        this.aCA = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Df();
            }
        };
        this.aCB = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aCy = z;
    }

    public boolean Dg() {
        return this.aCy;
    }

    private void init(Context context) {
        this.aCn = new LinkedList();
        this.aCo = new SparseArray<>();
        this.aCp = new SparseArray<>();
        this.aCq = new SparseArray<>();
        this.aCl = new g(context, this);
        this.aCm = new h(context, this);
        this.aCx = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aCp.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aCp.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aCo.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aCq.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aCq.put(i3, hashSet2);
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
        r eE;
        if (aVar != null) {
            if (aVar.code == 2) {
                l eC = this.aCl.eC(aVar.id);
                if (eC != null) {
                    z = false;
                } else {
                    eC = this.aCm.eC(aVar.id);
                    z = true;
                }
                if (eC == null) {
                    Iterator<l> it = this.aCx.iterator();
                    while (it.hasNext()) {
                        lVar = it.next();
                        if (lVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                lVar = eC;
                if (lVar != null) {
                    lVar.a(aVar);
                    if (z && (eE = eE(2)) != null && eE.aCc != null) {
                        eE.aCc.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aCl.a((r) null);
                this.aCm.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aCo.get(aVar.id);
                if (bVar != null) {
                    this.aCl.eA(aVar.id);
                    r eE2 = eE(aVar.id);
                    if (eE2 != null && eE2.aCQ == 5) {
                        this.aCm.hide();
                        Dh();
                    } else {
                        this.aCm.eA(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aCq.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aCo.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aCp.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Dh() {
        boolean z;
        r eE;
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.aCA);
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
        if (!z && (eE = eE(3)) != null && (eE.aCc instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) eE.aCc);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aCn.add(rVar);
        }
    }

    private void clear() {
        this.aCl.clear();
        this.aCm.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aCr = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aCl.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aCm.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ai.e(this, this.aCu, i);
        this.aCl.onChangeSkinType(i);
        this.aCm.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aCB;
    }

    public void A(List<Integer> list) {
        this.aCB.clear();
        this.aCB.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Db() {
        if (this.aCn != null && this.aCn.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aCn) {
                if (rVar.aCN > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aCc != null) {
                    rVar.aCc.setToolId(rVar.id);
                    rVar.aCc.setEditorTools(this);
                    if (rVar.aCQ == 6) {
                        this.aCm.a(rVar.aCc);
                    } else if (rVar.aCQ == 1 || rVar.aCQ == 2 || rVar.aCQ == 3 || rVar.aCQ == 4 || rVar.aCQ == 5) {
                        this.aCl.a(rVar.aCc, rVar.aCQ, !rVar.aCR);
                        if (rVar.aCQ == 5 && eE(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aCS, rVar.id, rVar.aCc);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aCP - rVar3.aCP;
                }
            });
            if (linkedList.size() > this.aCr) {
                o oVar = new o(getContext());
                if (this.aCv > 0 && oVar.aCc != null && (oVar.aCc instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aCc).setBackgroundColorId(this.aCv);
                }
                if (this.aCs > 0) {
                    oVar.aCN = this.aCs;
                }
                b(oVar);
                oVar.aCc.setToolId(oVar.id);
                oVar.aCc.setEditorTools(this);
                a(oVar.aCS, oVar.id, oVar.aCc);
                this.aCm.a(oVar.aCc);
                if (this.aCt) {
                    linkedList.add(this.aCr, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aCr + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aCl.a(a(rVar2, 1));
                } else {
                    this.aCm.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aCl.a(0, a);
            }
            this.aCl.Db();
            this.aCm.Db();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aCl.setLayoutParams(layoutParams);
            this.aCm.setLayoutParams(layoutParams);
            this.aCm.hide();
            removeAllViews();
            addView(this.aCl);
            addView(this.aCm);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aCl != null) {
                this.aCl.a(0, a);
                this.aCl.removeAllViews();
                this.aCl.Db();
            }
            invalidate();
        }
    }

    public r eE(int i) {
        for (r rVar : this.aCn) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aCn;
    }

    public l eC(int i) {
        l eC = this.aCl.eC(i);
        if (eC == null) {
            return this.aCm.eC(i);
        }
        return eC;
    }

    public void Di() {
        this.aCl.h(this.aCz);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aCz);
        }
        return a;
    }

    public void bG(boolean z) {
        for (r rVar : this.aCn) {
            if (rVar != null && (rVar.aCc instanceof View) && ((View) rVar.aCc).getVisibility() == 0 && !rVar.aCR) {
                rVar.aCc.lT();
            }
        }
        if (this.aCw) {
            this.aCw = false;
            Bu();
        }
        if (!Dd() && z) {
            com.baidu.adp.lib.g.e.ga().postDelayed(this.aCA, 200L);
        }
        setVisibility(0);
    }

    public void lT() {
        bG(true);
    }

    public void Dj() {
        for (r rVar : this.aCn) {
            if (rVar != null && (rVar.aCc instanceof View) && ((View) rVar.aCc).getVisibility() == 0 && !rVar.aCR) {
                rVar.aCc.lT();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aCm.hide();
        setVisibility(8);
        Dh();
    }

    public void Bu() {
        this.aCm.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aCl.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.aCl.c(z, i);
    }

    public boolean Dd() {
        return this.aCm.Dd();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aCs = i;
    }

    public void setBarLauncherType(int i) {
        this.aCl.setBarLauncherType(i);
    }

    public void bE(boolean z) {
        this.aCl.bE(z);
    }

    public void bF(boolean z) {
        this.aCl.bF(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aCt = z;
    }

    public void setBackgroundColorId(int i) {
        this.aCu = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aCv = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void F(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r eE = eE(toolId);
            if (eE.mc()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.aCl.a(eE);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lT();
                    b(new a(1, 3, null));
                } else if (eE.aCc == null) {
                    if (eE.aCS != null && eE.aCS.length > 0) {
                        b(new a(eE.aCS[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
