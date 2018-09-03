package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int baA;
    private int baB;
    private int baC;
    private int baD;
    private int baE;
    private boolean baF;
    private float baG;
    private int baH;
    private int baI;
    private int baJ;
    private boolean baK;
    private a baL;
    private int baM;
    private GestureDetector.OnGestureListener baN;
    private int baq;
    private boolean bas;
    private int bat;
    private boolean bau;
    private boolean bav;
    private GestureDetector baw;
    private GestureDetector bax;
    private int bay;
    private int baz;
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
        this.baq = 0;
        this.bas = true;
        this.bau = false;
        this.bav = false;
        this.bay = -1;
        this.baz = -1;
        this.baA = -1;
        this.mTempLoc = new int[2];
        this.baF = false;
        this.baG = 500.0f;
        this.baN = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bau && b.this.bav) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.baG) {
                        if (b.this.baM > (-width)) {
                            b.this.baL.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.baG) && b.this.baM < width) {
                        b.this.baL.stopDragWithVelocity(true, f);
                    }
                    b.this.bav = false;
                }
                return false;
            }
        };
        this.baL = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.baw = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.baL.isDragEnabled() || b.this.baL.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.baD = (int) motionEvent.getX();
                b.this.baE = (int) motionEvent.getY();
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
        this.bax = new GestureDetector(listView.getContext(), this.baN);
        this.bax.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.baH = i;
        this.baI = i4;
        this.baJ = i5;
        fD(i3);
        fC(i2);
    }

    public GestureDetector Mw() {
        return this.baw;
    }

    public void fC(int i) {
        this.baq = i;
    }

    public void ci(boolean z) {
        this.bas = z;
    }

    public void fD(int i) {
        this.bat = i;
    }

    public void cj(boolean z) {
        this.bau = z;
    }

    public boolean n(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bas && !this.bav) {
            i4 = 12;
        }
        if (this.bau && this.bav) {
            i4 = i4 | 1 | 2;
        }
        this.baF = this.baL.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.baF;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.baL.isDragEnabled() && !this.baL.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bau && this.baF && this.bat == 1) {
                this.bax.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.baD = (int) motionEvent.getX();
                    this.baE = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bau && this.bav) {
                        if ((this.baM >= 0 ? this.baM : -this.baM) > this.mListView.getWidth() / 2) {
                            this.baL.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bav = false;
                    this.baF = false;
                    break;
                case 3:
                    this.bav = false;
                    this.baF = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bau && this.bav) {
            this.baM = point.x;
        }
    }

    public int v(MotionEvent motionEvent) {
        return x(motionEvent);
    }

    public int w(MotionEvent motionEvent) {
        if (this.bat == 1) {
            return y(motionEvent);
        }
        return -1;
    }

    public int x(MotionEvent motionEvent) {
        return b(motionEvent, this.baH);
    }

    public int y(MotionEvent motionEvent) {
        return b(motionEvent, this.baJ);
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
                        this.baB = childAt.getLeft();
                        this.baC = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bau && this.bat == 0) {
            this.baA = b(motionEvent, this.baI);
        }
        this.bay = v(motionEvent);
        if (this.bay != -1 && this.baq == 0) {
            n(this.bay, ((int) motionEvent.getX()) - this.baB, ((int) motionEvent.getY()) - this.baC);
        }
        this.bav = false;
        this.baK = true;
        this.baM = 0;
        this.baz = w(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.baB;
            int i2 = y2 - this.baC;
            if (this.baK && !this.baF && (this.bay != -1 || this.baz != -1)) {
                if (this.bay != -1) {
                    if (this.baq == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bas) {
                        n(this.bay, i, i2);
                    } else if (this.baq != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bau) {
                        this.bav = true;
                        n(this.baz, i, i2);
                    }
                } else if (this.baz != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bau) {
                        this.bav = true;
                        n(this.baz, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.baK = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bay != -1 && this.baq == 2) {
            this.mListView.performHapticFeedback(0);
            n(this.bay, this.baD - this.baB, this.baE - this.baC);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bau && this.bat == 0 && this.baA != -1) {
            this.baL.removeItem(this.baA - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
