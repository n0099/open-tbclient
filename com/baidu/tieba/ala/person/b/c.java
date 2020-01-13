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
    private List<com.baidu.live.liveroom.c.d> Un = new LinkedList();
    private AlaLiveRoomPanelTabHost Uq;
    private BdUniqueId esx;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.esx = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.esx = bdUniqueId;
        initView();
    }

    public void initView() {
        this.Uq = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bbJ();
    }

    private void bbJ() {
        this.Un.add(new d(this.mPageContext, 0, this.mUserId, this.esx));
        this.Un.add(new d(this.mPageContext, 1, this.mUserId, this.esx));
        this.Uq.setData(this.Un);
    }

    public void a(a.InterfaceC0466a interfaceC0466a) {
        for (com.baidu.live.liveroom.c.d dVar : this.Un) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0466a);
            }
        }
    }

    public void qC(int i) {
        if (this.Un != null && this.Uq != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.Un.size()) {
                    com.baidu.live.liveroom.c.d dVar = this.Un.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.Uq.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void Z(String str, boolean z) {
        for (com.baidu.live.liveroom.c.d dVar : this.Un) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).Z(str, z);
            }
        }
    }

    public View getView() {
        return this.Uq;
    }

    public void enterForeground() {
        this.Uq.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.c.d dVar : this.Un) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.Uq.onChangeSkinType(i);
    }
}
