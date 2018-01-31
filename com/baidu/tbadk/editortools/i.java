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
    private boolean bqA;
    private int bqB;
    private int bqC;
    private boolean bqD;
    private LinkedList<l> bqE;
    private boolean bqF;
    private boolean bqG;
    private View.OnClickListener bqH;
    private Runnable bqI;
    private List<Integer> bqJ;
    private g bqs;
    private h bqt;
    private List<r> bqu;
    private SparseArray<b> bqv;
    private SparseArray<HashSet<b>> bqw;
    private SparseArray<HashSet<Integer>> bqx;
    private int bqy;
    private int bqz;

    public void KB() {
        r hJ = hJ(3);
        if (hJ != null && (hJ.bqj instanceof View)) {
            View view = (View) hJ.bqj;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.bqy = 1;
        this.bqz = 0;
        this.bqA = false;
        this.bqB = d.C0108d.common_color_10255;
        this.bqC = 0;
        this.bqD = true;
        this.bqF = false;
        this.bqG = false;
        this.bqH = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.bh(view);
            }
        };
        this.bqI = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.KB();
            }
        };
        this.bqJ = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.bqF = z;
    }

    public boolean KC() {
        return this.bqF;
    }

    public boolean KD() {
        return this.bqG;
    }

    public void setIsFromPb(boolean z) {
        this.bqG = z;
    }

    private void init(Context context) {
        this.bqu = new LinkedList();
        this.bqv = new SparseArray<>();
        this.bqw = new SparseArray<>();
        this.bqx = new SparseArray<>();
        this.bqs = new g(context, this);
        this.bqt = new h(context, this);
        this.bqE = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.bqw.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.bqw.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.bqv.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.bqx.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.bqx.put(i3, hashSet2);
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
        r hJ;
        if (aVar != null) {
            if (aVar.code == 2) {
                l hH = this.bqs.hH(aVar.id);
                if (hH != null) {
                    z = false;
                } else {
                    hH = this.bqt.hH(aVar.id);
                    z = true;
                }
                if (hH == null) {
                    Iterator<l> it = this.bqE.iterator();
                    while (it.hasNext()) {
                        lVar = it.next();
                        if (lVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                lVar = hH;
                if (lVar != null) {
                    lVar.a(aVar);
                    if (z && (hJ = hJ(2)) != null && hJ.bqj != null) {
                        hJ.bqj.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.bqs.a((r) null);
                IG();
            } else if (aVar.id > 0) {
                b bVar = this.bqv.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.bqs.hF(aVar.id);
                    }
                    r hJ2 = hJ(aVar.id);
                    if (hJ2 != null && hJ2.bqZ == 5) {
                        IG();
                        KE();
                    } else {
                        this.bqt.hF(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.bqx.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.bqv.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.bqw.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void KE() {
        boolean z;
        r hJ;
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bqI);
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
        if (!z && (hJ = hJ(3)) != null && (hJ.bqj instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) hJ.bqj);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.bqu.add(rVar);
        }
    }

    private void clear() {
        this.bqs.clear();
        this.bqt.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.bqy = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.bqs.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.bqt.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.g(this, this.bqB, i);
        this.bqs.onChangeSkinType(i);
        this.bqt.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.bqJ;
    }

    public void I(List<Integer> list) {
        this.bqJ.clear();
        this.bqJ.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Kx() {
        o oVar;
        if (this.bqu != null && this.bqu.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.bqu) {
                if (rVar.bqW > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.bqj != null) {
                    rVar.bqj.setToolId(rVar.id);
                    rVar.bqj.setEditorTools(this);
                    if (rVar.bqZ == 6) {
                        this.bqt.a(rVar.bqj);
                    } else if (rVar.bqZ == 1 || rVar.bqZ == 2 || rVar.bqZ == 3 || rVar.bqZ == 4 || rVar.bqZ == 5) {
                        this.bqs.a(rVar.bqj, rVar.bqZ, !rVar.bra);
                        if (rVar.bqZ == 5 && hJ(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.brb, rVar.id, rVar.bqj);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.bqY - rVar3.bqY;
                }
            });
            if (linkedList.size() > this.bqy) {
                if (this.bqG) {
                    oVar = new o(getContext(), true);
                } else {
                    oVar = new o(getContext());
                }
                if (this.bqC > 0 && oVar.bqj != null && (oVar.bqj instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.bqj).setBackgroundColorId(this.bqC);
                }
                if (this.bqz > 0) {
                    oVar.bqW = this.bqz;
                }
                b(oVar);
                oVar.bqj.setToolId(oVar.id);
                oVar.bqj.setEditorTools(this);
                a(oVar.brb, oVar.id, oVar.bqj);
                this.bqt.a(oVar.bqj);
                if (this.bqA) {
                    linkedList.add(this.bqy, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.bqy + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.bqs.a(a(rVar2, 1));
                } else {
                    this.bqt.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.bqs.a(0, a);
            }
            this.bqs.Kx();
            this.bqt.Kx();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.bqs.setLayoutParams(layoutParams);
            this.bqt.setLayoutParams(layoutParams);
            this.bqt.hide();
            if (this.bqG) {
                this.bqs.setPadding(0, 0, 0, 0);
            }
            IG();
            removeAllViews();
            addView(this.bqs);
            addView(this.bqt);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.bqs != null) {
                this.bqs.a(0, a);
                this.bqs.removeAllViews();
                this.bqs.Kx();
            }
            invalidate();
        }
    }

    public r hJ(int i) {
        for (r rVar : this.bqu) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.bqu;
    }

    public l hH(int i) {
        l hH = this.bqs.hH(i);
        if (hH == null) {
            return this.bqt.hH(i);
        }
        return hH;
    }

    public void KF() {
        this.bqs.d(this.bqH);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.bqH);
        }
        return a;
    }

    public void cd(boolean z) {
        for (r rVar : this.bqu) {
            if (rVar != null && (rVar.bqj instanceof View) && ((View) rVar.bqj).getVisibility() == 0 && !rVar.bra) {
                rVar.bqj.ti();
            }
        }
        if (this.bqD) {
            this.bqD = false;
            IG();
        }
        if (!Kz() && z) {
            com.baidu.adp.lib.g.e.ns().postDelayed(this.bqI, 200L);
        }
        setVisibility(0);
    }

    public void ti() {
        cd(true);
    }

    public void hide() {
        IG();
        setVisibility(8);
        KE();
    }

    public void IG() {
        this.bqt.hide();
        this.bqs.a((r) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.bqs.setBarLauncherEnabled(z);
    }

    public void g(boolean z, int i) {
        this.bqs.g(z, i);
    }

    public boolean Kz() {
        return this.bqt.Kz();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.bqz = i;
    }

    public void setBarLauncherType(int i) {
        this.bqs.setBarLauncherType(i);
    }

    public void cb(boolean z) {
        this.bqs.cb(z);
    }

    public void cc(boolean z) {
        this.bqs.cc(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.bqA = z;
    }

    public void setBackgroundColorId(int i) {
        this.bqB = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.bqC = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bh(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r hJ = hJ(toolId);
            if (hJ.tw()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.bqs.a(hJ);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    ti();
                    b(new a(1, 3, null));
                } else if (hJ.bqj == null) {
                    if (hJ.brb != null && hJ.brb.length > 0) {
                        b(new a(hJ.brb[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void KG() {
        this.bqs.a((r) null);
    }
}
