package com.baidu.tieba.ala.liveroom.j;

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
    private CircleProgressView hDH;
    private TextView hDI;
    PendantChildView hDJ;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.g.ala_apk_downloading_view_layout, (ViewGroup) null);
        this.hDJ = new PendantChildView(context) { // from class: com.baidu.tieba.ala.liveroom.j.d.1
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
        this.hDJ.addView(this.mRootView);
        this.hDH = (CircleProgressView) this.mRootView.findViewById(a.f.apk_download_progress);
        this.hDI = (TextView) this.mRootView.findViewById(a.f.apk_download_progress_text);
        this.mRootView.setBackgroundResource(a.e.sdk_black_oval_shape_alpha50);
        this.hDH.setCircleForegroundColor(context.getResources().getColor(a.c.sdk_white_alpha100));
        this.hDH.setCircleBackgroundColor(context.getResources().getColor(a.c.sdk_black_alpha100));
        this.hDH.setWidth(context.getResources().getDimensionPixelSize(a.d.sdk_ds4));
    }

    public PendantChildView cib() {
        return this.hDJ;
    }

    public void og(boolean z) {
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
        this.hDH.setProgress(i);
        this.hDI.setText(i + "%");
    }
}
