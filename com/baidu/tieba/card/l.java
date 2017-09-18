package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class l extends n {
    private bj ajE;
    private View.OnClickListener bLI;
    private View.OnClickListener bLJ;
    public TextView bLL;
    public EntelechyUserLikeButton bLM;
    private com.baidu.tieba.card.data.l bLN;
    private CommonUserLikeButton.a bLO;
    private TbPageContext mF;
    private int mSkinType;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bLO = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.card.l.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dx(int i) {
                l.this.hH(i);
            }
        };
        this.bLI = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.ajE != null && l.this.ajE.getAuthor() != null && !StringUtils.isNull(l.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(l.this.ajE.getAuthor().getUserId()) && l.this.ajE.rG() != null) {
                    if (l.this.XL() != null) {
                        l.this.XL().a(view, l.this.bLN);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(l.this.mF.getPageActivity(), l.this.ajE.getAuthor().getUserId(), l.this.ajE.getAuthor().getName_show(), l.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bLJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.XL() != null) {
                    l.this.XL().a(view, l.this.bLN);
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.n, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        super.a(lVar);
        if (lVar != null && lVar.threadData != null) {
            this.bLN = lVar;
            this.ajE = lVar.threadData;
        }
    }

    @Override // com.baidu.tieba.card.n, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.n
    public void l(BdUniqueId bdUniqueId) {
        super.l(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(int i) {
        if (this.bLL != null) {
            this.bLL.setText(String.format(this.mF.getResources().getString(d.l.fans_default_name_god_user), am.u(i)));
        }
    }
}
