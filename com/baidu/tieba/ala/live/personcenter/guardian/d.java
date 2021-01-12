package com.baidu.tieba.ala.live.personcenter.guardian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class d {
    private LinearLayout hhG;
    private TextView hhH;
    protected Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        ap(bXo());
    }

    public View bXo() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_guardian_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void ap(View view) {
        this.hhG = (LinearLayout) view.findViewById(a.f.ala_guardian_header_root);
        this.hhH = (TextView) view.findViewById(a.f.ala_guardian_header_title);
    }

    public void GG(String str) {
        this.hhH.setText(str);
    }

    public void a(AlaGuardianListActivity alaGuardianListActivity, int i) {
        alaGuardianListActivity.getLayoutMode().onModeChanged(this.hhG);
    }
}
