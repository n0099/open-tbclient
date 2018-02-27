package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends g implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int bGQ;
    private boolean bGR;
    private int bGS;
    private boolean bGT;
    private boolean bGU;
    private GestureDetector bGV;
    private GestureDetector bGW;
    private int bGX;
    private int bGY;
    private int bGZ;
    private int[] bHa;
    private int bHb;
    private int bHc;
    private int bHd;
    private int bHe;
    private boolean bHf;
    private float bHg;
    private int bHh;
    private int bHi;
    private int bHj;
    private boolean bHk;
    private a bHl;
    private int bHm;
    private GestureDetector.OnGestureListener bHn;
    private GestureDetector mDetector;
    private ListView mListView;
    private int mTouchSlop;

    public b(a aVar, ListView listView, int i, int i2, int i3) {
        this(aVar, listView, i, i2, i3, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4) {
        this(aVar, listView, i, i2, i3, i4, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4, int i5) {
        super(listView);
        this.bGQ = 0;
        this.bGR = true;
        this.bGT = false;
        this.bGU = false;
        this.bGX = -1;
        this.bGY = -1;
        this.bGZ = -1;
        this.bHa = new int[2];
        this.bHf = false;
        this.bHg = 500.0f;
        this.bHn = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bGT && b.this.bGU) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bHg) {
                        if (b.this.bHm > (-width)) {
                            b.this.bHl.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bHg) && b.this.bHm < width) {
                        b.this.bHl.stopDragWithVelocity(true, f);
                    }
                    b.this.bGU = false;
                }
                return false;
            }
        };
        this.bHl = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bGV = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bHl.isDragEnabled() || b.this.bHl.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bHd = (int) motionEvent.getX();
                b.this.bHe = (int) motionEvent.getY();
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
        this.bGW = new GestureDetector(listView.getContext(), this.bHn);
        this.bGW.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bHh = i;
        this.bHi = i4;
        this.bHj = i5;
        iA(i3);
        iz(i2);
    }

    public GestureDetector Qi() {
        return this.bGV;
    }

    public void iz(int i) {
        this.bGQ = i;
    }

    public void cJ(boolean z) {
        this.bGR = z;
    }

    public void iA(int i) {
        this.bGS = i;
    }

    public void cK(boolean z) {
        this.bGT = z;
    }

    public boolean y(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bGR && !this.bGU) {
            i4 = 12;
        }
        if (this.bGT && this.bGU) {
            i4 = i4 | 1 | 2;
        }
        this.bHf = this.bHl.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bHf;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bHl.isDragEnabled() && !this.bHl.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bGT && this.bHf && this.bGS == 1) {
                this.bGW.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bHd = (int) motionEvent.getX();
                    this.bHe = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bGT && this.bGU) {
                        if ((this.bHm >= 0 ? this.bHm : -this.bHm) > this.mListView.getWidth() / 2) {
                            this.bHl.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bGU = false;
                    this.bHf = false;
                    break;
                case 3:
                    this.bGU = false;
                    this.bHf = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.g, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bGT && this.bGU) {
            this.bHm = point.x;
        }
    }

    public int B(MotionEvent motionEvent) {
        return D(motionEvent);
    }

    public int C(MotionEvent motionEvent) {
        if (this.bGS == 1) {
            return E(motionEvent);
        }
        return -1;
    }

    public int D(MotionEvent motionEvent) {
        return c(motionEvent, this.bHh);
    }

    public int E(MotionEvent motionEvent) {
        return c(motionEvent, this.bHj);
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
                findViewById.getLocationOnScreen(this.bHa);
                if (rawX > this.bHa[0] && rawY > this.bHa[1] && rawX < this.bHa[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.bHa[1]) {
                        this.bHb = childAt.getLeft();
                        this.bHc = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bGT && this.bGS == 0) {
            this.bGZ = c(motionEvent, this.bHi);
        }
        this.bGX = B(motionEvent);
        if (this.bGX != -1 && this.bGQ == 0) {
            y(this.bGX, ((int) motionEvent.getX()) - this.bHb, ((int) motionEvent.getY()) - this.bHc);
        }
        this.bGU = false;
        this.bHk = true;
        this.bHm = 0;
        this.bGY = C(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bHb;
            int i2 = y2 - this.bHc;
            if (this.bHk && !this.bHf && (this.bGX != -1 || this.bGY != -1)) {
                if (this.bGX != -1) {
                    if (this.bGQ == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bGR) {
                        y(this.bGX, i, i2);
                    } else if (this.bGQ != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bGT) {
                        this.bGU = true;
                        y(this.bGY, i, i2);
                    }
                } else if (this.bGY != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bGT) {
                        this.bGU = true;
                        y(this.bGY, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bHk = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bGX != -1 && this.bGQ == 2) {
            this.mListView.performHapticFeedback(0);
            y(this.bGX, this.bHd - this.bHb, this.bHe - this.bHc);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bGT && this.bGS == 0 && this.bGZ != -1) {
            this.bHl.removeItem(this.bGZ - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
