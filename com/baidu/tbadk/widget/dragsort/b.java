package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int cxF;
    private boolean cxG;
    private int cxH;
    private boolean cxI;
    private boolean cxJ;
    private GestureDetector cxK;
    private GestureDetector cxL;
    private int cxM;
    private int cxN;
    private int cxO;
    private int cxP;
    private int cxQ;
    private int cxR;
    private int cxS;
    private boolean cxT;
    private float cxU;
    private int cxV;
    private int cxW;
    private int cxX;
    private boolean cxY;
    private a cxZ;
    private int cya;
    private GestureDetector.OnGestureListener cyb;
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
        this.cxF = 0;
        this.cxG = true;
        this.cxI = false;
        this.cxJ = false;
        this.cxM = -1;
        this.cxN = -1;
        this.cxO = -1;
        this.mTempLoc = new int[2];
        this.cxT = false;
        this.cxU = 500.0f;
        this.cyb = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.cxI && b.this.cxJ) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.cxU) {
                        if (b.this.cya > (-width)) {
                            b.this.cxZ.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.cxU) && b.this.cya < width) {
                        b.this.cxZ.stopDragWithVelocity(true, f);
                    }
                    b.this.cxJ = false;
                }
                return false;
            }
        };
        this.cxZ = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.cxK = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.cxZ.isDragEnabled() || b.this.cxZ.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.cxR = (int) motionEvent.getX();
                b.this.cxS = (int) motionEvent.getY();
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
        this.cxL = new GestureDetector(listView.getContext(), this.cyb);
        this.cxL.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.cxV = i;
        this.cxW = i4;
        this.cxX = i5;
        kp(i3);
        ko(i2);
    }

    public GestureDetector art() {
        return this.cxK;
    }

    public void ko(int i) {
        this.cxF = i;
    }

    public void fo(boolean z) {
        this.cxG = z;
    }

    public void kp(int i) {
        this.cxH = i;
    }

    public void fp(boolean z) {
        this.cxI = z;
    }

    public boolean s(int i, int i2, int i3) {
        int i4 = 0;
        if (this.cxG && !this.cxJ) {
            i4 = 12;
        }
        if (this.cxI && this.cxJ) {
            i4 = i4 | 1 | 2;
        }
        this.cxT = this.cxZ.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.cxT;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cxZ.isDragEnabled() && !this.cxZ.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.cxI && this.cxT && this.cxH == 1) {
                this.cxL.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cxR = (int) motionEvent.getX();
                    this.cxS = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.cxI && this.cxJ) {
                        if ((this.cya >= 0 ? this.cya : -this.cya) > this.mListView.getWidth() / 2) {
                            this.cxZ.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.cxJ = false;
                    this.cxT = false;
                    break;
                case 3:
                    this.cxJ = false;
                    this.cxT = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.cxI && this.cxJ) {
            this.cya = point.x;
        }
    }

    public int z(MotionEvent motionEvent) {
        return B(motionEvent);
    }

    public int A(MotionEvent motionEvent) {
        if (this.cxH == 1) {
            return C(motionEvent);
        }
        return -1;
    }

    public int B(MotionEvent motionEvent) {
        return c(motionEvent, this.cxV);
    }

    public int C(MotionEvent motionEvent) {
        return c(motionEvent, this.cxX);
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
                        this.cxP = childAt.getLeft();
                        this.cxQ = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.cxI && this.cxH == 0) {
            this.cxO = c(motionEvent, this.cxW);
        }
        this.cxM = z(motionEvent);
        if (this.cxM != -1 && this.cxF == 0) {
            s(this.cxM, ((int) motionEvent.getX()) - this.cxP, ((int) motionEvent.getY()) - this.cxQ);
        }
        this.cxJ = false;
        this.cxY = true;
        this.cya = 0;
        this.cxN = A(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.cxP;
            int i2 = y2 - this.cxQ;
            if (this.cxY && !this.cxT && (this.cxM != -1 || this.cxN != -1)) {
                if (this.cxM != -1) {
                    if (this.cxF == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.cxG) {
                        s(this.cxM, i, i2);
                    } else if (this.cxF != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.cxI) {
                        this.cxJ = true;
                        s(this.cxN, i, i2);
                    }
                } else if (this.cxN != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.cxI) {
                        this.cxJ = true;
                        s(this.cxN, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.cxY = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.cxM != -1 && this.cxF == 2) {
            this.mListView.performHapticFeedback(0);
            s(this.cxM, this.cxR - this.cxP, this.cxS - this.cxQ);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.cxI && this.cxH == 0 && this.cxO != -1) {
            this.cxZ.removeItem(this.cxO - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
