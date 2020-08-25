package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes7.dex */
public class a {
    private long gwF;
    private TextView gwG;
    private TbPageContext mContext;
    private View mView;

    public void eg(long j) {
        if (j > this.gwF) {
            this.gwF = j;
            bQN();
        }
    }

    public void bQM() {
        this.gwF = 0L;
        bQN();
    }

    private void bQN() {
        this.gwG.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.gwF)));
    }

    public View getView() {
        return this.mView;
    }
}
