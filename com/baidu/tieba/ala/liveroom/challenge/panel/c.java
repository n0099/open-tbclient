package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.panel.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends e implements i.a {
    private String dlu;
    private TextView eRi;
    private LinearLayout eRj;
    private LinearLayout eRk;
    private LinearLayout eRl;
    private LinkedList<i> eRm;
    private LinearLayout eRn;
    private TextView eRo;

    public c(Context context, k kVar, String str) {
        super(context, kVar);
        this.eRm = new LinkedList<>();
        this.dlu = str;
        this.eRi = (TextView) this.mRootView.findViewById(a.g.ala_link_pk_entry_description);
        this.eRj = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.eRk = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.eRi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.s.a.wR().asq.Yn;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.dlu;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.dlu;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.eRj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eRD != null) {
                    c.this.eRD.biU();
                }
            }
        });
        this.eRk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eRD != null) {
                    c.this.eRD.biW();
                }
            }
        });
        this.eRl = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.eRn = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.eRo = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int biN() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void biO() {
        super.biO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bC(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.Vw + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.eRn.setVisibility(8);
            this.eRo.setVisibility(0);
            biR();
            this.eRD.be(this.eRm.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<i> it = this.eRm.iterator();
        while (it.hasNext()) {
            i next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.bjg()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                this.eRl.removeView(iVar.getView());
                this.eRm.remove(iVar);
                iVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<i> it3 = this.eRm.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                i next2 = it3.next();
                if (dVar3.equals(next2.bjg())) {
                    if (dVar3.Vw != next2.bjg().Vw) {
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
                    this.eRl.addView(iVar2.getView());
                    this.eRm.add(iVar2);
                }
            }
        }
        if (this.eRl.getChildCount() > 0) {
            this.eRn.setVisibility(0);
            this.eRo.setVisibility(8);
            return;
        }
        this.eRn.setVisibility(8);
        this.eRo.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void a(i iVar) {
        if (iVar != null) {
            this.eRl.removeView(iVar.getView());
            this.eRm.remove(iVar);
            iVar.onDestory();
            if (ListUtils.isEmpty(this.eRm)) {
                this.eRn.setVisibility(8);
                this.eRo.setVisibility(0);
            }
            this.eRD.be(this.eRm.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eRD.cR(dVar.userId);
        }
    }

    public void biR() {
        this.eRl.removeAllViews();
        Iterator<i> it = this.eRm.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.eRm.clear();
        this.eRn.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        this.eRD.removeView();
        return true;
    }
}
