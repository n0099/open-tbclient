package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private long eZK;
    private TextView eZL;
    private TbPageContext mContext;
    private View mView;

    public void cV(long j) {
        if (j > this.eZK) {
            this.eZK = j;
            blw();
        }
    }

    public void blv() {
        this.eZK = 0L;
        blw();
    }

    private void blw() {
        this.eZL.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.eZK)));
    }

    public View getView() {
        return this.mView;
    }
}
