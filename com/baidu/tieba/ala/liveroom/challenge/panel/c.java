package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.panel.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class c extends e implements i.a {
    private String cxs;
    private TextView dZN;
    private LinearLayout dZO;
    private LinearLayout dZP;
    private LinearLayout dZQ;
    private LinkedList<i> dZR;
    private LinearLayout dZS;
    private TextView dZT;

    public c(Context context, k kVar, String str) {
        super(context, kVar);
        this.dZR = new LinkedList<>();
        this.cxs = str;
        this.dZN = (TextView) this.mRootView.findViewById(a.g.ala_link_pk_entry_description);
        this.dZO = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.dZP = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.dZN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.l.a.uB().ajF.Rg;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.cxs;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.cxs;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.dZO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eai != null) {
                    c.this.eai.aQD();
                }
            }
        });
        this.dZP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eai != null) {
                    c.this.eai.aQF();
                }
            }
        });
        this.dZQ = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.dZS = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.dZT = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int aQz() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void aav() {
        super.aav();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bD(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.Oi + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.dZS.setVisibility(8);
            this.dZT.setVisibility(0);
            aQB();
            this.eai.aT(this.dZR.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<i> it = this.dZR.iterator();
        while (it.hasNext()) {
            i next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.aQN()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                this.dZQ.removeView(iVar.getView());
                this.dZR.remove(iVar);
                iVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<i> it3 = this.dZR.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                i next2 = it3.next();
                if (dVar3.equals(next2.aQN())) {
                    if (dVar3.Oi != next2.aQN().Oi) {
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
                    this.dZQ.addView(iVar2.getView());
                    this.dZR.add(iVar2);
                }
            }
        }
        if (this.dZQ.getChildCount() > 0) {
            this.dZS.setVisibility(0);
            this.dZT.setVisibility(8);
            return;
        }
        this.dZS.setVisibility(8);
        this.dZT.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void a(i iVar) {
        if (iVar != null) {
            this.dZQ.removeView(iVar.getView());
            this.dZR.remove(iVar);
            iVar.onDestory();
            if (ListUtils.isEmpty(this.dZR)) {
                this.dZS.setVisibility(8);
                this.dZT.setVisibility(0);
            }
            this.eai.aT(this.dZR.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eai.cg(dVar.userId);
        }
    }

    public void aQB() {
        this.dZQ.removeAllViews();
        Iterator<i> it = this.dZR.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.dZR.clear();
        this.dZS.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        this.eai.removeView();
        return true;
    }
}
