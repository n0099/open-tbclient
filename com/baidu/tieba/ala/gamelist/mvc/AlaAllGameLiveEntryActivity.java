package com.baidu.tieba.ala.gamelist.mvc;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.atomdata.AlaAllGameLiveEntryActivityConfig;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaAllGameLiveEntryActivity extends BaseFragmentActivity {
    public ArrayList<AlaSquareTabInfo> mAlaSquareTabInfos;
    public View mCustomScrollView;
    public d.a.o0.v.h.a.a mGameEntryAdapter;
    public NoScrollGridView mGridView;
    public int mHasSearchTab;
    public NavigationBar mNavigationBar;
    public LinearLayout mNoDataRootView;
    public LinearLayout mRootView;
    public ImageView mSearchIcon;
    public LinearLayout mSearchRoot;
    public IAlaSquareTabController mSquareTabController;
    public TextView mTextSearchHint;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(AlaAllGameLiveEntryActivity.this.getPageContext().getPageActivity())));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            AlaSquareTabInfo alaSquareTabInfo = (AlaSquareTabInfo) ListUtils.getItem(AlaAllGameLiveEntryActivity.this.mGameEntryAdapter.a(), i2);
            if (alaSquareTabInfo == null || AlaAllGameLiveEntryActivity.this.mSquareTabController == null) {
                return;
            }
            int tabIndex = AlaAllGameLiveEntryActivity.this.mSquareTabController.getTabIndex(alaSquareTabInfo.id);
            if (tabIndex >= 0) {
                AlaAllGameLiveEntryActivity.this.mSquareTabController.goToTab(tabIndex);
                AlaAllGameLiveEntryActivity.this.finish();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaNewSquareSubListActivityConfig(AlaAllGameLiveEntryActivity.this, alaSquareTabInfo)));
        }
    }

    private void dealWithIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mHasSearchTab = intent.getIntExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_HAS_SEARCH, 0);
            this.mAlaSquareTabInfos = intent.getParcelableArrayListExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_DATA);
        }
    }

    private void initView() {
        LinearLayout linearLayout = (LinearLayout) View.inflate(getPageContext().getPageActivity(), R.layout.ala_all_game_entry_activity, null);
        this.mRootView = linearLayout;
        NavigationBar navigationBar = (NavigationBar) linearLayout.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.ala_all_game_entry_title));
        LinearLayout linearLayout2 = (LinearLayout) this.mRootView.findViewById(R.id.search_container);
        this.mSearchRoot = linearLayout2;
        TextView textView = (TextView) linearLayout2.findViewById(R.id.search_text);
        this.mTextSearchHint = textView;
        textView.setClickable(false);
        this.mSearchIcon = (ImageView) this.mSearchRoot.findViewById(R.id.search_icon);
        this.mSearchRoot.setOnClickListener(new a());
        if (this.mHasSearchTab == 1) {
            this.mSearchRoot.setVisibility(0);
        } else {
            this.mSearchRoot.setVisibility(8);
        }
        this.mNoDataRootView = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.ala_all_game_no_data, (ViewGroup) null);
        this.mCustomScrollView = this.mRootView.findViewById(R.id.scroll_grid_view_root);
        this.mGameEntryAdapter = new d.a.o0.v.h.a.a(getPageContext());
        NoScrollGridView noScrollGridView = (NoScrollGridView) this.mRootView.findViewById(R.id.ala_live_list);
        this.mGridView = noScrollGridView;
        noScrollGridView.setOnItemClickListener(new b());
        this.mGridView.setAdapter((ListAdapter) this.mGameEntryAdapter);
        if (ListUtils.isEmpty(this.mAlaSquareTabInfos)) {
            this.mCustomScrollView.setVisibility(8);
            this.mRootView.addView(this.mNoDataRootView, 1);
        } else {
            this.mRootView.removeView(this.mNoDataRootView);
            this.mCustomScrollView.setVisibility(0);
            this.mGameEntryAdapter.b(this.mAlaSquareTabInfos);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        setContentView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        SkinManager.setImageResource(this.mSearchIcon, R.drawable.icon_search);
        SkinManager.setViewTextColor(this.mTextSearchHint, R.color.enter_forum_search_text_color);
        SkinManager.setBackgroundResource(this.mSearchRoot, R.drawable.all_game_search_frame);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dealWithIntent();
        initView();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class);
        if (runTask == null || runTask.getData() == null) {
            return;
        }
        this.mSquareTabController = (IAlaSquareTabController) runTask.getData();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mSquareTabController = null;
    }
}
