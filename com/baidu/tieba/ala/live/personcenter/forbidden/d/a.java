package com.baidu.tieba.ala.live.personcenter.forbidden.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes4.dex */
public class a {
    private FrameLayout aii;
    private TextView cLW;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aii = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.g.sdk_prc_person_forbiddenlist_header, (ViewGroup) null);
        this.cLW = (TextView) this.aii.findViewById(a.f.text_user_name);
    }

    public void uY(int i) {
        this.cLW.setText(this.mPageContext.getResources().getString(a.h.sdk_prc_person_forbiddenlist_header, Integer.valueOf(i)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.cLW, a.c.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.aii, a.c.sdk_cp_bg_line_e);
    }

    public FrameLayout aYc() {
        return this.aii;
    }
}
