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
    private final AlaTopTipView.a htA;
    private com.baidu.live.liveroom.a.a htB;
    private final List<AlaTopTipView> htz;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.htz = new LinkedList();
        this.htA = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void cj(View view) {
                a.this.htz.remove(view);
            }
        };
        this.htB = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.htA);
            alaTopTipView.r(viewGroup, 0);
            this.htz.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.htB == null || this.htB.eO(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.htA);
                alaTopTipView.r(viewGroup, 0);
                this.htz.add(alaTopTipView);
            }
        }
    }

    public void chs() {
        if (!this.htz.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.htz) {
                if (alaTopTipView != null) {
                    alaTopTipView.chs();
                }
            }
        }
    }

    public boolean wl(int i) {
        if (this.htz.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.htz) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void wm(int i) {
        for (AlaTopTipView alaTopTipView : this.htz) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gh(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Dm() {
        super.Dm();
        for (AlaTopTipView alaTopTipView : this.htz) {
            alaTopTipView.gh(false);
        }
        this.htz.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.htz) {
            alaTopTipView.gh(false);
        }
        this.htz.clear();
    }
}
