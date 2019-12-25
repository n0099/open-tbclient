package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int dFO;
    private boolean dFP;
    private int dFQ;
    private boolean dFR;
    private boolean dFS;
    private GestureDetector dFT;
    private GestureDetector dFU;
    private int dFV;
    private int dFW;
    private int dFX;
    private int dFY;
    private int dFZ;
    private int dGa;
    private int dGb;
    private float dGc;
    private int dGd;
    private int dGe;
    private int dGf;
    private boolean dGg;
    private a dGh;
    private int dGi;
    private GestureDetector.OnGestureListener dGj;
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
        this.dFO = 0;
        this.dFP = true;
        this.dFR = false;
        this.dFS = false;
        this.dFV = -1;
        this.dFW = -1;
        this.dFX = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.dGc = 500.0f;
        this.dGj = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.dFR && b.this.dFS) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.dGc) {
                        if (b.this.dGi > (-width)) {
                            b.this.dGh.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.dGc) && b.this.dGi < width) {
                        b.this.dGh.stopDragWithVelocity(true, f);
                    }
                    b.this.dFS = false;
                }
                return false;
            }
        };
        this.dGh = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.dFT = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.dGh.isDragEnabled() || b.this.dGh.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.dGa = (int) motionEvent.getX();
                b.this.dGb = (int) motionEvent.getY();
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
        this.dFU = new GestureDetector(listView.getContext(), this.dGj);
        this.dFU.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.dGd = i;
        this.dGe = i4;
        this.dGf = i5;
        mK(i3);
        mJ(i2);
    }

    public GestureDetector aQD() {
        return this.dFT;
    }

    public void mJ(int i) {
        this.dFO = i;
    }

    public void gV(boolean z) {
        this.dFP = z;
    }

    public void mK(int i) {
        this.dFQ = i;
    }

    public void gW(boolean z) {
        this.dFR = z;
    }

    public boolean y(int i, int i2, int i3) {
        int i4 = 0;
        if (this.dFP && !this.dFS) {
            i4 = 12;
        }
        if (this.dFR && this.dFS) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.dGh.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dGh.isDragEnabled() && !this.dGh.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.dFR && this.mDragging && this.dFQ == 1) {
                this.dFU.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dGa = (int) motionEvent.getX();
                    this.dGb = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.dFR && this.dFS) {
                        if ((this.dGi >= 0 ? this.dGi : -this.dGi) > this.mListView.getWidth() / 2) {
                            this.dGh.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.dFS = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.dFS = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.dFR && this.dFS) {
            this.dGi = point.x;
        }
    }

    public int t(MotionEvent motionEvent) {
        return v(motionEvent);
    }

    public int u(MotionEvent motionEvent) {
        if (this.dFQ == 1) {
            return w(motionEvent);
        }
        return -1;
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.dGd);
    }

    public int w(MotionEvent motionEvent) {
        return c(motionEvent, this.dGf);
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
                        this.dFY = childAt.getLeft();
                        this.dFZ = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.dFR && this.dFQ == 0) {
            this.dFX = c(motionEvent, this.dGe);
        }
        this.dFV = t(motionEvent);
        if (this.dFV != -1 && this.dFO == 0) {
            y(this.dFV, ((int) motionEvent.getX()) - this.dFY, ((int) motionEvent.getY()) - this.dFZ);
        }
        this.dFS = false;
        this.dGg = true;
        this.dGi = 0;
        this.dFW = u(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.dFY;
            int i2 = y2 - this.dFZ;
            if (this.dGg && !this.mDragging && (this.dFV != -1 || this.dFW != -1)) {
                if (this.dFV != -1) {
                    if (this.dFO == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.dFP) {
                        y(this.dFV, i, i2);
                    } else if (this.dFO != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.dFR) {
                        this.dFS = true;
                        y(this.dFW, i, i2);
                    }
                } else if (this.dFW != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.dFR) {
                        this.dFS = true;
                        y(this.dFW, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.dGg = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.dFV != -1 && this.dFO == 2) {
            this.mListView.performHapticFeedback(0);
            y(this.dFV, this.dGa - this.dFY, this.dGb - this.dFZ);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.dFR && this.dFQ == 0 && this.dFX != -1) {
            this.dGh.removeItem(this.dFX - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
