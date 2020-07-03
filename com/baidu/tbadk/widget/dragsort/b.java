package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int eDg;
    private boolean eIA;
    private boolean eIB;
    private GestureDetector eIC;
    private GestureDetector eID;
    private int eIE;
    private int eIF;
    private int eIG;
    private int eIH;
    private int eII;
    private int eIJ;
    private float eIK;
    private int eIL;
    private int eIM;
    private int eIN;
    private boolean eIO;
    private a eIP;
    private int eIQ;
    private GestureDetector.OnGestureListener eIR;
    private int eIx;
    private boolean eIy;
    private int eIz;
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
        this.eIx = 0;
        this.eIy = true;
        this.eIA = false;
        this.eIB = false;
        this.eIE = -1;
        this.eIF = -1;
        this.eIG = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.eIK = 500.0f;
        this.eIR = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.eIA && b.this.eIB) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.eIK) {
                        if (b.this.eIQ > (-width)) {
                            b.this.eIP.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.eIK) && b.this.eIQ < width) {
                        b.this.eIP.stopDragWithVelocity(true, f);
                    }
                    b.this.eIB = false;
                }
                return false;
            }
        };
        this.eIP = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.eIC = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.eIP.isDragEnabled() || b.this.eIP.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.eIJ = (int) motionEvent.getX();
                b.this.eDg = (int) motionEvent.getY();
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
        this.eID = new GestureDetector(listView.getContext(), this.eIR);
        this.eID.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.eIL = i;
        this.eIM = i4;
        this.eIN = i5;
        oq(i3);
        op(i2);
    }

    public GestureDetector bkb() {
        return this.eIC;
    }

    public void op(int i) {
        this.eIx = i;
    }

    public void iO(boolean z) {
        this.eIy = z;
    }

    public void oq(int i) {
        this.eIz = i;
    }

    public void iP(boolean z) {
        this.eIA = z;
    }

    public boolean A(int i, int i2, int i3) {
        int i4 = 0;
        if (this.eIy && !this.eIB) {
            i4 = 12;
        }
        if (this.eIA && this.eIB) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.eIP.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eIP.isDragEnabled() && !this.eIP.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.eIA && this.mDragging && this.eIz == 1) {
                this.eID.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.eIJ = (int) motionEvent.getX();
                    this.eDg = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.eIA && this.eIB) {
                        if ((this.eIQ >= 0 ? this.eIQ : -this.eIQ) > this.mListView.getWidth() / 2) {
                            this.eIP.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.eIB = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.eIB = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.eIA && this.eIB) {
            this.eIQ = point.x;
        }
    }

    public int s(MotionEvent motionEvent) {
        return u(motionEvent);
    }

    public int t(MotionEvent motionEvent) {
        if (this.eIz == 1) {
            return v(motionEvent);
        }
        return -1;
    }

    public int u(MotionEvent motionEvent) {
        return c(motionEvent, this.eIL);
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.eIN);
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
                        this.eIH = childAt.getLeft();
                        this.eII = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.eIA && this.eIz == 0) {
            this.eIG = c(motionEvent, this.eIM);
        }
        this.eIE = s(motionEvent);
        if (this.eIE != -1 && this.eIx == 0) {
            A(this.eIE, ((int) motionEvent.getX()) - this.eIH, ((int) motionEvent.getY()) - this.eII);
        }
        this.eIB = false;
        this.eIO = true;
        this.eIQ = 0;
        this.eIF = t(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.eIH;
            int i2 = y2 - this.eII;
            if (this.eIO && !this.mDragging && (this.eIE != -1 || this.eIF != -1)) {
                if (this.eIE != -1) {
                    if (this.eIx == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.eIy) {
                        A(this.eIE, i, i2);
                    } else if (this.eIx != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.eIA) {
                        this.eIB = true;
                        A(this.eIF, i, i2);
                    }
                } else if (this.eIF != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.eIA) {
                        this.eIB = true;
                        A(this.eIF, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.eIO = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.eIE != -1 && this.eIx == 2) {
            this.mListView.performHapticFeedback(0);
            A(this.eIE, this.eIJ - this.eIH, this.eDg - this.eII);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.eIA && this.eIz == 0 && this.eIG != -1) {
            this.eIP.removeItem(this.eIG - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
