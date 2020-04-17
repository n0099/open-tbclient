package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private long fEw;
    private TextView fEx;
    private TbPageContext mContext;
    private View mView;

    public void dD(long j) {
        if (j > this.fEw) {
            this.fEw = j;
            buU();
        }
    }

    public void buT() {
        this.fEw = 0L;
        buU();
    }

    private void buU() {
        this.fEx.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.fEw)));
    }

    public View getView() {
        return this.mView;
    }
}
