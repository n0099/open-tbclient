package com.baidu.tieba.ala.liveroom.tippop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private final List<AlaTopTipView> gJt;
    private final AlaTopTipView.a gJu;
    private com.baidu.live.liveroom.a.a gJv;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.gJt = new LinkedList();
        this.gJu = new AlaTopTipView.a() { // from class: com.baidu.tieba.ala.liveroom.tippop.a.1
            @Override // com.baidu.tieba.ala.liveroom.tippop.AlaTopTipView.a
            public void bR(View view) {
                a.this.gJt.remove(view);
            }
        };
        this.gJv = aVar;
    }

    public void a(ViewGroup viewGroup, String str, int i, boolean z) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
            if (z) {
                alaTopTipView.setDuration(0);
            }
            alaTopTipView.setType(i);
            alaTopTipView.setText(str);
            alaTopTipView.setOnTipCompletedCallback(this.gJu);
            alaTopTipView.n(viewGroup, 0);
            this.gJt.add(alaTopTipView);
        }
    }

    public void a(ViewGroup viewGroup, String str, int i) {
        if (viewGroup != null && !StringUtils.isNull(str)) {
            if (i != 1 || this.gJv == null || this.gJv.ey(9)) {
                AlaTopTipView alaTopTipView = new AlaTopTipView(viewGroup.getContext());
                alaTopTipView.setType(i);
                alaTopTipView.setText(str);
                alaTopTipView.setOnTipCompletedCallback(this.gJu);
                alaTopTipView.n(viewGroup, 0);
                this.gJt.add(alaTopTipView);
            }
        }
    }

    public void bWD() {
        if (!this.gJt.isEmpty()) {
            for (AlaTopTipView alaTopTipView : this.gJt) {
                if (alaTopTipView != null) {
                    alaTopTipView.bWD();
                }
            }
        }
    }

    public boolean uF(int i) {
        if (this.gJt.isEmpty()) {
            return false;
        }
        for (AlaTopTipView alaTopTipView : this.gJt) {
            if (alaTopTipView.getType() == i) {
                return true;
            }
        }
        return false;
    }

    public void uG(int i) {
        for (AlaTopTipView alaTopTipView : this.gJt) {
            if (alaTopTipView.getType() == i) {
                alaTopTipView.fq(true);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BB() {
        super.BB();
        for (AlaTopTipView alaTopTipView : this.gJt) {
            alaTopTipView.fq(false);
        }
        this.gJt.clear();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        for (AlaTopTipView alaTopTipView : this.gJt) {
            alaTopTipView.fq(false);
        }
        this.gJt.clear();
    }
}
