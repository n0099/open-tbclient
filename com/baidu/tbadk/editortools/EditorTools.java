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
    private int dka;
    public EditorBar dwI;
    private EditorDesk dwJ;
    private View dwK;
    private List<l> dwL;
    private SparseArray<b> dwM;
    private SparseArray<HashSet<b>> dwN;
    private SparseArray<HashSet<Integer>> dwO;
    private int dwP;
    private boolean dwQ;
    private int dwR;
    private boolean dwS;
    private LinkedList<g> dwT;
    private boolean dwU;
    private boolean dwV;
    private View.OnClickListener dwW;
    private Runnable dwX;
    private List<Integer> dwY;

    public void aOv() {
        l mp = mp(3);
        if (mp != null && (mp.dwz instanceof View)) {
            View view = (View) mp.dwz;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.dwP = 1;
        this.dwQ = false;
        this.dka = 0;
        this.dwR = 0;
        this.dwS = true;
        this.dwU = false;
        this.dwV = false;
        this.dwW = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.be(view);
            }
        };
        this.dwX = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aOv();
            }
        };
        this.dwY = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.dwU = z;
    }

    public boolean aOw() {
        return this.dwU;
    }

    public boolean aOx() {
        return this.dwV;
    }

    public void setIsFromPb(boolean z) {
        this.dwV = z;
    }

    private void init(Context context) {
        this.dwL = new LinkedList();
        this.dwM = new SparseArray<>();
        this.dwN = new SparseArray<>();
        this.dwO = new SparseArray<>();
        this.dwI = new EditorBar(context, this);
        this.dwJ = new EditorDesk(context, this);
        this.dwT = new LinkedList<>();
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
                HashSet<b> hashSet = this.dwN.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.dwN.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.dwM.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.dwO.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.dwO.put(i3, hashSet2);
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
                g mm = this.dwI.mm(aVar.id);
                if (mm != null) {
                    z = false;
                } else {
                    mm = this.dwJ.mm(aVar.id);
                    z = true;
                }
                if (mm == null) {
                    Iterator<g> it = this.dwT.iterator();
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
                    if (z && (mp = mp(2)) != null && mp.dwz != null) {
                        mp.dwz.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.dwI.a((l) null);
                aMO();
            } else if (aVar.id > 0) {
                b bVar = this.dwM.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.dwI.mk(aVar.id);
                    }
                    l mp2 = mp(aVar.id);
                    if (mp2 != null && mp2.dxq == 5) {
                        aMO();
                        aOy();
                    } else {
                        this.dwJ.mk(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.dwO.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.dwM.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.dwN.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void aOy() {
        boolean z;
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dwX);
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
            if (mp != null && (mp.dwz instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) mp.dwz);
            }
            l mp2 = mp(28);
            if (mp2 != null && (mp2.dwz instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) mp2.dwz);
            }
        }
    }

    public void b(l lVar) {
        if (lVar != null) {
            this.dwL.add(lVar);
        }
    }

    private void clear() {
        this.dwI.clear();
        this.dwJ.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.dwP = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.dwI.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.dwJ.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.dka, i);
        this.dwI.onChangeSkinType(i);
        this.dwJ.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.dwY;
    }

    public void aI(List<Integer> list) {
        this.dwY.clear();
        this.dwY.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.dwL != null && this.dwL.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (l lVar : this.dwL) {
                if (lVar.dxl > 0) {
                    linkedList.add(lVar);
                }
                if (lVar.dwz != null) {
                    lVar.dwz.setToolId(lVar.id);
                    lVar.dwz.setEditorTools(this);
                    if (lVar.dxq == 6) {
                        this.dwJ.a(lVar.dwz);
                    } else if (lVar.dxq == 1 || lVar.dxq == 2 || lVar.dxq == 3 || lVar.dxq == 4 || lVar.dxq == 5) {
                        this.dwI.a(lVar.dwz, lVar.dxq, !lVar.dxr);
                        if (lVar.dxq == 5 && mp(1) == null) {
                            z = true;
                        }
                    }
                    a(lVar.dxs, lVar.id, lVar.dwz);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<l>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(l lVar2, l lVar3) {
                    return lVar2.dxp - lVar3.dxp;
                }
            });
            if (linkedList.size() > this.dwP) {
                if (this.dwV) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.dwR > 0 && iVar.dwz != null && (iVar.dwz instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.dwz).setBackgroundColorId(this.dwR);
                }
                b(iVar);
                iVar.dwz.setToolId(iVar.id);
                iVar.dwz.setEditorTools(this);
                a(iVar.dxs, iVar.id, iVar.dwz);
                this.dwJ.a(iVar.dwz);
                if (this.dwQ) {
                    linkedList.add(this.dwP, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.dwP + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                l lVar2 = (l) it.next();
                if (i2 < i) {
                    this.dwI.a(a(lVar2, 1));
                } else {
                    this.dwJ.a(a(lVar2, 2));
                }
                if ((lVar2 instanceof com.baidu.tbadk.editortools.a.a) && lVar2.dxp > this.dwP) {
                    lVar2.dxl = R.drawable.icon_pure_more_at40_svg;
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.dwI.a(0, a);
            }
            this.dwI.build();
            this.dwJ.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.dwI.setLayoutParams(layoutParams);
            this.dwJ.setLayoutParams(layoutParams);
            this.dwJ.hide();
            if (this.dwV) {
                this.dwI.setPadding(0, 0, 0, 0);
            }
            aMO();
            removeAllViews();
            if (this.dwI.getBarLauncherType() != 4) {
                aOz();
            }
            addView(this.dwI);
            addView(this.dwJ);
            invalidate();
        }
    }

    private void aOz() {
        if (this.dwK == null || this.dwK.getParent() != null) {
            this.dwK = new View(getContext());
            am.setBackgroundResource(this.dwK, R.drawable.bottom_view_shadow);
            this.dwK.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.dwK);
    }

    public void c(l lVar) {
        if (lVar != null) {
            b(lVar);
            g a = a(lVar, 1);
            a.hide();
            if (this.dwI != null) {
                this.dwI.a(0, a);
                this.dwI.removeAllViews();
                this.dwI.build();
            }
            invalidate();
        }
    }

    public l mp(int i) {
        for (l lVar : this.dwL) {
            if (lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public List<l> getAllTools() {
        return this.dwL;
    }

    public g mm(int i) {
        g mm = this.dwI.mm(i);
        if (mm == null) {
            return this.dwJ.mm(i);
        }
        return mm;
    }

    public void aOA() {
        this.dwI.h(this.dwW);
    }

    private g a(l lVar, int i) {
        g a = f.a(getContext(), lVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(lVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.dwW);
        }
        return a;
    }

    public void gD(boolean z) {
        for (l lVar : this.dwL) {
            if (lVar != null && (lVar.dwz instanceof View) && ((View) lVar.dwz).getVisibility() == 0 && !lVar.dxr) {
                lVar.dwz.display();
            }
        }
        if (this.dwS) {
            this.dwS = false;
            aMO();
        }
        if (!aOt() && z) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dwX, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        gD(true);
    }

    public void hide() {
        aMO();
        setVisibility(8);
        aOy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void aMO() {
        this.dwJ.hide();
        this.dwI.a((l) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.dwI.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.dwI.setBarLauncherEnabled(z, i);
    }

    public boolean aOt() {
        return this.dwJ.aOt();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.dwI.setBarLauncherType(i);
    }

    public void gB(boolean z) {
        this.dwI.gB(z);
    }

    public void gC(boolean z) {
        this.dwI.gC(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.dwQ = z;
    }

    public void setBackgroundColorId(int i) {
        this.dka = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.dwR = i;
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
                this.dwI.a(mp);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (mp.dwz == null) {
                    if (mp.dxs != null && mp.dxs.length > 0) {
                        b(new a(mp.dxs[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void aOB() {
        this.dwI.a((l) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
