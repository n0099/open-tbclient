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
    private int eTS;
    public EditorBar fhE;
    public EditorDesk fhF;
    private View fhG;
    private List<m> fhH;
    private SparseArray<b> fhI;
    private SparseArray<HashSet<b>> fhJ;
    private SparseArray<HashSet<Integer>> fhK;
    private int fhL;
    private boolean fhM;
    private int fhN;
    private boolean fhO;
    private LinkedList<h> fhP;
    private boolean fhQ;
    private boolean fhR;
    private View.OnClickListener fhS;
    private View.OnClickListener fhT;
    private Runnable fhU;
    private List<Integer> fhV;
    private View mMaskView;

    public void bxe() {
        m ra = ra(3);
        if (ra != null && (ra.fhv instanceof View)) {
            View view = (View) ra.fhv;
            view.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), view);
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.fhL = 1;
        this.fhM = false;
        this.eTS = 0;
        this.fhN = 0;
        this.fhO = true;
        this.fhQ = false;
        this.fhR = false;
        this.fhS = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorTools.this.bw(view);
            }
        };
        this.fhU = new Runnable() { // from class: com.baidu.tbadk.editortools.EditorTools.2
            @Override // java.lang.Runnable
            public void run() {
                EditorTools.this.bxe();
            }
        };
        this.fhV = new ArrayList();
        init(context);
    }

    public void setIsIM(boolean z) {
        this.fhQ = z;
    }

    public boolean bxf() {
        return this.fhQ;
    }

    public boolean bxg() {
        return this.fhR;
    }

    public void setIsFromPb(boolean z) {
        this.fhR = z;
    }

    private void init(Context context) {
        this.context = context;
        this.fhH = new LinkedList();
        this.fhI = new SparseArray<>();
        this.fhJ = new SparseArray<>();
        this.fhK = new SparseArray<>();
        this.fhE = new EditorBar(context, this);
        this.fhF = new EditorDesk(context, this);
        this.fhP = new LinkedList<>();
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
                HashSet<b> hashSet = this.fhJ.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.fhJ.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.fhI.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.fhK.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.fhK.put(i3, hashSet2);
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
        m ra;
        if (aVar != null) {
            if (aVar.code == 2) {
                h qX = this.fhE.qX(aVar.id);
                if (qX != null) {
                    z = false;
                } else {
                    qX = this.fhF.qX(aVar.id);
                    z = true;
                }
                if (qX == null) {
                    Iterator<h> it = this.fhP.iterator();
                    while (it.hasNext()) {
                        hVar = it.next();
                        if (hVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                hVar = qX;
                if (hVar != null) {
                    hVar.a(aVar);
                    if (z && (ra = ra(2)) != null && ra.fhv != null) {
                        ra.fhv.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.fhE.a((m) null);
                this.fhF.bxa();
            } else {
                if (aVar.id > 0) {
                    b bVar = this.fhI.get(aVar.id);
                    if (bVar != null) {
                        if (aVar.code != 19 && aVar.code != 20 && aVar.id != 27) {
                            this.fhE.qV(aVar.id);
                        }
                        m ra2 = ra(aVar.id);
                        if (ra2 != null && ra2.fir == 5) {
                            bvv();
                            bxh();
                        } else {
                            this.fhF.qV(aVar.id);
                        }
                        bVar.a(aVar);
                    }
                } else if (aVar.id <= 0) {
                    if (aVar.id < 0 && (hashSet = this.fhK.get(aVar.code)) != null && !hashSet.isEmpty()) {
                        Iterator<Integer> it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            b bVar2 = this.fhI.get(it2.next().intValue());
                            if (bVar2 != null) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                    HashSet<b> hashSet2 = this.fhJ.get(aVar.code);
                    if (hashSet2 != null && !hashSet2.isEmpty()) {
                        Iterator<b> it3 = hashSet2.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(aVar);
                        }
                    }
                }
                if (this.context.getClass().getSimpleName().equals("WriteActivity") && aVar.id == 2) {
                    DLauncher dLauncher = (DLauncher) this.fhF.qX(32);
                    if (dLauncher != null) {
                        bv(dLauncher);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
                }
            }
        }
    }

    public void bxh() {
        boolean z;
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fhU);
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
            m ra = ra(3);
            if (ra != null && (ra.fhv instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) ra.fhv);
            }
            m ra2 = ra(28);
            if (ra2 != null && (ra2.fhv instanceof View)) {
                com.baidu.adp.lib.util.l.hideSoftKeyPad(getContext(), (View) ra2.fhv);
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.fhH.add(mVar);
        }
    }

    private void clear() {
        this.fhE.clear();
        this.fhF.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.fhL = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.fhE.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.fhF.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, this.eTS, i);
        this.fhE.onChangeSkinType(i);
        this.fhF.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.fhV;
    }

    public void bt(List<Integer> list) {
        this.fhV.clear();
        this.fhV.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void build() {
        j jVar;
        if (this.fhH != null && this.fhH.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (m mVar : this.fhH) {
                if (mVar.fij > 0) {
                    linkedList.add(mVar);
                }
                if (mVar.fhv != null) {
                    mVar.fhv.setToolId(mVar.id);
                    mVar.fhv.setEditorTools(this);
                    if (mVar.fir == 6) {
                        this.fhF.a(mVar.fhv);
                    } else if (mVar.fir == 1 || mVar.fir == 2 || mVar.fir == 3 || mVar.fir == 4 || mVar.fir == 5) {
                        this.fhE.a(mVar.fhv, mVar.fir, !mVar.fis);
                        if (mVar.fir == 5 && ra(1) == null) {
                            z = true;
                        }
                    }
                    a(mVar.fit, mVar.id, mVar.fhv);
                }
                z = z;
            }
            Collections.sort(linkedList, new Comparator<m>() { // from class: com.baidu.tbadk.editortools.EditorTools.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(m mVar2, m mVar3) {
                    return mVar2.fiq - mVar3.fiq;
                }
            });
            if (linkedList.size() > this.fhL) {
                if (this.fhR) {
                    jVar = new j(getContext(), true);
                } else {
                    jVar = new j(getContext());
                }
                if (this.fhN > 0 && jVar.fhv != null && (jVar.fhv instanceof CommonTabHost)) {
                    ((CommonTabHost) jVar.fhv).setBackgroundColorId(this.fhN);
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_write_more_tool_point", false)) {
                    jVar.fiu = true;
                } else {
                    jVar.fiu = false;
                }
                b(jVar);
                jVar.fhv.setToolId(jVar.id);
                jVar.fhv.setEditorTools(this);
                a(jVar.fit, jVar.id, jVar.fhv);
                this.fhF.a(jVar.fhv);
                if (this.fhM) {
                    linkedList.add(this.fhL, jVar);
                } else {
                    linkedList.add(0, jVar);
                }
            }
            int i = this.fhL + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m mVar2 = (m) it.next();
                if (i2 < i) {
                    this.fhE.a(a(mVar2, 1));
                } else {
                    this.fhF.a(a(mVar2, 2));
                }
                i2++;
            }
            if (z) {
                f fVar = new f();
                b(fVar);
                h a2 = a(fVar, 1);
                a2.hide();
                this.fhE.a(0, a2);
            }
            this.fhE.build();
            this.fhF.build();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.fhE.setLayoutParams(layoutParams);
            this.fhF.setLayoutParams(layoutParams2);
            this.fhF.hide();
            if (this.fhR) {
                this.fhE.setPadding(0, 0, 0, 0);
            }
            bvv();
            removeAllViews();
            if (this.fhE.getBarLauncherType() != 4) {
                bxi();
            }
            addView(this.fhE);
            addView(this.fhF);
            invalidate();
        }
    }

    public void bv(View view) {
        BaseActivity baseActivity = (BaseActivity) this.context;
        com.baidu.tieba.c.e eVar = new com.baidu.tieba.c.e(baseActivity.getPageContext(), view);
        eVar.fh(R.drawable.bg_tip_blue_down);
        eVar.fg(48);
        eVar.ox(true);
        eVar.setAnchor(2);
        eVar.setUseDirectOffset(true);
        eVar.xd(com.baidu.adp.lib.util.l.getDimens(baseActivity, R.dimen.ds32));
        eVar.xa(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.xb(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.fi((int) IMConnection.RETRY_DELAY_TIMES);
        eVar.y(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    private void bxi() {
        if (this.fhG == null || this.fhG.getParent() != null) {
            this.fhG = new View(getContext());
            ap.setBackgroundResource(this.fhG, R.drawable.bottom_view_shadow);
            this.fhG.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16)));
        }
        addView(this.fhG);
    }

    private void bxj() {
        if (this.mMaskView == null || this.mMaskView.getParent() != null) {
            this.mMaskView = new View(getContext());
            ap.setBackgroundResource(this.mMaskView, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mMaskView.setLayoutParams(layoutParams);
            this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.EditorTools.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (EditorTools.this.fhT != null) {
                        EditorTools.this.fhT.onClick(view);
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
            if (this.fhE != null) {
                this.fhE.a(0, a2);
                this.fhE.removeAllViews();
                this.fhE.build();
            }
            invalidate();
        }
    }

    public m ra(int i) {
        for (m mVar : this.fhH) {
            if (mVar.id == i) {
                return mVar;
            }
        }
        return null;
    }

    public List<m> getAllTools() {
        return this.fhH;
    }

    public h qX(int i) {
        h qX = this.fhE.qX(i);
        if (qX == null) {
            return this.fhF.qX(i);
        }
        return qX;
    }

    public void bxk() {
        this.fhE.h(this.fhS);
    }

    private h a(m mVar, int i) {
        h a2 = g.a(getContext(), mVar, i);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.name);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.fhS);
        }
        return a2;
    }

    public void jU(boolean z) {
        for (m mVar : this.fhH) {
            if (mVar != null && (mVar.fhv instanceof View) && ((View) mVar.fhv).getVisibility() == 0 && !mVar.fis) {
                mVar.fhv.display();
            }
        }
        if (this.fhO) {
            this.fhO = false;
            bvv();
        }
        if (!bxc() && z) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.fhU, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, true));
    }

    public void display() {
        jU(true);
    }

    public void hide() {
        bvv();
        setVisibility(8);
        bxh();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED, false));
    }

    public void bvv() {
        this.fhF.hide();
        this.fhE.a((m) null);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.fhF.setDeskLauncherEnabled(z);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.fhE.setBarLauncherEnabled(z);
    }

    public void setToolEnabled(boolean z, int i) {
        if (!this.fhE.u(z, i)) {
            this.fhF.v(z, i);
        }
    }

    public boolean bxc() {
        return this.fhF.bxc();
    }

    public void setFrom(int i) {
    }

    public void setBarLauncherType(int i) {
        this.fhE.setBarLauncherType(i);
    }

    public void jS(boolean z) {
        this.fhE.jS(z);
    }

    public void jT(boolean z) {
        this.fhE.jT(z);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.fhM = z;
    }

    public void setBackgroundColorId(int i) {
        this.eTS = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.fhN = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void bw(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m ra = ra(toolId);
            if (ra.sE()) {
                b(new a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.fhE.a(ra);
                if (hVar.getToolId() == 2 && !com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_write_more_tool_point", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_write_more_tool_point", true);
                    hVar.bwX();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    display();
                    b(new a(1, 3, null));
                } else if (ra.fhv == null) {
                    if (ra.fit != null && ra.fit.length > 0) {
                        b(new a(ra.fit[0], -1, null));
                    }
                } else {
                    b(new a(1, toolId, null));
                }
            }
        }
    }

    public void bxl() {
        this.fhE.a((m) null);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.fhT = onClickListener;
        bxj();
    }
}
