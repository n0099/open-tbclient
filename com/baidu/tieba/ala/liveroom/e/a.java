package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private long fSv;
    private TextView fSw;
    private TbPageContext mContext;
    private View mView;

    public void dE(long j) {
        if (j > this.fSv) {
            this.fSv = j;
            bAR();
        }
    }

    public void bAQ() {
        this.fSv = 0L;
        bAR();
    }

    private void bAR() {
        this.fSw.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.fSv)));
    }

    public View getView() {
        return this.mView;
    }
}
