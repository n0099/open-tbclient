package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes6.dex */
public class a {
    private long eeT;
    private TextView eeU;
    private TbPageContext mContext;
    private View mView;

    public void cj(long j) {
        if (j > this.eeT) {
            this.eeT = j;
            aRt();
        }
    }

    public void aRs() {
        this.eeT = 0L;
        aRt();
    }

    private void aRt() {
        this.eeU.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.eeT)));
    }

    public View getView() {
        return this.mView;
    }
}
