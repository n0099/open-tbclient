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
    private bl akj;
    private TbPageContext alI;
    private View.OnClickListener bHn;
    private View.OnClickListener bHo;
    public TextView bHq;
    public EntelechyUserLikeButton bHr;
    private com.baidu.tieba.card.data.l bHs;
    private CommonUserLikeButton.a bHt;
    private int mSkinType;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bHt = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.card.l.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dw(int i) {
                l.this.ht(i);
            }
        };
        this.bHn = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akj != null && l.this.akj.getAuthor() != null && !StringUtils.isNull(l.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(l.this.akj.getAuthor().getUserId()) && l.this.akj.rK() != null) {
                    if (l.this.We() != null) {
                        l.this.We().a(view, l.this.bHs);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(l.this.alI.getPageActivity(), l.this.akj.getAuthor().getUserId(), l.this.akj.getAuthor().getName_show(), l.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bHo = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.We() != null) {
                    l.this.We().a(view, l.this.bHs);
                }
            }
        };
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.n, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        super.a(lVar);
        if (lVar != null && lVar.threadData != null) {
            this.bHs = lVar;
            this.akj = lVar.threadData;
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
    public void ht(int i) {
        if (this.bHq != null) {
            this.bHq.setText(String.format(this.alI.getResources().getString(d.l.fans_default_name_god_user), al.u(i)));
        }
    }
}
