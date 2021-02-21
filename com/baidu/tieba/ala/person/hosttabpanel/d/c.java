package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.am;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class c extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.b> {
    private com.baidu.live.x.c hNQ;
    private RelativeLayout hWB;
    private LinearLayout hWC;
    private boolean hWD;
    private com.baidu.tieba.ala.person.hosttabpanel.b.b hWE;
    private CustomMessageListener hWF;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hWD = false;
        this.hWF = new CustomMessageListener(2913067) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && c.this.hWC != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() <= 0) {
                        c.this.hWC.setVisibility(8);
                    } else {
                        c.this.hWC.setVisibility(0);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hWB = (RelativeLayout) this.mRootView.findViewById(a.f.rank_list_container);
        this.mRootView.setOnClickListener(this);
        this.hWC = (LinearLayout) this.mRootView.findViewById(a.f.rank_list_entry_layout);
        MessageManager.getInstance().registerListener(this.hWF);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.g.ala_new_host_tab_ranklist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.b bVar) {
        if (!this.hWD) {
            this.hWE = bVar;
            e(bVar.liveType, bVar.hVX, bVar.portrait);
            this.hWD = true;
        }
    }

    private void e(int i, long j, String str) {
        if (this.hNQ == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, com.baidu.live.x.c.class, new com.baidu.live.x.a(this.mTbPageContext.getPageActivity(), i, j, false, str));
            if (runTask != null && runTask.getData() != null) {
                this.hNQ = (com.baidu.live.x.c) runTask.getData();
            }
        }
        if (this.hNQ != null && this.hNQ.Px() != null) {
            View Px = this.hNQ.Px();
            Px.setBackgroundResource(0);
            a(this.hNQ.Py());
            a(this.hNQ.Pz());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds40));
            layoutParams.addRule(15, 1);
            layoutParams.addRule(9, 1);
            this.hWB.addView(Px, layoutParams);
        }
    }

    private void a(com.baidu.live.x.b bVar) {
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
        if ((view == this.mRootView || ((this.hNQ.Py() != null && view == this.hNQ.Py().getRankItemRootView()) || (this.hNQ.Pz() != null && view == this.hNQ.Pz().getRankItemRootView()))) && this.hWE != null && this.hWE.hVX != 0) {
            am amVar = new am();
            amVar.liveType = this.hWE.liveType;
            amVar.userId = this.hWE.hVX;
            amVar.portrait = this.hWE.portrait;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.brD = amVar;
            cVar.brE = (short) 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public c hVU;

        public a(c cVar) {
            super(cVar.getView());
            this.hVU = cVar;
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        if (this.hNQ != null) {
            this.hNQ.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.hWF);
    }
}
