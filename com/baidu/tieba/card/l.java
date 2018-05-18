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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.horizonalList.widget.e {
    public TextView bHL;
    public ClickableHeaderImageView cpd;
    public TextView cpe;
    public EntelechyUserLikeButton cpf;
    private com.baidu.tbadk.core.view.userLike.c cpg;
    private com.baidu.tieba.card.data.i cph;
    private TbPageContext mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public l(View view2, TbPageContext tbPageContext) {
        super(view2);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (l.this.cph != null && l.this.cph.aaf != null && !StringUtils.isNull(l.this.cph.aaf.getName_show()) && !StringUtils.isNull(l.this.cph.aaf.getUserId())) {
                    if (l.this.axH != null) {
                        l.this.axH.onClick(view3);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cph.aaf.getUserId(), l.this.cph.aaf.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cpd = (ClickableHeaderImageView) view2.findViewById(d.g.rec_god_item_header);
        this.cpd.setGodIconMargin(d.e.ds6);
        this.bHL = (TextView) view2.findViewById(d.g.rec_god_item_user_name);
        this.cpe = (TextView) view2.findViewById(d.g.rec_god_item_user_describe);
        this.cpf = (EntelechyUserLikeButton) view2.findViewById(d.g.rec_god_item_user_like_btn);
        this.cpg = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cpf);
        this.cpg.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ad(View view2) {
        l lVar = new l(view2, this.mContext);
        lVar.cpg.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cph = (com.baidu.tieba.card.data.i) cVar;
            if (this.cph.aaf != null) {
                getView().setTag(d.g.rec_god_item_root, this.cph.aaf.getUserId());
                this.cpd.setTag(d.g.rec_god_item_root, this.cph.aaf.getUserId());
                this.cpf.setTag(this.cph.aaf);
                this.cpd.setData(this.cph.aaf);
                this.cpd.setAfterClickListener(this.axH);
                this.bHL.setText(an.t(this.cph.aaf.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cph.aaf.getGodUserData() != null) {
                    this.cpe.setText(an.t(this.cph.aaf.getGodUserData().getIntro(), 6));
                }
                this.cpg.a(this.cph.aaf);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.h(this.bHL, d.C0126d.cp_cont_b);
            ak.h(this.cpe, d.C0126d.cp_cont_d);
            if (this.cpf != null) {
                this.cpf.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
