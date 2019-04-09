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
import com.baidu.tbadk.core.dialog.f;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends g {
    private final i eka;
    private final List<f> ekd;
    private final i.c eki;
    private FrsViewData fvY;
    private Context mContext;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eki = new i.c() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                c.this.dismiss();
                if (!j.kY()) {
                    l.showToast(c.this.mContext, d.j.network_not_available);
                } else if (i == 1) {
                    TiebaStatic.log(new am("c13384").bJ(ImageViewerConfig.FORUM_ID, c.this.fvY.getForum().getId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                    FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(c.this.mPageContext.getPageActivity());
                    if (frsPrivateShareDialogView.d(c.this.fvY, c.this.mPageContext)) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.mPageContext.getPageActivity());
                        aVar.gE(2);
                        aVar.az(frsPrivateShareDialogView);
                        aVar.b(c.this.mPageContext).aaW();
                    }
                } else if (i == 2) {
                    TiebaStatic.log(new am("c12402").bJ(ImageViewerConfig.FORUM_ID, c.this.fvY.getForum().getId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_NAME, c.this.fvY.getForum().getName()));
                    if (!StringUtils.isNull(c.this.fvY.getForum().getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(c.this.mContext, c.this.fvY.getForum().getName(), c.this.fvY.getForum().getId())));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ekd = new ArrayList();
        this.eka = new i(this.mContext);
        this.eka.a(this.eki);
        setContentView(this.eka.abh());
    }

    public void onChangeSkinType() {
        if (this.eka != null) {
            this.eka.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.ekd != null && this.eka != null) {
            this.ekd.clear();
            this.ekd.add(new f(1, getString(d.j.share, new Object[0]), this.eka));
            this.ekd.add(new f(2, getString(d.j.search, new Object[0]), this.eka));
            this.eka.P(this.ekd);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void l(FrsViewData frsViewData) {
        this.fvY = frsViewData;
        createView();
    }
}
