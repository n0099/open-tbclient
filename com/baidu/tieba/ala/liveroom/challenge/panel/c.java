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
/* loaded from: classes10.dex */
public class c extends g implements k.a {
    private String fvT;
    private ImageView hxZ;
    private LinearLayout hya;
    private LinearLayout hyb;
    private LinearLayout hyc;
    private LinkedList<k> hyd;
    private LinearLayout hye;
    private TextView hyf;

    public c(Context context, n nVar, String str) {
        super(context, nVar);
        this.hyd = new LinkedList<>();
        this.fvT = str;
        this.hxZ = (ImageView) this.mRootView.findViewById(a.f.desc_imageView);
        this.hya = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_enrty_random_entry);
        this.hyb = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_enrty_direct_entry);
        this.hxZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.ae.a.Qm().bwx.aNy;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.fvT;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.fvT;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.hya.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hyC != null) {
                    c.this.hyC.cdJ();
                }
            }
        });
        this.hyb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hyC != null) {
                    c.this.hyC.cdL();
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
                if (c.this.hyC != null) {
                    c.this.hyC.cdM();
                }
            }
        });
        this.hyc = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_wait_user_container);
        this.hye = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_direct_challenger_layout);
        this.hyf = (TextView) this.mRootView.findViewById(a.f.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdz() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void onShow() {
        super.onShow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cD(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.aHf + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.hye.setVisibility(8);
            this.hyf.setVisibility(0);
            cdC();
            this.hyC.cx(this.hyd.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<k> it = this.hyd.iterator();
        while (it.hasNext()) {
            k next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.cdW()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                this.hyc.removeView(kVar.getView());
                this.hyd.remove(kVar);
                kVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<k> it3 = this.hyd.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                k next2 = it3.next();
                if (dVar3.equals(next2.cdW())) {
                    if (dVar3.aHf != next2.cdW().aHf) {
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
                    this.hyc.addView(kVar2.getView());
                    this.hyd.add(kVar2);
                }
            }
        }
        if (this.hyc.getChildCount() > 0) {
            this.hye.setVisibility(0);
            this.hyf.setVisibility(8);
            return;
        }
        this.hye.setVisibility(8);
        this.hyf.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        if (kVar != null) {
            this.hyc.removeView(kVar.getView());
            this.hyd.remove(kVar);
            kVar.onDestory();
            if (ListUtils.isEmpty(this.hyd)) {
                this.hye.setVisibility(8);
                this.hyf.setVisibility(0);
            }
            this.hyC.cx(this.hyd.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hyC.fD(dVar.userId);
        }
    }

    public void cdC() {
        this.hyc.removeAllViews();
        Iterator<k> it = this.hyd.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.hyd.clear();
        this.hye.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        this.hyC.removeView();
        return true;
    }
}
