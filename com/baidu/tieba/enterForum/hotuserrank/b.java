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
    private TbPageContext duG;
    private c.a gCW;
    private TextView gCX;
    private TextView gCY;
    private String gCZ;
    private int gDa;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.gCZ)) {
                b.this.duG.showToast(R.string.load_error_retry);
                return;
            }
            ba.aOY().b(b.this.duG, new String[]{b.this.gCZ});
            if (b.this.gDa != 0) {
                if (b.this.gDa != 2) {
                    if (b.this.gDa == 1) {
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
        this.duG = tbPageContext;
        this.mRootView = view;
        this.gCW = new c.a(view.findViewById(R.id.user_view));
        this.gCW.sp(1);
        this.gCX = (TextView) view.findViewById(R.id.get_influence);
        this.gCY = (TextView) view.findViewById(R.id.rank_num);
        this.gCY.setTextSize(0, l.getDimens(this.duG.getPageActivity(), R.dimen.tbfontsize46));
        this.gCX.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.gDB != null && cVar.gDB.gDx != null && !cVar.gDB.gDx.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.gCW.a(cVar.gDB);
            this.gCW.bIR();
            this.gCZ = cVar.gDC;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.gCW.onChangeSkinType(i);
        am.setBackgroundColor(this.gCW.itemView, R.color.cp_bg_line_h);
        am.setViewTextColor(this.gCX, (int) R.color.cp_link_tip_a);
    }

    public void so(int i) {
        this.gDa = i;
    }
}
