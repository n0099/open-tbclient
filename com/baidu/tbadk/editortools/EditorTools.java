package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorTools extends LinearLayout {
    public EditorBar aUU;
    private EditorDesk aUV;
    private List<k> aUW;
    private SparseArray<b> aUX;
    private SparseArray<HashSet<b>> aUY;
    private SparseArray<HashSet<Integer>> aUZ;
    private int aVa;
    private int aVb;
    private boolean aVc;
    private int aVd;
    private int aVe;
    private boolean aVf;
    private LinkedList<g> aVg;
    private boolean aVh;
    private boolean aVi;
    private View.OnClickListener aVj;
    private Runnable aVk;
    private List<Integer> aVl;

    public void KY() {
        k fw = fw(3);
        if (fw != null && (fw.aUL instanceof View)) {
            View view = (View) fw.aUL;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aVa = 1;
        this.aVb = 0;
        this.aVc = false;
        this.aVd = e.d.common_color_10255;
        this.aVe = 0;
        this.aVf = true;
        this.aVh = false;
        this.aVi = false;
        this.aVj = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.aa(view);
            }
        };
        this.aVk = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.KY();
            }
        };
        this.aVl = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aVh = z;
    }

    public boolean KZ() {
        return this.aVh;
    }

    public boolean La() {
        return this.aVi;
    }

    public void setIsFromPb(boolean z) {
        this.aVi = z;
    }

    private void init(Context context) {
        this.aUW = new LinkedList();
        this.aUX = new SparseArray<>();
        this.aUY = new SparseArray<>();
        this.aUZ = new SparseArray<>();
        this.aUU = new EditorBar(context, this);
        this.aUV = new EditorDesk(context, this);
        this.aVg = new LinkedList<>();
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
                HashSet<b> hashSet = this.aUY.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aUY.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aUX.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aUZ.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aUZ.put(i3, hashSet2);
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
        k fw;
        if (aVar != null) {
            if (aVar.code == 2) {
                g ft = this.aUU.ft(aVar.id);
                if (ft != null) {
                    z = false;
                } else {
                    ft = this.aUV.ft(aVar.id);
                    z = true;
                }
                if (ft == null) {
                    Iterator<g> it = this.aVg.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = ft;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (fw = fw(2)) != null && fw.aUL != null) {
                        fw.aUL.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aUU.a((k) null);
                Js();
            } else if (aVar.id > 0) {
                b bVar = this.aUX.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aUU.fr(aVar.id);
                    }
                    k fw2 = fw(aVar.id);
                    if (fw2 != null && fw2.aVB == 5) {
                        Js();
                        Lb();
                    } else {
                        this.aUV.fr(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aUZ.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aUX.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aUY.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Lb() {
        boolean z;
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aVk);
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
            k fw = fw(3);
            if (fw != null && (fw.aUL instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) fw.aUL);
            }
            k fw2 = fw(28);
            if (fw2 != null && (fw2.aUL instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) fw2.aUL);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aUW.add(kVar);
        }
    }

    private void clear() {
        this.aUU.clear();
        this.aUV.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aVa = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aUU.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aUV.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.e(this, this.aVd, i);
        this.aUU.onChangeSkinType(i);
        this.aUV.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aVl;
    }

    public void w(List<Integer> list) {
        this.aVl.clear();
        this.aVl.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void KU() {
        i iVar;
        if (this.aUW != null && this.aUW.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aUW) {
                if (kVar.aVy > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aUL != null) {
                    kVar.aUL.setToolId(kVar.id);
                    kVar.aUL.setEditorTools(this);
                    if (kVar.aVB == 6) {
                        this.aUV.a(kVar.aUL);
                    } else if (kVar.aVB == 1 || kVar.aVB == 2 || kVar.aVB == 3 || kVar.aVB == 4 || kVar.aVB == 5) {
                        this.aUU.a(kVar.aUL, kVar.aVB, !kVar.aVC);
                        if (kVar.aVB == 5 && fw(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aVD, kVar.id, kVar.aUL);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aVA - kVar3.aVA;
                }
            });
            if (linkedList.size() > this.aVa) {
                if (this.aVi) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aVe > 0 && iVar.aUL != null && (iVar.aUL instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aUL).setBackgroundColorId(this.aVe);
                }
                if (this.aVb > 0) {
                    iVar.aVy = this.aVb;
                }
                b(iVar);
                iVar.aUL.setToolId(iVar.id);
                iVar.aUL.setEditorTools(this);
                a(iVar.aVD, iVar.id, iVar.aUL);
                this.aUV.a(iVar.aUL);
                if (this.aVc) {
                    linkedList.add(this.aVa, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aVa + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aUU.a(a(kVar2, 1));
                } else {
                    this.aUV.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aUU.a(0, a);
            }
            this.aUU.KU();
            this.aUV.KU();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aUU.setLayoutParams(layoutParams);
            this.aUV.setLayoutParams(layoutParams);
            this.aUV.hide();
            if (this.aVi) {
                this.aUU.setPadding(0, 0, 0, 0);
            }
            Js();
            removeAllViews();
            addView(this.aUU);
            addView(this.aUV);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aUU != null) {
                this.aUU.a(0, a);
                this.aUU.removeAllViews();
                this.aUU.KU();
            }
            invalidate();
        }
    }

    public k fw(int i) {
        for (k kVar : this.aUW) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aUW;
    }

    public g ft(int i) {
        g ft = this.aUU.ft(i);
        if (ft == null) {
            return this.aUV.ft(i);
        }
        return ft;
    }

    public void Lc() {
        this.aUU.e(this.aVj);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aVj);
        }
        return a;
    }

    public void cr(boolean z) {
        for (k kVar : this.aUW) {
            if (kVar != null && (kVar.aUL instanceof View) && ((View) kVar.aUL).getVisibility() == 0 && !kVar.aVC) {
                kVar.aUL.pO();
            }
        }
        if (this.aVf) {
            this.aVf = false;
            Js();
        }
        if (!KW() && z) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.aVk, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void pO() {
        cr(true);
    }

    public void hide() {
        Js();
        setVisibility(8);
        Lb();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void Js() {
        this.aUV.hide();
        this.aUU.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aUU.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aUU.setBarLauncherEnabled(z, i);
    }

    public boolean KW() {
        return this.aUV.KW();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aVb = i;
    }

    public void setBarLauncherType(int i) {
        this.aUU.setBarLauncherType(i);
    }

    public void cp(boolean z) {
        this.aUU.cp(z);
    }

    public void cq(boolean z) {
        this.aUU.cq(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aVc = z;
    }

    public void setBackgroundColorId(int i) {
        this.aVd = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aVe = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void aa(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k fw = fw(toolId);
            if (fw.qc()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.aUU.a(fw);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    pO();
                    b(new a(1, 3, null));
                } else if (fw.aUL == null) {
                    if (fw.aVD != null && fw.aVD.length > 0) {
                        b(new a(fw.aVD[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Ld() {
        this.aUU.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
