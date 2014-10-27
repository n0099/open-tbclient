package com.baidu.tieba.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class ao extends BaseFragment implements com.baidu.adp.widget.ListView.aa {
    private GameCenterActivity aIg;
    private av aIh;
    private au aIi;
    private boolean aIk;
    private boolean aIl;
    private View agA;
    private int aIj = 0;
    private final CustomMessageListener aHc = new ap(this, 2001121);
    private final com.baidu.adp.framework.listener.e ayJ = new aq(this, 303008);
    private final CustomMessageListener ayK = new as(this, 2001224);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.agA = layoutInflater.inflate(com.baidu.tieba.w.game_center_view, (ViewGroup) null);
        this.aIh = new av(this.aIg, this.agA, this);
        return this.agA;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if ((getActivity() instanceof GameCenterActivity) && ((GameCenterActivity) getActivity()).getCurrentPosition() == 1) {
            Hw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aIg = (GameCenterActivity) getActivity();
        this.aIi = new au(this.aIg);
        this.aIi.registerListener(this.ayJ);
        this.aIi.registerListener(this.ayK);
        this.aIi.registerListener(this.aHc);
    }

    public void Hw() {
        if (!this.aIk) {
            if (this.aIl) {
                if (UtilHelper.isNetOk()) {
                    showLoadingView(this.aIh.HF(), true);
                    bK(true);
                    return;
                }
                return;
            }
            showLoadingView(this.aIh.HF(), true);
            bK(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aIh.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (z) {
            this.aIi.sendMessage(this.aIi.getPageNum());
        } else {
            this.aIi.fe(this.aIi.getPageNum());
        }
    }

    private void Eh() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aIh.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        Eh();
    }
}
