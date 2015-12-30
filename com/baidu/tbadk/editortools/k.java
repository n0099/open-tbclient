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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends LinearLayout {
    private SparseArray<HashSet<b>> asA;
    private SparseArray<HashSet<Integer>> asB;
    private int asC;
    private int asD;
    private boolean asE;
    private int asF;
    private int asG;
    private boolean asH;
    private LinkedList<r> asI;
    private j asJ;
    private View.OnClickListener asK;
    private Runnable asL;
    private Runnable asM;
    private List<Integer> asN;
    private g asw;
    private h asx;
    private List<y> asy;
    private SparseArray<b> asz;

    public void Bq() {
        y ec = ec(3);
        if (ec != null && (ec.toolView instanceof View)) {
            View view = (View) ec.toolView;
            view.requestFocus();
            com.baidu.adp.lib.util.k.d(getContext(), view);
            com.baidu.adp.lib.h.h.hj().postDelayed(this.asM, 500L);
        }
    }

    public k(Context context) {
        super(context);
        this.asC = 1;
        this.asD = 0;
        this.asE = false;
        this.asF = n.d.editor_background;
        this.asG = 0;
        this.asH = true;
        this.asK = new l(this);
        this.asL = new m(this);
        this.asM = new n(this);
        this.asN = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.asy = new LinkedList();
        this.asz = new SparseArray<>();
        this.asA = new SparseArray<>();
        this.asB = new SparseArray<>();
        this.asw = new g(context, this);
        this.asx = new h(context, this);
        this.asI = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.asA.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.asA.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.asz.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.asB.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.asB.put(i3, hashSet2);
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
        r rVar;
        y ec;
        if (aVar != null) {
            if (aVar.code == 2) {
                r ea = this.asw.ea(aVar.id);
                if (ea != null) {
                    z = false;
                } else {
                    ea = this.asx.ea(aVar.id);
                    z = true;
                }
                if (ea == null) {
                    Iterator<r> it = this.asI.iterator();
                    while (it.hasNext()) {
                        rVar = it.next();
                        if (rVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                rVar = ea;
                if (rVar != null) {
                    rVar.a(aVar);
                    if (z && (ec = ec(2)) != null && ec.toolView != null) {
                        ec.toolView.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.asw.a((y) null);
                this.asx.hide();
            } else if (aVar.id > 0) {
                b bVar = this.asz.get(aVar.id);
                if (bVar != null) {
                    this.asw.dY(aVar.id);
                    y ec2 = ec(aVar.id);
                    if (ec2 != null && ec2.toolPosition == 5) {
                        this.asx.hide();
                        Br();
                    } else {
                        this.asx.dY(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.asB.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.asz.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.asA.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Br() {
        boolean z;
        y ec;
        com.baidu.adp.lib.h.h.hj().removeCallbacks(this.asL);
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
        if (!z && (ec = ec(3)) != null && (ec.toolView instanceof View)) {
            com.baidu.adp.lib.util.k.c(getContext(), (View) ec.toolView);
        }
    }

    public void b(y yVar) {
        if (yVar != null) {
            this.asy.add(yVar);
        }
    }

    private void clear() {
        this.asw.clear();
        this.asx.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.asC = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.asw.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.asx.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        as.d(this, this.asF, i);
        this.asw.onChangeSkinType(i);
        this.asx.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.asN;
    }

    public void q(List<Integer> list) {
        this.asN.clear();
        this.asN.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Bk() {
        if (this.asy != null && this.asy.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (y yVar : this.asy) {
                if (yVar.launcherIcon > 0) {
                    linkedList.add(yVar);
                }
                if (yVar.toolView != null) {
                    yVar.toolView.setToolId(yVar.id);
                    yVar.toolView.setEditorTools(this);
                    if (yVar.toolPosition == 6) {
                        this.asx.a(yVar.toolView);
                    } else if (yVar.toolPosition == 1 || yVar.toolPosition == 2 || yVar.toolPosition == 3 || yVar.toolPosition == 4 || yVar.toolPosition == 5) {
                        this.asw.a(yVar.toolView, yVar.toolPosition, !yVar.toolNeedAction);
                        if (yVar.toolPosition == 5 && ec(1) == null) {
                            z = true;
                        }
                    }
                    a(yVar.toolLaunchAction, yVar.id, yVar.toolView);
                }
            }
            Collections.sort(linkedList, new o(this));
            if (linkedList.size() > this.asC) {
                v vVar = new v(getContext());
                if (this.asG > 0 && vVar.toolView != null && (vVar.toolView instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) vVar.toolView).setBackgroundColorId(this.asG);
                }
                if (this.asD > 0) {
                    vVar.launcherIcon = this.asD;
                }
                b(vVar);
                vVar.toolView.setToolId(vVar.id);
                vVar.toolView.setEditorTools(this);
                a(vVar.toolLaunchAction, vVar.id, vVar.toolView);
                this.asx.a(vVar.toolView);
                if (this.asE) {
                    linkedList.add(this.asC, vVar);
                } else {
                    linkedList.add(0, vVar);
                }
            }
            int i = this.asC + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                y yVar2 = (y) it.next();
                if (i2 < i) {
                    this.asw.a(a(yVar2, 1));
                } else {
                    this.asx.a(a(yVar2, 2));
                }
                i2++;
            }
            if (z) {
                p pVar = new p();
                b(pVar);
                r a = a(pVar, 1);
                a.hide();
                this.asw.a(0, a);
            }
            this.asw.Bk();
            this.asx.Bk();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.asw.setLayoutParams(layoutParams);
            this.asx.setLayoutParams(layoutParams);
            this.asx.hide();
            removeAllViews();
            addView(this.asw);
            addView(this.asx);
            invalidate();
        }
    }

    public void c(y yVar) {
        if (yVar != null) {
            b(yVar);
            r a = a(yVar, 1);
            a.hide();
            if (this.asw != null) {
                this.asw.a(0, a);
                this.asw.removeAllViews();
                this.asw.Bk();
            }
            invalidate();
        }
    }

    public y ec(int i) {
        for (y yVar : this.asy) {
            if (yVar.id == i) {
                return yVar;
            }
        }
        return null;
    }

    public List<y> getAllTools() {
        return this.asy;
    }

    public r ea(int i) {
        r ea = this.asw.ea(i);
        if (ea == null) {
            return this.asx.ea(i);
        }
        return ea;
    }

    public void Bs() {
        this.asw.e(this.asK);
    }

    private r a(y yVar, int i) {
        r a = q.a(getContext(), yVar, i);
        if (a instanceof View) {
            ((View) a).setOnClickListener(this.asK);
        }
        return a;
    }

    public void bk(boolean z) {
        for (y yVar : this.asy) {
            if (yVar != null && (yVar.toolView instanceof View) && ((View) yVar.toolView).getVisibility() == 0 && !yVar.toolNeedAction) {
                yVar.toolView.ob();
            }
        }
        if (this.asH) {
            this.asH = false;
            zK();
        }
        if (!Bm() && z) {
            com.baidu.adp.lib.h.h.hj().postDelayed(this.asL, 200L);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bt() {
        if (this.asJ == null) {
            this.asJ = new j(getResources().getString(n.j.editor_new_function_tips), "video_tips_show_config", 19, 2);
        }
        r ea = ea(this.asJ.Bo());
        if ((ea instanceof View) && ec(this.asJ.getToolId()) != null) {
            this.asJ.f(getContext(), (View) ea);
        }
    }

    public void ob() {
        bk(true);
    }

    public void Bu() {
        for (y yVar : this.asy) {
            if (yVar != null && (yVar.toolView instanceof View) && ((View) yVar.toolView).getVisibility() == 0 && !yVar.toolNeedAction) {
                yVar.toolView.ob();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.asJ != null) {
            this.asJ.Bp();
        }
        com.baidu.adp.lib.h.h.hj().removeCallbacks(this.asM);
        this.asx.hide();
        setVisibility(8);
        Br();
    }

    public void zK() {
        this.asx.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.asw.setBarLauncherEnabled(z);
    }

    public boolean Bm() {
        return this.asx.Bm();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.asD = i;
    }

    public void setBarLauncherType(int i) {
        this.asw.setBarLauncherType(i);
    }

    public void setBarLinePostion(int i) {
        this.asw.setLinePosition(i);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.asE = z;
    }

    public void setBackgroundColorId(int i) {
        this.asF = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.asG = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
