package com.baidu.tieba.ala.live.personcenter.admin.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes4.dex */
public class a {
    private FrameLayout ail;
    private TextView cKm;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ail = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.g.sdk_prc_person_adminlist_header, (ViewGroup) null);
        this.cKm = (TextView) this.ail.findViewById(a.f.text_user_name);
    }

    public void bJ(int i, int i2) {
        this.cKm.setText(this.mPageContext.getResources().getString(a.h.sdk_prc_person_adminlist_header, String.valueOf(i), String.valueOf(i2)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.cKm, a.c.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.ail, a.c.sdk_cp_bg_line_e);
    }

    public FrameLayout aXu() {
        return this.ail;
    }
}
