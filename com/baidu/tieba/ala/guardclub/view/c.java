package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.data.ao;
import com.baidu.live.guardclub.g;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c {
    private Context mContext;
    private View mView;
    private TextView textView;

    public c(Context context, View.OnClickListener onClickListener) {
        this.mContext = context;
        r(onClickListener);
    }

    private void r(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.view_guardclub_im_entry, (ViewGroup) null);
        this.textView = (TextView) this.mView.findViewById(a.g.textView);
        ao BJ = g.BH().BJ();
        if (BJ != null && !TextUtils.isEmpty(BJ.aAb)) {
            this.textView.setText(BJ.aAb);
        }
        this.mView.setOnClickListener(onClickListener);
    }

    public View getView() {
        return this.mView;
    }
}
