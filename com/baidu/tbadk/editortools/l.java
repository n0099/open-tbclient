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
    private g atP;
    private h atQ;
    private List<aa> atR;
    private SparseArray<b> atS;
    private SparseArray<HashSet<b>> atT;
    private SparseArray<HashSet<Integer>> atU;
    private int atV;
    private int atW;
    private boolean atX;
    private int atY;
    private int atZ;
    private boolean aua;
    private LinkedList<s> aub;
    private j auc;
    private View.OnClickListener aud;
    private Runnable aue;
    private Runnable auf;
    private List<Integer> aug;

    public void Do() {
        aa eC = eC(3);
        if (eC != null && (eC.toolView instanceof View)) {
            View view = (View) eC.toolView;
            view.requestFocus();
            com.baidu.adp.lib.util.k.d(getContext(), view);
            com.baidu.adp.lib.h.h.hx().postDelayed(this.auf, 1000L);
        }
    }

    public l(Context context) {
        super(context);
        this.atV = 1;
        this.atW = 0;
        this.atX = false;
        this.atY = t.d.editor_background;
        this.atZ = 0;
        this.aua = true;
        this.aud = new m(this);
        this.aue = new n(this);
        this.auf = new o(this);
        this.aug = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        this.atR = new LinkedList();
        this.atS = new SparseArray<>();
        this.atT = new SparseArray<>();
        this.atU = new SparseArray<>();
        this.atP = new g(context, this);
        this.atQ = new h(context, this);
        this.aub = new LinkedList<>();
        setOrientation(1);
    }

    public void a(int i, b bVar) {
        a(new int[]{i}, 0, bVar);
    }

    protected void a(int[] iArr, int i, b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr != null && iArr.length != 0) {
                HashSet<b> hashSet = this.atT.get(iArr[0]);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    int length = iArr.length;
                    while (i2 < length) {
                        this.atT.put(iArr[i2], hashSet);
                        i2++;
                    }
                }
                hashSet.add(bVar);
            }
        } else if (i > 0) {
            this.atS.put(i, bVar);
            if (iArr != null && iArr.length > 0) {
                int length2 = iArr.length;
                while (i2 < length2) {
                    int i3 = iArr[i2];
                    HashSet<Integer> hashSet2 = this.atU.get(i3);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet<>();
                        this.atU.put(i3, hashSet2);
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
        aa eC;
        if (aVar != null) {
            if (aVar.code == 2) {
                s eA = this.atP.eA(aVar.id);
                if (eA != null) {
                    z = false;
                } else {
                    eA = this.atQ.eA(aVar.id);
                    z = true;
                }
                if (eA == null) {
                    Iterator<s> it = this.aub.iterator();
                    while (it.hasNext()) {
                        sVar = it.next();
                        if (sVar.getToolId() == aVar.id) {
                            break;
                        }
                    }
                }
                sVar = eA;
                if (sVar != null) {
                    sVar.a(aVar);
                    if (z && (eC = eC(2)) != null && eC.toolView != null) {
                        eC.toolView.a(aVar);
                    }
                }
            } else if (aVar.code == 5) {
                this.atP.a((aa) null);
                this.atQ.hide();
            } else if (aVar.id > 0) {
                b bVar = this.atS.get(aVar.id);
                if (bVar != null) {
                    this.atP.ey(aVar.id);
                    aa eC2 = eC(aVar.id);
                    if (eC2 != null && eC2.toolPosition == 5) {
                        this.atQ.hide();
                        Dp();
                    } else {
                        this.atQ.ey(aVar.id);
                    }
                    bVar.a(aVar);
                }
            } else if (aVar.id <= 0) {
                if (aVar.id < 0 && (hashSet = this.atU.get(aVar.code)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        b bVar2 = this.atS.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.a(aVar);
                        }
                    }
                }
                HashSet<b> hashSet2 = this.atT.get(aVar.code);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(aVar);
                    }
                }
            }
        }
    }

    public void Dp() {
        boolean z;
        aa eC;
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.aue);
        if (getContext() instanceof Activity) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null) {
                z = true;
                com.baidu.adp.lib.util.k.c(getContext(), currentFocus);
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && (eC = eC(3)) != null && (eC.toolView instanceof View)) {
            com.baidu.adp.lib.util.k.c(getContext(), (View) eC.toolView);
        }
    }

    public void b(aa aaVar) {
        if (aaVar != null) {
            this.atR.add(aaVar);
        }
    }

    private void clear() {
        this.atP.clear();
        this.atQ.clear();
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.atV = i;
    }

    public void setBarBackgroundColorId(int i) {
        this.atP.setBackgroundColorId(i);
    }

    public void setDeskBackgroundColorId(int i) {
        this.atQ.setBackgroundColorId(i);
    }

    public void onChangeSkinType(int i) {
        at.d(this, this.atY, i);
        this.atP.onChangeSkinType(i);
        this.atQ.onChangeSkinType(i);
    }

    public List<Integer> getCollectTools() {
        return this.aug;
    }

    public void v(List<Integer> list) {
        this.aug.clear();
        this.aug.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EDITOR_COLLECT_TOOL, this));
    }

    public void Di() {
        if (this.atR != null && this.atR.size() != 0) {
            clear();
            LinkedList linkedList = new LinkedList();
            boolean z = false;
            for (aa aaVar : this.atR) {
                if (aaVar.launcherIcon > 0) {
                    linkedList.add(aaVar);
                }
                if (aaVar.toolView != null) {
                    aaVar.toolView.setToolId(aaVar.id);
                    aaVar.toolView.setEditorTools(this);
                    if (aaVar.toolPosition == 6) {
                        this.atQ.a(aaVar.toolView);
                    } else if (aaVar.toolPosition == 1 || aaVar.toolPosition == 2 || aaVar.toolPosition == 3 || aaVar.toolPosition == 4 || aaVar.toolPosition == 5) {
                        this.atP.a(aaVar.toolView, aaVar.toolPosition, !aaVar.toolNeedAction);
                        if (aaVar.toolPosition == 5 && eC(1) == null) {
                            z = true;
                        }
                    }
                    a(aaVar.toolLaunchAction, aaVar.id, aaVar.toolView);
                }
            }
            Collections.sort(linkedList, new p(this));
            if (linkedList.size() > this.atV) {
                x xVar = new x(getContext());
                if (this.atZ > 0 && xVar.toolView != null && (xVar.toolView instanceof com.baidu.tbadk.editortools.view.c)) {
                    ((com.baidu.tbadk.editortools.view.c) xVar.toolView).setBackgroundColorId(this.atZ);
                }
                if (this.atW > 0) {
                    xVar.launcherIcon = this.atW;
                }
                b(xVar);
                xVar.toolView.setToolId(xVar.id);
                xVar.toolView.setEditorTools(this);
                a(xVar.toolLaunchAction, xVar.id, xVar.toolView);
                this.atQ.a(xVar.toolView);
                if (this.atX) {
                    linkedList.add(this.atV, xVar);
                } else {
                    linkedList.add(0, xVar);
                }
            }
            int i = this.atV + 1;
            Iterator it = linkedList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                aa aaVar2 = (aa) it.next();
                if (i2 < i) {
                    this.atP.a(a(aaVar2, 1));
                } else {
                    this.atQ.a(a(aaVar2, 2));
                }
                i2++;
            }
            if (z) {
                q qVar = new q();
                b(qVar);
                s a = a(qVar, 1);
                a.hide();
                this.atP.a(0, a);
            }
            this.atP.Di();
            this.atQ.Di();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.atP.setLayoutParams(layoutParams);
            this.atQ.setLayoutParams(layoutParams);
            this.atQ.hide();
            removeAllViews();
            addView(this.atP);
            addView(this.atQ);
            invalidate();
        }
    }

    public void c(aa aaVar) {
        if (aaVar != null) {
            b(aaVar);
            s a = a(aaVar, 1);
            a.hide();
            if (this.atP != null) {
                this.atP.a(0, a);
                this.atP.removeAllViews();
                this.atP.Di();
            }
            invalidate();
        }
    }

    public aa eC(int i) {
        for (aa aaVar : this.atR) {
            if (aaVar.id == i) {
                return aaVar;
            }
        }
        return null;
    }

    public List<aa> getAllTools() {
        return this.atR;
    }

    public s eA(int i) {
        s eA = this.atP.eA(i);
        if (eA == null) {
            return this.atQ.eA(i);
        }
        return eA;
    }

    public void Dq() {
        this.atP.i(this.aud);
    }

    private s a(aa aaVar, int i) {
        s a = r.a(getContext(), aaVar, i);
        if (a instanceof View) {
            ((View) a).setContentDescription(aaVar.name);
        }
        if (a instanceof c) {
            ((View) a).setOnClickListener(this.aud);
        }
        return a;
    }

    public void br(boolean z) {
        for (aa aaVar : this.atR) {
            if (aaVar != null && (aaVar.toolView instanceof View) && ((View) aaVar.toolView).getVisibility() == 0 && !aaVar.toolNeedAction) {
                aaVar.toolView.op();
            }
        }
        if (this.aua) {
            this.aua = false;
            BD();
        }
        if (!Dk() && z) {
            com.baidu.adp.lib.h.h.hx().postDelayed(this.aue, 200L);
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dr() {
        if (this.auc == null) {
            this.auc = new j(getResources().getString(t.j.graffiti_reply_tips), "graffiti_reply_tip_show", 24, 2);
        }
        s eA = eA(this.auc.Dm());
        if ((eA instanceof View) && eC(this.auc.getToolId()) != null) {
            this.auc.e(getContext(), (View) eA);
        }
    }

    public void op() {
        br(true);
    }

    public void Ds() {
        for (aa aaVar : this.atR) {
            if (aaVar != null && (aaVar.toolView instanceof View) && ((View) aaVar.toolView).getVisibility() == 0 && !aaVar.toolNeedAction) {
                aaVar.toolView.op();
            }
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.auc != null) {
            this.auc.Dn();
        }
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.auf);
        this.atQ.hide();
        setVisibility(8);
        Dp();
    }

    public void BD() {
        this.atQ.hide();
    }

    public void setBarLauncherEnabled(boolean z) {
        this.atP.setBarLauncherEnabled(z);
    }

    public boolean Dk() {
        return this.atQ.Dk();
    }

    public void setFrom(int i) {
    }

    public void setMoreLauncherIcon(int i) {
        this.atW = i;
    }

    public void setBarLauncherType(int i) {
        this.atP.setBarLauncherType(i);
    }

    public void setBarLinePostion(int i) {
        this.atP.setLinePosition(i);
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.atX = z;
    }

    public void setBackgroundColorId(int i) {
        this.atY = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setMoreDeskBgColorId(int i) {
        this.atZ = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void H(View view) {
        if (view instanceof s) {
            s sVar = (s) view;
            b(new a(31, 0, Integer.valueOf(sVar.getToolId())));
            this.atP.a(eC(sVar.getToolId()));
            if (this.auc != null) {
                this.auc.Dn();
                com.baidu.adp.lib.h.h.hx().removeCallbacks(this.auf);
            }
            if (sVar.getToolId() == 1) {
                sVar.hide();
                op();
                b(new a(1, 3, null));
                return;
            }
            int toolId = sVar.getToolId();
            aa eC = eC(toolId);
            if (eC.toolView == null) {
                if (eC.toolLaunchAction != null && eC.toolLaunchAction.length > 0) {
                    b(new a(eC.toolLaunchAction[0], -1, null));
                    return;
                }
                return;
            }
            b(new a(1, toolId, null));
        }
    }

    public void Dt() {
        if (this.auc != null) {
            this.auc.Dn();
            this.auc = null;
        }
    }
}
