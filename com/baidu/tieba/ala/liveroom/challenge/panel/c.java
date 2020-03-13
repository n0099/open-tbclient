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
    private String dpQ;
    private TextView eVn;
    private LinearLayout eVo;
    private LinearLayout eVp;
    private LinearLayout eVq;
    private LinkedList<i> eVr;
    private LinearLayout eVs;
    private TextView eVt;

    public c(Context context, k kVar, String str) {
        super(context, kVar);
        this.eVr = new LinkedList<>();
        this.dpQ = str;
        this.eVn = (TextView) this.mRootView.findViewById(a.g.ala_link_pk_entry_description);
        this.eVo = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.eVp = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.eVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.v.a.zl().awC.aaf;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.dpQ;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.dpQ;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.eVo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eVI != null) {
                    c.this.eVI.bkM();
                }
            }
        });
        this.eVp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eVI != null) {
                    c.this.eVI.bkO();
                }
            }
        });
        this.eVq = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.eVs = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.eVt = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkG() {
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
            this.eVs.setVisibility(8);
            this.eVt.setVisibility(0);
            bkJ();
            this.eVI.bl(this.eVr.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<i> it = this.eVr.iterator();
        while (it.hasNext()) {
            i next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.bkY()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                this.eVq.removeView(iVar.getView());
                this.eVr.remove(iVar);
                iVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<i> it3 = this.eVr.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                i next2 = it3.next();
                if (dVar3.equals(next2.bkY())) {
                    if (dVar3.Xc != next2.bkY().Xc) {
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
                    this.eVq.addView(iVar2.getView());
                    this.eVr.add(iVar2);
                }
            }
        }
        if (this.eVq.getChildCount() > 0) {
            this.eVs.setVisibility(0);
            this.eVt.setVisibility(8);
            return;
        }
        this.eVs.setVisibility(8);
        this.eVt.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void a(i iVar) {
        if (iVar != null) {
            this.eVq.removeView(iVar.getView());
            this.eVr.remove(iVar);
            iVar.onDestory();
            if (ListUtils.isEmpty(this.eVr)) {
                this.eVs.setVisibility(8);
                this.eVt.setVisibility(0);
            }
            this.eVI.bl(this.eVr.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eVI.cT(dVar.userId);
        }
    }

    public void bkJ() {
        this.eVq.removeAllViews();
        Iterator<i> it = this.eVr.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.eVr.clear();
        this.eVs.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        this.eVI.removeView();
        return true;
    }
}
