package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.cs;
import com.baidu.tieba.w;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ah extends ao {
    private VoteView chM;

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
            this.chM = (VoteView) findViewById;
            this.chM.setWidth(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds560));
            this.chM.setProgressBarHeight(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20));
            this.chM.setDescTextColorResId(w.e.cp_cont_b);
            this.chM.setProgressBarTopMargin(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds8));
            this.chM.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.cic.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void iM(int i) {
        if (this.chM != null) {
            this.chM.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void D(bm bmVar) {
        if (bmVar != null && bmVar.rg() != null) {
            long longValue = bmVar.rg().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = bmVar.rg().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        cs csVar = new cs();
                        csVar.eD(true);
                        csVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(csVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.chM.setBoallotsForListView(linkedList);
                    this.chM.onChangeSkinType(getSkinType());
                    this.chM.setVisibility(0);
                    return;
                }
                this.chM.setVisibility(8);
            }
        }
    }
}
