package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.fx;
import com.baidu.tieba.t;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class al extends am {
    private VoteView bpU;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.c.am
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(t.g.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(t.g.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bpU = (VoteView) findViewById;
            this.bpU.setWidth(com.baidu.adp.lib.util.k.c(getContext(), t.e.ds560));
            this.bpU.setProgressBarHeight(com.baidu.adp.lib.util.k.c(getContext(), t.e.ds20));
            this.bpU.setDescTextColorResId(t.d.cp_cont_b);
            this.bpU.setProgressBarTopMargin(com.baidu.adp.lib.util.k.c(getContext(), t.e.ds8));
            this.bpU.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bpW.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.c(getContext(), t.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.c.am
    protected void gB(int i) {
        if (this.bpU != null) {
            this.bpU.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.c.am
    protected void k(ax axVar) {
        if (axVar != null && axVar.qL() != null) {
            long longValue = axVar.qL().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = axVar.qL().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        fx fxVar = new fx();
                        fxVar.dc(true);
                        fxVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(fxVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bpU.setBoallotsForListView(linkedList);
                    this.bpU.onChangeSkinType(getSkinType());
                    this.bpU.setVisibility(0);
                    return;
                }
                this.bpU.setVisibility(8);
            }
        }
    }
}
