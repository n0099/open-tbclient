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
    private final List<AlaTopTipView> fkQ;
    private final AlaTopTipView.a fkR;
    private com.baidu.live.liveroom.a.a fkS;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.fkQ = new LinkedList();
        this.fkR = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bB(View view) {
                a.this.fkQ.remove(view);
            }
        };
        this.fkS = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.fkR);
            alaTopTipView.o(viewGroup, 0);
            this.fkQ.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.fkS == null || this.fkS.cc(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.fkR);
                alaTopTipView.o(viewGroup, 0);
                this.fkQ.add(alaTopTipView);
            }
        }
    }

    public void bqA() {
        if (!this.fkQ.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.fkQ) {
                if (alaTopTipView != null) {
                    alaTopTipView.bqA();
                }
            }
        }
    }

    public boolean qC(int i) {
        if (this.fkQ.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.fkQ) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void qD(int i) {
        for (AlaTopTipView alaTopTipView : this.fkQ) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.dt(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
        for (AlaTopTipView alaTopTipView : this.fkQ) {
            alaTopTipView.dt(false);
        }
        this.fkQ.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.fkQ) {
            alaTopTipView.dt(false);
        }
        this.fkQ.clear();
    }
}
