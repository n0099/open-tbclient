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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dn extends bw<com.baidu.tbadk.core.data.ah, Cdo> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> DV;

    public dn(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.DV = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public Cdo b(ViewGroup viewGroup) {
        return new Cdo(LayoutInflater.from(this.mContext).inflate(t.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ah ahVar, Cdo cdo) {
        super.a(i, view, viewGroup, (ViewGroup) ahVar, (com.baidu.tbadk.core.data.ah) cdo);
        if (cdo.aej != this.mSkinType) {
            a.a(this.bek.getPageContext(), view);
            cdo.aej = this.mSkinType;
        }
        cdo.blh.setOnClickListener(this);
        cdo.blh.setTag(ahVar);
        cdo.bli.setShowBottom(false);
        cdo.bli.setShowContent(false);
        cdo.bli.setShowRefreshTimeInHead(true);
        cdo.bli.setShowLiveIcon(true);
        cdo.bli.setHeadPaddingTop(0);
        cdo.bli.setChooseStyle(ahVar.pR().getShowStyle());
        cdo.bli.setShowImage(com.baidu.tbadk.core.l.ob().oh());
        cdo.bli.setData(ahVar.pR());
        cdo.bli.setPortraitClicklistener(this);
        cdo.blj.setOnClickListener(this);
        cdo.blj.setTag(ahVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.ah) {
            this.bix.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.ah) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.DV.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10178").ac("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
    }

    public int Rx() {
        return t.g.more_live_list;
    }

    public int Ry() {
        return t.g.make_headlines;
    }
}
