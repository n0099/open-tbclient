package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class MultiContentView extends LinearLayout {
    private Context a;
    private View b;
    private LinearLayout c;
    private com.baidu.adp.lib.d.b<f> d;
    private com.baidu.adp.lib.d.b<c> e;
    private com.baidu.adp.lib.d.b<bb> f;
    private com.baidu.adp.lib.b.b g;
    private int h;
    private boolean i;
    private String j;
    private int k;

    public MultiContentView(Context context) {
        super(context);
        this.g = null;
        this.i = true;
        this.k = 2;
        this.a = context;
        a();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = null;
        this.i = true;
        this.k = 2;
        this.a = context;
        a();
    }

    private void a() {
        this.b = View.inflate(this.a, com.baidu.tieba.v.msg_multi_pic_text_content_view, this);
        this.c = (LinearLayout) this.b.findViewById(com.baidu.tieba.u.view_container);
        this.d = i.a().a(this.a);
        this.e = i.a().b(this.a);
        this.f = i.a().c(this.a);
        this.c.setOnHierarchyChangeListener(new b(this));
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.c.addView(view);
    }

    public void a(List<p> list, View view) {
        this.c.removeAllViews();
        if (list != null && list.size() != 0) {
            int size = list.size();
            if (size == 1) {
                a(list.get(0), getSingleView(), view);
                return;
            }
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    a(list.get(i), getTopView(), view);
                } else if (i == size - 1) {
                    a(list.get(i), getBottomView(), view);
                } else {
                    a(list.get(i), getMidView(), view);
                }
            }
        }
    }

    private f getTopView() {
        f fVar = null;
        if (this.d != null) {
            fVar = this.d.a();
        }
        if (fVar == null || fVar.getParent() != null) {
            fVar = new f(this.a);
        }
        fVar.setOnItemViewLongClickListener(this.g);
        fVar.setPosition(this.h);
        if (TbadkApplication.m252getInst().getSkinType() == 1 && this.i) {
            if (this.k == 2) {
                fVar.setBackgroundResource(com.baidu.tieba.t.selector_history_multi_top_bg_1);
            } else if (this.k == 1) {
                fVar.setBackgroundResource(com.baidu.tieba.t.selector_msg_multi_top_bg_1);
            }
            fVar.a(true);
        } else {
            if (this.k == 2) {
                fVar.setBackgroundResource(com.baidu.tieba.t.selector_history_multi_top_bg);
            } else if (this.k == 1) {
                fVar.setBackgroundResource(com.baidu.tieba.t.selector_msg_multi_top_bg);
            }
            fVar.a(false);
        }
        return fVar;
    }

    private void a(p pVar, f fVar, View view) {
        if (pVar != null && fVar != null) {
            fVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            fVar.setTime(this.j);
            fVar.a(pVar, view);
            this.c.addView(fVar);
        }
    }

    private c getCommonBottomView() {
        c cVar = null;
        if (this.e != null) {
            cVar = this.e.a();
        }
        if (cVar == null || cVar.getParent() != null) {
            cVar = new c(this.a);
        }
        cVar.setOnItemViewLongClickListener(this.g);
        cVar.setPosition(this.h);
        return cVar;
    }

    private c getMidView() {
        c commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1 && this.i) {
            if (this.k == 2) {
                commonBottomView.setBackgroundResource(com.baidu.tieba.t.selector_history_multi_mid_bg_1);
            } else if (this.k == 1) {
                commonBottomView.setBackgroundResource(com.baidu.tieba.t.selector_msg_multi_mid_bg_1);
            }
            commonBottomView.a(true);
            return commonBottomView;
        }
        if (this.k == 2) {
            commonBottomView.setBackgroundResource(com.baidu.tieba.t.selector_history_multi_mid_bg);
        } else if (this.k == 1) {
            commonBottomView.setBackgroundResource(com.baidu.tieba.t.selector_msg_multi_mid_bg);
        }
        commonBottomView.a(false);
        return commonBottomView;
    }

    private c getBottomView() {
        c commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1 && this.i) {
            if (this.k == 2) {
                commonBottomView.setBackgroundResource(com.baidu.tieba.t.selector_history_multi_bottom_bg_1);
            } else if (this.k == 1) {
                commonBottomView.setBackgroundResource(com.baidu.tieba.t.selector_msg_multi_bottom_bg_1);
            }
            commonBottomView.a(true);
            return commonBottomView;
        }
        if (this.k == 2) {
            commonBottomView.setBackgroundResource(com.baidu.tieba.t.selector_history_multi_bottom_bg);
        } else if (this.k == 1) {
            commonBottomView.setBackgroundResource(com.baidu.tieba.t.selector_msg_multi_bottom_bg);
        }
        commonBottomView.a(false);
        return commonBottomView;
    }

    private void a(p pVar, c cVar, View view) {
        if (pVar != null && cVar != null) {
            cVar.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.a.getResources().getDimension(com.baidu.tieba.s.multi_bottom_height)));
            cVar.a(pVar, view);
            this.c.addView(cVar);
        }
    }

    private bb getSingleView() {
        bb bbVar = null;
        if (this.f != null) {
            bbVar = this.f.a();
        }
        if (bbVar == null || bbVar.getParent() == null) {
            bbVar = new bb(this.a);
        }
        bbVar.setOnItemViewLongClickListener(this.g);
        bbVar.setPosition(this.h);
        if (TbadkApplication.m252getInst().getSkinType() == 1 && this.i) {
            if (this.k == 2) {
                bbVar.setBackgroundResource(com.baidu.tieba.t.selector_history_multi_single_bg_1);
            } else if (this.k == 1) {
                bbVar.setBackgroundResource(com.baidu.tieba.t.selector_msg_multi_single_bg_1);
            }
            bbVar.a(true);
        } else {
            if (this.k == 2) {
                bbVar.setBackgroundResource(com.baidu.tieba.t.selector_history_multi_single_bg);
            } else if (this.k == 1) {
                bbVar.setBackgroundResource(com.baidu.tieba.t.selector_msg_multi_single_bg);
            }
            bbVar.a(false);
        }
        return bbVar;
    }

    private void a(p pVar, bb bbVar, View view) {
        if (pVar != null && bbVar != null) {
            bbVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            bbVar.setTime(this.j);
            bbVar.a(pVar, view);
            this.c.addView(bbVar);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.g = bVar;
    }

    public void setPosition(int i) {
        this.h = i;
    }

    public void setNeedNightMode(boolean z) {
        this.i = z;
    }

    public void setTime(String str) {
        this.j = str;
    }

    public void setType(int i) {
        this.k = i;
    }
}
