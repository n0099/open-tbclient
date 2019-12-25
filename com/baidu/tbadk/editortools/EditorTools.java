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
    private int dfI;
    private int dsA;
    private boolean dsB;
    private LinkedList<g> dsC;
    private boolean dsD;
    private boolean dsE;
    private View.OnClickListener dsF;
    private Runnable dsG;
    private List<Integer> dsH;
    public EditorBar dsq;
    private EditorDesk dsr;
    private View dss;
    private List<l> dsu;
    private SparseArray<b> dsv;
    private SparseArray<HashSet<b>> dsw;
    private SparseArray<HashSet<Integer>> dsx;
    private int dsy;
    private boolean dsz;

    public void aLG() {
        l lX = lX(3);
        if (lX != null && (lX.dsh instanceof View)) {
            View view = (View) lX.dsh;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.dsy = 1;
        this.dsz = false;
        this.dfI = 0;
        this.dsA = 0;
        this.dsB = true;
        this.dsD = false;
        this.dsE = false;
        this.dsF = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.ba(view);
            }
        };
        this.dsG = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aLG();
            }
        };
        this.dsH = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.dsD = z;
    }

    public boolean aLH() {
        return this.dsD;
    }

    public boolean aLI() {
        return this.dsE;
    }

    public void setIsFromPb(boolean z) {
        this.dsE = z;
    }

    private void init(Context context) {
        this.dsu = new LinkedList();
        this.dsv = new SparseArray<>();
        this.dsw = new SparseArray<>();
        this.dsx = new SparseArray<>();
        this.dsq = new EditorBar(context, this);
        this.dsr = new EditorDesk(context, this);
        this.dsC = new LinkedList<>();
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
                HashSet<b> hashSet = this.dsw.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.dsw.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.dsv.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.dsx.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.dsx.put(i3, hashSet2);
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
                g lU = this.dsq.lU(aVar.id);
                if (lU != null) {
                    z = false;
                } else {
                    lU = this.dsr.lU(aVar.id);
                    z = true;
                }
                if (lU == null) {
                    Iterator<g> it = this.dsC.iterator();
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
                    if (z && (lX = lX(2)) != null && lX.dsh != null) {
                        lX.dsh.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.dsq.a((l) null);
                aJZ();
            } else if (aVar.id > 0) {
                b bVar = this.dsv.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.dsq.lS(aVar.id);
                    }
                    l lX2 = lX(aVar.id);
                    if (lX2 != null && lX2.dsZ == 5) {
                        aJZ();
                        aLJ();
                    } else {
                        this.dsr.lS(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.dsx.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.dsv.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.dsw.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void aLJ() {
        boolean z;
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.dsG);
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
            if (lX != null && (lX.dsh instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) lX.dsh);
            }
            l lX2 = lX(28);
            if (lX2 != null && (lX2.dsh instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) lX2.dsh);
            }
        }
    }

    public void b(l lVar) {
        if (lVar != null) {
            this.dsu.add(lVar);
        }
    }

    private void clear() {
        this.dsq.clear();
        this.dsr.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.dsy = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.dsq.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.dsr.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.dfI, i);
        this.dsq.onChangeSkinType(i);
        this.dsr.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.dsH;
    }

    public void aJ(List<Integer> list) {
        this.dsH.clear();
        this.dsH.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.dsu != null && this.dsu.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (l lVar : this.dsu) {
                if (lVar.dsU > 0) {
                    linkedList.add(lVar);
                }
                if (lVar.dsh != null) {
                    lVar.dsh.setToolId(lVar.id);
                    lVar.dsh.setEditorTools(this);
                    if (lVar.dsZ == 6) {
                        this.dsr.a(lVar.dsh);
                    } else if (lVar.dsZ == 1 || lVar.dsZ == 2 || lVar.dsZ == 3 || lVar.dsZ == 4 || lVar.dsZ == 5) {
                        this.dsq.a(lVar.dsh, lVar.dsZ, !lVar.dta);
                        if (lVar.dsZ == 5 && lX(1) == null) {
                            z = true;
                        }
                    }
                    a(lVar.dtb, lVar.id, lVar.dsh);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<l>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(l lVar2, l lVar3) {
                    return lVar2.dsY - lVar3.dsY;
                }
            });
            if (linkedList.size() > this.dsy) {
                if (this.dsE) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.dsA > 0 && iVar.dsh != null && (iVar.dsh instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.dsh).setBackgroundColorId(this.dsA);
                }
                b(iVar);
                iVar.dsh.setToolId(iVar.id);
                iVar.dsh.setEditorTools(this);
                a(iVar.dtb, iVar.id, iVar.dsh);
                this.dsr.a(iVar.dsh);
                if (this.dsz) {
                    linkedList.add(this.dsy, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.dsy + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                l lVar2 = (l) it.next();
                if (i2 < i) {
                    this.dsq.a(a(lVar2, 1));
                } else {
                    this.dsr.a(a(lVar2, 2));
                }
                if ((lVar2 instanceof com.baidu.tbadk.editortools.a.a) && lVar2.dsY > this.dsy) {
                    lVar2.dsU = R.drawable.icon_pure_more_at40_svg;
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.dsq.a(0, a);
            }
            this.dsq.build();
            this.dsr.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.dsq.setLayoutParams(layoutParams);
            this.dsr.setLayoutParams(layoutParams);
            this.dsr.hide();
            if (this.dsE) {
                this.dsq.setPadding(0, 0, 0, 0);
            }
            aJZ();
            removeAllViews();
            if (this.dsq.getBarLauncherType() != 4) {
                aLK();
            }
            addView(this.dsq);
            addView(this.dsr);
            invalidate();
        }
    }

    private void aLK() {
        if (this.dss == null || this.dss.getParent() != null) {
            this.dss = new View(getContext());
            am.setBackgroundResource(this.dss, R.drawable.bottom_view_shadow);
            this.dss.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.dss);
    }

    public void c(l lVar) {
        if (lVar != null) {
            b(lVar);
            g a = a(lVar, 1);
            a.hide();
            if (this.dsq != null) {
                this.dsq.a(0, a);
                this.dsq.removeAllViews();
                this.dsq.build();
            }
            invalidate();
        }
    }

    public l lX(int i) {
        for (l lVar : this.dsu) {
            if (lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public List<l> getAllTools() {
        return this.dsu;
    }

    public g lU(int i) {
        g lU = this.dsq.lU(i);
        if (lU == null) {
            return this.dsr.lU(i);
        }
        return lU;
    }

    public void aLL() {
        this.dsq.i(this.dsF);
    }

    private g a(l lVar, int i) {
        g a = f.a(getContext(), lVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(lVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.dsF);
        }
        return a;
    }

    public void gr(boolean z) {
        for (l lVar : this.dsu) {
            if (lVar != null && (lVar.dsh instanceof View) && ((View) lVar.dsh).getVisibility() == 0 && !lVar.dta) {
                lVar.dsh.lw();
            }
        }
        if (this.dsB) {
            this.dsB = false;
            aJZ();
        }
        if (!aLE() && z) {
            com.baidu.adp.lib.f.e.gy().postDelayed(this.dsG, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void lw() {
        gr(true);
    }

    public void hide() {
        aJZ();
        setVisibility(8);
        aLJ();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void aJZ() {
        this.dsr.hide();
        this.dsq.a((l) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.dsq.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.dsq.setBarLauncherEnabled(z, i);
    }

    public boolean aLE() {
        return this.dsr.aLE();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.dsq.setBarLauncherType(i);
    }

    public void gp(boolean z) {
        this.dsq.gp(z);
    }

    public void gq(boolean z) {
        this.dsq.gq(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.dsz = z;
    }

    public void setBackgroundColorId(int i) {
        this.dfI = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.dsA = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void ba(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            l lX = lX(toolId);
            if (lX.lK()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.dsq.a(lX);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    lw();
                    b(new a(1, 3, null));
                } else if (lX.dsh == null) {
                    if (lX.dtb != null && lX.dtb.length > 0) {
                        b(new a(lX.dtb[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void aLM() {
        this.dsq.a((l) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
