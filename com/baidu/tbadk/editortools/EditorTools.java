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
    public EditorBar aCW;
    private EditorDesk aCX;
    private List<k> aCY;
    private SparseArray<b> aCZ;
    private SparseArray<HashSet<b>> aDa;
    private SparseArray<HashSet<Integer>> aDb;
    private int aDc;
    private int aDd;
    private boolean aDe;
    private int aDf;
    private int aDg;
    private boolean aDh;
    private LinkedList<g> aDi;
    private boolean aDj;
    private boolean aDk;
    private View.OnClickListener aDl;
    private Runnable aDm;
    private List<Integer> aDn;

    public void DI() {
        k eI = eI(3);
        if (eI != null && (eI.aCN instanceof View)) {
            View view2 = (View) eI.aCN;
            view2.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view2);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aDc = 1;
        this.aDd = 0;
        this.aDe = false;
        this.aDf = d.C0126d.common_color_10255;
        this.aDg = 0;
        this.aDh = true;
        this.aDj = false;
        this.aDk = false;
        this.aDl = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EditorTools.this.M(view2);
            }
        };
        this.aDm = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.DI();
            }
        };
        this.aDn = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aDj = z;
    }

    public boolean DJ() {
        return this.aDj;
    }

    public boolean DK() {
        return this.aDk;
    }

    public void setIsFromPb(boolean z) {
        this.aDk = z;
    }

    private void init(Context context) {
        this.aCY = new LinkedList();
        this.aCZ = new SparseArray<>();
        this.aDa = new SparseArray<>();
        this.aDb = new SparseArray<>();
        this.aCW = new EditorBar(context, this);
        this.aCX = new EditorDesk(context, this);
        this.aDi = new LinkedList<>();
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
                HashSet<b> hashSet = this.aDa.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aDa.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aCZ.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aDb.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aDb.put(i3, hashSet2);
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
                g eF = this.aCW.eF(aVar.id);
                if (eF != null) {
                    z = false;
                } else {
                    eF = this.aCX.eF(aVar.id);
                    z = true;
                }
                if (eF == null) {
                    Iterator<g> it = this.aDi.iterator();
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
                    if (z && (eI = eI(2)) != null && eI.aCN != null) {
                        eI.aCN.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aCW.a((k) null);
                BY();
            } else if (aVar.id > 0) {
                b bVar = this.aCZ.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aCW.eD(aVar.id);
                    }
                    k eI2 = eI(aVar.id);
                    if (eI2 != null && eI2.aDD == 5) {
                        BY();
                        DL();
                    } else {
                        this.aCX.eD(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aDb.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aCZ.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aDa.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void DL() {
        boolean z;
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.aDm);
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
            if (eI != null && (eI.aCN instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) eI.aCN);
            }
            k eI2 = eI(28);
            if (eI2 != null && (eI2.aCN instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) eI2.aCN);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aCY.add(kVar);
        }
    }

    private void clear() {
        this.aCW.clear();
        this.aCX.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aDc = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aCW.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aCX.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ak.e(this, this.aDf, i);
        this.aCW.onChangeSkinType(i);
        this.aCX.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aDn;
    }

    public void C(List<Integer> list) {
        this.aDn.clear();
        this.aDn.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void DE() {
        i iVar;
        if (this.aCY != null && this.aCY.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aCY) {
                if (kVar.aDA > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aCN != null) {
                    kVar.aCN.setToolId(kVar.id);
                    kVar.aCN.setEditorTools(this);
                    if (kVar.aDD == 6) {
                        this.aCX.a(kVar.aCN);
                    } else if (kVar.aDD == 1 || kVar.aDD == 2 || kVar.aDD == 3 || kVar.aDD == 4 || kVar.aDD == 5) {
                        this.aCW.a(kVar.aCN, kVar.aDD, !kVar.aDE);
                        if (kVar.aDD == 5 && eI(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aDF, kVar.id, kVar.aCN);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aDC - kVar3.aDC;
                }
            });
            if (linkedList.size() > this.aDc) {
                if (this.aDk) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aDg > 0 && iVar.aCN != null && (iVar.aCN instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aCN).setBackgroundColorId(this.aDg);
                }
                if (this.aDd > 0) {
                    iVar.aDA = this.aDd;
                }
                b(iVar);
                iVar.aCN.setToolId(iVar.id);
                iVar.aCN.setEditorTools(this);
                a(iVar.aDF, iVar.id, iVar.aCN);
                this.aCX.a(iVar.aCN);
                if (this.aDe) {
                    linkedList.add(this.aDc, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aDc + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aCW.a(a(kVar2, 1));
                } else {
                    this.aCX.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aCW.a(0, a);
            }
            this.aCW.DE();
            this.aCX.DE();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aCW.setLayoutParams(layoutParams);
            this.aCX.setLayoutParams(layoutParams);
            this.aCX.hide();
            if (this.aDk) {
                this.aCW.setPadding(0, 0, 0, 0);
            }
            BY();
            removeAllViews();
            addView(this.aCW);
            addView(this.aCX);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aCW != null) {
                this.aCW.a(0, a);
                this.aCW.removeAllViews();
                this.aCW.DE();
            }
            invalidate();
        }
    }

    public k eI(int i) {
        for (k kVar : this.aCY) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aCY;
    }

    public g eF(int i) {
        g eF = this.aCW.eF(i);
        if (eF == null) {
            return this.aCX.eF(i);
        }
        return eF;
    }

    public void DM() {
        this.aCW.d(this.aDl);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aDl);
        }
        return a;
    }

    public void bz(boolean z) {
        for (k kVar : this.aCY) {
            if (kVar != null && (kVar.aCN instanceof View) && ((View) kVar.aCN).getVisibility() == 0 && !kVar.aDE) {
                kVar.aCN.lM();
            }
        }
        if (this.aDh) {
            this.aDh = false;
            BY();
        }
        if (!DG() && z) {
            com.baidu.adp.lib.g.e.fw().postDelayed(this.aDm, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void lM() {
        bz(true);
    }

    public void hide() {
        BY();
        setVisibility(8);
        DL();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void BY() {
        this.aCX.hide();
        this.aCW.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aCW.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aCW.setBarLauncherEnabled(z, i);
    }

    public boolean DG() {
        return this.aCX.DG();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aDd = i;
    }

    public void setBarLauncherType(int i) {
        this.aCW.setBarLauncherType(i);
    }

    public void bx(boolean z) {
        this.aCW.bx(z);
    }

    public void by(boolean z) {
        this.aCW.by(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aDe = z;
    }

    public void setBackgroundColorId(int i) {
        this.aDf = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aDg = i;
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
            if (eI.ma()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.aCW.a(eI);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    lM();
                    b(new a(1, 3, null));
                } else if (eI.aCN == null) {
                    if (eI.aDF != null && eI.aDF.length > 0) {
                        b(new a(eI.aDF[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void DN() {
        this.aCW.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
