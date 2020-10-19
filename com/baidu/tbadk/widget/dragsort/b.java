package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int fjh;
    private int foI;
    private boolean foJ;
    private int foK;
    private boolean foL;
    private boolean foM;
    private GestureDetector foN;
    private GestureDetector foO;
    private int foP;
    private int foQ;
    private int foR;
    private int foS;
    private int foT;
    private int foU;
    private float foV;
    private int foW;
    private int foX;
    private int foY;
    private boolean foZ;
    private a fpa;
    private int fpb;
    private GestureDetector.OnGestureListener fpc;
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
        this.foI = 0;
        this.foJ = true;
        this.foL = false;
        this.foM = false;
        this.foP = -1;
        this.foQ = -1;
        this.foR = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.foV = 500.0f;
        this.fpc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.foL && b.this.foM) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.foV) {
                        if (b.this.fpb > (-width)) {
                            b.this.fpa.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.foV) && b.this.fpb < width) {
                        b.this.fpa.stopDragWithVelocity(true, f);
                    }
                    b.this.foM = false;
                }
                return false;
            }
        };
        this.fpa = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.foN = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.fpa.isDragEnabled() || b.this.fpa.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.foU = (int) motionEvent.getX();
                b.this.fjh = (int) motionEvent.getY();
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
        this.foO = new GestureDetector(listView.getContext(), this.fpc);
        this.foO.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.foW = i;
        this.foX = i4;
        this.foY = i5;
        rK(i3);
        rJ(i2);
    }

    public GestureDetector bAD() {
        return this.foN;
    }

    public void rJ(int i) {
        this.foI = i;
    }

    public void ks(boolean z) {
        this.foJ = z;
    }

    public void rK(int i) {
        this.foK = i;
    }

    public void kt(boolean z) {
        this.foL = z;
    }

    public boolean z(int i, int i2, int i3) {
        int i4 = 0;
        if (this.foJ && !this.foM) {
            i4 = 12;
        }
        if (this.foL && this.foM) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.fpa.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fpa.isDragEnabled() && !this.fpa.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.foL && this.mDragging && this.foK == 1) {
                this.foO.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.foU = (int) motionEvent.getX();
                    this.fjh = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.foL && this.foM) {
                        if ((this.fpb >= 0 ? this.fpb : -this.fpb) > this.mListView.getWidth() / 2) {
                            this.fpa.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.foM = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.foM = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.foL && this.foM) {
            this.fpb = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.foK == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return c(motionEvent, this.foW);
    }

    public int K(MotionEvent motionEvent) {
        return c(motionEvent, this.foY);
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
                        this.foS = childAt.getLeft();
                        this.foT = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.foL && this.foK == 0) {
            this.foR = c(motionEvent, this.foX);
        }
        this.foP = H(motionEvent);
        if (this.foP != -1 && this.foI == 0) {
            z(this.foP, ((int) motionEvent.getX()) - this.foS, ((int) motionEvent.getY()) - this.foT);
        }
        this.foM = false;
        this.foZ = true;
        this.fpb = 0;
        this.foQ = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.foS;
            int i2 = y2 - this.foT;
            if (this.foZ && !this.mDragging && (this.foP != -1 || this.foQ != -1)) {
                if (this.foP != -1) {
                    if (this.foI == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.foJ) {
                        z(this.foP, i, i2);
                    } else if (this.foI != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.foL) {
                        this.foM = true;
                        z(this.foQ, i, i2);
                    }
                } else if (this.foQ != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.foL) {
                        this.foM = true;
                        z(this.foQ, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.foZ = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.foP != -1 && this.foI == 2) {
            this.mListView.performHapticFeedback(0);
            z(this.foP, this.foU - this.foS, this.fjh - this.foT);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.foL && this.foK == 0 && this.foR != -1) {
            this.fpa.removeItem(this.foR - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
