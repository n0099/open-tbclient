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
    private String ets;
    private ImageView gfq;
    private LinearLayout gfr;
    private LinearLayout gfs;
    private LinearLayout gft;
    private LinkedList<k> gfu;
    private LinearLayout gfv;
    private TextView gfw;

    public c(Context context, m mVar, String str) {
        super(context, mVar);
        this.gfu = new LinkedList<>();
        this.ets = str;
        this.gfq = (ImageView) this.mRootView.findViewById(a.g.desc_imageView);
        this.gfr = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.gfs = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.gfq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.v.a.Hs().aZn.aBg;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.ets;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.ets;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.gfr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gfS != null) {
                    c.this.gfS.bGu();
                }
            }
        });
        this.gfs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gfS != null) {
                    c.this.gfS.bGw();
                }
            }
        });
        View findViewById = this.mRootView.findViewById(a.g.ala_challenge_latest_entry);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.mRootView.getResources().getDimensionPixelOffset(a.e.sdk_ds16));
        gradientDrawable.setColor(452984831);
        findViewById.setBackgroundDrawable(gradientDrawable);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gfS != null) {
                    c.this.gfS.bGx();
                }
            }
        });
        this.gft = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.gfv = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.gfw = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bGk() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void GF() {
        super.GF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bW(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.axw + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.gfv.setVisibility(8);
            this.gfw.setVisibility(0);
            bGn();
            this.gfS.bS(this.gfu.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<k> it = this.gfu.iterator();
        while (it.hasNext()) {
            k next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.bGG()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                this.gft.removeView(kVar.getView());
                this.gfu.remove(kVar);
                kVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<k> it3 = this.gfu.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                k next2 = it3.next();
                if (dVar3.equals(next2.bGG())) {
                    if (dVar3.axw != next2.bGG().axw) {
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
                    this.gft.addView(kVar2.getView());
                    this.gfu.add(kVar2);
                }
            }
        }
        if (this.gft.getChildCount() > 0) {
            this.gfv.setVisibility(0);
            this.gfw.setVisibility(8);
            return;
        }
        this.gfv.setVisibility(8);
        this.gfw.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        if (kVar != null) {
            this.gft.removeView(kVar.getView());
            this.gfu.remove(kVar);
            kVar.onDestory();
            if (ListUtils.isEmpty(this.gfu)) {
                this.gfv.setVisibility(8);
                this.gfw.setVisibility(0);
            }
            this.gfS.bS(this.gfu.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gfS.dT(dVar.userId);
        }
    }

    public void bGn() {
        this.gft.removeAllViews();
        Iterator<k> it = this.gfu.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.gfu.clear();
        this.gfv.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        this.gfS.removeView();
        return true;
    }
}
