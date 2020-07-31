package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private List<com.baidu.live.liveroom.d.d> awp = new LinkedList();
    private AlaLiveRoomPanelTabHost aws;
    private BdUniqueId fFJ;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.fFJ = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.fFJ = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aws = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bzw();
    }

    private void bzw() {
        this.awp.add(new d(this.mPageContext, 0, this.mUserId, this.fFJ));
        this.awp.add(new d(this.mPageContext, 1, this.mUserId, this.fFJ));
        this.aws.setData(this.awp);
    }

    public void a(a.InterfaceC0599a interfaceC0599a) {
        for (com.baidu.live.liveroom.d.d dVar : this.awp) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0599a);
            }
        }
    }

    public void sy(int i) {
        if (this.awp != null && this.aws != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.awp.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.awp.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aws.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void as(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.awp) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).as(str, z);
            }
        }
    }

    public View getView() {
        return this.aws;
    }

    public void enterForeground() {
        this.aws.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.awp) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aws.onChangeSkinType(i);
    }
}
