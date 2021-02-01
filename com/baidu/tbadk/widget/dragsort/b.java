package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int fLL;
    private boolean fRA;
    private int fRB;
    private boolean fRC;
    private boolean fRD;
    private GestureDetector fRE;
    private GestureDetector fRF;
    private int fRG;
    private int fRH;
    private int fRI;
    private int fRJ;
    private int fRK;
    private int fRL;
    private float fRM;
    private int fRN;
    private int fRO;
    private int fRP;
    private boolean fRQ;
    private a fRR;
    private int fRS;
    private GestureDetector.OnGestureListener fRT;
    private int fRz;
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
        this.fRz = 0;
        this.fRA = true;
        this.fRC = false;
        this.fRD = false;
        this.fRG = -1;
        this.fRH = -1;
        this.fRI = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.fRM = 500.0f;
        this.fRT = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.fRC && b.this.fRD) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.fRM) {
                        if (b.this.fRS > (-width)) {
                            b.this.fRR.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.fRM) && b.this.fRS < width) {
                        b.this.fRR.stopDragWithVelocity(true, f);
                    }
                    b.this.fRD = false;
                }
                return false;
            }
        };
        this.fRR = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.fRE = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.fRR.isDragEnabled() || b.this.fRR.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.fRL = (int) motionEvent.getX();
                b.this.fLL = (int) motionEvent.getY();
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
        this.fRF = new GestureDetector(listView.getContext(), this.fRT);
        this.fRF.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.fRN = i;
        this.fRO = i4;
        this.fRP = i5;
        rQ(i3);
        rP(i2);
    }

    public GestureDetector bGM() {
        return this.fRE;
    }

    public void rP(int i) {
        this.fRz = i;
    }

    public void lE(boolean z) {
        this.fRA = z;
    }

    public void rQ(int i) {
        this.fRB = i;
    }

    public void lF(boolean z) {
        this.fRC = z;
    }

    public boolean D(int i, int i2, int i3) {
        int i4 = 0;
        if (this.fRA && !this.fRD) {
            i4 = 12;
        }
        if (this.fRC && this.fRD) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.fRR.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fRR.isDragEnabled() && !this.fRR.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.fRC && this.mDragging && this.fRB == 1) {
                this.fRF.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.fRL = (int) motionEvent.getX();
                    this.fLL = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.fRC && this.fRD) {
                        if ((this.fRS >= 0 ? this.fRS : -this.fRS) > this.mListView.getWidth() / 2) {
                            this.fRR.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.fRD = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.fRD = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.fRC && this.fRD) {
            this.fRS = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.fRB == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return d(motionEvent, this.fRN);
    }

    public int K(MotionEvent motionEvent) {
        return d(motionEvent, this.fRP);
    }

    public int d(MotionEvent motionEvent, int i) {
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
                        this.fRJ = childAt.getLeft();
                        this.fRK = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.fRC && this.fRB == 0) {
            this.fRI = d(motionEvent, this.fRO);
        }
        this.fRG = H(motionEvent);
        if (this.fRG != -1 && this.fRz == 0) {
            D(this.fRG, ((int) motionEvent.getX()) - this.fRJ, ((int) motionEvent.getY()) - this.fRK);
        }
        this.fRD = false;
        this.fRQ = true;
        this.fRS = 0;
        this.fRH = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.fRJ;
            int i2 = y2 - this.fRK;
            if (this.fRQ && !this.mDragging && (this.fRG != -1 || this.fRH != -1)) {
                if (this.fRG != -1) {
                    if (this.fRz == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.fRA) {
                        D(this.fRG, i, i2);
                    } else if (this.fRz != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.fRC) {
                        this.fRD = true;
                        D(this.fRH, i, i2);
                    }
                } else if (this.fRH != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.fRC) {
                        this.fRD = true;
                        D(this.fRH, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.fRQ = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.fRG != -1 && this.fRz == 2) {
            this.mListView.performHapticFeedback(0);
            D(this.fRG, this.fRL - this.fRJ, this.fLL - this.fRK);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.fRC && this.fRB == 0 && this.fRI != -1) {
            this.fRR.removeItem(this.fRI - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
