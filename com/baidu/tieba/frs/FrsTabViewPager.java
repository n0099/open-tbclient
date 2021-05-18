package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
/* loaded from: classes4.dex */
public class FrsTabViewPager extends BdBaseViewPager {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f15262a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15263b;

        public boolean a() {
            return this.f15262a;
        }

        public boolean b() {
            return this.f15263b;
        }

        public void c(boolean z) {
            this.f15262a = z;
        }

        public void d(boolean z) {
            this.f15263b = z;
        }
    }

    public FrsTabViewPager(Context context) {
        this(context, null);
    }

    public final boolean c() {
        return getCurrentItem() == getAdapter().getCount() - 1;
    }

    public void d() {
        e(false);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            e(true);
        } else if (action == 1) {
            e(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e(boolean z) {
        a aVar = new a();
        aVar.c(c());
        aVar.d(z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921369, aVar));
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            e(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public FrsTabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
