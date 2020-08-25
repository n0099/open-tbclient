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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class EditorTools extends LinearLayout {
    private Context context;
    public EditorBar eKG;
    private EditorDesk eKH;
    private View eKI;
    private List<m> eKJ;
    private SparseArray<b> eKK;
    private SparseArray<HashSet<b>> eKL;
    private SparseArray<HashSet<Integer>> eKM;
    private int eKN;
    private boolean eKO;
    private int eKP;
    private boolean eKQ;
    private LinkedList<h> eKR;
    private boolean eKS;
    private boolean eKT;
    private View.OnClickListener eKU;
    private View.OnClickListener eKV;
    private Runnable eKW;
    private List<Integer> eKX;
    private int exe;
    private View mMaskView;

    public void brz() {
        m qe = qe(3);
        if (qe != null && (qe.eKx instanceof View)) {
            View view = (View) qe.eKx;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.eKN = 1;
        this.eKO = false;
        this.exe = 0;
        this.eKP = 0;
        this.eKQ = true;
        this.eKS = false;
        this.eKT = false;
        this.eKU = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bp(view);
            }
        };
        this.eKW = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.brz();
            }
        };
        this.eKX = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.eKS = z;
    }

    public boolean brA() {
        return this.eKS;
    }

    public boolean brB() {
        return this.eKT;
    }

    public void setIsFromPb(boolean z) {
        this.eKT = z;
    }

    private void init(Context context) {
        this.context = context;
        this.eKJ = new LinkedList();
        this.eKK = new SparseArray<>();
        this.eKL = new SparseArray<>();
        this.eKM = new SparseArray<>();
        this.eKG = new EditorBar(context, this);
        this.eKH = new EditorDesk(context, this);
        this.eKR = new LinkedList<>();
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
                HashSet<b> hashSet = this.eKL.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.eKL.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.eKK.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.eKM.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.eKM.put(i3, hashSet2);
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
        h hVar;
        m qe;
        if (aVar != null) {
            if (aVar.code == 2) {
                h qb = this.eKG.qb(aVar.id);
                if (qb != null) {
                    z = false;
                } else {
                    qb = this.eKH.qb(aVar.id);
                    z = true;
                }
                if (qb == null) {
                    Iterator<h> it = this.eKR.iterator();
                    while (it.hasNext()) {
                        hVar = it.next();
                        if (hVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                hVar = qb;
                if (hVar != null) {
                    hVar.a(aVar);
                    if (z && (qe = qe(2)) != null && qe.eKx != null) {
                        qe.eKx.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.eKG.a((m) null);
                bpX();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.eKK.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.eKG.pZ(aVar.id);
                        }
                        m qe2 = qe(aVar.id);
                        if (qe2 != null && qe2.eLr == 5) {
                            bpX();
                            brC();
                        } else {
                            this.eKH.pZ(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.eKM.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.eKK.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.eKL.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.eKH.qb(32);
                    if (dLauncher != null) {
                        bo(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void brC() {
        boolean z;
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.eKW);
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
            m qe = qe(3);
            if (qe != null && (qe.eKx instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qe.eKx);
            }
            m qe2 = qe(28);
            if (qe2 != null && (qe2.eKx instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qe2.eKx);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.eKJ.add(mVar);
        }
    }

    private void clear() {
        this.eKG.clear();
        this.eKH.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.eKN = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.eKG.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.eKH.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.exe, i);
        this.eKG.onChangeSkinType(i);
        this.eKH.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.eKX;
    }

    public void bc(List<Integer> list) {
        this.eKX.clear();
        this.eKX.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.eKJ != null && this.eKJ.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.eKJ) {
                if (mVar.eLk > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.eKx != null) {
                    mVar.eKx.setToolId(mVar.id);
                    mVar.eKx.setEditorTools(this);
                    if (mVar.eLr == 6) {
                        this.eKH.a(mVar.eKx);
                    } else if (mVar.eLr == 1 || mVar.eLr == 2 || mVar.eLr == 3 || mVar.eLr == 4 || mVar.eLr == 5) {
                        this.eKG.a(mVar.eKx, mVar.eLr, !mVar.eLs);
                        if (mVar.eLr == 5 && qe(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.eLt, mVar.id, mVar.eKx);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.eLq - mVar3.eLq;
                }
            });
            if (linkedList.size() > this.eKN) {
                if (this.eKT) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.eKP > 0 && jVar.eKx != null && (jVar.eKx instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.eKx).setBackgroundColorId(this.eKP);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_write_more_tool_point", false)) {
                    jVar.eLu = true;
                } else {
                    jVar.eLu = false;
                }
                b(jVar);
                jVar.eKx.setToolId(jVar.id);
                jVar.eKx.setEditorTools(this);
                a(jVar.eLt, jVar.id, jVar.eKx);
                this.eKH.a(jVar.eKx);
                if (this.eKO) {
                    linkedList.add(this.eKN, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.eKN + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.eKG.a(a(mVar2, 1));
                } else {
                    this.eKH.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a = a(fVar, 1);
                a.hide();
                this.eKG.a(0, a);
            }
            this.eKG.build();
            this.eKH.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.eKG.setLayoutParams(layoutParams);
            this.eKH.setLayoutParams(layoutParams);
            this.eKH.hide();
            if (this.eKT) {
                this.eKG.setPadding(0, 0, 0, 0);
            }
            bpX();
            removeAllViews();
            if (this.eKG.getBarLauncherType() != 4) {
                brD();
            }
            addView(this.eKG);
            addView(this.eKH);
            invalidate();
        }
    }

    public void bo(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.eL(R.drawable.bg_tip_blue_down);
        eVar.eK(48);
        eVar.ns(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.vF(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.vC(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.vD(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.eM((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.y(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void brD() {
        if (this.eKI == null || this.eKI.getParent() != null) {
            this.eKI = new View(getContext());
            ap.setBackgroundResource(this.eKI, R.drawable.bottom_view_shadow);
            this.eKI.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.eKI);
    }

    private void brE() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ap.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.eKV != null) {
                        EditorTools.this.eKV.onClick(view);
                    }
                }
            });
        }
        addView(this.mMaskView, 0);
    }

    public void c(m mVar) {
        if (mVar != null) {
            b(mVar);
            h a = a(mVar, 1);
            a.hide();
            if (this.eKG != null) {
                this.eKG.a(0, a);
                this.eKG.removeAllViews();
                this.eKG.build();
            }
            invalidate();
        }
    }

    public m qe(int i) {
        for (m mVar : this.eKJ) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.eKJ;
    }

    public h qb(int i) {
        h qb = this.eKG.qb(i);
        if (qb == null) {
            return this.eKH.qb(i);
        }
        return qb;
    }

    public void brF() {
        this.eKG.h(this.eKU);
    }

    private h a(m mVar, int i) {
        h a = g.a(getContext(), mVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(mVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.eKU);
        }
        return a;
    }

    public void jj(boolean z) {
        for (m mVar : this.eKJ) {
            if (mVar != null && (mVar.eKx instanceof View) && ((View) mVar.eKx).getVisibility() == 0 && !mVar.eLs) {
                mVar.eKx.display();
            }
        }
        if (this.eKQ) {
            this.eKQ = false;
            bpX();
        }
        if (!brx() && z) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.eKW, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        jj(true);
    }

    public void hide() {
        bpX();
        setVisibility(8);
        brC();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bpX() {
        this.eKH.hide();
        this.eKG.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.eKH.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.eKG.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.eKG.t(z, i)) {
            this.eKH.u(z, i);
        }
    }

    public boolean brx() {
        return this.eKH.brx();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.eKG.setBarLauncherType(i);
    }

    public void jh(boolean z) {
        this.eKG.jh(z);
    }

    public void ji(boolean z) {
        this.eKG.ji(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.eKO = z;
    }

    public void setBackgroundColorId(int i) {
        this.exe = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.eKP = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bp(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m qe = qe(toolId);
            if (qe.sz()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.eKG.a(qe);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_write_more_tool_point", true);
                    hVar.bru();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (qe.eKx == null) {
                    if (qe.eLt != null && qe.eLt.length > 0) {
                        b(new a(qe.eLt[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void brG() {
        this.eKG.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.eKV = onClickListener;
        brE();
    }
}
