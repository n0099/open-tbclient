package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.panel.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends g implements k.a {
    private String fgt;
    private ImageView hbl;
    private LinearLayout hbm;
    private LinearLayout hbn;
    private LinearLayout hbo;
    private LinkedList<k> hbp;
    private LinearLayout hbq;
    private TextView hbr;

    public c(Context context, n nVar, String str) {
        super(context, nVar);
        this.hbp = new LinkedList<>();
        this.fgt = str;
        this.hbl = (ImageView) this.mRootView.findViewById(a.f.desc_imageView);
        this.hbm = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_enrty_random_entry);
        this.hbn = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_enrty_direct_entry);
        this.hbl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.aa.a.PQ().bod.aMn;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.fgt;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.fgt;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.hbm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hbO != null) {
                    c.this.hbO.can();
                }
            }
        });
        this.hbn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hbO != null) {
                    c.this.hbO.cap();
                }
            }
        });
        View findViewById = this.mRootView.findViewById(a.f.ala_challenge_latest_entry);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.mRootView.getResources().getDimensionPixelOffset(a.d.sdk_ds16));
        gradientDrawable.setColor(452984831);
        findViewById.setBackgroundDrawable(gradientDrawable);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hbO != null) {
                    c.this.hbO.caq();
                }
            }
        });
        this.hbo = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_wait_user_container);
        this.hbq = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_direct_challenger_layout);
        this.hbr = (TextView) this.mRootView.findViewById(a.f.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cad() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void Pc() {
        super.Pc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cx(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.aHm + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.hbq.setVisibility(8);
            this.hbr.setVisibility(0);
            cag();
            this.hbO.dN(this.hbp.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<k> it = this.hbp.iterator();
        while (it.hasNext()) {
            k next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.caA()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                this.hbo.removeView(kVar.getView());
                this.hbp.remove(kVar);
                kVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<k> it3 = this.hbp.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                k next2 = it3.next();
                if (dVar3.equals(next2.caA())) {
                    if (dVar3.aHm != next2.caA().aHm) {
                        next2.k(dVar3);
                    }
                    z = true;
                } else {
                    z = z3;
                }
                z3 = z;
            }
            if (!z3) {
                k kVar2 = new k(this.mContext);
                kVar2.a(this);
                kVar2.k(dVar3);
                if (kVar2.isVisible()) {
                    this.hbo.addView(kVar2.getView());
                    this.hbp.add(kVar2);
                }
            }
        }
        if (this.hbo.getChildCount() > 0) {
            this.hbq.setVisibility(0);
            this.hbr.setVisibility(8);
            return;
        }
        this.hbq.setVisibility(8);
        this.hbr.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        if (kVar != null) {
            this.hbo.removeView(kVar.getView());
            this.hbp.remove(kVar);
            kVar.onDestory();
            if (ListUtils.isEmpty(this.hbp)) {
                this.hbq.setVisibility(8);
                this.hbr.setVisibility(0);
            }
            this.hbO.dN(this.hbp.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hbO.eU(dVar.userId);
        }
    }

    public void cag() {
        this.hbo.removeAllViews();
        Iterator<k> it = this.hbp.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.hbp.clear();
        this.hbq.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        this.hbO.removeView();
        return true;
    }
}
