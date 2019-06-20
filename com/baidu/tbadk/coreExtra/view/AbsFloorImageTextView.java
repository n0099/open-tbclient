package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
/* loaded from: classes3.dex */
public abstract class AbsFloorImageTextView extends RelativeLayout {
    protected ImageUrlData ckf;
    private c.a ckg;
    public com.baidu.tieba.pb.a.c ckh;
    protected String mUserId;
    protected static final int TOP = l.g(TbadkApplication.getInst(), R.dimen.tbds34);
    protected static final int BOTTOM = l.g(TbadkApplication.getInst(), R.dimen.tbds28);
    protected static final int LEFT = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
    protected static final int RIGHT = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
    protected static final int ckd = (l.af(TbadkApplication.getInst()) - LEFT) - RIGHT;
    protected static final int cke = l.g(TbadkApplication.getInst(), R.dimen.tbds42);

    public abstract void a(ImageUrlData imageUrlData);

    public abstract void o(boolean z, boolean z2);

    public AbsFloorImageTextView(@NonNull Context context) {
        super(context);
        this.ckg = new c.a() { // from class: com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean b(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean c(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean d(View view, MotionEvent motionEvent) {
                AbsFloorImageTextView.this.aoV();
                return true;
            }
        };
        this.ckh = new com.baidu.tieba.pb.a.c(this.ckg) { // from class: com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView.2
            @Override // com.baidu.tieba.pb.a.c, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        };
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void aoV() {
        if (this.ckf != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.ckf.threadId), String.valueOf(this.ckf.postId), this.ckf.mIsSeeHost, this.ckf.mIsReserver, null);
            if (this.ckf.isFirstPost) {
                createHistoryCfg.setJumpToTopArea(true);
            } else {
                createHistoryCfg.setJumpToCommentArea(true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<Integer, Integer> po(String str) {
        return ab.q(str, cke, ckd);
    }

    protected void o(View view, int i) {
        if (view != null) {
            int height = view.getHeight();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && height != i) {
                layoutParams.height = i;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jJ(int i) {
        o(this, i);
    }
}
