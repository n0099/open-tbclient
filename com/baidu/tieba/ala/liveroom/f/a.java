package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes11.dex */
public class a {
    private long hBl;
    private TextView hBm;
    private TbPageContext mContext;
    private View mView;

    public void fG(long j) {
        if (j > this.hBl) {
            this.hBl = j;
            ceu();
        }
    }

    public void cet() {
        this.hBl = 0L;
        ceu();
    }

    private void ceu() {
        this.hBm.setText(String.format(this.mContext.getString(a.h.sdk_charm_name), StringHelper.formatTosepara((int) this.hBl)));
    }

    public View getView() {
        return this.mView;
    }
}
