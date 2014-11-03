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
    private GameCenterActivity aIs;
    private av aIt;
    private au aIu;
    private boolean aIw;
    private boolean aIx;
    private View agI;
    private int aIv = 0;
    private int aIy = 0;
    private final CustomMessageListener aHm = new ap(this, 2001121);
    private final com.baidu.adp.framework.listener.e ayS = new aq(this, 303008);
    private final CustomMessageListener ayT = new as(this, 2001224);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.agI = layoutInflater.inflate(com.baidu.tieba.w.game_center_view, (ViewGroup) null);
        this.aIt = new av(this.aIs, this.agI, this);
        return this.agI;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if ((getActivity() instanceof GameCenterActivity) && ((GameCenterActivity) getActivity()).getCurrentPosition() == 1) {
            Hz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aIs = (GameCenterActivity) getActivity();
        this.aIu = new au(this.aIs);
        this.aIu.registerListener(this.ayS);
        this.aIu.registerListener(this.ayT);
        this.aIu.registerListener(this.aHm);
        this.aIy = this.aIs.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds300);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aIt.onResume();
    }

    public void Hx() {
        if (this.aIt != null) {
            hideLoadingView(this.aIt.HJ());
        }
    }

    public void Hy() {
        if (this.aIt.HI() != null) {
            this.aIt.HI().onDestroy();
        }
    }

    public void Hz() {
        if (!this.aIw) {
            if (this.aIx) {
                if (UtilHelper.isNetOk()) {
                    showLoadingView(this.aIt.HJ(), true, this.aIy);
                    bK(true);
                    return;
                }
                return;
            }
            showLoadingView(this.aIt.HJ(), true, this.aIy);
            bK(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aIt.onPause();
        hideLoadingView(this.aIt.HJ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (z) {
            this.aIu.sendMessage(this.aIu.getPageNum());
        } else {
            this.aIu.fe(this.aIu.getPageNum());
        }
    }

    private void Ej() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aIt.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        Ej();
    }
}
