package com.baidu.tieba.enterForum.home;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.e;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class c {
    private PopupWindow dit;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private Runnable diu = new Runnable() { // from class: com.baidu.tieba.enterForum.home.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dit != null) {
                g.a(c.this.dit);
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
                    c.this.aF(i, l);
                }
            }, 100L);
        }
    }

    private int l(LinkedList<VisitedForumData> linkedList) {
        int size = linkedList.size();
        for (int i = 0; i < 3 && i < size; i++) {
            VisitedForumData visitedForumData = linkedList.get(i);
            if (visitedForumData != null && visitedForumData.KD()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(int i, int i2) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_forum_ufan_recent_visit_tip_show", true);
        if (this.dit == null || !this.dit.isShowing()) {
            if (this.mRootView == null) {
                this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.enter_forum_ufan_item_tip, (ViewGroup) null);
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.atH();
                    }
                });
            }
            if (this.dit == null) {
                this.dit = new PopupWindow(this.mRootView, -2, -2);
                this.dit.setOutsideTouchable(true);
            }
            g.showPopupWindowAtLocation(this.dit, this.mPageContext.getPageActivity().findViewById(16908290), 51, this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.tbds44) + (this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.tbds220) * i2), i);
            this.mHandler.postDelayed(this.diu, 5000L);
        }
    }

    public void atH() {
        if (this.dit != null) {
            g.a(this.dit);
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
