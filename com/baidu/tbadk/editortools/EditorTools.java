package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorTools extends LinearLayout {
    private View.OnClickListener aMA;
    private Runnable aMB;
    private List<Integer> aMC;
    public EditorBar aMl;
    private EditorDesk aMm;
    private List<k> aMn;
    private SparseArray<b> aMo;
    private SparseArray<HashSet<b>> aMp;
    private SparseArray<HashSet<Integer>> aMq;
    private int aMr;
    private int aMs;
    private boolean aMt;
    private int aMu;
    private int aMv;
    private boolean aMw;
    private LinkedList<g> aMx;
    private boolean aMy;
    private boolean aMz;

    public void Hy() {
        k eN = eN(3);
        if (eN != null && (eN.aMc instanceof View)) {
            View view = (View) eN.aMc;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aMr = 1;
        this.aMs = 0;
        this.aMt = false;
        this.aMu = f.d.common_color_10255;
        this.aMv = 0;
        this.aMw = true;
        this.aMy = false;
        this.aMz = false;
        this.aMA = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.N(view);
            }
        };
        this.aMB = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.Hy();
            }
        };
        this.aMC = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aMy = z;
    }

    public boolean Hz() {
        return this.aMy;
    }

    public boolean HA() {
        return this.aMz;
    }

    public void setIsFromPb(boolean z) {
        this.aMz = z;
    }

    private void init(Context context) {
        this.aMn = new LinkedList();
        this.aMo = new SparseArray<>();
        this.aMp = new SparseArray<>();
        this.aMq = new SparseArray<>();
        this.aMl = new EditorBar(context, this);
        this.aMm = new EditorDesk(context, this);
        this.aMx = new LinkedList<>();
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
                HashSet<b> hashSet = this.aMp.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aMp.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aMo.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aMq.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aMq.put(i3, hashSet2);
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
        k eN;
        if (aVar != null) {
            if (aVar.code == 2) {
                g eK = this.aMl.eK(aVar.id);
                if (eK != null) {
                    z = false;
                } else {
                    eK = this.aMm.eK(aVar.id);
                    z = true;
                }
                if (eK == null) {
                    Iterator<g> it = this.aMx.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = eK;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (eN = eN(2)) != null && eN.aMc != null) {
                        eN.aMc.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aMl.a((k) null);
                FP();
            } else if (aVar.id > 0) {
                b bVar = this.aMo.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aMl.eI(aVar.id);
                    }
                    k eN2 = eN(aVar.id);
                    if (eN2 != null && eN2.aMS == 5) {
                        FP();
                        HB();
                    } else {
                        this.aMm.eI(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aMq.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aMo.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aMp.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void HB() {
        boolean z;
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.aMB);
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
        if (!z) {
            k eN = eN(3);
            if (eN != null && (eN.aMc instanceof View)) {
                com.baidu.adp.lib.util.l.a(getContext(), (View) eN.aMc);
            }
            k eN2 = eN(28);
            if (eN2 != null && (eN2.aMc instanceof View)) {
                com.baidu.adp.lib.util.l.a(getContext(), (View) eN2.aMc);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aMn.add(kVar);
        }
    }

    private void clear() {
        this.aMl.clear();
        this.aMm.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aMr = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aMl.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aMm.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.e(this, this.aMu, i);
        this.aMl.onChangeSkinType(i);
        this.aMm.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aMC;
    }

    public void F(List<Integer> list) {
        this.aMC.clear();
        this.aMC.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void Hu() {
        i iVar;
        if (this.aMn != null && this.aMn.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aMn) {
                if (kVar.aMP > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aMc != null) {
                    kVar.aMc.setToolId(kVar.id);
                    kVar.aMc.setEditorTools(this);
                    if (kVar.aMS == 6) {
                        this.aMm.a(kVar.aMc);
                    } else if (kVar.aMS == 1 || kVar.aMS == 2 || kVar.aMS == 3 || kVar.aMS == 4 || kVar.aMS == 5) {
                        this.aMl.a(kVar.aMc, kVar.aMS, !kVar.aMT);
                        if (kVar.aMS == 5 && eN(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aMU, kVar.id, kVar.aMc);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aMR - kVar3.aMR;
                }
            });
            if (linkedList.size() > this.aMr) {
                if (this.aMz) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aMv > 0 && iVar.aMc != null && (iVar.aMc instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aMc).setBackgroundColorId(this.aMv);
                }
                if (this.aMs > 0) {
                    iVar.aMP = this.aMs;
                }
                b(iVar);
                iVar.aMc.setToolId(iVar.id);
                iVar.aMc.setEditorTools(this);
                a(iVar.aMU, iVar.id, iVar.aMc);
                this.aMm.a(iVar.aMc);
                if (this.aMt) {
                    linkedList.add(this.aMr, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aMr + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aMl.a(a(kVar2, 1));
                } else {
                    this.aMm.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aMl.a(0, a);
            }
            this.aMl.Hu();
            this.aMm.Hu();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aMl.setLayoutParams(layoutParams);
            this.aMm.setLayoutParams(layoutParams);
            this.aMm.hide();
            if (this.aMz) {
                this.aMl.setPadding(0, 0, 0, 0);
            }
            FP();
            removeAllViews();
            addView(this.aMl);
            addView(this.aMm);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aMl != null) {
                this.aMl.a(0, a);
                this.aMl.removeAllViews();
                this.aMl.Hu();
            }
            invalidate();
        }
    }

    public k eN(int i) {
        for (k kVar : this.aMn) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aMn;
    }

    public g eK(int i) {
        g eK = this.aMl.eK(i);
        if (eK == null) {
            return this.aMm.eK(i);
        }
        return eK;
    }

    public void HC() {
        this.aMl.d(this.aMA);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aMA);
        }
        return a;
    }

    public void bF(boolean z) {
        for (k kVar : this.aMn) {
            if (kVar != null && (kVar.aMc instanceof View) && ((View) kVar.aMc).getVisibility() == 0 && !kVar.aMT) {
                kVar.aMc.oC();
            }
        }
        if (this.aMw) {
            this.aMw = false;
            FP();
        }
        if (!Hw() && z) {
            com.baidu.adp.lib.g.e.in().postDelayed(this.aMB, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void oC() {
        bF(true);
    }

    public void hide() {
        FP();
        setVisibility(8);
        HB();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void FP() {
        this.aMm.hide();
        this.aMl.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aMl.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aMl.setBarLauncherEnabled(z, i);
    }

    public boolean Hw() {
        return this.aMm.Hw();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aMs = i;
    }

    public void setBarLauncherType(int i) {
        this.aMl.setBarLauncherType(i);
    }

    public void bD(boolean z) {
        this.aMl.bD(z);
    }

    public void bE(boolean z) {
        this.aMl.bE(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aMt = z;
    }

    public void setBackgroundColorId(int i) {
        this.aMu = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aMv = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void N(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k eN = eN(toolId);
            if (eN.oR()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.aMl.a(eN);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    oC();
                    b(new a(1, 3, null));
                } else if (eN.aMc == null) {
                    if (eN.aMU != null && eN.aMU.length > 0) {
                        b(new a(eN.aMU[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void HD() {
        this.aMl.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
