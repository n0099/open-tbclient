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
import com.baidu.tieba.frs.aw;
import java.util.LinkedList;
import java.util.List;
import tbclient.PollOption;
/* loaded from: classes.dex */
public class g extends i {
    private VoteView cPm;

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
            this.cPm = (VoteView) findViewById;
            this.cPm.setWidth(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds560));
            this.cPm.setProgressBarHeight(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20));
            this.cPm.setDescTextColorResId(d.C0096d.cp_cont_b);
            this.cPm.setProgressBarTopMargin(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds8));
            this.cPm.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.cPC.getLayoutParams()).topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void kn(int i) {
        if (this.cPm != null) {
            this.cPm.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void L(bd bdVar) {
        if (bdVar != null && bdVar.rh() != null) {
            long longValue = bdVar.rh().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = bdVar.rh().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        aw awVar = new aw();
                        awVar.ff(true);
                        awVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(awVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.cPm.setBoallotsForListView(linkedList);
                    this.cPm.onChangeSkinType(getSkinType());
                    this.cPm.setVisibility(0);
                    return;
                }
                this.cPm.setVisibility(8);
            }
        }
    }
}
