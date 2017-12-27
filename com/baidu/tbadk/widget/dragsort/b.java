package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends g implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int bEJ;
    private boolean bEK;
    private int bEL;
    private boolean bEM;
    private boolean bEN;
    private GestureDetector bEO;
    private GestureDetector bEP;
    private int bEQ;
    private int bER;
    private int bES;
    private int[] bET;
    private int bEU;
    private int bEV;
    private int bEW;
    private int bEX;
    private boolean bEY;
    private float bEZ;
    private int bFa;
    private int bFb;
    private int bFc;
    private boolean bFd;
    private a bFe;
    private int bFf;
    private GestureDetector.OnGestureListener bFg;
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
        this.bEJ = 0;
        this.bEK = true;
        this.bEM = false;
        this.bEN = false;
        this.bEQ = -1;
        this.bER = -1;
        this.bES = -1;
        this.bET = new int[2];
        this.bEY = false;
        this.bEZ = 500.0f;
        this.bFg = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bEM && b.this.bEN) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bEZ) {
                        if (b.this.bFf > (-width)) {
                            b.this.bFe.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bEZ) && b.this.bFf < width) {
                        b.this.bFe.stopDragWithVelocity(true, f);
                    }
                    b.this.bEN = false;
                }
                return false;
            }
        };
        this.bFe = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bEO = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bFe.isDragEnabled() || b.this.bFe.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bEW = (int) motionEvent.getX();
                b.this.bEX = (int) motionEvent.getY();
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
        this.bEP = new GestureDetector(listView.getContext(), this.bFg);
        this.bEP.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bFa = i;
        this.bFb = i4;
        this.bFc = i5;
        iH(i3);
        iG(i2);
    }

    public GestureDetector PO() {
        return this.bEO;
    }

    public void iG(int i) {
        this.bEJ = i;
    }

    public void cG(boolean z) {
        this.bEK = z;
    }

    public void iH(int i) {
        this.bEL = i;
    }

    public void cH(boolean z) {
        this.bEM = z;
    }

    public boolean x(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bEK && !this.bEN) {
            i4 = 12;
        }
        if (this.bEM && this.bEN) {
            i4 = i4 | 1 | 2;
        }
        this.bEY = this.bFe.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bEY;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bFe.isDragEnabled() && !this.bFe.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bEM && this.bEY && this.bEL == 1) {
                this.bEP.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bEW = (int) motionEvent.getX();
                    this.bEX = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bEM && this.bEN) {
                        if ((this.bFf >= 0 ? this.bFf : -this.bFf) > this.mListView.getWidth() / 2) {
                            this.bFe.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bEN = false;
                    this.bEY = false;
                    break;
                case 3:
                    this.bEN = false;
                    this.bEY = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.g, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bEM && this.bEN) {
            this.bFf = point.x;
        }
    }

    public int x(MotionEvent motionEvent) {
        return z(motionEvent);
    }

    public int y(MotionEvent motionEvent) {
        if (this.bEL == 1) {
            return A(motionEvent);
        }
        return -1;
    }

    public int z(MotionEvent motionEvent) {
        return c(motionEvent, this.bFa);
    }

    public int A(MotionEvent motionEvent) {
        return c(motionEvent, this.bFc);
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
                findViewById.getLocationOnScreen(this.bET);
                if (rawX > this.bET[0] && rawY > this.bET[1] && rawX < this.bET[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.bET[1]) {
                        this.bEU = childAt.getLeft();
                        this.bEV = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bEM && this.bEL == 0) {
            this.bES = c(motionEvent, this.bFb);
        }
        this.bEQ = x(motionEvent);
        if (this.bEQ != -1 && this.bEJ == 0) {
            x(this.bEQ, ((int) motionEvent.getX()) - this.bEU, ((int) motionEvent.getY()) - this.bEV);
        }
        this.bEN = false;
        this.bFd = true;
        this.bFf = 0;
        this.bER = y(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bEU;
            int i2 = y2 - this.bEV;
            if (this.bFd && !this.bEY && (this.bEQ != -1 || this.bER != -1)) {
                if (this.bEQ != -1) {
                    if (this.bEJ == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bEK) {
                        x(this.bEQ, i, i2);
                    } else if (this.bEJ != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bEM) {
                        this.bEN = true;
                        x(this.bER, i, i2);
                    }
                } else if (this.bER != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bEM) {
                        this.bEN = true;
                        x(this.bER, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bFd = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bEQ != -1 && this.bEJ == 2) {
            this.mListView.performHapticFeedback(0);
            x(this.bEQ, this.bEW - this.bEU, this.bEX - this.bEV);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bEM && this.bEL == 0 && this.bES != -1) {
            this.bFe.removeItem(this.bES - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
