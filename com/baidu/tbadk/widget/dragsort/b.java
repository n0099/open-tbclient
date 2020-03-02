package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int dKd;
    private boolean dKe;
    private int dKf;
    private boolean dKg;
    private boolean dKh;
    private GestureDetector dKi;
    private GestureDetector dKj;
    private int dKk;
    private int dKl;
    private int dKm;
    private int dKn;
    private int dKo;
    private int dKp;
    private int dKq;
    private float dKr;
    private int dKs;
    private int dKt;
    private int dKu;
    private boolean dKv;
    private a dKw;
    private int dKx;
    private GestureDetector.OnGestureListener dKy;
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
        this.dKd = 0;
        this.dKe = true;
        this.dKg = false;
        this.dKh = false;
        this.dKk = -1;
        this.dKl = -1;
        this.dKm = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.dKr = 500.0f;
        this.dKy = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.dKg && b.this.dKh) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.dKr) {
                        if (b.this.dKx > (-width)) {
                            b.this.dKw.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.dKr) && b.this.dKx < width) {
                        b.this.dKw.stopDragWithVelocity(true, f);
                    }
                    b.this.dKh = false;
                }
                return false;
            }
        };
        this.dKw = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.dKi = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.dKw.isDragEnabled() || b.this.dKw.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.dKp = (int) motionEvent.getX();
                b.this.dKq = (int) motionEvent.getY();
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
        this.dKj = new GestureDetector(listView.getContext(), this.dKy);
        this.dKj.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.dKs = i;
        this.dKt = i4;
        this.dKu = i5;
        nb(i3);
        na(i2);
    }

    public GestureDetector aTp() {
        return this.dKi;
    }

    public void na(int i) {
        this.dKd = i;
    }

    public void hh(boolean z) {
        this.dKe = z;
    }

    public void nb(int i) {
        this.dKf = i;
    }

    public void hi(boolean z) {
        this.dKg = z;
    }

    public boolean z(int i, int i2, int i3) {
        int i4 = 0;
        if (this.dKe && !this.dKh) {
            i4 = 12;
        }
        if (this.dKg && this.dKh) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.dKw.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dKw.isDragEnabled() && !this.dKw.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.dKg && this.mDragging && this.dKf == 1) {
                this.dKj.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dKp = (int) motionEvent.getX();
                    this.dKq = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.dKg && this.dKh) {
                        if ((this.dKx >= 0 ? this.dKx : -this.dKx) > this.mListView.getWidth() / 2) {
                            this.dKw.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.dKh = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.dKh = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.dKg && this.dKh) {
            this.dKx = point.x;
        }
    }

    public int t(MotionEvent motionEvent) {
        return v(motionEvent);
    }

    public int u(MotionEvent motionEvent) {
        if (this.dKf == 1) {
            return w(motionEvent);
        }
        return -1;
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.dKs);
    }

    public int w(MotionEvent motionEvent) {
        return c(motionEvent, this.dKu);
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
                        this.dKn = childAt.getLeft();
                        this.dKo = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.dKg && this.dKf == 0) {
            this.dKm = c(motionEvent, this.dKt);
        }
        this.dKk = t(motionEvent);
        if (this.dKk != -1 && this.dKd == 0) {
            z(this.dKk, ((int) motionEvent.getX()) - this.dKn, ((int) motionEvent.getY()) - this.dKo);
        }
        this.dKh = false;
        this.dKv = true;
        this.dKx = 0;
        this.dKl = u(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.dKn;
            int i2 = y2 - this.dKo;
            if (this.dKv && !this.mDragging && (this.dKk != -1 || this.dKl != -1)) {
                if (this.dKk != -1) {
                    if (this.dKd == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.dKe) {
                        z(this.dKk, i, i2);
                    } else if (this.dKd != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.dKg) {
                        this.dKh = true;
                        z(this.dKl, i, i2);
                    }
                } else if (this.dKl != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.dKg) {
                        this.dKh = true;
                        z(this.dKl, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.dKv = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.dKk != -1 && this.dKd == 2) {
            this.mListView.performHapticFeedback(0);
            z(this.dKk, this.dKp - this.dKn, this.dKq - this.dKo);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.dKg && this.dKf == 0 && this.dKm != -1) {
            this.dKw.removeItem(this.dKm - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
