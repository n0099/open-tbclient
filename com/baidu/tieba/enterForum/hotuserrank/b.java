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
    private TbPageContext dIF;
    private c.a gRK;
    private TextView gRL;
    private TextView gRM;
    private String gRN;
    private int gRO;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.gRN)) {
                b.this.dIF.showToast(R.string.load_error_retry);
                return;
            }
            ba.aUZ().b(b.this.dIF, new String[]{b.this.gRN});
            if (b.this.gRO != 0) {
                if (b.this.gRO != 2) {
                    if (b.this.gRO == 1) {
                        an anVar = new an("c13669");
                        anVar.ag("obj_locate", 2);
                        TiebaStatic.log(anVar);
                        return;
                    }
                    return;
                }
                an anVar2 = new an("c13658");
                anVar2.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar2.ag("obj_locate", 2);
                TiebaStatic.log(anVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.dIF = tbPageContext;
        this.mRootView = view;
        this.gRK = new c.a(view.findViewById(R.id.user_view));
        this.gRK.sU(1);
        this.gRL = (TextView) view.findViewById(R.id.get_influence);
        this.gRM = (TextView) view.findViewById(R.id.rank_num);
        this.gRM.setTextSize(0, l.getDimens(this.dIF.getPageActivity(), R.dimen.tbfontsize46));
        this.gRL.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.gSq != null && cVar.gSq.gSm != null && !cVar.gSq.gSm.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.gRK.a(cVar.gSq);
            this.gRK.bPj();
            this.gRN = cVar.gSr;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.gRK.onChangeSkinType(i);
        am.setBackgroundColor(this.gRK.itemView, R.color.cp_bg_line_h);
        am.setViewTextColor(this.gRL, (int) R.color.cp_link_tip_a);
    }

    public void sT(int i) {
        this.gRO = i;
    }
}
