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
    public EditorBar fCW;
    public EditorDesk fCX;
    private View fCY;
    private List<m> fCZ;
    private SparseArray<b> fDa;
    private SparseArray<HashSet<b>> fDb;
    private SparseArray<HashSet<Integer>> fDc;
    private int fDd;
    private boolean fDe;
    private int fDf;
    private boolean fDg;
    private LinkedList<h> fDh;
    private boolean fDi;
    private boolean fDj;
    private View.OnClickListener fDk;
    private View.OnClickListener fDl;
    private Runnable fDm;
    private List<Integer> fDn;
    private int fpd;
    private View mMaskView;

    public void bBq() {
        m qV = qV(3);
        if (qV != null && (qV.fCN instanceof View)) {
            View view = (View) qV.fCN;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.fDd = 1;
        this.fDe = false;
        this.fpd = 0;
        this.fDf = 0;
        this.fDg = true;
        this.fDi = false;
        this.fDj = false;
        this.fDk = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bL(view);
            }
        };
        this.fDm = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bBq();
            }
        };
        this.fDn = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.fDi = z;
    }

    public boolean bBr() {
        return this.fDi;
    }

    public boolean bBs() {
        return this.fDj;
    }

    public void setIsFromPb(boolean z) {
        this.fDj = z;
    }

    private void init(Context context) {
        this.context = context;
        this.fCZ = new LinkedList();
        this.fDa = new SparseArray<>();
        this.fDb = new SparseArray<>();
        this.fDc = new SparseArray<>();
        this.fCW = new EditorBar(context, this);
        this.fCX = new EditorDesk(context, this);
        this.fDh = new LinkedList<>();
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
                HashSet<b> hashSet = this.fDb.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.fDb.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.fDa.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.fDc.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.fDc.put(i3, hashSet2);
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
        m qV;
        if (aVar != null) {
            if (aVar.code == 2) {
                h qS = this.fCW.qS(aVar.id);
                if (qS != null) {
                    z = false;
                } else {
                    qS = this.fCX.qS(aVar.id);
                    z = true;
                }
                if (qS == null) {
                    Iterator<h> it = this.fDh.iterator();
                    while (it.hasNext()) {
                        hVar = it.next();
                        if (hVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                hVar = qS;
                if (hVar != null) {
                    hVar.a(aVar);
                    if (z && (qV = qV(2)) != null && qV.fCN != null) {
                        qV.fCN.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.fCW.a((m) null);
                this.fCX.bBm();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.fDa.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.fCW.qQ(aVar.id);
                        }
                        m qV2 = qV(aVar.id);
                        if (qV2 != null && qV2.fDH == 5) {
                            bzG();
                            bBt();
                        } else {
                            this.fCX.qQ(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.fDc.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.fDa.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.fDb.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.fCX.qS(32);
                    if (dLauncher != null) {
                        bK(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void bBt() {
        boolean z;
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fDm);
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
            m qV = qV(3);
            if (qV != null && (qV.fCN instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qV.fCN);
            }
            m qV2 = qV(28);
            if (qV2 != null && (qV2.fCN instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qV2.fCN);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.fCZ.add(mVar);
        }
    }

    private void clear() {
        this.fCW.clear();
        this.fCX.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.fDd = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.fCW.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.fCX.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.fpd, i);
        this.fCW.onChangeSkinType(i);
        this.fCX.onChangeSkinType(i);
        if (this.fCY != null) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.fCY).oh(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
        }
    }

    public List<Integer> getCollectTools() {
        return this.fDn;
    }

    public void bG(List<Integer> list) {
        this.fDn.clear();
        this.fDn.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.fCZ != null && this.fCZ.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.fCZ) {
                if (mVar.fDA > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.fCN != null) {
                    mVar.fCN.setToolId(mVar.id);
                    mVar.fCN.setEditorTools(this);
                    if (mVar.fDH == 6) {
                        this.fCX.a(mVar.fCN);
                    } else if (mVar.fDH == 1 || mVar.fDH == 2 || mVar.fDH == 3 || mVar.fDH == 4 || mVar.fDH == 5) {
                        this.fCW.a(mVar.fCN, mVar.fDH, !mVar.fDI);
                        if (mVar.fDH == 5 && qV(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.fDJ, mVar.id, mVar.fCN);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.fDG - mVar3.fDG;
                }
            });
            if (linkedList.size() > this.fDd) {
                if (this.fDj) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.fDf > 0 && jVar.fCN != null && (jVar.fCN instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.fCN).setBackgroundColorId(this.fDf);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_write_more_tool_point", false)) {
                    jVar.fDK = true;
                } else {
                    jVar.fDK = false;
                }
                b(jVar);
                jVar.fCN.setToolId(jVar.id);
                jVar.fCN.setEditorTools(this);
                a(jVar.fDJ, jVar.id, jVar.fCN);
                this.fCX.a(jVar.fCN);
                if (this.fDe) {
                    linkedList.add(this.fDd, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.fDd + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.fCW.a(a(mVar2, 1));
                } else {
                    this.fCX.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a2 = a(fVar, 1);
                a2.hide();
                this.fCW.a(0, a2);
            }
            this.fCW.build();
            this.fCX.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.fCW.setLayoutParams(layoutParams);
            this.fCX.setLayoutParams(layoutParams2);
            this.fCX.hide();
            if (this.fDj) {
                this.fCW.setPadding(0, 0, 0, 0);
            }
            bzG();
            removeAllViews();
            if (this.fCW.getBarLauncherType() != 4) {
                bBu();
            }
            addView(this.fCW);
            addView(this.fCX);
            invalidate();
        }
    }

    public void bK(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.eo(R.drawable.bg_tip_blue_down);
        eVar.en(48);
        eVar.pJ(true);
        eVar.xi(2);
        eVar.setUseDirectOffset(true);
        eVar.xm(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.xj(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.xk(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.ep((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.C(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void bBu() {
        if (this.fCY == null || this.fCY.getParent() != null) {
            this.fCY = new View(getContext());
            com.baidu.tbadk.core.elementsMaven.c.br(this.fCY).oh(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
            this.fCY.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.L_X01)));
        }
        addView(this.fCY);
    }

    private void bBv() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ap.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.fDl != null) {
                        EditorTools.this.fDl.onClick(view);
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
            if (this.fCW != null) {
                this.fCW.a(0, a2);
                this.fCW.removeAllViews();
                this.fCW.build();
            }
            invalidate();
        }
    }

    public m qV(int i) {
        for (m mVar : this.fCZ) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.fCZ;
    }

    public h qS(int i) {
        h qS = this.fCW.qS(i);
        if (qS == null) {
            return this.fCX.qS(i);
        }
        return qS;
    }

    public void bBw() {
        this.fCW.j(this.fDk);
    }

    private h a(m mVar, int i) {
        h a2 = g.a(getContext(), mVar, i);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.name);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.fDk);
        }
        return a2;
    }

    public void kP(boolean z) {
        for (m mVar : this.fCZ) {
            if (mVar != null && (mVar.fCN instanceof View) && ((View) mVar.fCN).getVisibility() == 0 && !mVar.fDI) {
                mVar.fCN.display();
            }
        }
        if (this.fDg) {
            this.fDg = false;
            bzG();
        }
        if (!bBo() && z) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.fDm, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        kP(true);
    }

    public void hide() {
        bzG();
        setVisibility(8);
        bBt();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bzG() {
        this.fCX.hide();
        this.fCW.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.fCX.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.fCW.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.fCW.t(z, i)) {
            this.fCX.u(z, i);
        }
    }

    public boolean bBo() {
        return this.fCX.bBo();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.fCW.setBarLauncherType(i);
    }

    public void kN(boolean z) {
        this.fCW.kN(z);
    }

    public void kO(boolean z) {
        this.fCW.kO(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.fDe = z;
    }

    public void setBackgroundColorId(int i) {
        this.fpd = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.fDf = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bL(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m qV = qV(toolId);
            if (qV.sg()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.fCW.a(qV);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_write_more_tool_point", true);
                    hVar.bBj();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (qV.fCN == null) {
                    if (qV.fDJ != null && qV.fDJ.length > 0) {
                        b(new a(qV.fDJ[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bBx() {
        this.fCW.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.fDl = onClickListener;
        bBv();
    }
}
