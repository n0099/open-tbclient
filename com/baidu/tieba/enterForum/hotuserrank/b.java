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
    private c.a ixs;
    private TextView ixt;
    private TextView ixu;
    private String ixv;
    private int ixw;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.ixv)) {
                b.this.eNx.showToast(R.string.load_error_retry);
                return;
            }
            bf.bua().b(b.this.eNx, new String[]{b.this.ixv});
            if (b.this.ixw != 0) {
                if (b.this.ixw != 2) {
                    if (b.this.ixw == 1) {
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
        this.ixs = new c.a(view.findViewById(R.id.user_view));
        this.ixs.yS(1);
        this.ixt = (TextView) view.findViewById(R.id.get_influence);
        this.ixu = (TextView) view.findViewById(R.id.rank_num);
        this.ixu.setTextSize(0, l.getDimens(this.eNx.getPageActivity(), R.dimen.tbfontsize46));
        this.ixt.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.ixW != null && cVar.ixW.ixS != null && !cVar.ixW.ixS.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.ixs.a(cVar.ixW);
            this.ixs.cwi();
            this.ixv = cVar.ixX;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.ixs.onChangeSkinType(i);
        ap.setBackgroundColor(this.ixs.itemView, R.color.CAM_X0207);
        ap.setViewTextColor(this.ixt, R.color.CAM_X0302);
    }

    public void yR(int i) {
        this.ixw = i;
    }
}
