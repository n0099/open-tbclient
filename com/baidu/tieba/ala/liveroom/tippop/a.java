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
    private final List<AlaTopTipView> fQa;
    private final AlaTopTipView.a fQb;
    private com.baidu.live.liveroom.a.a fQc;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.fQa = new LinkedList();
        this.fQb = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bG(View view) {
                a.this.fQa.remove(view);
            }
        };
        this.fQc = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.fQb);
            alaTopTipView.o(viewGroup, 0);
            this.fQa.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.fQc == null || this.fQc.cr(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.fQb);
                alaTopTipView.o(viewGroup, 0);
                this.fQa.add(alaTopTipView);
            }
        }
    }

    public void bAf() {
        if (!this.fQa.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.fQa) {
                if (alaTopTipView != null) {
                    alaTopTipView.bAf();
                }
            }
        }
    }

    public boolean qX(int i) {
        if (this.fQa.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.fQa) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void qY(int i) {
        for (AlaTopTipView alaTopTipView : this.fQa) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.eq(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ug() {
        super.ug();
        for (AlaTopTipView alaTopTipView : this.fQa) {
            alaTopTipView.eq(false);
        }
        this.fQa.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.fQa) {
            alaTopTipView.eq(false);
        }
        this.fQa.clear();
    }
}
