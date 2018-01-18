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
    private VoteView dII;

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
            this.dII = (VoteView) findViewById;
            this.dII.setWidth(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds560));
            this.dII.setProgressBarHeight(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds20));
            this.dII.setDescTextColorResId(d.C0107d.cp_cont_b);
            this.dII.setProgressBarTopMargin(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds8));
            this.dII.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.dIY.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void no(int i) {
        if (this.dII != null) {
            this.dII.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void P(bd bdVar) {
        if (bdVar != null && bdVar.yE() != null) {
            long longValue = bdVar.yE().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = bdVar.yE().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        ax axVar = new ax();
                        axVar.fP(true);
                        axVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(axVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.dII.setBoallotsForListView(linkedList);
                    this.dII.onChangeSkinType(getSkinType());
                    this.dII.setVisibility(0);
                    return;
                }
                this.dII.setVisibility(8);
            }
        }
    }
}
