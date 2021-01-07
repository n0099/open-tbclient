package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private List<com.baidu.live.liveroom.d.d> aHo = new LinkedList();
    private AlaLiveRoomPanelTabHost aHr;
    private BdUniqueId gQC;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.gQC = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.gQC = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aHr = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bXd();
    }

    private void bXd() {
        this.aHo.add(new d(this.mPageContext, 0, this.mUserId, this.gQC));
        this.aHo.add(new d(this.mPageContext, 1, this.mUserId, this.gQC));
        this.aHr.setData(this.aHo);
    }

    public void a(a.InterfaceC0699a interfaceC0699a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aHo) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0699a);
            }
        }
    }

    public void xI(int i) {
        if (this.aHo != null && this.aHr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aHo.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aHo.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aHr.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aE(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aHo) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aE(str, z);
            }
        }
    }

    public View getView() {
        return this.aHr;
    }

    public void enterForeground() {
        this.aHr.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aHo) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aHr.onChangeSkinType(i);
    }
}
