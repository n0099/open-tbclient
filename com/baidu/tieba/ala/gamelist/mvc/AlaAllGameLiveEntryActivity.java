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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.gamelist.a.a;
import com.baidu.tieba.view.NoScrollGridView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaAllGameLiveEntryActivity extends BaseFragmentActivity {
    private IAlaSquareTabController faU;
    private LinearLayout fla;
    private ArrayList<AlaSquareTabInfo> fwD;
    private LinearLayout fwH;
    private TextView fwI;
    private ImageView fwJ;
    private NoScrollGridView fwK;
    private View fwL;
    private a fwM;
    private int fwN;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bum();
        initView();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class);
        if (runTask != null && runTask.getData() != null) {
            this.faU = (IAlaSquareTabController) runTask.getData();
        }
    }

    private void bum() {
        Intent intent = getIntent();
        if (intent != null) {
            this.fwN = intent.getIntExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_HAS_SEARCH, 0);
            this.fwD = intent.getParcelableArrayListExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_DATA);
        }
    }

    private void initView() {
        this.mRootView = (LinearLayout) View.inflate(getPageContext().getPageActivity(), R.layout.ala_all_game_entry_activity, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.ala_all_game_entry_title));
        this.fwH = (LinearLayout) this.mRootView.findViewById(R.id.search_container);
        this.fwI = (TextView) this.fwH.findViewById(R.id.search_text);
        this.fwI.setClickable(false);
        this.fwJ = (ImageView) this.fwH.findViewById(R.id.search_icon);
        this.fwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(AlaAllGameLiveEntryActivity.this.getPageContext().getPageActivity())));
            }
        });
        if (this.fwN == 1) {
            this.fwH.setVisibility(0);
        } else {
            this.fwH.setVisibility(8);
        }
        this.fla = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.ala_all_game_no_data, (ViewGroup) null);
        this.fwL = this.mRootView.findViewById(R.id.scroll_grid_view_root);
        this.fwM = new a(getPageContext());
        this.fwK = (NoScrollGridView) this.mRootView.findViewById(R.id.ala_live_list);
        this.fwK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlaSquareTabInfo alaSquareTabInfo = (AlaSquareTabInfo) v.getItem(AlaAllGameLiveEntryActivity.this.fwM.getData(), i);
                if (alaSquareTabInfo != null && AlaAllGameLiveEntryActivity.this.faU != null) {
                    int tabIndex = AlaAllGameLiveEntryActivity.this.faU.getTabIndex(alaSquareTabInfo.id);
                    if (tabIndex >= 0) {
                        AlaAllGameLiveEntryActivity.this.faU.goToTab(tabIndex);
                        AlaAllGameLiveEntryActivity.this.finish();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaNewSquareSubListActivityConfig(AlaAllGameLiveEntryActivity.this, alaSquareTabInfo)));
                }
            }
        });
        this.fwK.setAdapter((ListAdapter) this.fwM);
        if (v.isEmpty(this.fwD)) {
            this.fwL.setVisibility(8);
            this.mRootView.addView(this.fla, 1);
        } else {
            this.mRootView.removeView(this.fla);
            this.fwL.setVisibility(0);
            this.fwM.setData(this.fwD);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        setContentView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setImageResource(this.fwJ, R.drawable.icon_search);
        am.setViewTextColor(this.fwI, (int) R.color.enter_forum_search_text_color);
        am.setBackgroundResource(this.fwH, R.drawable.all_game_search_frame);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.faU = null;
    }
}
