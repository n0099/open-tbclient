package com.baidu.tieba.ala.liveroom;

import android.view.ViewGroup;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public abstract class a {
    TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void ao(ViewGroup viewGroup) {
    }

    public void vm() {
    }

    public void onDestroy() {
    }
}
