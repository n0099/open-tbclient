package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes4.dex */
public class a {
    private long gzV;
    private TextView gzW;
    private TbPageContext mContext;
    private View mView;

    public void ej(long j) {
        if (j > this.gzV) {
            this.gzV = j;
            bSk();
        }
    }

    public void bSj() {
        this.gzV = 0L;
        bSk();
    }

    private void bSk() {
        this.gzW.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.gzV)));
    }

    public View getView() {
        return this.mView;
    }
}
