package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private final k eOr;
    private final List<g> eOu;
    private final k.c eOz;
    private FrsViewData fSW;
    private Context mContext;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eOz = new k.c() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                c.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(c.this.mContext, (int) R.string.network_not_available);
                } else if (i == 1) {
                    TiebaStatic.log(new an("c13384").bS("fid", c.this.fSW.getForum().getId()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                    if (c.this.fSW != null && c.this.fSW.getForum() != null && !StringUtils.isNull(c.this.fSW.getForum().getId()) && !StringUtils.isNull(c.this.fSW.getForum().getName())) {
                        FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(c.this.mPageContext.getPageActivity());
                        if (frsPrivateShareDialogView.d(c.this.fSW, c.this.mPageContext)) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.mPageContext.getPageActivity());
                            aVar.hW(2);
                            aVar.aM(frsPrivateShareDialogView);
                            aVar.b(c.this.mPageContext).akM();
                        }
                    }
                } else if (i == 2) {
                    TiebaStatic.log(new an("c12402").bS("fid", c.this.fSW.getForum().getId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fname", c.this.fSW.getForum().getName()));
                    if (!StringUtils.isNull(c.this.fSW.getForum().getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(c.this.mContext, c.this.fSW.getForum().getName(), c.this.fSW.getForum().getId())));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eOu = new ArrayList();
        this.eOr = new k(this.mContext);
        this.eOr.a(this.eOz);
        a(this.eOr);
    }

    public void onChangeSkinType() {
        if (this.eOr != null) {
            this.eOr.onChangeSkinType();
        }
    }

    private void nw() {
        if (this.eOu != null && this.eOr != null) {
            this.eOu.clear();
            this.eOu.add(new g(1, getString(R.string.share, new Object[0]), this.eOr));
            this.eOu.add(new g(2, getString(R.string.search, new Object[0]), this.eOr));
            this.eOr.at(this.eOu);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void m(FrsViewData frsViewData) {
        this.fSW = frsViewData;
        nw();
    }
}
