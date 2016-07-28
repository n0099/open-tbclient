package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.j.a;
import com.baidu.tieba.frs.h.b;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cf extends bj<com.baidu.tbadk.core.data.ap, cg> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> EA;
    private com.baidu.tbadk.core.data.ap bHy;

    public cf(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.EA = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public cg a(ViewGroup viewGroup) {
        return new cg(LayoutInflater.from(this.mContext).inflate(u.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bj, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ap apVar, cg cgVar) {
        super.a(i, view, viewGroup, (ViewGroup) apVar, (com.baidu.tbadk.core.data.ap) cgVar);
        if (cgVar.afy != this.mSkinType) {
            a.a(this.bem.getPageContext(), view);
            cgVar.afy = this.mSkinType;
        }
        this.bHy = apVar;
        cgVar.bHz.setOnClickListener(this);
        cgVar.bHz.setTag(apVar);
        cgVar.bHA.setShowBottom(false);
        cgVar.bHA.setShowContent(false);
        cgVar.bHA.setShowRefreshTimeInHead(true);
        cgVar.bHA.setShowLiveIcon(true);
        cgVar.bHA.setHeadPaddingTop(0);
        cgVar.bHA.setChooseStyle(apVar.pu().getShowStyle());
        cgVar.bHA.setShowImage(com.baidu.tbadk.core.l.nL().nR());
        cgVar.bHA.setData(apVar.pu());
        cgVar.bHA.setPortraitClicklistener(this);
        cgVar.bHB.setOnClickListener(this);
        cgVar.bHB.setTag(apVar);
        b.aam().a(bSh, apVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.ap) {
            this.bFF.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.ap) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.EA.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10178").ab("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        b.aam().a(bSh, this.bHy, 2);
    }

    public int Xj() {
        return u.g.more_live_list;
    }

    public int Xk() {
        return u.g.make_headlines;
    }
}
