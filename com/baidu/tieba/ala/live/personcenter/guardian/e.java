package com.baidu.tieba.ala.live.personcenter.guardian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class e {
    private LinearLayout dSS;
    private TextView dST;
    protected Context mContext;
    private View mRootView;

    public e(Context context) {
        this.mContext = context;
        W(aMx());
    }

    public View aMx() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_guardian_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void W(View view) {
        this.dSS = (LinearLayout) view.findViewById(a.g.ala_guardian_header_root);
        this.dST = (TextView) view.findViewById(a.g.ala_guardian_header_title);
    }

    public void ts(String str) {
        this.dST.setText(str);
    }

    public void a(AlaGuardianListActivity alaGuardianListActivity, int i) {
        alaGuardianListActivity.getLayoutMode().onModeChanged(this.dSS);
    }
}
