package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes10.dex */
public class a {
    private long hwN;
    private TextView hwO;
    private TbPageContext mContext;
    private View mView;

    public void fB(long j) {
        if (j > this.hwN) {
            this.hwN = j;
            cds();
        }
    }

    public void cdr() {
        this.hwN = 0L;
        cds();
    }

    private void cds() {
        this.hwO.setText(String.format(this.mContext.getString(a.h.sdk_charm_name), StringHelper.formatTosepara((int) this.hwN)));
    }

    public View getView() {
        return this.mView;
    }
}
