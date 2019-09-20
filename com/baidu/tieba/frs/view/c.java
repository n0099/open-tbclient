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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends i {
    private final k eGB;
    private final List<g> eGE;
    private final k.c eGJ;
    private FrsViewData fUt;
    private Context mContext;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eGJ = new k.c() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                c.this.dismiss();
                if (!j.kc()) {
                    l.showToast(c.this.mContext, (int) R.string.network_not_available);
                } else if (i == 1) {
                    TiebaStatic.log(new an("c13384").bT("fid", c.this.fUt.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    if (c.this.fUt != null && c.this.fUt.getForum() != null && !StringUtils.isNull(c.this.fUt.getForum().getId()) && !StringUtils.isNull(c.this.fUt.getForum().getName())) {
                        FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(c.this.mPageContext.getPageActivity());
                        if (frsPrivateShareDialogView.d(c.this.fUt, c.this.mPageContext)) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.mPageContext.getPageActivity());
                            aVar.hy(2);
                            aVar.aH(frsPrivateShareDialogView);
                            aVar.b(c.this.mPageContext).agO();
                        }
                    }
                } else if (i == 2) {
                    TiebaStatic.log(new an("c12402").bT("fid", c.this.fUt.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(ImageViewerConfig.FORUM_NAME, c.this.fUt.getForum().getName()));
                    if (!StringUtils.isNull(c.this.fUt.getForum().getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(c.this.mContext, c.this.fUt.getForum().getName(), c.this.fUt.getForum().getId())));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eGE = new ArrayList();
        this.eGB = new k(this.mContext);
        this.eGB.a(this.eGJ);
        a(this.eGB);
    }

    public void onChangeSkinType() {
        if (this.eGB != null) {
            this.eGB.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.eGE != null && this.eGB != null) {
            this.eGE.clear();
            this.eGE.add(new g(1, getString(R.string.share, new Object[0]), this.eGB));
            this.eGE.add(new g(2, getString(R.string.search, new Object[0]), this.eGB));
            this.eGB.W(this.eGE);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void m(FrsViewData frsViewData) {
        this.fUt = frsViewData;
        createView();
    }
}
