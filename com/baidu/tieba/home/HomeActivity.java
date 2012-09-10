package com.baidu.tieba.home;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
/* loaded from: classes.dex */
public class HomeActivity extends ActivityGroup {
    private static final String CURRENT_PAGE = "current_page";
    private static final int MENU_ID_ABOUT = 4;
    private static final int MENU_ID_ACCOUNT = 2;
    private static final int MENU_ID_FEEDBACK = 3;
    private static final int MENU_ID_QUIT = 5;
    private static final int MENU_ID_SETUP = 1;
    private ImageButton mButtonLike;
    private ImageButton mButtonMark;
    private FrameLayout mContent;

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        this.mContent = (FrameLayout) findViewById(R.id.content);
        this.mButtonLike = (ImageButton) findViewById(R.id.home_bt_like);
        this.mButtonMark = (ImageButton) findViewById(R.id.home_bt_mark);
        this.mButtonLike.setBackgroundResource(R.drawable.home_topbar_bt);
        this.mButtonMark.setBackgroundDrawable(null);
        switchPages(R.id.home_bt_like);
    }

    public void addView(String id, Class<?> cls) {
        Intent intent = new Intent(this, cls);
        this.mContent.removeAllViews();
        this.mContent.addView(getLocalActivityManager().startActivity(id, intent).getDecorView());
    }

    public void onClick(View v) {
        switchPages(v.getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void switchPages(int id) {
        switch (id) {
            case R.id.home_bt_like /* 2131361925 */:
                addView("like", LikeActivity.class);
                this.mButtonLike.setBackgroundResource(R.drawable.home_topbar_bt);
                this.mButtonMark.setBackgroundDrawable(null);
                this.mButtonLike.setImageResource(R.drawable.home_bt_like_on);
                this.mButtonMark.setImageResource(R.drawable.home_bt_mark);
                return;
            case R.id.home_bt_mark /* 2131361926 */:
                addView("mark", MarkActivity.class);
                this.mButtonLike.setBackgroundDrawable(null);
                this.mButtonMark.setBackgroundResource(R.drawable.home_topbar_bt);
                this.mButtonLike.setImageResource(R.drawable.home_bt_like);
                this.mButtonMark.setImageResource(R.drawable.home_bt_mark_on);
                return;
            default:
                return;
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            MenuItem item = menu.findItem(1);
            item.setVisible(true);
            if (!TiebaApplication.isBaiduAccountManager()) {
                MenuItem item2 = menu.findItem(2);
                item2.setVisible(true);
            }
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

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(CURRENT_PAGE, getLocalActivityManager().getCurrentId());
        super.onSaveInstanceState(outState);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        String page = state.getString(CURRENT_PAGE);
        if (page != null && page.equals("mark")) {
            switchPages(R.id.home_bt_mark);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        if (!TiebaApplication.isBaiduAccountManager()) {
            menu.add(0, 2, 2, getString(R.string.account)).setIcon(R.drawable.menu_account);
        }
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
                UtilHelper.quitDialog(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
