package com.baidu.tieba.ala.live.personcenter.admin.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes3.dex */
public class a {
    private FrameLayout agu;
    private TextView cbI;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.agu = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.h.sdk_prc_person_adminlist_header, (ViewGroup) null);
        this.cbI = (TextView) this.agu.findViewById(a.g.text_user_name);
    }

    public void bw(int i, int i2) {
        this.cbI.setText(this.mPageContext.getResources().getString(a.i.sdk_prc_person_adminlist_header, String.valueOf(i), String.valueOf(i2)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.cbI, a.d.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.agu, a.d.sdk_cp_bg_line_e);
    }

    public FrameLayout aDF() {
        return this.agu;
    }
}
