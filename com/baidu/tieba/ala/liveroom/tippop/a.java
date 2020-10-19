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
    private final List<AlaTopTipView> hbL;
    private final AlaTopTipView.a hbM;
    private com.baidu.live.liveroom.a.a hbN;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hbL = new LinkedList();
        this.hbM = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void ca(View view) {
                a.this.hbL.remove(view);
            }
        };
        this.hbN = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.hbM);
            alaTopTipView.r(viewGroup, 0);
            this.hbL.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hbN == null || this.hbN.eL(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.hbM);
                alaTopTipView.r(viewGroup, 0);
                this.hbL.add(alaTopTipView);
            }
        }
    }

    public void cbL() {
        if (!this.hbL.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.hbL) {
                if (alaTopTipView != null) {
                    alaTopTipView.cbL();
                }
            }
        }
    }

    public boolean vE(int i) {
        if (this.hbL.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.hbL) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void vF(int i) {
        for (AlaTopTipView alaTopTipView : this.hbL) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.fL(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CN() {
        super.CN();
        for (AlaTopTipView alaTopTipView : this.hbL) {
            alaTopTipView.fL(false);
        }
        this.hbL.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.hbL) {
            alaTopTipView.fL(false);
        }
        this.hbL.clear();
    }
}
