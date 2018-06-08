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
    private boolean aLA;
    private int aLB;
    private int aLC;
    private boolean aLD;
    private LinkedList<g> aLE;
    private boolean aLF;
    private boolean aLG;
    private View.OnClickListener aLH;
    private Runnable aLI;
    private List<Integer> aLJ;
    public EditorBar aLs;
    private EditorDesk aLt;
    private List<k> aLu;
    private SparseArray<b> aLv;
    private SparseArray<HashSet<b>> aLw;
    private SparseArray<HashSet<Integer>> aLx;
    private int aLy;
    private int aLz;

    public void Hl() {
        k eM = eM(3);
        if (eM != null && (eM.aLj instanceof View)) {
            View view = (View) eM.aLj;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aLy = 1;
        this.aLz = 0;
        this.aLA = false;
        this.aLB = d.C0141d.common_color_10255;
        this.aLC = 0;
        this.aLD = true;
        this.aLF = false;
        this.aLG = false;
        this.aLH = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.M(view);
            }
        };
        this.aLI = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.Hl();
            }
        };
        this.aLJ = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aLF = z;
    }

    public boolean Hm() {
        return this.aLF;
    }

    public boolean Hn() {
        return this.aLG;
    }

    public void setIsFromPb(boolean z) {
        this.aLG = z;
    }

    private void init(Context context) {
        this.aLu = new LinkedList();
        this.aLv = new SparseArray<>();
        this.aLw = new SparseArray<>();
        this.aLx = new SparseArray<>();
        this.aLs = new EditorBar(context, this);
        this.aLt = new EditorDesk(context, this);
        this.aLE = new LinkedList<>();
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
                HashSet<b> hashSet = this.aLw.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aLw.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aLv.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aLx.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aLx.put(i3, hashSet2);
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
        k eM;
        if (aVar != null) {
            if (aVar.code == 2) {
                g eJ = this.aLs.eJ(aVar.id);
                if (eJ != null) {
                    z = false;
                } else {
                    eJ = this.aLt.eJ(aVar.id);
                    z = true;
                }
                if (eJ == null) {
                    Iterator<g> it = this.aLE.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = eJ;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (eM = eM(2)) != null && eM.aLj != null) {
                        eM.aLj.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aLs.a((k) null);
                FB();
            } else if (aVar.id > 0) {
                b bVar = this.aLv.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aLs.eH(aVar.id);
                    }
                    k eM2 = eM(aVar.id);
                    if (eM2 != null && eM2.aLZ == 5) {
                        FB();
                        Ho();
                    } else {
                        this.aLt.eH(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aLx.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aLv.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aLw.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Ho() {
        boolean z;
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.aLI);
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
            k eM = eM(3);
            if (eM != null && (eM.aLj instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) eM.aLj);
            }
            k eM2 = eM(28);
            if (eM2 != null && (eM2.aLj instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) eM2.aLj);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aLu.add(kVar);
        }
    }

    private void clear() {
        this.aLs.clear();
        this.aLt.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aLy = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aLs.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aLt.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.e(this, this.aLB, i);
        this.aLs.onChangeSkinType(i);
        this.aLt.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aLJ;
    }

    public void F(List<Integer> list) {
        this.aLJ.clear();
        this.aLJ.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void Hh() {
        i iVar;
        if (this.aLu != null && this.aLu.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aLu) {
                if (kVar.aLW > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aLj != null) {
                    kVar.aLj.setToolId(kVar.id);
                    kVar.aLj.setEditorTools(this);
                    if (kVar.aLZ == 6) {
                        this.aLt.a(kVar.aLj);
                    } else if (kVar.aLZ == 1 || kVar.aLZ == 2 || kVar.aLZ == 3 || kVar.aLZ == 4 || kVar.aLZ == 5) {
                        this.aLs.a(kVar.aLj, kVar.aLZ, !kVar.aMa);
                        if (kVar.aLZ == 5 && eM(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aMb, kVar.id, kVar.aLj);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aLY - kVar3.aLY;
                }
            });
            if (linkedList.size() > this.aLy) {
                if (this.aLG) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aLC > 0 && iVar.aLj != null && (iVar.aLj instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aLj).setBackgroundColorId(this.aLC);
                }
                if (this.aLz > 0) {
                    iVar.aLW = this.aLz;
                }
                b(iVar);
                iVar.aLj.setToolId(iVar.id);
                iVar.aLj.setEditorTools(this);
                a(iVar.aMb, iVar.id, iVar.aLj);
                this.aLt.a(iVar.aLj);
                if (this.aLA) {
                    linkedList.add(this.aLy, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aLy + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aLs.a(a(kVar2, 1));
                } else {
                    this.aLt.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aLs.a(0, a);
            }
            this.aLs.Hh();
            this.aLt.Hh();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aLs.setLayoutParams(layoutParams);
            this.aLt.setLayoutParams(layoutParams);
            this.aLt.hide();
            if (this.aLG) {
                this.aLs.setPadding(0, 0, 0, 0);
            }
            FB();
            removeAllViews();
            addView(this.aLs);
            addView(this.aLt);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aLs != null) {
                this.aLs.a(0, a);
                this.aLs.removeAllViews();
                this.aLs.Hh();
            }
            invalidate();
        }
    }

    public k eM(int i) {
        for (k kVar : this.aLu) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aLu;
    }

    public g eJ(int i) {
        g eJ = this.aLs.eJ(i);
        if (eJ == null) {
            return this.aLt.eJ(i);
        }
        return eJ;
    }

    public void Hp() {
        this.aLs.d(this.aLH);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aLH);
        }
        return a;
    }

    public void bD(boolean z) {
        for (k kVar : this.aLu) {
            if (kVar != null && (kVar.aLj instanceof View) && ((View) kVar.aLj).getVisibility() == 0 && !kVar.aMa) {
                kVar.aLj.oD();
            }
        }
        if (this.aLD) {
            this.aLD = false;
            FB();
        }
        if (!Hj() && z) {
            com.baidu.adp.lib.g.e.im().postDelayed(this.aLI, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void oD() {
        bD(true);
    }

    public void hide() {
        FB();
        setVisibility(8);
        Ho();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void FB() {
        this.aLt.hide();
        this.aLs.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aLs.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aLs.setBarLauncherEnabled(z, i);
    }

    public boolean Hj() {
        return this.aLt.Hj();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aLz = i;
    }

    public void setBarLauncherType(int i) {
        this.aLs.setBarLauncherType(i);
    }

    public void bB(boolean z) {
        this.aLs.bB(z);
    }

    public void bC(boolean z) {
        this.aLs.bC(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aLA = z;
    }

    public void setBackgroundColorId(int i) {
        this.aLB = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aLC = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void M(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k eM = eM(toolId);
            if (eM.oR()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.aLs.a(eM);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    oD();
                    b(new a(1, 3, null));
                } else if (eM.aLj == null) {
                    if (eM.aMb != null && eM.aMb.length > 0) {
                        b(new a(eM.aMb[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Hq() {
        this.aLs.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
