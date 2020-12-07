package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.ag;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.b> {
    private com.baidu.live.y.c hBH;
    private RelativeLayout hKl;
    private LinearLayout hKm;
    private boolean hKn;
    private com.baidu.tieba.ala.person.hosttabpanel.b.b hKo;
    private CustomMessageListener hKp;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hKn = false;
        this.hKp = new CustomMessageListener(2913067) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && c.this.hKm != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() <= 0) {
                        c.this.hKm.setVisibility(8);
                    } else {
                        c.this.hKm.setVisibility(0);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hKl = (RelativeLayout) this.mRootView.findViewById(a.f.rank_list_container);
        this.mRootView.setOnClickListener(this);
        this.hKm = (LinearLayout) this.mRootView.findViewById(a.f.rank_list_entry_layout);
        MessageManager.getInstance().registerListener(this.hKp);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.g.ala_new_host_tab_ranklist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.b bVar) {
        if (!this.hKn) {
            this.hKo = bVar;
            h(bVar.liveType, bVar.hJH, bVar.portrait);
            this.hKn = true;
        }
    }

    private void h(int i, long j, String str) {
        if (this.hBH == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, com.baidu.live.y.c.class, new com.baidu.live.y.a(this.mTbPageContext.getPageActivity(), i, j, false, str));
            if (runTask != null && runTask.getData() != null) {
                this.hBH = (com.baidu.live.y.c) runTask.getData();
            }
        }
        if (this.hBH != null && this.hBH.QQ() != null) {
            View QQ = this.hBH.QQ();
            QQ.setBackgroundResource(0);
            a(this.hBH.QR());
            a(this.hBH.QS());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds40));
            layoutParams.addRule(15, 1);
            layoutParams.addRule(9, 1);
            this.hKl.addView(QQ, layoutParams);
        }
    }

    private void a(com.baidu.live.y.b bVar) {
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
        if ((view == this.mRootView || ((this.hBH.QR() != null && view == this.hBH.QR().getRankItemRootView()) || (this.hBH.QS() != null && view == this.hBH.QS().getRankItemRootView()))) && this.hKo != null && this.hKo.hJH != 0) {
            ag agVar = new ag();
            agVar.liveType = this.hKo.liveType;
            agVar.userId = this.hKo.hJH;
            agVar.portrait = this.hKo.portrait;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.bqU = agVar;
            cVar.bqV = (short) 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public c hJE;

        public a(c cVar) {
            super(cVar.getView());
            this.hJE = cVar;
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        if (this.hBH != null) {
            this.hBH.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.hKp);
    }
}
