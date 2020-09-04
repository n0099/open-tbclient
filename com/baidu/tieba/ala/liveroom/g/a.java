package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes7.dex */
public class a {
    private long gwJ;
    private TextView gwK;
    private TbPageContext mContext;
    private View mView;

    public void eg(long j) {
        if (j > this.gwJ) {
            this.gwJ = j;
            bQO();
        }
    }

    public void bQN() {
        this.gwJ = 0L;
        bQO();
    }

    private void bQO() {
        this.gwK.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.gwJ)));
    }

    public View getView() {
        return this.mView;
    }
}
