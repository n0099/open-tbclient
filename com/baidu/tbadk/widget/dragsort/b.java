package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int bdJ;
    private boolean bdK;
    private int bdL;
    private boolean bdM;
    private boolean bdN;
    private GestureDetector bdO;
    private GestureDetector bdP;
    private int bdQ;
    private int bdR;
    private int bdS;
    private int bdT;
    private int bdU;
    private int bdV;
    private int bdW;
    private boolean bdX;
    private float bdY;
    private int bdZ;
    private int bea;
    private int beb;
    private boolean bec;
    private a bed;
    private int bee;
    private GestureDetector.OnGestureListener bef;
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
        this.bdJ = 0;
        this.bdK = true;
        this.bdM = false;
        this.bdN = false;
        this.bdQ = -1;
        this.bdR = -1;
        this.bdS = -1;
        this.mTempLoc = new int[2];
        this.bdX = false;
        this.bdY = 500.0f;
        this.bef = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bdM && b.this.bdN) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bdY) {
                        if (b.this.bee > (-width)) {
                            b.this.bed.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bdY) && b.this.bee < width) {
                        b.this.bed.stopDragWithVelocity(true, f);
                    }
                    b.this.bdN = false;
                }
                return false;
            }
        };
        this.bed = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bdO = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bed.isDragEnabled() || b.this.bed.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bdV = (int) motionEvent.getX();
                b.this.bdW = (int) motionEvent.getY();
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
        this.bdP = new GestureDetector(listView.getContext(), this.bef);
        this.bdP.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bdZ = i;
        this.bea = i4;
        this.beb = i5;
        fP(i3);
        fO(i2);
    }

    public GestureDetector NO() {
        return this.bdO;
    }

    public void fO(int i) {
        this.bdJ = i;
    }

    public void cu(boolean z) {
        this.bdK = z;
    }

    public void fP(int i) {
        this.bdL = i;
    }

    public void cv(boolean z) {
        this.bdM = z;
    }

    public boolean p(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bdK && !this.bdN) {
            i4 = 12;
        }
        if (this.bdM && this.bdN) {
            i4 = i4 | 1 | 2;
        }
        this.bdX = this.bed.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bdX;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bed.isDragEnabled() && !this.bed.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bdM && this.bdX && this.bdL == 1) {
                this.bdP.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bdV = (int) motionEvent.getX();
                    this.bdW = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bdM && this.bdN) {
                        if ((this.bee >= 0 ? this.bee : -this.bee) > this.mListView.getWidth() / 2) {
                            this.bed.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bdN = false;
                    this.bdX = false;
                    break;
                case 3:
                    this.bdN = false;
                    this.bdX = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bdM && this.bdN) {
            this.bee = point.x;
        }
    }

    public int v(MotionEvent motionEvent) {
        return x(motionEvent);
    }

    public int w(MotionEvent motionEvent) {
        if (this.bdL == 1) {
            return y(motionEvent);
        }
        return -1;
    }

    public int x(MotionEvent motionEvent) {
        return b(motionEvent, this.bdZ);
    }

    public int y(MotionEvent motionEvent) {
        return b(motionEvent, this.beb);
    }

    public int b(MotionEvent motionEvent, int i) {
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
                        this.bdT = childAt.getLeft();
                        this.bdU = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bdM && this.bdL == 0) {
            this.bdS = b(motionEvent, this.bea);
        }
        this.bdQ = v(motionEvent);
        if (this.bdQ != -1 && this.bdJ == 0) {
            p(this.bdQ, ((int) motionEvent.getX()) - this.bdT, ((int) motionEvent.getY()) - this.bdU);
        }
        this.bdN = false;
        this.bec = true;
        this.bee = 0;
        this.bdR = w(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bdT;
            int i2 = y2 - this.bdU;
            if (this.bec && !this.bdX && (this.bdQ != -1 || this.bdR != -1)) {
                if (this.bdQ != -1) {
                    if (this.bdJ == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bdK) {
                        p(this.bdQ, i, i2);
                    } else if (this.bdJ != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bdM) {
                        this.bdN = true;
                        p(this.bdR, i, i2);
                    }
                } else if (this.bdR != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bdM) {
                        this.bdN = true;
                        p(this.bdR, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bec = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bdQ != -1 && this.bdJ == 2) {
            this.mListView.performHapticFeedback(0);
            p(this.bdQ, this.bdV - this.bdT, this.bdW - this.bdU);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bdM && this.bdL == 0 && this.bdS != -1) {
            this.bed.removeItem(this.bdS - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
