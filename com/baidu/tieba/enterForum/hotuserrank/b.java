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
    private TbPageContext eXu;
    private RankListViewController.RankListViewHolder iJF;
    private TextView iJG;
    private TextView iJH;
    private String iJI;
    private int iJJ;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.iJI)) {
                b.this.eXu.showToast(R.string.load_error_retry);
                return;
            }
            be.bwu().b(b.this.eXu, new String[]{b.this.iJI});
            if (b.this.iJJ != 0) {
                if (b.this.iJJ != 2) {
                    if (b.this.iJJ == 1) {
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
        this.eXu = tbPageContext;
        this.mRootView = view;
        this.iJF = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.iJF.zf(1);
        this.iJG = (TextView) view.findViewById(R.id.get_influence);
        this.iJH = (TextView) view.findViewById(R.id.rank_num);
        this.iJH.setTextSize(0, l.getDimens(this.eXu.getPageActivity(), R.dimen.tbfontsize46));
        this.iJG.setOnClickListener(this.mOnClickListener);
    }

    public void b(c cVar) {
        if (cVar != null && cVar.iKj != null && cVar.iKj.iKf != null && !cVar.iKj.iKf.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.iJF.a(cVar.iKj);
            this.iJF.czb();
            this.iJI = cVar.iKk;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.iJF.onChangeSkinType(i);
        ao.setBackgroundColor(this.iJF.itemView, R.color.CAM_X0207);
        ao.setViewTextColor(this.iJG, R.color.CAM_X0302);
    }

    public void ze(int i) {
        this.iJJ = i;
    }
}
