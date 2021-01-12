package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int fJA;
    private int fPA;
    private int fPB;
    private int fPC;
    private boolean fPD;
    private a fPE;
    private int fPF;
    private GestureDetector.OnGestureListener fPG;
    private int fPm;
    private boolean fPn;
    private int fPo;
    private boolean fPp;
    private boolean fPq;
    private GestureDetector fPr;
    private GestureDetector fPs;
    private int fPt;
    private int fPu;
    private int fPv;
    private int fPw;
    private int fPx;
    private int fPy;
    private float fPz;
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
        this.fPm = 0;
        this.fPn = true;
        this.fPp = false;
        this.fPq = false;
        this.fPt = -1;
        this.fPu = -1;
        this.fPv = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.fPz = 500.0f;
        this.fPG = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.fPp && b.this.fPq) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.fPz) {
                        if (b.this.fPF > (-width)) {
                            b.this.fPE.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.fPz) && b.this.fPF < width) {
                        b.this.fPE.stopDragWithVelocity(true, f);
                    }
                    b.this.fPq = false;
                }
                return false;
            }
        };
        this.fPE = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.fPr = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.fPE.isDragEnabled() || b.this.fPE.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.fPy = (int) motionEvent.getX();
                b.this.fJA = (int) motionEvent.getY();
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
        this.fPs = new GestureDetector(listView.getContext(), this.fPG);
        this.fPs.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.fPA = i;
        this.fPB = i4;
        this.fPC = i5;
        rL(i3);
        rK(i2);
    }

    public GestureDetector bGs() {
        return this.fPr;
    }

    public void rK(int i) {
        this.fPm = i;
    }

    public void lB(boolean z) {
        this.fPn = z;
    }

    public void rL(int i) {
        this.fPo = i;
    }

    public void lC(boolean z) {
        this.fPp = z;
    }

    public boolean D(int i, int i2, int i3) {
        int i4 = 0;
        if (this.fPn && !this.fPq) {
            i4 = 12;
        }
        if (this.fPp && this.fPq) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.fPE.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fPE.isDragEnabled() && !this.fPE.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.fPp && this.mDragging && this.fPo == 1) {
                this.fPs.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.fPy = (int) motionEvent.getX();
                    this.fJA = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.fPp && this.fPq) {
                        if ((this.fPF >= 0 ? this.fPF : -this.fPF) > this.mListView.getWidth() / 2) {
                            this.fPE.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.fPq = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.fPq = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.fPp && this.fPq) {
            this.fPF = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.fPo == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return d(motionEvent, this.fPA);
    }

    public int K(MotionEvent motionEvent) {
        return d(motionEvent, this.fPC);
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
                        this.fPw = childAt.getLeft();
                        this.fPx = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.fPp && this.fPo == 0) {
            this.fPv = d(motionEvent, this.fPB);
        }
        this.fPt = H(motionEvent);
        if (this.fPt != -1 && this.fPm == 0) {
            D(this.fPt, ((int) motionEvent.getX()) - this.fPw, ((int) motionEvent.getY()) - this.fPx);
        }
        this.fPq = false;
        this.fPD = true;
        this.fPF = 0;
        this.fPu = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.fPw;
            int i2 = y2 - this.fPx;
            if (this.fPD && !this.mDragging && (this.fPt != -1 || this.fPu != -1)) {
                if (this.fPt != -1) {
                    if (this.fPm == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.fPn) {
                        D(this.fPt, i, i2);
                    } else if (this.fPm != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.fPp) {
                        this.fPq = true;
                        D(this.fPu, i, i2);
                    }
                } else if (this.fPu != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.fPp) {
                        this.fPq = true;
                        D(this.fPu, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.fPD = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.fPt != -1 && this.fPm == 2) {
            this.mListView.performHapticFeedback(0);
            D(this.fPt, this.fPy - this.fPw, this.fJA - this.fPx);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.fPp && this.fPo == 0 && this.fPv != -1) {
            this.fPE.removeItem(this.fPv - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
