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
    private VoteView cxE;

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
            this.cxE = (VoteView) findViewById;
            this.cxE.setWidth(com.baidu.adp.lib.util.l.f(getContext(), d.f.ds560));
            this.cxE.setProgressBarHeight(com.baidu.adp.lib.util.l.f(getContext(), d.f.ds20));
            this.cxE.setDescTextColorResId(d.e.cp_cont_b);
            this.cxE.setProgressBarTopMargin(com.baidu.adp.lib.util.l.f(getContext(), d.f.ds8));
            this.cxE.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.cxU.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void jw(int i) {
        if (this.cxE != null) {
            this.cxE.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void G(bh bhVar) {
        if (bhVar != null && bhVar.rc() != null) {
            long longValue = bhVar.rc().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = bhVar.rc().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        av avVar = new av();
                        avVar.eM(true);
                        avVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(avVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.cxE.setBoallotsForListView(linkedList);
                    this.cxE.onChangeSkinType(getSkinType());
                    this.cxE.setVisibility(0);
                    return;
                }
                this.cxE.setVisibility(8);
            }
        }
    }
}
