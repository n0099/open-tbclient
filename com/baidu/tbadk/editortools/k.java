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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends LinearLayout {
    private boolean atA;
    private LinkedList<r> atB;
    private j atC;
    private View.OnClickListener atD;
    private Runnable atE;
    private Runnable atF;
    private List<Integer> atG;
    private g atp;
    private h atq;
    private List<y> atr;
    private SparseArray<b> ats;
    private SparseArray<HashSet<b>> att;
    private SparseArray<HashSet<Integer>> atu;
    private int atv;
    private int atw;
    private boolean atx;
    private int aty;
    private int atz;

    public void CG() {
        y ex = ex(3);
        if (ex != null && (ex.toolView instanceof View)) {
            View view = (View) ex.toolView;
            view.requestFocus();
            com.baidu.adp.lib.util.k.d(getContext(), view);
            com.baidu.adp.lib.h.h.hr().postDelayed(this.atF, 500L);
        }
    }

    public k(Context context) {
        super(context);
        this.atv = 1;
        this.atw = 0;
        this.atx = false;
        this.aty = t.d.editor_background;
        this.atz = 0;
        this.atA = true;
        this.atD = new l(this);
        this.atE = new m(this);
        this.atF = new n(this);
        this.atG = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.atr = new LinkedList();
        this.ats = new SparseArray<>();
        this.att = new SparseArray<>();
        this.atu = new SparseArray<>();
        this.atp = new g(context, this);
        this.atq = new h(context, this);
        this.atB = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.att.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.att.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.ats.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.atu.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.atu.put(i3, hashSet2);
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
        y ex;
        if (aVar != null) {
            if (aVar.code == 2) {
                r ev = this.atp.ev(aVar.id);
                if (ev != null) {
                    z = false;
                } else {
                    ev = this.atq.ev(aVar.id);
                    z = true;
                }
                if (ev == null) {
                    Iterator<r> it = this.atB.iterator();
                    while (it.hasNext()) {
                        rVar = it.next();
                        if (rVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                rVar = ev;
                if (rVar != null) {
                    rVar.a(aVar);
                    if (z && (ex = ex(2)) != null && ex.toolView != null) {
                        ex.toolView.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.atp.a((y) null);
                this.atq.hide();
            } else if (aVar.id > 0) {
                b bVar = this.ats.get(aVar.id);
                if (bVar != null) {
                    this.atp.et(aVar.id);
                    y ex2 = ex(aVar.id);
                    if (ex2 != null && ex2.toolPosition == 5) {
                        this.atq.hide();
                        CH();
                    } else {
                        this.atq.et(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.atu.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.ats.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.att.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void CH() {
        boolean z;
        y ex;
        com.baidu.adp.lib.h.h.hr().removeCallbacks(this.atE);
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
        if (!z && (ex = ex(3)) != null && (ex.toolView instanceof View)) {
            com.baidu.adp.lib.util.k.c(getContext(), (View) ex.toolView);
        }
    }

    public void b(y yVar) {
        if (yVar != null) {
            this.atr.add(yVar);
        }
    }

    private void clear() {
        this.atp.clear();
        this.atq.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.atv = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.atp.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.atq.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ar.d(this, this.aty, i);
        this.atp.onChangeSkinType(i);
        this.atq.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.atG;
    }

    public void u(List<Integer> list) {
        this.atG.clear();
        this.atG.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void CA() {
        if (this.atr != null && this.atr.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (y yVar : this.atr) {
                if (yVar.launcherIcon > 0) {
                    linkedList.add(yVar);
                }
                if (yVar.toolView != null) {
                    yVar.toolView.setToolId(yVar.id);
                    yVar.toolView.setEditorTools(this);
                    if (yVar.toolPosition == 6) {
                        this.atq.a(yVar.toolView);
                    } else if (yVar.toolPosition == 1 || yVar.toolPosition == 2 || yVar.toolPosition == 3 || yVar.toolPosition == 4 || yVar.toolPosition == 5) {
                        this.atp.a(yVar.toolView, yVar.toolPosition, !yVar.toolNeedAction);
                        if (yVar.toolPosition == 5 && ex(1) == null) {
                            z = true;
                        }
                    }
                    a(yVar.toolLaunchAction, yVar.id, yVar.toolView);
                }
            }
            Collections.sort(linkedList, new o(this));
            if (linkedList.size() > this.atv) {
                v vVar = new v(getContext());
                if (this.atz > 0 && vVar.toolView != null && (vVar.toolView instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) vVar.toolView).setBackgroundColorId(this.atz);
                }
                if (this.atw > 0) {
                    vVar.launcherIcon = this.atw;
                }
                b(vVar);
                vVar.toolView.setToolId(vVar.id);
                vVar.toolView.setEditorTools(this);
                a(vVar.toolLaunchAction, vVar.id, vVar.toolView);
                this.atq.a(vVar.toolView);
                if (this.atx) {
                    linkedList.add(this.atv, vVar);
                } else {
                    linkedList.add(0, vVar);
                }
            }
            int i = this.atv + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                y yVar2 = (y) it.next();
                if (i2 < i) {
                    this.atp.a(a(yVar2, 1));
                } else {
                    this.atq.a(a(yVar2, 2));
                }
                i2++;
            }
            if (z) {
                p pVar = new p();
                b(pVar);
                r a = a(pVar, 1);
                a.hide();
                this.atp.a(0, a);
            }
            this.atp.CA();
            this.atq.CA();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.atp.setLayoutParams(layoutParams);
            this.atq.setLayoutParams(layoutParams);
            this.atq.hide();
            removeAllViews();
            addView(this.atp);
            addView(this.atq);
            invalidate();
        }
    }

    public void c(y yVar) {
        if (yVar != null) {
            b(yVar);
            r a = a(yVar, 1);
            a.hide();
            if (this.atp != null) {
                this.atp.a(0, a);
                this.atp.removeAllViews();
                this.atp.CA();
            }
            invalidate();
        }
    }

    public y ex(int i) {
        for (y yVar : this.atr) {
            if (yVar.id == i) {
                return yVar;
            }
        }
        return null;
    }

    public List<y> getAllTools() {
        return this.atr;
    }

    public r ev(int i) {
        r ev = this.atp.ev(i);
        if (ev == null) {
            return this.atq.ev(i);
        }
        return ev;
    }

    public void CI() {
        this.atp.i(this.atD);
    }

    private r a(y yVar, int i) {
        r a = q.a(getContext(), yVar, i);
        if (a instanceof View) {
            ((View) a).setOnClickListener(this.atD);
        }
        return a;
    }

    public void bm(boolean z) {
        for (y yVar : this.atr) {
            if (yVar != null && (yVar.toolView instanceof View) && ((View) yVar.toolView).getVisibility() == 0 && !yVar.toolNeedAction) {
                yVar.toolView.ow();
            }
        }
        if (this.atA) {
            this.atA = false;
            Ba();
        }
        if (!CC() && z) {
            com.baidu.adp.lib.h.h.hr().postDelayed(this.atE, 200L);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CJ() {
        if (this.atC == null) {
            this.atC = new j(getResources().getString(t.j.editor_new_function_tips), "video_tips_show_config", 19, 2);
        }
        r ev = ev(this.atC.CE());
        if ((ev instanceof View) && ex(this.atC.getToolId()) != null) {
            this.atC.f(getContext(), (View) ev);
        }
    }

    public void ow() {
        bm(true);
    }

    public void CK() {
        for (y yVar : this.atr) {
            if (yVar != null && (yVar.toolView instanceof View) && ((View) yVar.toolView).getVisibility() == 0 && !yVar.toolNeedAction) {
                yVar.toolView.ow();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.atC != null) {
            this.atC.CF();
        }
        com.baidu.adp.lib.h.h.hr().removeCallbacks(this.atF);
        this.atq.hide();
        setVisibility(8);
        CH();
    }

    public void Ba() {
        this.atq.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.atp.setBarLauncherEnabled(z);
    }

    public boolean CC() {
        return this.atq.CC();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.atw = i;
    }

    public void setBarLauncherType(int i) {
        this.atp.setBarLauncherType(i);
    }

    public void setBarLinePostion(int i) {
        this.atp.setLinePosition(i);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.atx = z;
    }

    public void setBackgroundColorId(int i) {
        this.aty = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.atz = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
