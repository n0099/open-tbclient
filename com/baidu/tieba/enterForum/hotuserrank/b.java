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
    private c.a gRV;
    private TextView gRW;
    private TextView gRX;
    private String gRY;
    private int gRZ;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.gRY)) {
                b.this.dIF.showToast(R.string.load_error_retry);
                return;
            }
            ba.aVa().b(b.this.dIF, new String[]{b.this.gRY});
            if (b.this.gRZ != 0) {
                if (b.this.gRZ != 2) {
                    if (b.this.gRZ == 1) {
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
        this.gRV = new c.a(view.findViewById(R.id.user_view));
        this.gRV.sW(1);
        this.gRW = (TextView) view.findViewById(R.id.get_influence);
        this.gRX = (TextView) view.findViewById(R.id.rank_num);
        this.gRX.setTextSize(0, l.getDimens(this.dIF.getPageActivity(), R.dimen.tbfontsize46));
        this.gRW.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.gSB != null && cVar.gSB.gSx != null && !cVar.gSB.gSx.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.gRV.a(cVar.gSB);
            this.gRV.bPl();
            this.gRY = cVar.gSC;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.gRV.onChangeSkinType(i);
        am.setBackgroundColor(this.gRV.itemView, R.color.cp_bg_line_h);
        am.setViewTextColor(this.gRW, (int) R.color.cp_link_tip_a);
    }

    public void sV(int i) {
        this.gRZ = i;
    }
}
