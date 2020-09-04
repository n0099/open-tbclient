package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private List<com.baidu.live.liveroom.d.d> aBt = new LinkedList();
    private AlaLiveRoomPanelTabHost aBw;
    private BdUniqueId fRe;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.fRe = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.fRe = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aBw = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bIA();
    }

    private void bIA() {
        this.aBt.add(new d(this.mPageContext, 0, this.mUserId, this.fRe));
        this.aBt.add(new d(this.mPageContext, 1, this.mUserId, this.fRe));
        this.aBw.setData(this.aBt);
    }

    public void a(a.InterfaceC0649a interfaceC0649a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aBt) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0649a);
            }
        }
    }

    public void uM(int i) {
        if (this.aBt != null && this.aBw != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aBt.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aBt.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aBw.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aw(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aBt) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aw(str, z);
            }
        }
    }

    public View getView() {
        return this.aBw;
    }

    public void enterForeground() {
        this.aBw.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aBt) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aBw.onChangeSkinType(i);
    }
}
