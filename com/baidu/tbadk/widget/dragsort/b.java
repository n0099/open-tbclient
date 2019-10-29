package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int cSA;
    private boolean cSB;
    private float cSC;
    private int cSD;
    private int cSE;
    private int cSF;
    private boolean cSG;
    private a cSH;
    private int cSI;
    private GestureDetector.OnGestureListener cSJ;
    private int cSn;
    private boolean cSo;
    private int cSp;
    private boolean cSq;
    private boolean cSr;
    private GestureDetector cSs;
    private GestureDetector cSt;
    private int cSu;
    private int cSv;
    private int cSw;
    private int cSx;
    private int cSy;
    private int cSz;
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
        this.cSn = 0;
        this.cSo = true;
        this.cSq = false;
        this.cSr = false;
        this.cSu = -1;
        this.cSv = -1;
        this.cSw = -1;
        this.mTempLoc = new int[2];
        this.cSB = false;
        this.cSC = 500.0f;
        this.cSJ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.cSq && b.this.cSr) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.cSC) {
                        if (b.this.cSI > (-width)) {
                            b.this.cSH.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.cSC) && b.this.cSI < width) {
                        b.this.cSH.stopDragWithVelocity(true, f);
                    }
                    b.this.cSr = false;
                }
                return false;
            }
        };
        this.cSH = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.cSs = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.cSH.isDragEnabled() || b.this.cSH.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.cSz = (int) motionEvent.getX();
                b.this.cSA = (int) motionEvent.getY();
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
        this.cSt = new GestureDetector(listView.getContext(), this.cSJ);
        this.cSt.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.cSD = i;
        this.cSE = i4;
        this.cSF = i5;
        kw(i3);
        kv(i2);
    }

    public GestureDetector ayG() {
        return this.cSs;
    }

    public void kv(int i) {
        this.cSn = i;
    }

    public void fH(boolean z) {
        this.cSo = z;
    }

    public void kw(int i) {
        this.cSp = i;
    }

    public void fI(boolean z) {
        this.cSq = z;
    }

    public boolean y(int i, int i2, int i3) {
        int i4 = 0;
        if (this.cSo && !this.cSr) {
            i4 = 12;
        }
        if (this.cSq && this.cSr) {
            i4 = i4 | 1 | 2;
        }
        this.cSB = this.cSH.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.cSB;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cSH.isDragEnabled() && !this.cSH.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.cSq && this.cSB && this.cSp == 1) {
                this.cSt.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cSz = (int) motionEvent.getX();
                    this.cSA = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.cSq && this.cSr) {
                        if ((this.cSI >= 0 ? this.cSI : -this.cSI) > this.mListView.getWidth() / 2) {
                            this.cSH.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.cSr = false;
                    this.cSB = false;
                    break;
                case 3:
                    this.cSr = false;
                    this.cSB = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.cSq && this.cSr) {
            this.cSI = point.x;
        }
    }

    public int t(MotionEvent motionEvent) {
        return v(motionEvent);
    }

    public int u(MotionEvent motionEvent) {
        if (this.cSp == 1) {
            return w(motionEvent);
        }
        return -1;
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.cSD);
    }

    public int w(MotionEvent motionEvent) {
        return c(motionEvent, this.cSF);
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
                        this.cSx = childAt.getLeft();
                        this.cSy = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.cSq && this.cSp == 0) {
            this.cSw = c(motionEvent, this.cSE);
        }
        this.cSu = t(motionEvent);
        if (this.cSu != -1 && this.cSn == 0) {
            y(this.cSu, ((int) motionEvent.getX()) - this.cSx, ((int) motionEvent.getY()) - this.cSy);
        }
        this.cSr = false;
        this.cSG = true;
        this.cSI = 0;
        this.cSv = u(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.cSx;
            int i2 = y2 - this.cSy;
            if (this.cSG && !this.cSB && (this.cSu != -1 || this.cSv != -1)) {
                if (this.cSu != -1) {
                    if (this.cSn == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.cSo) {
                        y(this.cSu, i, i2);
                    } else if (this.cSn != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.cSq) {
                        this.cSr = true;
                        y(this.cSv, i, i2);
                    }
                } else if (this.cSv != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.cSq) {
                        this.cSr = true;
                        y(this.cSv, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.cSG = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.cSu != -1 && this.cSn == 2) {
            this.mListView.performHapticFeedback(0);
            y(this.cSu, this.cSz - this.cSx, this.cSA - this.cSy);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.cSq && this.cSp == 0 && this.cSw != -1) {
            this.cSH.removeItem(this.cSw - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
