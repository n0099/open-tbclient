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
    private g bqa;
    private h bqb;
    private List<r> bqc;
    private SparseArray<b> bqd;
    private SparseArray<HashSet<b>> bqe;
    private SparseArray<HashSet<Integer>> bqf;
    private int bqg;
    private int bqh;
    private boolean bqi;
    private int bqj;
    private int bqk;
    private boolean bql;
    private LinkedList<l> bqm;
    private boolean bqn;
    private boolean bqo;
    private View.OnClickListener bqp;
    private Runnable bqq;
    private List<Integer> bqr;

    public void KK() {
        r hN = hN(3);
        if (hN != null && (hN.bpR instanceof View)) {
            View view = (View) hN.bpR;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.bqg = 1;
        this.bqh = 0;
        this.bqi = false;
        this.bqj = d.C0108d.common_color_10255;
        this.bqk = 0;
        this.bql = true;
        this.bqn = false;
        this.bqo = false;
        this.bqp = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.bf(view);
            }
        };
        this.bqq = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.KK();
            }
        };
        this.bqr = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.bqn = z;
    }

    public boolean KL() {
        return this.bqn;
    }

    public boolean KM() {
        return this.bqo;
    }

    public void setIsFromPb(boolean z) {
        this.bqo = z;
    }

    private void init(Context context) {
        this.bqc = new LinkedList();
        this.bqd = new SparseArray<>();
        this.bqe = new SparseArray<>();
        this.bqf = new SparseArray<>();
        this.bqa = new g(context, this);
        this.bqb = new h(context, this);
        this.bqm = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.bqe.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.bqe.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.bqd.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.bqf.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.bqf.put(i3, hashSet2);
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
        r hN;
        if (aVar != null) {
            if (aVar.code == 2) {
                l hL = this.bqa.hL(aVar.id);
                if (hL != null) {
                    z = false;
                } else {
                    hL = this.bqb.hL(aVar.id);
                    z = true;
                }
                if (hL == null) {
                    Iterator<l> it = this.bqm.iterator();
                    while (it.hasNext()) {
                        lVar = it.next();
                        if (lVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                lVar = hL;
                if (lVar != null) {
                    lVar.a(aVar);
                    if (z && (hN = hN(2)) != null && hN.bpR != null) {
                        hN.bpR.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.bqa.a((r) null);
                IP();
            } else if (aVar.id > 0) {
                b bVar = this.bqd.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.bqa.hJ(aVar.id);
                    }
                    r hN2 = hN(aVar.id);
                    if (hN2 != null && hN2.bqH == 5) {
                        IP();
                        KN();
                    } else {
                        this.bqb.hJ(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.bqf.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.bqd.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.bqe.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void KN() {
        boolean z;
        r hN;
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bqq);
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
        if (!z && (hN = hN(3)) != null && (hN.bpR instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) hN.bpR);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.bqc.add(rVar);
        }
    }

    private void clear() {
        this.bqa.clear();
        this.bqb.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.bqg = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.bqa.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.bqb.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.g(this, this.bqj, i);
        this.bqa.onChangeSkinType(i);
        this.bqb.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.bqr;
    }

    public void K(List<Integer> list) {
        this.bqr.clear();
        this.bqr.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void KG() {
        o oVar;
        if (this.bqc != null && this.bqc.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.bqc) {
                if (rVar.bqE > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.bpR != null) {
                    rVar.bpR.setToolId(rVar.id);
                    rVar.bpR.setEditorTools(this);
                    if (rVar.bqH == 6) {
                        this.bqb.a(rVar.bpR);
                    } else if (rVar.bqH == 1 || rVar.bqH == 2 || rVar.bqH == 3 || rVar.bqH == 4 || rVar.bqH == 5) {
                        this.bqa.a(rVar.bpR, rVar.bqH, !rVar.bqI);
                        if (rVar.bqH == 5 && hN(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.bqJ, rVar.id, rVar.bpR);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.bqG - rVar3.bqG;
                }
            });
            if (linkedList.size() > this.bqg) {
                if (this.bqo) {
                    oVar = new o(getContext(), true);
                } else {
                    oVar = new o(getContext());
                }
                if (this.bqk > 0 && oVar.bpR != null && (oVar.bpR instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.bpR).setBackgroundColorId(this.bqk);
                }
                if (this.bqh > 0) {
                    oVar.bqE = this.bqh;
                }
                b(oVar);
                oVar.bpR.setToolId(oVar.id);
                oVar.bpR.setEditorTools(this);
                a(oVar.bqJ, oVar.id, oVar.bpR);
                this.bqb.a(oVar.bpR);
                if (this.bqi) {
                    linkedList.add(this.bqg, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.bqg + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.bqa.a(a(rVar2, 1));
                } else {
                    this.bqb.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.bqa.a(0, a);
            }
            this.bqa.KG();
            this.bqb.KG();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.bqa.setLayoutParams(layoutParams);
            this.bqb.setLayoutParams(layoutParams);
            this.bqb.hide();
            if (this.bqo) {
                this.bqa.setPadding(0, 0, 0, 0);
            }
            IP();
            removeAllViews();
            addView(this.bqa);
            addView(this.bqb);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.bqa != null) {
                this.bqa.a(0, a);
                this.bqa.removeAllViews();
                this.bqa.KG();
            }
            invalidate();
        }
    }

    public r hN(int i) {
        for (r rVar : this.bqc) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.bqc;
    }

    public l hL(int i) {
        l hL = this.bqa.hL(i);
        if (hL == null) {
            return this.bqb.hL(i);
        }
        return hL;
    }

    public void KO() {
        this.bqa.d(this.bqp);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.bqp);
        }
        return a;
    }

    public void ce(boolean z) {
        for (r rVar : this.bqc) {
            if (rVar != null && (rVar.bpR instanceof View) && ((View) rVar.bpR).getVisibility() == 0 && !rVar.bqI) {
                rVar.bpR.th();
            }
        }
        if (this.bql) {
            this.bql = false;
            IP();
        }
        if (!KI() && z) {
            com.baidu.adp.lib.g.e.nr().postDelayed(this.bqq, 200L);
        }
        setVisibility(0);
    }

    public void th() {
        ce(true);
    }

    public void hide() {
        IP();
        setVisibility(8);
        KN();
    }

    public void IP() {
        this.bqb.hide();
        this.bqa.a((r) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.bqa.setBarLauncherEnabled(z);
    }

    public void g(boolean z, int i) {
        this.bqa.g(z, i);
    }

    public boolean KI() {
        return this.bqb.KI();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.bqh = i;
    }

    public void setBarLauncherType(int i) {
        this.bqa.setBarLauncherType(i);
    }

    public void cc(boolean z) {
        this.bqa.cc(z);
    }

    public void cd(boolean z) {
        this.bqa.cd(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.bqi = z;
    }

    public void setBackgroundColorId(int i) {
        this.bqj = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.bqk = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bf(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r hN = hN(toolId);
            if (hN.tv()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.bqa.a(hN);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    th();
                    b(new a(1, 3, null));
                } else if (hN.bpR == null) {
                    if (hN.bqJ != null && hN.bqJ.length > 0) {
                        b(new a(hN.bqJ[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void KP() {
        this.bqa.a((r) null);
    }
}
