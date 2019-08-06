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
    public static DateFormat cPA = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int cOT;
    private int cOU;
    private int cOV;
    private float cOW;
    private boolean[] cOm;
    private WheelView cPB;
    private WheelView cPC;
    private WheelView cPD;
    private WheelView cPE;
    private WheelView cPF;
    private WheelView cPG;
    private int cPL;
    private com.baidu.tbadk.widget.timepicker.a.d.b cPM;
    private WheelView.DividerType cPb;
    private int gravity;
    private int textSize;
    private View view;
    private int cOq = 1900;
    private int cOr = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int cPH = 1;
    private int cPI = 12;
    private int cPJ = 1;
    private int cPK = 31;
    private boolean cOt = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.cOm = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void fZ(boolean z) {
        this.cOt = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.cOt) {
            int[] z = com.baidu.tbadk.widget.timepicker.a.e.b.z(i, i2 + 1, i3);
            a(z[0], z[1] - 1, z[2], z[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.cPB = (WheelView) this.view.findViewById(R.id.year);
        this.cPB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.az(this.cOq, this.cOr)));
        this.cPB.setLabel("");
        this.cPB.setCurrentItem(i - this.cOq);
        this.cPB.setGravity(this.gravity);
        this.cPC = (WheelView) this.view.findViewById(R.id.month);
        this.cPC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lV(i)));
        this.cPC.setLabel("");
        int lS = com.baidu.tbadk.widget.timepicker.a.e.a.lS(i);
        if (lS != 0 && (i2 > lS - 1 || z)) {
            this.cPC.setCurrentItem(i2 + 1);
        } else {
            this.cPC.setCurrentItem(i2);
        }
        this.cPC.setGravity(this.gravity);
        this.cPD = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lS(i) == 0) {
            this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lW(com.baidu.tbadk.widget.timepicker.a.e.a.ay(i, i2))));
        } else {
            this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lW(com.baidu.tbadk.widget.timepicker.a.e.a.lR(i))));
        }
        this.cPD.setLabel("");
        this.cPD.setCurrentItem(i3 - 1);
        this.cPD.setGravity(this.gravity);
        this.cPE = (WheelView) this.view.findViewById(R.id.hour);
        this.cPE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cPE.setCurrentItem(i4);
        this.cPE.setGravity(this.gravity);
        this.cPF = (WheelView) this.view.findViewById(R.id.min);
        this.cPF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cPF.setCurrentItem(i5);
        this.cPF.setGravity(this.gravity);
        this.cPG = (WheelView) this.view.findViewById(R.id.second);
        this.cPG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cPG.setCurrentItem(i5);
        this.cPG.setGravity(this.gravity);
        this.cPB.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lZ(int i7) {
                int ay;
                int i8 = c.this.cOq + i7;
                c.this.cPC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lV(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lS(i8) == 0 || c.this.cPC.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lS(i8) - 1) {
                    c.this.cPC.setCurrentItem(c.this.cPC.getCurrentItem());
                } else {
                    c.this.cPC.setCurrentItem(c.this.cPC.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lS(i8) == 0 || c.this.cPC.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lS(i8) - 1) {
                    c.this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lW(com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cPC.getCurrentItem() + 1))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cPC.getCurrentItem() + 1);
                } else if (c.this.cPC.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lS(i8) + 1) {
                    c.this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lW(com.baidu.tbadk.widget.timepicker.a.e.a.lR(i8))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.lR(i8);
                } else {
                    c.this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lW(com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cPC.getCurrentItem()))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(i8, c.this.cPC.getCurrentItem());
                }
                if (c.this.cPD.getCurrentItem() > ay - 1) {
                    c.this.cPD.setCurrentItem(ay - 1);
                }
                if (c.this.cPM != null) {
                    c.this.cPM.azM();
                }
            }
        });
        this.cPC.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lZ(int i7) {
                int ay;
                int currentItem = c.this.cPB.getCurrentItem() + c.this.cOq;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lS(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.lS(currentItem) - 1) {
                    c.this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lW(com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7 + 1))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7 + 1);
                } else if (c.this.cPC.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lS(currentItem) + 1) {
                    c.this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lW(com.baidu.tbadk.widget.timepicker.a.e.a.lR(currentItem))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.lR(currentItem);
                } else {
                    c.this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lW(com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7))));
                    ay = com.baidu.tbadk.widget.timepicker.a.e.a.ay(currentItem, i7);
                }
                if (c.this.cPD.getCurrentItem() > ay - 1) {
                    c.this.cPD.setCurrentItem(ay - 1);
                }
                if (c.this.cPM != null) {
                    c.this.cPM.azM();
                }
            }
        });
        a(this.cPD);
        a(this.cPE);
        a(this.cPF);
        a(this.cPG);
        if (this.cOm.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.cPB.setVisibility(this.cOm[0] ? 0 : 8);
        this.cPC.setVisibility(this.cOm[1] ? 0 : 8);
        this.cPD.setVisibility(this.cOm[2] ? 0 : 8);
        this.cPE.setVisibility(this.cOm[3] ? 0 : 8);
        this.cPF.setVisibility(this.cOm[4] ? 0 : 8);
        this.cPG.setVisibility(this.cOm[5] ? 0 : 8);
        azY();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.cPL = i;
        this.cPB = (WheelView) this.view.findViewById(R.id.year);
        this.cPB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cOq, this.cOr));
        this.cPB.setCurrentItem(i - this.cOq);
        this.cPB.setGravity(this.gravity);
        this.cPC = (WheelView) this.view.findViewById(R.id.month);
        if (this.cOq == this.cOr) {
            this.cPC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPH, this.cPI));
            this.cPC.setCurrentItem((i2 + 1) - this.cPH);
        } else if (i == this.cOq) {
            this.cPC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPH, 12));
            this.cPC.setCurrentItem((i2 + 1) - this.cPH);
        } else if (i == this.cOr) {
            this.cPC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cPI));
            this.cPC.setCurrentItem(i2);
        } else {
            this.cPC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.cPC.setCurrentItem(i2);
        }
        this.cPC.setGravity(this.gravity);
        this.cPD = (WheelView) this.view.findViewById(R.id.day);
        if (this.cOq == this.cOr && this.cPH == this.cPI) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cPK > 31) {
                    this.cPK = 31;
                }
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPJ, this.cPK));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cPK > 30) {
                    this.cPK = 30;
                }
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPJ, this.cPK));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cPK > 29) {
                    this.cPK = 29;
                }
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPJ, this.cPK));
            } else {
                if (this.cPK > 28) {
                    this.cPK = 28;
                }
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPJ, this.cPK));
            }
            this.cPD.setCurrentItem(i3 - this.cPJ);
        } else if (i == this.cOq && i2 + 1 == this.cPH) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPJ, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPJ, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPJ, 29));
            } else {
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cPJ, 28));
            }
            this.cPD.setCurrentItem(i3 - this.cPJ);
        } else if (i == this.cOr && i2 + 1 == this.cPI) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cPK > 31) {
                    this.cPK = 31;
                }
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cPK));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cPK > 30) {
                    this.cPK = 30;
                }
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cPK));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cPK > 29) {
                    this.cPK = 29;
                }
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cPK));
            } else {
                if (this.cPK > 28) {
                    this.cPK = 28;
                }
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cPK));
            }
            this.cPD.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.cPD.setCurrentItem(i3 - 1);
        }
        this.cPD.setGravity(this.gravity);
        this.cPE = (WheelView) this.view.findViewById(R.id.hour);
        this.cPE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cPE.setCurrentItem(i4);
        this.cPE.setGravity(this.gravity);
        this.cPF = (WheelView) this.view.findViewById(R.id.min);
        this.cPF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cPF.setCurrentItem(i5);
        this.cPF.setGravity(this.gravity);
        this.cPG = (WheelView) this.view.findViewById(R.id.second);
        this.cPG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cPG.setCurrentItem(i6);
        this.cPG.setGravity(this.gravity);
        this.cPB.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lZ(int i7) {
                int i8 = i7 + c.this.cOq;
                c.this.cPL = i8;
                int currentItem = c.this.cPC.getCurrentItem();
                if (c.this.cOq == c.this.cOr) {
                    c.this.cPC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cPH, c.this.cPI));
                    if (currentItem > c.this.cPC.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cPC.getAdapter().getItemsCount() - 1;
                        c.this.cPC.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.cPH + currentItem;
                    if (c.this.cPH == c.this.cPI) {
                        c.this.a(i8, i9, c.this.cPJ, c.this.cPK, asList, asList2);
                    } else if (i9 == c.this.cPH) {
                        c.this.a(i8, i9, c.this.cPJ, 31, asList, asList2);
                    } else if (i9 == c.this.cPI) {
                        c.this.a(i8, i9, 1, c.this.cPK, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.cOq) {
                    c.this.cPC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cPH, 12));
                    if (currentItem > c.this.cPC.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cPC.getAdapter().getItemsCount() - 1;
                        c.this.cPC.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.cPH + currentItem;
                    if (i10 == c.this.cPH) {
                        c.this.a(i8, i10, c.this.cPJ, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.cOr) {
                    c.this.cPC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.cPI));
                    if (currentItem > c.this.cPC.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cPC.getAdapter().getItemsCount() - 1;
                        c.this.cPC.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.cPI) {
                        c.this.a(i8, i11, 1, c.this.cPK, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.cPC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.cPC.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.cPM != null) {
                    c.this.cPM.azM();
                }
            }
        });
        this.cPC.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lZ(int i7) {
                int i8 = i7 + 1;
                if (c.this.cOq == c.this.cOr) {
                    int i9 = (c.this.cPH + i8) - 1;
                    if (c.this.cPH == c.this.cPI) {
                        c.this.a(c.this.cPL, i9, c.this.cPJ, c.this.cPK, asList, asList2);
                    } else if (c.this.cPH == i9) {
                        c.this.a(c.this.cPL, i9, c.this.cPJ, 31, asList, asList2);
                    } else if (c.this.cPI == i9) {
                        c.this.a(c.this.cPL, i9, 1, c.this.cPK, asList, asList2);
                    } else {
                        c.this.a(c.this.cPL, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.cPL == c.this.cOq) {
                    int i10 = (c.this.cPH + i8) - 1;
                    if (i10 == c.this.cPH) {
                        c.this.a(c.this.cPL, i10, c.this.cPJ, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.cPL, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.cPL == c.this.cOr) {
                    if (i8 == c.this.cPI) {
                        c.this.a(c.this.cPL, c.this.cPC.getCurrentItem() + 1, 1, c.this.cPK, asList, asList2);
                    } else {
                        c.this.a(c.this.cPL, c.this.cPC.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.cPL, i8, 1, 31, asList, asList2);
                }
                if (c.this.cPM != null) {
                    c.this.cPM.azM();
                }
            }
        });
        a(this.cPD);
        a(this.cPE);
        a(this.cPF);
        a(this.cPG);
        if (this.cOm.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.cPB.setVisibility(this.cOm[0] ? 0 : 8);
        this.cPC.setVisibility(this.cOm[1] ? 0 : 8);
        this.cPD.setVisibility(this.cOm[2] ? 0 : 8);
        this.cPE.setVisibility(this.cOm[3] ? 0 : 8);
        this.cPF.setVisibility(this.cOm[4] ? 0 : 8);
        this.cPG.setVisibility(this.cOm[5] ? 0 : 8);
        azY();
    }

    private void a(WheelView wheelView) {
        if (this.cPM != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void lZ(int i) {
                    c.this.cPM.azM();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.cPD.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.cPD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.cPD.getAdapter().getItemsCount() - 1) {
            this.cPD.setCurrentItem(this.cPD.getAdapter().getItemsCount() - 1);
        }
    }

    private void azY() {
        this.cPD.setTextSize(this.textSize);
        this.cPC.setTextSize(this.textSize);
        this.cPB.setTextSize(this.textSize);
        this.cPE.setTextSize(this.textSize);
        this.cPF.setTextSize(this.textSize);
        this.cPG.setTextSize(this.textSize);
    }

    private void azZ() {
        this.cPD.setTextColorOut(this.cOT);
        this.cPC.setTextColorOut(this.cOT);
        this.cPB.setTextColorOut(this.cOT);
        this.cPE.setTextColorOut(this.cOT);
        this.cPF.setTextColorOut(this.cOT);
        this.cPG.setTextColorOut(this.cOT);
    }

    private void aAa() {
        this.cPD.setTextColorCenter(this.cOU);
        this.cPC.setTextColorCenter(this.cOU);
        this.cPB.setTextColorCenter(this.cOU);
        this.cPE.setTextColorCenter(this.cOU);
        this.cPF.setTextColorCenter(this.cOU);
        this.cPG.setTextColorCenter(this.cOU);
    }

    private void aAb() {
        this.cPD.setDividerColor(this.cOV);
        this.cPC.setDividerColor(this.cOV);
        this.cPB.setDividerColor(this.cOV);
        this.cPE.setDividerColor(this.cOV);
        this.cPF.setDividerColor(this.cOV);
        this.cPG.setDividerColor(this.cOV);
    }

    private void aAc() {
        this.cPD.setDividerType(this.cPb);
        this.cPC.setDividerType(this.cPb);
        this.cPB.setDividerType(this.cPb);
        this.cPE.setDividerType(this.cPb);
        this.cPF.setDividerType(this.cPb);
        this.cPG.setDividerType(this.cPb);
    }

    private void aAd() {
        this.cPD.setLineSpacingMultiplier(this.cOW);
        this.cPC.setLineSpacingMultiplier(this.cOW);
        this.cPB.setLineSpacingMultiplier(this.cOW);
        this.cPE.setLineSpacingMultiplier(this.cOW);
        this.cPF.setLineSpacingMultiplier(this.cOW);
        this.cPG.setLineSpacingMultiplier(this.cOW);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.cOt) {
            if (str != null) {
                this.cPB.setLabel(str);
            } else {
                this.cPB.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.cPC.setLabel(str2);
            } else {
                this.cPC.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.cPD.setLabel(str3);
            } else {
                this.cPD.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.cPE.setLabel(str4);
            } else {
                this.cPE.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.cPF.setLabel(str5);
            } else {
                this.cPF.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.cPG.setLabel(str6);
            } else {
                this.cPG.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cPD.setTextXOffset(i);
        this.cPC.setTextXOffset(i2);
        this.cPB.setTextXOffset(i3);
        this.cPE.setTextXOffset(i4);
        this.cPF.setTextXOffset(i5);
        this.cPG.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.cPB.setCyclic(z);
        this.cPC.setCyclic(z);
        this.cPD.setCyclic(z);
        this.cPE.setCyclic(z);
        this.cPF.setCyclic(z);
        this.cPG.setCyclic(z);
    }

    public String getTime() {
        if (this.cOt) {
            return aAe();
        }
        StringBuilder sb = new StringBuilder();
        if (this.cPL == this.cOq) {
            if (this.cPC.getCurrentItem() + this.cPH == this.cPH) {
                sb.append(this.cPB.getCurrentItem() + this.cOq).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPC.getCurrentItem() + this.cPH).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPD.getCurrentItem() + this.cPJ).append(" ").append(this.cPE.getCurrentItem()).append(":").append(this.cPF.getCurrentItem()).append(":").append(this.cPG.getCurrentItem());
            } else {
                sb.append(this.cPB.getCurrentItem() + this.cOq).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPC.getCurrentItem() + this.cPH).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPD.getCurrentItem() + 1).append(" ").append(this.cPE.getCurrentItem()).append(":").append(this.cPF.getCurrentItem()).append(":").append(this.cPG.getCurrentItem());
            }
        } else {
            sb.append(this.cPB.getCurrentItem() + this.cOq).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPC.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cPD.getCurrentItem() + 1).append(" ").append(this.cPE.getCurrentItem()).append(":").append(this.cPF.getCurrentItem()).append(":").append(this.cPG.getCurrentItem());
        }
        return sb.toString();
    }

    private String aAe() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.cPB.getCurrentItem() + this.cOq;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lS(currentItem2) == 0) {
            currentItem = this.cPC.getCurrentItem() + 1;
            z = false;
        } else if ((this.cPC.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lS(currentItem2) <= 0) {
            currentItem = this.cPC.getCurrentItem() + 1;
            z = false;
        } else if ((this.cPC.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lS(currentItem2) == 1) {
            currentItem = this.cPC.getCurrentItem();
            z = true;
        } else {
            currentItem = this.cPC.getCurrentItem();
            z = false;
        }
        int[] e = com.baidu.tbadk.widget.timepicker.a.e.b.e(currentItem2, currentItem, this.cPD.getCurrentItem() + 1, z);
        sb.append(e[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[2]).append(" ").append(this.cPE.getCurrentItem()).append(":").append(this.cPF.getCurrentItem()).append(":").append(this.cPG.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void lX(int i) {
        this.cOq = i;
    }

    public void lY(int i) {
        this.cOr = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.cOq) {
                this.cOr = i;
                this.cPI = i2;
                this.cPK = i3;
            } else if (i == this.cOq) {
                if (i2 > this.cPH) {
                    this.cOr = i;
                    this.cPI = i2;
                    this.cPK = i3;
                } else if (i2 == this.cPH && i3 > this.cPJ) {
                    this.cOr = i;
                    this.cPI = i2;
                    this.cPK = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.cOr) {
                this.cPH = i5;
                this.cPJ = i6;
                this.cOq = i4;
            } else if (i4 == this.cOr) {
                if (i5 < this.cPI) {
                    this.cPH = i5;
                    this.cPJ = i6;
                    this.cOq = i4;
                } else if (i5 == this.cPI && i6 < this.cPK) {
                    this.cPH = i5;
                    this.cPJ = i6;
                    this.cOq = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.cOq = calendar.get(1);
            this.cOr = calendar2.get(1);
            this.cPH = calendar.get(2) + 1;
            this.cPI = calendar2.get(2) + 1;
            this.cPJ = calendar.get(5);
            this.cPK = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.cOW = f;
        aAd();
    }

    public void setDividerColor(int i) {
        this.cOV = i;
        aAb();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.cPb = dividerType;
        aAc();
    }

    public void setTextColorCenter(int i) {
        this.cOU = i;
        aAa();
    }

    public void setTextColorOut(int i) {
        this.cOT = i;
        azZ();
    }

    public void ga(boolean z) {
        this.cPD.ga(z);
        this.cPC.ga(z);
        this.cPB.ga(z);
        this.cPE.ga(z);
        this.cPF.ga(z);
        this.cPG.ga(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.cPM = bVar;
    }
}
