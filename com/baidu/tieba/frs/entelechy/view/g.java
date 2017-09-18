package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.au;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class g extends i {
    private VoteView cxa;

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
            this.cxa = (VoteView) findViewById;
            this.cxa.setWidth(com.baidu.adp.lib.util.k.f(getContext(), d.f.ds560));
            this.cxa.setProgressBarHeight(com.baidu.adp.lib.util.k.f(getContext(), d.f.ds20));
            this.cxa.setDescTextColorResId(d.e.cp_cont_b);
            this.cxa.setProgressBarTopMargin(com.baidu.adp.lib.util.k.f(getContext(), d.f.ds8));
            this.cxa.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.cxq.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.f(getContext(), d.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void jo(int i) {
        if (this.cxa != null) {
            this.cxa.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void L(bj bjVar) {
        if (bjVar != null && bjVar.rp() != null) {
            long longValue = bjVar.rp().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = bjVar.rp().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        au auVar = new au();
                        auVar.eU(true);
                        auVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(auVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.cxa.setBoallotsForListView(linkedList);
                    this.cxa.onChangeSkinType(getSkinType());
                    this.cxa.setVisibility(0);
                    return;
                }
                this.cxa.setVisibility(8);
            }
        }
    }
}
