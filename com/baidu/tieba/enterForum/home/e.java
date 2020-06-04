package com.baidu.tieba.enterForum.home;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.adp.lib.f.g;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class e {
    private PopupWindow gQX;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private Runnable gQY = new Runnable() { // from class: com.baidu.tieba.enterForum.home.e.1
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.gQX != null) {
                g.dismissPopupWindow(e.this.gQX);
            }
        }
    };

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(LinkedList<VisitedForumData> linkedList, final int i) {
        if (linkedList == null || linkedList.size() < 1) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_RECENT_VISIT_TIP_SHOW, true);
            return;
        }
        final int i2 = i(linkedList);
        if (i2 < 0) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_RECENT_VISIT_TIP_SHOW, true);
        } else if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_RECENT_VISIT_TIP_SHOW, false)) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.home.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.bL(i, i2);
                }
            }, 100L);
        }
    }

    private int i(LinkedList<VisitedForumData> linkedList) {
        int size = linkedList.size();
        for (int i = 0; i < 3 && i < size; i++) {
            VisitedForumData visitedForumData = linkedList.get(i);
            if (visitedForumData != null && visitedForumData.bcG()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(int i, int i2) {
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.KEY_ENTER_FORUM_UFAN_RECENT_VISIT_TIP_SHOW, true);
        if (this.gQX == null || !this.gQX.isShowing()) {
            if (this.mRootView == null) {
                this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.enter_forum_ufan_item_tip, (ViewGroup) null);
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.bPh();
                    }
                });
            }
            if (this.gQX == null) {
                this.gQX = new PopupWindow(this.mRootView, -2, -2);
                this.gQX.setOutsideTouchable(true);
            }
            g.showPopupWindowAtLocation(this.gQX, this.mPageContext.getPageActivity().findViewById(16908290), 51, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) + (this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds220) * i2), i);
            this.mHandler.postDelayed(this.gQY, 5000L);
        }
    }

    public void bPh() {
        if (this.gQX != null) {
            g.dismissPopupWindow(this.gQX);
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
