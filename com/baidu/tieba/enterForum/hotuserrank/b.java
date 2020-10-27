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
    private TbPageContext eCn;
    private c.a ifL;
    private TextView ifM;
    private TextView ifN;
    private String ifO;
    private int ifP;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.ifO)) {
                b.this.eCn.showToast(R.string.load_error_retry);
                return;
            }
            be.boR().b(b.this.eCn, new String[]{b.this.ifO});
            if (b.this.ifP != 0) {
                if (b.this.ifP != 2) {
                    if (b.this.ifP == 1) {
                        aq aqVar = new aq("c13669");
                        aqVar.aj("obj_locate", 2);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13658");
                aqVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar2.aj("obj_locate", 2);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.eCn = tbPageContext;
        this.mRootView = view;
        this.ifL = new c.a(view.findViewById(R.id.user_view));
        this.ifL.xC(1);
        this.ifM = (TextView) view.findViewById(R.id.get_influence);
        this.ifN = (TextView) view.findViewById(R.id.rank_num);
        this.ifN.setTextSize(0, l.getDimens(this.eCn.getPageActivity(), R.dimen.tbfontsize46));
        this.ifM.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.igp != null && cVar.igp.igl != null && !cVar.igp.igl.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.ifL.a(cVar.igp);
            this.ifL.cpO();
            this.ifO = cVar.igq;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.ifL.onChangeSkinType(i);
        ap.setBackgroundColor(this.ifL.itemView, R.color.cp_bg_line_h);
        ap.setViewTextColor(this.ifM, R.color.cp_link_tip_a);
    }

    public void xB(int i) {
        this.ifP = i;
    }
}
