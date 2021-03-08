package com.baidu.tieba.faceshop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class y extends PopupWindow {
    private ViewGroup bOn;
    private int bOp;
    private ae iYK;
    private a iYL;
    private Context mContext;
    private ListView mListView;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, com.baidu.tbadk.album.a aVar);
    }

    public void a(a aVar) {
        this.iYL = aVar;
    }

    public y(Context context) {
        super(context);
        this.mContext = context;
        setWidth(-1);
        setHeight(-1);
        setContentView(c(new ArrayList(), com.baidu.tbadk.album.a.ALBUM_ID_ALL));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @SuppressLint({"ResourceAsColor"})
    private View c(List<com.baidu.tbadk.album.a> list, String str) {
        BdListView bdListView = new BdListView(this.mContext);
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.iYK = new ae(this.mContext);
        this.iYK.setData(list, str);
        bdListView.setAdapter((ListAdapter) this.iYK);
        bdListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.y.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.baidu.tbadk.album.a item = y.this.iYK.getItem(i);
                if (item instanceof com.baidu.tbadk.album.a) {
                    com.baidu.tbadk.album.a aVar = item;
                    if (y.this.iYL != null) {
                        y.this.iYL.a(i, aVar);
                    }
                }
                y.this.UX();
            }
        });
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        this.bOn = frameLayout2;
        frameLayout2.setBackgroundColor(this.mContext.getResources().getColor(R.color.common_color_10175));
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.y.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                y.this.UX();
            }
        });
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    public void setData(List<com.baidu.tbadk.album.a> list, String str) {
        int i;
        if (list != null) {
            this.bOp = d(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.iYK.setData(list, str);
            this.iYK.notifyDataSetChanged();
        }
    }

    private int d(List<com.baidu.tbadk.album.a> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.album.a aVar = list.get(i);
            if (aVar != null && str.equals(aVar.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void O(View view) {
        this.mListView.setSelection(this.bOp);
        if (Build.VERSION.SDK_INT < 24) {
            if (com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this, view)) {
                UZ();
            }
        } else if (com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this, view, 0, 0, view.getHeight())) {
            UZ();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        UX();
    }

    public void UX() {
        Va();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UY() {
        super.dismiss();
    }

    private void UZ() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.bOn.startAnimation(alphaAnimation);
    }

    private void Va() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.faceshop.y.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                y.this.UY();
            }
        });
        this.mListView.startAnimation(translateAnimation);
        this.bOn.startAnimation(alphaAnimation);
    }
}
