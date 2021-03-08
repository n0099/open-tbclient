package com.baidu.tieba.ala.liveroom.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class c {
    private TextView hrH;
    private TbPageContext mContext;
    private View mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_id_view_layout, (ViewGroup) null);
        this.hrH = (TextView) this.mView.findViewById(a.f.ala_id_txt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fB(long j) {
        if (this.hrH != null) {
            this.hrH.setText(String.format(this.mContext.getString(a.h.sdk_live_id), String.valueOf(j)));
        }
    }

    public View getView() {
        return this.mView;
    }
}
