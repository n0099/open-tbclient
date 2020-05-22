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
    private final List<AlaTopTipView> geQ;
    private final AlaTopTipView.a geR;
    private com.baidu.live.liveroom.a.a geS;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.geQ = new LinkedList();
        this.geR = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bF(View view) {
                a.this.geQ.remove(view);
            }
        };
        this.geS = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.geR);
            alaTopTipView.m(viewGroup, 0);
            this.geQ.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.geS == null || this.geS.cy(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.geR);
                alaTopTipView.m(viewGroup, 0);
                this.geQ.add(alaTopTipView);
            }
        }
    }

    public void bGq() {
        if (!this.geQ.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.geQ) {
                if (alaTopTipView != null) {
                    alaTopTipView.bGq();
                }
            }
        }
    }

    public boolean rz(int i) {
        if (this.geQ.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.geQ) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void rA(int i) {
        for (AlaTopTipView alaTopTipView : this.geQ) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.eJ(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vm() {
        super.vm();
        for (AlaTopTipView alaTopTipView : this.geQ) {
            alaTopTipView.eJ(false);
        }
        this.geQ.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.geQ) {
            alaTopTipView.eJ(false);
        }
        this.geQ.clear();
    }
}
