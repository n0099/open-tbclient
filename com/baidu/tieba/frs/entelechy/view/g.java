package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.av;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class g extends i {
    private VoteView cFx;

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
            this.cFx = (VoteView) findViewById;
            this.cFx.setWidth(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds560));
            this.cFx.setProgressBarHeight(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20));
            this.cFx.setDescTextColorResId(d.C0080d.cp_cont_b);
            this.cFx.setProgressBarTopMargin(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds8));
            this.cFx.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.cFN.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void jO(int i) {
        if (this.cFx != null) {
            this.cFx.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void H(bh bhVar) {
        if (bhVar != null && bhVar.rf() != null) {
            long longValue = bhVar.rf().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = bhVar.rf().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        av avVar = new av();
                        avVar.eI(true);
                        avVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(avVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.cFx.setBoallotsForListView(linkedList);
                    this.cFx.onChangeSkinType(getSkinType());
                    this.cFx.setVisibility(0);
                    return;
                }
                this.cFx.setVisibility(8);
            }
        }
    }
}
