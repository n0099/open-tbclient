package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int dKc;
    private boolean dKd;
    private int dKe;
    private boolean dKf;
    private boolean dKg;
    private GestureDetector dKh;
    private GestureDetector dKi;
    private int dKj;
    private int dKk;
    private int dKl;
    private int dKm;
    private int dKn;
    private int dKo;
    private int dKp;
    private float dKq;
    private int dKr;
    private int dKs;
    private int dKt;
    private boolean dKu;
    private a dKv;
    private int dKw;
    private GestureDetector.OnGestureListener dKx;
    private GestureDetector mDetector;
    private boolean mDragging;
    private ListView mListView;
    private int[] mTempLoc;
    private int mTouchSlop;

    public b(a aVar, ListView listView, int i, int i2, int i3) {
        this(aVar, listView, i, i2, i3, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4) {
        this(aVar, listView, i, i2, i3, i4, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4, int i5) {
        super(listView);
        this.dKc = 0;
        this.dKd = true;
        this.dKf = false;
        this.dKg = false;
        this.dKj = -1;
        this.dKk = -1;
        this.dKl = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.dKq = 500.0f;
        this.dKx = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.dKf && b.this.dKg) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.dKq) {
                        if (b.this.dKw > (-width)) {
                            b.this.dKv.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.dKq) && b.this.dKw < width) {
                        b.this.dKv.stopDragWithVelocity(true, f);
                    }
                    b.this.dKg = false;
                }
                return false;
            }
        };
        this.dKv = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.dKh = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.dKv.isDragEnabled() || b.this.dKv.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.dKo = (int) motionEvent.getX();
                b.this.dKp = (int) motionEvent.getY();
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                b.this.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        });
        this.dKi = new GestureDetector(listView.getContext(), this.dKx);
        this.dKi.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.dKr = i;
        this.dKs = i4;
        this.dKt = i5;
        nb(i3);
        na(i2);
    }

    public GestureDetector aTn() {
        return this.dKh;
    }

    public void na(int i) {
        this.dKc = i;
    }

    public void hh(boolean z) {
        this.dKd = z;
    }

    public void nb(int i) {
        this.dKe = i;
    }

    public void hi(boolean z) {
        this.dKf = z;
    }

    public boolean z(int i, int i2, int i3) {
        int i4 = 0;
        if (this.dKd && !this.dKg) {
            i4 = 12;
        }
        if (this.dKf && this.dKg) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.dKv.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dKv.isDragEnabled() && !this.dKv.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.dKf && this.mDragging && this.dKe == 1) {
                this.dKi.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dKo = (int) motionEvent.getX();
                    this.dKp = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.dKf && this.dKg) {
                        if ((this.dKw >= 0 ? this.dKw : -this.dKw) > this.mListView.getWidth() / 2) {
                            this.dKv.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.dKg = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.dKg = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.dKf && this.dKg) {
            this.dKw = point.x;
        }
    }

    public int t(MotionEvent motionEvent) {
        return v(motionEvent);
    }

    public int u(MotionEvent motionEvent) {
        if (this.dKe == 1) {
            return w(motionEvent);
        }
        return -1;
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.dKr);
    }

    public int w(MotionEvent motionEvent) {
        return c(motionEvent, this.dKt);
    }

    public int c(MotionEvent motionEvent, int i) {
        int pointToPosition = this.mListView.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int count = this.mListView.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.mListView.getChildAt(pointToPosition - this.mListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.mTempLoc);
                if (rawX > this.mTempLoc[0] && rawY > this.mTempLoc[1] && rawX < this.mTempLoc[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.mTempLoc[1]) {
                        this.dKm = childAt.getLeft();
                        this.dKn = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.dKf && this.dKe == 0) {
            this.dKl = c(motionEvent, this.dKs);
        }
        this.dKj = t(motionEvent);
        if (this.dKj != -1 && this.dKc == 0) {
            z(this.dKj, ((int) motionEvent.getX()) - this.dKm, ((int) motionEvent.getY()) - this.dKn);
        }
        this.dKg = false;
        this.dKu = true;
        this.dKw = 0;
        this.dKk = u(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.dKm;
            int i2 = y2 - this.dKn;
            if (this.dKu && !this.mDragging && (this.dKj != -1 || this.dKk != -1)) {
                if (this.dKj != -1) {
                    if (this.dKc == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.dKd) {
                        z(this.dKj, i, i2);
                    } else if (this.dKc != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.dKf) {
                        this.dKg = true;
                        z(this.dKk, i, i2);
                    }
                } else if (this.dKk != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.dKf) {
                        this.dKg = true;
                        z(this.dKk, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.dKu = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.dKj != -1 && this.dKc == 2) {
            this.mListView.performHapticFeedback(0);
            z(this.dKj, this.dKo - this.dKm, this.dKp - this.dKn);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.dKf && this.dKe == 0 && this.dKl != -1) {
            this.dKv.removeItem(this.dKl - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
