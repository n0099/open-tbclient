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
    private VoteView cnJ;

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
            this.cnJ = (VoteView) findViewById;
            this.cnJ.setWidth(com.baidu.adp.lib.util.k.g(getContext(), d.f.ds560));
            this.cnJ.setProgressBarHeight(com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20));
            this.cnJ.setDescTextColorResId(d.e.cp_cont_b);
            this.cnJ.setProgressBarTopMargin(com.baidu.adp.lib.util.k.g(getContext(), d.f.ds8));
            this.cnJ.setDescTopMargin(0);
            try {
                ((ViewGroup.MarginLayoutParams) this.cnZ.getLayoutParams()).topMargin = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds38);
            } catch (ClassCastException e) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void iW(int i) {
        if (this.cnJ != null) {
            this.cnJ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.i
    protected void H(bl blVar) {
        if (blVar != null && blVar.rj() != null) {
            long longValue = blVar.rj().total_poll.longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            List<PollOption> list = blVar.rj().options;
            if (list != null && !list.isEmpty()) {
                LinkedList linkedList = new LinkedList();
                for (PollOption pollOption : list) {
                    if (pollOption != null && !StringUtils.isNull(pollOption.text)) {
                        if (linkedList.size() >= 3) {
                            break;
                        }
                        au auVar = new au();
                        auVar.eO(true);
                        auVar.a(linkedList.size() + 1, pollOption, longValue);
                        linkedList.add(auVar);
                    }
                }
                if (linkedList.size() > 0) {
                    this.cnJ.setBoallotsForListView(linkedList);
                    this.cnJ.onChangeSkinType(getSkinType());
                    this.cnJ.setVisibility(0);
                    return;
                }
                this.cnJ.setVisibility(8);
            }
        }
    }
}
