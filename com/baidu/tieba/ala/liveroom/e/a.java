package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes2.dex */
public class a {
    private long eTW;
    private TextView eTX;
    private TbPageContext mContext;
    private View mView;

    public void cO(long j) {
        if (j > this.eTW) {
            this.eTW = j;
            biS();
        }
    }

    public void biR() {
        this.eTW = 0L;
        biS();
    }

    private void biS() {
        this.eTX.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.eTW)));
    }

    public View getView() {
        return this.mView;
    }
}
