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
    private SparseArray<b> cEA;
    private SparseArray<HashSet<b>> cEB;
    private SparseArray<HashSet<Integer>> cEC;
    private int cED;
    private boolean cEE;
    private int cEF;
    private int cEG;
    private boolean cEH;
    private LinkedList<g> cEI;
    private boolean cEJ;
    private boolean cEK;
    private View.OnClickListener cEL;
    private Runnable cEM;
    private List<Integer> cEN;
    public EditorBar cEw;
    private EditorDesk cEx;
    private View cEy;
    private List<k> cEz;

    public void aub() {
        k jK = jK(3);
        if (jK != null && (jK.cEn instanceof View)) {
            View view = (View) jK.cEn;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.cED = 1;
        this.cEE = false;
        this.cEF = 0;
        this.cEG = 0;
        this.cEH = true;
        this.cEJ = false;
        this.cEK = false;
        this.cEL = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bd(view);
            }
        };
        this.cEM = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.aub();
            }
        };
        this.cEN = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.cEJ = z;
    }

    public boolean auc() {
        return this.cEJ;
    }

    public boolean aud() {
        return this.cEK;
    }

    public void setIsFromPb(boolean z) {
        this.cEK = z;
    }

    private void init(Context context) {
        this.cEz = new LinkedList();
        this.cEA = new SparseArray<>();
        this.cEB = new SparseArray<>();
        this.cEC = new SparseArray<>();
        this.cEw = new EditorBar(context, this);
        this.cEx = new EditorDesk(context, this);
        this.cEI = new LinkedList<>();
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
                HashSet<b> hashSet = this.cEB.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.cEB.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.cEA.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.cEC.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.cEC.put(i3, hashSet2);
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
        k jK;
        if (aVar != null) {
            if (aVar.code == 2) {
                g jH = this.cEw.jH(aVar.id);
                if (jH != null) {
                    z = false;
                } else {
                    jH = this.cEx.jH(aVar.id);
                    z = true;
                }
                if (jH == null) {
                    Iterator<g> it = this.cEI.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = jH;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (jK = jK(2)) != null && jK.cEn != null) {
                        jK.cEn.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.cEw.a((k) null);
                asA();
            } else if (aVar.id > 0) {
                b bVar = this.cEA.get(aVar.id);
                if (bVar != null) {
                    if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                        this.cEw.jF(aVar.id);
                    }
                    k jK2 = jK(aVar.id);
                    if (jK2 != null && jK2.cFf == 5) {
                        asA();
                        aue();
                    } else {
                        this.cEx.jF(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.cEC.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.cEA.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.cEB.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void aue() {
        boolean z;
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.cEM);
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
            k jK = jK(3);
            if (jK != null && (jK.cEn instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) jK.cEn);
            }
            k jK2 = jK(28);
            if (jK2 != null && (jK2.cEn instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) jK2.cEn);
            }
        }
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.cEz.add(kVar);
        }
    }

    private void clear() {
        this.cEw.clear();
        this.cEx.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.cED = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.cEw.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.cEx.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, this.cEF, i);
        this.cEw.onChangeSkinType(i);
        this.cEx.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.cEN;
    }

    public void aC(List<Integer> list) {
        this.cEN.clear();
        this.cEN.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.cEz != null && this.cEz.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (k kVar : this.cEz) {
                if (kVar.cFa > 0) {
                    linkedList.add(kVar);
                }
                if (kVar.cEn != null) {
                    kVar.cEn.setToolId(kVar.id);
                    kVar.cEn.setEditorTools(this);
                    if (kVar.cFf == 6) {
                        this.cEx.a(kVar.cEn);
                    } else if (kVar.cFf == 1 || kVar.cFf == 2 || kVar.cFf == 3 || kVar.cFf == 4 || kVar.cFf == 5) {
                        this.cEw.a(kVar.cEn, kVar.cFf, !kVar.cFg);
                        if (kVar.cFf == 5 && jK(1) == null) {
                            z = true;
                        }
                    }
                    a(kVar.cFh, kVar.id, kVar.cEn);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<k>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(k kVar2, k kVar3) {
                    return kVar2.cFe - kVar3.cFe;
                }
            });
            if (linkedList.size() > this.cED) {
                if (this.cEK) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.cEG > 0 && iVar.cEn != null && (iVar.cEn instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.cEn).setBackgroundColorId(this.cEG);
                }
                b(iVar);
                iVar.cEn.setToolId(iVar.id);
                iVar.cEn.setEditorTools(this);
                a(iVar.cFh, iVar.id, iVar.cEn);
                this.cEx.a(iVar.cEn);
                if (this.cEE) {
                    linkedList.add(this.cED, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.cED + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (i2 < i) {
                    this.cEw.a(a(kVar2, 1));
                } else {
                    this.cEx.a(a(kVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.cEw.a(0, a);
            }
            this.cEw.build();
            this.cEx.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.cEw.setLayoutParams(layoutParams);
            this.cEx.setLayoutParams(layoutParams);
            this.cEx.hide();
            if (this.cEK) {
                this.cEw.setPadding(0, 0, 0, 0);
            }
            asA();
            removeAllViews();
            if (this.cEw.getBarLauncherType() != 4) {
                auf();
            }
            addView(this.cEw);
            addView(this.cEx);
            invalidate();
        }
    }

    private void auf() {
        if (this.cEy == null || this.cEy.getParent() != null) {
            this.cEy = new View(getContext());
            this.cEy.setBackgroundResource(R.drawable.bottom_shadow);
            this.cEy.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.cEy);
    }

    public void c(k kVar) {
        if (kVar != null) {
            b(kVar);
            g a = a(kVar, 1);
            a.hide();
            if (this.cEw != null) {
                this.cEw.a(0, a);
                this.cEw.removeAllViews();
                this.cEw.build();
            }
            invalidate();
        }
    }

    public k jK(int i) {
        for (k kVar : this.cEz) {
            if (kVar.id == i) {
                return kVar;
            }
        }
        return null;
    }

    public List<k> getAllTools() {
        return this.cEz;
    }

    public g jH(int i) {
        g jH = this.cEw.jH(i);
        if (jH == null) {
            return this.cEx.jH(i);
        }
        return jH;
    }

    public void aug() {
        this.cEw.g(this.cEL);
    }

    private g a(k kVar, int i) {
        g a = f.a(getContext(), kVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(kVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.cEL);
        }
        return a;
    }

    public void fg(boolean z) {
        for (k kVar : this.cEz) {
            if (kVar != null && (kVar.cEn instanceof View) && ((View) kVar.cEn).getVisibility() == 0 && !kVar.cFg) {
                kVar.cEn.le();
            }
        }
        if (this.cEH) {
            this.cEH = false;
            asA();
        }
        if (!atZ() && z) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.cEM, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void le() {
        fg(true);
    }

    public void hide() {
        asA();
        setVisibility(8);
        aue();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void asA() {
        this.cEx.hide();
        this.cEw.a((k) null);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.cEw.setBarLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        this.cEw.setBarLauncherEnabled(z, i);
    }

    public boolean atZ() {
        return this.cEx.atZ();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.cEw.setBarLauncherType(i);
    }

    public void fe(boolean z) {
        this.cEw.fe(z);
    }

    public void ff(boolean z) {
        this.cEw.ff(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.cEE = z;
    }

    public void setBackgroundColorId(int i) {
        this.cEF = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.cEG = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bd(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            k jK = jK(toolId);
            if (jK.lt()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.cEw.a(jK);
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    le();
                    b(new a(1, 3, null));
                } else if (jK.cEn == null) {
                    if (jK.cFh != null && jK.cFh.length > 0) {
                        b(new a(jK.cFh[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void auh() {
        this.cEw.a((k) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
