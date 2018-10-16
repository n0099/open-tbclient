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
    public EditorBar aUe;
    private EditorDesk aUf;
    private List<k> aUg;
    private SparseArray<b> aUh;
    private SparseArray<HashSet<b>> aUi;
    private SparseArray<HashSet<Integer>> aUj;
    private int aUk;
    private int aUl;
    private boolean aUm;
    private int aUn;
    private int aUo;
    private boolean aUp;
    private LinkedList<g> aUq;
    private boolean aUr;
    private boolean aUs;
    private View.OnClickListener aUt;
    private Runnable aUu;
    private List<Integer> aUv;

    public void KM() {
        k fi = fi(3);
        if (fi != null && (fi.aTV instanceof View)) {
            View view = (View) fi.aTV;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.aUk = 1;
        this.aUl = 0;
        this.aUm = false;
        this.aUn = e.d.common_color_10255;
        this.aUo = 0;
        this.aUp = true;
        this.aUr = false;
        this.aUs = false;
        this.aUt = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.aa(view);
            }
        };
        this.aUu = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.KM();
            }
        };
        this.aUv = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.aUr = z;
    }

    public boolean KN() {
        return this.aUr;
    }

    public boolean KO() {
        return this.aUs;
    }

    public void setIsFromPb(boolean z) {
        this.aUs = z;
    }

    private void init(Context context) {
        this.aUg = new LinkedList();
        this.aUh = new SparseArray<>();
        this.aUi = new SparseArray<>();
        this.aUj = new SparseArray<>();
        this.aUe = new EditorBar(context, this);
        this.aUf = new EditorDesk(context, this);
        this.aUq = new LinkedList<>();
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
                HashSet<b> hashSet = this.aUi.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aUi.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aUh.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aUj.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aUj.put(i3, hashSet2);
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
        k fi;
        if (aVar != null) {
            if (aVar.code == 2) {
                g ff = this.aUe.ff(aVar.id);
                if (ff != null) {
                    z = false;
                } else {
                    ff = this.aUf.ff(aVar.id);
                    z = true;
                }
                if (ff == null) {
                    Iterator<g> it = this.aUq.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = ff;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (fi = fi(2)) != null && fi.aTV != null) {
                        fi.aTV.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aUe.a((k) null);
                Jg();
            } else if (aVar.id > 0) {
                b bVar = this.aUh.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.aUe.fd(aVar.id);
                    }
                    k fi2 = fi(aVar.id);
                    if (fi2 != null && fi2.aUL == 5) {
                        Jg();
                        KP();
                    } else {
                        this.aUf.fd(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aUj.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aUh.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aUi.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void KP() {
        boolean z;
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.aUu);
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
            k fi = fi(3);
            if (fi != null && (fi.aTV instanceof View)) {
                com.baidu.adp.lib.util.l.a(getContext(), (View) fi.aTV);
            }
            k fi2 = fi(28);
            if (fi2 != null && (fi2.aTV instanceof View)) {
                com.baidu.adp.lib.util.l.a(getContext(), (View) fi2.aTV);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.aUg.add(kVar);
        }
    }

    private void clear() {
        this.aUe.clear();
        this.aUf.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aUk = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aUe.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aUf.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.e(this, this.aUn, i);
        this.aUe.onChangeSkinType(i);
        this.aUf.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aUv;
    }

    public void w(List<Integer> list) {
        this.aUv.clear();
        this.aUv.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void KI() {
        i iVar;
        if (this.aUg != null && this.aUg.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.aUg) {
                if (kVar.aUI > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.aTV != null) {
                    kVar.aTV.setToolId(kVar.id);
                    kVar.aTV.setEditorTools(this);
                    if (kVar.aUL == 6) {
                        this.aUf.a(kVar.aTV);
                    } else if (kVar.aUL == 1 || kVar.aUL == 2 || kVar.aUL == 3 || kVar.aUL == 4 || kVar.aUL == 5) {
                        this.aUe.a(kVar.aTV, kVar.aUL, !kVar.aUM);
                        if (kVar.aUL == 5 && fi(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.aUN, kVar.id, kVar.aTV);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.aUK - kVar3.aUK;
                }
            });
            if (linkedList.size() > this.aUk) {
                if (this.aUs) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.aUo > 0 && iVar.aTV != null && (iVar.aTV instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.aTV).setBackgroundColorId(this.aUo);
                }
                if (this.aUl > 0) {
                    iVar.aUI = this.aUl;
                }
                b(iVar);
                iVar.aTV.setToolId(iVar.id);
                iVar.aTV.setEditorTools(this);
                a(iVar.aUN, iVar.id, iVar.aTV);
                this.aUf.a(iVar.aTV);
                if (this.aUm) {
                    linkedList.add(this.aUk, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.aUk + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.aUe.a(a(kVar2, 1));
                } else {
                    this.aUf.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.aUe.a(0, a);
            }
            this.aUe.KI();
            this.aUf.KI();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aUe.setLayoutParams(layoutParams);
            this.aUf.setLayoutParams(layoutParams);
            this.aUf.hide();
            if (this.aUs) {
                this.aUe.setPadding(0, 0, 0, 0);
            }
            Jg();
            removeAllViews();
            addView(this.aUe);
            addView(this.aUf);
            invalidate();
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.aUe != null) {
                this.aUe.a(0, a);
                this.aUe.removeAllViews();
                this.aUe.KI();
            }
            invalidate();
        }
    }

    public k fi(int i) {
        for (k kVar : this.aUg) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.aUg;
    }

    public g ff(int i) {
        g ff = this.aUe.ff(i);
        if (ff == null) {
            return this.aUf.ff(i);
        }
        return ff;
    }

    public void KQ() {
        this.aUe.d(this.aUt);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.aUt);
        }
        return a;
    }

    public void ca(boolean z) {
        for (k kVar : this.aUg) {
            if (kVar != null && (kVar.aTV instanceof View) && ((View) kVar.aTV).getVisibility() == 0 && !kVar.aUM) {
                kVar.aTV.pQ();
            }
        }
        if (this.aUp) {
            this.aUp = false;
            Jg();
        }
        if (!KK() && z) {
            com.baidu.adp.lib.g.e.jI().postDelayed(this.aUu, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void pQ() {
        ca(true);
    }

    public void hide() {
        Jg();
        setVisibility(8);
        KP();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void Jg() {
        this.aUf.hide();
        this.aUe.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aUe.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.aUe.setBarLauncherEnabled(z, i);
    }

    public boolean KK() {
        return this.aUf.KK();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aUl = i;
    }

    public void setBarLauncherType(int i) {
        this.aUe.setBarLauncherType(i);
    }

    public void bY(boolean z) {
        this.aUe.bY(z);
    }

    public void bZ(boolean z) {
        this.aUe.bZ(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aUm = z;
    }

    public void setBackgroundColorId(int i) {
        this.aUn = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aUo = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void aa(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k fi = fi(toolId);
            if (fi.qe()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.aUe.a(fi);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    pQ();
                    b(new a(1, 3, null));
                } else if (fi.aTV == null) {
                    if (fi.aUN != null && fi.aUN.length > 0) {
                        b(new a(fi.aUN[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void KR() {
        this.aUe.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
