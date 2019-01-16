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
    public EditorBar aZe;
    private EditorDesk aZf;
    private List<k> aZg;
    private SparseArray<b> aZh;
    private SparseArray<HashSet<b>> aZi;
    private SparseArray<HashSet<Integer>> aZj;
    private int aZk;
    private int aZl;
    private boolean aZm;
    private int aZn;
    private int aZo;
    private boolean aZp;
    private LinkedList<g> aZq;
    private boolean aZr;
    private boolean aZs;
    private View.OnClickListener aZt;
    private Runnable aZu;
    private List<Integer> aZv;

    public void Mu() {
        k fL = fL(3);
        if (fL != null && (fL.aYV instanceof View)) {
            View view = (View) fL.aYV;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aZk = 1;
        this.aZl = 0;
        this.aZm = false;
        this.aZn = e.d.common_color_10255;
        this.aZo = 0;
        this.aZp = true;
        this.aZr = false;
        this.aZs = false;
        this.aZt = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.aa(view);
            }
        };
        this.aZu = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.Mu();
            }
        };
        this.aZv = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aZr = z;
    }

    public boolean Mv() {
        return this.aZr;
    }

    public boolean Mw() {
        return this.aZs;
    }

    public void setIsFromPb(boolean z) {
        this.aZs = z;
    }

    private void init(Context context) {
        this.aZg = new LinkedList();
        this.aZh = new SparseArray<>();
        this.aZi = new SparseArray<>();
        this.aZj = new SparseArray<>();
        this.aZe = new EditorBar(context, this);
        this.aZf = new EditorDesk(context, this);
        this.aZq = new LinkedList<>();
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
                HashSet<b> hashSet = this.aZi.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aZi.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aZh.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aZj.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aZj.put(i3, hashSet2);
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
                g fI = this.aZe.fI(aVar.id);
                if (fI != null) {
                    z = false;
                } else {
                    fI = this.aZf.fI(aVar.id);
                    z = true;
                }
                if (fI == null) {
                    Iterator<g> it = this.aZq.iterator();
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
                    if (z && (fL = fL(2)) != null && fL.aYV != null) {
                        fL.aYV.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aZe.a((k) null);
                KM();
            } else if (aVar.id > 0) {
                b bVar = this.aZh.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aZe.fG(aVar.id);
                    }
                    k fL2 = fL(aVar.id);
                    if (fL2 != null && fL2.aZL == 5) {
                        KM();
                        Mx();
                    } else {
                        this.aZf.fG(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aZj.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aZh.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aZi.get(aVar.code);
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aZu);
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
            if (fL != null && (fL.aYV instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) fL.aYV);
            }
            k fL2 = fL(28);
            if (fL2 != null && (fL2.aYV instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) fL2.aYV);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aZg.add(kVar);
        }
    }

    private void clear() {
        this.aZe.clear();
        this.aZf.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aZk = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aZe.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aZf.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.e(this, this.aZn, i);
        this.aZe.onChangeSkinType(i);
        this.aZf.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aZv;
    }

    public void w(List<Integer> list) {
        this.aZv.clear();
        this.aZv.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void Mq() {
        i iVar;
        if (this.aZg != null && this.aZg.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aZg) {
                if (kVar.aZI > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aYV != null) {
                    kVar.aYV.setToolId(kVar.id);
                    kVar.aYV.setEditorTools(this);
                    if (kVar.aZL == 6) {
                        this.aZf.a(kVar.aYV);
                    } else if (kVar.aZL == 1 || kVar.aZL == 2 || kVar.aZL == 3 || kVar.aZL == 4 || kVar.aZL == 5) {
                        this.aZe.a(kVar.aYV, kVar.aZL, !kVar.aZM);
                        if (kVar.aZL == 5 && fL(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aZN, kVar.id, kVar.aYV);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aZK - kVar3.aZK;
                }
            });
            if (linkedList.size() > this.aZk) {
                if (this.aZs) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aZo > 0 && iVar.aYV != null && (iVar.aYV instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aYV).setBackgroundColorId(this.aZo);
                }
                if (this.aZl > 0) {
                    iVar.aZI = this.aZl;
                }
                b(iVar);
                iVar.aYV.setToolId(iVar.id);
                iVar.aYV.setEditorTools(this);
                a(iVar.aZN, iVar.id, iVar.aYV);
                this.aZf.a(iVar.aYV);
                if (this.aZm) {
                    linkedList.add(this.aZk, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aZk + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aZe.a(a(kVar2, 1));
                } else {
                    this.aZf.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aZe.a(0, a);
            }
            this.aZe.Mq();
            this.aZf.Mq();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aZe.setLayoutParams(layoutParams);
            this.aZf.setLayoutParams(layoutParams);
            this.aZf.hide();
            if (this.aZs) {
                this.aZe.setPadding(0, 0, 0, 0);
            }
            KM();
            removeAllViews();
            addView(this.aZe);
            addView(this.aZf);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aZe != null) {
                this.aZe.a(0, a);
                this.aZe.removeAllViews();
                this.aZe.Mq();
            }
            invalidate();
        }
    }

    public k fL(int i) {
        for (k kVar : this.aZg) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aZg;
    }

    public g fI(int i) {
        g fI = this.aZe.fI(i);
        if (fI == null) {
            return this.aZf.fI(i);
        }
        return fI;
    }

    public void My() {
        this.aZe.e(this.aZt);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aZt);
        }
        return a;
    }

    public void cv(boolean z) {
        for (k kVar : this.aZg) {
            if (kVar != null && (kVar.aYV instanceof View) && ((View) kVar.aYV).getVisibility() == 0 && !kVar.aZM) {
                kVar.aYV.pR();
            }
        }
        if (this.aZp) {
            this.aZp = false;
            KM();
        }
        if (!Ms() && z) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.aZu, 200L);
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
        this.aZf.hide();
        this.aZe.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aZe.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aZe.setBarLauncherEnabled(z, i);
    }

    public boolean Ms() {
        return this.aZf.Ms();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aZl = i;
    }

    public void setBarLauncherType(int i) {
        this.aZe.setBarLauncherType(i);
    }

    public void ct(boolean z) {
        this.aZe.ct(z);
    }

    public void cu(boolean z) {
        this.aZe.cu(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aZm = z;
    }

    public void setBackgroundColorId(int i) {
        this.aZn = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aZo = i;
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
                this.aZe.a(fL);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    pR();
                    b(new a(1, 3, null));
                } else if (fL.aYV == null) {
                    if (fL.aZN != null && fL.aZN.length > 0) {
                        b(new a(fL.aZN[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Mz() {
        this.aZe.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
