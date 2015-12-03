package com.baidu.tieba.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareForumListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class o extends b<com.baidu.tieba.a.a.h> {
    private String aMo;
    private HorizonalScrollListView aMr;

    public void n(String str, String str2, String str3) {
        this.aMr.ao(str, str2);
        this.aMo = str3;
    }

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aMo = null;
        this.aMr = new HorizonalScrollListView(getContext());
        this.aMr.setLoadMoreClickListener(this);
        this.aLV.addView(this.aMr);
        this.aLN.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.a.a
    public void setFrom(String str) {
        super.setFrom(str);
        this.aMr.setFrom(str);
    }

    @Override // com.baidu.tieba.a.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.aMr != null) {
            this.aMr.cZ(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a.b
    public void a(com.baidu.tieba.a.a.h hVar) {
        super.a((o) hVar);
        if (hVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<com.baidu.tbadk.widget.horizonalScrollListView.f> Ed = hVar.Ed();
        int k = y.k(Ed);
        if (k <= 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        if (k > 10) {
            Ed = Ed.subList(0, 10);
        }
        this.aMr.a(Ed, Io());
        onChangeSkinType(Io(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tieba.a.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aLN == view || (this.aMr != null && this.aMr.getLastItemView() == view)) {
            if (!TextUtils.isEmpty(this.aMo)) {
                TiebaStatic.log(this.aMo);
            }
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_WEEKLY, new SquareForumListActivityConfig(getContext(), 1)));
            } else {
                UtilHelper.showToast(Io().getPageActivity(), n.i.plugin_config_not_found);
            }
        }
    }
}
