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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class l extends n {
    private bl aiQ;
    private TbPageContext ako;
    private View.OnClickListener bGd;
    private View.OnClickListener bGe;
    public TextView bGg;
    public EntelechyUserLikeButton bGh;
    private com.baidu.tieba.card.data.l bGi;
    private CommonUserLikeButton.a bGj;
    private int mSkinType;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bGj = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.card.l.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void du(int i) {
                l.this.hs(i);
            }
        };
        this.bGd = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.aiQ != null && l.this.aiQ.getAuthor() != null && !StringUtils.isNull(l.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(l.this.aiQ.getAuthor().getUserId()) && l.this.aiQ.rA() != null) {
                    if (l.this.VZ() != null) {
                        l.this.VZ().a(view, l.this.bGi);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(l.this.ako.getPageActivity(), l.this.aiQ.getAuthor().getUserId(), l.this.aiQ.getAuthor().getName_show(), l.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bGe = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.VZ() != null) {
                    l.this.VZ().a(view, l.this.bGi);
                }
            }
        };
        this.ako = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.n, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        super.a(lVar);
        if (lVar != null && lVar.threadData != null) {
            this.bGi = lVar;
            this.aiQ = lVar.threadData;
        }
    }

    @Override // com.baidu.tieba.card.n, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.n
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(int i) {
        if (this.bGg != null) {
            this.bGg.setText(String.format(this.ako.getResources().getString(d.l.fans_default_name_god_user), al.u(i)));
        }
    }
}
