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
    private boolean cFA;
    private boolean cFB;
    private View.OnClickListener cFC;
    private Runnable cFD;
    private List<Integer> cFE;
    public EditorBar cFn;
    private EditorDesk cFo;
    private View cFp;
    private List<k> cFq;
    private SparseArray<b> cFr;
    private SparseArray<HashSet<b>> cFs;
    private SparseArray<HashSet<Integer>> cFt;
    private int cFu;
    private boolean cFv;
    private int cFw;
    private int cFx;
    private boolean cFy;
    private LinkedList<g> cFz;

    public void aud() {
        k jL = jL(3);
        if (jL != null && (jL.cFe instanceof View)) {
            View view = (View) jL.cFe;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.cFu = 1;
        this.cFv = false;
        this.cFw = 0;
        this.cFx = 0;
        this.cFy = true;
        this.cFA = false;
        this.cFB = false;
        this.cFC = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bd(view);
            }
        };
        this.cFD = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aud();
            }
        };
        this.cFE = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.cFA = z;
    }

    public boolean aue() {
        return this.cFA;
    }

    public boolean auf() {
        return this.cFB;
    }

    public void setIsFromPb(boolean z) {
        this.cFB = z;
    }

    private void init(Context context) {
        this.cFq = new LinkedList();
        this.cFr = new SparseArray<>();
        this.cFs = new SparseArray<>();
        this.cFt = new SparseArray<>();
        this.cFn = new EditorBar(context, this);
        this.cFo = new EditorDesk(context, this);
        this.cFz = new LinkedList<>();
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
                HashSet<b> hashSet = this.cFs.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.cFs.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.cFr.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.cFt.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.cFt.put(i3, hashSet2);
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
        k jL;
        if (aVar != null) {
            if (aVar.code == 2) {
                g jI = this.cFn.jI(aVar.id);
                if (jI != null) {
                    z = false;
                } else {
                    jI = this.cFo.jI(aVar.id);
                    z = true;
                }
                if (jI == null) {
                    Iterator<g> it = this.cFz.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = jI;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (jL = jL(2)) != null && jL.cFe != null) {
                        jL.cFe.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.cFn.a((k) null);
                asC();
            } else if (aVar.id > 0) {
                b bVar = this.cFr.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.cFn.jG(aVar.id);
                    }
                    k jL2 = jL(aVar.id);
                    if (jL2 != null && jL2.cFW == 5) {
                        asC();
                        aug();
                    } else {
                        this.cFo.jG(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.cFt.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.cFr.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.cFs.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void aug() {
        boolean z;
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cFD);
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
            k jL = jL(3);
            if (jL != null && (jL.cFe instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) jL.cFe);
            }
            k jL2 = jL(28);
            if (jL2 != null && (jL2.cFe instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) jL2.cFe);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.cFq.add(kVar);
        }
    }

    private void clear() {
        this.cFn.clear();
        this.cFo.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.cFu = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.cFn.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.cFo.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.cFw, i);
        this.cFn.onChangeSkinType(i);
        this.cFo.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.cFE;
    }

    public void aC(List<Integer> list) {
        this.cFE.clear();
        this.cFE.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.cFq != null && this.cFq.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.cFq) {
                if (kVar.cFR > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.cFe != null) {
                    kVar.cFe.setToolId(kVar.id);
                    kVar.cFe.setEditorTools(this);
                    if (kVar.cFW == 6) {
                        this.cFo.a(kVar.cFe);
                    } else if (kVar.cFW == 1 || kVar.cFW == 2 || kVar.cFW == 3 || kVar.cFW == 4 || kVar.cFW == 5) {
                        this.cFn.a(kVar.cFe, kVar.cFW, !kVar.cFX);
                        if (kVar.cFW == 5 && jL(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.cFY, kVar.id, kVar.cFe);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.cFV - kVar3.cFV;
                }
            });
            if (linkedList.size() > this.cFu) {
                if (this.cFB) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.cFx > 0 && iVar.cFe != null && (iVar.cFe instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.cFe).setBackgroundColorId(this.cFx);
                }
                b(iVar);
                iVar.cFe.setToolId(iVar.id);
                iVar.cFe.setEditorTools(this);
                a(iVar.cFY, iVar.id, iVar.cFe);
                this.cFo.a(iVar.cFe);
                if (this.cFv) {
                    linkedList.add(this.cFu, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.cFu + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.cFn.a(a(kVar2, 1));
                } else {
                    this.cFo.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.cFn.a(0, a);
            }
            this.cFn.build();
            this.cFo.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.cFn.setLayoutParams(layoutParams);
            this.cFo.setLayoutParams(layoutParams);
            this.cFo.hide();
            if (this.cFB) {
                this.cFn.setPadding(0, 0, 0, 0);
            }
            asC();
            removeAllViews();
            if (this.cFn.getBarLauncherType() != 4) {
                auh();
            }
            addView(this.cFn);
            addView(this.cFo);
            invalidate();
        }
    }

    private void auh() {
        if (this.cFp == null || this.cFp.getParent() != null) {
            this.cFp = new View(getContext());
            this.cFp.setBackgroundResource(R.drawable.bottom_shadow);
            this.cFp.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.cFp);
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.cFn != null) {
                this.cFn.a(0, a);
                this.cFn.removeAllViews();
                this.cFn.build();
            }
            invalidate();
        }
    }

    public k jL(int i) {
        for (k kVar : this.cFq) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.cFq;
    }

    public g jI(int i) {
        g jI = this.cFn.jI(i);
        if (jI == null) {
            return this.cFo.jI(i);
        }
        return jI;
    }

    public void aui() {
        this.cFn.g(this.cFC);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.cFC);
        }
        return a;
    }

    public void fg(boolean z) {
        for (k kVar : this.cFq) {
            if (kVar != null && (kVar.cFe instanceof View) && ((View) kVar.cFe).getVisibility() == 0 && !kVar.cFX) {
                kVar.cFe.le();
            }
        }
        if (this.cFy) {
            this.cFy = false;
            asC();
        }
        if (!aub() && z) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.cFD, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void le() {
        fg(true);
    }

    public void hide() {
        asC();
        setVisibility(8);
        aug();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void asC() {
        this.cFo.hide();
        this.cFn.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.cFn.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.cFn.setBarLauncherEnabled(z, i);
    }

    public boolean aub() {
        return this.cFo.aub();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.cFn.setBarLauncherType(i);
    }

    public void fe(boolean z) {
        this.cFn.fe(z);
    }

    public void ff(boolean z) {
        this.cFn.ff(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.cFv = z;
    }

    public void setBackgroundColorId(int i) {
        this.cFw = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.cFx = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bd(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k jL = jL(toolId);
            if (jL.lt()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.cFn.a(jL);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    le();
                    b(new a(1, 3, null));
                } else if (jL.cFe == null) {
                    if (jL.cFY != null && jL.cFY.length > 0) {
                        b(new a(jL.cFY[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void auj() {
        this.cFn.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
