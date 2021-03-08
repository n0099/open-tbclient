package com.baidu.tieba.frs.videomiddlepagelight;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.frs.aggregation.g;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import java.util.ArrayList;
import java.util.List;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes2.dex */
public final class b extends com.baidu.adp.widget.ListView.a<g, CardViewHolder<c>> {
    private final BdUniqueId XG;
    private final VideoMiddlePageViewModel jPT;
    private final List<c> jPV;
    private final TbPageContext<?> pageContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        p.p(tbPageContext, "pageContext");
        p.p(bdUniqueId, "mType");
        p.p(videoMiddlePageViewModel, "viewModel");
        this.pageContext = tbPageContext;
        this.XG = bdUniqueId;
        this.jPT = videoMiddlePageViewModel;
        this.jPV = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<c> e(ViewGroup viewGroup) {
        c cVar = new c(this.pageContext, this.jPT);
        this.jPV.add(cVar);
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, CardViewHolder<c> cardViewHolder) {
        c cto;
        AgreeData bpL;
        cb f = g.f(gVar);
        if (gVar != null && (bpL = gVar.bpL()) != null) {
            bpL.keyFromHomePage = this.jPT.getFrom();
        }
        if (cardViewHolder != null && (cto = cardViewHolder.cto()) != null) {
            cto.b(gVar, i);
        }
        a(gVar, f, i);
        a(gVar, i);
        if (cardViewHolder != null) {
            return cardViewHolder.getView();
        }
        return null;
    }

    public final void onDestroy() {
        for (c cVar : this.jPV) {
            if (cVar != null) {
                cVar.onDestroy();
            }
        }
    }

    private final void a(g gVar, int i) {
        ar arVar = new ar("c12590");
        arVar.dR("tid", gVar != null ? gVar.threadId : null);
        arVar.dR(IntentConfig.NID, gVar != null ? gVar.nid : null);
        arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
        arVar.aq("obj_locate", i);
        arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, 1);
        if (gVar == null) {
            p.eLc();
        }
        arVar.dR("fid", gVar.forumId);
        arVar.dR("obj_param1", au.isEmpty(gVar.weight) ? "0" : gVar.weight);
        arVar.dR("extra", au.isEmpty(gVar.extra) ? "0" : gVar.extra);
        arVar.dR("obj_id", this.jPT.cNe());
        arVar.dR("ab_tag", au.isEmpty(gVar.abtest_tag) ? "0" : gVar.abtest_tag);
        arVar.dR("obj_type", this.jPT.getFrom());
        arVar.aq("obj_param5", gVar.getVideoType());
        arVar.dR("obj_source", au.isEmpty(gVar.source) ? "0" : gVar.source);
        arVar.aq("is_vertical", gVar.cFI() ? 1 : 0);
        if (gVar.mBaijiahao != null) {
            BaijiahaoData baijiahaoData = gVar.mBaijiahao;
            arVar.dR("obj_param4", baijiahaoData != null ? baijiahaoData.oriUgcNid : null);
            BaijiahaoData baijiahaoData2 = gVar.mBaijiahao;
            arVar.dR("obj_param6", baijiahaoData2 != null ? baijiahaoData2.oriUgcVid : null);
        }
        TiebaStatic.log(arVar);
    }

    private final void a(g gVar, cb cbVar, int i) {
        if (gVar == null) {
            p.eLc();
        }
        com.baidu.tieba.s.c.dMH().a(this.pageContext.getUniqueId(), com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao), com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
    }
}
