package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
    public static DateFormat cZI = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private boolean[] cYu;
    private WheelView cZJ;
    private WheelView cZK;
    private WheelView cZL;
    private WheelView cZM;
    private WheelView cZN;
    private WheelView cZO;
    private int cZT;
    private com.baidu.tbadk.widget.timepicker.a.d.b cZU;
    private int cZb;
    private int cZc;
    private int cZd;
    private float cZe;
    private WheelView.DividerType cZj;
    private int gravity;
    private int textSize;
    private View view;
    private int cYy = 1900;
    private int cYz = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int cZP = 1;
    private int cZQ = 12;
    private int cZR = 1;
    private int cZS = 31;
    private boolean cYB = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.cYu = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void fR(boolean z) {
        this.cYB = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.cYB) {
            int[] A = com.baidu.tbadk.widget.timepicker.a.e.b.A(i, i2 + 1, i3);
            a(A[0], A[1] - 1, A[2], A[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.cZJ = (WheelView) this.view.findViewById(R.id.year);
        this.cZJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.aA(this.cYy, this.cYz)));
        this.cZJ.setLabel("");
        this.cZJ.setCurrentItem(i - this.cYy);
        this.cZJ.setGravity(this.gravity);
        this.cZK = (WheelView) this.view.findViewById(R.id.month);
        this.cZK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.le(i)));
        this.cZK.setLabel("");
        int lb = com.baidu.tbadk.widget.timepicker.a.e.a.lb(i);
        if (lb != 0 && (i2 > lb - 1 || z)) {
            this.cZK.setCurrentItem(i2 + 1);
        } else {
            this.cZK.setCurrentItem(i2);
        }
        this.cZK.setGravity(this.gravity);
        this.cZL = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lb(i) == 0) {
            this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lf(com.baidu.tbadk.widget.timepicker.a.e.a.az(i, i2))));
        } else {
            this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lf(com.baidu.tbadk.widget.timepicker.a.e.a.la(i))));
        }
        this.cZL.setLabel("");
        this.cZL.setCurrentItem(i3 - 1);
        this.cZL.setGravity(this.gravity);
        this.cZM = (WheelView) this.view.findViewById(R.id.hour);
        this.cZM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cZM.setCurrentItem(i4);
        this.cZM.setGravity(this.gravity);
        this.cZN = (WheelView) this.view.findViewById(R.id.min);
        this.cZN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cZN.setCurrentItem(i5);
        this.cZN.setGravity(this.gravity);
        this.cZO = (WheelView) this.view.findViewById(R.id.second);
        this.cZO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cZO.setCurrentItem(i5);
        this.cZO.setGravity(this.gravity);
        this.cZJ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void li(int i7) {
                int az;
                int i8 = c.this.cYy + i7;
                c.this.cZK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.le(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lb(i8) == 0 || c.this.cZK.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lb(i8) - 1) {
                    c.this.cZK.setCurrentItem(c.this.cZK.getCurrentItem());
                } else {
                    c.this.cZK.setCurrentItem(c.this.cZK.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lb(i8) == 0 || c.this.cZK.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.lb(i8) - 1) {
                    c.this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lf(com.baidu.tbadk.widget.timepicker.a.e.a.az(i8, c.this.cZK.getCurrentItem() + 1))));
                    az = com.baidu.tbadk.widget.timepicker.a.e.a.az(i8, c.this.cZK.getCurrentItem() + 1);
                } else if (c.this.cZK.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lb(i8) + 1) {
                    c.this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lf(com.baidu.tbadk.widget.timepicker.a.e.a.la(i8))));
                    az = com.baidu.tbadk.widget.timepicker.a.e.a.la(i8);
                } else {
                    c.this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lf(com.baidu.tbadk.widget.timepicker.a.e.a.az(i8, c.this.cZK.getCurrentItem()))));
                    az = com.baidu.tbadk.widget.timepicker.a.e.a.az(i8, c.this.cZK.getCurrentItem());
                }
                if (c.this.cZL.getCurrentItem() > az - 1) {
                    c.this.cZL.setCurrentItem(az - 1);
                }
                if (c.this.cZU != null) {
                    c.this.cZU.aAh();
                }
            }
        });
        this.cZK.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void li(int i7) {
                int az;
                int currentItem = c.this.cZJ.getCurrentItem() + c.this.cYy;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.lb(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.lb(currentItem) - 1) {
                    c.this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lf(com.baidu.tbadk.widget.timepicker.a.e.a.az(currentItem, i7 + 1))));
                    az = com.baidu.tbadk.widget.timepicker.a.e.a.az(currentItem, i7 + 1);
                } else if (c.this.cZK.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.lb(currentItem) + 1) {
                    c.this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lf(com.baidu.tbadk.widget.timepicker.a.e.a.la(currentItem))));
                    az = com.baidu.tbadk.widget.timepicker.a.e.a.la(currentItem);
                } else {
                    c.this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.lf(com.baidu.tbadk.widget.timepicker.a.e.a.az(currentItem, i7))));
                    az = com.baidu.tbadk.widget.timepicker.a.e.a.az(currentItem, i7);
                }
                if (c.this.cZL.getCurrentItem() > az - 1) {
                    c.this.cZL.setCurrentItem(az - 1);
                }
                if (c.this.cZU != null) {
                    c.this.cZU.aAh();
                }
            }
        });
        a(this.cZL);
        a(this.cZM);
        a(this.cZN);
        a(this.cZO);
        if (this.cYu.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.cZJ.setVisibility(this.cYu[0] ? 0 : 8);
        this.cZK.setVisibility(this.cYu[1] ? 0 : 8);
        this.cZL.setVisibility(this.cYu[2] ? 0 : 8);
        this.cZM.setVisibility(this.cYu[3] ? 0 : 8);
        this.cZN.setVisibility(this.cYu[4] ? 0 : 8);
        this.cZO.setVisibility(this.cYu[5] ? 0 : 8);
        aAt();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", "6", "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.cZT = i;
        this.cZJ = (WheelView) this.view.findViewById(R.id.year);
        this.cZJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cYy, this.cYz));
        this.cZJ.setCurrentItem(i - this.cYy);
        this.cZJ.setGravity(this.gravity);
        this.cZK = (WheelView) this.view.findViewById(R.id.month);
        if (this.cYy == this.cYz) {
            this.cZK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZP, this.cZQ));
            this.cZK.setCurrentItem((i2 + 1) - this.cZP);
        } else if (i == this.cYy) {
            this.cZK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZP, 12));
            this.cZK.setCurrentItem((i2 + 1) - this.cZP);
        } else if (i == this.cYz) {
            this.cZK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cZQ));
            this.cZK.setCurrentItem(i2);
        } else {
            this.cZK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.cZK.setCurrentItem(i2);
        }
        this.cZK.setGravity(this.gravity);
        this.cZL = (WheelView) this.view.findViewById(R.id.day);
        if (this.cYy == this.cYz && this.cZP == this.cZQ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cZS > 31) {
                    this.cZS = 31;
                }
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZR, this.cZS));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cZS > 30) {
                    this.cZS = 30;
                }
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZR, this.cZS));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cZS > 29) {
                    this.cZS = 29;
                }
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZR, this.cZS));
            } else {
                if (this.cZS > 28) {
                    this.cZS = 28;
                }
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZR, this.cZS));
            }
            this.cZL.setCurrentItem(i3 - this.cZR);
        } else if (i == this.cYy && i2 + 1 == this.cZP) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZR, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZR, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZR, 29));
            } else {
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cZR, 28));
            }
            this.cZL.setCurrentItem(i3 - this.cZR);
        } else if (i == this.cYz && i2 + 1 == this.cZQ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cZS > 31) {
                    this.cZS = 31;
                }
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cZS));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cZS > 30) {
                    this.cZS = 30;
                }
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cZS));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cZS > 29) {
                    this.cZS = 29;
                }
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cZS));
            } else {
                if (this.cZS > 28) {
                    this.cZS = 28;
                }
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cZS));
            }
            this.cZL.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.cZL.setCurrentItem(i3 - 1);
        }
        this.cZL.setGravity(this.gravity);
        this.cZM = (WheelView) this.view.findViewById(R.id.hour);
        this.cZM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cZM.setCurrentItem(i4);
        this.cZM.setGravity(this.gravity);
        this.cZN = (WheelView) this.view.findViewById(R.id.min);
        this.cZN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cZN.setCurrentItem(i5);
        this.cZN.setGravity(this.gravity);
        this.cZO = (WheelView) this.view.findViewById(R.id.second);
        this.cZO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cZO.setCurrentItem(i6);
        this.cZO.setGravity(this.gravity);
        this.cZJ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void li(int i7) {
                int i8 = i7 + c.this.cYy;
                c.this.cZT = i8;
                int currentItem = c.this.cZK.getCurrentItem();
                if (c.this.cYy == c.this.cYz) {
                    c.this.cZK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cZP, c.this.cZQ));
                    if (currentItem > c.this.cZK.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cZK.getAdapter().getItemsCount() - 1;
                        c.this.cZK.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.cZP + currentItem;
                    if (c.this.cZP == c.this.cZQ) {
                        c.this.a(i8, i9, c.this.cZR, c.this.cZS, asList, asList2);
                    } else if (i9 == c.this.cZP) {
                        c.this.a(i8, i9, c.this.cZR, 31, asList, asList2);
                    } else if (i9 == c.this.cZQ) {
                        c.this.a(i8, i9, 1, c.this.cZS, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.cYy) {
                    c.this.cZK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cZP, 12));
                    if (currentItem > c.this.cZK.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cZK.getAdapter().getItemsCount() - 1;
                        c.this.cZK.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.cZP + currentItem;
                    if (i10 == c.this.cZP) {
                        c.this.a(i8, i10, c.this.cZR, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.cYz) {
                    c.this.cZK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.cZQ));
                    if (currentItem > c.this.cZK.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cZK.getAdapter().getItemsCount() - 1;
                        c.this.cZK.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.cZQ) {
                        c.this.a(i8, i11, 1, c.this.cZS, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.cZK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.cZK.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.cZU != null) {
                    c.this.cZU.aAh();
                }
            }
        });
        this.cZK.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void li(int i7) {
                int i8 = i7 + 1;
                if (c.this.cYy == c.this.cYz) {
                    int i9 = (c.this.cZP + i8) - 1;
                    if (c.this.cZP == c.this.cZQ) {
                        c.this.a(c.this.cZT, i9, c.this.cZR, c.this.cZS, asList, asList2);
                    } else if (c.this.cZP == i9) {
                        c.this.a(c.this.cZT, i9, c.this.cZR, 31, asList, asList2);
                    } else if (c.this.cZQ == i9) {
                        c.this.a(c.this.cZT, i9, 1, c.this.cZS, asList, asList2);
                    } else {
                        c.this.a(c.this.cZT, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.cZT == c.this.cYy) {
                    int i10 = (c.this.cZP + i8) - 1;
                    if (i10 == c.this.cZP) {
                        c.this.a(c.this.cZT, i10, c.this.cZR, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.cZT, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.cZT == c.this.cYz) {
                    if (i8 == c.this.cZQ) {
                        c.this.a(c.this.cZT, c.this.cZK.getCurrentItem() + 1, 1, c.this.cZS, asList, asList2);
                    } else {
                        c.this.a(c.this.cZT, c.this.cZK.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.cZT, i8, 1, 31, asList, asList2);
                }
                if (c.this.cZU != null) {
                    c.this.cZU.aAh();
                }
            }
        });
        a(this.cZL);
        a(this.cZM);
        a(this.cZN);
        a(this.cZO);
        if (this.cYu.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.cZJ.setVisibility(this.cYu[0] ? 0 : 8);
        this.cZK.setVisibility(this.cYu[1] ? 0 : 8);
        this.cZL.setVisibility(this.cYu[2] ? 0 : 8);
        this.cZM.setVisibility(this.cYu[3] ? 0 : 8);
        this.cZN.setVisibility(this.cYu[4] ? 0 : 8);
        this.cZO.setVisibility(this.cYu[5] ? 0 : 8);
        aAt();
    }

    private void a(WheelView wheelView) {
        if (this.cZU != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void li(int i) {
                    c.this.cZU.aAh();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.cZL.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.cZL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.cZL.getAdapter().getItemsCount() - 1) {
            this.cZL.setCurrentItem(this.cZL.getAdapter().getItemsCount() - 1);
        }
    }

    private void aAt() {
        this.cZL.setTextSize(this.textSize);
        this.cZK.setTextSize(this.textSize);
        this.cZJ.setTextSize(this.textSize);
        this.cZM.setTextSize(this.textSize);
        this.cZN.setTextSize(this.textSize);
        this.cZO.setTextSize(this.textSize);
    }

    private void aAu() {
        this.cZL.setTextColorOut(this.cZb);
        this.cZK.setTextColorOut(this.cZb);
        this.cZJ.setTextColorOut(this.cZb);
        this.cZM.setTextColorOut(this.cZb);
        this.cZN.setTextColorOut(this.cZb);
        this.cZO.setTextColorOut(this.cZb);
    }

    private void aAv() {
        this.cZL.setTextColorCenter(this.cZc);
        this.cZK.setTextColorCenter(this.cZc);
        this.cZJ.setTextColorCenter(this.cZc);
        this.cZM.setTextColorCenter(this.cZc);
        this.cZN.setTextColorCenter(this.cZc);
        this.cZO.setTextColorCenter(this.cZc);
    }

    private void aAw() {
        this.cZL.setDividerColor(this.cZd);
        this.cZK.setDividerColor(this.cZd);
        this.cZJ.setDividerColor(this.cZd);
        this.cZM.setDividerColor(this.cZd);
        this.cZN.setDividerColor(this.cZd);
        this.cZO.setDividerColor(this.cZd);
    }

    private void aAx() {
        this.cZL.setDividerType(this.cZj);
        this.cZK.setDividerType(this.cZj);
        this.cZJ.setDividerType(this.cZj);
        this.cZM.setDividerType(this.cZj);
        this.cZN.setDividerType(this.cZj);
        this.cZO.setDividerType(this.cZj);
    }

    private void aAy() {
        this.cZL.setLineSpacingMultiplier(this.cZe);
        this.cZK.setLineSpacingMultiplier(this.cZe);
        this.cZJ.setLineSpacingMultiplier(this.cZe);
        this.cZM.setLineSpacingMultiplier(this.cZe);
        this.cZN.setLineSpacingMultiplier(this.cZe);
        this.cZO.setLineSpacingMultiplier(this.cZe);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.cYB) {
            if (str != null) {
                this.cZJ.setLabel(str);
            } else {
                this.cZJ.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.cZK.setLabel(str2);
            } else {
                this.cZK.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.cZL.setLabel(str3);
            } else {
                this.cZL.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.cZM.setLabel(str4);
            } else {
                this.cZM.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.cZN.setLabel(str5);
            } else {
                this.cZN.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.cZO.setLabel(str6);
            } else {
                this.cZO.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cZL.setTextXOffset(i);
        this.cZK.setTextXOffset(i2);
        this.cZJ.setTextXOffset(i3);
        this.cZM.setTextXOffset(i4);
        this.cZN.setTextXOffset(i5);
        this.cZO.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.cZJ.setCyclic(z);
        this.cZK.setCyclic(z);
        this.cZL.setCyclic(z);
        this.cZM.setCyclic(z);
        this.cZN.setCyclic(z);
        this.cZO.setCyclic(z);
    }

    public String getTime() {
        if (this.cYB) {
            return aAz();
        }
        StringBuilder sb = new StringBuilder();
        if (this.cZT == this.cYy) {
            if (this.cZK.getCurrentItem() + this.cZP == this.cZP) {
                sb.append(this.cZJ.getCurrentItem() + this.cYy).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cZK.getCurrentItem() + this.cZP).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cZL.getCurrentItem() + this.cZR).append(HanziToPinyin.Token.SEPARATOR).append(this.cZM.getCurrentItem()).append(":").append(this.cZN.getCurrentItem()).append(":").append(this.cZO.getCurrentItem());
            } else {
                sb.append(this.cZJ.getCurrentItem() + this.cYy).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cZK.getCurrentItem() + this.cZP).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cZL.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.cZM.getCurrentItem()).append(":").append(this.cZN.getCurrentItem()).append(":").append(this.cZO.getCurrentItem());
            }
        } else {
            sb.append(this.cZJ.getCurrentItem() + this.cYy).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cZK.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cZL.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.cZM.getCurrentItem()).append(":").append(this.cZN.getCurrentItem()).append(":").append(this.cZO.getCurrentItem());
        }
        return sb.toString();
    }

    private String aAz() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.cZJ.getCurrentItem() + this.cYy;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.lb(currentItem2) == 0) {
            currentItem = this.cZK.getCurrentItem() + 1;
            z = false;
        } else if ((this.cZK.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lb(currentItem2) <= 0) {
            currentItem = this.cZK.getCurrentItem() + 1;
            z = false;
        } else if ((this.cZK.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.lb(currentItem2) == 1) {
            currentItem = this.cZK.getCurrentItem();
            z = true;
        } else {
            currentItem = this.cZK.getCurrentItem();
            z = false;
        }
        int[] e = com.baidu.tbadk.widget.timepicker.a.e.b.e(currentItem2, currentItem, this.cZL.getCurrentItem() + 1, z);
        sb.append(e[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[2]).append(HanziToPinyin.Token.SEPARATOR).append(this.cZM.getCurrentItem()).append(":").append(this.cZN.getCurrentItem()).append(":").append(this.cZO.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void lg(int i) {
        this.cYy = i;
    }

    public void lh(int i) {
        this.cYz = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.cYy) {
                this.cYz = i;
                this.cZQ = i2;
                this.cZS = i3;
            } else if (i == this.cYy) {
                if (i2 > this.cZP) {
                    this.cYz = i;
                    this.cZQ = i2;
                    this.cZS = i3;
                } else if (i2 == this.cZP && i3 > this.cZR) {
                    this.cYz = i;
                    this.cZQ = i2;
                    this.cZS = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.cYz) {
                this.cZP = i5;
                this.cZR = i6;
                this.cYy = i4;
            } else if (i4 == this.cYz) {
                if (i5 < this.cZQ) {
                    this.cZP = i5;
                    this.cZR = i6;
                    this.cYy = i4;
                } else if (i5 == this.cZQ && i6 < this.cZS) {
                    this.cZP = i5;
                    this.cZR = i6;
                    this.cYy = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.cYy = calendar.get(1);
            this.cYz = calendar2.get(1);
            this.cZP = calendar.get(2) + 1;
            this.cZQ = calendar2.get(2) + 1;
            this.cZR = calendar.get(5);
            this.cZS = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.cZe = f;
        aAy();
    }

    public void setDividerColor(int i) {
        this.cZd = i;
        aAw();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.cZj = dividerType;
        aAx();
    }

    public void setTextColorCenter(int i) {
        this.cZc = i;
        aAv();
    }

    public void setTextColorOut(int i) {
        this.cZb = i;
        aAu();
    }

    public void fS(boolean z) {
        this.cZL.fS(z);
        this.cZK.fS(z);
        this.cZJ.fS(z);
        this.cZM.fS(z);
        this.cZN.fS(z);
        this.cZO.fS(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.cZU = bVar;
    }
}
