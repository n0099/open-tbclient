package com.baidu.tieba.ala.liveroom.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.tbadk.coreextra.view.CircleProgressView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class d {
    private CircleProgressView fGs;
    private TextView fGt;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_apk_downloading_view_layout, (ViewGroup) null);
        this.fGs = (CircleProgressView) this.mRootView.findViewById(a.g.apk_download_progress);
        this.fGt = (TextView) this.mRootView.findViewById(a.g.apk_download_progress_text);
        this.mRootView.setBackgroundResource(a.f.sdk_black_oval_shape_alpha50);
        this.fGs.setCircleForegroundColor(context.getResources().getColor(a.d.sdk_white_alpha100));
        this.fGs.setCircleBackgroundColor(context.getResources().getColor(a.d.sdk_black_alpha100));
        this.fGs.setWidth(context.getResources().getDimensionPixelSize(a.e.sdk_ds4));
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void ks(boolean z) {
        if (z) {
            this.mRootView.setAlpha(0.5f);
        } else {
            this.mRootView.setAlpha(1.0f);
        }
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.fGs.setProgress(i);
        this.fGt.setText(i + "%");
    }
}
