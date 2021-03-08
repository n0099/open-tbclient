package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int fNl;
    private int fSZ;
    private boolean fTa;
    private int fTb;
    private boolean fTc;
    private boolean fTd;
    private GestureDetector fTe;
    private GestureDetector fTf;
    private int fTg;
    private int fTh;
    private int fTi;
    private int fTj;
    private int fTk;
    private int fTl;
    private float fTm;
    private int fTn;
    private int fTo;
    private int fTp;
    private boolean fTq;
    private a fTr;
    private int fTs;
    private GestureDetector.OnGestureListener fTt;
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
        this.fSZ = 0;
        this.fTa = true;
        this.fTc = false;
        this.fTd = false;
        this.fTg = -1;
        this.fTh = -1;
        this.fTi = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.fTm = 500.0f;
        this.fTt = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.fTc && b.this.fTd) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.fTm) {
                        if (b.this.fTs > (-width)) {
                            b.this.fTr.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.fTm) && b.this.fTs < width) {
                        b.this.fTr.stopDragWithVelocity(true, f);
                    }
                    b.this.fTd = false;
                }
                return false;
            }
        };
        this.fTr = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.fTe = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.fTr.isDragEnabled() || b.this.fTr.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.fTl = (int) motionEvent.getX();
                b.this.fNl = (int) motionEvent.getY();
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
        this.fTf = new GestureDetector(listView.getContext(), this.fTt);
        this.fTf.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.fTn = i;
        this.fTo = i4;
        this.fTp = i5;
        rS(i3);
        rR(i2);
    }

    public GestureDetector bGQ() {
        return this.fTe;
    }

    public void rR(int i) {
        this.fSZ = i;
    }

    public void lE(boolean z) {
        this.fTa = z;
    }

    public void rS(int i) {
        this.fTb = i;
    }

    public void lF(boolean z) {
        this.fTc = z;
    }

    public boolean D(int i, int i2, int i3) {
        int i4 = 0;
        if (this.fTa && !this.fTd) {
            i4 = 12;
        }
        if (this.fTc && this.fTd) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.fTr.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fTr.isDragEnabled() && !this.fTr.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.fTc && this.mDragging && this.fTb == 1) {
                this.fTf.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.fTl = (int) motionEvent.getX();
                    this.fNl = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.fTc && this.fTd) {
                        if ((this.fTs >= 0 ? this.fTs : -this.fTs) > this.mListView.getWidth() / 2) {
                            this.fTr.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.fTd = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.fTd = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.fTc && this.fTd) {
            this.fTs = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.fTb == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return d(motionEvent, this.fTn);
    }

    public int K(MotionEvent motionEvent) {
        return d(motionEvent, this.fTp);
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
                        this.fTj = childAt.getLeft();
                        this.fTk = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.fTc && this.fTb == 0) {
            this.fTi = d(motionEvent, this.fTo);
        }
        this.fTg = H(motionEvent);
        if (this.fTg != -1 && this.fSZ == 0) {
            D(this.fTg, ((int) motionEvent.getX()) - this.fTj, ((int) motionEvent.getY()) - this.fTk);
        }
        this.fTd = false;
        this.fTq = true;
        this.fTs = 0;
        this.fTh = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.fTj;
            int i2 = y2 - this.fTk;
            if (this.fTq && !this.mDragging && (this.fTg != -1 || this.fTh != -1)) {
                if (this.fTg != -1) {
                    if (this.fSZ == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.fTa) {
                        D(this.fTg, i, i2);
                    } else if (this.fSZ != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.fTc) {
                        this.fTd = true;
                        D(this.fTh, i, i2);
                    }
                } else if (this.fTh != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.fTc) {
                        this.fTd = true;
                        D(this.fTh, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.fTq = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.fTg != -1 && this.fSZ == 2) {
            this.mListView.performHapticFeedback(0);
            D(this.fTg, this.fTl - this.fTj, this.fNl - this.fTk);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.fTc && this.fTb == 0 && this.fTi != -1) {
            this.fTr.removeItem(this.fTi - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
