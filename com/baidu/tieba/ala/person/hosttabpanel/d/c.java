package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.ae;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.b> {
    private RelativeLayout hAZ;
    private LinearLayout hBa;
    private boolean hBb;
    private com.baidu.tieba.ala.person.hosttabpanel.b.b hBc;
    private CustomMessageListener hBd;
    private com.baidu.live.u.c hsw;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hBb = false;
        this.hBd = new CustomMessageListener(2913067) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && c.this.hBa != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() <= 0) {
                        c.this.hBa.setVisibility(8);
                    } else {
                        c.this.hBa.setVisibility(0);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hAZ = (RelativeLayout) this.mRootView.findViewById(a.f.rank_list_container);
        this.mRootView.setOnClickListener(this);
        this.hBa = (LinearLayout) this.mRootView.findViewById(a.f.rank_list_entry_layout);
        MessageManager.getInstance().registerListener(this.hBd);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.g.ala_new_host_tab_ranklist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.b bVar) {
        if (!this.hBb) {
            this.hBc = bVar;
            h(bVar.liveType, bVar.hAv, bVar.portrait);
            this.hBb = true;
        }
    }

    private void h(int i, long j, String str) {
        if (this.hsw == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, com.baidu.live.u.c.class, new com.baidu.live.u.a(this.mTbPageContext.getPageActivity(), i, j, false, str));
            if (runTask != null && runTask.getData() != null) {
                this.hsw = (com.baidu.live.u.c) runTask.getData();
            }
        }
        if (this.hsw != null && this.hsw.Pf() != null) {
            View Pf = this.hsw.Pf();
            Pf.setBackgroundResource(0);
            a(this.hsw.Pg());
            a(this.hsw.Ph());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds40));
            layoutParams.addRule(15, 1);
            layoutParams.addRule(9, 1);
            this.hAZ.addView(Pf, layoutParams);
        }
    }

    private void a(com.baidu.live.u.b bVar) {
        if (bVar != null) {
            TextView rankLevelView = bVar.getRankLevelView();
            TextView rankNameView = bVar.getRankNameView();
            View rankItemRootView = bVar.getRankItemRootView();
            if (rankLevelView != null) {
                rankLevelView.setTextSize(0, this.mPageContext.getResources().getDimension(a.d.sdk_ds32));
                rankLevelView.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_cp_cont_b));
            }
            if (rankNameView != null) {
                rankNameView.setTextSize(0, this.mPageContext.getResources().getDimension(a.d.sdk_ds32));
                rankNameView.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_cp_cont_b));
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
        if ((view == this.mRootView || ((this.hsw.Pg() != null && view == this.hsw.Pg().getRankItemRootView()) || (this.hsw.Ph() != null && view == this.hsw.Ph().getRankItemRootView()))) && this.hBc != null && this.hBc.hAv != 0) {
            ae aeVar = new ae();
            aeVar.liveType = this.hBc.liveType;
            aeVar.userId = this.hBc.hAv;
            aeVar.portrait = this.hBc.portrait;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bny = aeVar;
            cVar.bnz = (short) 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public c hAs;

        public a(c cVar) {
            super(cVar.getView());
            this.hAs = cVar;
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        if (this.hsw != null) {
            this.hsw.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.hBd);
    }
}
