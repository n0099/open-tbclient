package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.l;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class c extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.b> {
    private com.baidu.live.h.c enb;
    private RelativeLayout euf;
    private LinearLayout eug;
    private boolean euh;
    private com.baidu.tieba.ala.person.hosttabpanel.b.b eui;
    private CustomMessageListener euj;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.euh = false;
        this.euj = new CustomMessageListener(2913067) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && c.this.eug != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() <= 0) {
                        c.this.eug.setVisibility(8);
                    } else {
                        c.this.eug.setVisibility(0);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.euf = (RelativeLayout) this.mRootView.findViewById(a.g.rank_list_container);
        this.mRootView.setOnClickListener(this);
        this.eug = (LinearLayout) this.mRootView.findViewById(a.g.rank_list_entry_layout);
        MessageManager.getInstance().registerListener(this.euj);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.h.ala_new_host_tab_ranklist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.b bVar) {
        if (!this.euh) {
            this.eui = bVar;
            c(bVar.liveType, bVar.etA, bVar.portrait);
            this.euh = true;
        }
    }

    private void c(int i, long j, String str) {
        if (this.enb == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, com.baidu.live.h.c.class, new com.baidu.live.h.a(this.mTbPageContext.getPageActivity(), i, j, false, str));
            if (runTask != null && runTask.getData() != null) {
                this.enb = (com.baidu.live.h.c) runTask.getData();
            }
        }
        if (this.enb != null && this.enb.uw() != null) {
            View uw = this.enb.uw();
            uw.setBackgroundResource(0);
            a(this.enb.ux());
            a(this.enb.uy());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40));
            layoutParams.addRule(15, 1);
            layoutParams.addRule(9, 1);
            this.euf.addView(uw, layoutParams);
        }
    }

    private void a(com.baidu.live.h.b bVar) {
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
        if ((view == this.mRootView || ((this.enb.ux() != null && view == this.enb.ux().getRankItemRootView()) || (this.enb.uy() != null && view == this.enb.uy().getRankItemRootView()))) && this.eui != null && this.eui.etA != 0) {
            l lVar = new l();
            lVar.liveType = this.eui.liveType;
            lVar.userId = this.eui.etA;
            lVar.portrait = this.eui.portrait;
            com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
            cVar.ajp = lVar;
            cVar.ajq = (short) 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes6.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public c etx;

        public a(c cVar) {
            super(cVar.getView());
            this.etx = cVar;
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        if (this.enb != null) {
            this.enb.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.euj);
    }
}
