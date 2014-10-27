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
public class bi extends BaseFragment {
    private bm aIY;
    private BdListView aIZ;
    private boolean aIk;
    private boolean aIl;
    private View aJa;
    private RelativeLayout aJb;
    private bg aJc;
    private bn aJd;
    private NoNetworkView ank;
    private View.OnClickListener mOnClickListener = new bj(this);
    private bq aJe = new bk(this);

    static {
        bn.HM();
        com.baidu.tieba.ai.b(2001240, bh.class);
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

    public void Hw() {
        if (!this.aIk) {
            if (this.aIl) {
                if (UtilHelper.isNetOk()) {
                    showLoadingView(this.aJb, true);
                    this.aJd.HO();
                    return;
                }
                return;
            }
            showLoadingView(this.aJb, true);
            this.aJd.HN();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        nu();
        if ((getActivity() instanceof GameCenterActivity) && ((GameCenterActivity) getActivity()).getCurrentPosition() == 0) {
            Hw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar) {
        List<GameInfoData> list = null;
        this.aIZ.setVisibility(0);
        if (this.aIY != null) {
            this.aIY.setCarouselData(anVar == null ? null : anVar.getAdLists());
            this.aIY.setCarouselRefId("4000101");
        }
        if (this.aJc != null) {
            if (anVar != null && (list = anVar.getGameList()) != null) {
                for (GameInfoData gameInfoData : list) {
                    gameInfoData.setRefId("1000101");
                }
            }
            this.aJc.setData(list);
            this.aJc.notifyDataSetChanged();
        }
    }

    private void initData() {
        this.aJd = new bn(getActivity());
        this.aJd.a(this.aJe);
        this.aJd.registerListener();
    }

    private void nu() {
        View view = getView();
        if (view != null) {
            this.aJa = view.findViewById(com.baidu.tieba.v.recommend_game_root);
            this.ank = (NoNetworkView) view.findViewById(com.baidu.tieba.v.view_no_network);
            this.aJb = (RelativeLayout) view.findViewById(com.baidu.tieba.v.recommend_game_content_view);
            this.aIZ = (BdListView) view.findViewById(com.baidu.tieba.v.game_list);
            this.aIY = new bm(getActivity(), this.mOnClickListener);
            this.aIZ.addHeaderView(this.aIY);
            this.aJc = new bg(getActivity());
            this.aIZ.setAdapter((ListAdapter) this.aJc);
            this.aIZ.setOnItemClickListener(new bl(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aJa != null) {
            this.aJa.setBackgroundColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_bg_line_d));
        }
        if (this.ank != null) {
            this.ank.onChangeSkinType(i);
        }
        if (this.aIY != null) {
            this.aIY.sB();
        }
        if (this.aJc != null) {
            this.aJc.notifyDataSetChanged();
        }
    }
}
