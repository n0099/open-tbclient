package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.cz;
import com.baidu.tieba.w;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class al extends as {
    private VoteView bTD;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(w.h.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(w.h.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bTD = (VoteView) findViewById;
            this.bTD.setWidth(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds560));
            this.bTD.setProgressBarHeight(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20));
            this.bTD.setDescTextColorResId(w.e.cp_cont_b);
            this.bTD.setProgressBarTopMargin(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds8));
            this.bTD.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bTM.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void ig(int i) {
        if (this.bTD != null) {
            this.bTD.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void t(bi biVar) {
        if (biVar != null && biVar.sd() != null) {
            long longValue = biVar.sd().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = biVar.sd().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        cz czVar = new cz();
                        czVar.dU(true);
                        czVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(czVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bTD.setBoallotsForListView(linkedList);
                    this.bTD.onChangeSkinType(getSkinType());
                    this.bTD.setVisibility(0);
                    return;
                }
                this.bTD.setVisibility(8);
            }
        }
    }
}
