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
    private boolean bsA;
    private int bsB;
    private int bsC;
    private boolean bsD;
    private LinkedList<l> bsE;
    private boolean bsF;
    private boolean bsG;
    private View.OnClickListener bsH;
    private Runnable bsI;
    private List<Integer> bsJ;
    private g bss;
    private h bst;
    private List<r> bsu;
    private SparseArray<b> bsv;
    private SparseArray<HashSet<b>> bsw;
    private SparseArray<HashSet<Integer>> bsx;
    private int bsy;
    private int bsz;

    public void Lg() {
        r hI = hI(3);
        if (hI != null && (hI.bsj instanceof View)) {
            View view = (View) hI.bsj;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.bsy = 1;
        this.bsz = 0;
        this.bsA = false;
        this.bsB = d.C0141d.common_color_10255;
        this.bsC = 0;
        this.bsD = true;
        this.bsF = false;
        this.bsG = false;
        this.bsH = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.bh(view);
            }
        };
        this.bsI = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Lg();
            }
        };
        this.bsJ = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.bsF = z;
    }

    public boolean Lh() {
        return this.bsF;
    }

    public boolean Li() {
        return this.bsG;
    }

    public void setIsFromPb(boolean z) {
        this.bsG = z;
    }

    private void init(Context context) {
        this.bsu = new LinkedList();
        this.bsv = new SparseArray<>();
        this.bsw = new SparseArray<>();
        this.bsx = new SparseArray<>();
        this.bss = new g(context, this);
        this.bst = new h(context, this);
        this.bsE = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.bsw.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.bsw.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.bsv.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.bsx.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.bsx.put(i3, hashSet2);
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
                l hG = this.bss.hG(aVar.id);
                if (hG != null) {
                    z = false;
                } else {
                    hG = this.bst.hG(aVar.id);
                    z = true;
                }
                if (hG == null) {
                    Iterator<l> it = this.bsE.iterator();
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
                    if (z && (hI = hI(2)) != null && hI.bsj != null) {
                        hI.bsj.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.bss.a((r) null);
                Jl();
            } else if (aVar.id > 0) {
                b bVar = this.bsv.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.bss.hE(aVar.id);
                    }
                    r hI2 = hI(aVar.id);
                    if (hI2 != null && hI2.bsZ == 5) {
                        Jl();
                        Lj();
                    } else {
                        this.bst.hE(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.bsx.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.bsv.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.bsw.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Lj() {
        boolean z;
        r hI;
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bsI);
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
        if (!z && (hI = hI(3)) != null && (hI.bsj instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) hI.bsj);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.bsu.add(rVar);
        }
    }

    private void clear() {
        this.bss.clear();
        this.bst.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.bsy = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.bss.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.bst.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.g(this, this.bsB, i);
        this.bss.onChangeSkinType(i);
        this.bst.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.bsJ;
    }

    public void K(List<Integer> list) {
        this.bsJ.clear();
        this.bsJ.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void Lc() {
        o oVar;
        if (this.bsu != null && this.bsu.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.bsu) {
                if (rVar.bsW > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.bsj != null) {
                    rVar.bsj.setToolId(rVar.id);
                    rVar.bsj.setEditorTools(this);
                    if (rVar.bsZ == 6) {
                        this.bst.a(rVar.bsj);
                    } else if (rVar.bsZ == 1 || rVar.bsZ == 2 || rVar.bsZ == 3 || rVar.bsZ == 4 || rVar.bsZ == 5) {
                        this.bss.a(rVar.bsj, rVar.bsZ, !rVar.bta);
                        if (rVar.bsZ == 5 && hI(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.btb, rVar.id, rVar.bsj);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.bsY - rVar3.bsY;
                }
            });
            if (linkedList.size() > this.bsy) {
                if (this.bsG) {
                    oVar = new o(getContext(), true);
                } else {
                    oVar = new o(getContext());
                }
                if (this.bsC > 0 && oVar.bsj != null && (oVar.bsj instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.bsj).setBackgroundColorId(this.bsC);
                }
                if (this.bsz > 0) {
                    oVar.bsW = this.bsz;
                }
                b(oVar);
                oVar.bsj.setToolId(oVar.id);
                oVar.bsj.setEditorTools(this);
                a(oVar.btb, oVar.id, oVar.bsj);
                this.bst.a(oVar.bsj);
                if (this.bsA) {
                    linkedList.add(this.bsy, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.bsy + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.bss.a(a(rVar2, 1));
                } else {
                    this.bst.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.bss.a(0, a);
            }
            this.bss.Lc();
            this.bst.Lc();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.bss.setLayoutParams(layoutParams);
            this.bst.setLayoutParams(layoutParams);
            this.bst.hide();
            if (this.bsG) {
                this.bss.setPadding(0, 0, 0, 0);
            }
            Jl();
            removeAllViews();
            addView(this.bss);
            addView(this.bst);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.bss != null) {
                this.bss.a(0, a);
                this.bss.removeAllViews();
                this.bss.Lc();
            }
            invalidate();
        }
    }

    public r hI(int i) {
        for (r rVar : this.bsu) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.bsu;
    }

    public l hG(int i) {
        l hG = this.bss.hG(i);
        if (hG == null) {
            return this.bst.hG(i);
        }
        return hG;
    }

    public void Lk() {
        this.bss.d(this.bsH);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.bsH);
        }
        return a;
    }

    public void ch(boolean z) {
        for (r rVar : this.bsu) {
            if (rVar != null && (rVar.bsj instanceof View) && ((View) rVar.bsj).getVisibility() == 0 && !rVar.bta) {
                rVar.bsj.th();
            }
        }
        if (this.bsD) {
            this.bsD = false;
            Jl();
        }
        if (!Le() && z) {
            com.baidu.adp.lib.g.e.ns().postDelayed(this.bsI, 200L);
        }
        setVisibility(0);
    }

    public void th() {
        ch(true);
    }

    public void hide() {
        Jl();
        setVisibility(8);
        Lj();
    }

    public void Jl() {
        this.bst.hide();
        this.bss.a((r) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.bss.setBarLauncherEnabled(z);
    }

    public void g(boolean z, int i) {
        this.bss.g(z, i);
    }

    public boolean Le() {
        return this.bst.Le();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.bsz = i;
    }

    public void setBarLauncherType(int i) {
        this.bss.setBarLauncherType(i);
    }

    public void cf(boolean z) {
        this.bss.cf(z);
    }

    public void cg(boolean z) {
        this.bss.cg(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.bsA = z;
    }

    public void setBackgroundColorId(int i) {
        this.bsB = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.bsC = i;
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
                this.bss.a(hI);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    th();
                    b(new a(1, 3, null));
                } else if (hI.bsj == null) {
                    if (hI.btb != null && hI.btb.length > 0) {
                        b(new a(hI.btb[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Ll() {
        this.bss.a((r) null);
    }
}
