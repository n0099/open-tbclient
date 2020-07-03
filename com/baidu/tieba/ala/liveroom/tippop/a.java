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
    private final List<AlaTopTipView> grX;
    private final AlaTopTipView.a grY;
    private com.baidu.live.liveroom.a.a grZ;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.grX = new LinkedList();
        this.grY = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bJ(View view) {
                a.this.grX.remove(view);
            }
        };
        this.grZ = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.grY);
            alaTopTipView.n(viewGroup, 0);
            this.grX.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.grZ == null || this.grZ.cG(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.grY);
                alaTopTipView.n(viewGroup, 0);
                this.grX.add(alaTopTipView);
            }
        }
    }

    public void bJz() {
        if (!this.grX.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.grX) {
                if (alaTopTipView != null) {
                    alaTopTipView.bJz();
                }
            }
        }
    }

    public boolean rZ(int i) {
        if (this.grX.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.grX) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void sa(int i) {
        for (AlaTopTipView alaTopTipView : this.grX) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.eO(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vH() {
        super.vH();
        for (AlaTopTipView alaTopTipView : this.grX) {
            alaTopTipView.eO(false);
        }
        this.grX.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.grX) {
            alaTopTipView.eO(false);
        }
        this.grX.clear();
    }
}
