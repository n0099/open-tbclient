package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.ai;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class c extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.b> {
    private com.baidu.live.z.c hJe;
    private RelativeLayout hRS;
    private LinearLayout hRT;
    private boolean hRU;
    private com.baidu.tieba.ala.person.hosttabpanel.b.b hRV;
    private CustomMessageListener hRW;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hRU = false;
        this.hRW = new CustomMessageListener(2913067) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && c.this.hRT != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() <= 0) {
                        c.this.hRT.setVisibility(8);
                    } else {
                        c.this.hRT.setVisibility(0);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hRS = (RelativeLayout) this.mRootView.findViewById(a.f.rank_list_container);
        this.mRootView.setOnClickListener(this);
        this.hRT = (LinearLayout) this.mRootView.findViewById(a.f.rank_list_entry_layout);
        MessageManager.getInstance().registerListener(this.hRW);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.g.ala_new_host_tab_ranklist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.b bVar) {
        if (!this.hRU) {
            this.hRV = bVar;
            j(bVar.liveType, bVar.hRo, bVar.portrait);
            this.hRU = true;
        }
    }

    private void j(int i, long j, String str) {
        if (this.hJe == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, com.baidu.live.z.c.class, new com.baidu.live.z.a(this.mTbPageContext.getPageActivity(), i, j, false, str));
            if (runTask != null && runTask.getData() != null) {
                this.hJe = (com.baidu.live.z.c) runTask.getData();
            }
        }
        if (this.hJe != null && this.hJe.NY() != null) {
            View NY = this.hJe.NY();
            NY.setBackgroundResource(0);
            a(this.hJe.NZ());
            a(this.hJe.Oa());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds40));
            layoutParams.addRule(15, 1);
            layoutParams.addRule(9, 1);
            this.hRS.addView(NY, layoutParams);
        }
    }

    private void a(com.baidu.live.z.b bVar) {
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
        if ((view == this.mRootView || ((this.hJe.NZ() != null && view == this.hJe.NZ().getRankItemRootView()) || (this.hJe.Oa() != null && view == this.hJe.Oa().getRankItemRootView()))) && this.hRV != null && this.hRV.hRo != 0) {
            ai aiVar = new ai();
            aiVar.liveType = this.hRV.liveType;
            aiVar.userId = this.hRV.hRo;
            aiVar.portrait = this.hRV.portrait;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.boc = aiVar;
            cVar.bod = (short) 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public c hRl;

        public a(c cVar) {
            super(cVar.getView());
            this.hRl = cVar;
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        if (this.hJe != null) {
            this.hJe.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.hRW);
    }
}
