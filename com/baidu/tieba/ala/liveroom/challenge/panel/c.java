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
    private String dPW;
    private LinearLayout fAa;
    private LinearLayout fAb;
    private LinearLayout fAc;
    private LinkedList<i> fAd;
    private LinearLayout fAe;
    private TextView fAf;
    private TextView fzZ;

    public c(Context context, k kVar, String str) {
        super(context, kVar);
        this.fAd = new LinkedList<>();
        this.dPW = str;
        this.fzZ = (TextView) this.mRootView.findViewById(a.g.ala_link_pk_entry_description);
        this.fAa = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.fAb = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.fzZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.v.a.Eo().aQp.asE;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.dPW;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.dPW;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.fAa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fAu != null) {
                    c.this.fAu.buk();
                }
            }
        });
        this.fAb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fAu != null) {
                    c.this.fAu.bum();
                }
            }
        });
        this.fAc = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.fAe = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.fAf = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bue() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void Cd() {
        super.Cd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bL(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.apo + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.fAe.setVisibility(8);
            this.fAf.setVisibility(0);
            buh();
            this.fAu.by(this.fAd.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<i> it = this.fAd.iterator();
        while (it.hasNext()) {
            i next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.buw()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                this.fAc.removeView(iVar.getView());
                this.fAd.remove(iVar);
                iVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<i> it3 = this.fAd.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                i next2 = it3.next();
                if (dVar3.equals(next2.buw())) {
                    if (dVar3.apo != next2.buw().apo) {
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
                    this.fAc.addView(iVar2.getView());
                    this.fAd.add(iVar2);
                }
            }
        }
        if (this.fAc.getChildCount() > 0) {
            this.fAe.setVisibility(0);
            this.fAf.setVisibility(8);
            return;
        }
        this.fAe.setVisibility(8);
        this.fAf.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void a(i iVar) {
        if (iVar != null) {
            this.fAc.removeView(iVar.getView());
            this.fAd.remove(iVar);
            iVar.onDestory();
            if (ListUtils.isEmpty(this.fAd)) {
                this.fAe.setVisibility(8);
                this.fAf.setVisibility(0);
            }
            this.fAu.by(this.fAd.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.fAu.dB(dVar.userId);
        }
    }

    public void buh() {
        this.fAc.removeAllViews();
        Iterator<i> it = this.fAd.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.fAd.clear();
        this.fAe.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        this.fAu.removeView();
        return true;
    }
}
