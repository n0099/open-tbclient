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
    private final List<AlaTopTipView> hCK;
    private final AlaTopTipView.a hCL;
    private com.baidu.live.liveroom.a.a hCM;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hCK = new LinkedList();
        this.hCL = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void ct(View view) {
                a.this.hCK.remove(view);
            }
        };
        this.hCM = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.hCL);
            alaTopTipView.r(viewGroup, 0);
            this.hCK.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.hCM == null || this.hCM.fh(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.hCL);
                alaTopTipView.r(viewGroup, 0);
                this.hCK.add(alaTopTipView);
            }
        }
    }

    public void ckF() {
        if (!this.hCK.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.hCK) {
                if (alaTopTipView != null) {
                    alaTopTipView.ckF();
                }
            }
        }
    }

    public boolean xo(int i) {
        if (this.hCK.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.hCK) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void xp(int i) {
        for (AlaTopTipView alaTopTipView : this.hCK) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.gz(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void En() {
        super.En();
        for (AlaTopTipView alaTopTipView : this.hCK) {
            alaTopTipView.gz(false);
        }
        this.hCK.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.hCK) {
            alaTopTipView.gz(false);
        }
        this.hCK.clear();
    }
}
