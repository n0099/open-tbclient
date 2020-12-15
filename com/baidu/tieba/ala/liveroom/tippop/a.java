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
    private final List<AlaTopTipView> hCM;
    private final AlaTopTipView.a hCN;
    private com.baidu.live.liveroom.a.a hCO;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hCM = new LinkedList();
        this.hCN = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void ct(View view) {
                a.this.hCM.remove(view);
            }
        };
        this.hCO = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.hCN);
            alaTopTipView.r(viewGroup, 0);
            this.hCM.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hCO == null || this.hCO.fh(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.hCN);
                alaTopTipView.r(viewGroup, 0);
                this.hCM.add(alaTopTipView);
            }
        }
    }

    public void ckG() {
        if (!this.hCM.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.hCM) {
                if (alaTopTipView != null) {
                    alaTopTipView.ckG();
                }
            }
        }
    }

    public boolean xo(int i) {
        if (this.hCM.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.hCM) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void xp(int i) {
        for (AlaTopTipView alaTopTipView : this.hCM) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gz(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void En() {
        super.En();
        for (AlaTopTipView alaTopTipView : this.hCM) {
            alaTopTipView.gz(false);
        }
        this.hCM.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.hCM) {
            alaTopTipView.gz(false);
        }
        this.hCM.clear();
    }
}
