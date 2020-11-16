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
    private int eYP;
    public EditorBar fmG;
    public EditorDesk fmH;
    private View fmI;
    private List<m> fmJ;
    private SparseArray<b> fmK;
    private SparseArray<HashSet<b>> fmL;
    private SparseArray<HashSet<Integer>> fmM;
    private int fmN;
    private boolean fmO;
    private int fmP;
    private boolean fmQ;
    private LinkedList<h> fmR;
    private boolean fmS;
    private boolean fmT;
    private View.OnClickListener fmU;
    private View.OnClickListener fmV;
    private Runnable fmW;
    private List<Integer> fmX;
    private View mMaskView;

    public void byT() {
        m rI = rI(3);
        if (rI != null && (rI.fmx instanceof View)) {
            View view = (View) rI.fmx;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.fmN = 1;
        this.fmO = false;
        this.eYP = 0;
        this.fmP = 0;
        this.fmQ = true;
        this.fmS = false;
        this.fmT = false;
        this.fmU = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bD(view);
            }
        };
        this.fmW = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.byT();
            }
        };
        this.fmX = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.fmS = z;
    }

    public boolean byU() {
        return this.fmS;
    }

    public boolean byV() {
        return this.fmT;
    }

    public void setIsFromPb(boolean z) {
        this.fmT = z;
    }

    private void init(Context context) {
        this.context = context;
        this.fmJ = new LinkedList();
        this.fmK = new SparseArray<>();
        this.fmL = new SparseArray<>();
        this.fmM = new SparseArray<>();
        this.fmG = new EditorBar(context, this);
        this.fmH = new EditorDesk(context, this);
        this.fmR = new LinkedList<>();
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
                HashSet<b> hashSet = this.fmL.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.fmL.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.fmK.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.fmM.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.fmM.put(i3, hashSet2);
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
        m rI;
        if (aVar != null) {
            if (aVar.code == 2) {
                h rF = this.fmG.rF(aVar.id);
                if (rF != null) {
                    z = false;
                } else {
                    rF = this.fmH.rF(aVar.id);
                    z = true;
                }
                if (rF == null) {
                    Iterator<h> it = this.fmR.iterator();
                    while (it.hasNext()) {
                        hVar = it.next();
                        if (hVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                hVar = rF;
                if (hVar != null) {
                    hVar.a(aVar);
                    if (z && (rI = rI(2)) != null && rI.fmx != null) {
                        rI.fmx.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.fmG.a((m) null);
                this.fmH.byP();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.fmK.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.fmG.rD(aVar.id);
                        }
                        m rI2 = rI(aVar.id);
                        if (rI2 != null && rI2.fnr == 5) {
                            bxk();
                            byW();
                        } else {
                            this.fmH.rD(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.fmM.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.fmK.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.fmL.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.fmH.rF(32);
                    if (dLauncher != null) {
                        bC(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void byW() {
        boolean z;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fmW);
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
            m rI = rI(3);
            if (rI != null && (rI.fmx instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) rI.fmx);
            }
            m rI2 = rI(28);
            if (rI2 != null && (rI2.fmx instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) rI2.fmx);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.fmJ.add(mVar);
        }
    }

    private void clear() {
        this.fmG.clear();
        this.fmH.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.fmN = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.fmG.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.fmH.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.eYP, i);
        this.fmG.onChangeSkinType(i);
        this.fmH.onChangeSkinType(i);
        if (this.fmI != null) {
            com.baidu.tbadk.core.elementsMaven.c.bj(this.fmI).pb(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
        }
    }

    public List<Integer> getCollectTools() {
        return this.fmX;
    }

    public void bA(List<Integer> list) {
        this.fmX.clear();
        this.fmX.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.fmJ != null && this.fmJ.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.fmJ) {
                if (mVar.fnk > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.fmx != null) {
                    mVar.fmx.setToolId(mVar.id);
                    mVar.fmx.setEditorTools(this);
                    if (mVar.fnr == 6) {
                        this.fmH.a(mVar.fmx);
                    } else if (mVar.fnr == 1 || mVar.fnr == 2 || mVar.fnr == 3 || mVar.fnr == 4 || mVar.fnr == 5) {
                        this.fmG.a(mVar.fmx, mVar.fnr, !mVar.fns);
                        if (mVar.fnr == 5 && rI(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.fnt, mVar.id, mVar.fmx);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.fnq - mVar3.fnq;
                }
            });
            if (linkedList.size() > this.fmN) {
                if (this.fmT) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.fmP > 0 && jVar.fmx != null && (jVar.fmx instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.fmx).setBackgroundColorId(this.fmP);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_write_more_tool_point", false)) {
                    jVar.fnu = true;
                } else {
                    jVar.fnu = false;
                }
                b(jVar);
                jVar.fmx.setToolId(jVar.id);
                jVar.fmx.setEditorTools(this);
                a(jVar.fnt, jVar.id, jVar.fmx);
                this.fmH.a(jVar.fmx);
                if (this.fmO) {
                    linkedList.add(this.fmN, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.fmN + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.fmG.a(a(mVar2, 1));
                } else {
                    this.fmH.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a2 = a(fVar, 1);
                a2.hide();
                this.fmG.a(0, a2);
            }
            this.fmG.build();
            this.fmH.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.fmG.setLayoutParams(layoutParams);
            this.fmH.setLayoutParams(layoutParams2);
            this.fmH.hide();
            if (this.fmT) {
                this.fmG.setPadding(0, 0, 0, 0);
            }
            bxk();
            removeAllViews();
            if (this.fmG.getBarLauncherType() != 4) {
                byX();
            }
            addView(this.fmG);
            addView(this.fmH);
            invalidate();
        }
    }

    public void bC(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.d.e eVar = new com.baidu.tieba.d.e(baseActivity.getPageContext(), view);
        eVar.fq(R.drawable.bg_tip_blue_down);
        eVar.fp(48);
        eVar.oJ(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.xO(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.xL(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.xM(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fr((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.z(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void byX() {
        if (this.fmI == null || this.fmI.getParent() != null) {
            this.fmI = new View(getContext());
            com.baidu.tbadk.core.elementsMaven.c.bj(this.fmI).pb(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
            this.fmI.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.L_X01)));
        }
        addView(this.fmI);
    }

    private void byY() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ap.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.fmV != null) {
                        EditorTools.this.fmV.onClick(view);
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
            if (this.fmG != null) {
                this.fmG.a(0, a2);
                this.fmG.removeAllViews();
                this.fmG.build();
            }
            invalidate();
        }
    }

    public m rI(int i) {
        for (m mVar : this.fmJ) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.fmJ;
    }

    public h rF(int i) {
        h rF = this.fmG.rF(i);
        if (rF == null) {
            return this.fmH.rF(i);
        }
        return rF;
    }

    public void byZ() {
        this.fmG.i(this.fmU);
    }

    private h a(m mVar, int i) {
        h a2 = g.a(getContext(), mVar, i);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.name);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.fmU);
        }
        return a2;
    }

    public void ke(boolean z) {
        for (m mVar : this.fmJ) {
            if (mVar != null && (mVar.fmx instanceof View) && ((View) mVar.fmx).getVisibility() == 0 && !mVar.fns) {
                mVar.fmx.display();
            }
        }
        if (this.fmQ) {
            this.fmQ = false;
            bxk();
        }
        if (!byR() && z) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.fmW, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        ke(true);
    }

    public void hide() {
        bxk();
        setVisibility(8);
        byW();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bxk() {
        this.fmH.hide();
        this.fmG.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.fmH.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.fmG.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.fmG.u(z, i)) {
            this.fmH.v(z, i);
        }
    }

    public boolean byR() {
        return this.fmH.byR();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.fmG.setBarLauncherType(i);
    }

    public void kc(boolean z) {
        this.fmG.kc(z);
    }

    public void kd(boolean z) {
        this.fmG.kd(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.fmO = z;
    }

    public void setBackgroundColorId(int i) {
        this.eYP = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.fmP = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bD(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m rI = rI(toolId);
            if (rI.sE()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.fmG.a(rI);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_write_more_tool_point", true);
                    hVar.byM();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (rI.fmx == null) {
                    if (rI.fnt != null && rI.fnt.length > 0) {
                        b(new a(rI.fnt[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bza() {
        this.fmG.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.fmV = onClickListener;
        byY();
    }
}
