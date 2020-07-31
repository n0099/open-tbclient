package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes4.dex */
public class a {
    private long gkB;
    private TextView gkC;
    private TbPageContext mContext;
    private View mView;

    public void dV(long j) {
        if (j > this.gkB) {
            this.gkB = j;
            bHj();
        }
    }

    public void bHi() {
        this.gkB = 0L;
        bHj();
    }

    private void bHj() {
        this.gkC.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.gkB)));
    }

    public View getView() {
        return this.mView;
    }
}
