package com.baidu.tieba.ala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private final List<AlaTopTipView> htg;
    private final AlaTopTipView.a hth;
    private com.baidu.live.liveroom.a.a hti;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.htg = new LinkedList();
        this.hth = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void cm(View view) {
                a.this.htg.remove(view);
            }
        };
        this.hti = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.hth);
            alaTopTipView.r(viewGroup, 0);
            this.htg.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hti == null || this.hti.eK(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.hth);
                alaTopTipView.r(viewGroup, 0);
                this.htg.add(alaTopTipView);
            }
        }
    }

    public void cgL() {
        if (!this.htg.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.htg) {
                if (alaTopTipView != null) {
                    alaTopTipView.cgL();
                }
            }
        }
    }

    public boolean wJ(int i) {
        if (this.htg.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.htg) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void wK(int i) {
        for (AlaTopTipView alaTopTipView : this.htg) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gk(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CD() {
        super.CD();
        for (AlaTopTipView alaTopTipView : this.htg) {
            alaTopTipView.gk(false);
        }
        this.htg.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.htg) {
            alaTopTipView.gk(false);
        }
        this.htg.clear();
    }
}
