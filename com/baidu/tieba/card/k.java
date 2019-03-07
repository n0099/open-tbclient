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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.e;
/* loaded from: classes3.dex */
public class k extends e {
    public TextView dBb;
    public EntelechyUserLikeButton ehA;
    private com.baidu.tbadk.core.view.userLike.c ehB;
    private com.baidu.tieba.card.data.i ehC;
    public ClickableHeaderImageView ehy;
    public TextView ehz;
    private TbPageContext mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public k(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.ehC != null && k.this.ehC.bBE != null && !StringUtils.isNull(k.this.ehC.bBE.getName_show()) && !StringUtils.isNull(k.this.ehC.bBE.getUserId())) {
                    if (k.this.ccA != null) {
                        k.this.ccA.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(k.this.mContext.getPageActivity(), k.this.ehC.bBE.getUserId(), k.this.ehC.bBE.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.ehy = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.ehy.setGodIconMargin(d.e.ds6);
        this.dBb = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.ehz = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.ehA = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.ehB = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.ehA);
        this.ehB.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public e bv(View view) {
        k kVar = new k(view, this.mContext);
        kVar.ehB.i(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.ehC = (com.baidu.tieba.card.data.i) cVar;
            if (this.ehC.bBE != null) {
                getView().setTag(d.g.rec_god_item_root, this.ehC.bBE.getUserId());
                this.ehy.setTag(d.g.rec_god_item_root, this.ehC.bBE.getUserId());
                this.ehA.setTag(this.ehC.bBE);
                this.ehy.setData(this.ehC.bBE);
                this.ehy.setAfterClickListener(this.ccA);
                this.dBb.setText(ap.V(this.ehC.bBE.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.ehC.bBE.getGodUserData() != null) {
                    this.ehz.setText(ap.V(this.ehC.bBE.getGodUserData().getIntro(), 6));
                }
                this.ehB.a(this.ehC.bBE);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.dBb, d.C0236d.cp_cont_b);
            al.j(this.ehz, d.C0236d.cp_cont_d);
            if (this.ehA != null) {
                this.ehA.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
