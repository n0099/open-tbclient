package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class l extends com.baidu.tieba.horizonalList.widget.e {
    public ClickableHeaderImageView cUk;
    public TextView cUl;
    public EntelechyUserLikeButton cUm;
    private com.baidu.tbadk.core.view.userLike.c cUn;
    private com.baidu.tieba.card.data.i cUo;
    public TextView clh;
    private TbPageContext mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public l(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.cUo != null && l.this.cUo.atK != null && !StringUtils.isNull(l.this.cUo.atK.getName_show()) && !StringUtils.isNull(l.this.cUo.atK.getUserId())) {
                    if (l.this.aSY != null) {
                        l.this.aSY.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cUo.atK.getUserId(), l.this.cUo.atK.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cUk = (ClickableHeaderImageView) view.findViewById(e.g.rec_god_item_header);
        this.cUk.setGodIconMargin(e.C0210e.ds6);
        this.clh = (TextView) view.findViewById(e.g.rec_god_item_user_name);
        this.cUl = (TextView) view.findViewById(e.g.rec_god_item_user_describe);
        this.cUm = (EntelechyUserLikeButton) view.findViewById(e.g.rec_god_item_user_like_btn);
        this.cUn = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cUm);
        this.cUn.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ay(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cUn.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cUo = (com.baidu.tieba.card.data.i) cVar;
            if (this.cUo.atK != null) {
                getView().setTag(e.g.rec_god_item_root, this.cUo.atK.getUserId());
                this.cUk.setTag(e.g.rec_god_item_root, this.cUo.atK.getUserId());
                this.cUm.setTag(this.cUo.atK);
                this.cUk.setData(this.cUo.atK);
                this.cUk.setAfterClickListener(this.aSY);
                this.clh.setText(ao.z(this.cUo.atK.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cUo.atK.getGodUserData() != null) {
                    this.cUl.setText(ao.z(this.cUo.atK.getGodUserData().getIntro(), 6));
                }
                this.cUn.a(this.cUo.atK);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.clh, e.d.cp_cont_b);
            al.h(this.cUl, e.d.cp_cont_d);
            if (this.cUm != null) {
                this.cUm.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
