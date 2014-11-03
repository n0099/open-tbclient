package com.baidu.tieba.game;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tbadk.game.GameInfoData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r extends BaseFragment {
    private GameInfoData aHj;
    private HorizontalListView aHo;
    private w aHp;
    private View aHq;
    private TextView aHr;
    private TextView aHs;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aHj = (GameInfoData) getArguments().getSerializable("gameInfo");
        this.mContext = getActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mContentView = layoutInflater.inflate(com.baidu.tieba.w.game_detail_intro, (ViewGroup) null);
        this.aHo = (HorizontalListView) this.mContentView.findViewById(com.baidu.tieba.v.game_detail_image_listview);
        this.aHq = this.mContentView.findViewById(com.baidu.tieba.v.game_detail_desc_divider);
        this.aHr = (TextView) this.mContentView.findViewById(com.baidu.tieba.v.game_detail_game_desc_title_tv);
        this.aHs = (TextView) this.mContentView.findViewById(com.baidu.tieba.v.game_detail_game_desc_tv);
        this.aHp = new w();
        this.aHo.setAdapter((ListAdapter) this.aHp);
        if (this.aHj != null && !TextUtils.isEmpty(this.aHj.getIntroduce())) {
            this.aHq.setVisibility(0);
            this.aHr.setVisibility(0);
            if (this.aHj.getIntroduce().length() > 80) {
                this.aHs.setText(String.valueOf(this.aHj.getIntroduce().substring(0, 80)) + "...");
            } else {
                this.aHs.setText(this.aHj.getIntroduce());
            }
        }
        if (this.aHj != null && this.aHj.getGamePic() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.aHj.getGamePic());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty((String) it.next())) {
                    it.remove();
                }
            }
            if (arrayList.size() == 0) {
                this.aHo.setVisibility(8);
                this.aHq.setVisibility(8);
            } else {
                this.aHo.setVisibility(0);
                this.aHq.setVisibility(0);
            }
            this.aHp.setData(arrayList);
        } else {
            this.aHo.setVisibility(8);
            this.aHq.setVisibility(8);
        }
        this.aHp.notifyDataSetChanged();
        return this.mContentView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        F(this.mContentView);
    }

    private void F(View view) {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (this.mContext instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.mContext;
            baseActivity.getLayoutMode().L(skinType == 1);
            baseActivity.getLayoutMode().h(view);
        } else if (this.mContext instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.mContext;
            baseFragmentActivity.getLayoutMode().L(skinType == 1);
            baseFragmentActivity.getLayoutMode().h(view);
        }
    }
}
