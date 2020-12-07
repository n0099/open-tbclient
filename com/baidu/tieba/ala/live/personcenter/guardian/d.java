package com.baidu.tieba.ala.live.personcenter.guardian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d {
    private LinearLayout hax;
    private TextView hay;
    protected Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        an(bYz());
    }

    public View bYz() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_guardian_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void an(View view) {
        this.hax = (LinearLayout) view.findViewById(a.f.ala_guardian_header_root);
        this.hay = (TextView) view.findViewById(a.f.ala_guardian_header_title);
    }

    public void HS(String str) {
        this.hay.setText(str);
    }

    public void a(AlaGuardianListActivity alaGuardianListActivity, int i) {
        alaGuardianListActivity.getLayoutMode().onModeChanged(this.hax);
    }
}
