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
    private LinkedList<g> aMA;
    private boolean aMB;
    private boolean aMC;
    private View.OnClickListener aMD;
    private Runnable aME;
    private List<Integer> aMF;
    public EditorBar aMo;
    private EditorDesk aMp;
    private List<k> aMq;
    private SparseArray<b> aMr;
    private SparseArray<HashSet<b>> aMs;
    private SparseArray<HashSet<Integer>> aMt;
    private int aMu;
    private int aMv;
    private boolean aMw;
    private int aMx;
    private int aMy;
    private boolean aMz;

    public void HD() {
        k eN = eN(3);
        if (eN != null && (eN.aMf instanceof View)) {
            View view = (View) eN.aMf;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aMu = 1;
        this.aMv = 0;
        this.aMw = false;
        this.aMx = d.C0142d.common_color_10255;
        this.aMy = 0;
        this.aMz = true;
        this.aMB = false;
        this.aMC = false;
        this.aMD = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.N(view);
            }
        };
        this.aME = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.HD();
            }
        };
        this.aMF = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aMB = z;
    }

    public boolean HE() {
        return this.aMB;
    }

    public boolean HF() {
        return this.aMC;
    }

    public void setIsFromPb(boolean z) {
        this.aMC = z;
    }

    private void init(Context context) {
        this.aMq = new LinkedList();
        this.aMr = new SparseArray<>();
        this.aMs = new SparseArray<>();
        this.aMt = new SparseArray<>();
        this.aMo = new EditorBar(context, this);
        this.aMp = new EditorDesk(context, this);
        this.aMA = new LinkedList<>();
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
                HashSet<b> hashSet = this.aMs.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aMs.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aMr.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aMt.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aMt.put(i3, hashSet2);
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
                g eK = this.aMo.eK(aVar.id);
                if (eK != null) {
                    z = false;
                } else {
                    eK = this.aMp.eK(aVar.id);
                    z = true;
                }
                if (eK == null) {
                    Iterator<g> it = this.aMA.iterator();
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
                    if (z && (eN = eN(2)) != null && eN.aMf != null) {
                        eN.aMf.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aMo.a((k) null);
                FT();
            } else if (aVar.id > 0) {
                b bVar = this.aMr.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aMo.eI(aVar.id);
                    }
                    k eN2 = eN(aVar.id);
                    if (eN2 != null && eN2.aMV == 5) {
                        FT();
                        HG();
                    } else {
                        this.aMp.eI(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aMt.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aMr.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aMs.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void HG() {
        boolean z;
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.aME);
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
            k eN = eN(3);
            if (eN != null && (eN.aMf instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) eN.aMf);
            }
            k eN2 = eN(28);
            if (eN2 != null && (eN2.aMf instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) eN2.aMf);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aMq.add(kVar);
        }
    }

    private void clear() {
        this.aMo.clear();
        this.aMp.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aMu = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aMo.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aMp.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.e(this, this.aMx, i);
        this.aMo.onChangeSkinType(i);
        this.aMp.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aMF;
    }

    public void G(List<Integer> list) {
        this.aMF.clear();
        this.aMF.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void Hz() {
        i iVar;
        if (this.aMq != null && this.aMq.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aMq) {
                if (kVar.aMS > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aMf != null) {
                    kVar.aMf.setToolId(kVar.id);
                    kVar.aMf.setEditorTools(this);
                    if (kVar.aMV == 6) {
                        this.aMp.a(kVar.aMf);
                    } else if (kVar.aMV == 1 || kVar.aMV == 2 || kVar.aMV == 3 || kVar.aMV == 4 || kVar.aMV == 5) {
                        this.aMo.a(kVar.aMf, kVar.aMV, !kVar.aMW);
                        if (kVar.aMV == 5 && eN(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aMX, kVar.id, kVar.aMf);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aMU - kVar3.aMU;
                }
            });
            if (linkedList.size() > this.aMu) {
                if (this.aMC) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aMy > 0 && iVar.aMf != null && (iVar.aMf instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aMf).setBackgroundColorId(this.aMy);
                }
                if (this.aMv > 0) {
                    iVar.aMS = this.aMv;
                }
                b(iVar);
                iVar.aMf.setToolId(iVar.id);
                iVar.aMf.setEditorTools(this);
                a(iVar.aMX, iVar.id, iVar.aMf);
                this.aMp.a(iVar.aMf);
                if (this.aMw) {
                    linkedList.add(this.aMu, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aMu + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aMo.a(a(kVar2, 1));
                } else {
                    this.aMp.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aMo.a(0, a);
            }
            this.aMo.Hz();
            this.aMp.Hz();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aMo.setLayoutParams(layoutParams);
            this.aMp.setLayoutParams(layoutParams);
            this.aMp.hide();
            if (this.aMC) {
                this.aMo.setPadding(0, 0, 0, 0);
            }
            FT();
            removeAllViews();
            addView(this.aMo);
            addView(this.aMp);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aMo != null) {
                this.aMo.a(0, a);
                this.aMo.removeAllViews();
                this.aMo.Hz();
            }
            invalidate();
        }
    }

    public k eN(int i) {
        for (k kVar : this.aMq) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aMq;
    }

    public g eK(int i) {
        g eK = this.aMo.eK(i);
        if (eK == null) {
            return this.aMp.eK(i);
        }
        return eK;
    }

    public void HH() {
        this.aMo.d(this.aMD);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aMD);
        }
        return a;
    }

    public void bG(boolean z) {
        for (k kVar : this.aMq) {
            if (kVar != null && (kVar.aMf instanceof View) && ((View) kVar.aMf).getVisibility() == 0 && !kVar.aMW) {
                kVar.aMf.oD();
            }
        }
        if (this.aMz) {
            this.aMz = false;
            FT();
        }
        if (!HB() && z) {
            com.baidu.adp.lib.g.e.im().postDelayed(this.aME, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void oD() {
        bG(true);
    }

    public void hide() {
        FT();
        setVisibility(8);
        HG();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void FT() {
        this.aMp.hide();
        this.aMo.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aMo.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aMo.setBarLauncherEnabled(z, i);
    }

    public boolean HB() {
        return this.aMp.HB();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aMv = i;
    }

    public void setBarLauncherType(int i) {
        this.aMo.setBarLauncherType(i);
    }

    public void bE(boolean z) {
        this.aMo.bE(z);
    }

    public void bF(boolean z) {
        this.aMo.bF(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aMw = z;
    }

    public void setBackgroundColorId(int i) {
        this.aMx = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aMy = i;
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
                this.aMo.a(eN);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    oD();
                    b(new a(1, 3, null));
                } else if (eN.aMf == null) {
                    if (eN.aMX != null && eN.aMX.length > 0) {
                        b(new a(eN.aMX[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void HI() {
        this.aMo.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
