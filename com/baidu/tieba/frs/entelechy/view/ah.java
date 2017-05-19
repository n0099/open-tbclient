package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.cq;
import com.baidu.tieba.w;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ah extends ao {
    private VoteView bTL;

    public ah(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(w.h.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(w.h.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bTL = (VoteView) findViewById;
            this.bTL.setWidth(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds560));
            this.bTL.setProgressBarHeight(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20));
            this.bTL.setDescTextColorResId(w.e.cp_cont_b);
            this.bTL.setProgressBarTopMargin(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds8));
            this.bTL.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bUa.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void ic(int i) {
        if (this.bTL != null) {
            this.bTL.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void x(bk bkVar) {
        if (bkVar != null && bkVar.rn() != null) {
            long longValue = bkVar.rn().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = bkVar.rn().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        cq cqVar = new cq();
                        cqVar.dV(true);
                        cqVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(cqVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bTL.setBoallotsForListView(linkedList);
                    this.bTL.onChangeSkinType(getSkinType());
                    this.bTL.setVisibility(0);
                    return;
                }
                this.bTL.setVisibility(8);
            }
        }
    }
}
