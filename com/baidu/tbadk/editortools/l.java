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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private g auR;
    private h auS;
    private List<aa> auT;
    private SparseArray<b> auU;
    private SparseArray<HashSet<b>> auV;
    private SparseArray<HashSet<Integer>> auW;
    private int auX;
    private int auY;
    private boolean auZ;
    private int ava;
    private int avb;
    private boolean avc;
    private LinkedList<s> avd;
    private j ave;
    private View.OnClickListener avf;
    private Runnable avg;
    private Runnable avh;
    private List<Integer> avi;

    public void CV() {
        aa eB = eB(3);
        if (eB != null && (eB.auC instanceof View)) {
            View view = (View) eB.auC;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.avh, 1000L);
        }
    }

    public l(Context context) {
        super(context);
        this.auX = 1;
        this.auY = 0;
        this.auZ = false;
        this.ava = r.d.common_color_10255;
        this.avb = 0;
        this.avc = true;
        this.avf = new m(this);
        this.avg = new n(this);
        this.avh = new o(this);
        this.avi = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.auT = new LinkedList();
        this.auU = new SparseArray<>();
        this.auV = new SparseArray<>();
        this.auW = new SparseArray<>();
        this.auR = new g(context, this);
        this.auS = new h(context, this);
        this.avd = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.auV.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.auV.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.auU.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.auW.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.auW.put(i3, hashSet2);
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
        s sVar;
        aa eB;
        if (aVar != null) {
            if (aVar.code == 2) {
                s ez = this.auR.ez(aVar.id);
                if (ez != null) {
                    z = false;
                } else {
                    ez = this.auS.ez(aVar.id);
                    z = true;
                }
                if (ez == null) {
                    Iterator<s> it = this.avd.iterator();
                    while (it.hasNext()) {
                        sVar = it.next();
                        if (sVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                sVar = ez;
                if (sVar != null) {
                    sVar.a(aVar);
                    if (z && (eB = eB(2)) != null && eB.auC != null) {
                        eB.auC.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.auR.a((aa) null);
                this.auS.hide();
            } else if (aVar.id > 0) {
                b bVar = this.auU.get(aVar.id);
                if (bVar != null) {
                    this.auR.ex(aVar.id);
                    aa eB2 = eB(aVar.id);
                    if (eB2 != null && eB2.avx == 5) {
                        this.auS.hide();
                        CW();
                    } else {
                        this.auS.ex(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.auW.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.auU.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.auV.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void CW() {
        boolean z;
        aa eB;
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.avg);
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
        if (!z && (eB = eB(3)) != null && (eB.auC instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) eB.auC);
        }
    }

    public void b(aa aaVar) {
        if (aaVar != null) {
            this.auT.add(aaVar);
        }
    }

    private void clear() {
        this.auR.clear();
        this.auS.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.auX = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.auR.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.auS.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        at.e(this, this.ava, i);
        this.auR.onChangeSkinType(i);
        this.auS.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.avi;
    }

    public void y(List<Integer> list) {
        this.avi.clear();
        this.avi.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CP() {
        if (this.auT != null && this.auT.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (aa aaVar : this.auT) {
                if (aaVar.avu > 0) {
                    linkedList.add(aaVar);
                }
                if (aaVar.auC != null) {
                    aaVar.auC.setToolId(aaVar.id);
                    aaVar.auC.setEditorTools(this);
                    if (aaVar.avx == 6) {
                        this.auS.a(aaVar.auC);
                    } else if (aaVar.avx == 1 || aaVar.avx == 2 || aaVar.avx == 3 || aaVar.avx == 4 || aaVar.avx == 5) {
                        this.auR.a(aaVar.auC, aaVar.avx, !aaVar.avy);
                        if (aaVar.avx == 5 && eB(1) == null) {
                            z = true;
                        }
                    }
                    a(aaVar.avz, aaVar.id, aaVar.auC);
                }
            }
            Collections.sort(linkedList, new p(this));
            if (linkedList.size() > this.auX) {
                x xVar = new x(getContext());
                if (this.avb > 0 && xVar.auC != null && (xVar.auC instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) xVar.auC).setBackgroundColorId(this.avb);
                }
                if (this.auY > 0) {
                    xVar.avu = this.auY;
                }
                b(xVar);
                xVar.auC.setToolId(xVar.id);
                xVar.auC.setEditorTools(this);
                a(xVar.avz, xVar.id, xVar.auC);
                this.auS.a(xVar.auC);
                if (this.auZ) {
                    linkedList.add(this.auX, xVar);
                } else {
                    linkedList.add(0, xVar);
                }
            }
            int i = this.auX + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                aa aaVar2 = (aa) it.next();
                if (i2 < i) {
                    this.auR.a(a(aaVar2, 1));
                } else {
                    this.auS.a(a(aaVar2, 2));
                }
                i2++;
            }
            if (z) {
                q qVar = new q();
                b(qVar);
                s a = a(qVar, 1);
                a.hide();
                this.auR.a(0, a);
            }
            this.auR.CP();
            this.auS.CP();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.auR.setLayoutParams(layoutParams);
            this.auS.setLayoutParams(layoutParams);
            this.auS.hide();
            removeAllViews();
            addView(this.auR);
            addView(this.auS);
            invalidate();
        }
    }

    public void c(aa aaVar) {
        if (aaVar != null) {
            b(aaVar);
            s a = a(aaVar, 1);
            a.hide();
            if (this.auR != null) {
                this.auR.a(0, a);
                this.auR.removeAllViews();
                this.auR.CP();
            }
            invalidate();
        }
    }

    public aa eB(int i) {
        for (aa aaVar : this.auT) {
            if (aaVar.id == i) {
                return aaVar;
            }
        }
        return null;
    }

    public List<aa> getAllTools() {
        return this.auT;
    }

    public s ez(int i) {
        s ez = this.auR.ez(i);
        if (ez == null) {
            return this.auS.ez(i);
        }
        return ez;
    }

    public void CX() {
        this.auR.i(this.avf);
    }

    private s a(aa aaVar, int i) {
        s a = r.a(getContext(), aaVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(aaVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.avf);
        }
        return a;
    }

    public void bE(boolean z) {
        for (aa aaVar : this.auT) {
            if (aaVar != null && (aaVar.auC instanceof View) && ((View) aaVar.auC).getVisibility() == 0 && !aaVar.avy) {
                aaVar.auC.lz();
            }
        }
        if (this.avc) {
            this.avc = false;
            Bc();
        }
        if (!CR() && z) {
            com.baidu.adp.lib.h.h.eG().postDelayed(this.avg, 200L);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CY() {
        if (this.ave == null) {
            this.ave = new j(getResources().getString(r.j.graffiti_reply_tips), "graffiti_reply_tip_show", 24, 2);
        }
        s ez = ez(this.ave.CT());
        if ((ez instanceof View) && eB(this.ave.getToolId()) != null) {
            this.ave.d(getContext(), (View) ez);
        }
    }

    public void lz() {
        bE(true);
    }

    public void CZ() {
        for (aa aaVar : this.auT) {
            if (aaVar != null && (aaVar.auC instanceof View) && ((View) aaVar.auC).getVisibility() == 0 && !aaVar.avy) {
                aaVar.auC.lz();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.ave != null) {
            this.ave.CU();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.avh);
        this.auS.hide();
        setVisibility(8);
        CW();
    }

    public void Bc() {
        this.auS.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.auR.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.auR.c(z, i);
    }

    public boolean CR() {
        return this.auS.CR();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.auY = i;
    }

    public void setBarLauncherType(int i) {
        this.auR.setBarLauncherType(i);
    }

    public void bC(boolean z) {
        this.auR.bC(z);
    }

    public void bD(boolean z) {
        this.auR.bD(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.auZ = z;
    }

    public void setBackgroundColorId(int i) {
        this.ava = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.avb = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void J(View view) {
        if (view instanceof s) {
            s sVar = (s) view;
            b(new a(31, 0, Integer.valueOf(sVar.getToolId())));
            this.auR.a(eB(sVar.getToolId()));
            if (this.ave != null) {
                this.ave.CU();
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.avh);
            }
            if (sVar.getToolId() == 1) {
                sVar.hide();
                lz();
                b(new a(1, 3, null));
                return;
            }
            int toolId = sVar.getToolId();
            aa eB = eB(toolId);
            if (eB.auC == null) {
                if (eB.avz != null && eB.avz.length > 0) {
                    b(new a(eB.avz[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }

    public void Da() {
        if (this.ave != null) {
            this.ave.CU();
            this.ave = null;
        }
    }
}
