package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private long fSG;
    private TextView fSH;
    private TbPageContext mContext;
    private View mView;

    public void dE(long j) {
        if (j > this.fSG) {
            this.fSG = j;
            bAT();
        }
    }

    public void bAS() {
        this.fSG = 0L;
        bAT();
    }

    private void bAT() {
        this.fSH.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.fSG)));
    }

    public View getView() {
        return this.mView;
    }
}
