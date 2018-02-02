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
import com.baidu.tieba.frs.ax;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes2.dex */
public class g extends i {
    private VoteView dJd;

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
            this.dJd = (VoteView) findViewById;
            this.dJd.setWidth(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds560));
            this.dJd.setProgressBarHeight(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds20));
            this.dJd.setDescTextColorResId(d.C0108d.cp_cont_b);
            this.dJd.setProgressBarTopMargin(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds8));
            this.dJd.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.dJt.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void no(int i) {
        if (this.dJd != null) {
            this.dJd.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void P(bd bdVar) {
        if (bdVar != null && bdVar.yF() != null) {
            long longValue = bdVar.yF().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = bdVar.yF().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        ax axVar = new ax();
                        axVar.fS(true);
                        axVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(axVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.dJd.setBoallotsForListView(linkedList);
                    this.dJd.onChangeSkinType(getSkinType());
                    this.dJd.setVisibility(0);
                    return;
                }
                this.dJd.setVisibility(8);
            }
        }
    }
}
