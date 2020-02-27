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
    private String dpC;
    private TextView eUZ;
    private LinearLayout eVa;
    private LinearLayout eVb;
    private LinearLayout eVc;
    private LinkedList<i> eVd;
    private LinearLayout eVe;
    private TextView eVf;

    public c(Context context, k kVar, String str) {
        super(context, kVar);
        this.eVd = new LinkedList<>();
        this.dpC = str;
        this.eUZ = (TextView) this.mRootView.findViewById(a.g.ala_link_pk_entry_description);
        this.eVa = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.eVb = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.eUZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.v.a.zj().awA.aaf;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.dpC;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.dpC;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.eVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eVu != null) {
                    c.this.eVu.bkJ();
                }
            }
        });
        this.eVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eVu != null) {
                    c.this.eVu.bkL();
                }
            }
        });
        this.eVc = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.eVe = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.eVf = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkD() {
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
            this.eVe.setVisibility(8);
            this.eVf.setVisibility(0);
            bkG();
            this.eVu.bl(this.eVd.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<i> it = this.eVd.iterator();
        while (it.hasNext()) {
            i next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.bkV()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                this.eVc.removeView(iVar.getView());
                this.eVd.remove(iVar);
                iVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<i> it3 = this.eVd.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                i next2 = it3.next();
                if (dVar3.equals(next2.bkV())) {
                    if (dVar3.Xc != next2.bkV().Xc) {
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
                    this.eVc.addView(iVar2.getView());
                    this.eVd.add(iVar2);
                }
            }
        }
        if (this.eVc.getChildCount() > 0) {
            this.eVe.setVisibility(0);
            this.eVf.setVisibility(8);
            return;
        }
        this.eVe.setVisibility(8);
        this.eVf.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void a(i iVar) {
        if (iVar != null) {
            this.eVc.removeView(iVar.getView());
            this.eVd.remove(iVar);
            iVar.onDestory();
            if (ListUtils.isEmpty(this.eVd)) {
                this.eVe.setVisibility(8);
                this.eVf.setVisibility(0);
            }
            this.eVu.bl(this.eVd.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eVu.cT(dVar.userId);
        }
    }

    public void bkG() {
        this.eVc.removeAllViews();
        Iterator<i> it = this.eVd.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.eVd.clear();
        this.eVe.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        this.eVu.removeView();
        return true;
    }
}
