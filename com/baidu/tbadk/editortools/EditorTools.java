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
    private int dkb;
    public EditorBar dwJ;
    private EditorDesk dwK;
    private View dwL;
    private List<l> dwM;
    private SparseArray<b> dwN;
    private SparseArray<HashSet<b>> dwO;
    private SparseArray<HashSet<Integer>> dwP;
    private int dwQ;
    private boolean dwR;
    private int dwS;
    private boolean dwT;
    private LinkedList<g> dwU;
    private boolean dwV;
    private boolean dwW;
    private View.OnClickListener dwX;
    private Runnable dwY;
    private List<Integer> dwZ;

    public void aOx() {
        l mp = mp(3);
        if (mp != null && (mp.dwA instanceof View)) {
            View view = (View) mp.dwA;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.dwQ = 1;
        this.dwR = false;
        this.dkb = 0;
        this.dwS = 0;
        this.dwT = true;
        this.dwV = false;
        this.dwW = false;
        this.dwX = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.be(view);
            }
        };
        this.dwY = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aOx();
            }
        };
        this.dwZ = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.dwV = z;
    }

    public boolean aOy() {
        return this.dwV;
    }

    public boolean aOz() {
        return this.dwW;
    }

    public void setIsFromPb(boolean z) {
        this.dwW = z;
    }

    private void init(Context context) {
        this.dwM = new LinkedList();
        this.dwN = new SparseArray<>();
        this.dwO = new SparseArray<>();
        this.dwP = new SparseArray<>();
        this.dwJ = new EditorBar(context, this);
        this.dwK = new EditorDesk(context, this);
        this.dwU = new LinkedList<>();
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
                HashSet<b> hashSet = this.dwO.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.dwO.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.dwN.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.dwP.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.dwP.put(i3, hashSet2);
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
        l mp;
        if (aVar != null) {
            if (aVar.code == 2) {
                g mm = this.dwJ.mm(aVar.id);
                if (mm != null) {
                    z = false;
                } else {
                    mm = this.dwK.mm(aVar.id);
                    z = true;
                }
                if (mm == null) {
                    Iterator<g> it = this.dwU.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = mm;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (mp = mp(2)) != null && mp.dwA != null) {
                        mp.dwA.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.dwJ.a((l) null);
                aMQ();
            } else if (aVar.id > 0) {
                b bVar = this.dwN.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.dwJ.mk(aVar.id);
                    }
                    l mp2 = mp(aVar.id);
                    if (mp2 != null && mp2.dxr == 5) {
                        aMQ();
                        aOA();
                    } else {
                        this.dwK.mk(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.dwP.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.dwN.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.dwO.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void aOA() {
        boolean z;
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dwY);
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
            l mp = mp(3);
            if (mp != null && (mp.dwA instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) mp.dwA);
            }
            l mp2 = mp(28);
            if (mp2 != null && (mp2.dwA instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) mp2.dwA);
            }
        }
    }

    public void b(l lVar) {
        if (lVar != null) {
            this.dwM.add(lVar);
        }
    }

    private void clear() {
        this.dwJ.clear();
        this.dwK.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.dwQ = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.dwJ.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.dwK.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.dkb, i);
        this.dwJ.onChangeSkinType(i);
        this.dwK.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.dwZ;
    }

    public void aI(List<Integer> list) {
        this.dwZ.clear();
        this.dwZ.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.dwM != null && this.dwM.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (l lVar : this.dwM) {
                if (lVar.dxm > 0) {
                    linkedList.add(lVar);
                }
                if (lVar.dwA != null) {
                    lVar.dwA.setToolId(lVar.id);
                    lVar.dwA.setEditorTools(this);
                    if (lVar.dxr == 6) {
                        this.dwK.a(lVar.dwA);
                    } else if (lVar.dxr == 1 || lVar.dxr == 2 || lVar.dxr == 3 || lVar.dxr == 4 || lVar.dxr == 5) {
                        this.dwJ.a(lVar.dwA, lVar.dxr, !lVar.dxs);
                        if (lVar.dxr == 5 && mp(1) == null) {
                            z = true;
                        }
                    }
                    a(lVar.dxt, lVar.id, lVar.dwA);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<l>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(l lVar2, l lVar3) {
                    return lVar2.dxq - lVar3.dxq;
                }
            });
            if (linkedList.size() > this.dwQ) {
                if (this.dwW) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.dwS > 0 && iVar.dwA != null && (iVar.dwA instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.dwA).setBackgroundColorId(this.dwS);
                }
                b(iVar);
                iVar.dwA.setToolId(iVar.id);
                iVar.dwA.setEditorTools(this);
                a(iVar.dxt, iVar.id, iVar.dwA);
                this.dwK.a(iVar.dwA);
                if (this.dwR) {
                    linkedList.add(this.dwQ, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.dwQ + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                l lVar2 = (l) it.next();
                if (i2 < i) {
                    this.dwJ.a(a(lVar2, 1));
                } else {
                    this.dwK.a(a(lVar2, 2));
                }
                if ((lVar2 instanceof com.baidu.tbadk.editortools.a.a) && lVar2.dxq > this.dwQ) {
                    lVar2.dxm = R.drawable.icon_pure_more_at40_svg;
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.dwJ.a(0, a);
            }
            this.dwJ.build();
            this.dwK.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.dwJ.setLayoutParams(layoutParams);
            this.dwK.setLayoutParams(layoutParams);
            this.dwK.hide();
            if (this.dwW) {
                this.dwJ.setPadding(0, 0, 0, 0);
            }
            aMQ();
            removeAllViews();
            if (this.dwJ.getBarLauncherType() != 4) {
                aOB();
            }
            addView(this.dwJ);
            addView(this.dwK);
            invalidate();
        }
    }

    private void aOB() {
        if (this.dwL == null || this.dwL.getParent() != null) {
            this.dwL = new View(getContext());
            am.setBackgroundResource(this.dwL, R.drawable.bottom_view_shadow);
            this.dwL.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.dwL);
    }

    public void c(l lVar) {
        if (lVar != null) {
            b(lVar);
            g a = a(lVar, 1);
            a.hide();
            if (this.dwJ != null) {
                this.dwJ.a(0, a);
                this.dwJ.removeAllViews();
                this.dwJ.build();
            }
            invalidate();
        }
    }

    public l mp(int i) {
        for (l lVar : this.dwM) {
            if (lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public List<l> getAllTools() {
        return this.dwM;
    }

    public g mm(int i) {
        g mm = this.dwJ.mm(i);
        if (mm == null) {
            return this.dwK.mm(i);
        }
        return mm;
    }

    public void aOC() {
        this.dwJ.h(this.dwX);
    }

    private g a(l lVar, int i) {
        g a = f.a(getContext(), lVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(lVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.dwX);
        }
        return a;
    }

    public void gD(boolean z) {
        for (l lVar : this.dwM) {
            if (lVar != null && (lVar.dwA instanceof View) && ((View) lVar.dwA).getVisibility() == 0 && !lVar.dxs) {
                lVar.dwA.display();
            }
        }
        if (this.dwT) {
            this.dwT = false;
            aMQ();
        }
        if (!aOv() && z) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dwY, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        gD(true);
    }

    public void hide() {
        aMQ();
        setVisibility(8);
        aOA();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void aMQ() {
        this.dwK.hide();
        this.dwJ.a((l) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.dwJ.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.dwJ.setBarLauncherEnabled(z, i);
    }

    public boolean aOv() {
        return this.dwK.aOv();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.dwJ.setBarLauncherType(i);
    }

    public void gB(boolean z) {
        this.dwJ.gB(z);
    }

    public void gC(boolean z) {
        this.dwJ.gC(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.dwR = z;
    }

    public void setBackgroundColorId(int i) {
        this.dkb = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.dwS = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void be(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            l mp = mp(toolId);
            if (mp.lZ()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.dwJ.a(mp);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (mp.dwA == null) {
                    if (mp.dxt != null && mp.dxt.length > 0) {
                        b(new a(mp.dxt[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void aOD() {
        this.dwJ.a((l) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
