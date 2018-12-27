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
    private int aYA;
    private int aYB;
    private boolean aYC;
    private int aYD;
    private int aYE;
    private boolean aYF;
    private LinkedList<g> aYG;
    private boolean aYH;
    private boolean aYI;
    private View.OnClickListener aYJ;
    private Runnable aYK;
    private List<Integer> aYL;
    public EditorBar aYu;
    private EditorDesk aYv;
    private List<k> aYw;
    private SparseArray<b> aYx;
    private SparseArray<HashSet<b>> aYy;
    private SparseArray<HashSet<Integer>> aYz;

    public void Md() {
        k fL = fL(3);
        if (fL != null && (fL.aYl instanceof View)) {
            View view = (View) fL.aYl;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aYA = 1;
        this.aYB = 0;
        this.aYC = false;
        this.aYD = e.d.common_color_10255;
        this.aYE = 0;
        this.aYF = true;
        this.aYH = false;
        this.aYI = false;
        this.aYJ = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.aa(view);
            }
        };
        this.aYK = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.Md();
            }
        };
        this.aYL = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aYH = z;
    }

    public boolean Me() {
        return this.aYH;
    }

    public boolean Mf() {
        return this.aYI;
    }

    public void setIsFromPb(boolean z) {
        this.aYI = z;
    }

    private void init(Context context) {
        this.aYw = new LinkedList();
        this.aYx = new SparseArray<>();
        this.aYy = new SparseArray<>();
        this.aYz = new SparseArray<>();
        this.aYu = new EditorBar(context, this);
        this.aYv = new EditorDesk(context, this);
        this.aYG = new LinkedList<>();
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
                HashSet<b> hashSet = this.aYy.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aYy.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aYx.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aYz.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aYz.put(i3, hashSet2);
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
        k fL;
        if (aVar != null) {
            if (aVar.code == 2) {
                g fI = this.aYu.fI(aVar.id);
                if (fI != null) {
                    z = false;
                } else {
                    fI = this.aYv.fI(aVar.id);
                    z = true;
                }
                if (fI == null) {
                    Iterator<g> it = this.aYG.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = fI;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (fL = fL(2)) != null && fL.aYl != null) {
                        fL.aYl.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aYu.a((k) null);
                Kx();
            } else if (aVar.id > 0) {
                b bVar = this.aYx.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aYu.fG(aVar.id);
                    }
                    k fL2 = fL(aVar.id);
                    if (fL2 != null && fL2.aZb == 5) {
                        Kx();
                        Mg();
                    } else {
                        this.aYv.fG(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aYz.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aYx.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aYy.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Mg() {
        boolean z;
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aYK);
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
            k fL = fL(3);
            if (fL != null && (fL.aYl instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) fL.aYl);
            }
            k fL2 = fL(28);
            if (fL2 != null && (fL2.aYl instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) fL2.aYl);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aYw.add(kVar);
        }
    }

    private void clear() {
        this.aYu.clear();
        this.aYv.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aYA = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aYu.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aYv.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.e(this, this.aYD, i);
        this.aYu.onChangeSkinType(i);
        this.aYv.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aYL;
    }

    public void w(List<Integer> list) {
        this.aYL.clear();
        this.aYL.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void LZ() {
        i iVar;
        if (this.aYw != null && this.aYw.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aYw) {
                if (kVar.aYY > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aYl != null) {
                    kVar.aYl.setToolId(kVar.id);
                    kVar.aYl.setEditorTools(this);
                    if (kVar.aZb == 6) {
                        this.aYv.a(kVar.aYl);
                    } else if (kVar.aZb == 1 || kVar.aZb == 2 || kVar.aZb == 3 || kVar.aZb == 4 || kVar.aZb == 5) {
                        this.aYu.a(kVar.aYl, kVar.aZb, !kVar.aZc);
                        if (kVar.aZb == 5 && fL(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aZd, kVar.id, kVar.aYl);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aZa - kVar3.aZa;
                }
            });
            if (linkedList.size() > this.aYA) {
                if (this.aYI) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aYE > 0 && iVar.aYl != null && (iVar.aYl instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aYl).setBackgroundColorId(this.aYE);
                }
                if (this.aYB > 0) {
                    iVar.aYY = this.aYB;
                }
                b(iVar);
                iVar.aYl.setToolId(iVar.id);
                iVar.aYl.setEditorTools(this);
                a(iVar.aZd, iVar.id, iVar.aYl);
                this.aYv.a(iVar.aYl);
                if (this.aYC) {
                    linkedList.add(this.aYA, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aYA + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aYu.a(a(kVar2, 1));
                } else {
                    this.aYv.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aYu.a(0, a);
            }
            this.aYu.LZ();
            this.aYv.LZ();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aYu.setLayoutParams(layoutParams);
            this.aYv.setLayoutParams(layoutParams);
            this.aYv.hide();
            if (this.aYI) {
                this.aYu.setPadding(0, 0, 0, 0);
            }
            Kx();
            removeAllViews();
            addView(this.aYu);
            addView(this.aYv);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aYu != null) {
                this.aYu.a(0, a);
                this.aYu.removeAllViews();
                this.aYu.LZ();
            }
            invalidate();
        }
    }

    public k fL(int i) {
        for (k kVar : this.aYw) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aYw;
    }

    public g fI(int i) {
        g fI = this.aYu.fI(i);
        if (fI == null) {
            return this.aYv.fI(i);
        }
        return fI;
    }

    public void Mh() {
        this.aYu.e(this.aYJ);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aYJ);
        }
        return a;
    }

    public void cs(boolean z) {
        for (k kVar : this.aYw) {
            if (kVar != null && (kVar.aYl instanceof View) && ((View) kVar.aYl).getVisibility() == 0 && !kVar.aZc) {
                kVar.aYl.pN();
            }
        }
        if (this.aYF) {
            this.aYF = false;
            Kx();
        }
        if (!Mb() && z) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.aYK, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void pN() {
        cs(true);
    }

    public void hide() {
        Kx();
        setVisibility(8);
        Mg();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void Kx() {
        this.aYv.hide();
        this.aYu.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aYu.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aYu.setBarLauncherEnabled(z, i);
    }

    public boolean Mb() {
        return this.aYv.Mb();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aYB = i;
    }

    public void setBarLauncherType(int i) {
        this.aYu.setBarLauncherType(i);
    }

    public void cq(boolean z) {
        this.aYu.cq(z);
    }

    public void cr(boolean z) {
        this.aYu.cr(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aYC = z;
    }

    public void setBackgroundColorId(int i) {
        this.aYD = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aYE = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void aa(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k fL = fL(toolId);
            if (fL.qb()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.aYu.a(fL);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    pN();
                    b(new a(1, 3, null));
                } else if (fL.aYl == null) {
                    if (fL.aZd != null && fL.aZd.length > 0) {
                        b(new a(fL.aZd[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Mi() {
        this.aYu.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
