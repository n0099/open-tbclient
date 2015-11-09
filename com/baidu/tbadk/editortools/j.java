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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private g aoW;
    private h aoX;
    private List<w> aoY;
    private SparseArray<b> aoZ;
    private SparseArray<HashSet<b>> apa;
    private SparseArray<HashSet<Integer>> apb;
    private int apc;
    private int apd;
    private boolean ape;
    private int apf;
    private int apg;
    private boolean aph;
    private LinkedList<p> api;
    private View.OnClickListener apj;
    private Runnable apk;
    private List<Integer> apl;

    public void AE() {
        w dU = dU(3);
        if (dU != null && (dU.toolView instanceof View)) {
            View view = (View) dU.toolView;
            view.requestFocus();
            com.baidu.adp.lib.util.k.d(getContext(), view);
        }
    }

    public j(Context context) {
        super(context);
        this.apc = 1;
        this.apd = 0;
        this.ape = false;
        this.apf = i.c.editor_background;
        this.apg = 0;
        this.aph = true;
        this.apj = new k(this);
        this.apk = new l(this);
        this.apl = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.aoY = new LinkedList();
        this.aoZ = new SparseArray<>();
        this.apa = new SparseArray<>();
        this.apb = new SparseArray<>();
        this.aoW = new g(context, this);
        this.aoX = new h(context, this);
        this.api = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.apa.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.apa.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aoZ.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.apb.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.apb.put(i3, hashSet2);
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
        w dU;
        if (aVar != null) {
            if (aVar.code == 2) {
                p dS = this.aoW.dS(aVar.id);
                if (dS != null) {
                    z = false;
                } else {
                    dS = this.aoX.dS(aVar.id);
                    z = true;
                }
                if (dS == null) {
                    Iterator<p> it = this.api.iterator();
                    while (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                pVar = dS;
                if (pVar != null) {
                    pVar.a(aVar);
                    if (z && (dU = dU(2)) != null && dU.toolView != null) {
                        dU.toolView.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aoW.a((w) null);
                this.aoX.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aoZ.get(aVar.id);
                if (bVar != null) {
                    this.aoW.dQ(aVar.id);
                    w dU2 = dU(aVar.id);
                    if (dU2 != null && dU2.toolPosition == 5) {
                        this.aoX.hide();
                        AF();
                    } else {
                        this.aoX.dQ(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.apb.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aoZ.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.apa.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void AF() {
        boolean z;
        w dU;
        com.baidu.adp.lib.g.h.hh().removeCallbacks(this.apk);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.k.c(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && (dU = dU(3)) != null && (dU.toolView instanceof View)) {
            com.baidu.adp.lib.util.k.c(getContext(), (View) dU.toolView);
        }
    }

    public void b(w wVar) {
        if (wVar != null) {
            this.aoY.add(wVar);
        }
    }

    private void clear() {
        this.aoW.clear();
        this.aoX.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.apc = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aoW.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aoX.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        an.d(this, this.apf, i);
        this.aoW.onChangeSkinType(i);
        this.aoX.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.apl;
    }

    public void q(List<Integer> list) {
        this.apl.clear();
        this.apl.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void AA() {
        if (this.aoY != null && this.aoY.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (w wVar : this.aoY) {
                if (wVar.launcherIcon > 0) {
                    linkedList.add(wVar);
                }
                if (wVar.toolView != null) {
                    wVar.toolView.setToolId(wVar.id);
                    wVar.toolView.setEditorTools(this);
                    if (wVar.toolPosition == 6) {
                        this.aoX.a(wVar.toolView);
                    } else if (wVar.toolPosition == 1 || wVar.toolPosition == 2 || wVar.toolPosition == 3 || wVar.toolPosition == 4 || wVar.toolPosition == 5) {
                        this.aoW.a(wVar.toolView, wVar.toolPosition, !wVar.toolNeedAction);
                        if (wVar.toolPosition == 5 && dU(1) == null) {
                            z = true;
                        }
                    }
                    a(wVar.toolLaunchAction, wVar.id, wVar.toolView);
                }
            }
            Collections.sort(linkedList, new m(this));
            if (linkedList.size() > this.apc) {
                t tVar = new t(getContext());
                if (this.apg > 0 && tVar.toolView != null && (tVar.toolView instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) tVar.toolView).setBackgroundColorId(this.apg);
                }
                if (this.apd > 0) {
                    tVar.launcherIcon = this.apd;
                }
                b(tVar);
                tVar.toolView.setToolId(tVar.id);
                tVar.toolView.setEditorTools(this);
                a(tVar.toolLaunchAction, tVar.id, tVar.toolView);
                this.aoX.a(tVar.toolView);
                if (this.ape) {
                    linkedList.add(this.apc, tVar);
                } else {
                    linkedList.add(0, tVar);
                }
            }
            int i = this.apc + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                w wVar2 = (w) it.next();
                if (i2 < i) {
                    this.aoW.a(a(wVar2, 1));
                } else {
                    this.aoX.a(a(wVar2, 2));
                }
                i2++;
            }
            if (z) {
                n nVar = new n();
                b(nVar);
                p a = a(nVar, 1);
                a.hide();
                this.aoW.a(0, a);
            }
            this.aoW.AA();
            this.aoX.AA();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aoW.setLayoutParams(layoutParams);
            this.aoX.setLayoutParams(layoutParams);
            this.aoX.hide();
            removeAllViews();
            addView(this.aoW);
            addView(this.aoX);
            invalidate();
        }
    }

    public void c(w wVar) {
        if (wVar != null) {
            b(wVar);
            p a = a(wVar, 1);
            a.hide();
            if (this.aoW != null) {
                this.aoW.a(0, a);
                this.aoW.removeAllViews();
                this.aoW.AA();
            }
            invalidate();
        }
    }

    public w dU(int i) {
        for (w wVar : this.aoY) {
            if (wVar.id == i) {
                return wVar;
            }
        }
        return null;
    }

    public List<w> getAllTools() {
        return this.aoY;
    }

    public p dS(int i) {
        p dS = this.aoW.dS(i);
        if (dS == null) {
            return this.aoX.dS(i);
        }
        return dS;
    }

    public void AG() {
        this.aoW.e(this.apj);
    }

    private p a(w wVar, int i) {
        p a = o.a(getContext(), wVar, i);
        if (a instanceof View) {
            ((View) a).setOnClickListener(this.apj);
        }
        return a;
    }

    public void bf(boolean z) {
        for (w wVar : this.aoY) {
            if (wVar != null && (wVar.toolView instanceof View) && ((View) wVar.toolView).getVisibility() == 0 && !wVar.toolNeedAction) {
                wVar.toolView.ox();
            }
        }
        if (this.aph) {
            this.aph = false;
            zc();
        }
        if (!AC() && z) {
            com.baidu.adp.lib.g.h.hh().postDelayed(this.apk, 200L);
        }
        setVisibility(0);
    }

    public void ox() {
        bf(true);
    }

    public void AH() {
        for (w wVar : this.aoY) {
            if (wVar != null && (wVar.toolView instanceof View) && ((View) wVar.toolView).getVisibility() == 0 && !wVar.toolNeedAction) {
                wVar.toolView.ox();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        this.aoX.hide();
        setVisibility(8);
        AF();
    }

    public void zc() {
        this.aoX.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aoW.setBarLauncherEnabled(z);
    }

    public boolean AC() {
        return this.aoX.AC();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.apd = i;
    }

    public void setBarLauncherType(int i) {
        this.aoW.setBarLauncherType(i);
    }

    public void setBarLinePostion(int i) {
        this.aoW.setLinePosition(i);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.ape = z;
    }

    public void setBackgroundColorId(int i) {
        this.apf = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.apg = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
