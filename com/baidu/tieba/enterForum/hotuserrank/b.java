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
    private TbPageContext efr;
    private c.a hxl;
    private TextView hxm;
    private TextView hxn;
    private String hxo;
    private int hxp;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.hxo)) {
                b.this.efr.showToast(R.string.load_error_retry);
                return;
            }
            be.bju().b(b.this.efr, new String[]{b.this.hxo});
            if (b.this.hxp != 0) {
                if (b.this.hxp != 2) {
                    if (b.this.hxp == 1) {
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
        this.efr = tbPageContext;
        this.mRootView = view;
        this.hxl = new c.a(view.findViewById(R.id.user_view));
        this.hxl.we(1);
        this.hxm = (TextView) view.findViewById(R.id.get_influence);
        this.hxn = (TextView) view.findViewById(R.id.rank_num);
        this.hxn.setTextSize(0, l.getDimens(this.efr.getPageActivity(), R.dimen.tbfontsize46));
        this.hxm.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.hxR != null && cVar.hxR.hxN != null && !cVar.hxR.hxN.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.hxl.a(cVar.hxR);
            this.hxl.cfU();
            this.hxo = cVar.hxS;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hxl.onChangeSkinType(i);
        ap.setBackgroundColor(this.hxl.itemView, R.color.cp_bg_line_h);
        ap.setViewTextColor(this.hxm, R.color.cp_link_tip_a);
    }

    public void wd(int i) {
        this.hxp = i;
    }
}
