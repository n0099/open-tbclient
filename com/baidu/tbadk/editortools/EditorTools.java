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
    public EditorBar csc;
    private EditorDesk csd;
    private View cse;
    private List<k> csf;
    private SparseArray<b> csg;
    private SparseArray<HashSet<b>> csh;
    private SparseArray<HashSet<Integer>> csi;
    private int csj;
    private int csk;
    private boolean csl;
    private int csm;
    private int csn;
    private boolean cso;
    private LinkedList<g> csp;
    private boolean csq;
    private boolean csr;
    private View.OnClickListener css;
    private Runnable cst;
    private List<Integer> csu;

    public void asd() {
        k kp = kp(3);
        if (kp != null && (kp.crT instanceof View)) {
            View view = (View) kp.crT;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.csj = 1;
        this.csk = 0;
        this.csl = false;
        this.csm = R.color.common_color_10255;
        this.csn = 0;
        this.cso = true;
        this.csq = false;
        this.csr = false;
        this.css = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bd(view);
            }
        };
        this.cst = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.asd();
            }
        };
        this.csu = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.csq = z;
    }

    public boolean ase() {
        return this.csq;
    }

    public boolean asf() {
        return this.csr;
    }

    public void setIsFromPb(boolean z) {
        this.csr = z;
    }

    private void init(Context context) {
        this.csf = new LinkedList();
        this.csg = new SparseArray<>();
        this.csh = new SparseArray<>();
        this.csi = new SparseArray<>();
        this.csc = new EditorBar(context, this);
        this.csd = new EditorDesk(context, this);
        this.csp = new LinkedList<>();
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
                HashSet<b> hashSet = this.csh.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.csh.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.csg.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.csi.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.csi.put(i3, hashSet2);
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
        k kp;
        if (aVar != null) {
            if (aVar.code == 2) {
                g km = this.csc.km(aVar.id);
                if (km != null) {
                    z = false;
                } else {
                    km = this.csd.km(aVar.id);
                    z = true;
                }
                if (km == null) {
                    Iterator<g> it = this.csp.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = km;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (kp = kp(2)) != null && kp.crT != null) {
                        kp.crT.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.csc.a((k) null);
                aqu();
            } else if (aVar.id > 0) {
                b bVar = this.csg.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.csc.kk(aVar.id);
                    }
                    k kp2 = kp(aVar.id);
                    if (kp2 != null && kp2.csK == 5) {
                        aqu();
                        asg();
                    } else {
                        this.csd.kk(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.csi.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.csg.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.csh.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void asg() {
        boolean z;
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cst);
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
            k kp = kp(3);
            if (kp != null && (kp.crT instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) kp.crT);
            }
            k kp2 = kp(28);
            if (kp2 != null && (kp2.crT instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) kp2.crT);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.csf.add(kVar);
        }
    }

    private void clear() {
        this.csc.clear();
        this.csd.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.csj = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.csc.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.csd.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.h(this, this.csm, i);
        this.csc.onChangeSkinType(i);
        this.csd.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.csu;
    }

    public void ai(List<Integer> list) {
        this.csu.clear();
        this.csu.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void arZ() {
        i iVar;
        if (this.csf != null && this.csf.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.csf) {
                if (kVar.csH > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.crT != null) {
                    kVar.crT.setToolId(kVar.id);
                    kVar.crT.setEditorTools(this);
                    if (kVar.csK == 6) {
                        this.csd.a(kVar.crT);
                    } else if (kVar.csK == 1 || kVar.csK == 2 || kVar.csK == 3 || kVar.csK == 4 || kVar.csK == 5) {
                        this.csc.a(kVar.crT, kVar.csK, !kVar.csL);
                        if (kVar.csK == 5 && kp(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.csM, kVar.id, kVar.crT);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.csJ - kVar3.csJ;
                }
            });
            if (linkedList.size() > this.csj) {
                if (this.csr) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.csn > 0 && iVar.crT != null && (iVar.crT instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.crT).setBackgroundColorId(this.csn);
                }
                if (this.csk > 0) {
                    iVar.csH = this.csk;
                }
                b(iVar);
                iVar.crT.setToolId(iVar.id);
                iVar.crT.setEditorTools(this);
                a(iVar.csM, iVar.id, iVar.crT);
                this.csd.a(iVar.crT);
                if (this.csl) {
                    linkedList.add(this.csj, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.csj + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.csc.a(a(kVar2, 1));
                } else {
                    this.csd.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.csc.a(0, a);
            }
            this.csc.arZ();
            this.csd.arZ();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.csc.setLayoutParams(layoutParams);
            this.csd.setLayoutParams(layoutParams);
            this.csd.hide();
            if (this.csr) {
                this.csc.setPadding(0, 0, 0, 0);
            }
            aqu();
            removeAllViews();
            if (this.csc.getBarLauncherType() != 4) {
                ash();
            }
            addView(this.csc);
            addView(this.csd);
            invalidate();
        }
    }

    private void ash() {
        if (this.cse == null || this.cse.getParent() != null) {
            this.cse = new View(getContext());
            this.cse.setBackgroundResource(R.drawable.bottom_shadow);
            this.cse.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16)));
        }
        addView(this.cse);
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.csc != null) {
                this.csc.a(0, a);
                this.csc.removeAllViews();
                this.csc.arZ();
            }
            invalidate();
        }
    }

    public k kp(int i) {
        for (k kVar : this.csf) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.csf;
    }

    public g km(int i) {
        g km = this.csc.km(i);
        if (km == null) {
            return this.csd.km(i);
        }
        return km;
    }

    public void asi() {
        this.csc.f(this.css);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.css);
        }
        return a;
    }

    public void fj(boolean z) {
        for (k kVar : this.csf) {
            if (kVar != null && (kVar.crT instanceof View) && ((View) kVar.crT).getVisibility() == 0 && !kVar.csL) {
                kVar.crT.qk();
            }
        }
        if (this.cso) {
            this.cso = false;
            aqu();
        }
        if (!asb() && z) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.cst, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void qk() {
        fj(true);
    }

    public void hide() {
        aqu();
        setVisibility(8);
        asg();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void aqu() {
        this.csd.hide();
        this.csc.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.csc.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.csc.setBarLauncherEnabled(z, i);
    }

    public boolean asb() {
        return this.csd.asb();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.csk = i;
    }

    public void setBarLauncherType(int i) {
        this.csc.setBarLauncherType(i);
    }

    public void fh(boolean z) {
        this.csc.fh(z);
    }

    public void fi(boolean z) {
        this.csc.fi(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.csl = z;
    }

    public void setBackgroundColorId(int i) {
        this.csm = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.csn = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bd(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k kp = kp(toolId);
            if (kp.qz()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.csc.a(kp);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    qk();
                    b(new a(1, 3, null));
                } else if (kp.crT == null) {
                    if (kp.csM != null && kp.csM.length > 0) {
                        b(new a(kp.csM[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void asj() {
        this.csc.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
