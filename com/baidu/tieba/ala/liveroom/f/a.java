package com.baidu.tieba.ala.liveroom.f;

import android.view.View;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes2.dex */
public class a {
    private long eVF;
    private TextView eVG;
    private TbPageContext mContext;
    private View mView;

    public void cT(long j) {
        if (j > this.eVF) {
            this.eVF = j;
            bjE();
        }
    }

    public void bjD() {
        this.eVF = 0L;
        bjE();
    }

    private void bjE() {
        this.eVG.setText(String.format(this.mContext.getString(a.i.sdk_charm_name), StringHelper.formatTosepara((int) this.eVF)));
    }

    public View getView() {
        return this.mView;
    }
}
