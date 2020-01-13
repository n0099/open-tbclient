package com.baidu.tieba.ala.liveroom.l;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.data.ag;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.guardclub.l;
/* loaded from: classes2.dex */
public class d {
    private TbPageContext mContext;
    private View mView;
    private TextView textView;

    public d(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        a(this.mContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.h.view_guardclub_im_entry, (ViewGroup) null);
        this.textView = (TextView) this.mView.findViewById(a.g.textView);
        ag bdb = l.bcZ().bdb();
        if (bdb != null && !TextUtils.isEmpty(bdb.aaq)) {
            this.textView.setText(bdb.aaq);
        }
        this.mView.setOnClickListener(onClickListener);
    }

    public View getView() {
        return this.mView;
    }
}
