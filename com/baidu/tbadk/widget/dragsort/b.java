package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int dKA;
    private int dKB;
    private int dKC;
    private int dKD;
    private float dKE;
    private int dKF;
    private int dKG;
    private int dKH;
    private boolean dKI;
    private a dKJ;
    private int dKK;
    private GestureDetector.OnGestureListener dKL;
    private int dKq;
    private boolean dKr;
    private int dKs;
    private boolean dKt;
    private boolean dKu;
    private GestureDetector dKv;
    private GestureDetector dKw;
    private int dKx;
    private int dKy;
    private int dKz;
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
        this.dKq = 0;
        this.dKr = true;
        this.dKt = false;
        this.dKu = false;
        this.dKx = -1;
        this.dKy = -1;
        this.dKz = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.dKE = 500.0f;
        this.dKL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.dKt && b.this.dKu) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.dKE) {
                        if (b.this.dKK > (-width)) {
                            b.this.dKJ.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.dKE) && b.this.dKK < width) {
                        b.this.dKJ.stopDragWithVelocity(true, f);
                    }
                    b.this.dKu = false;
                }
                return false;
            }
        };
        this.dKJ = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.dKv = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.dKJ.isDragEnabled() || b.this.dKJ.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.dKC = (int) motionEvent.getX();
                b.this.dKD = (int) motionEvent.getY();
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
        this.dKw = new GestureDetector(listView.getContext(), this.dKL);
        this.dKw.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.dKF = i;
        this.dKG = i4;
        this.dKH = i5;
        nb(i3);
        na(i2);
    }

    public GestureDetector aTq() {
        return this.dKv;
    }

    public void na(int i) {
        this.dKq = i;
    }

    public void hh(boolean z) {
        this.dKr = z;
    }

    public void nb(int i) {
        this.dKs = i;
    }

    public void hi(boolean z) {
        this.dKt = z;
    }

    public boolean z(int i, int i2, int i3) {
        int i4 = 0;
        if (this.dKr && !this.dKu) {
            i4 = 12;
        }
        if (this.dKt && this.dKu) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.dKJ.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dKJ.isDragEnabled() && !this.dKJ.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.dKt && this.mDragging && this.dKs == 1) {
                this.dKw.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dKC = (int) motionEvent.getX();
                    this.dKD = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.dKt && this.dKu) {
                        if ((this.dKK >= 0 ? this.dKK : -this.dKK) > this.mListView.getWidth() / 2) {
                            this.dKJ.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.dKu = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.dKu = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.dKt && this.dKu) {
            this.dKK = point.x;
        }
    }

    public int t(MotionEvent motionEvent) {
        return v(motionEvent);
    }

    public int u(MotionEvent motionEvent) {
        if (this.dKs == 1) {
            return w(motionEvent);
        }
        return -1;
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.dKF);
    }

    public int w(MotionEvent motionEvent) {
        return c(motionEvent, this.dKH);
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
                        this.dKA = childAt.getLeft();
                        this.dKB = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.dKt && this.dKs == 0) {
            this.dKz = c(motionEvent, this.dKG);
        }
        this.dKx = t(motionEvent);
        if (this.dKx != -1 && this.dKq == 0) {
            z(this.dKx, ((int) motionEvent.getX()) - this.dKA, ((int) motionEvent.getY()) - this.dKB);
        }
        this.dKu = false;
        this.dKI = true;
        this.dKK = 0;
        this.dKy = u(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.dKA;
            int i2 = y2 - this.dKB;
            if (this.dKI && !this.mDragging && (this.dKx != -1 || this.dKy != -1)) {
                if (this.dKx != -1) {
                    if (this.dKq == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.dKr) {
                        z(this.dKx, i, i2);
                    } else if (this.dKq != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.dKt) {
                        this.dKu = true;
                        z(this.dKy, i, i2);
                    }
                } else if (this.dKy != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.dKt) {
                        this.dKu = true;
                        z(this.dKy, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.dKI = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.dKx != -1 && this.dKq == 2) {
            this.mListView.performHapticFeedback(0);
            z(this.dKx, this.dKC - this.dKA, this.dKD - this.dKB);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.dKt && this.dKs == 0 && this.dKz != -1) {
            this.dKJ.removeItem(this.dKz - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
