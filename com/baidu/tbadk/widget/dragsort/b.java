package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int cHA;
    private int cHB;
    private boolean cHC;
    private a cHD;
    private int cHE;
    private GestureDetector.OnGestureListener cHF;
    private int cHj;
    private boolean cHk;
    private int cHl;
    private boolean cHm;
    private boolean cHn;
    private GestureDetector cHo;
    private GestureDetector cHp;
    private int cHq;
    private int cHr;
    private int cHs;
    private int cHt;
    private int cHu;
    private int cHv;
    private int cHw;
    private boolean cHx;
    private float cHy;
    private int cHz;
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
        this.cHj = 0;
        this.cHk = true;
        this.cHm = false;
        this.cHn = false;
        this.cHq = -1;
        this.cHr = -1;
        this.cHs = -1;
        this.mTempLoc = new int[2];
        this.cHx = false;
        this.cHy = 500.0f;
        this.cHF = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.cHm && b.this.cHn) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.cHy) {
                        if (b.this.cHE > (-width)) {
                            b.this.cHD.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.cHy) && b.this.cHE < width) {
                        b.this.cHD.stopDragWithVelocity(true, f);
                    }
                    b.this.cHn = false;
                }
                return false;
            }
        };
        this.cHD = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.cHo = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.cHD.isDragEnabled() || b.this.cHD.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.cHv = (int) motionEvent.getX();
                b.this.cHw = (int) motionEvent.getY();
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
        this.cHp = new GestureDetector(listView.getContext(), this.cHF);
        this.cHp.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.cHz = i;
        this.cHA = i4;
        this.cHB = i5;
        lj(i3);
        li(i2);
    }

    public GestureDetector axI() {
        return this.cHo;
    }

    public void li(int i) {
        this.cHj = i;
    }

    public void fP(boolean z) {
        this.cHk = z;
    }

    public void lj(int i) {
        this.cHl = i;
    }

    public void fQ(boolean z) {
        this.cHm = z;
    }

    public boolean t(int i, int i2, int i3) {
        int i4 = 0;
        if (this.cHk && !this.cHn) {
            i4 = 12;
        }
        if (this.cHm && this.cHn) {
            i4 = i4 | 1 | 2;
        }
        this.cHx = this.cHD.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.cHx;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cHD.isDragEnabled() && !this.cHD.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.cHm && this.cHx && this.cHl == 1) {
                this.cHp.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cHv = (int) motionEvent.getX();
                    this.cHw = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.cHm && this.cHn) {
                        if ((this.cHE >= 0 ? this.cHE : -this.cHE) > this.mListView.getWidth() / 2) {
                            this.cHD.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.cHn = false;
                    this.cHx = false;
                    break;
                case 3:
                    this.cHn = false;
                    this.cHx = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.cHm && this.cHn) {
            this.cHE = point.x;
        }
    }

    public int z(MotionEvent motionEvent) {
        return B(motionEvent);
    }

    public int A(MotionEvent motionEvent) {
        if (this.cHl == 1) {
            return C(motionEvent);
        }
        return -1;
    }

    public int B(MotionEvent motionEvent) {
        return c(motionEvent, this.cHz);
    }

    public int C(MotionEvent motionEvent) {
        return c(motionEvent, this.cHB);
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
                        this.cHt = childAt.getLeft();
                        this.cHu = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.cHm && this.cHl == 0) {
            this.cHs = c(motionEvent, this.cHA);
        }
        this.cHq = z(motionEvent);
        if (this.cHq != -1 && this.cHj == 0) {
            t(this.cHq, ((int) motionEvent.getX()) - this.cHt, ((int) motionEvent.getY()) - this.cHu);
        }
        this.cHn = false;
        this.cHC = true;
        this.cHE = 0;
        this.cHr = A(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.cHt;
            int i2 = y2 - this.cHu;
            if (this.cHC && !this.cHx && (this.cHq != -1 || this.cHr != -1)) {
                if (this.cHq != -1) {
                    if (this.cHj == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.cHk) {
                        t(this.cHq, i, i2);
                    } else if (this.cHj != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.cHm) {
                        this.cHn = true;
                        t(this.cHr, i, i2);
                    }
                } else if (this.cHr != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.cHm) {
                        this.cHn = true;
                        t(this.cHr, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.cHC = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.cHq != -1 && this.cHj == 2) {
            this.mListView.performHapticFeedback(0);
            t(this.cHq, this.cHv - this.cHt, this.cHw - this.cHu);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.cHm && this.cHl == 0 && this.cHs != -1) {
            this.cHD.removeItem(this.cHs - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
