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
    private LinearLayout glK;
    private TextView glL;
    protected Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        am(bMK());
    }

    public View bMK() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_guardian_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void am(View view) {
        this.glK = (LinearLayout) view.findViewById(a.g.ala_guardian_header_root);
        this.glL = (TextView) view.findViewById(a.g.ala_guardian_header_title);
    }

    public void Gg(String str) {
        this.glL.setText(str);
    }

    public void a(AlaGuardianListActivity alaGuardianListActivity, int i) {
        alaGuardianListActivity.getLayoutMode().onModeChanged(this.glK);
    }
}
