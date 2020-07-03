package com.baidu.tieba.ala.live.personcenter.forbidden.d;

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
        this.agu = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.h.sdk_prc_person_forbiddenlist_header, (ViewGroup) null);
        this.cbI = (TextView) this.agu.findViewById(a.g.text_user_name);
    }

    public void qV(int i) {
        this.cbI.setText(this.mPageContext.getResources().getString(a.i.sdk_prc_person_forbiddenlist_header, Integer.valueOf(i)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.cbI, a.d.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.agu, a.d.sdk_cp_bg_line_e);
    }

    public FrameLayout aDF() {
        return this.agu;
    }
}
