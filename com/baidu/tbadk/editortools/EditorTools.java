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
import com.baidu.tbadk.core.util.an;
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
    private int egR;
    public EditorBar etQ;
    private EditorDesk etR;
    private View etS;
    private List<l> etT;
    private SparseArray<b> etU;
    private SparseArray<HashSet<b>> etV;
    private SparseArray<HashSet<Integer>> etW;
    private int etX;
    private boolean etY;
    private int etZ;
    private boolean eua;
    private LinkedList<g> eub;
    private boolean euc;
    private boolean eud;
    private View.OnClickListener eue;
    private Runnable euf;
    private List<Integer> eug;

    public void bfe() {
        l nB = nB(3);
        if (nB != null && (nB.etH instanceof View)) {
            View view = (View) nB.etH;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.etX = 1;
        this.etY = false;
        this.egR = 0;
        this.etZ = 0;
        this.eua = true;
        this.euc = false;
        this.eud = false;
        this.eue = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bh(view);
            }
        };
        this.euf = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bfe();
            }
        };
        this.eug = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.euc = z;
    }

    public boolean bff() {
        return this.euc;
    }

    public boolean bfg() {
        return this.eud;
    }

    public void setIsFromPb(boolean z) {
        this.eud = z;
    }

    private void init(Context context) {
        this.context = context;
        this.etT = new LinkedList();
        this.etU = new SparseArray<>();
        this.etV = new SparseArray<>();
        this.etW = new SparseArray<>();
        this.etQ = new EditorBar(context, this);
        this.etR = new EditorDesk(context, this);
        this.eub = new LinkedList<>();
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
                HashSet<b> hashSet = this.etV.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.etV.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.etU.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.etW.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.etW.put(i3, hashSet2);
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
        l nB;
        if (aVar != null) {
            if (aVar.code == 2) {
                g ny = this.etQ.ny(aVar.id);
                if (ny != null) {
                    z = false;
                } else {
                    ny = this.etR.ny(aVar.id);
                    z = true;
                }
                if (ny == null) {
                    Iterator<g> it = this.eub.iterator();
                    while (it.hasNext()) {
                        gVar = it.next();
                        if (gVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                gVar = ny;
                if (gVar != null) {
                    gVar.a(aVar);
                    if (z && (nB = nB(2)) != null && nB.etH != null) {
                        nB.etH.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.etQ.a((l) null);
                bdC();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.etU.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.etQ.nw(aVar.id);
                        }
                        l nB2 = nB(aVar.id);
                        if (nB2 != null && nB2.euz == 5) {
                            bdC();
                            bfh();
                        } else {
                            this.etR.nw(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.etW.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.etU.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.etV.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2 && (dLauncher = (DLauncher) this.etR.ny(32)) != null) {
                    bg(dLauncher);
                }
            }
        }
    }

    public void bfh() {
        boolean z;
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.euf);
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
            l nB = nB(3);
            if (nB != null && (nB.etH instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) nB.etH);
            }
            l nB2 = nB(28);
            if (nB2 != null && (nB2.etH instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) nB2.etH);
            }
        }
    }

    public void b(l lVar) {
        if (lVar != null) {
            this.etT.add(lVar);
        }
    }

    private void clear() {
        this.etQ.clear();
        this.etR.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.etX = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.etQ.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.etR.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this, this.egR, i);
        this.etQ.onChangeSkinType(i);
        this.etR.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.eug;
    }

    public void aW(List<Integer> list) {
        this.eug.clear();
        this.eug.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        i iVar;
        if (this.etT != null && this.etT.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (l lVar : this.etT) {
                if (lVar.eut > 0) {
                    linkedList.add(lVar);
                }
                if (lVar.etH != null) {
                    lVar.etH.setToolId(lVar.id);
                    lVar.etH.setEditorTools(this);
                    if (lVar.euz == 6) {
                        this.etR.a(lVar.etH);
                    } else if (lVar.euz == 1 || lVar.euz == 2 || lVar.euz == 3 || lVar.euz == 4 || lVar.euz == 5) {
                        this.etQ.a(lVar.etH, lVar.euz, !lVar.euA);
                        if (lVar.euz == 5 && nB(1) == null) {
                            z = true;
                        }
                    }
                    a(lVar.euB, lVar.id, lVar.etH);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<l>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(l lVar2, l lVar3) {
                    return lVar2.euy - lVar3.euy;
                }
            });
            if (linkedList.size() > this.etX) {
                if (this.eud) {
                    iVar = new i(getContext(), true);
                } else {
                    iVar = new i(getContext());
                }
                if (this.etZ > 0 && iVar.etH != null && (iVar.etH instanceof CommonTabHost)) {
                    ((CommonTabHost) iVar.etH).setBackgroundColorId(this.etZ);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_write_more_tool_point", false)) {
                    iVar.euC = true;
                } else {
                    iVar.euC = false;
                }
                b(iVar);
                iVar.etH.setToolId(iVar.id);
                iVar.etH.setEditorTools(this);
                a(iVar.euB, iVar.id, iVar.etH);
                this.etR.a(iVar.etH);
                if (this.etY) {
                    linkedList.add(this.etX, iVar);
                } else {
                    linkedList.add(0, iVar);
                }
            }
            int i = this.etX + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                l lVar2 = (l) it.next();
                if (i2 < i) {
                    this.etQ.a(a(lVar2, 1));
                } else {
                    this.etR.a(a(lVar2, 2));
                }
                i2++;
            }
            if (z) {
                e eVar = new e();
                b(eVar);
                g a = a(eVar, 1);
                a.hide();
                this.etQ.a(0, a);
            }
            this.etQ.build();
            this.etR.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.etQ.setLayoutParams(layoutParams);
            this.etR.setLayoutParams(layoutParams);
            this.etR.hide();
            if (this.eud) {
                this.etQ.setPadding(0, 0, 0, 0);
            }
            bdC();
            removeAllViews();
            if (this.etQ.getBarLauncherType() != 4) {
                bfi();
            }
            addView(this.etQ);
            addView(this.etR);
            invalidate();
        }
    }

    public void bg(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.cS(R.drawable.bg_tip_blue_down);
        eVar.cR(48);
        eVar.mk(true);
        eVar.sV(2);
        eVar.setUseDirectOffset(true);
        eVar.sZ(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.sW(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.sX(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.cT((int) 3000);
        eVar.z(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void bfi() {
        if (this.etS == null || this.etS.getParent() != null) {
            this.etS = new View(getContext());
            an.setBackgroundResource(this.etS, R.drawable.bottom_view_shadow);
            this.etS.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.etS);
    }

    public void c(l lVar) {
        if (lVar != null) {
            b(lVar);
            g a = a(lVar, 1);
            a.hide();
            if (this.etQ != null) {
                this.etQ.a(0, a);
                this.etQ.removeAllViews();
                this.etQ.build();
            }
            invalidate();
        }
    }

    public l nB(int i) {
        for (l lVar : this.etT) {
            if (lVar.id == i) {
                return lVar;
            }
        }
        return null;
    }

    public List<l> getAllTools() {
        return this.etT;
    }

    public g ny(int i) {
        g ny = this.etQ.ny(i);
        if (ny == null) {
            return this.etR.ny(i);
        }
        return ny;
    }

    public void bfj() {
        this.etQ.h(this.eue);
    }

    private g a(l lVar, int i) {
        g a = f.a(getContext(), lVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(lVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.eue);
        }
        return a;
    }

    public void ih(boolean z) {
        for (l lVar : this.etT) {
            if (lVar != null && (lVar.etH instanceof View) && ((View) lVar.etH).getVisibility() == 0 && !lVar.euA) {
                lVar.etH.display();
            }
        }
        if (this.eua) {
            this.eua = false;
            bdC();
        }
        if (!bfc() && z) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.euf, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        ih(true);
    }

    public void hide() {
        bdC();
        setVisibility(8);
        bfh();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bdC() {
        this.etR.hide();
        this.etQ.a((l) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.etR.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.etQ.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.etQ.t(z, i)) {
            this.etR.u(z, i);
        }
    }

    public boolean bfc() {
        return this.etR.bfc();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.etQ.setBarLauncherType(i);
    }

    /* renamed from: if  reason: not valid java name */
    public void m32if(boolean z) {
        this.etQ.m31if(z);
    }

    public void ig(boolean z) {
        this.etQ.ig(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.etY = z;
    }

    public void setBackgroundColorId(int i) {
        this.egR = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.etZ = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bh(View view) {
        if (view instanceof g) {
            g gVar = (g) view;
            int toolId = gVar.getToolId();
            l nB = nB(toolId);
            if (nB.qY()) {
                b(new a(31, 0, Integer.valueOf(gVar.getToolId())));
                this.etQ.a(nB);
                if (gVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_write_more_tool_point", true);
                    gVar.beZ();
                }
                if (gVar.getToolId() == 1) {
                    gVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (nB.etH == null) {
                    if (nB.euB != null && nB.euB.length > 0) {
                        b(new a(nB.euB[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bfk() {
        this.etQ.a((l) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
