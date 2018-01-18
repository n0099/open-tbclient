package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends g implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int bER;
    private boolean bES;
    private int bET;
    private boolean bEU;
    private boolean bEV;
    private GestureDetector bEW;
    private GestureDetector bEX;
    private int bEY;
    private int bEZ;
    private int bFa;
    private int[] bFb;
    private int bFc;
    private int bFd;
    private int bFe;
    private int bFf;
    private boolean bFg;
    private float bFh;
    private int bFi;
    private int bFj;
    private int bFk;
    private boolean bFl;
    private a bFm;
    private int bFn;
    private GestureDetector.OnGestureListener bFo;
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
        this.bER = 0;
        this.bES = true;
        this.bEU = false;
        this.bEV = false;
        this.bEY = -1;
        this.bEZ = -1;
        this.bFa = -1;
        this.bFb = new int[2];
        this.bFg = false;
        this.bFh = 500.0f;
        this.bFo = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bEU && b.this.bEV) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bFh) {
                        if (b.this.bFn > (-width)) {
                            b.this.bFm.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bFh) && b.this.bFn < width) {
                        b.this.bFm.stopDragWithVelocity(true, f);
                    }
                    b.this.bEV = false;
                }
                return false;
            }
        };
        this.bFm = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bEW = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bFm.isDragEnabled() || b.this.bFm.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bFe = (int) motionEvent.getX();
                b.this.bFf = (int) motionEvent.getY();
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
        this.bEX = new GestureDetector(listView.getContext(), this.bFo);
        this.bEX.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bFi = i;
        this.bFj = i4;
        this.bFk = i5;
        iD(i3);
        iC(i2);
    }

    public GestureDetector PC() {
        return this.bEW;
    }

    public void iC(int i) {
        this.bER = i;
    }

    public void cE(boolean z) {
        this.bES = z;
    }

    public void iD(int i) {
        this.bET = i;
    }

    public void cF(boolean z) {
        this.bEU = z;
    }

    public boolean x(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bES && !this.bEV) {
            i4 = 12;
        }
        if (this.bEU && this.bEV) {
            i4 = i4 | 1 | 2;
        }
        this.bFg = this.bFm.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bFg;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bFm.isDragEnabled() && !this.bFm.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bEU && this.bFg && this.bET == 1) {
                this.bEX.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bFe = (int) motionEvent.getX();
                    this.bFf = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bEU && this.bEV) {
                        if ((this.bFn >= 0 ? this.bFn : -this.bFn) > this.mListView.getWidth() / 2) {
                            this.bFm.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bEV = false;
                    this.bFg = false;
                    break;
                case 3:
                    this.bEV = false;
                    this.bFg = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.g, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bEU && this.bEV) {
            this.bFn = point.x;
        }
    }

    public int x(MotionEvent motionEvent) {
        return z(motionEvent);
    }

    public int y(MotionEvent motionEvent) {
        if (this.bET == 1) {
            return A(motionEvent);
        }
        return -1;
    }

    public int z(MotionEvent motionEvent) {
        return c(motionEvent, this.bFi);
    }

    public int A(MotionEvent motionEvent) {
        return c(motionEvent, this.bFk);
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
                findViewById.getLocationOnScreen(this.bFb);
                if (rawX > this.bFb[0] && rawY > this.bFb[1] && rawX < this.bFb[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.bFb[1]) {
                        this.bFc = childAt.getLeft();
                        this.bFd = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bEU && this.bET == 0) {
            this.bFa = c(motionEvent, this.bFj);
        }
        this.bEY = x(motionEvent);
        if (this.bEY != -1 && this.bER == 0) {
            x(this.bEY, ((int) motionEvent.getX()) - this.bFc, ((int) motionEvent.getY()) - this.bFd);
        }
        this.bEV = false;
        this.bFl = true;
        this.bFn = 0;
        this.bEZ = y(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bFc;
            int i2 = y2 - this.bFd;
            if (this.bFl && !this.bFg && (this.bEY != -1 || this.bEZ != -1)) {
                if (this.bEY != -1) {
                    if (this.bER == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bES) {
                        x(this.bEY, i, i2);
                    } else if (this.bER != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bEU) {
                        this.bEV = true;
                        x(this.bEZ, i, i2);
                    }
                } else if (this.bEZ != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bEU) {
                        this.bEV = true;
                        x(this.bEZ, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bFl = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bEY != -1 && this.bER == 2) {
            this.mListView.performHapticFeedback(0);
            x(this.bEY, this.bFe - this.bFc, this.bFf - this.bFd);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bEU && this.bET == 0 && this.bFa != -1) {
            this.bFm.removeItem(this.bFa - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
