package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes4.dex */
public class a {
    private long hpx;
    private TextView hpy;
    private TbPageContext mContext;
    private View mView;

    public void fB(long j) {
        if (j > this.hpx) {
            this.hpx = j;
            cet();
        }
    }

    public void ces() {
        this.hpx = 0L;
        cet();
    }

    private void cet() {
        this.hpy.setText(String.format(this.mContext.getString(a.h.sdk_charm_name), StringHelper.formatTosepara((int) this.hpx)));
    }

    public View getView() {
        return this.mView;
    }
}
