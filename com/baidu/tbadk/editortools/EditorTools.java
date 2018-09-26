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
    public EditorBar aPD;
    private EditorDesk aPE;
    private List<k> aPF;
    private SparseArray<b> aPG;
    private SparseArray<HashSet<b>> aPH;
    private SparseArray<HashSet<Integer>> aPI;
    private int aPJ;
    private int aPK;
    private boolean aPL;
    private int aPM;
    private int aPN;
    private boolean aPO;
    private LinkedList<g> aPP;
    private boolean aPQ;
    private boolean aPR;
    private View.OnClickListener aPS;
    private Runnable aPT;
    private List<Integer> aPU;

    public void IO() {
        k eZ = eZ(3);
        if (eZ != null && (eZ.aPu instanceof View)) {
            View view = (View) eZ.aPu;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aPJ = 1;
        this.aPK = 0;
        this.aPL = false;
        this.aPM = e.d.common_color_10255;
        this.aPN = 0;
        this.aPO = true;
        this.aPQ = false;
        this.aPR = false;
        this.aPS = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.aa(view);
            }
        };
        this.aPT = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.IO();
            }
        };
        this.aPU = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aPQ = z;
    }

    public boolean IP() {
        return this.aPQ;
    }

    public boolean IQ() {
        return this.aPR;
    }

    public void setIsFromPb(boolean z) {
        this.aPR = z;
    }

    private void init(Context context) {
        this.aPF = new LinkedList();
        this.aPG = new SparseArray<>();
        this.aPH = new SparseArray<>();
        this.aPI = new SparseArray<>();
        this.aPD = new EditorBar(context, this);
        this.aPE = new EditorDesk(context, this);
        this.aPP = new LinkedList<>();
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
                HashSet<b> hashSet = this.aPH.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aPH.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aPG.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aPI.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aPI.put(i3, hashSet2);
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
        k eZ;
        if (aVar != null) {
            if (aVar.code == 2) {
                g eW = this.aPD.eW(aVar.id);
                if (eW != null) {
                    z = false;
                } else {
                    eW = this.aPE.eW(aVar.id);
                    z = true;
                }
                if (eW == null) {
                    Iterator<g> it = this.aPP.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = eW;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (eZ = eZ(2)) != null && eZ.aPu != null) {
                        eZ.aPu.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aPD.a((k) null);
                Hf();
            } else if (aVar.id > 0) {
                b bVar = this.aPG.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aPD.eU(aVar.id);
                    }
                    k eZ2 = eZ(aVar.id);
                    if (eZ2 != null && eZ2.aQk == 5) {
                        Hf();
                        IR();
                    } else {
                        this.aPE.eU(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aPI.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aPG.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aPH.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void IR() {
        boolean z;
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.aPT);
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
            k eZ = eZ(3);
            if (eZ != null && (eZ.aPu instanceof View)) {
                com.baidu.adp.lib.util.l.a(getContext(), (View) eZ.aPu);
            }
            k eZ2 = eZ(28);
            if (eZ2 != null && (eZ2.aPu instanceof View)) {
                com.baidu.adp.lib.util.l.a(getContext(), (View) eZ2.aPu);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aPF.add(kVar);
        }
    }

    private void clear() {
        this.aPD.clear();
        this.aPE.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aPJ = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aPD.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aPE.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.e(this, this.aPM, i);
        this.aPD.onChangeSkinType(i);
        this.aPE.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aPU;
    }

    public void G(List<Integer> list) {
        this.aPU.clear();
        this.aPU.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void IK() {
        i iVar;
        if (this.aPF != null && this.aPF.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aPF) {
                if (kVar.aQh > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aPu != null) {
                    kVar.aPu.setToolId(kVar.id);
                    kVar.aPu.setEditorTools(this);
                    if (kVar.aQk == 6) {
                        this.aPE.a(kVar.aPu);
                    } else if (kVar.aQk == 1 || kVar.aQk == 2 || kVar.aQk == 3 || kVar.aQk == 4 || kVar.aQk == 5) {
                        this.aPD.a(kVar.aPu, kVar.aQk, !kVar.aQl);
                        if (kVar.aQk == 5 && eZ(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aQm, kVar.id, kVar.aPu);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aQj - kVar3.aQj;
                }
            });
            if (linkedList.size() > this.aPJ) {
                if (this.aPR) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aPN > 0 && iVar.aPu != null && (iVar.aPu instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aPu).setBackgroundColorId(this.aPN);
                }
                if (this.aPK > 0) {
                    iVar.aQh = this.aPK;
                }
                b(iVar);
                iVar.aPu.setToolId(iVar.id);
                iVar.aPu.setEditorTools(this);
                a(iVar.aQm, iVar.id, iVar.aPu);
                this.aPE.a(iVar.aPu);
                if (this.aPL) {
                    linkedList.add(this.aPJ, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aPJ + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aPD.a(a(kVar2, 1));
                } else {
                    this.aPE.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aPD.a(0, a);
            }
            this.aPD.IK();
            this.aPE.IK();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aPD.setLayoutParams(layoutParams);
            this.aPE.setLayoutParams(layoutParams);
            this.aPE.hide();
            if (this.aPR) {
                this.aPD.setPadding(0, 0, 0, 0);
            }
            Hf();
            removeAllViews();
            addView(this.aPD);
            addView(this.aPE);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aPD != null) {
                this.aPD.a(0, a);
                this.aPD.removeAllViews();
                this.aPD.IK();
            }
            invalidate();
        }
    }

    public k eZ(int i) {
        for (k kVar : this.aPF) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aPF;
    }

    public g eW(int i) {
        g eW = this.aPD.eW(i);
        if (eW == null) {
            return this.aPE.eW(i);
        }
        return eW;
    }

    public void IS() {
        this.aPD.d(this.aPS);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aPS);
        }
        return a;
    }

    public void bR(boolean z) {
        for (k kVar : this.aPF) {
            if (kVar != null && (kVar.aPu instanceof View) && ((View) kVar.aPu).getVisibility() == 0 && !kVar.aQl) {
                kVar.aPu.pI();
            }
        }
        if (this.aPO) {
            this.aPO = false;
            Hf();
        }
        if (!IM() && z) {
            com.baidu.adp.lib.g.e.jt().postDelayed(this.aPT, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void pI() {
        bR(true);
    }

    public void hide() {
        Hf();
        setVisibility(8);
        IR();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void Hf() {
        this.aPE.hide();
        this.aPD.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aPD.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aPD.setBarLauncherEnabled(z, i);
    }

    public boolean IM() {
        return this.aPE.IM();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aPK = i;
    }

    public void setBarLauncherType(int i) {
        this.aPD.setBarLauncherType(i);
    }

    public void bP(boolean z) {
        this.aPD.bP(z);
    }

    public void bQ(boolean z) {
        this.aPD.bQ(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aPL = z;
    }

    public void setBackgroundColorId(int i) {
        this.aPM = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aPN = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void aa(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k eZ = eZ(toolId);
            if (eZ.pX()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.aPD.a(eZ);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    pI();
                    b(new a(1, 3, null));
                } else if (eZ.aPu == null) {
                    if (eZ.aQm != null && eZ.aQm.length > 0) {
                        b(new a(eZ.aQm[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void IT() {
        this.aPD.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
