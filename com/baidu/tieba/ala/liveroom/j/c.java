package com.baidu.tieba.ala.liveroom.j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class c {
    private TbPageContext mContext;
    private View mView;
    private TextView textView;

    public c(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        a(this.mContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.g.view_host_letter_entry, (ViewGroup) null);
        this.textView = (TextView) this.mView.findViewById(a.f.textView);
        this.textView.setIncludeFontPadding(false);
        this.mView.setOnClickListener(onClickListener);
    }

    public View getView() {
        return this.mView;
    }
}
