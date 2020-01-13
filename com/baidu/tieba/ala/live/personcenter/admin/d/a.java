package com.baidu.tieba.ala.live.personcenter.admin.d;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes2.dex */
public class a {
    private TextView ble;
    private FrameLayout coW;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.coW = (FrameLayout) tbPageContext.getPageActivity().getLayoutInflater().inflate(a.h.sdk_prc_person_adminlist_header, (ViewGroup) null);
        this.ble = (TextView) this.coW.findViewById(a.g.text_user_name);
    }

    public void pk(int i) {
        this.ble.setText(this.mPageContext.getResources().getString(a.i.sdk_prc_person_adminlist_header, Integer.valueOf(i)));
    }

    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.ble, a.d.sdk_cp_cont_d);
        SkinManager.setBackgroundColor(this.coW, a.d.sdk_cp_bg_line_e);
    }

    public FrameLayout aoc() {
        return this.coW;
    }
}
