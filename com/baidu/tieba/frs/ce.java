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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ce extends bd<com.baidu.tbadk.core.data.q, cf> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public ce(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.mPageContext = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public cf a(ViewGroup viewGroup) {
        return new cf(LayoutInflater.from(this.mContext).inflate(i.g.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bd, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.q qVar, cf cfVar) {
        super.a(i, view, viewGroup, (ViewGroup) qVar, (com.baidu.tbadk.core.data.q) cfVar);
        com.baidu.tbadk.h.a.a(this.mPageContext, view);
        cfVar.aXY.setOnClickListener(this);
        cfVar.aXY.setTag(qVar);
        cfVar.aXZ.setShowBottom(false);
        cfVar.aXZ.setShowContent(false);
        cfVar.aXZ.setShowRefreshTimeInHead(true);
        cfVar.aXZ.setShowLiveIcon(true);
        cfVar.aXZ.setHeadPaddingTop(0);
        cfVar.aXZ.setChooseStyle(qVar.rT().getShowStyle());
        cfVar.aXZ.setShowImage(com.baidu.tbadk.core.m.rb().rf());
        cfVar.aXZ.setData(qVar.rT());
        cfVar.aXZ.setPortraitClicklistener(this);
        cfVar.aYa.setOnClickListener(this);
        cfVar.aYa.setTag(qVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.q) {
            this.aWB.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.q) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10178").af(ImageViewerConfig.FORUM_ID, String.valueOf(photoLiveCardData.getForumId())));
        }
    }

    public int Mm() {
        return i.f.more_live_list;
    }

    public int LE() {
        return i.f.make_headlines;
    }
}
