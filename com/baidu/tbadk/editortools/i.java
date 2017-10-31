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
    private LinkedList<l> aBA;
    private boolean aBB;
    private View.OnClickListener aBC;
    private Runnable aBD;
    private List<Integer> aBE;
    private g aBo;
    private h aBp;
    private List<r> aBq;
    private SparseArray<b> aBr;
    private SparseArray<HashSet<b>> aBs;
    private SparseArray<HashSet<Integer>> aBt;
    private int aBu;
    private int aBv;
    private boolean aBw;
    private int aBx;
    private int aBy;
    private boolean aBz;

    public void CN() {
        r eP = eP(3);
        if (eP != null && (eP.aBf instanceof View)) {
            View view = (View) eP.aBf;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.aBu = 1;
        this.aBv = 0;
        this.aBw = false;
        this.aBx = d.C0080d.common_color_10255;
        this.aBy = 0;
        this.aBz = true;
        this.aBB = false;
        this.aBC = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.L(view);
            }
        };
        this.aBD = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.CN();
            }
        };
        this.aBE = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aBB = z;
    }

    public boolean CO() {
        return this.aBB;
    }

    private void init(Context context) {
        this.aBq = new LinkedList();
        this.aBr = new SparseArray<>();
        this.aBs = new SparseArray<>();
        this.aBt = new SparseArray<>();
        this.aBo = new g(context, this);
        this.aBp = new h(context, this);
        this.aBA = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aBs.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aBs.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aBr.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aBt.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aBt.put(i3, hashSet2);
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
                l eN = this.aBo.eN(aVar.id);
                if (eN != null) {
                    z = false;
                } else {
                    eN = this.aBp.eN(aVar.id);
                    z = true;
                }
                if (eN == null) {
                    Iterator<l> it = this.aBA.iterator();
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
                    if (z && (eP = eP(2)) != null && eP.aBf != null) {
                        eP.aBf.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aBo.a((r) null);
                this.aBp.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aBr.get(aVar.id);
                if (bVar != null) {
                    this.aBo.eL(aVar.id);
                    r eP2 = eP(aVar.id);
                    if (eP2 != null && eP2.aBT == 5) {
                        this.aBp.hide();
                        CP();
                    } else {
                        this.aBp.eL(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aBt.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aBr.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aBs.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void CP() {
        boolean z;
        r eP;
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aBD);
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
        if (!z && (eP = eP(3)) != null && (eP.aBf instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) eP.aBf);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.aBq.add(rVar);
        }
    }

    private void clear() {
        this.aBo.clear();
        this.aBp.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aBu = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aBo.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aBp.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.e(this, this.aBx, i);
        this.aBo.onChangeSkinType(i);
        this.aBp.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aBE;
    }

    public void A(List<Integer> list) {
        this.aBE.clear();
        this.aBE.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CJ() {
        if (this.aBq != null && this.aBq.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.aBq) {
                if (rVar.aBQ > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.aBf != null) {
                    rVar.aBf.setToolId(rVar.id);
                    rVar.aBf.setEditorTools(this);
                    if (rVar.aBT == 6) {
                        this.aBp.a(rVar.aBf);
                    } else if (rVar.aBT == 1 || rVar.aBT == 2 || rVar.aBT == 3 || rVar.aBT == 4 || rVar.aBT == 5) {
                        this.aBo.a(rVar.aBf, rVar.aBT, !rVar.aBU);
                        if (rVar.aBT == 5 && eP(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.aBV, rVar.id, rVar.aBf);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.aBS - rVar3.aBS;
                }
            });
            if (linkedList.size() > this.aBu) {
                o oVar = new o(getContext());
                if (this.aBy > 0 && oVar.aBf != null && (oVar.aBf instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.aBf).setBackgroundColorId(this.aBy);
                }
                if (this.aBv > 0) {
                    oVar.aBQ = this.aBv;
                }
                b(oVar);
                oVar.aBf.setToolId(oVar.id);
                oVar.aBf.setEditorTools(this);
                a(oVar.aBV, oVar.id, oVar.aBf);
                this.aBp.a(oVar.aBf);
                if (this.aBw) {
                    linkedList.add(this.aBu, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.aBu + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.aBo.a(a(rVar2, 1));
                } else {
                    this.aBp.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.aBo.a(0, a);
            }
            new ViewGroup.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(d.e.ds1));
            this.aBo.CJ();
            this.aBp.CJ();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aBo.setLayoutParams(layoutParams);
            this.aBp.setLayoutParams(layoutParams);
            this.aBp.hide();
            removeAllViews();
            addView(this.aBo);
            addView(this.aBp);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.aBo != null) {
                this.aBo.a(0, a);
                this.aBo.removeAllViews();
                this.aBo.CJ();
            }
            invalidate();
        }
    }

    public r eP(int i) {
        for (r rVar : this.aBq) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.aBq;
    }

    public l eN(int i) {
        l eN = this.aBo.eN(i);
        if (eN == null) {
            return this.aBp.eN(i);
        }
        return eN;
    }

    public void CQ() {
        this.aBo.d(this.aBC);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aBC);
        }
        return a;
    }

    public void by(boolean z) {
        for (r rVar : this.aBq) {
            if (rVar != null && (rVar.aBf instanceof View) && ((View) rVar.aBf).getVisibility() == 0 && !rVar.aBU) {
                rVar.aBf.lG();
            }
        }
        if (this.aBz) {
            this.aBz = false;
            AQ();
        }
        if (!CL() && z) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.aBD, 200L);
        }
        setVisibility(0);
    }

    public void lG() {
        by(true);
    }

    public void CR() {
        for (r rVar : this.aBq) {
            if (rVar != null && (rVar.aBf instanceof View) && ((View) rVar.aBf).getVisibility() == 0 && !rVar.aBU) {
                rVar.aBf.lG();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aBp.hide();
        setVisibility(8);
        CP();
    }

    public void AQ() {
        this.aBp.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aBo.setBarLauncherEnabled(z);
    }

    public void d(boolean z, int i) {
        this.aBo.d(z, i);
    }

    public boolean CL() {
        return this.aBp.CL();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aBv = i;
    }

    public void setBarLauncherType(int i) {
        this.aBo.setBarLauncherType(i);
    }

    public void bw(boolean z) {
        this.aBo.bw(z);
    }

    public void bx(boolean z) {
        this.aBo.bx(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aBw = z;
    }

    public void setBackgroundColorId(int i) {
        this.aBx = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aBy = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void L(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r eP = eP(toolId);
            if (eP.lP()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.aBo.a(eP);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    lG();
                    b(new a(1, 3, null));
                } else if (eP.aBf == null) {
                    if (eP.aBV != null && eP.aBV.length > 0) {
                        b(new a(eP.aBV[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
