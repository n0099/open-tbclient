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
    private int dKz;
    public EditorBar dWV;
    private EditorDesk dWW;
    private View dWX;
    private List<l> dWY;
    private SparseArray<b> dWZ;
    private SparseArray<HashSet<b>> dXa;
    private SparseArray<HashSet<Integer>> dXb;
    private int dXc;
    private boolean dXd;
    private int dXe;
    private boolean dXf;
    private LinkedList<g> dXg;
    private boolean dXh;
    private boolean dXi;
    private View.OnClickListener dXj;
    private Runnable dXk;
    private List<Integer> dXl;

    public void aWR() {
        l mD = mD(3);
        if (mD != null && (mD.dWM instanceof View)) {
            View view = (View) mD.dWM;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.dXc = 1;
        this.dXd = false;
        this.dKz = 0;
        this.dXe = 0;
        this.dXf = true;
        this.dXh = false;
        this.dXi = false;
        this.dXj = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bf(view);
            }
        };
        this.dXk = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aWR();
            }
        };
        this.dXl = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.dXh = z;
    }

    public boolean aWS() {
        return this.dXh;
    }

    public boolean aWT() {
        return this.dXi;
    }

    public void setIsFromPb(boolean z) {
        this.dXi = z;
    }

    private void init(Context context) {
        this.dWY = new LinkedList();
        this.dWZ = new SparseArray<>();
        this.dXa = new SparseArray<>();
        this.dXb = new SparseArray<>();
        this.dWV = new EditorBar(context, this);
        this.dWW = new EditorDesk(context, this);
        this.dXg = new LinkedList<>();
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
                HashSet<b> hashSet = this.dXa.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.dXa.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.dWZ.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.dXb.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.dXb.put(i3, hashSet2);
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
        l mD;
        if (aVar != null) {
            if (aVar.code == 2) {
                g mA = this.dWV.mA(aVar.id);
                if (mA != null) {
                    z = false;
                } else {
                    mA = this.dWW.mA(aVar.id);
                    z = true;
                }
                if (mA == null) {
                    Iterator<g> it = this.dXg.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = mA;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (mD = mD(2)) != null && mD.dWM != null) {
                        mD.dWM.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.dWV.a((l) null);
                aVq();
            } else if (aVar.id > 0) {
                b bVar = this.dWZ.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.dWV.my(aVar.id);
                    }
                    l mD2 = mD(aVar.id);
                    if (mD2 != null && mD2.dXD == 5) {
                        aVq();
                        aWU();
                    } else {
                        this.dWW.my(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.dXb.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.dWZ.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.dXa.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void aWU() {
        boolean z;
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.dXk);
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
            l mD = mD(3);
            if (mD != null && (mD.dWM instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) mD.dWM);
            }
            l mD2 = mD(28);
            if (mD2 != null && (mD2.dWM instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) mD2.dWM);
            }
        }
    }

    public void b(l lVar) {
        if (lVar != null) {
            this.dWY.add(lVar);
        }
    }

    private void clear() {
        this.dWV.clear();
        this.dWW.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.dXc = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.dWV.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.dWW.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.dKz, i);
        this.dWV.onChangeSkinType(i);
        this.dWW.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.dXl;
    }

    public void aR(List<Integer> list) {
        this.dXl.clear();
        this.dXl.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.dWY != null && this.dWY.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (l lVar : this.dWY) {
                if (lVar.dXy > 0) {
                    linkedList.add(lVar);
                }
                if (lVar.dWM != null) {
                    lVar.dWM.setToolId(lVar.id);
                    lVar.dWM.setEditorTools(this);
                    if (lVar.dXD == 6) {
                        this.dWW.a(lVar.dWM);
                    } else if (lVar.dXD == 1 || lVar.dXD == 2 || lVar.dXD == 3 || lVar.dXD == 4 || lVar.dXD == 5) {
                        this.dWV.a(lVar.dWM, lVar.dXD, !lVar.dXE);
                        if (lVar.dXD == 5 && mD(1) == null) {
                            z = true;
                        }
                    }
                    a(lVar.dXF, lVar.id, lVar.dWM);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<l>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(l lVar2, l lVar3) {
                    return lVar2.dXC - lVar3.dXC;
                }
            });
            if (linkedList.size() > this.dXc) {
                if (this.dXi) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.dXe > 0 && iVar.dWM != null && (iVar.dWM instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.dWM).setBackgroundColorId(this.dXe);
                }
                b(iVar);
                iVar.dWM.setToolId(iVar.id);
                iVar.dWM.setEditorTools(this);
                a(iVar.dXF, iVar.id, iVar.dWM);
                this.dWW.a(iVar.dWM);
                if (this.dXd) {
                    linkedList.add(this.dXc, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.dXc + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                l lVar2 = (l) it.next();
                if (i2 < i) {
                    this.dWV.a(a(lVar2, 1));
                } else {
                    this.dWW.a(a(lVar2, 2));
                }
                if ((lVar2 instanceof com.baidu.tbadk.editortools.a.a) && lVar2.dXC > this.dXc) {
                    lVar2.dXy = R.drawable.icon_pure_more_at40_svg;
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.dWV.a(0, a);
            }
            this.dWV.build();
            this.dWW.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.dWV.setLayoutParams(layoutParams);
            this.dWW.setLayoutParams(layoutParams);
            this.dWW.hide();
            if (this.dXi) {
                this.dWV.setPadding(0, 0, 0, 0);
            }
            aVq();
            removeAllViews();
            if (this.dWV.getBarLauncherType() != 4) {
                aWV();
            }
            addView(this.dWV);
            addView(this.dWW);
            invalidate();
        }
    }

    private void aWV() {
        if (this.dWX == null || this.dWX.getParent() != null) {
            this.dWX = new View(getContext());
            am.setBackgroundResource(this.dWX, R.drawable.bottom_view_shadow);
            this.dWX.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.dWX);
    }

    public void c(l lVar) {
        if (lVar != null) {
            b(lVar);
            g a = a(lVar, 1);
            a.hide();
            if (this.dWV != null) {
                this.dWV.a(0, a);
                this.dWV.removeAllViews();
                this.dWV.build();
            }
            invalidate();
        }
    }

    public l mD(int i) {
        for (l lVar : this.dWY) {
            if (lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public List<l> getAllTools() {
        return this.dWY;
    }

    public g mA(int i) {
        g mA = this.dWV.mA(i);
        if (mA == null) {
            return this.dWW.mA(i);
        }
        return mA;
    }

    public void aWW() {
        this.dWV.h(this.dXj);
    }

    private g a(l lVar, int i) {
        g a = f.a(getContext(), lVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(lVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.dXj);
        }
        return a;
    }

    public void hC(boolean z) {
        for (l lVar : this.dWY) {
            if (lVar != null && (lVar.dWM instanceof View) && ((View) lVar.dWM).getVisibility() == 0 && !lVar.dXE) {
                lVar.dWM.display();
            }
        }
        if (this.dXf) {
            this.dXf = false;
            aVq();
        }
        if (!aWP() && z) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.dXk, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        hC(true);
    }

    public void hide() {
        aVq();
        setVisibility(8);
        aWU();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void aVq() {
        this.dWW.hide();
        this.dWV.a((l) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.dWV.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.dWV.setBarLauncherEnabled(z, i);
    }

    public boolean aWP() {
        return this.dWW.aWP();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.dWV.setBarLauncherType(i);
    }

    public void hA(boolean z) {
        this.dWV.hA(z);
    }

    public void hB(boolean z) {
        this.dWV.hB(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.dXd = z;
    }

    public void setBackgroundColorId(int i) {
        this.dKz = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.dXe = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bf(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            l mD = mD(toolId);
            if (mD.qB()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.dWV.a(mD);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (mD.dWM == null) {
                    if (mD.dXF != null && mD.dXF.length > 0) {
                        b(new a(mD.dXF[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void aWX() {
        this.dWV.a((l) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
