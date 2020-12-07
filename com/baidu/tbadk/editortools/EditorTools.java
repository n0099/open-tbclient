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
    private int fgm;
    private Runnable fuA;
    private List<Integer> fuB;
    public EditorBar fuk;
    public EditorDesk ful;
    private View fum;
    private List<m> fun;
    private SparseArray<b> fuo;
    private SparseArray<HashSet<b>> fup;
    private SparseArray<HashSet<Integer>> fuq;
    private int fur;
    private boolean fus;
    private int fut;
    private boolean fuu;
    private LinkedList<h> fuv;
    private boolean fuw;
    private boolean fux;
    private View.OnClickListener fuy;
    private View.OnClickListener fuz;
    private View mMaskView;

    public void bCt() {
        m sj = sj(3);
        if (sj != null && (sj.fub instanceof View)) {
            View view = (View) sj.fub;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.fur = 1;
        this.fus = false;
        this.fgm = 0;
        this.fut = 0;
        this.fuu = true;
        this.fuw = false;
        this.fux = false;
        this.fuy = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bG(view);
            }
        };
        this.fuA = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bCt();
            }
        };
        this.fuB = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.fuw = z;
    }

    public boolean bCu() {
        return this.fuw;
    }

    public boolean bCv() {
        return this.fux;
    }

    public void setIsFromPb(boolean z) {
        this.fux = z;
    }

    private void init(Context context) {
        this.context = context;
        this.fun = new LinkedList();
        this.fuo = new SparseArray<>();
        this.fup = new SparseArray<>();
        this.fuq = new SparseArray<>();
        this.fuk = new EditorBar(context, this);
        this.ful = new EditorDesk(context, this);
        this.fuv = new LinkedList<>();
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
                HashSet<b> hashSet = this.fup.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.fup.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.fuo.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.fuq.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.fuq.put(i3, hashSet2);
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
        m sj;
        if (aVar != null) {
            if (aVar.code == 2) {
                h sg = this.fuk.sg(aVar.id);
                if (sg != null) {
                    z = false;
                } else {
                    sg = this.ful.sg(aVar.id);
                    z = true;
                }
                if (sg == null) {
                    Iterator<h> it = this.fuv.iterator();
                    while (it.hasNext()) {
                        hVar = it.next();
                        if (hVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                hVar = sg;
                if (hVar != null) {
                    hVar.a(aVar);
                    if (z && (sj = sj(2)) != null && sj.fub != null) {
                        sj.fub.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.fuk.a((m) null);
                this.ful.bCp();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.fuo.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.fuk.se(aVar.id);
                        }
                        m sj2 = sj(aVar.id);
                        if (sj2 != null && sj2.fuV == 5) {
                            bAK();
                            bCw();
                        } else {
                            this.ful.se(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.fuq.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.fuo.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.fup.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.ful.sg(32);
                    if (dLauncher != null) {
                        bF(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void bCw() {
        boolean z;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fuA);
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
            m sj = sj(3);
            if (sj != null && (sj.fub instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) sj.fub);
            }
            m sj2 = sj(28);
            if (sj2 != null && (sj2.fub instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) sj2.fub);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.fun.add(mVar);
        }
    }

    private void clear() {
        this.fuk.clear();
        this.ful.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.fur = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.fuk.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.ful.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.fgm, i);
        this.fuk.onChangeSkinType(i);
        this.ful.onChangeSkinType(i);
        if (this.fum != null) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.fum).pA(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
        }
    }

    public List<Integer> getCollectTools() {
        return this.fuB;
    }

    public void bE(List<Integer> list) {
        this.fuB.clear();
        this.fuB.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.fun != null && this.fun.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.fun) {
                if (mVar.fuO > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.fub != null) {
                    mVar.fub.setToolId(mVar.id);
                    mVar.fub.setEditorTools(this);
                    if (mVar.fuV == 6) {
                        this.ful.a(mVar.fub);
                    } else if (mVar.fuV == 1 || mVar.fuV == 2 || mVar.fuV == 3 || mVar.fuV == 4 || mVar.fuV == 5) {
                        this.fuk.a(mVar.fub, mVar.fuV, !mVar.fuW);
                        if (mVar.fuV == 5 && sj(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.fuX, mVar.id, mVar.fub);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.fuU - mVar3.fuU;
                }
            });
            if (linkedList.size() > this.fur) {
                if (this.fux) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.fut > 0 && jVar.fub != null && (jVar.fub instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.fub).setBackgroundColorId(this.fut);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_write_more_tool_point", false)) {
                    jVar.fuY = true;
                } else {
                    jVar.fuY = false;
                }
                b(jVar);
                jVar.fub.setToolId(jVar.id);
                jVar.fub.setEditorTools(this);
                a(jVar.fuX, jVar.id, jVar.fub);
                this.ful.a(jVar.fub);
                if (this.fus) {
                    linkedList.add(this.fur, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.fur + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.fuk.a(a(mVar2, 1));
                } else {
                    this.ful.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a2 = a(fVar, 1);
                a2.hide();
                this.fuk.a(0, a2);
            }
            this.fuk.build();
            this.ful.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.fuk.setLayoutParams(layoutParams);
            this.ful.setLayoutParams(layoutParams2);
            this.ful.hide();
            if (this.fux) {
                this.fuk.setPadding(0, 0, 0, 0);
            }
            bAK();
            removeAllViews();
            if (this.fuk.getBarLauncherType() != 4) {
                bCx();
            }
            addView(this.fuk);
            addView(this.ful);
            invalidate();
        }
    }

    public void bF(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.d.e eVar = new com.baidu.tieba.d.e(baseActivity.getPageContext(), view);
        eVar.fO(R.drawable.bg_tip_blue_down);
        eVar.fN(48);
        eVar.pf(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.yt(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.yq(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.yr(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fP((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.A(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void bCx() {
        if (this.fum == null || this.fum.getParent() != null) {
            this.fum = new View(getContext());
            com.baidu.tbadk.core.elementsMaven.c.bm(this.fum).pA(R.string.J_X02).setBackGroundColor(R.color.CAM_X0210);
            this.fum.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.L_X01)));
        }
        addView(this.fum);
    }

    private void bCy() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ap.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.fuz != null) {
                        EditorTools.this.fuz.onClick(view);
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
            if (this.fuk != null) {
                this.fuk.a(0, a2);
                this.fuk.removeAllViews();
                this.fuk.build();
            }
            invalidate();
        }
    }

    public m sj(int i) {
        for (m mVar : this.fun) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.fun;
    }

    public h sg(int i) {
        h sg = this.fuk.sg(i);
        if (sg == null) {
            return this.ful.sg(i);
        }
        return sg;
    }

    public void bCz() {
        this.fuk.i(this.fuy);
    }

    private h a(m mVar, int i) {
        h a2 = g.a(getContext(), mVar, i);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.name);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.fuy);
        }
        return a2;
    }

    public void ku(boolean z) {
        for (m mVar : this.fun) {
            if (mVar != null && (mVar.fub instanceof View) && ((View) mVar.fub).getVisibility() == 0 && !mVar.fuW) {
                mVar.fub.su();
            }
        }
        if (this.fuu) {
            this.fuu = false;
            bAK();
        }
        if (!bCr() && z) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.fuA, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void su() {
        ku(true);
    }

    public void hide() {
        bAK();
        setVisibility(8);
        bCw();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bAK() {
        this.ful.hide();
        this.fuk.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.ful.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.fuk.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.fuk.u(z, i)) {
            this.ful.v(z, i);
        }
    }

    public boolean bCr() {
        return this.ful.bCr();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.fuk.setBarLauncherType(i);
    }

    public void ks(boolean z) {
        this.fuk.ks(z);
    }

    public void kt(boolean z) {
        this.fuk.kt(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.fus = z;
    }

    public void setBackgroundColorId(int i) {
        this.fgm = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.fut = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bG(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m sj = sj(toolId);
            if (sj.sH()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.fuk.a(sj);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_write_more_tool_point", true);
                    hVar.bCm();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    su();
                    b(new a(1, 3, null));
                } else if (sj.fub == null) {
                    if (sj.fuX != null && sj.fuX.length > 0) {
                        b(new a(sj.fuX[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bCA() {
        this.fuk.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.fuz = onClickListener;
        bCy();
    }
}
