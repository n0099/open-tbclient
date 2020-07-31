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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.gamelist.a.a;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaAllGameLiveEntryActivity extends BaseFragmentActivity {
    private LinearLayout fBu;
    private ArrayList<AlaSquareTabInfo> fNi;
    private LinearLayout fNm;
    private TextView fNn;
    private ImageView fNo;
    private NoScrollGridView fNp;
    private View fNq;
    private a fNr;
    private int fNs;
    private IAlaSquareTabController frn;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bAy();
        initView();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class);
        if (runTask != null && runTask.getData() != null) {
            this.frn = (IAlaSquareTabController) runTask.getData();
        }
    }

    private void bAy() {
        Intent intent = getIntent();
        if (intent != null) {
            this.fNs = intent.getIntExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_HAS_SEARCH, 0);
            this.fNi = intent.getParcelableArrayListExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_DATA);
        }
    }

    private void initView() {
        this.mRootView = (LinearLayout) View.inflate(getPageContext().getPageActivity(), R.layout.ala_all_game_entry_activity, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.ala_all_game_entry_title));
        this.fNm = (LinearLayout) this.mRootView.findViewById(R.id.search_container);
        this.fNn = (TextView) this.fNm.findViewById(R.id.search_text);
        this.fNn.setClickable(false);
        this.fNo = (ImageView) this.fNm.findViewById(R.id.search_icon);
        this.fNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(AlaAllGameLiveEntryActivity.this.getPageContext().getPageActivity())));
            }
        });
        if (this.fNs == 1) {
            this.fNm.setVisibility(0);
        } else {
            this.fNm.setVisibility(8);
        }
        this.fBu = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.ala_all_game_no_data, (ViewGroup) null);
        this.fNq = this.mRootView.findViewById(R.id.scroll_grid_view_root);
        this.fNr = new a(getPageContext());
        this.fNp = (NoScrollGridView) this.mRootView.findViewById(R.id.ala_live_list);
        this.fNp.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlaSquareTabInfo alaSquareTabInfo = (AlaSquareTabInfo) x.getItem(AlaAllGameLiveEntryActivity.this.fNr.getData(), i);
                if (alaSquareTabInfo != null && AlaAllGameLiveEntryActivity.this.frn != null) {
                    int tabIndex = AlaAllGameLiveEntryActivity.this.frn.getTabIndex(alaSquareTabInfo.id);
                    if (tabIndex >= 0) {
                        AlaAllGameLiveEntryActivity.this.frn.goToTab(tabIndex);
                        AlaAllGameLiveEntryActivity.this.finish();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaNewSquareSubListActivityConfig(AlaAllGameLiveEntryActivity.this, alaSquareTabInfo)));
                }
            }
        });
        this.fNp.setAdapter((ListAdapter) this.fNr);
        if (x.isEmpty(this.fNi)) {
            this.fNq.setVisibility(8);
            this.mRootView.addView(this.fBu, 1);
        } else {
            this.mRootView.removeView(this.fBu);
            this.fNq.setVisibility(0);
            this.fNr.setData(this.fNi);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        setContentView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setImageResource(this.fNo, R.drawable.icon_search);
        ao.setViewTextColor(this.fNn, R.color.enter_forum_search_text_color);
        ao.setBackgroundResource(this.fNm, R.drawable.all_game_search_frame);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.frn = null;
    }
}
