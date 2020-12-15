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
    private com.baidu.live.y.c hBJ;
    private RelativeLayout hKn;
    private LinearLayout hKo;
    private boolean hKp;
    private com.baidu.tieba.ala.person.hosttabpanel.b.b hKq;
    private CustomMessageListener hKr;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hKp = false;
        this.hKr = new CustomMessageListener(2913067) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && c.this.hKo != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() <= 0) {
                        c.this.hKo.setVisibility(8);
                    } else {
                        c.this.hKo.setVisibility(0);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hKn = (RelativeLayout) this.mRootView.findViewById(a.f.rank_list_container);
        this.mRootView.setOnClickListener(this);
        this.hKo = (LinearLayout) this.mRootView.findViewById(a.f.rank_list_entry_layout);
        MessageManager.getInstance().registerListener(this.hKr);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.g.ala_new_host_tab_ranklist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.b bVar) {
        if (!this.hKp) {
            this.hKq = bVar;
            h(bVar.liveType, bVar.hJJ, bVar.portrait);
            this.hKp = true;
        }
    }

    private void h(int i, long j, String str) {
        if (this.hBJ == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, com.baidu.live.y.c.class, new com.baidu.live.y.a(this.mTbPageContext.getPageActivity(), i, j, false, str));
            if (runTask != null && runTask.getData() != null) {
                this.hBJ = (com.baidu.live.y.c) runTask.getData();
            }
        }
        if (this.hBJ != null && this.hBJ.QQ() != null) {
            View QQ = this.hBJ.QQ();
            QQ.setBackgroundResource(0);
            a(this.hBJ.QR());
            a(this.hBJ.QS());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds40));
            layoutParams.addRule(15, 1);
            layoutParams.addRule(9, 1);
            this.hKn.addView(QQ, layoutParams);
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
        if ((view == this.mRootView || ((this.hBJ.QR() != null && view == this.hBJ.QR().getRankItemRootView()) || (this.hBJ.QS() != null && view == this.hBJ.QS().getRankItemRootView()))) && this.hKq != null && this.hKq.hJJ != 0) {
            ag agVar = new ag();
            agVar.liveType = this.hKq.liveType;
            agVar.userId = this.hKq.hJJ;
            agVar.portrait = this.hKq.portrait;
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
        public c hJG;

        public a(c cVar) {
            super(cVar.getView());
            this.hJG = cVar;
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        if (this.hBJ != null) {
            this.hBJ.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.hKr);
    }
}
