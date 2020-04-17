package com.baidu.tieba.ala.live.personcenter.guardian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class d {
    private LinearLayout frQ;
    private TextView frR;
    protected Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        ag(bqc());
    }

    public View bqc() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_guardian_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ag(View view) {
        this.frQ = (LinearLayout) view.findViewById(a.g.ala_guardian_header_root);
        this.frR = (TextView) view.findViewById(a.g.ala_guardian_header_title);
    }

    public void As(String str) {
        this.frR.setText(str);
    }

    public void a(AlaGuardianListActivity alaGuardianListActivity, int i) {
        alaGuardianListActivity.getLayoutMode().onModeChanged(this.frQ);
    }
}
