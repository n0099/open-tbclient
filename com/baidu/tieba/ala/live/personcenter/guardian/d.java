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
    private LinearLayout eMN;
    private TextView eMO;
    protected Context mContext;
    private View mRootView;

    public d(Context context) {
        this.mContext = context;
        initView(bgF());
    }

    public View bgF() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_guardian_header, (ViewGroup) null);
        }
        return this.mRootView;
    }

    private void initView(View view) {
        this.eMN = (LinearLayout) view.findViewById(a.g.ala_guardian_header_root);
        this.eMO = (TextView) view.findViewById(a.g.ala_guardian_header_title);
    }

    public void yI(String str) {
        this.eMO.setText(str);
    }

    public void a(AlaGuardianListActivity alaGuardianListActivity, int i) {
        alaGuardianListActivity.getLayoutMode().onModeChanged(this.eMN);
    }
}
