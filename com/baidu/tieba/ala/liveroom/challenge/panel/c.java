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
    private String cyj;
    private TextView eaE;
    private LinearLayout eaF;
    private LinearLayout eaG;
    private LinearLayout eaH;
    private LinkedList<i> eaI;
    private LinearLayout eaJ;
    private TextView eaK;

    public c(Context context, k kVar, String str) {
        super(context, kVar);
        this.eaI = new LinkedList<>();
        this.cyj = str;
        this.eaE = (TextView) this.mRootView.findViewById(a.g.ala_link_pk_entry_description);
        this.eaF = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.eaG = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.eaE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.l.a.uA().ajX.RG;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.cyj;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.cyj;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.eaF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eaZ != null) {
                    c.this.eaZ.aQF();
                }
            }
        });
        this.eaG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eaZ != null) {
                    c.this.eaZ.aQH();
                }
            }
        });
        this.eaH = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.eaJ = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.eaK = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int aQB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void aax() {
        super.aax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bD(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.OI + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.eaJ.setVisibility(8);
            this.eaK.setVisibility(0);
            aQD();
            this.eaZ.aT(this.eaI.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<i> it = this.eaI.iterator();
        while (it.hasNext()) {
            i next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.aQP()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                this.eaH.removeView(iVar.getView());
                this.eaI.remove(iVar);
                iVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<i> it3 = this.eaI.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                i next2 = it3.next();
                if (dVar3.equals(next2.aQP())) {
                    if (dVar3.OI != next2.aQP().OI) {
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
                    this.eaH.addView(iVar2.getView());
                    this.eaI.add(iVar2);
                }
            }
        }
        if (this.eaH.getChildCount() > 0) {
            this.eaJ.setVisibility(0);
            this.eaK.setVisibility(8);
            return;
        }
        this.eaJ.setVisibility(8);
        this.eaK.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void a(i iVar) {
        if (iVar != null) {
            this.eaH.removeView(iVar.getView());
            this.eaI.remove(iVar);
            iVar.onDestory();
            if (ListUtils.isEmpty(this.eaI)) {
                this.eaJ.setVisibility(8);
                this.eaK.setVisibility(0);
            }
            this.eaZ.aT(this.eaI.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.i.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eaZ.ch(dVar.userId);
        }
    }

    public void aQD() {
        this.eaH.removeAllViews();
        Iterator<i> it = this.eaI.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.eaI.clear();
        this.eaJ.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        this.eaZ.removeView();
        return true;
    }
}
