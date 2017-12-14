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
    private g aCc;
    private h aCd;
    private List<r> aCe;
    private SparseArray<b> aCf;
    private SparseArray<HashSet<b>> aCg;
    private SparseArray<HashSet<Integer>> aCh;
    private int aCi;
    private int aCj;
    private boolean aCk;
    private int aCl;
    private int aCm;
    private boolean aCn;
    private LinkedList<l> aCo;
    private boolean aCp;
    private boolean aCq;
    private View.OnClickListener aCr;
    private Runnable aCs;
    private List<Integer> aCt;

    public void Dj() {
        r eP = eP(3);
        if (eP != null && (eP.aBT instanceof View)) {
            View view = (View) eP.aBT;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aCi = 1;
        this.aCj = 0;
        this.aCk = false;
        this.aCl = d.C0096d.common_color_10255;
        this.aCm = 0;
        this.aCn = true;
        this.aCp = false;
        this.aCq = false;
        this.aCr = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.M(view);
            }
        };
        this.aCs = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Dj();
            }
        };
        this.aCt = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aCp = z;
    }

    public boolean Dk() {
        return this.aCp;
    }

    public boolean Dl() {
        return this.aCq;
    }

    public void setIsFromPb(boolean z) {
        this.aCq = z;
    }

    private void init(Context context) {
        this.aCe = new LinkedList();
        this.aCf = new SparseArray<>();
        this.aCg = new SparseArray<>();
        this.aCh = new SparseArray<>();
        this.aCc = new g(context, this);
        this.aCd = new h(context, this);
        this.aCo = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aCg.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aCg.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aCf.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aCh.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aCh.put(i3, hashSet2);
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
                l eN = this.aCc.eN(aVar.id);
                if (eN != null) {
                    z = false;
                } else {
                    eN = this.aCd.eN(aVar.id);
                    z = true;
                }
                if (eN == null) {
                    Iterator<l> it = this.aCo.iterator();
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
                    if (z && (eP = eP(2)) != null && eP.aBT != null) {
                        eP.aBT.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aCc.a((r) null);
                Bn();
            } else if (aVar.id > 0) {
                b bVar = this.aCf.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aCc.eL(aVar.id);
                    }
                    r eP2 = eP(aVar.id);
                    if (eP2 != null && eP2.aCJ == 5) {
                        Bn();
                        Dm();
                    } else {
                        this.aCd.eL(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aCh.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aCf.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aCg.get(aVar.code);
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
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aCs);
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
        if (!z && (eP = eP(3)) != null && (eP.aBT instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) eP.aBT);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aCe.add(rVar);
        }
    }

    private void clear() {
        this.aCc.clear();
        this.aCd.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aCi = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aCc.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aCd.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.e(this, this.aCl, i);
        this.aCc.onChangeSkinType(i);
        this.aCd.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aCt;
    }

    public void B(List<Integer> list) {
        this.aCt.clear();
        this.aCt.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Df() {
        o oVar;
        if (this.aCe != null && this.aCe.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aCe) {
                if (rVar.aCG > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aBT != null) {
                    rVar.aBT.setToolId(rVar.id);
                    rVar.aBT.setEditorTools(this);
                    if (rVar.aCJ == 6) {
                        this.aCd.a(rVar.aBT);
                    } else if (rVar.aCJ == 1 || rVar.aCJ == 2 || rVar.aCJ == 3 || rVar.aCJ == 4 || rVar.aCJ == 5) {
                        this.aCc.a(rVar.aBT, rVar.aCJ, !rVar.aCK);
                        if (rVar.aCJ == 5 && eP(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aCL, rVar.id, rVar.aBT);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aCI - rVar3.aCI;
                }
            });
            if (linkedList.size() > this.aCi) {
                if (this.aCq) {
                    oVar = new o(getContext(), true);
                } else {
                    oVar = new o(getContext());
                }
                if (this.aCm > 0 && oVar.aBT != null && (oVar.aBT instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aBT).setBackgroundColorId(this.aCm);
                }
                if (this.aCj > 0) {
                    oVar.aCG = this.aCj;
                }
                b(oVar);
                oVar.aBT.setToolId(oVar.id);
                oVar.aBT.setEditorTools(this);
                a(oVar.aCL, oVar.id, oVar.aBT);
                this.aCd.a(oVar.aBT);
                if (this.aCk) {
                    linkedList.add(this.aCi, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aCi + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aCc.a(a(rVar2, 1));
                } else {
                    this.aCd.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aCc.a(0, a);
            }
            this.aCc.Df();
            this.aCd.Df();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aCc.setLayoutParams(layoutParams);
            this.aCd.setLayoutParams(layoutParams);
            this.aCd.hide();
            if (this.aCq) {
                this.aCc.setPadding(0, 0, 0, 0);
            }
            Bn();
            removeAllViews();
            addView(this.aCc);
            addView(this.aCd);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aCc != null) {
                this.aCc.a(0, a);
                this.aCc.removeAllViews();
                this.aCc.Df();
            }
            invalidate();
        }
    }

    public r eP(int i) {
        for (r rVar : this.aCe) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aCe;
    }

    public l eN(int i) {
        l eN = this.aCc.eN(i);
        if (eN == null) {
            return this.aCd.eN(i);
        }
        return eN;
    }

    public void Dn() {
        this.aCc.d(this.aCr);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aCr);
        }
        return a;
    }

    public void bA(boolean z) {
        for (r rVar : this.aCe) {
            if (rVar != null && (rVar.aBT instanceof View) && ((View) rVar.aBT).getVisibility() == 0 && !rVar.aCK) {
                rVar.aBT.lE();
            }
        }
        if (this.aCn) {
            this.aCn = false;
            Bn();
        }
        if (!Dh() && z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.aCs, 200L);
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
        this.aCd.hide();
        this.aCc.a((r) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aCc.setBarLauncherEnabled(z);
    }

    public void d(boolean z, int i) {
        this.aCc.d(z, i);
    }

    public boolean Dh() {
        return this.aCd.Dh();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aCj = i;
    }

    public void setBarLauncherType(int i) {
        this.aCc.setBarLauncherType(i);
    }

    public void by(boolean z) {
        this.aCc.by(z);
    }

    public void bz(boolean z) {
        this.aCc.bz(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aCk = z;
    }

    public void setBackgroundColorId(int i) {
        this.aCl = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aCm = i;
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
                this.aCc.a(eP);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lE();
                    b(new a(1, 3, null));
                } else if (eP.aBT == null) {
                    if (eP.aCL != null && eP.aCL.length > 0) {
                        b(new a(eP.aCL[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Do() {
        this.aCc.a((r) null);
    }
}
