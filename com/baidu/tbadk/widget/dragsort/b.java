package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int cxE;
    private boolean cxF;
    private int cxG;
    private boolean cxH;
    private boolean cxI;
    private GestureDetector cxJ;
    private GestureDetector cxK;
    private int cxL;
    private int cxM;
    private int cxN;
    private int cxO;
    private int cxP;
    private int cxQ;
    private int cxR;
    private boolean cxS;
    private float cxT;
    private int cxU;
    private int cxV;
    private int cxW;
    private boolean cxX;
    private a cxY;
    private int cxZ;
    private GestureDetector.OnGestureListener cya;
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
        this.cxE = 0;
        this.cxF = true;
        this.cxH = false;
        this.cxI = false;
        this.cxL = -1;
        this.cxM = -1;
        this.cxN = -1;
        this.mTempLoc = new int[2];
        this.cxS = false;
        this.cxT = 500.0f;
        this.cya = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.cxH && b.this.cxI) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.cxT) {
                        if (b.this.cxZ > (-width)) {
                            b.this.cxY.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.cxT) && b.this.cxZ < width) {
                        b.this.cxY.stopDragWithVelocity(true, f);
                    }
                    b.this.cxI = false;
                }
                return false;
            }
        };
        this.cxY = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.cxJ = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.cxY.isDragEnabled() || b.this.cxY.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.cxQ = (int) motionEvent.getX();
                b.this.cxR = (int) motionEvent.getY();
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
        this.cxK = new GestureDetector(listView.getContext(), this.cya);
        this.cxK.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.cxU = i;
        this.cxV = i4;
        this.cxW = i5;
        ko(i3);
        kn(i2);
    }

    public GestureDetector arp() {
        return this.cxJ;
    }

    public void kn(int i) {
        this.cxE = i;
    }

    public void fo(boolean z) {
        this.cxF = z;
    }

    public void ko(int i) {
        this.cxG = i;
    }

    public void fp(boolean z) {
        this.cxH = z;
    }

    public boolean s(int i, int i2, int i3) {
        int i4 = 0;
        if (this.cxF && !this.cxI) {
            i4 = 12;
        }
        if (this.cxH && this.cxI) {
            i4 = i4 | 1 | 2;
        }
        this.cxS = this.cxY.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.cxS;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cxY.isDragEnabled() && !this.cxY.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.cxH && this.cxS && this.cxG == 1) {
                this.cxK.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cxQ = (int) motionEvent.getX();
                    this.cxR = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.cxH && this.cxI) {
                        if ((this.cxZ >= 0 ? this.cxZ : -this.cxZ) > this.mListView.getWidth() / 2) {
                            this.cxY.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.cxI = false;
                    this.cxS = false;
                    break;
                case 3:
                    this.cxI = false;
                    this.cxS = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.cxH && this.cxI) {
            this.cxZ = point.x;
        }
    }

    public int z(MotionEvent motionEvent) {
        return B(motionEvent);
    }

    public int A(MotionEvent motionEvent) {
        if (this.cxG == 1) {
            return C(motionEvent);
        }
        return -1;
    }

    public int B(MotionEvent motionEvent) {
        return c(motionEvent, this.cxU);
    }

    public int C(MotionEvent motionEvent) {
        return c(motionEvent, this.cxW);
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
                        this.cxO = childAt.getLeft();
                        this.cxP = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.cxH && this.cxG == 0) {
            this.cxN = c(motionEvent, this.cxV);
        }
        this.cxL = z(motionEvent);
        if (this.cxL != -1 && this.cxE == 0) {
            s(this.cxL, ((int) motionEvent.getX()) - this.cxO, ((int) motionEvent.getY()) - this.cxP);
        }
        this.cxI = false;
        this.cxX = true;
        this.cxZ = 0;
        this.cxM = A(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.cxO;
            int i2 = y2 - this.cxP;
            if (this.cxX && !this.cxS && (this.cxL != -1 || this.cxM != -1)) {
                if (this.cxL != -1) {
                    if (this.cxE == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.cxF) {
                        s(this.cxL, i, i2);
                    } else if (this.cxE != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.cxH) {
                        this.cxI = true;
                        s(this.cxM, i, i2);
                    }
                } else if (this.cxM != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.cxH) {
                        this.cxI = true;
                        s(this.cxM, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.cxX = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.cxL != -1 && this.cxE == 2) {
            this.mListView.performHapticFeedback(0);
            s(this.cxL, this.cxQ - this.cxO, this.cxR - this.cxP);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.cxH && this.cxG == 0 && this.cxN != -1) {
            this.cxY.removeItem(this.cxN - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
