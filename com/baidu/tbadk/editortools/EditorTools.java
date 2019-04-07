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
    public EditorBar ciF;
    private EditorDesk ciG;
    private View ciH;
    private List<k> ciI;
    private SparseArray<b> ciJ;
    private SparseArray<HashSet<b>> ciK;
    private SparseArray<HashSet<Integer>> ciL;
    private int ciM;
    private int ciN;
    private boolean ciO;
    private int ciP;
    private int ciQ;
    private boolean ciR;
    private LinkedList<g> ciS;
    private boolean ciT;
    private boolean ciU;
    private View.OnClickListener ciV;
    private Runnable ciW;
    private List<Integer> ciX;

    public void alU() {
        k jv = jv(3);
        if (jv != null && (jv.ciw instanceof View)) {
            View view = (View) jv.ciw;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.ciM = 1;
        this.ciN = 0;
        this.ciO = false;
        this.ciP = d.C0277d.common_color_10255;
        this.ciQ = 0;
        this.ciR = true;
        this.ciT = false;
        this.ciU = false;
        this.ciV = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.aV(view);
            }
        };
        this.ciW = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.alU();
            }
        };
        this.ciX = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.ciT = z;
    }

    public boolean alV() {
        return this.ciT;
    }

    public boolean alW() {
        return this.ciU;
    }

    public void setIsFromPb(boolean z) {
        this.ciU = z;
    }

    private void init(Context context) {
        this.ciI = new LinkedList();
        this.ciJ = new SparseArray<>();
        this.ciK = new SparseArray<>();
        this.ciL = new SparseArray<>();
        this.ciF = new EditorBar(context, this);
        this.ciG = new EditorDesk(context, this);
        this.ciS = new LinkedList<>();
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
                HashSet<b> hashSet = this.ciK.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.ciK.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.ciJ.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.ciL.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.ciL.put(i3, hashSet2);
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
                g js = this.ciF.js(aVar.id);
                if (js != null) {
                    z = false;
                } else {
                    js = this.ciG.js(aVar.id);
                    z = true;
                }
                if (js == null) {
                    Iterator<g> it = this.ciS.iterator();
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
                    if (z && (jv = jv(2)) != null && jv.ciw != null) {
                        jv.ciw.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.ciF.a((k) null);
                akm();
            } else if (aVar.id > 0) {
                b bVar = this.ciJ.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.ciF.jq(aVar.id);
                    }
                    k jv2 = jv(aVar.id);
                    if (jv2 != null && jv2.cjn == 5) {
                        akm();
                        alX();
                    } else {
                        this.ciG.jq(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.ciL.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.ciJ.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.ciK.get(aVar.code);
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
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.ciW);
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
            if (jv != null && (jv.ciw instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) jv.ciw);
            }
            k jv2 = jv(28);
            if (jv2 != null && (jv2.ciw instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) jv2.ciw);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.ciI.add(kVar);
        }
    }

    private void clear() {
        this.ciF.clear();
        this.ciG.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.ciM = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.ciF.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.ciG.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.f(this, this.ciP, i);
        this.ciF.onChangeSkinType(i);
        this.ciG.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.ciX;
    }

    public void ab(List<Integer> list) {
        this.ciX.clear();
        this.ciX.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void alQ() {
        i iVar;
        if (this.ciI != null && this.ciI.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.ciI) {
                if (kVar.cjk > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.ciw != null) {
                    kVar.ciw.setToolId(kVar.id);
                    kVar.ciw.setEditorTools(this);
                    if (kVar.cjn == 6) {
                        this.ciG.a(kVar.ciw);
                    } else if (kVar.cjn == 1 || kVar.cjn == 2 || kVar.cjn == 3 || kVar.cjn == 4 || kVar.cjn == 5) {
                        this.ciF.a(kVar.ciw, kVar.cjn, !kVar.cjo);
                        if (kVar.cjn == 5 && jv(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.cjp, kVar.id, kVar.ciw);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.cjm - kVar3.cjm;
                }
            });
            if (linkedList.size() > this.ciM) {
                if (this.ciU) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.ciQ > 0 && iVar.ciw != null && (iVar.ciw instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.ciw).setBackgroundColorId(this.ciQ);
                }
                if (this.ciN > 0) {
                    iVar.cjk = this.ciN;
                }
                b(iVar);
                iVar.ciw.setToolId(iVar.id);
                iVar.ciw.setEditorTools(this);
                a(iVar.cjp, iVar.id, iVar.ciw);
                this.ciG.a(iVar.ciw);
                if (this.ciO) {
                    linkedList.add(this.ciM, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.ciM + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.ciF.a(a(kVar2, 1));
                } else {
                    this.ciG.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.ciF.a(0, a);
            }
            this.ciF.alQ();
            this.ciG.alQ();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.ciF.setLayoutParams(layoutParams);
            this.ciG.setLayoutParams(layoutParams);
            this.ciG.hide();
            if (this.ciU) {
                this.ciF.setPadding(0, 0, 0, 0);
            }
            akm();
            removeAllViews();
            if (this.ciF.getBarLauncherType() != 4) {
                alY();
            }
            addView(this.ciF);
            addView(this.ciG);
            invalidate();
        }
    }

    private void alY() {
        if (this.ciH == null || this.ciH.getParent() != null) {
            this.ciH = new View(getContext());
            this.ciH.setBackgroundResource(d.f.bottom_shadow);
            this.ciH.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds16)));
        }
        addView(this.ciH);
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.ciF != null) {
                this.ciF.a(0, a);
                this.ciF.removeAllViews();
                this.ciF.alQ();
            }
            invalidate();
        }
    }

    public k jv(int i) {
        for (k kVar : this.ciI) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.ciI;
    }

    public g js(int i) {
        g js = this.ciF.js(i);
        if (js == null) {
            return this.ciG.js(i);
        }
        return js;
    }

    public void alZ() {
        this.ciF.f(this.ciV);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.ciV);
        }
        return a;
    }

    public void eJ(boolean z) {
        for (k kVar : this.ciI) {
            if (kVar != null && (kVar.ciw instanceof View) && ((View) kVar.ciw).getVisibility() == 0 && !kVar.cjo) {
                kVar.ciw.qT();
            }
        }
        if (this.ciR) {
            this.ciR = false;
            akm();
        }
        if (!alS() && z) {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.ciW, 200L);
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
        this.ciG.hide();
        this.ciF.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.ciF.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.ciF.setBarLauncherEnabled(z, i);
    }

    public boolean alS() {
        return this.ciG.alS();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.ciN = i;
    }

    public void setBarLauncherType(int i) {
        this.ciF.setBarLauncherType(i);
    }

    public void eH(boolean z) {
        this.ciF.eH(z);
    }

    public void eI(boolean z) {
        this.ciF.eI(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.ciO = z;
    }

    public void setBackgroundColorId(int i) {
        this.ciP = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.ciQ = i;
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
                this.ciF.a(jv);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    qT();
                    b(new a(1, 3, null));
                } else if (jv.ciw == null) {
                    if (jv.cjp != null && jv.cjp.length > 0) {
                        b(new a(jv.cjp[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void ama() {
        this.ciF.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
