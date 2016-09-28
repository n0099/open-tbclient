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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private g atX;
    private h atY;
    private List<aa> atZ;
    private SparseArray<b> aua;
    private SparseArray<HashSet<b>> aub;
    private SparseArray<HashSet<Integer>> auc;
    private int aud;
    private int aue;
    private boolean auf;
    private int aug;
    private int auh;
    private boolean aui;
    private LinkedList<s> auj;
    private j auk;
    private View.OnClickListener aul;
    private Runnable aum;
    private Runnable aun;
    private List<Integer> auo;

    public void CN() {
        aa ey = ey(3);
        if (ey != null && (ey.atI instanceof View)) {
            View view = (View) ey.atI;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.aun, 1000L);
        }
    }

    public l(Context context) {
        super(context);
        this.aud = 1;
        this.aue = 0;
        this.auf = false;
        this.aug = r.d.common_color_10255;
        this.auh = 0;
        this.aui = true;
        this.aul = new m(this);
        this.aum = new n(this);
        this.aun = new o(this);
        this.auo = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.atZ = new LinkedList();
        this.aua = new SparseArray<>();
        this.aub = new SparseArray<>();
        this.auc = new SparseArray<>();
        this.atX = new g(context, this);
        this.atY = new h(context, this);
        this.auj = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aub.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aub.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aua.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.auc.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.auc.put(i3, hashSet2);
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
        aa ey;
        if (aVar != null) {
            if (aVar.code == 2) {
                s ew = this.atX.ew(aVar.id);
                if (ew != null) {
                    z = false;
                } else {
                    ew = this.atY.ew(aVar.id);
                    z = true;
                }
                if (ew == null) {
                    Iterator<s> it = this.auj.iterator();
                    while (it.hasNext()) {
                        sVar = it.next();
                        if (sVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                sVar = ew;
                if (sVar != null) {
                    sVar.a(aVar);
                    if (z && (ey = ey(2)) != null && ey.atI != null) {
                        ey.atI.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.atX.a((aa) null);
                this.atY.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aua.get(aVar.id);
                if (bVar != null) {
                    this.atX.eu(aVar.id);
                    aa ey2 = ey(aVar.id);
                    if (ey2 != null && ey2.auD == 5) {
                        this.atY.hide();
                        CO();
                    } else {
                        this.atY.eu(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.auc.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aua.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aub.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void CO() {
        boolean z;
        aa ey;
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aum);
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
        if (!z && (ey = ey(3)) != null && (ey.atI instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) ey.atI);
        }
    }

    public void b(aa aaVar) {
        if (aaVar != null) {
            this.atZ.add(aaVar);
        }
    }

    private void clear() {
        this.atX.clear();
        this.atY.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aud = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.atX.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.atY.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        av.e(this, this.aug, i);
        this.atX.onChangeSkinType(i);
        this.atY.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.auo;
    }

    public void y(List<Integer> list) {
        this.auo.clear();
        this.auo.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CH() {
        if (this.atZ != null && this.atZ.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (aa aaVar : this.atZ) {
                if (aaVar.auA > 0) {
                    linkedList.add(aaVar);
                }
                if (aaVar.atI != null) {
                    aaVar.atI.setToolId(aaVar.id);
                    aaVar.atI.setEditorTools(this);
                    if (aaVar.auD == 6) {
                        this.atY.a(aaVar.atI);
                    } else if (aaVar.auD == 1 || aaVar.auD == 2 || aaVar.auD == 3 || aaVar.auD == 4 || aaVar.auD == 5) {
                        this.atX.a(aaVar.atI, aaVar.auD, !aaVar.auE);
                        if (aaVar.auD == 5 && ey(1) == null) {
                            z = true;
                        }
                    }
                    a(aaVar.auF, aaVar.id, aaVar.atI);
                }
            }
            Collections.sort(linkedList, new p(this));
            if (linkedList.size() > this.aud) {
                x xVar = new x(getContext());
                if (this.auh > 0 && xVar.atI != null && (xVar.atI instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) xVar.atI).setBackgroundColorId(this.auh);
                }
                if (this.aue > 0) {
                    xVar.auA = this.aue;
                }
                b(xVar);
                xVar.atI.setToolId(xVar.id);
                xVar.atI.setEditorTools(this);
                a(xVar.auF, xVar.id, xVar.atI);
                this.atY.a(xVar.atI);
                if (this.auf) {
                    linkedList.add(this.aud, xVar);
                } else {
                    linkedList.add(0, xVar);
                }
            }
            int i = this.aud + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                aa aaVar2 = (aa) it.next();
                if (i2 < i) {
                    this.atX.a(a(aaVar2, 1));
                } else {
                    this.atY.a(a(aaVar2, 2));
                }
                i2++;
            }
            if (z) {
                q qVar = new q();
                b(qVar);
                s a = a(qVar, 1);
                a.hide();
                this.atX.a(0, a);
            }
            this.atX.CH();
            this.atY.CH();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.atX.setLayoutParams(layoutParams);
            this.atY.setLayoutParams(layoutParams);
            this.atY.hide();
            removeAllViews();
            addView(this.atX);
            addView(this.atY);
            invalidate();
        }
    }

    public void c(aa aaVar) {
        if (aaVar != null) {
            b(aaVar);
            s a = a(aaVar, 1);
            a.hide();
            if (this.atX != null) {
                this.atX.a(0, a);
                this.atX.removeAllViews();
                this.atX.CH();
            }
            invalidate();
        }
    }

    public aa ey(int i) {
        for (aa aaVar : this.atZ) {
            if (aaVar.id == i) {
                return aaVar;
            }
        }
        return null;
    }

    public List<aa> getAllTools() {
        return this.atZ;
    }

    public s ew(int i) {
        s ew = this.atX.ew(i);
        if (ew == null) {
            return this.atY.ew(i);
        }
        return ew;
    }

    public void CP() {
        this.atX.h(this.aul);
    }

    private s a(aa aaVar, int i) {
        s a = r.a(getContext(), aaVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(aaVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aul);
        }
        return a;
    }

    public void bA(boolean z) {
        for (aa aaVar : this.atZ) {
            if (aaVar != null && (aaVar.atI instanceof View) && ((View) aaVar.atI).getVisibility() == 0 && !aaVar.auE) {
                aaVar.atI.lw();
            }
        }
        if (this.aui) {
            this.aui = false;
            AV();
        }
        if (!CJ() && z) {
            com.baidu.adp.lib.h.h.eG().postDelayed(this.aum, 200L);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CQ() {
        if (this.auk == null) {
            this.auk = new j(getResources().getString(r.j.graffiti_reply_tips), "graffiti_reply_tip_show", 24, 2);
        }
        s ew = ew(this.auk.CL());
        if ((ew instanceof View) && ey(this.auk.getToolId()) != null) {
            this.auk.d(getContext(), (View) ew);
        }
    }

    public void lw() {
        bA(true);
    }

    public void CR() {
        for (aa aaVar : this.atZ) {
            if (aaVar != null && (aaVar.atI instanceof View) && ((View) aaVar.atI).getVisibility() == 0 && !aaVar.auE) {
                aaVar.atI.lw();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.auk != null) {
            this.auk.CM();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aun);
        this.atY.hide();
        setVisibility(8);
        CO();
    }

    public void AV() {
        this.atY.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.atX.setBarLauncherEnabled(z);
    }

    public void c(boolean z, int i) {
        this.atX.c(z, i);
    }

    public boolean CJ() {
        return this.atY.CJ();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aue = i;
    }

    public void setBarLauncherType(int i) {
        this.atX.setBarLauncherType(i);
    }

    public void by(boolean z) {
        this.atX.by(z);
    }

    public void bz(boolean z) {
        this.atX.bz(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.auf = z;
    }

    public void setBackgroundColorId(int i) {
        this.aug = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.auh = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void I(View view) {
        if (view instanceof s) {
            s sVar = (s) view;
            b(new a(31, 0, Integer.valueOf(sVar.getToolId())));
            this.atX.a(ey(sVar.getToolId()));
            if (this.auk != null) {
                this.auk.CM();
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aun);
            }
            if (sVar.getToolId() == 1) {
                sVar.hide();
                lw();
                b(new a(1, 3, null));
                return;
            }
            int toolId = sVar.getToolId();
            aa ey = ey(toolId);
            if (ey.atI == null) {
                if (ey.auF != null && ey.auF.length > 0) {
                    b(new a(ey.auF[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }

    public void CS() {
        if (this.auk != null) {
            this.auk.CM();
            this.auk = null;
        }
    }
}
