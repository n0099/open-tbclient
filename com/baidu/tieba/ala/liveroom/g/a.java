package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes4.dex */
public class a {
    private long hpv;
    private TextView hpw;
    private TbPageContext mContext;
    private View mView;

    public void fB(long j) {
        if (j > this.hpv) {
            this.hpv = j;
            ces();
        }
    }

    public void cer() {
        this.hpv = 0L;
        ces();
    }

    private void ces() {
        this.hpw.setText(String.format(this.mContext.getString(a.h.sdk_charm_name), StringHelper.formatTosepara((int) this.hpv)));
    }

    public View getView() {
        return this.mView;
    }
}
