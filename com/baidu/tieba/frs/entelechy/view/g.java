package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.au;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class g extends i {
    private VoteView cpC;

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
            this.cpC = (VoteView) findViewById;
            this.cpC.setWidth(com.baidu.adp.lib.util.k.g(getContext(), d.f.ds560));
            this.cpC.setProgressBarHeight(com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20));
            this.cpC.setDescTextColorResId(d.e.cp_cont_b);
            this.cpC.setProgressBarTopMargin(com.baidu.adp.lib.util.k.g(getContext(), d.f.ds8));
            this.cpC.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.cpS.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void iY(int i) {
        if (this.cpC != null) {
            this.cpC.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void H(bl blVar) {
        if (blVar != null && blVar.rt() != null) {
            long longValue = blVar.rt().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = blVar.rt().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        au auVar = new au();
                        auVar.eQ(true);
                        auVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(auVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.cpC.setBoallotsForListView(linkedList);
                    this.cpC.onChangeSkinType(getSkinType());
                    this.cpC.setVisibility(0);
                    return;
                }
                this.cpC.setVisibility(8);
            }
        }
    }
}
