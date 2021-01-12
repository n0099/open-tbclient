package com.baidu.tieba.ala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private final List<AlaTopTipView> hKg;
    private final AlaTopTipView.a hKh;
    private com.baidu.live.liveroom.a.a hKi;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hKg = new LinkedList();
        this.hKh = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void cC(View view) {
                a.this.hKg.remove(view);
            }
        };
        this.hKi = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, int i2) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            alaTopTipView.setDuration(i2);
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.hKh);
            if (i == 2) {
                alaTopTipView.cjF();
            }
            alaTopTipView.v(viewGroup, 0);
            this.hKg.add(alaTopTipView);
        }
    }

    public void c(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hKi == null || this.hKi.dz(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.hKh);
                alaTopTipView.v(viewGroup, 0);
                this.hKg.add(alaTopTipView);
            }
        }
    }

    public void cjG() {
        if (!this.hKg.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.hKg) {
                if (alaTopTipView != null) {
                    alaTopTipView.cjG();
                }
            }
        }
    }

    public boolean vU(int i) {
        if (this.hKg.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.hKg) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void vV(int i) {
        for (AlaTopTipView alaTopTipView : this.hKg) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gE(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void zH() {
        super.zH();
        for (AlaTopTipView alaTopTipView : this.hKg) {
            alaTopTipView.gE(false);
        }
        this.hKg.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.hKg) {
            alaTopTipView.gE(false);
        }
        this.hKg.clear();
    }
}
