package com.baidu.tieba.ala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.b;
import com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private final List<AlaTopTipView> feD;
    private final AlaTopTipView.a feE;
    private b feF;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.feD = new LinkedList();
        this.feE = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bw(View view) {
                a.this.feD.remove(view);
            }
        };
        this.feF = bVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.feE);
            alaTopTipView.o(viewGroup, 0);
            this.feD.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.feF == null || this.feF.pq(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.feE);
                alaTopTipView.o(viewGroup, 0);
                this.feD.add(alaTopTipView);
            }
        }
    }

    public void bnS() {
        if (!this.feD.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.feD) {
                if (alaTopTipView != null) {
                    alaTopTipView.bnS();
                }
            }
        }
    }

    public boolean qq(int i) {
        if (this.feD.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.feD) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void qr(int i) {
        for (AlaTopTipView alaTopTipView : this.feD) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.dh(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oS() {
        super.oS();
        for (AlaTopTipView alaTopTipView : this.feD) {
            alaTopTipView.dh(false);
        }
        this.feD.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.feD) {
            alaTopTipView.dh(false);
        }
        this.feD.clear();
    }
}
