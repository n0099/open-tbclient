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
    private LinkedList<g> aYD;
    private boolean aYE;
    private boolean aYF;
    private View.OnClickListener aYG;
    private Runnable aYH;
    private List<Integer> aYI;
    public EditorBar aYr;
    private EditorDesk aYs;
    private List<k> aYt;
    private SparseArray<b> aYu;
    private SparseArray<HashSet<b>> aYv;
    private SparseArray<HashSet<Integer>> aYw;
    private int aYx;
    private int aYy;
    private boolean aYz;

    public void Mc() {
        k fK = fK(3);
        if (fK != null && (fK.aYi instanceof View)) {
            View view = (View) fK.aYi;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aYx = 1;
        this.aYy = 0;
        this.aYz = false;
        this.aYA = e.d.common_color_10255;
        this.aYB = 0;
        this.aYC = true;
        this.aYE = false;
        this.aYF = false;
        this.aYG = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.aa(view);
            }
        };
        this.aYH = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.Mc();
            }
        };
        this.aYI = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aYE = z;
    }

    public boolean Md() {
        return this.aYE;
    }

    public boolean Me() {
        return this.aYF;
    }

    public void setIsFromPb(boolean z) {
        this.aYF = z;
    }

    private void init(Context context) {
        this.aYt = new LinkedList();
        this.aYu = new SparseArray<>();
        this.aYv = new SparseArray<>();
        this.aYw = new SparseArray<>();
        this.aYr = new EditorBar(context, this);
        this.aYs = new EditorDesk(context, this);
        this.aYD = new LinkedList<>();
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
                HashSet<b> hashSet = this.aYv.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aYv.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aYu.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aYw.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aYw.put(i3, hashSet2);
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
        k fK;
        if (aVar != null) {
            if (aVar.code == 2) {
                g fH = this.aYr.fH(aVar.id);
                if (fH != null) {
                    z = false;
                } else {
                    fH = this.aYs.fH(aVar.id);
                    z = true;
                }
                if (fH == null) {
                    Iterator<g> it = this.aYD.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = fH;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (fK = fK(2)) != null && fK.aYi != null) {
                        fK.aYi.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aYr.a((k) null);
                Kw();
            } else if (aVar.id > 0) {
                b bVar = this.aYu.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aYr.fF(aVar.id);
                    }
                    k fK2 = fK(aVar.id);
                    if (fK2 != null && fK2.aYY == 5) {
                        Kw();
                        Mf();
                    } else {
                        this.aYs.fF(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aYw.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aYu.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aYv.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Mf() {
        boolean z;
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aYH);
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
            k fK = fK(3);
            if (fK != null && (fK.aYi instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) fK.aYi);
            }
            k fK2 = fK(28);
            if (fK2 != null && (fK2.aYi instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) fK2.aYi);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aYt.add(kVar);
        }
    }

    private void clear() {
        this.aYr.clear();
        this.aYs.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aYx = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aYr.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aYs.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.e(this, this.aYA, i);
        this.aYr.onChangeSkinType(i);
        this.aYs.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aYI;
    }

    public void w(List<Integer> list) {
        this.aYI.clear();
        this.aYI.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void LY() {
        i iVar;
        if (this.aYt != null && this.aYt.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aYt) {
                if (kVar.aYV > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aYi != null) {
                    kVar.aYi.setToolId(kVar.id);
                    kVar.aYi.setEditorTools(this);
                    if (kVar.aYY == 6) {
                        this.aYs.a(kVar.aYi);
                    } else if (kVar.aYY == 1 || kVar.aYY == 2 || kVar.aYY == 3 || kVar.aYY == 4 || kVar.aYY == 5) {
                        this.aYr.a(kVar.aYi, kVar.aYY, !kVar.aYZ);
                        if (kVar.aYY == 5 && fK(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aZa, kVar.id, kVar.aYi);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aYX - kVar3.aYX;
                }
            });
            if (linkedList.size() > this.aYx) {
                if (this.aYF) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aYB > 0 && iVar.aYi != null && (iVar.aYi instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aYi).setBackgroundColorId(this.aYB);
                }
                if (this.aYy > 0) {
                    iVar.aYV = this.aYy;
                }
                b(iVar);
                iVar.aYi.setToolId(iVar.id);
                iVar.aYi.setEditorTools(this);
                a(iVar.aZa, iVar.id, iVar.aYi);
                this.aYs.a(iVar.aYi);
                if (this.aYz) {
                    linkedList.add(this.aYx, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aYx + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aYr.a(a(kVar2, 1));
                } else {
                    this.aYs.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aYr.a(0, a);
            }
            this.aYr.LY();
            this.aYs.LY();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aYr.setLayoutParams(layoutParams);
            this.aYs.setLayoutParams(layoutParams);
            this.aYs.hide();
            if (this.aYF) {
                this.aYr.setPadding(0, 0, 0, 0);
            }
            Kw();
            removeAllViews();
            addView(this.aYr);
            addView(this.aYs);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aYr != null) {
                this.aYr.a(0, a);
                this.aYr.removeAllViews();
                this.aYr.LY();
            }
            invalidate();
        }
    }

    public k fK(int i) {
        for (k kVar : this.aYt) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aYt;
    }

    public g fH(int i) {
        g fH = this.aYr.fH(i);
        if (fH == null) {
            return this.aYs.fH(i);
        }
        return fH;
    }

    public void Mg() {
        this.aYr.e(this.aYG);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aYG);
        }
        return a;
    }

    public void cs(boolean z) {
        for (k kVar : this.aYt) {
            if (kVar != null && (kVar.aYi instanceof View) && ((View) kVar.aYi).getVisibility() == 0 && !kVar.aYZ) {
                kVar.aYi.pN();
            }
        }
        if (this.aYC) {
            this.aYC = false;
            Kw();
        }
        if (!Ma() && z) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.aYH, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void pN() {
        cs(true);
    }

    public void hide() {
        Kw();
        setVisibility(8);
        Mf();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void Kw() {
        this.aYs.hide();
        this.aYr.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aYr.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aYr.setBarLauncherEnabled(z, i);
    }

    public boolean Ma() {
        return this.aYs.Ma();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aYy = i;
    }

    public void setBarLauncherType(int i) {
        this.aYr.setBarLauncherType(i);
    }

    public void cq(boolean z) {
        this.aYr.cq(z);
    }

    public void cr(boolean z) {
        this.aYr.cr(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aYz = z;
    }

    public void setBackgroundColorId(int i) {
        this.aYA = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aYB = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void aa(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k fK = fK(toolId);
            if (fK.qb()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.aYr.a(fK);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    pN();
                    b(new a(1, 3, null));
                } else if (fK.aYi == null) {
                    if (fK.aZa != null && fK.aZa.length > 0) {
                        b(new a(fK.aZa[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Mh() {
        this.aYr.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
