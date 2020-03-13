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
    private final List<AlaTopTipView> fld;
    private final AlaTopTipView.a fle;
    private com.baidu.live.liveroom.a.a flf;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.fld = new LinkedList();
        this.fle = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bB(View view) {
                a.this.fld.remove(view);
            }
        };
        this.flf = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.fle);
            alaTopTipView.o(viewGroup, 0);
            this.fld.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.flf == null || this.flf.cc(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.fle);
                alaTopTipView.o(viewGroup, 0);
                this.fld.add(alaTopTipView);
            }
        }
    }

    public void bqB() {
        if (!this.fld.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.fld) {
                if (alaTopTipView != null) {
                    alaTopTipView.bqB();
                }
            }
        }
    }

    public boolean qC(int i) {
        if (this.fld.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.fld) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void qD(int i) {
        for (AlaTopTipView alaTopTipView : this.fld) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.dt(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
        for (AlaTopTipView alaTopTipView : this.fld) {
            alaTopTipView.dt(false);
        }
        this.fld.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.fld) {
            alaTopTipView.dt(false);
        }
        this.fld.clear();
    }
}
