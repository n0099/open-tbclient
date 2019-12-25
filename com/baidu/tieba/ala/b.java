package com.baidu.tieba.ala;

import android.view.View;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements com.baidu.live.liveroom.c.e {
    private int Ws = 1;
    private List<com.baidu.live.liveroom.c.d> mDataList;
    private TbPageContext mPageContext;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uj() {
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
    public String uk() {
        if (this.Ws == 1) {
            return com.baidu.live.r.a.wA().arE.Xz;
        }
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short ul() {
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
