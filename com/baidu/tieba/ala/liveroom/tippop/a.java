package com.baidu.tieba.ala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.b;
import com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private final List<AlaTopTipView> eoU;
    private final AlaTopTipView.a eoV;
    private b eoW;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.eoU = new LinkedList();
        this.eoV = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bz(View view) {
                a.this.eoU.remove(view);
            }
        };
        this.eoW = bVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.eoV);
            alaTopTipView.l(viewGroup, 0);
            this.eoU.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.eoW == null || this.eoW.na(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.eoV);
                alaTopTipView.l(viewGroup, 0);
                this.eoU.add(alaTopTipView);
            }
        }
    }

    public void aWf() {
        if (!this.eoU.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.eoU) {
                if (alaTopTipView != null) {
                    alaTopTipView.aWf();
                }
            }
        }
    }

    public boolean oa(int i) {
        if (this.eoU.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.eoU) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void ob(int i) {
        for (AlaTopTipView alaTopTipView : this.eoU) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.cd(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        for (AlaTopTipView alaTopTipView : this.eoU) {
            alaTopTipView.cd(false);
        }
        this.eoU.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.eoU) {
            alaTopTipView.cd(false);
        }
        this.eoU.clear();
    }
}
