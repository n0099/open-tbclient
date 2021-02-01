package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes11.dex */
public class a {
    private long hAX;
    private TextView hAY;
    private TbPageContext mContext;
    private View mView;

    public void fG(long j) {
        if (j > this.hAX) {
            this.hAX = j;
            cen();
        }
    }

    public void cem() {
        this.hAX = 0L;
        cen();
    }

    private void cen() {
        this.hAY.setText(String.format(this.mContext.getString(a.h.sdk_charm_name), StringHelper.formatTosepara((int) this.hAX)));
    }

    public View getView() {
        return this.mView;
    }
}
