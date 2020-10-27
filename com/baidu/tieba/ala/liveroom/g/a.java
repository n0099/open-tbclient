package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes4.dex */
public class a {
    private long hac;
    private TextView had;
    private TbPageContext mContext;
    private View mView;

    public void eB(long j) {
        if (j > this.hac) {
            this.hac = j;
            bYC();
        }
    }

    public void bYB() {
        this.hac = 0L;
        bYC();
    }

    private void bYC() {
        this.had.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.hac)));
    }

    public View getView() {
        return this.mView;
    }
}
