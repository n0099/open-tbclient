package com.baidu.tieba.ala.live.personcenter.guardian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class d {
    private LinearLayout giD;
    private TextView giE;
    protected Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        ak(bLA());
    }

    public View bLA() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_guardian_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ak(View view) {
        this.giD = (LinearLayout) view.findViewById(a.g.ala_guardian_header_root);
        this.giE = (TextView) view.findViewById(a.g.ala_guardian_header_title);
    }

    public void FJ(String str) {
        this.giE.setText(str);
    }

    public void a(AlaGuardianListActivity alaGuardianListActivity, int i) {
        alaGuardianListActivity.getLayoutMode().onModeChanged(this.giD);
    }
}
