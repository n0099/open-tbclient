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
    private View.OnClickListener aCA;
    private Runnable aCB;
    private List<Integer> aCC;
    private g aCm;
    private h aCn;
    private List<r> aCo;
    private SparseArray<b> aCp;
    private SparseArray<HashSet<b>> aCq;
    private SparseArray<HashSet<Integer>> aCr;
    private int aCs;
    private int aCt;
    private boolean aCu;
    private int aCv;
    private int aCw;
    private boolean aCx;
    private LinkedList<l> aCy;
    private boolean aCz;

    public void Df() {
        r eE = eE(3);
        if (eE != null && (eE.aCd instanceof View)) {
            View view = (View) eE.aCd;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aCs = 1;
        this.aCt = 0;
        this.aCu = false;
        this.aCv = d.e.common_color_10255;
        this.aCw = 0;
        this.aCx = true;
        this.aCz = false;
        this.aCA = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.F(view);
            }
        };
        this.aCB = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Df();
            }
        };
        this.aCC = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aCz = z;
    }

    public boolean Dg() {
        return this.aCz;
    }

    private void init(Context context) {
        this.aCo = new LinkedList();
        this.aCp = new SparseArray<>();
        this.aCq = new SparseArray<>();
        this.aCr = new SparseArray<>();
        this.aCm = new g(context, this);
        this.aCn = new h(context, this);
        this.aCy = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aCq.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aCq.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aCp.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aCr.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aCr.put(i3, hashSet2);
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
                l eC = this.aCm.eC(aVar.id);
                if (eC != null) {
                    z = false;
                } else {
                    eC = this.aCn.eC(aVar.id);
                    z = true;
                }
                if (eC == null) {
                    Iterator<l> it = this.aCy.iterator();
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
                    if (z && (eE = eE(2)) != null && eE.aCd != null) {
                        eE.aCd.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aCm.a((r) null);
                this.aCn.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aCp.get(aVar.id);
                if (bVar != null) {
                    this.aCm.eA(aVar.id);
                    r eE2 = eE(aVar.id);
                    if (eE2 != null && eE2.aCR == 5) {
                        this.aCn.hide();
                        Dh();
                    } else {
                        this.aCn.eA(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aCr.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aCp.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aCq.get(aVar.code);
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
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.aCB);
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
        if (!z && (eE = eE(3)) != null && (eE.aCd instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) eE.aCd);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aCo.add(rVar);
        }
    }

    private void clear() {
        this.aCm.clear();
        this.aCn.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aCs = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aCm.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aCn.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ai.e(this, this.aCv, i);
        this.aCm.onChangeSkinType(i);
        this.aCn.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aCC;
    }

    public void A(List<Integer> list) {
        this.aCC.clear();
        this.aCC.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Db() {
        if (this.aCo != null && this.aCo.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aCo) {
                if (rVar.aCO > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aCd != null) {
                    rVar.aCd.setToolId(rVar.id);
                    rVar.aCd.setEditorTools(this);
                    if (rVar.aCR == 6) {
                        this.aCn.a(rVar.aCd);
                    } else if (rVar.aCR == 1 || rVar.aCR == 2 || rVar.aCR == 3 || rVar.aCR == 4 || rVar.aCR == 5) {
                        this.aCm.a(rVar.aCd, rVar.aCR, !rVar.aCS);
                        if (rVar.aCR == 5 && eE(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aCT, rVar.id, rVar.aCd);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aCQ - rVar3.aCQ;
                }
            });
            if (linkedList.size() > this.aCs) {
                o oVar = new o(getContext());
                if (this.aCw > 0 && oVar.aCd != null && (oVar.aCd instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aCd).setBackgroundColorId(this.aCw);
                }
                if (this.aCt > 0) {
                    oVar.aCO = this.aCt;
                }
                b(oVar);
                oVar.aCd.setToolId(oVar.id);
                oVar.aCd.setEditorTools(this);
                a(oVar.aCT, oVar.id, oVar.aCd);
                this.aCn.a(oVar.aCd);
                if (this.aCu) {
                    linkedList.add(this.aCs, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aCs + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aCm.a(a(rVar2, 1));
                } else {
                    this.aCn.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aCm.a(0, a);
            }
            this.aCm.Db();
            this.aCn.Db();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aCm.setLayoutParams(layoutParams);
            this.aCn.setLayoutParams(layoutParams);
            this.aCn.hide();
            removeAllViews();
            addView(this.aCm);
            addView(this.aCn);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aCm != null) {
                this.aCm.a(0, a);
                this.aCm.removeAllViews();
                this.aCm.Db();
            }
            invalidate();
        }
    }

    public r eE(int i) {
        for (r rVar : this.aCo) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aCo;
    }

    public l eC(int i) {
        l eC = this.aCm.eC(i);
        if (eC == null) {
            return this.aCn.eC(i);
        }
        return eC;
    }

    public void Di() {
        this.aCm.h(this.aCA);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aCA);
        }
        return a;
    }

    public void bG(boolean z) {
        for (r rVar : this.aCo) {
            if (rVar != null && (rVar.aCd instanceof View) && ((View) rVar.aCd).getVisibility() == 0 && !rVar.aCS) {
                rVar.aCd.lT();
            }
        }
        if (this.aCx) {
            this.aCx = false;
            Bu();
        }
        if (!Dd() && z) {
            com.baidu.adp.lib.g.e.ga().postDelayed(this.aCB, 200L);
        }
        setVisibility(0);
    }

    public void lT() {
        bG(true);
    }

    public void Dj() {
        for (r rVar : this.aCo) {
            if (rVar != null && (rVar.aCd instanceof View) && ((View) rVar.aCd).getVisibility() == 0 && !rVar.aCS) {
                rVar.aCd.lT();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aCn.hide();
        setVisibility(8);
        Dh();
    }

    public void Bu() {
        this.aCn.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aCm.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.aCm.c(z, i);
    }

    public boolean Dd() {
        return this.aCn.Dd();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aCt = i;
    }

    public void setBarLauncherType(int i) {
        this.aCm.setBarLauncherType(i);
    }

    public void bE(boolean z) {
        this.aCm.bE(z);
    }

    public void bF(boolean z) {
        this.aCm.bF(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aCu = z;
    }

    public void setBackgroundColorId(int i) {
        this.aCv = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aCw = i;
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
                this.aCm.a(eE);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lT();
                    b(new a(1, 3, null));
                } else if (eE.aCd == null) {
                    if (eE.aCT != null && eE.aCT.length > 0) {
                        b(new a(eE.aCT[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
