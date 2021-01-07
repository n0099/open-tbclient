package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int fOh;
    private int fTT;
    private boolean fTU;
    private int fTV;
    private boolean fTW;
    private boolean fTX;
    private GestureDetector fTY;
    private GestureDetector fTZ;
    private int fUa;
    private int fUb;
    private int fUc;
    private int fUd;
    private int fUe;
    private int fUf;
    private float fUg;
    private int fUh;
    private int fUi;
    private int fUj;
    private boolean fUk;
    private a fUl;
    private int fUm;
    private GestureDetector.OnGestureListener fUn;
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
        this.fTT = 0;
        this.fTU = true;
        this.fTW = false;
        this.fTX = false;
        this.fUa = -1;
        this.fUb = -1;
        this.fUc = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.fUg = 500.0f;
        this.fUn = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.fTW && b.this.fTX) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.fUg) {
                        if (b.this.fUm > (-width)) {
                            b.this.fUl.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.fUg) && b.this.fUm < width) {
                        b.this.fUl.stopDragWithVelocity(true, f);
                    }
                    b.this.fTX = false;
                }
                return false;
            }
        };
        this.fUl = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.fTY = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.fUl.isDragEnabled() || b.this.fUl.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.fUf = (int) motionEvent.getX();
                b.this.fOh = (int) motionEvent.getY();
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
        this.fTZ = new GestureDetector(listView.getContext(), this.fUn);
        this.fTZ.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.fUh = i;
        this.fUi = i4;
        this.fUj = i5;
        tr(i3);
        tq(i2);
    }

    public GestureDetector bKk() {
        return this.fTY;
    }

    public void tq(int i) {
        this.fTT = i;
    }

    public void lF(boolean z) {
        this.fTU = z;
    }

    public void tr(int i) {
        this.fTV = i;
    }

    public void lG(boolean z) {
        this.fTW = z;
    }

    public boolean D(int i, int i2, int i3) {
        int i4 = 0;
        if (this.fTU && !this.fTX) {
            i4 = 12;
        }
        if (this.fTW && this.fTX) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.fUl.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.fUl.isDragEnabled() && !this.fUl.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.fTW && this.mDragging && this.fTV == 1) {
                this.fTZ.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.fUf = (int) motionEvent.getX();
                    this.fOh = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.fTW && this.fTX) {
                        if ((this.fUm >= 0 ? this.fUm : -this.fUm) > this.mListView.getWidth() / 2) {
                            this.fUl.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.fTX = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.fTX = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.fTW && this.fTX) {
            this.fUm = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.fTV == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return d(motionEvent, this.fUh);
    }

    public int K(MotionEvent motionEvent) {
        return d(motionEvent, this.fUj);
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
                        this.fUd = childAt.getLeft();
                        this.fUe = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.fTW && this.fTV == 0) {
            this.fUc = d(motionEvent, this.fUi);
        }
        this.fUa = H(motionEvent);
        if (this.fUa != -1 && this.fTT == 0) {
            D(this.fUa, ((int) motionEvent.getX()) - this.fUd, ((int) motionEvent.getY()) - this.fUe);
        }
        this.fTX = false;
        this.fUk = true;
        this.fUm = 0;
        this.fUb = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.fUd;
            int i2 = y2 - this.fUe;
            if (this.fUk && !this.mDragging && (this.fUa != -1 || this.fUb != -1)) {
                if (this.fUa != -1) {
                    if (this.fTT == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.fTU) {
                        D(this.fUa, i, i2);
                    } else if (this.fTT != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.fTW) {
                        this.fTX = true;
                        D(this.fUb, i, i2);
                    }
                } else if (this.fUb != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.fTW) {
                        this.fTX = true;
                        D(this.fUb, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.fUk = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.fUa != -1 && this.fTT == 2) {
            this.mListView.performHapticFeedback(0);
            D(this.fUa, this.fUf - this.fUd, this.fOh - this.fUe);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.fTW && this.fTV == 0 && this.fUc != -1) {
            this.fUl.removeItem(this.fUc - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
