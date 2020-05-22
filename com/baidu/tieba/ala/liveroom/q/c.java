package com.baidu.tieba.ala.liveroom.q;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c {
    private TextView gdb;
    private TbPageContext mContext;
    private View mView;

    public c(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        a(this.mContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.h.privilege_manager_view_layout, (ViewGroup) null);
        this.gdb = (TextView) this.mView.findViewById(a.g.privilege_manager_txt);
        this.gdb.setText(this.mContext.getResources().getString(a.i.privilege_manager_str));
        this.mView.setOnClickListener(onClickListener);
    }

    public View getView() {
        return this.mView;
    }
}
