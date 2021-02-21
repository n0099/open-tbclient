package com.baidu.tieba.ala.live.personcenter.guardian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class d {
    private LinearLayout hmk;
    private TextView hml;
    protected Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_guardian_header, (ViewGroup) null);
        }
        am(this.mRootView);
    }

    public View bYv() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_guardian_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void am(View view) {
        this.hmk = (LinearLayout) view.findViewById(a.f.ala_guardian_header_root);
        this.hml = (TextView) view.findViewById(a.f.ala_guardian_header_title);
    }

    public void Hm(String str) {
        this.hml.setText(str);
    }

    public void a(AlaGuardianListActivity alaGuardianListActivity, int i) {
        alaGuardianListActivity.getLayoutMode().onModeChanged(this.hmk);
    }
}
