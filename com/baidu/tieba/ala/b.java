package com.baidu.tieba.ala;

import android.view.View;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.liveroom.d.e {
    private int aqR = 1;
    private List<com.baidu.live.liveroom.d.d> mDataList;
    private TbPageContext mPageContext;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        if (this.mPageContext != null) {
            return this.mPageContext.getString(a.i.ala_rank_list_sub_panel_title);
        }
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String AT() {
        if (this.aqR == 1) {
            return com.baidu.live.v.a.Eo().aQp.asi;
        }
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AU() {
        return (short) 5;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.mDataList != null) {
            for (com.baidu.live.liveroom.d.d dVar : this.mDataList) {
                dVar.onDestroy();
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
