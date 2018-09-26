package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class c {
    public static DateFormat bly = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int bkR;
    private int bkS;
    private int bkT;
    private float bkU;
    private WheelView.DividerType bkZ;
    private boolean[] bkm;
    private WheelView blA;
    private WheelView blB;
    private WheelView blC;
    private WheelView blD;
    private WheelView blE;
    private int blJ;
    private com.baidu.tbadk.widget.timepicker.a.d.b blK;
    private WheelView blz;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = 1900;
    private int endYear = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int blF = 1;
    private int blG = 12;
    private int blH = 1;
    private int blI = 31;
    private boolean bkr = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.bkm = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void cE(boolean z) {
        this.bkr = z;
    }

    public void e(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.bkr) {
            int[] v = com.baidu.tbadk.widget.timepicker.a.e.b.v(i, i2 + 1, i3);
            a(v[0], v[1] - 1, v[2], v[3] == 1, i4, i5, i6);
            return;
        }
        f(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.blz = (WheelView) this.view.findViewById(e.g.year);
        this.blz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.V(this.startYear, this.endYear)));
        this.blz.setLabel("");
        this.blz.setCurrentItem(i - this.startYear);
        this.blz.setGravity(this.gravity);
        this.blA = (WheelView) this.view.findViewById(e.g.month);
        this.blA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gz(i)));
        this.blA.setLabel("");
        int gw = com.baidu.tbadk.widget.timepicker.a.e.a.gw(i);
        if (gw != 0 && (i2 > gw - 1 || z)) {
            this.blA.setCurrentItem(i2 + 1);
        } else {
            this.blA.setCurrentItem(i2);
        }
        this.blA.setGravity(this.gravity);
        this.blB = (WheelView) this.view.findViewById(e.g.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.gw(i) == 0) {
            this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gA(com.baidu.tbadk.widget.timepicker.a.e.a.U(i, i2))));
        } else {
            this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gA(com.baidu.tbadk.widget.timepicker.a.e.a.gv(i))));
        }
        this.blB.setLabel("");
        this.blB.setCurrentItem(i3 - 1);
        this.blB.setGravity(this.gravity);
        this.blC = (WheelView) this.view.findViewById(e.g.hour);
        this.blC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.blC.setCurrentItem(i4);
        this.blC.setGravity(this.gravity);
        this.blD = (WheelView) this.view.findViewById(e.g.min);
        this.blD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.blD.setCurrentItem(i5);
        this.blD.setGravity(this.gravity);
        this.blE = (WheelView) this.view.findViewById(e.g.second);
        this.blE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.blE.setCurrentItem(i5);
        this.blE.setGravity(this.gravity);
        this.blz.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gC(int i7) {
                int U;
                int i8 = c.this.startYear + i7;
                c.this.blA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gz(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.gw(i8) == 0 || c.this.blA.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.gw(i8) - 1) {
                    c.this.blA.setCurrentItem(c.this.blA.getCurrentItem());
                } else {
                    c.this.blA.setCurrentItem(c.this.blA.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.gw(i8) == 0 || c.this.blA.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.gw(i8) - 1) {
                    c.this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gA(com.baidu.tbadk.widget.timepicker.a.e.a.U(i8, c.this.blA.getCurrentItem() + 1))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.U(i8, c.this.blA.getCurrentItem() + 1);
                } else if (c.this.blA.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.gw(i8) + 1) {
                    c.this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gA(com.baidu.tbadk.widget.timepicker.a.e.a.gv(i8))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.gv(i8);
                } else {
                    c.this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gA(com.baidu.tbadk.widget.timepicker.a.e.a.U(i8, c.this.blA.getCurrentItem()))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.U(i8, c.this.blA.getCurrentItem());
                }
                if (c.this.blB.getCurrentItem() > U - 1) {
                    c.this.blB.setCurrentItem(U - 1);
                }
                if (c.this.blK != null) {
                    c.this.blK.PO();
                }
            }
        });
        this.blA.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gC(int i7) {
                int U;
                int currentItem = c.this.blz.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.gw(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.gw(currentItem) - 1) {
                    c.this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gA(com.baidu.tbadk.widget.timepicker.a.e.a.U(currentItem, i7 + 1))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.U(currentItem, i7 + 1);
                } else if (c.this.blA.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.gw(currentItem) + 1) {
                    c.this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gA(com.baidu.tbadk.widget.timepicker.a.e.a.gv(currentItem))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.gv(currentItem);
                } else {
                    c.this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gA(com.baidu.tbadk.widget.timepicker.a.e.a.U(currentItem, i7))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.U(currentItem, i7);
                }
                if (c.this.blB.getCurrentItem() > U - 1) {
                    c.this.blB.setCurrentItem(U - 1);
                }
                if (c.this.blK != null) {
                    c.this.blK.PO();
                }
            }
        });
        a(this.blB);
        a(this.blC);
        a(this.blD);
        a(this.blE);
        if (this.bkm.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.blz.setVisibility(this.bkm[0] ? 0 : 8);
        this.blA.setVisibility(this.bkm[1] ? 0 : 8);
        this.blB.setVisibility(this.bkm[2] ? 0 : 8);
        this.blC.setVisibility(this.bkm[3] ? 0 : 8);
        this.blD.setVisibility(this.bkm[4] ? 0 : 8);
        this.blE.setVisibility(this.bkm[5] ? 0 : 8);
        PZ();
    }

    private void f(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.blJ = i;
        this.blz = (WheelView) this.view.findViewById(e.g.year);
        this.blz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.blz.setCurrentItem(i - this.startYear);
        this.blz.setGravity(this.gravity);
        this.blA = (WheelView) this.view.findViewById(e.g.month);
        if (this.startYear == this.endYear) {
            this.blA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.blF, this.blG));
            this.blA.setCurrentItem((i2 + 1) - this.blF);
        } else if (i == this.startYear) {
            this.blA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.blF, 12));
            this.blA.setCurrentItem((i2 + 1) - this.blF);
        } else if (i == this.endYear) {
            this.blA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.blG));
            this.blA.setCurrentItem(i2);
        } else {
            this.blA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.blA.setCurrentItem(i2);
        }
        this.blA.setGravity(this.gravity);
        this.blB = (WheelView) this.view.findViewById(e.g.day);
        if (this.startYear == this.endYear && this.blF == this.blG) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.blI > 31) {
                    this.blI = 31;
                }
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.blH, this.blI));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.blI > 30) {
                    this.blI = 30;
                }
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.blH, this.blI));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % HttpStatus.SC_BAD_REQUEST == 0) {
                if (this.blI > 29) {
                    this.blI = 29;
                }
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.blH, this.blI));
            } else {
                if (this.blI > 28) {
                    this.blI = 28;
                }
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.blH, this.blI));
            }
            this.blB.setCurrentItem(i3 - this.blH);
        } else if (i == this.startYear && i2 + 1 == this.blF) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.blH, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.blH, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % HttpStatus.SC_BAD_REQUEST == 0) {
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.blH, 29));
            } else {
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.blH, 28));
            }
            this.blB.setCurrentItem(i3 - this.blH);
        } else if (i == this.endYear && i2 + 1 == this.blG) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.blI > 31) {
                    this.blI = 31;
                }
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.blI));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.blI > 30) {
                    this.blI = 30;
                }
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.blI));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % HttpStatus.SC_BAD_REQUEST == 0) {
                if (this.blI > 29) {
                    this.blI = 29;
                }
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.blI));
            } else {
                if (this.blI > 28) {
                    this.blI = 28;
                }
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.blI));
            }
            this.blB.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % HttpStatus.SC_BAD_REQUEST == 0) {
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.blB.setCurrentItem(i3 - 1);
        }
        this.blB.setGravity(this.gravity);
        this.blC = (WheelView) this.view.findViewById(e.g.hour);
        this.blC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.blC.setCurrentItem(i4);
        this.blC.setGravity(this.gravity);
        this.blD = (WheelView) this.view.findViewById(e.g.min);
        this.blD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.blD.setCurrentItem(i5);
        this.blD.setGravity(this.gravity);
        this.blE = (WheelView) this.view.findViewById(e.g.second);
        this.blE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.blE.setCurrentItem(i6);
        this.blE.setGravity(this.gravity);
        this.blz.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gC(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.blJ = i8;
                int currentItem = c.this.blA.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.blA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.blF, c.this.blG));
                    if (currentItem > c.this.blA.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.blA.getAdapter().getItemsCount() - 1;
                        c.this.blA.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.blF + currentItem;
                    if (c.this.blF == c.this.blG) {
                        c.this.a(i8, i9, c.this.blH, c.this.blI, asList, asList2);
                    } else if (i9 == c.this.blF) {
                        c.this.a(i8, i9, c.this.blH, 31, asList, asList2);
                    } else if (i9 == c.this.blG) {
                        c.this.a(i8, i9, 1, c.this.blI, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.blA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.blF, 12));
                    if (currentItem > c.this.blA.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.blA.getAdapter().getItemsCount() - 1;
                        c.this.blA.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.blF + currentItem;
                    if (i10 == c.this.blF) {
                        c.this.a(i8, i10, c.this.blH, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.blA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.blG));
                    if (currentItem > c.this.blA.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.blA.getAdapter().getItemsCount() - 1;
                        c.this.blA.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.blG) {
                        c.this.a(i8, i11, 1, c.this.blI, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.blA.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.blA.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.blK != null) {
                    c.this.blK.PO();
                }
            }
        });
        this.blA.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gC(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.blF + i8) - 1;
                    if (c.this.blF == c.this.blG) {
                        c.this.a(c.this.blJ, i9, c.this.blH, c.this.blI, asList, asList2);
                    } else if (c.this.blF == i9) {
                        c.this.a(c.this.blJ, i9, c.this.blH, 31, asList, asList2);
                    } else if (c.this.blG == i9) {
                        c.this.a(c.this.blJ, i9, 1, c.this.blI, asList, asList2);
                    } else {
                        c.this.a(c.this.blJ, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.blJ == c.this.startYear) {
                    int i10 = (c.this.blF + i8) - 1;
                    if (i10 == c.this.blF) {
                        c.this.a(c.this.blJ, i10, c.this.blH, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.blJ, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.blJ == c.this.endYear) {
                    if (i8 == c.this.blG) {
                        c.this.a(c.this.blJ, c.this.blA.getCurrentItem() + 1, 1, c.this.blI, asList, asList2);
                    } else {
                        c.this.a(c.this.blJ, c.this.blA.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.blJ, i8, 1, 31, asList, asList2);
                }
                if (c.this.blK != null) {
                    c.this.blK.PO();
                }
            }
        });
        a(this.blB);
        a(this.blC);
        a(this.blD);
        a(this.blE);
        if (this.bkm.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.blz.setVisibility(this.bkm[0] ? 0 : 8);
        this.blA.setVisibility(this.bkm[1] ? 0 : 8);
        this.blB.setVisibility(this.bkm[2] ? 0 : 8);
        this.blC.setVisibility(this.bkm[3] ? 0 : 8);
        this.blD.setVisibility(this.bkm[4] ? 0 : 8);
        this.blE.setVisibility(this.bkm[5] ? 0 : 8);
        PZ();
    }

    private void a(WheelView wheelView) {
        if (this.blK != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void gC(int i) {
                    c.this.blK.PO();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.blB.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % HttpStatus.SC_BAD_REQUEST == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.blB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.blB.getAdapter().getItemsCount() - 1) {
            this.blB.setCurrentItem(this.blB.getAdapter().getItemsCount() - 1);
        }
    }

    private void PZ() {
        this.blB.setTextSize(this.textSize);
        this.blA.setTextSize(this.textSize);
        this.blz.setTextSize(this.textSize);
        this.blC.setTextSize(this.textSize);
        this.blD.setTextSize(this.textSize);
        this.blE.setTextSize(this.textSize);
    }

    private void Qa() {
        this.blB.setTextColorOut(this.bkR);
        this.blA.setTextColorOut(this.bkR);
        this.blz.setTextColorOut(this.bkR);
        this.blC.setTextColorOut(this.bkR);
        this.blD.setTextColorOut(this.bkR);
        this.blE.setTextColorOut(this.bkR);
    }

    private void Qb() {
        this.blB.setTextColorCenter(this.bkS);
        this.blA.setTextColorCenter(this.bkS);
        this.blz.setTextColorCenter(this.bkS);
        this.blC.setTextColorCenter(this.bkS);
        this.blD.setTextColorCenter(this.bkS);
        this.blE.setTextColorCenter(this.bkS);
    }

    private void Qc() {
        this.blB.setDividerColor(this.bkT);
        this.blA.setDividerColor(this.bkT);
        this.blz.setDividerColor(this.bkT);
        this.blC.setDividerColor(this.bkT);
        this.blD.setDividerColor(this.bkT);
        this.blE.setDividerColor(this.bkT);
    }

    private void Qd() {
        this.blB.setDividerType(this.bkZ);
        this.blA.setDividerType(this.bkZ);
        this.blz.setDividerType(this.bkZ);
        this.blC.setDividerType(this.bkZ);
        this.blD.setDividerType(this.bkZ);
        this.blE.setDividerType(this.bkZ);
    }

    private void Qe() {
        this.blB.setLineSpacingMultiplier(this.bkU);
        this.blA.setLineSpacingMultiplier(this.bkU);
        this.blz.setLineSpacingMultiplier(this.bkU);
        this.blC.setLineSpacingMultiplier(this.bkU);
        this.blD.setLineSpacingMultiplier(this.bkU);
        this.blE.setLineSpacingMultiplier(this.bkU);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.bkr) {
            if (str != null) {
                this.blz.setLabel(str);
            } else {
                this.blz.setLabel(this.view.getContext().getString(e.j.pickerview_year));
            }
            if (str2 != null) {
                this.blA.setLabel(str2);
            } else {
                this.blA.setLabel(this.view.getContext().getString(e.j.pickerview_month));
            }
            if (str3 != null) {
                this.blB.setLabel(str3);
            } else {
                this.blB.setLabel(this.view.getContext().getString(e.j.pickerview_day));
            }
            if (str4 != null) {
                this.blC.setLabel(str4);
            } else {
                this.blC.setLabel(this.view.getContext().getString(e.j.pickerview_hours));
            }
            if (str5 != null) {
                this.blD.setLabel(str5);
            } else {
                this.blD.setLabel(this.view.getContext().getString(e.j.pickerview_minutes));
            }
            if (str6 != null) {
                this.blE.setLabel(str6);
            } else {
                this.blE.setLabel(this.view.getContext().getString(e.j.pickerview_seconds));
            }
        }
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.blB.setTextXOffset(i);
        this.blA.setTextXOffset(i2);
        this.blz.setTextXOffset(i3);
        this.blC.setTextXOffset(i4);
        this.blD.setTextXOffset(i5);
        this.blE.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.blz.setCyclic(z);
        this.blA.setCyclic(z);
        this.blB.setCyclic(z);
        this.blC.setCyclic(z);
        this.blD.setCyclic(z);
        this.blE.setCyclic(z);
    }

    public String getTime() {
        if (this.bkr) {
            return Qf();
        }
        StringBuilder sb = new StringBuilder();
        if (this.blJ == this.startYear) {
            if (this.blA.getCurrentItem() + this.blF == this.blF) {
                sb.append(this.blz.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.blA.getCurrentItem() + this.blF).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.blB.getCurrentItem() + this.blH).append(" ").append(this.blC.getCurrentItem()).append(":").append(this.blD.getCurrentItem()).append(":").append(this.blE.getCurrentItem());
            } else {
                sb.append(this.blz.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.blA.getCurrentItem() + this.blF).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.blB.getCurrentItem() + 1).append(" ").append(this.blC.getCurrentItem()).append(":").append(this.blD.getCurrentItem()).append(":").append(this.blE.getCurrentItem());
            }
        } else {
            sb.append(this.blz.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.blA.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.blB.getCurrentItem() + 1).append(" ").append(this.blC.getCurrentItem()).append(":").append(this.blD.getCurrentItem()).append(":").append(this.blE.getCurrentItem());
        }
        return sb.toString();
    }

    private String Qf() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.blz.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.gw(currentItem2) == 0) {
            currentItem = this.blA.getCurrentItem() + 1;
            z = false;
        } else if ((this.blA.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.gw(currentItem2) <= 0) {
            currentItem = this.blA.getCurrentItem() + 1;
            z = false;
        } else if ((this.blA.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.gw(currentItem2) == 1) {
            currentItem = this.blA.getCurrentItem();
            z = true;
        } else {
            currentItem = this.blA.getCurrentItem();
            z = false;
        }
        int[] b = com.baidu.tbadk.widget.timepicker.a.e.b.b(currentItem2, currentItem, this.blB.getCurrentItem() + 1, z);
        sb.append(b[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[2]).append(" ").append(this.blC.getCurrentItem()).append(":").append(this.blD.getCurrentItem()).append(":").append(this.blE.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void gB(int i) {
        this.endYear = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.startYear) {
                this.endYear = i;
                this.blG = i2;
                this.blI = i3;
            } else if (i == this.startYear) {
                if (i2 > this.blF) {
                    this.endYear = i;
                    this.blG = i2;
                    this.blI = i3;
                } else if (i2 == this.blF && i3 > this.blH) {
                    this.endYear = i;
                    this.blG = i2;
                    this.blI = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.blF = i5;
                this.blH = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.blG) {
                    this.blF = i5;
                    this.blH = i6;
                    this.startYear = i4;
                } else if (i5 == this.blG && i6 < this.blI) {
                    this.blF = i5;
                    this.blH = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.blF = calendar.get(2) + 1;
            this.blG = calendar2.get(2) + 1;
            this.blH = calendar.get(5);
            this.blI = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.bkU = f;
        Qe();
    }

    public void setDividerColor(int i) {
        this.bkT = i;
        Qc();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.bkZ = dividerType;
        Qd();
    }

    public void setTextColorCenter(int i) {
        this.bkS = i;
        Qb();
    }

    public void setTextColorOut(int i) {
        this.bkR = i;
        Qa();
    }

    public void cF(boolean z) {
        this.blB.cF(z);
        this.blA.cF(z);
        this.blz.cF(z);
        this.blC.cF(z);
        this.blD.cF(z);
        this.blE.cF(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.blK = bVar;
    }
}
