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
    private List<Integer> bqA;
    private g bqj;
    private h bqk;
    private List<r> bql;
    private SparseArray<b> bqm;
    private SparseArray<HashSet<b>> bqn;
    private SparseArray<HashSet<Integer>> bqo;
    private int bqp;
    private int bqq;
    private boolean bqr;
    private int bqs;
    private int bqt;
    private boolean bqu;
    private LinkedList<l> bqv;
    private boolean bqw;
    private boolean bqx;
    private View.OnClickListener bqy;
    private Runnable bqz;

    public void Kz() {
        r hJ = hJ(3);
        if (hJ != null && (hJ.bqa instanceof View)) {
            View view = (View) hJ.bqa;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.bqp = 1;
        this.bqq = 0;
        this.bqr = false;
        this.bqs = d.C0107d.common_color_10255;
        this.bqt = 0;
        this.bqu = true;
        this.bqw = false;
        this.bqx = false;
        this.bqy = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.bh(view);
            }
        };
        this.bqz = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Kz();
            }
        };
        this.bqA = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.bqw = z;
    }

    public boolean KA() {
        return this.bqw;
    }

    public boolean KB() {
        return this.bqx;
    }

    public void setIsFromPb(boolean z) {
        this.bqx = z;
    }

    private void init(Context context) {
        this.bql = new LinkedList();
        this.bqm = new SparseArray<>();
        this.bqn = new SparseArray<>();
        this.bqo = new SparseArray<>();
        this.bqj = new g(context, this);
        this.bqk = new h(context, this);
        this.bqv = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.bqn.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.bqn.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.bqm.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.bqo.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.bqo.put(i3, hashSet2);
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
                l hH = this.bqj.hH(aVar.id);
                if (hH != null) {
                    z = false;
                } else {
                    hH = this.bqk.hH(aVar.id);
                    z = true;
                }
                if (hH == null) {
                    Iterator<l> it = this.bqv.iterator();
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
                    if (z && (hJ = hJ(2)) != null && hJ.bqa != null) {
                        hJ.bqa.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.bqj.a((r) null);
                IE();
            } else if (aVar.id > 0) {
                b bVar = this.bqm.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.bqj.hF(aVar.id);
                    }
                    r hJ2 = hJ(aVar.id);
                    if (hJ2 != null && hJ2.bqQ == 5) {
                        IE();
                        KC();
                    } else {
                        this.bqk.hF(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.bqo.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.bqm.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.bqn.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void KC() {
        boolean z;
        r hJ;
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bqz);
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
        if (!z && (hJ = hJ(3)) != null && (hJ.bqa instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) hJ.bqa);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.bql.add(rVar);
        }
    }

    private void clear() {
        this.bqj.clear();
        this.bqk.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.bqp = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.bqj.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.bqk.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.g(this, this.bqs, i);
        this.bqj.onChangeSkinType(i);
        this.bqk.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.bqA;
    }

    public void I(List<Integer> list) {
        this.bqA.clear();
        this.bqA.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Kv() {
        o oVar;
        if (this.bql != null && this.bql.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.bql) {
                if (rVar.bqN > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.bqa != null) {
                    rVar.bqa.setToolId(rVar.id);
                    rVar.bqa.setEditorTools(this);
                    if (rVar.bqQ == 6) {
                        this.bqk.a(rVar.bqa);
                    } else if (rVar.bqQ == 1 || rVar.bqQ == 2 || rVar.bqQ == 3 || rVar.bqQ == 4 || rVar.bqQ == 5) {
                        this.bqj.a(rVar.bqa, rVar.bqQ, !rVar.bqR);
                        if (rVar.bqQ == 5 && hJ(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.bqS, rVar.id, rVar.bqa);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.bqP - rVar3.bqP;
                }
            });
            if (linkedList.size() > this.bqp) {
                if (this.bqx) {
                    oVar = new o(getContext(), true);
                } else {
                    oVar = new o(getContext());
                }
                if (this.bqt > 0 && oVar.bqa != null && (oVar.bqa instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.bqa).setBackgroundColorId(this.bqt);
                }
                if (this.bqq > 0) {
                    oVar.bqN = this.bqq;
                }
                b(oVar);
                oVar.bqa.setToolId(oVar.id);
                oVar.bqa.setEditorTools(this);
                a(oVar.bqS, oVar.id, oVar.bqa);
                this.bqk.a(oVar.bqa);
                if (this.bqr) {
                    linkedList.add(this.bqp, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.bqp + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.bqj.a(a(rVar2, 1));
                } else {
                    this.bqk.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.bqj.a(0, a);
            }
            this.bqj.Kv();
            this.bqk.Kv();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.bqj.setLayoutParams(layoutParams);
            this.bqk.setLayoutParams(layoutParams);
            this.bqk.hide();
            if (this.bqx) {
                this.bqj.setPadding(0, 0, 0, 0);
            }
            IE();
            removeAllViews();
            addView(this.bqj);
            addView(this.bqk);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.bqj != null) {
                this.bqj.a(0, a);
                this.bqj.removeAllViews();
                this.bqj.Kv();
            }
            invalidate();
        }
    }

    public r hJ(int i) {
        for (r rVar : this.bql) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.bql;
    }

    public l hH(int i) {
        l hH = this.bqj.hH(i);
        if (hH == null) {
            return this.bqk.hH(i);
        }
        return hH;
    }

    public void KD() {
        this.bqj.d(this.bqy);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.bqy);
        }
        return a;
    }

    public void cc(boolean z) {
        for (r rVar : this.bql) {
            if (rVar != null && (rVar.bqa instanceof View) && ((View) rVar.bqa).getVisibility() == 0 && !rVar.bqR) {
                rVar.bqa.th();
            }
        }
        if (this.bqu) {
            this.bqu = false;
            IE();
        }
        if (!Kx() && z) {
            com.baidu.adp.lib.g.e.nr().postDelayed(this.bqz, 200L);
        }
        setVisibility(0);
    }

    public void th() {
        cc(true);
    }

    public void hide() {
        IE();
        setVisibility(8);
        KC();
    }

    public void IE() {
        this.bqk.hide();
        this.bqj.a((r) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.bqj.setBarLauncherEnabled(z);
    }

    public void g(boolean z, int i) {
        this.bqj.g(z, i);
    }

    public boolean Kx() {
        return this.bqk.Kx();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.bqq = i;
    }

    public void setBarLauncherType(int i) {
        this.bqj.setBarLauncherType(i);
    }

    public void ca(boolean z) {
        this.bqj.ca(z);
    }

    public void cb(boolean z) {
        this.bqj.cb(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.bqr = z;
    }

    public void setBackgroundColorId(int i) {
        this.bqs = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.bqt = i;
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
            if (hJ.tv()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.bqj.a(hJ);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    th();
                    b(new a(1, 3, null));
                } else if (hJ.bqa == null) {
                    if (hJ.bqS != null && hJ.bqS.length > 0) {
                        b(new a(hJ.bqS[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void KE() {
        this.bqj.a((r) null);
    }
}
