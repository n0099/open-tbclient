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
    private g ayQ;
    private h ayR;
    private List<x> ayS;
    private SparseArray<b> ayT;
    private SparseArray<HashSet<b>> ayU;
    private SparseArray<HashSet<Integer>> ayV;
    private int ayW;
    private int ayX;
    private boolean ayY;
    private int ayZ;
    private int aza;
    private boolean azb;
    private LinkedList<p> azc;
    private View.OnClickListener azd;
    private Runnable aze;
    private List<Integer> azf;

    public void CU() {
        x ey = ey(3);
        if (ey != null && (ey.ayH instanceof View)) {
            View view = (View) ey.ayH;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
        }
    }

    public j(Context context) {
        super(context);
        this.ayW = 1;
        this.ayX = 0;
        this.ayY = false;
        this.ayZ = w.e.common_color_10255;
        this.aza = 0;
        this.azb = true;
        this.azd = new k(this);
        this.aze = new l(this);
        this.azf = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.ayS = new LinkedList();
        this.ayT = new SparseArray<>();
        this.ayU = new SparseArray<>();
        this.ayV = new SparseArray<>();
        this.ayQ = new g(context, this);
        this.ayR = new h(context, this);
        this.azc = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.ayU.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.ayU.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.ayT.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.ayV.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.ayV.put(i3, hashSet2);
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
                p ew = this.ayQ.ew(aVar.id);
                if (ew != null) {
                    z = false;
                } else {
                    ew = this.ayR.ew(aVar.id);
                    z = true;
                }
                if (ew == null) {
                    Iterator<p> it = this.azc.iterator();
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
                    if (z && (ey = ey(2)) != null && ey.ayH != null) {
                        ey.ayH.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.ayQ.a((x) null);
                this.ayR.hide();
            } else if (aVar.id > 0) {
                b bVar = this.ayT.get(aVar.id);
                if (bVar != null) {
                    this.ayQ.eu(aVar.id);
                    x ey2 = ey(aVar.id);
                    if (ey2 != null && ey2.azu == 5) {
                        this.ayR.hide();
                        CV();
                    } else {
                        this.ayR.eu(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.ayV.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.ayT.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.ayU.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void CV() {
        boolean z;
        x ey;
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.aze);
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
        if (!z && (ey = ey(3)) != null && (ey.ayH instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) ey.ayH);
        }
    }

    public void b(x xVar) {
        if (xVar != null) {
            this.ayS.add(xVar);
        }
    }

    private void clear() {
        this.ayQ.clear();
        this.ayR.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.ayW = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.ayQ.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.ayR.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aq.e(this, this.ayZ, i);
        this.ayQ.onChangeSkinType(i);
        this.ayR.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.azf;
    }

    public void u(List<Integer> list) {
        this.azf.clear();
        this.azf.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CQ() {
        if (this.ayS != null && this.ayS.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (x xVar : this.ayS) {
                if (xVar.azr > 0) {
                    linkedList.add(xVar);
                }
                if (xVar.ayH != null) {
                    xVar.ayH.setToolId(xVar.id);
                    xVar.ayH.setEditorTools(this);
                    if (xVar.azu == 6) {
                        this.ayR.a(xVar.ayH);
                    } else if (xVar.azu == 1 || xVar.azu == 2 || xVar.azu == 3 || xVar.azu == 4 || xVar.azu == 5) {
                        this.ayQ.a(xVar.ayH, xVar.azu, !xVar.azv);
                        if (xVar.azu == 5 && ey(1) == null) {
                            z = true;
                        }
                    }
                    a(xVar.azw, xVar.id, xVar.ayH);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.ayW) {
                u uVar = new u(getContext());
                if (this.aza > 0 && uVar.ayH != null && (uVar.ayH instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) uVar.ayH).setBackgroundColorId(this.aza);
                }
                if (this.ayX > 0) {
                    uVar.azr = this.ayX;
                }
                b(uVar);
                uVar.ayH.setToolId(uVar.id);
                uVar.ayH.setEditorTools(this);
                a(uVar.azw, uVar.id, uVar.ayH);
                this.ayR.a(uVar.ayH);
                if (this.ayY) {
                    linkedList.add(this.ayW, uVar);
                } else {
                    linkedList.add(0, uVar);
                }
            }
            int i = this.ayW + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                x xVar2 = (x) it.next();
                if (i2 < i) {
                    this.ayQ.a(a(xVar2, 1));
                } else {
                    this.ayR.a(a(xVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.ayQ.a(0, a);
            }
            this.ayQ.CQ();
            this.ayR.CQ();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.ayQ.setLayoutParams(layoutParams);
            this.ayR.setLayoutParams(layoutParams);
            this.ayR.hide();
            removeAllViews();
            addView(this.ayQ);
            addView(this.ayR);
            invalidate();
        }
    }

    public void c(x xVar) {
        if (xVar != null) {
            b(xVar);
            p a = a(xVar, 1);
            a.hide();
            if (this.ayQ != null) {
                this.ayQ.a(0, a);
                this.ayQ.removeAllViews();
                this.ayQ.CQ();
            }
            invalidate();
        }
    }

    public x ey(int i) {
        for (x xVar : this.ayS) {
            if (xVar.id == i) {
                return xVar;
            }
        }
        return null;
    }

    public List<x> getAllTools() {
        return this.ayS;
    }

    public p ew(int i) {
        p ew = this.ayQ.ew(i);
        if (ew == null) {
            return this.ayR.ew(i);
        }
        return ew;
    }

    public void CW() {
        this.ayQ.h(this.azd);
    }

    private p a(x xVar, int i) {
        p a = o.a(getContext(), xVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(xVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.azd);
        }
        return a;
    }

    public void bD(boolean z) {
        for (x xVar : this.ayS) {
            if (xVar != null && (xVar.ayH instanceof View) && ((View) xVar.ayH).getVisibility() == 0 && !xVar.azv) {
                xVar.ayH.ml();
            }
        }
        if (this.azb) {
            this.azb = false;
            Bd();
        }
        if (!CS() && z) {
            com.baidu.adp.lib.g.h.fM().postDelayed(this.aze, 200L);
        }
        setVisibility(0);
    }

    public void ml() {
        bD(true);
    }

    public void CX() {
        for (x xVar : this.ayS) {
            if (xVar != null && (xVar.ayH instanceof View) && ((View) xVar.ayH).getVisibility() == 0 && !xVar.azv) {
                xVar.ayH.ml();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.ayR.hide();
        setVisibility(8);
        CV();
    }

    public void Bd() {
        this.ayR.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.ayQ.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.ayQ.c(z, i);
    }

    public boolean CS() {
        return this.ayR.CS();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.ayX = i;
    }

    public void setBarLauncherType(int i) {
        this.ayQ.setBarLauncherType(i);
    }

    public void bB(boolean z) {
        this.ayQ.bB(z);
    }

    public void bC(boolean z) {
        this.ayQ.bC(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.ayY = z;
    }

    public void setBackgroundColorId(int i) {
        this.ayZ = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.aza = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void F(View view) {
        if (view instanceof p) {
            p pVar = (p) view;
            b(new a(31, 0, Integer.valueOf(pVar.getToolId())));
            this.ayQ.a(ey(pVar.getToolId()));
            if (pVar.getToolId() == 1) {
                pVar.hide();
                ml();
                b(new a(1, 3, null));
                return;
            }
            int toolId = pVar.getToolId();
            x ey = ey(toolId);
            if (ey.ayH == null) {
                if (ey.azw != null && ey.azw.length > 0) {
                    b(new a(ey.azw[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }
}
