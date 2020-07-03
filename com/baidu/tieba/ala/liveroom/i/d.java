package com.baidu.tieba.ala.liveroom.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.coreextra.view.CircleProgressView;
/* loaded from: classes3.dex */
public class d {
    private CircleProgressView ghw;
    private TextView ghx;
    PendantChildView ghy;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_apk_downloading_view_layout, (ViewGroup) null);
        this.ghy = new PendantChildView(context) { // from class: com.baidu.tieba.ala.liveroom.i.d.1
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalFullPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public int getPriority() {
                return 35;
            }
        };
        this.ghy.addView(this.mRootView);
        this.ghw = (CircleProgressView) this.mRootView.findViewById(a.g.apk_download_progress);
        this.ghx = (TextView) this.mRootView.findViewById(a.g.apk_download_progress_text);
        this.mRootView.setBackgroundResource(a.f.sdk_black_oval_shape_alpha50);
        this.ghw.setCircleForegroundColor(context.getResources().getColor(a.d.sdk_white_alpha100));
        this.ghw.setCircleBackgroundColor(context.getResources().getColor(a.d.sdk_black_alpha100));
        this.ghw.setWidth(context.getResources().getDimensionPixelSize(a.e.sdk_ds4));
    }

    public PendantChildView bEx() {
        return this.ghy;
    }

    public void kY(boolean z) {
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
        this.ghw.setProgress(i);
        this.ghx.setText(i + "%");
    }
}
