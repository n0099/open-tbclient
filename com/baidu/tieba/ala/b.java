package com.baidu.tieba.ala;

import android.view.View;
import com.baidu.live.k.a;
import com.baidu.live.liveroom.c.e;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements e {
    private int Pw = 1;
    private List<com.baidu.live.liveroom.c.d> mDataList;
    private TbPageContext mPageContext;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View ss() {
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
    public String st() {
        if (this.Pw == 1) {
            return com.baidu.live.l.a.uB().ajF.QK;
        }
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short su() {
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
