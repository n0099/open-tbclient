package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends i {
    private final k ezP;
    private final List<g> ezS;
    private final k.c ezX;
    private FrsViewData fMR;
    private Context mContext;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ezX = new k.c() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                c.this.dismiss();
                if (!j.jS()) {
                    l.showToast(c.this.mContext, (int) R.string.network_not_available);
                } else if (i == 1) {
                    TiebaStatic.log(new am("c13384").bT("fid", c.this.fMR.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    if (c.this.fMR != null && c.this.fMR.getForum() != null && !StringUtils.isNull(c.this.fMR.getForum().getId()) && !StringUtils.isNull(c.this.fMR.getForum().getName())) {
                        FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(c.this.mPageContext.getPageActivity());
                        if (frsPrivateShareDialogView.d(c.this.fMR, c.this.mPageContext)) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.mPageContext.getPageActivity());
                            aVar.hr(2);
                            aVar.aF(frsPrivateShareDialogView);
                            aVar.b(c.this.mPageContext).afG();
                        }
                    }
                } else if (i == 2) {
                    TiebaStatic.log(new am("c12402").bT("fid", c.this.fMR.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(ImageViewerConfig.FORUM_NAME, c.this.fMR.getForum().getName()));
                    if (!StringUtils.isNull(c.this.fMR.getForum().getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(c.this.mContext, c.this.fMR.getForum().getName(), c.this.fMR.getForum().getId())));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ezS = new ArrayList();
        this.ezP = new k(this.mContext);
        this.ezP.a(this.ezX);
        setContentView(this.ezP.afZ());
    }

    public void onChangeSkinType() {
        if (this.ezP != null) {
            this.ezP.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.ezS != null && this.ezP != null) {
            this.ezS.clear();
            this.ezS.add(new g(1, getString(R.string.share, new Object[0]), this.ezP));
            this.ezS.add(new g(2, getString(R.string.search, new Object[0]), this.ezP));
            this.ezP.W(this.ezS);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void m(FrsViewData frsViewData) {
        this.fMR = frsViewData;
        createView();
    }
}
