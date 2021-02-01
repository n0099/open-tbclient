package com.baidu.tieba.ala.live.personcenter.forbidden.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes11.dex */
public class a {
    private FrameLayout aiT;
    private TextView cTD;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aiT = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.g.sdk_prc_person_forbiddenlist_header, (ViewGroup) null);
        this.cTD = (TextView) this.aiT.findViewById(a.f.text_user_name);
    }

    public void uS(int i) {
        this.cTD.setText(this.mPageContext.getResources().getString(a.h.sdk_prc_person_forbiddenlist_header, Integer.valueOf(i)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.cTD, a.c.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.aiT, a.c.sdk_cp_bg_line_e);
    }

    public FrameLayout aZl() {
        return this.aiT;
    }
}
