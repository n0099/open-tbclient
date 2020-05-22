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
    private int dYP;
    public EditorBar ele;
    private EditorDesk elf;
    private View elg;
    private List<l> elh;
    private SparseArray<b> eli;
    private SparseArray<HashSet<b>> elj;
    private SparseArray<HashSet<Integer>> elk;
    private int ell;
    private boolean elm;
    private int eln;
    private boolean elo;
    private LinkedList<g> elp;
    private boolean elq;
    private boolean elr;
    private View.OnClickListener els;
    private Runnable elt;
    private List<Integer> elu;

    public void bda() {
        l nf = nf(3);
        if (nf != null && (nf.ekV instanceof View)) {
            View view = (View) nf.ekV;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.ell = 1;
        this.elm = false;
        this.dYP = 0;
        this.eln = 0;
        this.elo = true;
        this.elq = false;
        this.elr = false;
        this.els = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bg(view);
            }
        };
        this.elt = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bda();
            }
        };
        this.elu = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.elq = z;
    }

    public boolean bdb() {
        return this.elq;
    }

    public boolean bdc() {
        return this.elr;
    }

    public void setIsFromPb(boolean z) {
        this.elr = z;
    }

    private void init(Context context) {
        this.elh = new LinkedList();
        this.eli = new SparseArray<>();
        this.elj = new SparseArray<>();
        this.elk = new SparseArray<>();
        this.ele = new EditorBar(context, this);
        this.elf = new EditorDesk(context, this);
        this.elp = new LinkedList<>();
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
                HashSet<b> hashSet = this.elj.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.elj.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.eli.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.elk.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.elk.put(i3, hashSet2);
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
        l nf;
        if (aVar != null) {
            if (aVar.code == 2) {
                g nc = this.ele.nc(aVar.id);
                if (nc != null) {
                    z = false;
                } else {
                    nc = this.elf.nc(aVar.id);
                    z = true;
                }
                if (nc == null) {
                    Iterator<g> it = this.elp.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = nc;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (nf = nf(2)) != null && nf.ekV != null) {
                        nf.ekV.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.ele.a((l) null);
                bbz();
            } else if (aVar.id > 0) {
                b bVar = this.eli.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.ele.na(aVar.id);
                    }
                    l nf2 = nf(aVar.id);
                    if (nf2 != null && nf2.elM == 5) {
                        bbz();
                        bdd();
                    } else {
                        this.elf.na(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.elk.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.eli.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.elj.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void bdd() {
        boolean z;
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.elt);
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
            l nf = nf(3);
            if (nf != null && (nf.ekV instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) nf.ekV);
            }
            l nf2 = nf(28);
            if (nf2 != null && (nf2.ekV instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) nf2.ekV);
            }
        }
    }

    public void b(l lVar) {
        if (lVar != null) {
            this.elh.add(lVar);
        }
    }

    private void clear() {
        this.ele.clear();
        this.elf.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.ell = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.ele.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.elf.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.dYP, i);
        this.ele.onChangeSkinType(i);
        this.elf.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.elu;
    }

    public void aM(List<Integer> list) {
        this.elu.clear();
        this.elu.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.elh != null && this.elh.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (l lVar : this.elh) {
                if (lVar.elH > 0) {
                    linkedList.add(lVar);
                }
                if (lVar.ekV != null) {
                    lVar.ekV.setToolId(lVar.id);
                    lVar.ekV.setEditorTools(this);
                    if (lVar.elM == 6) {
                        this.elf.a(lVar.ekV);
                    } else if (lVar.elM == 1 || lVar.elM == 2 || lVar.elM == 3 || lVar.elM == 4 || lVar.elM == 5) {
                        this.ele.a(lVar.ekV, lVar.elM, !lVar.elN);
                        if (lVar.elM == 5 && nf(1) == null) {
                            z = true;
                        }
                    }
                    a(lVar.elO, lVar.id, lVar.ekV);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<l>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(l lVar2, l lVar3) {
                    return lVar2.elL - lVar3.elL;
                }
            });
            if (linkedList.size() > this.ell) {
                if (this.elr) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.eln > 0 && iVar.ekV != null && (iVar.ekV instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.ekV).setBackgroundColorId(this.eln);
                }
                b(iVar);
                iVar.ekV.setToolId(iVar.id);
                iVar.ekV.setEditorTools(this);
                a(iVar.elO, iVar.id, iVar.ekV);
                this.elf.a(iVar.ekV);
                if (this.elm) {
                    linkedList.add(this.ell, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.ell + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                l lVar2 = (l) it.next();
                if (i2 < i) {
                    this.ele.a(a(lVar2, 1));
                } else {
                    this.elf.a(a(lVar2, 2));
                }
                if ((lVar2 instanceof com.baidu.tbadk.editortools.a.a) && lVar2.elL > this.ell) {
                    lVar2.elH = R.drawable.icon_pure_more_at40_svg;
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.ele.a(0, a);
            }
            this.ele.build();
            this.elf.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.ele.setLayoutParams(layoutParams);
            this.elf.setLayoutParams(layoutParams);
            this.elf.hide();
            if (this.elr) {
                this.ele.setPadding(0, 0, 0, 0);
            }
            bbz();
            removeAllViews();
            if (this.ele.getBarLauncherType() != 4) {
                bde();
            }
            addView(this.ele);
            addView(this.elf);
            invalidate();
        }
    }

    private void bde() {
        if (this.elg == null || this.elg.getParent() != null) {
            this.elg = new View(getContext());
            am.setBackgroundResource(this.elg, R.drawable.bottom_view_shadow);
            this.elg.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.elg);
    }

    public void c(l lVar) {
        if (lVar != null) {
            b(lVar);
            g a = a(lVar, 1);
            a.hide();
            if (this.ele != null) {
                this.ele.a(0, a);
                this.ele.removeAllViews();
                this.ele.build();
            }
            invalidate();
        }
    }

    public l nf(int i) {
        for (l lVar : this.elh) {
            if (lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public List<l> getAllTools() {
        return this.elh;
    }

    public g nc(int i) {
        g nc = this.ele.nc(i);
        if (nc == null) {
            return this.elf.nc(i);
        }
        return nc;
    }

    public void bdf() {
        this.ele.h(this.els);
    }

    private g a(l lVar, int i) {
        g a = f.a(getContext(), lVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(lVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.els);
        }
        return a;
    }

    public void hY(boolean z) {
        for (l lVar : this.elh) {
            if (lVar != null && (lVar.ekV instanceof View) && ((View) lVar.ekV).getVisibility() == 0 && !lVar.elN) {
                lVar.ekV.display();
            }
        }
        if (this.elo) {
            this.elo = false;
            bbz();
        }
        if (!bcY() && z) {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.elt, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        hY(true);
    }

    public void hide() {
        bbz();
        setVisibility(8);
        bdd();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bbz() {
        this.elf.hide();
        this.ele.a((l) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.ele.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.ele.setBarLauncherEnabled(z, i);
    }

    public boolean bcY() {
        return this.elf.bcY();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.ele.setBarLauncherType(i);
    }

    public void hW(boolean z) {
        this.ele.hW(z);
    }

    public void hX(boolean z) {
        this.ele.hX(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.elm = z;
    }

    public void setBackgroundColorId(int i) {
        this.dYP = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.eln = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bg(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            l nf = nf(toolId);
            if (nf.qH()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.ele.a(nf);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (nf.ekV == null) {
                    if (nf.elO != null && nf.elO.length > 0) {
                        b(new a(nf.elO[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bdg() {
        this.ele.a((l) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
