package com.baidu.tieba.ala.live.personcenter.forbidden.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes4.dex */
public class a {
    private FrameLayout ajk;
    private TextView cRf;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ajk = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.g.sdk_prc_person_forbiddenlist_header, (ViewGroup) null);
        this.cRf = (TextView) this.ajk.findViewById(a.f.text_user_name);
    }

    public void wd(int i) {
        this.cRf.setText(this.mPageContext.getResources().getString(a.h.sdk_prc_person_forbiddenlist_header, Integer.valueOf(i)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.cRf, a.c.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.ajk, a.c.sdk_cp_bg_line_e);
    }

    public FrameLayout baz() {
        return this.ajk;
    }
}
