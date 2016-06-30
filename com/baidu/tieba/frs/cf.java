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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cf extends bj<com.baidu.tbadk.core.data.ak, cg> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> Ea;

    public cf(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.Ea = baseActivity.getPageContext();
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ak akVar, cg cgVar) {
        super.a(i, view, viewGroup, (ViewGroup) akVar, (com.baidu.tbadk.core.data.ak) cgVar);
        if (cgVar.aeK != this.mSkinType) {
            a.a(this.bkc.getPageContext(), view);
            cgVar.aeK = this.mSkinType;
        }
        cgVar.bGd.setOnClickListener(this);
        cgVar.bGd.setTag(akVar);
        cgVar.bGe.setShowBottom(false);
        cgVar.bGe.setShowContent(false);
        cgVar.bGe.setShowRefreshTimeInHead(true);
        cgVar.bGe.setShowLiveIcon(true);
        cgVar.bGe.setHeadPaddingTop(0);
        cgVar.bGe.setChooseStyle(akVar.pL().getShowStyle());
        cgVar.bGe.setShowImage(com.baidu.tbadk.core.l.nW().oc());
        cgVar.bGe.setData(akVar.pL());
        cgVar.bGe.setPortraitClicklistener(this);
        cgVar.bGf.setOnClickListener(this);
        cgVar.bGf.setTag(akVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.ak) {
            this.bEt.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.ak) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.Ea.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10178").ab("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
    }

    public int WR() {
        return u.g.more_live_list;
    }

    public int WS() {
        return u.g.make_headlines;
    }
}
