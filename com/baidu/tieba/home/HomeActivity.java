package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.write.WriteActivity;
/* loaded from: classes.dex */
public class HomeActivity extends BaseActivity {
    public static final int HOME_TYPE_INVALID = 0;
    public static final int HOME_TYPE_LIKE = 1;
    public static final int HOME_TYPE_MARK = 2;
    public static final int HOME_TYPE_SEARCH = 3;
    private static final int MENU_ID_ABOUT = 4;
    private static final int MENU_ID_ACCOUNT = 2;
    private static final int MENU_ID_FEEDBACK = 3;
    private static final int MENU_ID_QUIT = 5;
    private static final int MENU_ID_SETUP = 1;
    public static final String TYPE = "type";
    private int mHomeType;
    private LikeView mLikeView = null;
    private MarkView mMarkView = null;
    private RelativeLayout mLayoutLike = null;
    private RelativeLayout mLayoutMark = null;

    public static void startAcitivity(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        initUI();
        if (savedInstanceState != null) {
            this.mHomeType = savedInstanceState.getInt("type", 1);
        } else {
            Intent intent = getIntent();
            this.mHomeType = intent.getIntExtra("type", 1);
        }
        switch (this.mHomeType) {
            case 1:
            case 3:
                goToLike(false);
                return;
            case 2:
                goToMark(false);
                return;
            default:
                return;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.mHomeType == 2) {
            goToMark(false);
        } else if (this.mHomeType == 1) {
            goToLike(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.mLikeView != null) {
                this.mLikeView.cancelAsyncTask();
                this.mLikeView.releaseProgressBar();
            }
            if (this.mMarkView != null) {
                this.mMarkView.cancelAsyncTask();
            }
            System.gc();
        } catch (Exception e) {
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("type", this.mHomeType);
    }

    private void initUI() {
        this.mHomeType = 0;
        this.mLayoutLike = (RelativeLayout) findViewById(R.id.home_layout_like);
        this.mLayoutMark = (RelativeLayout) findViewById(R.id.home_layout_mark);
        this.mLikeView = new LikeView(this);
        this.mLikeView.init();
        this.mMarkView = new MarkView(this);
        this.mMarkView.init();
    }

    public void setVisibility(int like, int mark) {
        this.mLayoutLike.setVisibility(like);
        this.mLayoutMark.setVisibility(mark);
    }

    public void setHomeType(int type) {
        this.mHomeType = type;
    }

    public int getHomeType() {
        return this.mHomeType;
    }

    public void goToLike(boolean isRefresh) {
        this.mLikeView.exec(isRefresh);
    }

    public void goToMark(boolean isRefresh) {
        this.mMarkView.exec(isRefresh);
    }

    public void closeSearch() {
        if (this.mLikeView != null) {
            this.mLikeView.closeSearch();
        }
    }

    public void closeDialog() {
        if (this.mLikeView != null) {
            this.mLikeView.closeSearch();
        }
        if (this.mMarkView != null) {
            this.mMarkView.closeDialog();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            quitDialog();
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            MenuItem item = menu.findItem(1);
            item.setVisible(true);
            MenuItem item2 = menu.findItem(2);
            item2.setVisible(true);
            MenuItem item3 = menu.findItem(3);
            item3.setVisible(true);
            MenuItem item4 = menu.findItem(4);
            item4.setVisible(true);
            MenuItem item5 = menu.findItem(5);
            item5.setVisible(true);
        } catch (Exception ex) {
            TiebaLog.e("HomeActivity", "onPrepareOptionsMenu", "exp: " + ex.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        menu.add(0, 2, 2, getString(R.string.account)).setIcon(R.drawable.menu_account);
        menu.add(0, 3, 3, getString(R.string.feedback)).setIcon(R.drawable.menu_feedback);
        menu.add(0, 4, 4, getString(R.string.about)).setIcon(R.drawable.menu_about);
        menu.add(0, 5, 5, getString(R.string.quit)).setIcon(R.drawable.menu_quit);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                MainTabActivity.startActivity(this, MainTabActivity.GOTO_MORE);
                break;
            case 2:
                AccountActivity.startActivity(this);
                break;
            case 3:
                AntiData anti = new AntiData();
                anti.setIfpost(1);
                WriteActivity.startActivityFeedBack(this, Config.POSITION_PAGER_ID, Config.POSITION_PAGER_NAME, anti);
                break;
            case 4:
                AboutActivity.startActivity(this);
                break;
            case 5:
                quitDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
