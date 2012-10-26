package com.baidu.tieba.home;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
/* loaded from: classes.dex */
public class HomeActivity extends ActivityGroup {
    private static final int MENU_ID_ABOUT = 4;
    private static final int MENU_ID_ACCOUNT = 2;
    private static final int MENU_ID_FEEDBACK = 3;
    private static final int MENU_ID_QUIT = 5;
    private static final int MENU_ID_SETUP = 1;
    private RadioButton mButtonLike;
    private RadioButton mButtonMark;
    private FrameLayout mContent;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = null;
    private Button mButtonRefresh = null;
    private Button mButtonSearch = null;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.HomeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (v != HomeActivity.this.mButtonRefresh) {
                if (v == HomeActivity.this.mButtonSearch) {
                    SearchActivity.startActivity(HomeActivity.this, HomeActivity.this.getString(R.string.my_bar));
                    return;
                }
                return;
            }
            Activity activity = HomeActivity.this.getLocalActivityManager().getCurrentActivity();
            if (activity instanceof LikeActivity) {
                String id = TiebaApplication.getCurrentAccount();
                if (id == null || id.length() <= 0) {
                    LoginActivity.startActivity((Activity) HomeActivity.this, HomeActivity.this.getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_HOME_REFRESHLIKE);
                    return;
                }
                LikeActivity like = (LikeActivity) activity;
                like.exec(true);
            }
        }
    };

    @Override // android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        this.mContent = (FrameLayout) findViewById(R.id.content);
        this.mButtonLike = (RadioButton) findViewById(R.id.home_bt_like);
        this.mButtonMark = (RadioButton) findViewById(R.id.home_bt_mark);
        this.mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.home.HomeActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setTextColor(HomeActivity.this.getResources().getColor(R.color.tab_hightlight_text_color));
                    if (buttonView != HomeActivity.this.mButtonLike) {
                        if (buttonView == HomeActivity.this.mButtonMark) {
                            HomeActivity.this.addView("mark", MarkActivity.class);
                            return;
                        }
                        return;
                    }
                    HomeActivity.this.addView("like", LikeActivity.class);
                    return;
                }
                buttonView.setTextColor(HomeActivity.this.getResources().getColor(R.color.tab_text_color));
            }
        };
        this.mButtonLike.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        this.mButtonMark.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        this.mButtonLike.setChecked(true);
        this.mButtonRefresh = (Button) findViewById(R.id.refresh);
        this.mButtonSearch = (Button) findViewById(R.id.search);
        this.mButtonRefresh.setOnClickListener(this.mOnClickListener);
        this.mButtonSearch.setOnClickListener(this.mOnClickListener);
    }

    public void addView(String id, Class<?> cls) {
        Intent intent = new Intent(this, cls);
        this.mContent.removeAllViews();
        this.mContent.addView(getLocalActivityManager().startActivity(id, intent).getDecorView());
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

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case RequestResponseCode.REQUEST_LOGIN_HOME_REFRESHLIKE /* 1100015 */:
                    Activity activity = getLocalActivityManager().getCurrentActivity();
                    if (activity instanceof LikeActivity) {
                        LikeActivity like = (LikeActivity) activity;
                        like.exec(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
