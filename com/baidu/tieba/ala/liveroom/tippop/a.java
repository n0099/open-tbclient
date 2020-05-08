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
    private final List<AlaTopTipView> fQf;
    private final AlaTopTipView.a fQg;
    private com.baidu.live.liveroom.a.a fQh;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.fQf = new LinkedList();
        this.fQg = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bG(View view) {
                a.this.fQf.remove(view);
            }
        };
        this.fQh = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.fQg);
            alaTopTipView.o(viewGroup, 0);
            this.fQf.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.fQh == null || this.fQh.cr(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.fQg);
                alaTopTipView.o(viewGroup, 0);
                this.fQf.add(alaTopTipView);
            }
        }
    }

    public void bAd() {
        if (!this.fQf.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.fQf) {
                if (alaTopTipView != null) {
                    alaTopTipView.bAd();
                }
            }
        }
    }

    public boolean qX(int i) {
        if (this.fQf.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.fQf) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void qY(int i) {
        for (AlaTopTipView alaTopTipView : this.fQf) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.eq(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void uf() {
        super.uf();
        for (AlaTopTipView alaTopTipView : this.fQf) {
            alaTopTipView.eq(false);
        }
        this.fQf.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.fQf) {
            alaTopTipView.eq(false);
        }
        this.fQf.clear();
    }
}
