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
    private String dQb;
    private TextView fAe;
    private LinearLayout fAf;
    private LinearLayout fAg;
    private LinearLayout fAh;
    private LinkedList<i> fAi;
    private LinearLayout fAj;
    private TextView fAk;

    public c(Context context, k kVar, String str) {
        super(context, kVar);
        this.fAi = new LinkedList<>();
        this.dQb = str;
        this.fAe = (TextView) this.mRootView.findViewById(a.g.ala_link_pk_entry_description);
        this.fAf = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.fAg = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.fAe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.v.a.En().aQu.asK;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.dQb;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.dQb;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.fAf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fAz != null) {
                    c.this.fAz.bui();
                }
            }
        });
        this.fAg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fAz != null) {
                    c.this.fAz.buk();
                }
            }
        });
        this.fAh = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.fAj = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.fAk = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int buc() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void Cc() {
        super.Cc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bL(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.apv + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.fAj.setVisibility(8);
            this.fAk.setVisibility(0);
            buf();
            this.fAz.by(this.fAi.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<i> it = this.fAi.iterator();
        while (it.hasNext()) {
            i next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.buu()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                this.fAh.removeView(iVar.getView());
                this.fAi.remove(iVar);
                iVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<i> it3 = this.fAi.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                i next2 = it3.next();
                if (dVar3.equals(next2.buu())) {
                    if (dVar3.apv != next2.buu().apv) {
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
                    this.fAh.addView(iVar2.getView());
                    this.fAi.add(iVar2);
                }
            }
        }
        if (this.fAh.getChildCount() > 0) {
            this.fAj.setVisibility(0);
            this.fAk.setVisibility(8);
            return;
        }
        this.fAj.setVisibility(8);
        this.fAk.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void a(i iVar) {
        if (iVar != null) {
            this.fAh.removeView(iVar.getView());
            this.fAi.remove(iVar);
            iVar.onDestory();
            if (ListUtils.isEmpty(this.fAi)) {
                this.fAj.setVisibility(8);
                this.fAk.setVisibility(0);
            }
            this.fAz.by(this.fAi.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.fAz.dB(dVar.userId);
        }
    }

    public void buf() {
        this.fAh.removeAllViews();
        Iterator<i> it = this.fAi.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.fAi.clear();
        this.fAj.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        this.fAz.removeView();
        return true;
    }
}
