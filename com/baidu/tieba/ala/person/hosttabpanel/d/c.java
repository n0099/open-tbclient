package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.p;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class c extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.b> {
    private com.baidu.live.m.c fgG;
    private RelativeLayout foK;
    private LinearLayout foL;
    private boolean foM;
    private com.baidu.tieba.ala.person.hosttabpanel.b.b foN;
    private CustomMessageListener foO;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.foM = false;
        this.foO = new CustomMessageListener(2913067) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && c.this.foL != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() <= 0) {
                        c.this.foL.setVisibility(8);
                    } else {
                        c.this.foL.setVisibility(0);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.foK = (RelativeLayout) this.mRootView.findViewById(a.g.rank_list_container);
        this.mRootView.setOnClickListener(this);
        this.foL = (LinearLayout) this.mRootView.findViewById(a.g.rank_list_entry_layout);
        MessageManager.getInstance().registerListener(this.foO);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.h.ala_new_host_tab_ranklist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.b bVar) {
        if (!this.foM) {
            this.foN = bVar;
            c(bVar.liveType, bVar.fog, bVar.portrait);
            this.foM = true;
        }
    }

    private void c(int i, long j, String str) {
        if (this.fgG == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, com.baidu.live.m.c.class, new com.baidu.live.m.a(this.mTbPageContext.getPageActivity(), i, j, false, str));
            if (runTask != null && runTask.getData() != null) {
                this.fgG = (com.baidu.live.m.c) runTask.getData();
            }
        }
        if (this.fgG != null && this.fgG.wI() != null) {
            View wI = this.fgG.wI();
            wI.setBackgroundResource(0);
            a(this.fgG.wJ());
            a(this.fgG.wK());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40));
            layoutParams.addRule(15, 1);
            layoutParams.addRule(9, 1);
            this.foK.addView(wI, layoutParams);
        }
    }

    private void a(com.baidu.live.m.b bVar) {
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
        if ((view == this.mRootView || ((this.fgG.wJ() != null && view == this.fgG.wJ().getRankItemRootView()) || (this.fgG.wK() != null && view == this.fgG.wK().getRankItemRootView()))) && this.foN != null && this.foN.fog != 0) {
            p pVar = new p();
            pVar.liveType = this.foN.liveType;
            pVar.userId = this.foN.fog;
            pVar.portrait = this.foN.portrait;
            com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
            cVar.arY = pVar;
            cVar.arZ = (short) 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public c fod;

        public a(c cVar) {
            super(cVar.getView());
            this.fod = cVar;
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        if (this.fgG != null) {
            this.fgG.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.foO);
    }
}
