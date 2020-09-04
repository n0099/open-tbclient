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
/* loaded from: classes.dex */
public class EditorTools extends LinearLayout {
    private Context context;
    public EditorBar eKK;
    private EditorDesk eKL;
    private View eKM;
    private List<m> eKN;
    private SparseArray<b> eKO;
    private SparseArray<HashSet<b>> eKP;
    private SparseArray<HashSet<Integer>> eKQ;
    private int eKR;
    private boolean eKS;
    private int eKT;
    private boolean eKU;
    private LinkedList<h> eKV;
    private boolean eKW;
    private boolean eKX;
    private View.OnClickListener eKY;
    private View.OnClickListener eKZ;
    private Runnable eLa;
    private List<Integer> eLb;
    private int exi;
    private View mMaskView;

    public void brA() {
        m qe = qe(3);
        if (qe != null && (qe.eKB instanceof View)) {
            View view = (View) qe.eKB;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.eKR = 1;
        this.eKS = false;
        this.exi = 0;
        this.eKT = 0;
        this.eKU = true;
        this.eKW = false;
        this.eKX = false;
        this.eKY = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bp(view);
            }
        };
        this.eLa = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.brA();
            }
        };
        this.eLb = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.eKW = z;
    }

    public boolean brB() {
        return this.eKW;
    }

    public boolean brC() {
        return this.eKX;
    }

    public void setIsFromPb(boolean z) {
        this.eKX = z;
    }

    private void init(Context context) {
        this.context = context;
        this.eKN = new LinkedList();
        this.eKO = new SparseArray<>();
        this.eKP = new SparseArray<>();
        this.eKQ = new SparseArray<>();
        this.eKK = new EditorBar(context, this);
        this.eKL = new EditorDesk(context, this);
        this.eKV = new LinkedList<>();
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
                HashSet<b> hashSet = this.eKP.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.eKP.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.eKO.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.eKQ.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.eKQ.put(i3, hashSet2);
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
                h qb = this.eKK.qb(aVar.id);
                if (qb != null) {
                    z = false;
                } else {
                    qb = this.eKL.qb(aVar.id);
                    z = true;
                }
                if (qb == null) {
                    Iterator<h> it = this.eKV.iterator();
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
                    if (z && (qe = qe(2)) != null && qe.eKB != null) {
                        qe.eKB.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.eKK.a((m) null);
                bpY();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.eKO.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.eKK.pZ(aVar.id);
                        }
                        m qe2 = qe(aVar.id);
                        if (qe2 != null && qe2.eLv == 5) {
                            bpY();
                            brD();
                        } else {
                            this.eKL.pZ(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.eKQ.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.eKO.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.eKP.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.eKL.qb(32);
                    if (dLauncher != null) {
                        bo(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void brD() {
        boolean z;
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.eLa);
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
            if (qe != null && (qe.eKB instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qe.eKB);
            }
            m qe2 = qe(28);
            if (qe2 != null && (qe2.eKB instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qe2.eKB);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.eKN.add(mVar);
        }
    }

    private void clear() {
        this.eKK.clear();
        this.eKL.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.eKR = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.eKK.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.eKL.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.exi, i);
        this.eKK.onChangeSkinType(i);
        this.eKL.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.eLb;
    }

    public void bc(List<Integer> list) {
        this.eLb.clear();
        this.eLb.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.eKN != null && this.eKN.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.eKN) {
                if (mVar.eLo > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.eKB != null) {
                    mVar.eKB.setToolId(mVar.id);
                    mVar.eKB.setEditorTools(this);
                    if (mVar.eLv == 6) {
                        this.eKL.a(mVar.eKB);
                    } else if (mVar.eLv == 1 || mVar.eLv == 2 || mVar.eLv == 3 || mVar.eLv == 4 || mVar.eLv == 5) {
                        this.eKK.a(mVar.eKB, mVar.eLv, !mVar.eLw);
                        if (mVar.eLv == 5 && qe(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.eLx, mVar.id, mVar.eKB);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.eLu - mVar3.eLu;
                }
            });
            if (linkedList.size() > this.eKR) {
                if (this.eKX) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.eKT > 0 && jVar.eKB != null && (jVar.eKB instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.eKB).setBackgroundColorId(this.eKT);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_write_more_tool_point", false)) {
                    jVar.eLy = true;
                } else {
                    jVar.eLy = false;
                }
                b(jVar);
                jVar.eKB.setToolId(jVar.id);
                jVar.eKB.setEditorTools(this);
                a(jVar.eLx, jVar.id, jVar.eKB);
                this.eKL.a(jVar.eKB);
                if (this.eKS) {
                    linkedList.add(this.eKR, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.eKR + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.eKK.a(a(mVar2, 1));
                } else {
                    this.eKL.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a = a(fVar, 1);
                a.hide();
                this.eKK.a(0, a);
            }
            this.eKK.build();
            this.eKL.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.eKK.setLayoutParams(layoutParams);
            this.eKL.setLayoutParams(layoutParams);
            this.eKL.hide();
            if (this.eKX) {
                this.eKK.setPadding(0, 0, 0, 0);
            }
            bpY();
            removeAllViews();
            if (this.eKK.getBarLauncherType() != 4) {
                brE();
            }
            addView(this.eKK);
            addView(this.eKL);
            invalidate();
        }
    }

    public void bo(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.eL(R.drawable.bg_tip_blue_down);
        eVar.eK(48);
        eVar.nu(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.vF(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.vC(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.vD(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.eM((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.y(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void brE() {
        if (this.eKM == null || this.eKM.getParent() != null) {
            this.eKM = new View(getContext());
            ap.setBackgroundResource(this.eKM, R.drawable.bottom_view_shadow);
            this.eKM.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.eKM);
    }

    private void brF() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ap.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.eKZ != null) {
                        EditorTools.this.eKZ.onClick(view);
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
            if (this.eKK != null) {
                this.eKK.a(0, a);
                this.eKK.removeAllViews();
                this.eKK.build();
            }
            invalidate();
        }
    }

    public m qe(int i) {
        for (m mVar : this.eKN) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.eKN;
    }

    public h qb(int i) {
        h qb = this.eKK.qb(i);
        if (qb == null) {
            return this.eKL.qb(i);
        }
        return qb;
    }

    public void brG() {
        this.eKK.h(this.eKY);
    }

    private h a(m mVar, int i) {
        h a = g.a(getContext(), mVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(mVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.eKY);
        }
        return a;
    }

    public void jl(boolean z) {
        for (m mVar : this.eKN) {
            if (mVar != null && (mVar.eKB instanceof View) && ((View) mVar.eKB).getVisibility() == 0 && !mVar.eLw) {
                mVar.eKB.display();
            }
        }
        if (this.eKU) {
            this.eKU = false;
            bpY();
        }
        if (!bry() && z) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.eLa, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        jl(true);
    }

    public void hide() {
        bpY();
        setVisibility(8);
        brD();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bpY() {
        this.eKL.hide();
        this.eKK.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.eKL.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.eKK.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.eKK.t(z, i)) {
            this.eKL.u(z, i);
        }
    }

    public boolean bry() {
        return this.eKL.bry();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.eKK.setBarLauncherType(i);
    }

    public void jj(boolean z) {
        this.eKK.jj(z);
    }

    public void jk(boolean z) {
        this.eKK.jk(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.eKS = z;
    }

    public void setBackgroundColorId(int i) {
        this.exi = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.eKT = i;
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
                this.eKK.a(qe);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_write_more_tool_point", true);
                    hVar.brv();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (qe.eKB == null) {
                    if (qe.eLx != null && qe.eLx.length > 0) {
                        b(new a(qe.eLx[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void brH() {
        this.eKK.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.eKZ = onClickListener;
        brF();
    }
}
