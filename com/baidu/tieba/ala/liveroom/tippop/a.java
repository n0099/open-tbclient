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
    private final List<AlaTopTipView> gxu;
    private final AlaTopTipView.a gxv;
    private com.baidu.live.liveroom.a.a gxw;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.gxu = new LinkedList();
        this.gxv = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bP(View view) {
                a.this.gxu.remove(view);
            }
        };
        this.gxw = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.gxv);
            alaTopTipView.n(viewGroup, 0);
            this.gxu.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.gxw == null || this.gxw.cI(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.gxv);
                alaTopTipView.n(viewGroup, 0);
                this.gxu.add(alaTopTipView);
            }
        }
    }

    public void bMG() {
        if (!this.gxu.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.gxu) {
                if (alaTopTipView != null) {
                    alaTopTipView.bMG();
                }
            }
        }
    }

    public boolean sr(int i) {
        if (this.gxu.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.gxu) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void ss(int i) {
        for (AlaTopTipView alaTopTipView : this.gxu) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.eX(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void wd() {
        super.wd();
        for (AlaTopTipView alaTopTipView : this.gxu) {
            alaTopTipView.eX(false);
        }
        this.gxu.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.gxu) {
            alaTopTipView.eX(false);
        }
        this.gxu.clear();
    }
}
