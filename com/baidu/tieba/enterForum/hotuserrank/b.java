package com.baidu.tieba.enterForum.hotuserrank;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.c;
/* loaded from: classes16.dex */
public class b {
    private TbPageContext efn;
    private c.a hxf;
    private TextView hxg;
    private TextView hxh;
    private String hxi;
    private int hxj;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.hxi)) {
                b.this.efn.showToast(R.string.load_error_retry);
                return;
            }
            be.bju().b(b.this.efn, new String[]{b.this.hxi});
            if (b.this.hxj != 0) {
                if (b.this.hxj != 2) {
                    if (b.this.hxj == 1) {
                        aq aqVar = new aq("c13669");
                        aqVar.ai("obj_locate", 2);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13658");
                aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar2.ai("obj_locate", 2);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.efn = tbPageContext;
        this.mRootView = view;
        this.hxf = new c.a(view.findViewById(R.id.user_view));
        this.hxf.we(1);
        this.hxg = (TextView) view.findViewById(R.id.get_influence);
        this.hxh = (TextView) view.findViewById(R.id.rank_num);
        this.hxh.setTextSize(0, l.getDimens(this.efn.getPageActivity(), R.dimen.tbfontsize46));
        this.hxg.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.hxL != null && cVar.hxL.hxH != null && !cVar.hxL.hxH.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.hxf.a(cVar.hxL);
            this.hxf.cfT();
            this.hxi = cVar.hxM;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hxf.onChangeSkinType(i);
        ap.setBackgroundColor(this.hxf.itemView, R.color.cp_bg_line_h);
        ap.setViewTextColor(this.hxg, R.color.cp_link_tip_a);
    }

    public void wd(int i) {
        this.hxj = i;
    }
}
