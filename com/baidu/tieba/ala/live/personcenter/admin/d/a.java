package com.baidu.tieba.ala.live.personcenter.admin.d;

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
        this.ddl = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.h.sdk_prc_person_adminlist_header, (ViewGroup) null);
        this.bWU = (TextView) this.ddl.findViewById(a.g.text_user_name);
    }

    public void bs(int i, int i2) {
        this.bWU.setText(this.mPageContext.getResources().getString(a.i.sdk_prc_person_adminlist_header, String.valueOf(i), String.valueOf(i2)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.bWU, a.d.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.ddl, a.d.sdk_cp_bg_line_e);
    }

    public FrameLayout aCz() {
        return this.ddl;
    }
}
