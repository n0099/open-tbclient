package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.w;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class al extends as {
    private VoteView bTP;

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
            this.bTP = (VoteView) findViewById;
            this.bTP.setWidth(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds560));
            this.bTP.setProgressBarHeight(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20));
            this.bTP.setDescTextColorResId(w.e.cp_cont_b);
            this.bTP.setProgressBarTopMargin(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds8));
            this.bTP.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bTY.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void id(int i) {
        if (this.bTP != null) {
            this.bTP.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.as
    protected void t(bj bjVar) {
        if (bjVar != null && bjVar.rF() != null) {
            long longValue = bjVar.rF().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = bjVar.rF().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        cx cxVar = new cx();
                        cxVar.dS(true);
                        cxVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(cxVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bTP.setBoallotsForListView(linkedList);
                    this.bTP.onChangeSkinType(getSkinType());
                    this.bTP.setVisibility(0);
                    return;
                }
                this.bTP.setVisibility(8);
            }
        }
    }
}
