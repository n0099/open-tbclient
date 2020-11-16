package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes4.dex */
public class a {
    private long hfN;
    private TextView hfO;
    private TbPageContext mContext;
    private View mView;

    public void eX(long j) {
        if (j > this.hfN) {
            this.hfN = j;
            cax();
        }
    }

    public void caw() {
        this.hfN = 0L;
        cax();
    }

    private void cax() {
        this.hfO.setText(String.format(this.mContext.getString(a.h.sdk_charm_name), StringHelper.formatTosepara((int) this.hfN)));
    }

    public View getView() {
        return this.mView;
    }
}
