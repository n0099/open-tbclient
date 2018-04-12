package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorTools extends LinearLayout {
    public EditorBar aCV;
    private EditorDesk aCW;
    private List<k> aCX;
    private SparseArray<b> aCY;
    private SparseArray<HashSet<b>> aCZ;
    private SparseArray<HashSet<Integer>> aDa;
    private int aDb;
    private int aDc;
    private boolean aDd;
    private int aDe;
    private int aDf;
    private boolean aDg;
    private LinkedList<g> aDh;
    private boolean aDi;
    private boolean aDj;
    private View.OnClickListener aDk;
    private Runnable aDl;
    private List<Integer> aDm;

    public void DK() {
        k eI = eI(3);
        if (eI != null && (eI.aCM instanceof View)) {
            View view2 = (View) eI.aCM;
            view2.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view2);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aDb = 1;
        this.aDc = 0;
        this.aDd = false;
        this.aDe = d.C0126d.common_color_10255;
        this.aDf = 0;
        this.aDg = true;
        this.aDi = false;
        this.aDj = false;
        this.aDk = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EditorTools.this.M(view2);
            }
        };
        this.aDl = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.DK();
            }
        };
        this.aDm = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aDi = z;
    }

    public boolean DL() {
        return this.aDi;
    }

    public boolean DM() {
        return this.aDj;
    }

    public void setIsFromPb(boolean z) {
        this.aDj = z;
    }

    private void init(Context context) {
        this.aCX = new LinkedList();
        this.aCY = new SparseArray<>();
        this.aCZ = new SparseArray<>();
        this.aDa = new SparseArray<>();
        this.aCV = new EditorBar(context, this);
        this.aCW = new EditorDesk(context, this);
        this.aDh = new LinkedList<>();
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
                HashSet<b> hashSet = this.aCZ.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aCZ.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aCY.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aDa.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aDa.put(i3, hashSet2);
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
        k eI;
        if (aVar != null) {
            if (aVar.code == 2) {
                g eF = this.aCV.eF(aVar.id);
                if (eF != null) {
                    z = false;
                } else {
                    eF = this.aCW.eF(aVar.id);
                    z = true;
                }
                if (eF == null) {
                    Iterator<g> it = this.aDh.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = eF;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (eI = eI(2)) != null && eI.aCM != null) {
                        eI.aCM.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aCV.a((k) null);
                Ca();
            } else if (aVar.id > 0) {
                b bVar = this.aCY.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aCV.eD(aVar.id);
                    }
                    k eI2 = eI(aVar.id);
                    if (eI2 != null && eI2.aDC == 5) {
                        Ca();
                        DN();
                    } else {
                        this.aCW.eD(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aDa.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aCY.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aCZ.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void DN() {
        boolean z;
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aDl);
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
            k eI = eI(3);
            if (eI != null && (eI.aCM instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) eI.aCM);
            }
            k eI2 = eI(28);
            if (eI2 != null && (eI2.aCM instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) eI2.aCM);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aCX.add(kVar);
        }
    }

    private void clear() {
        this.aCV.clear();
        this.aCW.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aDb = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aCV.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aCW.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ak.e(this, this.aDe, i);
        this.aCV.onChangeSkinType(i);
        this.aCW.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aDm;
    }

    public void C(List<Integer> list) {
        this.aDm.clear();
        this.aDm.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void DG() {
        i iVar;
        if (this.aCX != null && this.aCX.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aCX) {
                if (kVar.aDz > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aCM != null) {
                    kVar.aCM.setToolId(kVar.id);
                    kVar.aCM.setEditorTools(this);
                    if (kVar.aDC == 6) {
                        this.aCW.a(kVar.aCM);
                    } else if (kVar.aDC == 1 || kVar.aDC == 2 || kVar.aDC == 3 || kVar.aDC == 4 || kVar.aDC == 5) {
                        this.aCV.a(kVar.aCM, kVar.aDC, !kVar.aDD);
                        if (kVar.aDC == 5 && eI(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aDE, kVar.id, kVar.aCM);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aDB - kVar3.aDB;
                }
            });
            if (linkedList.size() > this.aDb) {
                if (this.aDj) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aDf > 0 && iVar.aCM != null && (iVar.aCM instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aCM).setBackgroundColorId(this.aDf);
                }
                if (this.aDc > 0) {
                    iVar.aDz = this.aDc;
                }
                b(iVar);
                iVar.aCM.setToolId(iVar.id);
                iVar.aCM.setEditorTools(this);
                a(iVar.aDE, iVar.id, iVar.aCM);
                this.aCW.a(iVar.aCM);
                if (this.aDd) {
                    linkedList.add(this.aDb, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aDb + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aCV.a(a(kVar2, 1));
                } else {
                    this.aCW.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aCV.a(0, a);
            }
            this.aCV.DG();
            this.aCW.DG();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aCV.setLayoutParams(layoutParams);
            this.aCW.setLayoutParams(layoutParams);
            this.aCW.hide();
            if (this.aDj) {
                this.aCV.setPadding(0, 0, 0, 0);
            }
            Ca();
            removeAllViews();
            addView(this.aCV);
            addView(this.aCW);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aCV != null) {
                this.aCV.a(0, a);
                this.aCV.removeAllViews();
                this.aCV.DG();
            }
            invalidate();
        }
    }

    public k eI(int i) {
        for (k kVar : this.aCX) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aCX;
    }

    public g eF(int i) {
        g eF = this.aCV.eF(i);
        if (eF == null) {
            return this.aCW.eF(i);
        }
        return eF;
    }

    public void DO() {
        this.aCV.d(this.aDk);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aDk);
        }
        return a;
    }

    public void bz(boolean z) {
        for (k kVar : this.aCX) {
            if (kVar != null && (kVar.aCM instanceof View) && ((View) kVar.aCM).getVisibility() == 0 && !kVar.aDD) {
                kVar.aCM.lN();
            }
        }
        if (this.aDg) {
            this.aDg = false;
            Ca();
        }
        if (!DI() && z) {
            com.baidu.adp.lib.g.e.fw().postDelayed(this.aDl, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void lN() {
        bz(true);
    }

    public void hide() {
        Ca();
        setVisibility(8);
        DN();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void Ca() {
        this.aCW.hide();
        this.aCV.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aCV.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aCV.setBarLauncherEnabled(z, i);
    }

    public boolean DI() {
        return this.aCW.DI();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aDc = i;
    }

    public void setBarLauncherType(int i) {
        this.aCV.setBarLauncherType(i);
    }

    public void bx(boolean z) {
        this.aCV.bx(z);
    }

    public void by(boolean z) {
        this.aCV.by(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aDd = z;
    }

    public void setBackgroundColorId(int i) {
        this.aDe = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aDf = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void M(View view2) {
        if (view2 instanceof g) {
            g gVar = (g) view2;
            int toolId = gVar.getToolId();
            k eI = eI(toolId);
            if (eI.mb()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.aCV.a(eI);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    lN();
                    b(new a(1, 3, null));
                } else if (eI.aCM == null) {
                    if (eI.aDE != null && eI.aDE.length > 0) {
                        b(new a(eI.aDE[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void DP() {
        this.aCV.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
