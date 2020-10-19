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
    private TbPageContext etO;
    private c.a hTk;
    private TextView hTl;
    private TextView hTm;
    private String hTn;
    private int hTo;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.hTn)) {
                b.this.etO.showToast(R.string.load_error_retry);
                return;
            }
            be.bmY().b(b.this.etO, new String[]{b.this.hTn});
            if (b.this.hTo != 0) {
                if (b.this.hTo != 2) {
                    if (b.this.hTo == 1) {
                        aq aqVar = new aq("c13669");
                        aqVar.aj("obj_locate", 2);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13658");
                aqVar2.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar2.aj("obj_locate", 2);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.etO = tbPageContext;
        this.mRootView = view;
        this.hTk = new c.a(view.findViewById(R.id.user_view));
        this.hTk.xj(1);
        this.hTl = (TextView) view.findViewById(R.id.get_influence);
        this.hTm = (TextView) view.findViewById(R.id.rank_num);
        this.hTm.setTextSize(0, l.getDimens(this.etO.getPageActivity(), R.dimen.tbfontsize46));
        this.hTl.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.hTP != null && cVar.hTP.hTL != null && !cVar.hTP.hTL.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.hTk.a(cVar.hTP);
            this.hTk.cmH();
            this.hTn = cVar.hTQ;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.hTk.onChangeSkinType(i);
        ap.setBackgroundColor(this.hTk.itemView, R.color.cp_bg_line_h);
        ap.setViewTextColor(this.hTl, R.color.cp_link_tip_a);
    }

    public void xi(int i) {
        this.hTo = i;
    }
}
