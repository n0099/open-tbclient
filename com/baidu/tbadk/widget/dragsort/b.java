package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes2.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int eUb;
    private boolean eZA;
    private int eZB;
    private boolean eZC;
    private boolean eZD;
    private GestureDetector eZE;
    private GestureDetector eZF;
    private int eZG;
    private int eZH;
    private int eZI;
    private int eZJ;
    private int eZK;
    private int eZL;
    private float eZM;
    private int eZN;
    private int eZO;
    private int eZP;
    private boolean eZQ;
    private a eZR;
    private int eZS;
    private GestureDetector.OnGestureListener eZT;
    private int eZz;
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
        this.eZz = 0;
        this.eZA = true;
        this.eZC = false;
        this.eZD = false;
        this.eZG = -1;
        this.eZH = -1;
        this.eZI = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.eZM = 500.0f;
        this.eZT = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.eZC && b.this.eZD) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.eZM) {
                        if (b.this.eZS > (-width)) {
                            b.this.eZR.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.eZM) && b.this.eZS < width) {
                        b.this.eZR.stopDragWithVelocity(true, f);
                    }
                    b.this.eZD = false;
                }
                return false;
            }
        };
        this.eZR = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.eZE = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.eZR.isDragEnabled() || b.this.eZR.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.eZL = (int) motionEvent.getX();
                b.this.eUb = (int) motionEvent.getY();
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
        this.eZF = new GestureDetector(listView.getContext(), this.eZT);
        this.eZF.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.eZN = i;
        this.eZO = i4;
        this.eZP = i5;
        qV(i3);
        qU(i2);
    }

    public GestureDetector bwJ() {
        return this.eZE;
    }

    public void qU(int i) {
        this.eZz = i;
    }

    public void jR(boolean z) {
        this.eZA = z;
    }

    public void qV(int i) {
        this.eZB = i;
    }

    public void jS(boolean z) {
        this.eZC = z;
    }

    public boolean z(int i, int i2, int i3) {
        int i4 = 0;
        if (this.eZA && !this.eZD) {
            i4 = 12;
        }
        if (this.eZC && this.eZD) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.eZR.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eZR.isDragEnabled() && !this.eZR.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.eZC && this.mDragging && this.eZB == 1) {
                this.eZF.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.eZL = (int) motionEvent.getX();
                    this.eUb = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.eZC && this.eZD) {
                        if ((this.eZS >= 0 ? this.eZS : -this.eZS) > this.mListView.getWidth() / 2) {
                            this.eZR.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.eZD = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.eZD = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.eZC && this.eZD) {
            this.eZS = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.eZB == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return c(motionEvent, this.eZN);
    }

    public int K(MotionEvent motionEvent) {
        return c(motionEvent, this.eZP);
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
                        this.eZJ = childAt.getLeft();
                        this.eZK = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.eZC && this.eZB == 0) {
            this.eZI = c(motionEvent, this.eZO);
        }
        this.eZG = H(motionEvent);
        if (this.eZG != -1 && this.eZz == 0) {
            z(this.eZG, ((int) motionEvent.getX()) - this.eZJ, ((int) motionEvent.getY()) - this.eZK);
        }
        this.eZD = false;
        this.eZQ = true;
        this.eZS = 0;
        this.eZH = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.eZJ;
            int i2 = y2 - this.eZK;
            if (this.eZQ && !this.mDragging && (this.eZG != -1 || this.eZH != -1)) {
                if (this.eZG != -1) {
                    if (this.eZz == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.eZA) {
                        z(this.eZG, i, i2);
                    } else if (this.eZz != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.eZC) {
                        this.eZD = true;
                        z(this.eZH, i, i2);
                    }
                } else if (this.eZH != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.eZC) {
                        this.eZD = true;
                        z(this.eZH, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.eZQ = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.eZG != -1 && this.eZz == 2) {
            this.mListView.performHapticFeedback(0);
            z(this.eZG, this.eZL - this.eZJ, this.eUb - this.eZK);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.eZC && this.eZB == 0 && this.eZI != -1) {
            this.eZR.removeItem(this.eZI - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
