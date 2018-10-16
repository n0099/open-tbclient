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
    private PopupWindow dho;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private Runnable dhp = new Runnable() { // from class: com.baidu.tieba.enterForum.home.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.dho != null) {
                g.a(c.this.dho);
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
                    c.this.aD(i, l);
                }
            }, 100L);
        }
    }

    private int l(LinkedList<VisitedForumData> linkedList) {
        int size = linkedList.size();
        for (int i = 0; i < 3 && i < size; i++) {
            VisitedForumData visitedForumData = linkedList.get(i);
            if (visitedForumData != null && visitedForumData.Kr()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(int i, int i2) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_enter_forum_ufan_recent_visit_tip_show", true);
        if (this.dho == null || !this.dho.isShowing()) {
            if (this.mRootView == null) {
                this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.enter_forum_ufan_item_tip, (ViewGroup) null);
                this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        c.this.aui();
                    }
                });
            }
            if (this.dho == null) {
                this.dho = new PopupWindow(this.mRootView, -2, -2);
                this.dho.setOutsideTouchable(true);
            }
            g.showPopupWindowAtLocation(this.dho, this.mPageContext.getPageActivity().findViewById(16908290), 51, this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.tbds44) + (this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.tbds220) * i2), i);
            this.mHandler.postDelayed(this.dhp, 5000L);
        }
    }

    public void aui() {
        if (this.dho != null) {
            g.a(this.dho);
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
