package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private boolean cRA;
    private GestureDetector cRB;
    private GestureDetector cRC;
    private int cRD;
    private int cRE;
    private int cRF;
    private int cRG;
    private int cRH;
    private int cRI;
    private int cRJ;
    private boolean cRK;
    private float cRL;
    private int cRM;
    private int cRN;
    private int cRO;
    private boolean cRP;
    private a cRQ;
    private int cRR;
    private GestureDetector.OnGestureListener cRS;
    private int cRw;
    private boolean cRx;
    private int cRy;
    private boolean cRz;
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
        this.cRw = 0;
        this.cRx = true;
        this.cRz = false;
        this.cRA = false;
        this.cRD = -1;
        this.cRE = -1;
        this.cRF = -1;
        this.mTempLoc = new int[2];
        this.cRK = false;
        this.cRL = 500.0f;
        this.cRS = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.cRz && b.this.cRA) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.cRL) {
                        if (b.this.cRR > (-width)) {
                            b.this.cRQ.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.cRL) && b.this.cRR < width) {
                        b.this.cRQ.stopDragWithVelocity(true, f);
                    }
                    b.this.cRA = false;
                }
                return false;
            }
        };
        this.cRQ = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.cRB = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.cRQ.isDragEnabled() || b.this.cRQ.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.cRI = (int) motionEvent.getX();
                b.this.cRJ = (int) motionEvent.getY();
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
        this.cRC = new GestureDetector(listView.getContext(), this.cRS);
        this.cRC.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.cRM = i;
        this.cRN = i4;
        this.cRO = i5;
        kv(i3);
        ku(i2);
    }

    public GestureDetector ayE() {
        return this.cRB;
    }

    public void ku(int i) {
        this.cRw = i;
    }

    public void fH(boolean z) {
        this.cRx = z;
    }

    public void kv(int i) {
        this.cRy = i;
    }

    public void fI(boolean z) {
        this.cRz = z;
    }

    public boolean y(int i, int i2, int i3) {
        int i4 = 0;
        if (this.cRx && !this.cRA) {
            i4 = 12;
        }
        if (this.cRz && this.cRA) {
            i4 = i4 | 1 | 2;
        }
        this.cRK = this.cRQ.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.cRK;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cRQ.isDragEnabled() && !this.cRQ.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.cRz && this.cRK && this.cRy == 1) {
                this.cRC.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cRI = (int) motionEvent.getX();
                    this.cRJ = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.cRz && this.cRA) {
                        if ((this.cRR >= 0 ? this.cRR : -this.cRR) > this.mListView.getWidth() / 2) {
                            this.cRQ.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.cRA = false;
                    this.cRK = false;
                    break;
                case 3:
                    this.cRA = false;
                    this.cRK = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.cRz && this.cRA) {
            this.cRR = point.x;
        }
    }

    public int t(MotionEvent motionEvent) {
        return v(motionEvent);
    }

    public int u(MotionEvent motionEvent) {
        if (this.cRy == 1) {
            return w(motionEvent);
        }
        return -1;
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.cRM);
    }

    public int w(MotionEvent motionEvent) {
        return c(motionEvent, this.cRO);
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
                        this.cRG = childAt.getLeft();
                        this.cRH = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.cRz && this.cRy == 0) {
            this.cRF = c(motionEvent, this.cRN);
        }
        this.cRD = t(motionEvent);
        if (this.cRD != -1 && this.cRw == 0) {
            y(this.cRD, ((int) motionEvent.getX()) - this.cRG, ((int) motionEvent.getY()) - this.cRH);
        }
        this.cRA = false;
        this.cRP = true;
        this.cRR = 0;
        this.cRE = u(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.cRG;
            int i2 = y2 - this.cRH;
            if (this.cRP && !this.cRK && (this.cRD != -1 || this.cRE != -1)) {
                if (this.cRD != -1) {
                    if (this.cRw == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.cRx) {
                        y(this.cRD, i, i2);
                    } else if (this.cRw != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.cRz) {
                        this.cRA = true;
                        y(this.cRE, i, i2);
                    }
                } else if (this.cRE != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.cRz) {
                        this.cRA = true;
                        y(this.cRE, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.cRP = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.cRD != -1 && this.cRw == 2) {
            this.mListView.performHapticFeedback(0);
            y(this.cRD, this.cRI - this.cRG, this.cRJ - this.cRH);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.cRz && this.cRy == 0 && this.cRF != -1) {
            this.cRQ.removeItem(this.cRF - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
