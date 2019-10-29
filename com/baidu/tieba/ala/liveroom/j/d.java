package com.baidu.tieba.ala.liveroom.j;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.data.z;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.guardclub.m;
/* loaded from: classes6.dex */
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
        z aLz = m.aLx().aLz();
        if (aLz != null && !TextUtils.isEmpty(aLz.TG)) {
            this.textView.setText(aLz.TG);
        }
        this.mView.setOnClickListener(onClickListener);
    }

    public View getView() {
        return this.mView;
    }
}
