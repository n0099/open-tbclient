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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a.c;
/* loaded from: classes3.dex */
public abstract class AbsFloorImageTextView extends RelativeLayout {
    protected ImageUrlData cbW;
    private c.a cbX;
    public com.baidu.tieba.pb.a.c cbY;
    protected String mUserId;
    protected static final int TOP = l.h(TbadkApplication.getInst(), d.e.tbds34);
    protected static final int BOTTOM = l.h(TbadkApplication.getInst(), d.e.tbds28);
    protected static final int LEFT = l.h(TbadkApplication.getInst(), d.e.tbds44);
    protected static final int RIGHT = l.h(TbadkApplication.getInst(), d.e.tbds44);
    protected static final int cbU = (l.aO(TbadkApplication.getInst()) - LEFT) - RIGHT;
    protected static final int cbV = l.h(TbadkApplication.getInst(), d.e.tbds42);

    public abstract void a(ImageUrlData imageUrlData);

    public abstract void ep(boolean z);

    public AbsFloorImageTextView(@NonNull Context context) {
        super(context);
        this.cbX = new c.a() { // from class: com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView.1
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
                AbsFloorImageTextView.this.ajY();
                return true;
            }
        };
        this.cbY = new com.baidu.tieba.pb.a.c(this.cbX) { // from class: com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView.2
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

    public void ajY() {
        if (this.cbW != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.cbW.threadId), String.valueOf(this.cbW.postId), this.cbW.mIsSeeHost, this.cbW.mIsReserver, null);
            if (this.cbW.isFirstPost) {
                createHistoryCfg.setJumpToTopArea(true);
            } else {
                createHistoryCfg.setJumpToCommentArea(true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<Integer, Integer> oe(String str) {
        return ab.q(str, cbV, cbU);
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
    public void iW(int i) {
        o(this, i);
    }
}
