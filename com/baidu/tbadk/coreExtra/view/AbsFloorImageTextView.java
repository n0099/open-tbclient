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
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
/* loaded from: classes6.dex */
public abstract class AbsFloorImageTextView extends RelativeLayout {
    public com.baidu.tieba.pb.a.c dmA;
    protected ImageUrlData dmy;
    private c.a dmz;
    protected String mUserId;
    protected static final int TOP = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds34);
    protected static final int BOTTOM = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds28);
    protected static final int LEFT = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
    protected static final int RIGHT = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds44);
    protected static final int dmw = (l.getEquipmentWidth(TbadkApplication.getInst()) - LEFT) - RIGHT;
    protected static final int dmx = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds42);

    public abstract void a(ImageUrlData imageUrlData);

    public abstract void t(boolean z, boolean z2);

    public AbsFloorImageTextView(@NonNull Context context) {
        super(context);
        this.dmz = new c.a() { // from class: com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView.1
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
                AbsFloorImageTextView.this.aKa();
                return true;
            }
        };
        this.dmA = new com.baidu.tieba.pb.a.c(this.dmz) { // from class: com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView.2
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

    public void aKa() {
        if (this.dmy != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.dmy.threadId), String.valueOf(this.dmy.postId), this.dmy.mIsSeeHost, this.dmy.mIsReserver, null);
            if (this.dmy.isFirstPost) {
                createHistoryCfg.setJumpToTopArea(true);
            } else {
                createHistoryCfg.setJumpToCommentArea(true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<Integer, Integer> uj(String str) {
        return ad.r(str, dmx, dmw);
    }

    protected void i(View view, int i) {
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
    public void lC(int i) {
        i(this, i);
    }
}
