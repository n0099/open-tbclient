package com.baidu.tieba.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* loaded from: classes.dex */
public class bj extends BaseFragment {
    private boolean aIw;
    private boolean aIx;
    private bo aJl;
    private BdListView aJm;
    private View aJn;
    private RelativeLayout aJo;
    private bh aJp;
    private bp aJq;
    private NoNetworkView ant;
    private int aIy = 0;
    private View.OnClickListener mOnClickListener = new bk(this);
    private bs aJr = new bl(this);

    static {
        bp.HQ();
        com.baidu.tieba.ai.b(2001240, bi.class);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.w.recommend_game_fragment, (ViewGroup) null);
    }

    public void Hz() {
        if (!this.aIw) {
            if (this.aIx) {
                if (UtilHelper.isNetOk()) {
                    showLoadingView(this.aJo, true, this.aIy);
                    this.aJq.HS();
                    return;
                }
                return;
            }
            showLoadingView(this.aJo, true, this.aIy);
            this.aJq.HR();
        }
    }

    public void Hy() {
        if (this.aJl.getAdvCarouselView() != null) {
            this.aJl.getAdvCarouselView().onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        nu();
        if ((getActivity() instanceof GameCenterActivity) && ((GameCenterActivity) getActivity()).getCurrentPosition() == 0) {
            Hz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        hideLoadingView(this.aJo);
    }

    public void Hx() {
        if (this.aJo != null) {
            hideLoadingView(this.aJo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar) {
        List<GameInfoData> list = null;
        this.aJm.setVisibility(0);
        if (this.aJl != null) {
            this.aJl.setCarouselData(anVar == null ? null : anVar.getAdLists());
            this.aJl.setCarouselRefId("4000101");
        }
        if (this.aJp != null) {
            if (anVar != null && (list = anVar.getGameList()) != null) {
                for (GameInfoData gameInfoData : list) {
                    gameInfoData.setRefId("1000101");
                }
            }
            this.aJp.setData(list);
            this.aJp.notifyDataSetChanged();
        }
    }

    private void initData() {
        this.aJq = new bp(getActivity());
        this.aJq.a(this.aJr);
        this.aJq.registerListener();
        this.aIy = getActivity().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds300);
    }

    private void nu() {
        View view = getView();
        if (view != null) {
            this.aJn = view.findViewById(com.baidu.tieba.v.recommend_game_root);
            this.ant = (NoNetworkView) view.findViewById(com.baidu.tieba.v.view_no_network);
            this.aJo = (RelativeLayout) view.findViewById(com.baidu.tieba.v.recommend_game_content_view);
            this.aJm = (BdListView) view.findViewById(com.baidu.tieba.v.game_list);
            this.aJl = new bo(getActivity(), this.mOnClickListener);
            this.aJm.addHeaderView(this.aJl);
            this.aJp = new bh(getActivity(), getUniqueId());
            this.aJm.setAdapter((ListAdapter) this.aJp);
            this.aJm.setOnItemClickListener(new bm(this));
            this.aJm.setOnScrollListener(new bn(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aJn != null) {
            this.aJn.setBackgroundColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_bg_line_d));
        }
        if (this.ant != null) {
            this.ant.onChangeSkinType(i);
        }
        if (this.aJl != null) {
            this.aJl.sD();
        }
        if (this.aJp != null) {
            this.aJp.notifyDataSetChanged();
        }
    }
}
