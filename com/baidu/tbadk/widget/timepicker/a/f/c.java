package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static DateFormat cFK = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private boolean[] cEy;
    private WheelView cFL;
    private WheelView cFM;
    private WheelView cFN;
    private WheelView cFO;
    private WheelView cFP;
    private WheelView cFQ;
    private int cFV;
    private com.baidu.tbadk.widget.timepicker.a.d.b cFW;
    private int cFd;
    private int cFe;
    private int cFf;
    private float cFg;
    private WheelView.DividerType cFl;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = 1900;
    private int endYear = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int cFR = 1;
    private int cFS = 12;
    private int cFT = 1;
    private int cFU = 31;
    private boolean cED = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.cEy = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void fy(boolean z) {
        this.cED = z;
    }

    public void f(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.cED) {
            int[] y = com.baidu.tbadk.widget.timepicker.a.e.b.y(i, i2 + 1, i3);
            a(y[0], y[1] - 1, y[2], y[3] == 1, i4, i5, i6);
            return;
        }
        g(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.cFL = (WheelView) this.view.findViewById(d.g.year);
        this.cFL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.av(this.startYear, this.endYear)));
        this.cFL.setLabel("");
        this.cFL.setCurrentItem(i - this.startYear);
        this.cFL.setGravity(this.gravity);
        this.cFM = (WheelView) this.view.findViewById(d.g.month);
        this.cFM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(i)));
        this.cFM.setLabel("");
        int kX = com.baidu.tbadk.widget.timepicker.a.e.a.kX(i);
        if (kX != 0 && (i2 > kX - 1 || z)) {
            this.cFM.setCurrentItem(i2 + 1);
        } else {
            this.cFM.setCurrentItem(i2);
        }
        this.cFM.setGravity(this.gravity);
        this.cFN = (WheelView) this.view.findViewById(d.g.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.kX(i) == 0) {
            this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lb(com.baidu.tbadk.widget.timepicker.a.e.a.au(i, i2))));
        } else {
            this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lb(com.baidu.tbadk.widget.timepicker.a.e.a.kW(i))));
        }
        this.cFN.setLabel("");
        this.cFN.setCurrentItem(i3 - 1);
        this.cFN.setGravity(this.gravity);
        this.cFO = (WheelView) this.view.findViewById(d.g.hour);
        this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cFO.setCurrentItem(i4);
        this.cFO.setGravity(this.gravity);
        this.cFP = (WheelView) this.view.findViewById(d.g.min);
        this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFP.setCurrentItem(i5);
        this.cFP.setGravity(this.gravity);
        this.cFQ = (WheelView) this.view.findViewById(d.g.second);
        this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFQ.setCurrentItem(i5);
        this.cFQ.setGravity(this.gravity);
        this.cFL.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void ld(int i7) {
                int au;
                int i8 = c.this.startYear + i7;
                c.this.cFM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.kX(i8) == 0 || c.this.cFM.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.kX(i8) - 1) {
                    c.this.cFM.setCurrentItem(c.this.cFM.getCurrentItem());
                } else {
                    c.this.cFM.setCurrentItem(c.this.cFM.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.kX(i8) == 0 || c.this.cFM.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.kX(i8) - 1) {
                    c.this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lb(com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFM.getCurrentItem() + 1))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFM.getCurrentItem() + 1);
                } else if (c.this.cFM.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.kX(i8) + 1) {
                    c.this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lb(com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8);
                } else {
                    c.this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lb(com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFM.getCurrentItem()))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFM.getCurrentItem());
                }
                if (c.this.cFN.getCurrentItem() > au - 1) {
                    c.this.cFN.setCurrentItem(au - 1);
                }
                if (c.this.cFW != null) {
                    c.this.cFW.atv();
                }
            }
        });
        this.cFM.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void ld(int i7) {
                int au;
                int currentItem = c.this.cFL.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.kX(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.kX(currentItem) - 1) {
                    c.this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lb(com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7 + 1))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7 + 1);
                } else if (c.this.cFM.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.kX(currentItem) + 1) {
                    c.this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lb(com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem);
                } else {
                    c.this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lb(com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7);
                }
                if (c.this.cFN.getCurrentItem() > au - 1) {
                    c.this.cFN.setCurrentItem(au - 1);
                }
                if (c.this.cFW != null) {
                    c.this.cFW.atv();
                }
            }
        });
        a(this.cFN);
        a(this.cFO);
        a(this.cFP);
        a(this.cFQ);
        if (this.cEy.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.cFL.setVisibility(this.cEy[0] ? 0 : 8);
        this.cFM.setVisibility(this.cEy[1] ? 0 : 8);
        this.cFN.setVisibility(this.cEy[2] ? 0 : 8);
        this.cFO.setVisibility(this.cEy[3] ? 0 : 8);
        this.cFP.setVisibility(this.cEy[4] ? 0 : 8);
        this.cFQ.setVisibility(this.cEy[5] ? 0 : 8);
        atF();
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.cFV = i;
        this.cFL = (WheelView) this.view.findViewById(d.g.year);
        this.cFL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.cFL.setCurrentItem(i - this.startYear);
        this.cFL.setGravity(this.gravity);
        this.cFM = (WheelView) this.view.findViewById(d.g.month);
        if (this.startYear == this.endYear) {
            this.cFM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFR, this.cFS));
            this.cFM.setCurrentItem((i2 + 1) - this.cFR);
        } else if (i == this.startYear) {
            this.cFM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFR, 12));
            this.cFM.setCurrentItem((i2 + 1) - this.cFR);
        } else if (i == this.endYear) {
            this.cFM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFS));
            this.cFM.setCurrentItem(i2);
        } else {
            this.cFM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.cFM.setCurrentItem(i2);
        }
        this.cFM.setGravity(this.gravity);
        this.cFN = (WheelView) this.view.findViewById(d.g.day);
        if (this.startYear == this.endYear && this.cFR == this.cFS) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cFU > 31) {
                    this.cFU = 31;
                }
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFT, this.cFU));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cFU > 30) {
                    this.cFU = 30;
                }
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFT, this.cFU));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cFU > 29) {
                    this.cFU = 29;
                }
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFT, this.cFU));
            } else {
                if (this.cFU > 28) {
                    this.cFU = 28;
                }
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFT, this.cFU));
            }
            this.cFN.setCurrentItem(i3 - this.cFT);
        } else if (i == this.startYear && i2 + 1 == this.cFR) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFT, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFT, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFT, 29));
            } else {
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFT, 28));
            }
            this.cFN.setCurrentItem(i3 - this.cFT);
        } else if (i == this.endYear && i2 + 1 == this.cFS) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cFU > 31) {
                    this.cFU = 31;
                }
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFU));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cFU > 30) {
                    this.cFU = 30;
                }
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFU));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cFU > 29) {
                    this.cFU = 29;
                }
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFU));
            } else {
                if (this.cFU > 28) {
                    this.cFU = 28;
                }
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFU));
            }
            this.cFN.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.cFN.setCurrentItem(i3 - 1);
        }
        this.cFN.setGravity(this.gravity);
        this.cFO = (WheelView) this.view.findViewById(d.g.hour);
        this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cFO.setCurrentItem(i4);
        this.cFO.setGravity(this.gravity);
        this.cFP = (WheelView) this.view.findViewById(d.g.min);
        this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFP.setCurrentItem(i5);
        this.cFP.setGravity(this.gravity);
        this.cFQ = (WheelView) this.view.findViewById(d.g.second);
        this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFQ.setCurrentItem(i6);
        this.cFQ.setGravity(this.gravity);
        this.cFL.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void ld(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.cFV = i8;
                int currentItem = c.this.cFM.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.cFM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cFR, c.this.cFS));
                    if (currentItem > c.this.cFM.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cFM.getAdapter().getItemsCount() - 1;
                        c.this.cFM.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.cFR + currentItem;
                    if (c.this.cFR == c.this.cFS) {
                        c.this.a(i8, i9, c.this.cFT, c.this.cFU, asList, asList2);
                    } else if (i9 == c.this.cFR) {
                        c.this.a(i8, i9, c.this.cFT, 31, asList, asList2);
                    } else if (i9 == c.this.cFS) {
                        c.this.a(i8, i9, 1, c.this.cFU, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.cFM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cFR, 12));
                    if (currentItem > c.this.cFM.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cFM.getAdapter().getItemsCount() - 1;
                        c.this.cFM.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.cFR + currentItem;
                    if (i10 == c.this.cFR) {
                        c.this.a(i8, i10, c.this.cFT, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.cFM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.cFS));
                    if (currentItem > c.this.cFM.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cFM.getAdapter().getItemsCount() - 1;
                        c.this.cFM.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.cFS) {
                        c.this.a(i8, i11, 1, c.this.cFU, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.cFM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.cFM.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.cFW != null) {
                    c.this.cFW.atv();
                }
            }
        });
        this.cFM.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void ld(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.cFR + i8) - 1;
                    if (c.this.cFR == c.this.cFS) {
                        c.this.a(c.this.cFV, i9, c.this.cFT, c.this.cFU, asList, asList2);
                    } else if (c.this.cFR == i9) {
                        c.this.a(c.this.cFV, i9, c.this.cFT, 31, asList, asList2);
                    } else if (c.this.cFS == i9) {
                        c.this.a(c.this.cFV, i9, 1, c.this.cFU, asList, asList2);
                    } else {
                        c.this.a(c.this.cFV, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.cFV == c.this.startYear) {
                    int i10 = (c.this.cFR + i8) - 1;
                    if (i10 == c.this.cFR) {
                        c.this.a(c.this.cFV, i10, c.this.cFT, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.cFV, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.cFV == c.this.endYear) {
                    if (i8 == c.this.cFS) {
                        c.this.a(c.this.cFV, c.this.cFM.getCurrentItem() + 1, 1, c.this.cFU, asList, asList2);
                    } else {
                        c.this.a(c.this.cFV, c.this.cFM.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.cFV, i8, 1, 31, asList, asList2);
                }
                if (c.this.cFW != null) {
                    c.this.cFW.atv();
                }
            }
        });
        a(this.cFN);
        a(this.cFO);
        a(this.cFP);
        a(this.cFQ);
        if (this.cEy.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.cFL.setVisibility(this.cEy[0] ? 0 : 8);
        this.cFM.setVisibility(this.cEy[1] ? 0 : 8);
        this.cFN.setVisibility(this.cEy[2] ? 0 : 8);
        this.cFO.setVisibility(this.cEy[3] ? 0 : 8);
        this.cFP.setVisibility(this.cEy[4] ? 0 : 8);
        this.cFQ.setVisibility(this.cEy[5] ? 0 : 8);
        atF();
    }

    private void a(WheelView wheelView) {
        if (this.cFW != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void ld(int i) {
                    c.this.cFW.atv();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.cFN.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.cFN.getAdapter().getItemsCount() - 1) {
            this.cFN.setCurrentItem(this.cFN.getAdapter().getItemsCount() - 1);
        }
    }

    private void atF() {
        this.cFN.setTextSize(this.textSize);
        this.cFM.setTextSize(this.textSize);
        this.cFL.setTextSize(this.textSize);
        this.cFO.setTextSize(this.textSize);
        this.cFP.setTextSize(this.textSize);
        this.cFQ.setTextSize(this.textSize);
    }

    private void atG() {
        this.cFN.setTextColorOut(this.cFd);
        this.cFM.setTextColorOut(this.cFd);
        this.cFL.setTextColorOut(this.cFd);
        this.cFO.setTextColorOut(this.cFd);
        this.cFP.setTextColorOut(this.cFd);
        this.cFQ.setTextColorOut(this.cFd);
    }

    private void atH() {
        this.cFN.setTextColorCenter(this.cFe);
        this.cFM.setTextColorCenter(this.cFe);
        this.cFL.setTextColorCenter(this.cFe);
        this.cFO.setTextColorCenter(this.cFe);
        this.cFP.setTextColorCenter(this.cFe);
        this.cFQ.setTextColorCenter(this.cFe);
    }

    private void atI() {
        this.cFN.setDividerColor(this.cFf);
        this.cFM.setDividerColor(this.cFf);
        this.cFL.setDividerColor(this.cFf);
        this.cFO.setDividerColor(this.cFf);
        this.cFP.setDividerColor(this.cFf);
        this.cFQ.setDividerColor(this.cFf);
    }

    private void atJ() {
        this.cFN.setDividerType(this.cFl);
        this.cFM.setDividerType(this.cFl);
        this.cFL.setDividerType(this.cFl);
        this.cFO.setDividerType(this.cFl);
        this.cFP.setDividerType(this.cFl);
        this.cFQ.setDividerType(this.cFl);
    }

    private void atK() {
        this.cFN.setLineSpacingMultiplier(this.cFg);
        this.cFM.setLineSpacingMultiplier(this.cFg);
        this.cFL.setLineSpacingMultiplier(this.cFg);
        this.cFO.setLineSpacingMultiplier(this.cFg);
        this.cFP.setLineSpacingMultiplier(this.cFg);
        this.cFQ.setLineSpacingMultiplier(this.cFg);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.cED) {
            if (str != null) {
                this.cFL.setLabel(str);
            } else {
                this.cFL.setLabel(this.view.getContext().getString(d.j.pickerview_year));
            }
            if (str2 != null) {
                this.cFM.setLabel(str2);
            } else {
                this.cFM.setLabel(this.view.getContext().getString(d.j.pickerview_month));
            }
            if (str3 != null) {
                this.cFN.setLabel(str3);
            } else {
                this.cFN.setLabel(this.view.getContext().getString(d.j.pickerview_day));
            }
            if (str4 != null) {
                this.cFO.setLabel(str4);
            } else {
                this.cFO.setLabel(this.view.getContext().getString(d.j.pickerview_hours));
            }
            if (str5 != null) {
                this.cFP.setLabel(str5);
            } else {
                this.cFP.setLabel(this.view.getContext().getString(d.j.pickerview_minutes));
            }
            if (str6 != null) {
                this.cFQ.setLabel(str6);
            } else {
                this.cFQ.setLabel(this.view.getContext().getString(d.j.pickerview_seconds));
            }
        }
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cFN.setTextXOffset(i);
        this.cFM.setTextXOffset(i2);
        this.cFL.setTextXOffset(i3);
        this.cFO.setTextXOffset(i4);
        this.cFP.setTextXOffset(i5);
        this.cFQ.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.cFL.setCyclic(z);
        this.cFM.setCyclic(z);
        this.cFN.setCyclic(z);
        this.cFO.setCyclic(z);
        this.cFP.setCyclic(z);
        this.cFQ.setCyclic(z);
    }

    public String getTime() {
        if (this.cED) {
            return atL();
        }
        StringBuilder sb = new StringBuilder();
        if (this.cFV == this.startYear) {
            if (this.cFM.getCurrentItem() + this.cFR == this.cFR) {
                sb.append(this.cFL.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFM.getCurrentItem() + this.cFR).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFN.getCurrentItem() + this.cFT).append(" ").append(this.cFO.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFP.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFQ.getCurrentItem());
            } else {
                sb.append(this.cFL.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFM.getCurrentItem() + this.cFR).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFN.getCurrentItem() + 1).append(" ").append(this.cFO.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFP.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFQ.getCurrentItem());
            }
        } else {
            sb.append(this.cFL.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFM.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFN.getCurrentItem() + 1).append(" ").append(this.cFO.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFP.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFQ.getCurrentItem());
        }
        return sb.toString();
    }

    private String atL() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.cFL.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.kX(currentItem2) == 0) {
            currentItem = this.cFM.getCurrentItem() + 1;
            z = false;
        } else if ((this.cFM.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.kX(currentItem2) <= 0) {
            currentItem = this.cFM.getCurrentItem() + 1;
            z = false;
        } else if ((this.cFM.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.kX(currentItem2) == 1) {
            currentItem = this.cFM.getCurrentItem();
            z = true;
        } else {
            currentItem = this.cFM.getCurrentItem();
            z = false;
        }
        int[] e = com.baidu.tbadk.widget.timepicker.a.e.b.e(currentItem2, currentItem, this.cFN.getCurrentItem() + 1, z);
        sb.append(e[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[2]).append(" ").append(this.cFO.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFP.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFQ.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void lc(int i) {
        this.endYear = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.startYear) {
                this.endYear = i;
                this.cFS = i2;
                this.cFU = i3;
            } else if (i == this.startYear) {
                if (i2 > this.cFR) {
                    this.endYear = i;
                    this.cFS = i2;
                    this.cFU = i3;
                } else if (i2 == this.cFR && i3 > this.cFT) {
                    this.endYear = i;
                    this.cFS = i2;
                    this.cFU = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.cFR = i5;
                this.cFT = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.cFS) {
                    this.cFR = i5;
                    this.cFT = i6;
                    this.startYear = i4;
                } else if (i5 == this.cFS && i6 < this.cFU) {
                    this.cFR = i5;
                    this.cFT = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.cFR = calendar.get(2) + 1;
            this.cFS = calendar2.get(2) + 1;
            this.cFT = calendar.get(5);
            this.cFU = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.cFg = f;
        atK();
    }

    public void setDividerColor(int i) {
        this.cFf = i;
        atI();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.cFl = dividerType;
        atJ();
    }

    public void setTextColorCenter(int i) {
        this.cFe = i;
        atH();
    }

    public void setTextColorOut(int i) {
        this.cFd = i;
        atG();
    }

    public void fz(boolean z) {
        this.cFN.fz(z);
        this.cFM.fz(z);
        this.cFL.fz(z);
        this.cFO.fz(z);
        this.cFP.fz(z);
        this.cFQ.fz(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.cFW = bVar;
    }
}
