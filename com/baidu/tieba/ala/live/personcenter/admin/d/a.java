package com.baidu.tieba.ala.live.personcenter.admin.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes7.dex */
public class a {
    private FrameLayout ahv;
    private TextView cjo;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ahv = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.h.sdk_prc_person_adminlist_header, (ViewGroup) null);
        this.cjo = (TextView) this.ahv.findViewById(a.g.text_user_name);
    }

    public void bH(int i, int i2) {
        this.cjo.setText(this.mPageContext.getResources().getString(a.i.sdk_prc_person_adminlist_header, String.valueOf(i), String.valueOf(i2)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.cjo, a.d.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.ahv, a.d.sdk_cp_bg_line_e);
    }

    public FrameLayout aQn() {
        return this.ahv;
    }
}
