package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int dKG;
    private boolean dKH;
    private int dKI;
    private boolean dKJ;
    private boolean dKK;
    private GestureDetector dKL;
    private GestureDetector dKM;
    private int dKN;
    private int dKO;
    private int dKP;
    private int dKQ;
    private int dKR;
    private int dKS;
    private int dKT;
    private float dKU;
    private int dKV;
    private int dKW;
    private int dKX;
    private boolean dKY;
    private a dKZ;
    private int dLa;
    private GestureDetector.OnGestureListener dLb;
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
        this.dKG = 0;
        this.dKH = true;
        this.dKJ = false;
        this.dKK = false;
        this.dKN = -1;
        this.dKO = -1;
        this.dKP = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.dKU = 500.0f;
        this.dLb = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.dKJ && b.this.dKK) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.dKU) {
                        if (b.this.dLa > (-width)) {
                            b.this.dKZ.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.dKU) && b.this.dLa < width) {
                        b.this.dKZ.stopDragWithVelocity(true, f);
                    }
                    b.this.dKK = false;
                }
                return false;
            }
        };
        this.dKZ = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.dKL = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.dKZ.isDragEnabled() || b.this.dKZ.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.dKS = (int) motionEvent.getX();
                b.this.dKT = (int) motionEvent.getY();
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
        this.dKM = new GestureDetector(listView.getContext(), this.dLb);
        this.dKM.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.dKV = i;
        this.dKW = i4;
        this.dKX = i5;
        nd(i3);
        nc(i2);
    }

    public GestureDetector aTu() {
        return this.dKL;
    }

    public void nc(int i) {
        this.dKG = i;
    }

    public void hi(boolean z) {
        this.dKH = z;
    }

    public void nd(int i) {
        this.dKI = i;
    }

    public void hj(boolean z) {
        this.dKJ = z;
    }

    public boolean z(int i, int i2, int i3) {
        int i4 = 0;
        if (this.dKH && !this.dKK) {
            i4 = 12;
        }
        if (this.dKJ && this.dKK) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.dKZ.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dKZ.isDragEnabled() && !this.dKZ.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.dKJ && this.mDragging && this.dKI == 1) {
                this.dKM.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dKS = (int) motionEvent.getX();
                    this.dKT = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.dKJ && this.dKK) {
                        if ((this.dLa >= 0 ? this.dLa : -this.dLa) > this.mListView.getWidth() / 2) {
                            this.dKZ.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.dKK = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.dKK = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.dKJ && this.dKK) {
            this.dLa = point.x;
        }
    }

    public int t(MotionEvent motionEvent) {
        return v(motionEvent);
    }

    public int u(MotionEvent motionEvent) {
        if (this.dKI == 1) {
            return w(motionEvent);
        }
        return -1;
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.dKV);
    }

    public int w(MotionEvent motionEvent) {
        return c(motionEvent, this.dKX);
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
                        this.dKQ = childAt.getLeft();
                        this.dKR = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.dKJ && this.dKI == 0) {
            this.dKP = c(motionEvent, this.dKW);
        }
        this.dKN = t(motionEvent);
        if (this.dKN != -1 && this.dKG == 0) {
            z(this.dKN, ((int) motionEvent.getX()) - this.dKQ, ((int) motionEvent.getY()) - this.dKR);
        }
        this.dKK = false;
        this.dKY = true;
        this.dLa = 0;
        this.dKO = u(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.dKQ;
            int i2 = y2 - this.dKR;
            if (this.dKY && !this.mDragging && (this.dKN != -1 || this.dKO != -1)) {
                if (this.dKN != -1) {
                    if (this.dKG == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.dKH) {
                        z(this.dKN, i, i2);
                    } else if (this.dKG != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.dKJ) {
                        this.dKK = true;
                        z(this.dKO, i, i2);
                    }
                } else if (this.dKO != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.dKJ) {
                        this.dKK = true;
                        z(this.dKO, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.dKY = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.dKN != -1 && this.dKG == 2) {
            this.mListView.performHapticFeedback(0);
            z(this.dKN, this.dKS - this.dKQ, this.dKT - this.dKR);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.dKJ && this.dKI == 0 && this.dKP != -1) {
            this.dKZ.removeItem(this.dKP - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
