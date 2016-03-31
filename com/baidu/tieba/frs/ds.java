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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ds extends bx<com.baidu.tbadk.core.data.af, dt> implements View.OnClickListener, PhotoLiveCardView.b {
    private TbPageContext<?> ND;

    /* JADX INFO: Access modifiers changed from: protected */
    public ds(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.ND = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public dt b(ViewGroup viewGroup) {
        return new dt(LayoutInflater.from(this.mContext).inflate(t.h.frs_photo_live_headlines_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.af afVar, dt dtVar) {
        super.a(i, view, viewGroup, (ViewGroup) afVar, (com.baidu.tbadk.core.data.af) dtVar);
        if (dtVar.aik != this.mSkinType) {
            com.baidu.tbadk.i.a.a(this.bix.getPageContext(), view);
            dtVar.aik = this.mSkinType;
        }
        dtVar.bpR.setOnClickListener(this);
        dtVar.bpR.setTag(afVar);
        dtVar.bpS.setShowBottom(false);
        dtVar.bpS.setShowContent(false);
        dtVar.bpS.setShowRefreshTimeInHead(true);
        dtVar.bpS.setShowLiveIcon(true);
        dtVar.bpS.setHeadPaddingTop(0);
        dtVar.bpS.setChooseStyle(afVar.sv().getShowStyle());
        dtVar.bpS.setShowImage(com.baidu.tbadk.core.l.qE().qK());
        dtVar.bpS.setData(afVar.sv());
        dtVar.bpS.setPortraitClicklistener(this);
        dtVar.bpT.setOnClickListener(this);
        dtVar.bpT.setTag(afVar);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.baidu.tbadk.core.data.af) {
            this.bmX.a(view.getId(), 0, view, null, (com.baidu.tbadk.core.data.af) view.getTag());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.b
    public void onPortraitClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof PhotoLiveCardData) {
            PhotoLiveCardData photoLiveCardData = (PhotoLiveCardData) tag;
            if (!StringUtils.isNull(photoLiveCardData.getAuthorId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ND.getPageActivity(), photoLiveCardData.getAuthorId(), null)));
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10178").ac("fid", String.valueOf(photoLiveCardData.getForumId())));
        }
    }

    public int Sn() {
        return t.g.more_live_list;
    }

    public int Ru() {
        return t.g.make_headlines;
    }
}
