package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorTools extends LinearLayout {
    private int dkB;
    public EditorBar dxj;
    private EditorDesk dxk;
    private View dxl;
    private List<l> dxm;
    private SparseArray<b> dxn;
    private SparseArray<HashSet<b>> dxo;
    private SparseArray<HashSet<Integer>> dxp;
    private int dxq;
    private boolean dxr;
    private int dxs;
    private boolean dxt;
    private LinkedList<g> dxu;
    private boolean dxv;
    private boolean dxw;
    private View.OnClickListener dxx;
    private Runnable dxy;
    private List<Integer> dxz;

    public void aOC() {
        l mr = mr(3);
        if (mr != null && (mr.dxa instanceof View)) {
            View view = (View) mr.dxa;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.dxq = 1;
        this.dxr = false;
        this.dkB = 0;
        this.dxs = 0;
        this.dxt = true;
        this.dxv = false;
        this.dxw = false;
        this.dxx = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.be(view);
            }
        };
        this.dxy = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aOC();
            }
        };
        this.dxz = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.dxv = z;
    }

    public boolean aOD() {
        return this.dxv;
    }

    public boolean aOE() {
        return this.dxw;
    }

    public void setIsFromPb(boolean z) {
        this.dxw = z;
    }

    private void init(Context context) {
        this.dxm = new LinkedList();
        this.dxn = new SparseArray<>();
        this.dxo = new SparseArray<>();
        this.dxp = new SparseArray<>();
        this.dxj = new EditorBar(context, this);
        this.dxk = new EditorDesk(context, this);
        this.dxu = new LinkedList<>();
        setOrientation(1);
    }

    public void setActionListener(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    public void setActionListener(int[] iArr, b bVar) {
        a(iArr, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.dxo.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.dxo.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.dxn.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.dxp.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.dxp.put(i3, hashSet2);
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
        g gVar;
        l mr;
        if (aVar != null) {
            if (aVar.code == 2) {
                g mo = this.dxj.mo(aVar.id);
                if (mo != null) {
                    z = false;
                } else {
                    mo = this.dxk.mo(aVar.id);
                    z = true;
                }
                if (mo == null) {
                    Iterator<g> it = this.dxu.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = mo;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (mr = mr(2)) != null && mr.dxa != null) {
                        mr.dxa.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.dxj.a((l) null);
                aMV();
            } else if (aVar.id > 0) {
                b bVar = this.dxn.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.dxj.mm(aVar.id);
                    }
                    l mr2 = mr(aVar.id);
                    if (mr2 != null && mr2.dxR == 5) {
                        aMV();
                        aOF();
                    } else {
                        this.dxk.mm(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.dxp.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.dxn.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.dxo.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void aOF() {
        boolean z;
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dxy);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z) {
            l mr = mr(3);
            if (mr != null && (mr.dxa instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) mr.dxa);
            }
            l mr2 = mr(28);
            if (mr2 != null && (mr2.dxa instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) mr2.dxa);
            }
        }
    }

    public void b(l lVar) {
        if (lVar != null) {
            this.dxm.add(lVar);
        }
    }

    private void clear() {
        this.dxj.clear();
        this.dxk.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.dxq = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.dxj.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.dxk.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.dkB, i);
        this.dxj.onChangeSkinType(i);
        this.dxk.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.dxz;
    }

    public void aI(List<Integer> list) {
        this.dxz.clear();
        this.dxz.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.dxm != null && this.dxm.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (l lVar : this.dxm) {
                if (lVar.dxM > 0) {
                    linkedList.add(lVar);
                }
                if (lVar.dxa != null) {
                    lVar.dxa.setToolId(lVar.id);
                    lVar.dxa.setEditorTools(this);
                    if (lVar.dxR == 6) {
                        this.dxk.a(lVar.dxa);
                    } else if (lVar.dxR == 1 || lVar.dxR == 2 || lVar.dxR == 3 || lVar.dxR == 4 || lVar.dxR == 5) {
                        this.dxj.a(lVar.dxa, lVar.dxR, !lVar.dxS);
                        if (lVar.dxR == 5 && mr(1) == null) {
                            z = true;
                        }
                    }
                    a(lVar.dxT, lVar.id, lVar.dxa);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<l>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(l lVar2, l lVar3) {
                    return lVar2.dxQ - lVar3.dxQ;
                }
            });
            if (linkedList.size() > this.dxq) {
                if (this.dxw) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.dxs > 0 && iVar.dxa != null && (iVar.dxa instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.dxa).setBackgroundColorId(this.dxs);
                }
                b(iVar);
                iVar.dxa.setToolId(iVar.id);
                iVar.dxa.setEditorTools(this);
                a(iVar.dxT, iVar.id, iVar.dxa);
                this.dxk.a(iVar.dxa);
                if (this.dxr) {
                    linkedList.add(this.dxq, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.dxq + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                l lVar2 = (l) it.next();
                if (i2 < i) {
                    this.dxj.a(a(lVar2, 1));
                } else {
                    this.dxk.a(a(lVar2, 2));
                }
                if ((lVar2 instanceof com.baidu.tbadk.editortools.a.a) && lVar2.dxQ > this.dxq) {
                    lVar2.dxM = R.drawable.icon_pure_more_at40_svg;
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.dxj.a(0, a);
            }
            this.dxj.build();
            this.dxk.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.dxj.setLayoutParams(layoutParams);
            this.dxk.setLayoutParams(layoutParams);
            this.dxk.hide();
            if (this.dxw) {
                this.dxj.setPadding(0, 0, 0, 0);
            }
            aMV();
            removeAllViews();
            if (this.dxj.getBarLauncherType() != 4) {
                aOG();
            }
            addView(this.dxj);
            addView(this.dxk);
            invalidate();
        }
    }

    private void aOG() {
        if (this.dxl == null || this.dxl.getParent() != null) {
            this.dxl = new View(getContext());
            am.setBackgroundResource(this.dxl, R.drawable.bottom_view_shadow);
            this.dxl.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.dxl);
    }

    public void c(l lVar) {
        if (lVar != null) {
            b(lVar);
            g a = a(lVar, 1);
            a.hide();
            if (this.dxj != null) {
                this.dxj.a(0, a);
                this.dxj.removeAllViews();
                this.dxj.build();
            }
            invalidate();
        }
    }

    public l mr(int i) {
        for (l lVar : this.dxm) {
            if (lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public List<l> getAllTools() {
        return this.dxm;
    }

    public g mo(int i) {
        g mo = this.dxj.mo(i);
        if (mo == null) {
            return this.dxk.mo(i);
        }
        return mo;
    }

    public void aOH() {
        this.dxj.h(this.dxx);
    }

    private g a(l lVar, int i) {
        g a = f.a(getContext(), lVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(lVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.dxx);
        }
        return a;
    }

    public void gE(boolean z) {
        for (l lVar : this.dxm) {
            if (lVar != null && (lVar.dxa instanceof View) && ((View) lVar.dxa).getVisibility() == 0 && !lVar.dxS) {
                lVar.dxa.display();
            }
        }
        if (this.dxt) {
            this.dxt = false;
            aMV();
        }
        if (!aOA() && z) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dxy, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        gE(true);
    }

    public void hide() {
        aMV();
        setVisibility(8);
        aOF();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void aMV() {
        this.dxk.hide();
        this.dxj.a((l) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.dxj.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.dxj.setBarLauncherEnabled(z, i);
    }

    public boolean aOA() {
        return this.dxk.aOA();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.dxj.setBarLauncherType(i);
    }

    public void gC(boolean z) {
        this.dxj.gC(z);
    }

    public void gD(boolean z) {
        this.dxj.gD(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.dxr = z;
    }

    public void setBackgroundColorId(int i) {
        this.dkB = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.dxs = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void be(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            l mr = mr(toolId);
            if (mr.lZ()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.dxj.a(mr);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (mr.dxa == null) {
                    if (mr.dxT != null && mr.dxT.length > 0) {
                        b(new a(mr.dxT[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void aOI() {
        this.dxj.a((l) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
