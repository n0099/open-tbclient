package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.av;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class g extends i {
    private VoteView cPb;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(d.g.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(d.g.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.cPb = (VoteView) findViewById;
            this.cPb.setWidth(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds560));
            this.cPb.setProgressBarHeight(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20));
            this.cPb.setDescTextColorResId(d.C0082d.cp_cont_b);
            this.cPb.setProgressBarTopMargin(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds8));
            this.cPb.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.cPr.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void kl(int i) {
        if (this.cPb != null) {
            this.cPb.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void J(bd bdVar) {
        if (bdVar != null && bdVar.rj() != null) {
            long longValue = bdVar.rj().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = bdVar.rj().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        av avVar = new av();
                        avVar.fe(true);
                        avVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(avVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.cPb.setBoallotsForListView(linkedList);
                    this.cPb.onChangeSkinType(getSkinType());
                    this.cPb.setVisibility(0);
                    return;
                }
                this.cPb.setVisibility(8);
            }
        }
    }
}
