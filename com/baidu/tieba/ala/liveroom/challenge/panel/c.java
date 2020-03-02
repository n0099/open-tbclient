package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.challenge.panel.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends e implements i.a {
    private String dpD;
    private TextView eVa;
    private LinearLayout eVb;
    private LinearLayout eVc;
    private LinearLayout eVd;
    private LinkedList<i> eVe;
    private LinearLayout eVf;
    private TextView eVg;

    public c(Context context, k kVar, String str) {
        super(context, kVar);
        this.eVe = new LinkedList<>();
        this.dpD = str;
        this.eVa = (TextView) this.mRootView.findViewById(a.g.ala_link_pk_entry_description);
        this.eVb = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.eVc = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.eVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.v.a.zl().awB.aaf;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.dpD;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.dpD;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.eVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eVv != null) {
                    c.this.eVv.bkL();
                }
            }
        });
        this.eVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eVv != null) {
                    c.this.eVv.bkN();
                }
            }
        });
        this.eVd = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.eVf = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.eVg = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkF() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void xm() {
        super.xm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bC(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.Xc + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.eVf.setVisibility(8);
            this.eVg.setVisibility(0);
            bkI();
            this.eVv.bl(this.eVe.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<i> it = this.eVe.iterator();
        while (it.hasNext()) {
            i next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.bkX()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                this.eVd.removeView(iVar.getView());
                this.eVe.remove(iVar);
                iVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<i> it3 = this.eVe.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                i next2 = it3.next();
                if (dVar3.equals(next2.bkX())) {
                    if (dVar3.Xc != next2.bkX().Xc) {
                        next2.h(dVar3);
                    }
                    z = true;
                } else {
                    z = z3;
                }
                z3 = z;
            }
            if (!z3) {
                i iVar2 = new i(this.mContext);
                iVar2.a(this);
                iVar2.h(dVar3);
                if (iVar2.isVisible()) {
                    this.eVd.addView(iVar2.getView());
                    this.eVe.add(iVar2);
                }
            }
        }
        if (this.eVd.getChildCount() > 0) {
            this.eVf.setVisibility(0);
            this.eVg.setVisibility(8);
            return;
        }
        this.eVf.setVisibility(8);
        this.eVg.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void a(i iVar) {
        if (iVar != null) {
            this.eVd.removeView(iVar.getView());
            this.eVe.remove(iVar);
            iVar.onDestory();
            if (ListUtils.isEmpty(this.eVe)) {
                this.eVf.setVisibility(8);
                this.eVg.setVisibility(0);
            }
            this.eVv.bl(this.eVe.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eVv.cT(dVar.userId);
        }
    }

    public void bkI() {
        this.eVd.removeAllViews();
        Iterator<i> it = this.eVe.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.eVe.clear();
        this.eVf.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        this.eVv.removeView();
        return true;
    }
}
