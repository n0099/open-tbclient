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
    public EditorBar fDQ;
    public EditorDesk fDR;
    private View fDS;
    private List<m> fDT;
    private SparseArray<b> fDU;
    private SparseArray<HashSet<b>> fDV;
    private SparseArray<HashSet<Integer>> fDW;
    private int fDX;
    private boolean fDY;
    private int fDZ;
    private boolean fEa;
    private LinkedList<h> fEb;
    private boolean fEc;
    private boolean fEd;
    private View.OnClickListener fEe;
    private View.OnClickListener fEf;
    private Runnable fEg;
    private List<Integer> fEh;
    private int fpV;
    private View mMaskView;

    public void bEP() {
        m sv = sv(3);
        if (sv != null && (sv.fDH instanceof View)) {
            View view = (View) sv.fDH;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.fDX = 1;
        this.fDY = false;
        this.fpV = 0;
        this.fDZ = 0;
        this.fEa = true;
        this.fEc = false;
        this.fEd = false;
        this.fEe = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bP(view);
            }
        };
        this.fEg = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bEP();
            }
        };
        this.fEh = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.fEc = z;
    }

    public boolean bEQ() {
        return this.fEc;
    }

    public boolean bER() {
        return this.fEd;
    }

    public void setIsFromPb(boolean z) {
        this.fEd = z;
    }

    private void init(Context context) {
        this.context = context;
        this.fDT = new LinkedList();
        this.fDU = new SparseArray<>();
        this.fDV = new SparseArray<>();
        this.fDW = new SparseArray<>();
        this.fDQ = new EditorBar(context, this);
        this.fDR = new EditorDesk(context, this);
        this.fEb = new LinkedList<>();
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
                HashSet<b> hashSet = this.fDV.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.fDV.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.fDU.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.fDW.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.fDW.put(i3, hashSet2);
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
        m sv;
        if (aVar != null) {
            if (aVar.code == 2) {
                h ss = this.fDQ.ss(aVar.id);
                if (ss != null) {
                    z = false;
                } else {
                    ss = this.fDR.ss(aVar.id);
                    z = true;
                }
                if (ss == null) {
                    Iterator<h> it = this.fEb.iterator();
                    while (it.hasNext()) {
                        hVar = it.next();
                        if (hVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                hVar = ss;
                if (hVar != null) {
                    hVar.a(aVar);
                    if (z && (sv = sv(2)) != null && sv.fDH != null) {
                        sv.fDH.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.fDQ.a((m) null);
                this.fDR.bEL();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.fDU.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.fDQ.sq(aVar.id);
                        }
                        m sv2 = sv(aVar.id);
                        if (sv2 != null && sv2.fEB == 5) {
                            bDf();
                            bES();
                        } else {
                            this.fDR.sq(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.fDW.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.fDU.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.fDV.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.fDR.ss(32);
                    if (dLauncher != null) {
                        bO(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void bES() {
        boolean z;
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fEg);
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
            m sv = sv(3);
            if (sv != null && (sv.fDH instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) sv.fDH);
            }
            m sv2 = sv(28);
            if (sv2 != null && (sv2.fDH instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) sv2.fDH);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.fDT.add(mVar);
        }
    }

    private void clear() {
        this.fDQ.clear();
        this.fDR.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.fDX = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.fDQ.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.fDR.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, this.fpV, i);
        this.fDQ.onChangeSkinType(i);
        this.fDR.onChangeSkinType(i);
        if (this.fDS != null) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.fDS).pK(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
        }
    }

    public List<Integer> getCollectTools() {
        return this.fEh;
    }

    public void bL(List<Integer> list) {
        this.fEh.clear();
        this.fEh.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.fDT != null && this.fDT.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.fDT) {
                if (mVar.fEu > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.fDH != null) {
                    mVar.fDH.setToolId(mVar.id);
                    mVar.fDH.setEditorTools(this);
                    if (mVar.fEB == 6) {
                        this.fDR.a(mVar.fDH);
                    } else if (mVar.fEB == 1 || mVar.fEB == 2 || mVar.fEB == 3 || mVar.fEB == 4 || mVar.fEB == 5) {
                        this.fDQ.a(mVar.fDH, mVar.fEB, !mVar.fEC);
                        if (mVar.fEB == 5 && sv(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.fED, mVar.id, mVar.fDH);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.fEA - mVar3.fEA;
                }
            });
            if (linkedList.size() > this.fDX) {
                if (this.fEd) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.fDZ > 0 && jVar.fDH != null && (jVar.fDH instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.fDH).setBackgroundColorId(this.fDZ);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_write_more_tool_point", false)) {
                    jVar.fEE = true;
                } else {
                    jVar.fEE = false;
                }
                b(jVar);
                jVar.fDH.setToolId(jVar.id);
                jVar.fDH.setEditorTools(this);
                a(jVar.fED, jVar.id, jVar.fDH);
                this.fDR.a(jVar.fDH);
                if (this.fDY) {
                    linkedList.add(this.fDX, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.fDX + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.fDQ.a(a(mVar2, 1));
                } else {
                    this.fDR.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a2 = a(fVar, 1);
                a2.hide();
                this.fDQ.a(0, a2);
            }
            this.fDQ.build();
            this.fDR.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.fDQ.setLayoutParams(layoutParams);
            this.fDR.setLayoutParams(layoutParams2);
            this.fDR.hide();
            if (this.fEd) {
                this.fDQ.setPadding(0, 0, 0, 0);
            }
            bDf();
            removeAllViews();
            if (this.fDQ.getBarLauncherType() != 4) {
                bET();
            }
            addView(this.fDQ);
            addView(this.fDR);
            invalidate();
        }
    }

    public void bO(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.fP(R.drawable.bg_tip_blue_down);
        eVar.fO(48);
        eVar.pD(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.yH(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.yE(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.yF(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fQ((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.C(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void bET() {
        if (this.fDS == null || this.fDS.getParent() != null) {
            this.fDS = new View(getContext());
            com.baidu.tbadk.core.elementsMaven.c.bv(this.fDS).pK(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
            this.fDS.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.L_X01)));
        }
        addView(this.fDS);
    }

    private void bEU() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ao.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.fEf != null) {
                        EditorTools.this.fEf.onClick(view);
                    }
                }
            });
        }
        addView(this.mMaskView, 0);
    }

    public void c(m mVar) {
        if (mVar != null) {
            b(mVar);
            h a2 = a(mVar, 1);
            a2.hide();
            if (this.fDQ != null) {
                this.fDQ.a(0, a2);
                this.fDQ.removeAllViews();
                this.fDQ.build();
            }
            invalidate();
        }
    }

    public m sv(int i) {
        for (m mVar : this.fDT) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.fDT;
    }

    public h ss(int i) {
        h ss = this.fDQ.ss(i);
        if (ss == null) {
            return this.fDR.ss(i);
        }
        return ss;
    }

    public void bEV() {
        this.fDQ.j(this.fEe);
    }

    private h a(m mVar, int i) {
        h a2 = g.a(getContext(), mVar, i);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.name);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.fEe);
        }
        return a2;
    }

    public void kQ(boolean z) {
        for (m mVar : this.fDT) {
            if (mVar != null && (mVar.fDH instanceof View) && ((View) mVar.fDH).getVisibility() == 0 && !mVar.fEC) {
                mVar.fDH.rV();
            }
        }
        if (this.fEa) {
            this.fEa = false;
            bDf();
        }
        if (!bEN() && z) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.fEg, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void rV() {
        kQ(true);
    }

    public void hide() {
        bDf();
        setVisibility(8);
        bES();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bDf() {
        this.fDR.hide();
        this.fDQ.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.fDR.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.fDQ.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.fDQ.t(z, i)) {
            this.fDR.u(z, i);
        }
    }

    public boolean bEN() {
        return this.fDR.bEN();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.fDQ.setBarLauncherType(i);
    }

    public void kO(boolean z) {
        this.fDQ.kO(z);
    }

    public void kP(boolean z) {
        this.fDQ.kP(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.fDY = z;
    }

    public void setBackgroundColorId(int i) {
        this.fpV = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.fDZ = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bP(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m sv = sv(toolId);
            if (sv.sj()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.fDQ.a(sv);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("key_write_more_tool_point", true);
                    hVar.bEI();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    rV();
                    b(new a(1, 3, null));
                } else if (sv.fDH == null) {
                    if (sv.fED != null && sv.fED.length > 0) {
                        b(new a(sv.fED[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bEW() {
        this.fDQ.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.fEf = onClickListener;
        bEU();
    }
}
