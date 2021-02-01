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
    private List<m> fBA;
    private SparseArray<b> fBB;
    private SparseArray<HashSet<b>> fBC;
    private SparseArray<HashSet<Integer>> fBD;
    private int fBE;
    private boolean fBF;
    private int fBG;
    private boolean fBH;
    private LinkedList<h> fBI;
    private boolean fBJ;
    private boolean fBK;
    private View.OnClickListener fBL;
    private View.OnClickListener fBM;
    private Runnable fBN;
    private List<Integer> fBO;
    public EditorBar fBx;
    public EditorDesk fBy;
    private View fBz;
    private int fnD;
    private View mMaskView;

    public void bBn() {
        m qU = qU(3);
        if (qU != null && (qU.fBo instanceof View)) {
            View view = (View) qU.fBo;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.fBE = 1;
        this.fBF = false;
        this.fnD = 0;
        this.fBG = 0;
        this.fBH = true;
        this.fBJ = false;
        this.fBK = false;
        this.fBL = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bL(view);
            }
        };
        this.fBN = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bBn();
            }
        };
        this.fBO = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.fBJ = z;
    }

    public boolean bBo() {
        return this.fBJ;
    }

    public boolean bBp() {
        return this.fBK;
    }

    public void setIsFromPb(boolean z) {
        this.fBK = z;
    }

    private void init(Context context) {
        this.context = context;
        this.fBA = new LinkedList();
        this.fBB = new SparseArray<>();
        this.fBC = new SparseArray<>();
        this.fBD = new SparseArray<>();
        this.fBx = new EditorBar(context, this);
        this.fBy = new EditorDesk(context, this);
        this.fBI = new LinkedList<>();
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
                HashSet<b> hashSet = this.fBC.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.fBC.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.fBB.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.fBD.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.fBD.put(i3, hashSet2);
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
        m qU;
        if (aVar != null) {
            if (aVar.code == 2) {
                h qR = this.fBx.qR(aVar.id);
                if (qR != null) {
                    z = false;
                } else {
                    qR = this.fBy.qR(aVar.id);
                    z = true;
                }
                if (qR == null) {
                    Iterator<h> it = this.fBI.iterator();
                    while (it.hasNext()) {
                        hVar = it.next();
                        if (hVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                hVar = qR;
                if (hVar != null) {
                    hVar.a(aVar);
                    if (z && (qU = qU(2)) != null && qU.fBo != null) {
                        qU.fBo.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.fBx.a((m) null);
                this.fBy.bBj();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.fBB.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.fBx.qP(aVar.id);
                        }
                        m qU2 = qU(aVar.id);
                        if (qU2 != null && qU2.fCi == 5) {
                            bzD();
                            bBq();
                        } else {
                            this.fBy.qP(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.fBD.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.fBB.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.fBC.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.fBy.qR(32);
                    if (dLauncher != null) {
                        bK(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void bBq() {
        boolean z;
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.fBN);
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
            m qU = qU(3);
            if (qU != null && (qU.fBo instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qU.fBo);
            }
            m qU2 = qU(28);
            if (qU2 != null && (qU2.fBo instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qU2.fBo);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.fBA.add(mVar);
        }
    }

    private void clear() {
        this.fBx.clear();
        this.fBy.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.fBE = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.fBx.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.fBy.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.fnD, i);
        this.fBx.onChangeSkinType(i);
        this.fBy.onChangeSkinType(i);
        if (this.fBz != null) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.fBz).og(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
        }
    }

    public List<Integer> getCollectTools() {
        return this.fBO;
    }

    public void bG(List<Integer> list) {
        this.fBO.clear();
        this.fBO.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.fBA != null && this.fBA.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.fBA) {
                if (mVar.fCb > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.fBo != null) {
                    mVar.fBo.setToolId(mVar.id);
                    mVar.fBo.setEditorTools(this);
                    if (mVar.fCi == 6) {
                        this.fBy.a(mVar.fBo);
                    } else if (mVar.fCi == 1 || mVar.fCi == 2 || mVar.fCi == 3 || mVar.fCi == 4 || mVar.fCi == 5) {
                        this.fBx.a(mVar.fBo, mVar.fCi, !mVar.fCj);
                        if (mVar.fCi == 5 && qU(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.fCk, mVar.id, mVar.fBo);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.fCh - mVar3.fCh;
                }
            });
            if (linkedList.size() > this.fBE) {
                if (this.fBK) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.fBG > 0 && jVar.fBo != null && (jVar.fBo instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.fBo).setBackgroundColorId(this.fBG);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_write_more_tool_point", false)) {
                    jVar.fCl = true;
                } else {
                    jVar.fCl = false;
                }
                b(jVar);
                jVar.fBo.setToolId(jVar.id);
                jVar.fBo.setEditorTools(this);
                a(jVar.fCk, jVar.id, jVar.fBo);
                this.fBy.a(jVar.fBo);
                if (this.fBF) {
                    linkedList.add(this.fBE, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.fBE + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.fBx.a(a(mVar2, 1));
                } else {
                    this.fBy.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a2 = a(fVar, 1);
                a2.hide();
                this.fBx.a(0, a2);
            }
            this.fBx.build();
            this.fBy.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.fBx.setLayoutParams(layoutParams);
            this.fBy.setLayoutParams(layoutParams2);
            this.fBy.hide();
            if (this.fBK) {
                this.fBx.setPadding(0, 0, 0, 0);
            }
            bzD();
            removeAllViews();
            if (this.fBx.getBarLauncherType() != 4) {
                bBr();
            }
            addView(this.fBx);
            addView(this.fBy);
            invalidate();
        }
    }

    public void bK(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.en(R.drawable.bg_tip_blue_down);
        eVar.em(48);
        eVar.pJ(true);
        eVar.xh(2);
        eVar.setUseDirectOffset(true);
        eVar.xl(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.xi(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.xj(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.eo((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.C(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void bBr() {
        if (this.fBz == null || this.fBz.getParent() != null) {
            this.fBz = new View(getContext());
            com.baidu.tbadk.core.elementsMaven.c.br(this.fBz).og(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
            this.fBz.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.L_X01)));
        }
        addView(this.fBz);
    }

    private void bBs() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ap.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.fBM != null) {
                        EditorTools.this.fBM.onClick(view);
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
            if (this.fBx != null) {
                this.fBx.a(0, a2);
                this.fBx.removeAllViews();
                this.fBx.build();
            }
            invalidate();
        }
    }

    public m qU(int i) {
        for (m mVar : this.fBA) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.fBA;
    }

    public h qR(int i) {
        h qR = this.fBx.qR(i);
        if (qR == null) {
            return this.fBy.qR(i);
        }
        return qR;
    }

    public void bBt() {
        this.fBx.j(this.fBL);
    }

    private h a(m mVar, int i) {
        h a2 = g.a(getContext(), mVar, i);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.name);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.fBL);
        }
        return a2;
    }

    public void kP(boolean z) {
        for (m mVar : this.fBA) {
            if (mVar != null && (mVar.fBo instanceof View) && ((View) mVar.fBo).getVisibility() == 0 && !mVar.fCj) {
                mVar.fBo.display();
            }
        }
        if (this.fBH) {
            this.fBH = false;
            bzD();
        }
        if (!bBl() && z) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.fBN, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        kP(true);
    }

    public void hide() {
        bzD();
        setVisibility(8);
        bBq();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bzD() {
        this.fBy.hide();
        this.fBx.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.fBy.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.fBx.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.fBx.t(z, i)) {
            this.fBy.u(z, i);
        }
    }

    public boolean bBl() {
        return this.fBy.bBl();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.fBx.setBarLauncherType(i);
    }

    public void kN(boolean z) {
        this.fBx.kN(z);
    }

    public void kO(boolean z) {
        this.fBx.kO(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.fBF = z;
    }

    public void setBackgroundColorId(int i) {
        this.fnD = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.fBG = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bL(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m qU = qU(toolId);
            if (qU.sg()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.fBx.a(qU);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_write_more_tool_point", true);
                    hVar.bBg();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (qU.fBo == null) {
                    if (qU.fCk != null && qU.fCk.length > 0) {
                        b(new a(qU.fCk[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bBu() {
        this.fBx.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.fBM = onClickListener;
        bBs();
    }
}
