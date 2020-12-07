package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int fEC;
    private float fKA;
    private int fKB;
    private int fKC;
    private int fKD;
    private boolean fKE;
    private a fKF;
    private int fKG;
    private GestureDetector.OnGestureListener fKH;
    private int fKn;
    private boolean fKo;
    private int fKp;
    private boolean fKq;
    private boolean fKr;
    private GestureDetector fKs;
    private GestureDetector fKt;
    private int fKu;
    private int fKv;
    private int fKw;
    private int fKx;
    private int fKy;
    private int fKz;
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
        this.fKn = 0;
        this.fKo = true;
        this.fKq = false;
        this.fKr = false;
        this.fKu = -1;
        this.fKv = -1;
        this.fKw = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.fKA = 500.0f;
        this.fKH = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.fKq && b.this.fKr) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.fKA) {
                        if (b.this.fKG > (-width)) {
                            b.this.fKF.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.fKA) && b.this.fKG < width) {
                        b.this.fKF.stopDragWithVelocity(true, f);
                    }
                    b.this.fKr = false;
                }
                return false;
            }
        };
        this.fKF = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.fKs = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.fKF.isDragEnabled() || b.this.fKF.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.fKz = (int) motionEvent.getX();
                b.this.fEC = (int) motionEvent.getY();
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
        this.fKt = new GestureDetector(listView.getContext(), this.fKH);
        this.fKt.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.fKB = i;
        this.fKC = i4;
        this.fKD = i5;
        tg(i3);
        tf(i2);
    }

    public GestureDetector bHP() {
        return this.fKs;
    }

    public void tf(int i) {
        this.fKn = i;
    }

    public void lj(boolean z) {
        this.fKo = z;
    }

    public void tg(int i) {
        this.fKp = i;
    }

    public void lk(boolean z) {
        this.fKq = z;
    }

    public boolean B(int i, int i2, int i3) {
        int i4 = 0;
        if (this.fKo && !this.fKr) {
            i4 = 12;
        }
        if (this.fKq && this.fKr) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.fKF.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fKF.isDragEnabled() && !this.fKF.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.fKq && this.mDragging && this.fKp == 1) {
                this.fKt.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.fKz = (int) motionEvent.getX();
                    this.fEC = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.fKq && this.fKr) {
                        if ((this.fKG >= 0 ? this.fKG : -this.fKG) > this.mListView.getWidth() / 2) {
                            this.fKF.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.fKr = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.fKr = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.fKq && this.fKr) {
            this.fKG = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.fKp == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return c(motionEvent, this.fKB);
    }

    public int K(MotionEvent motionEvent) {
        return c(motionEvent, this.fKD);
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
                        this.fKx = childAt.getLeft();
                        this.fKy = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.fKq && this.fKp == 0) {
            this.fKw = c(motionEvent, this.fKC);
        }
        this.fKu = H(motionEvent);
        if (this.fKu != -1 && this.fKn == 0) {
            B(this.fKu, ((int) motionEvent.getX()) - this.fKx, ((int) motionEvent.getY()) - this.fKy);
        }
        this.fKr = false;
        this.fKE = true;
        this.fKG = 0;
        this.fKv = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.fKx;
            int i2 = y2 - this.fKy;
            if (this.fKE && !this.mDragging && (this.fKu != -1 || this.fKv != -1)) {
                if (this.fKu != -1) {
                    if (this.fKn == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.fKo) {
                        B(this.fKu, i, i2);
                    } else if (this.fKn != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.fKq) {
                        this.fKr = true;
                        B(this.fKv, i, i2);
                    }
                } else if (this.fKv != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.fKq) {
                        this.fKr = true;
                        B(this.fKv, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.fKE = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.fKu != -1 && this.fKn == 2) {
            this.mListView.performHapticFeedback(0);
            B(this.fKu, this.fKz - this.fKx, this.fEC - this.fKy);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.fKq && this.fKp == 0 && this.fKw != -1) {
            this.fKF.removeItem(this.fKw - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
