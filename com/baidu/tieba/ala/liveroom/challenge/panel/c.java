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
    private String faC;
    private ImageView gVh;
    private LinearLayout gVi;
    private LinearLayout gVj;
    private LinearLayout gVk;
    private LinkedList<k> gVl;
    private LinearLayout gVm;
    private TextView gVn;

    public c(Context context, n nVar, String str) {
        super(context, nVar);
        this.gVl = new LinkedList<>();
        this.faC = str;
        this.gVh = (ImageView) this.mRootView.findViewById(a.g.desc_imageView);
        this.gVi = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_random_entry);
        this.gVj = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_enrty_direct_entry);
        this.gVh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str2 = com.baidu.live.z.a.Pq().bmJ.aLn;
                if (!StringUtils.isNull(str2)) {
                    if (!str2.contains("?")) {
                        str2 = str2 + "?id=" + c.this.faC;
                    } else if (!str2.contains("&id=")) {
                        str2 = str2 + "&id=" + c.this.faC;
                    }
                    BrowserHelper.startInternalWebActivity(c.this.mContext, str2);
                }
            }
        });
        this.gVi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gVK != null) {
                    c.this.gVK.bXL();
                }
            }
        });
        this.gVj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gVK != null) {
                    c.this.gVK.bXN();
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
                if (c.this.gVK != null) {
                    c.this.gVK.bXO();
                }
            }
        });
        this.gVk = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_wait_user_container);
        this.gVm = (LinearLayout) this.mRootView.findViewById(a.g.ala_challenge_direct_challenger_layout);
        this.gVn = (TextView) this.mRootView.findViewById(a.g.ala_challenge_no_challenge_tip);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_panel_entry_layout, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bXB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void OC() {
        super.OC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cp(List<com.baidu.live.challenge.d> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.live.challenge.d dVar : list) {
                if ((dVar.aGw + 60) - (System.currentTimeMillis() / 1000) < 0) {
                    arrayList.add(dVar);
                }
            }
            list.removeAll(arrayList);
        }
        if (ListUtils.isEmpty(list)) {
            this.gVm.setVisibility(8);
            this.gVn.setVisibility(0);
            bXE();
            this.gVK.dN(this.gVl.size());
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<k> it = this.gVl.iterator();
        while (it.hasNext()) {
            k next = it.next();
            boolean z2 = false;
            for (com.baidu.live.challenge.d dVar2 : list) {
                z2 = dVar2.equals(next.bXY()) ? true : z2;
            }
            if (!z2) {
                linkedList.add(next);
            }
        }
        if (!ListUtils.isEmpty(linkedList)) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                this.gVk.removeView(kVar.getView());
                this.gVl.remove(kVar);
                kVar.onDestory();
            }
        }
        for (com.baidu.live.challenge.d dVar3 : list) {
            Iterator<k> it3 = this.gVl.iterator();
            boolean z3 = false;
            while (it3.hasNext()) {
                k next2 = it3.next();
                if (dVar3.equals(next2.bXY())) {
                    if (dVar3.aGw != next2.bXY().aGw) {
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
                    this.gVk.addView(kVar2.getView());
                    this.gVl.add(kVar2);
                }
            }
        }
        if (this.gVk.getChildCount() > 0) {
            this.gVm.setVisibility(0);
            this.gVn.setVisibility(8);
            return;
        }
        this.gVm.setVisibility(8);
        this.gVn.setVisibility(0);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        if (kVar != null) {
            this.gVk.removeView(kVar.getView());
            this.gVl.remove(kVar);
            kVar.onDestory();
            if (ListUtils.isEmpty(this.gVl)) {
                this.gVm.setVisibility(8);
                this.gVn.setVisibility(0);
            }
            this.gVK.dN(this.gVl.size());
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gVK.ey(dVar.userId);
        }
    }

    public void bXE() {
        this.gVk.removeAllViews();
        Iterator<k> it = this.gVl.iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.gVl.clear();
        this.gVm.setVisibility(8);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        this.gVK.removeView();
        return true;
    }
}
