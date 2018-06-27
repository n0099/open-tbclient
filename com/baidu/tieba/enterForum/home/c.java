package com.baidu.tieba.enterForum.home;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class c {
    private PopupWindow cQy;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private Runnable cQz = new Runnable() { // from class: com.baidu.tieba.enterForum.home.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.cQy != null) {
                g.a(c.this.cQy);
            }
        }
    };

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void d(LinkedList<VisitedForumData> linkedList, final int i) {
        if (linkedList == null || linkedList.size() < 1) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_forum_ufan_recent_visit_tip_show", true);
            return;
        }
        final int l = l(linkedList);
        if (l < 0) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_forum_ufan_recent_visit_tip_show", true);
        } else if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_enter_forum_ufan_recent_visit_tip_show", false)) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.home.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.at(i, l);
                }
            }, 100L);
        }
    }

    private int l(LinkedList<VisitedForumData> linkedList) {
        int size = linkedList.size();
        for (int i = 0; i < 3 && i < size; i++) {
            VisitedForumData visitedForumData = linkedList.get(i);
            if (visitedForumData != null && visitedForumData.Hg()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(int i, int i2) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_forum_ufan_recent_visit_tip_show", true);
        if (this.cQy == null || !this.cQy.isShowing()) {
            if (this.mRootView == null) {
                this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.enter_forum_ufan_item_tip, (ViewGroup) null);
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.aox();
                    }
                });
            }
            if (this.cQy == null) {
                this.cQy = new PopupWindow(this.mRootView, -2, -2);
                this.cQy.setOutsideTouchable(true);
            }
            g.showPopupWindowAtLocation(this.cQy, this.mPageContext.getPageActivity().findViewById(16908290), 51, this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds44) + (this.mPageContext.getResources().getDimensionPixelSize(d.e.tbds220) * i2), i);
            this.mHandler.postDelayed(this.cQz, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void aox() {
        if (this.cQy != null) {
            g.a(this.cQy);
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
