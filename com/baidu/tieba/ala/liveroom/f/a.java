package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes3.dex */
public class a {
    private long gft;
    private TextView gfu;
    private TbPageContext mContext;
    private View mView;

    public void dH(long j) {
        if (j > this.gft) {
            this.gft = j;
            bDX();
        }
    }

    public void bDW() {
        this.gft = 0L;
        bDX();
    }

    private void bDX() {
        this.gfu.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.gft)));
    }

    public View getView() {
        return this.mView;
    }
}
