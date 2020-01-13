package com.baidu.tieba.ala;

import android.view.View;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements com.baidu.live.liveroom.c.e {
    private int WL = 1;
    private List<com.baidu.live.liveroom.c.d> mDataList;
    private TbPageContext mPageContext;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uA() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        if (this.mPageContext != null) {
            return this.mPageContext.getString(a.i.ala_rank_list_sub_panel_title);
        }
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uB() {
        if (this.WL == 1) {
            return com.baidu.live.s.a.wR().asq.XS;
        }
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short uC() {
        return (short) 5;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        if (this.mDataList != null) {
            for (com.baidu.live.liveroom.c.d dVar : this.mDataList) {
                dVar.onDestroy();
            }
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
    }
}
