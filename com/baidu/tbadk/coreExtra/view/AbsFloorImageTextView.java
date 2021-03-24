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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.z0.i0;
import d.b.i0.c2.i.c;
/* loaded from: classes3.dex */
public abstract class AbsFloorImageTextView extends RelativeLayout {

    /* renamed from: h  reason: collision with root package name */
    public static final int f13719h = l.g(TbadkApplication.getInst(), R.dimen.tbds34);
    public static final int i = l.g(TbadkApplication.getInst(), R.dimen.tbds28);
    public static final int j = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
    public static final int k = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
    public static final int l = (l.k(TbadkApplication.getInst()) - j) - k;
    public static final int m = l.g(TbadkApplication.getInst(), R.dimen.tbds42);

    /* renamed from: e  reason: collision with root package name */
    public ImageUrlData f13720e;

    /* renamed from: f  reason: collision with root package name */
    public c.a f13721f;

    /* renamed from: g  reason: collision with root package name */
    public c f13722g;

    /* loaded from: classes3.dex */
    public class a implements c.a {
        public a() {
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            AbsFloorImageTextView.this.c();
            return true;
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // d.b.i0.c2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c {
        public b(c.a aVar) {
            super(aVar);
        }

        @Override // d.b.i0.c2.i.c, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // d.b.i0.c2.i.c, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }
    }

    public AbsFloorImageTextView(@NonNull Context context) {
        super(context);
        a aVar = new a();
        this.f13721f = aVar;
        this.f13722g = new b(aVar);
    }

    public void a(int i2) {
        b(this, i2);
    }

    public void b(View view, int i2) {
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || height == i2) {
            return;
        }
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public void c() {
        ImageUrlData imageUrlData = this.f13720e;
        if (imageUrlData == null) {
            return;
        }
        String valueOf = String.valueOf(imageUrlData.threadId);
        String valueOf2 = String.valueOf(this.f13720e.postId);
        PbActivityConfig pbActivityConfig = new PbActivityConfig(getContext());
        ImageUrlData imageUrlData2 = this.f13720e;
        PbActivityConfig createHistoryCfg = pbActivityConfig.createHistoryCfg(valueOf, valueOf2, imageUrlData2.mIsSeeHost, imageUrlData2.mIsReserver, null);
        if (this.f13720e.isFirstPost) {
            createHistoryCfg.setJumpToTopArea(true);
        } else {
            createHistoryCfg.setJumpToCommentArea(true);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
    }

    public Pair<Integer, Integer> d(String str) {
        return i0.i(str, m, l);
    }

    public abstract void e(boolean z);

    public abstract void f(ImageUrlData imageUrlData);

    public void setUserId(String str) {
    }
}
