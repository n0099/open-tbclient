package com.baidu.tieba.ala.livewishlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.b.t;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.n;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.widget.ScrollTextView;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.i.a, ScrollTextView.c {
    private u aAP;
    private ViewGroup gQL;
    protected WishListEntryView gQM;
    private ViewGroup gcM;
    private ViewGroup.LayoutParams gsI;
    private Context mContext;
    private BdUniqueId fUp = BdUniqueId.gen();
    private boolean fTM = true;
    private boolean gQN = true;
    private boolean gQO = true;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.i.a
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null) {
            reset(true);
            this.gcM = viewGroup;
            this.gsI = layoutParams;
            bJu();
        }
    }

    private void bJu() {
        this.gQL = new FrameLayout(this.gcM.getContext());
        this.gQL.setBackgroundColor(0);
        this.gQL.setId(a.g.wish_layout_id);
        this.gcM.addView(this.gQL, this.gsI);
    }

    @Override // com.baidu.live.i.a
    public void a(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null) {
            this.aAP = uVar;
            if (this.gQL == null || this.gcM.indexOfChild(this.gQL) < 0) {
                bJu();
                this.gQL.setVisibility(this.fTM ? 0 : 8);
            }
            if (this.gQM == null) {
                this.gQM = new WishListEntryView(this.mContext);
                this.gQM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.IW();
                    }
                });
                this.gQM.setOnScrollTextViewChangeListener(this);
            }
            if (this.gQL != null && this.gQL.indexOfChild(this.gQM) < 0) {
                this.gQL.addView(this.gQM, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.gQO) {
                if (this.gQM != null) {
                    this.gQM.ag(this.aAP.aFe);
                }
                this.gQO = false;
            }
            if (ListUtils.isEmpty(this.aAP.aFe) || this.aAP.aFe.size() == 1) {
                this.gQO = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, uVar));
        }
    }

    @Override // com.baidu.live.i.a
    public void IW() {
        if (this.aAP != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(this.mContext, this.aAP, String.valueOf(this.aAP.mLiveInfo.live_id), String.valueOf(this.aAP.aEz.userId), this.gQN)));
        }
    }

    @Override // com.baidu.live.i.a
    public void a(n nVar) {
    }

    @Override // com.baidu.live.i.a
    public void bM(boolean z) {
        this.gQN = z;
    }

    @Override // com.baidu.live.i.a
    public void setCanVisible(boolean z) {
        if (this.gQM != null && this.gQM.getView() != null) {
            this.gQM.getView().setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ala.widget.ScrollTextView.c
    public void a(AlaLiveWishListData alaLiveWishListData, int i) {
        if (this.gQM != null && this.aAP != null) {
            this.gQM.af(this.aAP.aFe);
        }
    }

    @Override // com.baidu.live.i.a
    public void IT() {
        kD(true);
    }

    @Override // com.baidu.live.i.a
    public void onDestroy() {
        kD(true);
    }

    private void reset(boolean z) {
        this.fTM = true;
        kD(z);
    }

    private void kD(boolean z) {
        if (this.gQM != null && (this.gQM.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gQM.getParent()).removeView(this.gQM);
        }
        if (z && this.gQL != null && (this.gQL.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gQL.getParent()).removeView(this.gQL);
        }
    }
}
