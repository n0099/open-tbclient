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
    public static DateFormat cPt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int cOM;
    private int cON;
    private int cOO;
    private float cOP;
    private WheelView.DividerType cOU;
    private boolean[] cOf;
    private int cPE;
    private com.baidu.tbadk.widget.timepicker.a.d.b cPF;
    private WheelView cPu;
    private WheelView cPv;
    private WheelView cPw;
    private WheelView cPx;
    private WheelView cPy;
    private WheelView cPz;
    private int gravity;
    private int textSize;
    private View view;
    private int cOj = 1900;
    private int cOk = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int cPA = 1;
    private int cPB = 12;
    private int cPC = 1;
    private int cPD = 31;
    private boolean cOm = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.cOf = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void fZ(boolean z) {
        this.cOm = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.cOm) {
            int[] z = com.baidu.tbadk.widget.timepicker.a.e.b.z(i, i2 + 1, i3);
            a(z[0], z[1] - 1, z[2], z[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.cPu = (WheelView) this.view.findViewById(R.id.year);
        this.cPu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.az(this.cOj, this.cOk)));
        this.cPu.setLabel("");
        this.cPu.setCurrentItem(i - this.cOj);
        this.cPu.setGravity(this.gravity);
        this.cPv = (WheelView) this.view.findViewById(R.id.month);
        this.cPv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lU(i)));
        this.cPv.setLabel("");
        int lR = com.baidu.tbadk.widget.timepicker.a.e.a.lR(i);
        if (lR != 0 && (i2 > lR - 1 || z)) {
            this.cPv.setCurrentItem(i2 + 1);
        } else {
            this.cPv.setCurrentItem(i2);
        }
        this.cPv.setGravity(this.gravity);
        this.cPw = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lR(i) == 0) {
            this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lV(com.baidu.tbadk.widget.timepicker.a.e.a.ay(i, i2))));
        } else {
            this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lV(com.baidu.tbadk.widget.timepicker.a.e.a.lQ(i))));
        }
        this.cPw.setLabel("");
        this.cPw.setCurrentItem(i3 - 1);
        this.cPw.setGravity(this.gravity);
        this.cPx = (WheelView) this.view.findViewById(R.id.hour);
        this.cPx.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cPx.setCurrentItem(i4);
        this.cPx.setGravity(this.gravity);
        this.cPy = (WheelView) this.view.findViewById(R.id.min);
        this.cPy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cPy.setCurrentItem(i5);
        this.cPy.setGravity(this.gravity);
        this.cPz = (WheelView) this.view.findViewById(R.id.second);
        this.cPz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cPz.setCurrentItem(i5);
        this.cPz.setGravity(this.gravity);
        this.cPu.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lY(int i7) {
                int ay;
                int i8 = c.this.cOj + i7;
                c.this.cPv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lU(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lR(i8) == 0 || c.this.cPv.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lR(i8) - 1) {
                    c.this.cPv.setCurrentItem(c.this.cPv.getCurrentItem());
                } else {
                    c.this.cPv.setCurrentItem(c.this.cPv.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lR(i8) == 0 || c.this.cPv.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lR(i8) - 1) {
                    c.this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lV(com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cPv.getCurrentItem() + 1))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cPv.getCurrentItem() + 1);
                } else if (c.this.cPv.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lR(i8) + 1) {
                    c.this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lV(com.baidu.tbadk.widget.timepicker.a.e.a.lQ(i8))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.lQ(i8);
                } else {
                    c.this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lV(com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cPv.getCurrentItem()))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cPv.getCurrentItem());
                }
                if (c.this.cPw.getCurrentItem() > ay - 1) {
                    c.this.cPw.setCurrentItem(ay - 1);
                }
                if (c.this.cPF != null) {
                    c.this.cPF.azK();
                }
            }
        });
        this.cPv.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lY(int i7) {
                int ay;
                int currentItem = c.this.cPu.getCurrentItem() + c.this.cOj;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lR(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.lR(currentItem) - 1) {
                    c.this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lV(com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7 + 1))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7 + 1);
                } else if (c.this.cPv.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lR(currentItem) + 1) {
                    c.this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lV(com.baidu.tbadk.widget.timepicker.a.e.a.lQ(currentItem))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.lQ(currentItem);
                } else {
                    c.this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lV(com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7);
                }
                if (c.this.cPw.getCurrentItem() > ay - 1) {
                    c.this.cPw.setCurrentItem(ay - 1);
                }
                if (c.this.cPF != null) {
                    c.this.cPF.azK();
                }
            }
        });
        a(this.cPw);
        a(this.cPx);
        a(this.cPy);
        a(this.cPz);
        if (this.cOf.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.cPu.setVisibility(this.cOf[0] ? 0 : 8);
        this.cPv.setVisibility(this.cOf[1] ? 0 : 8);
        this.cPw.setVisibility(this.cOf[2] ? 0 : 8);
        this.cPx.setVisibility(this.cOf[3] ? 0 : 8);
        this.cPy.setVisibility(this.cOf[4] ? 0 : 8);
        this.cPz.setVisibility(this.cOf[5] ? 0 : 8);
        azW();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.cPE = i;
        this.cPu = (WheelView) this.view.findViewById(R.id.year);
        this.cPu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOj, this.cOk));
        this.cPu.setCurrentItem(i - this.cOj);
        this.cPu.setGravity(this.gravity);
        this.cPv = (WheelView) this.view.findViewById(R.id.month);
        if (this.cOj == this.cOk) {
            this.cPv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPA, this.cPB));
            this.cPv.setCurrentItem((i2 + 1) - this.cPA);
        } else if (i == this.cOj) {
            this.cPv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPA, 12));
            this.cPv.setCurrentItem((i2 + 1) - this.cPA);
        } else if (i == this.cOk) {
            this.cPv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cPB));
            this.cPv.setCurrentItem(i2);
        } else {
            this.cPv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.cPv.setCurrentItem(i2);
        }
        this.cPv.setGravity(this.gravity);
        this.cPw = (WheelView) this.view.findViewById(R.id.day);
        if (this.cOj == this.cOk && this.cPA == this.cPB) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cPD > 31) {
                    this.cPD = 31;
                }
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPC, this.cPD));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cPD > 30) {
                    this.cPD = 30;
                }
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPC, this.cPD));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cPD > 29) {
                    this.cPD = 29;
                }
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPC, this.cPD));
            } else {
                if (this.cPD > 28) {
                    this.cPD = 28;
                }
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPC, this.cPD));
            }
            this.cPw.setCurrentItem(i3 - this.cPC);
        } else if (i == this.cOj && i2 + 1 == this.cPA) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPC, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPC, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPC, 29));
            } else {
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPC, 28));
            }
            this.cPw.setCurrentItem(i3 - this.cPC);
        } else if (i == this.cOk && i2 + 1 == this.cPB) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cPD > 31) {
                    this.cPD = 31;
                }
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cPD));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cPD > 30) {
                    this.cPD = 30;
                }
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cPD));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cPD > 29) {
                    this.cPD = 29;
                }
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cPD));
            } else {
                if (this.cPD > 28) {
                    this.cPD = 28;
                }
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cPD));
            }
            this.cPw.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.cPw.setCurrentItem(i3 - 1);
        }
        this.cPw.setGravity(this.gravity);
        this.cPx = (WheelView) this.view.findViewById(R.id.hour);
        this.cPx.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cPx.setCurrentItem(i4);
        this.cPx.setGravity(this.gravity);
        this.cPy = (WheelView) this.view.findViewById(R.id.min);
        this.cPy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cPy.setCurrentItem(i5);
        this.cPy.setGravity(this.gravity);
        this.cPz = (WheelView) this.view.findViewById(R.id.second);
        this.cPz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cPz.setCurrentItem(i6);
        this.cPz.setGravity(this.gravity);
        this.cPu.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lY(int i7) {
                int i8 = i7 + c.this.cOj;
                c.this.cPE = i8;
                int currentItem = c.this.cPv.getCurrentItem();
                if (c.this.cOj == c.this.cOk) {
                    c.this.cPv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cPA, c.this.cPB));
                    if (currentItem > c.this.cPv.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cPv.getAdapter().getItemsCount() - 1;
                        c.this.cPv.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.cPA + currentItem;
                    if (c.this.cPA == c.this.cPB) {
                        c.this.a(i8, i9, c.this.cPC, c.this.cPD, asList, asList2);
                    } else if (i9 == c.this.cPA) {
                        c.this.a(i8, i9, c.this.cPC, 31, asList, asList2);
                    } else if (i9 == c.this.cPB) {
                        c.this.a(i8, i9, 1, c.this.cPD, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.cOj) {
                    c.this.cPv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cPA, 12));
                    if (currentItem > c.this.cPv.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cPv.getAdapter().getItemsCount() - 1;
                        c.this.cPv.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.cPA + currentItem;
                    if (i10 == c.this.cPA) {
                        c.this.a(i8, i10, c.this.cPC, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.cOk) {
                    c.this.cPv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.cPB));
                    if (currentItem > c.this.cPv.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cPv.getAdapter().getItemsCount() - 1;
                        c.this.cPv.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.cPB) {
                        c.this.a(i8, i11, 1, c.this.cPD, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.cPv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.cPv.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.cPF != null) {
                    c.this.cPF.azK();
                }
            }
        });
        this.cPv.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lY(int i7) {
                int i8 = i7 + 1;
                if (c.this.cOj == c.this.cOk) {
                    int i9 = (c.this.cPA + i8) - 1;
                    if (c.this.cPA == c.this.cPB) {
                        c.this.a(c.this.cPE, i9, c.this.cPC, c.this.cPD, asList, asList2);
                    } else if (c.this.cPA == i9) {
                        c.this.a(c.this.cPE, i9, c.this.cPC, 31, asList, asList2);
                    } else if (c.this.cPB == i9) {
                        c.this.a(c.this.cPE, i9, 1, c.this.cPD, asList, asList2);
                    } else {
                        c.this.a(c.this.cPE, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.cPE == c.this.cOj) {
                    int i10 = (c.this.cPA + i8) - 1;
                    if (i10 == c.this.cPA) {
                        c.this.a(c.this.cPE, i10, c.this.cPC, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.cPE, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.cPE == c.this.cOk) {
                    if (i8 == c.this.cPB) {
                        c.this.a(c.this.cPE, c.this.cPv.getCurrentItem() + 1, 1, c.this.cPD, asList, asList2);
                    } else {
                        c.this.a(c.this.cPE, c.this.cPv.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.cPE, i8, 1, 31, asList, asList2);
                }
                if (c.this.cPF != null) {
                    c.this.cPF.azK();
                }
            }
        });
        a(this.cPw);
        a(this.cPx);
        a(this.cPy);
        a(this.cPz);
        if (this.cOf.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.cPu.setVisibility(this.cOf[0] ? 0 : 8);
        this.cPv.setVisibility(this.cOf[1] ? 0 : 8);
        this.cPw.setVisibility(this.cOf[2] ? 0 : 8);
        this.cPx.setVisibility(this.cOf[3] ? 0 : 8);
        this.cPy.setVisibility(this.cOf[4] ? 0 : 8);
        this.cPz.setVisibility(this.cOf[5] ? 0 : 8);
        azW();
    }

    private void a(WheelView wheelView) {
        if (this.cPF != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void lY(int i) {
                    c.this.cPF.azK();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.cPw.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.cPw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.cPw.getAdapter().getItemsCount() - 1) {
            this.cPw.setCurrentItem(this.cPw.getAdapter().getItemsCount() - 1);
        }
    }

    private void azW() {
        this.cPw.setTextSize(this.textSize);
        this.cPv.setTextSize(this.textSize);
        this.cPu.setTextSize(this.textSize);
        this.cPx.setTextSize(this.textSize);
        this.cPy.setTextSize(this.textSize);
        this.cPz.setTextSize(this.textSize);
    }

    private void azX() {
        this.cPw.setTextColorOut(this.cOM);
        this.cPv.setTextColorOut(this.cOM);
        this.cPu.setTextColorOut(this.cOM);
        this.cPx.setTextColorOut(this.cOM);
        this.cPy.setTextColorOut(this.cOM);
        this.cPz.setTextColorOut(this.cOM);
    }

    private void azY() {
        this.cPw.setTextColorCenter(this.cON);
        this.cPv.setTextColorCenter(this.cON);
        this.cPu.setTextColorCenter(this.cON);
        this.cPx.setTextColorCenter(this.cON);
        this.cPy.setTextColorCenter(this.cON);
        this.cPz.setTextColorCenter(this.cON);
    }

    private void azZ() {
        this.cPw.setDividerColor(this.cOO);
        this.cPv.setDividerColor(this.cOO);
        this.cPu.setDividerColor(this.cOO);
        this.cPx.setDividerColor(this.cOO);
        this.cPy.setDividerColor(this.cOO);
        this.cPz.setDividerColor(this.cOO);
    }

    private void aAa() {
        this.cPw.setDividerType(this.cOU);
        this.cPv.setDividerType(this.cOU);
        this.cPu.setDividerType(this.cOU);
        this.cPx.setDividerType(this.cOU);
        this.cPy.setDividerType(this.cOU);
        this.cPz.setDividerType(this.cOU);
    }

    private void aAb() {
        this.cPw.setLineSpacingMultiplier(this.cOP);
        this.cPv.setLineSpacingMultiplier(this.cOP);
        this.cPu.setLineSpacingMultiplier(this.cOP);
        this.cPx.setLineSpacingMultiplier(this.cOP);
        this.cPy.setLineSpacingMultiplier(this.cOP);
        this.cPz.setLineSpacingMultiplier(this.cOP);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.cOm) {
            if (str != null) {
                this.cPu.setLabel(str);
            } else {
                this.cPu.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.cPv.setLabel(str2);
            } else {
                this.cPv.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.cPw.setLabel(str3);
            } else {
                this.cPw.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.cPx.setLabel(str4);
            } else {
                this.cPx.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.cPy.setLabel(str5);
            } else {
                this.cPy.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.cPz.setLabel(str6);
            } else {
                this.cPz.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cPw.setTextXOffset(i);
        this.cPv.setTextXOffset(i2);
        this.cPu.setTextXOffset(i3);
        this.cPx.setTextXOffset(i4);
        this.cPy.setTextXOffset(i5);
        this.cPz.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.cPu.setCyclic(z);
        this.cPv.setCyclic(z);
        this.cPw.setCyclic(z);
        this.cPx.setCyclic(z);
        this.cPy.setCyclic(z);
        this.cPz.setCyclic(z);
    }

    public String getTime() {
        if (this.cOm) {
            return aAc();
        }
        StringBuilder sb = new StringBuilder();
        if (this.cPE == this.cOj) {
            if (this.cPv.getCurrentItem() + this.cPA == this.cPA) {
                sb.append(this.cPu.getCurrentItem() + this.cOj).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPv.getCurrentItem() + this.cPA).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPw.getCurrentItem() + this.cPC).append(" ").append(this.cPx.getCurrentItem()).append(":").append(this.cPy.getCurrentItem()).append(":").append(this.cPz.getCurrentItem());
            } else {
                sb.append(this.cPu.getCurrentItem() + this.cOj).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPv.getCurrentItem() + this.cPA).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPw.getCurrentItem() + 1).append(" ").append(this.cPx.getCurrentItem()).append(":").append(this.cPy.getCurrentItem()).append(":").append(this.cPz.getCurrentItem());
            }
        } else {
            sb.append(this.cPu.getCurrentItem() + this.cOj).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPv.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPw.getCurrentItem() + 1).append(" ").append(this.cPx.getCurrentItem()).append(":").append(this.cPy.getCurrentItem()).append(":").append(this.cPz.getCurrentItem());
        }
        return sb.toString();
    }

    private String aAc() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.cPu.getCurrentItem() + this.cOj;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lR(currentItem2) == 0) {
            currentItem = this.cPv.getCurrentItem() + 1;
            z = false;
        } else if ((this.cPv.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lR(currentItem2) <= 0) {
            currentItem = this.cPv.getCurrentItem() + 1;
            z = false;
        } else if ((this.cPv.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lR(currentItem2) == 1) {
            currentItem = this.cPv.getCurrentItem();
            z = true;
        } else {
            currentItem = this.cPv.getCurrentItem();
            z = false;
        }
        int[] e = com.baidu.tbadk.widget.timepicker.a.e.b.e(currentItem2, currentItem, this.cPw.getCurrentItem() + 1, z);
        sb.append(e[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[2]).append(" ").append(this.cPx.getCurrentItem()).append(":").append(this.cPy.getCurrentItem()).append(":").append(this.cPz.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void lW(int i) {
        this.cOj = i;
    }

    public void lX(int i) {
        this.cOk = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.cOj) {
                this.cOk = i;
                this.cPB = i2;
                this.cPD = i3;
            } else if (i == this.cOj) {
                if (i2 > this.cPA) {
                    this.cOk = i;
                    this.cPB = i2;
                    this.cPD = i3;
                } else if (i2 == this.cPA && i3 > this.cPC) {
                    this.cOk = i;
                    this.cPB = i2;
                    this.cPD = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.cOk) {
                this.cPA = i5;
                this.cPC = i6;
                this.cOj = i4;
            } else if (i4 == this.cOk) {
                if (i5 < this.cPB) {
                    this.cPA = i5;
                    this.cPC = i6;
                    this.cOj = i4;
                } else if (i5 == this.cPB && i6 < this.cPD) {
                    this.cPA = i5;
                    this.cPC = i6;
                    this.cOj = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.cOj = calendar.get(1);
            this.cOk = calendar2.get(1);
            this.cPA = calendar.get(2) + 1;
            this.cPB = calendar2.get(2) + 1;
            this.cPC = calendar.get(5);
            this.cPD = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.cOP = f;
        aAb();
    }

    public void setDividerColor(int i) {
        this.cOO = i;
        azZ();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.cOU = dividerType;
        aAa();
    }

    public void setTextColorCenter(int i) {
        this.cON = i;
        azY();
    }

    public void setTextColorOut(int i) {
        this.cOM = i;
        azX();
    }

    public void ga(boolean z) {
        this.cPw.ga(z);
        this.cPv.ga(z);
        this.cPu.ga(z);
        this.cPx.ga(z);
        this.cPy.ga(z);
        this.cPz.ga(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.cPF = bVar;
    }
}
