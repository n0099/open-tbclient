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
    public static DateFormat cNX = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private boolean[] cML;
    private WheelView cNY;
    private WheelView cNZ;
    private int cNq;
    private int cNr;
    private int cNs;
    private float cNt;
    private WheelView.DividerType cNy;
    private WheelView cOa;
    private WheelView cOb;
    private WheelView cOc;
    private WheelView cOd;
    private int cOi;
    private com.baidu.tbadk.widget.timepicker.a.d.b cOj;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = 1900;
    private int endYear = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int cOe = 1;
    private int cOf = 12;
    private int cOg = 1;
    private int cOh = 31;
    private boolean cMQ = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.cML = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void fV(boolean z) {
        this.cMQ = z;
    }

    public void f(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.cMQ) {
            int[] z = com.baidu.tbadk.widget.timepicker.a.e.b.z(i, i2 + 1, i3);
            a(z[0], z[1] - 1, z[2], z[3] == 1, i4, i5, i6);
            return;
        }
        g(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.cNY = (WheelView) this.view.findViewById(R.id.year);
        this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.av(this.startYear, this.endYear)));
        this.cNY.setLabel("");
        this.cNY.setCurrentItem(i - this.startYear);
        this.cNY.setGravity(this.gravity);
        this.cNZ = (WheelView) this.view.findViewById(R.id.month);
        this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lO(i)));
        this.cNZ.setLabel("");
        int lL = com.baidu.tbadk.widget.timepicker.a.e.a.lL(i);
        if (lL != 0 && (i2 > lL - 1 || z)) {
            this.cNZ.setCurrentItem(i2 + 1);
        } else {
            this.cNZ.setCurrentItem(i2);
        }
        this.cNZ.setGravity(this.gravity);
        this.cOa = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lL(i) == 0) {
            this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.au(i, i2))));
        } else {
            this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.lK(i))));
        }
        this.cOa.setLabel("");
        this.cOa.setCurrentItem(i3 - 1);
        this.cOa.setGravity(this.gravity);
        this.cOb = (WheelView) this.view.findViewById(R.id.hour);
        this.cOb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cOb.setCurrentItem(i4);
        this.cOb.setGravity(this.gravity);
        this.cOc = (WheelView) this.view.findViewById(R.id.min);
        this.cOc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cOc.setCurrentItem(i5);
        this.cOc.setGravity(this.gravity);
        this.cOd = (WheelView) this.view.findViewById(R.id.second);
        this.cOd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cOd.setCurrentItem(i5);
        this.cOd.setGravity(this.gravity);
        this.cNY.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lR(int i7) {
                int au;
                int i8 = c.this.startYear + i7;
                c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lO(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lL(i8) == 0 || c.this.cNZ.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lL(i8) - 1) {
                    c.this.cNZ.setCurrentItem(c.this.cNZ.getCurrentItem());
                } else {
                    c.this.cNZ.setCurrentItem(c.this.cNZ.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lL(i8) == 0 || c.this.cNZ.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lL(i8) - 1) {
                    c.this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cNZ.getCurrentItem() + 1))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cNZ.getCurrentItem() + 1);
                } else if (c.this.cNZ.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lL(i8) + 1) {
                    c.this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.lK(i8))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.lK(i8);
                } else {
                    c.this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cNZ.getCurrentItem()))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cNZ.getCurrentItem());
                }
                if (c.this.cOa.getCurrentItem() > au - 1) {
                    c.this.cOa.setCurrentItem(au - 1);
                }
                if (c.this.cOj != null) {
                    c.this.cOj.ayy();
                }
            }
        });
        this.cNZ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lR(int i7) {
                int au;
                int currentItem = c.this.cNY.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem) - 1) {
                    c.this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7 + 1))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7 + 1);
                } else if (c.this.cNZ.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem) + 1) {
                    c.this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.lK(currentItem))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.lK(currentItem);
                } else {
                    c.this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lP(com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7);
                }
                if (c.this.cOa.getCurrentItem() > au - 1) {
                    c.this.cOa.setCurrentItem(au - 1);
                }
                if (c.this.cOj != null) {
                    c.this.cOj.ayy();
                }
            }
        });
        a(this.cOa);
        a(this.cOb);
        a(this.cOc);
        a(this.cOd);
        if (this.cML.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.cNY.setVisibility(this.cML[0] ? 0 : 8);
        this.cNZ.setVisibility(this.cML[1] ? 0 : 8);
        this.cOa.setVisibility(this.cML[2] ? 0 : 8);
        this.cOb.setVisibility(this.cML[3] ? 0 : 8);
        this.cOc.setVisibility(this.cML[4] ? 0 : 8);
        this.cOd.setVisibility(this.cML[5] ? 0 : 8);
        ayI();
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.cOi = i;
        this.cNY = (WheelView) this.view.findViewById(R.id.year);
        this.cNY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.cNY.setCurrentItem(i - this.startYear);
        this.cNY.setGravity(this.gravity);
        this.cNZ = (WheelView) this.view.findViewById(R.id.month);
        if (this.startYear == this.endYear) {
            this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOe, this.cOf));
            this.cNZ.setCurrentItem((i2 + 1) - this.cOe);
        } else if (i == this.startYear) {
            this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOe, 12));
            this.cNZ.setCurrentItem((i2 + 1) - this.cOe);
        } else if (i == this.endYear) {
            this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cOf));
            this.cNZ.setCurrentItem(i2);
        } else {
            this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.cNZ.setCurrentItem(i2);
        }
        this.cNZ.setGravity(this.gravity);
        this.cOa = (WheelView) this.view.findViewById(R.id.day);
        if (this.startYear == this.endYear && this.cOe == this.cOf) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cOh > 31) {
                    this.cOh = 31;
                }
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOg, this.cOh));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cOh > 30) {
                    this.cOh = 30;
                }
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOg, this.cOh));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cOh > 29) {
                    this.cOh = 29;
                }
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOg, this.cOh));
            } else {
                if (this.cOh > 28) {
                    this.cOh = 28;
                }
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOg, this.cOh));
            }
            this.cOa.setCurrentItem(i3 - this.cOg);
        } else if (i == this.startYear && i2 + 1 == this.cOe) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOg, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOg, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOg, 29));
            } else {
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOg, 28));
            }
            this.cOa.setCurrentItem(i3 - this.cOg);
        } else if (i == this.endYear && i2 + 1 == this.cOf) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cOh > 31) {
                    this.cOh = 31;
                }
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cOh));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cOh > 30) {
                    this.cOh = 30;
                }
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cOh));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cOh > 29) {
                    this.cOh = 29;
                }
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cOh));
            } else {
                if (this.cOh > 28) {
                    this.cOh = 28;
                }
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cOh));
            }
            this.cOa.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.cOa.setCurrentItem(i3 - 1);
        }
        this.cOa.setGravity(this.gravity);
        this.cOb = (WheelView) this.view.findViewById(R.id.hour);
        this.cOb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cOb.setCurrentItem(i4);
        this.cOb.setGravity(this.gravity);
        this.cOc = (WheelView) this.view.findViewById(R.id.min);
        this.cOc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cOc.setCurrentItem(i5);
        this.cOc.setGravity(this.gravity);
        this.cOd = (WheelView) this.view.findViewById(R.id.second);
        this.cOd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cOd.setCurrentItem(i6);
        this.cOd.setGravity(this.gravity);
        this.cNY.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lR(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.cOi = i8;
                int currentItem = c.this.cNZ.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cOe, c.this.cOf));
                    if (currentItem > c.this.cNZ.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cNZ.getAdapter().getItemsCount() - 1;
                        c.this.cNZ.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.cOe + currentItem;
                    if (c.this.cOe == c.this.cOf) {
                        c.this.a(i8, i9, c.this.cOg, c.this.cOh, asList, asList2);
                    } else if (i9 == c.this.cOe) {
                        c.this.a(i8, i9, c.this.cOg, 31, asList, asList2);
                    } else if (i9 == c.this.cOf) {
                        c.this.a(i8, i9, 1, c.this.cOh, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cOe, 12));
                    if (currentItem > c.this.cNZ.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cNZ.getAdapter().getItemsCount() - 1;
                        c.this.cNZ.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.cOe + currentItem;
                    if (i10 == c.this.cOe) {
                        c.this.a(i8, i10, c.this.cOg, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.cOf));
                    if (currentItem > c.this.cNZ.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cNZ.getAdapter().getItemsCount() - 1;
                        c.this.cNZ.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.cOf) {
                        c.this.a(i8, i11, 1, c.this.cOh, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.cNZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.cNZ.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.cOj != null) {
                    c.this.cOj.ayy();
                }
            }
        });
        this.cNZ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lR(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.cOe + i8) - 1;
                    if (c.this.cOe == c.this.cOf) {
                        c.this.a(c.this.cOi, i9, c.this.cOg, c.this.cOh, asList, asList2);
                    } else if (c.this.cOe == i9) {
                        c.this.a(c.this.cOi, i9, c.this.cOg, 31, asList, asList2);
                    } else if (c.this.cOf == i9) {
                        c.this.a(c.this.cOi, i9, 1, c.this.cOh, asList, asList2);
                    } else {
                        c.this.a(c.this.cOi, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.cOi == c.this.startYear) {
                    int i10 = (c.this.cOe + i8) - 1;
                    if (i10 == c.this.cOe) {
                        c.this.a(c.this.cOi, i10, c.this.cOg, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.cOi, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.cOi == c.this.endYear) {
                    if (i8 == c.this.cOf) {
                        c.this.a(c.this.cOi, c.this.cNZ.getCurrentItem() + 1, 1, c.this.cOh, asList, asList2);
                    } else {
                        c.this.a(c.this.cOi, c.this.cNZ.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.cOi, i8, 1, 31, asList, asList2);
                }
                if (c.this.cOj != null) {
                    c.this.cOj.ayy();
                }
            }
        });
        a(this.cOa);
        a(this.cOb);
        a(this.cOc);
        a(this.cOd);
        if (this.cML.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.cNY.setVisibility(this.cML[0] ? 0 : 8);
        this.cNZ.setVisibility(this.cML[1] ? 0 : 8);
        this.cOa.setVisibility(this.cML[2] ? 0 : 8);
        this.cOb.setVisibility(this.cML[3] ? 0 : 8);
        this.cOc.setVisibility(this.cML[4] ? 0 : 8);
        this.cOd.setVisibility(this.cML[5] ? 0 : 8);
        ayI();
    }

    private void a(WheelView wheelView) {
        if (this.cOj != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void lR(int i) {
                    c.this.cOj.ayy();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.cOa.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.cOa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.cOa.getAdapter().getItemsCount() - 1) {
            this.cOa.setCurrentItem(this.cOa.getAdapter().getItemsCount() - 1);
        }
    }

    private void ayI() {
        this.cOa.setTextSize(this.textSize);
        this.cNZ.setTextSize(this.textSize);
        this.cNY.setTextSize(this.textSize);
        this.cOb.setTextSize(this.textSize);
        this.cOc.setTextSize(this.textSize);
        this.cOd.setTextSize(this.textSize);
    }

    private void ayJ() {
        this.cOa.setTextColorOut(this.cNq);
        this.cNZ.setTextColorOut(this.cNq);
        this.cNY.setTextColorOut(this.cNq);
        this.cOb.setTextColorOut(this.cNq);
        this.cOc.setTextColorOut(this.cNq);
        this.cOd.setTextColorOut(this.cNq);
    }

    private void ayK() {
        this.cOa.setTextColorCenter(this.cNr);
        this.cNZ.setTextColorCenter(this.cNr);
        this.cNY.setTextColorCenter(this.cNr);
        this.cOb.setTextColorCenter(this.cNr);
        this.cOc.setTextColorCenter(this.cNr);
        this.cOd.setTextColorCenter(this.cNr);
    }

    private void ayL() {
        this.cOa.setDividerColor(this.cNs);
        this.cNZ.setDividerColor(this.cNs);
        this.cNY.setDividerColor(this.cNs);
        this.cOb.setDividerColor(this.cNs);
        this.cOc.setDividerColor(this.cNs);
        this.cOd.setDividerColor(this.cNs);
    }

    private void ayM() {
        this.cOa.setDividerType(this.cNy);
        this.cNZ.setDividerType(this.cNy);
        this.cNY.setDividerType(this.cNy);
        this.cOb.setDividerType(this.cNy);
        this.cOc.setDividerType(this.cNy);
        this.cOd.setDividerType(this.cNy);
    }

    private void ayN() {
        this.cOa.setLineSpacingMultiplier(this.cNt);
        this.cNZ.setLineSpacingMultiplier(this.cNt);
        this.cNY.setLineSpacingMultiplier(this.cNt);
        this.cOb.setLineSpacingMultiplier(this.cNt);
        this.cOc.setLineSpacingMultiplier(this.cNt);
        this.cOd.setLineSpacingMultiplier(this.cNt);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.cMQ) {
            if (str != null) {
                this.cNY.setLabel(str);
            } else {
                this.cNY.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.cNZ.setLabel(str2);
            } else {
                this.cNZ.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.cOa.setLabel(str3);
            } else {
                this.cOa.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.cOb.setLabel(str4);
            } else {
                this.cOb.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.cOc.setLabel(str5);
            } else {
                this.cOc.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.cOd.setLabel(str6);
            } else {
                this.cOd.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cOa.setTextXOffset(i);
        this.cNZ.setTextXOffset(i2);
        this.cNY.setTextXOffset(i3);
        this.cOb.setTextXOffset(i4);
        this.cOc.setTextXOffset(i5);
        this.cOd.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.cNY.setCyclic(z);
        this.cNZ.setCyclic(z);
        this.cOa.setCyclic(z);
        this.cOb.setCyclic(z);
        this.cOc.setCyclic(z);
        this.cOd.setCyclic(z);
    }

    public String getTime() {
        if (this.cMQ) {
            return ayO();
        }
        StringBuilder sb = new StringBuilder();
        if (this.cOi == this.startYear) {
            if (this.cNZ.getCurrentItem() + this.cOe == this.cOe) {
                sb.append(this.cNY.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cNZ.getCurrentItem() + this.cOe).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cOa.getCurrentItem() + this.cOg).append(" ").append(this.cOb.getCurrentItem()).append(":").append(this.cOc.getCurrentItem()).append(":").append(this.cOd.getCurrentItem());
            } else {
                sb.append(this.cNY.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cNZ.getCurrentItem() + this.cOe).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cOa.getCurrentItem() + 1).append(" ").append(this.cOb.getCurrentItem()).append(":").append(this.cOc.getCurrentItem()).append(":").append(this.cOd.getCurrentItem());
            }
        } else {
            sb.append(this.cNY.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cNZ.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cOa.getCurrentItem() + 1).append(" ").append(this.cOb.getCurrentItem()).append(":").append(this.cOc.getCurrentItem()).append(":").append(this.cOd.getCurrentItem());
        }
        return sb.toString();
    }

    private String ayO() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.cNY.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem2) == 0) {
            currentItem = this.cNZ.getCurrentItem() + 1;
            z = false;
        } else if ((this.cNZ.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem2) <= 0) {
            currentItem = this.cNZ.getCurrentItem() + 1;
            z = false;
        } else if ((this.cNZ.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lL(currentItem2) == 1) {
            currentItem = this.cNZ.getCurrentItem();
            z = true;
        } else {
            currentItem = this.cNZ.getCurrentItem();
            z = false;
        }
        int[] e = com.baidu.tbadk.widget.timepicker.a.e.b.e(currentItem2, currentItem, this.cOa.getCurrentItem() + 1, z);
        sb.append(e[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[2]).append(" ").append(this.cOb.getCurrentItem()).append(":").append(this.cOc.getCurrentItem()).append(":").append(this.cOd.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void lQ(int i) {
        this.endYear = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.startYear) {
                this.endYear = i;
                this.cOf = i2;
                this.cOh = i3;
            } else if (i == this.startYear) {
                if (i2 > this.cOe) {
                    this.endYear = i;
                    this.cOf = i2;
                    this.cOh = i3;
                } else if (i2 == this.cOe && i3 > this.cOg) {
                    this.endYear = i;
                    this.cOf = i2;
                    this.cOh = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.cOe = i5;
                this.cOg = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.cOf) {
                    this.cOe = i5;
                    this.cOg = i6;
                    this.startYear = i4;
                } else if (i5 == this.cOf && i6 < this.cOh) {
                    this.cOe = i5;
                    this.cOg = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.cOe = calendar.get(2) + 1;
            this.cOf = calendar2.get(2) + 1;
            this.cOg = calendar.get(5);
            this.cOh = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.cNt = f;
        ayN();
    }

    public void setDividerColor(int i) {
        this.cNs = i;
        ayL();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.cNy = dividerType;
        ayM();
    }

    public void setTextColorCenter(int i) {
        this.cNr = i;
        ayK();
    }

    public void setTextColorOut(int i) {
        this.cNq = i;
        ayJ();
    }

    public void fW(boolean z) {
        this.cOa.fW(z);
        this.cNZ.fW(z);
        this.cNY.fW(z);
        this.cOb.fW(z);
        this.cOc.fW(z);
        this.cOd.fW(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.cOj = bVar;
    }
}
