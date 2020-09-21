package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.b> {
    private com.baidu.live.s.c gLL;
    private RelativeLayout gUi;
    private LinearLayout gUj;
    private boolean gUk;
    private com.baidu.tieba.ala.person.hosttabpanel.b.b gUl;
    private CustomMessageListener gUm;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gUk = false;
        this.gUm = new CustomMessageListener(2913067) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && c.this.gUj != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() <= 0) {
                        c.this.gUj.setVisibility(8);
                    } else {
                        c.this.gUj.setVisibility(0);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gUi = (RelativeLayout) this.mRootView.findViewById(a.g.rank_list_container);
        this.mRootView.setOnClickListener(this);
        this.gUj = (LinearLayout) this.mRootView.findViewById(a.g.rank_list_entry_layout);
        MessageManager.getInstance().registerListener(this.gUm);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.h.ala_new_host_tab_ranklist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.b bVar) {
        if (!this.gUk) {
            this.gUl = bVar;
            c(bVar.liveType, bVar.gTE, bVar.portrait);
            this.gUk = true;
        }
    }

    private void c(int i, long j, String str) {
        if (this.gLL == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, com.baidu.live.s.c.class, new com.baidu.live.s.a(this.mTbPageContext.getPageActivity(), i, j, false, str));
            if (runTask != null && runTask.getData() != null) {
                this.gLL = (com.baidu.live.s.c) runTask.getData();
            }
        }
        if (this.gLL != null && this.gLL.Nc() != null) {
            View Nc = this.gLL.Nc();
            Nc.setBackgroundResource(0);
            a(this.gLL.Nd());
            a(this.gLL.Ne());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40));
            layoutParams.addRule(15, 1);
            layoutParams.addRule(9, 1);
            this.gUi.addView(Nc, layoutParams);
        }
    }

    private void a(com.baidu.live.s.b bVar) {
        if (bVar != null) {
            TextView rankLevelView = bVar.getRankLevelView();
            TextView rankNameView = bVar.getRankNameView();
            View rankItemRootView = bVar.getRankItemRootView();
            if (rankLevelView != null) {
                rankLevelView.setTextSize(0, this.mPageContext.getResources().getDimension(a.e.sdk_ds32));
                rankLevelView.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_b));
            }
            if (rankNameView != null) {
                rankNameView.setTextSize(0, this.mPageContext.getResources().getDimension(a.e.sdk_ds32));
                rankNameView.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_b));
            }
            if (rankItemRootView != null) {
                rankItemRootView.setOnClickListener(this);
                if (rankItemRootView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rankItemRootView.getLayoutParams();
                    layoutParams.width = -2;
                    rankItemRootView.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || ((this.gLL.Nd() != null && view == this.gLL.Nd().getRankItemRootView()) || (this.gLL.Ne() != null && view == this.gLL.Ne().getRankItemRootView()))) && this.gUl != null && this.gUl.gTE != 0) {
            ab abVar = new ab();
            abVar.liveType = this.gUl.liveType;
            abVar.userId = this.gUl.gTE;
            abVar.portrait = this.gUl.portrait;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bgT = abVar;
            cVar.bgU = (short) 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public c gTB;

        public a(c cVar) {
            super(cVar.getView());
            this.gTB = cVar;
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        if (this.gLL != null) {
            this.gLL.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.gUm);
    }
}
