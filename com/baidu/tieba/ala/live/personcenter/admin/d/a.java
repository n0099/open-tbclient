package com.baidu.tieba.ala.live.personcenter.admin.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes6.dex */
public class a {
    private TextView aLN;
    private FrameLayout bEf;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bEf = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.h.sdk_prc_person_adminlist_header, (ViewGroup) null);
        this.aLN = (TextView) this.bEf.findViewById(a.g.text_user_name);
    }

    public void mT(int i) {
        this.aLN.setText(this.mPageContext.getResources().getString(a.i.sdk_prc_person_adminlist_header, Integer.valueOf(i)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.aLN, a.d.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.bEf, a.d.sdk_cp_bg_line_e);
    }

    public FrameLayout Yr() {
        return this.bEf;
    }
}
