package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ax;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes2.dex */
public class g extends i {
    private VoteView dEh;

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
            this.dEh = (VoteView) findViewById;
            this.dEh.setWidth(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds560));
            this.dEh.setProgressBarHeight(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds20));
            this.dEh.setDescTextColorResId(d.C0108d.cp_cont_b);
            this.dEh.setProgressBarTopMargin(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds8));
            this.dEh.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.dEx.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void nl(int i) {
        if (this.dEh != null) {
            this.dEh.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void P(be beVar) {
        if (beVar != null && beVar.yJ() != null) {
            long longValue = beVar.yJ().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = beVar.yJ().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        ax axVar = new ax();
                        axVar.fL(true);
                        axVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(axVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.dEh.setBoallotsForListView(linkedList);
                    this.dEh.onChangeSkinType(getSkinType());
                    this.dEh.setVisibility(0);
                    return;
                }
                this.dEh.setVisibility(8);
            }
        }
    }
}
