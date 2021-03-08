package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes10.dex */
public class a {
    private long hCU;
    private TextView hCV;
    private TbPageContext mContext;
    private View mView;

    public void fG(long j) {
        if (j > this.hCU) {
            this.hCU = j;
            ceA();
        }
    }

    public void cez() {
        this.hCU = 0L;
        ceA();
    }

    private void ceA() {
        this.hCV.setText(String.format(this.mContext.getString(a.h.sdk_charm_name), StringHelper.formatTosepara((int) this.hCU)));
    }

    public View getView() {
        return this.mView;
    }
}
