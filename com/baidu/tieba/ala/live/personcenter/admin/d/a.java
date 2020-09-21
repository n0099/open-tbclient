package com.baidu.tieba.ala.live.personcenter.admin.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes4.dex */
public class a {
    private FrameLayout ahP;
    private TextView clp;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ahP = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.h.sdk_prc_person_adminlist_header, (ViewGroup) null);
        this.clp = (TextView) this.ahP.findViewById(a.g.text_user_name);
    }

    public void bH(int i, int i2) {
        this.clp.setText(this.mPageContext.getResources().getString(a.i.sdk_prc_person_adminlist_header, String.valueOf(i), String.valueOf(i2)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.clp, a.d.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.ahP, a.d.sdk_cp_bg_line_e);
    }

    public FrameLayout aQZ() {
        return this.ahP;
    }
}
