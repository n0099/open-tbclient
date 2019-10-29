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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
/* loaded from: classes3.dex */
public abstract class AbsFloorImageTextView extends RelativeLayout {
    protected ImageUrlData czt;
    private c.a czu;
    public com.baidu.tieba.pb.a.c czv;
    protected String mUserId;
    protected static final int czp = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds34);
    protected static final int czq = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds28);
    protected static final int LEFT = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
    protected static final int RIGHT = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
    protected static final int czr = (l.getEquipmentWidth(TbadkApplication.getInst()) - LEFT) - RIGHT;
    protected static final int czs = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds42);

    public abstract void a(ImageUrlData imageUrlData);

    public abstract void t(boolean z, boolean z2);

    public AbsFloorImageTextView(@NonNull Context context) {
        super(context);
        this.czu = new c.a() { // from class: com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView.1
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
                AbsFloorImageTextView.this.asj();
                return true;
            }
        };
        this.czv = new com.baidu.tieba.pb.a.c(this.czu) { // from class: com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView.2
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

    public void asj() {
        if (this.czt != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.czt.threadId), String.valueOf(this.czt.postId), this.czt.mIsSeeHost, this.czt.mIsReserver, null);
            if (this.czt.isFirstPost) {
                createHistoryCfg.setJumpToTopArea(true);
            } else {
                createHistoryCfg.setJumpToCommentArea(true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<Integer, Integer> pa(String str) {
        return aa.p(str, czs, czr);
    }

    protected void h(View view, int i) {
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
    public void jq(int i) {
        h(this, i);
    }
}
