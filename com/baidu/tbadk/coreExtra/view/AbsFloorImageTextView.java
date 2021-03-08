package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
/* loaded from: classes.dex */
public abstract class AbsFloorImageTextView extends RelativeLayout {
    protected ImageUrlData fxh;
    private c.a fxi;
    public com.baidu.tieba.pb.a.c fxj;
    protected String mUserId;
    protected static final int TOP = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds34);
    protected static final int BOTTOM = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds28);
    protected static final int LEFT = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
    protected static final int RIGHT = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
    protected static final int fxf = (l.getEquipmentWidth(TbadkApplication.getInst()) - LEFT) - RIGHT;
    protected static final int fxg = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds42);

    public abstract void a(ImageUrlData imageUrlData);

    public abstract void kz(boolean z);

    public AbsFloorImageTextView(@NonNull Context context) {
        super(context);
        this.fxi = new c.a() { // from class: com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView.1
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                AbsFloorImageTextView.this.bzn();
                return true;
            }
        };
        this.fxj = new com.baidu.tieba.pb.a.c(this.fxi) { // from class: com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView.2
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

    public void bzn() {
        if (this.fxh != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.fxh.threadId), String.valueOf(this.fxh.postId), this.fxh.mIsSeeHost, this.fxh.mIsReserver, null);
            if (this.fxh.isFirstPost) {
                createHistoryCfg.setJumpToTopArea(true);
            } else {
                createHistoryCfg.setJumpToCommentArea(true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<Integer, Integer> Cu(String str) {
        return ag.u(str, fxg, fxf);
    }

    protected void q(View view, int i) {
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
    public void qB(int i) {
        q(this, i);
    }
}
