package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private List<com.baidu.live.liveroom.c.d> TW = new LinkedList();
    private AlaLiveRoomPanelTabHost TZ;
    private BdUniqueId erl;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.erl = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.erl = bdUniqueId;
        initView();
    }

    public void initView() {
        this.TZ = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bbo();
    }

    private void bbo() {
        this.TW.add(new d(this.mPageContext, 0, this.mUserId, this.erl));
        this.TW.add(new d(this.mPageContext, 1, this.mUserId, this.erl));
        this.TZ.setData(this.TW);
    }

    public void a(a.InterfaceC0462a interfaceC0462a) {
        for (com.baidu.live.liveroom.c.d dVar : this.TW) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0462a);
            }
        }
    }

    public void qx(int i) {
        if (this.TW != null && this.TZ != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.TW.size()) {
                    com.baidu.live.liveroom.c.d dVar = this.TW.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.TZ.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void Z(String str, boolean z) {
        for (com.baidu.live.liveroom.c.d dVar : this.TW) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).Z(str, z);
            }
        }
    }

    public View getView() {
        return this.TZ;
    }

    public void enterForeground() {
        this.TZ.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.c.d dVar : this.TW) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.TZ.onChangeSkinType(i);
    }
}
