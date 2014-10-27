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
    private GameInfoData aGZ;
    private HorizontalListView aHe;
    private w aHf;
    private View aHg;
    private TextView aHh;
    private TextView aHi;
    private View mContentView;
    private Context mContext;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aGZ = (GameInfoData) getArguments().getSerializable("gameInfo");
        this.mContext = getActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mContentView = layoutInflater.inflate(com.baidu.tieba.w.game_detail_intro, (ViewGroup) null);
        this.aHe = (HorizontalListView) this.mContentView.findViewById(com.baidu.tieba.v.game_detail_image_listview);
        this.aHg = this.mContentView.findViewById(com.baidu.tieba.v.game_detail_desc_divider);
        this.aHh = (TextView) this.mContentView.findViewById(com.baidu.tieba.v.game_detail_game_desc_title_tv);
        this.aHi = (TextView) this.mContentView.findViewById(com.baidu.tieba.v.game_detail_game_desc_tv);
        this.aHf = new w();
        this.aHe.setAdapter((ListAdapter) this.aHf);
        if (this.aGZ != null && !TextUtils.isEmpty(this.aGZ.getIntroduce())) {
            this.aHg.setVisibility(0);
            this.aHh.setVisibility(0);
            if (this.aGZ.getIntroduce().length() > 80) {
                this.aHi.setText(String.valueOf(this.aGZ.getIntroduce().substring(0, 80)) + "...");
            } else {
                this.aHi.setText(this.aGZ.getIntroduce());
            }
        }
        if (this.aGZ != null && this.aGZ.getGamePic() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.aGZ.getGamePic());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty((String) it.next())) {
                    it.remove();
                }
            }
            if (arrayList.size() == 0) {
                this.aHe.setVisibility(8);
                this.aHg.setVisibility(8);
            } else {
                this.aHe.setVisibility(0);
                this.aHg.setVisibility(0);
            }
            this.aHf.setData(arrayList);
        } else {
            this.aHe.setVisibility(8);
            this.aHg.setVisibility(8);
        }
        this.aHf.notifyDataSetChanged();
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
