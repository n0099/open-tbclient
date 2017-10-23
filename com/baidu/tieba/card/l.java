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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class l extends n {
    private bh aiU;
    private View.OnClickListener bKS;
    private View.OnClickListener bKT;
    public TextView bKV;
    public EntelechyUserLikeButton bKW;
    private com.baidu.tieba.card.data.l bKX;
    private CommonUserLikeButton.a bKY;
    private TbPageContext mH;
    private int mSkinType;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bKY = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.card.l.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dG(int i) {
                l.this.hO(i);
            }
        };
        this.bKS = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aiU != null && l.this.aiU.getAuthor() != null && !StringUtils.isNull(l.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(l.this.aiU.getAuthor().getUserId()) && l.this.aiU.rt() != null) {
                    if (l.this.Xn() != null) {
                        l.this.Xn().a(view, l.this.bKX);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(l.this.mH.getPageActivity(), l.this.aiU.getAuthor().getUserId(), l.this.aiU.getAuthor().getName_show(), l.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bKT = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.Xn() != null) {
                    l.this.Xn().a(view, l.this.bKX);
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.n, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        super.a(lVar);
        if (lVar != null && lVar.threadData != null) {
            this.bKX = lVar;
            this.aiU = lVar.threadData;
        }
    }

    @Override // com.baidu.tieba.card.n, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.n
    public void k(BdUniqueId bdUniqueId) {
        super.k(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        if (this.bKV != null) {
            this.bKV.setText(String.format(this.mH.getResources().getString(d.l.fans_default_name_god_user), am.u(i)));
        }
    }
}
