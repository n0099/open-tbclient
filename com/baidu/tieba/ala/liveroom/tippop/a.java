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
    private final List<AlaTopTipView> hOS;
    private final AlaTopTipView.a hOT;
    private com.baidu.live.liveroom.a.a hOU;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hOS = new LinkedList();
        this.hOT = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void cy(View view) {
                a.this.hOS.remove(view);
            }
        };
        this.hOU = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, int i2) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            alaTopTipView.setDuration(i2);
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.hOT);
            if (i == 2) {
                alaTopTipView.ckL();
            }
            alaTopTipView.w(viewGroup, 0);
            this.hOS.add(alaTopTipView);
        }
    }

    public void c(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hOU == null || this.hOU.dF(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.hOT);
                alaTopTipView.w(viewGroup, 0);
                this.hOS.add(alaTopTipView);
            }
        }
    }

    public void ckM() {
        if (!this.hOS.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.hOS) {
                if (alaTopTipView != null) {
                    alaTopTipView.ckM();
                }
            }
        }
    }

    public boolean wf(int i) {
        if (this.hOS.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.hOS) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void wg(int i) {
        for (AlaTopTipView alaTopTipView : this.hOS) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gG(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Ar() {
        super.Ar();
        for (AlaTopTipView alaTopTipView : this.hOS) {
            alaTopTipView.gG(false);
        }
        this.hOS.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.hOS) {
            alaTopTipView.gG(false);
        }
        this.hOS.clear();
    }
}
