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
    private final List<AlaTopTipView> eod;
    private final AlaTopTipView.a eoe;
    private b eof;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.eod = new LinkedList();
        this.eoe = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bz(View view) {
                a.this.eod.remove(view);
            }
        };
        this.eof = bVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.eoe);
            alaTopTipView.l(viewGroup, 0);
            this.eod.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.eof == null || this.eof.mZ(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.eoe);
                alaTopTipView.l(viewGroup, 0);
                this.eod.add(alaTopTipView);
            }
        }
    }

    public void aWd() {
        if (!this.eod.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.eod) {
                if (alaTopTipView != null) {
                    alaTopTipView.aWd();
                }
            }
        }
    }

    public boolean nZ(int i) {
        if (this.eod.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.eod) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void oa(int i) {
        for (AlaTopTipView alaTopTipView : this.eod) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.cd(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        for (AlaTopTipView alaTopTipView : this.eod) {
            alaTopTipView.cd(false);
        }
        this.eod.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.eod) {
            alaTopTipView.cd(false);
        }
        this.eod.clear();
    }
}
