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
    private String eev;
    private TextView fOh;
    private LinearLayout fOi;
    private LinearLayout fOj;
    private LinearLayout fOk;
    private LinkedList<i> fOl;
    private LinearLayout fOm;
    private TextView fOn;

    public c(Context context, k kVar, String str) {
        super(context, kVar);
        this.fOl = new LinkedList<>();
        this.eev = str;
        this.fOh = (TextView) this.mRootView.findViewById(a.g.ala_link_pk_entry_description);
        this.fOi = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.fOj = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.fOh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.v.a.Ge().aWF.axK;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.eev;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.eev;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.fOi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fOC != null) {
                    c.this.fOC.bAh();
                }
            }
        });
        this.fOj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fOC != null) {
                    c.this.fOC.bAj();
                }
            }
        });
        this.fOk = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.fOm = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.fOn = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bAb() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void Dz() {
        super.Dz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bI(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.auo + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.fOm.setVisibility(8);
            this.fOn.setVisibility(0);
            bAe();
            this.fOC.bF(this.fOl.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<i> it = this.fOl.iterator();
        while (it.hasNext()) {
            i next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.bAt()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                this.fOk.removeView(iVar.getView());
                this.fOl.remove(iVar);
                iVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<i> it3 = this.fOl.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                i next2 = it3.next();
                if (dVar3.equals(next2.bAt())) {
                    if (dVar3.auo != next2.bAt().auo) {
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
                    this.fOk.addView(iVar2.getView());
                    this.fOl.add(iVar2);
                }
            }
        }
        if (this.fOk.getChildCount() > 0) {
            this.fOm.setVisibility(0);
            this.fOn.setVisibility(8);
            return;
        }
        this.fOm.setVisibility(8);
        this.fOn.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void a(i iVar) {
        if (iVar != null) {
            this.fOk.removeView(iVar.getView());
            this.fOl.remove(iVar);
            iVar.onDestory();
            if (ListUtils.isEmpty(this.fOl)) {
                this.fOm.setVisibility(8);
                this.fOn.setVisibility(0);
            }
            this.fOC.bF(this.fOl.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.fOC.dC(dVar.userId);
        }
    }

    public void bAe() {
        this.fOk.removeAllViews();
        Iterator<i> it = this.fOl.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.fOl.clear();
        this.fOm.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        this.fOC.removeView();
        return true;
    }
}
