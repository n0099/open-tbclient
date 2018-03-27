package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends g implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int bGT;
    private boolean bGU;
    private int bGV;
    private boolean bGW;
    private boolean bGX;
    private GestureDetector bGY;
    private GestureDetector bGZ;
    private int bHa;
    private int bHb;
    private int bHc;
    private int[] bHd;
    private int bHe;
    private int bHf;
    private int bHg;
    private int bHh;
    private boolean bHi;
    private float bHj;
    private int bHk;
    private int bHl;
    private int bHm;
    private boolean bHn;
    private a bHo;
    private int bHp;
    private GestureDetector.OnGestureListener bHq;
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
        this.bGT = 0;
        this.bGU = true;
        this.bGW = false;
        this.bGX = false;
        this.bHa = -1;
        this.bHb = -1;
        this.bHc = -1;
        this.bHd = new int[2];
        this.bHi = false;
        this.bHj = 500.0f;
        this.bHq = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bGW && b.this.bGX) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bHj) {
                        if (b.this.bHp > (-width)) {
                            b.this.bHo.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bHj) && b.this.bHp < width) {
                        b.this.bHo.stopDragWithVelocity(true, f);
                    }
                    b.this.bGX = false;
                }
                return false;
            }
        };
        this.bHo = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bGY = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bHo.isDragEnabled() || b.this.bHo.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bHg = (int) motionEvent.getX();
                b.this.bHh = (int) motionEvent.getY();
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
        this.bGZ = new GestureDetector(listView.getContext(), this.bHq);
        this.bGZ.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bHk = i;
        this.bHl = i4;
        this.bHm = i5;
        iA(i3);
        iz(i2);
    }

    public GestureDetector Qj() {
        return this.bGY;
    }

    public void iz(int i) {
        this.bGT = i;
    }

    public void cJ(boolean z) {
        this.bGU = z;
    }

    public void iA(int i) {
        this.bGV = i;
    }

    public void cK(boolean z) {
        this.bGW = z;
    }

    public boolean y(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bGU && !this.bGX) {
            i4 = 12;
        }
        if (this.bGW && this.bGX) {
            i4 = i4 | 1 | 2;
        }
        this.bHi = this.bHo.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bHi;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bHo.isDragEnabled() && !this.bHo.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bGW && this.bHi && this.bGV == 1) {
                this.bGZ.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bHg = (int) motionEvent.getX();
                    this.bHh = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bGW && this.bGX) {
                        if ((this.bHp >= 0 ? this.bHp : -this.bHp) > this.mListView.getWidth() / 2) {
                            this.bHo.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bGX = false;
                    this.bHi = false;
                    break;
                case 3:
                    this.bGX = false;
                    this.bHi = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.g, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bGW && this.bGX) {
            this.bHp = point.x;
        }
    }

    public int B(MotionEvent motionEvent) {
        return D(motionEvent);
    }

    public int C(MotionEvent motionEvent) {
        if (this.bGV == 1) {
            return E(motionEvent);
        }
        return -1;
    }

    public int D(MotionEvent motionEvent) {
        return c(motionEvent, this.bHk);
    }

    public int E(MotionEvent motionEvent) {
        return c(motionEvent, this.bHm);
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
                findViewById.getLocationOnScreen(this.bHd);
                if (rawX > this.bHd[0] && rawY > this.bHd[1] && rawX < this.bHd[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.bHd[1]) {
                        this.bHe = childAt.getLeft();
                        this.bHf = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bGW && this.bGV == 0) {
            this.bHc = c(motionEvent, this.bHl);
        }
        this.bHa = B(motionEvent);
        if (this.bHa != -1 && this.bGT == 0) {
            y(this.bHa, ((int) motionEvent.getX()) - this.bHe, ((int) motionEvent.getY()) - this.bHf);
        }
        this.bGX = false;
        this.bHn = true;
        this.bHp = 0;
        this.bHb = C(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bHe;
            int i2 = y2 - this.bHf;
            if (this.bHn && !this.bHi && (this.bHa != -1 || this.bHb != -1)) {
                if (this.bHa != -1) {
                    if (this.bGT == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bGU) {
                        y(this.bHa, i, i2);
                    } else if (this.bGT != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bGW) {
                        this.bGX = true;
                        y(this.bHb, i, i2);
                    }
                } else if (this.bHb != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bGW) {
                        this.bGX = true;
                        y(this.bHb, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bHn = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bHa != -1 && this.bGT == 2) {
            this.mListView.performHapticFeedback(0);
            y(this.bHa, this.bHg - this.bHe, this.bHh - this.bHf);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bGW && this.bGV == 0 && this.bHc != -1) {
            this.bHo.removeItem(this.bHc - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
