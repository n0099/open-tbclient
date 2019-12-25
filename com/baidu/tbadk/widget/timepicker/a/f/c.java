package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.searchbox.ugc.model.PublishType;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes5.dex */
public class c {
    public static DateFormat dNt = new SimpleDateFormat(DateTimeUtil.TIME_FORMAT);
    private WheelView.DividerType dMX;
    private boolean[] dMn;
    private int dNE;
    private com.baidu.tbadk.widget.timepicker.a.d.b dNF;
    private WheelView dNu;
    private WheelView dNv;
    private WheelView dNw;
    private WheelView dNx;
    private WheelView dNy;
    private WheelView dNz;
    private int dividerColor;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int dMr = 1900;
    private int dMs = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int dNA = 1;
    private int dNB = 12;
    private int dNC = 1;
    private int dND = 31;
    private boolean dMu = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.dMn = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void hg(boolean z) {
        this.dMu = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.dMu) {
            int[] A = com.baidu.tbadk.widget.timepicker.a.e.b.A(i, i2 + 1, i3);
            a(A[0], A[1] - 1, A[2], A[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.dNu = (WheelView) this.view.findViewById(R.id.year);
        this.dNu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.aS(this.dMr, this.dMs)));
        this.dNu.setLabel("");
        this.dNu.setCurrentItem(i - this.dMr);
        this.dNu.setGravity(this.gravity);
        this.dNv = (WheelView) this.view.findViewById(R.id.month);
        this.dNv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nt(i)));
        this.dNv.setLabel("");
        int nq = com.baidu.tbadk.widget.timepicker.a.e.a.nq(i);
        if (nq != 0 && (i2 > nq - 1 || z)) {
            this.dNv.setCurrentItem(i2 + 1);
        } else {
            this.dNv.setCurrentItem(i2);
        }
        this.dNv.setGravity(this.gravity);
        this.dNw = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nq(i) == 0) {
            this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.aR(i, i2))));
        } else {
            this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.np(i))));
        }
        this.dNw.setLabel("");
        this.dNw.setCurrentItem(i3 - 1);
        this.dNw.setGravity(this.gravity);
        this.dNx = (WheelView) this.view.findViewById(R.id.hour);
        this.dNx.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dNx.setCurrentItem(i4);
        this.dNx.setGravity(this.gravity);
        this.dNy = (WheelView) this.view.findViewById(R.id.min);
        this.dNy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dNy.setCurrentItem(i5);
        this.dNy.setGravity(this.gravity);
        this.dNz = (WheelView) this.view.findViewById(R.id.second);
        this.dNz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dNz.setCurrentItem(i5);
        this.dNz.setGravity(this.gravity);
        this.dNu.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aR;
                int i8 = c.this.dMr + i7;
                c.this.dNv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nt(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nq(i8) == 0 || c.this.dNv.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nq(i8) - 1) {
                    c.this.dNv.setCurrentItem(c.this.dNv.getCurrentItem());
                } else {
                    c.this.dNv.setCurrentItem(c.this.dNv.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nq(i8) == 0 || c.this.dNv.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nq(i8) - 1) {
                    c.this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.aR(i8, c.this.dNv.getCurrentItem() + 1))));
                    aR = com.baidu.tbadk.widget.timepicker.a.e.a.aR(i8, c.this.dNv.getCurrentItem() + 1);
                } else if (c.this.dNv.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nq(i8) + 1) {
                    c.this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.np(i8))));
                    aR = com.baidu.tbadk.widget.timepicker.a.e.a.np(i8);
                } else {
                    c.this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.aR(i8, c.this.dNv.getCurrentItem()))));
                    aR = com.baidu.tbadk.widget.timepicker.a.e.a.aR(i8, c.this.dNv.getCurrentItem());
                }
                if (c.this.dNw.getCurrentItem() > aR - 1) {
                    c.this.dNw.setCurrentItem(aR - 1);
                }
                if (c.this.dNF != null) {
                    c.this.dNF.aSf();
                }
            }
        });
        this.dNv.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aR;
                int currentItem = c.this.dNu.getCurrentItem() + c.this.dMr;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem) - 1) {
                    c.this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.aR(currentItem, i7 + 1))));
                    aR = com.baidu.tbadk.widget.timepicker.a.e.a.aR(currentItem, i7 + 1);
                } else if (c.this.dNv.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem) + 1) {
                    c.this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.np(currentItem))));
                    aR = com.baidu.tbadk.widget.timepicker.a.e.a.np(currentItem);
                } else {
                    c.this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.aR(currentItem, i7))));
                    aR = com.baidu.tbadk.widget.timepicker.a.e.a.aR(currentItem, i7);
                }
                if (c.this.dNw.getCurrentItem() > aR - 1) {
                    c.this.dNw.setCurrentItem(aR - 1);
                }
                if (c.this.dNF != null) {
                    c.this.dNF.aSf();
                }
            }
        });
        a(this.dNw);
        a(this.dNx);
        a(this.dNy);
        a(this.dNz);
        if (this.dMn.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.dNu.setVisibility(this.dMn[0] ? 0 : 8);
        this.dNv.setVisibility(this.dMn[1] ? 0 : 8);
        this.dNw.setVisibility(this.dMn[2] ? 0 : 8);
        this.dNx.setVisibility(this.dMn[3] ? 0 : 8);
        this.dNy.setVisibility(this.dMn[4] ? 0 : 8);
        this.dNz.setVisibility(this.dMn[5] ? 0 : 8);
        aSn();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"4", "6", PublishType.TYPE_VIDEO_SHARE, "11"};
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList(strArr);
        this.dNE = i;
        this.dNu = (WheelView) this.view.findViewById(R.id.year);
        this.dNu.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dMr, this.dMs));
        this.dNu.setCurrentItem(i - this.dMr);
        this.dNu.setGravity(this.gravity);
        this.dNv = (WheelView) this.view.findViewById(R.id.month);
        if (this.dMr == this.dMs) {
            this.dNv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNA, this.dNB));
            this.dNv.setCurrentItem((i2 + 1) - this.dNA);
        } else if (i == this.dMr) {
            this.dNv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNA, 12));
            this.dNv.setCurrentItem((i2 + 1) - this.dNA);
        } else if (i == this.dMs) {
            this.dNv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dNB));
            this.dNv.setCurrentItem(i2);
        } else {
            this.dNv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.dNv.setCurrentItem(i2);
        }
        this.dNv.setGravity(this.gravity);
        this.dNw = (WheelView) this.view.findViewById(R.id.day);
        if (this.dMr == this.dMs && this.dNA == this.dNB) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dND > 31) {
                    this.dND = 31;
                }
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNC, this.dND));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dND > 30) {
                    this.dND = 30;
                }
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNC, this.dND));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dND > 29) {
                    this.dND = 29;
                }
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNC, this.dND));
            } else {
                if (this.dND > 28) {
                    this.dND = 28;
                }
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNC, this.dND));
            }
            this.dNw.setCurrentItem(i3 - this.dNC);
        } else if (i == this.dMr && i2 + 1 == this.dNA) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNC, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNC, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNC, 29));
            } else {
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNC, 28));
            }
            this.dNw.setCurrentItem(i3 - this.dNC);
        } else if (i == this.dMs && i2 + 1 == this.dNB) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dND > 31) {
                    this.dND = 31;
                }
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dND));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dND > 30) {
                    this.dND = 30;
                }
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dND));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dND > 29) {
                    this.dND = 29;
                }
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dND));
            } else {
                if (this.dND > 28) {
                    this.dND = 28;
                }
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dND));
            }
            this.dNw.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.dNw.setCurrentItem(i3 - 1);
        }
        this.dNw.setGravity(this.gravity);
        this.dNx = (WheelView) this.view.findViewById(R.id.hour);
        this.dNx.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dNx.setCurrentItem(i4);
        this.dNx.setGravity(this.gravity);
        this.dNy = (WheelView) this.view.findViewById(R.id.min);
        this.dNy.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dNy.setCurrentItem(i5);
        this.dNy.setGravity(this.gravity);
        this.dNz = (WheelView) this.view.findViewById(R.id.second);
        this.dNz.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dNz.setCurrentItem(i6);
        this.dNz.setGravity(this.gravity);
        this.dNu.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.dMr;
                c.this.dNE = i8;
                int currentItem = c.this.dNv.getCurrentItem();
                if (c.this.dMr == c.this.dMs) {
                    c.this.dNv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dNA, c.this.dNB));
                    if (currentItem > c.this.dNv.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dNv.getAdapter().getItemsCount() - 1;
                        c.this.dNv.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.dNA + currentItem;
                    if (c.this.dNA == c.this.dNB) {
                        c.this.a(i8, i9, c.this.dNC, c.this.dND, asList, asList2);
                    } else if (i9 == c.this.dNA) {
                        c.this.a(i8, i9, c.this.dNC, 31, asList, asList2);
                    } else if (i9 == c.this.dNB) {
                        c.this.a(i8, i9, 1, c.this.dND, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dMr) {
                    c.this.dNv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dNA, 12));
                    if (currentItem > c.this.dNv.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dNv.getAdapter().getItemsCount() - 1;
                        c.this.dNv.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.dNA + currentItem;
                    if (i10 == c.this.dNA) {
                        c.this.a(i8, i10, c.this.dNC, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dMs) {
                    c.this.dNv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.dNB));
                    if (currentItem > c.this.dNv.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dNv.getAdapter().getItemsCount() - 1;
                        c.this.dNv.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.dNB) {
                        c.this.a(i8, i11, 1, c.this.dND, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.dNv.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.dNv.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.dNF != null) {
                    c.this.dNF.aSf();
                }
            }
        });
        this.dNv.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.dMr == c.this.dMs) {
                    int i9 = (c.this.dNA + i8) - 1;
                    if (c.this.dNA == c.this.dNB) {
                        c.this.a(c.this.dNE, i9, c.this.dNC, c.this.dND, asList, asList2);
                    } else if (c.this.dNA == i9) {
                        c.this.a(c.this.dNE, i9, c.this.dNC, 31, asList, asList2);
                    } else if (c.this.dNB == i9) {
                        c.this.a(c.this.dNE, i9, 1, c.this.dND, asList, asList2);
                    } else {
                        c.this.a(c.this.dNE, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.dNE == c.this.dMr) {
                    int i10 = (c.this.dNA + i8) - 1;
                    if (i10 == c.this.dNA) {
                        c.this.a(c.this.dNE, i10, c.this.dNC, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.dNE, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.dNE == c.this.dMs) {
                    if (i8 == c.this.dNB) {
                        c.this.a(c.this.dNE, c.this.dNv.getCurrentItem() + 1, 1, c.this.dND, asList, asList2);
                    } else {
                        c.this.a(c.this.dNE, c.this.dNv.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.dNE, i8, 1, 31, asList, asList2);
                }
                if (c.this.dNF != null) {
                    c.this.dNF.aSf();
                }
            }
        });
        a(this.dNw);
        a(this.dNx);
        a(this.dNy);
        a(this.dNz);
        if (this.dMn.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.dNu.setVisibility(this.dMn[0] ? 0 : 8);
        this.dNv.setVisibility(this.dMn[1] ? 0 : 8);
        this.dNw.setVisibility(this.dMn[2] ? 0 : 8);
        this.dNx.setVisibility(this.dMn[3] ? 0 : 8);
        this.dNy.setVisibility(this.dMn[4] ? 0 : 8);
        this.dNz.setVisibility(this.dMn[5] ? 0 : 8);
        aSn();
    }

    private void a(WheelView wheelView) {
        if (this.dNF != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.dNF.aSf();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.dNw.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.dNw.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.dNw.getAdapter().getItemsCount() - 1) {
            this.dNw.setCurrentItem(this.dNw.getAdapter().getItemsCount() - 1);
        }
    }

    private void aSn() {
        this.dNw.setTextSize(this.textSize);
        this.dNv.setTextSize(this.textSize);
        this.dNu.setTextSize(this.textSize);
        this.dNx.setTextSize(this.textSize);
        this.dNy.setTextSize(this.textSize);
        this.dNz.setTextSize(this.textSize);
    }

    private void aSo() {
        this.dNw.setTextColorOut(this.textColorOut);
        this.dNv.setTextColorOut(this.textColorOut);
        this.dNu.setTextColorOut(this.textColorOut);
        this.dNx.setTextColorOut(this.textColorOut);
        this.dNy.setTextColorOut(this.textColorOut);
        this.dNz.setTextColorOut(this.textColorOut);
    }

    private void aSp() {
        this.dNw.setTextColorCenter(this.textColorCenter);
        this.dNv.setTextColorCenter(this.textColorCenter);
        this.dNu.setTextColorCenter(this.textColorCenter);
        this.dNx.setTextColorCenter(this.textColorCenter);
        this.dNy.setTextColorCenter(this.textColorCenter);
        this.dNz.setTextColorCenter(this.textColorCenter);
    }

    private void aSq() {
        this.dNw.setDividerColor(this.dividerColor);
        this.dNv.setDividerColor(this.dividerColor);
        this.dNu.setDividerColor(this.dividerColor);
        this.dNx.setDividerColor(this.dividerColor);
        this.dNy.setDividerColor(this.dividerColor);
        this.dNz.setDividerColor(this.dividerColor);
    }

    private void aSr() {
        this.dNw.setDividerType(this.dMX);
        this.dNv.setDividerType(this.dMX);
        this.dNu.setDividerType(this.dMX);
        this.dNx.setDividerType(this.dMX);
        this.dNy.setDividerType(this.dMX);
        this.dNz.setDividerType(this.dMX);
    }

    private void aSs() {
        this.dNw.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dNv.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dNu.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dNx.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dNy.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dNz.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.dMu) {
            if (str != null) {
                this.dNu.setLabel(str);
            } else {
                this.dNu.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.dNv.setLabel(str2);
            } else {
                this.dNv.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.dNw.setLabel(str3);
            } else {
                this.dNw.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.dNx.setLabel(str4);
            } else {
                this.dNx.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.dNy.setLabel(str5);
            } else {
                this.dNy.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.dNz.setLabel(str6);
            } else {
                this.dNz.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dNw.setTextXOffset(i);
        this.dNv.setTextXOffset(i2);
        this.dNu.setTextXOffset(i3);
        this.dNx.setTextXOffset(i4);
        this.dNy.setTextXOffset(i5);
        this.dNz.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.dNu.setCyclic(z);
        this.dNv.setCyclic(z);
        this.dNw.setCyclic(z);
        this.dNx.setCyclic(z);
        this.dNy.setCyclic(z);
        this.dNz.setCyclic(z);
    }

    public String getTime() {
        if (this.dMu) {
            return aSt();
        }
        StringBuilder sb = new StringBuilder();
        if (this.dNE == this.dMr) {
            if (this.dNv.getCurrentItem() + this.dNA == this.dNA) {
                sb.append(this.dNu.getCurrentItem() + this.dMr).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dNv.getCurrentItem() + this.dNA).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dNw.getCurrentItem() + this.dNC).append(HanziToPinyin.Token.SEPARATOR).append(this.dNx.getCurrentItem()).append(":").append(this.dNy.getCurrentItem()).append(":").append(this.dNz.getCurrentItem());
            } else {
                sb.append(this.dNu.getCurrentItem() + this.dMr).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dNv.getCurrentItem() + this.dNA).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dNw.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dNx.getCurrentItem()).append(":").append(this.dNy.getCurrentItem()).append(":").append(this.dNz.getCurrentItem());
            }
        } else {
            sb.append(this.dNu.getCurrentItem() + this.dMr).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dNv.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dNw.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dNx.getCurrentItem()).append(":").append(this.dNy.getCurrentItem()).append(":").append(this.dNz.getCurrentItem());
        }
        return sb.toString();
    }

    private String aSt() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.dNu.getCurrentItem() + this.dMr;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem2) == 0) {
            currentItem = this.dNv.getCurrentItem() + 1;
            z = false;
        } else if ((this.dNv.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem2) <= 0) {
            currentItem = this.dNv.getCurrentItem() + 1;
            z = false;
        } else if ((this.dNv.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem2) == 1) {
            currentItem = this.dNv.getCurrentItem();
            z = true;
        } else {
            currentItem = this.dNv.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.dNw.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(HanziToPinyin.Token.SEPARATOR).append(this.dNx.getCurrentItem()).append(":").append(this.dNy.getCurrentItem()).append(":").append(this.dNz.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void nv(int i) {
        this.dMr = i;
    }

    public void nw(int i) {
        this.dMs = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.dMr) {
                this.dMs = i;
                this.dNB = i2;
                this.dND = i3;
            } else if (i == this.dMr) {
                if (i2 > this.dNA) {
                    this.dMs = i;
                    this.dNB = i2;
                    this.dND = i3;
                } else if (i2 == this.dNA && i3 > this.dNC) {
                    this.dMs = i;
                    this.dNB = i2;
                    this.dND = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.dMs) {
                this.dNA = i5;
                this.dNC = i6;
                this.dMr = i4;
            } else if (i4 == this.dMs) {
                if (i5 < this.dNB) {
                    this.dNA = i5;
                    this.dNC = i6;
                    this.dMr = i4;
                } else if (i5 == this.dNB && i6 < this.dND) {
                    this.dNA = i5;
                    this.dNC = i6;
                    this.dMr = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.dMr = calendar.get(1);
            this.dMs = calendar2.get(1);
            this.dNA = calendar.get(2) + 1;
            this.dNB = calendar2.get(2) + 1;
            this.dNC = calendar.get(5);
            this.dND = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        aSs();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        aSq();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.dMX = dividerType;
        aSr();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        aSp();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        aSo();
    }

    public void isCenterLabel(boolean z) {
        this.dNw.isCenterLabel(z);
        this.dNv.isCenterLabel(z);
        this.dNu.isCenterLabel(z);
        this.dNx.isCenterLabel(z);
        this.dNy.isCenterLabel(z);
        this.dNz.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.dNF = bVar;
    }
}
