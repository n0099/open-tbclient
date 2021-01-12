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
    private int fll;
    public EditorBar fzi;
    public EditorDesk fzj;
    private View fzk;
    private List<m> fzl;
    private SparseArray<b> fzm;
    private SparseArray<HashSet<b>> fzn;
    private SparseArray<HashSet<Integer>> fzo;
    private int fzp;
    private boolean fzq;
    private int fzr;
    private boolean fzs;
    private LinkedList<h> fzt;
    private boolean fzu;
    private boolean fzv;
    private View.OnClickListener fzw;
    private View.OnClickListener fzx;
    private Runnable fzy;
    private List<Integer> fzz;
    private View mMaskView;

    public void bAV() {
        m qP = qP(3);
        if (qP != null && (qP.fyZ instanceof View)) {
            View view = (View) qP.fyZ;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.fzp = 1;
        this.fzq = false;
        this.fll = 0;
        this.fzr = 0;
        this.fzs = true;
        this.fzu = false;
        this.fzv = false;
        this.fzw = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bP(view);
            }
        };
        this.fzy = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bAV();
            }
        };
        this.fzz = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.fzu = z;
    }

    public boolean bAW() {
        return this.fzu;
    }

    public boolean bAX() {
        return this.fzv;
    }

    public void setIsFromPb(boolean z) {
        this.fzv = z;
    }

    private void init(Context context) {
        this.context = context;
        this.fzl = new LinkedList();
        this.fzm = new SparseArray<>();
        this.fzn = new SparseArray<>();
        this.fzo = new SparseArray<>();
        this.fzi = new EditorBar(context, this);
        this.fzj = new EditorDesk(context, this);
        this.fzt = new LinkedList<>();
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
                HashSet<b> hashSet = this.fzn.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.fzn.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.fzm.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.fzo.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.fzo.put(i3, hashSet2);
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
        m qP;
        if (aVar != null) {
            if (aVar.code == 2) {
                h qM = this.fzi.qM(aVar.id);
                if (qM != null) {
                    z = false;
                } else {
                    qM = this.fzj.qM(aVar.id);
                    z = true;
                }
                if (qM == null) {
                    Iterator<h> it = this.fzt.iterator();
                    while (it.hasNext()) {
                        hVar = it.next();
                        if (hVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                hVar = qM;
                if (hVar != null) {
                    hVar.a(aVar);
                    if (z && (qP = qP(2)) != null && qP.fyZ != null) {
                        qP.fyZ.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.fzi.a((m) null);
                this.fzj.bAR();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.fzm.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.fzi.qK(aVar.id);
                        }
                        m qP2 = qP(aVar.id);
                        if (qP2 != null && qP2.fzT == 5) {
                            bzl();
                            bAY();
                        } else {
                            this.fzj.qK(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.fzo.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.fzm.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.fzn.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.fzj.qM(32);
                    if (dLauncher != null) {
                        bO(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void bAY() {
        boolean z;
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fzy);
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
            m qP = qP(3);
            if (qP != null && (qP.fyZ instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qP.fyZ);
            }
            m qP2 = qP(28);
            if (qP2 != null && (qP2.fyZ instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qP2.fyZ);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.fzl.add(mVar);
        }
    }

    private void clear() {
        this.fzi.clear();
        this.fzj.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.fzp = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.fzi.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.fzj.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, this.fll, i);
        this.fzi.onChangeSkinType(i);
        this.fzj.onChangeSkinType(i);
        if (this.fzk != null) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.fzk).od(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
        }
    }

    public List<Integer> getCollectTools() {
        return this.fzz;
    }

    public void bL(List<Integer> list) {
        this.fzz.clear();
        this.fzz.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.fzl != null && this.fzl.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.fzl) {
                if (mVar.fzM > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.fyZ != null) {
                    mVar.fyZ.setToolId(mVar.id);
                    mVar.fyZ.setEditorTools(this);
                    if (mVar.fzT == 6) {
                        this.fzj.a(mVar.fyZ);
                    } else if (mVar.fzT == 1 || mVar.fzT == 2 || mVar.fzT == 3 || mVar.fzT == 4 || mVar.fzT == 5) {
                        this.fzi.a(mVar.fyZ, mVar.fzT, !mVar.fzU);
                        if (mVar.fzT == 5 && qP(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.fzV, mVar.id, mVar.fyZ);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.fzS - mVar3.fzS;
                }
            });
            if (linkedList.size() > this.fzp) {
                if (this.fzv) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.fzr > 0 && jVar.fyZ != null && (jVar.fyZ instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.fyZ).setBackgroundColorId(this.fzr);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_write_more_tool_point", false)) {
                    jVar.fzW = true;
                } else {
                    jVar.fzW = false;
                }
                b(jVar);
                jVar.fyZ.setToolId(jVar.id);
                jVar.fyZ.setEditorTools(this);
                a(jVar.fzV, jVar.id, jVar.fyZ);
                this.fzj.a(jVar.fyZ);
                if (this.fzq) {
                    linkedList.add(this.fzp, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.fzp + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.fzi.a(a(mVar2, 1));
                } else {
                    this.fzj.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a2 = a(fVar, 1);
                a2.hide();
                this.fzi.a(0, a2);
            }
            this.fzi.build();
            this.fzj.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.fzi.setLayoutParams(layoutParams);
            this.fzj.setLayoutParams(layoutParams2);
            this.fzj.hide();
            if (this.fzv) {
                this.fzi.setPadding(0, 0, 0, 0);
            }
            bzl();
            removeAllViews();
            if (this.fzi.getBarLauncherType() != 4) {
                bAZ();
            }
            addView(this.fzi);
            addView(this.fzj);
            invalidate();
        }
    }

    public void bO(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.ej(R.drawable.bg_tip_blue_down);
        eVar.ei(48);
        eVar.pz(true);
        eVar.wX(2);
        eVar.setUseDirectOffset(true);
        eVar.xb(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.wY(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.wZ(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.ek((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.C(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void bAZ() {
        if (this.fzk == null || this.fzk.getParent() != null) {
            this.fzk = new View(getContext());
            com.baidu.tbadk.core.elementsMaven.c.bv(this.fzk).od(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
            this.fzk.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.L_X01)));
        }
        addView(this.fzk);
    }

    private void bBa() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ao.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.fzx != null) {
                        EditorTools.this.fzx.onClick(view);
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
            if (this.fzi != null) {
                this.fzi.a(0, a2);
                this.fzi.removeAllViews();
                this.fzi.build();
            }
            invalidate();
        }
    }

    public m qP(int i) {
        for (m mVar : this.fzl) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.fzl;
    }

    public h qM(int i) {
        h qM = this.fzi.qM(i);
        if (qM == null) {
            return this.fzj.qM(i);
        }
        return qM;
    }

    public void bBb() {
        this.fzi.j(this.fzw);
    }

    private h a(m mVar, int i) {
        h a2 = g.a(getContext(), mVar, i);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.name);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.fzw);
        }
        return a2;
    }

    public void kM(boolean z) {
        for (m mVar : this.fzl) {
            if (mVar != null && (mVar.fyZ instanceof View) && ((View) mVar.fyZ).getVisibility() == 0 && !mVar.fzU) {
                mVar.fyZ.rV();
            }
        }
        if (this.fzs) {
            this.fzs = false;
            bzl();
        }
        if (!bAT() && z) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.fzy, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void rV() {
        kM(true);
    }

    public void hide() {
        bzl();
        setVisibility(8);
        bAY();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bzl() {
        this.fzj.hide();
        this.fzi.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.fzj.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.fzi.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.fzi.t(z, i)) {
            this.fzj.u(z, i);
        }
    }

    public boolean bAT() {
        return this.fzj.bAT();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.fzi.setBarLauncherType(i);
    }

    public void kK(boolean z) {
        this.fzi.kK(z);
    }

    public void kL(boolean z) {
        this.fzi.kL(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.fzq = z;
    }

    public void setBackgroundColorId(int i) {
        this.fll = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.fzr = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bP(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m qP = qP(toolId);
            if (qP.sj()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.fzi.a(qP);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_write_more_tool_point", true);
                    hVar.bAO();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    rV();
                    b(new a(1, 3, null));
                } else if (qP.fyZ == null) {
                    if (qP.fzV != null && qP.fzV.length > 0) {
                        b(new a(qP.fzV[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bBc() {
        this.fzi.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.fzx = onClickListener;
        bBa();
    }
}
