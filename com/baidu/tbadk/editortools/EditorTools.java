package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorTools extends LinearLayout {
    public EditorBar cqO;
    private EditorDesk cqP;
    private View cqQ;
    private List<k> cqR;
    private SparseArray<b> cqS;
    private SparseArray<HashSet<b>> cqT;
    private SparseArray<HashSet<Integer>> cqU;
    private int cqV;
    private int cqW;
    private boolean cqX;
    private int cqY;
    private int cqZ;
    private boolean cra;
    private LinkedList<g> crb;
    private boolean crd;
    private boolean cre;
    private View.OnClickListener crf;
    private Runnable crg;
    private List<Integer> crh;

    public void aqX() {
        k kj = kj(3);
        if (kj != null && (kj.cqF instanceof View)) {
            View view = (View) kj.cqF;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.cqV = 1;
        this.cqW = 0;
        this.cqX = false;
        this.cqY = R.color.common_color_10255;
        this.cqZ = 0;
        this.cra = true;
        this.crd = false;
        this.cre = false;
        this.crf = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bb(view);
            }
        };
        this.crg = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aqX();
            }
        };
        this.crh = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.crd = z;
    }

    public boolean aqY() {
        return this.crd;
    }

    public boolean aqZ() {
        return this.cre;
    }

    public void setIsFromPb(boolean z) {
        this.cre = z;
    }

    private void init(Context context) {
        this.cqR = new LinkedList();
        this.cqS = new SparseArray<>();
        this.cqT = new SparseArray<>();
        this.cqU = new SparseArray<>();
        this.cqO = new EditorBar(context, this);
        this.cqP = new EditorDesk(context, this);
        this.crb = new LinkedList<>();
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
                HashSet<b> hashSet = this.cqT.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.cqT.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.cqS.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.cqU.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.cqU.put(i3, hashSet2);
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
        k kj;
        if (aVar != null) {
            if (aVar.code == 2) {
                g kg = this.cqO.kg(aVar.id);
                if (kg != null) {
                    z = false;
                } else {
                    kg = this.cqP.kg(aVar.id);
                    z = true;
                }
                if (kg == null) {
                    Iterator<g> it = this.crb.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = kg;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (kj = kj(2)) != null && kj.cqF != null) {
                        kj.cqF.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.cqO.a((k) null);
                app();
            } else if (aVar.id > 0) {
                b bVar = this.cqS.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.cqO.ke(aVar.id);
                    }
                    k kj2 = kj(aVar.id);
                    if (kj2 != null && kj2.crx == 5) {
                        app();
                        ara();
                    } else {
                        this.cqP.ke(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.cqU.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.cqS.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.cqT.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void ara() {
        boolean z;
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.crg);
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
            k kj = kj(3);
            if (kj != null && (kj.cqF instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) kj.cqF);
            }
            k kj2 = kj(28);
            if (kj2 != null && (kj2.cqF instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) kj2.cqF);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.cqR.add(kVar);
        }
    }

    private void clear() {
        this.cqO.clear();
        this.cqP.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.cqV = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.cqO.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.cqP.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.h(this, this.cqY, i);
        this.cqO.onChangeSkinType(i);
        this.cqP.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.crh;
    }

    public void ai(List<Integer> list) {
        this.crh.clear();
        this.crh.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void aqT() {
        i iVar;
        if (this.cqR != null && this.cqR.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.cqR) {
                if (kVar.cru > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.cqF != null) {
                    kVar.cqF.setToolId(kVar.id);
                    kVar.cqF.setEditorTools(this);
                    if (kVar.crx == 6) {
                        this.cqP.a(kVar.cqF);
                    } else if (kVar.crx == 1 || kVar.crx == 2 || kVar.crx == 3 || kVar.crx == 4 || kVar.crx == 5) {
                        this.cqO.a(kVar.cqF, kVar.crx, !kVar.cry);
                        if (kVar.crx == 5 && kj(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.crz, kVar.id, kVar.cqF);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.crw - kVar3.crw;
                }
            });
            if (linkedList.size() > this.cqV) {
                if (this.cre) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.cqZ > 0 && iVar.cqF != null && (iVar.cqF instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.cqF).setBackgroundColorId(this.cqZ);
                }
                if (this.cqW > 0) {
                    iVar.cru = this.cqW;
                }
                b(iVar);
                iVar.cqF.setToolId(iVar.id);
                iVar.cqF.setEditorTools(this);
                a(iVar.crz, iVar.id, iVar.cqF);
                this.cqP.a(iVar.cqF);
                if (this.cqX) {
                    linkedList.add(this.cqV, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.cqV + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.cqO.a(a(kVar2, 1));
                } else {
                    this.cqP.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.cqO.a(0, a);
            }
            this.cqO.aqT();
            this.cqP.aqT();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.cqO.setLayoutParams(layoutParams);
            this.cqP.setLayoutParams(layoutParams);
            this.cqP.hide();
            if (this.cre) {
                this.cqO.setPadding(0, 0, 0, 0);
            }
            app();
            removeAllViews();
            if (this.cqO.getBarLauncherType() != 4) {
                arb();
            }
            addView(this.cqO);
            addView(this.cqP);
            invalidate();
        }
    }

    private void arb() {
        if (this.cqQ == null || this.cqQ.getParent() != null) {
            this.cqQ = new View(getContext());
            this.cqQ.setBackgroundResource(R.drawable.bottom_shadow);
            this.cqQ.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16)));
        }
        addView(this.cqQ);
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.cqO != null) {
                this.cqO.a(0, a);
                this.cqO.removeAllViews();
                this.cqO.aqT();
            }
            invalidate();
        }
    }

    public k kj(int i) {
        for (k kVar : this.cqR) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.cqR;
    }

    public g kg(int i) {
        g kg = this.cqO.kg(i);
        if (kg == null) {
            return this.cqP.kg(i);
        }
        return kg;
    }

    public void arc() {
        this.cqO.f(this.crf);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.crf);
        }
        return a;
    }

    public void ff(boolean z) {
        for (k kVar : this.cqR) {
            if (kVar != null && (kVar.cqF instanceof View) && ((View) kVar.cqF).getVisibility() == 0 && !kVar.cry) {
                kVar.cqF.pO();
            }
        }
        if (this.cra) {
            this.cra = false;
            app();
        }
        if (!aqV() && z) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.crg, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void pO() {
        ff(true);
    }

    public void hide() {
        app();
        setVisibility(8);
        ara();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void app() {
        this.cqP.hide();
        this.cqO.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.cqO.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.cqO.setBarLauncherEnabled(z, i);
    }

    public boolean aqV() {
        return this.cqP.aqV();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.cqW = i;
    }

    public void setBarLauncherType(int i) {
        this.cqO.setBarLauncherType(i);
    }

    public void fd(boolean z) {
        this.cqO.fd(z);
    }

    public void fe(boolean z) {
        this.cqO.fe(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.cqX = z;
    }

    public void setBackgroundColorId(int i) {
        this.cqY = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.cqZ = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bb(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k kj = kj(toolId);
            if (kj.qd()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.cqO.a(kj);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    pO();
                    b(new a(1, 3, null));
                } else if (kj.cqF == null) {
                    if (kj.crz != null && kj.crz.length > 0) {
                        b(new a(kj.crz[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void ard() {
        this.cqO.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
