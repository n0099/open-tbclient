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
    private final List<AlaTopTipView> gMO;
    private final AlaTopTipView.a gMP;
    private com.baidu.live.liveroom.a.a gMQ;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.gMO = new LinkedList();
        this.gMP = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bW(View view) {
                a.this.gMO.remove(view);
            }
        };
        this.gMQ = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.gMP);
            alaTopTipView.p(viewGroup, 0);
            this.gMO.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.gMQ == null || this.gMQ.eC(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.gMP);
                alaTopTipView.p(viewGroup, 0);
                this.gMO.add(alaTopTipView);
            }
        }
    }

    public void bYl() {
        if (!this.gMO.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.gMO) {
                if (alaTopTipView != null) {
                    alaTopTipView.bYl();
                }
            }
        }
    }

    public boolean uY(int i) {
        if (this.gMO.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.gMO) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void uZ(int i) {
        for (AlaTopTipView alaTopTipView : this.gMO) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.fp(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BQ() {
        super.BQ();
        for (AlaTopTipView alaTopTipView : this.gMO) {
            alaTopTipView.fp(false);
        }
        this.gMO.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.gMO) {
            alaTopTipView.fp(false);
        }
        this.gMO.clear();
    }
}
