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
    private boolean aCA;
    private View.OnClickListener aCB;
    private Runnable aCC;
    private List<Integer> aCD;
    private g aCn;
    private h aCo;
    private List<r> aCp;
    private SparseArray<b> aCq;
    private SparseArray<HashSet<b>> aCr;
    private SparseArray<HashSet<Integer>> aCs;
    private int aCt;
    private int aCu;
    private boolean aCv;
    private int aCw;
    private int aCx;
    private boolean aCy;
    private LinkedList<l> aCz;

    public void Df() {
        r eE = eE(3);
        if (eE != null && (eE.aCe instanceof View)) {
            View view = (View) eE.aCe;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aCt = 1;
        this.aCu = 0;
        this.aCv = false;
        this.aCw = d.e.common_color_10255;
        this.aCx = 0;
        this.aCy = true;
        this.aCA = false;
        this.aCB = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.F(view);
            }
        };
        this.aCC = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Df();
            }
        };
        this.aCD = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aCA = z;
    }

    public boolean Dg() {
        return this.aCA;
    }

    private void init(Context context) {
        this.aCp = new LinkedList();
        this.aCq = new SparseArray<>();
        this.aCr = new SparseArray<>();
        this.aCs = new SparseArray<>();
        this.aCn = new g(context, this);
        this.aCo = new h(context, this);
        this.aCz = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aCr.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aCr.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aCq.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aCs.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aCs.put(i3, hashSet2);
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
                l eC = this.aCn.eC(aVar.id);
                if (eC != null) {
                    z = false;
                } else {
                    eC = this.aCo.eC(aVar.id);
                    z = true;
                }
                if (eC == null) {
                    Iterator<l> it = this.aCz.iterator();
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
                    if (z && (eE = eE(2)) != null && eE.aCe != null) {
                        eE.aCe.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aCn.a((r) null);
                this.aCo.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aCq.get(aVar.id);
                if (bVar != null) {
                    this.aCn.eA(aVar.id);
                    r eE2 = eE(aVar.id);
                    if (eE2 != null && eE2.aCS == 5) {
                        this.aCo.hide();
                        Dh();
                    } else {
                        this.aCo.eA(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aCs.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aCq.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aCr.get(aVar.code);
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
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.aCC);
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
        if (!z && (eE = eE(3)) != null && (eE.aCe instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) eE.aCe);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aCp.add(rVar);
        }
    }

    private void clear() {
        this.aCn.clear();
        this.aCo.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aCt = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aCn.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aCo.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ai.e(this, this.aCw, i);
        this.aCn.onChangeSkinType(i);
        this.aCo.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aCD;
    }

    public void A(List<Integer> list) {
        this.aCD.clear();
        this.aCD.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Db() {
        if (this.aCp != null && this.aCp.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aCp) {
                if (rVar.aCP > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aCe != null) {
                    rVar.aCe.setToolId(rVar.id);
                    rVar.aCe.setEditorTools(this);
                    if (rVar.aCS == 6) {
                        this.aCo.a(rVar.aCe);
                    } else if (rVar.aCS == 1 || rVar.aCS == 2 || rVar.aCS == 3 || rVar.aCS == 4 || rVar.aCS == 5) {
                        this.aCn.a(rVar.aCe, rVar.aCS, !rVar.aCT);
                        if (rVar.aCS == 5 && eE(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aCU, rVar.id, rVar.aCe);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aCR - rVar3.aCR;
                }
            });
            if (linkedList.size() > this.aCt) {
                o oVar = new o(getContext());
                if (this.aCx > 0 && oVar.aCe != null && (oVar.aCe instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aCe).setBackgroundColorId(this.aCx);
                }
                if (this.aCu > 0) {
                    oVar.aCP = this.aCu;
                }
                b(oVar);
                oVar.aCe.setToolId(oVar.id);
                oVar.aCe.setEditorTools(this);
                a(oVar.aCU, oVar.id, oVar.aCe);
                this.aCo.a(oVar.aCe);
                if (this.aCv) {
                    linkedList.add(this.aCt, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aCt + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aCn.a(a(rVar2, 1));
                } else {
                    this.aCo.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aCn.a(0, a);
            }
            this.aCn.Db();
            this.aCo.Db();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aCn.setLayoutParams(layoutParams);
            this.aCo.setLayoutParams(layoutParams);
            this.aCo.hide();
            removeAllViews();
            addView(this.aCn);
            addView(this.aCo);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aCn != null) {
                this.aCn.a(0, a);
                this.aCn.removeAllViews();
                this.aCn.Db();
            }
            invalidate();
        }
    }

    public r eE(int i) {
        for (r rVar : this.aCp) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aCp;
    }

    public l eC(int i) {
        l eC = this.aCn.eC(i);
        if (eC == null) {
            return this.aCo.eC(i);
        }
        return eC;
    }

    public void Di() {
        this.aCn.d(this.aCB);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aCB);
        }
        return a;
    }

    public void bG(boolean z) {
        for (r rVar : this.aCp) {
            if (rVar != null && (rVar.aCe instanceof View) && ((View) rVar.aCe).getVisibility() == 0 && !rVar.aCT) {
                rVar.aCe.lS();
            }
        }
        if (this.aCy) {
            this.aCy = false;
            Bu();
        }
        if (!Dd() && z) {
            com.baidu.adp.lib.g.e.ga().postDelayed(this.aCC, 200L);
        }
        setVisibility(0);
    }

    public void lS() {
        bG(true);
    }

    public void Dj() {
        for (r rVar : this.aCp) {
            if (rVar != null && (rVar.aCe instanceof View) && ((View) rVar.aCe).getVisibility() == 0 && !rVar.aCT) {
                rVar.aCe.lS();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aCo.hide();
        setVisibility(8);
        Dh();
    }

    public void Bu() {
        this.aCo.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aCn.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.aCn.c(z, i);
    }

    public boolean Dd() {
        return this.aCo.Dd();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aCu = i;
    }

    public void setBarLauncherType(int i) {
        this.aCn.setBarLauncherType(i);
    }

    public void bE(boolean z) {
        this.aCn.bE(z);
    }

    public void bF(boolean z) {
        this.aCn.bF(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aCv = z;
    }

    public void setBackgroundColorId(int i) {
        this.aCw = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aCx = i;
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
            if (eE.mb()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.aCn.a(eE);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lS();
                    b(new a(1, 3, null));
                } else if (eE.aCe == null) {
                    if (eE.aCU != null && eE.aCU.length > 0) {
                        b(new a(eE.aCU[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
