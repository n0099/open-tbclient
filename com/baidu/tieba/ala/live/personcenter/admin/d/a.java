package com.baidu.tieba.ala.live.personcenter.admin.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes10.dex */
public class a {
    private FrameLayout akl;
    private TextView cVd;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.akl = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.g.sdk_prc_person_adminlist_header, (ViewGroup) null);
        this.cVd = (TextView) this.akl.findViewById(a.f.text_user_name);
    }

    public void bL(int i, int i2) {
        this.cVd.setText(this.mPageContext.getResources().getString(a.h.sdk_prc_person_adminlist_header, String.valueOf(i), String.valueOf(i2)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.cVd, a.c.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.akl, a.c.sdk_cp_bg_line_e);
    }

    public FrameLayout aZo() {
        return this.akl;
    }
}
