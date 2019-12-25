package com.baidu.tieba.ala.liveroom.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class c {
    private TextView fdq;
    private TbPageContext mContext;
    private View mView;

    public c(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        a(this.mContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.h.privilege_manager_view_layout, (ViewGroup) null);
        this.fdq = (TextView) this.mView.findViewById(a.g.privilege_manager_txt);
        this.fdq.setText(this.mContext.getResources().getString(a.i.privilege_manager_str));
        this.mView.setOnClickListener(onClickListener);
    }

    public View getView() {
        return this.mView;
    }
}
