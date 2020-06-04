package com.baidu.tieba.ala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private final List<AlaTopTipView> gfb;
    private final AlaTopTipView.a gfc;
    private com.baidu.live.liveroom.a.a gfd;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.gfb = new LinkedList();
        this.gfc = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bF(View view) {
                a.this.gfb.remove(view);
            }
        };
        this.gfd = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.gfc);
            alaTopTipView.m(viewGroup, 0);
            this.gfb.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.gfd == null || this.gfd.cA(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.gfc);
                alaTopTipView.m(viewGroup, 0);
                this.gfb.add(alaTopTipView);
            }
        }
    }

    public void bGs() {
        if (!this.gfb.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.gfb) {
                if (alaTopTipView != null) {
                    alaTopTipView.bGs();
                }
            }
        }
    }

    public boolean rB(int i) {
        if (this.gfb.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.gfb) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void rC(int i) {
        for (AlaTopTipView alaTopTipView : this.gfb) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.eJ(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vm() {
        super.vm();
        for (AlaTopTipView alaTopTipView : this.gfb) {
            alaTopTipView.eJ(false);
        }
        this.gfb.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.gfb) {
            alaTopTipView.eJ(false);
        }
        this.gfb.clear();
    }
}
