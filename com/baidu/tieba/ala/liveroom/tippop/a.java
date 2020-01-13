package com.baidu.tieba.ala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.b;
import com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private final List<AlaTopTipView> fhJ;
    private final AlaTopTipView.a fhK;
    private b fhL;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.fhJ = new LinkedList();
        this.fhK = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bB(View view) {
                a.this.fhJ.remove(view);
            }
        };
        this.fhL = bVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.fhK);
            alaTopTipView.o(viewGroup, 0);
            this.fhJ.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.fhL == null || this.fhL.pr(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.fhK);
                alaTopTipView.o(viewGroup, 0);
                this.fhJ.add(alaTopTipView);
            }
        }
    }

    public void boS() {
        if (!this.fhJ.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.fhJ) {
                if (alaTopTipView != null) {
                    alaTopTipView.boS();
                }
            }
        }
    }

    public boolean qv(int i) {
        if (this.fhJ.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.fhJ) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void qw(int i) {
        for (AlaTopTipView alaTopTipView : this.fhJ) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.dm(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oZ() {
        super.oZ();
        for (AlaTopTipView alaTopTipView : this.fhJ) {
            alaTopTipView.dm(false);
        }
        this.fhJ.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.fhJ) {
            alaTopTipView.dm(false);
        }
        this.fhJ.clear();
    }
}
