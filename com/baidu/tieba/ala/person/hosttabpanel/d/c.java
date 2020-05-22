package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.b> {
    private com.baidu.live.p.c gdc;
    private CustomMessageListener glA;
    private RelativeLayout glw;
    private LinearLayout glx;
    private boolean gly;
    private com.baidu.tieba.ala.person.hosttabpanel.b.b glz;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gly = false;
        this.glA = new CustomMessageListener(2913067) { // from class: com.baidu.tieba.ala.person.hosttabpanel.d.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && c.this.glx != null) {
                    if (((Integer) customResponsedMessage.getData()).intValue() <= 0) {
                        c.this.glx.setVisibility(8);
                    } else {
                        c.this.glx.setVisibility(0);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.glw = (RelativeLayout) this.mRootView.findViewById(a.g.rank_list_container);
        this.mRootView.setOnClickListener(this);
        this.glx = (LinearLayout) this.mRootView.findViewById(a.g.rank_list_entry_layout);
        MessageManager.getInstance().registerListener(this.glA);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.h.ala_new_host_tab_ranklist;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.b bVar) {
        if (!this.gly) {
            this.glz = bVar;
            c(bVar.liveType, bVar.gkT, bVar.portrait);
            this.gly = true;
        }
    }

    private void c(int i, long j, String str) {
        if (this.gdc == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, com.baidu.live.p.c.class, new com.baidu.live.p.a(this.mTbPageContext.getPageActivity(), i, j, false, str));
            if (runTask != null && runTask.getData() != null) {
                this.gdc = (com.baidu.live.p.c) runTask.getData();
            }
        }
        if (this.gdc != null && this.gdc.FS() != null) {
            View FS = this.gdc.FS();
            FS.setBackgroundResource(0);
            a(this.gdc.FT());
            a(this.gdc.FU());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds40));
            layoutParams.addRule(15, 1);
            layoutParams.addRule(9, 1);
            this.glw.addView(FS, layoutParams);
        }
    }

    private void a(com.baidu.live.p.b bVar) {
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
        if ((view == this.mRootView || ((this.gdc.FT() != null && view == this.gdc.FT().getRankItemRootView()) || (this.gdc.FU() != null && view == this.gdc.FU().getRankItemRootView()))) && this.glz != null && this.glz.gkT != 0) {
            u uVar = new u();
            uVar.liveType = this.glz.liveType;
            uVar.userId = this.glz.gkT;
            uVar.portrait = this.glz.portrait;
            com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
            cVar.aWc = uVar;
            cVar.aWd = (short) 5;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913042, cVar));
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public c gkQ;

        public a(c cVar) {
            super(cVar.getView());
            this.gkQ = cVar;
        }
    }

    @Override // com.baidu.live.tieba.b.a
    public void onDestroy() {
        if (this.gdc != null) {
            this.gdc.destory();
        }
        MessageManager.getInstance().unRegisterListener(this.glA);
    }
}
