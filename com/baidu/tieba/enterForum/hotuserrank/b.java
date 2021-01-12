package com.baidu.tieba.enterForum.hotuserrank;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.RankListViewController;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext eSJ;
    private RankListViewController.RankListViewHolder iEY;
    private TextView iEZ;
    private TextView iFa;
    private String iFb;
    private int iFc;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.iFb)) {
                b.this.eSJ.showToast(R.string.load_error_retry);
                return;
            }
            be.bsB().b(b.this.eSJ, new String[]{b.this.iFb});
            if (b.this.iFc != 0) {
                if (b.this.iFc != 2) {
                    if (b.this.iFc == 1) {
                        aq aqVar = new aq("c13669");
                        aqVar.an("obj_locate", 2);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13658");
                aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar2.an("obj_locate", 2);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.eSJ = tbPageContext;
        this.mRootView = view;
        this.iEY = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.iEY.xz(1);
        this.iEZ = (TextView) view.findViewById(R.id.get_influence);
        this.iFa = (TextView) view.findViewById(R.id.rank_num);
        this.iFa.setTextSize(0, l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbfontsize46));
        this.iEZ.setOnClickListener(this.mOnClickListener);
    }

    public void b(c cVar) {
        if (cVar != null && cVar.iFC != null && cVar.iFC.iFy != null && !cVar.iFC.iFy.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.iEY.a(cVar.iFC);
            this.iEY.cvk();
            this.iFb = cVar.iFD;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.iEY.onChangeSkinType(i);
        ao.setBackgroundColor(this.iEY.itemView, R.color.CAM_X0207);
        ao.setViewTextColor(this.iEZ, R.color.CAM_X0302);
    }

    public void xy(int i) {
        this.iFc = i;
    }
}
