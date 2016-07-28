package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.u;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class al extends am {
    private VoteView bMp;

    public al(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.am
    public void initView() {
        super.initView();
        View findViewById = this.mRootView.findViewById(u.g.text_vote_view);
        if (findViewById == null) {
            findViewById = ((ViewStub) this.mRootView.findViewById(u.g.text_vote_view_stub)).inflate();
        }
        if (findViewById != null) {
            this.bMp = (VoteView) findViewById;
            this.bMp.setWidth(com.baidu.adp.lib.util.k.c(getContext(), u.e.ds560));
            this.bMp.setProgressBarHeight(com.baidu.adp.lib.util.k.c(getContext(), u.e.ds20));
            this.bMp.setDescTextColorResId(u.d.cp_cont_b);
            this.bMp.setProgressBarTopMargin(com.baidu.adp.lib.util.k.c(getContext(), u.e.ds8));
            this.bMp.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.bMr.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.am
    protected void hD(int i) {
        if (this.bMp != null) {
            this.bMp.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.am
    protected void l(be beVar) {
        if (beVar != null && beVar.qo() != null) {
            long longValue = beVar.qo().total_poll.longValue();
            long j = longValue < 0 ? 0L : longValue;
            List<PollOption> list = beVar.qo().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        ec ecVar = new ec();
                        ecVar.dw(true);
                        ecVar.a(linkedList.size() + 1, pollOption, j);
                        linkedList.add(ecVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.bMp.setBoallotsForListView(linkedList);
                    this.bMp.onChangeSkinType(getSkinType());
                    this.bMp.setVisibility(0);
                    return;
                }
                this.bMp.setVisibility(8);
            }
        }
    }
}
