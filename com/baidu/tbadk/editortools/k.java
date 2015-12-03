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
    private g aqS;
    private h aqT;
    private List<y> aqU;
    private SparseArray<b> aqV;
    private SparseArray<HashSet<b>> aqW;
    private SparseArray<HashSet<Integer>> aqX;
    private int aqY;
    private int aqZ;
    private boolean ara;
    private int arb;
    private int arc;
    private boolean ard;
    private LinkedList<r> are;
    private j arf;
    private View.OnClickListener arg;
    private Runnable arh;
    private Runnable ari;
    private List<Integer> arj;

    public void BB() {
        y ei = ei(3);
        if (ei != null && (ei.toolView instanceof View)) {
            View view = (View) ei.toolView;
            view.requestFocus();
            com.baidu.adp.lib.util.k.d(getContext(), view);
            com.baidu.adp.lib.h.h.hj().postDelayed(this.ari, 500L);
        }
    }

    public k(Context context) {
        super(context);
        this.aqY = 1;
        this.aqZ = 0;
        this.ara = false;
        this.arb = n.c.editor_background;
        this.arc = 0;
        this.ard = true;
        this.arg = new l(this);
        this.arh = new m(this);
        this.ari = new n(this);
        this.arj = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.aqU = new LinkedList();
        this.aqV = new SparseArray<>();
        this.aqW = new SparseArray<>();
        this.aqX = new SparseArray<>();
        this.aqS = new g(context, this);
        this.aqT = new h(context, this);
        this.are = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.aqW.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.aqW.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.aqV.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.aqX.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.aqX.put(i3, hashSet2);
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
        y ei;
        if (aVar != null) {
            if (aVar.code == 2) {
                r eg = this.aqS.eg(aVar.id);
                if (eg != null) {
                    z = false;
                } else {
                    eg = this.aqT.eg(aVar.id);
                    z = true;
                }
                if (eg == null) {
                    Iterator<r> it = this.are.iterator();
                    while (it.hasNext()) {
                        rVar = it.next();
                        if (rVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                rVar = eg;
                if (rVar != null) {
                    rVar.a(aVar);
                    if (z && (ei = ei(2)) != null && ei.toolView != null) {
                        ei.toolView.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.aqS.a((y) null);
                this.aqT.hide();
            } else if (aVar.id > 0) {
                b bVar = this.aqV.get(aVar.id);
                if (bVar != null) {
                    this.aqS.ee(aVar.id);
                    y ei2 = ei(aVar.id);
                    if (ei2 != null && ei2.toolPosition == 5) {
                        this.aqT.hide();
                        BC();
                    } else {
                        this.aqT.ee(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.aqX.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.aqV.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.aqW.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void BC() {
        boolean z;
        y ei;
        com.baidu.adp.lib.h.h.hj().removeCallbacks(this.arh);
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
        if (!z && (ei = ei(3)) != null && (ei.toolView instanceof View)) {
            com.baidu.adp.lib.util.k.c(getContext(), (View) ei.toolView);
        }
    }

    public void b(y yVar) {
        if (yVar != null) {
            this.aqU.add(yVar);
        }
    }

    private void clear() {
        this.aqS.clear();
        this.aqT.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.aqY = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.aqS.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.aqT.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        as.d(this, this.arb, i);
        this.aqS.onChangeSkinType(i);
        this.aqT.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.arj;
    }

    public void p(List<Integer> list) {
        this.arj.clear();
        this.arj.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Bv() {
        if (this.aqU != null && this.aqU.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (y yVar : this.aqU) {
                if (yVar.launcherIcon > 0) {
                    linkedList.add(yVar);
                }
                if (yVar.toolView != null) {
                    yVar.toolView.setToolId(yVar.id);
                    yVar.toolView.setEditorTools(this);
                    if (yVar.toolPosition == 6) {
                        this.aqT.a(yVar.toolView);
                    } else if (yVar.toolPosition == 1 || yVar.toolPosition == 2 || yVar.toolPosition == 3 || yVar.toolPosition == 4 || yVar.toolPosition == 5) {
                        this.aqS.a(yVar.toolView, yVar.toolPosition, !yVar.toolNeedAction);
                        if (yVar.toolPosition == 5 && ei(1) == null) {
                            z = true;
                        }
                    }
                    a(yVar.toolLaunchAction, yVar.id, yVar.toolView);
                }
            }
            Collections.sort(linkedList, new o(this));
            if (linkedList.size() > this.aqY) {
                v vVar = new v(getContext());
                if (this.arc > 0 && vVar.toolView != null && (vVar.toolView instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) vVar.toolView).setBackgroundColorId(this.arc);
                }
                if (this.aqZ > 0) {
                    vVar.launcherIcon = this.aqZ;
                }
                b(vVar);
                vVar.toolView.setToolId(vVar.id);
                vVar.toolView.setEditorTools(this);
                a(vVar.toolLaunchAction, vVar.id, vVar.toolView);
                this.aqT.a(vVar.toolView);
                if (this.ara) {
                    linkedList.add(this.aqY, vVar);
                } else {
                    linkedList.add(0, vVar);
                }
            }
            int i = this.aqY + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                y yVar2 = (y) it.next();
                if (i2 < i) {
                    this.aqS.a(a(yVar2, 1));
                } else {
                    this.aqT.a(a(yVar2, 2));
                }
                i2++;
            }
            if (z) {
                p pVar = new p();
                b(pVar);
                r a = a(pVar, 1);
                a.hide();
                this.aqS.a(0, a);
            }
            this.aqS.Bv();
            this.aqT.Bv();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.aqS.setLayoutParams(layoutParams);
            this.aqT.setLayoutParams(layoutParams);
            this.aqT.hide();
            removeAllViews();
            addView(this.aqS);
            addView(this.aqT);
            invalidate();
        }
    }

    public void c(y yVar) {
        if (yVar != null) {
            b(yVar);
            r a = a(yVar, 1);
            a.hide();
            if (this.aqS != null) {
                this.aqS.a(0, a);
                this.aqS.removeAllViews();
                this.aqS.Bv();
            }
            invalidate();
        }
    }

    public y ei(int i) {
        for (y yVar : this.aqU) {
            if (yVar.id == i) {
                return yVar;
            }
        }
        return null;
    }

    public List<y> getAllTools() {
        return this.aqU;
    }

    public r eg(int i) {
        r eg = this.aqS.eg(i);
        if (eg == null) {
            return this.aqT.eg(i);
        }
        return eg;
    }

    public void BD() {
        this.aqS.e(this.arg);
    }

    private r a(y yVar, int i) {
        r a = q.a(getContext(), yVar, i);
        if (a instanceof View) {
            ((View) a).setOnClickListener(this.arg);
        }
        return a;
    }

    public void bk(boolean z) {
        for (y yVar : this.aqU) {
            if (yVar != null && (yVar.toolView instanceof View) && ((View) yVar.toolView).getVisibility() == 0 && !yVar.toolNeedAction) {
                yVar.toolView.oD();
            }
        }
        if (this.ard) {
            this.ard = false;
            zY();
        }
        if (!Bx() && z) {
            com.baidu.adp.lib.h.h.hj().postDelayed(this.arh, 200L);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BE() {
        if (this.arf == null) {
            this.arf = new j(getResources().getString(n.i.editor_new_function_tips), "video_tips_show_config", 19, 2);
        }
        r eg = eg(this.arf.Bz());
        if ((eg instanceof View) && ei(this.arf.getToolId()) != null) {
            this.arf.f(getContext(), (View) eg);
        }
    }

    public void oD() {
        bk(true);
    }

    public void BF() {
        for (y yVar : this.aqU) {
            if (yVar != null && (yVar.toolView instanceof View) && ((View) yVar.toolView).getVisibility() == 0 && !yVar.toolNeedAction) {
                yVar.toolView.oD();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.arf != null) {
            this.arf.BA();
        }
        com.baidu.adp.lib.h.h.hj().removeCallbacks(this.ari);
        this.aqT.hide();
        setVisibility(8);
        BC();
    }

    public void zY() {
        this.aqT.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.aqS.setBarLauncherEnabled(z);
    }

    public boolean Bx() {
        return this.aqT.Bx();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.aqZ = i;
    }

    public void setBarLauncherType(int i) {
        this.aqS.setBarLauncherType(i);
    }

    public void setBarLinePostion(int i) {
        this.aqS.setLinePosition(i);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.ara = z;
    }

    public void setBackgroundColorId(int i) {
        this.arb = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.arc = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
