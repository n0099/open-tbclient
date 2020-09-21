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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.gamelist.a.a;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaAllGameLiveEntryActivity extends BaseFragmentActivity {
    private IAlaSquareTabController fFY;
    private LinearLayout fQe;
    private LinearLayout gcC;
    private TextView gcD;
    private ImageView gcE;
    private NoScrollGridView gcF;
    private View gcG;
    private a gcH;
    private int gcI;
    private ArrayList<AlaSquareTabInfo> gcy;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bLe();
        initView();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class);
        if (runTask != null && runTask.getData() != null) {
            this.fFY = (IAlaSquareTabController) runTask.getData();
        }
    }

    private void bLe() {
        Intent intent = getIntent();
        if (intent != null) {
            this.gcI = intent.getIntExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_HAS_SEARCH, 0);
            this.gcy = intent.getParcelableArrayListExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_DATA);
        }
    }

    private void initView() {
        this.mRootView = (LinearLayout) View.inflate(getPageContext().getPageActivity(), R.layout.ala_all_game_entry_activity, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.ala_all_game_entry_title));
        this.gcC = (LinearLayout) this.mRootView.findViewById(R.id.search_container);
        this.gcD = (TextView) this.gcC.findViewById(R.id.search_text);
        this.gcD.setClickable(false);
        this.gcE = (ImageView) this.gcC.findViewById(R.id.search_icon);
        this.gcC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(AlaAllGameLiveEntryActivity.this.getPageContext().getPageActivity())));
            }
        });
        if (this.gcI == 1) {
            this.gcC.setVisibility(0);
        } else {
            this.gcC.setVisibility(8);
        }
        this.fQe = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.ala_all_game_no_data, (ViewGroup) null);
        this.gcG = this.mRootView.findViewById(R.id.scroll_grid_view_root);
        this.gcH = new a(getPageContext());
        this.gcF = (NoScrollGridView) this.mRootView.findViewById(R.id.ala_live_list);
        this.gcF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlaSquareTabInfo alaSquareTabInfo = (AlaSquareTabInfo) y.getItem(AlaAllGameLiveEntryActivity.this.gcH.getData(), i);
                if (alaSquareTabInfo != null && AlaAllGameLiveEntryActivity.this.fFY != null) {
                    int tabIndex = AlaAllGameLiveEntryActivity.this.fFY.getTabIndex(alaSquareTabInfo.id);
                    if (tabIndex >= 0) {
                        AlaAllGameLiveEntryActivity.this.fFY.goToTab(tabIndex);
                        AlaAllGameLiveEntryActivity.this.finish();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaNewSquareSubListActivityConfig(AlaAllGameLiveEntryActivity.this, alaSquareTabInfo)));
                }
            }
        });
        this.gcF.setAdapter((ListAdapter) this.gcH);
        if (y.isEmpty(this.gcy)) {
            this.gcG.setVisibility(8);
            this.mRootView.addView(this.fQe, 1);
        } else {
            this.mRootView.removeView(this.fQe);
            this.gcG.setVisibility(0);
            this.gcH.setData(this.gcy);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        setContentView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setImageResource(this.gcE, R.drawable.icon_search);
        ap.setViewTextColor(this.gcD, R.color.enter_forum_search_text_color);
        ap.setBackgroundResource(this.gcC, R.drawable.all_game_search_frame);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fFY = null;
    }
}
