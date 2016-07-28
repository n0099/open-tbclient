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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private View.OnClickListener arA;
    private Runnable arB;
    private Runnable arC;
    private Boolean arD;
    private List<Integer> arE;
    private g arm;
    private h arn;
    private List<aa> aro;
    private SparseArray<b> arp;
    private SparseArray<HashSet<b>> arq;
    private SparseArray<HashSet<Integer>> arr;
    private int ars;
    private int art;
    private boolean aru;
    private int arv;
    private int arw;
    private boolean arx;
    private LinkedList<s> ary;
    private j arz;

    public void Bs() {
        aa el = el(3);
        if (el != null && (el.aqX instanceof View)) {
            View view = (View) el.aqX;
            view.requestFocus();
            com.baidu.adp.lib.util.k.c(getContext(), view);
            com.baidu.adp.lib.h.h.dL().postDelayed(this.arC, 1000L);
        }
    }

    public l(Context context) {
        super(context);
        this.ars = 1;
        this.art = 0;
        this.aru = false;
        this.arv = u.d.common_color_10255;
        this.arw = 0;
        this.arx = true;
        this.arA = new m(this);
        this.arB = new n(this);
        this.arC = new o(this);
        this.arE = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.aro = new LinkedList();
        this.arp = new SparseArray<>();
        this.arq = new SparseArray<>();
        this.arr = new SparseArray<>();
        this.arm = new g(context, this);
        this.arn = new h(context, this);
        this.ary = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.arq.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.arq.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.arp.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.arr.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.arr.put(i3, hashSet2);
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
        aa el;
        if (aVar != null) {
            if (aVar.code == 2) {
                s ej = this.arm.ej(aVar.id);
                if (ej != null) {
                    z = false;
                } else {
                    ej = this.arn.ej(aVar.id);
                    z = true;
                }
                if (ej == null) {
                    Iterator<s> it = this.ary.iterator();
                    while (it.hasNext()) {
                        sVar = it.next();
                        if (sVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                sVar = ej;
                if (sVar != null) {
                    sVar.a(aVar);
                    if (z && (el = el(2)) != null && el.aqX != null) {
                        el.aqX.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.arm.a((aa) null);
                this.arn.hide();
            } else if (aVar.id > 0) {
                b bVar = this.arp.get(aVar.id);
                if (bVar != null) {
                    this.arm.eh(aVar.id);
                    aa el2 = el(aVar.id);
                    if (el2 != null && el2.arT == 5) {
                        this.arn.hide();
                        Bt();
                    } else {
                        this.arn.eh(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.arr.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.arp.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.arq.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Bt() {
        boolean z;
        aa el;
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.arB);
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
        if (!z && (el = el(3)) != null && (el.aqX instanceof View)) {
            com.baidu.adp.lib.util.k.b(getContext(), (View) el.aqX);
        }
    }

    public void b(aa aaVar) {
        if (aaVar != null) {
            this.aro.add(aaVar);
        }
    }

    private void clear() {
        this.arm.clear();
        this.arn.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.ars = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.arm.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.arn.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        av.e(this, this.arv, i);
        this.arm.onChangeSkinType(i);
        this.arn.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.arE;
    }

    public void y(List<Integer> list) {
        this.arE.clear();
        this.arE.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Bm() {
        if (this.aro != null && this.aro.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (aa aaVar : this.aro) {
                if (aaVar.arQ > 0) {
                    linkedList.add(aaVar);
                }
                if (aaVar.aqX != null) {
                    aaVar.aqX.setToolId(aaVar.id);
                    aaVar.aqX.setEditorTools(this);
                    if (aaVar.arT == 6) {
                        this.arn.a(aaVar.aqX);
                    } else if (aaVar.arT == 1 || aaVar.arT == 2 || aaVar.arT == 3 || aaVar.arT == 4 || aaVar.arT == 5) {
                        this.arm.a(aaVar.aqX, aaVar.arT, !aaVar.arU);
                        if (aaVar.arT == 5 && el(1) == null) {
                            z = true;
                        }
                    }
                    a(aaVar.arV, aaVar.id, aaVar.aqX);
                }
            }
            Collections.sort(linkedList, new p(this));
            if (linkedList.size() > this.ars) {
                x xVar = new x(getContext());
                if (this.arw > 0 && xVar.aqX != null && (xVar.aqX instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) xVar.aqX).setBackgroundColorId(this.arw);
                }
                if (this.art > 0) {
                    xVar.arQ = this.art;
                }
                b(xVar);
                xVar.aqX.setToolId(xVar.id);
                xVar.aqX.setEditorTools(this);
                a(xVar.arV, xVar.id, xVar.aqX);
                this.arn.a(xVar.aqX);
                if (this.aru) {
                    linkedList.add(this.ars, xVar);
                } else {
                    linkedList.add(0, xVar);
                }
            }
            int i = this.ars + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                aa aaVar2 = (aa) it.next();
                if (i2 < i) {
                    this.arm.a(a(aaVar2, 1));
                } else {
                    this.arn.a(a(aaVar2, 2));
                }
                i2++;
            }
            if (z) {
                q qVar = new q();
                b(qVar);
                s a = a(qVar, 1);
                a.hide();
                this.arm.a(0, a);
            }
            this.arm.Bm();
            this.arn.Bm();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.arm.setLayoutParams(layoutParams);
            this.arn.setLayoutParams(layoutParams);
            this.arn.hide();
            removeAllViews();
            addView(this.arm);
            addView(this.arn);
            invalidate();
        }
    }

    public void c(aa aaVar) {
        if (aaVar != null) {
            b(aaVar);
            s a = a(aaVar, 1);
            a.hide();
            if (this.arm != null) {
                this.arm.a(0, a);
                this.arm.removeAllViews();
                this.arm.Bm();
            }
            invalidate();
        }
    }

    public aa el(int i) {
        for (aa aaVar : this.aro) {
            if (aaVar.id == i) {
                return aaVar;
            }
        }
        return null;
    }

    public List<aa> getAllTools() {
        return this.aro;
    }

    public s ej(int i) {
        s ej = this.arm.ej(i);
        if (ej == null) {
            return this.arn.ej(i);
        }
        return ej;
    }

    public void Bu() {
        this.arm.i(this.arA);
    }

    private s a(aa aaVar, int i) {
        s a = r.a(getContext(), aaVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(aaVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.arA);
        }
        return a;
    }

    public void bz(boolean z) {
        for (aa aaVar : this.aro) {
            if (aaVar != null && (aaVar.aqX instanceof View) && ((View) aaVar.aqX).getVisibility() == 0 && !aaVar.arU) {
                aaVar.aqX.kB();
            }
        }
        if (this.arx) {
            this.arx = false;
            zD();
        }
        if (!Bo() && z) {
            com.baidu.adp.lib.h.h.dL().postDelayed(this.arB, 200L);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bv() {
        if (this.arz == null) {
            this.arz = new j(getResources().getString(u.j.graffiti_reply_tips), "graffiti_reply_tip_show", 24, 2);
        }
        s ej = ej(this.arz.Bq());
        if ((ej instanceof View) && el(this.arz.getToolId()) != null) {
            this.arz.d(getContext(), (View) ej);
        }
    }

    public void kB() {
        bz(true);
    }

    public void Bw() {
        for (aa aaVar : this.aro) {
            if (aaVar != null && (aaVar.aqX instanceof View) && ((View) aaVar.aqX).getVisibility() == 0 && !aaVar.arU) {
                aaVar.aqX.kB();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.arz != null) {
            this.arz.Br();
        }
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.arC);
        this.arn.hide();
        setVisibility(8);
        Bt();
    }

    public void zD() {
        this.arn.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.arm.setBarLauncherEnabled(z);
    }

    public boolean Bo() {
        return this.arn.Bo();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.art = i;
    }

    public void setBarLauncherType(int i) {
        this.arm.setBarLauncherType(i);
    }

    public void bx(boolean z) {
        this.arm.bx(z);
    }

    public void by(boolean z) {
        this.arm.by(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.aru = z;
    }

    public void setBackgroundColorId(int i) {
        this.arv = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.arw = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void H(View view) {
        if (view instanceof s) {
            s sVar = (s) view;
            b(new a(31, 0, Integer.valueOf(sVar.getToolId())));
            this.arm.a(el(sVar.getToolId()));
            if (this.arz != null) {
                this.arz.Br();
                com.baidu.adp.lib.h.h.dL().removeCallbacks(this.arC);
            }
            if (sVar.getToolId() == 1) {
                sVar.hide();
                kB();
                b(new a(1, 3, null));
                return;
            }
            int toolId = sVar.getToolId();
            aa el = el(toolId);
            if (el.aqX == null) {
                if (el.arV != null && el.arV.length > 0) {
                    b(new a(el.arV[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }

    public void Bx() {
        if (this.arz != null) {
            this.arz.Br();
            this.arz = null;
        }
    }

    public void setCanshowTogetherhi(Boolean bool) {
        this.arD = bool;
    }

    public Boolean getCanshowTogetherhi() {
        return this.arD;
    }
}
