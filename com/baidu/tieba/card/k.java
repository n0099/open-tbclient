package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.horizonalList.widget.e {
    private TbPageContext ceu;
    public ClickableHeaderImageView eLA;
    public TextView eLB;
    public EntelechyUserLikeButton eLC;
    private com.baidu.tbadk.core.view.userLike.c eLD;
    private com.baidu.tieba.card.data.i eLE;
    public TextView evA;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public k(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.eLE != null && k.this.eLE.cbv != null && !StringUtils.isNull(k.this.eLE.cbv.getName_show()) && !StringUtils.isNull(k.this.eLE.cbv.getUserId())) {
                    if (k.this.cze != null) {
                        k.this.cze.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(k.this.ceu.getPageActivity(), k.this.eLE.cbv.getUserId(), k.this.eLE.cbv.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.ceu = tbPageContext;
        this.eLA = (ClickableHeaderImageView) view.findViewById(R.id.rec_god_item_header);
        this.eLA.setGodIconMargin(R.dimen.ds6);
        this.evA = (TextView) view.findViewById(R.id.rec_god_item_user_name);
        this.eLB = (TextView) view.findViewById(R.id.rec_god_item_user_describe);
        this.eLC = (EntelechyUserLikeButton) view.findViewById(R.id.rec_god_item_user_like_btn);
        this.eLD = new com.baidu.tbadk.core.view.userLike.c(this.ceu, this.eLC);
        this.eLD.mX("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bB(View view) {
        k kVar = new k(view, this.ceu);
        kVar.eLD.j(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.eLE = (com.baidu.tieba.card.data.i) cVar;
            if (this.eLE.cbv != null) {
                getView().setTag(R.id.rec_god_item_root, this.eLE.cbv.getUserId());
                this.eLA.setTag(R.id.rec_god_item_root, this.eLE.cbv.getUserId());
                this.eLC.setTag(this.eLE.cbv);
                this.eLA.setData(this.eLE.cbv);
                this.eLA.setAfterClickListener(this.cze);
                this.evA.setText(aq.cutStringWithEllipsis(this.eLE.cbv.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.eLE.cbv.getGodUserData() != null) {
                    this.eLB.setText(aq.cutStringWithEllipsis(this.eLE.cbv.getGodUserData().getIntro(), 6));
                }
                this.eLD.a(this.eLE.cbv);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.evA, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eLB, (int) R.color.cp_cont_d);
            if (this.eLC != null) {
                this.eLC.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
