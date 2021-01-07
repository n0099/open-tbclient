package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes11.dex */
public class a {
    private long hBt;
    private TextView hBu;
    private TbPageContext mContext;
    private View mView;

    public void fB(long j) {
        if (j > this.hBt) {
            this.hBt = j;
            chk();
        }
    }

    public void chj() {
        this.hBt = 0L;
        chk();
    }

    private void chk() {
        this.hBu.setText(String.format(this.mContext.getString(a.h.sdk_charm_name), StringHelper.formatTosepara((int) this.hBt)));
    }

    public View getView() {
        return this.mView;
    }
}
