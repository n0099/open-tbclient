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
import com.baidu.tieba.frs.g.b;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cb extends bf<com.baidu.tbadk.core.data.ar, cc> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private com.baidu.tbadk.core.data.ar bSE;

    public cb(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.GM = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public cc a(ViewGroup viewGroup) {
        return new cc(LayoutInflater.from(this.mContext).inflate(t.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ar arVar, cc ccVar) {
        super.a(i, view, viewGroup, (ViewGroup) arVar, (com.baidu.tbadk.core.data.ar) ccVar);
        if (ccVar.ait != this.mSkinType) {
            a.a(this.aPR.getPageContext(), view);
            ccVar.ait = this.mSkinType;
        }
        this.bSE = arVar;
        ccVar.bSF.setOnClickListener(this);
        ccVar.bSF.setTag(arVar);
        ccVar.bSG.setShowBottom(false);
        ccVar.bSG.setShowContent(false);
        ccVar.bSG.setShowRefreshTimeInHead(true);
        ccVar.bSG.setShowLiveIcon(true);
        ccVar.bSG.setHeadPaddingTop(0);
        ccVar.bSG.setChooseStyle(arVar.qy().getShowStyle());
        ccVar.bSG.setShowImage(com.baidu.tbadk.core.l.oG().oM());
        ccVar.bSG.setData(arVar.qy());
        ccVar.bSG.setPortraitClicklistener(this);
        ccVar.bSH.setOnClickListener(this);
        ccVar.bSH.setTag(arVar);
        b.aeX().a(cdn, arVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.ar) {
            this.bQN.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.ar) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.GM.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10178").ab("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        b.aeX().a(cdn, this.bSE, 2);
    }

    public int acg() {
        return t.g.more_live_list;
    }

    public int ach() {
        return t.g.make_headlines;
    }
}
