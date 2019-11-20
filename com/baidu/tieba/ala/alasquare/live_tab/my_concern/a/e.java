package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.i;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.j;
import com.baidu.tieba.card.ab;
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b, j> {
    private ab<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b> dxc;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b.dxh);
        this.dxc = new ab<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b>() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b bVar) {
                e.this.a(bVar);
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public j b(ViewGroup viewGroup) {
        i iVar = new i(this.mPageContext, viewGroup);
        iVar.d(this.dxc);
        return new j(iVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b bVar, j jVar) {
        if (jVar == null || jVar.dyj == null) {
            return null;
        }
        jVar.dyj.a(bVar);
        return jVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.b bVar) {
        if (bVar != null) {
            String str = bVar.user_id;
            if (!StringUtils.isNull(str) && com.baidu.adp.lib.g.b.toLong(str, 0L) != 0) {
                if (!TbadkCoreApplication.isLogin()) {
                    bc.skipToLoginActivity(this.mPageContext.getPageActivity());
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(str, 0L), !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str), false)));
                }
            }
        }
    }
}
