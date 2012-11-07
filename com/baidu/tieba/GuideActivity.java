package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends Activity {
    private static final int IMAGE_NUM = 4;
    private HotspotPagerAdapter hotspotAdapter;
    ViewPager hotspotPager;
    private List<Bitmap> mBitmapList;
    ArrayList<View> mHotspotViews;
    private Button startButton;
    private int[] image = {R.drawable.guide0, R.drawable.guide1, R.drawable.guide2, R.drawable.guide3};
    public View.OnClickListener startOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.GuideActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            GuideActivity.this.startApp();
        }
    };

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, GuideActivity.class);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        View tempView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);
        this.hotspotAdapter = new HotspotPagerAdapter(this, null);
        this.hotspotPager = (ViewPager) findViewById(R.id.guide_pager);
        this.hotspotPager.setAdapter(this.hotspotAdapter);
        this.mBitmapList = new ArrayList();
        LayoutInflater mInflater = getLayoutInflater();
        this.mHotspotViews = new ArrayList<>();
        for (int i = 0; i < this.image.length; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), this.image[i]);
            if (i == this.image.length - 1) {
                tempView = mInflater.inflate(R.layout.guide_view, (ViewGroup) null);
            } else {
                tempView = new ImageView(this);
            }
            tempView.setBackgroundDrawable(new BitmapDrawable(bitmap));
            this.mBitmapList.add(bitmap);
            this.mHotspotViews.add(i, tempView);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        for (int i = 0; i < this.image.length; i++) {
            View temp = this.mHotspotViews.get(i);
            if (temp != null) {
                temp.setBackgroundDrawable(null);
            }
            Bitmap tempBitmap = this.mBitmapList.get(i);
            if (tempBitmap != null && !tempBitmap.isRecycled()) {
                tempBitmap.recycle();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 4:
                startApp();
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startApp() {
        ((ProgressBar) findViewById(R.id.guide_progress)).setVisibility(0);
        String id = TiebaApplication.getCurrentAccount();
        if (id != null && id.length() > 0) {
            MainTabActivity.startActivity(this, MainTabActivity.GOTO_HOME);
        } else {
            MainTabActivity.startActivity(this, MainTabActivity.GOTO_RECOMMEND);
            if (TiebaApplication.isBaiduAccountManager() && BaiduAccountProxy.hasValidBaiduAccount(this)) {
                TiebaLog.i(getClass().getName(), "startAPP", "getAccountData");
                BaiduAccountProxy.getAccountData(this, 0, MainTabActivity.GOTO_HOME, false);
            }
        }
        finish();
    }

    /* loaded from: classes.dex */
    private class HotspotPagerAdapter extends PagerAdapter {
        private HotspotPagerAdapter() {
        }

        /* synthetic */ HotspotPagerAdapter(GuideActivity guideActivity, HotspotPagerAdapter hotspotPagerAdapter) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 4;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(View collection, int position) {
            ((ViewPager) collection).addView(GuideActivity.this.mHotspotViews.get(position), 0);
            GuideActivity.this.startButton = (Button) GuideActivity.this.findViewById(R.id.st_button);
            if (GuideActivity.this.startButton != null) {
                GuideActivity.this.startButton.setOnClickListener(GuideActivity.this.startOnClickListener);
            }
            return GuideActivity.this.mHotspotViews.get(position);
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(View collection, int position, Object view) {
            ((ViewPager) collection).removeView(GuideActivity.this.mHotspotViews.get(position));
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
