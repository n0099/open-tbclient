package com.baidu.tieba.enterForum.hotuserrank;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.c;
/* loaded from: classes16.dex */
public class b {
    private TbPageContext dVN;
    private c.a hko;
    private TextView hkp;
    private TextView hkq;
    private String hkr;
    private int hks;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.hkr)) {
                b.this.dVN.showToast(R.string.load_error_retry);
                return;
            }
            bd.baV().b(b.this.dVN, new String[]{b.this.hkr});
            if (b.this.hks != 0) {
                if (b.this.hks != 2) {
                    if (b.this.hks == 1) {
                        ap apVar = new ap("c13669");
                        apVar.ah("obj_locate", 2);
                        TiebaStatic.log(apVar);
                        return;
                    }
                    return;
                }
                ap apVar2 = new ap("c13658");
                apVar2.t("uid", TbadkCoreApplication.getCurrentAccountId());
                apVar2.ah("obj_locate", 2);
                TiebaStatic.log(apVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.dVN = tbPageContext;
        this.mRootView = view;
        this.hko = new c.a(view.findViewById(R.id.user_view));
        this.hko.tP(1);
        this.hkp = (TextView) view.findViewById(R.id.get_influence);
        this.hkq = (TextView) view.findViewById(R.id.rank_num);
        this.hkq.setTextSize(0, l.getDimens(this.dVN.getPageActivity(), R.dimen.tbfontsize46));
        this.hkp.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.hkU != null && cVar.hkU.hkQ != null && !cVar.hkU.hkQ.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.hko.a(cVar.hkU);
            this.hko.bVG();
            this.hkr = cVar.hkV;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hko.onChangeSkinType(i);
        ao.setBackgroundColor(this.hko.itemView, R.color.cp_bg_line_h);
        ao.setViewTextColor(this.hkp, R.color.cp_link_tip_a);
    }

    public void tO(int i) {
        this.hks = i;
    }
}
