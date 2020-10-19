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
    private int eLw;
    public EditorBar eZi;
    public EditorDesk eZj;
    private View eZk;
    private List<m> eZl;
    private SparseArray<b> eZm;
    private SparseArray<HashSet<b>> eZn;
    private SparseArray<HashSet<Integer>> eZo;
    private int eZp;
    private boolean eZq;
    private int eZr;
    private boolean eZs;
    private LinkedList<h> eZt;
    private boolean eZu;
    private boolean eZv;
    private View.OnClickListener eZw;
    private View.OnClickListener eZx;
    private Runnable eZy;
    private List<Integer> eZz;
    private View mMaskView;

    public void bvl() {
        m qP = qP(3);
        if (qP != null && (qP.eYZ instanceof View)) {
            View view = (View) qP.eYZ;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.eZp = 1;
        this.eZq = false;
        this.eLw = 0;
        this.eZr = 0;
        this.eZs = true;
        this.eZu = false;
        this.eZv = false;
        this.eZw = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bv(view);
            }
        };
        this.eZy = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bvl();
            }
        };
        this.eZz = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.eZu = z;
    }

    public boolean bvm() {
        return this.eZu;
    }

    public boolean bvn() {
        return this.eZv;
    }

    public void setIsFromPb(boolean z) {
        this.eZv = z;
    }

    private void init(Context context) {
        this.context = context;
        this.eZl = new LinkedList();
        this.eZm = new SparseArray<>();
        this.eZn = new SparseArray<>();
        this.eZo = new SparseArray<>();
        this.eZi = new EditorBar(context, this);
        this.eZj = new EditorDesk(context, this);
        this.eZt = new LinkedList<>();
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
                HashSet<b> hashSet = this.eZn.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.eZn.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.eZm.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.eZo.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.eZo.put(i3, hashSet2);
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
                h qM = this.eZi.qM(aVar.id);
                if (qM != null) {
                    z = false;
                } else {
                    qM = this.eZj.qM(aVar.id);
                    z = true;
                }
                if (qM == null) {
                    Iterator<h> it = this.eZt.iterator();
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
                    if (z && (qP = qP(2)) != null && qP.eYZ != null) {
                        qP.eYZ.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.eZi.a((m) null);
                this.eZj.bvh();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.eZm.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.eZi.qK(aVar.id);
                        }
                        m qP2 = qP(aVar.id);
                        if (qP2 != null && qP2.eZT == 5) {
                            btC();
                            bvo();
                        } else {
                            this.eZj.qK(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.eZo.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.eZm.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.eZn.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.eZj.qM(32);
                    if (dLauncher != null) {
                        bu(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void bvo() {
        boolean z;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.eZy);
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
            if (qP != null && (qP.eYZ instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qP.eYZ);
            }
            m qP2 = qP(28);
            if (qP2 != null && (qP2.eYZ instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qP2.eYZ);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.eZl.add(mVar);
        }
    }

    private void clear() {
        this.eZi.clear();
        this.eZj.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.eZp = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.eZi.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.eZj.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.eLw, i);
        this.eZi.onChangeSkinType(i);
        this.eZj.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.eZz;
    }

    public void bj(List<Integer> list) {
        this.eZz.clear();
        this.eZz.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.eZl != null && this.eZl.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.eZl) {
                if (mVar.eZM > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.eYZ != null) {
                    mVar.eYZ.setToolId(mVar.id);
                    mVar.eYZ.setEditorTools(this);
                    if (mVar.eZT == 6) {
                        this.eZj.a(mVar.eYZ);
                    } else if (mVar.eZT == 1 || mVar.eZT == 2 || mVar.eZT == 3 || mVar.eZT == 4 || mVar.eZT == 5) {
                        this.eZi.a(mVar.eYZ, mVar.eZT, !mVar.eZU);
                        if (mVar.eZT == 5 && qP(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.eZV, mVar.id, mVar.eYZ);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.eZS - mVar3.eZS;
                }
            });
            if (linkedList.size() > this.eZp) {
                if (this.eZv) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.eZr > 0 && jVar.eYZ != null && (jVar.eYZ instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.eYZ).setBackgroundColorId(this.eZr);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_write_more_tool_point", false)) {
                    jVar.eZW = true;
                } else {
                    jVar.eZW = false;
                }
                b(jVar);
                jVar.eYZ.setToolId(jVar.id);
                jVar.eYZ.setEditorTools(this);
                a(jVar.eZV, jVar.id, jVar.eYZ);
                this.eZj.a(jVar.eYZ);
                if (this.eZq) {
                    linkedList.add(this.eZp, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.eZp + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.eZi.a(a(mVar2, 1));
                } else {
                    this.eZj.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a2 = a(fVar, 1);
                a2.hide();
                this.eZi.a(0, a2);
            }
            this.eZi.build();
            this.eZj.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.eZi.setLayoutParams(layoutParams);
            this.eZj.setLayoutParams(layoutParams2);
            this.eZj.hide();
            if (this.eZv) {
                this.eZi.setPadding(0, 0, 0, 0);
            }
            btC();
            removeAllViews();
            if (this.eZi.getBarLauncherType() != 4) {
                bvp();
            }
            addView(this.eZi);
            addView(this.eZj);
            invalidate();
        }
    }

    public void bu(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.ff(R.drawable.bg_tip_blue_down);
        eVar.fe(48);
        eVar.of(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.wK(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.wH(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.wI(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fg((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.y(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void bvp() {
        if (this.eZk == null || this.eZk.getParent() != null) {
            this.eZk = new View(getContext());
            ap.setBackgroundResource(this.eZk, R.drawable.bottom_view_shadow);
            this.eZk.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.eZk);
    }

    private void bvq() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ap.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.eZx != null) {
                        EditorTools.this.eZx.onClick(view);
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
            if (this.eZi != null) {
                this.eZi.a(0, a2);
                this.eZi.removeAllViews();
                this.eZi.build();
            }
            invalidate();
        }
    }

    public m qP(int i) {
        for (m mVar : this.eZl) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.eZl;
    }

    public h qM(int i) {
        h qM = this.eZi.qM(i);
        if (qM == null) {
            return this.eZj.qM(i);
        }
        return qM;
    }

    public void bvr() {
        this.eZi.h(this.eZw);
    }

    private h a(m mVar, int i) {
        h a2 = g.a(getContext(), mVar, i);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.name);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.eZw);
        }
        return a2;
    }

    public void jH(boolean z) {
        for (m mVar : this.eZl) {
            if (mVar != null && (mVar.eYZ instanceof View) && ((View) mVar.eYZ).getVisibility() == 0 && !mVar.eZU) {
                mVar.eYZ.display();
            }
        }
        if (this.eZs) {
            this.eZs = false;
            btC();
        }
        if (!bvj() && z) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.eZy, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        jH(true);
    }

    public void hide() {
        btC();
        setVisibility(8);
        bvo();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void btC() {
        this.eZj.hide();
        this.eZi.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.eZj.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.eZi.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.eZi.u(z, i)) {
            this.eZj.v(z, i);
        }
    }

    public boolean bvj() {
        return this.eZj.bvj();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.eZi.setBarLauncherType(i);
    }

    public void jF(boolean z) {
        this.eZi.jF(z);
    }

    public void jG(boolean z) {
        this.eZi.jG(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.eZq = z;
    }

    public void setBackgroundColorId(int i) {
        this.eLw = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.eZr = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bv(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m qP = qP(toolId);
            if (qP.sE()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.eZi.a(qP);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_write_more_tool_point", true);
                    hVar.bve();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (qP.eYZ == null) {
                    if (qP.eZV != null && qP.eZV.length > 0) {
                        b(new a(qP.eZV[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bvs() {
        this.eZi.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.eZx = onClickListener;
        bvq();
    }
}
