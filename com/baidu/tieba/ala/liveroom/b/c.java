package com.baidu.tieba.ala.liveroom.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c {
    private TextView eQm;
    private TbPageContext mContext;
    private View mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_id_view_layout, (ViewGroup) null);
        this.eQm = (TextView) this.mView.findViewById(a.g.ala_id_txt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cR(long j) {
        if (this.eQm != null) {
            this.eQm.setText(String.format(this.mContext.getString(a.i.sdk_live_id), String.valueOf(j)));
        }
    }

    public View getView() {
        return this.mView;
    }
}
