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
/* loaded from: classes9.dex */
public class AlaAllGameLiveEntryActivity extends BaseFragmentActivity {
    private LinearLayout gGC;
    private View gUA;
    private a gUB;
    private int gUC;
    private ArrayList<AlaSquareTabInfo> gUs;
    private LinearLayout gUw;
    private TextView gUx;
    private ImageView gUy;
    private NoScrollGridView gUz;
    private IAlaSquareTabController gwk;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootView;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bUL();
        initView();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class);
        if (runTask != null && runTask.getData() != null) {
            this.gwk = (IAlaSquareTabController) runTask.getData();
        }
    }

    private void bUL() {
        Intent intent = getIntent();
        if (intent != null) {
            this.gUC = intent.getIntExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_HAS_SEARCH, 0);
            this.gUs = intent.getParcelableArrayListExtra(AlaAllGameLiveEntryActivityConfig.ALA_ALL_GAME_ENTRY_DATA);
        }
    }

    private void initView() {
        this.mRootView = (LinearLayout) View.inflate(getPageContext().getPageActivity(), R.layout.ala_all_game_entry_activity, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.ala_all_game_entry_title));
        this.gUw = (LinearLayout) this.mRootView.findViewById(R.id.search_container);
        this.gUx = (TextView) this.gUw.findViewById(R.id.search_text);
        this.gUx.setClickable(false);
        this.gUy = (ImageView) this.gUw.findViewById(R.id.search_icon);
        this.gUw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(AlaAllGameLiveEntryActivity.this.getPageContext().getPageActivity())));
            }
        });
        if (this.gUC == 1) {
            this.gUw.setVisibility(0);
        } else {
            this.gUw.setVisibility(8);
        }
        this.gGC = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.ala_all_game_no_data, (ViewGroup) null);
        this.gUA = this.mRootView.findViewById(R.id.scroll_grid_view_root);
        this.gUB = new a(getPageContext());
        this.gUz = (NoScrollGridView) this.mRootView.findViewById(R.id.ala_live_list);
        this.gUz.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlaSquareTabInfo alaSquareTabInfo = (AlaSquareTabInfo) x.getItem(AlaAllGameLiveEntryActivity.this.gUB.getData(), i);
                if (alaSquareTabInfo != null && AlaAllGameLiveEntryActivity.this.gwk != null) {
                    int tabIndex = AlaAllGameLiveEntryActivity.this.gwk.getTabIndex(alaSquareTabInfo.id);
                    if (tabIndex >= 0) {
                        AlaAllGameLiveEntryActivity.this.gwk.goToTab(tabIndex);
                        AlaAllGameLiveEntryActivity.this.finish();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaNewSquareSubListActivityConfig(AlaAllGameLiveEntryActivity.this, alaSquareTabInfo)));
                }
            }
        });
        this.gUz.setAdapter((ListAdapter) this.gUB);
        if (x.isEmpty(this.gUs)) {
            this.gUA.setVisibility(8);
            this.mRootView.addView(this.gGC, 1);
        } else {
            this.mRootView.removeView(this.gGC);
            this.gUA.setVisibility(0);
            this.gUB.setData(this.gUs);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        setContentView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setImageResource(this.gUy, R.drawable.icon_search);
        ao.setViewTextColor(this.gUx, R.color.enter_forum_search_text_color);
        ao.setBackgroundResource(this.gUw, R.drawable.all_game_search_frame);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gwk = null;
    }
}
