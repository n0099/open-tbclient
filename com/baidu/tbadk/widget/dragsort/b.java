package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int eWV;
    private boolean fcA;
    private GestureDetector fcB;
    private GestureDetector fcC;
    private int fcD;
    private int fcE;
    private int fcF;
    private int fcG;
    private int fcH;
    private int fcI;
    private float fcJ;
    private int fcK;
    private int fcL;
    private int fcM;
    private boolean fcN;
    private a fcO;
    private int fcP;
    private GestureDetector.OnGestureListener fcQ;
    private int fcw;
    private boolean fcx;
    private int fcy;
    private boolean fcz;
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
        this.fcw = 0;
        this.fcx = true;
        this.fcz = false;
        this.fcA = false;
        this.fcD = -1;
        this.fcE = -1;
        this.fcF = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.fcJ = 500.0f;
        this.fcQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.fcz && b.this.fcA) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.fcJ) {
                        if (b.this.fcP > (-width)) {
                            b.this.fcO.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.fcJ) && b.this.fcP < width) {
                        b.this.fcO.stopDragWithVelocity(true, f);
                    }
                    b.this.fcA = false;
                }
                return false;
            }
        };
        this.fcO = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.fcB = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.fcO.isDragEnabled() || b.this.fcO.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.fcI = (int) motionEvent.getX();
                b.this.eWV = (int) motionEvent.getY();
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
        this.fcC = new GestureDetector(listView.getContext(), this.fcQ);
        this.fcC.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.fcK = i;
        this.fcL = i4;
        this.fcM = i5;
        rm(i3);
        rl(i2);
    }

    public GestureDetector bxT() {
        return this.fcB;
    }

    public void rl(int i) {
        this.fcw = i;
    }

    public void jU(boolean z) {
        this.fcx = z;
    }

    public void rm(int i) {
        this.fcy = i;
    }

    public void jV(boolean z) {
        this.fcz = z;
    }

    public boolean z(int i, int i2, int i3) {
        int i4 = 0;
        if (this.fcx && !this.fcA) {
            i4 = 12;
        }
        if (this.fcz && this.fcA) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.fcO.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fcO.isDragEnabled() && !this.fcO.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.fcz && this.mDragging && this.fcy == 1) {
                this.fcC.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.fcI = (int) motionEvent.getX();
                    this.eWV = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.fcz && this.fcA) {
                        if ((this.fcP >= 0 ? this.fcP : -this.fcP) > this.mListView.getWidth() / 2) {
                            this.fcO.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.fcA = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.fcA = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.fcz && this.fcA) {
            this.fcP = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.fcy == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return c(motionEvent, this.fcK);
    }

    public int K(MotionEvent motionEvent) {
        return c(motionEvent, this.fcM);
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
                        this.fcG = childAt.getLeft();
                        this.fcH = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.fcz && this.fcy == 0) {
            this.fcF = c(motionEvent, this.fcL);
        }
        this.fcD = H(motionEvent);
        if (this.fcD != -1 && this.fcw == 0) {
            z(this.fcD, ((int) motionEvent.getX()) - this.fcG, ((int) motionEvent.getY()) - this.fcH);
        }
        this.fcA = false;
        this.fcN = true;
        this.fcP = 0;
        this.fcE = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.fcG;
            int i2 = y2 - this.fcH;
            if (this.fcN && !this.mDragging && (this.fcD != -1 || this.fcE != -1)) {
                if (this.fcD != -1) {
                    if (this.fcw == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.fcx) {
                        z(this.fcD, i, i2);
                    } else if (this.fcw != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.fcz) {
                        this.fcA = true;
                        z(this.fcE, i, i2);
                    }
                } else if (this.fcE != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.fcz) {
                        this.fcA = true;
                        z(this.fcE, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.fcN = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.fcD != -1 && this.fcw == 2) {
            this.mListView.performHapticFeedback(0);
            z(this.fcD, this.fcI - this.fcG, this.eWV - this.fcH);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.fcz && this.fcy == 0 && this.fcF != -1) {
            this.fcO.removeItem(this.fcF - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
