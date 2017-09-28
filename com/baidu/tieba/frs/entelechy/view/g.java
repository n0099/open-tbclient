package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.av;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class g extends i {
    private VoteView cxQ;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(d.h.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(d.h.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.cxQ = (VoteView) findViewById;
            this.cxQ.setWidth(com.baidu.adp.lib.util.l.f(getContext(), d.f.ds560));
            this.cxQ.setProgressBarHeight(com.baidu.adp.lib.util.l.f(getContext(), d.f.ds20));
            this.cxQ.setDescTextColorResId(d.e.cp_cont_b);
            this.cxQ.setProgressBarTopMargin(com.baidu.adp.lib.util.l.f(getContext(), d.f.ds8));
            this.cxQ.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.cyg.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void jx(int i) {
        if (this.cxQ != null) {
            this.cxQ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void G(bh bhVar) {
        if (bhVar != null && bhVar.rj() != null) {
            long longValue = bhVar.rj().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = bhVar.rj().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        av avVar = new av();
                        avVar.eN(true);
                        avVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(avVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.cxQ.setBoallotsForListView(linkedList);
                    this.cxQ.onChangeSkinType(getSkinType());
                    this.cxQ.setVisibility(0);
                    return;
                }
                this.cxQ.setVisibility(8);
            }
        }
    }
}
