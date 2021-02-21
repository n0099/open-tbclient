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
/* loaded from: classes11.dex */
public class c extends g implements k.a {
    private String fuu;
    private ImageView hwq;
    private LinearLayout hwr;
    private LinearLayout hws;
    private LinearLayout hwt;
    private LinkedList<k> hwu;
    private LinearLayout hwv;
    private TextView hww;

    public c(Context context, n nVar, String str) {
        super(context, nVar);
        this.hwu = new LinkedList<>();
        this.fuu = str;
        this.hwq = (ImageView) this.mRootView.findViewById(a.f.desc_imageView);
        this.hwr = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_enrty_random_entry);
        this.hws = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_enrty_direct_entry);
        this.hwq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.ae.a.Qj().buX.aLY;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.fuu;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.fuu;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.hwr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hwT != null) {
                    c.this.hwT.cdD();
                }
            }
        });
        this.hws.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hwT != null) {
                    c.this.hwT.cdF();
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
                if (c.this.hwT != null) {
                    c.this.hwT.cdG();
                }
            }
        });
        this.hwt = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_wait_user_container);
        this.hwv = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_direct_challenger_layout);
        this.hww = (TextView) this.mRootView.findViewById(a.f.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdt() {
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
                if ((dVar.aFF + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.hwv.setVisibility(8);
            this.hww.setVisibility(0);
            cdw();
            this.hwT.cw(this.hwu.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<k> it = this.hwu.iterator();
        while (it.hasNext()) {
            k next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.cdQ()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                this.hwt.removeView(kVar.getView());
                this.hwu.remove(kVar);
                kVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<k> it3 = this.hwu.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                k next2 = it3.next();
                if (dVar3.equals(next2.cdQ())) {
                    if (dVar3.aFF != next2.cdQ().aFF) {
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
                    this.hwt.addView(kVar2.getView());
                    this.hwu.add(kVar2);
                }
            }
        }
        if (this.hwt.getChildCount() > 0) {
            this.hwv.setVisibility(0);
            this.hww.setVisibility(8);
            return;
        }
        this.hwv.setVisibility(8);
        this.hww.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        if (kVar != null) {
            this.hwt.removeView(kVar.getView());
            this.hwu.remove(kVar);
            kVar.onDestory();
            if (ListUtils.isEmpty(this.hwu)) {
                this.hwv.setVisibility(8);
                this.hww.setVisibility(0);
            }
            this.hwT.cw(this.hwu.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hwT.fD(dVar.userId);
        }
    }

    public void cdw() {
        this.hwt.removeAllViews();
        Iterator<k> it = this.hwu.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.hwu.clear();
        this.hwv.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        this.hwT.removeView();
        return true;
    }
}
