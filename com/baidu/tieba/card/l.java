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
    private bl akl;
    private View.OnClickListener bHW;
    private View.OnClickListener bHX;
    public TextView bHZ;
    public EntelechyUserLikeButton bIa;
    private com.baidu.tieba.card.data.l bIb;
    private CommonUserLikeButton.a bIc;
    private int mSkinType;
    private TbPageContext oV;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.bIc = new CommonUserLikeButton.a() { // from class: com.baidu.tieba.card.l.1
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dw(int i) {
                l.this.hu(i);
            }
        };
        this.bHW = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.akl != null && l.this.akl.getAuthor() != null && !StringUtils.isNull(l.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(l.this.akl.getAuthor().getUserId()) && l.this.akl.rK() != null) {
                    if (l.this.WA() != null) {
                        l.this.WA().a(view, l.this.bIb);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(l.this.oV.getPageActivity(), l.this.akl.getAuthor().getUserId(), l.this.akl.getAuthor().getName_show(), l.this.akl.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.bHX = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.WA() != null) {
                    l.this.WA().a(view, l.this.bIb);
                }
            }
        };
        this.oV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.n, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.l lVar) {
        super.a(lVar);
        if (lVar != null && lVar.threadData != null) {
            this.bIb = lVar;
            this.akl = lVar.threadData;
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
    public void hu(int i) {
        if (this.bHZ != null) {
            this.bHZ.setText(String.format(this.oV.getResources().getString(d.l.fans_default_name_god_user), al.u(i)));
        }
    }
}
