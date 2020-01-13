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
    private int dfU;
    public EditorBar dsC;
    private EditorDesk dsD;
    private View dsE;
    private List<l> dsF;
    private SparseArray<b> dsG;
    private SparseArray<HashSet<b>> dsH;
    private SparseArray<HashSet<Integer>> dsI;
    private int dsJ;
    private boolean dsK;
    private int dsL;
    private boolean dsM;
    private LinkedList<g> dsN;
    private boolean dsO;
    private boolean dsP;
    private View.OnClickListener dsQ;
    private Runnable dsR;
    private List<Integer> dsS;

    public void aLZ() {
        l lX = lX(3);
        if (lX != null && (lX.dss instanceof View)) {
            View view = (View) lX.dss;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.dsJ = 1;
        this.dsK = false;
        this.dfU = 0;
        this.dsL = 0;
        this.dsM = true;
        this.dsO = false;
        this.dsP = false;
        this.dsQ = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.be(view);
            }
        };
        this.dsR = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aLZ();
            }
        };
        this.dsS = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.dsO = z;
    }

    public boolean aMa() {
        return this.dsO;
    }

    public boolean aMb() {
        return this.dsP;
    }

    public void setIsFromPb(boolean z) {
        this.dsP = z;
    }

    private void init(Context context) {
        this.dsF = new LinkedList();
        this.dsG = new SparseArray<>();
        this.dsH = new SparseArray<>();
        this.dsI = new SparseArray<>();
        this.dsC = new EditorBar(context, this);
        this.dsD = new EditorDesk(context, this);
        this.dsN = new LinkedList<>();
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
                HashSet<b> hashSet = this.dsH.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.dsH.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.dsG.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.dsI.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.dsI.put(i3, hashSet2);
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
        l lX;
        if (aVar != null) {
            if (aVar.code == 2) {
                g lU = this.dsC.lU(aVar.id);
                if (lU != null) {
                    z = false;
                } else {
                    lU = this.dsD.lU(aVar.id);
                    z = true;
                }
                if (lU == null) {
                    Iterator<g> it = this.dsN.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = lU;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (lX = lX(2)) != null && lX.dss != null) {
                        lX.dss.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.dsC.a((l) null);
                aKs();
            } else if (aVar.id > 0) {
                b bVar = this.dsG.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.dsC.lS(aVar.id);
                    }
                    l lX2 = lX(aVar.id);
                    if (lX2 != null && lX2.dtk == 5) {
                        aKs();
                        aMc();
                    } else {
                        this.dsD.lS(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.dsI.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.dsG.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.dsH.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void aMc() {
        boolean z;
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dsR);
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
            l lX = lX(3);
            if (lX != null && (lX.dss instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) lX.dss);
            }
            l lX2 = lX(28);
            if (lX2 != null && (lX2.dss instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) lX2.dss);
            }
        }
    }

    public void b(l lVar) {
        if (lVar != null) {
            this.dsF.add(lVar);
        }
    }

    private void clear() {
        this.dsC.clear();
        this.dsD.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.dsJ = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.dsC.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.dsD.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.dfU, i);
        this.dsC.onChangeSkinType(i);
        this.dsD.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.dsS;
    }

    public void aI(List<Integer> list) {
        this.dsS.clear();
        this.dsS.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.dsF != null && this.dsF.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (l lVar : this.dsF) {
                if (lVar.dtf > 0) {
                    linkedList.add(lVar);
                }
                if (lVar.dss != null) {
                    lVar.dss.setToolId(lVar.id);
                    lVar.dss.setEditorTools(this);
                    if (lVar.dtk == 6) {
                        this.dsD.a(lVar.dss);
                    } else if (lVar.dtk == 1 || lVar.dtk == 2 || lVar.dtk == 3 || lVar.dtk == 4 || lVar.dtk == 5) {
                        this.dsC.a(lVar.dss, lVar.dtk, !lVar.dtl);
                        if (lVar.dtk == 5 && lX(1) == null) {
                            z = true;
                        }
                    }
                    a(lVar.dtm, lVar.id, lVar.dss);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<l>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(l lVar2, l lVar3) {
                    return lVar2.dtj - lVar3.dtj;
                }
            });
            if (linkedList.size() > this.dsJ) {
                if (this.dsP) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.dsL > 0 && iVar.dss != null && (iVar.dss instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.dss).setBackgroundColorId(this.dsL);
                }
                b(iVar);
                iVar.dss.setToolId(iVar.id);
                iVar.dss.setEditorTools(this);
                a(iVar.dtm, iVar.id, iVar.dss);
                this.dsD.a(iVar.dss);
                if (this.dsK) {
                    linkedList.add(this.dsJ, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.dsJ + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                l lVar2 = (l) it.next();
                if (i2 < i) {
                    this.dsC.a(a(lVar2, 1));
                } else {
                    this.dsD.a(a(lVar2, 2));
                }
                if ((lVar2 instanceof com.baidu.tbadk.editortools.a.a) && lVar2.dtj > this.dsJ) {
                    lVar2.dtf = R.drawable.icon_pure_more_at40_svg;
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.dsC.a(0, a);
            }
            this.dsC.build();
            this.dsD.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.dsC.setLayoutParams(layoutParams);
            this.dsD.setLayoutParams(layoutParams);
            this.dsD.hide();
            if (this.dsP) {
                this.dsC.setPadding(0, 0, 0, 0);
            }
            aKs();
            removeAllViews();
            if (this.dsC.getBarLauncherType() != 4) {
                aMd();
            }
            addView(this.dsC);
            addView(this.dsD);
            invalidate();
        }
    }

    private void aMd() {
        if (this.dsE == null || this.dsE.getParent() != null) {
            this.dsE = new View(getContext());
            am.setBackgroundResource(this.dsE, R.drawable.bottom_view_shadow);
            this.dsE.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.dsE);
    }

    public void c(l lVar) {
        if (lVar != null) {
            b(lVar);
            g a = a(lVar, 1);
            a.hide();
            if (this.dsC != null) {
                this.dsC.a(0, a);
                this.dsC.removeAllViews();
                this.dsC.build();
            }
            invalidate();
        }
    }

    public l lX(int i) {
        for (l lVar : this.dsF) {
            if (lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public List<l> getAllTools() {
        return this.dsF;
    }

    public g lU(int i) {
        g lU = this.dsC.lU(i);
        if (lU == null) {
            return this.dsD.lU(i);
        }
        return lU;
    }

    public void aMe() {
        this.dsC.h(this.dsQ);
    }

    private g a(l lVar, int i) {
        g a = f.a(getContext(), lVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(lVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.dsQ);
        }
        return a;
    }

    public void gw(boolean z) {
        for (l lVar : this.dsF) {
            if (lVar != null && (lVar.dss instanceof View) && ((View) lVar.dss).getVisibility() == 0 && !lVar.dtl) {
                lVar.dss.display();
            }
        }
        if (this.dsM) {
            this.dsM = false;
            aKs();
        }
        if (!aLX() && z) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dsR, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        gw(true);
    }

    public void hide() {
        aKs();
        setVisibility(8);
        aMc();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void aKs() {
        this.dsD.hide();
        this.dsC.a((l) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.dsC.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.dsC.setBarLauncherEnabled(z, i);
    }

    public boolean aLX() {
        return this.dsD.aLX();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.dsC.setBarLauncherType(i);
    }

    public void gu(boolean z) {
        this.dsC.gu(z);
    }

    public void gv(boolean z) {
        this.dsC.gv(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.dsK = z;
    }

    public void setBackgroundColorId(int i) {
        this.dfU = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.dsL = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void be(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            l lX = lX(toolId);
            if (lX.lK()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.dsC.a(lX);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (lX.dss == null) {
                    if (lX.dtm != null && lX.dtm.length > 0) {
                        b(new a(lX.dtm[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void aMf() {
        this.dsC.a((l) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
