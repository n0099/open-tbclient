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
    private final List<AlaTopTipView> flC;
    private final AlaTopTipView.a flD;
    private com.baidu.live.liveroom.a.a flE;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.flC = new LinkedList();
        this.flD = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bB(View view) {
                a.this.flC.remove(view);
            }
        };
        this.flE = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.flD);
            alaTopTipView.o(viewGroup, 0);
            this.flC.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.flE == null || this.flE.cc(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.flD);
                alaTopTipView.o(viewGroup, 0);
                this.flC.add(alaTopTipView);
            }
        }
    }

    public void bqG() {
        if (!this.flC.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.flC) {
                if (alaTopTipView != null) {
                    alaTopTipView.bqG();
                }
            }
        }
    }

    public boolean qE(int i) {
        if (this.flC.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.flC) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void qF(int i) {
        for (AlaTopTipView alaTopTipView : this.flC) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.du(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pP() {
        super.pP();
        for (AlaTopTipView alaTopTipView : this.flC) {
            alaTopTipView.du(false);
        }
        this.flC.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.flC) {
            alaTopTipView.du(false);
        }
        this.flC.clear();
    }
}
