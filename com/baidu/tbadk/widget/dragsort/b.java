package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int fCB;
    private boolean fCC;
    private int fCD;
    private boolean fCE;
    private boolean fCF;
    private GestureDetector fCG;
    private GestureDetector fCH;
    private int fCI;
    private int fCJ;
    private int fCK;
    private int fCL;
    private int fCM;
    private int fCN;
    private float fCO;
    private int fCP;
    private int fCQ;
    private int fCR;
    private boolean fCS;
    private a fCT;
    private int fCU;
    private GestureDetector.OnGestureListener fCV;
    private int fwN;
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
        this.fCB = 0;
        this.fCC = true;
        this.fCE = false;
        this.fCF = false;
        this.fCI = -1;
        this.fCJ = -1;
        this.fCK = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.fCO = 500.0f;
        this.fCV = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.fCE && b.this.fCF) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.fCO) {
                        if (b.this.fCU > (-width)) {
                            b.this.fCT.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.fCO) && b.this.fCU < width) {
                        b.this.fCT.stopDragWithVelocity(true, f);
                    }
                    b.this.fCF = false;
                }
                return false;
            }
        };
        this.fCT = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.fCG = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.fCT.isDragEnabled() || b.this.fCT.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.fCN = (int) motionEvent.getX();
                b.this.fwN = (int) motionEvent.getY();
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
        this.fCH = new GestureDetector(listView.getContext(), this.fCV);
        this.fCH.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.fCP = i;
        this.fCQ = i4;
        this.fCR = i5;
        sD(i3);
        sC(i2);
    }

    public GestureDetector bEo() {
        return this.fCG;
    }

    public void sC(int i) {
        this.fCB = i;
    }

    public void kP(boolean z) {
        this.fCC = z;
    }

    public void sD(int i) {
        this.fCD = i;
    }

    public void kQ(boolean z) {
        this.fCE = z;
    }

    public boolean C(int i, int i2, int i3) {
        int i4 = 0;
        if (this.fCC && !this.fCF) {
            i4 = 12;
        }
        if (this.fCE && this.fCF) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.fCT.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fCT.isDragEnabled() && !this.fCT.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.fCE && this.mDragging && this.fCD == 1) {
                this.fCH.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.fCN = (int) motionEvent.getX();
                    this.fwN = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.fCE && this.fCF) {
                        if ((this.fCU >= 0 ? this.fCU : -this.fCU) > this.mListView.getWidth() / 2) {
                            this.fCT.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.fCF = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.fCF = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.fCE && this.fCF) {
            this.fCU = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.fCD == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return c(motionEvent, this.fCP);
    }

    public int K(MotionEvent motionEvent) {
        return c(motionEvent, this.fCR);
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
                        this.fCL = childAt.getLeft();
                        this.fCM = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.fCE && this.fCD == 0) {
            this.fCK = c(motionEvent, this.fCQ);
        }
        this.fCI = H(motionEvent);
        if (this.fCI != -1 && this.fCB == 0) {
            C(this.fCI, ((int) motionEvent.getX()) - this.fCL, ((int) motionEvent.getY()) - this.fCM);
        }
        this.fCF = false;
        this.fCS = true;
        this.fCU = 0;
        this.fCJ = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.fCL;
            int i2 = y2 - this.fCM;
            if (this.fCS && !this.mDragging && (this.fCI != -1 || this.fCJ != -1)) {
                if (this.fCI != -1) {
                    if (this.fCB == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.fCC) {
                        C(this.fCI, i, i2);
                    } else if (this.fCB != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.fCE) {
                        this.fCF = true;
                        C(this.fCJ, i, i2);
                    }
                } else if (this.fCJ != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.fCE) {
                        this.fCF = true;
                        C(this.fCJ, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.fCS = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.fCI != -1 && this.fCB == 2) {
            this.mListView.performHapticFeedback(0);
            C(this.fCI, this.fCN - this.fCL, this.fwN - this.fCM);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.fCE && this.fCD == 0 && this.fCK != -1) {
            this.fCT.removeItem(this.fCK - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
