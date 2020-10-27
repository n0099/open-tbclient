package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int frG;
    private a fxA;
    private int fxB;
    private GestureDetector.OnGestureListener fxC;
    private int fxi;
    private boolean fxj;
    private int fxk;
    private boolean fxl;
    private boolean fxm;
    private GestureDetector fxn;
    private GestureDetector fxo;
    private int fxp;
    private int fxq;
    private int fxr;
    private int fxs;
    private int fxt;
    private int fxu;
    private float fxv;
    private int fxw;
    private int fxx;
    private int fxy;
    private boolean fxz;
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
        this.fxi = 0;
        this.fxj = true;
        this.fxl = false;
        this.fxm = false;
        this.fxp = -1;
        this.fxq = -1;
        this.fxr = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.fxv = 500.0f;
        this.fxC = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.fxl && b.this.fxm) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.fxv) {
                        if (b.this.fxB > (-width)) {
                            b.this.fxA.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.fxv) && b.this.fxB < width) {
                        b.this.fxA.stopDragWithVelocity(true, f);
                    }
                    b.this.fxm = false;
                }
                return false;
            }
        };
        this.fxA = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.fxn = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.fxA.isDragEnabled() || b.this.fxA.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.fxu = (int) motionEvent.getX();
                b.this.frG = (int) motionEvent.getY();
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
        this.fxo = new GestureDetector(listView.getContext(), this.fxC);
        this.fxo.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.fxw = i;
        this.fxx = i4;
        this.fxy = i5;
        rV(i3);
        rU(i2);
    }

    public GestureDetector bCw() {
        return this.fxn;
    }

    public void rU(int i) {
        this.fxi = i;
    }

    public void kF(boolean z) {
        this.fxj = z;
    }

    public void rV(int i) {
        this.fxk = i;
    }

    public void kG(boolean z) {
        this.fxl = z;
    }

    public boolean A(int i, int i2, int i3) {
        int i4 = 0;
        if (this.fxj && !this.fxm) {
            i4 = 12;
        }
        if (this.fxl && this.fxm) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.fxA.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fxA.isDragEnabled() && !this.fxA.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.fxl && this.mDragging && this.fxk == 1) {
                this.fxo.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.fxu = (int) motionEvent.getX();
                    this.frG = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.fxl && this.fxm) {
                        if ((this.fxB >= 0 ? this.fxB : -this.fxB) > this.mListView.getWidth() / 2) {
                            this.fxA.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.fxm = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.fxm = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.fxl && this.fxm) {
            this.fxB = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.fxk == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return c(motionEvent, this.fxw);
    }

    public int K(MotionEvent motionEvent) {
        return c(motionEvent, this.fxy);
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
                        this.fxs = childAt.getLeft();
                        this.fxt = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.fxl && this.fxk == 0) {
            this.fxr = c(motionEvent, this.fxx);
        }
        this.fxp = H(motionEvent);
        if (this.fxp != -1 && this.fxi == 0) {
            A(this.fxp, ((int) motionEvent.getX()) - this.fxs, ((int) motionEvent.getY()) - this.fxt);
        }
        this.fxm = false;
        this.fxz = true;
        this.fxB = 0;
        this.fxq = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.fxs;
            int i2 = y2 - this.fxt;
            if (this.fxz && !this.mDragging && (this.fxp != -1 || this.fxq != -1)) {
                if (this.fxp != -1) {
                    if (this.fxi == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.fxj) {
                        A(this.fxp, i, i2);
                    } else if (this.fxi != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.fxl) {
                        this.fxm = true;
                        A(this.fxq, i, i2);
                    }
                } else if (this.fxq != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.fxl) {
                        this.fxm = true;
                        A(this.fxq, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.fxz = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.fxp != -1 && this.fxi == 2) {
            this.mListView.performHapticFeedback(0);
            A(this.fxp, this.fxu - this.fxs, this.frG - this.fxt);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.fxl && this.fxk == 0 && this.fxr != -1) {
            this.fxA.removeItem(this.fxr - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
