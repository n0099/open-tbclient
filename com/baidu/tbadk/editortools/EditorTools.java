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
    public EditorBar eNb;
    public EditorDesk eNc;
    private View eNd;
    private List<m> eNe;
    private SparseArray<b> eNf;
    private SparseArray<HashSet<b>> eNg;
    private SparseArray<HashSet<Integer>> eNh;
    private int eNi;
    private boolean eNj;
    private int eNk;
    private boolean eNl;
    private LinkedList<h> eNm;
    private boolean eNn;
    private boolean eNo;
    private View.OnClickListener eNp;
    private View.OnClickListener eNq;
    private Runnable eNr;
    private List<Integer> eNs;
    private int ezp;
    private View mMaskView;

    public void bsB() {
        m qr = qr(3);
        if (qr != null && (qr.eMS instanceof View)) {
            View view = (View) qr.eMS;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.eNi = 1;
        this.eNj = false;
        this.ezp = 0;
        this.eNk = 0;
        this.eNl = true;
        this.eNn = false;
        this.eNo = false;
        this.eNp = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.br(view);
            }
        };
        this.eNr = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bsB();
            }
        };
        this.eNs = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.eNn = z;
    }

    public boolean bsC() {
        return this.eNn;
    }

    public boolean bsD() {
        return this.eNo;
    }

    public void setIsFromPb(boolean z) {
        this.eNo = z;
    }

    private void init(Context context) {
        this.context = context;
        this.eNe = new LinkedList();
        this.eNf = new SparseArray<>();
        this.eNg = new SparseArray<>();
        this.eNh = new SparseArray<>();
        this.eNb = new EditorBar(context, this);
        this.eNc = new EditorDesk(context, this);
        this.eNm = new LinkedList<>();
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
                HashSet<b> hashSet = this.eNg.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.eNg.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.eNf.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.eNh.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.eNh.put(i3, hashSet2);
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
        m qr;
        if (aVar != null) {
            if (aVar.code == 2) {
                h qo = this.eNb.qo(aVar.id);
                if (qo != null) {
                    z = false;
                } else {
                    qo = this.eNc.qo(aVar.id);
                    z = true;
                }
                if (qo == null) {
                    Iterator<h> it = this.eNm.iterator();
                    while (it.hasNext()) {
                        hVar = it.next();
                        if (hVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                hVar = qo;
                if (hVar != null) {
                    hVar.a(aVar);
                    if (z && (qr = qr(2)) != null && qr.eMS != null) {
                        qr.eMS.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.eNb.a((m) null);
                this.eNc.bsx();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.eNf.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.eNb.qm(aVar.id);
                        }
                        m qr2 = qr(aVar.id);
                        if (qr2 != null && qr2.eNM == 5) {
                            bqS();
                            bsE();
                        } else {
                            this.eNc.qm(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.eNh.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.eNf.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.eNg.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.eNc.qo(32);
                    if (dLauncher != null) {
                        bq(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void bsE() {
        boolean z;
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.eNr);
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
            m qr = qr(3);
            if (qr != null && (qr.eMS instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qr.eMS);
            }
            m qr2 = qr(28);
            if (qr2 != null && (qr2.eMS instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) qr2.eMS);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.eNe.add(mVar);
        }
    }

    private void clear() {
        this.eNb.clear();
        this.eNc.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.eNi = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.eNb.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.eNc.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.ezp, i);
        this.eNb.onChangeSkinType(i);
        this.eNc.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.eNs;
    }

    public void bg(List<Integer> list) {
        this.eNs.clear();
        this.eNs.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.eNe != null && this.eNe.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.eNe) {
                if (mVar.eNF > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.eMS != null) {
                    mVar.eMS.setToolId(mVar.id);
                    mVar.eMS.setEditorTools(this);
                    if (mVar.eNM == 6) {
                        this.eNc.a(mVar.eMS);
                    } else if (mVar.eNM == 1 || mVar.eNM == 2 || mVar.eNM == 3 || mVar.eNM == 4 || mVar.eNM == 5) {
                        this.eNb.a(mVar.eMS, mVar.eNM, !mVar.eNN);
                        if (mVar.eNM == 5 && qr(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.eNO, mVar.id, mVar.eMS);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.eNL - mVar3.eNL;
                }
            });
            if (linkedList.size() > this.eNi) {
                if (this.eNo) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.eNk > 0 && jVar.eMS != null && (jVar.eMS instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.eMS).setBackgroundColorId(this.eNk);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_write_more_tool_point", false)) {
                    jVar.eNP = true;
                } else {
                    jVar.eNP = false;
                }
                b(jVar);
                jVar.eMS.setToolId(jVar.id);
                jVar.eMS.setEditorTools(this);
                a(jVar.eNO, jVar.id, jVar.eMS);
                this.eNc.a(jVar.eMS);
                if (this.eNj) {
                    linkedList.add(this.eNi, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.eNi + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.eNb.a(a(mVar2, 1));
                } else {
                    this.eNc.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a = a(fVar, 1);
                a.hide();
                this.eNb.a(0, a);
            }
            this.eNb.build();
            this.eNc.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.eNb.setLayoutParams(layoutParams);
            this.eNc.setLayoutParams(layoutParams2);
            this.eNc.hide();
            if (this.eNo) {
                this.eNb.setPadding(0, 0, 0, 0);
            }
            bqS();
            removeAllViews();
            if (this.eNb.getBarLauncherType() != 4) {
                bsF();
            }
            addView(this.eNb);
            addView(this.eNc);
            invalidate();
        }
    }

    public void bq(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.eW(R.drawable.bg_tip_blue_down);
        eVar.eV(48);
        eVar.nA(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.we(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.wb(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.wc(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.eX((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.y(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void bsF() {
        if (this.eNd == null || this.eNd.getParent() != null) {
            this.eNd = new View(getContext());
            ap.setBackgroundResource(this.eNd, R.drawable.bottom_view_shadow);
            this.eNd.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.eNd);
    }

    private void bsG() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ap.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.eNq != null) {
                        EditorTools.this.eNq.onClick(view);
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
            if (this.eNb != null) {
                this.eNb.a(0, a);
                this.eNb.removeAllViews();
                this.eNb.build();
            }
            invalidate();
        }
    }

    public m qr(int i) {
        for (m mVar : this.eNe) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.eNe;
    }

    public h qo(int i) {
        h qo = this.eNb.qo(i);
        if (qo == null) {
            return this.eNc.qo(i);
        }
        return qo;
    }

    public void bsH() {
        this.eNb.h(this.eNp);
    }

    private h a(m mVar, int i) {
        h a = g.a(getContext(), mVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(mVar.name);
        }
        if (a instanceof BLauncher) {
            ((View) a).setOnClickListener(this.eNp);
        }
        return a;
    }

    public void jj(boolean z) {
        for (m mVar : this.eNe) {
            if (mVar != null && (mVar.eMS instanceof View) && ((View) mVar.eMS).getVisibility() == 0 && !mVar.eNN) {
                mVar.eMS.display();
            }
        }
        if (this.eNl) {
            this.eNl = false;
            bqS();
        }
        if (!bsz() && z) {
            com.baidu.adp.lib.f.e.mX().postDelayed(this.eNr, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        jj(true);
    }

    public void hide() {
        bqS();
        setVisibility(8);
        bsE();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bqS() {
        this.eNc.hide();
        this.eNb.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.eNc.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.eNb.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.eNb.t(z, i)) {
            this.eNc.u(z, i);
        }
    }

    public boolean bsz() {
        return this.eNc.bsz();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.eNb.setBarLauncherType(i);
    }

    public void jh(boolean z) {
        this.eNb.jh(z);
    }

    public void ji(boolean z) {
        this.eNb.ji(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.eNj = z;
    }

    public void setBackgroundColorId(int i) {
        this.ezp = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.eNk = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void br(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m qr = qr(toolId);
            if (qr.sE()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.eNb.a(qr);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_write_more_tool_point", true);
                    hVar.bsu();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (qr.eMS == null) {
                    if (qr.eNO != null && qr.eNO.length > 0) {
                        b(new a(qr.eNO[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bsI() {
        this.eNb.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.eNq = onClickListener;
        bsG();
    }
}
