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
    private String fnb;
    private ImageView hkB;
    private LinearLayout hkC;
    private LinearLayout hkD;
    private LinearLayout hkE;
    private LinkedList<k> hkF;
    private LinearLayout hkG;
    private TextView hkH;

    public c(Context context, n nVar, String str) {
        super(context, nVar);
        this.hkF = new LinkedList<>();
        this.fnb = str;
        this.hkB = (ImageView) this.mRootView.findViewById(a.f.desc_imageView);
        this.hkC = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_enrty_random_entry);
        this.hkD = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_enrty_direct_entry);
        this.hkB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.ae.a.RB().brA.aNx;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.fnb;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.fnb;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.hkC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hle != null) {
                    c.this.hle.cdB();
                }
            }
        });
        this.hkD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hle != null) {
                    c.this.hle.cdD();
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
                if (c.this.hle != null) {
                    c.this.hle.cdE();
                }
            }
        });
        this.hkE = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_wait_user_container);
        this.hkG = (LinearLayout) this.mRootView.findViewById(a.f.ala_challenge_direct_challenger_layout);
        this.hkH = (TextView) this.mRootView.findViewById(a.f.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void QM() {
        super.QM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cB(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.aIj + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.hkG.setVisibility(8);
            this.hkH.setVisibility(0);
            cdu();
            this.hle.ec(this.hkF.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<k> it = this.hkF.iterator();
        while (it.hasNext()) {
            k next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.cdO()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                this.hkE.removeView(kVar.getView());
                this.hkF.remove(kVar);
                kVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<k> it3 = this.hkF.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                k next2 = it3.next();
                if (dVar3.equals(next2.cdO())) {
                    if (dVar3.aIj != next2.cdO().aIj) {
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
                    this.hkE.addView(kVar2.getView());
                    this.hkF.add(kVar2);
                }
            }
        }
        if (this.hkE.getChildCount() > 0) {
            this.hkG.setVisibility(0);
            this.hkH.setVisibility(8);
            return;
        }
        this.hkG.setVisibility(8);
        this.hkH.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        if (kVar != null) {
            this.hkE.removeView(kVar.getView());
            this.hkF.remove(kVar);
            kVar.onDestory();
            if (ListUtils.isEmpty(this.hkF)) {
                this.hkG.setVisibility(8);
                this.hkH.setVisibility(0);
            }
            this.hle.ec(this.hkF.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hle.fy(dVar.userId);
        }
    }

    public void cdu() {
        this.hkE.removeAllViews();
        Iterator<k> it = this.hkF.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.hkF.clear();
        this.hkG.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        this.hle.removeView();
        return true;
    }
}
