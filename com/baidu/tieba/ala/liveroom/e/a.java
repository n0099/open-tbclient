package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private long eZx;
    private TextView eZy;
    private TbPageContext mContext;
    private View mView;

    public void cV(long j) {
        if (j > this.eZx) {
            this.eZx = j;
            blv();
        }
    }

    public void blu() {
        this.eZx = 0L;
        blv();
    }

    private void blv() {
        this.eZy.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.eZx)));
    }

    public View getView() {
        return this.mView;
    }
}
