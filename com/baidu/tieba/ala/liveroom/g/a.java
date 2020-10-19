package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes4.dex */
public class a {
    private long gOo;
    private TextView gOp;
    private TbPageContext mContext;
    private View mView;

    public void ez(long j) {
        if (j > this.gOo) {
            this.gOo = j;
            bVD();
        }
    }

    public void bVC() {
        this.gOo = 0L;
        bVD();
    }

    private void bVD() {
        this.gOp.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.gOo)));
    }

    public View getView() {
        return this.mView;
    }
}
