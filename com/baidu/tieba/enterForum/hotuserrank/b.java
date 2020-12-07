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
import com.baidu.tieba.enterForum.hotuserrank.c;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext eNx;
    private c.a ixq;
    private TextView ixr;
    private TextView ixs;
    private String ixt;
    private int ixu;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.ixt)) {
                b.this.eNx.showToast(R.string.load_error_retry);
                return;
            }
            bf.bua().b(b.this.eNx, new String[]{b.this.ixt});
            if (b.this.ixu != 0) {
                if (b.this.ixu != 2) {
                    if (b.this.ixu == 1) {
                        ar arVar = new ar("c13669");
                        arVar.al("obj_locate", 2);
                        TiebaStatic.log(arVar);
                        return;
                    }
                    return;
                }
                ar arVar2 = new ar("c13658");
                arVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar2.al("obj_locate", 2);
                TiebaStatic.log(arVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.eNx = tbPageContext;
        this.mRootView = view;
        this.ixq = new c.a(view.findViewById(R.id.user_view));
        this.ixq.yS(1);
        this.ixr = (TextView) view.findViewById(R.id.get_influence);
        this.ixs = (TextView) view.findViewById(R.id.rank_num);
        this.ixs.setTextSize(0, l.getDimens(this.eNx.getPageActivity(), R.dimen.tbfontsize46));
        this.ixr.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.ixU != null && cVar.ixU.ixQ != null && !cVar.ixU.ixQ.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.ixq.a(cVar.ixU);
            this.ixq.cwh();
            this.ixt = cVar.ixV;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.ixq.onChangeSkinType(i);
        ap.setBackgroundColor(this.ixq.itemView, R.color.CAM_X0207);
        ap.setViewTextColor(this.ixr, R.color.CAM_X0302);
    }

    public void yR(int i) {
        this.ixu = i;
    }
}
