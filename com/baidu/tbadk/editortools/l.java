package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private g apH;
    private h apI;
    private List<aa> apJ;
    private SparseArray<b> apK;
    private SparseArray<HashSet<b>> apL;
    private SparseArray<HashSet<Integer>> apM;
    private int apN;
    private int apO;
    private boolean apP;
    private int apQ;
    private int apR;
    private boolean apS;
    private LinkedList<s> apT;
    private j apU;
    private View.OnClickListener apV;
    private Runnable apW;
    private Runnable apX;
    private Boolean apY;
    private List<Integer> apZ;

    public void Bi() {
        aa ei = ei(3);
        if (ei != null && (ei.aps instanceof View)) {
            View view = (View) ei.aps;
            view.requestFocus();
            com.baidu.adp.lib.util.k.b(getContext(), view);
            com.baidu.adp.lib.h.h.dL().postDelayed(this.apX, 1000L);
        }
    }

    public l(Context context) {
        super(context);
        this.apN = 1;
        this.apO = 0;
        this.apP = false;
        this.apQ = t.d.editor_background;
        this.apR = 0;
        this.apS = true;
        this.apV = new m(this);
        this.apW = new n(this);
        this.apX = new o(this);
        this.apZ = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.apJ = new LinkedList();
        this.apK = new SparseArray<>();
        this.apL = new SparseArray<>();
        this.apM = new SparseArray<>();
        this.apH = new g(context, this);
        this.apI = new h(context, this);
        this.apT = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.apL.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.apL.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.apK.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.apM.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.apM.put(i3, hashSet2);
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
        s sVar;
        aa ei;
        if (aVar != null) {
            if (aVar.code == 2) {
                s eg = this.apH.eg(aVar.id);
                if (eg != null) {
                    z = false;
                } else {
                    eg = this.apI.eg(aVar.id);
                    z = true;
                }
                if (eg == null) {
                    Iterator<s> it = this.apT.iterator();
                    while (it.hasNext()) {
                        sVar = it.next();
                        if (sVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                sVar = eg;
                if (sVar != null) {
                    sVar.a(aVar);
                    if (z && (ei = ei(2)) != null && ei.aps != null) {
                        ei.aps.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.apH.a((aa) null);
                this.apI.hide();
            } else if (aVar.id > 0) {
                b bVar = this.apK.get(aVar.id);
                if (bVar != null) {
                    this.apH.ee(aVar.id);
                    aa ei2 = ei(aVar.id);
                    if (ei2 != null && ei2.aqo == 5) {
                        this.apI.hide();
                        Bj();
                    } else {
                        this.apI.ee(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.apM.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.apK.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.apL.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Bj() {
        boolean z;
        aa ei;
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.apW);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.k.a(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && (ei = ei(3)) != null && (ei.aps instanceof View)) {
            com.baidu.adp.lib.util.k.a(getContext(), (View) ei.aps);
        }
    }

    public void b(aa aaVar) {
        if (aaVar != null) {
            this.apJ.add(aaVar);
        }
    }

    private void clear() {
        this.apH.clear();
        this.apI.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.apN = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.apH.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.apI.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        at.e(this, this.apQ, i);
        this.apH.onChangeSkinType(i);
        this.apI.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.apZ;
    }

    public void x(List<Integer> list) {
        this.apZ.clear();
        this.apZ.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Bc() {
        if (this.apJ != null && this.apJ.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (aa aaVar : this.apJ) {
                if (aaVar.aql > 0) {
                    linkedList.add(aaVar);
                }
                if (aaVar.aps != null) {
                    aaVar.aps.setToolId(aaVar.id);
                    aaVar.aps.setEditorTools(this);
                    if (aaVar.aqo == 6) {
                        this.apI.a(aaVar.aps);
                    } else if (aaVar.aqo == 1 || aaVar.aqo == 2 || aaVar.aqo == 3 || aaVar.aqo == 4 || aaVar.aqo == 5) {
                        this.apH.a(aaVar.aps, aaVar.aqo, !aaVar.aqp);
                        if (aaVar.aqo == 5 && ei(1) == null) {
                            z = true;
                        }
                    }
                    a(aaVar.aqq, aaVar.id, aaVar.aps);
                }
            }
            Collections.sort(linkedList, new p(this));
            if (linkedList.size() > this.apN) {
                x xVar = new x(getContext());
                if (this.apR > 0 && xVar.aps != null && (xVar.aps instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) xVar.aps).setBackgroundColorId(this.apR);
                }
                if (this.apO > 0) {
                    xVar.aql = this.apO;
                }
                b(xVar);
                xVar.aps.setToolId(xVar.id);
                xVar.aps.setEditorTools(this);
                a(xVar.aqq, xVar.id, xVar.aps);
                this.apI.a(xVar.aps);
                if (this.apP) {
                    linkedList.add(this.apN, xVar);
                } else {
                    linkedList.add(0, xVar);
                }
            }
            int i = this.apN + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                aa aaVar2 = (aa) it.next();
                if (i2 < i) {
                    this.apH.a(a(aaVar2, 1));
                } else {
                    this.apI.a(a(aaVar2, 2));
                }
                i2++;
            }
            if (z) {
                q qVar = new q();
                b(qVar);
                s a = a(qVar, 1);
                a.hide();
                this.apH.a(0, a);
            }
            this.apH.Bc();
            this.apI.Bc();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.apH.setLayoutParams(layoutParams);
            this.apI.setLayoutParams(layoutParams);
            this.apI.hide();
            removeAllViews();
            addView(this.apH);
            addView(this.apI);
            invalidate();
        }
    }

    public void c(aa aaVar) {
        if (aaVar != null) {
            b(aaVar);
            s a = a(aaVar, 1);
            a.hide();
            if (this.apH != null) {
                this.apH.a(0, a);
                this.apH.removeAllViews();
                this.apH.Bc();
            }
            invalidate();
        }
    }

    public aa ei(int i) {
        for (aa aaVar : this.apJ) {
            if (aaVar.id == i) {
                return aaVar;
            }
        }
        return null;
    }

    public List<aa> getAllTools() {
        return this.apJ;
    }

    public s eg(int i) {
        s eg = this.apH.eg(i);
        if (eg == null) {
            return this.apI.eg(i);
        }
        return eg;
    }

    public void Bk() {
        this.apH.i(this.apV);
    }

    private s a(aa aaVar, int i) {
        s a = r.a(getContext(), aaVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(aaVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.apV);
        }
        return a;
    }

    public void bx(boolean z) {
        for (aa aaVar : this.apJ) {
            if (aaVar != null && (aaVar.aps instanceof View) && ((View) aaVar.aps).getVisibility() == 0 && !aaVar.aqp) {
                aaVar.aps.kC();
            }
        }
        if (this.apS) {
            this.apS = false;
            zx();
        }
        if (!Be() && z) {
            com.baidu.adp.lib.h.h.dL().postDelayed(this.apW, 200L);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl() {
        if (this.apU == null) {
            this.apU = new j(getResources().getString(t.j.graffiti_reply_tips), "graffiti_reply_tip_show", 24, 2);
        }
        s eg = eg(this.apU.Bg());
        if ((eg instanceof View) && ei(this.apU.getToolId()) != null) {
            this.apU.c(getContext(), (View) eg);
        }
    }

    public void kC() {
        bx(true);
    }

    public void Bm() {
        for (aa aaVar : this.apJ) {
            if (aaVar != null && (aaVar.aps instanceof View) && ((View) aaVar.aps).getVisibility() == 0 && !aaVar.aqp) {
                aaVar.aps.kC();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.apU != null) {
            this.apU.Bh();
        }
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.apX);
        this.apI.hide();
        setVisibility(8);
        Bj();
    }

    public void zx() {
        this.apI.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.apH.setBarLauncherEnabled(z);
    }

    public boolean Be() {
        return this.apI.Be();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.apO = i;
    }

    public void setBarLauncherType(int i) {
        this.apH.setBarLauncherType(i);
    }

    public void setBarLinePostion(int i) {
        this.apH.setLinePosition(i);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.apP = z;
    }

    public void setBackgroundColorId(int i) {
        this.apQ = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.apR = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void I(View view) {
        if (view instanceof s) {
            s sVar = (s) view;
            b(new a(31, 0, Integer.valueOf(sVar.getToolId())));
            this.apH.a(ei(sVar.getToolId()));
            if (this.apU != null) {
                this.apU.Bh();
                com.baidu.adp.lib.h.h.dL().removeCallbacks(this.apX);
            }
            if (sVar.getToolId() == 1) {
                sVar.hide();
                kC();
                b(new a(1, 3, null));
                return;
            }
            int toolId = sVar.getToolId();
            aa ei = ei(toolId);
            if (ei.aps == null) {
                if (ei.aqq != null && ei.aqq.length > 0) {
                    b(new a(ei.aqq[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }

    public void Bn() {
        if (this.apU != null) {
            this.apU.Bh();
            this.apU = null;
        }
    }

    public void setCanshowTogetherhi(Boolean bool) {
        this.apY = bool;
    }

    public Boolean getCanshowTogetherhi() {
        return this.apY;
    }
}
