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
    private int dCT;
    private int dCU;
    private int dCV;
    private float dCW;
    private boolean[] gbz;
    private WheelView gcE;
    private WheelView gcF;
    private WheelView gcG;
    private WheelView gcH;
    private WheelView gcI;
    private WheelView gcJ;
    private int gcO;
    private com.baidu.tbadk.widget.timepicker.a.d.b gcP;
    private WheelView.DividerType gch;
    private int gravity;
    private int textSize;
    private View view;
    private int gbD = FeatureCodes.SKY_SEG;
    private int gbE = 2100;
    private int gcK = 1;
    private int gcL = 12;
    private int gcM = 1;
    private int gcN = 31;
    private boolean gbG = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.gbz = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void lR(boolean z) {
        this.gbG = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.gbG) {
            int[] I = com.baidu.tbadk.widget.timepicker.a.e.b.I(i, i2 + 1, i3);
            a(I[0], I[1] - 1, I[2], I[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.gcE = (WheelView) this.view.findViewById(R.id.year);
        this.gcE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bv(this.gbD, this.gbE)));
        this.gcE.setLabel("");
        this.gcE.setCurrentItem(i - this.gbD);
        this.gcE.setGravity(this.gravity);
        this.gcF = (WheelView) this.view.findViewById(R.id.month);
        this.gcF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ud(i)));
        this.gcF.setLabel("");
        int ua = com.baidu.tbadk.widget.timepicker.a.e.a.ua(i);
        if (ua != 0 && (i2 > ua - 1 || z)) {
            this.gcF.setCurrentItem(i2 + 1);
        } else {
            this.gcF.setCurrentItem(i2);
        }
        this.gcF.setGravity(this.gravity);
        this.gcG = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.ua(i) == 0) {
            this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ue(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i, i2))));
        } else {
            this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ue(com.baidu.tbadk.widget.timepicker.a.e.a.tZ(i))));
        }
        this.gcG.setLabel("");
        this.gcG.setCurrentItem(i3 - 1);
        this.gcG.setGravity(this.gravity);
        this.gcH = (WheelView) this.view.findViewById(R.id.hour);
        this.gcH.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.gcH.setCurrentItem(i4);
        this.gcH.setGravity(this.gravity);
        this.gcI = (WheelView) this.view.findViewById(R.id.min);
        this.gcI.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gcI.setCurrentItem(i5);
        this.gcI.setGravity(this.gravity);
        this.gcJ = (WheelView) this.view.findViewById(R.id.second);
        this.gcJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gcJ.setCurrentItem(i5);
        this.gcJ.setGravity(this.gravity);
        this.gcE.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void uh(int i7) {
                int bu;
                int i8 = c.this.gbD + i7;
                c.this.gcF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ud(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.ua(i8) == 0 || c.this.gcF.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.ua(i8) - 1) {
                    c.this.gcF.setCurrentItem(c.this.gcF.getCurrentItem());
                } else {
                    c.this.gcF.setCurrentItem(c.this.gcF.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.ua(i8) == 0 || c.this.gcF.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.ua(i8) - 1) {
                    c.this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ue(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.gcF.getCurrentItem() + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.gcF.getCurrentItem() + 1);
                } else if (c.this.gcF.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.ua(i8) + 1) {
                    c.this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ue(com.baidu.tbadk.widget.timepicker.a.e.a.tZ(i8))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.tZ(i8);
                } else {
                    c.this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ue(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.gcF.getCurrentItem()))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.gcF.getCurrentItem());
                }
                if (c.this.gcG.getCurrentItem() > bu - 1) {
                    c.this.gcG.setCurrentItem(bu - 1);
                }
                if (c.this.gcP != null) {
                    c.this.gcP.bLX();
                }
            }
        });
        this.gcF.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void uh(int i7) {
                int bu;
                int currentItem = c.this.gcE.getCurrentItem() + c.this.gbD;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.ua(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.ua(currentItem) - 1) {
                    c.this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ue(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1);
                } else if (c.this.gcF.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.ua(currentItem) + 1) {
                    c.this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ue(com.baidu.tbadk.widget.timepicker.a.e.a.tZ(currentItem))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.tZ(currentItem);
                } else {
                    c.this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.ue(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7);
                }
                if (c.this.gcG.getCurrentItem() > bu - 1) {
                    c.this.gcG.setCurrentItem(bu - 1);
                }
                if (c.this.gcP != null) {
                    c.this.gcP.bLX();
                }
            }
        });
        a(this.gcG);
        a(this.gcH);
        a(this.gcI);
        a(this.gcJ);
        if (this.gbz.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.gcE.setVisibility(this.gbz[0] ? 0 : 8);
        this.gcF.setVisibility(this.gbz[1] ? 0 : 8);
        this.gcG.setVisibility(this.gbz[2] ? 0 : 8);
        this.gcH.setVisibility(this.gbz[3] ? 0 : 8);
        this.gcI.setVisibility(this.gbz[4] ? 0 : 8);
        this.gcJ.setVisibility(this.gbz[5] ? 0 : 8);
        bMf();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", "8", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", "6", "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.gcO = i;
        this.gcE = (WheelView) this.view.findViewById(R.id.year);
        this.gcE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gbD, this.gbE));
        this.gcE.setCurrentItem(i - this.gbD);
        this.gcE.setGravity(this.gravity);
        this.gcF = (WheelView) this.view.findViewById(R.id.month);
        if (this.gbD == this.gbE) {
            this.gcF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gcK, this.gcL));
            this.gcF.setCurrentItem((i2 + 1) - this.gcK);
        } else if (i == this.gbD) {
            this.gcF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gcK, 12));
            this.gcF.setCurrentItem((i2 + 1) - this.gcK);
        } else if (i == this.gbE) {
            this.gcF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gcL));
            this.gcF.setCurrentItem(i2);
        } else {
            this.gcF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.gcF.setCurrentItem(i2);
        }
        this.gcF.setGravity(this.gravity);
        this.gcG = (WheelView) this.view.findViewById(R.id.day);
        if (this.gbD == this.gbE && this.gcK == this.gcL) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.gcN > 31) {
                    this.gcN = 31;
                }
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gcM, this.gcN));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.gcN > 30) {
                    this.gcN = 30;
                }
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gcM, this.gcN));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.gcN > 29) {
                    this.gcN = 29;
                }
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gcM, this.gcN));
            } else {
                if (this.gcN > 28) {
                    this.gcN = 28;
                }
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gcM, this.gcN));
            }
            this.gcG.setCurrentItem(i3 - this.gcM);
        } else if (i == this.gbD && i2 + 1 == this.gcK) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gcM, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gcM, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gcM, 29));
            } else {
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.gcM, 28));
            }
            this.gcG.setCurrentItem(i3 - this.gcM);
        } else if (i == this.gbE && i2 + 1 == this.gcL) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.gcN > 31) {
                    this.gcN = 31;
                }
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gcN));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.gcN > 30) {
                    this.gcN = 30;
                }
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gcN));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.gcN > 29) {
                    this.gcN = 29;
                }
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gcN));
            } else {
                if (this.gcN > 28) {
                    this.gcN = 28;
                }
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.gcN));
            }
            this.gcG.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.gcG.setCurrentItem(i3 - 1);
        }
        this.gcG.setGravity(this.gravity);
        this.gcH = (WheelView) this.view.findViewById(R.id.hour);
        this.gcH.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.gcH.setCurrentItem(i4);
        this.gcH.setGravity(this.gravity);
        this.gcI = (WheelView) this.view.findViewById(R.id.min);
        this.gcI.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gcI.setCurrentItem(i5);
        this.gcI.setGravity(this.gravity);
        this.gcJ = (WheelView) this.view.findViewById(R.id.second);
        this.gcJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.gcJ.setCurrentItem(i6);
        this.gcJ.setGravity(this.gravity);
        this.gcE.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void uh(int i7) {
                int i8 = i7 + c.this.gbD;
                c.this.gcO = i8;
                int currentItem = c.this.gcF.getCurrentItem();
                if (c.this.gbD == c.this.gbE) {
                    c.this.gcF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.gcK, c.this.gcL));
                    if (currentItem > c.this.gcF.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.gcF.getAdapter().getItemsCount() - 1;
                        c.this.gcF.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.gcK + currentItem;
                    if (c.this.gcK == c.this.gcL) {
                        c.this.a(i8, i9, c.this.gcM, c.this.gcN, asList, asList2);
                    } else if (i9 == c.this.gcK) {
                        c.this.a(i8, i9, c.this.gcM, 31, asList, asList2);
                    } else if (i9 == c.this.gcL) {
                        c.this.a(i8, i9, 1, c.this.gcN, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.gbD) {
                    c.this.gcF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.gcK, 12));
                    if (currentItem > c.this.gcF.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.gcF.getAdapter().getItemsCount() - 1;
                        c.this.gcF.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.gcK + currentItem;
                    if (i10 == c.this.gcK) {
                        c.this.a(i8, i10, c.this.gcM, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.gbE) {
                    c.this.gcF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.gcL));
                    if (currentItem > c.this.gcF.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.gcF.getAdapter().getItemsCount() - 1;
                        c.this.gcF.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.gcL) {
                        c.this.a(i8, i11, 1, c.this.gcN, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.gcF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.gcF.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.gcP != null) {
                    c.this.gcP.bLX();
                }
            }
        });
        this.gcF.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void uh(int i7) {
                int i8 = i7 + 1;
                if (c.this.gbD == c.this.gbE) {
                    int i9 = (c.this.gcK + i8) - 1;
                    if (c.this.gcK == c.this.gcL) {
                        c.this.a(c.this.gcO, i9, c.this.gcM, c.this.gcN, asList, asList2);
                    } else if (c.this.gcK == i9) {
                        c.this.a(c.this.gcO, i9, c.this.gcM, 31, asList, asList2);
                    } else if (c.this.gcL == i9) {
                        c.this.a(c.this.gcO, i9, 1, c.this.gcN, asList, asList2);
                    } else {
                        c.this.a(c.this.gcO, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.gcO == c.this.gbD) {
                    int i10 = (c.this.gcK + i8) - 1;
                    if (i10 == c.this.gcK) {
                        c.this.a(c.this.gcO, i10, c.this.gcM, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.gcO, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.gcO == c.this.gbE) {
                    if (i8 == c.this.gcL) {
                        c.this.a(c.this.gcO, c.this.gcF.getCurrentItem() + 1, 1, c.this.gcN, asList, asList2);
                    } else {
                        c.this.a(c.this.gcO, c.this.gcF.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.gcO, i8, 1, 31, asList, asList2);
                }
                if (c.this.gcP != null) {
                    c.this.gcP.bLX();
                }
            }
        });
        a(this.gcG);
        a(this.gcH);
        a(this.gcI);
        a(this.gcJ);
        if (this.gbz.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.gcE.setVisibility(this.gbz[0] ? 0 : 8);
        this.gcF.setVisibility(this.gbz[1] ? 0 : 8);
        this.gcG.setVisibility(this.gbz[2] ? 0 : 8);
        this.gcH.setVisibility(this.gbz[3] ? 0 : 8);
        this.gcI.setVisibility(this.gbz[4] ? 0 : 8);
        this.gcJ.setVisibility(this.gbz[5] ? 0 : 8);
        bMf();
    }

    private void a(WheelView wheelView) {
        if (this.gcP != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void uh(int i) {
                    c.this.gcP.bLX();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.gcG.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.gcG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.gcG.getAdapter().getItemsCount() - 1) {
            this.gcG.setCurrentItem(this.gcG.getAdapter().getItemsCount() - 1);
        }
    }

    private void bMf() {
        this.gcG.setTextSize(this.textSize);
        this.gcF.setTextSize(this.textSize);
        this.gcE.setTextSize(this.textSize);
        this.gcH.setTextSize(this.textSize);
        this.gcI.setTextSize(this.textSize);
        this.gcJ.setTextSize(this.textSize);
    }

    private void bMg() {
        this.gcG.setTextColorOut(this.dCT);
        this.gcF.setTextColorOut(this.dCT);
        this.gcE.setTextColorOut(this.dCT);
        this.gcH.setTextColorOut(this.dCT);
        this.gcI.setTextColorOut(this.dCT);
        this.gcJ.setTextColorOut(this.dCT);
    }

    private void bMh() {
        this.gcG.setTextColorCenter(this.dCU);
        this.gcF.setTextColorCenter(this.dCU);
        this.gcE.setTextColorCenter(this.dCU);
        this.gcH.setTextColorCenter(this.dCU);
        this.gcI.setTextColorCenter(this.dCU);
        this.gcJ.setTextColorCenter(this.dCU);
    }

    private void bMi() {
        this.gcG.setDividerColor(this.dCV);
        this.gcF.setDividerColor(this.dCV);
        this.gcE.setDividerColor(this.dCV);
        this.gcH.setDividerColor(this.dCV);
        this.gcI.setDividerColor(this.dCV);
        this.gcJ.setDividerColor(this.dCV);
    }

    private void bMj() {
        this.gcG.setDividerType(this.gch);
        this.gcF.setDividerType(this.gch);
        this.gcE.setDividerType(this.gch);
        this.gcH.setDividerType(this.gch);
        this.gcI.setDividerType(this.gch);
        this.gcJ.setDividerType(this.gch);
    }

    private void bMk() {
        this.gcG.setLineSpacingMultiplier(this.dCW);
        this.gcF.setLineSpacingMultiplier(this.dCW);
        this.gcE.setLineSpacingMultiplier(this.dCW);
        this.gcH.setLineSpacingMultiplier(this.dCW);
        this.gcI.setLineSpacingMultiplier(this.dCW);
        this.gcJ.setLineSpacingMultiplier(this.dCW);
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.gbG) {
            if (str != null) {
                this.gcE.setLabel(str);
            } else {
                this.gcE.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.gcF.setLabel(str2);
            } else {
                this.gcF.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.gcG.setLabel(str3);
            } else {
                this.gcG.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.gcH.setLabel(str4);
            } else {
                this.gcH.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.gcI.setLabel(str5);
            } else {
                this.gcI.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.gcJ.setLabel(str6);
            } else {
                this.gcJ.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gcG.setTextXOffset(i);
        this.gcF.setTextXOffset(i2);
        this.gcE.setTextXOffset(i3);
        this.gcH.setTextXOffset(i4);
        this.gcI.setTextXOffset(i5);
        this.gcJ.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.gcE.setCyclic(z);
        this.gcF.setCyclic(z);
        this.gcG.setCyclic(z);
        this.gcH.setCyclic(z);
        this.gcI.setCyclic(z);
        this.gcJ.setCyclic(z);
    }

    public String getTime() {
        if (this.gbG) {
            return bMl();
        }
        StringBuilder sb = new StringBuilder();
        if (this.gcO == this.gbD) {
            if (this.gcF.getCurrentItem() + this.gcK == this.gcK) {
                sb.append(this.gcE.getCurrentItem() + this.gbD).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gcF.getCurrentItem() + this.gcK).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gcG.getCurrentItem() + this.gcM).append(" ").append(this.gcH.getCurrentItem()).append(":").append(this.gcI.getCurrentItem()).append(":").append(this.gcJ.getCurrentItem());
            } else {
                sb.append(this.gcE.getCurrentItem() + this.gbD).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gcF.getCurrentItem() + this.gcK).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gcG.getCurrentItem() + 1).append(" ").append(this.gcH.getCurrentItem()).append(":").append(this.gcI.getCurrentItem()).append(":").append(this.gcJ.getCurrentItem());
            }
        } else {
            sb.append(this.gcE.getCurrentItem() + this.gbD).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gcF.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.gcG.getCurrentItem() + 1).append(" ").append(this.gcH.getCurrentItem()).append(":").append(this.gcI.getCurrentItem()).append(":").append(this.gcJ.getCurrentItem());
        }
        return sb.toString();
    }

    private String bMl() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.gcE.getCurrentItem() + this.gbD;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.ua(currentItem2) == 0) {
            currentItem = this.gcF.getCurrentItem() + 1;
            z = false;
        } else if ((this.gcF.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.ua(currentItem2) <= 0) {
            currentItem = this.gcF.getCurrentItem() + 1;
            z = false;
        } else if ((this.gcF.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.ua(currentItem2) == 1) {
            currentItem = this.gcF.getCurrentItem();
            z = true;
        } else {
            currentItem = this.gcF.getCurrentItem();
            z = false;
        }
        int[] d = com.baidu.tbadk.widget.timepicker.a.e.b.d(currentItem2, currentItem, this.gcG.getCurrentItem() + 1, z);
        sb.append(d[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(d[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(d[2]).append(" ").append(this.gcH.getCurrentItem()).append(":").append(this.gcI.getCurrentItem()).append(":").append(this.gcJ.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void uf(int i) {
        this.gbD = i;
    }

    public void ug(int i) {
        this.gbE = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.gbD) {
                this.gbE = i;
                this.gcL = i2;
                this.gcN = i3;
            } else if (i == this.gbD) {
                if (i2 > this.gcK) {
                    this.gbE = i;
                    this.gcL = i2;
                    this.gcN = i3;
                } else if (i2 == this.gcK && i3 > this.gcM) {
                    this.gbE = i;
                    this.gcL = i2;
                    this.gcN = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.gbE) {
                this.gcK = i5;
                this.gcM = i6;
                this.gbD = i4;
            } else if (i4 == this.gbE) {
                if (i5 < this.gcL) {
                    this.gcK = i5;
                    this.gcM = i6;
                    this.gbD = i4;
                } else if (i5 == this.gcL && i6 < this.gcN) {
                    this.gcK = i5;
                    this.gcM = i6;
                    this.gbD = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.gbD = calendar.get(1);
            this.gbE = calendar2.get(1);
            this.gcK = calendar.get(2) + 1;
            this.gcL = calendar2.get(2) + 1;
            this.gcM = calendar.get(5);
            this.gcN = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.dCW = f;
        bMk();
    }

    public void setDividerColor(int i) {
        this.dCV = i;
        bMi();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.gch = dividerType;
        bMj();
    }

    public void setTextColorCenter(int i) {
        this.dCU = i;
        bMh();
    }

    public void setTextColorOut(int i) {
        this.dCT = i;
        bMg();
    }

    public void lS(boolean z) {
        this.gcG.lS(z);
        this.gcF.lS(z);
        this.gcE.lS(z);
        this.gcH.lS(z);
        this.gcI.lS(z);
        this.gcJ.lS(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.gcP = bVar;
    }
}
