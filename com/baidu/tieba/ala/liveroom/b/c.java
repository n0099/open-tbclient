package com.baidu.tieba.ala.liveroom.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class c {
    private TextView gVc;
    private TbPageContext mContext;
    private View mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_id_view_layout, (ViewGroup) null);
        this.gVc = (TextView) this.mView.findViewById(a.f.ala_id_txt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eS(long j) {
        if (this.gVc != null) {
            this.gVc.setText(String.format(this.mContext.getString(a.h.sdk_live_id), String.valueOf(j)));
        }
    }

    public View getView() {
        return this.mView;
    }
}
