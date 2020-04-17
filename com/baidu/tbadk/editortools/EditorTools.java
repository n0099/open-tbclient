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
    private int dKv;
    public EditorBar dWQ;
    private EditorDesk dWR;
    private View dWS;
    private List<l> dWT;
    private SparseArray<b> dWU;
    private SparseArray<HashSet<b>> dWV;
    private SparseArray<HashSet<Integer>> dWW;
    private int dWX;
    private boolean dWY;
    private int dWZ;
    private boolean dXa;
    private LinkedList<g> dXb;
    private boolean dXc;
    private boolean dXd;
    private View.OnClickListener dXe;
    private Runnable dXf;
    private List<Integer> dXg;

    public void aWT() {
        l mD = mD(3);
        if (mD != null && (mD.dWH instanceof View)) {
            View view = (View) mD.dWH;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.dWX = 1;
        this.dWY = false;
        this.dKv = 0;
        this.dWZ = 0;
        this.dXa = true;
        this.dXc = false;
        this.dXd = false;
        this.dXe = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bf(view);
            }
        };
        this.dXf = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aWT();
            }
        };
        this.dXg = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.dXc = z;
    }

    public boolean aWU() {
        return this.dXc;
    }

    public boolean aWV() {
        return this.dXd;
    }

    public void setIsFromPb(boolean z) {
        this.dXd = z;
    }

    private void init(Context context) {
        this.dWT = new LinkedList();
        this.dWU = new SparseArray<>();
        this.dWV = new SparseArray<>();
        this.dWW = new SparseArray<>();
        this.dWQ = new EditorBar(context, this);
        this.dWR = new EditorDesk(context, this);
        this.dXb = new LinkedList<>();
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
                HashSet<b> hashSet = this.dWV.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.dWV.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.dWU.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.dWW.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.dWW.put(i3, hashSet2);
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
                g mA = this.dWQ.mA(aVar.id);
                if (mA != null) {
                    z = false;
                } else {
                    mA = this.dWR.mA(aVar.id);
                    z = true;
                }
                if (mA == null) {
                    Iterator<g> it = this.dXb.iterator();
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
                    if (z && (mD = mD(2)) != null && mD.dWH != null) {
                        mD.dWH.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.dWQ.a((l) null);
                aVs();
            } else if (aVar.id > 0) {
                b bVar = this.dWU.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.dWQ.my(aVar.id);
                    }
                    l mD2 = mD(aVar.id);
                    if (mD2 != null && mD2.dXy == 5) {
                        aVs();
                        aWW();
                    } else {
                        this.dWR.my(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.dWW.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.dWU.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.dWV.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void aWW() {
        boolean z;
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.dXf);
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
            if (mD != null && (mD.dWH instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) mD.dWH);
            }
            l mD2 = mD(28);
            if (mD2 != null && (mD2.dWH instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) mD2.dWH);
            }
        }
    }

    public void b(l lVar) {
        if (lVar != null) {
            this.dWT.add(lVar);
        }
    }

    private void clear() {
        this.dWQ.clear();
        this.dWR.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.dWX = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.dWQ.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.dWR.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.dKv, i);
        this.dWQ.onChangeSkinType(i);
        this.dWR.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.dXg;
    }

    public void aR(List<Integer> list) {
        this.dXg.clear();
        this.dXg.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.dWT != null && this.dWT.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (l lVar : this.dWT) {
                if (lVar.dXt > 0) {
                    linkedList.add(lVar);
                }
                if (lVar.dWH != null) {
                    lVar.dWH.setToolId(lVar.id);
                    lVar.dWH.setEditorTools(this);
                    if (lVar.dXy == 6) {
                        this.dWR.a(lVar.dWH);
                    } else if (lVar.dXy == 1 || lVar.dXy == 2 || lVar.dXy == 3 || lVar.dXy == 4 || lVar.dXy == 5) {
                        this.dWQ.a(lVar.dWH, lVar.dXy, !lVar.dXz);
                        if (lVar.dXy == 5 && mD(1) == null) {
                            z = true;
                        }
                    }
                    a(lVar.dXA, lVar.id, lVar.dWH);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<l>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(l lVar2, l lVar3) {
                    return lVar2.dXx - lVar3.dXx;
                }
            });
            if (linkedList.size() > this.dWX) {
                if (this.dXd) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.dWZ > 0 && iVar.dWH != null && (iVar.dWH instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.dWH).setBackgroundColorId(this.dWZ);
                }
                b(iVar);
                iVar.dWH.setToolId(iVar.id);
                iVar.dWH.setEditorTools(this);
                a(iVar.dXA, iVar.id, iVar.dWH);
                this.dWR.a(iVar.dWH);
                if (this.dWY) {
                    linkedList.add(this.dWX, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.dWX + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                l lVar2 = (l) it.next();
                if (i2 < i) {
                    this.dWQ.a(a(lVar2, 1));
                } else {
                    this.dWR.a(a(lVar2, 2));
                }
                if ((lVar2 instanceof com.baidu.tbadk.editortools.a.a) && lVar2.dXx > this.dWX) {
                    lVar2.dXt = R.drawable.icon_pure_more_at40_svg;
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.dWQ.a(0, a);
            }
            this.dWQ.build();
            this.dWR.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.dWQ.setLayoutParams(layoutParams);
            this.dWR.setLayoutParams(layoutParams);
            this.dWR.hide();
            if (this.dXd) {
                this.dWQ.setPadding(0, 0, 0, 0);
            }
            aVs();
            removeAllViews();
            if (this.dWQ.getBarLauncherType() != 4) {
                aWX();
            }
            addView(this.dWQ);
            addView(this.dWR);
            invalidate();
        }
    }

    private void aWX() {
        if (this.dWS == null || this.dWS.getParent() != null) {
            this.dWS = new View(getContext());
            am.setBackgroundResource(this.dWS, R.drawable.bottom_view_shadow);
            this.dWS.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.dWS);
    }

    public void c(l lVar) {
        if (lVar != null) {
            b(lVar);
            g a = a(lVar, 1);
            a.hide();
            if (this.dWQ != null) {
                this.dWQ.a(0, a);
                this.dWQ.removeAllViews();
                this.dWQ.build();
            }
            invalidate();
        }
    }

    public l mD(int i) {
        for (l lVar : this.dWT) {
            if (lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public List<l> getAllTools() {
        return this.dWT;
    }

    public g mA(int i) {
        g mA = this.dWQ.mA(i);
        if (mA == null) {
            return this.dWR.mA(i);
        }
        return mA;
    }

    public void aWY() {
        this.dWQ.h(this.dXe);
    }

    private g a(l lVar, int i) {
        g a = f.a(getContext(), lVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(lVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.dXe);
        }
        return a;
    }

    public void hC(boolean z) {
        for (l lVar : this.dWT) {
            if (lVar != null && (lVar.dWH instanceof View) && ((View) lVar.dWH).getVisibility() == 0 && !lVar.dXz) {
                lVar.dWH.display();
            }
        }
        if (this.dXa) {
            this.dXa = false;
            aVs();
        }
        if (!aWR() && z) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.dXf, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        hC(true);
    }

    public void hide() {
        aVs();
        setVisibility(8);
        aWW();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void aVs() {
        this.dWR.hide();
        this.dWQ.a((l) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.dWQ.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.dWQ.setBarLauncherEnabled(z, i);
    }

    public boolean aWR() {
        return this.dWR.aWR();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.dWQ.setBarLauncherType(i);
    }

    public void hA(boolean z) {
        this.dWQ.hA(z);
    }

    public void hB(boolean z) {
        this.dWQ.hB(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.dWY = z;
    }

    public void setBackgroundColorId(int i) {
        this.dKv = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.dWZ = i;
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
                this.dWQ.a(mD);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (mD.dWH == null) {
                    if (mD.dXA != null && mD.dXA.length > 0) {
                        b(new a(mD.dXA[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void aWZ() {
        this.dWQ.a((l) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
