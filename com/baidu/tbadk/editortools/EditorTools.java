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
import com.baidu.tbadk.core.util.al;
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
    public EditorBar cqN;
    private EditorDesk cqO;
    private View cqP;
    private List<k> cqQ;
    private SparseArray<b> cqR;
    private SparseArray<HashSet<b>> cqS;
    private SparseArray<HashSet<Integer>> cqT;
    private int cqU;
    private int cqV;
    private boolean cqW;
    private int cqX;
    private int cqY;
    private boolean cqZ;
    private LinkedList<g> cra;
    private boolean crb;
    private boolean crd;
    private View.OnClickListener cre;
    private Runnable crf;
    private List<Integer> crg;

    public void aqX() {
        k kj = kj(3);
        if (kj != null && (kj.cqE instanceof View)) {
            View view = (View) kj.cqE;
            view.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.cqU = 1;
        this.cqV = 0;
        this.cqW = false;
        this.cqX = R.color.common_color_10255;
        this.cqY = 0;
        this.cqZ = true;
        this.crb = false;
        this.crd = false;
        this.cre = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bb(view);
            }
        };
        this.crf = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aqX();
            }
        };
        this.crg = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.crb = z;
    }

    public boolean aqY() {
        return this.crb;
    }

    public boolean aqZ() {
        return this.crd;
    }

    public void setIsFromPb(boolean z) {
        this.crd = z;
    }

    private void init(Context context) {
        this.cqQ = new LinkedList();
        this.cqR = new SparseArray<>();
        this.cqS = new SparseArray<>();
        this.cqT = new SparseArray<>();
        this.cqN = new EditorBar(context, this);
        this.cqO = new EditorDesk(context, this);
        this.cra = new LinkedList<>();
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
                HashSet<b> hashSet = this.cqS.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.cqS.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.cqR.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.cqT.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.cqT.put(i3, hashSet2);
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
        k kj;
        if (aVar != null) {
            if (aVar.code == 2) {
                g kg = this.cqN.kg(aVar.id);
                if (kg != null) {
                    z = false;
                } else {
                    kg = this.cqO.kg(aVar.id);
                    z = true;
                }
                if (kg == null) {
                    Iterator<g> it = this.cra.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = kg;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (kj = kj(2)) != null && kj.cqE != null) {
                        kj.cqE.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.cqN.a((k) null);
                app();
            } else if (aVar.id > 0) {
                b bVar = this.cqR.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.cqN.ke(aVar.id);
                    }
                    k kj2 = kj(aVar.id);
                    if (kj2 != null && kj2.crw == 5) {
                        app();
                        ara();
                    } else {
                        this.cqO.ke(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.cqT.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.cqR.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.cqS.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void ara() {
        boolean z;
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.crf);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.l.b(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z) {
            k kj = kj(3);
            if (kj != null && (kj.cqE instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) kj.cqE);
            }
            k kj2 = kj(28);
            if (kj2 != null && (kj2.cqE instanceof View)) {
                com.baidu.adp.lib.util.l.b(getContext(), (View) kj2.cqE);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.cqQ.add(kVar);
        }
    }

    private void clear() {
        this.cqN.clear();
        this.cqO.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.cqU = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.cqN.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.cqO.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        al.h(this, this.cqX, i);
        this.cqN.onChangeSkinType(i);
        this.cqO.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.crg;
    }

    public void ai(List<Integer> list) {
        this.crg.clear();
        this.crg.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public void aqT() {
        i iVar;
        if (this.cqQ != null && this.cqQ.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.cqQ) {
                if (kVar.crt > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.cqE != null) {
                    kVar.cqE.setToolId(kVar.id);
                    kVar.cqE.setEditorTools(this);
                    if (kVar.crw == 6) {
                        this.cqO.a(kVar.cqE);
                    } else if (kVar.crw == 1 || kVar.crw == 2 || kVar.crw == 3 || kVar.crw == 4 || kVar.crw == 5) {
                        this.cqN.a(kVar.cqE, kVar.crw, !kVar.crx);
                        if (kVar.crw == 5 && kj(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.cry, kVar.id, kVar.cqE);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.crv - kVar3.crv;
                }
            });
            if (linkedList.size() > this.cqU) {
                if (this.crd) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.cqY > 0 && iVar.cqE != null && (iVar.cqE instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.cqE).setBackgroundColorId(this.cqY);
                }
                if (this.cqV > 0) {
                    iVar.crt = this.cqV;
                }
                b(iVar);
                iVar.cqE.setToolId(iVar.id);
                iVar.cqE.setEditorTools(this);
                a(iVar.cry, iVar.id, iVar.cqE);
                this.cqO.a(iVar.cqE);
                if (this.cqW) {
                    linkedList.add(this.cqU, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.cqU + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.cqN.a(a(kVar2, 1));
                } else {
                    this.cqO.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.cqN.a(0, a);
            }
            this.cqN.aqT();
            this.cqO.aqT();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.cqN.setLayoutParams(layoutParams);
            this.cqO.setLayoutParams(layoutParams);
            this.cqO.hide();
            if (this.crd) {
                this.cqN.setPadding(0, 0, 0, 0);
            }
            app();
            removeAllViews();
            if (this.cqN.getBarLauncherType() != 4) {
                arb();
            }
            addView(this.cqN);
            addView(this.cqO);
            invalidate();
        }
    }

    private void arb() {
        if (this.cqP == null || this.cqP.getParent() != null) {
            this.cqP = new View(getContext());
            this.cqP.setBackgroundResource(R.drawable.bottom_shadow);
            this.cqP.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds16)));
        }
        addView(this.cqP);
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.cqN != null) {
                this.cqN.a(0, a);
                this.cqN.removeAllViews();
                this.cqN.aqT();
            }
            invalidate();
        }
    }

    public k kj(int i) {
        for (k kVar : this.cqQ) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.cqQ;
    }

    public g kg(int i) {
        g kg = this.cqN.kg(i);
        if (kg == null) {
            return this.cqO.kg(i);
        }
        return kg;
    }

    public void arc() {
        this.cqN.f(this.cre);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.cre);
        }
        return a;
    }

    public void ff(boolean z) {
        for (k kVar : this.cqQ) {
            if (kVar != null && (kVar.cqE instanceof View) && ((View) kVar.cqE).getVisibility() == 0 && !kVar.crx) {
                kVar.cqE.pO();
            }
        }
        if (this.cqZ) {
            this.cqZ = false;
            app();
        }
        if (!aqV() && z) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.crf, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, true));
    }

    public void pO() {
        ff(true);
    }

    public void hide() {
        app();
        setVisibility(8);
        ara();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, false));
    }

    public void app() {
        this.cqO.hide();
        this.cqN.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.cqN.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.cqN.setBarLauncherEnabled(z, i);
    }

    public boolean aqV() {
        return this.cqO.aqV();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.cqV = i;
    }

    public void setBarLauncherType(int i) {
        this.cqN.setBarLauncherType(i);
    }

    public void fd(boolean z) {
        this.cqN.fd(z);
    }

    public void fe(boolean z) {
        this.cqN.fe(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.cqW = z;
    }

    public void setBackgroundColorId(int i) {
        this.cqX = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.cqY = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bb(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k kj = kj(toolId);
            if (kj.qd()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.cqN.a(kj);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    pO();
                    b(new a(1, 3, null));
                } else if (kj.cqE == null) {
                    if (kj.cry != null && kj.cry.length > 0) {
                        b(new a(kj.cry[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void ard() {
        this.cqN.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
