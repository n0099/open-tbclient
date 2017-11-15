package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
    private SparseArray<HashSet<b>> aBA;
    private SparseArray<HashSet<Integer>> aBB;
    private int aBC;
    private int aBD;
    private boolean aBE;
    private int aBF;
    private int aBG;
    private boolean aBH;
    private LinkedList<l> aBI;
    private boolean aBJ;
    private View.OnClickListener aBK;
    private Runnable aBL;
    private List<Integer> aBM;
    private g aBw;
    private h aBx;
    private List<r> aBy;
    private SparseArray<b> aBz;

    public void CZ() {
        r eO = eO(3);
        if (eO != null && (eO.aBn instanceof View)) {
            View view = (View) eO.aBn;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aBC = 1;
        this.aBD = 0;
        this.aBE = false;
        this.aBF = d.C0080d.common_color_10255;
        this.aBG = 0;
        this.aBH = true;
        this.aBJ = false;
        this.aBK = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.L(view);
            }
        };
        this.aBL = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.CZ();
            }
        };
        this.aBM = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aBJ = z;
    }

    public boolean Da() {
        return this.aBJ;
    }

    private void init(Context context) {
        this.aBy = new LinkedList();
        this.aBz = new SparseArray<>();
        this.aBA = new SparseArray<>();
        this.aBB = new SparseArray<>();
        this.aBw = new g(context, this);
        this.aBx = new h(context, this);
        this.aBI = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aBA.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aBA.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aBz.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aBB.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aBB.put(i3, hashSet2);
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
        r eO;
        if (aVar != null) {
            if (aVar.code == 2) {
                l eM = this.aBw.eM(aVar.id);
                if (eM != null) {
                    z = false;
                } else {
                    eM = this.aBx.eM(aVar.id);
                    z = true;
                }
                if (eM == null) {
                    Iterator<l> it = this.aBI.iterator();
                    while (it.hasNext()) {
                        lVar = it.next();
                        if (lVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                lVar = eM;
                if (lVar != null) {
                    lVar.a(aVar);
                    if (z && (eO = eO(2)) != null && eO.aBn != null) {
                        eO.aBn.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aBw.a((r) null);
                this.aBx.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aBz.get(aVar.id);
                if (bVar != null) {
                    this.aBw.eK(aVar.id);
                    r eO2 = eO(aVar.id);
                    if (eO2 != null && eO2.aCb == 5) {
                        this.aBx.hide();
                        Db();
                    } else {
                        this.aBx.eK(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aBB.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aBz.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aBA.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Db() {
        boolean z;
        r eO;
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aBL);
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
        if (!z && (eO = eO(3)) != null && (eO.aBn instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) eO.aBn);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aBy.add(rVar);
        }
    }

    private void clear() {
        this.aBw.clear();
        this.aBx.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aBC = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aBw.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aBx.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.e(this, this.aBF, i);
        this.aBw.onChangeSkinType(i);
        this.aBx.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aBM;
    }

    public void A(List<Integer> list) {
        this.aBM.clear();
        this.aBM.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CV() {
        if (this.aBy != null && this.aBy.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aBy) {
                if (rVar.aBY > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aBn != null) {
                    rVar.aBn.setToolId(rVar.id);
                    rVar.aBn.setEditorTools(this);
                    if (rVar.aCb == 6) {
                        this.aBx.a(rVar.aBn);
                    } else if (rVar.aCb == 1 || rVar.aCb == 2 || rVar.aCb == 3 || rVar.aCb == 4 || rVar.aCb == 5) {
                        this.aBw.a(rVar.aBn, rVar.aCb, !rVar.aCc);
                        if (rVar.aCb == 5 && eO(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aCd, rVar.id, rVar.aBn);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aCa - rVar3.aCa;
                }
            });
            if (linkedList.size() > this.aBC) {
                o oVar = new o(getContext());
                if (this.aBG > 0 && oVar.aBn != null && (oVar.aBn instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aBn).setBackgroundColorId(this.aBG);
                }
                if (this.aBD > 0) {
                    oVar.aBY = this.aBD;
                }
                b(oVar);
                oVar.aBn.setToolId(oVar.id);
                oVar.aBn.setEditorTools(this);
                a(oVar.aCd, oVar.id, oVar.aBn);
                this.aBx.a(oVar.aBn);
                if (this.aBE) {
                    linkedList.add(this.aBC, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aBC + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aBw.a(a(rVar2, 1));
                } else {
                    this.aBx.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aBw.a(0, a);
            }
            new ViewGroup.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.e.ds1));
            this.aBw.CV();
            this.aBx.CV();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aBw.setLayoutParams(layoutParams);
            this.aBx.setLayoutParams(layoutParams);
            this.aBx.hide();
            removeAllViews();
            addView(this.aBw);
            addView(this.aBx);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aBw != null) {
                this.aBw.a(0, a);
                this.aBw.removeAllViews();
                this.aBw.CV();
            }
            invalidate();
        }
    }

    public r eO(int i) {
        for (r rVar : this.aBy) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aBy;
    }

    public l eM(int i) {
        l eM = this.aBw.eM(i);
        if (eM == null) {
            return this.aBx.eM(i);
        }
        return eM;
    }

    public void Dc() {
        this.aBw.d(this.aBK);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aBK);
        }
        return a;
    }

    public void bz(boolean z) {
        for (r rVar : this.aBy) {
            if (rVar != null && (rVar.aBn instanceof View) && ((View) rVar.aBn).getVisibility() == 0 && !rVar.aCc) {
                rVar.aBn.lG();
            }
        }
        if (this.aBH) {
            this.aBH = false;
            Bc();
        }
        if (!CX() && z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.aBL, 200L);
        }
        setVisibility(0);
    }

    public void lG() {
        bz(true);
    }

    public void Dd() {
        for (r rVar : this.aBy) {
            if (rVar != null && (rVar.aBn instanceof View) && ((View) rVar.aBn).getVisibility() == 0 && !rVar.aCc) {
                rVar.aBn.lG();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aBx.hide();
        setVisibility(8);
        Db();
    }

    public void Bc() {
        this.aBx.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aBw.setBarLauncherEnabled(z);
    }

    public void d(boolean z, int i) {
        this.aBw.d(z, i);
    }

    public boolean CX() {
        return this.aBx.CX();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aBD = i;
    }

    public void setBarLauncherType(int i) {
        this.aBw.setBarLauncherType(i);
    }

    public void bx(boolean z) {
        this.aBw.bx(z);
    }

    public void by(boolean z) {
        this.aBw.by(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aBE = z;
    }

    public void setBackgroundColorId(int i) {
        this.aBF = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aBG = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void L(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r eO = eO(toolId);
            if (eO.lP()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.aBw.a(eO);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lG();
                    b(new a(1, 3, null));
                } else if (eO.aBn == null) {
                    if (eO.aCd != null && eO.aCd.length > 0) {
                        b(new a(eO.aCd[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
