package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
    private SparseArray<HashSet<Integer>> bsA;
    private int bsB;
    private int bsC;
    private boolean bsD;
    private int bsE;
    private int bsF;
    private boolean bsG;
    private LinkedList<l> bsH;
    private boolean bsI;
    private boolean bsJ;
    private View.OnClickListener bsK;
    private Runnable bsL;
    private List<Integer> bsM;
    private g bsv;
    private h bsw;
    private List<r> bsx;
    private SparseArray<b> bsy;
    private SparseArray<HashSet<b>> bsz;

    public void Lh() {
        r hI = hI(3);
        if (hI != null && (hI.bsm instanceof View)) {
            View view = (View) hI.bsm;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.bsB = 1;
        this.bsC = 0;
        this.bsD = false;
        this.bsE = d.C0141d.common_color_10255;
        this.bsF = 0;
        this.bsG = true;
        this.bsI = false;
        this.bsJ = false;
        this.bsK = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.bh(view);
            }
        };
        this.bsL = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Lh();
            }
        };
        this.bsM = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.bsI = z;
    }

    public boolean Li() {
        return this.bsI;
    }

    public boolean Lj() {
        return this.bsJ;
    }

    public void setIsFromPb(boolean z) {
        this.bsJ = z;
    }

    private void init(Context context) {
        this.bsx = new LinkedList();
        this.bsy = new SparseArray<>();
        this.bsz = new SparseArray<>();
        this.bsA = new SparseArray<>();
        this.bsv = new g(context, this);
        this.bsw = new h(context, this);
        this.bsH = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.bsz.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.bsz.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.bsy.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.bsA.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.bsA.put(i3, hashSet2);
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
        r hI;
        if (aVar != null) {
            if (aVar.code == 2) {
                l hG = this.bsv.hG(aVar.id);
                if (hG != null) {
                    z = false;
                } else {
                    hG = this.bsw.hG(aVar.id);
                    z = true;
                }
                if (hG == null) {
                    Iterator<l> it = this.bsH.iterator();
                    while (it.hasNext()) {
                        lVar = it.next();
                        if (lVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                lVar = hG;
                if (lVar != null) {
                    lVar.a(aVar);
                    if (z && (hI = hI(2)) != null && hI.bsm != null) {
                        hI.bsm.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.bsv.a((r) null);
                Jm();
            } else if (aVar.id > 0) {
                b bVar = this.bsy.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.bsv.hE(aVar.id);
                    }
                    r hI2 = hI(aVar.id);
                    if (hI2 != null && hI2.btc == 5) {
                        Jm();
                        Lk();
                    } else {
                        this.bsw.hE(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.bsA.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.bsy.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.bsz.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Lk() {
        boolean z;
        r hI;
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bsL);
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
        if (!z && (hI = hI(3)) != null && (hI.bsm instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) hI.bsm);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.bsx.add(rVar);
        }
    }

    private void clear() {
        this.bsv.clear();
        this.bsw.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.bsB = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.bsv.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.bsw.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.g(this, this.bsE, i);
        this.bsv.onChangeSkinType(i);
        this.bsw.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.bsM;
    }

    public void K(List<Integer> list) {
        this.bsM.clear();
        this.bsM.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void Ld() {
        o oVar;
        if (this.bsx != null && this.bsx.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.bsx) {
                if (rVar.bsZ > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.bsm != null) {
                    rVar.bsm.setToolId(rVar.id);
                    rVar.bsm.setEditorTools(this);
                    if (rVar.btc == 6) {
                        this.bsw.a(rVar.bsm);
                    } else if (rVar.btc == 1 || rVar.btc == 2 || rVar.btc == 3 || rVar.btc == 4 || rVar.btc == 5) {
                        this.bsv.a(rVar.bsm, rVar.btc, !rVar.btd);
                        if (rVar.btc == 5 && hI(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.bte, rVar.id, rVar.bsm);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.btb - rVar3.btb;
                }
            });
            if (linkedList.size() > this.bsB) {
                if (this.bsJ) {
                    oVar = new o(getContext(), true);
                } else {
                    oVar = new o(getContext());
                }
                if (this.bsF > 0 && oVar.bsm != null && (oVar.bsm instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.bsm).setBackgroundColorId(this.bsF);
                }
                if (this.bsC > 0) {
                    oVar.bsZ = this.bsC;
                }
                b(oVar);
                oVar.bsm.setToolId(oVar.id);
                oVar.bsm.setEditorTools(this);
                a(oVar.bte, oVar.id, oVar.bsm);
                this.bsw.a(oVar.bsm);
                if (this.bsD) {
                    linkedList.add(this.bsB, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.bsB + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.bsv.a(a(rVar2, 1));
                } else {
                    this.bsw.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.bsv.a(0, a);
            }
            this.bsv.Ld();
            this.bsw.Ld();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.bsv.setLayoutParams(layoutParams);
            this.bsw.setLayoutParams(layoutParams);
            this.bsw.hide();
            if (this.bsJ) {
                this.bsv.setPadding(0, 0, 0, 0);
            }
            Jm();
            removeAllViews();
            addView(this.bsv);
            addView(this.bsw);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.bsv != null) {
                this.bsv.a(0, a);
                this.bsv.removeAllViews();
                this.bsv.Ld();
            }
            invalidate();
        }
    }

    public r hI(int i) {
        for (r rVar : this.bsx) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.bsx;
    }

    public l hG(int i) {
        l hG = this.bsv.hG(i);
        if (hG == null) {
            return this.bsw.hG(i);
        }
        return hG;
    }

    public void Ll() {
        this.bsv.d(this.bsK);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.bsK);
        }
        return a;
    }

    public void ch(boolean z) {
        for (r rVar : this.bsx) {
            if (rVar != null && (rVar.bsm instanceof View) && ((View) rVar.bsm).getVisibility() == 0 && !rVar.btd) {
                rVar.bsm.th();
            }
        }
        if (this.bsG) {
            this.bsG = false;
            Jm();
        }
        if (!Lf() && z) {
            com.baidu.adp.lib.g.e.ns().postDelayed(this.bsL, 200L);
        }
        setVisibility(0);
    }

    public void th() {
        ch(true);
    }

    public void hide() {
        Jm();
        setVisibility(8);
        Lk();
    }

    public void Jm() {
        this.bsw.hide();
        this.bsv.a((r) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.bsv.setBarLauncherEnabled(z);
    }

    public void g(boolean z, int i) {
        this.bsv.g(z, i);
    }

    public boolean Lf() {
        return this.bsw.Lf();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.bsC = i;
    }

    public void setBarLauncherType(int i) {
        this.bsv.setBarLauncherType(i);
    }

    public void cf(boolean z) {
        this.bsv.cf(z);
    }

    public void cg(boolean z) {
        this.bsv.cg(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.bsD = z;
    }

    public void setBackgroundColorId(int i) {
        this.bsE = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.bsF = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bh(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r hI = hI(toolId);
            if (hI.tv()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.bsv.a(hI);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    th();
                    b(new a(1, 3, null));
                } else if (hI.bsm == null) {
                    if (hI.bte != null && hI.bte.length > 0) {
                        b(new a(hI.bte[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Lm() {
        this.bsv.a((r) null);
    }
}
