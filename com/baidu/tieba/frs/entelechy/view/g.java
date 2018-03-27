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
    private VoteView dLX;

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
            this.dLX = (VoteView) findViewById;
            this.dLX.setWidth(com.baidu.adp.lib.util.l.t(getContext(), d.e.ds560));
            this.dLX.setProgressBarHeight(com.baidu.adp.lib.util.l.t(getContext(), d.e.ds20));
            this.dLX.setDescTextColorResId(d.C0141d.cp_cont_b);
            this.dLX.setProgressBarTopMargin(com.baidu.adp.lib.util.l.t(getContext(), d.e.ds8));
            this.dLX.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.dMn.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void nm(int i) {
        if (this.dLX != null) {
            this.dLX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void S(bd bdVar) {
        if (bdVar != null && bdVar.yZ() != null) {
            long longValue = bdVar.yZ().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = bdVar.yZ().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        ax axVar = new ax();
                        axVar.fZ(true);
                        axVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(axVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.dLX.setBoallotsForListView(linkedList);
                    this.dLX.onChangeSkinType(getSkinType());
                    this.dLX.setVisibility(0);
                    return;
                }
                this.dLX.setVisibility(8);
            }
        }
    }
}
