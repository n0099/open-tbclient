package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.cr;
import com.baidu.tieba.w;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class ah extends ao {
    private VoteView bZD;

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
            this.bZD = (VoteView) findViewById;
            this.bZD.setWidth(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds560));
            this.bZD.setProgressBarHeight(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20));
            this.bZD.setDescTextColorResId(w.e.cp_cont_b);
            this.bZD.setProgressBarTopMargin(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds8));
            this.bZD.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bZT.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void iA(int i) {
        if (this.bZD != null) {
            this.bZD.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ao
    protected void C(bl blVar) {
        if (blVar != null && blVar.rj() != null) {
            long longValue = blVar.rj().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = blVar.rj().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        cr crVar = new cr();
                        crVar.el(true);
                        crVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(crVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bZD.setBoallotsForListView(linkedList);
                    this.bZD.onChangeSkinType(getSkinType());
                    this.bZD.setVisibility(0);
                    return;
                }
                this.bZD.setVisibility(8);
            }
        }
    }
}
