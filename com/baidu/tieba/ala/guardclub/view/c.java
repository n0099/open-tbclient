package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.data.bd;
import com.baidu.live.guardclub.g;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class c {
    private Context mContext;
    private View mView;
    private TextView textView;

    public c(Context context, View.OnClickListener onClickListener) {
        this.mContext = context;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.view_guardclub_im_entry, (ViewGroup) null);
        this.textView = (TextView) this.mView.findViewById(a.g.textView);
        bd Kh = g.Kf().Kh();
        if (Kh != null && !TextUtils.isEmpty(Kh.aNT)) {
            this.textView.setText(Kh.aNT);
        }
        this.mView.setOnClickListener(onClickListener);
    }

    public View getView() {
        return this.mView;
    }
}
