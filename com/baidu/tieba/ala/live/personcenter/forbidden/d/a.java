package com.baidu.tieba.ala.live.personcenter.forbidden.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private TextView bWU;
    private FrameLayout ddl;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ddl = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.h.sdk_prc_person_forbiddenlist_header, (ViewGroup) null);
        this.bWU = (TextView) this.ddl.findViewById(a.g.text_user_name);
    }

    public void qw(int i) {
        this.bWU.setText(this.mPageContext.getResources().getString(a.i.sdk_prc_person_forbiddenlist_header, Integer.valueOf(i)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.bWU, a.d.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.ddl, a.d.sdk_cp_bg_line_e);
    }

    public FrameLayout aCz() {
        return this.ddl;
    }
}
