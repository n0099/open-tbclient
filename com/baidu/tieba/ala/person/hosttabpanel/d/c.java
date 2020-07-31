package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.v;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.b> {
    private RelativeLayout gDW;
    private LinearLayout gDX;
    private boolean gDY;
    private com.baidu.tieba.ala.person.hosttabpanel.b.b gDZ;
    private CustomMessageListener gEa;
    private com.baidu.live.q.c gvi;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gDY = false;
        this.gEa = new CustomMessageListener(2913067) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && c.this.gDX != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() <= 0) {
                        c.this.gDX.setVisibility(8);
                    } else {
                        c.this.gDX.setVisibility(0);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gDW = (RelativeLayout) this.mRootView.findViewById(a.g.rank_list_container);
        this.mRootView.setOnClickListener(this);
        this.gDX = (LinearLayout) this.mRootView.findViewById(a.g.rank_list_entry_layout);
        MessageManager.getInstance().registerListener(this.gEa);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.h.ala_new_host_tab_ranklist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.b bVar) {
        if (!this.gDY) {
            this.gDZ = bVar;
            c(bVar.liveType, bVar.gDt, bVar.portrait);
            this.gDY = true;
        }
    }

    private void c(int i, long j, String str) {
        if (this.gvi == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, com.baidu.live.q.c.class, new com.baidu.live.q.a(this.mTbPageContext.getPageActivity(), i, j, false, str));
            if (runTask != null && runTask.getData() != null) {
                this.gvi = (com.baidu.live.q.c) runTask.getData();
            }
        }
        if (this.gvi != null && this.gvi.GI() != null) {
            View GI = this.gvi.GI();
            GI.setBackgroundResource(0);
            a(this.gvi.GJ());
            a(this.gvi.GK());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40));
            layoutParams.addRule(15, 1);
            layoutParams.addRule(9, 1);
            this.gDW.addView(GI, layoutParams);
        }
    }

    private void a(com.baidu.live.q.b bVar) {
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
        if ((view == this.mRootView || ((this.gvi.GJ() != null && view == this.gvi.GJ().getRankItemRootView()) || (this.gvi.GK() != null && view == this.gvi.GK().getRankItemRootView()))) && this.gDZ != null && this.gDZ.gDt != 0) {
            v vVar = new v();
            vVar.liveType = this.gDZ.liveType;
            vVar.userId = this.gDZ.gDt;
            vVar.portrait = this.gDZ.portrait;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.aYJ = vVar;
            cVar.aYK = (short) 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public c gDq;

        public a(c cVar) {
            super(cVar.getView());
            this.gDq = cVar;
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        if (this.gvi != null) {
            this.gvi.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.gEa);
    }
}
