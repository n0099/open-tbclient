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
    private final k eES;
    private final List<g> eEV;
    private final k.c eFa;
    private FrsViewData fSC;
    private Context mContext;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eFa = new k.c() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                c.this.dismiss();
                if (!j.kc()) {
                    l.showToast(c.this.mContext, (int) R.string.network_not_available);
                } else if (i == 1) {
                    TiebaStatic.log(new an("c13384").bT("fid", c.this.fSC.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                    if (c.this.fSC != null && c.this.fSC.getForum() != null && !StringUtils.isNull(c.this.fSC.getForum().getId()) && !StringUtils.isNull(c.this.fSC.getForum().getName())) {
                        FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(c.this.mPageContext.getPageActivity());
                        if (frsPrivateShareDialogView.d(c.this.fSC, c.this.mPageContext)) {
                            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.mPageContext.getPageActivity());
                            aVar.hx(2);
                            aVar.aH(frsPrivateShareDialogView);
                            aVar.b(c.this.mPageContext).agK();
                        }
                    }
                } else if (i == 2) {
                    TiebaStatic.log(new an("c12402").bT("fid", c.this.fSC.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(ImageViewerConfig.FORUM_NAME, c.this.fSC.getForum().getName()));
                    if (!StringUtils.isNull(c.this.fSC.getForum().getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(c.this.mContext, c.this.fSC.getForum().getName(), c.this.fSC.getForum().getId())));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eEV = new ArrayList();
        this.eES = new k(this.mContext);
        this.eES.a(this.eFa);
        setContentView(this.eES.ahd());
    }

    public void onChangeSkinType() {
        if (this.eES != null) {
            this.eES.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.eEV != null && this.eES != null) {
            this.eEV.clear();
            this.eEV.add(new g(1, getString(R.string.share, new Object[0]), this.eES));
            this.eEV.add(new g(2, getString(R.string.search, new Object[0]), this.eES));
            this.eES.W(this.eEV);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void m(FrsViewData frsViewData) {
        this.fSC = frsViewData;
        createView();
    }
}
