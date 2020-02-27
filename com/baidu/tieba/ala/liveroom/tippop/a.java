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
    private final List<AlaTopTipView> fkP;
    private final AlaTopTipView.a fkQ;
    private com.baidu.live.liveroom.a.a fkR;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.fkP = new LinkedList();
        this.fkQ = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bB(View view) {
                a.this.fkP.remove(view);
            }
        };
        this.fkR = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.fkQ);
            alaTopTipView.o(viewGroup, 0);
            this.fkP.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.fkR == null || this.fkR.cc(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.fkQ);
                alaTopTipView.o(viewGroup, 0);
                this.fkP.add(alaTopTipView);
            }
        }
    }

    public void bqy() {
        if (!this.fkP.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.fkP) {
                if (alaTopTipView != null) {
                    alaTopTipView.bqy();
                }
            }
        }
    }

    public boolean qC(int i) {
        if (this.fkP.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.fkP) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void qD(int i) {
        for (AlaTopTipView alaTopTipView : this.fkP) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.dt(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
        for (AlaTopTipView alaTopTipView : this.fkP) {
            alaTopTipView.dt(false);
        }
        this.fkP.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.fkP) {
            alaTopTipView.dt(false);
        }
        this.fkP.clear();
    }
}
