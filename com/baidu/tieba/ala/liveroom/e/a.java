package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private long eZw;
    private TextView eZx;
    private TbPageContext mContext;
    private View mView;

    public void cV(long j) {
        if (j > this.eZw) {
            this.eZw = j;
            blt();
        }
    }

    public void bls() {
        this.eZw = 0L;
        blt();
    }

    private void blt() {
        this.eZx.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.eZw)));
    }

    public View getView() {
        return this.mView;
    }
}
