package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private g bsF;
    private h bsG;
    private List<r> bsH;
    private SparseArray<b> bsI;
    private SparseArray<HashSet<b>> bsJ;
    private SparseArray<HashSet<Integer>> bsK;
    private int bsL;
    private int bsM;
    private boolean bsN;
    private int bsO;
    private int bsP;
    private boolean bsQ;
    private LinkedList<l> bsR;
    private boolean bsS;
    private boolean bsT;
    private View.OnClickListener bsU;
    private Runnable bsV;
    private List<Integer> bsW;

    public void Lh() {
        r hI = hI(3);
        if (hI != null && (hI.bsw instanceof View)) {
            View view = (View) hI.bsw;
            view.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), view);
        }
    }

    public i(Context context) {
        super(context);
        this.bsL = 1;
        this.bsM = 0;
        this.bsN = false;
        this.bsO = d.C0140d.common_color_10255;
        this.bsP = 0;
        this.bsQ = true;
        this.bsS = false;
        this.bsT = false;
        this.bsU = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.bh(view);
            }
        };
        this.bsV = new Runnable() { // from class: com.baidu.tbadk.editortools.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.Lh();
            }
        };
        this.bsW = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.bsS = z;
    }

    public boolean Li() {
        return this.bsS;
    }

    public boolean Lj() {
        return this.bsT;
    }

    public void setIsFromPb(boolean z) {
        this.bsT = z;
    }

    private void init(Context context) {
        this.bsH = new LinkedList();
        this.bsI = new SparseArray<>();
        this.bsJ = new SparseArray<>();
        this.bsK = new SparseArray<>();
        this.bsF = new g(context, this);
        this.bsG = new h(context, this);
        this.bsR = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.bsJ.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.bsJ.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.bsI.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.bsK.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.bsK.put(i3, hashSet2);
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
        l lVar;
        r hI;
        if (aVar != null) {
            if (aVar.code == 2) {
                l hG = this.bsF.hG(aVar.id);
                if (hG != null) {
                    z = false;
                } else {
                    hG = this.bsG.hG(aVar.id);
                    z = true;
                }
                if (hG == null) {
                    Iterator<l> it = this.bsR.iterator();
                    while (it.hasNext()) {
                        lVar = it.next();
                        if (lVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                lVar = hG;
                if (lVar != null) {
                    lVar.a(aVar);
                    if (z && (hI = hI(2)) != null && hI.bsw != null) {
                        hI.bsw.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.bsF.a((r) null);
                Jm();
            } else if (aVar.id > 0) {
                b bVar = this.bsI.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.bsF.hE(aVar.id);
                    }
                    r hI2 = hI(aVar.id);
                    if (hI2 != null && hI2.btm == 5) {
                        Jm();
                        Lk();
                    } else {
                        this.bsG.hE(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.bsK.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.bsI.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.bsJ.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Lk() {
        boolean z;
        r hI;
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bsV);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.l.a(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && (hI = hI(3)) != null && (hI.bsw instanceof View)) {
            com.baidu.adp.lib.util.l.a(getContext(), (View) hI.bsw);
        }
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.bsH.add(rVar);
        }
    }

    private void clear() {
        this.bsF.clear();
        this.bsG.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.bsL = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.bsF.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.bsG.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        aj.g(this, this.bsO, i);
        this.bsF.onChangeSkinType(i);
        this.bsG.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.bsW;
    }

    public void K(List<Integer> list) {
        this.bsW.clear();
        this.bsW.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void Ld() {
        o oVar;
        if (this.bsH != null && this.bsH.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (r rVar : this.bsH) {
                if (rVar.btj > 0) {
                    linkedList.add(rVar);
                }
                if (rVar.bsw != null) {
                    rVar.bsw.setToolId(rVar.id);
                    rVar.bsw.setEditorTools(this);
                    if (rVar.btm == 6) {
                        this.bsG.a(rVar.bsw);
                    } else if (rVar.btm == 1 || rVar.btm == 2 || rVar.btm == 3 || rVar.btm == 4 || rVar.btm == 5) {
                        this.bsF.a(rVar.bsw, rVar.btm, !rVar.bto);
                        if (rVar.btm == 5 && hI(1) == null) {
                            z = true;
                        }
                    }
                    a(rVar.btp, rVar.id, rVar.bsw);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<r>() { // from class: com.baidu.tbadk.editortools.i.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(r rVar2, r rVar3) {
                    return rVar2.btl - rVar3.btl;
                }
            });
            if (linkedList.size() > this.bsL) {
                if (this.bsT) {
                    oVar = new o(getContext(), true);
                } else {
                    oVar = new o(getContext());
                }
                if (this.bsP > 0 && oVar.bsw != null && (oVar.bsw instanceof com.baidu.tbadk.editortools.view.b)) {
                    ((com.baidu.tbadk.editortools.view.b) oVar.bsw).setBackgroundColorId(this.bsP);
                }
                if (this.bsM > 0) {
                    oVar.btj = this.bsM;
                }
                b(oVar);
                oVar.bsw.setToolId(oVar.id);
                oVar.bsw.setEditorTools(this);
                a(oVar.btp, oVar.id, oVar.bsw);
                this.bsG.a(oVar.bsw);
                if (this.bsN) {
                    linkedList.add(this.bsL, oVar);
                } else {
                    linkedList.add(0, oVar);
                }
            }
            int i = this.bsL + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                r rVar2 = (r) it.next();
                if (i2 < i) {
                    this.bsF.a(a(rVar2, 1));
                } else {
                    this.bsG.a(a(rVar2, 2));
                }
                i2++;
            }
            if (z) {
                j jVar = new j();
                b(jVar);
                l a = a(jVar, 1);
                a.hide();
                this.bsF.a(0, a);
            }
            this.bsF.Ld();
            this.bsG.Ld();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.bsF.setLayoutParams(layoutParams);
            this.bsG.setLayoutParams(layoutParams);
            this.bsG.hide();
            if (this.bsT) {
                this.bsF.setPadding(0, 0, 0, 0);
            }
            Jm();
            removeAllViews();
            addView(this.bsF);
            addView(this.bsG);
            invalidate();
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            b(rVar);
            l a = a(rVar, 1);
            a.hide();
            if (this.bsF != null) {
                this.bsF.a(0, a);
                this.bsF.removeAllViews();
                this.bsF.Ld();
            }
            invalidate();
        }
    }

    public r hI(int i) {
        for (r rVar : this.bsH) {
            if (rVar.id == i) {
                return rVar;
            }
        }
        return null;
    }

    public List<r> getAllTools() {
        return this.bsH;
    }

    public l hG(int i) {
        l hG = this.bsF.hG(i);
        if (hG == null) {
            return this.bsG.hG(i);
        }
        return hG;
    }

    public void Ll() {
        this.bsF.d(this.bsU);
    }

    private l a(r rVar, int i) {
        l a = k.a(getContext(), rVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(rVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.bsU);
        }
        return a;
    }

    public void ch(boolean z) {
        for (r rVar : this.bsH) {
            if (rVar != null && (rVar.bsw instanceof View) && ((View) rVar.bsw).getVisibility() == 0 && !rVar.bto) {
                rVar.bsw.th();
            }
        }
        if (this.bsQ) {
            this.bsQ = false;
            Jm();
        }
        if (!Lf() && z) {
            com.baidu.adp.lib.g.e.ns().postDelayed(this.bsV, 200L);
        }
        setVisibility(0);
    }

    public void th() {
        ch(true);
    }

    public void hide() {
        Jm();
        setVisibility(8);
        Lk();
    }

    public void Jm() {
        this.bsG.hide();
        this.bsF.a((r) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.bsF.setBarLauncherEnabled(z);
    }

    public void g(boolean z, int i) {
        this.bsF.g(z, i);
    }

    public boolean Lf() {
        return this.bsG.Lf();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.bsM = i;
    }

    public void setBarLauncherType(int i) {
        this.bsF.setBarLauncherType(i);
    }

    public void cf(boolean z) {
        this.bsF.cf(z);
    }

    public void cg(boolean z) {
        this.bsF.cg(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.bsN = z;
    }

    public void setBackgroundColorId(int i) {
        this.bsO = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.bsP = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bh(View view) {
        if (view instanceof l) {
            l lVar = (l) view;
            int toolId = lVar.getToolId();
            r hI = hI(toolId);
            if (hI.tv()) {
                b(new a(31, 0, Integer.valueOf(lVar.getToolId())));
                this.bsF.a(hI);
                if (lVar.getToolId() == 1) {
                    lVar.hide();
                    th();
                    b(new a(1, 3, null));
                } else if (hI.bsw == null) {
                    if (hI.btp != null && hI.btp.length > 0) {
                        b(new a(hI.btp[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void Lm() {
        this.bsF.a((r) null);
    }
}
