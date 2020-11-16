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
/* loaded from: classes21.dex */
public class b {
    private TbPageContext eGu;
    private String imA;
    private int imB;
    private c.a imx;
    private TextView imy;
    private TextView imz;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(b.this.imA)) {
                b.this.eGu.showToast(R.string.load_error_retry);
                return;
            }
            bf.bqF().b(b.this.eGu, new String[]{b.this.imA});
            if (b.this.imB != 0) {
                if (b.this.imB != 2) {
                    if (b.this.imB == 1) {
                        ar arVar = new ar("c13669");
                        arVar.ak("obj_locate", 2);
                        TiebaStatic.log(arVar);
                        return;
                    }
                    return;
                }
                ar arVar2 = new ar("c13658");
                arVar2.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar2.ak("obj_locate", 2);
                TiebaStatic.log(arVar2);
            }
        }
    };
    private View mRootView;

    public b(TbPageContext tbPageContext, View view) {
        this.eGu = tbPageContext;
        this.mRootView = view;
        this.imx = new c.a(view.findViewById(R.id.user_view));
        this.imx.yn(1);
        this.imy = (TextView) view.findViewById(R.id.get_influence);
        this.imz = (TextView) view.findViewById(R.id.rank_num);
        this.imz.setTextSize(0, l.getDimens(this.eGu.getPageActivity(), R.dimen.tbfontsize46));
        this.imy.setOnClickListener(this.mOnClickListener);
    }

    public void b(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
        if (cVar != null && cVar.inb != null && cVar.inb.imX != null && !cVar.inb.imX.isMask && TbadkCoreApplication.isLogin()) {
            this.mRootView.setVisibility(0);
            this.imx.a(cVar.inb);
            this.imx.crS();
            this.imA = cVar.inc;
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.imx.onChangeSkinType(i);
        ap.setBackgroundColor(this.imx.itemView, R.color.CAM_X0207);
        ap.setViewTextColor(this.imy, R.color.CAM_X0302);
    }

    public void ym(int i) {
        this.imB = i;
    }
}
