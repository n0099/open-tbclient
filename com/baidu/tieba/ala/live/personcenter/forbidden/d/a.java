package com.baidu.tieba.ala.live.personcenter.forbidden.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private TextView bpq;
    private FrameLayout csZ;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.csZ = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.h.sdk_prc_person_forbiddenlist_header, (ViewGroup) null);
        this.bpq = (TextView) this.csZ.findViewById(a.g.text_user_name);
    }

    public void pw(int i) {
        this.bpq.setText(this.mPageContext.getResources().getString(a.i.sdk_prc_person_forbiddenlist_header, Integer.valueOf(i)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.bpq, a.d.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.csZ, a.d.sdk_cp_bg_line_e);
    }

    public FrameLayout aqs() {
        return this.csZ;
    }
}
