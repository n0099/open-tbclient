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
/* loaded from: classes11.dex */
public class d {
    private CircleProgressView hDm;
    private TextView hDn;
    PendantChildView hDo;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.g.ala_apk_downloading_view_layout, (ViewGroup) null);
        this.hDo = new PendantChildView(context) { // from class: com.baidu.tieba.ala.liveroom.i.d.1
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalBBChattingPosition() {
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
        this.hDo.addView(this.mRootView);
        this.hDm = (CircleProgressView) this.mRootView.findViewById(a.f.apk_download_progress);
        this.hDn = (TextView) this.mRootView.findViewById(a.f.apk_download_progress_text);
        this.mRootView.setBackgroundResource(a.e.sdk_black_oval_shape_alpha50);
        this.hDm.setCircleForegroundColor(context.getResources().getColor(a.c.sdk_white_alpha100));
        this.hDm.setCircleBackgroundColor(context.getResources().getColor(a.c.sdk_black_alpha100));
        this.hDm.setWidth(context.getResources().getDimensionPixelSize(a.d.sdk_ds4));
    }

    public PendantChildView cff() {
        return this.hDo;
    }

    public void on(boolean z) {
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
        this.hDm.setProgress(i);
        this.hDn.setText(i + "%");
    }
}
