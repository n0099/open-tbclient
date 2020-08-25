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
/* loaded from: classes7.dex */
public class c extends g implements k.a {
    private String eDP;
    private LinearLayout grA;
    private LinearLayout grB;
    private LinkedList<k> grC;
    private LinearLayout grD;
    private TextView grE;
    private ImageView gry;
    private LinearLayout grz;

    public c(Context context, m mVar, String str) {
        super(context, mVar);
        this.grC = new LinkedList<>();
        this.eDP = str;
        this.gry = (ImageView) this.mRootView.findViewById(a.g.desc_imageView);
        this.grz = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.grA = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.gry.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.w.a.Nk().beH.aGq;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.eDP;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.eDP;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.grz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gsa != null) {
                    c.this.gsa.bPZ();
                }
            }
        });
        this.grA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gsa != null) {
                    c.this.gsa.bQb();
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
                if (c.this.gsa != null) {
                    c.this.gsa.bQc();
                }
            }
        });
        this.grB = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.grD = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.grE = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bPP() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void Mr() {
        super.Mr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bX(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.aCy + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.grD.setVisibility(8);
            this.grE.setVisibility(0);
            bPS();
            this.gsa.dE(this.grC.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<k> it = this.grC.iterator();
        while (it.hasNext()) {
            k next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.bQl()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                this.grB.removeView(kVar.getView());
                this.grC.remove(kVar);
                kVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<k> it3 = this.grC.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                k next2 = it3.next();
                if (dVar3.equals(next2.bQl())) {
                    if (dVar3.aCy != next2.bQl().aCy) {
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
                    this.grB.addView(kVar2.getView());
                    this.grC.add(kVar2);
                }
            }
        }
        if (this.grB.getChildCount() > 0) {
            this.grD.setVisibility(0);
            this.grE.setVisibility(8);
            return;
        }
        this.grD.setVisibility(8);
        this.grE.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        if (kVar != null) {
            this.grB.removeView(kVar.getView());
            this.grC.remove(kVar);
            kVar.onDestory();
            if (ListUtils.isEmpty(this.grC)) {
                this.grD.setVisibility(8);
                this.grE.setVisibility(0);
            }
            this.gsa.dE(this.grC.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gsa.ee(dVar.userId);
        }
    }

    public void bPS() {
        this.grB.removeAllViews();
        Iterator<k> it = this.grC.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.grC.clear();
        this.grD.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        this.gsa.removeView();
        return true;
    }
}
