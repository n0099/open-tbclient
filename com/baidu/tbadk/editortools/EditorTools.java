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
    public EditorBar ciD;
    private EditorDesk ciE;
    private View ciF;
    private List<k> ciG;
    private SparseArray<b> ciH;
    private SparseArray<HashSet<b>> ciI;
    private SparseArray<HashSet<Integer>> ciJ;
    private int ciK;
    private int ciL;
    private boolean ciM;
    private int ciN;
    private int ciO;
    private boolean ciP;
    private LinkedList<g> ciQ;
    private boolean ciR;
    private boolean ciS;
    private View.OnClickListener ciT;
    private Runnable ciU;
    private List<Integer> ciV;

    public void alX() {
        k jw = jw(3);
        if (jw != null && (jw.ciu instanceof View)) {
            View view = (View) jw.ciu;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.ciK = 1;
        this.ciL = 0;
        this.ciM = false;
        this.ciN = d.C0277d.common_color_10255;
        this.ciO = 0;
        this.ciP = true;
        this.ciR = false;
        this.ciS = false;
        this.ciT = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.aV(view);
            }
        };
        this.ciU = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.alX();
            }
        };
        this.ciV = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.ciR = z;
    }

    public boolean alY() {
        return this.ciR;
    }

    public boolean alZ() {
        return this.ciS;
    }

    public void setIsFromPb(boolean z) {
        this.ciS = z;
    }

    private void init(Context context) {
        this.ciG = new LinkedList();
        this.ciH = new SparseArray<>();
        this.ciI = new SparseArray<>();
        this.ciJ = new SparseArray<>();
        this.ciD = new EditorBar(context, this);
        this.ciE = new EditorDesk(context, this);
        this.ciQ = new LinkedList<>();
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
                HashSet<b> hashSet = this.ciI.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.ciI.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.ciH.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.ciJ.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.ciJ.put(i3, hashSet2);
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
        k jw;
        if (aVar != null) {
            if (aVar.code == 2) {
                g jt = this.ciD.jt(aVar.id);
                if (jt != null) {
                    z = false;
                } else {
                    jt = this.ciE.jt(aVar.id);
                    z = true;
                }
                if (jt == null) {
                    Iterator<g> it = this.ciQ.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = jt;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (jw = jw(2)) != null && jw.ciu != null) {
                        jw.ciu.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.ciD.a((k) null);
                akp();
            } else if (aVar.id > 0) {
                b bVar = this.ciH.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.ciD.jr(aVar.id);
                    }
                    k jw2 = jw(aVar.id);
                    if (jw2 != null && jw2.cjl == 5) {
                        akp();
                        ama();
                    } else {
                        this.ciE.jr(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.ciJ.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.ciH.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.ciI.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void ama() {
        boolean z;
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.ciU);
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
            k jw = jw(3);
            if (jw != null && (jw.ciu instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) jw.ciu);
            }
            k jw2 = jw(28);
            if (jw2 != null && (jw2.ciu instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) jw2.ciu);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.ciG.add(kVar);
        }
    }

    private void clear() {
        this.ciD.clear();
        this.ciE.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.ciK = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.ciD.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.ciE.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.f(this, this.ciN, i);
        this.ciD.onChangeSkinType(i);
        this.ciE.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.ciV;
    }

    public void ab(List<Integer> list) {
        this.ciV.clear();
        this.ciV.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void alT() {
        i iVar;
        if (this.ciG != null && this.ciG.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.ciG) {
                if (kVar.cji > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.ciu != null) {
                    kVar.ciu.setToolId(kVar.id);
                    kVar.ciu.setEditorTools(this);
                    if (kVar.cjl == 6) {
                        this.ciE.a(kVar.ciu);
                    } else if (kVar.cjl == 1 || kVar.cjl == 2 || kVar.cjl == 3 || kVar.cjl == 4 || kVar.cjl == 5) {
                        this.ciD.a(kVar.ciu, kVar.cjl, !kVar.cjm);
                        if (kVar.cjl == 5 && jw(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.cjn, kVar.id, kVar.ciu);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.cjk - kVar3.cjk;
                }
            });
            if (linkedList.size() > this.ciK) {
                if (this.ciS) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.ciO > 0 && iVar.ciu != null && (iVar.ciu instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.ciu).setBackgroundColorId(this.ciO);
                }
                if (this.ciL > 0) {
                    iVar.cji = this.ciL;
                }
                b(iVar);
                iVar.ciu.setToolId(iVar.id);
                iVar.ciu.setEditorTools(this);
                a(iVar.cjn, iVar.id, iVar.ciu);
                this.ciE.a(iVar.ciu);
                if (this.ciM) {
                    linkedList.add(this.ciK, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.ciK + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.ciD.a(a(kVar2, 1));
                } else {
                    this.ciE.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.ciD.a(0, a);
            }
            this.ciD.alT();
            this.ciE.alT();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.ciD.setLayoutParams(layoutParams);
            this.ciE.setLayoutParams(layoutParams);
            this.ciE.hide();
            if (this.ciS) {
                this.ciD.setPadding(0, 0, 0, 0);
            }
            akp();
            removeAllViews();
            if (this.ciD.getBarLauncherType() != 4) {
                amb();
            }
            addView(this.ciD);
            addView(this.ciE);
            invalidate();
        }
    }

    private void amb() {
        if (this.ciF == null || this.ciF.getParent() != null) {
            this.ciF = new View(getContext());
            this.ciF.setBackgroundResource(d.f.bottom_shadow);
            this.ciF.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds16)));
        }
        addView(this.ciF);
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.ciD != null) {
                this.ciD.a(0, a);
                this.ciD.removeAllViews();
                this.ciD.alT();
            }
            invalidate();
        }
    }

    public k jw(int i) {
        for (k kVar : this.ciG) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.ciG;
    }

    public g jt(int i) {
        g jt = this.ciD.jt(i);
        if (jt == null) {
            return this.ciE.jt(i);
        }
        return jt;
    }

    public void amc() {
        this.ciD.f(this.ciT);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.ciT);
        }
        return a;
    }

    public void eJ(boolean z) {
        for (k kVar : this.ciG) {
            if (kVar != null && (kVar.ciu instanceof View) && ((View) kVar.ciu).getVisibility() == 0 && !kVar.cjm) {
                kVar.ciu.qT();
            }
        }
        if (this.ciP) {
            this.ciP = false;
            akp();
        }
        if (!alV() && z) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.ciU, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void qT() {
        eJ(true);
    }

    public void hide() {
        akp();
        setVisibility(8);
        ama();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void akp() {
        this.ciE.hide();
        this.ciD.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.ciD.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.ciD.setBarLauncherEnabled(z, i);
    }

    public boolean alV() {
        return this.ciE.alV();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.ciL = i;
    }

    public void setBarLauncherType(int i) {
        this.ciD.setBarLauncherType(i);
    }

    public void eH(boolean z) {
        this.ciD.eH(z);
    }

    public void eI(boolean z) {
        this.ciD.eI(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.ciM = z;
    }

    public void setBackgroundColorId(int i) {
        this.ciN = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.ciO = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void aV(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k jw = jw(toolId);
            if (jw.ri()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.ciD.a(jw);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    qT();
                    b(new a(1, 3, null));
                } else if (jw.ciu == null) {
                    if (jw.cjn != null && jw.cjn.length > 0) {
                        b(new a(jw.cjn[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void amd() {
        this.ciD.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
