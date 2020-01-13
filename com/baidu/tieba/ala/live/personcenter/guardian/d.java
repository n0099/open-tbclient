package com.baidu.tieba.ala.live.personcenter.guardian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class d {
    private LinearLayout eIS;
    private TextView eIT;
    protected Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        initView(bet());
    }

    public View bet() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_guardian_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void initView(View view) {
        this.eIS = (LinearLayout) view.findViewById(a.g.ala_guardian_header_root);
        this.eIT = (TextView) view.findViewById(a.g.ala_guardian_header_title);
    }

    public void ym(String str) {
        this.eIT.setText(str);
    }

    public void a(AlaGuardianListActivity alaGuardianListActivity, int i) {
        alaGuardianListActivity.getLayoutMode().onModeChanged(this.eIS);
    }
}
