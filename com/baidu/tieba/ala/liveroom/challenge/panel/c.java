package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.panel.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends e implements i.a {
    private String dle;
    private TextView ePJ;
    private LinearLayout ePK;
    private LinearLayout ePL;
    private LinearLayout ePM;
    private LinkedList<i> ePN;
    private LinearLayout ePO;
    private TextView ePP;

    public c(Context context, k kVar, String str) {
        super(context, kVar);
        this.ePN = new LinkedList<>();
        this.dle = str;
        this.ePJ = (TextView) this.mRootView.findViewById(a.g.ala_link_pk_entry_description);
        this.ePK = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.ePL = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.ePJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.r.a.wA().arE.XU;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.dle;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.dle;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.ePK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eQe != null) {
                    c.this.eQe.bih();
                }
            }
        });
        this.ePL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eQe != null) {
                    c.this.eQe.bij();
                }
            }
        });
        this.ePM = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.ePO = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.ePP = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bic() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void bid() {
        super.bid();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bC(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.Vg + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.ePO.setVisibility(8);
            this.ePP.setVisibility(0);
            bif();
            this.eQe.be(this.ePN.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<i> it = this.ePN.iterator();
        while (it.hasNext()) {
            i next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.bir()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                this.ePM.removeView(iVar.getView());
                this.ePN.remove(iVar);
                iVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<i> it3 = this.ePN.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                i next2 = it3.next();
                if (dVar3.equals(next2.bir())) {
                    if (dVar3.Vg != next2.bir().Vg) {
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
                    this.ePM.addView(iVar2.getView());
                    this.ePN.add(iVar2);
                }
            }
        }
        if (this.ePM.getChildCount() > 0) {
            this.ePO.setVisibility(0);
            this.ePP.setVisibility(8);
            return;
        }
        this.ePO.setVisibility(8);
        this.ePP.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void a(i iVar) {
        if (iVar != null) {
            this.ePM.removeView(iVar.getView());
            this.ePN.remove(iVar);
            iVar.onDestory();
            if (ListUtils.isEmpty(this.ePN)) {
                this.ePO.setVisibility(8);
                this.ePP.setVisibility(0);
            }
            this.eQe.be(this.ePN.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eQe.cM(dVar.userId);
        }
    }

    public void bif() {
        this.ePM.removeAllViews();
        Iterator<i> it = this.ePN.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.ePN.clear();
        this.ePO.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        this.eQe.removeView();
        return true;
    }
}
