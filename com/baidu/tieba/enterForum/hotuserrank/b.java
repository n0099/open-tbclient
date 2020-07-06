package com.baidu.tieba.enterForum.hotuserrank;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.c;
/* loaded from: classes9.dex */
public class b {
    private TbPageContext dPv;
    private c.a heE;
    private TextView heF;
    private TextView heG;
    private String heH;
    private int heI;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.heH)) {
                b.this.dPv.showToast(R.string.load_error_retry);
                return;
            }
            bc.aWU().b(b.this.dPv, new String[]{b.this.heH});
            if (b.this.heI != 0) {
                if (b.this.heI != 2) {
                    if (b.this.heI == 1) {
                        ao aoVar = new ao("c13669");
                        aoVar.ag("obj_locate", 2);
                        TiebaStatic.log(aoVar);
                        return;
                    }
                    return;
                }
                ao aoVar2 = new ao("c13658");
                aoVar2.s("uid", TbadkCoreApplication.getCurrentAccountId());
                aoVar2.ag("obj_locate", 2);
                TiebaStatic.log(aoVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.dPv = tbPageContext;
        this.mRootView = view;
        this.heE = new c.a(view.findViewById(R.id.user_view));
        this.heE.tx(1);
        this.heF = (TextView) view.findViewById(R.id.get_influence);
        this.heG = (TextView) view.findViewById(R.id.rank_num);
        this.heG.setTextSize(0, l.getDimens(this.dPv.getPageActivity(), R.dimen.tbfontsize46));
        this.heF.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.hfk != null && cVar.hfk.hfg != null && !cVar.hfk.hfg.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.heE.a(cVar.hfk);
            this.heE.bSp();
            this.heH = cVar.hfl;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.heE.onChangeSkinType(i);
        an.setBackgroundColor(this.heE.itemView, R.color.cp_bg_line_h);
        an.setViewTextColor(this.heF, (int) R.color.cp_link_tip_a);
    }

    public void tw(int i) {
        this.heI = i;
    }
}
