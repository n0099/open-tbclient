package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static DateFormat cQq = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int cPJ;
    private int cPK;
    private int cPL;
    private float cPM;
    private WheelView.DividerType cPR;
    private boolean[] cPc;
    private int cQB;
    private com.baidu.tbadk.widget.timepicker.a.d.b cQC;
    private WheelView cQr;
    private WheelView cQs;
    private WheelView cQt;
    private WheelView cQu;
    private WheelView cQv;
    private WheelView cQw;
    private int gravity;
    private int textSize;
    private View view;
    private int cPg = 1900;
    private int cPh = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int cQx = 1;
    private int cQy = 12;
    private int cQz = 1;
    private int cQA = 31;
    private boolean cPj = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.cPc = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void gc(boolean z) {
        this.cPj = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.cPj) {
            int[] A = com.baidu.tbadk.widget.timepicker.a.e.b.A(i, i2 + 1, i3);
            a(A[0], A[1] - 1, A[2], A[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.cQr = (WheelView) this.view.findViewById(R.id.year);
        this.cQr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.az(this.cPg, this.cPh)));
        this.cQr.setLabel("");
        this.cQr.setCurrentItem(i - this.cPg);
        this.cQr.setGravity(this.gravity);
        this.cQs = (WheelView) this.view.findViewById(R.id.month);
        this.cQs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lZ(i)));
        this.cQs.setLabel("");
        int lW = com.baidu.tbadk.widget.timepicker.a.e.a.lW(i);
        if (lW != 0 && (i2 > lW - 1 || z)) {
            this.cQs.setCurrentItem(i2 + 1);
        } else {
            this.cQs.setCurrentItem(i2);
        }
        this.cQs.setGravity(this.gravity);
        this.cQt = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lW(i) == 0) {
            this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ma(com.baidu.tbadk.widget.timepicker.a.e.a.ay(i, i2))));
        } else {
            this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ma(com.baidu.tbadk.widget.timepicker.a.e.a.lV(i))));
        }
        this.cQt.setLabel("");
        this.cQt.setCurrentItem(i3 - 1);
        this.cQt.setGravity(this.gravity);
        this.cQu = (WheelView) this.view.findViewById(R.id.hour);
        this.cQu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cQu.setCurrentItem(i4);
        this.cQu.setGravity(this.gravity);
        this.cQv = (WheelView) this.view.findViewById(R.id.min);
        this.cQv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cQv.setCurrentItem(i5);
        this.cQv.setGravity(this.gravity);
        this.cQw = (WheelView) this.view.findViewById(R.id.second);
        this.cQw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cQw.setCurrentItem(i5);
        this.cQw.setGravity(this.gravity);
        this.cQr.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void md(int i7) {
                int ay;
                int i8 = c.this.cPg + i7;
                c.this.cQs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lZ(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lW(i8) == 0 || c.this.cQs.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lW(i8) - 1) {
                    c.this.cQs.setCurrentItem(c.this.cQs.getCurrentItem());
                } else {
                    c.this.cQs.setCurrentItem(c.this.cQs.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lW(i8) == 0 || c.this.cQs.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lW(i8) - 1) {
                    c.this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ma(com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cQs.getCurrentItem() + 1))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cQs.getCurrentItem() + 1);
                } else if (c.this.cQs.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lW(i8) + 1) {
                    c.this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ma(com.baidu.tbadk.widget.timepicker.a.e.a.lV(i8))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.lV(i8);
                } else {
                    c.this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ma(com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cQs.getCurrentItem()))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cQs.getCurrentItem());
                }
                if (c.this.cQt.getCurrentItem() > ay - 1) {
                    c.this.cQt.setCurrentItem(ay - 1);
                }
                if (c.this.cQC != null) {
                    c.this.cQC.azY();
                }
            }
        });
        this.cQs.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void md(int i7) {
                int ay;
                int currentItem = c.this.cQr.getCurrentItem() + c.this.cPg;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lW(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.lW(currentItem) - 1) {
                    c.this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ma(com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7 + 1))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7 + 1);
                } else if (c.this.cQs.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lW(currentItem) + 1) {
                    c.this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ma(com.baidu.tbadk.widget.timepicker.a.e.a.lV(currentItem))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.lV(currentItem);
                } else {
                    c.this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ma(com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7);
                }
                if (c.this.cQt.getCurrentItem() > ay - 1) {
                    c.this.cQt.setCurrentItem(ay - 1);
                }
                if (c.this.cQC != null) {
                    c.this.cQC.azY();
                }
            }
        });
        a(this.cQt);
        a(this.cQu);
        a(this.cQv);
        a(this.cQw);
        if (this.cPc.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.cQr.setVisibility(this.cPc[0] ? 0 : 8);
        this.cQs.setVisibility(this.cPc[1] ? 0 : 8);
        this.cQt.setVisibility(this.cPc[2] ? 0 : 8);
        this.cQu.setVisibility(this.cPc[3] ? 0 : 8);
        this.cQv.setVisibility(this.cPc[4] ? 0 : 8);
        this.cQw.setVisibility(this.cPc[5] ? 0 : 8);
        aAk();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.cQB = i;
        this.cQr = (WheelView) this.view.findViewById(R.id.year);
        this.cQr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPg, this.cPh));
        this.cQr.setCurrentItem(i - this.cPg);
        this.cQr.setGravity(this.gravity);
        this.cQs = (WheelView) this.view.findViewById(R.id.month);
        if (this.cPg == this.cPh) {
            this.cQs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cQx, this.cQy));
            this.cQs.setCurrentItem((i2 + 1) - this.cQx);
        } else if (i == this.cPg) {
            this.cQs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cQx, 12));
            this.cQs.setCurrentItem((i2 + 1) - this.cQx);
        } else if (i == this.cPh) {
            this.cQs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cQy));
            this.cQs.setCurrentItem(i2);
        } else {
            this.cQs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.cQs.setCurrentItem(i2);
        }
        this.cQs.setGravity(this.gravity);
        this.cQt = (WheelView) this.view.findViewById(R.id.day);
        if (this.cPg == this.cPh && this.cQx == this.cQy) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cQA > 31) {
                    this.cQA = 31;
                }
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cQz, this.cQA));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cQA > 30) {
                    this.cQA = 30;
                }
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cQz, this.cQA));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cQA > 29) {
                    this.cQA = 29;
                }
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cQz, this.cQA));
            } else {
                if (this.cQA > 28) {
                    this.cQA = 28;
                }
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cQz, this.cQA));
            }
            this.cQt.setCurrentItem(i3 - this.cQz);
        } else if (i == this.cPg && i2 + 1 == this.cQx) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cQz, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cQz, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cQz, 29));
            } else {
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cQz, 28));
            }
            this.cQt.setCurrentItem(i3 - this.cQz);
        } else if (i == this.cPh && i2 + 1 == this.cQy) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cQA > 31) {
                    this.cQA = 31;
                }
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cQA));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cQA > 30) {
                    this.cQA = 30;
                }
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cQA));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cQA > 29) {
                    this.cQA = 29;
                }
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cQA));
            } else {
                if (this.cQA > 28) {
                    this.cQA = 28;
                }
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cQA));
            }
            this.cQt.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.cQt.setCurrentItem(i3 - 1);
        }
        this.cQt.setGravity(this.gravity);
        this.cQu = (WheelView) this.view.findViewById(R.id.hour);
        this.cQu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cQu.setCurrentItem(i4);
        this.cQu.setGravity(this.gravity);
        this.cQv = (WheelView) this.view.findViewById(R.id.min);
        this.cQv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cQv.setCurrentItem(i5);
        this.cQv.setGravity(this.gravity);
        this.cQw = (WheelView) this.view.findViewById(R.id.second);
        this.cQw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cQw.setCurrentItem(i6);
        this.cQw.setGravity(this.gravity);
        this.cQr.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void md(int i7) {
                int i8 = i7 + c.this.cPg;
                c.this.cQB = i8;
                int currentItem = c.this.cQs.getCurrentItem();
                if (c.this.cPg == c.this.cPh) {
                    c.this.cQs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cQx, c.this.cQy));
                    if (currentItem > c.this.cQs.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cQs.getAdapter().getItemsCount() - 1;
                        c.this.cQs.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.cQx + currentItem;
                    if (c.this.cQx == c.this.cQy) {
                        c.this.a(i8, i9, c.this.cQz, c.this.cQA, asList, asList2);
                    } else if (i9 == c.this.cQx) {
                        c.this.a(i8, i9, c.this.cQz, 31, asList, asList2);
                    } else if (i9 == c.this.cQy) {
                        c.this.a(i8, i9, 1, c.this.cQA, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.cPg) {
                    c.this.cQs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cQx, 12));
                    if (currentItem > c.this.cQs.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cQs.getAdapter().getItemsCount() - 1;
                        c.this.cQs.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.cQx + currentItem;
                    if (i10 == c.this.cQx) {
                        c.this.a(i8, i10, c.this.cQz, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.cPh) {
                    c.this.cQs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.cQy));
                    if (currentItem > c.this.cQs.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cQs.getAdapter().getItemsCount() - 1;
                        c.this.cQs.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.cQy) {
                        c.this.a(i8, i11, 1, c.this.cQA, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.cQs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.cQs.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.cQC != null) {
                    c.this.cQC.azY();
                }
            }
        });
        this.cQs.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void md(int i7) {
                int i8 = i7 + 1;
                if (c.this.cPg == c.this.cPh) {
                    int i9 = (c.this.cQx + i8) - 1;
                    if (c.this.cQx == c.this.cQy) {
                        c.this.a(c.this.cQB, i9, c.this.cQz, c.this.cQA, asList, asList2);
                    } else if (c.this.cQx == i9) {
                        c.this.a(c.this.cQB, i9, c.this.cQz, 31, asList, asList2);
                    } else if (c.this.cQy == i9) {
                        c.this.a(c.this.cQB, i9, 1, c.this.cQA, asList, asList2);
                    } else {
                        c.this.a(c.this.cQB, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.cQB == c.this.cPg) {
                    int i10 = (c.this.cQx + i8) - 1;
                    if (i10 == c.this.cQx) {
                        c.this.a(c.this.cQB, i10, c.this.cQz, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.cQB, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.cQB == c.this.cPh) {
                    if (i8 == c.this.cQy) {
                        c.this.a(c.this.cQB, c.this.cQs.getCurrentItem() + 1, 1, c.this.cQA, asList, asList2);
                    } else {
                        c.this.a(c.this.cQB, c.this.cQs.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.cQB, i8, 1, 31, asList, asList2);
                }
                if (c.this.cQC != null) {
                    c.this.cQC.azY();
                }
            }
        });
        a(this.cQt);
        a(this.cQu);
        a(this.cQv);
        a(this.cQw);
        if (this.cPc.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.cQr.setVisibility(this.cPc[0] ? 0 : 8);
        this.cQs.setVisibility(this.cPc[1] ? 0 : 8);
        this.cQt.setVisibility(this.cPc[2] ? 0 : 8);
        this.cQu.setVisibility(this.cPc[3] ? 0 : 8);
        this.cQv.setVisibility(this.cPc[4] ? 0 : 8);
        this.cQw.setVisibility(this.cPc[5] ? 0 : 8);
        aAk();
    }

    private void a(WheelView wheelView) {
        if (this.cQC != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void md(int i) {
                    c.this.cQC.azY();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.cQt.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.cQt.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.cQt.getAdapter().getItemsCount() - 1) {
            this.cQt.setCurrentItem(this.cQt.getAdapter().getItemsCount() - 1);
        }
    }

    private void aAk() {
        this.cQt.setTextSize(this.textSize);
        this.cQs.setTextSize(this.textSize);
        this.cQr.setTextSize(this.textSize);
        this.cQu.setTextSize(this.textSize);
        this.cQv.setTextSize(this.textSize);
        this.cQw.setTextSize(this.textSize);
    }

    private void aAl() {
        this.cQt.setTextColorOut(this.cPJ);
        this.cQs.setTextColorOut(this.cPJ);
        this.cQr.setTextColorOut(this.cPJ);
        this.cQu.setTextColorOut(this.cPJ);
        this.cQv.setTextColorOut(this.cPJ);
        this.cQw.setTextColorOut(this.cPJ);
    }

    private void aAm() {
        this.cQt.setTextColorCenter(this.cPK);
        this.cQs.setTextColorCenter(this.cPK);
        this.cQr.setTextColorCenter(this.cPK);
        this.cQu.setTextColorCenter(this.cPK);
        this.cQv.setTextColorCenter(this.cPK);
        this.cQw.setTextColorCenter(this.cPK);
    }

    private void aAn() {
        this.cQt.setDividerColor(this.cPL);
        this.cQs.setDividerColor(this.cPL);
        this.cQr.setDividerColor(this.cPL);
        this.cQu.setDividerColor(this.cPL);
        this.cQv.setDividerColor(this.cPL);
        this.cQw.setDividerColor(this.cPL);
    }

    private void aAo() {
        this.cQt.setDividerType(this.cPR);
        this.cQs.setDividerType(this.cPR);
        this.cQr.setDividerType(this.cPR);
        this.cQu.setDividerType(this.cPR);
        this.cQv.setDividerType(this.cPR);
        this.cQw.setDividerType(this.cPR);
    }

    private void aAp() {
        this.cQt.setLineSpacingMultiplier(this.cPM);
        this.cQs.setLineSpacingMultiplier(this.cPM);
        this.cQr.setLineSpacingMultiplier(this.cPM);
        this.cQu.setLineSpacingMultiplier(this.cPM);
        this.cQv.setLineSpacingMultiplier(this.cPM);
        this.cQw.setLineSpacingMultiplier(this.cPM);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.cPj) {
            if (str != null) {
                this.cQr.setLabel(str);
            } else {
                this.cQr.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.cQs.setLabel(str2);
            } else {
                this.cQs.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.cQt.setLabel(str3);
            } else {
                this.cQt.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.cQu.setLabel(str4);
            } else {
                this.cQu.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.cQv.setLabel(str5);
            } else {
                this.cQv.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.cQw.setLabel(str6);
            } else {
                this.cQw.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cQt.setTextXOffset(i);
        this.cQs.setTextXOffset(i2);
        this.cQr.setTextXOffset(i3);
        this.cQu.setTextXOffset(i4);
        this.cQv.setTextXOffset(i5);
        this.cQw.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.cQr.setCyclic(z);
        this.cQs.setCyclic(z);
        this.cQt.setCyclic(z);
        this.cQu.setCyclic(z);
        this.cQv.setCyclic(z);
        this.cQw.setCyclic(z);
    }

    public String getTime() {
        if (this.cPj) {
            return aAq();
        }
        StringBuilder sb = new StringBuilder();
        if (this.cQB == this.cPg) {
            if (this.cQs.getCurrentItem() + this.cQx == this.cQx) {
                sb.append(this.cQr.getCurrentItem() + this.cPg).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cQs.getCurrentItem() + this.cQx).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cQt.getCurrentItem() + this.cQz).append(" ").append(this.cQu.getCurrentItem()).append(":").append(this.cQv.getCurrentItem()).append(":").append(this.cQw.getCurrentItem());
            } else {
                sb.append(this.cQr.getCurrentItem() + this.cPg).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cQs.getCurrentItem() + this.cQx).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cQt.getCurrentItem() + 1).append(" ").append(this.cQu.getCurrentItem()).append(":").append(this.cQv.getCurrentItem()).append(":").append(this.cQw.getCurrentItem());
            }
        } else {
            sb.append(this.cQr.getCurrentItem() + this.cPg).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cQs.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cQt.getCurrentItem() + 1).append(" ").append(this.cQu.getCurrentItem()).append(":").append(this.cQv.getCurrentItem()).append(":").append(this.cQw.getCurrentItem());
        }
        return sb.toString();
    }

    private String aAq() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.cQr.getCurrentItem() + this.cPg;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lW(currentItem2) == 0) {
            currentItem = this.cQs.getCurrentItem() + 1;
            z = false;
        } else if ((this.cQs.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lW(currentItem2) <= 0) {
            currentItem = this.cQs.getCurrentItem() + 1;
            z = false;
        } else if ((this.cQs.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lW(currentItem2) == 1) {
            currentItem = this.cQs.getCurrentItem();
            z = true;
        } else {
            currentItem = this.cQs.getCurrentItem();
            z = false;
        }
        int[] e = com.baidu.tbadk.widget.timepicker.a.e.b.e(currentItem2, currentItem, this.cQt.getCurrentItem() + 1, z);
        sb.append(e[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[2]).append(" ").append(this.cQu.getCurrentItem()).append(":").append(this.cQv.getCurrentItem()).append(":").append(this.cQw.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void mb(int i) {
        this.cPg = i;
    }

    public void mc(int i) {
        this.cPh = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.cPg) {
                this.cPh = i;
                this.cQy = i2;
                this.cQA = i3;
            } else if (i == this.cPg) {
                if (i2 > this.cQx) {
                    this.cPh = i;
                    this.cQy = i2;
                    this.cQA = i3;
                } else if (i2 == this.cQx && i3 > this.cQz) {
                    this.cPh = i;
                    this.cQy = i2;
                    this.cQA = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.cPh) {
                this.cQx = i5;
                this.cQz = i6;
                this.cPg = i4;
            } else if (i4 == this.cPh) {
                if (i5 < this.cQy) {
                    this.cQx = i5;
                    this.cQz = i6;
                    this.cPg = i4;
                } else if (i5 == this.cQy && i6 < this.cQA) {
                    this.cQx = i5;
                    this.cQz = i6;
                    this.cPg = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.cPg = calendar.get(1);
            this.cPh = calendar2.get(1);
            this.cQx = calendar.get(2) + 1;
            this.cQy = calendar2.get(2) + 1;
            this.cQz = calendar.get(5);
            this.cQA = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.cPM = f;
        aAp();
    }

    public void setDividerColor(int i) {
        this.cPL = i;
        aAn();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.cPR = dividerType;
        aAo();
    }

    public void setTextColorCenter(int i) {
        this.cPK = i;
        aAm();
    }

    public void setTextColorOut(int i) {
        this.cPJ = i;
        aAl();
    }

    public void gd(boolean z) {
        this.cQt.gd(z);
        this.cQs.gd(z);
        this.cQr.gd(z);
        this.cQu.gd(z);
        this.cQv.gd(z);
        this.cQw.gd(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.cQC = bVar;
    }
}
