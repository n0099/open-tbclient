package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int cxC;
    private boolean cxD;
    private int cxE;
    private boolean cxF;
    private boolean cxG;
    private GestureDetector cxH;
    private GestureDetector cxI;
    private int cxJ;
    private int cxK;
    private int cxL;
    private int cxM;
    private int cxN;
    private int cxO;
    private int cxP;
    private boolean cxQ;
    private float cxR;
    private int cxS;
    private int cxT;
    private int cxU;
    private boolean cxV;
    private a cxW;
    private int cxX;
    private GestureDetector.OnGestureListener cxY;
    private GestureDetector mDetector;
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
        this.cxC = 0;
        this.cxD = true;
        this.cxF = false;
        this.cxG = false;
        this.cxJ = -1;
        this.cxK = -1;
        this.cxL = -1;
        this.mTempLoc = new int[2];
        this.cxQ = false;
        this.cxR = 500.0f;
        this.cxY = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.cxF && b.this.cxG) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.cxR) {
                        if (b.this.cxX > (-width)) {
                            b.this.cxW.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.cxR) && b.this.cxX < width) {
                        b.this.cxW.stopDragWithVelocity(true, f);
                    }
                    b.this.cxG = false;
                }
                return false;
            }
        };
        this.cxW = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.cxH = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.cxW.isDragEnabled() || b.this.cxW.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.cxO = (int) motionEvent.getX();
                b.this.cxP = (int) motionEvent.getY();
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
        this.cxI = new GestureDetector(listView.getContext(), this.cxY);
        this.cxI.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.cxS = i;
        this.cxT = i4;
        this.cxU = i5;
        kp(i3);
        ko(i2);
    }

    public GestureDetector ars() {
        return this.cxH;
    }

    public void ko(int i) {
        this.cxC = i;
    }

    public void fo(boolean z) {
        this.cxD = z;
    }

    public void kp(int i) {
        this.cxE = i;
    }

    public void fp(boolean z) {
        this.cxF = z;
    }

    public boolean s(int i, int i2, int i3) {
        int i4 = 0;
        if (this.cxD && !this.cxG) {
            i4 = 12;
        }
        if (this.cxF && this.cxG) {
            i4 = i4 | 1 | 2;
        }
        this.cxQ = this.cxW.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.cxQ;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cxW.isDragEnabled() && !this.cxW.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.cxF && this.cxQ && this.cxE == 1) {
                this.cxI.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cxO = (int) motionEvent.getX();
                    this.cxP = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.cxF && this.cxG) {
                        if ((this.cxX >= 0 ? this.cxX : -this.cxX) > this.mListView.getWidth() / 2) {
                            this.cxW.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.cxG = false;
                    this.cxQ = false;
                    break;
                case 3:
                    this.cxG = false;
                    this.cxQ = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.cxF && this.cxG) {
            this.cxX = point.x;
        }
    }

    public int z(MotionEvent motionEvent) {
        return B(motionEvent);
    }

    public int A(MotionEvent motionEvent) {
        if (this.cxE == 1) {
            return C(motionEvent);
        }
        return -1;
    }

    public int B(MotionEvent motionEvent) {
        return c(motionEvent, this.cxS);
    }

    public int C(MotionEvent motionEvent) {
        return c(motionEvent, this.cxU);
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
                        this.cxM = childAt.getLeft();
                        this.cxN = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.cxF && this.cxE == 0) {
            this.cxL = c(motionEvent, this.cxT);
        }
        this.cxJ = z(motionEvent);
        if (this.cxJ != -1 && this.cxC == 0) {
            s(this.cxJ, ((int) motionEvent.getX()) - this.cxM, ((int) motionEvent.getY()) - this.cxN);
        }
        this.cxG = false;
        this.cxV = true;
        this.cxX = 0;
        this.cxK = A(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.cxM;
            int i2 = y2 - this.cxN;
            if (this.cxV && !this.cxQ && (this.cxJ != -1 || this.cxK != -1)) {
                if (this.cxJ != -1) {
                    if (this.cxC == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.cxD) {
                        s(this.cxJ, i, i2);
                    } else if (this.cxC != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.cxF) {
                        this.cxG = true;
                        s(this.cxK, i, i2);
                    }
                } else if (this.cxK != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.cxF) {
                        this.cxG = true;
                        s(this.cxK, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.cxV = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.cxJ != -1 && this.cxC == 2) {
            this.mListView.performHapticFeedback(0);
            s(this.cxJ, this.cxO - this.cxM, this.cxP - this.cxN);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.cxF && this.cxE == 0 && this.cxL != -1) {
            this.cxW.removeItem(this.cxL - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
