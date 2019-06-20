package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int cFP;
    private boolean cFQ;
    private int cFR;
    private boolean cFS;
    private boolean cFT;
    private GestureDetector cFU;
    private GestureDetector cFV;
    private int cFW;
    private int cFX;
    private int cFY;
    private int cFZ;
    private int cGa;
    private int cGb;
    private int cGc;
    private boolean cGd;
    private float cGe;
    private int cGf;
    private int cGg;
    private int cGh;
    private boolean cGi;
    private a cGj;
    private int cGk;
    private GestureDetector.OnGestureListener cGl;
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
        this.cFP = 0;
        this.cFQ = true;
        this.cFS = false;
        this.cFT = false;
        this.cFW = -1;
        this.cFX = -1;
        this.cFY = -1;
        this.mTempLoc = new int[2];
        this.cGd = false;
        this.cGe = 500.0f;
        this.cGl = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.cFS && b.this.cFT) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.cGe) {
                        if (b.this.cGk > (-width)) {
                            b.this.cGj.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.cGe) && b.this.cGk < width) {
                        b.this.cGj.stopDragWithVelocity(true, f);
                    }
                    b.this.cFT = false;
                }
                return false;
            }
        };
        this.cGj = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.cFU = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.cGj.isDragEnabled() || b.this.cGj.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.cGb = (int) motionEvent.getX();
                b.this.cGc = (int) motionEvent.getY();
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
        this.cFV = new GestureDetector(listView.getContext(), this.cGl);
        this.cFV.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.cGf = i;
        this.cGg = i4;
        this.cGh = i5;
        ld(i3);
        lc(i2);
    }

    public GestureDetector aww() {
        return this.cFU;
    }

    public void lc(int i) {
        this.cFP = i;
    }

    public void fL(boolean z) {
        this.cFQ = z;
    }

    public void ld(int i) {
        this.cFR = i;
    }

    public void fM(boolean z) {
        this.cFS = z;
    }

    public boolean t(int i, int i2, int i3) {
        int i4 = 0;
        if (this.cFQ && !this.cFT) {
            i4 = 12;
        }
        if (this.cFS && this.cFT) {
            i4 = i4 | 1 | 2;
        }
        this.cGd = this.cGj.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.cGd;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cGj.isDragEnabled() && !this.cGj.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.cFS && this.cGd && this.cFR == 1) {
                this.cFV.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cGb = (int) motionEvent.getX();
                    this.cGc = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.cFS && this.cFT) {
                        if ((this.cGk >= 0 ? this.cGk : -this.cGk) > this.mListView.getWidth() / 2) {
                            this.cGj.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.cFT = false;
                    this.cGd = false;
                    break;
                case 3:
                    this.cFT = false;
                    this.cGd = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.cFS && this.cFT) {
            this.cGk = point.x;
        }
    }

    public int z(MotionEvent motionEvent) {
        return B(motionEvent);
    }

    public int A(MotionEvent motionEvent) {
        if (this.cFR == 1) {
            return C(motionEvent);
        }
        return -1;
    }

    public int B(MotionEvent motionEvent) {
        return c(motionEvent, this.cGf);
    }

    public int C(MotionEvent motionEvent) {
        return c(motionEvent, this.cGh);
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
                        this.cFZ = childAt.getLeft();
                        this.cGa = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.cFS && this.cFR == 0) {
            this.cFY = c(motionEvent, this.cGg);
        }
        this.cFW = z(motionEvent);
        if (this.cFW != -1 && this.cFP == 0) {
            t(this.cFW, ((int) motionEvent.getX()) - this.cFZ, ((int) motionEvent.getY()) - this.cGa);
        }
        this.cFT = false;
        this.cGi = true;
        this.cGk = 0;
        this.cFX = A(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.cFZ;
            int i2 = y2 - this.cGa;
            if (this.cGi && !this.cGd && (this.cFW != -1 || this.cFX != -1)) {
                if (this.cFW != -1) {
                    if (this.cFP == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.cFQ) {
                        t(this.cFW, i, i2);
                    } else if (this.cFP != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.cFS) {
                        this.cFT = true;
                        t(this.cFX, i, i2);
                    }
                } else if (this.cFX != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.cFS) {
                        this.cFT = true;
                        t(this.cFX, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.cGi = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.cFW != -1 && this.cFP == 2) {
            this.mListView.performHapticFeedback(0);
            t(this.cFW, this.cGb - this.cFZ, this.cGc - this.cGa);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.cFS && this.cFR == 0 && this.cFY != -1) {
            this.cGj.removeItem(this.cFY - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
