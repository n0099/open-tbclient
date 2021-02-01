package com.baidu.tieba.enterForum.hotuserrank;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.RankListViewController;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext eUY;
    private RankListViewController.RankListViewHolder iKH;
    private TextView iKI;
    private TextView iKJ;
    private String iKK;
    private int iKL;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.iKK)) {
                b.this.eUY.showToast(R.string.load_error_retry);
                return;
            }
            bf.bsV().b(b.this.eUY, new String[]{b.this.iKK});
            if (b.this.iKL != 0) {
                if (b.this.iKL != 2) {
                    if (b.this.iKL == 1) {
                        ar arVar = new ar("c13669");
                        arVar.ap("obj_locate", 2);
                        TiebaStatic.log(arVar);
                        return;
                    }
                    return;
                }
                ar arVar2 = new ar("c13658");
                arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar2.ap("obj_locate", 2);
                TiebaStatic.log(arVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.mRootView = view;
        this.iKH = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.iKH.xJ(1);
        this.iKI = (TextView) view.findViewById(R.id.get_influence);
        this.iKJ = (TextView) view.findViewById(R.id.rank_num);
        this.iKJ.setTextSize(0, l.getDimens(this.eUY.getPageActivity(), R.dimen.tbfontsize46));
        this.iKI.setOnClickListener(this.mOnClickListener);
    }

    public void b(c cVar) {
        if (cVar != null && cVar.iLl != null && cVar.iLl.iLh != null && !cVar.iLl.iLh.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.iKH.a(cVar.iLl);
            this.iKH.cww();
            this.iKK = cVar.iLm;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.iKH.onChangeSkinType(i);
        ap.setBackgroundColor(this.iKH.itemView, R.color.CAM_X0207);
        ap.setViewTextColor(this.iKI, R.color.CAM_X0302);
    }

    public void xI(int i) {
        this.iKL = i;
    }
}
