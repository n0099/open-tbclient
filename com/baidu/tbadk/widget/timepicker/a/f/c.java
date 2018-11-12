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
    public static DateFormat bqm = new SimpleDateFormat(AiAppDateTimeUtil.TIME_FORMAT);
    private int bpF;
    private int bpG;
    private int bpH;
    private float bpI;
    private WheelView.DividerType bpN;
    private boolean[] bpa;
    private WheelView bqn;
    private WheelView bqo;
    private WheelView bqp;
    private WheelView bqq;
    private WheelView bqr;
    private WheelView bqs;
    private int bqx;
    private com.baidu.tbadk.widget.timepicker.a.d.b bqy;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = BdDatePicker.START_YEAR;
    private int endYear = 2100;
    private int bqt = 1;
    private int bqu = 12;
    private int bqv = 1;
    private int bqw = 31;
    private boolean bpf = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.bpa = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void de(boolean z) {
        this.bpf = z;
    }

    public void f(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.bpf) {
            int[] v = com.baidu.tbadk.widget.timepicker.a.e.b.v(i, i2 + 1, i3);
            a(v[0], v[1] - 1, v[2], v[3] == 1, i4, i5, i6);
            return;
        }
        g(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.bqn = (WheelView) this.view.findViewById(e.g.year);
        this.bqn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.W(this.startYear, this.endYear)));
        this.bqn.setLabel("");
        this.bqn.setCurrentItem(i - this.startYear);
        this.bqn.setGravity(this.gravity);
        this.bqo = (WheelView) this.view.findViewById(e.g.month);
        this.bqo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gV(i)));
        this.bqo.setLabel("");
        int gS = com.baidu.tbadk.widget.timepicker.a.e.a.gS(i);
        if (gS != 0 && (i2 > gS - 1 || z)) {
            this.bqo.setCurrentItem(i2 + 1);
        } else {
            this.bqo.setCurrentItem(i2);
        }
        this.bqo.setGravity(this.gravity);
        this.bqp = (WheelView) this.view.findViewById(e.g.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.gS(i) == 0) {
            this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gW(com.baidu.tbadk.widget.timepicker.a.e.a.V(i, i2))));
        } else {
            this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gW(com.baidu.tbadk.widget.timepicker.a.e.a.gR(i))));
        }
        this.bqp.setLabel("");
        this.bqp.setCurrentItem(i3 - 1);
        this.bqp.setGravity(this.gravity);
        this.bqq = (WheelView) this.view.findViewById(e.g.hour);
        this.bqq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.bqq.setCurrentItem(i4);
        this.bqq.setGravity(this.gravity);
        this.bqr = (WheelView) this.view.findViewById(e.g.min);
        this.bqr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.bqr.setCurrentItem(i5);
        this.bqr.setGravity(this.gravity);
        this.bqs = (WheelView) this.view.findViewById(e.g.second);
        this.bqs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.bqs.setCurrentItem(i5);
        this.bqs.setGravity(this.gravity);
        this.bqn.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gY(int i7) {
                int V;
                int i8 = c.this.startYear + i7;
                c.this.bqo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gV(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.gS(i8) == 0 || c.this.bqo.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.gS(i8) - 1) {
                    c.this.bqo.setCurrentItem(c.this.bqo.getCurrentItem());
                } else {
                    c.this.bqo.setCurrentItem(c.this.bqo.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.gS(i8) == 0 || c.this.bqo.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.gS(i8) - 1) {
                    c.this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gW(com.baidu.tbadk.widget.timepicker.a.e.a.V(i8, c.this.bqo.getCurrentItem() + 1))));
                    V = com.baidu.tbadk.widget.timepicker.a.e.a.V(i8, c.this.bqo.getCurrentItem() + 1);
                } else if (c.this.bqo.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.gS(i8) + 1) {
                    c.this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gW(com.baidu.tbadk.widget.timepicker.a.e.a.gR(i8))));
                    V = com.baidu.tbadk.widget.timepicker.a.e.a.gR(i8);
                } else {
                    c.this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gW(com.baidu.tbadk.widget.timepicker.a.e.a.V(i8, c.this.bqo.getCurrentItem()))));
                    V = com.baidu.tbadk.widget.timepicker.a.e.a.V(i8, c.this.bqo.getCurrentItem());
                }
                if (c.this.bqp.getCurrentItem() > V - 1) {
                    c.this.bqp.setCurrentItem(V - 1);
                }
                if (c.this.bqy != null) {
                    c.this.bqy.RS();
                }
            }
        });
        this.bqo.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gY(int i7) {
                int V;
                int currentItem = c.this.bqn.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.gS(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.gS(currentItem) - 1) {
                    c.this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gW(com.baidu.tbadk.widget.timepicker.a.e.a.V(currentItem, i7 + 1))));
                    V = com.baidu.tbadk.widget.timepicker.a.e.a.V(currentItem, i7 + 1);
                } else if (c.this.bqo.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.gS(currentItem) + 1) {
                    c.this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gW(com.baidu.tbadk.widget.timepicker.a.e.a.gR(currentItem))));
                    V = com.baidu.tbadk.widget.timepicker.a.e.a.gR(currentItem);
                } else {
                    c.this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gW(com.baidu.tbadk.widget.timepicker.a.e.a.V(currentItem, i7))));
                    V = com.baidu.tbadk.widget.timepicker.a.e.a.V(currentItem, i7);
                }
                if (c.this.bqp.getCurrentItem() > V - 1) {
                    c.this.bqp.setCurrentItem(V - 1);
                }
                if (c.this.bqy != null) {
                    c.this.bqy.RS();
                }
            }
        });
        a(this.bqp);
        a(this.bqq);
        a(this.bqr);
        a(this.bqs);
        if (this.bpa.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.bqn.setVisibility(this.bpa[0] ? 0 : 8);
        this.bqo.setVisibility(this.bpa[1] ? 0 : 8);
        this.bqp.setVisibility(this.bpa[2] ? 0 : 8);
        this.bqq.setVisibility(this.bpa[3] ? 0 : 8);
        this.bqr.setVisibility(this.bpa[4] ? 0 : 8);
        this.bqs.setVisibility(this.bpa[5] ? 0 : 8);
        Sc();
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.bqx = i;
        this.bqn = (WheelView) this.view.findViewById(e.g.year);
        this.bqn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.bqn.setCurrentItem(i - this.startYear);
        this.bqn.setGravity(this.gravity);
        this.bqo = (WheelView) this.view.findViewById(e.g.month);
        if (this.startYear == this.endYear) {
            this.bqo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bqt, this.bqu));
            this.bqo.setCurrentItem((i2 + 1) - this.bqt);
        } else if (i == this.startYear) {
            this.bqo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bqt, 12));
            this.bqo.setCurrentItem((i2 + 1) - this.bqt);
        } else if (i == this.endYear) {
            this.bqo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.bqu));
            this.bqo.setCurrentItem(i2);
        } else {
            this.bqo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.bqo.setCurrentItem(i2);
        }
        this.bqo.setGravity(this.gravity);
        this.bqp = (WheelView) this.view.findViewById(e.g.day);
        if (this.startYear == this.endYear && this.bqt == this.bqu) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.bqw > 31) {
                    this.bqw = 31;
                }
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bqv, this.bqw));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.bqw > 30) {
                    this.bqw = 30;
                }
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bqv, this.bqw));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.bqw > 29) {
                    this.bqw = 29;
                }
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bqv, this.bqw));
            } else {
                if (this.bqw > 28) {
                    this.bqw = 28;
                }
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bqv, this.bqw));
            }
            this.bqp.setCurrentItem(i3 - this.bqv);
        } else if (i == this.startYear && i2 + 1 == this.bqt) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bqv, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bqv, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bqv, 29));
            } else {
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bqv, 28));
            }
            this.bqp.setCurrentItem(i3 - this.bqv);
        } else if (i == this.endYear && i2 + 1 == this.bqu) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.bqw > 31) {
                    this.bqw = 31;
                }
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.bqw));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.bqw > 30) {
                    this.bqw = 30;
                }
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.bqw));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.bqw > 29) {
                    this.bqw = 29;
                }
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.bqw));
            } else {
                if (this.bqw > 28) {
                    this.bqw = 28;
                }
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.bqw));
            }
            this.bqp.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.bqp.setCurrentItem(i3 - 1);
        }
        this.bqp.setGravity(this.gravity);
        this.bqq = (WheelView) this.view.findViewById(e.g.hour);
        this.bqq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.bqq.setCurrentItem(i4);
        this.bqq.setGravity(this.gravity);
        this.bqr = (WheelView) this.view.findViewById(e.g.min);
        this.bqr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.bqr.setCurrentItem(i5);
        this.bqr.setGravity(this.gravity);
        this.bqs = (WheelView) this.view.findViewById(e.g.second);
        this.bqs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.bqs.setCurrentItem(i6);
        this.bqs.setGravity(this.gravity);
        this.bqn.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gY(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.bqx = i8;
                int currentItem = c.this.bqo.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.bqo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.bqt, c.this.bqu));
                    if (currentItem > c.this.bqo.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.bqo.getAdapter().getItemsCount() - 1;
                        c.this.bqo.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.bqt + currentItem;
                    if (c.this.bqt == c.this.bqu) {
                        c.this.a(i8, i9, c.this.bqv, c.this.bqw, asList, asList2);
                    } else if (i9 == c.this.bqt) {
                        c.this.a(i8, i9, c.this.bqv, 31, asList, asList2);
                    } else if (i9 == c.this.bqu) {
                        c.this.a(i8, i9, 1, c.this.bqw, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.bqo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.bqt, 12));
                    if (currentItem > c.this.bqo.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.bqo.getAdapter().getItemsCount() - 1;
                        c.this.bqo.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.bqt + currentItem;
                    if (i10 == c.this.bqt) {
                        c.this.a(i8, i10, c.this.bqv, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.bqo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.bqu));
                    if (currentItem > c.this.bqo.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.bqo.getAdapter().getItemsCount() - 1;
                        c.this.bqo.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.bqu) {
                        c.this.a(i8, i11, 1, c.this.bqw, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.bqo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.bqo.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.bqy != null) {
                    c.this.bqy.RS();
                }
            }
        });
        this.bqo.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gY(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.bqt + i8) - 1;
                    if (c.this.bqt == c.this.bqu) {
                        c.this.a(c.this.bqx, i9, c.this.bqv, c.this.bqw, asList, asList2);
                    } else if (c.this.bqt == i9) {
                        c.this.a(c.this.bqx, i9, c.this.bqv, 31, asList, asList2);
                    } else if (c.this.bqu == i9) {
                        c.this.a(c.this.bqx, i9, 1, c.this.bqw, asList, asList2);
                    } else {
                        c.this.a(c.this.bqx, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.bqx == c.this.startYear) {
                    int i10 = (c.this.bqt + i8) - 1;
                    if (i10 == c.this.bqt) {
                        c.this.a(c.this.bqx, i10, c.this.bqv, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.bqx, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.bqx == c.this.endYear) {
                    if (i8 == c.this.bqu) {
                        c.this.a(c.this.bqx, c.this.bqo.getCurrentItem() + 1, 1, c.this.bqw, asList, asList2);
                    } else {
                        c.this.a(c.this.bqx, c.this.bqo.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.bqx, i8, 1, 31, asList, asList2);
                }
                if (c.this.bqy != null) {
                    c.this.bqy.RS();
                }
            }
        });
        a(this.bqp);
        a(this.bqq);
        a(this.bqr);
        a(this.bqs);
        if (this.bpa.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.bqn.setVisibility(this.bpa[0] ? 0 : 8);
        this.bqo.setVisibility(this.bpa[1] ? 0 : 8);
        this.bqp.setVisibility(this.bpa[2] ? 0 : 8);
        this.bqq.setVisibility(this.bpa[3] ? 0 : 8);
        this.bqr.setVisibility(this.bpa[4] ? 0 : 8);
        this.bqs.setVisibility(this.bpa[5] ? 0 : 8);
        Sc();
    }

    private void a(WheelView wheelView) {
        if (this.bqy != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void gY(int i) {
                    c.this.bqy.RS();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.bqp.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.bqp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.bqp.getAdapter().getItemsCount() - 1) {
            this.bqp.setCurrentItem(this.bqp.getAdapter().getItemsCount() - 1);
        }
    }

    private void Sc() {
        this.bqp.setTextSize(this.textSize);
        this.bqo.setTextSize(this.textSize);
        this.bqn.setTextSize(this.textSize);
        this.bqq.setTextSize(this.textSize);
        this.bqr.setTextSize(this.textSize);
        this.bqs.setTextSize(this.textSize);
    }

    private void Sd() {
        this.bqp.setTextColorOut(this.bpF);
        this.bqo.setTextColorOut(this.bpF);
        this.bqn.setTextColorOut(this.bpF);
        this.bqq.setTextColorOut(this.bpF);
        this.bqr.setTextColorOut(this.bpF);
        this.bqs.setTextColorOut(this.bpF);
    }

    private void Se() {
        this.bqp.setTextColorCenter(this.bpG);
        this.bqo.setTextColorCenter(this.bpG);
        this.bqn.setTextColorCenter(this.bpG);
        this.bqq.setTextColorCenter(this.bpG);
        this.bqr.setTextColorCenter(this.bpG);
        this.bqs.setTextColorCenter(this.bpG);
    }

    private void Sf() {
        this.bqp.setDividerColor(this.bpH);
        this.bqo.setDividerColor(this.bpH);
        this.bqn.setDividerColor(this.bpH);
        this.bqq.setDividerColor(this.bpH);
        this.bqr.setDividerColor(this.bpH);
        this.bqs.setDividerColor(this.bpH);
    }

    private void Sg() {
        this.bqp.setDividerType(this.bpN);
        this.bqo.setDividerType(this.bpN);
        this.bqn.setDividerType(this.bpN);
        this.bqq.setDividerType(this.bpN);
        this.bqr.setDividerType(this.bpN);
        this.bqs.setDividerType(this.bpN);
    }

    private void Sh() {
        this.bqp.setLineSpacingMultiplier(this.bpI);
        this.bqo.setLineSpacingMultiplier(this.bpI);
        this.bqn.setLineSpacingMultiplier(this.bpI);
        this.bqq.setLineSpacingMultiplier(this.bpI);
        this.bqr.setLineSpacingMultiplier(this.bpI);
        this.bqs.setLineSpacingMultiplier(this.bpI);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.bpf) {
            if (str != null) {
                this.bqn.setLabel(str);
            } else {
                this.bqn.setLabel(this.view.getContext().getString(e.j.pickerview_year));
            }
            if (str2 != null) {
                this.bqo.setLabel(str2);
            } else {
                this.bqo.setLabel(this.view.getContext().getString(e.j.pickerview_month));
            }
            if (str3 != null) {
                this.bqp.setLabel(str3);
            } else {
                this.bqp.setLabel(this.view.getContext().getString(e.j.pickerview_day));
            }
            if (str4 != null) {
                this.bqq.setLabel(str4);
            } else {
                this.bqq.setLabel(this.view.getContext().getString(e.j.pickerview_hours));
            }
            if (str5 != null) {
                this.bqr.setLabel(str5);
            } else {
                this.bqr.setLabel(this.view.getContext().getString(e.j.pickerview_minutes));
            }
            if (str6 != null) {
                this.bqs.setLabel(str6);
            } else {
                this.bqs.setLabel(this.view.getContext().getString(e.j.pickerview_seconds));
            }
        }
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bqp.setTextXOffset(i);
        this.bqo.setTextXOffset(i2);
        this.bqn.setTextXOffset(i3);
        this.bqq.setTextXOffset(i4);
        this.bqr.setTextXOffset(i5);
        this.bqs.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.bqn.setCyclic(z);
        this.bqo.setCyclic(z);
        this.bqp.setCyclic(z);
        this.bqq.setCyclic(z);
        this.bqr.setCyclic(z);
        this.bqs.setCyclic(z);
    }

    public String getTime() {
        if (this.bpf) {
            return Si();
        }
        StringBuilder sb = new StringBuilder();
        if (this.bqx == this.startYear) {
            if (this.bqo.getCurrentItem() + this.bqt == this.bqt) {
                sb.append(this.bqn.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bqo.getCurrentItem() + this.bqt).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bqp.getCurrentItem() + this.bqv).append(" ").append(this.bqq.getCurrentItem()).append(":").append(this.bqr.getCurrentItem()).append(":").append(this.bqs.getCurrentItem());
            } else {
                sb.append(this.bqn.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bqo.getCurrentItem() + this.bqt).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bqp.getCurrentItem() + 1).append(" ").append(this.bqq.getCurrentItem()).append(":").append(this.bqr.getCurrentItem()).append(":").append(this.bqs.getCurrentItem());
            }
        } else {
            sb.append(this.bqn.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bqo.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bqp.getCurrentItem() + 1).append(" ").append(this.bqq.getCurrentItem()).append(":").append(this.bqr.getCurrentItem()).append(":").append(this.bqs.getCurrentItem());
        }
        return sb.toString();
    }

    private String Si() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.bqn.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.gS(currentItem2) == 0) {
            currentItem = this.bqo.getCurrentItem() + 1;
            z = false;
        } else if ((this.bqo.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.gS(currentItem2) <= 0) {
            currentItem = this.bqo.getCurrentItem() + 1;
            z = false;
        } else if ((this.bqo.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.gS(currentItem2) == 1) {
            currentItem = this.bqo.getCurrentItem();
            z = true;
        } else {
            currentItem = this.bqo.getCurrentItem();
            z = false;
        }
        int[] b = com.baidu.tbadk.widget.timepicker.a.e.b.b(currentItem2, currentItem, this.bqp.getCurrentItem() + 1, z);
        sb.append(b[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[2]).append(" ").append(this.bqq.getCurrentItem()).append(":").append(this.bqr.getCurrentItem()).append(":").append(this.bqs.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void gX(int i) {
        this.endYear = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.startYear) {
                this.endYear = i;
                this.bqu = i2;
                this.bqw = i3;
            } else if (i == this.startYear) {
                if (i2 > this.bqt) {
                    this.endYear = i;
                    this.bqu = i2;
                    this.bqw = i3;
                } else if (i2 == this.bqt && i3 > this.bqv) {
                    this.endYear = i;
                    this.bqu = i2;
                    this.bqw = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.bqt = i5;
                this.bqv = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.bqu) {
                    this.bqt = i5;
                    this.bqv = i6;
                    this.startYear = i4;
                } else if (i5 == this.bqu && i6 < this.bqw) {
                    this.bqt = i5;
                    this.bqv = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.bqt = calendar.get(2) + 1;
            this.bqu = calendar2.get(2) + 1;
            this.bqv = calendar.get(5);
            this.bqw = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.bpI = f;
        Sh();
    }

    public void setDividerColor(int i) {
        this.bpH = i;
        Sf();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.bpN = dividerType;
        Sg();
    }

    public void setTextColorCenter(int i) {
        this.bpG = i;
        Se();
    }

    public void setTextColorOut(int i) {
        this.bpF = i;
        Sd();
    }

    public void df(boolean z) {
        this.bqp.df(z);
        this.bqo.df(z);
        this.bqn.df(z);
        this.bqq.df(z);
        this.bqr.df(z);
        this.bqs.df(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.bqy = bVar;
    }
}
