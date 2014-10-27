package com.baidu.tieba.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.game.GameRankInfoData;
import java.util.List;
/* loaded from: classes.dex */
public class s extends BaseFragment {
    private GameRankInfoData aHa;
    private u aHj;
    private com.baidu.tbadk.core.view.o aHk;
    private BdListView azz;
    private View mContentView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aHa = (GameRankInfoData) getArguments().getSerializable("gameRank");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mContentView = layoutInflater.inflate(com.baidu.tieba.w.game_detail_rank, (ViewGroup) null);
        this.azz = (BdListView) this.mContentView.findViewById(com.baidu.tieba.v.rank_list);
        this.aHk = NoDataViewFactory.a(getActivity(), this.mContentView, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, 0), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.game_detail_rank_no), null);
        this.aHj = new u(getActivity());
        if (this.aHa != null) {
            List<UserData> rankList = this.aHa.getRankList();
            if (rankList.size() == 0) {
                this.aHk.setVisibility(0);
            } else {
                this.aHk.setVisibility(8);
                this.aHj.F(rankList);
            }
        }
        this.azz.setAdapter((ListAdapter) this.aHj);
        this.azz.setOnItemClickListener(new t(this));
        return this.mContentView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (getActivity() instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) getActivity();
            baseFragmentActivity.getLayoutMode().L(i == 1);
            baseFragmentActivity.getLayoutMode().h(this.mContentView);
        }
        this.aHk.onChangeSkinType(i);
    }
}
