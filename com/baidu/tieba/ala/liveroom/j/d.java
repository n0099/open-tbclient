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
/* loaded from: classes4.dex */
public class d {
    private CircleProgressView hcG;
    private TextView hcH;
    PendantChildView hcI;
    private Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(context).inflate(a.h.ala_apk_downloading_view_layout, (ViewGroup) null);
        this.hcI = new PendantChildView(context) { // from class: com.baidu.tieba.ala.liveroom.j.d.1
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
        this.hcI.addView(this.mRootView);
        this.hcG = (CircleProgressView) this.mRootView.findViewById(a.g.apk_download_progress);
        this.hcH = (TextView) this.mRootView.findViewById(a.g.apk_download_progress_text);
        this.mRootView.setBackgroundResource(a.f.sdk_black_oval_shape_alpha50);
        this.hcG.setCircleForegroundColor(context.getResources().getColor(a.d.sdk_white_alpha100));
        this.hcG.setCircleBackgroundColor(context.getResources().getColor(a.d.sdk_black_alpha100));
        this.hcG.setWidth(context.getResources().getDimensionPixelSize(a.e.sdk_ds4));
    }

    public PendantChildView bZw() {
        return this.hcI;
    }

    public void nb(boolean z) {
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
        this.hcG.setProgress(i);
        this.hcH.setText(i + "%");
    }
}
