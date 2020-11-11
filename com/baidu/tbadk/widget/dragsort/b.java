package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int fCY;
    private boolean fCZ;
    private int fDa;
    private boolean fDb;
    private boolean fDc;
    private GestureDetector fDd;
    private GestureDetector fDe;
    private int fDf;
    private int fDg;
    private int fDh;
    private int fDi;
    private int fDj;
    private int fDk;
    private float fDl;
    private int fDm;
    private int fDn;
    private int fDo;
    private boolean fDp;
    private a fDq;
    private int fDr;
    private GestureDetector.OnGestureListener fDs;
    private int fxy;
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
        this.fCY = 0;
        this.fCZ = true;
        this.fDb = false;
        this.fDc = false;
        this.fDf = -1;
        this.fDg = -1;
        this.fDh = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.fDl = 500.0f;
        this.fDs = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.fDb && b.this.fDc) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.fDl) {
                        if (b.this.fDr > (-width)) {
                            b.this.fDq.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.fDl) && b.this.fDr < width) {
                        b.this.fDq.stopDragWithVelocity(true, f);
                    }
                    b.this.fDc = false;
                }
                return false;
            }
        };
        this.fDq = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.fDd = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.fDq.isDragEnabled() || b.this.fDq.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.fDk = (int) motionEvent.getX();
                b.this.fxy = (int) motionEvent.getY();
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
        this.fDe = new GestureDetector(listView.getContext(), this.fDs);
        this.fDe.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.fDm = i;
        this.fDn = i4;
        this.fDo = i5;
        sf(i3);
        se(i2);
    }

    public GestureDetector bEV() {
        return this.fDd;
    }

    public void se(int i) {
        this.fCY = i;
    }

    public void kO(boolean z) {
        this.fCZ = z;
    }

    public void sf(int i) {
        this.fDa = i;
    }

    public void kP(boolean z) {
        this.fDb = z;
    }

    public boolean A(int i, int i2, int i3) {
        int i4 = 0;
        if (this.fCZ && !this.fDc) {
            i4 = 12;
        }
        if (this.fDb && this.fDc) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.fDq.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fDq.isDragEnabled() && !this.fDq.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.fDb && this.mDragging && this.fDa == 1) {
                this.fDe.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.fDk = (int) motionEvent.getX();
                    this.fxy = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.fDb && this.fDc) {
                        if ((this.fDr >= 0 ? this.fDr : -this.fDr) > this.mListView.getWidth() / 2) {
                            this.fDq.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.fDc = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.fDc = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.fDb && this.fDc) {
            this.fDr = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.fDa == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return c(motionEvent, this.fDm);
    }

    public int K(MotionEvent motionEvent) {
        return c(motionEvent, this.fDo);
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
                        this.fDi = childAt.getLeft();
                        this.fDj = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.fDb && this.fDa == 0) {
            this.fDh = c(motionEvent, this.fDn);
        }
        this.fDf = H(motionEvent);
        if (this.fDf != -1 && this.fCY == 0) {
            A(this.fDf, ((int) motionEvent.getX()) - this.fDi, ((int) motionEvent.getY()) - this.fDj);
        }
        this.fDc = false;
        this.fDp = true;
        this.fDr = 0;
        this.fDg = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.fDi;
            int i2 = y2 - this.fDj;
            if (this.fDp && !this.mDragging && (this.fDf != -1 || this.fDg != -1)) {
                if (this.fDf != -1) {
                    if (this.fCY == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.fCZ) {
                        A(this.fDf, i, i2);
                    } else if (this.fCY != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.fDb) {
                        this.fDc = true;
                        A(this.fDg, i, i2);
                    }
                } else if (this.fDg != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.fDb) {
                        this.fDc = true;
                        A(this.fDg, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.fDp = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.fDf != -1 && this.fCY == 2) {
            this.mListView.performHapticFeedback(0);
            A(this.fDf, this.fDk - this.fDi, this.fxy - this.fDj);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.fDb && this.fDa == 0 && this.fDh != -1) {
            this.fDq.removeItem(this.fDh - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
