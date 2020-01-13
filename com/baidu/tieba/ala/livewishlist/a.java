package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.r;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.g;
import com.baidu.live.data.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.i.a, ScrollTextView.c {
    private l aiW;
    private ViewGroup erT;
    private ViewGroup.LayoutParams erU;
    private ViewGroup erV;
    protected WishListEntryView flQ;
    private Context mContext;
    private BdUniqueId esx = BdUniqueId.gen();
    private boolean erZ = true;
    private boolean flR = true;
    private boolean flS = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.erT = viewGroup;
        this.erU = layoutParams;
        bbB();
    }

    private void bbB() {
        this.erV = new FrameLayout(this.erT.getContext());
        this.erV.setBackgroundColor(0);
        this.erT.addView(this.erV, this.erU);
    }

    @Override // com.baidu.live.i.a
    public void a(l lVar) {
        if (lVar != null && lVar.mLiveInfo != null) {
            this.aiW = lVar;
            if (this.erV == null || this.erT.indexOfChild(this.erV) < 0) {
                bbB();
                this.erV.setVisibility(this.erZ ? 0 : 8);
            }
            if (this.flQ == null || (this.erV != null && this.erV.indexOfChild(this.flQ) < 0)) {
                this.flQ = new WishListEntryView(this.erV.getContext());
                this.erV.addView(this.flQ, new FrameLayout.LayoutParams(-2, -2));
                this.flQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.uj();
                    }
                });
                this.flQ.setOnScrollTextViewChangeListener(this);
            }
            if (this.flS) {
                if (this.flQ != null) {
                    this.flQ.X(this.aiW.Wv);
                }
                this.flS = false;
            }
            if (ListUtils.isEmpty(this.aiW.Wv) || this.aiW.Wv.size() == 1) {
                this.flS = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, lVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void uj() {
        if (this.aiW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.aiW, String.valueOf(this.aiW.mLiveInfo.live_id), String.valueOf(this.aiW.Wf.userId), this.flR)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(g gVar) {
    }

    @Override // com.baidu.live.i.a
    public void aM(boolean z) {
        this.flR = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.flQ != null && this.flQ.getView() != null) {
            this.flQ.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.flQ != null && this.aiW != null) {
            this.flQ.W(this.aiW.Wv);
        }
    }

    @Override // com.baidu.live.i.a
    public void uk() {
        hL(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        hL(true);
    }

    private void reset(boolean z) {
        this.erZ = true;
        hL(z);
    }

    private void hL(boolean z) {
        if (this.flQ != null && (this.flQ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.flQ.getParent()).removeView(this.flQ);
        }
        if (z && this.erV != null && (this.erV.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.erV.getParent()).removeView(this.erV);
        }
    }
}
