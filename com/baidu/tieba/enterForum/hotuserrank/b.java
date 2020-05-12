package com.baidu.tieba.enterForum.hotuserrank;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.c;
/* loaded from: classes9.dex */
public class b {
    private TbPageContext duK;
    private c.a gDc;
    private TextView gDd;
    private TextView gDe;
    private String gDf;
    private int gDg;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.gDf)) {
                b.this.duK.showToast(R.string.load_error_retry);
                return;
            }
            ba.aOV().b(b.this.duK, new String[]{b.this.gDf});
            if (b.this.gDg != 0) {
                if (b.this.gDg != 2) {
                    if (b.this.gDg == 1) {
                        an anVar = new an("c13669");
                        anVar.af("obj_locate", 2);
                        TiebaStatic.log(anVar);
                        return;
                    }
                    return;
                }
                an anVar2 = new an("c13658");
                anVar2.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar2.af("obj_locate", 2);
                TiebaStatic.log(anVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.duK = tbPageContext;
        this.mRootView = view;
        this.gDc = new c.a(view.findViewById(R.id.user_view));
        this.gDc.sp(1);
        this.gDd = (TextView) view.findViewById(R.id.get_influence);
        this.gDe = (TextView) view.findViewById(R.id.rank_num);
        this.gDe.setTextSize(0, l.getDimens(this.duK.getPageActivity(), R.dimen.tbfontsize46));
        this.gDd.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.gDH != null && cVar.gDH.gDD != null && !cVar.gDH.gDD.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.gDc.a(cVar.gDH);
            this.gDc.bIQ();
            this.gDf = cVar.gDI;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.gDc.onChangeSkinType(i);
        am.setBackgroundColor(this.gDc.itemView, R.color.cp_bg_line_h);
        am.setViewTextColor(this.gDd, (int) R.color.cp_link_tip_a);
    }

    public void so(int i) {
        this.gDg = i;
    }
}
