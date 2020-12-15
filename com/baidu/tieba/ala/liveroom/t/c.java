package com.baidu.tieba.ala.liveroom.t;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class c {
    private TextView hBI;
    private TbPageContext mContext;
    private View mView;

    public c(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        a(this.mContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.g.privilege_manager_view_layout, (ViewGroup) null);
        this.hBI = (TextView) this.mView.findViewById(a.f.privilege_manager_txt);
        this.hBI.setText(this.mContext.getResources().getString(a.h.privilege_manager_str));
        this.mView.setOnClickListener(onClickListener);
    }

    public View getView() {
        return this.mView;
    }
}
