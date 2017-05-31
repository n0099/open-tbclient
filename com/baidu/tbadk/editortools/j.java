package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private g ayS;
    private h ayT;
    private List<x> ayU;
    private SparseArray<b> ayV;
    private SparseArray<HashSet<b>> ayW;
    private SparseArray<HashSet<Integer>> ayX;
    private int ayY;
    private int ayZ;
    private boolean aza;
    private int azb;
    private int azc;
    private boolean azd;
    private LinkedList<p> aze;
    private View.OnClickListener azf;
    private Runnable azg;
    private List<Integer> azh;

    public void Cr() {
        x ey = ey(3);
        if (ey != null && (ey.ayJ instanceof View)) {
            View view = (View) ey.ayJ;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
        }
    }

    public j(Context context) {
        super(context);
        this.ayY = 1;
        this.ayZ = 0;
        this.aza = false;
        this.azb = w.e.common_color_10255;
        this.azc = 0;
        this.azd = true;
        this.azf = new k(this);
        this.azg = new l(this);
        this.azh = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.ayU = new LinkedList();
        this.ayV = new SparseArray<>();
        this.ayW = new SparseArray<>();
        this.ayX = new SparseArray<>();
        this.ayS = new g(context, this);
        this.ayT = new h(context, this);
        this.aze = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.ayW.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.ayW.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.ayV.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.ayX.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.ayX.put(i3, hashSet2);
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
        p pVar;
        x ey;
        if (aVar != null) {
            if (aVar.code == 2) {
                p ew = this.ayS.ew(aVar.id);
                if (ew != null) {
                    z = false;
                } else {
                    ew = this.ayT.ew(aVar.id);
                    z = true;
                }
                if (ew == null) {
                    Iterator<p> it = this.aze.iterator();
                    while (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                pVar = ew;
                if (pVar != null) {
                    pVar.a(aVar);
                    if (z && (ey = ey(2)) != null && ey.ayJ != null) {
                        ey.ayJ.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.ayS.a((x) null);
                this.ayT.hide();
            } else if (aVar.id > 0) {
                b bVar = this.ayV.get(aVar.id);
                if (bVar != null) {
                    this.ayS.eu(aVar.id);
                    x ey2 = ey(aVar.id);
                    if (ey2 != null && ey2.azw == 5) {
                        this.ayT.hide();
                        Cs();
                    } else {
                        this.ayT.eu(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.ayX.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.ayV.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.ayW.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Cs() {
        boolean z;
        x ey;
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.azg);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.k.b(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && (ey = ey(3)) != null && (ey.ayJ instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) ey.ayJ);
        }
    }

    public void b(x xVar) {
        if (xVar != null) {
            this.ayU.add(xVar);
        }
    }

    private void clear() {
        this.ayS.clear();
        this.ayT.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.ayY = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.ayS.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.ayT.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aq.e(this, this.azb, i);
        this.ayS.onChangeSkinType(i);
        this.ayT.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.azh;
    }

    public void v(List<Integer> list) {
        this.azh.clear();
        this.azh.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Cn() {
        if (this.ayU != null && this.ayU.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (x xVar : this.ayU) {
                if (xVar.azt > 0) {
                    linkedList.add(xVar);
                }
                if (xVar.ayJ != null) {
                    xVar.ayJ.setToolId(xVar.id);
                    xVar.ayJ.setEditorTools(this);
                    if (xVar.azw == 6) {
                        this.ayT.a(xVar.ayJ);
                    } else if (xVar.azw == 1 || xVar.azw == 2 || xVar.azw == 3 || xVar.azw == 4 || xVar.azw == 5) {
                        this.ayS.a(xVar.ayJ, xVar.azw, !xVar.azx);
                        if (xVar.azw == 5 && ey(1) == null) {
                            z = true;
                        }
                    }
                    a(xVar.azy, xVar.id, xVar.ayJ);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.ayY) {
                u uVar = new u(getContext());
                if (this.azc > 0 && uVar.ayJ != null && (uVar.ayJ instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) uVar.ayJ).setBackgroundColorId(this.azc);
                }
                if (this.ayZ > 0) {
                    uVar.azt = this.ayZ;
                }
                b(uVar);
                uVar.ayJ.setToolId(uVar.id);
                uVar.ayJ.setEditorTools(this);
                a(uVar.azy, uVar.id, uVar.ayJ);
                this.ayT.a(uVar.ayJ);
                if (this.aza) {
                    linkedList.add(this.ayY, uVar);
                } else {
                    linkedList.add(0, uVar);
                }
            }
            int i = this.ayY + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                x xVar2 = (x) it.next();
                if (i2 < i) {
                    this.ayS.a(a(xVar2, 1));
                } else {
                    this.ayT.a(a(xVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.ayS.a(0, a);
            }
            this.ayS.Cn();
            this.ayT.Cn();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.ayS.setLayoutParams(layoutParams);
            this.ayT.setLayoutParams(layoutParams);
            this.ayT.hide();
            removeAllViews();
            addView(this.ayS);
            addView(this.ayT);
            invalidate();
        }
    }

    public void c(x xVar) {
        if (xVar != null) {
            b(xVar);
            p a = a(xVar, 1);
            a.hide();
            if (this.ayS != null) {
                this.ayS.a(0, a);
                this.ayS.removeAllViews();
                this.ayS.Cn();
            }
            invalidate();
        }
    }

    public x ey(int i) {
        for (x xVar : this.ayU) {
            if (xVar.id == i) {
                return xVar;
            }
        }
        return null;
    }

    public List<x> getAllTools() {
        return this.ayU;
    }

    public p ew(int i) {
        p ew = this.ayS.ew(i);
        if (ew == null) {
            return this.ayT.ew(i);
        }
        return ew;
    }

    public void Ct() {
        this.ayS.h(this.azf);
    }

    private p a(x xVar, int i) {
        p a = o.a(getContext(), xVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(xVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.azf);
        }
        return a;
    }

    public void bC(boolean z) {
        for (x xVar : this.ayU) {
            if (xVar != null && (xVar.ayJ instanceof View) && ((View) xVar.ayJ).getVisibility() == 0 && !xVar.azx) {
                xVar.ayJ.lO();
            }
        }
        if (this.azd) {
            this.azd = false;
            AG();
        }
        if (!Cp() && z) {
            com.baidu.adp.lib.g.h.fS().postDelayed(this.azg, 200L);
        }
        setVisibility(0);
    }

    public void lO() {
        bC(true);
    }

    public void Cu() {
        for (x xVar : this.ayU) {
            if (xVar != null && (xVar.ayJ instanceof View) && ((View) xVar.ayJ).getVisibility() == 0 && !xVar.azx) {
                xVar.ayJ.lO();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.ayT.hide();
        setVisibility(8);
        Cs();
    }

    public void AG() {
        this.ayT.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.ayS.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.ayS.c(z, i);
    }

    public boolean Cp() {
        return this.ayT.Cp();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.ayZ = i;
    }

    public void setBarLauncherType(int i) {
        this.ayS.setBarLauncherType(i);
    }

    public void bA(boolean z) {
        this.ayS.bA(z);
    }

    public void bB(boolean z) {
        this.ayS.bB(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aza = z;
    }

    public void setBackgroundColorId(int i) {
        this.azb = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.azc = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void E(View view) {
        if (view instanceof p) {
            p pVar = (p) view;
            int toolId = pVar.getToolId();
            x ey = ey(toolId);
            if (ey.lX()) {
                b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
                this.ayS.a(ey);
                if (pVar.getToolId() == 1) {
                    pVar.hide();
                    lO();
                    b(new a(1, 3, null));
                } else if (ey.ayJ == null) {
                    if (ey.azy != null && ey.azy.length > 0) {
                        b(new a(ey.azy[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }
}
