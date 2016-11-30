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
import com.baidu.tbadk.i.a;
import com.baidu.tieba.frs.h.b;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bg extends aq<com.baidu.tbadk.core.data.av, bh> implements View.OnClickListener, PhotoLiveCardView.b, com.baidu.tieba.frs.h.e {
    private TbPageContext<?> GO;
    private com.baidu.tbadk.core.data.av bUK;

    public bg(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.GO = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: u */
    public bh a(ViewGroup viewGroup) {
        return new bh(LayoutInflater.from(this.mContext).inflate(r.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.aq, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.av avVar, bh bhVar) {
        super.a(i, view, viewGroup, (ViewGroup) avVar, (com.baidu.tbadk.core.data.av) bhVar);
        if (bhVar.aiA != this.mSkinType) {
            a.a(this.aTb.getPageContext(), view);
            bhVar.aiA = this.mSkinType;
        }
        this.bUK = avVar;
        bhVar.bUL.setOnClickListener(this);
        bhVar.bUL.setTag(avVar);
        bhVar.bUM.setShowBottom(false);
        bhVar.bUM.setShowContent(false);
        bhVar.bUM.setShowRefreshTimeInHead(true);
        bhVar.bUM.setShowLiveIcon(true);
        bhVar.bUM.setHeadPaddingTop(0);
        bhVar.bUM.setChooseStyle(avVar.qL().getShowStyle());
        bhVar.bUM.setShowImage(com.baidu.tbadk.core.l.oJ().oP());
        bhVar.bUM.setData(avVar.qL());
        bhVar.bUM.setPortraitClicklistener(this);
        bhVar.bUN.setOnClickListener(this);
        bhVar.bUN.setTag(avVar);
        if (avVar != null) {
            avVar.sN();
        }
        b.agV().a(chm, avVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.av) {
            this.bTo.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.av) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.GO.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10178").ab("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
        b.agV().a(chm, this.bUK, 2);
    }

    public int ady() {
        return r.g.more_live_list;
    }

    public int adz() {
        return r.g.make_headlines;
    }
}
