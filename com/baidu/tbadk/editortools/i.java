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
import com.baidu.tbadk.core.util.aj;
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
    private g aCf;
    private h aCg;
    private List<r> aCh;
    private SparseArray<b> aCi;
    private SparseArray<HashSet<b>> aCj;
    private SparseArray<HashSet<Integer>> aCk;
    private int aCl;
    private int aCm;
    private boolean aCn;
    private int aCo;
    private int aCp;
    private boolean aCq;
    private LinkedList<l> aCr;
    private boolean aCs;
    private boolean aCt;
    private View.OnClickListener aCu;
    private Runnable aCv;
    private List<Integer> aCw;

    public void Dj() {
        r eP = eP(3);
        if (eP != null && (eP.aBW instanceof View)) {
            View view = (View) eP.aBW;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aCl = 1;
        this.aCm = 0;
        this.aCn = false;
        this.aCo = d.C0095d.common_color_10255;
        this.aCp = 0;
        this.aCq = true;
        this.aCs = false;
        this.aCt = false;
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.M(view);
            }
        };
        this.aCv = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Dj();
            }
        };
        this.aCw = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aCs = z;
    }

    public boolean Dk() {
        return this.aCs;
    }

    public boolean Dl() {
        return this.aCt;
    }

    public void setIsFromPb(boolean z) {
        this.aCt = z;
    }

    private void init(Context context) {
        this.aCh = new LinkedList();
        this.aCi = new SparseArray<>();
        this.aCj = new SparseArray<>();
        this.aCk = new SparseArray<>();
        this.aCf = new g(context, this);
        this.aCg = new h(context, this);
        this.aCr = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aCj.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aCj.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aCi.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aCk.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aCk.put(i3, hashSet2);
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
        r eP;
        if (aVar != null) {
            if (aVar.code == 2) {
                l eN = this.aCf.eN(aVar.id);
                if (eN != null) {
                    z = false;
                } else {
                    eN = this.aCg.eN(aVar.id);
                    z = true;
                }
                if (eN == null) {
                    Iterator<l> it = this.aCr.iterator();
                    while (it.hasNext()) {
                        lVar = it.next();
                        if (lVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                lVar = eN;
                if (lVar != null) {
                    lVar.a(aVar);
                    if (z && (eP = eP(2)) != null && eP.aBW != null) {
                        eP.aBW.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aCf.a((r) null);
                Bn();
            } else if (aVar.id > 0) {
                b bVar = this.aCi.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aCf.eL(aVar.id);
                    }
                    r eP2 = eP(aVar.id);
                    if (eP2 != null && eP2.aCM == 5) {
                        Bn();
                        Dm();
                    } else {
                        this.aCg.eL(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aCk.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aCi.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aCj.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Dm() {
        boolean z;
        r eP;
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aCv);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.l.a(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && (eP = eP(3)) != null && (eP.aBW instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) eP.aBW);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aCh.add(rVar);
        }
    }

    private void clear() {
        this.aCf.clear();
        this.aCg.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aCl = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aCf.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aCg.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.e(this, this.aCo, i);
        this.aCf.onChangeSkinType(i);
        this.aCg.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aCw;
    }

    public void B(List<Integer> list) {
        this.aCw.clear();
        this.aCw.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Df() {
        o oVar;
        if (this.aCh != null && this.aCh.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aCh) {
                if (rVar.aCJ > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aBW != null) {
                    rVar.aBW.setToolId(rVar.id);
                    rVar.aBW.setEditorTools(this);
                    if (rVar.aCM == 6) {
                        this.aCg.a(rVar.aBW);
                    } else if (rVar.aCM == 1 || rVar.aCM == 2 || rVar.aCM == 3 || rVar.aCM == 4 || rVar.aCM == 5) {
                        this.aCf.a(rVar.aBW, rVar.aCM, !rVar.aCN);
                        if (rVar.aCM == 5 && eP(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aCO, rVar.id, rVar.aBW);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aCL - rVar3.aCL;
                }
            });
            if (linkedList.size() > this.aCl) {
                if (this.aCt) {
                    oVar = new o(getContext(), true);
                } else {
                    oVar = new o(getContext());
                }
                if (this.aCp > 0 && oVar.aBW != null && (oVar.aBW instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aBW).setBackgroundColorId(this.aCp);
                }
                if (this.aCm > 0) {
                    oVar.aCJ = this.aCm;
                }
                b(oVar);
                oVar.aBW.setToolId(oVar.id);
                oVar.aBW.setEditorTools(this);
                a(oVar.aCO, oVar.id, oVar.aBW);
                this.aCg.a(oVar.aBW);
                if (this.aCn) {
                    linkedList.add(this.aCl, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aCl + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aCf.a(a(rVar2, 1));
                } else {
                    this.aCg.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aCf.a(0, a);
            }
            this.aCf.Df();
            this.aCg.Df();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aCf.setLayoutParams(layoutParams);
            this.aCg.setLayoutParams(layoutParams);
            this.aCg.hide();
            if (this.aCt) {
                this.aCf.setPadding(0, 0, 0, 0);
            }
            Bn();
            removeAllViews();
            addView(this.aCf);
            addView(this.aCg);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aCf != null) {
                this.aCf.a(0, a);
                this.aCf.removeAllViews();
                this.aCf.Df();
            }
            invalidate();
        }
    }

    public r eP(int i) {
        for (r rVar : this.aCh) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aCh;
    }

    public l eN(int i) {
        l eN = this.aCf.eN(i);
        if (eN == null) {
            return this.aCg.eN(i);
        }
        return eN;
    }

    public void Dn() {
        this.aCf.d(this.aCu);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aCu);
        }
        return a;
    }

    public void bA(boolean z) {
        for (r rVar : this.aCh) {
            if (rVar != null && (rVar.aBW instanceof View) && ((View) rVar.aBW).getVisibility() == 0 && !rVar.aCN) {
                rVar.aBW.lE();
            }
        }
        if (this.aCq) {
            this.aCq = false;
            Bn();
        }
        if (!Dh() && z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.aCv, 200L);
        }
        setVisibility(0);
    }

    public void lE() {
        bA(true);
    }

    public void hide() {
        Bn();
        setVisibility(8);
        Dm();
    }

    public void Bn() {
        this.aCg.hide();
        this.aCf.a((r) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aCf.setBarLauncherEnabled(z);
    }

    public void d(boolean z, int i) {
        this.aCf.d(z, i);
    }

    public boolean Dh() {
        return this.aCg.Dh();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aCm = i;
    }

    public void setBarLauncherType(int i) {
        this.aCf.setBarLauncherType(i);
    }

    public void by(boolean z) {
        this.aCf.by(z);
    }

    public void bz(boolean z) {
        this.aCf.bz(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aCn = z;
    }

    public void setBackgroundColorId(int i) {
        this.aCo = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aCp = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void M(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r eP = eP(toolId);
            if (eP.lS()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.aCf.a(eP);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lE();
                    b(new a(1, 3, null));
                } else if (eP.aBW == null) {
                    if (eP.aCO != null && eP.aCO.length > 0) {
                        b(new a(eP.aCO[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Do() {
        this.aCf.a((r) null);
    }
}
