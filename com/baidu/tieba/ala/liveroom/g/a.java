package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes4.dex */
public class a {
    private long hgg;
    private TextView hgh;
    private TbPageContext mContext;
    private View mView;

    public void eX(long j) {
        if (j > this.hgg) {
            this.hgg = j;
            cbe();
        }
    }

    public void cbd() {
        this.hgg = 0L;
        cbe();
    }

    private void cbe() {
        this.hgh.setText(String.format(this.mContext.getString(a.h.sdk_charm_name), StringHelper.formatTosepara((int) this.hgg)));
    }

    public View getView() {
        return this.mView;
    }
}
