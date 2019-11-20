package com.baidu.tieba.ala.liveroom.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes6.dex */
public class a {
    private long eec;
    private TextView eed;
    private TbPageContext mContext;
    private View mView;

    public void ci(long j) {
        if (j > this.eec) {
            this.eec = j;
            aRr();
        }
    }

    public void aRq() {
        this.eec = 0L;
        aRr();
    }

    private void aRr() {
        this.eed.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.eec)));
    }

    public View getView() {
        return this.mView;
    }
}
