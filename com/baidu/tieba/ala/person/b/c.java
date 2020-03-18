package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private List<com.baidu.live.liveroom.d.d> Wh = new LinkedList();
    private AlaLiveRoomPanelTabHost Wk;
    private BdUniqueId exr;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.exr = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.exr = bdUniqueId;
        initView();
    }

    private void initView() {
        this.Wk = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        beg();
    }

    private void beg() {
        this.Wh.add(new d(this.mPageContext, 0, this.mUserId, this.exr));
        this.Wh.add(new d(this.mPageContext, 1, this.mUserId, this.exr));
        this.Wk.setData(this.Wh);
    }

    public void a(a.InterfaceC0474a interfaceC0474a) {
        for (com.baidu.live.liveroom.d.d dVar : this.Wh) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0474a);
            }
        }
    }

    public void qL(int i) {
        if (this.Wh != null && this.Wk != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.Wh.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.Wh.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.Wk.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void Z(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.Wh) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).Z(str, z);
            }
        }
    }

    public View getView() {
        return this.Wk;
    }

    public void enterForeground() {
        this.Wk.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.Wh) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.Wk.onChangeSkinType(i);
    }
}
