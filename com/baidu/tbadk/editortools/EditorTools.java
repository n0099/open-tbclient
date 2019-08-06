package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorTools extends LinearLayout {
    private Runnable csA;
    private List<Integer> csB;
    public EditorBar csj;
    private EditorDesk csk;
    private View csl;
    private List<k> csm;
    private SparseArray<b> csn;
    private SparseArray<HashSet<b>> cso;
    private SparseArray<HashSet<Integer>> csp;
    private int csq;
    private int csr;
    private boolean css;
    private int cst;
    private int csu;
    private boolean csv;
    private LinkedList<g> csw;
    private boolean csx;
    private boolean csy;
    private View.OnClickListener csz;

    public void asf() {
        k kq = kq(3);
        if (kq != null && (kq.csa instanceof View)) {
            View view = (View) kq.csa;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.csq = 1;
        this.csr = 0;
        this.css = false;
        this.cst = R.color.common_color_10255;
        this.csu = 0;
        this.csv = true;
        this.csx = false;
        this.csy = false;
        this.csz = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bd(view);
            }
        };
        this.csA = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.asf();
            }
        };
        this.csB = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.csx = z;
    }

    public boolean asg() {
        return this.csx;
    }

    public boolean ash() {
        return this.csy;
    }

    public void setIsFromPb(boolean z) {
        this.csy = z;
    }

    private void init(Context context) {
        this.csm = new LinkedList();
        this.csn = new SparseArray<>();
        this.cso = new SparseArray<>();
        this.csp = new SparseArray<>();
        this.csj = new EditorBar(context, this);
        this.csk = new EditorDesk(context, this);
        this.csw = new LinkedList<>();
        setOrientation(1);
    }

    public void setActionListener(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    public void setActionListener(int[] iArr, b bVar) {
        a(iArr, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.cso.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.cso.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.csn.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.csp.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.csp.put(i3, hashSet2);
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
        g gVar;
        k kq;
        if (aVar != null) {
            if (aVar.code == 2) {
                g kn = this.csj.kn(aVar.id);
                if (kn != null) {
                    z = false;
                } else {
                    kn = this.csk.kn(aVar.id);
                    z = true;
                }
                if (kn == null) {
                    Iterator<g> it = this.csw.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = kn;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (kq = kq(2)) != null && kq.csa != null) {
                        kq.csa.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.csj.a((k) null);
                aqw();
            } else if (aVar.id > 0) {
                b bVar = this.csn.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.csj.kl(aVar.id);
                    }
                    k kq2 = kq(aVar.id);
                    if (kq2 != null && kq2.csR == 5) {
                        aqw();
                        asi();
                    } else {
                        this.csk.kl(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.csp.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.csn.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.cso.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void asi() {
        boolean z;
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.csA);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.l.b(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z) {
            k kq = kq(3);
            if (kq != null && (kq.csa instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) kq.csa);
            }
            k kq2 = kq(28);
            if (kq2 != null && (kq2.csa instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) kq2.csa);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.csm.add(kVar);
        }
    }

    private void clear() {
        this.csj.clear();
        this.csk.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.csq = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.csj.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.csk.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.h(this, this.cst, i);
        this.csj.onChangeSkinType(i);
        this.csk.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.csB;
    }

    public void ai(List<Integer> list) {
        this.csB.clear();
        this.csB.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void asb() {
        i iVar;
        if (this.csm != null && this.csm.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.csm) {
                if (kVar.csO > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.csa != null) {
                    kVar.csa.setToolId(kVar.id);
                    kVar.csa.setEditorTools(this);
                    if (kVar.csR == 6) {
                        this.csk.a(kVar.csa);
                    } else if (kVar.csR == 1 || kVar.csR == 2 || kVar.csR == 3 || kVar.csR == 4 || kVar.csR == 5) {
                        this.csj.a(kVar.csa, kVar.csR, !kVar.csS);
                        if (kVar.csR == 5 && kq(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.csT, kVar.id, kVar.csa);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.csQ - kVar3.csQ;
                }
            });
            if (linkedList.size() > this.csq) {
                if (this.csy) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.csu > 0 && iVar.csa != null && (iVar.csa instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.csa).setBackgroundColorId(this.csu);
                }
                if (this.csr > 0) {
                    iVar.csO = this.csr;
                }
                b(iVar);
                iVar.csa.setToolId(iVar.id);
                iVar.csa.setEditorTools(this);
                a(iVar.csT, iVar.id, iVar.csa);
                this.csk.a(iVar.csa);
                if (this.css) {
                    linkedList.add(this.csq, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.csq + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.csj.a(a(kVar2, 1));
                } else {
                    this.csk.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.csj.a(0, a);
            }
            this.csj.asb();
            this.csk.asb();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.csj.setLayoutParams(layoutParams);
            this.csk.setLayoutParams(layoutParams);
            this.csk.hide();
            if (this.csy) {
                this.csj.setPadding(0, 0, 0, 0);
            }
            aqw();
            removeAllViews();
            if (this.csj.getBarLauncherType() != 4) {
                asj();
            }
            addView(this.csj);
            addView(this.csk);
            invalidate();
        }
    }

    private void asj() {
        if (this.csl == null || this.csl.getParent() != null) {
            this.csl = new View(getContext());
            this.csl.setBackgroundResource(R.drawable.bottom_shadow);
            this.csl.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16)));
        }
        addView(this.csl);
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.csj != null) {
                this.csj.a(0, a);
                this.csj.removeAllViews();
                this.csj.asb();
            }
            invalidate();
        }
    }

    public k kq(int i) {
        for (k kVar : this.csm) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.csm;
    }

    public g kn(int i) {
        g kn = this.csj.kn(i);
        if (kn == null) {
            return this.csk.kn(i);
        }
        return kn;
    }

    public void ask() {
        this.csj.f(this.csz);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.csz);
        }
        return a;
    }

    public void fj(boolean z) {
        for (k kVar : this.csm) {
            if (kVar != null && (kVar.csa instanceof View) && ((View) kVar.csa).getVisibility() == 0 && !kVar.csS) {
                kVar.csa.qk();
            }
        }
        if (this.csv) {
            this.csv = false;
            aqw();
        }
        if (!asd() && z) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.csA, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void qk() {
        fj(true);
    }

    public void hide() {
        aqw();
        setVisibility(8);
        asi();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void aqw() {
        this.csk.hide();
        this.csj.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.csj.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.csj.setBarLauncherEnabled(z, i);
    }

    public boolean asd() {
        return this.csk.asd();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.csr = i;
    }

    public void setBarLauncherType(int i) {
        this.csj.setBarLauncherType(i);
    }

    public void fh(boolean z) {
        this.csj.fh(z);
    }

    public void fi(boolean z) {
        this.csj.fi(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.css = z;
    }

    public void setBackgroundColorId(int i) {
        this.cst = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.csu = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bd(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k kq = kq(toolId);
            if (kq.qz()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.csj.a(kq);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    qk();
                    b(new a(1, 3, null));
                } else if (kq.csa == null) {
                    if (kq.csT != null && kq.csT.length > 0) {
                        b(new a(kq.csT[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void asl() {
        this.csj.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
