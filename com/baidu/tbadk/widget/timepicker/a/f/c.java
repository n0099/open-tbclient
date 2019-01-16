package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdDatePicker;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.e;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static DateFormat buC = new SimpleDateFormat(AiAppDateTimeUtil.TIME_FORMAT);
    private int btU;
    private int btV;
    private int btW;
    private float btX;
    private boolean[] btp;
    private WheelView buD;
    private WheelView buE;
    private WheelView buF;
    private WheelView buG;
    private WheelView buH;
    private WheelView buI;
    private int buN;
    private com.baidu.tbadk.widget.timepicker.a.d.b buO;
    private WheelView.DividerType buc;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = BdDatePicker.START_YEAR;
    private int endYear = 2100;
    private int buJ = 1;
    private int buK = 12;
    private int buL = 1;
    private int buM = 31;
    private boolean btu = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.btp = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void di(boolean z) {
        this.btu = z;
    }

    public void f(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.btu) {
            int[] v = com.baidu.tbadk.widget.timepicker.a.e.b.v(i, i2 + 1, i3);
            a(v[0], v[1] - 1, v[2], v[3] == 1, i4, i5, i6);
            return;
        }
        g(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.buD = (WheelView) this.view.findViewById(e.g.year);
        this.buD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.X(this.startYear, this.endYear)));
        this.buD.setLabel("");
        this.buD.setCurrentItem(i - this.startYear);
        this.buD.setGravity(this.gravity);
        this.buE = (WheelView) this.view.findViewById(e.g.month);
        this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(i)));
        this.buE.setLabel("");
        int hh = com.baidu.tbadk.widget.timepicker.a.e.a.hh(i);
        if (hh != 0 && (i2 > hh - 1 || z)) {
            this.buE.setCurrentItem(i2 + 1);
        } else {
            this.buE.setCurrentItem(i2);
        }
        this.buE.setGravity(this.gravity);
        this.buF = (WheelView) this.view.findViewById(e.g.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(i) == 0) {
            this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(i, i2))));
        } else {
            this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.hg(i))));
        }
        this.buF.setLabel("");
        this.buF.setCurrentItem(i3 - 1);
        this.buF.setGravity(this.gravity);
        this.buG = (WheelView) this.view.findViewById(e.g.hour);
        this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.buG.setCurrentItem(i4);
        this.buG.setGravity(this.gravity);
        this.buH = (WheelView) this.view.findViewById(e.g.min);
        this.buH.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.buH.setCurrentItem(i5);
        this.buH.setGravity(this.gravity);
        this.buI = (WheelView) this.view.findViewById(e.g.second);
        this.buI.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.buI.setCurrentItem(i5);
        this.buI.setGravity(this.gravity);
        this.buD.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int W;
                int i8 = c.this.startYear + i7;
                c.this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) == 0 || c.this.buE.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) - 1) {
                    c.this.buE.setCurrentItem(c.this.buE.getCurrentItem());
                } else {
                    c.this.buE.setCurrentItem(c.this.buE.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) == 0 || c.this.buE.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) - 1) {
                    c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.buE.getCurrentItem() + 1))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.buE.getCurrentItem() + 1);
                } else if (c.this.buE.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) + 1) {
                    c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8);
                } else {
                    c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.buE.getCurrentItem()))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.buE.getCurrentItem());
                }
                if (c.this.buF.getCurrentItem() > W - 1) {
                    c.this.buF.setCurrentItem(W - 1);
                }
                if (c.this.buO != null) {
                    c.this.buO.Tw();
                }
            }
        });
        this.buE.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int W;
                int currentItem = c.this.buD.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem) - 1) {
                    c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7 + 1))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7 + 1);
                } else if (c.this.buE.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem) + 1) {
                    c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem);
                } else {
                    c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7);
                }
                if (c.this.buF.getCurrentItem() > W - 1) {
                    c.this.buF.setCurrentItem(W - 1);
                }
                if (c.this.buO != null) {
                    c.this.buO.Tw();
                }
            }
        });
        a(this.buF);
        a(this.buG);
        a(this.buH);
        a(this.buI);
        if (this.btp.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.buD.setVisibility(this.btp[0] ? 0 : 8);
        this.buE.setVisibility(this.btp[1] ? 0 : 8);
        this.buF.setVisibility(this.btp[2] ? 0 : 8);
        this.buG.setVisibility(this.btp[3] ? 0 : 8);
        this.buH.setVisibility(this.btp[4] ? 0 : 8);
        this.buI.setVisibility(this.btp[5] ? 0 : 8);
        TG();
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.buN = i;
        this.buD = (WheelView) this.view.findViewById(e.g.year);
        this.buD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.buD.setCurrentItem(i - this.startYear);
        this.buD.setGravity(this.gravity);
        this.buE = (WheelView) this.view.findViewById(e.g.month);
        if (this.startYear == this.endYear) {
            this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buJ, this.buK));
            this.buE.setCurrentItem((i2 + 1) - this.buJ);
        } else if (i == this.startYear) {
            this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buJ, 12));
            this.buE.setCurrentItem((i2 + 1) - this.buJ);
        } else if (i == this.endYear) {
            this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.buK));
            this.buE.setCurrentItem(i2);
        } else {
            this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.buE.setCurrentItem(i2);
        }
        this.buE.setGravity(this.gravity);
        this.buF = (WheelView) this.view.findViewById(e.g.day);
        if (this.startYear == this.endYear && this.buJ == this.buK) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.buM > 31) {
                    this.buM = 31;
                }
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buL, this.buM));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.buM > 30) {
                    this.buM = 30;
                }
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buL, this.buM));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.buM > 29) {
                    this.buM = 29;
                }
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buL, this.buM));
            } else {
                if (this.buM > 28) {
                    this.buM = 28;
                }
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buL, this.buM));
            }
            this.buF.setCurrentItem(i3 - this.buL);
        } else if (i == this.startYear && i2 + 1 == this.buJ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buL, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buL, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buL, 29));
            } else {
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buL, 28));
            }
            this.buF.setCurrentItem(i3 - this.buL);
        } else if (i == this.endYear && i2 + 1 == this.buK) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.buM > 31) {
                    this.buM = 31;
                }
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.buM));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.buM > 30) {
                    this.buM = 30;
                }
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.buM));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.buM > 29) {
                    this.buM = 29;
                }
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.buM));
            } else {
                if (this.buM > 28) {
                    this.buM = 28;
                }
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.buM));
            }
            this.buF.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.buF.setCurrentItem(i3 - 1);
        }
        this.buF.setGravity(this.gravity);
        this.buG = (WheelView) this.view.findViewById(e.g.hour);
        this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.buG.setCurrentItem(i4);
        this.buG.setGravity(this.gravity);
        this.buH = (WheelView) this.view.findViewById(e.g.min);
        this.buH.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.buH.setCurrentItem(i5);
        this.buH.setGravity(this.gravity);
        this.buI = (WheelView) this.view.findViewById(e.g.second);
        this.buI.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.buI.setCurrentItem(i6);
        this.buI.setGravity(this.gravity);
        this.buD.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.buN = i8;
                int currentItem = c.this.buE.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.buJ, c.this.buK));
                    if (currentItem > c.this.buE.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.buE.getAdapter().getItemsCount() - 1;
                        c.this.buE.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.buJ + currentItem;
                    if (c.this.buJ == c.this.buK) {
                        c.this.a(i8, i9, c.this.buL, c.this.buM, asList, asList2);
                    } else if (i9 == c.this.buJ) {
                        c.this.a(i8, i9, c.this.buL, 31, asList, asList2);
                    } else if (i9 == c.this.buK) {
                        c.this.a(i8, i9, 1, c.this.buM, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.buJ, 12));
                    if (currentItem > c.this.buE.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.buE.getAdapter().getItemsCount() - 1;
                        c.this.buE.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.buJ + currentItem;
                    if (i10 == c.this.buJ) {
                        c.this.a(i8, i10, c.this.buL, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.buK));
                    if (currentItem > c.this.buE.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.buE.getAdapter().getItemsCount() - 1;
                        c.this.buE.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.buK) {
                        c.this.a(i8, i11, 1, c.this.buM, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.buE.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.buO != null) {
                    c.this.buO.Tw();
                }
            }
        });
        this.buE.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.buJ + i8) - 1;
                    if (c.this.buJ == c.this.buK) {
                        c.this.a(c.this.buN, i9, c.this.buL, c.this.buM, asList, asList2);
                    } else if (c.this.buJ == i9) {
                        c.this.a(c.this.buN, i9, c.this.buL, 31, asList, asList2);
                    } else if (c.this.buK == i9) {
                        c.this.a(c.this.buN, i9, 1, c.this.buM, asList, asList2);
                    } else {
                        c.this.a(c.this.buN, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.buN == c.this.startYear) {
                    int i10 = (c.this.buJ + i8) - 1;
                    if (i10 == c.this.buJ) {
                        c.this.a(c.this.buN, i10, c.this.buL, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.buN, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.buN == c.this.endYear) {
                    if (i8 == c.this.buK) {
                        c.this.a(c.this.buN, c.this.buE.getCurrentItem() + 1, 1, c.this.buM, asList, asList2);
                    } else {
                        c.this.a(c.this.buN, c.this.buE.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.buN, i8, 1, 31, asList, asList2);
                }
                if (c.this.buO != null) {
                    c.this.buO.Tw();
                }
            }
        });
        a(this.buF);
        a(this.buG);
        a(this.buH);
        a(this.buI);
        if (this.btp.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.buD.setVisibility(this.btp[0] ? 0 : 8);
        this.buE.setVisibility(this.btp[1] ? 0 : 8);
        this.buF.setVisibility(this.btp[2] ? 0 : 8);
        this.buG.setVisibility(this.btp[3] ? 0 : 8);
        this.buH.setVisibility(this.btp[4] ? 0 : 8);
        this.buI.setVisibility(this.btp[5] ? 0 : 8);
        TG();
    }

    private void a(WheelView wheelView) {
        if (this.buO != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void hn(int i) {
                    c.this.buO.Tw();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.buF.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.buF.getAdapter().getItemsCount() - 1) {
            this.buF.setCurrentItem(this.buF.getAdapter().getItemsCount() - 1);
        }
    }

    private void TG() {
        this.buF.setTextSize(this.textSize);
        this.buE.setTextSize(this.textSize);
        this.buD.setTextSize(this.textSize);
        this.buG.setTextSize(this.textSize);
        this.buH.setTextSize(this.textSize);
        this.buI.setTextSize(this.textSize);
    }

    private void TH() {
        this.buF.setTextColorOut(this.btU);
        this.buE.setTextColorOut(this.btU);
        this.buD.setTextColorOut(this.btU);
        this.buG.setTextColorOut(this.btU);
        this.buH.setTextColorOut(this.btU);
        this.buI.setTextColorOut(this.btU);
    }

    private void TI() {
        this.buF.setTextColorCenter(this.btV);
        this.buE.setTextColorCenter(this.btV);
        this.buD.setTextColorCenter(this.btV);
        this.buG.setTextColorCenter(this.btV);
        this.buH.setTextColorCenter(this.btV);
        this.buI.setTextColorCenter(this.btV);
    }

    private void TJ() {
        this.buF.setDividerColor(this.btW);
        this.buE.setDividerColor(this.btW);
        this.buD.setDividerColor(this.btW);
        this.buG.setDividerColor(this.btW);
        this.buH.setDividerColor(this.btW);
        this.buI.setDividerColor(this.btW);
    }

    private void TK() {
        this.buF.setDividerType(this.buc);
        this.buE.setDividerType(this.buc);
        this.buD.setDividerType(this.buc);
        this.buG.setDividerType(this.buc);
        this.buH.setDividerType(this.buc);
        this.buI.setDividerType(this.buc);
    }

    private void TL() {
        this.buF.setLineSpacingMultiplier(this.btX);
        this.buE.setLineSpacingMultiplier(this.btX);
        this.buD.setLineSpacingMultiplier(this.btX);
        this.buG.setLineSpacingMultiplier(this.btX);
        this.buH.setLineSpacingMultiplier(this.btX);
        this.buI.setLineSpacingMultiplier(this.btX);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.btu) {
            if (str != null) {
                this.buD.setLabel(str);
            } else {
                this.buD.setLabel(this.view.getContext().getString(e.j.pickerview_year));
            }
            if (str2 != null) {
                this.buE.setLabel(str2);
            } else {
                this.buE.setLabel(this.view.getContext().getString(e.j.pickerview_month));
            }
            if (str3 != null) {
                this.buF.setLabel(str3);
            } else {
                this.buF.setLabel(this.view.getContext().getString(e.j.pickerview_day));
            }
            if (str4 != null) {
                this.buG.setLabel(str4);
            } else {
                this.buG.setLabel(this.view.getContext().getString(e.j.pickerview_hours));
            }
            if (str5 != null) {
                this.buH.setLabel(str5);
            } else {
                this.buH.setLabel(this.view.getContext().getString(e.j.pickerview_minutes));
            }
            if (str6 != null) {
                this.buI.setLabel(str6);
            } else {
                this.buI.setLabel(this.view.getContext().getString(e.j.pickerview_seconds));
            }
        }
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.buF.setTextXOffset(i);
        this.buE.setTextXOffset(i2);
        this.buD.setTextXOffset(i3);
        this.buG.setTextXOffset(i4);
        this.buH.setTextXOffset(i5);
        this.buI.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.buD.setCyclic(z);
        this.buE.setCyclic(z);
        this.buF.setCyclic(z);
        this.buG.setCyclic(z);
        this.buH.setCyclic(z);
        this.buI.setCyclic(z);
    }

    public String getTime() {
        if (this.btu) {
            return TM();
        }
        StringBuilder sb = new StringBuilder();
        if (this.buN == this.startYear) {
            if (this.buE.getCurrentItem() + this.buJ == this.buJ) {
                sb.append(this.buD.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buE.getCurrentItem() + this.buJ).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buF.getCurrentItem() + this.buL).append(" ").append(this.buG.getCurrentItem()).append(":").append(this.buH.getCurrentItem()).append(":").append(this.buI.getCurrentItem());
            } else {
                sb.append(this.buD.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buE.getCurrentItem() + this.buJ).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buF.getCurrentItem() + 1).append(" ").append(this.buG.getCurrentItem()).append(":").append(this.buH.getCurrentItem()).append(":").append(this.buI.getCurrentItem());
            }
        } else {
            sb.append(this.buD.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buE.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buF.getCurrentItem() + 1).append(" ").append(this.buG.getCurrentItem()).append(":").append(this.buH.getCurrentItem()).append(":").append(this.buI.getCurrentItem());
        }
        return sb.toString();
    }

    private String TM() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.buD.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem2) == 0) {
            currentItem = this.buE.getCurrentItem() + 1;
            z = false;
        } else if ((this.buE.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem2) <= 0) {
            currentItem = this.buE.getCurrentItem() + 1;
            z = false;
        } else if ((this.buE.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem2) == 1) {
            currentItem = this.buE.getCurrentItem();
            z = true;
        } else {
            currentItem = this.buE.getCurrentItem();
            z = false;
        }
        int[] b = com.baidu.tbadk.widget.timepicker.a.e.b.b(currentItem2, currentItem, this.buF.getCurrentItem() + 1, z);
        sb.append(b[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[2]).append(" ").append(this.buG.getCurrentItem()).append(":").append(this.buH.getCurrentItem()).append(":").append(this.buI.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void hm(int i) {
        this.endYear = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.startYear) {
                this.endYear = i;
                this.buK = i2;
                this.buM = i3;
            } else if (i == this.startYear) {
                if (i2 > this.buJ) {
                    this.endYear = i;
                    this.buK = i2;
                    this.buM = i3;
                } else if (i2 == this.buJ && i3 > this.buL) {
                    this.endYear = i;
                    this.buK = i2;
                    this.buM = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.buJ = i5;
                this.buL = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.buK) {
                    this.buJ = i5;
                    this.buL = i6;
                    this.startYear = i4;
                } else if (i5 == this.buK && i6 < this.buM) {
                    this.buJ = i5;
                    this.buL = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.buJ = calendar.get(2) + 1;
            this.buK = calendar2.get(2) + 1;
            this.buL = calendar.get(5);
            this.buM = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.btX = f;
        TL();
    }

    public void setDividerColor(int i) {
        this.btW = i;
        TJ();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.buc = dividerType;
        TK();
    }

    public void setTextColorCenter(int i) {
        this.btV = i;
        TI();
    }

    public void setTextColorOut(int i) {
        this.btU = i;
        TH();
    }

    public void dj(boolean z) {
        this.buF.dj(z);
        this.buE.dj(z);
        this.buD.dj(z);
        this.buG.dj(z);
        this.buH.dj(z);
        this.buI.dj(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.buO = bVar;
    }
}
