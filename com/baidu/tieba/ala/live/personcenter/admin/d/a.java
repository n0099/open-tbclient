package com.baidu.tieba.ala.live.personcenter.admin.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private TextView bNJ;
    private FrameLayout cSf;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cSf = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.h.sdk_prc_person_adminlist_header, (ViewGroup) null);
        this.bNJ = (TextView) this.cSf.findViewById(a.g.text_user_name);
    }

    public void pS(int i) {
        this.bNJ.setText(this.mPageContext.getResources().getString(a.i.sdk_prc_person_adminlist_header, Integer.valueOf(i)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.bNJ, a.d.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.cSf, a.d.sdk_cp_bg_line_e);
    }

    public FrameLayout ayH() {
        return this.cSf;
    }
}
