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
    public static DateFormat buD = new SimpleDateFormat(AiAppDateTimeUtil.TIME_FORMAT);
    private int btV;
    private int btW;
    private int btX;
    private float btY;
    private boolean[] btq;
    private WheelView buE;
    private WheelView buF;
    private WheelView buG;
    private WheelView buH;
    private WheelView buI;
    private WheelView buJ;
    private int buO;
    private com.baidu.tbadk.widget.timepicker.a.d.b buP;
    private WheelView.DividerType bud;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = BdDatePicker.START_YEAR;
    private int endYear = 2100;
    private int buK = 1;
    private int buL = 12;
    private int buM = 1;
    private int buN = 31;
    private boolean btv = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.btq = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void di(boolean z) {
        this.btv = z;
    }

    public void f(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.btv) {
            int[] v = com.baidu.tbadk.widget.timepicker.a.e.b.v(i, i2 + 1, i3);
            a(v[0], v[1] - 1, v[2], v[3] == 1, i4, i5, i6);
            return;
        }
        g(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.buE = (WheelView) this.view.findViewById(e.g.year);
        this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.X(this.startYear, this.endYear)));
        this.buE.setLabel("");
        this.buE.setCurrentItem(i - this.startYear);
        this.buE.setGravity(this.gravity);
        this.buF = (WheelView) this.view.findViewById(e.g.month);
        this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(i)));
        this.buF.setLabel("");
        int hh = com.baidu.tbadk.widget.timepicker.a.e.a.hh(i);
        if (hh != 0 && (i2 > hh - 1 || z)) {
            this.buF.setCurrentItem(i2 + 1);
        } else {
            this.buF.setCurrentItem(i2);
        }
        this.buF.setGravity(this.gravity);
        this.buG = (WheelView) this.view.findViewById(e.g.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(i) == 0) {
            this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(i, i2))));
        } else {
            this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.hg(i))));
        }
        this.buG.setLabel("");
        this.buG.setCurrentItem(i3 - 1);
        this.buG.setGravity(this.gravity);
        this.buH = (WheelView) this.view.findViewById(e.g.hour);
        this.buH.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.buH.setCurrentItem(i4);
        this.buH.setGravity(this.gravity);
        this.buI = (WheelView) this.view.findViewById(e.g.min);
        this.buI.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.buI.setCurrentItem(i5);
        this.buI.setGravity(this.gravity);
        this.buJ = (WheelView) this.view.findViewById(e.g.second);
        this.buJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.buJ.setCurrentItem(i5);
        this.buJ.setGravity(this.gravity);
        this.buE.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int W;
                int i8 = c.this.startYear + i7;
                c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) == 0 || c.this.buF.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) - 1) {
                    c.this.buF.setCurrentItem(c.this.buF.getCurrentItem());
                } else {
                    c.this.buF.setCurrentItem(c.this.buF.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) == 0 || c.this.buF.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) - 1) {
                    c.this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.buF.getCurrentItem() + 1))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.buF.getCurrentItem() + 1);
                } else if (c.this.buF.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) + 1) {
                    c.this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8);
                } else {
                    c.this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.buF.getCurrentItem()))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.buF.getCurrentItem());
                }
                if (c.this.buG.getCurrentItem() > W - 1) {
                    c.this.buG.setCurrentItem(W - 1);
                }
                if (c.this.buP != null) {
                    c.this.buP.Tw();
                }
            }
        });
        this.buF.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int W;
                int currentItem = c.this.buE.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem) - 1) {
                    c.this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7 + 1))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7 + 1);
                } else if (c.this.buF.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem) + 1) {
                    c.this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem);
                } else {
                    c.this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7);
                }
                if (c.this.buG.getCurrentItem() > W - 1) {
                    c.this.buG.setCurrentItem(W - 1);
                }
                if (c.this.buP != null) {
                    c.this.buP.Tw();
                }
            }
        });
        a(this.buG);
        a(this.buH);
        a(this.buI);
        a(this.buJ);
        if (this.btq.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.buE.setVisibility(this.btq[0] ? 0 : 8);
        this.buF.setVisibility(this.btq[1] ? 0 : 8);
        this.buG.setVisibility(this.btq[2] ? 0 : 8);
        this.buH.setVisibility(this.btq[3] ? 0 : 8);
        this.buI.setVisibility(this.btq[4] ? 0 : 8);
        this.buJ.setVisibility(this.btq[5] ? 0 : 8);
        TG();
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.buO = i;
        this.buE = (WheelView) this.view.findViewById(e.g.year);
        this.buE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.buE.setCurrentItem(i - this.startYear);
        this.buE.setGravity(this.gravity);
        this.buF = (WheelView) this.view.findViewById(e.g.month);
        if (this.startYear == this.endYear) {
            this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buK, this.buL));
            this.buF.setCurrentItem((i2 + 1) - this.buK);
        } else if (i == this.startYear) {
            this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buK, 12));
            this.buF.setCurrentItem((i2 + 1) - this.buK);
        } else if (i == this.endYear) {
            this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.buL));
            this.buF.setCurrentItem(i2);
        } else {
            this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.buF.setCurrentItem(i2);
        }
        this.buF.setGravity(this.gravity);
        this.buG = (WheelView) this.view.findViewById(e.g.day);
        if (this.startYear == this.endYear && this.buK == this.buL) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.buN > 31) {
                    this.buN = 31;
                }
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buM, this.buN));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.buN > 30) {
                    this.buN = 30;
                }
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buM, this.buN));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.buN > 29) {
                    this.buN = 29;
                }
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buM, this.buN));
            } else {
                if (this.buN > 28) {
                    this.buN = 28;
                }
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buM, this.buN));
            }
            this.buG.setCurrentItem(i3 - this.buM);
        } else if (i == this.startYear && i2 + 1 == this.buK) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buM, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buM, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buM, 29));
            } else {
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.buM, 28));
            }
            this.buG.setCurrentItem(i3 - this.buM);
        } else if (i == this.endYear && i2 + 1 == this.buL) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.buN > 31) {
                    this.buN = 31;
                }
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.buN));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.buN > 30) {
                    this.buN = 30;
                }
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.buN));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.buN > 29) {
                    this.buN = 29;
                }
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.buN));
            } else {
                if (this.buN > 28) {
                    this.buN = 28;
                }
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.buN));
            }
            this.buG.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.buG.setCurrentItem(i3 - 1);
        }
        this.buG.setGravity(this.gravity);
        this.buH = (WheelView) this.view.findViewById(e.g.hour);
        this.buH.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.buH.setCurrentItem(i4);
        this.buH.setGravity(this.gravity);
        this.buI = (WheelView) this.view.findViewById(e.g.min);
        this.buI.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.buI.setCurrentItem(i5);
        this.buI.setGravity(this.gravity);
        this.buJ = (WheelView) this.view.findViewById(e.g.second);
        this.buJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.buJ.setCurrentItem(i6);
        this.buJ.setGravity(this.gravity);
        this.buE.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.buO = i8;
                int currentItem = c.this.buF.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.buK, c.this.buL));
                    if (currentItem > c.this.buF.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.buF.getAdapter().getItemsCount() - 1;
                        c.this.buF.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.buK + currentItem;
                    if (c.this.buK == c.this.buL) {
                        c.this.a(i8, i9, c.this.buM, c.this.buN, asList, asList2);
                    } else if (i9 == c.this.buK) {
                        c.this.a(i8, i9, c.this.buM, 31, asList, asList2);
                    } else if (i9 == c.this.buL) {
                        c.this.a(i8, i9, 1, c.this.buN, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.buK, 12));
                    if (currentItem > c.this.buF.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.buF.getAdapter().getItemsCount() - 1;
                        c.this.buF.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.buK + currentItem;
                    if (i10 == c.this.buK) {
                        c.this.a(i8, i10, c.this.buM, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.buL));
                    if (currentItem > c.this.buF.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.buF.getAdapter().getItemsCount() - 1;
                        c.this.buF.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.buL) {
                        c.this.a(i8, i11, 1, c.this.buN, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.buF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.buF.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.buP != null) {
                    c.this.buP.Tw();
                }
            }
        });
        this.buF.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.buK + i8) - 1;
                    if (c.this.buK == c.this.buL) {
                        c.this.a(c.this.buO, i9, c.this.buM, c.this.buN, asList, asList2);
                    } else if (c.this.buK == i9) {
                        c.this.a(c.this.buO, i9, c.this.buM, 31, asList, asList2);
                    } else if (c.this.buL == i9) {
                        c.this.a(c.this.buO, i9, 1, c.this.buN, asList, asList2);
                    } else {
                        c.this.a(c.this.buO, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.buO == c.this.startYear) {
                    int i10 = (c.this.buK + i8) - 1;
                    if (i10 == c.this.buK) {
                        c.this.a(c.this.buO, i10, c.this.buM, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.buO, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.buO == c.this.endYear) {
                    if (i8 == c.this.buL) {
                        c.this.a(c.this.buO, c.this.buF.getCurrentItem() + 1, 1, c.this.buN, asList, asList2);
                    } else {
                        c.this.a(c.this.buO, c.this.buF.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.buO, i8, 1, 31, asList, asList2);
                }
                if (c.this.buP != null) {
                    c.this.buP.Tw();
                }
            }
        });
        a(this.buG);
        a(this.buH);
        a(this.buI);
        a(this.buJ);
        if (this.btq.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.buE.setVisibility(this.btq[0] ? 0 : 8);
        this.buF.setVisibility(this.btq[1] ? 0 : 8);
        this.buG.setVisibility(this.btq[2] ? 0 : 8);
        this.buH.setVisibility(this.btq[3] ? 0 : 8);
        this.buI.setVisibility(this.btq[4] ? 0 : 8);
        this.buJ.setVisibility(this.btq[5] ? 0 : 8);
        TG();
    }

    private void a(WheelView wheelView) {
        if (this.buP != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void hn(int i) {
                    c.this.buP.Tw();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.buG.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.buG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.buG.getAdapter().getItemsCount() - 1) {
            this.buG.setCurrentItem(this.buG.getAdapter().getItemsCount() - 1);
        }
    }

    private void TG() {
        this.buG.setTextSize(this.textSize);
        this.buF.setTextSize(this.textSize);
        this.buE.setTextSize(this.textSize);
        this.buH.setTextSize(this.textSize);
        this.buI.setTextSize(this.textSize);
        this.buJ.setTextSize(this.textSize);
    }

    private void TH() {
        this.buG.setTextColorOut(this.btV);
        this.buF.setTextColorOut(this.btV);
        this.buE.setTextColorOut(this.btV);
        this.buH.setTextColorOut(this.btV);
        this.buI.setTextColorOut(this.btV);
        this.buJ.setTextColorOut(this.btV);
    }

    private void TI() {
        this.buG.setTextColorCenter(this.btW);
        this.buF.setTextColorCenter(this.btW);
        this.buE.setTextColorCenter(this.btW);
        this.buH.setTextColorCenter(this.btW);
        this.buI.setTextColorCenter(this.btW);
        this.buJ.setTextColorCenter(this.btW);
    }

    private void TJ() {
        this.buG.setDividerColor(this.btX);
        this.buF.setDividerColor(this.btX);
        this.buE.setDividerColor(this.btX);
        this.buH.setDividerColor(this.btX);
        this.buI.setDividerColor(this.btX);
        this.buJ.setDividerColor(this.btX);
    }

    private void TK() {
        this.buG.setDividerType(this.bud);
        this.buF.setDividerType(this.bud);
        this.buE.setDividerType(this.bud);
        this.buH.setDividerType(this.bud);
        this.buI.setDividerType(this.bud);
        this.buJ.setDividerType(this.bud);
    }

    private void TL() {
        this.buG.setLineSpacingMultiplier(this.btY);
        this.buF.setLineSpacingMultiplier(this.btY);
        this.buE.setLineSpacingMultiplier(this.btY);
        this.buH.setLineSpacingMultiplier(this.btY);
        this.buI.setLineSpacingMultiplier(this.btY);
        this.buJ.setLineSpacingMultiplier(this.btY);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.btv) {
            if (str != null) {
                this.buE.setLabel(str);
            } else {
                this.buE.setLabel(this.view.getContext().getString(e.j.pickerview_year));
            }
            if (str2 != null) {
                this.buF.setLabel(str2);
            } else {
                this.buF.setLabel(this.view.getContext().getString(e.j.pickerview_month));
            }
            if (str3 != null) {
                this.buG.setLabel(str3);
            } else {
                this.buG.setLabel(this.view.getContext().getString(e.j.pickerview_day));
            }
            if (str4 != null) {
                this.buH.setLabel(str4);
            } else {
                this.buH.setLabel(this.view.getContext().getString(e.j.pickerview_hours));
            }
            if (str5 != null) {
                this.buI.setLabel(str5);
            } else {
                this.buI.setLabel(this.view.getContext().getString(e.j.pickerview_minutes));
            }
            if (str6 != null) {
                this.buJ.setLabel(str6);
            } else {
                this.buJ.setLabel(this.view.getContext().getString(e.j.pickerview_seconds));
            }
        }
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.buG.setTextXOffset(i);
        this.buF.setTextXOffset(i2);
        this.buE.setTextXOffset(i3);
        this.buH.setTextXOffset(i4);
        this.buI.setTextXOffset(i5);
        this.buJ.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.buE.setCyclic(z);
        this.buF.setCyclic(z);
        this.buG.setCyclic(z);
        this.buH.setCyclic(z);
        this.buI.setCyclic(z);
        this.buJ.setCyclic(z);
    }

    public String getTime() {
        if (this.btv) {
            return TM();
        }
        StringBuilder sb = new StringBuilder();
        if (this.buO == this.startYear) {
            if (this.buF.getCurrentItem() + this.buK == this.buK) {
                sb.append(this.buE.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buF.getCurrentItem() + this.buK).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buG.getCurrentItem() + this.buM).append(" ").append(this.buH.getCurrentItem()).append(":").append(this.buI.getCurrentItem()).append(":").append(this.buJ.getCurrentItem());
            } else {
                sb.append(this.buE.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buF.getCurrentItem() + this.buK).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buG.getCurrentItem() + 1).append(" ").append(this.buH.getCurrentItem()).append(":").append(this.buI.getCurrentItem()).append(":").append(this.buJ.getCurrentItem());
            }
        } else {
            sb.append(this.buE.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buF.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.buG.getCurrentItem() + 1).append(" ").append(this.buH.getCurrentItem()).append(":").append(this.buI.getCurrentItem()).append(":").append(this.buJ.getCurrentItem());
        }
        return sb.toString();
    }

    private String TM() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.buE.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem2) == 0) {
            currentItem = this.buF.getCurrentItem() + 1;
            z = false;
        } else if ((this.buF.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem2) <= 0) {
            currentItem = this.buF.getCurrentItem() + 1;
            z = false;
        } else if ((this.buF.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem2) == 1) {
            currentItem = this.buF.getCurrentItem();
            z = true;
        } else {
            currentItem = this.buF.getCurrentItem();
            z = false;
        }
        int[] b = com.baidu.tbadk.widget.timepicker.a.e.b.b(currentItem2, currentItem, this.buG.getCurrentItem() + 1, z);
        sb.append(b[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[2]).append(" ").append(this.buH.getCurrentItem()).append(":").append(this.buI.getCurrentItem()).append(":").append(this.buJ.getCurrentItem());
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
                this.buL = i2;
                this.buN = i3;
            } else if (i == this.startYear) {
                if (i2 > this.buK) {
                    this.endYear = i;
                    this.buL = i2;
                    this.buN = i3;
                } else if (i2 == this.buK && i3 > this.buM) {
                    this.endYear = i;
                    this.buL = i2;
                    this.buN = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.buK = i5;
                this.buM = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.buL) {
                    this.buK = i5;
                    this.buM = i6;
                    this.startYear = i4;
                } else if (i5 == this.buL && i6 < this.buN) {
                    this.buK = i5;
                    this.buM = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.buK = calendar.get(2) + 1;
            this.buL = calendar2.get(2) + 1;
            this.buM = calendar.get(5);
            this.buN = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.btY = f;
        TL();
    }

    public void setDividerColor(int i) {
        this.btX = i;
        TJ();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.bud = dividerType;
        TK();
    }

    public void setTextColorCenter(int i) {
        this.btW = i;
        TI();
    }

    public void setTextColorOut(int i) {
        this.btV = i;
        TH();
    }

    public void dj(boolean z) {
        this.buG.dj(z);
        this.buF.dj(z);
        this.buE.dj(z);
        this.buH.dj(z);
        this.buI.dj(z);
        this.buJ.dj(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.buP = bVar;
    }
}
