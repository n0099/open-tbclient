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
/* loaded from: classes22.dex */
public class b {
    private TbPageContext eIc;
    private c.a ilI;
    private TextView ilJ;
    private TextView ilK;
    private String ilL;
    private int ilM;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.ilL)) {
                b.this.eIc.showToast(R.string.load_error_retry);
                return;
            }
            be.brr().b(b.this.eIc, new String[]{b.this.ilL});
            if (b.this.ilM != 0) {
                if (b.this.ilM != 2) {
                    if (b.this.ilM == 1) {
                        aq aqVar = new aq("c13669");
                        aqVar.al("obj_locate", 2);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13658");
                aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar2.al("obj_locate", 2);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.eIc = tbPageContext;
        this.mRootView = view;
        this.ilI = new c.a(view.findViewById(R.id.user_view));
        this.ilI.xP(1);
        this.ilJ = (TextView) view.findViewById(R.id.get_influence);
        this.ilK = (TextView) view.findViewById(R.id.rank_num);
        this.ilK.setTextSize(0, l.getDimens(this.eIc.getPageActivity(), R.dimen.tbfontsize46));
        this.ilJ.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.imn != null && cVar.imn.imj != null && !cVar.imn.imj.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.ilI.a(cVar.imn);
            this.ilI.csp();
            this.ilL = cVar.imo;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.ilI.onChangeSkinType(i);
        ap.setBackgroundColor(this.ilI.itemView, R.color.cp_bg_line_h);
        ap.setViewTextColor(this.ilJ, R.color.cp_link_tip_a);
    }

    public void xO(int i) {
        this.ilM = i;
    }
}
