package com.baidu.tieba.enterForum.home;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.adp.lib.g.g;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class e {
    private PopupWindow fbW;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private Runnable fbX = new Runnable() { // from class: com.baidu.tieba.enterForum.home.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.fbW != null) {
                g.dismissPopupWindow(e.this.fbW);
            }
        }
    };

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(LinkedList<VisitedForumData> linkedList, final int i) {
        if (linkedList == null || linkedList.size() < 1) {
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_RECENT_VISIT_TIP_SHOW, true);
            return;
        }
        final int i2 = i(linkedList);
        if (i2 < 0) {
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_RECENT_VISIT_TIP_SHOW, true);
        } else if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_RECENT_VISIT_TIP_SHOW, false)) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.home.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.bj(i, i2);
                }
            }, 100L);
        }
    }

    private int i(LinkedList<VisitedForumData> linkedList) {
        int size = linkedList.size();
        for (int i = 0; i < 3 && i < size; i++) {
            VisitedForumData visitedForumData = linkedList.get(i);
            if (visitedForumData != null && visitedForumData.atG()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(int i, int i2) {
        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_RECENT_VISIT_TIP_SHOW, true);
        if (this.fbW == null || !this.fbW.isShowing()) {
            if (this.mRootView == null) {
                this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.enter_forum_ufan_item_tip, (ViewGroup) null);
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.beG();
                    }
                });
            }
            if (this.fbW == null) {
                this.fbW = new PopupWindow(this.mRootView, -2, -2);
                this.fbW.setOutsideTouchable(true);
            }
            g.showPopupWindowAtLocation(this.fbW, this.mPageContext.getPageActivity().findViewById(16908290), 51, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) + (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds220) * i2), i);
            this.mHandler.postDelayed(this.fbX, 5000L);
        }
    }

    public void beG() {
        if (this.fbW != null) {
            g.dismissPopupWindow(this.fbW);
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
