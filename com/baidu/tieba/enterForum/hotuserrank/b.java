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
/* loaded from: classes21.dex */
public class b {
    private TbPageContext ehG;
    private c.a hEo;
    private TextView hEp;
    private TextView hEq;
    private String hEr;
    private int hEs;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.hEr)) {
                b.this.ehG.showToast(R.string.load_error_retry);
                return;
            }
            be.bkp().b(b.this.ehG, new String[]{b.this.hEr});
            if (b.this.hEs != 0) {
                if (b.this.hEs != 2) {
                    if (b.this.hEs == 1) {
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
        this.ehG = tbPageContext;
        this.mRootView = view;
        this.hEo = new c.a(view.findViewById(R.id.user_view));
        this.hEo.wD(1);
        this.hEp = (TextView) view.findViewById(R.id.get_influence);
        this.hEq = (TextView) view.findViewById(R.id.rank_num);
        this.hEq.setTextSize(0, l.getDimens(this.ehG.getPageActivity(), R.dimen.tbfontsize46));
        this.hEp.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.hET != null && cVar.hET.hEP != null && !cVar.hET.hEP.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.hEo.a(cVar.hET);
            this.hEo.cjl();
            this.hEr = cVar.hEU;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hEo.onChangeSkinType(i);
        ap.setBackgroundColor(this.hEo.itemView, R.color.cp_bg_line_h);
        ap.setViewTextColor(this.hEp, R.color.cp_link_tip_a);
    }

    public void wC(int i) {
        this.hEs = i;
    }
}
