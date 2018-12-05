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
    public static DateFormat btK = new SimpleDateFormat(AiAppDateTimeUtil.TIME_FORMAT);
    private boolean[] bsx;
    private WheelView btL;
    private WheelView btM;
    private WheelView btN;
    private WheelView btO;
    private WheelView btP;
    private WheelView btQ;
    private int btV;
    private com.baidu.tbadk.widget.timepicker.a.d.b btW;
    private int btc;
    private int btd;
    private int bte;
    private float btf;
    private WheelView.DividerType btk;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = BdDatePicker.START_YEAR;
    private int endYear = 2100;
    private int btR = 1;
    private int btS = 12;
    private int btT = 1;
    private int btU = 31;
    private boolean bsC = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.bsx = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void df(boolean z) {
        this.bsC = z;
    }

    public void f(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.bsC) {
            int[] v = com.baidu.tbadk.widget.timepicker.a.e.b.v(i, i2 + 1, i3);
            a(v[0], v[1] - 1, v[2], v[3] == 1, i4, i5, i6);
            return;
        }
        g(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.btL = (WheelView) this.view.findViewById(e.g.year);
        this.btL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.X(this.startYear, this.endYear)));
        this.btL.setLabel("");
        this.btL.setCurrentItem(i - this.startYear);
        this.btL.setGravity(this.gravity);
        this.btM = (WheelView) this.view.findViewById(e.g.month);
        this.btM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hj(i)));
        this.btM.setLabel("");
        int hg = com.baidu.tbadk.widget.timepicker.a.e.a.hg(i);
        if (hg != 0 && (i2 > hg - 1 || z)) {
            this.btM.setCurrentItem(i2 + 1);
        } else {
            this.btM.setCurrentItem(i2);
        }
        this.btM.setGravity(this.gravity);
        this.btN = (WheelView) this.view.findViewById(e.g.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.hg(i) == 0) {
            this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(com.baidu.tbadk.widget.timepicker.a.e.a.W(i, i2))));
        } else {
            this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(com.baidu.tbadk.widget.timepicker.a.e.a.hf(i))));
        }
        this.btN.setLabel("");
        this.btN.setCurrentItem(i3 - 1);
        this.btN.setGravity(this.gravity);
        this.btO = (WheelView) this.view.findViewById(e.g.hour);
        this.btO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.btO.setCurrentItem(i4);
        this.btO.setGravity(this.gravity);
        this.btP = (WheelView) this.view.findViewById(e.g.min);
        this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.btP.setCurrentItem(i5);
        this.btP.setGravity(this.gravity);
        this.btQ = (WheelView) this.view.findViewById(e.g.second);
        this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.btQ.setCurrentItem(i5);
        this.btQ.setGravity(this.gravity);
        this.btL.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hm(int i7) {
                int W;
                int i8 = c.this.startYear + i7;
                c.this.btM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hj(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8) == 0 || c.this.btM.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8) - 1) {
                    c.this.btM.setCurrentItem(c.this.btM.getCurrentItem());
                } else {
                    c.this.btM.setCurrentItem(c.this.btM.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8) == 0 || c.this.btM.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8) - 1) {
                    c.this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.btM.getCurrentItem() + 1))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.btM.getCurrentItem() + 1);
                } else if (c.this.btM.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8) + 1) {
                    c.this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(com.baidu.tbadk.widget.timepicker.a.e.a.hf(i8))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.hf(i8);
                } else {
                    c.this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.btM.getCurrentItem()))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.btM.getCurrentItem());
                }
                if (c.this.btN.getCurrentItem() > W - 1) {
                    c.this.btN.setCurrentItem(W - 1);
                }
                if (c.this.btW != null) {
                    c.this.btW.SY();
                }
            }
        });
        this.btM.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hm(int i7) {
                int W;
                int currentItem = c.this.btL.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem) - 1) {
                    c.this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7 + 1))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7 + 1);
                } else if (c.this.btM.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem) + 1) {
                    c.this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(com.baidu.tbadk.widget.timepicker.a.e.a.hf(currentItem))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.hf(currentItem);
                } else {
                    c.this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7);
                }
                if (c.this.btN.getCurrentItem() > W - 1) {
                    c.this.btN.setCurrentItem(W - 1);
                }
                if (c.this.btW != null) {
                    c.this.btW.SY();
                }
            }
        });
        a(this.btN);
        a(this.btO);
        a(this.btP);
        a(this.btQ);
        if (this.bsx.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.btL.setVisibility(this.bsx[0] ? 0 : 8);
        this.btM.setVisibility(this.bsx[1] ? 0 : 8);
        this.btN.setVisibility(this.bsx[2] ? 0 : 8);
        this.btO.setVisibility(this.bsx[3] ? 0 : 8);
        this.btP.setVisibility(this.bsx[4] ? 0 : 8);
        this.btQ.setVisibility(this.bsx[5] ? 0 : 8);
        Ti();
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.btV = i;
        this.btL = (WheelView) this.view.findViewById(e.g.year);
        this.btL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.btL.setCurrentItem(i - this.startYear);
        this.btL.setGravity(this.gravity);
        this.btM = (WheelView) this.view.findViewById(e.g.month);
        if (this.startYear == this.endYear) {
            this.btM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btR, this.btS));
            this.btM.setCurrentItem((i2 + 1) - this.btR);
        } else if (i == this.startYear) {
            this.btM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btR, 12));
            this.btM.setCurrentItem((i2 + 1) - this.btR);
        } else if (i == this.endYear) {
            this.btM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.btS));
            this.btM.setCurrentItem(i2);
        } else {
            this.btM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.btM.setCurrentItem(i2);
        }
        this.btM.setGravity(this.gravity);
        this.btN = (WheelView) this.view.findViewById(e.g.day);
        if (this.startYear == this.endYear && this.btR == this.btS) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.btU > 31) {
                    this.btU = 31;
                }
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btT, this.btU));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.btU > 30) {
                    this.btU = 30;
                }
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btT, this.btU));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.btU > 29) {
                    this.btU = 29;
                }
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btT, this.btU));
            } else {
                if (this.btU > 28) {
                    this.btU = 28;
                }
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btT, this.btU));
            }
            this.btN.setCurrentItem(i3 - this.btT);
        } else if (i == this.startYear && i2 + 1 == this.btR) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btT, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btT, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btT, 29));
            } else {
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btT, 28));
            }
            this.btN.setCurrentItem(i3 - this.btT);
        } else if (i == this.endYear && i2 + 1 == this.btS) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.btU > 31) {
                    this.btU = 31;
                }
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.btU));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.btU > 30) {
                    this.btU = 30;
                }
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.btU));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.btU > 29) {
                    this.btU = 29;
                }
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.btU));
            } else {
                if (this.btU > 28) {
                    this.btU = 28;
                }
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.btU));
            }
            this.btN.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.btN.setCurrentItem(i3 - 1);
        }
        this.btN.setGravity(this.gravity);
        this.btO = (WheelView) this.view.findViewById(e.g.hour);
        this.btO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.btO.setCurrentItem(i4);
        this.btO.setGravity(this.gravity);
        this.btP = (WheelView) this.view.findViewById(e.g.min);
        this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.btP.setCurrentItem(i5);
        this.btP.setGravity(this.gravity);
        this.btQ = (WheelView) this.view.findViewById(e.g.second);
        this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.btQ.setCurrentItem(i6);
        this.btQ.setGravity(this.gravity);
        this.btL.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hm(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.btV = i8;
                int currentItem = c.this.btM.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.btM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.btR, c.this.btS));
                    if (currentItem > c.this.btM.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.btM.getAdapter().getItemsCount() - 1;
                        c.this.btM.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.btR + currentItem;
                    if (c.this.btR == c.this.btS) {
                        c.this.a(i8, i9, c.this.btT, c.this.btU, asList, asList2);
                    } else if (i9 == c.this.btR) {
                        c.this.a(i8, i9, c.this.btT, 31, asList, asList2);
                    } else if (i9 == c.this.btS) {
                        c.this.a(i8, i9, 1, c.this.btU, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.btM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.btR, 12));
                    if (currentItem > c.this.btM.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.btM.getAdapter().getItemsCount() - 1;
                        c.this.btM.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.btR + currentItem;
                    if (i10 == c.this.btR) {
                        c.this.a(i8, i10, c.this.btT, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.btM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.btS));
                    if (currentItem > c.this.btM.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.btM.getAdapter().getItemsCount() - 1;
                        c.this.btM.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.btS) {
                        c.this.a(i8, i11, 1, c.this.btU, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.btM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.btM.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.btW != null) {
                    c.this.btW.SY();
                }
            }
        });
        this.btM.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hm(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.btR + i8) - 1;
                    if (c.this.btR == c.this.btS) {
                        c.this.a(c.this.btV, i9, c.this.btT, c.this.btU, asList, asList2);
                    } else if (c.this.btR == i9) {
                        c.this.a(c.this.btV, i9, c.this.btT, 31, asList, asList2);
                    } else if (c.this.btS == i9) {
                        c.this.a(c.this.btV, i9, 1, c.this.btU, asList, asList2);
                    } else {
                        c.this.a(c.this.btV, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.btV == c.this.startYear) {
                    int i10 = (c.this.btR + i8) - 1;
                    if (i10 == c.this.btR) {
                        c.this.a(c.this.btV, i10, c.this.btT, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.btV, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.btV == c.this.endYear) {
                    if (i8 == c.this.btS) {
                        c.this.a(c.this.btV, c.this.btM.getCurrentItem() + 1, 1, c.this.btU, asList, asList2);
                    } else {
                        c.this.a(c.this.btV, c.this.btM.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.btV, i8, 1, 31, asList, asList2);
                }
                if (c.this.btW != null) {
                    c.this.btW.SY();
                }
            }
        });
        a(this.btN);
        a(this.btO);
        a(this.btP);
        a(this.btQ);
        if (this.bsx.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.btL.setVisibility(this.bsx[0] ? 0 : 8);
        this.btM.setVisibility(this.bsx[1] ? 0 : 8);
        this.btN.setVisibility(this.bsx[2] ? 0 : 8);
        this.btO.setVisibility(this.bsx[3] ? 0 : 8);
        this.btP.setVisibility(this.bsx[4] ? 0 : 8);
        this.btQ.setVisibility(this.bsx[5] ? 0 : 8);
        Ti();
    }

    private void a(WheelView wheelView) {
        if (this.btW != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void hm(int i) {
                    c.this.btW.SY();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.btN.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.btN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.btN.getAdapter().getItemsCount() - 1) {
            this.btN.setCurrentItem(this.btN.getAdapter().getItemsCount() - 1);
        }
    }

    private void Ti() {
        this.btN.setTextSize(this.textSize);
        this.btM.setTextSize(this.textSize);
        this.btL.setTextSize(this.textSize);
        this.btO.setTextSize(this.textSize);
        this.btP.setTextSize(this.textSize);
        this.btQ.setTextSize(this.textSize);
    }

    private void Tj() {
        this.btN.setTextColorOut(this.btc);
        this.btM.setTextColorOut(this.btc);
        this.btL.setTextColorOut(this.btc);
        this.btO.setTextColorOut(this.btc);
        this.btP.setTextColorOut(this.btc);
        this.btQ.setTextColorOut(this.btc);
    }

    private void Tk() {
        this.btN.setTextColorCenter(this.btd);
        this.btM.setTextColorCenter(this.btd);
        this.btL.setTextColorCenter(this.btd);
        this.btO.setTextColorCenter(this.btd);
        this.btP.setTextColorCenter(this.btd);
        this.btQ.setTextColorCenter(this.btd);
    }

    private void Tl() {
        this.btN.setDividerColor(this.bte);
        this.btM.setDividerColor(this.bte);
        this.btL.setDividerColor(this.bte);
        this.btO.setDividerColor(this.bte);
        this.btP.setDividerColor(this.bte);
        this.btQ.setDividerColor(this.bte);
    }

    private void Tm() {
        this.btN.setDividerType(this.btk);
        this.btM.setDividerType(this.btk);
        this.btL.setDividerType(this.btk);
        this.btO.setDividerType(this.btk);
        this.btP.setDividerType(this.btk);
        this.btQ.setDividerType(this.btk);
    }

    private void Tn() {
        this.btN.setLineSpacingMultiplier(this.btf);
        this.btM.setLineSpacingMultiplier(this.btf);
        this.btL.setLineSpacingMultiplier(this.btf);
        this.btO.setLineSpacingMultiplier(this.btf);
        this.btP.setLineSpacingMultiplier(this.btf);
        this.btQ.setLineSpacingMultiplier(this.btf);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.bsC) {
            if (str != null) {
                this.btL.setLabel(str);
            } else {
                this.btL.setLabel(this.view.getContext().getString(e.j.pickerview_year));
            }
            if (str2 != null) {
                this.btM.setLabel(str2);
            } else {
                this.btM.setLabel(this.view.getContext().getString(e.j.pickerview_month));
            }
            if (str3 != null) {
                this.btN.setLabel(str3);
            } else {
                this.btN.setLabel(this.view.getContext().getString(e.j.pickerview_day));
            }
            if (str4 != null) {
                this.btO.setLabel(str4);
            } else {
                this.btO.setLabel(this.view.getContext().getString(e.j.pickerview_hours));
            }
            if (str5 != null) {
                this.btP.setLabel(str5);
            } else {
                this.btP.setLabel(this.view.getContext().getString(e.j.pickerview_minutes));
            }
            if (str6 != null) {
                this.btQ.setLabel(str6);
            } else {
                this.btQ.setLabel(this.view.getContext().getString(e.j.pickerview_seconds));
            }
        }
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.btN.setTextXOffset(i);
        this.btM.setTextXOffset(i2);
        this.btL.setTextXOffset(i3);
        this.btO.setTextXOffset(i4);
        this.btP.setTextXOffset(i5);
        this.btQ.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.btL.setCyclic(z);
        this.btM.setCyclic(z);
        this.btN.setCyclic(z);
        this.btO.setCyclic(z);
        this.btP.setCyclic(z);
        this.btQ.setCyclic(z);
    }

    public String getTime() {
        if (this.bsC) {
            return To();
        }
        StringBuilder sb = new StringBuilder();
        if (this.btV == this.startYear) {
            if (this.btM.getCurrentItem() + this.btR == this.btR) {
                sb.append(this.btL.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btM.getCurrentItem() + this.btR).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btN.getCurrentItem() + this.btT).append(" ").append(this.btO.getCurrentItem()).append(":").append(this.btP.getCurrentItem()).append(":").append(this.btQ.getCurrentItem());
            } else {
                sb.append(this.btL.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btM.getCurrentItem() + this.btR).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btN.getCurrentItem() + 1).append(" ").append(this.btO.getCurrentItem()).append(":").append(this.btP.getCurrentItem()).append(":").append(this.btQ.getCurrentItem());
            }
        } else {
            sb.append(this.btL.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btM.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btN.getCurrentItem() + 1).append(" ").append(this.btO.getCurrentItem()).append(":").append(this.btP.getCurrentItem()).append(":").append(this.btQ.getCurrentItem());
        }
        return sb.toString();
    }

    private String To() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.btL.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem2) == 0) {
            currentItem = this.btM.getCurrentItem() + 1;
            z = false;
        } else if ((this.btM.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem2) <= 0) {
            currentItem = this.btM.getCurrentItem() + 1;
            z = false;
        } else if ((this.btM.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem2) == 1) {
            currentItem = this.btM.getCurrentItem();
            z = true;
        } else {
            currentItem = this.btM.getCurrentItem();
            z = false;
        }
        int[] b = com.baidu.tbadk.widget.timepicker.a.e.b.b(currentItem2, currentItem, this.btN.getCurrentItem() + 1, z);
        sb.append(b[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[2]).append(" ").append(this.btO.getCurrentItem()).append(":").append(this.btP.getCurrentItem()).append(":").append(this.btQ.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void hl(int i) {
        this.endYear = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.startYear) {
                this.endYear = i;
                this.btS = i2;
                this.btU = i3;
            } else if (i == this.startYear) {
                if (i2 > this.btR) {
                    this.endYear = i;
                    this.btS = i2;
                    this.btU = i3;
                } else if (i2 == this.btR && i3 > this.btT) {
                    this.endYear = i;
                    this.btS = i2;
                    this.btU = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.btR = i5;
                this.btT = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.btS) {
                    this.btR = i5;
                    this.btT = i6;
                    this.startYear = i4;
                } else if (i5 == this.btS && i6 < this.btU) {
                    this.btR = i5;
                    this.btT = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.btR = calendar.get(2) + 1;
            this.btS = calendar2.get(2) + 1;
            this.btT = calendar.get(5);
            this.btU = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.btf = f;
        Tn();
    }

    public void setDividerColor(int i) {
        this.bte = i;
        Tl();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.btk = dividerType;
        Tm();
    }

    public void setTextColorCenter(int i) {
        this.btd = i;
        Tk();
    }

    public void setTextColorOut(int i) {
        this.btc = i;
        Tj();
    }

    public void dg(boolean z) {
        this.btN.dg(z);
        this.btM.dg(z);
        this.btL.dg(z);
        this.btO.dg(z);
        this.btP.dg(z);
        this.btQ.dg(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.btW = bVar;
    }
}
