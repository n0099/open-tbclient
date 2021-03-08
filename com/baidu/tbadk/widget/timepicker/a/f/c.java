package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int dBN;
    private int dBO;
    private int dBP;
    private float dBQ;
    private boolean[] gaI;
    private WheelView gbM;
    private WheelView gbN;
    private WheelView gbO;
    private WheelView gbP;
    private WheelView gbQ;
    private WheelView gbR;
    private int gbW;
    private com.baidu.tbadk.widget.timepicker.a.d.b gbX;
    private WheelView.DividerType gbq;
    private int gravity;
    private int textSize;
    private View view;
    private int gaM = FeatureCodes.SKY_SEG;
    private int gaN = 2100;
    private int gbS = 1;
    private int gbT = 12;
    private int gbU = 1;
    private int gbV = 31;
    private boolean gaP = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.gaI = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void lR(boolean z) {
        this.gaP = z;
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.gaP) {
            int[] I = com.baidu.tbadk.widget.timepicker.a.e.b.I(i, i2 + 1, i3);
            a(I[0], I[1] - 1, I[2], I[3] == 1, i4, i5, i6);
            return;
        }
        j(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.gbM = (WheelView) this.view.findViewById(R.id.year);
        this.gbM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bs(this.gaM, this.gaN)));
        this.gbM.setLabel("");
        this.gbM.setCurrentItem(i - this.gaM);
        this.gbM.setGravity(this.gravity);
        this.gbN = (WheelView) this.view.findViewById(R.id.month);
        this.gbN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sE(i)));
        this.gbN.setLabel("");
        int sB = com.baidu.tbadk.widget.timepicker.a.e.a.sB(i);
        if (sB != 0 && (i2 > sB - 1 || z)) {
            this.gbN.setCurrentItem(i2 + 1);
        } else {
            this.gbN.setCurrentItem(i2);
        }
        this.gbN.setGravity(this.gravity);
        this.gbO = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.sB(i) == 0) {
            this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sF(com.baidu.tbadk.widget.timepicker.a.e.a.br(i, i2))));
        } else {
            this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sF(com.baidu.tbadk.widget.timepicker.a.e.a.sA(i))));
        }
        this.gbO.setLabel("");
        this.gbO.setCurrentItem(i3 - 1);
        this.gbO.setGravity(this.gravity);
        this.gbP = (WheelView) this.view.findViewById(R.id.hour);
        this.gbP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.gbP.setCurrentItem(i4);
        this.gbP.setGravity(this.gravity);
        this.gbQ = (WheelView) this.view.findViewById(R.id.min);
        this.gbQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gbQ.setCurrentItem(i5);
        this.gbQ.setGravity(this.gravity);
        this.gbR = (WheelView) this.view.findViewById(R.id.second);
        this.gbR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gbR.setCurrentItem(i5);
        this.gbR.setGravity(this.gravity);
        this.gbM.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sI(int i7) {
                int br;
                int i8 = c.this.gaM + i7;
                c.this.gbN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sE(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sB(i8) == 0 || c.this.gbN.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.sB(i8) - 1) {
                    c.this.gbN.setCurrentItem(c.this.gbN.getCurrentItem());
                } else {
                    c.this.gbN.setCurrentItem(c.this.gbN.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sB(i8) == 0 || c.this.gbN.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.sB(i8) - 1) {
                    c.this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sF(com.baidu.tbadk.widget.timepicker.a.e.a.br(i8, c.this.gbN.getCurrentItem() + 1))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.br(i8, c.this.gbN.getCurrentItem() + 1);
                } else if (c.this.gbN.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.sB(i8) + 1) {
                    c.this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sF(com.baidu.tbadk.widget.timepicker.a.e.a.sA(i8))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.sA(i8);
                } else {
                    c.this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sF(com.baidu.tbadk.widget.timepicker.a.e.a.br(i8, c.this.gbN.getCurrentItem()))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.br(i8, c.this.gbN.getCurrentItem());
                }
                if (c.this.gbO.getCurrentItem() > br - 1) {
                    c.this.gbO.setCurrentItem(br - 1);
                }
                if (c.this.gbX != null) {
                    c.this.gbX.bID();
                }
            }
        });
        this.gbN.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sI(int i7) {
                int br;
                int currentItem = c.this.gbM.getCurrentItem() + c.this.gaM;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sB(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.sB(currentItem) - 1) {
                    c.this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sF(com.baidu.tbadk.widget.timepicker.a.e.a.br(currentItem, i7 + 1))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.br(currentItem, i7 + 1);
                } else if (c.this.gbN.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.sB(currentItem) + 1) {
                    c.this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sF(com.baidu.tbadk.widget.timepicker.a.e.a.sA(currentItem))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.sA(currentItem);
                } else {
                    c.this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sF(com.baidu.tbadk.widget.timepicker.a.e.a.br(currentItem, i7))));
                    br = com.baidu.tbadk.widget.timepicker.a.e.a.br(currentItem, i7);
                }
                if (c.this.gbO.getCurrentItem() > br - 1) {
                    c.this.gbO.setCurrentItem(br - 1);
                }
                if (c.this.gbX != null) {
                    c.this.gbX.bID();
                }
            }
        });
        a(this.gbO);
        a(this.gbP);
        a(this.gbQ);
        a(this.gbR);
        if (this.gaI.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.gbM.setVisibility(this.gaI[0] ? 0 : 8);
        this.gbN.setVisibility(this.gaI[1] ? 0 : 8);
        this.gbO.setVisibility(this.gaI[2] ? 0 : 8);
        this.gbP.setVisibility(this.gaI[3] ? 0 : 8);
        this.gbQ.setVisibility(this.gaI[4] ? 0 : 8);
        this.gbR.setVisibility(this.gaI[5] ? 0 : 8);
        bIL();
    }

    private void j(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", "8", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", "6", "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.gbW = i;
        this.gbM = (WheelView) this.view.findViewById(R.id.year);
        this.gbM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gaM, this.gaN));
        this.gbM.setCurrentItem(i - this.gaM);
        this.gbM.setGravity(this.gravity);
        this.gbN = (WheelView) this.view.findViewById(R.id.month);
        if (this.gaM == this.gaN) {
            this.gbN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbS, this.gbT));
            this.gbN.setCurrentItem((i2 + 1) - this.gbS);
        } else if (i == this.gaM) {
            this.gbN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbS, 12));
            this.gbN.setCurrentItem((i2 + 1) - this.gbS);
        } else if (i == this.gaN) {
            this.gbN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gbT));
            this.gbN.setCurrentItem(i2);
        } else {
            this.gbN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.gbN.setCurrentItem(i2);
        }
        this.gbN.setGravity(this.gravity);
        this.gbO = (WheelView) this.view.findViewById(R.id.day);
        if (this.gaM == this.gaN && this.gbS == this.gbT) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.gbV > 31) {
                    this.gbV = 31;
                }
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbU, this.gbV));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.gbV > 30) {
                    this.gbV = 30;
                }
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbU, this.gbV));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.gbV > 29) {
                    this.gbV = 29;
                }
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbU, this.gbV));
            } else {
                if (this.gbV > 28) {
                    this.gbV = 28;
                }
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbU, this.gbV));
            }
            this.gbO.setCurrentItem(i3 - this.gbU);
        } else if (i == this.gaM && i2 + 1 == this.gbS) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbU, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbU, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbU, 29));
            } else {
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbU, 28));
            }
            this.gbO.setCurrentItem(i3 - this.gbU);
        } else if (i == this.gaN && i2 + 1 == this.gbT) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.gbV > 31) {
                    this.gbV = 31;
                }
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gbV));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.gbV > 30) {
                    this.gbV = 30;
                }
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gbV));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.gbV > 29) {
                    this.gbV = 29;
                }
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gbV));
            } else {
                if (this.gbV > 28) {
                    this.gbV = 28;
                }
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gbV));
            }
            this.gbO.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.gbO.setCurrentItem(i3 - 1);
        }
        this.gbO.setGravity(this.gravity);
        this.gbP = (WheelView) this.view.findViewById(R.id.hour);
        this.gbP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.gbP.setCurrentItem(i4);
        this.gbP.setGravity(this.gravity);
        this.gbQ = (WheelView) this.view.findViewById(R.id.min);
        this.gbQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gbQ.setCurrentItem(i5);
        this.gbQ.setGravity(this.gravity);
        this.gbR = (WheelView) this.view.findViewById(R.id.second);
        this.gbR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gbR.setCurrentItem(i6);
        this.gbR.setGravity(this.gravity);
        this.gbM.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sI(int i7) {
                int i8 = i7 + c.this.gaM;
                c.this.gbW = i8;
                int currentItem = c.this.gbN.getCurrentItem();
                if (c.this.gaM == c.this.gaN) {
                    c.this.gbN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.gbS, c.this.gbT));
                    if (currentItem > c.this.gbN.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.gbN.getAdapter().getItemsCount() - 1;
                        c.this.gbN.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.gbS + currentItem;
                    if (c.this.gbS == c.this.gbT) {
                        c.this.a(i8, i9, c.this.gbU, c.this.gbV, asList, asList2);
                    } else if (i9 == c.this.gbS) {
                        c.this.a(i8, i9, c.this.gbU, 31, asList, asList2);
                    } else if (i9 == c.this.gbT) {
                        c.this.a(i8, i9, 1, c.this.gbV, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.gaM) {
                    c.this.gbN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.gbS, 12));
                    if (currentItem > c.this.gbN.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.gbN.getAdapter().getItemsCount() - 1;
                        c.this.gbN.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.gbS + currentItem;
                    if (i10 == c.this.gbS) {
                        c.this.a(i8, i10, c.this.gbU, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.gaN) {
                    c.this.gbN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.gbT));
                    if (currentItem > c.this.gbN.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.gbN.getAdapter().getItemsCount() - 1;
                        c.this.gbN.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.gbT) {
                        c.this.a(i8, i11, 1, c.this.gbV, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.gbN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.gbN.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.gbX != null) {
                    c.this.gbX.bID();
                }
            }
        });
        this.gbN.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void sI(int i7) {
                int i8 = i7 + 1;
                if (c.this.gaM == c.this.gaN) {
                    int i9 = (c.this.gbS + i8) - 1;
                    if (c.this.gbS == c.this.gbT) {
                        c.this.a(c.this.gbW, i9, c.this.gbU, c.this.gbV, asList, asList2);
                    } else if (c.this.gbS == i9) {
                        c.this.a(c.this.gbW, i9, c.this.gbU, 31, asList, asList2);
                    } else if (c.this.gbT == i9) {
                        c.this.a(c.this.gbW, i9, 1, c.this.gbV, asList, asList2);
                    } else {
                        c.this.a(c.this.gbW, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.gbW == c.this.gaM) {
                    int i10 = (c.this.gbS + i8) - 1;
                    if (i10 == c.this.gbS) {
                        c.this.a(c.this.gbW, i10, c.this.gbU, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.gbW, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.gbW == c.this.gaN) {
                    if (i8 == c.this.gbT) {
                        c.this.a(c.this.gbW, c.this.gbN.getCurrentItem() + 1, 1, c.this.gbV, asList, asList2);
                    } else {
                        c.this.a(c.this.gbW, c.this.gbN.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.gbW, i8, 1, 31, asList, asList2);
                }
                if (c.this.gbX != null) {
                    c.this.gbX.bID();
                }
            }
        });
        a(this.gbO);
        a(this.gbP);
        a(this.gbQ);
        a(this.gbR);
        if (this.gaI.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.gbM.setVisibility(this.gaI[0] ? 0 : 8);
        this.gbN.setVisibility(this.gaI[1] ? 0 : 8);
        this.gbO.setVisibility(this.gaI[2] ? 0 : 8);
        this.gbP.setVisibility(this.gaI[3] ? 0 : 8);
        this.gbQ.setVisibility(this.gaI[4] ? 0 : 8);
        this.gbR.setVisibility(this.gaI[5] ? 0 : 8);
        bIL();
    }

    private void a(WheelView wheelView) {
        if (this.gbX != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void sI(int i) {
                    c.this.gbX.bID();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.gbO.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.gbO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.gbO.getAdapter().getItemsCount() - 1) {
            this.gbO.setCurrentItem(this.gbO.getAdapter().getItemsCount() - 1);
        }
    }

    private void bIL() {
        this.gbO.setTextSize(this.textSize);
        this.gbN.setTextSize(this.textSize);
        this.gbM.setTextSize(this.textSize);
        this.gbP.setTextSize(this.textSize);
        this.gbQ.setTextSize(this.textSize);
        this.gbR.setTextSize(this.textSize);
    }

    private void bIM() {
        this.gbO.setTextColorOut(this.dBN);
        this.gbN.setTextColorOut(this.dBN);
        this.gbM.setTextColorOut(this.dBN);
        this.gbP.setTextColorOut(this.dBN);
        this.gbQ.setTextColorOut(this.dBN);
        this.gbR.setTextColorOut(this.dBN);
    }

    private void bIN() {
        this.gbO.setTextColorCenter(this.dBO);
        this.gbN.setTextColorCenter(this.dBO);
        this.gbM.setTextColorCenter(this.dBO);
        this.gbP.setTextColorCenter(this.dBO);
        this.gbQ.setTextColorCenter(this.dBO);
        this.gbR.setTextColorCenter(this.dBO);
    }

    private void bIO() {
        this.gbO.setDividerColor(this.dBP);
        this.gbN.setDividerColor(this.dBP);
        this.gbM.setDividerColor(this.dBP);
        this.gbP.setDividerColor(this.dBP);
        this.gbQ.setDividerColor(this.dBP);
        this.gbR.setDividerColor(this.dBP);
    }

    private void bIP() {
        this.gbO.setDividerType(this.gbq);
        this.gbN.setDividerType(this.gbq);
        this.gbM.setDividerType(this.gbq);
        this.gbP.setDividerType(this.gbq);
        this.gbQ.setDividerType(this.gbq);
        this.gbR.setDividerType(this.gbq);
    }

    private void bIQ() {
        this.gbO.setLineSpacingMultiplier(this.dBQ);
        this.gbN.setLineSpacingMultiplier(this.dBQ);
        this.gbM.setLineSpacingMultiplier(this.dBQ);
        this.gbP.setLineSpacingMultiplier(this.dBQ);
        this.gbQ.setLineSpacingMultiplier(this.dBQ);
        this.gbR.setLineSpacingMultiplier(this.dBQ);
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.gaP) {
            if (str != null) {
                this.gbM.setLabel(str);
            } else {
                this.gbM.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.gbN.setLabel(str2);
            } else {
                this.gbN.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.gbO.setLabel(str3);
            } else {
                this.gbO.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.gbP.setLabel(str4);
            } else {
                this.gbP.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.gbQ.setLabel(str5);
            } else {
                this.gbQ.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.gbR.setLabel(str6);
            } else {
                this.gbR.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gbO.setTextXOffset(i);
        this.gbN.setTextXOffset(i2);
        this.gbM.setTextXOffset(i3);
        this.gbP.setTextXOffset(i4);
        this.gbQ.setTextXOffset(i5);
        this.gbR.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.gbM.setCyclic(z);
        this.gbN.setCyclic(z);
        this.gbO.setCyclic(z);
        this.gbP.setCyclic(z);
        this.gbQ.setCyclic(z);
        this.gbR.setCyclic(z);
    }

    public String getTime() {
        if (this.gaP) {
            return bIR();
        }
        StringBuilder sb = new StringBuilder();
        if (this.gbW == this.gaM) {
            if (this.gbN.getCurrentItem() + this.gbS == this.gbS) {
                sb.append(this.gbM.getCurrentItem() + this.gaM).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gbN.getCurrentItem() + this.gbS).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gbO.getCurrentItem() + this.gbU).append(" ").append(this.gbP.getCurrentItem()).append(":").append(this.gbQ.getCurrentItem()).append(":").append(this.gbR.getCurrentItem());
            } else {
                sb.append(this.gbM.getCurrentItem() + this.gaM).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gbN.getCurrentItem() + this.gbS).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gbO.getCurrentItem() + 1).append(" ").append(this.gbP.getCurrentItem()).append(":").append(this.gbQ.getCurrentItem()).append(":").append(this.gbR.getCurrentItem());
            }
        } else {
            sb.append(this.gbM.getCurrentItem() + this.gaM).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gbN.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gbO.getCurrentItem() + 1).append(" ").append(this.gbP.getCurrentItem()).append(":").append(this.gbQ.getCurrentItem()).append(":").append(this.gbR.getCurrentItem());
        }
        return sb.toString();
    }

    private String bIR() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.gbM.getCurrentItem() + this.gaM;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.sB(currentItem2) == 0) {
            currentItem = this.gbN.getCurrentItem() + 1;
            z = false;
        } else if ((this.gbN.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.sB(currentItem2) <= 0) {
            currentItem = this.gbN.getCurrentItem() + 1;
            z = false;
        } else if ((this.gbN.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.sB(currentItem2) == 1) {
            currentItem = this.gbN.getCurrentItem();
            z = true;
        } else {
            currentItem = this.gbN.getCurrentItem();
            z = false;
        }
        int[] d = com.baidu.tbadk.widget.timepicker.a.e.b.d(currentItem2, currentItem, this.gbO.getCurrentItem() + 1, z);
        sb.append(d[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(d[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(d[2]).append(" ").append(this.gbP.getCurrentItem()).append(":").append(this.gbQ.getCurrentItem()).append(":").append(this.gbR.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void sG(int i) {
        this.gaM = i;
    }

    public void sH(int i) {
        this.gaN = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.gaM) {
                this.gaN = i;
                this.gbT = i2;
                this.gbV = i3;
            } else if (i == this.gaM) {
                if (i2 > this.gbS) {
                    this.gaN = i;
                    this.gbT = i2;
                    this.gbV = i3;
                } else if (i2 == this.gbS && i3 > this.gbU) {
                    this.gaN = i;
                    this.gbT = i2;
                    this.gbV = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.gaN) {
                this.gbS = i5;
                this.gbU = i6;
                this.gaM = i4;
            } else if (i4 == this.gaN) {
                if (i5 < this.gbT) {
                    this.gbS = i5;
                    this.gbU = i6;
                    this.gaM = i4;
                } else if (i5 == this.gbT && i6 < this.gbV) {
                    this.gbS = i5;
                    this.gbU = i6;
                    this.gaM = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.gaM = calendar.get(1);
            this.gaN = calendar2.get(1);
            this.gbS = calendar.get(2) + 1;
            this.gbT = calendar2.get(2) + 1;
            this.gbU = calendar.get(5);
            this.gbV = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.dBQ = f;
        bIQ();
    }

    public void setDividerColor(int i) {
        this.dBP = i;
        bIO();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.gbq = dividerType;
        bIP();
    }

    public void setTextColorCenter(int i) {
        this.dBO = i;
        bIN();
    }

    public void setTextColorOut(int i) {
        this.dBN = i;
        bIM();
    }

    public void lS(boolean z) {
        this.gbO.lS(z);
        this.gbN.lS(z);
        this.gbM.lS(z);
        this.gbP.lS(z);
        this.gbQ.lS(z);
        this.gbR.lS(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.gbX = bVar;
    }
}
