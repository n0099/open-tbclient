package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
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
/* loaded from: classes6.dex */
public class c extends i {
    private final k fGf;
    private final List<g> fGi;
    private final k.c fGn;
    private FrsViewData gHv;
    private Context mContext;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fGn = new k.c() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                c.this.dismiss();
                if (!j.isNetWorkAvailable()) {
                    l.showToast(c.this.mContext, (int) R.string.network_not_available);
                } else if (i == 1) {
                    if (c.this.gHv != null && c.this.gHv.getForum() != null && !StringUtils.isNull(c.this.gHv.getForum().getId()) && !StringUtils.isNull(c.this.gHv.getForum().getName())) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK).cp("fid", c.this.gHv.getForum().getId()).Z("obj_locate", 11));
                        com.baidu.tieba.frs.f.e.a(c.this.mPageContext, c.this.gHv, c.this.gHv.getForum().getId());
                    }
                } else if (i == 2) {
                    TiebaStatic.log(new an("c12402").cp("fid", c.this.gHv.getForum().getId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fname", c.this.gHv.getForum().getName()));
                    if (!StringUtils.isNull(c.this.gHv.getForum().getName())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(c.this.mContext, c.this.gHv.getForum().getName(), c.this.gHv.getForum().getId())));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fGi = new ArrayList();
        this.fGf = new k(this.mContext);
        this.fGf.a(this.fGn);
        a(this.fGf);
    }

    public void onChangeSkinType() {
        if (this.fGf != null) {
            this.fGf.onChangeSkinType();
        }
    }

    private void createView() {
        if (this.fGi != null && this.fGf != null) {
            this.fGi.clear();
            this.fGi.add(new g(1, getString(R.string.share, new Object[0]), this.fGf));
            this.fGi.add(new g(2, getString(R.string.search, new Object[0]), this.fGf));
            this.fGf.aA(this.fGi);
        }
    }

    private String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void m(FrsViewData frsViewData) {
        this.gHv = frsViewData;
        createView();
    }
}
