package com.baidu.tieba.ala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private final List<AlaTopTipView> hOE;
    private final AlaTopTipView.a hOF;
    private com.baidu.live.liveroom.a.a hOG;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hOE = new LinkedList();
        this.hOF = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void cy(View view) {
                a.this.hOE.remove(view);
            }
        };
        this.hOG = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, int i2) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            alaTopTipView.setDuration(i2);
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.hOF);
            if (i == 2) {
                alaTopTipView.ckE();
            }
            alaTopTipView.w(viewGroup, 0);
            this.hOE.add(alaTopTipView);
        }
    }

    public void c(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hOG == null || this.hOG.dF(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.hOF);
                alaTopTipView.w(viewGroup, 0);
                this.hOE.add(alaTopTipView);
            }
        }
    }

    public void ckF() {
        if (!this.hOE.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.hOE) {
                if (alaTopTipView != null) {
                    alaTopTipView.ckF();
                }
            }
        }
    }

    public boolean wf(int i) {
        if (this.hOE.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.hOE) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void wg(int i) {
        for (AlaTopTipView alaTopTipView : this.hOE) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gG(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Ar() {
        super.Ar();
        for (AlaTopTipView alaTopTipView : this.hOE) {
            alaTopTipView.gG(false);
        }
        this.hOE.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.hOE) {
            alaTopTipView.gG(false);
        }
        this.hOE.clear();
    }
}
