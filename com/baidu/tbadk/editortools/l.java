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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private int auA;
    private boolean auB;
    private int auC;
    private int auD;
    private boolean auE;
    private LinkedList<s> auF;
    private j auG;
    private View.OnClickListener auH;
    private Runnable auI;
    private Runnable auJ;
    private Boolean auK;
    private List<Integer> auL;
    private g aut;
    private h auu;
    private List<aa> auv;
    private SparseArray<b> auw;
    private SparseArray<HashSet<b>> aux;
    private SparseArray<HashSet<Integer>> auy;
    private int auz;

    public void CN() {
        aa ez = ez(3);
        if (ez != null && (ez.aue instanceof View)) {
            View view = (View) ez.aue;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.auJ, 1000L);
        }
    }

    public l(Context context) {
        super(context);
        this.auz = 1;
        this.auA = 0;
        this.auB = false;
        this.auC = t.d.common_color_10255;
        this.auD = 0;
        this.auE = true;
        this.auH = new m(this);
        this.auI = new n(this);
        this.auJ = new o(this);
        this.auL = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.auv = new LinkedList();
        this.auw = new SparseArray<>();
        this.aux = new SparseArray<>();
        this.auy = new SparseArray<>();
        this.aut = new g(context, this);
        this.auu = new h(context, this);
        this.auF = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aux.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aux.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.auw.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.auy.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.auy.put(i3, hashSet2);
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
        aa ez;
        if (aVar != null) {
            if (aVar.code == 2) {
                s ex = this.aut.ex(aVar.id);
                if (ex != null) {
                    z = false;
                } else {
                    ex = this.auu.ex(aVar.id);
                    z = true;
                }
                if (ex == null) {
                    Iterator<s> it = this.auF.iterator();
                    while (it.hasNext()) {
                        sVar = it.next();
                        if (sVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                sVar = ex;
                if (sVar != null) {
                    sVar.a(aVar);
                    if (z && (ez = ez(2)) != null && ez.aue != null) {
                        ez.aue.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aut.a((aa) null);
                this.auu.hide();
            } else if (aVar.id > 0) {
                b bVar = this.auw.get(aVar.id);
                if (bVar != null) {
                    this.aut.ev(aVar.id);
                    aa ez2 = ez(aVar.id);
                    if (ez2 != null && ez2.ava == 5) {
                        this.auu.hide();
                        CO();
                    } else {
                        this.auu.ev(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.auy.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.auw.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aux.get(aVar.code);
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
        aa ez;
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.auI);
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
        if (!z && (ez = ez(3)) != null && (ez.aue instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) ez.aue);
        }
    }

    public void b(aa aaVar) {
        if (aaVar != null) {
            this.auv.add(aaVar);
        }
    }

    private void clear() {
        this.aut.clear();
        this.auu.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.auz = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aut.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.auu.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        av.e(this, this.auC, i);
        this.aut.onChangeSkinType(i);
        this.auu.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.auL;
    }

    public void y(List<Integer> list) {
        this.auL.clear();
        this.auL.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CH() {
        if (this.auv != null && this.auv.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (aa aaVar : this.auv) {
                if (aaVar.auX > 0) {
                    linkedList.add(aaVar);
                }
                if (aaVar.aue != null) {
                    aaVar.aue.setToolId(aaVar.id);
                    aaVar.aue.setEditorTools(this);
                    if (aaVar.ava == 6) {
                        this.auu.a(aaVar.aue);
                    } else if (aaVar.ava == 1 || aaVar.ava == 2 || aaVar.ava == 3 || aaVar.ava == 4 || aaVar.ava == 5) {
                        this.aut.a(aaVar.aue, aaVar.ava, !aaVar.avb);
                        if (aaVar.ava == 5 && ez(1) == null) {
                            z = true;
                        }
                    }
                    a(aaVar.avc, aaVar.id, aaVar.aue);
                }
            }
            Collections.sort(linkedList, new p(this));
            if (linkedList.size() > this.auz) {
                x xVar = new x(getContext());
                if (this.auD > 0 && xVar.aue != null && (xVar.aue instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) xVar.aue).setBackgroundColorId(this.auD);
                }
                if (this.auA > 0) {
                    xVar.auX = this.auA;
                }
                b(xVar);
                xVar.aue.setToolId(xVar.id);
                xVar.aue.setEditorTools(this);
                a(xVar.avc, xVar.id, xVar.aue);
                this.auu.a(xVar.aue);
                if (this.auB) {
                    linkedList.add(this.auz, xVar);
                } else {
                    linkedList.add(0, xVar);
                }
            }
            int i = this.auz + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                aa aaVar2 = (aa) it.next();
                if (i2 < i) {
                    this.aut.a(a(aaVar2, 1));
                } else {
                    this.auu.a(a(aaVar2, 2));
                }
                i2++;
            }
            if (z) {
                q qVar = new q();
                b(qVar);
                s a = a(qVar, 1);
                a.hide();
                this.aut.a(0, a);
            }
            this.aut.CH();
            this.auu.CH();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aut.setLayoutParams(layoutParams);
            this.auu.setLayoutParams(layoutParams);
            this.auu.hide();
            removeAllViews();
            addView(this.aut);
            addView(this.auu);
            invalidate();
        }
    }

    public void c(aa aaVar) {
        if (aaVar != null) {
            b(aaVar);
            s a = a(aaVar, 1);
            a.hide();
            if (this.aut != null) {
                this.aut.a(0, a);
                this.aut.removeAllViews();
                this.aut.CH();
            }
            invalidate();
        }
    }

    public aa ez(int i) {
        for (aa aaVar : this.auv) {
            if (aaVar.id == i) {
                return aaVar;
            }
        }
        return null;
    }

    public List<aa> getAllTools() {
        return this.auv;
    }

    public s ex(int i) {
        s ex = this.aut.ex(i);
        if (ex == null) {
            return this.auu.ex(i);
        }
        return ex;
    }

    public void CP() {
        this.aut.i(this.auH);
    }

    private s a(aa aaVar, int i) {
        s a = r.a(getContext(), aaVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(aaVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.auH);
        }
        return a;
    }

    public void bB(boolean z) {
        for (aa aaVar : this.auv) {
            if (aaVar != null && (aaVar.aue instanceof View) && ((View) aaVar.aue).getVisibility() == 0 && !aaVar.avb) {
                aaVar.aue.lw();
            }
        }
        if (this.auE) {
            this.auE = false;
            AS();
        }
        if (!CJ() && z) {
            com.baidu.adp.lib.h.h.eG().postDelayed(this.auI, 200L);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CQ() {
        if (this.auG == null) {
            this.auG = new j(getResources().getString(t.j.graffiti_reply_tips), "graffiti_reply_tip_show", 24, 2);
        }
        s ex = ex(this.auG.CL());
        if ((ex instanceof View) && ez(this.auG.getToolId()) != null) {
            this.auG.d(getContext(), (View) ex);
        }
    }

    public void lw() {
        bB(true);
    }

    public void CR() {
        for (aa aaVar : this.auv) {
            if (aaVar != null && (aaVar.aue instanceof View) && ((View) aaVar.aue).getVisibility() == 0 && !aaVar.avb) {
                aaVar.aue.lw();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.auG != null) {
            this.auG.CM();
        }
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.auJ);
        this.auu.hide();
        setVisibility(8);
        CO();
    }

    public void AS() {
        this.auu.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aut.setBarLauncherEnabled(z);
    }

    public boolean CJ() {
        return this.auu.CJ();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.auA = i;
    }

    public void setBarLauncherType(int i) {
        this.aut.setBarLauncherType(i);
    }

    public void bz(boolean z) {
        this.aut.bz(z);
    }

    public void bA(boolean z) {
        this.aut.bA(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.auB = z;
    }

    public void setBackgroundColorId(int i) {
        this.auC = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.auD = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void I(View view) {
        if (view instanceof s) {
            s sVar = (s) view;
            b(new a(31, 0, Integer.valueOf(sVar.getToolId())));
            this.aut.a(ez(sVar.getToolId()));
            if (this.auG != null) {
                this.auG.CM();
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.auJ);
            }
            if (sVar.getToolId() == 1) {
                sVar.hide();
                lw();
                b(new a(1, 3, null));
                return;
            }
            int toolId = sVar.getToolId();
            aa ez = ez(toolId);
            if (ez.aue == null) {
                if (ez.avc != null && ez.avc.length > 0) {
                    b(new a(ez.avc[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }

    public void CS() {
        if (this.auG != null) {
            this.auG.CM();
            this.auG = null;
        }
    }

    public void setCanshowTogetherhi(Boolean bool) {
        this.auK = bool;
    }

    public Boolean getCanshowTogetherhi() {
        return this.auK;
    }
}
