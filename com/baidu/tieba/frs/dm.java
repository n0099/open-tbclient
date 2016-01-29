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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dm extends bv<com.baidu.tbadk.core.data.x, dn> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> Nw;

    /* JADX INFO: Access modifiers changed from: protected */
    public dm(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.Nw = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public dn b(ViewGroup viewGroup) {
        return new dn(LayoutInflater.from(this.mContext).inflate(t.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.x xVar, dn dnVar) {
        super.a(i, view, viewGroup, (ViewGroup) xVar, (com.baidu.tbadk.core.data.x) dnVar);
        if (dnVar.ahU != this.mSkinType) {
            com.baidu.tbadk.i.a.a(this.bdK.getPageContext(), view);
            dnVar.ahU = this.mSkinType;
        }
        dnVar.bkC.setOnClickListener(this);
        dnVar.bkC.setTag(xVar);
        dnVar.bkD.setShowBottom(false);
        dnVar.bkD.setShowContent(false);
        dnVar.bkD.setShowRefreshTimeInHead(true);
        dnVar.bkD.setShowLiveIcon(true);
        dnVar.bkD.setHeadPaddingTop(0);
        dnVar.bkD.setChooseStyle(xVar.sA().getShowStyle());
        dnVar.bkD.setShowImage(com.baidu.tbadk.core.l.rn().rt());
        dnVar.bkD.setData(xVar.sA());
        dnVar.bkD.setPortraitClicklistener(this);
        dnVar.bkE.setOnClickListener(this);
        dnVar.bkE.setTag(xVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.x) {
            this.bim.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.x) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.Nw.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10178").aa(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
        }
    }

    public int Qu() {
        return t.g.more_live_list;
    }

    public int PF() {
        return t.g.make_headlines;
    }
}
