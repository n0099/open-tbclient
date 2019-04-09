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
    public EditorBar ciG;
    private EditorDesk ciH;
    private View ciI;
    private List<k> ciJ;
    private SparseArray<b> ciK;
    private SparseArray<HashSet<b>> ciL;
    private SparseArray<HashSet<Integer>> ciM;
    private int ciN;
    private int ciO;
    private boolean ciP;
    private int ciQ;
    private int ciR;
    private boolean ciS;
    private LinkedList<g> ciT;
    private boolean ciU;
    private boolean ciV;
    private View.OnClickListener ciW;
    private Runnable ciX;
    private List<Integer> ciY;

    public void alU() {
        k jv = jv(3);
        if (jv != null && (jv.cix instanceof View)) {
            View view = (View) jv.cix;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.ciN = 1;
        this.ciO = 0;
        this.ciP = false;
        this.ciQ = d.C0277d.common_color_10255;
        this.ciR = 0;
        this.ciS = true;
        this.ciU = false;
        this.ciV = false;
        this.ciW = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.aV(view);
            }
        };
        this.ciX = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.alU();
            }
        };
        this.ciY = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.ciU = z;
    }

    public boolean alV() {
        return this.ciU;
    }

    public boolean alW() {
        return this.ciV;
    }

    public void setIsFromPb(boolean z) {
        this.ciV = z;
    }

    private void init(Context context) {
        this.ciJ = new LinkedList();
        this.ciK = new SparseArray<>();
        this.ciL = new SparseArray<>();
        this.ciM = new SparseArray<>();
        this.ciG = new EditorBar(context, this);
        this.ciH = new EditorDesk(context, this);
        this.ciT = new LinkedList<>();
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
                HashSet<b> hashSet = this.ciL.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.ciL.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.ciK.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.ciM.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.ciM.put(i3, hashSet2);
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
        k jv;
        if (aVar != null) {
            if (aVar.code == 2) {
                g js = this.ciG.js(aVar.id);
                if (js != null) {
                    z = false;
                } else {
                    js = this.ciH.js(aVar.id);
                    z = true;
                }
                if (js == null) {
                    Iterator<g> it = this.ciT.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = js;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (jv = jv(2)) != null && jv.cix != null) {
                        jv.cix.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.ciG.a((k) null);
                akm();
            } else if (aVar.id > 0) {
                b bVar = this.ciK.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.ciG.jq(aVar.id);
                    }
                    k jv2 = jv(aVar.id);
                    if (jv2 != null && jv2.cjo == 5) {
                        akm();
                        alX();
                    } else {
                        this.ciH.jq(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.ciM.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.ciK.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.ciL.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void alX() {
        boolean z;
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.ciX);
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
            k jv = jv(3);
            if (jv != null && (jv.cix instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) jv.cix);
            }
            k jv2 = jv(28);
            if (jv2 != null && (jv2.cix instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) jv2.cix);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.ciJ.add(kVar);
        }
    }

    private void clear() {
        this.ciG.clear();
        this.ciH.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.ciN = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.ciG.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.ciH.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.f(this, this.ciQ, i);
        this.ciG.onChangeSkinType(i);
        this.ciH.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.ciY;
    }

    public void ab(List<Integer> list) {
        this.ciY.clear();
        this.ciY.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void alQ() {
        i iVar;
        if (this.ciJ != null && this.ciJ.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.ciJ) {
                if (kVar.cjl > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.cix != null) {
                    kVar.cix.setToolId(kVar.id);
                    kVar.cix.setEditorTools(this);
                    if (kVar.cjo == 6) {
                        this.ciH.a(kVar.cix);
                    } else if (kVar.cjo == 1 || kVar.cjo == 2 || kVar.cjo == 3 || kVar.cjo == 4 || kVar.cjo == 5) {
                        this.ciG.a(kVar.cix, kVar.cjo, !kVar.cjp);
                        if (kVar.cjo == 5 && jv(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.cjq, kVar.id, kVar.cix);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.cjn - kVar3.cjn;
                }
            });
            if (linkedList.size() > this.ciN) {
                if (this.ciV) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.ciR > 0 && iVar.cix != null && (iVar.cix instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.cix).setBackgroundColorId(this.ciR);
                }
                if (this.ciO > 0) {
                    iVar.cjl = this.ciO;
                }
                b(iVar);
                iVar.cix.setToolId(iVar.id);
                iVar.cix.setEditorTools(this);
                a(iVar.cjq, iVar.id, iVar.cix);
                this.ciH.a(iVar.cix);
                if (this.ciP) {
                    linkedList.add(this.ciN, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.ciN + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.ciG.a(a(kVar2, 1));
                } else {
                    this.ciH.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.ciG.a(0, a);
            }
            this.ciG.alQ();
            this.ciH.alQ();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.ciG.setLayoutParams(layoutParams);
            this.ciH.setLayoutParams(layoutParams);
            this.ciH.hide();
            if (this.ciV) {
                this.ciG.setPadding(0, 0, 0, 0);
            }
            akm();
            removeAllViews();
            if (this.ciG.getBarLauncherType() != 4) {
                alY();
            }
            addView(this.ciG);
            addView(this.ciH);
            invalidate();
        }
    }

    private void alY() {
        if (this.ciI == null || this.ciI.getParent() != null) {
            this.ciI = new View(getContext());
            this.ciI.setBackgroundResource(d.f.bottom_shadow);
            this.ciI.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds16)));
        }
        addView(this.ciI);
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.ciG != null) {
                this.ciG.a(0, a);
                this.ciG.removeAllViews();
                this.ciG.alQ();
            }
            invalidate();
        }
    }

    public k jv(int i) {
        for (k kVar : this.ciJ) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.ciJ;
    }

    public g js(int i) {
        g js = this.ciG.js(i);
        if (js == null) {
            return this.ciH.js(i);
        }
        return js;
    }

    public void alZ() {
        this.ciG.f(this.ciW);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.ciW);
        }
        return a;
    }

    public void eJ(boolean z) {
        for (k kVar : this.ciJ) {
            if (kVar != null && (kVar.cix instanceof View) && ((View) kVar.cix).getVisibility() == 0 && !kVar.cjp) {
                kVar.cix.qT();
            }
        }
        if (this.ciS) {
            this.ciS = false;
            akm();
        }
        if (!alS() && z) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.ciX, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void qT() {
        eJ(true);
    }

    public void hide() {
        akm();
        setVisibility(8);
        alX();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void akm() {
        this.ciH.hide();
        this.ciG.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.ciG.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.ciG.setBarLauncherEnabled(z, i);
    }

    public boolean alS() {
        return this.ciH.alS();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.ciO = i;
    }

    public void setBarLauncherType(int i) {
        this.ciG.setBarLauncherType(i);
    }

    public void eH(boolean z) {
        this.ciG.eH(z);
    }

    public void eI(boolean z) {
        this.ciG.eI(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.ciP = z;
    }

    public void setBackgroundColorId(int i) {
        this.ciQ = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.ciR = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void aV(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k jv = jv(toolId);
            if (jv.ri()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.ciG.a(jv);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    qT();
                    b(new a(1, 3, null));
                } else if (jv.cix == null) {
                    if (jv.cjq != null && jv.cjq.length > 0) {
                        b(new a(jv.cjq[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void ama() {
        this.ciG.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
