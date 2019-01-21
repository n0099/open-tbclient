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
    public EditorBar aZf;
    private EditorDesk aZg;
    private List<k> aZh;
    private SparseArray<b> aZi;
    private SparseArray<HashSet<b>> aZj;
    private SparseArray<HashSet<Integer>> aZk;
    private int aZl;
    private int aZm;
    private boolean aZn;
    private int aZo;
    private int aZp;
    private boolean aZq;
    private LinkedList<g> aZr;
    private boolean aZs;
    private boolean aZt;
    private View.OnClickListener aZu;
    private Runnable aZv;
    private List<Integer> aZw;

    public void Mu() {
        k fL = fL(3);
        if (fL != null && (fL.aYW instanceof View)) {
            View view = (View) fL.aYW;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aZl = 1;
        this.aZm = 0;
        this.aZn = false;
        this.aZo = e.d.common_color_10255;
        this.aZp = 0;
        this.aZq = true;
        this.aZs = false;
        this.aZt = false;
        this.aZu = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.aa(view);
            }
        };
        this.aZv = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.Mu();
            }
        };
        this.aZw = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aZs = z;
    }

    public boolean Mv() {
        return this.aZs;
    }

    public boolean Mw() {
        return this.aZt;
    }

    public void setIsFromPb(boolean z) {
        this.aZt = z;
    }

    private void init(Context context) {
        this.aZh = new LinkedList();
        this.aZi = new SparseArray<>();
        this.aZj = new SparseArray<>();
        this.aZk = new SparseArray<>();
        this.aZf = new EditorBar(context, this);
        this.aZg = new EditorDesk(context, this);
        this.aZr = new LinkedList<>();
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
                HashSet<b> hashSet = this.aZj.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aZj.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aZi.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aZk.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aZk.put(i3, hashSet2);
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
                g fI = this.aZf.fI(aVar.id);
                if (fI != null) {
                    z = false;
                } else {
                    fI = this.aZg.fI(aVar.id);
                    z = true;
                }
                if (fI == null) {
                    Iterator<g> it = this.aZr.iterator();
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
                    if (z && (fL = fL(2)) != null && fL.aYW != null) {
                        fL.aYW.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aZf.a((k) null);
                KM();
            } else if (aVar.id > 0) {
                b bVar = this.aZi.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aZf.fG(aVar.id);
                    }
                    k fL2 = fL(aVar.id);
                    if (fL2 != null && fL2.aZM == 5) {
                        KM();
                        Mx();
                    } else {
                        this.aZg.fG(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aZk.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aZi.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aZj.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Mx() {
        boolean z;
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aZv);
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
            if (fL != null && (fL.aYW instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) fL.aYW);
            }
            k fL2 = fL(28);
            if (fL2 != null && (fL2.aYW instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) fL2.aYW);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aZh.add(kVar);
        }
    }

    private void clear() {
        this.aZf.clear();
        this.aZg.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aZl = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aZf.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aZg.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.e(this, this.aZo, i);
        this.aZf.onChangeSkinType(i);
        this.aZg.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aZw;
    }

    public void w(List<Integer> list) {
        this.aZw.clear();
        this.aZw.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void Mq() {
        i iVar;
        if (this.aZh != null && this.aZh.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aZh) {
                if (kVar.aZJ > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aYW != null) {
                    kVar.aYW.setToolId(kVar.id);
                    kVar.aYW.setEditorTools(this);
                    if (kVar.aZM == 6) {
                        this.aZg.a(kVar.aYW);
                    } else if (kVar.aZM == 1 || kVar.aZM == 2 || kVar.aZM == 3 || kVar.aZM == 4 || kVar.aZM == 5) {
                        this.aZf.a(kVar.aYW, kVar.aZM, !kVar.aZN);
                        if (kVar.aZM == 5 && fL(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aZO, kVar.id, kVar.aYW);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aZL - kVar3.aZL;
                }
            });
            if (linkedList.size() > this.aZl) {
                if (this.aZt) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aZp > 0 && iVar.aYW != null && (iVar.aYW instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aYW).setBackgroundColorId(this.aZp);
                }
                if (this.aZm > 0) {
                    iVar.aZJ = this.aZm;
                }
                b(iVar);
                iVar.aYW.setToolId(iVar.id);
                iVar.aYW.setEditorTools(this);
                a(iVar.aZO, iVar.id, iVar.aYW);
                this.aZg.a(iVar.aYW);
                if (this.aZn) {
                    linkedList.add(this.aZl, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aZl + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aZf.a(a(kVar2, 1));
                } else {
                    this.aZg.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aZf.a(0, a);
            }
            this.aZf.Mq();
            this.aZg.Mq();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aZf.setLayoutParams(layoutParams);
            this.aZg.setLayoutParams(layoutParams);
            this.aZg.hide();
            if (this.aZt) {
                this.aZf.setPadding(0, 0, 0, 0);
            }
            KM();
            removeAllViews();
            addView(this.aZf);
            addView(this.aZg);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aZf != null) {
                this.aZf.a(0, a);
                this.aZf.removeAllViews();
                this.aZf.Mq();
            }
            invalidate();
        }
    }

    public k fL(int i) {
        for (k kVar : this.aZh) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aZh;
    }

    public g fI(int i) {
        g fI = this.aZf.fI(i);
        if (fI == null) {
            return this.aZg.fI(i);
        }
        return fI;
    }

    public void My() {
        this.aZf.e(this.aZu);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aZu);
        }
        return a;
    }

    public void cv(boolean z) {
        for (k kVar : this.aZh) {
            if (kVar != null && (kVar.aYW instanceof View) && ((View) kVar.aYW).getVisibility() == 0 && !kVar.aZN) {
                kVar.aYW.pR();
            }
        }
        if (this.aZq) {
            this.aZq = false;
            KM();
        }
        if (!Ms() && z) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.aZv, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void pR() {
        cv(true);
    }

    public void hide() {
        KM();
        setVisibility(8);
        Mx();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void KM() {
        this.aZg.hide();
        this.aZf.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aZf.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aZf.setBarLauncherEnabled(z, i);
    }

    public boolean Ms() {
        return this.aZg.Ms();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aZm = i;
    }

    public void setBarLauncherType(int i) {
        this.aZf.setBarLauncherType(i);
    }

    public void ct(boolean z) {
        this.aZf.ct(z);
    }

    public void cu(boolean z) {
        this.aZf.cu(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aZn = z;
    }

    public void setBackgroundColorId(int i) {
        this.aZo = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aZp = i;
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
            if (fL.qf()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.aZf.a(fL);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    pR();
                    b(new a(1, 3, null));
                } else if (fL.aYW == null) {
                    if (fL.aZO != null && fL.aZO.length > 0) {
                        b(new a(fL.aZO[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Mz() {
        this.aZf.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
