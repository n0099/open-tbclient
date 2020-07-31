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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ao;
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
    private Context context;
    public EditorBar eAi;
    private EditorDesk eAj;
    private View eAk;
    private List<l> eAl;
    private SparseArray<b> eAm;
    private SparseArray<HashSet<b>> eAn;
    private SparseArray<HashSet<Integer>> eAo;
    private int eAp;
    private boolean eAq;
    private int eAr;
    private boolean eAs;
    private LinkedList<g> eAt;
    private boolean eAu;
    private boolean eAv;
    private View.OnClickListener eAw;
    private View.OnClickListener eAx;
    private Runnable eAy;
    private List<Integer> eAz;
    private int ena;
    private View mMaskView;

    public void biN() {
        l nT = nT(3);
        if (nT != null && (nT.ezZ instanceof View)) {
            View view = (View) nT.ezZ;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.eAp = 1;
        this.eAq = false;
        this.ena = 0;
        this.eAr = 0;
        this.eAs = true;
        this.eAu = false;
        this.eAv = false;
        this.eAw = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bn(view);
            }
        };
        this.eAy = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.biN();
            }
        };
        this.eAz = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.eAu = z;
    }

    public boolean biO() {
        return this.eAu;
    }

    public boolean biP() {
        return this.eAv;
    }

    public void setIsFromPb(boolean z) {
        this.eAv = z;
    }

    private void init(Context context) {
        this.context = context;
        this.eAl = new LinkedList();
        this.eAm = new SparseArray<>();
        this.eAn = new SparseArray<>();
        this.eAo = new SparseArray<>();
        this.eAi = new EditorBar(context, this);
        this.eAj = new EditorDesk(context, this);
        this.eAt = new LinkedList<>();
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
                HashSet<b> hashSet = this.eAn.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.eAn.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.eAm.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.eAo.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.eAo.put(i3, hashSet2);
                    }
                    hashSet2.add(Integer.valueOf(i));
                    i2++;
                }
            }
        }
    }

    public void b(a aVar) {
        HashSet<Integer> hashSet;
        DLauncher dLauncher;
        boolean z;
        g gVar;
        l nT;
        if (aVar != null) {
            if (aVar.code == 2) {
                g nQ = this.eAi.nQ(aVar.id);
                if (nQ != null) {
                    z = false;
                } else {
                    nQ = this.eAj.nQ(aVar.id);
                    z = true;
                }
                if (nQ == null) {
                    Iterator<g> it = this.eAt.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = nQ;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (nT = nT(2)) != null && nT.ezZ != null) {
                        nT.ezZ.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.eAi.a((l) null);
                bhl();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.eAm.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.eAi.nO(aVar.id);
                        }
                        l nT2 = nT(aVar.id);
                        if (nT2 != null && nT2.eAS == 5) {
                            bhl();
                            biQ();
                        } else {
                            this.eAj.nO(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.eAo.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.eAm.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.eAn.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2 && (dLauncher = (DLauncher) this.eAj.nQ(32)) != null) {
                    bm(dLauncher);
                }
            }
        }
    }

    public void biQ() {
        boolean z;
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eAy);
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
            l nT = nT(3);
            if (nT != null && (nT.ezZ instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) nT.ezZ);
            }
            l nT2 = nT(28);
            if (nT2 != null && (nT2.ezZ instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) nT2.ezZ);
            }
        }
    }

    public void b(l lVar) {
        if (lVar != null) {
            this.eAl.add(lVar);
        }
    }

    private void clear() {
        this.eAi.clear();
        this.eAj.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.eAp = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.eAi.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.eAj.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, this.ena, i);
        this.eAi.onChangeSkinType(i);
        this.eAj.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.eAz;
    }

    public void bc(List<Integer> list) {
        this.eAz.clear();
        this.eAz.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.eAl != null && this.eAl.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (l lVar : this.eAl) {
                if (lVar.eAM > 0) {
                    linkedList.add(lVar);
                }
                if (lVar.ezZ != null) {
                    lVar.ezZ.setToolId(lVar.id);
                    lVar.ezZ.setEditorTools(this);
                    if (lVar.eAS == 6) {
                        this.eAj.a(lVar.ezZ);
                    } else if (lVar.eAS == 1 || lVar.eAS == 2 || lVar.eAS == 3 || lVar.eAS == 4 || lVar.eAS == 5) {
                        this.eAi.a(lVar.ezZ, lVar.eAS, !lVar.eAT);
                        if (lVar.eAS == 5 && nT(1) == null) {
                            z = true;
                        }
                    }
                    a(lVar.eAU, lVar.id, lVar.ezZ);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<l>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(l lVar2, l lVar3) {
                    return lVar2.eAR - lVar3.eAR;
                }
            });
            if (linkedList.size() > this.eAp) {
                if (this.eAv) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.eAr > 0 && iVar.ezZ != null && (iVar.ezZ instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.ezZ).setBackgroundColorId(this.eAr);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_write_more_tool_point", false)) {
                    iVar.eAV = true;
                } else {
                    iVar.eAV = false;
                }
                b(iVar);
                iVar.ezZ.setToolId(iVar.id);
                iVar.ezZ.setEditorTools(this);
                a(iVar.eAU, iVar.id, iVar.ezZ);
                this.eAj.a(iVar.ezZ);
                if (this.eAq) {
                    linkedList.add(this.eAp, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.eAp + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                l lVar2 = (l) it.next();
                if (i2 < i) {
                    this.eAi.a(a(lVar2, 1));
                } else {
                    this.eAj.a(a(lVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.eAi.a(0, a);
            }
            this.eAi.build();
            this.eAj.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.eAi.setLayoutParams(layoutParams);
            this.eAj.setLayoutParams(layoutParams);
            this.eAj.hide();
            if (this.eAv) {
                this.eAi.setPadding(0, 0, 0, 0);
            }
            bhl();
            removeAllViews();
            if (this.eAi.getBarLauncherType() != 4) {
                biR();
            }
            addView(this.eAi);
            addView(this.eAj);
            invalidate();
        }
    }

    public void bm(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.cS(R.drawable.bg_tip_blue_down);
        eVar.cR(48);
        eVar.mP(true);
        eVar.tn(2);
        eVar.setUseDirectOffset(true);
        eVar.tr(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.to(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.tp(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.cT((int) 3000);
        eVar.z(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void biR() {
        if (this.eAk == null || this.eAk.getParent() != null) {
            this.eAk = new View(getContext());
            ao.setBackgroundResource(this.eAk, R.drawable.bottom_view_shadow);
            this.eAk.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.eAk);
    }

    private void biS() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ao.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.eAx != null) {
                        EditorTools.this.eAx.onClick(view);
                    }
                }
            });
        }
        addView(this.mMaskView, 0);
    }

    public void c(l lVar) {
        if (lVar != null) {
            b(lVar);
            g a = a(lVar, 1);
            a.hide();
            if (this.eAi != null) {
                this.eAi.a(0, a);
                this.eAi.removeAllViews();
                this.eAi.build();
            }
            invalidate();
        }
    }

    public l nT(int i) {
        for (l lVar : this.eAl) {
            if (lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public List<l> getAllTools() {
        return this.eAl;
    }

    public g nQ(int i) {
        g nQ = this.eAi.nQ(i);
        if (nQ == null) {
            return this.eAj.nQ(i);
        }
        return nQ;
    }

    public void biT() {
        this.eAi.h(this.eAw);
    }

    private g a(l lVar, int i) {
        g a = f.a(getContext(), lVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(lVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.eAw);
        }
        return a;
    }

    public void iL(boolean z) {
        for (l lVar : this.eAl) {
            if (lVar != null && (lVar.ezZ instanceof View) && ((View) lVar.ezZ).getVisibility() == 0 && !lVar.eAT) {
                lVar.ezZ.display();
            }
        }
        if (this.eAs) {
            this.eAs = false;
            bhl();
        }
        if (!biL() && z) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.eAy, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        iL(true);
    }

    public void hide() {
        bhl();
        setVisibility(8);
        biQ();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bhl() {
        this.eAj.hide();
        this.eAi.a((l) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.eAj.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.eAi.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.eAi.t(z, i)) {
            this.eAj.u(z, i);
        }
    }

    public boolean biL() {
        return this.eAj.biL();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.eAi.setBarLauncherType(i);
    }

    public void iJ(boolean z) {
        this.eAi.iJ(z);
    }

    public void iK(boolean z) {
        this.eAi.iK(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.eAq = z;
    }

    public void setBackgroundColorId(int i) {
        this.ena = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.eAr = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bn(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            l nT = nT(toolId);
            if (nT.ra()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.eAi.a(nT);
                if (gVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_write_more_tool_point", true);
                    gVar.biI();
                }
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (nT.ezZ == null) {
                    if (nT.eAU != null && nT.eAU.length > 0) {
                        b(new a(nT.eAU[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void biU() {
        this.eAi.a((l) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.eAx = onClickListener;
        biS();
    }
}
