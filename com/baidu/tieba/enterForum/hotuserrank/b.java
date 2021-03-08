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
    private TbPageContext eWx;
    private RankListViewController.RankListViewHolder iME;
    private TextView iMF;
    private TextView iMG;
    private String iMH;
    private int iMI;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.iMH)) {
                b.this.eWx.showToast(R.string.load_error_retry);
                return;
            }
            bf.bsY().b(b.this.eWx, new String[]{b.this.iMH});
            if (b.this.iMI != 0) {
                if (b.this.iMI != 2) {
                    if (b.this.iMI == 1) {
                        ar arVar = new ar("c13669");
                        arVar.aq("obj_locate", 2);
                        TiebaStatic.log(arVar);
                        return;
                    }
                    return;
                }
                ar arVar2 = new ar("c13658");
                arVar2.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar2.aq("obj_locate", 2);
                TiebaStatic.log(arVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.eWx = tbPageContext;
        this.mRootView = view;
        this.iME = new RankListViewController.RankListViewHolder(view.findViewById(R.id.user_view));
        this.iME.xK(1);
        this.iMF = (TextView) view.findViewById(R.id.get_influence);
        this.iMG = (TextView) view.findViewById(R.id.rank_num);
        this.iMG.setTextSize(0, l.getDimens(this.eWx.getPageActivity(), R.dimen.tbfontsize46));
        this.iMF.setOnClickListener(this.mOnClickListener);
    }

    public void b(c cVar) {
        if (cVar != null && cVar.iNi != null && cVar.iNi.iNe != null && !cVar.iNi.iNe.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.iME.a(cVar.iNi);
            this.iME.cwJ();
            this.iMH = cVar.iNj;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.iME.onChangeSkinType(i);
        ap.setBackgroundColor(this.iME.itemView, R.color.CAM_X0207);
        ap.setViewTextColor(this.iMF, R.color.CAM_X0302);
    }

    public void xJ(int i) {
        this.iMI = i;
    }
}
