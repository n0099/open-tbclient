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
    private int eZH;
    private View fnA;
    private List<m> fnB;
    private SparseArray<b> fnC;
    private SparseArray<HashSet<b>> fnD;
    private SparseArray<HashSet<Integer>> fnE;
    private int fnF;
    private boolean fnG;
    private int fnH;
    private boolean fnI;
    private LinkedList<h> fnJ;
    private boolean fnK;
    private boolean fnL;
    private View.OnClickListener fnM;
    private View.OnClickListener fnN;
    private Runnable fnO;
    private List<Integer> fnP;
    public EditorBar fny;
    public EditorDesk fnz;
    private View mMaskView;

    public void bzD() {
        m rk = rk(3);
        if (rk != null && (rk.fnp instanceof View)) {
            View view = (View) rk.fnp;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.fnF = 1;
        this.fnG = false;
        this.eZH = 0;
        this.fnH = 0;
        this.fnI = true;
        this.fnK = false;
        this.fnL = false;
        this.fnM = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bA(view);
            }
        };
        this.fnO = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bzD();
            }
        };
        this.fnP = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.fnK = z;
    }

    public boolean bzE() {
        return this.fnK;
    }

    public boolean bzF() {
        return this.fnL;
    }

    public void setIsFromPb(boolean z) {
        this.fnL = z;
    }

    private void init(Context context) {
        this.context = context;
        this.fnB = new LinkedList();
        this.fnC = new SparseArray<>();
        this.fnD = new SparseArray<>();
        this.fnE = new SparseArray<>();
        this.fny = new EditorBar(context, this);
        this.fnz = new EditorDesk(context, this);
        this.fnJ = new LinkedList<>();
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
                HashSet<b> hashSet = this.fnD.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.fnD.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.fnC.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.fnE.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.fnE.put(i3, hashSet2);
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
        m rk;
        if (aVar != null) {
            if (aVar.code == 2) {
                h rh = this.fny.rh(aVar.id);
                if (rh != null) {
                    z = false;
                } else {
                    rh = this.fnz.rh(aVar.id);
                    z = true;
                }
                if (rh == null) {
                    Iterator<h> it = this.fnJ.iterator();
                    while (it.hasNext()) {
                        hVar = it.next();
                        if (hVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                hVar = rh;
                if (hVar != null) {
                    hVar.a(aVar);
                    if (z && (rk = rk(2)) != null && rk.fnp != null) {
                        rk.fnp.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.fny.a((m) null);
                this.fnz.bzz();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.fnC.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.fny.rf(aVar.id);
                        }
                        m rk2 = rk(aVar.id);
                        if (rk2 != null && rk2.foj == 5) {
                            bxU();
                            bzG();
                        } else {
                            this.fnz.rf(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.fnE.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.fnC.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.fnD.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.fnz.rh(32);
                    if (dLauncher != null) {
                        bz(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void bzG() {
        boolean z;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fnO);
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
            m rk = rk(3);
            if (rk != null && (rk.fnp instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) rk.fnp);
            }
            m rk2 = rk(28);
            if (rk2 != null && (rk2.fnp instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) rk2.fnp);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.fnB.add(mVar);
        }
    }

    private void clear() {
        this.fny.clear();
        this.fnz.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.fnF = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.fny.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.fnz.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.eZH, i);
        this.fny.onChangeSkinType(i);
        this.fnz.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.fnP;
    }

    public void bA(List<Integer> list) {
        this.fnP.clear();
        this.fnP.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.fnB != null && this.fnB.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.fnB) {
                if (mVar.foc > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.fnp != null) {
                    mVar.fnp.setToolId(mVar.id);
                    mVar.fnp.setEditorTools(this);
                    if (mVar.foj == 6) {
                        this.fnz.a(mVar.fnp);
                    } else if (mVar.foj == 1 || mVar.foj == 2 || mVar.foj == 3 || mVar.foj == 4 || mVar.foj == 5) {
                        this.fny.a(mVar.fnp, mVar.foj, !mVar.fok);
                        if (mVar.foj == 5 && rk(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.fol, mVar.id, mVar.fnp);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.foi - mVar3.foi;
                }
            });
            if (linkedList.size() > this.fnF) {
                if (this.fnL) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.fnH > 0 && jVar.fnp != null && (jVar.fnp instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.fnp).setBackgroundColorId(this.fnH);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_write_more_tool_point", false)) {
                    jVar.fom = true;
                } else {
                    jVar.fom = false;
                }
                b(jVar);
                jVar.fnp.setToolId(jVar.id);
                jVar.fnp.setEditorTools(this);
                a(jVar.fol, jVar.id, jVar.fnp);
                this.fnz.a(jVar.fnp);
                if (this.fnG) {
                    linkedList.add(this.fnF, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.fnF + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.fny.a(a(mVar2, 1));
                } else {
                    this.fnz.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a2 = a(fVar, 1);
                a2.hide();
                this.fny.a(0, a2);
            }
            this.fny.build();
            this.fnz.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.fny.setLayoutParams(layoutParams);
            this.fnz.setLayoutParams(layoutParams2);
            this.fnz.hide();
            if (this.fnL) {
                this.fny.setPadding(0, 0, 0, 0);
            }
            bxU();
            removeAllViews();
            if (this.fny.getBarLauncherType() != 4) {
                bzH();
            }
            addView(this.fny);
            addView(this.fnz);
            invalidate();
        }
    }

    public void bz(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.fu(R.drawable.bg_tip_blue_down);
        eVar.ft(48);
        eVar.oG(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.xq(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.xn(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.xo(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fv((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.z(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void bzH() {
        if (this.fnA == null || this.fnA.getParent() != null) {
            this.fnA = new View(getContext());
            ap.setBackgroundResource(this.fnA, R.drawable.bottom_view_shadow);
            this.fnA.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.fnA);
    }

    private void bzI() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ap.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.fnN != null) {
                        EditorTools.this.fnN.onClick(view);
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
            if (this.fny != null) {
                this.fny.a(0, a2);
                this.fny.removeAllViews();
                this.fny.build();
            }
            invalidate();
        }
    }

    public m rk(int i) {
        for (m mVar : this.fnB) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.fnB;
    }

    public h rh(int i) {
        h rh = this.fny.rh(i);
        if (rh == null) {
            return this.fnz.rh(i);
        }
        return rh;
    }

    public void bzJ() {
        this.fny.i(this.fnM);
    }

    private h a(m mVar, int i) {
        h a2 = g.a(getContext(), mVar, i);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.name);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.fnM);
        }
        return a2;
    }

    public void kd(boolean z) {
        for (m mVar : this.fnB) {
            if (mVar != null && (mVar.fnp instanceof View) && ((View) mVar.fnp).getVisibility() == 0 && !mVar.fok) {
                mVar.fnp.display();
            }
        }
        if (this.fnI) {
            this.fnI = false;
            bxU();
        }
        if (!bzB() && z) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.fnO, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        kd(true);
    }

    public void hide() {
        bxU();
        setVisibility(8);
        bzG();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bxU() {
        this.fnz.hide();
        this.fny.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.fnz.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.fny.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.fny.u(z, i)) {
            this.fnz.v(z, i);
        }
    }

    public boolean bzB() {
        return this.fnz.bzB();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.fny.setBarLauncherType(i);
    }

    public void kb(boolean z) {
        this.fny.kb(z);
    }

    public void kc(boolean z) {
        this.fny.kc(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.fnG = z;
    }

    public void setBackgroundColorId(int i) {
        this.eZH = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.fnH = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bA(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m rk = rk(toolId);
            if (rk.sE()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.fny.a(rk);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_write_more_tool_point", true);
                    hVar.bzw();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (rk.fnp == null) {
                    if (rk.fol != null && rk.fol.length > 0) {
                        b(new a(rk.fol[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bzK() {
        this.fny.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.fnN = onClickListener;
        bzI();
    }
}
